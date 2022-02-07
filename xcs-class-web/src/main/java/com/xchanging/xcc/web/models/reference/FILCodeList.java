package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class FILCodeList extends ReferenceList {

  private Vector filCodes;

  public FILCodeList() {
    filCodes = new Vector();
  }

  public void sort() {
    filCodes = doSort(filCodes);
  }

  public void createFILCode(String desc, String tfCode) {
    filCodes.add(new FILCode(desc, tfCode));
  }

  public Enumeration getFILCodes() {
    return filCodes.elements();
  }

  public boolean validate(String code) {
    boolean found = false;
    for (int i=0; i<filCodes.size(); i++) {
      FILCode b = (FILCode)filCodes.get(i);
      if (b.getCode().equals(code)) {
        found = true;
        break;
      }
    }
    return found;
  }

  public boolean validate(String filCode, String tfCode) {
    boolean found = false;
    for (int i=0; i<filCodes.size(); i++) {
      FILCode f = (FILCode)filCodes.get(i);
      if ((f.getCode().equals(filCode)) && (f.getTfCode().equals(tfCode))) {
        found = true;
        break;
      }
    }
    return found;
  }

  public class FILCode extends WebModel implements Comparable {

    private String code;
    private String tfCode;

    public FILCode(String code, String tfCode) {
      this.code = code;
      this.tfCode = tfCode;
    }

    public String getCode() {
      return code;
    }

    public String getTfCode() {
      return tfCode;
    }

    public int compareTo(Object o) {
      return code.compareTo(((FILCode)o).getCode());
    }
  }
}
