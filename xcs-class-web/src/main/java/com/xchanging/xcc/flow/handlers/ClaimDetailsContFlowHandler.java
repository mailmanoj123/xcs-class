package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.FinancialDetailsModel;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ClaimDetailsContFlowHandler extends FlowHandler {

  public ClaimDetailsContFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
        session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    NextScreenModel nextScreen = mm.getNextScreenModel();
    FinancialDetailsModel fdm =  mm.getFinancialDetailsModel();

    if (nextScreen.getNextScreen().equals("SCR015")) {
      Vector list = new Vector(2);
      list.add(new LY12Event("SCR015"));
      list.add(new LY37Event());
      fireEvents(list);

      return "2";
    } else //should never happen
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}