package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class SyndicateList {

  private Vector syndicates;

  public SyndicateList() {
    syndicates = new Vector();
  }

  public void setDefaultValue(String no) {
  }

  public void createNo(String no) {
    syndicates.add(new Syndicate(no));
  }

  public Enumeration getSyndicates() {
    return syndicates.elements();
  }

  public boolean validate(String no) {
    boolean found = false;
    for (int i=0; i<syndicates.size(); i++) {
      Syndicate b = (Syndicate)syndicates.get(i);
      if (b.getNo().equals(no)) {
        found = true;
        break;
      }
    }
    return found;
  }

  public class Syndicate extends WebModel {

    private String no;

    public Syndicate(String no) {
      this.no = no;
    }

    public String getNo() {
      return no;
    }
  }
}
