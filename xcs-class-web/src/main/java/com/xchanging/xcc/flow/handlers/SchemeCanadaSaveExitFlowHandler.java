package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LogoffEvent;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SchemeCanadaSaveExitFlowHandler extends FlowHandler {

  private ModelManager mm;
  private SchemeCanadaWebModel scwm;

  public SchemeCanadaSaveExitFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {

    String previous = request.getParameter("previous");
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    scwm = mm.getSchemeCanadaModel();
    Vector list = new Vector();

    if (previous.equals("save")) {
      return "1";
    } else {
      list.add(new LogoffEvent(false));
      fireEvents(list);
      return "2";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}