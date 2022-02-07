package com.xchanging.xcc.web.handlers;

import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY44Event;
import com.xchanging.xcc.events.LY45Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ExpertFeeBreakDownModel;
import com.xchanging.xcc.web.models.SCMAdviceModel;
import com.xchanging.xcc.web.models.VATRatesModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCMAdviceEndBDWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    SCMAdviceModel scmAdvice = mm.getSCMAdviceModel();
    mm.getMarketsModel();
    VATRatesModel vatModel = mm.getVATRatesModel();
    ExpertFeeBreakDownModel expertFeeBreakDownModel  = mm.getExpertFeeBreakDownModel();

    Vector expertFeeBreakDownDetails = expertFeeBreakDownModel.getExpertFeeBreakDownROWS();
    
    Vector v = new Vector();

    String[] vatAmts = vatModel.getAmts();
    String[] vatRates = vatModel.getRates();

    // Split the first 150 chars into 3 sets of 50. We'll ignore the
    // chars afeter 150- there shouldn't be any anyway.
    String[] sNarrative = getNarrative(request.getParameter("claimNarrative"),50,3);
    int istart = 0;
    int iend = 0;
    int counter = 1;

    String dolTo = formatDate(request.getParameter("dolToyyyy"),request.getParameter("dolTomm"),request.getParameter("dolTodd"));
    String dolFrom = formatDate(request.getParameter("dolFromyyyy"),request.getParameter("dolFrommm"),request.getParameter("dolFromdd"));
    String dcmFrom = formatDate(request.getParameter("dcmDodFromyyyy"),request.getParameter("dcmDodFrommm"),request.getParameter("dcmDodFromdd"));
    String dcmTo = formatDate(request.getParameter("dcmDodToyyyy"),request.getParameter("dcmDodTomm"),request.getParameter("dcmDodTodd"));
    String polPerFrom = formatDate(request.getParameter("polCertPeriodFromyyyy"),request.getParameter("polCertPeriodFrommm"),request.getParameter("polCertPeriodFromdd"));
    String polPerTo = formatDate(request.getParameter("polCertPeriodToyyyy"),request.getParameter("polCertPeriodTomm"),request.getParameter("polCertPeriodTodd"));

    v.add(new LY44Event(scmAdvice.getCurrNoVal(),
                        scmAdvice.getSdnNoVal(),
                        scmAdvice.getBdownNoVal(),
                        request.getParameter("clmRefRec"),
                        request.getParameter("origCcy"),
                        request.getParameter("settCcy"),
                        request.getParameter("settRateOfExc"),
                        request.getParameter("ptdLoss"),
                        request.getParameter("ptdExp"),
                        request.getParameter("ptdFee"),
                        request.getParameter("ptdTotal"),
                        request.getParameter("pttLoss"),
                        request.getParameter("pttExp"),
                        request.getParameter("pttFee"),
                        request.getParameter("pttTotal"),
                        request.getParameter("osLoss"),
                        request.getParameter("osLossqual"),
                        request.getParameter("osExp"),
                        request.getParameter("osFee"),
                        request.getParameter("osFeeQual"),
                        request.getParameter("osTotal"),
                        request.getParameter("osTotalQual"),
                        request.getParameter("ptdInSettCcy"),
                        request.getParameter("settledRateInSettCcy"),
                        request.getParameter("totalLine"),
                        request.getParameter("bureauPpn"),
                        request.getParameter("vatAmount"),
                        vatRates,
                        vatAmts,
                        request.getParameter("warAmount"),
                        request.getParameter("narrativeCode1"),
                        request.getParameter("narrativeCode2"),
                        request.getParameter("narrativeForSet"),
                        request.getParameter("narrativeForSet2"),
                        request.getParameter("narrativeForSet3"),
                        checkboxValue(request.getParameter("subrogation")),
                        request.getParameter("xcsRecovery"),
                        request.getParameter("highestEst"),
                        request.getParameter("incurred"),
                        request.getParameter("osRateOfExch"),
                        request.getParameter("finderCode1"),
                        request.getParameter("finderCode2"),
                        request.getParameter("finderCode3"),
                        checkboxValue(request.getParameter("attachmentsInd")),
//                        request.getParameter("cashCorpt1"),
                        request.getParameter("brokerContact"),
                        request.getParameter("brokerPhoneNo"),
                        request.getParameter("brokerClaimRef"),
                        request.getParameter("brokerClaimRef2"),
                        request.getParameter("countryOfOrigin"),
                        request.getParameter("origInsured"),
                        request.getParameter("insured"),
                        request.getParameter("reinsured"),
                        request.getParameter("ch"),
                        request.getParameter("claimant"),
                        request.getParameter("vesselAircraftConveyance"),
                        request.getParameter("otherName"),
                        polPerFrom,
                        polPerTo,
                        request.getParameter("polCertQualifier"),
                        dolFrom,
                        dolTo,
                        request.getParameter("dolQual"),
                        request.getParameter("dolNarr"),
                        dcmFrom,
                        dcmTo,
                        request.getParameter("dcmDodQual"),
                        request.getParameter("catCode"),
                        request.getParameter("pcsCode"),
                        request.getParameter("ccyOfLimits"),
                        request.getParameter("limits"),
                        request.getParameter("excess"),
                        request.getParameter("perilsCondition"),
                        request.getParameter("lossLocation"),
                        request.getParameter("voyage"),
                        request.getParameter("lossName"),
                        sNarrative,
                        request.getParameter("lawyerName"),
                        request.getParameter("lawyerRef"),
                        request.getParameter("lawyerCode"),
                        request.getParameter("adjusterName"),
                        request.getParameter("adjusterRef"),
                        request.getParameter("adjusterCode"),
                        request.getParameter("schemeCode"),
                        request.getParameter("tfCode"),
                        request.getParameter("stateCode"),
                        request.getParameter("naicCode"),
                        request.getParameter("naicQual"),
                        checkboxValue(request.getParameter("warInd")),
                        request.getParameter("filCode1"),
                        request.getParameter("filCode2"),
                        request.getParameter("otherTfCode"),
                        request.getParameter("dti"),
                        checkboxValue(request.getParameter("usaCanInd")),
                        checkboxValue(request.getParameter("lfEntryInd")), /* CCN#31 */
                        checkboxValue(request.getParameter("lfAdvancedInd")), /* CCN#31 */
                        checkboxValue(request.getParameter("blockInd")), /* CCN#31 */
                        checkboxValue(request.getParameter("directReportInd")), //SIR:150695 ECF Phase 6 Changes
                        checkboxValue(request.getParameter("clmInLitigationInd")), //SIR:150695 ECF Phase 6 Changes
                        request.getParameter("serviceType"),
                        expertFeeBreakDownDetails,
                        expertFeeBreakDownModel.getExpertCount(),
                        request.getParameter("countyCode"),
                        request.getParameter("barcode")       // TP866603 -Changes for barcode field
                        ));

    v.add(new LY45Event(scmAdvice.getHXcr(),
                        scmAdvice.getHUcr(),
                        scmAdvice.getHTr(),
                        scmAdvice.getHOsnd(),
                        scmAdvice.getHOrigBkr(),
                        scmAdvice.getHSigned(),
                        scmAdvice.getHPeerReview(),
                        scmAdvice.getHOrigCcy(),
                        scmAdvice.getHCor(),
                        scmAdvice.getHLoc(),
                        scmAdvice.getHPayeeBkr(),
                        scmAdvice.getHRedenomInd(),
                        scmAdvice.getHMvmtRefDate(),
                        request.getParameter("clmRefRec"),
                        request.getParameter("origCcy"),
                        request.getParameter("settCcy"),
                        request.getParameter("settRateOfExc"),
                        request.getParameter("ptdLoss"),
                        request.getParameter("ptdExp"),
                        request.getParameter("ptdFee"),
                        request.getParameter("ptdTotal"),
                        request.getParameter("pttLoss"),
                        request.getParameter("pttExp"),
                        request.getParameter("pttFee"),
                        request.getParameter("pttTotal"),
                        request.getParameter("osLoss"),
                        request.getParameter("osLossqual"),
                        request.getParameter("osExp"),
                        request.getParameter("osFee"),
                        request.getParameter("osFeeQual"),
                        request.getParameter("osTotal"),
                        request.getParameter("osTotalQual"),
                        request.getParameter("ptdInSettCcy"),
                        request.getParameter("settledRateInSettCcy"),
                        request.getParameter("totalLine"),
                        request.getParameter("bureauPpn"),
                        request.getParameter("vatAmount"),
                        vatRates,
                        vatAmts,
                        request.getParameter("warAmount"),
                        request.getParameter("narrativeCode1"),
                        request.getParameter("narrativeCode2"),
                        request.getParameter("narrativeForSet"),
                        request.getParameter("narrativeForSet2"),
                        request.getParameter("narrativeForSet3"),
                        checkboxValue(request.getParameter("subrogation")),
                        request.getParameter("xcsRecovery"),
                        request.getParameter("highestEst"),
                        request.getParameter("incurred"),
                        request.getParameter("osRateOfExch"),
                        request.getParameter("finderCode1"),
                        request.getParameter("finderCode2"),
                        request.getParameter("finderCode3"),
                        checkboxValue(request.getParameter("attachmentsInd")),
//                        request.getParameter("cashCorpt1"),
                        request.getParameter("brokerContact"),
                        request.getParameter("brokerPhoneNo"),
                        request.getParameter("brokerClaimRef"),
                        request.getParameter("brokerClaimRef2"),
                        request.getParameter("countryOfOrigin"),
                        request.getParameter("origInsured"),
                        request.getParameter("insured"),
                        request.getParameter("reinsured"),
                        request.getParameter("ch"),
                        request.getParameter("claimant"),
                        request.getParameter("vesselAircraftConveyance"),
                        request.getParameter("otherName"),
                        polPerFrom,
                        polPerTo,
                        request.getParameter("polCertQualifier"),
                        dolFrom,
                        dolTo,
                        request.getParameter("dolQual"),
                        request.getParameter("dolNarr"),
                        dcmFrom,
                        dcmTo,
                        request.getParameter("dcmDodQual"),
                        request.getParameter("catCode"),
                        request.getParameter("pcsCode"),
                        request.getParameter("ccyOfLimits"),
                        request.getParameter("limits"),
                        request.getParameter("excess"),
                        request.getParameter("perilsCondition"),
                        request.getParameter("lossLocation"),
                        request.getParameter("voyage"),
                        request.getParameter("lossName"),
                        sNarrative,
                        request.getParameter("lawyerName"),
                        request.getParameter("lawyerRef"),
                        request.getParameter("lawyerCode"),
                        request.getParameter("adjusterName"),
                        request.getParameter("adjusterRef"),
                        request.getParameter("adjusterCode"),
                        request.getParameter("schemeCode"),
                        request.getParameter("tfCode"),
                        request.getParameter("stateCode"),
                        request.getParameter("naicCode"),
                        request.getParameter("naicQual"),
                        checkboxValue(request.getParameter("warInd")),
                        request.getParameter("filCode1"),
                        request.getParameter("filCode2"),
                        request.getParameter("otherTfCode"),
                        request.getParameter("dti"),
                        checkboxValue(request.getParameter("usaCanInd")),
                        checkboxValue(request.getParameter("lfEntryInd")), /* CCN#31 */
                        checkboxValue(request.getParameter("lfAdvancedInd")), /* CCN#31 */
                        checkboxValue(request.getParameter("blockInd")), /* CCN#31 */
                        checkboxValue(request.getParameter("directReportInd")), //SIR:150695 ECF Phase 6 Changes
                        checkboxValue(request.getParameter("clmInLitigationInd")), //SIR:150695 ECF Phase 6 Changes
                        request.getParameter("serviceType"),
                        expertFeeBreakDownDetails,
                        expertFeeBreakDownModel.getExpertCount(),
                        request.getParameter("countyCode"),
                        request.getParameter("barcode")      // TP866603 -Changes for barcode field
                        ));

    v.add(new LY11Event("SCR017","E","N"));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}
