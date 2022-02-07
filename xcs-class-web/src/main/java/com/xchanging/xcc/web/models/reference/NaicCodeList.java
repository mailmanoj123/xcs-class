package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class NaicCodeList extends ReferenceList {

  private Vector companyCodes;
  private Vector groupCodes;
  private Vector poolCodes;

  public NaicCodeList() {
    companyCodes = new Vector();
    groupCodes = new Vector();
    poolCodes = new Vector();
  }

  public void setDefaultValue(String code) {
  }

  public void createCompanyCode(String naicCode, String feinCode, String company, String state) {
    companyCodes.add(new CompanyNaicCode(naicCode, feinCode, company, state));
  }

  public void createGroupCode(String code, String name) {
    groupCodes.add(new NaicCode(code, name));
  }

  public void createPoolCode(String code, String name) {
      poolCodes.add(new NaicCode(code, name));
  }

  private Vector getVector(String qual) {
    if (qual.equals("P"))
      return poolCodes;
    else if (qual.equals("G"))
      return groupCodes;
    else if ((qual.equals("F")) || (qual.equals("C")))
      return companyCodes;
    else
      return new Vector(0);
  }

  public Enumeration getNaicCodes(String qual) {
    return getVector(qual.toUpperCase()).elements();
  }

  public int getSize(String qual) {
    return getVector(qual.toUpperCase()).size();
  }

  public void sort() {
    poolCodes = doSort(poolCodes);
    companyCodes = doSort(companyCodes);
    groupCodes = doSort(groupCodes);
  }

  public boolean validate(String code, String qual) {
    qual = qual.toUpperCase();
    Vector codes = getVector(qual);

    if ((codes!=null) && (codes.size()>0)) {
      if (qual.equals("F")) {
        for (int i=0; i<codes.size(); i++) {
          CompanyNaicCode c = (CompanyNaicCode)codes.get(i);
          if (c.getFeinCode().equals(code))
            return true;
        }
      } else if (qual.equals("C")) {
        for (int i=0; i<codes.size(); i++) {
          CompanyNaicCode c = (CompanyNaicCode)codes.get(i);
          if (c.getNaicCode().equals(code))
            return true;
        }
      } else if (qual.equals("G") || qual.equals("P")) {
        for (int i=0; i<codes.size(); i++) {
          NaicCode c = (NaicCode)codes.get(i);
          if (c.getCode().equals(code))
            return true;
        }
      }
    }
    return false;
  }

  public class CompanyNaicCode extends WebModel implements Comparable {

    private String naicCode;
    private String feinCode;
    private String company;
    private String state;

    public CompanyNaicCode(String naicCode, String feinCode, String company, String state) {
      this.naicCode = naicCode;
      this.company = company;
      this.state = state;
      this.feinCode = feinCode;
    }

    public String getNaicCode() {
      return naicCode;
    }
    public String getFeinCode() {
      return feinCode;
    }
    public String getCompany() {
      return company;
    }
    public String getState() {
      return state;
    }

    public int compareTo(Object o) {
      return company.compareTo(((CompanyNaicCode)o).getCompany());
    }
  }

  public class NaicCode extends WebModel implements Comparable {

    private String code;
    private String name;

    public NaicCode(String code, String name) {
      this.code = code;
      this.name = name;
    }

    public String getCode() {
      return code;
    }
    public String getName() {
      return name;
    }

    public int compareTo(Object o) {
      return name.compareTo(((NaicCode)o).getName());
    }
  }
}