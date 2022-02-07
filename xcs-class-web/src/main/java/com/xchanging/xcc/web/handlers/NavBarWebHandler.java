package com.xchanging.xcc.web.handlers;

import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY29Event;
import com.xchanging.xcc.events.LY30Event;
import com.xchanging.xcc.events.LY32Event;
import com.xchanging.xcc.events.LY33Event;
import com.xchanging.xcc.events.LY35Event;
import com.xchanging.xcc.events.LY36Event;
import com.xchanging.xcc.events.LY38Event;
import com.xchanging.xcc.events.LY39Event;
import com.xchanging.xcc.events.LY41Event;
import com.xchanging.xcc.events.LY42Event;
import com.xchanging.xcc.events.LY44Event;
import com.xchanging.xcc.events.LY45Event;
import com.xchanging.xcc.events.LY46Event;
import com.xchanging.xcc.events.LY57Event;
import com.xchanging.xcc.events.LY58Event;
import com.xchanging.xcc.events.LY65Event;
import com.xchanging.xcc.events.LY94Event;
import com.xchanging.xcc.events.LY99Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.BulkComponentSelectionModel;
import com.xchanging.xcc.web.models.ClaimDetailsModel;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.ExpertFeeBreakDownModel;
import com.xchanging.xcc.web.models.FinancialDetailsModel;
import com.xchanging.xcc.web.models.MarketDetailsModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.PolicyRiskDetailsModel;
import com.xchanging.xcc.web.models.SCMAdviceModel;
import com.xchanging.xcc.web.models.SingleClaimLossReservesModel;
import com.xchanging.xcc.web.models.VATRatesModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class NavBarWebHandler extends WebHandler {

  private String ucrTrSysRef;
  private String currNo;
  private String sdnNo;
  private String statSplitNo;
  private String breakdownNo;
  private String returnScreen;
  private String nextScreen;
  private boolean validate;

  Vector v = new Vector();
  ModelManager mm;

  public void doStart(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getMarketsModel();
    mm.getPremiumComparisonModel();
    mm.getQuestionModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ucrTrSysRef = request.getParameter("ucrTrSysRef");
    currNo = request.getParameter("currNo");
    sdnNo = request.getParameter("sdnNo");
    statSplitNo = request.getParameter("statSplitNo");
    breakdownNo = request.getParameter("breakdownNo");

    returnScreen = request.getParameter("currentScreen");
    nextScreen = request.getParameter("screenId");
    validate = (!nextScreen.equals("SCR009")) &&
               (!nextScreen.equals("SCR012")) &&
               (!nextScreen.equals("SCR013")) &&
               (!nextScreen.equals("SCR014")) &&
               (!nextScreen.equals("SCR015")) &&
               (!nextScreen.equals("SCR016"));


    if (returnScreen.equals("SCR009")) {
      processSCR009(request);
    } else if (returnScreen.equals("SCR012")) {
      processSCR012(request);
    } else if (returnScreen.equals("SCR013")) {
      processSCR013(request);
    } else if (returnScreen.equals("SCR014")) {
      processSCR014(request);
    } else if (returnScreen.equals("SCR015")) {
      processSCR015(request);
    } else if (returnScreen.equals("SCR016")) {
      processSCR016(request);
    } else if (returnScreen.equals("SCR017")) {
      processSCR017(request);
    } else if (returnScreen.equals("SCR020")) {
      processSCR020(request);
    } else if (returnScreen.equals("SCR023")) {
      processSCR023(request);
    } else if (returnScreen.equals("SCR024")) {
      processSCR024(request);
    }

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }

  public void processSCR009(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();
    MarketsModel marketsModel = mm.getMarketsModel();

    String[] curr  = new String[3];
    String[] osnd  = new String[3];
    String[] apsnd = new String[3];

    for (int x = 0; x < 3; x++) {
      curr[x] = "";
      osnd[x] = "";
      apsnd[x] = "";
    }

    /**
     * Get the data for the LY25 Validation Event
     */

    // Check boxes
    String bulkInd          = checkboxValue(request.getParameter("bulkInd"));
    String nonScmAdvised    = checkboxValue(request.getParameter("nonScmAdvised"));
    String lossReserve      = checkboxValue(request.getParameter("lossReserve"));
    String prevPaidInd      = checkboxValue(request.getParameter("prevPaidInd"));

    // CCN# N0058 - BA - 09/01/2003
    String locDrawingInd    = checkboxValue(request.getParameter("locDrawingInd"));

    // CCN# N0021 - devo - 15/01/2003
    String schemeCanInd    = checkboxValue(request.getParameter("schemeCanInd"));
    String cpaInd          = checkboxValue(request.getParameter("cpaInd"));
    String dirLStockInd    = checkboxValue(request.getParameter("dirLStockInd"));



    String treaty           = checkboxValue(request.getParameter("treaty"));
        String ecfClaim           = checkboxValue(request.getParameter("ecfClaim"));
        String ecfClass           = request.getParameter("ecfClass");
    String riskUnsigned     = checkboxValue(request.getParameter("riskUnsigned"));
    String loc              = checkboxValue(request.getParameter("loc"));
    String payByCheque      = request.getParameter("payByCheque");
    String simRi            = checkboxValue(request.getParameter("simRi"));
    String prevAdvNonNet    = checkboxValue(request.getParameter("prevAdvNonNet"));
    String lossFund         = checkboxValue(request.getParameter("lossFund"));
    String noChargeableInd  = checkboxValue(request.getParameter("noChargeableInd"));

    /**
     * Get the data from the drop down lists
     */
    String settAdv          = request.getParameter("settAdv");
    String chargeType       = request.getParameter("chargeType");

    /**
     * Get the Pres Date
     */
    String presDate         = constructPresDate(request);

    /**
     * Get the three currencies
     */
    curr[0] = request.getParameter("origCcy1");
    curr[1] = request.getParameter("origCcy2");
    curr[2] = request.getParameter("origCcy3");

    /**
     * Get the three OSND and APSND values
     */
    String osnd1sssss  = request.getParameter("osnd1sssss");
    String osnd1dd     = request.getParameter("osnd1dd");
    String osnd1mm     = request.getParameter("osnd1mm");
    String osnd1yy     = request.getParameter("osnd1yy");

    String osnd2sssss  = request.getParameter("osnd2sssss");
    String osnd2dd     = request.getParameter("osnd2dd");
    String osnd2mm     = request.getParameter("osnd2mm");
    String osnd2yy     = request.getParameter("osnd2yy");

    String osnd3sssss  = request.getParameter("osnd3sssss");
    String osnd3dd     = request.getParameter("osnd3dd");
    String osnd3mm     = request.getParameter("osnd3mm");
    String osnd3yy     = request.getParameter("osnd3yy");

    String apsnd1sssss = request.getParameter("apsnd1sssss");
    String apsnd1dd    = request.getParameter("apsnd1dd");
    String apsnd1mm    = request.getParameter("apsnd1mm");
    String apsnd1yy    = request.getParameter("apsnd1yy");

    String apsnd2sssss = request.getParameter("apsnd2sssss");
    String apsnd2dd    = request.getParameter("apsnd2dd");
    String apsnd2mm    = request.getParameter("apsnd2mm");
    String apsnd2yy    = request.getParameter("apsnd2yy");

    String apsnd3sssss = request.getParameter("apsnd3sssss");
    String apsnd3dd    = request.getParameter("apsnd3dd");
    String apsnd3mm    = request.getParameter("apsnd3mm");
    String apsnd3yy    = request.getParameter("apsnd3yy");

    /**
     * Construct the OSND and APSND values to the correct
     * format
     */

    if (!osnd1yy.equals("")) {
      osnd[0] = getCentury(osnd1yy) + osnd1yy + osnd1mm + osnd1dd + osnd1sssss;
    }
    if (!osnd2yy.equals("")) {
      osnd[1] = getCentury(osnd2yy) + osnd2yy + osnd2mm + osnd2dd + osnd2sssss;
    }
    if (!osnd3yy.equals("")) {
      osnd[2] = getCentury(osnd3yy) + osnd3yy + osnd3mm + osnd3dd + osnd3sssss;
    }

    if (!apsnd1yy.equals("")) {
      apsnd[0] = getCentury(apsnd1yy) + apsnd1yy + apsnd1mm + apsnd1dd + apsnd1sssss;
    }
    if (!apsnd2yy.equals("")) {
      apsnd[1] = getCentury(apsnd2yy) + apsnd2yy + apsnd2mm + apsnd2dd + apsnd2sssss;
    }
    if (!apsnd3yy.equals("")) {
      apsnd[2] = getCentury(apsnd3yy) + apsnd3yy + apsnd3mm + apsnd3dd + apsnd3sssss;
    }

    String riskCode         = ctcModel.getRiskCode();
    String slipType         = ctcModel.getSlipType();


    /**
     * Event - Build Commarea for LIDS Interface and get Markets
     */
    v.add(new LY94Event(osnd,apsnd,curr,riskCode,
                         settAdv,nonScmAdvised,bulkInd,
                         riskUnsigned,treaty,ecfClaim,ecfClass,simRi,lossReserve,
                         loc,lossFund,payByCheque,chargeType,
                         noChargeableInd,prevAdvNonNet,prevPaidInd,
                         locDrawingInd, /* CCN# N0058 - BA - 09/01/2003 */
                         presDate,slipType,schemeCanInd, cpaInd,dirLStockInd,marketsModel.getOrigBkrCurr()));
  }

  public void processSCR012(HttpServletRequest request) {

    String polCertQualifier     = request.getParameter("polCertQualifier");
    String interest             = request.getParameter("interest");
    String perilsCondition      = request.getParameter("perilsCondition");
    String polCertPeriodFromHF  = request.getParameter("polCertPeriodFromHF");
    String peerReview           = request.getParameter("peerReview");
    String riskCode             = request.getParameter("riskCode");

    /* CCN # N0030 - BA - 7/1/2002 */
    String marketCode           = request.getParameter("marketCode");

    String coverLineslipToyyyy  = request.getParameter("coverLineslipToyyyy");
    String polCertPeriodFromyyyy = request.getParameter("polCertPeriodFromyyyy");
    String coverLineslipToHF    = request.getParameter("coverLineslipToHF");
    String sumInsuredNarrative2 = request.getParameter("sumInsuredNarrative2");
    String sumInsuredNarrative1 = request.getParameter("sumInsuredNarrative1");
    String coverLineslipFromyyyy = request.getParameter("coverLineslipFromyyyy");
    String polCertPeriodTomm    = request.getParameter("polCertPeriodTomm");
    String polCertPeriodToyyyy  = request.getParameter("polCertPeriodToyyyy");
    String polCertPeriodTodd    =  request.getParameter("polCertPeriodTodd");
    String coverLineslipFrommm  = request.getParameter("coverLineslipFrommm");
    String coverLineslipFromdd  = request.getParameter("coverLineslipFromdd");
    String policyPeriodNarrative= request.getParameter("policyPeriodNarrative");
    String slipOrder2           = request.getParameter("slipOrder2");
    String slipOrder1           = request.getParameter("slipOrder1");
    String umr                    = request.getParameter("umrumrb") + request.getParameter("umrumrbn") + request.getParameter("umrumranum");
    Logger.debug(this, "umr = " + umr);
    String polCertPeriodFrommm  = request.getParameter("polCertPeriodFrommm");
    String coverLineslipQualifier = request.getParameter("coverLineslipQualifier");
    String polCertPeriodFromdd  = request.getParameter("polCertPeriodFromdd");
    String yoa                  = request.getParameter("yoa");
    String basisOfLimit         = request.getParameter("basisOfLimit");
    String coverLineslipTomm    = request.getParameter("coverLineslipTomm");
    String coverLineslipTodd    = request.getParameter("coverLineslipTodd");
    String locationVoyageOfRisk = request.getParameter("locationVoyageOfRisk");
    String polCertPeriodToHF    = request.getParameter("polCertPeriodToHF");
    String currentBkr              = request.getParameter("currentBkr");
    String coverLineslipFromHF  = request.getParameter("coverLineslipFromHF");
    String warInd               = checkboxValue(request.getParameter("warInd"));
    String slipType                             = request.getParameter("slipType");
    String umrLids = mm.getClaimTransactionCreationModel().getUmr();

    String[] arrayExcess      = new String[3];
    String[] arraylimits      = new String[3];
    String[] arrayCcyOfLimits = new String[3];

    for (int x = 0; x < 3; x++) {
      arrayExcess[x] = "";
      arraylimits[x] = "";
      arrayCcyOfLimits[x] = "";
    }

    arrayExcess[0] = request.getParameter("excess1");
    arrayExcess[1] = request.getParameter("excess2");
    arrayExcess[2] = request.getParameter("excess3");
    arraylimits[0] = request.getParameter("limits1");
    arraylimits[1] = request.getParameter("limits2");
    arraylimits[2] = request.getParameter("limits3");
    arrayCcyOfLimits[0] = request.getParameter("ccyOfLimits1");
    arrayCcyOfLimits[1] = request.getParameter("ccyOfLimits2");
    arrayCcyOfLimits[2] = request.getParameter("ccyOfLimits3");

      v.add(new LY29Event(peerReview,
                          currentBkr,
                          riskCode,
                          marketCode, /* CCN # N0030 - BA - 7/1/2002 */
                          yoa,
                          interest,
                          arrayCcyOfLimits,
                          arraylimits,
                          arrayExcess,
                          slipOrder1,
                          slipOrder2,
                          perilsCondition,
                          locationVoyageOfRisk,
                          basisOfLimit,
                          formatDate(polCertPeriodFromyyyy, polCertPeriodFrommm, polCertPeriodFromdd),
                          formatDate(polCertPeriodToyyyy, polCertPeriodTomm, polCertPeriodTodd),
                          polCertQualifier,
                          formatDate(coverLineslipFromyyyy, coverLineslipFrommm,coverLineslipFromdd),
                          formatDate(coverLineslipToyyyy, coverLineslipTomm, coverLineslipTodd),
                          coverLineslipQualifier,
                          warInd,
                          slipType,
                          umr,                          
                          umrLids));

                          PolicyRiskDetailsModel policy = mm.getPolicyRiskDetailsModel();

                          v.add(new LY30Event(
                              policy.getXcr(),
                              policy.getUcr(),
                              policy.getTr(),
                              policy.getOrigRef1Flag(),
                              policy.getOrigRef2Flag(),
                              policy.getOrigRef3Flag(),
                              peerReview,
                              currentBkr,
                              riskCode,
                              marketCode, /* CCN # N0030 - BA - 7/1/2002 */
                              yoa,
                              interest,
                              arrayCcyOfLimits,
                              arraylimits,
                              arrayExcess,
                              sumInsuredNarrative1,
                                                /*  CCN: N0047
                                                Changed on: 11/12/02 (DH)
                                                sumInsuredNarrative2,
                                                */
                          slipOrder1,
                          slipOrder2,
                          perilsCondition,
                          locationVoyageOfRisk,
                          basisOfLimit,
                          formatDate(polCertPeriodFromyyyy, polCertPeriodFrommm, polCertPeriodFromdd),
                          formatDate(polCertPeriodToyyyy, polCertPeriodTomm, polCertPeriodTodd),
                          polCertQualifier,
                          policyPeriodNarrative,
                          formatDate(coverLineslipFromyyyy, coverLineslipFrommm,coverLineslipFromdd),
                          formatDate(coverLineslipToyyyy, coverLineslipTomm, coverLineslipTodd),
                          coverLineslipQualifier,
                          warInd,
                          slipType,
                          umr /* CCN # N0039 - BA - 7/1/2002 */));

                          v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
  }

  public void processSCR013(HttpServletRequest request) {
    MarketDetailsModel marketDetails = mm.getMarketDetailsModel();

    Vector syndicateNos = new Vector();
    Vector syndicatePercs = new Vector();
    Vector syndicateRefs = new Vector();
    Vector bureauLeaders = new Vector();
    Vector deleteInds = new Vector();

    int i=1;

    String delInd = checkboxValue(request.getParameter("del" + i));
    String syndNo = request.getParameter("syndicateNo" + i);
    String syndPerc = request.getParameter("syndicatePerc" + i);
    String syndRef = request.getParameter("syndicateRef" + i);
    String burLeader = checkboxValue(request.getParameter("bureauLeader" + i));


    while ((syndNo!=null) && (!syndNo.equals(""))) {
      deleteInds.add(delInd);
      syndicateNos.add(syndNo);
      syndicatePercs.add(syndPerc);
      syndicateRefs.add(syndRef);
      bureauLeaders.add(burLeader);

      i++;
      delInd = checkboxValue(request.getParameter("del" + i));
      syndNo = request.getParameter("syndicateNo" + i);
      syndPerc = request.getParameter("syndicatePerc" + i);
      syndRef = request.getParameter("syndicateRef" + i);
      burLeader = checkboxValue(request.getParameter("bureauLeader" + i));
    }

    i=1;
    delInd = checkboxValue(request.getParameter("delInsert" + i));
    syndNo = request.getParameter("syndicateNoInsert" + i);
    syndPerc = request.getParameter("syndicatePercInsert" + i);
    syndRef = request.getParameter("syndicateRefInsert" + i);
    burLeader = checkboxValue(request.getParameter("bureauLeaderInsert" + i));

    while ((syndNo!=null) && (!syndNo.equals(""))) {
      deleteInds.add(delInd);
      syndicateNos.add(syndNo);
      syndicatePercs.add(syndPerc);
      syndicateRefs.add(syndRef);
      bureauLeaders.add(burLeader);

      i++;
      delInd = checkboxValue(request.getParameter("delInsert" + i));
      syndNo = request.getParameter("syndicateNoInsert" + i);
      syndPerc = request.getParameter("syndicatePercInsert" + i);
      syndRef = request.getParameter("syndicateRefInsert" + i);
      burLeader = checkboxValue(request.getParameter("bureauLeaderInsert" + i));
    }

    // place the vectors into string arrays.
    String[] aDeleteInds = new String[deleteInds.size()];
    String[] aSyndicateNos = new String[syndicateNos.size()];
    String[] aSyndicatePercs = new String[syndicatePercs.size()];
    String[] aSyndicateRefs = new String[syndicateRefs.size()];
    String[] aBureauLeaders = new String[bureauLeaders.size()];

    for(int x = 0; x < syndicateNos.size(); x++){
      aDeleteInds[x] = (String)deleteInds.get(x);
      aSyndicateNos[x] = (String)syndicateNos.get(x);
      aSyndicatePercs[x] = (String)syndicatePercs.get(x);
      aSyndicateRefs[x] = (String)syndicateRefs.get(x);
      aBureauLeaders[x] = (String)bureauLeaders.get(x);
    }


      v.add(new LY32Event(marketDetails.getNoSyndicates(),marketDetails.getTotalLine(),marketDetails.getMarketSource(), aSyndicateNos, aSyndicatePercs, aSyndicateRefs, aDeleteInds));
    v.add(new LY33Event(marketDetails.getTotalLine(), aSyndicateNos, aSyndicatePercs, aSyndicateRefs, aBureauLeaders,aDeleteInds));
    v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
  }

  public void processSCR014(HttpServletRequest request) throws ClaimsErrorException {
    ClaimDetailsModel claimDetails = mm.getClaimDetailsModel();

    String dolTo = formatDate(request.getParameter("dolToyyyy"), request.getParameter("dolTomm"), request.getParameter("dolTodd"));
    String dolFrom = formatDate(request.getParameter("dolFromyyyy"), request.getParameter("dolFrommm"), request.getParameter("dolFromdd"));
    String dcmFrom = formatDate(request.getParameter("dcmFromyyyy"),request.getParameter("dcmFrommm"),request.getParameter("dcmFromdd"));
    String dcmTo = formatDate(request.getParameter("dcmToyyyy"),request.getParameter("dcmTomm"),request.getParameter("dcmTodd"));

    String bkrUcr = request.getParameter("bkrUcrpt1") + request.getParameter("bkrUcrpt2") + request.getParameter("bkrUcrpt3");

    String[] claimNarrative = getNarrative(request.getParameter("claimNarr"),50,7);

    String[] certInsNos = new String[] {
            request.getParameter("certInsNo1"),
            request.getParameter("certInsNo2"),
            request.getParameter("certInsNo3"),
            request.getParameter("certInsNo4"),
            request.getParameter("certInsNo5")
          };

    v.add(new LY35Event(request.getParameter("bkrContact"),
                          request.getParameter("bkrPhoneNo"),
                          request.getParameter("bkrClaimRef1"),
                          request.getParameter("bkrClaimRef2"),
                          bkrUcr,
                          request.getParameter("origInsured"),
                          request.getParameter("insured"),
                          request.getParameter("reinsured"),
                          request.getParameter("coverholder"),
                          request.getParameter("claimant"),
                          request.getParameter("otherName"),
                          request.getParameter("lossName"),
                          request.getParameter("vesselAircraft"),
                          dolFrom,
                          dolTo,
                          request.getParameter("dolQual"),
                          request.getParameter("dolNarrative"),
                          dcmFrom,
                          dcmTo,
                          request.getParameter("dcmQual"),
                          request.getParameter("lossLocation"),
                          request.getParameter("voyage"),
                          request.getParameter("catCode"),
                          request.getParameter("pcsCat"),
                          request.getParameter("claimRiskType"),
                          claimNarrative,
                          request.getParameter("adjSurvName"),
                          request.getParameter("adjSurvRef"),
                          request.getParameter("lawyerName"),
                          request.getParameter("lawyerRef"),
                          request.getParameter("causeCode"),
                          request.getParameter("chClmRef"),
                          request.getParameter("certInsNo1"),
                          request.getParameter("certInsNo2"),
                          request.getParameter("certInsNo3"),
                          request.getParameter("certInsNo4"),
                          request.getParameter("certInsNo5")
                          ));

    v.add(new LY36Event(claimDetails.getXcr(),
                        claimDetails.getUcr(),
                        claimDetails.getTr(),
                        claimDetails.getOsnd1(),
                        claimDetails.getOsnd2(),
                        claimDetails.getOsnd3(),
                        claimDetails.getOrigBroker(),
                        claimDetails.getSignedInd(),
                        claimDetails.getPeerReview(),
                        request.getParameter("bkrContact"),
                        request.getParameter("bkrPhoneNo"),
                        request.getParameter("bkrClaimRef1"),
                        request.getParameter("bkrClaimRef2"),
                        bkrUcr,
                        request.getParameter("origInsured"),
                        request.getParameter("insured"),
                        request.getParameter("reinsured"),
                        request.getParameter("coverholder"),
                        request.getParameter("claimant"),
                        request.getParameter("otherName"),
                        request.getParameter("lossName"),
                        request.getParameter("vesselAircraft"),
                        dolFrom,
                        dolTo,
                        request.getParameter("dolQual"),
                        request.getParameter("dolNarrative"),
                        dcmFrom,
                        dcmTo,
                        request.getParameter("dcmQual"),
                        request.getParameter("lossLocation"),
                        request.getParameter("voyage"),
                        request.getParameter("catCode"),
                        request.getParameter("pcsCat"),
                        request.getParameter("claimRiskType"),
                        claimNarrative,
                        request.getParameter("adjSurvName"),
                        request.getParameter("adjSurvRef"),
                        request.getParameter("lawyerName"),
                        request.getParameter("lawyerRef"),
                        request.getParameter("causeCode"),
                        request.getParameter("chClmRef"),
                        false,
                        certInsNos
                        ));

    v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
  }

  public void processSCR015(HttpServletRequest request) {
    FinancialDetailsModel fdm = mm.getFinancialDetailsModel();
    
      v.add(new LY38Event(request.getParameter("payeeBroker"),
                          request.getParameter("payeeBrokerPseud"),
                          request.getParameter("redenomInd"),
                          request.getParameter("origCcy"),
                          request.getParameter("settCcy"),
                          checkboxValue(request.getParameter("settCcyInd")),
                          request.getParameter("settRateOfExch"),
                          request.getParameter("ptdTotal"),
                          request.getParameter("pttTotal"),
                          request.getParameter("osTotal"),
                          request.getParameter("osTotalQual"),
                          request.getParameter("settledInSettCcy"),
                          request.getParameter("totalLine"),
                          request.getParameter("bureauPpnAmt"),
                          request.getParameter("vatAmt"),
                          request.getParameter("warAmount"),
                          request.getParameter("incurred"),
                          
                          request.getParameter("brokerTr"), //SIR:150695 ECF Phase 6 changes
                          request.getParameter("brokerTrQual"), //SIR:150695 ECF Phase 6 changes
                          request.getParameter("peerReview"),
                          
      					request.getParameter("individualUcr"),
      					request.getParameter("individualTr")
                          ));

    v.add(new LY39Event(fdm.getXcr(),
                        fdm.getUcr(),
                        fdm.getTr(),
                        fdm.getOsnd1(),
                        fdm.getOsnd2(),
                        fdm.getOsnd3(),
                        fdm.getOrigBkr(),
                        fdm.getSigned(),
                        request.getParameter("peerReview"),
                        request.getParameter("payeeBroker"),
                        request.getParameter("payeeBrokerPseud"),
                        request.getParameter("redenomInd"),
                        request.getParameter("origCcy"),
                        request.getParameter("settCcy"),
                        checkboxValue(request.getParameter("settCcyInd")),
                        request.getParameter("settRateOfExch"),
                        request.getParameter("ptdTotal"),
                        request.getParameter("pttTotal"),
                        request.getParameter("osTotal"),
                        request.getParameter("osTotalQual"),
                        request.getParameter("settledInSettCcy"),
                        request.getParameter("totalLine"),
                        request.getParameter("bureauPpnAmt"),
                        request.getParameter("vatAmt"),
                        request.getParameter("warAmount"),
                        request.getParameter("incurred"),
                        
                        request.getParameter("brokerTr"), //SIR:150695 ECF Phase 6 changes
                        request.getParameter("brokerTrQual"), //SIR:150695 ECF Phase 6 changes
                      //Binders changes
                       
    					request.getParameter("individualUcr"),
    					request.getParameter("individualTr")
                       
                        ));
    v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
  }

  public void processSCR016(HttpServletRequest request) {
    SingleClaimLossReservesModel claimModel =  mm.getSingleClaimLossReservesModel();

    String xcr = claimModel.getXcr() ;
    String ucr = claimModel.getUcr() ;
    String tr = claimModel.getTr() ;
    String origRef = claimModel.getOsnd() ;
    String origBkr = claimModel.getOrigBkr() ;
    String signedInd = claimModel.getSigned() ;
    String peerRevInd = claimModel.getPeerReview() ;
    String origCurr = claimModel.getOrigCcy() ;
    String cor = claimModel.getCor() ;
    String locInd = claimModel.getLoc() ;
    String moveRef = claimModel.getMvmtRefDate() ;
    String lrAdjDate = request.getParameter("lrAdjustmentAsAtyyyy") + "-" + request.getParameter("lrAdjustmentAsAtmm") + "-" + request.getParameter("lrAdjustmentAsAtdd");
    if (lrAdjDate.length()<=2)
      lrAdjDate = "";
    String lrRefunded = request.getParameter("refundedLR") ;
    String lrPaidClaim = request.getParameter("paidClaim") ;
    String lrAdvanced = request.getParameter("lrAdvanced") ;
    String lrInterest = request.getParameter("interest") ; ;
    String lrTax = request.getParameter("tax") ;
    String lrNetAmt = request.getParameter("net") ;
    String lrOutstAmt = request.getParameter("osAmount") ;
    String lrOutstQual = request.getParameter("osQualifier") ;

      v.add(
          new LY41Event(
          xcr,
          ucr,
          tr,
          origRef,
          origBkr,
          signedInd,
          peerRevInd,
          origCurr,
          cor,
          locInd,
          moveRef,
          lrAdjDate,
          lrRefunded,
          lrPaidClaim,
          lrAdvanced,
          lrInterest,
          lrTax,
          lrNetAmt,
          lrOutstAmt,
          lrOutstQual
          )
          ) ;
    v.add(
        new LY42Event(
        xcr,
        ucr,
        tr,
        origRef,
        origBkr,
        signedInd,
        peerRevInd,
        origCurr,
        cor,
        locInd,
        moveRef,
        lrAdjDate,
        lrRefunded,
        lrPaidClaim,
        lrAdvanced,
        lrInterest,
        lrTax,
        lrNetAmt,
        lrOutstAmt,
        lrOutstQual
        )
        ) ;
    v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
  }

  public void processSCR017(HttpServletRequest request) throws ClaimsErrorException {
    SCMAdviceModel scmAdvice = mm.getSCMAdviceModel();
    mm.getClaimDetailsModel();
    mm.getMarketsModel();
    VATRatesModel vatModel = mm.getVATRatesModel();
    ExpertFeeBreakDownModel expertFeeBreakDownModel  = mm.getExpertFeeBreakDownModel();

    Vector expertFeeBreakDownDetails = expertFeeBreakDownModel.getExpertFeeBreakDownROWS();


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

    if (validate)
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
                        request.getParameter("barcode")     // TP866603 -Changes for barcode field
                        
                        ));

    v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
  }

  public void processSCR020(HttpServletRequest request) {
    Vector dels = new Vector();
    Vector name1s = new Vector();
    Vector name1quals = new Vector();
    Vector statecodes = new Vector();
    Vector naiccodes = new Vector();
    Vector naicquals = new Vector();
    Vector dolquals = new Vector();
    Vector catcodes = new Vector();
    Vector name2s = new Vector();
    Vector name2quals = new Vector();
    Vector tfcodes = new Vector();
    Vector filcodes = new Vector();
    Vector pcscodes = new Vector();
    Vector dolfroms = new Vector();
    Vector doltos = new Vector();
    Vector cors = new Vector();
    Vector statsplits = new Vector();
    Vector mvmtrefs = new Vector();
    Vector breakdownnos = new Vector();
    Vector osamts = new Vector();
    Vector pttamts = new Vector();

    int i=1;

    while(request.getParameter("cor" + i)!=null) {

      dels.add(checkboxValue(request.getParameter("delchkbox" + i)));
      name1s.add(request.getParameter("name1" + i));
      name1quals.add(request.getParameter("name1qual" + i));
      statecodes.add(request.getParameter("statecode" + i));
      naiccodes.add(request.getParameter("naiccode" + i));
      naicquals.add(request.getParameter("naicqual" + i));
      dolquals.add(request.getParameter("dolqual" + i));
      catcodes.add(request.getParameter("catcode" + i));
      name2s.add(request.getParameter("name2" + i));
      name2quals.add(request.getParameter("name2qual" + i));
      tfcodes.add(request.getParameter("tfcode" + i));
      filcodes.add(request.getParameter("filcode" + i));
      pcscodes.add(request.getParameter("pcscode" + i));
      dolfroms.add(request.getParameter("dolfrom" + i + "yyyy") + "-" + request.getParameter("dolfrom" + i + "mm") + "-" + request.getParameter("dolfrom" + i + "dd"));
      doltos.add(request.getParameter("dolto" + i + "yyyy") + "-" + request.getParameter("dolto" + i + "mm") + "-" + request.getParameter("dolto" + i + "dd"));
      cors.add(request.getParameter("cor" + i));
      statsplits.add(request.getParameter("statsplit" + i));
      mvmtrefs.add(request.getParameter("mvmtref" + i));
      breakdownnos.add(request.getParameter("breakdownno" + i));
      osamts.add(request.getParameter("osAmt" + i));
      pttamts.add(request.getParameter("pttAmt" + i));

      i++;
    }

    i=i-1;

    String[] delsA = new String[i];
    String[] name1sA = new String[i];
    String[] name1qualsA = new String[i];
    String[] statecodesA = new String[i];
    String[] naiccodesA = new String[i];
    String[] naicqualsA = new String[i];
    String[] dolqualsA = new String[i];
    String[] catcodesA = new String[i];
    String[] name2sA = new String[i];
    String[] name2qualsA = new String[i];
    String[] tfcodesA = new String[i];
    String[] filcodesA = new String[i];
    String[] pcscodesA = new String[i];
    String[] dolfromsA = new String[i];
    String[] doltosA = new String[i];
    String[] corsA = new String[i];
    String[] statsplitsA = new String[i];
    String[] mvmtrefsA = new String[i];
    String[] breakdownnosA = new String[i];
    String[] osamtsA = new String[i];
    String[] pttamtsA = new String[i];

    for (int j=0; j<cors.size(); j++) {

      delsA[j] = (String)dels.elementAt(j);
      name1sA[j] = (String)name1s.elementAt(j);
      name1qualsA[j] = (String)name1quals.elementAt(j);
      statecodesA[j] = (String)statecodes.elementAt(j);
      naiccodesA[j] = (String)naiccodes.elementAt(j);
      naicqualsA[j] = (String)naicquals.elementAt(j);
      dolqualsA[j] = (String)dolquals.elementAt(j);
      catcodesA[j] = (String)catcodes.elementAt(j);
      name2sA[j] = (String)name2s.elementAt(j);
      name2qualsA[j] = (String)name2quals.elementAt(j);
      tfcodesA[j] = (String)tfcodes.elementAt(j);
      filcodesA[j] = (String)filcodes.elementAt(j);
      pcscodesA[j] = (String)pcscodes.elementAt(j);
      dolfromsA[j] = (String)dolfroms.elementAt(j);
      doltosA[j] = (String)doltos.elementAt(j);
      corsA[j] = (String)cors.elementAt(j);
      statsplitsA[j] = (String)statsplits.elementAt(j);
      mvmtrefsA[j] = (String)mvmtrefs.elementAt(j);
      breakdownnosA[j] = (String)breakdownnos.elementAt(j);
      osamtsA[j] = (String)osamts.elementAt(j);
      pttamtsA[j] = (String)pttamts.elementAt(j);
    }


      v.add(new LY57Event(corsA,delsA,statsplitsA,breakdownnosA,mvmtrefsA,name1sA,name1qualsA,name2sA,name2qualsA,filcodesA,tfcodesA,
                          statecodesA,dolfromsA,doltosA,dolqualsA,catcodesA,pcscodesA,naiccodesA,naicqualsA,osamtsA,pttamtsA));
    v.add(new LY58Event(corsA,delsA,statsplitsA,breakdownnosA,mvmtrefsA,name1sA,name1qualsA,name2sA,name2qualsA,filcodesA,tfcodesA,
                        statecodesA,dolfromsA,doltosA,dolqualsA,catcodesA,pcscodesA,naiccodesA,naicqualsA,osamtsA,pttamtsA));

    v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
  }

  public void processSCR023(HttpServletRequest request) {
    BulkComponentSelectionModel bulkSelection = mm.getBulkComponentSelectionModel();

    String[] compSysRefs = new String[bulkSelection.getNoOfItems()];
    String[] includeInds = new String[bulkSelection.getNoOfItems()];

    for (int i=0; i<compSysRefs.length; i++) {

      compSysRefs[i] = bulkSelection.getItem(i).getCompSysRef();
      includeInds[i] = checkboxValue(request.getParameter("item" + (i+1)));

    }

    v.add(new LY99Event(compSysRefs,includeInds));
    v.add(new LY65Event(true,request.getParameter("ucrTrSysRef"),request.getParameter("currNo"),request.getParameter("sdnNo"),request.getParameter("statSplitNo"),request.getParameter("breakdownNo"),request.getParameter("currentScreen"),request.getParameter("screenId"),"V"));
  }

  public void processSCR024(HttpServletRequest request) {
    v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
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
}
