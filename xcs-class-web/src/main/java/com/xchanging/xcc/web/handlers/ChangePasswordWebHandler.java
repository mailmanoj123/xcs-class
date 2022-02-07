package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.ChangePasswordEvent;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class ChangePasswordWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    String password = request.getParameter("passwordConfirm");

    Vector v = new Vector(1);
    v.add(new ChangePasswordEvent(password));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}