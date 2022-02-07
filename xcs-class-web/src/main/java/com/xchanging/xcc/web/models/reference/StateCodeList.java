package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class StateCodeList extends DropdownList {

  public StateCodeList() {
    values = new Vector();
  }

  public void createStateCode(String code) {
    values.add(new DropdownValue(code));
  }
}