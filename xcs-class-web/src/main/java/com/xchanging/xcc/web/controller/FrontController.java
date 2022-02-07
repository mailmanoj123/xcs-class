package com.xchanging.xcc.web.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.UserWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;
import com.xchanging.xcc.web.screens.manager.ScreenManager;
import com.xchanging.xcc.xml.XMLProcessor;
import com.xchanging.xcc.xml.mappings.RequestMapping;


public class FrontController extends HttpServlet {

  private HashMap requestMap;
  private HashMap screenMap;
  private HashMap exceptionMap;

  private RequestMapping requestMapping;

  public void init() throws ServletException {

    String requestMappingsURL = null;
    String screenDefsURL = null;
    String version = "";
    String phonenumber="";
    String maxexpertlimit = "";
    
    try {
      Properties versionProps = new Properties();
      versionProps.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/properties/version.properties")));
      version = "v" + versionProps.getProperty("version");
    } catch (Exception e) {
      Logger.error("Unable to load version properties file " + e);
    }

    try {
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/properties/xcsclass.properties")));
        phonenumber = appProps.getProperty("phonenumber");
        maxexpertlimit = appProps.getProperty("maxexpertlimit");
    } catch (Exception e) {
        Logger.error("Unable to load xcsclass properties file " + e);
      }
    
    try {
      requestMappingsURL = getServletContext().getResource("/xml/requestmap.xml").toString();
      screenDefsURL = getServletContext().getResource("/xml/screendefs.xml").toString();
    }
    catch (java.net.MalformedURLException ex) {
      Logger.error("Unable to load Claims XML file: " + ex );
    }

    requestMap = XMLProcessor.loadRequestMappings(requestMappingsURL);
    exceptionMap = XMLProcessor.getExceptionMappings(requestMappingsURL);
    screenMap = XMLProcessor.loadScreenDefinitions(screenDefsURL);

    getServletContext().setAttribute(Keys.RequestMappingsKey, requestMap);
    getServletContext().setAttribute(Keys.ExceptionMappingsKey, exceptionMap);
    getServletContext().setAttribute(Keys.ScreenMappingsKey, screenMap);
    //getServletContext().setAttribute(Keys.RefDataKey, new RefDAO(getServletContext()));
    getServletContext().setAttribute(Keys.VersionNoKey, version);
    getServletContext().setAttribute(Keys.PhoneNoKey, phonenumber);
    getServletContext().setAttribute(Keys.MaxExpertLimit, maxexpertlimit);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse  response) throws IOException, ServletException {
    doGet(request,response);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String selectedURL = request.getPathInfo();
    HttpSession session = request.getSession();
    requestMapping = getRequestMapping(selectedURL);

    if (Keys.getWebAppPath() == null) {
      String path = request.getPathTranslated();
      if (path!=null)path = path.replace('\\','/');
      Keys.setWebAppPath(path.substring(0,path.indexOf(request.getPathInfo())));
    }

    ModelManager modelManager = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    if ( modelManager == null ) {
      modelManager = new ModelManager();
      session.setAttribute(Keys.ModelManagerKey, modelManager);
      modelManager.init(getServletContext(), session);
    }

    UserWebModel user = modelManager.getUserWebModel();
    if ((user.getUsername()==null) && (request.getParameter("primarySession")!=null) && (request.getParameter("primarySession").equals("false"))) {
      user.populate(request);
    }
    Logger.info("User Id: " + user.getUsername());
    //Logger.log("Primary Session: " + request.getParameter("primarySession"));
    //Logger.log("Session Id: " + request.getSession().getId());

    if (requestMap.containsKey(selectedURL)) {

      /*
        Add the LY11 NextScreenModel to the session
      */
      modelManager.getNextScreenModel();
      if ((requestMapping != null) && requestMapping.requiresSignin()) {
        if (user.isLoggedIn()) {
          doProcess(request);
        }
        else {
          String loginScreen = getScreenManager(session).getLoginScreen();
          session.setAttribute(Keys.ScreenKey, loginScreen);
        }
      }
      else {
        if (user.isLoggedIn() | requestMapping.getURL().equals("/login") | requestMapping.getURL().equals("/logoff") | requestMapping.getURL().equals("/errorok") | requestMapping.getURL().equals("/changePassword")) {
          doProcess(request);
        }
      }
    }

    String template = getScreenManager(session).getTemplate(session);
    getServletContext().getRequestDispatcher(template).forward(request,response);

    if (requestMapping.getURL().equals("/logoff")) 
    {
        if (!user.isLoggedIn()) 
        {
            //modelManager.getCCEJB().remove();
            
            /*Memory Leakage CR*/
            if(modelManager!=null && modelManager.getCCWeb()!=null && modelManager.getCCWeb().getStateMachine()!=null)
            {
                modelManager.getCCWeb().getStateMachine().closeConnection();
            }
            
            session.invalidate();
            System.gc();
        }
    }
    
  }

