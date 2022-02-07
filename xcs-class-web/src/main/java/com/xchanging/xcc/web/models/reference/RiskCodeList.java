package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class RiskCodeList extends DropdownList {

  public RiskCodeList() {
    values = new Vector();
  }

  public void createRiskCode(String code) {
    values.add(new DropdownValue(code));
  }
}