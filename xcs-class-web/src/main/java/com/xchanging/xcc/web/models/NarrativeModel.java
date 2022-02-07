// Remedy 177552: Changes by Brian Ambrose, Steria Limited, 19-02-2004

package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY88Event;
import com.xchanging.xcc.events.LY89Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class NarrativeModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String textType;
  private Vector explanatoryText;
  private Vector narrativeDetails;
  private boolean narrativeDetailsFlag;
  private String screenMode = "";
  private String lineLength;
  private String maxNoLines;
  private String lineCount;
  private String textId;
  private String firstCall;

  // Remedy 177552 - Narrative lines 300 to 600
  // Add string to store whether more narrative lines should be retrieved
  private String moreLines;

  private boolean saved = false;

  public NarrativeModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.NarrativeModelKey, this);
  }

  public void performUpdate() {

    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    if (event instanceof LY88Event) {
      explanatoryText = new Vector();

      screenMode = (String)results.get(Keys.LY88_SCREEN_MODE);
      mm.getUserWebModel().setUpdateMode(screenMode);

      textId = (String)results.get(Keys.LY88_TEXT_ID_Field);
      textType = (String)results.get(Keys.LY88_TEXT_TYPE);
      firstCall = (String)results.get(Keys.LY88_FIRST_CALL);

      // Remedy 177552 - Narrative lines 300 to 600
      // Retrieve and store the value for more lines.  Y indicates that a
      // second call to retrieve further lines is required.
      moreLines = (String)results.get(Keys.LY88_MORE_LINES) ;

      // Remedy 177552 - Narrative lines 300 to 600
      // Only create a new vector for the narrative lines if this is the first
      // narrative retrieval call.
      if (!firstCall.equalsIgnoreCase("N"))	narrativeDetails = new Vector();

      MappedRecord textTable = (MappedRecord)((Vector)results.get(Keys.LY88_TEXT_TABLE)).get(0);

      Vector textNarratives = (Vector)textTable.get(Keys.LY88_TEXT_NARRATIVE);
      for (int i=0; i<textNarratives.size(); i++) {
        MappedRecord textNarrative = (MappedRecord)textNarratives.get(i);
        explanatoryText.add(textNarrative.get(Keys.LY88_TEXT_NARR));
      }

      lineLength = (String)textTable.get(Keys.LY88_LINE_LENGTH);  //extra value
      maxNoLines = (String)textTable.get(Keys.LY88_MAX_NO_LINES);  //extra value
      lineCount = (String)textTable.get(Keys.LY88_LINE_COUNT);  //extra value
      narrativeDetailsFlag = convertToBoolean((String)textTable.get(Keys.LY88_PROTECT_LINES));

      Vector textLines = (Vector)textTable.get(Keys.LY88_TEXT_LINES);
      for (int i=0; i<Integer.parseInt(lineCount); i++) {
        MappedRecord textLine = (MappedRecord)textLines.get(i);
        narrativeDetails.add(htmlSafe(((String)textLine.get(Keys.LY88_TEXT_LINE)).trim()));
      }
    } else if (event instanceof LY89Event) {
      textId = (String)results.get(Keys.LY89_TEXT_ID_Field);
      saved = true;
    }
  }

  public String getTextType() {
    return textType;
  }
  public Enumeration getExplanatoryText() {
    return explanatoryText.elements();
  }
  public Enumeration getNarrativeDetails() {
    return narrativeDetails.elements();
  }
  public String getNarrativeDetailsFlag() {
    return enabledStatusTextarea(screenMode.equals("E")?"P":"");
  }
  public String getLineCount() {
    return lineCount;
  }
  public String getLineLength() {
    return lineLength;
  }
  public String getMaxNoLines() {
    return maxNoLines;
  }
  public String getScreenMode() {
    return screenMode;
  }
  public String getTextId() {
    return textId;
  }
  public int getMaxLength() {
    try {
      return Integer.parseInt(lineLength) * Integer.parseInt(maxNoLines);
    } catch (Exception e) {
      return 0;
    }
  }
  // Remedy 177552 - Narrative lines 300 to 600
  // Add getters for more lines and first call
  public String getMoreLines() {
    return moreLines;
  }
  public String getFirstCall() {
    return firstCall;
  }

  public boolean isSaved() {
    return saved;
  }
}