package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;
import java.util.Vector;
import com.xchanging.xcc.events.LZ50Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SchemeCanadaProcessFlowHandler extends FlowHandler {

  private ModelManager mm;
  private SchemeCanadaWebModel scwm;

  public void doStart(HttpServletRequest request) {
    super.session = request.getSession();    // this should be removed - clintonj 26/04/2004
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);    
    scwm = mm.getSchemeCanadaModel();    
  }

  public String processFlow(HttpServletRequest request) {    
     return "1";    
  }

  public void doEnd(HttpServletRequest request) {

  }

}