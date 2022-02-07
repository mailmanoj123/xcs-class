package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY38Event;
import com.xchanging.xcc.events.LY39Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.FinancialDetailsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FinancialDetailsCntrContWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSubsequentAdviceScheduleModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    FinancialDetailsModel fdm = mm.getFinancialDetailsModel();

    Vector v = new Vector();

    
    
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
                        
                        /* Removed PREV_AMT_SETT for CCN #41
                        request.getParameter("prevSettled")
                        */
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

    v.add(new LY11Event("SCR015","","N"));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}