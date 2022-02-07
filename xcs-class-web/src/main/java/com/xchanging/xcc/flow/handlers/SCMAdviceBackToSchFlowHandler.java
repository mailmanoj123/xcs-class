package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCMAdviceBackToSchFlowHandler extends FlowHandler {

  public SCMAdviceBackToSchFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSubsequentAdviceScheduleModel();
    NextScreenModel nextScreen = mm.getNextScreenModel();

    if (nextScreen.getNextScreen().equals("SCR020")) {
      Vector v = new Vector();
      v.add(new LY12Event("SCR020"));
      v.add(new LY56Event("","",""));
      fireEvents(v);

      return "2";
    } else //should never happen
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}