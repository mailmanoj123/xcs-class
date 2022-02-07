package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkCompSelectUcrFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    if (mm.getSecurityNotesModel().getProgStatus().equals("2")) {
      return "2";
    } else {
      Vector v = new Vector(3);
      v.add(new LY12Event("SCR009"));
      v.add(new LZ02Event());
      v.add(new LY13Event());
      fireEvents(v);
      return "1";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}