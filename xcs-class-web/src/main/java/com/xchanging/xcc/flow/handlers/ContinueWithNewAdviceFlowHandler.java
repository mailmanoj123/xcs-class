package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

public class ContinueWithNewAdviceFlowHandler extends FlowHandler {

 public void doStart(HttpServletRequest request) {}
 public void doEnd(HttpServletRequest request) {}

 public String processFlow(HttpServletRequest request) {

   return "1";
 }
}