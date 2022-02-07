package com.xchanging.xcc.events;

public class LZ07Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;

  private String riskCode;
  private String yearOfAcc;
  private String lidsCount;
  private String[] filCode1;
  private String[] filCode2;
  private String[] dtiCode;
  private String[] tfCode;
  private String[] otherTf;
  private String[] origCcy;
  private String[] countryCode;

  public LZ07Event(String riskCode, String yearOfAcc, String lidsCount,
                   String[] filCode1, String[] filCode2, String[] dtiCode,
                   String[] tfCode, String[] otherTf, String[] origCcy,
                   String[] countryCode)
  {
    this.riskCode = riskCode;
    this.yearOfAcc = yearOfAcc;
    this.lidsCount = lidsCount;
    this.filCode1 = filCode1;
    this.filCode2 = filCode2;
    this.dtiCode = dtiCode;
    this.tfCode = tfCode;
    this.otherTf = otherTf;
    this.origCcy = origCcy;
    this.countryCode = countryCode;
  }

  public String getName() {
    return "java:comp/env/event/LZ07Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ07CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }
  public String[] getCountryCode() {
    return countryCode;
  }
  public String[] getDtiCode() {
    return dtiCode;
  }
  public String[] getFilCode1() {
    return filCode1;
  }
  public String[] getFilCode2() {
    return filCode2;
  }
  public String getLidsCount() {
    return lidsCount;
  }
  public String[] getOrigCcy() {
    return origCcy;
  }
  public String[] getOtherTf() {
    return otherTf;
  }
  public String getRiskCode() {
    return riskCode;
  }
  public String[] getTfCode() {
    return tfCode;
  }
  public String getYearOfAcc() {
    return yearOfAcc;
  }
}


