package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY69Event;
import com.xchanging.xcc.events.LY70Event;
import com.xchanging.xcc.events.LogoffEvent;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SummSettDeleteFlowHandler extends FlowHandler {

  public SummSettDeleteFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    String nextScreen = mm.getNextScreenModel().getNextScreen();
    mm.getFindClaimModel();

    if (nextScreen.equals("SCR004")) {

      return "2";
    } else if (nextScreen.equals("SCR005")) {

      return "3";
    } else if (nextScreen.equals("SCR025")) {
      Vector v = new Vector(1);
      v.add(new LY69Event("","",""));
      fireEvents(v);

      return "4";
    } else if (nextScreen.equals("SCR026")) {
      Vector v = new Vector(1);
      v.add(new LY70Event("","","","","","",""));
      fireEvents(v);

      return "5";
    } else if (nextScreen.equals("NONE")) {
      Vector v = new Vector(1);
      v.add(new LogoffEvent(false));
      fireEvents(v);

      return "6";
    }else if (nextScreen.equals("SCR045")) {
       
        return "8";
      } else // should never happen
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}