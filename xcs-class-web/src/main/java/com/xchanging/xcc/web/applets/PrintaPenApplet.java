package com.xchanging.xcc.web.applets;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.comm.*;		// Java Communications API  - for access to serial port
import netscape.javascript.*;	// Netscape Javascript API - for applet-to-javascript interaction

/**
 * An applet which can send data to the serial port
 */
public class PrintaPenApplet extends Applet {

  private DataRow[] fieldData;  // Cannot use Vector as it is implemented as an
                                // AbstractList as of jdk1.2, which causes a problem
                                // with jvm1.1.4 (which is used by IE 5.5)

  private boolean apiInstalled;
  private boolean apiInitialised;
  private boolean correctVersion;

  private static Object	lockObj = new Object();  // Used for synchronization of threads
  private Dialog printDialog;
  private DataPanel dataPanel;

  private URL urlLeft, urlMiddle, urlRight;
  private Image leftButtonImage, middleButtonImage, rightButtonImage;
  private int leftImageWidth, leftImageHeight, middleImageWidth, middleImageHeight, rightImageWidth, rightImageHeight;

  private boolean dialogDisplayed;  // Indicates whether dialog is currently displayed
  private boolean duringRelease;    // Indicates whether dialog displayed as part of Release process

  private Color backgroundColour = new Color(209,236,245);      // Default #D1ECF5;
  private String jsFunctionToCall = new String("summRelease");  // Default "summRelease"

  // Constants
  private static final String TITLE = "PrintaPen";
  private static final String FONTNAME = "verdana";
  private static final int FONTSIZE = 12;
  private static final int TIMEOUT = 20000;

  // Used for sending data to pen
  private static String	resetString;
  private static String	handshakeString;
  private static String	wideString;
  private static String	boldString;
  private static String	wideZero1String;
  private static String	wideZero2String;
  private static String	wideZero3String;
  private static String	crString;

  // Static initialiser
  static {
    // Set up strings containing control data
    char[] Oyster_Reset = { 27, 64 };
    resetString = new String(Oyster_Reset);
    char[] Oyster_Sw_HandShake = { 27, 88 };
    handshakeString = new String(Oyster_Sw_HandShake);
    char[] Oyster_Wide = { 27, 16 };
    wideString = new String(Oyster_Wide);
    char[] Oyster_Bold_Print = { 27, 71 };
    boldString = new String(Oyster_Bold_Print);
    char[] Oyster_Wide_Zero1 = { 27 };
    wideZero1String = new String(Oyster_Wide_Zero1);
    wideZero2String = new String("&0");
    char[] Oyster_Wide_Zero3 = { 63, 199, 254, 224, 124, 3, 192, 60, 3, 192, 62, 7, 127, 227, 252, 0, 0, 0, 0, 0, 0 };
    wideZero3String = new String(Oyster_Wide_Zero3);
    char[] CR = { 13 };
    crString = new String(CR);
  }

