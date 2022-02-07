package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;


public class GroupingSessionModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String histSessionNo;

  public GroupingSessionModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.GroupingSessionModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    histSessionNo = (String)results.get(Keys.LY71_HIST_SESSION_NO_FIELD);

    mm.getUserWebModel().setSecondaySessionNo(histSessionNo);
  }
}