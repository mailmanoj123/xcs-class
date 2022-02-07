package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class PaidByChequeList extends DropdownList {

  public PaidByChequeList() {
    values = new Vector();
  }

  public void createValue(String code) {
    values.add(new DropdownValue(code));
  }
}