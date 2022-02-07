package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY31Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.PolicyRiskDetailsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class PolicyRiskContFlowHandler extends FlowHandler {

  public PolicyRiskContFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
        session = request.getSession();
  }
  /************************************************************
  processFlow:
  Re-direction to the Market Details Screen requires the following calls:
          LY11
          LY12
          LY31

  ************************************************************/
  public String processFlow(HttpServletRequest request) {

    // Get handle to the ModelManager and then retrieve the PolicyRiskDetails model.
   ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
   PolicyRiskDetailsModel policy = mm.getPolicyRiskDetailsModel();

   // place the MarketDetailsModel into the session...if it is not already there.
   mm.getMarketDetailsModel();

   // Now check that the PolicyRiskDetails Model errors flag is not true.
   // NOTE: WHAT DO WE DO WHERE THERE ARE ERRORS?????
   if (!(policy.geterrorsInModel())){
     Vector list = new Vector(3);

     // Now add the LY11, LY12 and LY31 events to the list.......
     list.add(new LY11Event("SCR012", "","N"));
     list.add(new LY12Event("SCR013"));
     list.add(new LY31Event());
     fireEvents(list);

   }
   else
   {
     // NOTE:
     // The processing to handle any errors coming back from the original validation
     // would be placed here.
   }
   // WHEN THE ERRORS ARE PUT IN WE'LL DELETE THIS.
   // If we do get back to here just return 1 for the moment.
   // when we've fired all the events send the user to the market details screen.
     return "1";
 }
  public void doEnd(HttpServletRequest request) {

  }

}