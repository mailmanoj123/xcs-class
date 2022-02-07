package com.xchanging.xcc.web.taglib;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    InsertTag.java
 * Date:    September 2002
 * Version: 1.0
 *
 * Author:  Dave Houlden
 *          Steria UK
 *
 * Description: Custom tag implementation used to write screen parameters.
 *
 * Modification History
 * --------------------
 * Author:
 * Date:
 * Description:
 *
 */

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.screens.manager.ScreenManager;
import com.xchanging.xcc.xml.mappings.ScreenParameter;

public class InsertTag extends TagSupport {

  private boolean directInclude = false;
  private String parameter = null;
  private ScreenManager screenManager;
  private ScreenParameter parameterRef = null;

  public InsertTag() {
  }

  public void setParameter(String parameter){
    this.parameter = parameter;
  }

  public int doStartTag() throws JspTagException {

    try {
      pageContext.getOut().flush();
    }
    catch (Exception e){
      Logger.error("InsertTag: Error flushing JSP Writer" + e);
    }

    screenManager = (ScreenManager)pageContext.getSession().getAttribute(Keys.ScreenManagerKey);
    if ((screenManager != null) && (parameter != null)) {
      parameterRef = (ScreenParameter)screenManager.getScreenParameter(parameter, pageContext.getSession());
    }
    else {
      Logger.error("InsertTag: screenManager is null");
    }

    if (parameterRef != null) {
      directInclude = parameterRef.isDirect();
    }

    return SKIP_BODY;
  }

  public int doEndTag() throws JspTagException {
    try {
      if (directInclude && parameterRef != null) {
        pageContext.getOut().print(parameterRef.getValue());
      }
      else {
        if (parameterRef != null) {
          pageContext.getRequest().getRequestDispatcher(parameterRef.getValue()).include(pageContext.getRequest(), pageContext.getResponse());
        }
        else {
          String template = screenManager.getTemplate(pageContext.getSession());
          String screen = (String)pageContext.getSession().getAttribute(Keys.ScreenKey);
          Logger.error("InsertTag: Template " + template + " defines parameter " + parameter + " but screen definition " + screen + " does not have one");
        }
      }
    }
    catch(Exception e) {
      Logger.error("InsertTag: Error writing to JSP Writer" + e);
    }
    return EVAL_PAGE;
  }


}