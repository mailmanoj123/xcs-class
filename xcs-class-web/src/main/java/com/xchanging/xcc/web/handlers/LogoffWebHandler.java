package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LogoffEvent;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.UserWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class LogoffWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    UserWebModel user = mm.getUserWebModel();

    Vector v = new Vector();

    boolean closeWindow = request.getParameter("closeWindow")!=null?request.getParameter("closeWindow").equals("true"):false;
    boolean primarySession;

    String id = request.getParameter("id");
    if (id!=null) {
      user.setPrimarySessionNo(id);
    }

    if (request.getParameter("primarySession")!=null)
      primarySession = request.getParameter("primarySession").equals("true");
    else {
      if (id==null)
        Logger.warn("Primary session identifier not passed to logoff web handler. May cause unexpected results.");
      primarySession = true;
    }

    if (primarySession || (user.hasSecondarySession()))
      v.add(new LogoffEvent(primarySession));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}