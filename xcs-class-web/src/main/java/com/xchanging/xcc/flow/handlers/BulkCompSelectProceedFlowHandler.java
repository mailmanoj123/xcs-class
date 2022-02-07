package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY67Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.BulkComponentSelectionModel;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkCompSelectProceedFlowHandler extends FlowHandler {

  public BulkCompSelectProceedFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    BulkComponentSelectionModel bulkSelect = mm.getBulkComponentSelectionModel();

    if (bulkSelect.getProgStatus().equals("5")) {
      return "3";
    } else {
      Vector v = new Vector(1);
      v.add(new LY11Event("SCR023","","N"));
      fireEvents(v);

      NextScreenModel nextScreen = mm.getNextScreenModel();

      if (nextScreen.getNextScreen().equals("SCR024")) {
        v = new Vector(2);
        v.add(new LY12Event("SCR024"));
        v.add(new LY67Event());
        fireEvents(v);

        return "2";
      }
    }
    //should never happen
    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}