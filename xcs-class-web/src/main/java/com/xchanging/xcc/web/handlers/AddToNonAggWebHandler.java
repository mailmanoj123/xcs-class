package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY71Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.GroupEnquiryModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class AddToNonAggWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    GroupEnquiryModel gem = mm.getGroupEnquiryModel();
    mm.getGroupingSessionModel();
    mm.getConfirmationModel();
    gem.reset();

    Vector v = new Vector();
    v.add(new LY71Event("3"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}