  public void init() {

    apiInstalled = true;
    apiInitialised = true;
    correctVersion =true;

    // Get the background colour specified by parameter "bgcolor"
    String bgColourParam = getParameter("bgcolor");
    if (bgColourParam != null) {
      createBgColour(bgColourParam);
    }
    setBackground(backgroundColour);
    setLayout( null );

    // Determine version of java
    try {
      String javaVersion = System.getProperties().getProperty("java.version");
      if (javaVersion != null) {
        // Check if correct version of java
        if ( javaVersion.length() > 3 ) {
          int major = new Integer(javaVersion.substring(0,1)).intValue();
          int minor = new Integer(javaVersion.substring(2,3)).intValue();
          if ( major < 1) {
            correctVersion=false;
          } else if (major == 1) {
            if (minor < 3) {
              correctVersion=false;
            }
          }
        } else {
          correctVersion=false;
        }
      }
    } catch(SecurityException se) {
      // Code is not being treated as signed i.e. no plugin
      System.out.println( se.getMessage() );
      correctVersion=false;
    }

    if (!correctVersion) {
      apiInstalled=false;
      apiInitialised=false;
      return;
    }

    // Prevent JIT compiler throwing error if communications API not present
    // Use of Class.forName() means class name not explicitely stated
    try {
      Class c = Class.forName("com.sun.comm.Win32Driver");
      Object o = c.newInstance();
    } catch(Throwable t) {
      System.out.println("Communications API not installed");
      apiInstalled=false;
      apiInitialised=false;
    }

    if (apiInstalled) {

      // Initialise driver, again using class.forName()
      try {
        Class c1 = Class.forName("com.xchanging.xcc.web.applets.CommInitialise");
        Object o1 = c1.newInstance();
      } catch (NullPointerException npe) {
        if ( npe.getMessage().equals("name can't be null") ) {
          System.out.println("API cannot be initialised");
        }
        apiInitialised=false;
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        apiInitialised=false;
      }
    }

    if (apiInitialised) {

      // Read field data from applet parameters
      readParameters();

      // Load 'button' images from the images directory of web application
      Toolkit currentTK = Toolkit.getDefaultToolkit();
      try {
        urlLeft= new URL(getCodeBase().toString() + "images/actionButton_left.gif");
        urlMiddle= new URL(getCodeBase().toString() + "images/actionButton_middle.gif");
        urlRight= new URL(getCodeBase().toString() + "images/actionButton_right.gif");
      } catch(MalformedURLException mfue) {
        System.out.println( mfue.getMessage() );
      }
      MediaTracker mt = new MediaTracker(this);
      leftButtonImage = currentTK.getImage(urlLeft);
      mt.addImage(leftButtonImage,1);
      middleButtonImage = currentTK.getImage(urlMiddle);
      mt.addImage(middleButtonImage,2);
      rightButtonImage = currentTK.getImage(urlRight);
      mt.addImage(rightButtonImage,3);
      try {
        mt.waitForAll();
      } catch (InterruptedException ie) {
        System.out.println(ie.getMessage());
      }

      // Obtain image sizes
      leftImageWidth = leftButtonImage.getWidth(this);
      leftImageHeight = leftButtonImage.getHeight(this);
      middleImageWidth = middleButtonImage.getWidth(this);
      middleImageHeight = middleButtonImage.getHeight(this);
      rightImageWidth = rightButtonImage.getWidth(this);
      rightImageHeight = rightButtonImage.getHeight(this);

      // Add event handler for applet
      addMouseListener(new MouseAdapter() { // anonymous handler class
        public void mouseClicked(MouseEvent e) { showDialog(false); };
      } );// end anonymous handler class

      createDialog();
    }
  }

  private void readParameters() {

    int paramCount = 0;
    String paramValue="";

    // Get the name of javascript function on the page to
    // call when dialog closed as part of Release process
    // specified by jsfunction parameter
    paramValue = getParameter("jsfunction");
    if (paramValue != null) {
      jsFunctionToCall = new String(paramValue);
    }

    // Count number of UCR, XCR and TDN parameters
    paramValue = getParameter("ucr");
    if (paramValue != null) {
      paramCount++;
    }
    paramValue = getParameter("xcr");
    if (paramValue != null) {
      paramCount++;
    }
    for (int outer=1;;outer++) {

      paramValue = getParameter("TDNCURR" + outer + "COLL1");
      if (paramValue == null) {
        break; // out of outer loop
      }

      for (int inner=1;;inner++) {
        paramValue = getParameter("TDNCURR" + outer + "COLL" + inner);
        if (paramValue == null) {
          break; // out of inner loop
        } else {
          paramCount++;
        }
      }
    }

    // Create array and read parameters
    fieldData = new DataRow[paramCount];
    int index = 0;
    // Get the UCR specified as a parameter
    paramValue = getParameter("ucr");
    if (paramValue != null) {
      fieldData[index++] = new DataRow("UCR", "ucr", new String(paramValue));
    }

    // Get the XCR specified as a parameter
    paramValue = getParameter("xcr");
    if (paramValue != null) {
      fieldData[index++] = new DataRow("XCR", "xcr", new String(paramValue));
    }

    // Get the TDNs specified as parameters
    for (int outer=1;;outer++) {

      paramValue = getParameter("TDNCURR" + outer + "COLL1");
      if (paramValue == null) {
        break; // out of outer loop
      }

      for (int inner=1;;inner++) {
        paramValue = getParameter("TDNCURR" + outer + "COLL" + inner);
        if (paramValue == null) {
          break; // out of inner loop
        } else {
          fieldData[index++] = new DataRow("TDN", "TDNCURR" + outer + "COLL" + inner, new String(paramValue));
        }
      }
    }
  }

