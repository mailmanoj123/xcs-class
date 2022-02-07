package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class SchemeCodeList extends DropdownList {

  public SchemeCodeList() {
    values = new Vector();
  }

  public void createSchemeCode(String desc) {
    values.add(new DropdownValue(desc));
  }
}