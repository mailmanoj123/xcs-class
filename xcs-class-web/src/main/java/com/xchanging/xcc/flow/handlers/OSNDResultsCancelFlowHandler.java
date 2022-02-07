package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class OSNDResultsCancelFlowHandler extends FlowHandler {

  private ModelManager mm;
  private NextScreenModel nsm;

  public OSNDResultsCancelFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    nsm = mm.getNextScreenModel();
  }

  public String processFlow(HttpServletRequest request) {
    String nextScreen = nsm.getNextScreen();
    Vector v = new Vector(1);

    if (nextScreen.equals("SCR005")) {
      /**
       * Display the Find Claim Screen
       */
      return "2";
    }
    else if (nextScreen.equals("SCR004")) {
      /**
       * Display the Create Claim Screen
       */
      return "3";
    }
    else {
      /**
       * This should never happen. However, if LY11 returns a screen value
       * we are not expecting return the user to the OSND Search Results Screen
       */
      return "1";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}