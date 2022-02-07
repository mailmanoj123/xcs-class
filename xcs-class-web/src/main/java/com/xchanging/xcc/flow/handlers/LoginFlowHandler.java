package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.GetDiaryEvent;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.UserWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class LoginFlowHandler extends FlowHandler {


 public void doStart(HttpServletRequest request) {
   this.session = request.getSession();
 }


 public void doEnd(HttpServletRequest request) {}

 public String processFlow(HttpServletRequest request){

   ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
   UserWebModel user = mm.getUserWebModel();

   if ((user.isLoggedIn()) && (!user.isChangePasswordNeeded())) {
     Vector list = new Vector(1);
     list.add(new GetDiaryEvent());
     fireEvents(list);
     return "1";  // Display the Home Page
   }

   if (!user.isLoggedIn()) {
     return "2";  // Display the Error page
   }

   if ((user.isLoggedIn()) && (user.isChangePasswordNeeded())) {
     Vector list = new Vector(1);
     list.add(new GetDiaryEvent());
     fireEvents(list);
     return "3";  // Display the Change Password Screen
   }

   return "2";

 }
}