package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class NaicQualList extends DropdownList {

  public NaicQualList() {
    values = new Vector();
  }

  public void createNaicQual(String desc) {
    values.add(new DropdownValue(desc));
  }
}