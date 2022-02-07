package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class NextScreenModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;
  private String nextScreen;

  public NextScreenModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.NextScreenModelKey, this);
  }

  public void performUpdate() {

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    String nextScreen = (String)results.get(Keys.LY11NextProgField);
    Logger.info("LY11 setting next screen to: " + nextScreen);

    this.nextScreen = nextScreen;
  }

  public String getNextScreen() {
    return nextScreen;
  }
}