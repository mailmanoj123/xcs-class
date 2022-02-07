package com.xchanging.xcc.web.models;

public class SearchResult extends WebModel {

  private String cor;
  private String name1;
  private String name2;
  private String dateOfLoss;
  private String catCode;
  private String user;
  private String dateProcessed;
  private String ucr;
  private String claimant;
  private String brokerReference;

  public SearchResult( String cor,
                       String name1,
                       String name2,
                       String dateOfLoss,
                       String catCode,
                       String user,
                       String dateProcessed,
                       String claimant,
                       String brokerReference,
                       String ucr)
  {
    this.cor = cor;
    this.name1 = name1;
    this.name2 = name2;
    this.dateOfLoss = dateOfLoss;
    this.catCode = catCode;
    this.user = user;
    this.dateProcessed = dateProcessed;
    this.claimant = claimant;
    this.brokerReference = brokerReference;
    this.ucr = ucr;
  }

  public String getCor() {
    if (cor == null) {
      cor = "";
    }
    return cor;
  }

  public String getUcr() {
    if (ucr == null) {
      ucr = "";
    }
    return ucr;
  }

  public String getName1() {
    if (name1 == null) {
      name1 = "";
    }
    return name1;
  }

  public String getName2() {
    if (name2 == null) {
      name2 = "";
    }
    return name2;
  }

  public String getDateOfLoss() {
    if (dateOfLoss == null) {
      dateOfLoss = "";
    }
    return dateOfLoss;
  }

  public String getCatCode() {
    if (catCode == null) {
      catCode = "";
    }
    return catCode;
  }

  public String getUser() {
    if (user == null) {
      user = "";
    }
    return user;
  }

  public String getDateProcessed() {
    if (dateProcessed == null) {
      dateProcessed = "";
    }
    return dateProcessed;
  }


public String getClaimant()
{
    if (claimant == null) {
        claimant = "";
      }
    return claimant;
}


public String getBrokerReference()
{
    if (brokerReference == null) {
        brokerReference = "";
      }
    return brokerReference;
}
}