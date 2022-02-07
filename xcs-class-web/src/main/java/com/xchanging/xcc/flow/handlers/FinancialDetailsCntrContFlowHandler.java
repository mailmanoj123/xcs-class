package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.events.LY64Event;
import com.xchanging.xcc.events.LY98Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FinancialDetailsCntrContFlowHandler extends FlowHandler {

  private ModelManager mm;
  private NextScreenModel nextScreen;

  public FinancialDetailsCntrContFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();

    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    nextScreen = mm.getNextScreenModel();
    mm.getSCMAdviceModel();
    mm.getClaimDetailsModel();
    mm.getMarketsModel();
    mm.getVATRatesModel();
    mm.getExpertFeeBreakDownModel();
    mm.getBulkComponentSelectionModel();
    mm.getSingleClaimLossReservesModel();
  }

  public String processFlow(HttpServletRequest request) {

    Vector list = new Vector();

    if (nextScreen.getNextScreen().equals("SCR015")) {
      list.add(new LY12Event("SCR015"));
      list.add(new LY37Event());
      fireEvents(list);

      return "1";
    } else if (nextScreen.getNextScreen().equals("SCR023")) {
      list.add(new LY12Event("SCR023"));
      list.add(new LY98Event());
      list.add(new LY64Event("","","",""));
      fireEvents(list);

      return "2";
    } else if (nextScreen.getNextScreen().equals("SCR020"))  {
      list.add(new LY12Event("SCR020"));
      list.add(new LY56Event("","",""));
      fireEvents(list);

      return "3";
    } else if (nextScreen.getNextScreen().equals("SCR016")) {
      list.add(new LY12Event("SCR016"));
      list.add(new LY40Event());
      fireEvents(list);

      return "4";
    } else if (nextScreen.getNextScreen().equals("SCR017")) {
      list.add(new LY12Event("SCR017"));
      list.add(new LY43Event());
      fireEvents(list);
      // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
      // Hence we do a check here to ensure which screen we are directing the user towards.
      // Devo September 2003   CCN s229

      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        return "6";
      else
        return "5";

    } else //should never happen
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }
}