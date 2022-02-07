package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.events.LY31Event;
import com.xchanging.xcc.events.LY34Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY46Event;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.events.LY59Event;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.events.LY64Event;
import com.xchanging.xcc.events.LY67Event;
import com.xchanging.xcc.events.LY98Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.events.LZ07Event;
import com.xchanging.xcc.flow.handlers.helpers.LY25Helper;
import com.xchanging.xcc.flow.handlers.helpers.LY27Helper;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.NavigationBarModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class NavBarFlowHandler extends FlowHandler {

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
    String nextScreen = request.getParameter("screenId");

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    NavigationBarModel navBar = mm.getNavigationBar();

    Vector v = new Vector();

    // Call LY10 with request parameters
    String ucrTrSysRef = request.getParameter("ucrTrSysRef");
    String currNo = request.getParameter("currNo");
    String sdnNo = request.getParameter("sdnNo");
    String statSplitNo = request.getParameter("statSplitNo");
    String breakdownNo = request.getParameter("breakdownNo");
    String returnScreen = request.getParameter("currentScreen");

    v.add(new LY10Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,""));

    String ret;

    if (nextScreen.equals("SCR009")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LZ02Event());
      v.add(new LY13Event());
      ret="1";
    } else if (nextScreen.equals("SCR012")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY28Event());
      ret="2";
    } else if (nextScreen.equals("SCR013")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY31Event());
      ret="3";
    } else if (nextScreen.equals("SCR014")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY34Event());
      ret="4";
    } else if (nextScreen.equals("SCR015")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY37Event());
      ret="5";
    } else if (nextScreen.equals("SCR020")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY56Event("","",""));
      ret="6";
    } else if (nextScreen.equals("SCR017")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY43Event());
      ret="7";
    } else if (nextScreen.equals("SCR022")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY62Event());
      ret="8";
    } else if (nextScreen.equals("SCR021")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY59Event());
      ret="9";
    } else if (nextScreen.equals("SCR023")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY98Event());
      v.add(new LY64Event("","","",""));
      ret="10";
    } else if (nextScreen.equals("SCR024")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY67Event());
      ret="11";
    } else if (nextScreen.equals("SCR016")) {
      v.add(new LY12Event(nextScreen));
      v.add(new LY40Event());
      ret="12";
    }
    else
      ret="13";


    if (returnScreen.equals("SCR009")) {
      request.getSession().setAttribute(Keys.ContinueFlagKey,"navbar");
      request.getSession().setAttribute("NavBarEvents",v);
      request.getSession().setAttribute("NavBarReturn",ret);

      MarketsModel marketsModel = mm.getMarketsModel();
      boolean premComp = marketsModel.getProgStatus().equals("5");
      if (premComp) {
        Vector list = new Vector(1);
        list.add(new LZ07Event(marketsModel.getRiskCode(),
                               marketsModel.getYearOfAcc(),
                               marketsModel.getValueCount(),
                               marketsModel.getFilCode1(),
                               marketsModel.getFilCode2(),
                               marketsModel.getDtiCode(),
                               marketsModel.getTfCode(),
                               marketsModel.getNonUSTFCode(),
                               marketsModel.getOrigBkrCurr(),
                               marketsModel.getCntryCode()));
        fireEvents(list);
        return "14";
      }

      Vector v1 = new Vector(1);
      v1.add(LY25Helper.buildLY25Event(request));
      fireEvents(v1);

      ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();

      int marketCount = marketsModel.getMarketsCount();

      if (marketCount > 1) {
        return "1";
      }
      else {
        Vector list = new Vector();

        if (mm.getUserWebModel().updateMode())
          list.add(LY27Helper.buildLY27Event(request));

        list .add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
        fireEvents(list);
      }
    } else if (returnScreen.equals("SCR023")) {
      if (mm.getBulkComponentSelectionModel().getProgStatus().equals("5")) {
        return "15";
      } else {
        Vector list = new Vector(1);
        list.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
        fireEvents(list);
      }
    }

    fireEvents(v);

    if (nextScreen.equals("SCR017")) {
      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        ret="16";
      else
        ret="7";
    }

    return ret;
  }

  public void doEnd(HttpServletRequest request) {

  }

  private String constructPresDate(HttpServletRequest req) {
    String presDateyyyy = req.getParameter("presDateyyyy");
    String presDatemm = req.getParameter("presDatemm");
    String presDatedd = req.getParameter("presDatedd");

    if ((presDateyyyy!=null) && (!presDateyyyy.equals(""))) {
      return presDateyyyy + "-" + presDatemm + "-" + presDatedd;
    }
    else {
      return "";
    }
  }

  protected String checkboxValue(String checkbox) {
    if ((checkbox==null) || (checkbox.equals("")) || (checkbox.equals("null")))
      return "N";
    else
      return "Y";
  }
}