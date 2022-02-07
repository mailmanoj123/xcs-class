package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class CountryCodeList extends DropdownList {

  public CountryCodeList() {
    values = new Vector();
  }

  public void createCountryCode(String code, String name) {
    values.add(new DropdownValue(code, name + " (" + code + ")"));
  }
}
