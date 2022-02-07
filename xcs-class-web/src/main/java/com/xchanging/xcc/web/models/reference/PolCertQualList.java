package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class PolCertQualList extends DropdownList {

  public PolCertQualList() {
    values = new Vector();
  }

  public void createPolCertQual(String desc) {
    values.add(new DropdownValue(desc));
  }
}