package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class CurrencyCodeList extends DropdownList {

  public CurrencyCodeList() {
    values = new Vector();
  }

  public void createCurrencyCode(String code, String desc) {
    values.add(new DropdownValue(code));
  }
}
