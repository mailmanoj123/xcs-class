package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.TransactionStatusModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CreateNewClaimFlowHandler extends FlowHandler {

 public void doStart(HttpServletRequest request) {
   this.session = request.getSession();
 }

 public void doEnd(HttpServletRequest request) {
 }

 public String processFlow(HttpServletRequest request) {
   ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
   TransactionStatusModel txnStatus = mm.getTransactionStatusModel();

   if (txnStatus.getProgStatus().equals("5"))
     return "2";
   else {
     Vector v = new Vector(1);
     v.add(new LY10Event("0","0","0","0","0","SCR004"));
     fireEvents(v);

     return "1";
   }
 }
}