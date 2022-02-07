package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LoginEvent;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class LoginWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {

    /**
     * Add the appropriate beans to the session that
     * need to be notified when this event is complete
     */
    ModelManager modelManager = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    modelManager.getDiaryWebModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    /**
     * Get the data from the request
     */
    String account = request.getParameter("accountCode");
    String user    = request.getParameter("username");
    String pass    = request.getParameter("password");
    String section = request.getParameter("section");

    /**
     * Add the necessary events to the event list
     * for this request
     */

    Vector v = new Vector(1);
    v.add(new LoginEvent(account,user,pass,section));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}