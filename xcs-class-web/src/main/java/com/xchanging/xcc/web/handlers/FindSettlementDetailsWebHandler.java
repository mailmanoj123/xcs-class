package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ17Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.FindSettlementSearchResultsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindSettlementDetailsWebHandler extends WebHandler {

  private ModelManager mm;
  private FindSettlementSearchResultsModel fssrdm;

  private String tdn = "";
  private String tdnNo = "";
  private String versionNo = "";

  public FindSettlementDetailsWebHandler() {
  }

  public void doStart(HttpServletRequest request) {
    ModelManager modelManager = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    modelManager.getFindSettlementSearchDetailResults();
    fssrdm = modelManager.getFindSettlementSearchResults();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();

    if (!request.getParameter("C116_TAKE_DOWN_DATE").equals("")) {
      tdn = request.getParameter("C116_TAKE_DOWN_DATE");
      tdnNo = request.getParameter("C116_TAKE_DOWN_NO");
    }
    else {
      // This should never happen- front-end deals with this-
      tdn = "";
      tdnNo = "";
    }
    versionNo = request.getParameter("C116_VERSION_NO");


    v.add(new LZ17Event(tdnNo, tdn, versionNo));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}
