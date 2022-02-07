package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class RiskTypeList extends DropdownList {

  public RiskTypeList() {
    values = new Vector();
  }

  public void createRiskType(String code) {
    values.add(new DropdownValue(code));
  }
}