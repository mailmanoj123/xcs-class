package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY34Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MarketDetailsContFlowHandler extends FlowHandler {

  public MarketDetailsContFlowHandler() {

  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    NextScreenModel nextScreen = mm.getNextScreenModel();

    if (nextScreen.getNextScreen().equals("SCR014")) {
      Vector list = new Vector(2);
      list.add(new LY12Event("SCR014"));
      list.add(new LY34Event());
      fireEvents(list);

      return "2";
    }

    // should never happen
    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}