  private void doProcess(HttpServletRequest req) throws ServletException {

    HttpSession session = req.getSession();

    try {
      getRequestProcessor(session).processRequest(req);
      RequestMapping requestMapping = getRequestMapping(req.getPathInfo());
      getScreenManager(session).getNextScreen(requestMapping, req);
    }
    catch( Exception e ) {
      if (e instanceof ClaimsWarningException) {
        Logger.warn(e);
        session.setAttribute("WARNING_EVENT",session.getAttribute(Keys.WebEventKey));
        RequestProcessor rp = (RequestProcessor)session.getAttribute(Keys.RequestProcessorKey);
        rp.setPassedWarning(false);
      }

      if (e instanceof GeneralFailureException) {
        Logger.error(e);
        GeneralFailureException gfe = (GeneralFailureException)e;
        if (gfe.getClaimException() instanceof ClaimsErrorException) {
          e = (Exception)gfe.getClaimException();
        }
        else if (gfe.getClaimException() instanceof ClaimsWarningException) {
          session.setAttribute("WARNING_EVENT",session.getAttribute(Keys.WebEventKey));
          RequestProcessor rp = (RequestProcessor)session.getAttribute(Keys.RequestProcessorKey);
          rp.setPassedWarning(false);
          e = (Exception)gfe.getClaimException();
        }
        else if (gfe.getClaimException() == null) {
          e = (Exception)gfe;
        }
        else {
          e = (Exception)gfe.getClaimException();
        }
      }

      String className = e.getClass().getName();
      String exceptionScreen = getScreenManager(session).getExceptionScreen(className,exceptionMap);

      if (exceptionScreen == null) {
        exceptionScreen = "SYSTEM_ERROR_SCREEN";
      }
      req.setAttribute("javax.servlet.jsp.jspException", e);
      req.getSession().setAttribute(Keys.ScreenKey, exceptionScreen);
    }
  }

  private RequestMapping getRequestMapping(String urlPattern) {
    if ((requestMap != null) && requestMap.containsKey(urlPattern)) {
      return (RequestMapping)requestMap.get(urlPattern);
    }
    else {
      return null;
    }
  }

  private RequestProcessor getRequestProcessor(HttpSession session) {
    RequestProcessor rp = (RequestProcessor)session.getAttribute(Keys.RequestProcessorKey);
    if ( rp == null ) {
      rp = new RequestProcessor();
      rp.init(requestMap);
      session.setAttribute(Keys.RequestProcessorKey, rp);
    }
    return rp;
  }

  private ScreenManager getScreenManager(HttpSession session) {

    ScreenManager screenManager = (ScreenManager)session.getAttribute(Keys.ScreenManagerKey);

    if (screenManager == null ) {
      screenManager = new ScreenManager();
      session.setAttribute(Keys.ScreenManagerKey, screenManager);
    }
    return screenManager;
  }

}