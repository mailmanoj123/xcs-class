package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY59Event;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SubsAdviceFinishFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSummaryNonSettlementModel();
    mm.getSummarySettlementModel();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    String nextScreen = mm.getNextScreenModel().getNextScreen();

    Vector v = new Vector(2);

    if (nextScreen.equals("SCR021")) {
      v.add(new LY12Event("SCR021"));
      v.add(new LY59Event());
      fireEvents(v);
      return "2";
    }
    else if (nextScreen.equals("SCR022")) {
      v.add(new LY12Event("SCR022"));
      v.add(new LY62Event());
      fireEvents(v);
      return "3";
    } else //should never happen
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}