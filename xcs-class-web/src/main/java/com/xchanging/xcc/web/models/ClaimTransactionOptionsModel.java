package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ClaimTransactionOptionsModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String ucr = "";
  private String xcr = "";
  private String tr = "";

  public ClaimTransactionOptionsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.ClaimTransOptionsModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    /**
     * Code goes here to process the above MappedRecord
     */
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
}