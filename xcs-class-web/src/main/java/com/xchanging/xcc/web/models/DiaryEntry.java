package com.xchanging.xcc.web.models;

public class DiaryEntry extends WebModel{

  private String bkrRef;
  private String lossDateFrom;
  private String lossDateTo;
  private String name1;
  private String name2;
  private String ucr;

  public DiaryEntry(String bkrRef,
                    String lossDateFrom,
                    String lossDateTo,
                    String name1,
                    String name2,
                    String ucr) {

    this.bkrRef = bkrRef;
    this.lossDateFrom = lossDateFrom;
    this.lossDateTo = lossDateTo;
    this.name1 = name1;
    this.name2 = name2;
    this.ucr = ucr;
  }

  public String getBkrRef() {
    return bkrRef;
  }

  public String getLossDateFrom() {
    return lossDateFrom;
  }

  public String getLossDateTo() {
    return lossDateTo;
  }

  public String getName1() {
    return name1;
  }

  public String getName2() {
    return name2;
  }

  public String getUcr() {
    return ucr;
  }

}