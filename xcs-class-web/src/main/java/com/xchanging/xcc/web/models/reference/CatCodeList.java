package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class CatCodeList extends DropdownList{

  public CatCodeList() {
    values = new Vector();
  }

  public void createCatCode(String code, String desc) {
    values.add(new DropdownValue(code));
  }
}
