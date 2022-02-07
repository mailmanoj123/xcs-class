package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.LY16Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class TransactionStatusModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String ucr = "";
  private String tr = "";
  private String progStatus = "";
  private String currentScreen = "";

  public TransactionStatusModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.TransactionStatusModelKey, this);
  }

  public void reset() {
    ucr = "";
    tr = "";
    progStatus = "";
    currentScreen = "";
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    ucr = (String) results.get(Keys.LY16_UCR);
    tr  = (String) results.get(Keys.LY16_TR);
    progStatus = (String)results.get(Keys.LY16_PROG_STATUS);
    currentScreen = ((LY16Event)session.getAttribute(Keys.WebEventKey)).getCurrentScreen();
  }

  public String getUcr() {
    return ucr;
  }

  public String getTr() {
    return tr;
  }
  public String getProgStatus() {
    return progStatus;
  }
  public String getCurrentScreen() {
    return currentScreen;
  }
}
