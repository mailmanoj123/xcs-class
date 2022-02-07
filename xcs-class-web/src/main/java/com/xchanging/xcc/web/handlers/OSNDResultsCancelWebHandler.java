package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.OsndSearchResultsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class OSNDResultsCancelWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    OsndSearchResultsModel osndResults = mm.getOsndSearchResultsModel();

    Vector v = new Vector();
    v.add(new LY11Event("SCR006","","Y"));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}