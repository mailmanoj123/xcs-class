package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.events.LY59Event;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCMAdviceEndBDFlowHandler extends FlowHandler {

  public SCMAdviceEndBDFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session=request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    String nextScreen = mm.getNextScreenModel().getNextScreen();
    mm.getSummaryNonSettlementModel();
    mm.getSummarySettlementModel();
    mm.getFinancialDetailsModel();

    Vector list = new Vector();

    if (nextScreen.equals("SCR021")) {
      list.add(new LY12Event("SCR021"));
      list.add(new LY59Event());
      fireEvents(list);

      return "2";
    } else if (nextScreen.equals("SCR022")) {
      list.add(new LY12Event("SCR022"));
      list.add(new LY62Event());
      fireEvents(list);

      return "3";
    } else if (nextScreen.equals("SCR015")) {
      list.add(new LY12Event("SCR015"));
      list.add(new LY37Event());
      fireEvents(list);

      return "4";
    } else if (nextScreen.equals("SCR020")) {
      list.add(new LY12Event("SCR020"));
      list.add(new LY56Event("????","?????","????"));
      fireEvents(list);

      return "5";
    } else //should never happen
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }


}