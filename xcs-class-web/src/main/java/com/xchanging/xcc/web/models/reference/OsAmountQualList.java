package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class OsAmountQualList extends DropdownList {

  public OsAmountQualList() {
    values = new Vector();
  }

  public void createOsAmountQual(String desc) {
    values.add(new DropdownValue(desc));
  }
}