  public boolean isApiInitialised() {
    return apiInitialised;
  }

  private void createBgColour(String hexColour) {

    if ( (hexColour.length() == 7) && (hexColour.charAt(0) == '#') ) {
      backgroundColour = new Color( Integer.decode( "#" + hexColour.substring(1, 3)).intValue(),
                                    Integer.decode( "#" + hexColour.substring(3, 5)).intValue(),
                                    Integer.decode( "#" + hexColour.substring(5)).intValue()
                                  );
    }
  }

  private void createDialog() {

    // Get latest data from page
    updateData();

    // Create dialog
    printDialog = new Dialog(new Frame(), TITLE, true);
    printDialog.setSize(450,300);
    printDialog.setBackground(this.backgroundColour);

    // Create components
    ScrollPane scrollPane = new ScrollPane();

    Panel southPanel = new Panel();
    southPanel.setLayout(new BorderLayout());
    CloseButtonCanvas cbc = new CloseButtonCanvas("Close");

    Panel centerPanel = new Panel();
    centerPanel.setLayout(new BorderLayout());
    Label lbl = new Label("The following information is now available for printing:");

    dataPanel = new DataPanel();

    southPanel.add(cbc, BorderLayout.EAST);

    centerPanel.add(lbl, BorderLayout.NORTH);
    centerPanel.add(dataPanel, BorderLayout.CENTER);
    scrollPane.add(centerPanel);

    printDialog.add(southPanel, BorderLayout.SOUTH);
    printDialog.add(scrollPane, BorderLayout.CENTER);

    // Add event handler for dialog
    printDialog.addWindowListener( new WindowAdapter() { // anonymous handler class
      public void windowClosing(WindowEvent evt) {
        hideDialog();
      };
    } ); // end anonymous handler class

    // Place in Middle of Screen
    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    printDialog.setLocation(((int)screenDim.width/2)-(printDialog.getSize().width/2),
                            ((int)screenDim.height/2)-(printDialog.getSize().height/2)	);
  }

  private void hideDialog() {
    JSObject win = JSObject.getWindow(this);
    printDialog.setVisible(false);
    dialogDisplayed=false;
    if (duringRelease) {
      // Call javascript function
      win.call(jsFunctionToCall, null);
    }
  }

  public void showDialog(boolean releaseFlag) {

    if (apiInitialised) {
      if (!dialogDisplayed) {
        duringRelease = releaseFlag;
        updateData();
        dialogDisplayed = true;
        printDialog.setModal(true);
        printDialog.toFront();
        printDialog.setVisible(true);
      }
    }
  }

