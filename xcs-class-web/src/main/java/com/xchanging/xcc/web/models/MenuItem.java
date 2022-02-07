package com.xchanging.xcc.web.models;

public class MenuItem extends WebModel {

  private String text;
  private String currScrInd;
  private String indentInd;
  private String screenId;
  private String ucrTrSysRef;
  private String currNo;
  private String sdnNo;
  private String statSplitNo;
  private String breakdownNo;
  private MenuEntry submenu;
  private String currentScreen;

  public MenuItem(String text, String currScrInd, String indentInd, String screenId, String ucrTrSysRef, String currNo, String sdnNo, String statSplitNo, String breakdownNo, String currentScreen) {
    this.text = text;
    this.currScrInd = currScrInd;
    this.indentInd = indentInd;
    this.screenId = screenId;
    this.ucrTrSysRef = ucrTrSysRef;
    this.currNo = currNo;
    this.sdnNo = sdnNo;
    this.statSplitNo = statSplitNo;
    this.breakdownNo = breakdownNo;
    this.currentScreen = currentScreen;
  }

  public boolean hasChild() {
    return submenu!=null;
  }

  public MenuEntry getChild() {
    return submenu;
  }

  public void setChild(MenuEntry submenu) {
    this.submenu = submenu;
  }

  public String getText() {
    return text;
  }

  public String getCurrScrInd() {
    return currScrInd;
  }

  public String getIndentInd() {
    return indentInd;
  }

  public String getScreenId() {
    return screenId;
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
    return breakdownNo;
  }
  public String getCurrentScreen() {
    return currentScreen;
  }
}