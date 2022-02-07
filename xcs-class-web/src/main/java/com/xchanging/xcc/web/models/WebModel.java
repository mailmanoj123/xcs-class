package com.xchanging.xcc.web.models;

import javax.servlet.http.HttpSession;

public abstract class WebModel {

  HttpSession session;

  public void init(HttpSession session) {
    this.session = session;
  }

  protected boolean convertToBoolean(String str) {
    if (str.equals("P")) {
      return true;
    }
    else {
      return false;
    }
  }

  public String htmlSafe(String in) {
    int ptr;

    while ((ptr = in.indexOf("\""))>-1)
      in = in.substring(0,ptr) + "&quot;" + in.substring(ptr+1,in.length());

    while ((ptr = in.indexOf("'"))>-1)
      in = in.substring(0,ptr) + "&#39;" + in.substring(ptr+1,in.length());

    return in;
  }

  public String removeAmps(String s) {
    while (s.indexOf("&amp;")>0) {
      s = s.substring(0,s.indexOf("&amp;")) + "&" + s.substring(s.indexOf("&amp;")+5);
    }
    return s;
  }

  protected String enabledStatus(String str) {
    if ((str.equals("P")) && (!str.equals("F"))) {
      return " onClick=\"return false\" readonly=\"true\" class=\"fieldProtect\"";
    }
    else {
      return "";
    }
  } 

  protected String enabledStatusCheckbox(String str) {
    if ((str.equals("P")) && (!str.equals("F"))) {
      return " onClick=\"return false\" readonly=\"true\" DISABLED";
    }
    else {
      return "";
    }
  }

  protected String enabledStatusTextarea(String str) {
    if (str.equals("P")) {
      return " onClick=\"return false\" readonly=\"true\" class=\"fieldProtect\"";
    }
    else {
      return "";
    }
  }

  protected String checkBoxStatus(String str) {
    if (str.equals("N")) {
      return "";
    }
    else {
      return "CHECKED";
    }
  }

  protected String removeDecimals(String val) {
    if ((val!=null) && (val.indexOf(".")>-1) && (val.indexOf(".")==val.length()-3))
      return val.substring(0,val.length()-3);
    else
      return val;
  }
}