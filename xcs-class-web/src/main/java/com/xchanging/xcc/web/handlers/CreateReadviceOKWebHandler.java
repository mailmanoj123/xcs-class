package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ13Event;
import com.xchanging.xcc.events.LZ14Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class CreateReadviceOKWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();

    v.add( new LZ13Event(request.getParameter("currentNarrative1"),
                         request.getParameter("narrativeCode1"),
                         request.getParameter("currentNarrative2A"),
                         request.getParameter("narrativeCode2"),
                         request.getParameter("currentNarrative2B") ) );

    v.add( new LZ14Event(request.getParameter("currentNarrative1"),
                         request.getParameter("narrativeCode1"),
                         request.getParameter("currentNarrative2A"),
                         request.getParameter("narrativeCode2"),
                         request.getParameter("currentNarrative2B") ) );
     return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}