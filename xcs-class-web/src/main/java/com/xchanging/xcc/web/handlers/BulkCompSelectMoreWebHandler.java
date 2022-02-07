package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ09Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.BulkComponentSelectionModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkCompSelectMoreWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  private String checkBoxStatus(String str) {
    if (str.equals("N")) {
      return "";
    }
    else {
      return "CHECKED";
    }
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    BulkComponentSelectionModel bulkSelection = mm.getBulkComponentSelectionModel();

    // Store the check box states for the include indicators.
    // The form will be reloaded from the model when SCR023 is rebuilt.
    // The check box states are stored in the model so that any selection made
    // is not lost.
    String[] compSysRefs = new String[bulkSelection.getNoOfItems()];
    for (int i=0; i<compSysRefs.length; i++) {
      ((BulkComponentSelectionModel.BulkSettlementItem)bulkSelection.getItem(i)).setInclude(checkBoxStatus(checkboxValue(request.getParameter("item" + (i+1)))));
    }

    int lastOne = bulkSelection.getNoOfItems() - 1;
    BulkComponentSelectionModel.BulkSettlementItem item = bulkSelection.getItem(lastOne);

    Vector v = new Vector();

    // LZ09 Data
    String compSysRef = request.getParameter("compSysRef");
    BulkComponentSelectionModel.BulkSettlementItem detailItem = bulkSelection.getItem(compSysRef);
    if (detailItem.showMore()) {
      detailItem.clearBreakdownDetails();
      bulkSelection.setItem(compSysRef,detailItem);
    } else {
      v.add(new LZ09Event(compSysRef));
    }

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}