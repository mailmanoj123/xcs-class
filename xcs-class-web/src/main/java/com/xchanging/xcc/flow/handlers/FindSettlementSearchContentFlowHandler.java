package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.FindSettlementSearchResultsDetailsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

/**
 * Added 02/01/2004 STH
 * Flow handler for find settlement details cancel
 */

public class FindSettlementSearchContentFlowHandler extends FlowHandler {

  private ModelManager mm;
  private FindSettlementSearchResultsDetailsModel srm;

  public FindSettlementSearchContentFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    srm = mm.getFindSettlementSearchDetailResults();

    // At the moment we only want to go back to the key screen (1)
       return "1";


  }

  public void doEnd(HttpServletRequest request) {

  }

}



