package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LogoffEvent;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.TransactionStatusModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ExitFlowHandler extends FlowHandler {

 public void doStart(HttpServletRequest request) {
   this.session = request.getSession();
 }

 public void doEnd(HttpServletRequest request) {
 }

 public String processFlow(HttpServletRequest request) {
   ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
   TransactionStatusModel txnStatus = mm.getTransactionStatusModel();

   if (txnStatus.getProgStatus().equals("5"))
     return "1";
   else {
     Vector v = new Vector(1);
     v.add(new LY11Event((String)request.getSession().getAttribute(Keys.ScreenOkKey),"","Y"));
     fireEvents(v);

     NextScreenModel nextScreen = mm.getNextScreenModel();

     if (nextScreen.getNextScreen().equals("SCR004")) {
       return "5";
     } else if (nextScreen.getNextScreen().equals("SCR005")) {
       return "2";
     } else if (nextScreen.getNextScreen().equals("SCR025")) {
       return "3";
     } else if (nextScreen.getNextScreen().equals("SCR026")) {
       return "4";
     } else if (nextScreen.getNextScreen().equals("NONE")) {
       v = new Vector(1);
       v.add(new LogoffEvent(false));
       fireEvents(v);
       return "6";
     } else if (nextScreen.getNextScreen().equals("SCR007")) {
       return "7";
     } else if (nextScreen.getNextScreen().equals("SCR006")) {
       return "8";
     } else if (nextScreen.getNextScreen().equals("SCR045")) {
       return "9";
     }else //should never happen
       return nextScreen.getNextScreen();
   }
 }
}