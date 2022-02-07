package com.xchanging.xcc.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.exceptions.ClaimsError;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.refdata.RefDataChecker;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.handlers.WebHandler;
import com.xchanging.xcc.web.models.UserWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;
import com.xchanging.xcc.xml.mappings.RequestMapping;

public class RequestProcessor {

  private HashMap requestMaps;
  private ModelManager mm;
  private HttpServletRequest request;
  private boolean passedWarning = false;

  public void init(HashMap requestMaps) {
    this.requestMaps = requestMaps;
  }

  public void processEvents(Vector list) throws Exception {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    ClaimsControllerWeb ccWeb = (ClaimsControllerWeb)request.getSession().getAttribute(Keys.WebControllerKey);
    if (ccWeb == null) {
      ccWeb = new ClaimsControllerWeb(request.getSession());
      mm.setCCWeb(ccWeb);
      request.getSession().setAttribute(Keys.WebControllerKey, ccWeb);
    }

    Iterator it = list.iterator();
    UserWebModel user = (UserWebModel)request.getSession().getAttribute(Keys.UserWebModelKey);

    while (it.hasNext()) {

      ClaimsEvent event = (ClaimsEvent)it.next();

       if (user.updateMode() || ((event.getType()!=ClaimsEvent.UPDATE) && (event.getType()!=ClaimsEvent.VALIDATE))) {

         if ((!passedWarning) && (request.getParameter("ignoreWarnings")!=null) ) {
           com.xchanging.xcc.cics.handlers.CICSHandler.ignoreWarnings = true;
           passedWarning = false;
         }
         else {
           com.xchanging.xcc.cics.handlers.CICSHandler.ignoreWarnings = false;
           request.getSession().removeAttribute("WARNING_EVENT");
         }

         String sessionStr;
         if ((request.getParameter("primarySession")!=null) && (request.getParameter("primarySession").equals("false")))
           sessionStr = user.getSecondarySessionNo();
         else
           sessionStr = user.getPrimarySessionNo();

         if ((sessionStr != null) && sessionStr != "") {
           int sessionId = Integer.parseInt(sessionStr);
           event.setUserSession(sessionId);
         }

         if (event != null) {

           ClaimsEvent warningEvent = (ClaimsEvent)request.getSession().getAttribute("WARNING_EVENT");

           if ((warningEvent==null) || (event.getClass().getName().equals(warningEvent.getClass().getName()))) {
             passedWarning = true;
           }

           if ((warningEvent==null) || (passedWarning)) {
             event.setHttpSession(request.getSession());
             event.update();
             request.getSession().setAttribute(Keys.WebEventKey,event);
             //Collection webModelList = ccWeb.handleEvent(event);
             Collection webModelList = ccWeb.handleNonEjbEvent(event);
             ArrayList tempList = (ArrayList)webModelList;
             request.getSession().setAttribute(Keys.CicsDataKey,tempList.get(0));
             tempList.remove(0);
            mm.notifyListeners(tempList);
          }
        }
      }
    }
  }

  public void processRequest(HttpServletRequest request) throws Exception {
    String selectedUrl = request.getPathInfo();
    WebHandler handler = getHandler(selectedUrl);
    this.request = request;
    UserWebModel user = (UserWebModel)request.getSession().getAttribute(Keys.UserWebModelKey);

    /*
     * Temporary fix to throw error when data warehouse button clicked
     */
    if (request.getPathInfo().equals("/datawarehouse")) {
      Vector errors = new Vector(1);
      errors.add(new ClaimsError("G009","DATA WAREHOUSE NOT AVAILABLE",""));
      throw new ClaimsErrorException(errors.elements());
    }

    if (request.getPathInfo().equals("/accountenquiry")) {
      Vector errors = new Vector(1);
      errors.add(new ClaimsError("G011","ACCOUNT ENQUIRY NOT AVAILABLE",""));
      throw new ClaimsErrorException(errors.elements());
    }

    if (request.getPathInfo().equals("/repository")) {
      Vector errors = new Vector(1);
      errors.add(new ClaimsError("G012","REPOSITORY NOT AVAILABLE",""));
      throw new ClaimsErrorException(errors.elements());
    }

    if ((request.getParameter("username")==null) && (!user.getScreenMode().equalsIgnoreCase("E"))) {
      Enumeration e = RefDataChecker.checkRefData(request);
      if (e.hasMoreElements())
        throw new ClaimsErrorException(e);
    }

    if (handler != null) {
      handler.doStart(request);
      Vector list = handler.processRequest(request);

      request.getSession().setAttribute(Keys.WebEventList,list);

      processEvents(list);

      handler.doEnd(request);
    }
  }

  private WebHandler getHandler(String selectedUrl) {
    WebHandler handler = null;
    RequestMapping requestMapping = getRequestMapping(selectedUrl);
    String webHandlerString = null;
    if (requestMapping != null) {
      webHandlerString = requestMapping.getWebHandler();
      if (requestMapping.useWebHandler()) {
        try {
          handler = (WebHandler)getClass().getClassLoader().loadClass(webHandlerString).newInstance();
        }
        catch (Exception ex) {
          Logger.error("RequestProcessor caught loading handler: " + ex);
        }
      }
    }
    return handler;
  }

  private RequestMapping getRequestMapping(String urlPattern) {
    if ((requestMaps != null) && requestMaps.containsKey(urlPattern)) {
      return (RequestMapping)requestMaps.get(urlPattern);
    }
    else {
      return null;
    }
  }

  public void setPassedWarning(boolean passedWarning) {
    this.passedWarning = passedWarning;
  }
}
