package com.xchanging.xcc.web.screens.manager;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    ScreenManager.java
 * Date:    September 2002
 * Version: 1.0
 *
 * Author:  Dave Houlden
 *          Steria UK
 *
 * Description: Used to provide details on which screen, template and screen
 * parameters are required to satisfy the users request.
 *
 * Modification History
 * --------------------
 * Author:
 * Date:
 * Description:
 *
 */
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xchanging.xcc.flow.handlers.FlowHandler;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.controller.RequestProcessor;
import com.xchanging.xcc.web.models.manager.ModelManager;
import com.xchanging.xcc.xml.mappings.RequestMapping;
import com.xchanging.xcc.xml.mappings.ScreenMapping;
import com.xchanging.xcc.xml.mappings.ScreenParameter;

public class ScreenManager {

  private HashMap screenMaps;
  private HashMap exceptionMappings;
  private ModelManager mm;

  public ScreenManager() {
    screenMaps = new HashMap();
  }

  public String getLoginScreen() {
    return "LOGIN_SCREEN";
  }

  public String getTemplate(HttpSession session) {

    String screen = (String)session.getAttribute(Keys.ScreenKey);
    /*
      If there is no Screen in the Keys cache then simply throw up
      the Login screen.
    */

    if (screen == null) {
      screen = "CLOSE_WINDOW";
    }

    /*
      Now get the template for the Screen via the ScreenMaps
    */

    if (screenMaps.isEmpty()) {
      screenMaps = (HashMap)session.getServletContext().getAttribute(Keys.ScreenMappingsKey);
    }

    if (screenMaps == null) {
      Logger.fatal("FATAL ERROR: No Screen Definitions in HashMap");
      return null;
    }

    ScreenMapping screenMap = (ScreenMapping)screenMaps.get(screen);
    return screenMap.getTemplate();
  }

  /*
    Called from the JSP template (via the InsertTag class to obtain the
    ScreenParameter object.

    The reason for passing the HttpSession is because this object cannot
    access it any other way.
  */
  public ScreenParameter getScreenParameter(String parameter, HttpSession session) {

    String screen = (String)session.getAttribute(Keys.ScreenKey);

    if (screen == null) {
      screen = "LOGIN_LAUNCH_SCREEN";
    }
    if (screenMaps == null) {
      Logger.fatal("FATAL ERROR: No Screen Definitions in HashMap");
      return null;
    }

    ScreenMapping screenMap = (ScreenMapping)screenMaps.get(screen);
    // Now get the ScreenParameter object requested by the JSP template

    /*
      Now get the ScreenParameter object that was requested by the JSP
      template (via the InsertTag class).
    */
    ScreenParameter screenParam = (ScreenParameter)screenMap.getParameters().get(parameter);
    return screenParam;
  }

  public String getExceptionScreen(String exceptionClassName, HashMap exceptionMappings) {
    return (String)exceptionMappings.get(exceptionClassName);
  }

  /**
   * After the RequestProcessor has done its bit, FrontServlet calls
   * this to work out which screen is dished up next
   */
  public void getNextScreen(RequestMapping requestMapping, HttpServletRequest request) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

    String currentScreen = "";

    if (requestMapping != null) {
      if (!requestMapping.useFlowHandler()) {
        /**
         * If no flow handler is defined, set the currentScreen
         * to be that defined in the requestmappings.xml file
         * for this url
         */
        currentScreen = requestMapping.getScreen();
        request.getSession().setAttribute(Keys.ScreenKey, currentScreen);
        if ((!currentScreen.equals("ERROR_SCREEN")) && (!currentScreen.equals("WARNING_SCREEN")) && (!currentScreen.equals("SCR010")) && (!currentScreen.equals("CLOSE_WINDOW")) && (!currentScreen.equals("SCR032")) && (!currentScreen.equals("SCR031")) && (!currentScreen.equals("BACK")) && (!currentScreen.equals("BACK_TWO")) && (!currentScreen.equals("SCR029"))) {
          request.getSession().setAttribute(Keys.ScreenOkKey, currentScreen);
        }
      }
      else {
        /**
         * We have a flow handler
         */
        FlowHandler handler = null;
        String flowHandlerString = requestMapping.getFlowHandler();
          /**
           * Instantiate the flow handler and invoke doStart(), processFlow(request)
           * and doEnd() on it
           */
          handler = (FlowHandler)getClass().getClassLoader().loadClass(flowHandlerString).newInstance();

          handler.doStart(request);
          String flowResult = handler.processFlow(request);
          handler.doEnd(request);

          RequestProcessor rp = (RequestProcessor)request.getSession().getAttribute(Keys.RequestProcessorKey);
          if (rp!=null) {
            rp.setPassedWarning(false);
            request.getSession().removeAttribute("WARNING_EVENT");
          }


          /**
           *  Get the matching screen from the RequestMapping object
           */
          currentScreen = requestMapping.getResultScreen(flowResult);

        if (currentScreen != null) {
          request.getSession().setAttribute(Keys.ScreenKey, currentScreen);
          if ((!currentScreen.equals("ERROR_SCREEN")) && (!currentScreen.equals("WARNING_SCREEN")) && (!currentScreen.equals("SCR010")) && (!currentScreen.equals("CLOSE_WINDOW")) && (!currentScreen.equals("SCR032")) && (!currentScreen.equals("SCR031")) && (!currentScreen.equals("BACK")) && (!currentScreen.equals("BACK_TWO")) && (!currentScreen.equals("SCR029"))) {
            request.getSession().setAttribute(Keys.ScreenOkKey, currentScreen);
          }
        }
        else {
          /**
           * Opps! - no screen found for that URL
           */
          throw new RuntimeException("Screen not found for " + request.getPathInfo() + ". Result='" + flowResult + "'");
        }
      }
    }
  }
}