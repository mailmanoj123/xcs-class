package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MvmtHistorySelectFlowHandler extends FlowHandler {

  public MvmtHistorySelectFlowHandler() {
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
    } else {
        return "1";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}