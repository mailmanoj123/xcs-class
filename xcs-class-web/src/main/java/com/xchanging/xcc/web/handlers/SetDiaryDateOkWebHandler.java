package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY86Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class SetDiaryDateOkWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    String diaryDate = request.getParameter("diaryDateyyyy") +
                       "-" +
                       request.getParameter("diaryDatemm") +
                       "-" +
                       request.getParameter("diaryDatedd");

    Vector v = new Vector();
    v.add(new LY86Event(diaryDate));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}