package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY06Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.utils.Keys;

public class CreateNewAdviceFlowHandler extends FlowHandler {

 public void doStart(HttpServletRequest request) {
   this.session = request.getSession();
 }

 public void doEnd(HttpServletRequest request) {}

 public String processFlow(HttpServletRequest request) {

   String flowStatus = (String)request.getAttribute(Keys.TrasactionFlowKey);

   /**
    * Build the menu bar before opening the CTC
    */
   if (flowStatus.equals("1")) {
     Vector list = new Vector(2);
     list.add(new LY12Event("SCR009"));
     list.add(new LZ02Event());
     list.add(new LY13Event());
     fireEvents(list);
     return "1";
   }
   /**
    * Do an OSDN search before opening the OSDN Search Results Screen
    */
   else {
     Vector list = new Vector(1);
     String osnd = "";
     String osndsssss = request.getParameter("osndsssss");
     String osnddd = request.getParameter("osnddd");
     String osndmm = request.getParameter("osndmm");
     String osndyy = request.getParameter("osndyy");

     if (!osndyy.equals("")) {
       osnd = getCentury(osndyy) + osndyy + osndmm + osnddd + osndsssss;
     }
     list.add(new LY06Event(osnd,"SCR004"));
     fireEvents(list);
     return "2";
   }
 }
}