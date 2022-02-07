package com.xchanging.xcc.flow.handlers.helpers;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY27Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class LY27Helper {
  public static LY27Event buildLY27Event(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();
    MarketsModel marketsModel = mm.getMarketsModel();

    int selectedMarket = marketsModel.getSelectedMarket();

    return new LY27Event(
        ctcModel.getOsnd(),
        ctcModel.getApsnd(),
        ctcModel.getCurrencies(),
        marketsModel.getVersionNo()[selectedMarket],
        ctcModel.getSettAdv(),
        ctcModel.getNV_nonScmAdvised(),
        ctcModel.getNV_bulkInd(),
        ctcModel.getNV_riskUnsigned(),
        ctcModel.getNV_treaty(),
		ctcModel.getNV_ecfClaim(),
                ctcModel.getNV_ecfClass(),
        ctcModel.getNV_lossReserve(),
        ctcModel.getNV_loc(),
        ctcModel.getNV_lossFund(),
        ctcModel.getNV_payByCheque(),
        ctcModel.getChargeType(),
        ctcModel.getNV_nonChargeableInd(),
        ctcModel.getNV_prevAdvNonNet(),
        ctcModel.getNV_prevPaidInd(),
        ctcModel.getNV_locDrawingInd(), /* CCN# N0058 - BA - 09/01/2003 */
        ctcModel.getNV_SpecPymtInd(),   /* CCN# ????? - S.Caine - 03/12/2003 */
        ctcModel.getPresDate(),
        ctcModel.getRiskCode(),
        ctcModel.getYearOfAcc(),
        ctcModel.getUmr(),
        ctcModel.getSlipOrder1(),
        ctcModel.getSlipOrder2(),
        ctcModel.getLineSlipCH(),
        ctcModel.getInsured(),
        ctcModel.getReinsured(),
        ctcModel.getVesselAircraft(),
        ctcModel.getInterest(),
        ctcModel.getSiLimit(),
        ctcModel.getExcessLimit(),
        ctcModel.getSiCurr(),
        ctcModel.getPerilsConds(),
        ctcModel.getPolicyPeriodFrom(),
        ctcModel.getPolicyPeriodTo(),
        marketsModel.getNoOfSyndicates()[selectedMarket],
        marketsModel.getBureauShareTotalLine()[selectedMarket],
        marketsModel.getLidsSyndicateNo(selectedMarket),
        marketsModel.getLidsSyndicateLine(selectedMarket),
        marketsModel.getLidsSyndicateRef(selectedMarket),
        ctcModel.getNV_SchemeCanInd(),
        ctcModel.getNV_CPAInd(),
        ctcModel.getNV_DirLStockInd(),
        ctcModel.getNV_SimRI(),
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
        ctcModel.getSlipType()
        );
  }
}