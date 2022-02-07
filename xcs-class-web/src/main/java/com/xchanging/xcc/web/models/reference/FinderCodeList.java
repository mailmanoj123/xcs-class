package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class FinderCodeList extends DropdownList {

  public FinderCodeList() {
    values = new Vector();
  }

  public void createFinderCode(String code) {
    values.add(new DropdownValue(code));
  }
}