package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class LossReserveContinueFlowHandler extends FlowHandler {

  public LossReserveContinueFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    NextScreenModel nextScreen = mm.getNextScreenModel();

    Vector list = new Vector(1) ;

    if (nextScreen.getNextScreen().equals("SCR017")) {
      mm.getSCMAdviceModel() ;
      mm.getClaimDetailsModel();
      mm.getVATRatesModel();
      mm.getExpertFeeBreakDownModel();
      mm.getMarketsModel();
      list.add(new LY12Event("SCR017"));
      list.add(new LY43Event());
      fireEvents(list);
      // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
      // Hence we do a check here to ensure which screen we are directing the user towards.
      // Devo September 2003   CCN s229

      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        return "3";
      else
        return "2" ;

    } else {
      //should never happen
      return "1" ;
    }
  }


  public void doEnd(HttpServletRequest request) {
  }

}