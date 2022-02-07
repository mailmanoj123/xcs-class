package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class TrustFundList extends ReferenceList {

  private Vector trustFunds;

  public TrustFundList() {
    trustFunds = new Vector();
  }

  public void sort() {
    trustFunds = doSort(trustFunds);
  }

  public void createTrustFund(String code) {
    trustFunds.add(new TrustFund(code));
  }

  public Enumeration getTrustFunds() {
    return trustFunds.elements();
  }

  public boolean validate(String code) {
    boolean found = false;
    for (int i=0; i<trustFunds.size(); i++) {
      TrustFund b = (TrustFund)trustFunds.get(i);
      if (b.getCode().equals(code)) {
        found = true;
        break;
      }
    }
    return found;
  }

  public class TrustFund extends WebModel implements Comparable {

    private String code;

    public TrustFund(String code) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }

    public int compareTo(Object o) {
      return code.compareTo(((TrustFund)o).getCode());
    }
  }
}
