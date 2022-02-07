package com.xchanging.xcc.web.models;

public class RootMenu extends WebModel {

  private String text;
  private MenuEntry menu;

  public String getText() {
    return text;
  }

  public MenuEntry getMenu() {
    return menu;
  }

  public RootMenu (String text, MenuEntry menu) {
    this.menu = menu;
    this.text = text;
  }
}