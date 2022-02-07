package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class AdjSurvCodeList extends ReferenceList {

  private Vector adjSurvCodes;

  public AdjSurvCodeList() {
    adjSurvCodes = new Vector();
  }

  public void sort() {
    adjSurvCodes = doSort(adjSurvCodes);
  }

  public void createAdjSurvCode(String type, String code, String sname, String name) {
    adjSurvCodes.add(new AdjSurvCode(type, code, sname, name));
  }

  public Enumeration getAdjSurvCodes() {
    return adjSurvCodes.elements();
  }

  public boolean validate(String code) {
    boolean found = false;
    for (int i=0; i<adjSurvCodes.size(); i++) {
      AdjSurvCode b = (AdjSurvCode)adjSurvCodes.get(i);
      if (b.getCode().equals(code)) {
        found = true;
        break;
      }
    }
    return found;
  }

  public class AdjSurvCode extends WebModel implements Comparable {

    private String type;
    private String code;
    private String sname;
    private String name;

    public AdjSurvCode(String type, String code, String sname, String name) {
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
      return name.compareTo(((AdjSurvCode)o).getName());
    }
  }
}
