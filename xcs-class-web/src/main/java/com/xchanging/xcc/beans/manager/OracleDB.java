package com.xchanging.xcc.beans.manager;

import java.io.FileInputStream;import java.io.IOException;import javax.xml.parsers.DocumentBuilder;import javax.xml.parsers.DocumentBuilderFactory;import javax.xml.parsers.ParserConfigurationException;import org.w3c.dom.Element;import org.xml.sax.InputSource;import org.xml.sax.SAXException;import com.xchanging.xcc.logging.Logger;

public class OracleDB {

  private Element rootElement;
  private boolean valid;
  private final String SERVER_KEY      = "server";
  private final String USER_KEY        = "user";
  private final String PASSWORD_KEY    = "password";
  private final String PORT_KEY        = "port";
  private final String LISTENER_KEY    = "listener";

  public OracleDB(String file) {
    rootElement = getDom(file);
  }

  public String getServer() {
    return rootElement.getAttribute(SERVER_KEY);
  }
  public String getUser() {
    return rootElement.getAttribute(USER_KEY);
  }
  public String getPassword() {
    return rootElement.getAttribute(PASSWORD_KEY);
  }
  public String getPort() {
    return rootElement.getAttribute(PORT_KEY);
  }
  public String getListener() {
    return rootElement.getAttribute(LISTENER_KEY);
  }

  public boolean isValid() {
    return valid;
  }

  private Element getDom(String loc) {
    try {
      FileInputStream stream = new FileInputStream(loc);
      InputSource xmlInp = new InputSource(stream);
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();
      valid = true;
      return (parser.parse(xmlInp).getDocumentElement());
    }
    catch(ParserConfigurationException pce) {
      valid = false;
      Logger.error("Parser Config Error - Advanced Search Unavailable");
    }
    catch(IOException ioe) {
      valid = false;
      Logger.error("I/O Error - Advanced Search Unavailable");
    }
    catch(SAXException se) {
      valid = false;
      Logger.error("SAX Error - Advanced Search Unavailable");
    }
    return null;
  }
}