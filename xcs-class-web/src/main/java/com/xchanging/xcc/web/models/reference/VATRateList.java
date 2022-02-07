package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class VATRateList extends DropdownList {

  public VATRateList() {
    values = new Vector();
  }

  public void createVATRate(String rate) {
    values.add(new DropdownValue(rate));
  }
}