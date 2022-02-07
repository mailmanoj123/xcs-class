package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;




public class SCMAdviceCancelFlowHandler extends FlowHandler {

  public SCMAdviceCancelFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
      session=request.getSession();
      ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
      mm.getSCMAdviceModel();
      mm.getExpertFeeBreakDownModel();
  }

  public String processFlow(HttpServletRequest request) {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    Vector v = new Vector(2);

    v.add(new LY12Event("SCR017"));
    v.add(new LY43Event());
    fireEvents(v);

    if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
      return "2";
    else
      return "1";
  }
  public void doEnd(HttpServletRequest request) {

  }



}