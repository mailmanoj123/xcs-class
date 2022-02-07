package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class LogoffFlowHandler extends FlowHandler {

 public void doStart(HttpServletRequest request) {}
 public void doEnd(HttpServletRequest request) {}

 public String processFlow(HttpServletRequest request) {

   String close = request.getParameter("closeWindow");

   if ((close!=null) && (close.equals("true")))
     return "2";
   else
     return "1";
 }
}