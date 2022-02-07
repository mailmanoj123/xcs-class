package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class LawyerCodeList extends ReferenceList {

  private Vector lawyerCodes;

  public LawyerCodeList() {
    lawyerCodes = new Vector();
  }

  public void sort() {
    lawyerCodes = doSort(lawyerCodes);
  }

  public void createLawyerCode(String type, String code, String sname, String name) {
    lawyerCodes.add(new LawyerCode(type, code, sname, name));
  }

  public Enumeration getLawyerCodes() {
    return lawyerCodes.elements();
  }

  public boolean validate(String code) {
    boolean found = false;
    for (int i=0; i<lawyerCodes.size(); i++) {
      LawyerCode b = (LawyerCode)lawyerCodes.get(i);
      if (b.getCode().equals(code)) {
        found = true;
        break;
      }
    }
    return found;
  }

  public class LawyerCode extends WebModel implements Comparable {

    private String type;
    private String code;
    private String sname;
    private String name;

    public LawyerCode(String type, String code, String sname, String name) {
      this.type = type;
      this.code = code;
      this.sname = sname;
      this.name = name;
    }

    public String getType() {
      return type;
    }
    public String getCode() {
      return code;
    }
    public String getSname() {
      return sname;
    }
    public String getName() {
      return name;
    }
    public String getName(int fixedLength) {
      if ((fixedLength<=0) || (fixedLength>name.length()))
        return name;
      else
        return name.substring(0,fixedLength);
    }
    public int compareTo(Object o) {
      return name.compareTo(((LawyerCode)o).getName());
    }
  }
}