  private void updateData() {

    JSObject win, field;
    Cursor currentCursor;
    String fieldName;

    win = JSObject.getWindow(this);

    for (int i=0; i<fieldData.length; i++) {

      fieldName = new String( (String)fieldData[i].getFieldName() );
      field = (JSObject) win.eval("document.all." + fieldName );

      if ( fieldName.equals("ucr") || fieldName.equals("xcr") ) {
        // UCR/XCR
        try {
          fieldData[i].setFieldValue( (String)field.getMember("innerText") );
        } catch(NullPointerException e) {
          System.out.println("Cannot obtain value for field " + fieldName + " on page");
          fieldData[i].setFieldValue( new String("") );
        }
      } else {
        // TDNs
        if ( field != null ){
          try {
            String tagName = new String((String)field.getMember("tagName"));
            if (tagName.toUpperCase().equals("TABLE")) {
              // TDN in <INPUT> tags
              String sssss, dd, mm, ccyy;

              field = (JSObject) win.eval("document.all." + fieldName + "sssss");
              if ((String)field.getMember("value") == null) {
                sssss = new String("");
              } else {
                sssss = new String( (String)field.getMember("value") );
              }

              field = (JSObject) win.eval("document.all." + fieldName + "dd");
              if ((String)field.getMember("value") == null) {
                dd = new String("");
              } else {
                dd = new String( (String)field.getMember("value") );
              }

              field = (JSObject) win.eval("document.all." + fieldName + "mm");
              if ((String)field.getMember("value") == null) {
                mm = new String("");
              } else {
                mm = new String( (String)field.getMember("value") );
              }

              field = (JSObject) win.eval("document.all." + fieldName + "ccyy");
              if ((String)field.getMember("value") == null) {
                ccyy = new String("");
              } else {
                ccyy = new String( (String)field.getMember("value") );
              }

              if ( (sssss.length()!=5) || (dd.length()!=2) || (mm.length()!=2) || (ccyy.length()!=4) ) {
                fieldData[i].setFieldValue( new String("") );
              } else {
                fieldData[i].setFieldValue( new String(sssss + " * " + dd + "/" + mm + "/" + ccyy) );
              }
            } else {
              // TDN in <SPAN> tag
              fieldData[i].setFieldValue( (String)field.getMember("innerText") );
            }

          } catch(NullPointerException e) {
            System.out.println("Cannot obtain value for field " + fieldName + " on page");
            fieldData[i].setFieldValue( new String("") );
          }
        } else {
            System.out.println("Cannot obtain value for field " + fieldName + " on page");
            fieldData[i].setFieldValue( new String("") );
        }
      }


    }
  }

  public void stop() {
    if ( apiInitialised ) {
      printDialog.dispose();
    }
  }

  public void paint(Graphics g) {
    // Only paint paint button if API initialised
    if (apiInitialised) {

      int numMiddleGraphics = (TITLE.length()/2)+1;

      // Draw the 'button'
      g.drawImage(leftButtonImage,0,0,this);
      for ( int i=0; i < numMiddleGraphics; i++) {
        g.drawImage(middleButtonImage,leftImageWidth + (i*middleImageWidth),0,this);
      }
      g.drawImage(rightButtonImage,leftImageWidth+(numMiddleGraphics*middleImageWidth),0,this);
      g.setColor(Color.white);
      g.setFont( new Font(FONTNAME,Font.PLAIN,FONTSIZE) );
      g.drawString(TITLE,leftImageWidth, ((middleImageHeight-g.getFont().getSize())/2)+g.getFont().getSize());
    }
  }

  class printThread extends Thread {
    String fieldName;

    public printThread(String fieldName) {
      this.fieldName = fieldName;
    }

