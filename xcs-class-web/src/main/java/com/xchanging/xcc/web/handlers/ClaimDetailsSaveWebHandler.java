package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY35Event;
import com.xchanging.xcc.events.LY36Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimDetailsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ClaimDetailsSaveWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    ClaimDetailsModel claimDetails = mm.getClaimDetailsModel();

    String dolTo = formatDate(request.getParameter("dolToyyyy"), request.getParameter("dolTomm"), request.getParameter("dolTodd"));
    String dolFrom = formatDate(request.getParameter("dolFromyyyy"), request.getParameter("dolFrommm"), request.getParameter("dolFromdd"));
    String dcmFrom = formatDate(request.getParameter("dcmFromyyyy"),request.getParameter("dcmFrommm"),request.getParameter("dcmFromdd"));
    String dcmTo = formatDate(request.getParameter("dcmToyyyy"),request.getParameter("dcmTomm"),request.getParameter("dcmTodd"));

    String bkrUcr = request.getParameter("bkrUcrpt1") + request.getParameter("bkrUcrpt2") + request.getParameter("bkrUcrpt3");

    String[] certInsNos = new String[] {
            request.getParameter("certInsNo1"),
            request.getParameter("certInsNo2"),
            request.getParameter("certInsNo3"),
            request.getParameter("certInsNo4"),
            request.getParameter("certInsNo5")
          };

    String[] claimNarrative = getNarrative(request.getParameter("claimNarrative"),50,7);

    Vector v = new Vector();
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
                        (request.getParameter("lossDetails")!=null)&&(request.getParameter("lossDetails").equals("true")),
                        certInsNos
                        ));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}