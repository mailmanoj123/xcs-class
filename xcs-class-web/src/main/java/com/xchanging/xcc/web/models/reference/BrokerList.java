package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class BrokerList extends ReferenceList {

  private Vector brokers;

  public BrokerList() {
    brokers = new Vector();
  }

  public void setDefaultValue(String code) {
  }

  public void sort() {
    brokers = doSort(brokers);
  }

  public void createBroker(String code, String pseud) {
    brokers.add(new Broker(code, pseud));
  }

  public Enumeration getBrokers() {
    return brokers.elements();
  }

  public boolean validate(String code, String pseud) {
    boolean found = false;
    for (int i=0; i<brokers.size(); i++) {
      Broker b = (Broker)brokers.get(i);
      if ((b.getCode().equals(code)) && (b.getPseud().equals(pseud))) {
        found = true;
        break;
      }
    }
    return found;
  }

  public boolean validate(String code) {
    boolean found = false;
    for (int i=0; i<brokers.size(); i++) {
      Broker b = (Broker)brokers.get(i);
      if (b.getCode().equals(code)) {
        found = true;
        break;
      }
    }
    return found;
  }

  public class Broker extends WebModel implements Comparable {

    private String code;
    private String pseud;

    public Broker(String code, String pseud) {
      this.code = code;
      this.pseud = pseud;
    }

    public String getCode() {
      return code;
    }

    public String getPseud() {
      return pseud;
    }

    public int compareTo(Object o) {
      return code.compareTo(((Broker)o).getCode());
    }
  }
}