    public void run() {
      String s = "";
      Cursor currentCursor;

      // PrintaPen does not send anything back to say finished printing so
      // following code is synchronized as a precaution
      synchronized(lockObj) {
        currentCursor = getCursor();
        PrintaPenApplet.this.dataPanel.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        CommPortIdentifier portId;
        SerialPort serialPort;
        OutputStream outputStream;

        for(int i =0; i<fieldData.length; i++) {
          if ( fieldData[i].getFieldName().equals(fieldName) ) {
            s=fieldData[i].getFieldValue();
            fieldData[i].incrementPrintCount();
            dataPanel.repaint();
            break;
          }
        }

        try {
          portId = CommPortIdentifier.getPortIdentifier("COM1");
          serialPort = (SerialPort)portId.open("PrintaPenApplet", TIMEOUT);
          outputStream = serialPort.getOutputStream();
          serialPort.setSerialPortParams(9600,
              SerialPort.DATABITS_8,
              SerialPort.STOPBITS_1,
              SerialPort.PARITY_NONE	);
          serialPort.setFlowControlMode(serialPort.FLOWCONTROL_XONXOFF_OUT);
          outputStream.write(resetString.getBytes());
          outputStream.write(handshakeString.getBytes());
          outputStream.write(wideString.getBytes());
          outputStream.write(boldString.getBytes());
          outputStream.write(wideZero1String.getBytes());
          outputStream.write(wideZero2String.getBytes());
          outputStream.write(wideZero3String.getBytes());
          outputStream.write(s.getBytes());
          outputStream.write(crString.getBytes());
          serialPort.close();
        } catch (NoSuchPortException nspe) {
          System.out.println( nspe.getMessage() );
        } catch (PortInUseException piue) {
          System.out.println( piue.getMessage() );
        } catch (IOException ioe) {
          System.out.println( ioe.getMessage() );
        } catch (UnsupportedCommOperationException ucoe) {
          System.out.println( ucoe.getMessage() );
        } finally {
          PrintaPenApplet.this.dataPanel.setCursor(currentCursor);
        }

      } // end synchronized

    }
  }

  /**
   * Container for button images
   */
  class CloseButtonCanvas extends Canvas {

    private String buttonText;
    private int numMiddleGraphics;

    public CloseButtonCanvas(String buttonText) {
      this.buttonText=buttonText;
      numMiddleGraphics = (this.buttonText.length()/2)+1;
      setSize(leftImageWidth + (numMiddleGraphics*middleImageWidth) + rightImageWidth,middleImageHeight);
      addMouseListener( new CloseButtonListener() );
    }

    public void paint(Graphics g) {
      // Draw the button image
      g.drawImage(leftButtonImage,0,0,this);
      for ( int i=0; i < numMiddleGraphics; i++) {
        g.drawImage(middleButtonImage,leftImageWidth + (i*middleImageWidth),0,this);
      }
      g.drawImage(rightButtonImage,leftImageWidth+(numMiddleGraphics*middleImageWidth),0,this);
      g.setColor(Color.white);
      g.setFont( new Font(FONTNAME,Font.PLAIN,FONTSIZE) );
      g.drawString(buttonText,leftImageWidth, ((middleImageHeight-g.getFont().getSize())/2)+g.getFont().getSize());
    }
  }
  class PrintButtonCanvas extends Canvas {

    private String buttonText;
    private String fieldName;
    private int numMiddleGraphics;

    public PrintButtonCanvas(String buttonText, String fieldName) {
      this.buttonText="Print " + buttonText;
      numMiddleGraphics = (this.buttonText.length()/2)+1;
      this.fieldName=fieldName;
      setSize(leftImageWidth + (numMiddleGraphics*middleImageWidth) + rightImageWidth,middleImageHeight);
      addMouseListener( new PrintButtonListener(fieldName) );
    }

    public void paint(Graphics g) {
      // Draw the button image
      g.drawImage(leftButtonImage,0,0,this);
      for ( int i=0; i < numMiddleGraphics; i++) {
        g.drawImage(middleButtonImage,leftImageWidth + (i*middleImageWidth),0,this);
      }
      g.drawImage(rightButtonImage,leftImageWidth+(numMiddleGraphics*middleImageWidth),0,this);
      g.setColor(Color.white);
      g.setFont( new Font(FONTNAME,Font.PLAIN,FONTSIZE) );
      g.drawString(buttonText,leftImageWidth, ((middleImageHeight-g.getFont().getSize())/2)+g.getFont().getSize());
    }
  }

  class PrintButtonListener extends MouseAdapter {

    String fieldName;

    public PrintButtonListener(String fieldName) {
      this.fieldName=fieldName;
    }

