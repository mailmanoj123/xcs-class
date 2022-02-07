package com.xchanging.xcc.xml.mappings;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    RequestMapping.java
 * Date:    September 2002
 * Version: 1.0
 *
 * Author:  Dave Houlden
 *          Steria UK
 *
 * Description: Object representation of an XML request definition.
 *
 * Modification History
 * --------------------
 * Author:
 * Date:
 * Description:
 *
 */

import java.util.HashMap;

public class RequestMapping {

  private String url;
  private String screen;
  private boolean useWebHandler;
  private boolean useFlowHandler;
  private String webHandler;
  private String flowHandler;
  private HashMap resultMappings;
  private boolean requiresSignin;

  public RequestMapping(  String url,
                          String screen,
                          boolean useWebHandler,
                          boolean useFlowHandler,
                          String webHandler,
                          String flowHandler,
                          HashMap resultMappings,
                          boolean requiresSignin) {
    this.url = url;
    this.flowHandler = flowHandler;
    this.webHandler = webHandler;
    this.useWebHandler = useWebHandler;
    this.useFlowHandler = useFlowHandler ;
    this.resultMappings = resultMappings;
    this.screen = screen;
    this.requiresSignin = requiresSignin;
  }


  public String getURL() {
    return url;
  }

  public String getScreen() {
    return screen;
  }

  public String getWebHandler() {
    return webHandler;
  }

  public String getFlowHandler() {
    return flowHandler;
  }

  public boolean requiresSignin() {
    return requiresSignin;
  }

  public HashMap getResultMappings() {
    return resultMappings;
  }

  public boolean useWebHandler() {
    return useWebHandler;
  }

  public boolean useFlowHandler() {
    return useFlowHandler;
  }

  public String getResultScreen(String key) {
    if (resultMappings != null) {
      return (String)resultMappings.get(key);
    }
    else {
      return null;
    }
  }
}