package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY65Event;
import com.xchanging.xcc.events.LY99Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.BulkComponentSelectionModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class BulkCompSelectRefreshWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getQuestionModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    BulkComponentSelectionModel bulkSelection = mm.getBulkComponentSelectionModel();

    String[] compSysRefs = new String[bulkSelection.getNoOfItems()];
    String[] includeInds = new String[bulkSelection.getNoOfItems()];

    for (int i=0; i<compSysRefs.length; i++) {

      compSysRefs[i] = bulkSelection.getItem(i).getCompSysRef();
      includeInds[i] = checkboxValue(request.getParameter("item" + (i+1)));
    }


    Vector v = new Vector();
    v.add(new LY99Event(compSysRefs,includeInds));
    v.add(new LY65Event(false,"","","","","","","","R"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}