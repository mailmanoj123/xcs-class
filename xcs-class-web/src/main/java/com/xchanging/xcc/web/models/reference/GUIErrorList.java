package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class GUIErrorList {

  private Vector guiErrors;

  public GUIErrorList() {
    guiErrors = new Vector();
  }

  public void setDefaultValue(String error) {
  }

  public void createGUIError(String code, String text) {
    guiErrors.add(new GUIError(code,text));
  }

  public Enumeration getGUIErrors() {
    return guiErrors.elements();
  }

  public String getErrorText(String errorCode) {
    GUIError error;
    for (int i=0; i<guiErrors.size(); i++) {

      error = (GUIError)guiErrors.get(i);
      if (error.getCode().equals(errorCode))
        return error.getText();
    }
    return "";
  }

  public class GUIError extends WebModel {

    private String code;
    private String text;

    public GUIError(String code, String text) {
      this.code = code;
      this.text = text;
    }

    public String getCode() {
      return code;
    }
    public String getText() {
      return text;
    }
  }
}
