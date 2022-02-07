// Remedy 177552: Changes by Brian Ambrose, Steria Limited, 19-02-2004

package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY24Event;
import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY46Event;
import com.xchanging.xcc.events.LY88Event;
import com.xchanging.xcc.flow.handlers.helpers.LY25Helper;
import com.xchanging.xcc.flow.handlers.helpers.LY27Helper;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.NarrativeModel;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class PremCompOkFlowHandler extends FlowHandler {

  private ModelManager mm;

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

  public void doEnd(HttpServletRequest request) {}

  public String processFlow(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    String ucrTrSysRef = request.getParameter("ucrTrSysRef");
    String currNo = request.getParameter("currNo");
    String sdnNo = request.getParameter("sdnNo");
    String statSplitNo = request.getParameter("statSplitNo");
    String breakdownNo = request.getParameter("breakdownNo");
    String returnScreen = request.getParameter("currentScreen");
    String screenId = request.getParameter("screenId");

    Vector v = new Vector(1);
    v.add(LY25Helper.buildLY25Event(request));
    fireEvents(v);

    ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();
    MarketsModel marketsModel = mm.getMarketsModel();

    int marketCount = marketsModel.getMarketsCount();

    String contFlag = (String)request.getSession().getAttribute(Keys.ContinueFlagKey);

    if (marketCount > 1) {
      return "14";
    }
    else {
      if (contFlag.equals("continue")) {
        Vector list = new Vector(1);

        if (mm.getUserWebModel().updateMode())
          list.add(LY27Helper.buildLY27Event(request));

        list.add(new LY11Event("SCR009","","N"));

        fireEvents(list);

        NextScreenModel nsm = mm.getNextScreenModel();

        if (nsm.getNextScreen().equals("SCR012")) {
          mm.getPolicyRiskDetailsModel();
          Vector v1 = new Vector(2);
          v1.add(new LY12Event("SCR012"));
          v1.add(new LY28Event());
          fireEvents(v1);
          return "2";
        }

        if (nsm.getNextScreen().equals("SCR015")){
         /*  if (nsm.getNextScreen().equals("SCR012")) { */
          mm.getFinancialDetailsModel();
          Vector v1 = new Vector(2);
          v1.add(new LY12Event("SCR015"));
          v1.add(new LY37Event());
          fireEvents(v1);
          return "5";
        }
        return "2";
      } else if (contFlag.equals("navbar")) {
        Vector list = new Vector(1);

        if (mm.getUserWebModel().updateMode())
          list.add(LY27Helper.buildLY27Event(request));

        list.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,screenId));

        fireEvents(list);

        list = (Vector)request.getSession().getAttribute("NavBarEvents");
        String ret = (String)request.getSession().getAttribute("NavBarReturn");

        fireEvents(list);

        if (ret.equals("7"))
          if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
            ret = "24";

        return ret;
      } else if (contFlag.equals("exit")) {
        ctcModel = mm.getClaimTransactionCreationModel();

        marketCount = marketsModel.getMarketsCount();

        String currentScreen = request.getParameter("currentScreen");
        request.getSession().setAttribute(Keys.CurrentScreenKey,currentScreen);

        if (marketCount > 1) {
          return "21";
        }
        else {
          Vector list1 = new Vector();
          if (mm.getUserWebModel().updateMode()) {
            list1.add(LY27Helper.buildLY27Event(request));
          }

          list1.add(new LY11Event(currentScreen,"","Y"));

          fireEvents(list1);

          NextScreenModel nextScreen = mm.getNextScreenModel();

          if (nextScreen.getNextScreen().equals("SCR004")) {
            return "17";
          } else if (nextScreen.getNextScreen().equals("SCR005")) {
            return "18";
          } else if (nextScreen.getNextScreen().equals("SCR025")) {
            return "19";
          } else if (nextScreen.getNextScreen().equals("SCR026")) {
            return "20";
          } else //should never happen
            return "";
        }
      } else if (contFlag.equals("notes")) {
        String id = (String)request.getSession().getAttribute("notesId");
        Vector list1 = new Vector();

        if (mm.getUserWebModel().updateMode())
          list1.add(LY27Helper.buildLY27Event(request));

        list1.add(new LY88Event(id,"Y"));
        fireEvents(list1);

        // Remedy 177552 - Narrative lines 300 to 600
        // Check the narrativeModel to see if a subsequent LY88 call is required
        // to retrieve further narrative lines.
        NarrativeModel nm = mm.getNarrativeModel() ;
        if (nm.getMoreLines().equalsIgnoreCase("Y"))
        {
          // Remedy 177552 - Narrative lines 300 to 600
          // There are more narrative lines to retrieve, fire another LY88 event
          // Note that the second parameter must be "N" to indicate that this
          // is not the first call to LY88 for this narrative.
          list1.removeAllElements();
          list1.add(new LY88Event(id,"N"));
          fireEvents(list1) ;
        }

        return "22";
      } else if (contFlag.equals("copyfromucr")) {
        Vector list1 = new Vector();

        if (mm.getUserWebModel().updateMode())
          list1.add(LY27Helper.buildLY27Event(request));

        list1.add(new LY24Event());
        fireEvents(list1);
        return "23";
      }
      return "15";
    }
  }
}
