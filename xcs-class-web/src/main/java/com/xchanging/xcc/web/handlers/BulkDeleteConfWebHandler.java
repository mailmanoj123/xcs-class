package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.events.LY46Event;
import com.xchanging.xcc.events.LY64Event;
import com.xchanging.xcc.events.LY95Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;

public class BulkDeleteConfWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    Vector v = new Vector();

    if ((request.getParameter("answer")!=null) && (request.getParameter("answer").equals("yes"))) {      
      v.add(new LY95Event());

/* PRC Removed to fix SIR 36170
      if ((request.getParameter("navbar")!=null) && (request.getParameter("navbar").equals("true"))) {
      String ucrTrSysRef = request.getParameter("ucrTrSysRef");
      String currNo = request.getParameter("currNo");
      String sdnNo = request.getParameter("sdnNo");
      String statSplitNo = request.getParameter("statSplitNo");
      String breakdownNo = request.getParameter("breakdownNo");
      String returnScreen = request.getParameter("currentScreen");
      String nextScreen = request.getParameter("screenId");

      v.add(new LY46Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,nextScreen));
      v.add(new LY10Event(ucrTrSysRef,currNo,sdnNo,statSplitNo,breakdownNo,"")); */
    } 
    
    /* clintonj 16/06/2004 SIR 36170
     * ELSE statement changed to an IF to ensure that LY64 is always run except
     * if the user has decided to navigate to a differnt screen via the navbar and not a button.
     */    
    
    // clintonj 23/04/2004 SIR 36170
    // Remove the condition if the user leaves the screen via the nav bar.
    // see "Claims Convergence - On-line Func Spec - Process Description (29th March 2004).doc"
    //if ((request.getParameter("navbar")!=null) && (request.getParameter("navbar").equals("false")))      
    v.add(new LY64Event("","","",""));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}

/*
  $Log: BulkDeleteConfWebHandler.java,v $
  Revision 1.7  2004/04/28 12:53:53  clintonj
  Bulk Componet fix. Sir 36170

  Revision 1.6  2004/04/16 09:52:30  clintonj
  SIR 36170
  Code changed to ensure that LY64 is alwasy run, except if the user has
  decided to navigate to a different screen via the navbar.

  Revision 1.5  2004/03/30 16:15:23  coganp
  Fix for SIR 36170
  Changed to add ly64Event, if answer does not == 'yes' regardless of how this is deleted.

  
  
 */

