package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SecurityNotesExitWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    String ucrTrSysRef = "0";
    String currNo = "0";
    String sdnNo = "0";
    String statSplitNo = "0";
    String breakdownNo = "0";
    String returnScreen = mm.getSecurityNotesModel().getPrevScreen();

    Vector v = new Vector();
    v.add(new LY10Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,returnScreen));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}