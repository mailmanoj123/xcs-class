package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class OsLossQualList extends DropdownList {

  public OsLossQualList() {
    values = new Vector();
  }

  public void createOsLossQual(String desc) {
    values.add(new DropdownValue(desc));
  }
}