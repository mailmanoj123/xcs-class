package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class SectionList extends DropdownList {

  public SectionList () {
    values = new Vector();
  }

  public void createSection(String code) {
    values.add(new DropdownList.DropdownValue(code));
  }
}