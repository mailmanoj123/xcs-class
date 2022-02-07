package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class DTICodeList extends DropdownList {

  public DTICodeList() {
    values = new Vector();
  }

  public void createDTICode(String code) {
    values.add(new DropdownValue(code));
  }
}