    public void mouseClicked(MouseEvent e) {
      // Separate thread for work otherwise GUI doesn't repaint properly
      new printThread(fieldName).start();
    }
  }
  class CloseButtonListener extends MouseAdapter {

    public void mouseClicked(MouseEvent e) {
      PrintaPenApplet.this.hideDialog();
    }
  }

  class DataRow {

    private String displayName;
    private String fieldName;
    private String fieldValue;
    private int printCount;

    public DataRow (String displayName, String fieldName, String fieldValue) {
      this.displayName = displayName;
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
      printCount = 0;
    }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }
    public String getFieldValue() { return fieldValue; }
    public void setFieldValue(String fieldValue) { this.fieldValue = fieldValue; }
    public int getPrintCount() { return printCount; }
    public void incrementPrintCount() { printCount++; }
  }

  class DataPanel extends Panel {

    private GridBagConstraints gbc;

    private Component[] dispNameArr;
    private Label[] valueLabelArr;
    private PrintButtonCanvas[] printbuttonArr;
    private Label[] printLabelArr;

    public DataPanel() {
      dispNameArr = new Component[fieldData.length];
      valueLabelArr = new Label[fieldData.length];
      printbuttonArr = new PrintButtonCanvas[fieldData.length];
      printLabelArr = new Label[fieldData.length];

      setLayout(new GridBagLayout());
      gbc = new GridBagConstraints();
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx=1;
      gbc.weighty=0;
      gbc.anchor = GridBagConstraints.NORTH;
      gbc.fill = GridBagConstraints.NONE;
      gbc.ipadx = 1;
      gbc.ipady = 1;

      for(int i=0; i<fieldData.length; i++) {
        DataRow dr = fieldData[i];
        if ( dr.getDisplayName().toUpperCase().equals("XCR") || dr.getDisplayName().toUpperCase().equals("UCR") ) {
          TextField txtFldDisp = new TextField(dr.getDisplayName());
          txtFldDisp.setEditable(false);
          txtFldDisp.setBackground(backgroundColour);
          dispNameArr[i] = txtFldDisp;
          addUsingGBL( dispNameArr[i], 0, i );
          TextField txtFldVal = new TextField( dr.getFieldValue() );
          txtFldVal.setEditable(false);
          txtFldVal.setBackground(backgroundColour);
          valueLabelArr[i] = new Label();  // Not added to panel - XCR/UCR cannot be changed
          addUsingGBL( txtFldVal, 1, i );
        } else {
          dispNameArr[i] = new Label( dr.getDisplayName() );
          addUsingGBL( dispNameArr[i] , 0, i );
          valueLabelArr[i] = new Label( dr.getFieldValue() );
          addUsingGBL( valueLabelArr[i], 1, i );
        }
        printbuttonArr[i] = new PrintButtonCanvas( dr.getDisplayName(), dr.getFieldName() );
        addUsingGBL( printbuttonArr[i], 2, i );
        printLabelArr[i] = new Label( "Printed " + dr.getPrintCount() + " time(s)" );
        addUsingGBL( printLabelArr[i], 3, i );
      }
    }

    private void addUsingGBL(Component component, int x, int y) {
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.fill = GridBagConstraints.BOTH;
      this.add(component, gbc);
    }

    public void paint(Graphics g) {
      for(int i=0; i<fieldData.length; i++) {
        if ( fieldData[i].getFieldValue().equals("") ) {
//          dispNameArr[i].setVisible(false);
          valueLabelArr[i].setVisible(false);
          printbuttonArr[i].setVisible(false);
          printLabelArr[i].setVisible(false);
        } else {
//          dispNameArr[i].setVisible(true);
          valueLabelArr[i].setVisible(true);
          printbuttonArr[i].setVisible(true);
          printLabelArr[i].setVisible(true);
        }
        valueLabelArr[i].setText( fieldData[i].getFieldValue() );
        printLabelArr[i].setText( "Printed " + fieldData[i].getPrintCount() + " time(s)" );
      }
    }
  }
}
