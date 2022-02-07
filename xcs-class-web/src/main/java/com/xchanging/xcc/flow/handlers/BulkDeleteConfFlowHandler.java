package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.events.LY31Event;
import com.xchanging.xcc.events.LY34Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.events.LY59Event;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.events.LY64Event;
import com.xchanging.xcc.events.LY67Event;
import com.xchanging.xcc.events.LY98Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkDeleteConfFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getPolicyRiskDetailsModel();
    mm.getMarketDetailsModel();
    mm.getClaimDetailsModel();
    mm.getFinancialDetailsModel();
    mm.getSCMAdviceModel();
    mm.getVATRatesModel();
    mm.getExpertFeeBreakDownModel();
    mm.getSubsequentAdviceScheduleModel();
    mm.getSummaryNonSettlementModel();
    mm.getSummarySettlementModel();
    mm.getBulkComponentSelectionModel();
    mm.getConcOfBulkSettlementModel();
    mm.getSingleClaimLossReservesModel();

  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    Vector v = new Vector();

    String nextScreen = request.getParameter("screenId");

    if (nextScreen.equals("SCR009")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LZ02Event());
      v.add(new LY13Event());
      fireEvents(v);
      return "1";
    } else if (nextScreen.equals("SCR012")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY28Event());
      fireEvents(v);
      return "2";
    } else if (nextScreen.equals("SCR013")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY31Event());
      fireEvents(v);
      return "3";
    } else if (nextScreen.equals("SCR014")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY34Event());
      fireEvents(v);
      return "4";
    } else if (nextScreen.equals("SCR015")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY37Event());
      fireEvents(v);
      return "5";
    } else if (nextScreen.equals("SCR020")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY56Event("","",""));
      fireEvents(v);
      return "6";
    } else if (nextScreen.equals("SCR017")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY43Event());
      fireEvents(v);
      // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
      // Hence we do a check here to ensure which screen we are directing the user towards.
      // Devo September 2003   CCN s229

      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        return "13";
      else
        return "7";

    } else if (nextScreen.equals("SCR022")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY62Event());
      fireEvents(v);
      return "8";
    } else if (nextScreen.equals("SCR021")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY59Event());
      fireEvents(v);
      return "9";
    } else if (nextScreen.equals("SCR023")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY98Event());
      v.add(new LY64Event("","","",""));
      fireEvents(v);
      return "10";
    } else if (nextScreen.equals("SCR024")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY67Event());
      fireEvents(v);
      return "11";
    } else if (nextScreen.equals("SCR016")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY40Event());
      fireEvents(v);
      return "12";
    }
    else
      return nextScreen;
  }

  public void doEnd(HttpServletRequest request) {

  }
}
