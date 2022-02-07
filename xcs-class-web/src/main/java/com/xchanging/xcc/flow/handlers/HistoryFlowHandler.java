package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY68Event;
import com.xchanging.xcc.events.LY69Event;
import com.xchanging.xcc.events.LY70Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class HistoryFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ClaimsEvent event = (ClaimsEvent)request.getSession().getAttribute(Keys.WebEventKey);
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();

    Vector list = new Vector(1);

    if (event instanceof LY68Event) {
      if ((((LY68Event)event).getCurrentScreen().equals("SCR0016")) || (((LY68Event)event).getCurrentScreen().equals("SCR017"))) {
        list.add(new LY70Event("","","0","0","0","0","0"));
        fireEvents(list);
        return "2";
      } else {
        list.add(new LY69Event("","","0"));
        fireEvents(list);
        return "1";
      }
    } else if (event instanceof LY69Event) {
      list.add(new LY69Event("","","0"));
      fireEvents(list);
      return "1";
    } else if (event instanceof LY70Event) {
      list.add(new LY70Event("","","0","0","0","0","0"));
      fireEvents(list);
      return "2";
    } else //should never happen
      return "";
  }

  public void doEnd(HttpServletRequest request) {

  }

}