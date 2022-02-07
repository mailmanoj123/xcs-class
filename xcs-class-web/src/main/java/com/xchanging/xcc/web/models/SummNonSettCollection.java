package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;

public class SummNonSettCollection {

  private String cor = "";
  private String mvmtRef = "";
  private String osTotal = "";

  public SummNonSettCollection(MappedRecord mp) {
    this.cor = (String) mp.get(Keys.LY59_COR_Field);
    this.mvmtRef = (String) mp.get(Keys.LY59_MOVE_REF_Field);
    this.osTotal = (String) mp.get(Keys.LY59_OUTST_AMT_Field);
  }

  public String getCor() {
    return cor;
  }

  public String getMvmtRef() {
    return mvmtRef;
  }

  public String getOSTotal() {
    return osTotal;
  }

}