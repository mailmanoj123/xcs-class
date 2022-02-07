package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class GroupSearchCancelFlowHandler extends FlowHandler {

  public GroupSearchCancelFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {

  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    NextScreenModel nextScreen = mm.getNextScreenModel();

    if (nextScreen.getNextScreen().equals("SCR005"))
      return "2";
    else // should never happen...
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

}