package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class SettAdvList extends DropdownList {

  public SettAdvList() {
    values = new Vector();
  }

  public void createSettAdv(String code, String description) {
    values.add(new DropdownValue(code, description));
  }
}