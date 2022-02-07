package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class ChargeTypeList extends DropdownList {

  public ChargeTypeList() {
    values = new Vector();
  }

  public void createChargeType(String code, String description) {
    values.add(new DropdownValue(code,code + " - " + description));
  }
}