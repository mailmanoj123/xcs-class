// Remedy 177552: Changes by Brian Ambrose, Steria Limited, 19-02-2004

package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY24Event;
import com.xchanging.xcc.events.LY27Event;
import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.events.LY88Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.NarrativeModel;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MarketSelectedFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }
  public void doEnd(HttpServletRequest request) {}

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    String cont = (String)request.getSession().getAttribute(Keys.ContinueFlagKey);

    if (cont.equals("continue")) {
      Vector list = new Vector(1);
      list.add(new LY11Event("SCR009","","N"));
      fireEvents(list);

      NextScreenModel nsm = mm.getNextScreenModel();

      if (nsm.getNextScreen().equals("SCR012")) {
        mm.getPolicyRiskDetailsModel();
        Vector v1 = new Vector(2);
        v1.add(new LY12Event("SCR012"));
        v1.add(new LY28Event());
        fireEvents(v1);
        return "11";
      }
      else // shouldn't ever happen
        return "12";
    } else if (cont.equals("navbar")) {
      Vector list = new Vector(1);

      ClaimTransactionCreationModel ctcm = mm.getClaimTransactionCreationModel();
      MarketsModel marketsModel = mm.getMarketsModel();

      marketsModel.setMarketSelected(Integer.decode(request.getParameter("market")).intValue());
      int selectedMarket = marketsModel.getSelectedMarket();

      String versionNo        = marketsModel.getVersionNo()[selectedMarket];
      String noOfSyndicates   = marketsModel.getNoOfSyndicates()[selectedMarket];
      String totalLine        = marketsModel.getBureauShareTotalLine()[selectedMarket];
      String riskCode         = ctcm.getRiskCode();
      String yearOfAcc        = ctcm.getYearOfAcc();
      String umr              = ctcm.getUmr();
      String slipOrder1       = ctcm.getSlipOrder1();
      String slipOrder2       = ctcm.getSlipOrder2();
      String lineSlipCh       = ctcm.getLineSlipCH();
      String insured          = ctcm.getInsured();
      String reinsured        = ctcm.getReinsured();
      String vesselAircraft   = ctcm.getVesselAircraft();
      String interest         = ctcm.getInterest();
      String siLimit          = ctcm.getSiLimit();
      String excessLimit      = ctcm.getExcessLimit();
      String siCurr           = ctcm.getSiCurr();
      String perilsConds      = ctcm.getPerilsConds();
      String policyPeriodFrom = ctcm.getPolicyPeriodFrom();
      String policyPeriodTo   = ctcm.getPolicyPeriodTo();

      list.add(new LY27Event(
                             ctcm.getOsnd(),
                             ctcm.getApsnd(),
                             ctcm.getCurrencies(),
                             versionNo,
                             ctcm.getSettAdv(),
                             ctcm.getNonScmAdvised(),
                             ctcm.getBulkInd(),
                             ctcm.getRiskUnsigned(),
                             ctcm.getTreaty(),
                             ctcm.getEcfClaim(),
                             ctcm.getEcfClass(),
                             ctcm.getLossReserve(),
                             ctcm.getLoc(),
                             ctcm.getLossFund(),
                             ctcm.getPayByCheque(),
                             ctcm.getChargeType(),
                             ctcm.getNonChargeableInd(),
                             ctcm.getPrevAdvNonNet(),
                             ctcm.getPrevPaidInd(),
                             ctcm.getLocDrawingInd(),     /* CCN# N0058 - BA - 09/01/2003 */
                             ctcm.getSpecPymtInd(),       /* CCN# ????? - S.Caine - 03/12/2003 */
                             ctcm.getPresDate(),
                             riskCode,
                             yearOfAcc,
                             umr,
                             slipOrder1,
                             slipOrder2,
                             lineSlipCh,
                             insured,
                             reinsured,
                             vesselAircraft,
                             interest,
                             siLimit,
                             excessLimit,
                             siCurr,
                             perilsConds,
                             policyPeriodFrom,
                             policyPeriodTo,
                             noOfSyndicates,
                             totalLine,
                             marketsModel.getLidsSyndicateNo(selectedMarket),
                             marketsModel.getLidsSyndicateLine(selectedMarket),
                             marketsModel.getLidsSyndicateRef(selectedMarket),
                             ctcm.getNV_SchemeCanInd(),
                             ctcm.getNV_CPAInd(),
                             ctcm.getNV_DirLStockInd(),
                             ctcm.getNV_SimRI(),
                             marketsModel.getLidsOrigBkrCode(),
                             marketsModel.getLidsOrigBkrCurr(),
                             marketsModel.getLidsOrigSettCurr(),
                             marketsModel.getLidsFilCode1(),
                             marketsModel.getLidsFilCode2(),
                             marketsModel.getLidsTfCode(),
                             marketsModel.getLidsStateCode(),
                             marketsModel.getLidsNaicCode(),
                             marketsModel.getLidsNaicQual(),
                             marketsModel.getLidsNonUSTFCode(),
                             marketsModel.getLidsCntryCode(),
                             marketsModel.getLidsWarInd(),
                             marketsModel.getLidsDtiCode(),
                             ctcm.getSlipType()
                             ));

      Vector v = (Vector)request.getSession().getAttribute("NavBarEvents");
      String ret = (String)request.getSession().getAttribute("NavBarReturn");
      fireEvents(v);

      return ret;
    } else if (cont.equals("exit")) {

      Vector list = new Vector(1);
      list.add(new LY11Event((String)request.getSession().getAttribute(Keys.CurrentScreenKey),"","Y"));
      fireEvents(list);

      NextScreenModel nextScreen = mm.getNextScreenModel();

      if (nextScreen.getNextScreen().equals("SCR004")) {
        return "13";
      } else if (nextScreen.getNextScreen().equals("SCR005")) {
        return "14";
      } else if (nextScreen.getNextScreen().equals("SCR025")) {
        return "15";
      } else if (nextScreen.getNextScreen().equals("SCR026")) {
        return "16";
      } else //should never happen
        return "1";

    } else if (cont.equals("notes")) {
      String id = (String)request.getSession().getAttribute("notesId");

      Vector list = new Vector(1);
      list.add(new LY88Event(id,"Y"));
      fireEvents(list);

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
        list.removeAllElements();
        list.add(new LY88Event(id,"N"));
        fireEvents(list) ;
      }

      return "17";
    } else if (cont.equals("copyfromucr")) {
      Vector list = new Vector(1);
      list.add(new LY24Event());
      fireEvents(list);

      return "18";
    }
    return "10";
  }
}
