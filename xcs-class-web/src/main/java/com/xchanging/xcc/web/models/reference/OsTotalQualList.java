package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class OsTotalQualList extends DropdownList{

  public OsTotalQualList() {
    values = new Vector();
  }

  public void createOsTotalQual(String desc) {
    values.add(new DropdownValue(desc));
  }
}