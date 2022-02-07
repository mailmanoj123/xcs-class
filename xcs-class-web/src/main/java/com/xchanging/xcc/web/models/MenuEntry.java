package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

public class MenuEntry extends WebModel {

  private Vector menuItems = new Vector();

  public Enumeration getMenuItems() {
    return menuItems.elements();
  }

  public void addMenuItem(MenuItem item) {
    menuItems.add(item);
  }
}