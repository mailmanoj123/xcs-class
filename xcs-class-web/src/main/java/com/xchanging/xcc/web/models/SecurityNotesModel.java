package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.LY09Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SecurityNotesModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String ucr = "";
  private String xcr = "";
  private String tr = "";
  private String osnd1 = "";
  private String osnd2 = "";
  private String osnd3 = "";
  private String origBkr = "";
  private String note = "";
  private boolean notesFlag;
  private String progStatus = "";
  private String prevScreen = "";

  public SecurityNotesModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SecurityNotesModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    LY09Event event = (LY09Event)session.getAttribute(Keys.WebEventKey);

    prevScreen = event.getCurrentScreen();

    String ucrXcr = (String)results.get(Keys.LY09_UCR);

    if (ucrXcr.charAt(0)=='X') {
      xcr = ucrXcr;
      ucr = "";
    } else {
      ucr = ucrXcr;
      xcr = "";
    }

    tr = (String)results.get(Keys.LY09_TR);
    osnd1 = (String)results.get(Keys.LY09_ORIG_REF_1);
    osnd2 = (String)results.get(Keys.LY09_ORIG_REF_2);
    osnd3 = (String)results.get(Keys.LY09_ORIG_REF_3);
    origBkr = (String)results.get(Keys.LY09_ORIG_BKR_CODE);
    progStatus = (String)results.get(Keys.LY09_PROG_STATUS);

    Vector securityNotes = (Vector)results.get(Keys.LY09_SECURITY_NOTES);
    note = "";

    if (!(securityNotes == null)) {
      for (int i=0; i<securityNotes.size(); i++) {
        MappedRecord securityNote = (MappedRecord)securityNotes.get(i);
        if (i>0)
          note += "\r\n";

        note+=((String)securityNote.get(Keys.LY09_NOTES_LINE)).trim();
      }
    }
  }

  public String getUcr() {
    return ucr;
  }
  public String getXcr() {
    return xcr;
  }
  public String getTr() {
    return tr;
  }
  public String getOsnd1() {
    return osnd1;
  }
  public String getOsnd2() {
    return osnd2;
  }
  public String getOsnd3() {
    return osnd3;
  }
  public String getOrigBkr() {
    return origBkr;
  }
  public String getNote() {
    return note;
  }
  public boolean getNotesFlag() {
    return notesFlag;
  }
  public String getProgStatus() {
    return progStatus;
  }
  public String getPrevScreen() {
    return prevScreen;
  }
}