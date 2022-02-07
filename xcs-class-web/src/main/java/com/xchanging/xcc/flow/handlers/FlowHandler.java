package com.xchanging.xcc.flow.handlers;

import java.net.URLDecoder;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.controller.RequestProcessor;

public abstract class FlowHandler {

  protected HttpSession session;

  public abstract void doStart(HttpServletRequest request);
  public abstract String processFlow(HttpServletRequest request);
  public abstract void doEnd(HttpServletRequest request);

  protected String getCentury(String yearStr) {
    String century;
    int year = Integer.parseInt(yearStr);
    if (year > 35) {
      return "19";
    }
    else {
      return "20";
    }
  }

  protected void fireEvents(Vector list){
    RequestProcessor rp = (RequestProcessor)session.getAttribute(Keys.RequestProcessorKey);
    try {
      rp.processEvents(list);
    }
    catch (Exception e) {
      GeneralFailureException gfe = new GeneralFailureException(e.getMessage(),e);
      throw gfe;
    }
  }

  protected String checkboxValue(String checkbox) {
    if ((checkbox==null) || (checkbox.equals("")) || (checkbox.equals("null")))
      return "N";
    else
      return "Y";
  }

  protected String formatDate(String ccyy, String mm, String dd) {

    if (ccyy == null || mm == null || dd == null) {
      return "";
    }

    String fullDate = "";

    switch (ccyy.length()) {
      case 0:
        return "";
      case 2:
        fullDate += getCentury(ccyy) + ccyy;
        break;
      case 4:
        fullDate += ccyy;
        break;
    }

    if (mm.length()>0)
      fullDate += "-" + mm;
    else
      fullDate += "-00";

    if (dd.length()>0)
      fullDate += "-" + dd;
    else
      fullDate += "-00";

    return fullDate;
  }

  public String[] split(String s, String delimiter) {
    s = URLDecoder.decode(s);
    int indx = 0;
    Vector v = new Vector();
    while ((s = s.substring(indx)).indexOf(delimiter)>-1) {
      v.add(s.substring(0,s.indexOf(delimiter)));
      indx = s.indexOf(delimiter) + delimiter.length();
    }
    v.add(s);
    return (String[])v.toArray(new String[] {});
  }

  public String padOutNarrative(String narr, int lineLength) {
    String[] lines = split(narr,"\r\n");
    String result = "";
    for (int i=0; i<lines.length; i++) {
      result += lines[i];
      for (int j=0; j<50-lines[i].length(); j++) {
        result += " ";
      }
    }
    return result;
  }
}