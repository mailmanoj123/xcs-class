package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsError;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public abstract class WebHandler {

  public abstract void doStart(HttpServletRequest request);
  public abstract Vector processRequest(HttpServletRequest request) throws ClaimsErrorException;
  public abstract void doEnd(HttpServletRequest request);

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

  protected String checkboxValue(String checkbox) {
    if ((checkbox==null) || (checkbox.equals("")) || (checkbox.equals("null")))
      return "N";
    else
      return "Y";
  }

  public String[] getNarrative(String narrative, int lineLength, int maxLines) throws ClaimsErrorException {
    String[] narr = split(narrative,"\r\n",lineLength);

    if (narr.length>maxLines) {
      Vector errors = new Vector(1);
      errors.add(new ClaimsError("G013","NARRATIVE ONLY ALLOWS " + maxLines + " LINES. PLEASE MOVE/REMOVE ALL LINES FROM AND INCLUDING:","\"" + narr[maxLines] + "...\""));
      throw new ClaimsErrorException(errors.elements());
    }

    return narr;
  }

  private String[] split(String s, String delimiter, int lineLength) {
    int indx = 0;
    Vector v = new Vector();
    while (indx <= s.length()) {
      s = s.substring(indx);
      String temp;
      if (s.indexOf(delimiter)<0) {
        temp = s;
      } else {
        temp = s.substring(0,s.indexOf(delimiter));
      }
      if (temp.length()<=lineLength) {
        v.add(temp);
      } else {
        while (temp.length()>lineLength) {
          String line;
          if (temp.charAt(lineLength)==' ') {
            line = temp.substring(0,lineLength);
          } else {
            if (temp.substring(0,lineLength).lastIndexOf(" ")>=0)
              line = temp.substring(0,temp.substring(0,lineLength).lastIndexOf(" "));
            else
              line = temp.substring(0,lineLength);
          }
          v.add(line);
          temp = temp.substring(line.length()).trim();
        }
        if (temp.length()>0)
          v.add(temp);
      }
      if (s.indexOf(delimiter)<0)
        indx = s.length() + 1;
      else
        indx = s.indexOf(delimiter) + delimiter.length();
    }
    return (String[])v.toArray(new String[] {});
  }

  /*public String padOutNarrative(String narr, int lineLength) {
    String result = "";

    if (narr.indexOf("\r\n")>-1) {
      String[] lines = split(narr,"\r\n");
      for (int i=0; i<lines.length; i++) {
        result += lines[i];
        for (int j=0; j<50-lines[i].length(); j++) {
          result += " ";
        }
      }
    } else {
      int ind = 0;
      int i;
      boolean last = ind + 49 > narr.length();

      while (!last) {
        last = ind + 49 > narr.length();
        i=0;
        if (last) {
          result += narr.substring(ind);
        } else {
          while (narr.charAt(ind + 49 - i)!=' ') {
            i++;
          }
          result += narr.substring(ind, ind + 49 - i);
          for (int c=0; c<=i; c++) {
            result += " ";
          }
          ind += 50-i;
        }
      }
    }
    return result;
  }*/
}