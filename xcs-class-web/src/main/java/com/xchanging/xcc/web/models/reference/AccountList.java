package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class AccountList extends DropdownList {

  public AccountList () {
    values = new Vector();
  }

  public void createAccount(String code) {
    values.add(new DropdownList.DropdownValue(code));
  }
}