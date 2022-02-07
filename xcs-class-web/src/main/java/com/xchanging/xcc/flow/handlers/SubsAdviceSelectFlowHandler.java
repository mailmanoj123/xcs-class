package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SubsAdviceSelectFlowHandler extends FlowHandler {

  public SubsAdviceSelectFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    NextScreenModel nextScreen = mm.getNextScreenModel();

    if (nextScreen.getNextScreen().equals("SCR017")) {
      Vector v = new Vector(2);
      v.add(new LY12Event("SCR017"));
      v.add(new LY43Event());
      fireEvents(v);
      // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
      // Hence we do a check here to ensure which screen we are directing the user towards.
      // Devo September 2003   CCN s229

      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        return "4";
      else
        return "2";

    } else if (nextScreen.getNextScreen().equals("SCR016")) {
        Vector v = new Vector(2);
        v.add(new LY12Event("SCR016"));
        v.add(new LY40Event());
        fireEvents(v);

        return "3";
    } else
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}