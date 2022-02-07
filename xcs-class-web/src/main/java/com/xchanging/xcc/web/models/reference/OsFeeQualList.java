package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class OsFeeQualList extends DropdownList {

  public OsFeeQualList() {
    values = new Vector();
  }

  public void createOsFeeQual(String desc) {
    values.add(new DropdownValue(desc));
  }
}