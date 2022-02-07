package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class ClmRefRecList extends DropdownList {

  public ClmRefRecList() {
    values = new Vector();
  }

  public void createClmRefRec(String desc) {
    values.add(new DropdownValue(desc));
  }
}