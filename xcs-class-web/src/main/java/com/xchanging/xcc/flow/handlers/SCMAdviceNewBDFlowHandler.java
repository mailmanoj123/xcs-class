package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCMAdviceNewBDFlowHandler extends FlowHandler {

  public SCMAdviceNewBDFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    String nextScreen = mm.getNextScreenModel().getNextScreen();
    mm.getSummaryNonSettlementModel();
    mm.getSummarySettlementModel();

    Vector list = new Vector();

    if (nextScreen.equals("SCR016")) {
      list.add(new LY12Event("SCR016"));
      list.add(new LY40Event());
      fireEvents(list);
      return "2";
    } else {
      list.add(new LY12Event("SCR017"));
      list.add(new LY43Event());
      fireEvents(list);

      // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
      // Hence we do a check here to ensure which screen we are directing the user towards.
      // Devo September 2003   CCN s229

      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        return "3";
      else
        return "1";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}