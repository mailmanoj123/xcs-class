package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.FindClaimModel;
import com.xchanging.xcc.web.models.SecurityNotesModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindClaimSearchFlowHandler extends FlowHandler {

  public FindClaimSearchFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSCMAdviceModel();
    mm.getClaimDetailsModel();
    mm.getVATRatesModel();
    mm.getExpertFeeBreakDownModel();
    mm.getSingleClaimLossReservesModel();
    mm.getMarketsModel();
    mm.getSubsequentAdviceScheduleModel();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    if ((request.getParameter("mode")==null) || (request.getParameter("mode").equals("BASIC"))) {

      String flowStatus = (String)request.getAttribute(Keys.TrasactionFlowKey);

      if (flowStatus.equals("1")) {
        return "2";
      }
      else if (flowStatus.equals("2")) {
        return "3";
      }
      else if (flowStatus.equals("3")) {
        FindClaimModel findClaim = mm.getFindClaimModel();
        SecurityNotesModel securityNotes = mm.getSecurityNotesModel();

        String snProgStatus = securityNotes.getProgStatus();
        String nextProg = findClaim.getLy07NextProg();

        if (snProgStatus.equals("2")) {
          return "5";
        } else if (nextProg.equals("SCR009")) {
          Vector list = new Vector();
          list.add(new LY12Event("SCR009"));
          list.add(new LZ02Event());
          list.add(new LY13Event());
          fireEvents(list);
          return "4";         
        } else if (nextProg.equals("SCR015")) {          
          // clintonj - SIR 36027 - 09/03/2004
          // Added else if to handle navigation problem
          Vector list = new Vector();
          list.add(new LY12Event("SCR015"));
          list.add(new LY37Event());
          fireEvents(list);          
          return "11";
        } else if (nextProg.equals("SCR017")) {
          Vector list = new Vector();
          list.add(new LY12Event("SCR017"));
          list.add(new LY43Event());
          fireEvents(list);
          // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
          // Hence we do a check here to ensure which screen we are directing the user towards.
          // Devo September 2003   CCN s229

          if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
            return "10";
          else
            return "6";

        } else if (nextProg.equals("SCR016")) {
          Vector list = new Vector();
          list.add(new LY12Event("SCR016"));
          list.add(new LY40Event());
          fireEvents(list);

          return "7";
        } else if (nextProg.equals("SCR020")) {
          Vector list = new Vector();
          list.add(new LY12Event("SCR020"));
          list.add(new LY56Event("","",""));
          fireEvents(list);

          return "8";
        }
      }

      // Should never happen
      return "1";
    }
    else {
      return "9"; // Advanced Search Results Screen
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}


/*
 * 
 * $Log: FindClaimSearchFlowHandler.java,v $
 * Revision 1.5  2004/03/25 10:32:39  clintonj
 * clintonj - SIR - 36027
 * Additional fixed to ensure financial details
 * control model is updated when navigating to the SCR015
 *
 * 
 * 
 */