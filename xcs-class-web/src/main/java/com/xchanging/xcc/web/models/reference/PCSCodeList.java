package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class PCSCodeList extends DropdownList {

  public PCSCodeList() {
    values = new Vector();
  }

  public void createPCSCode(String code) {
    values.add(new DropdownValue(code));
  }
}