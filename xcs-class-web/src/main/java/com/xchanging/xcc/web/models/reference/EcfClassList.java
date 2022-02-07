package com.xchanging.xcc.web.models.reference;


import java.util.Vector;

import com.xchanging.xcc.web.models.reference.DropdownList.DropdownValue;

public class EcfClassList extends DropdownList {

  public EcfClassList() {
    values = new Vector();
  }
  
  public void createEcfClass(String code, String description) {
      values.add(new DropdownValue(code, code+ " - " + description));
    }
}