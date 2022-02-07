package com.xchanging.xcc.exceptions;

public class ClaimsError {

  private String code;
  private String description1;
  private String description2;

  public ClaimsError(String code, String description1, String description2) {
    this.code = code;
    this.description1 = description1;
    this.description2 = description2;
  }

  public String getCode() {
    return code;
  }

  public String getDescription1() {
    return description1;
  }

  public String getDescription2() {
    return description2;
  }
}