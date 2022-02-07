package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class HistoryModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  public HistoryModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.HistoryModelKey, this);
  }

  public void performUpdate() {

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    String histSession = (String)results.get(Keys.LY68_HIST_SESSION_NO);

    mm.getUserWebModel().setSecondaySessionNo(histSession);
  }
}