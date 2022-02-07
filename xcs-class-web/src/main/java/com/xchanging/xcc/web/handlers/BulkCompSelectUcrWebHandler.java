package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY09Event;
import com.xchanging.xcc.events.LY66Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkCompSelectUcrWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getClaimTransactionCreationModel();
    mm.getNavigationBar();
    mm.getBulkComponentSelectionModel();
    mm.getSecurityNotesModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector(2);
    v.add(new LY66Event(request.getParameter("compSysRef")));
    v.add(new LY09Event("SCR023"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}
