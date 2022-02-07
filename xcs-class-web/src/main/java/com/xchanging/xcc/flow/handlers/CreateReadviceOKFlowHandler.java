package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY59Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CreateReadviceOKFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSummaryNonSettlementModel();
  }

  public String processFlow(HttpServletRequest request) {

    Vector v = new Vector(2);
    v.add(new LY12Event("SCR021"));
    v.add(new LY59Event());
    fireEvents(v);

    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}