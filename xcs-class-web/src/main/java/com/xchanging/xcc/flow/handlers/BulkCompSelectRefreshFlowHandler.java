package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY64Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.BulkComponentSelectionModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkCompSelectRefreshFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    BulkComponentSelectionModel bulkSelect = mm.getBulkComponentSelectionModel();

    if (bulkSelect.getProgStatus().equals("5")) {
      return "2";
    } else {
      Vector v = new Vector(1);
      v.add(new LY64Event("","","",""));
      fireEvents(v);

      return "1";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}