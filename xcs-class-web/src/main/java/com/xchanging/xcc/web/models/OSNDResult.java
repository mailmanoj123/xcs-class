package com.xchanging.xcc.web.models;

public class OSNDResult {

  private String cor = "";
  private String ucr = "";
  private String name1 = "";
  private String dolFrom = "";
  private String stateCode = "";
  private String bkrClaimRef1 = "";
  private String name2 = "";
  private String dolTo = "";

  private String tr = "";
  private String ucrTrSysRef = "";
  private String currNo = "";
  private String sdnNo = "";
  private String statSplitNo = "";
  private String breakDownNo = "";
  private String outStanQual = "";

  public OSNDResult( String ucr,
                     String tr,
                     String ucrTrSysRef,
                     String currNo,
                     String sdnNo,
                     String statSplitNo,
                     String breakDownNo,
                     String cor,
                     String name1,
                     String name2,
                     String dolFrom,
                     String dolTo,
                     String stateCode,
                     String bkrClaimRef1, String outStanQual) {

    this.ucr = ucr;

    // Not handled in JSP but returned
    // in commarea - map them anyway
    this.tr = tr;
    this.ucrTrSysRef = ucrTrSysRef;
    this.currNo = currNo;
    this.sdnNo = sdnNo;
    this.statSplitNo = statSplitNo;
    this.breakDownNo = breakDownNo;
    //

    this.cor = cor;
    this.name1 = name1;
    this.name2 = name2;
    this.dolFrom = dolFrom;
    this.dolTo = dolTo;
    this.stateCode = stateCode;
    this.bkrClaimRef1 = bkrClaimRef1;
    this.outStanQual = outStanQual;
  }

  // Getters added for the data returned
  // in the commarea but not used in the JSP
  public String getTr() {
    return tr;
  }

  public String getUcrTrSysRef() {
    return ucrTrSysRef;
  }

  public String getCurrNo() {
    return currNo;
  }

  public String getSdnNo() {
    return sdnNo;
  }

  public String getStatSplitNo() {
    return statSplitNo;
  }

  public String getBreakdownNo() {
    return breakDownNo;
  }
  //

  public String getCor() {
    return cor;
  }

  public String getUcr() {
    return ucr;
  }

  public String getName1() {
    return name1;
  }

  public String getName2() {
    return name2;
  }

  public String getDolTo() {
    return dolTo;
  }

  public String getDolFrom() {
    return dolFrom;
  }

  public String getStateCode() {
    return stateCode;
  }

  public String getBkrClaimRef1() {
    return bkrClaimRef1;
  }


public String getOutStanQual()
{
    return outStanQual;
}


}