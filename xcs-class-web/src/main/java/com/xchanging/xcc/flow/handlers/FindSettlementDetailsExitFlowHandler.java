package com.xchanging.xcc.flow.handlers;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.FindSettlementSearchResultsDetailsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindSettlementDetailsExitFlowHandler extends FlowHandler {

  private ModelManager mm;
  private FindSettlementSearchResultsDetailsModel srm;

  public FindSettlementDetailsExitFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    srm = mm.getFindSettlementSearchDetailResults();

    // The m/f results will tell us whether we go back to screen scr042 or screen scr043
    if (srm.getC117_NEXT_PROGRAM().equals("SCR042")) {
      return "2";
    } else {
      return "1";
    }

  }

  public void doEnd(HttpServletRequest request) {

  }

}

