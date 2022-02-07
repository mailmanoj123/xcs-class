package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class DOLQualList extends DropdownList {

  public DOLQualList() {
    values = new Vector();
  }

  public void createDOLQual(String code, String description) {
    values.add(new DropdownValue(code));
  }
}