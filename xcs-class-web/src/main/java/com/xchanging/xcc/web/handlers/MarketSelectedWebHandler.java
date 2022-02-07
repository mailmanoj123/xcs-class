package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY27Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MarketSelectedWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getPolicyRiskDetailsModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager modelManager = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    MarketsModel marketsModel = modelManager.getMarketsModel();
    ClaimTransactionCreationModel ctcm = modelManager.getClaimTransactionCreationModel();

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

    Vector v = new Vector(1);
    boolean lids = marketsModel.getValueCount().equals("1");

    v.add(new LY27Event(
                        ctcm.getOsnd(),
                        ctcm.getApsnd(),
                        ctcm.getCurrencies(),
                        versionNo,
                        ctcm.getSettAdv(),
                        ctcm.getNV_nonScmAdvised(),
                        ctcm.getNV_bulkInd(),
                        ctcm.getNV_riskUnsigned(),
                        ctcm.getNV_treaty(),
						ctcm.getNV_ecfClaim(),
                                                ctcm.getNV_ecfClass(),
                        ctcm.getNV_lossReserve(),
                        ctcm.getNV_loc(),
                        ctcm.getNV_lossFund(),
                        ctcm.getNV_payByCheque(),
                        ctcm.getChargeType(),
                        ctcm.getNV_nonChargeableInd(),
                        ctcm.getNV_prevAdvNonNet(),
                        ctcm.getNV_prevPaidInd(),
                        ctcm.getNV_locDrawingInd(),     /* CCN# N0058 - BA - 09/01/2003 */
                        ctcm.getNV_SpecPymtInd(),       /* CCN# ????? - S.Caine - 03/12/2003 */
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

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}