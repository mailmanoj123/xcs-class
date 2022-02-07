package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY41Event;
import com.xchanging.xcc.events.LY42Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SingleClaimLossReservesModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class LossReserveSaveWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
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

    Vector v = new Vector();
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
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}