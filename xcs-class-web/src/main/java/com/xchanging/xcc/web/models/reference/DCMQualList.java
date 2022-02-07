package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class DCMQualList extends DropdownList {

  public DCMQualList() {
    values = new Vector();
  }

  public void createDCMQual(String code, String description) {
    values.add(new DropdownValue(code));
  }
}