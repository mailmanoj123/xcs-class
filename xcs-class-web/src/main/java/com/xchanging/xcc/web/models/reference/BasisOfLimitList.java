package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class BasisOfLimitList extends DropdownList {

  public BasisOfLimitList() {
    values = new Vector();
  }

  public void createBasisOfLimit(String code, String desc) {
    values.add(new DropdownValue(code, code + " - " + desc));
  }
}