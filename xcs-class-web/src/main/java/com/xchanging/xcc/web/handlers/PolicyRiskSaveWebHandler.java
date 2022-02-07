package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.events.LY29Event;
import com.xchanging.xcc.events.LY30Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.PolicyRiskDetailsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

/********************************************************
 * NOTE-
 * this will be used as both the save web handler and the
 * continue web handler as they both deal with exactly the same
 * events
 * LY29
 * LY30
 *
 ********************************************************/
public class PolicyRiskSaveWebHandler extends WebHandler {

  ModelManager mm;

  public void doStart(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    // Get handle to the PolicyRiskDetails model.
   PolicyRiskDetailsModel policy = mm.getPolicyRiskDetailsModel();

    // Extract the values out of the request object.
    String polCertQualifier     = request.getParameter("polCertQualifier");
    String interest             = request.getParameter("interest");
    String perilsCondition      = request.getParameter("perilsCondition");
    String polCertPeriodFromHF  = request.getParameter("polCertPeriodFromHF");
    String peerReview           = request.getParameter("peerReview");
    String riskCode             = request.getParameter("riskCode");
    // CCN# N0030 - BA - 06/01/2002
    String marketCode           = request.getParameter("marketCode") ;
    String coverLineslipToyyyy  = request.getParameter("coverLineslipToyyyy");
    String polCertPeriodFromyyyy = request.getParameter("polCertPeriodFromyyyy");
    String coverLineslipToHF = request.getParameter("coverLineslipToHF");
    String sumInsuredNarrative2 = request.getParameter("sumInsuredNarrative2");
    String sumInsuredNarrative1 = request.getParameter("sumInsuredNarrative1");
    String coverLineslipFromyyyy = request.getParameter("coverLineslipFromyyyy");
    String polCertPeriodTomm = request.getParameter("polCertPeriodTomm");
    String polCertPeriodToyyyy = request.getParameter("polCertPeriodToyyyy");
    String polCertPeriodTodd =  request.getParameter("polCertPeriodTodd");
    String coverLineslipFrommm = request.getParameter("coverLineslipFrommm");
    String coverLineslipFromdd = request.getParameter("coverLineslipFromdd");
    String policyPeriodNarrative = request.getParameter("policyPeriodNarrative");
    String slipOrder2   = request.getParameter("slipOrder2");
    String slipOrder1   = request.getParameter("slipOrder1");
    String umr          = request.getParameter("umrumrb") + request.getParameter("umrumrbn") + request.getParameter("umrumranum");
    Logger.debug(this, "umr = " + umr);
    String polCertPeriodFrommm = request.getParameter("polCertPeriodFrommm");
    String coverLineslipQualifier = request.getParameter("coverLineslipQualifier");
    String polCertPeriodFromdd = request.getParameter("polCertPeriodFromdd");
    String yoa          = request.getParameter("yoa");
    String basisOfLimit         = request.getParameter("basisOfLimit");
    String coverLineslipTomm =request.getParameter("coverLineslipTomm");
    String coverLineslipTodd =request.getParameter("coverLineslipTodd");
    String locationVoyageOfRisk = request.getParameter("locationVoyageOfRisk");
    String polCertPeriodToHF = request.getParameter("polCertPeriodToHF");
    String currentBkr = request.getParameter("currentBkr");
    String coverLineslipFromHF = request.getParameter("coverLineslipFromHF");
    String warInd = checkboxValue(request.getParameter("warInd"));
    String slipType = request.getParameter("slipType");
    // The umrLids will have been stashed from the execution of LY94- this is stored in the
    // getClaimTransactionCreationModel model-
    String umrLids =  mm.getClaimTransactionCreationModel().getUmr();

    // Now extract the data which we need to throw into a String array of 3 values each.
    String[] arrayExcess      = new String[3];
    String[] arraylimits      = new String[3];
    String[] arrayCcyOfLimits = new String[3];
    // don't really need to reinitialise- but will we always have 3 sets of data coming back?
    // Even then the fields should be blank.
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

    // We have all the data now create vector- add Event29 to it and return it.
    Vector v = new Vector();

    /**
     * Fire a validation event
     */
    // Fire off the validation here........
    v.add(new LY29Event(peerReview,
                        currentBkr,
                        riskCode,
                        marketCode, /* CCN# N0030 - BA - 06/01/2002 */
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

    // fire off the database update here........
    // NOTE: I'M ASSUMING THAT WE WILL BE ABLE TO CAPTURE THE ERRORS FROM THE VALIDATION
    // (FROM CICS) AT SOME POINT.

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
                            marketCode, /* CCN# N0030 - BA - 06/01/2002 */
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
                            umr /* CCN# N0039 - BA - 06/01/2002 */
                            ));

   v.add(new LY28Event());

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}