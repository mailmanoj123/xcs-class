package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class ExpertTypeList extends DropdownList {

  public ExpertTypeList() {
    values = new Vector();
  }

  public void createExpertType(String code, String description) {
    values.add(new DropdownValue(code,description));
  }
}