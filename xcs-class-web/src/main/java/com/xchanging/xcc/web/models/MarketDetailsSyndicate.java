package com.xchanging.xcc.web.models;

public class MarketDetailsSyndicate extends WebModel {

  private int lineNo;
  private String number = "";
  private String percentage = "";
  private String reference = "";
  private String agreementRole = "";
  private String responseCode = "";
  private String userName = "";
  private String responseDateTime = "";

  // CR ??? D.Smith 09/12/03
  private String syndOptOutStatus = "";
  private String syndOptOutDate = "";

  private String bureauLeaderFlag;
  private String numberFlag;
  private String referenceFlag;
  private String percentageFlag;

  public MarketDetailsSyndicate (
      int lineNo,
      String number,
      String percentage,
      String reference,
      String agreementRole,
      String responseCode,
      String userName,
      String responseDateTime,
      String syndOptOutStatus,
      String syndOptOutDate,
      String numberFlag,
      String percentageFlag,
      String referenceFlag,
      String bureauLeaderFlag) {

    this.lineNo = lineNo;
    this.number = number;
    this.percentage = percentage;
    this.reference = reference;
    this.agreementRole = agreementRole;
    this.responseCode = responseCode;
    this.userName = userName;
    this.responseDateTime = responseDateTime;
    // CR ???  D.Smith - 09/12/03
    this.syndOptOutDate = syndOptOutDate;
    this.syndOptOutStatus = syndOptOutStatus;
    this.numberFlag = enabledStatus(numberFlag);
    this.percentageFlag = enabledStatus(percentageFlag);
    this.referenceFlag = enabledStatus(referenceFlag);
    this.bureauLeaderFlag = enabledStatusCheckbox(bureauLeaderFlag);
  }

  public void update(String syndicateNo, String syndicatePerc, String syndicateRef) {
    this.number = syndicateNo;
    this.percentage = syndicatePerc;
    this.reference = syndicateRef;
  }

  public int getLineNo() {
    return lineNo;
  }

  public String getNumber() {
    return number;
  }

  public String getNumberFlag() {
    return numberFlag;
  }

  public String getPercentage() {
    // 25/02/2003, BA - CCN 320
    return new Double(percentage).toString();
  }

  public String getPercentageFlag() {
    return percentageFlag;
  }

  public String getReference() {
    return htmlSafe(reference);
  }

  public String getReferenceFlag() {
    return referenceFlag;
  }

  public String isBureauLeader() {
   return agreementRole.equals("L")?"CHECKED":"";
  }

  public String getBureauLeaderFlag() {
    return bureauLeaderFlag;
  }

  public boolean isClassForLloydsAuthoriser() {
    return !responseCode.trim().equals("");
  }

  public String getAgreementRole() {
    return agreementRole;
  }

  public String getResponseCode() {
    return responseCode;
  }

  public String getUserName() {
    return userName;
  }

  public String getResponseDateTime() {
    return responseDateTime;
  }

  public String getDeleteButtonFlag() {
    return bureauLeaderFlag;
  }

  // CR ???? D.Smith - 09/12/03
  public String getSyndicateOptOutStatus() {
   return syndOptOutStatus;
  }
  public String getSyndicateOptOutDate() {
   return syndOptOutDate;
  }
}