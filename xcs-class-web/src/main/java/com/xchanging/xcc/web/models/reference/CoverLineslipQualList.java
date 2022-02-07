package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class CoverLineslipQualList extends DropdownList {

  public CoverLineslipQualList() {
    values = new Vector();
  }

  public void createCoverLineslipQual(String code) {
    values.add(new DropdownValue(code));
  }
}