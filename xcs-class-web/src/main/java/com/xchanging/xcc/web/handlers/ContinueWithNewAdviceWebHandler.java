package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LZ01Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.OsndSearchResultsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ContinueWithNewAdviceWebHandler extends WebHandler {

  private String osnd = "";
  private String apsnd = "";

  public void doStart(HttpServletRequest request) {
    ModelManager modelManager = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    modelManager.getClaimTransactionCreationModel();
    modelManager.getNavigationBar();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    OsndSearchResultsModel osndModel = (OsndSearchResultsModel)request.getSession().getAttribute(Keys.OsndSearchResultsModelKey);

    Vector v = new Vector();

    v.add(new LZ01Event(osndModel.getOsnd(),osndModel.getApsnd()));
    v.add(new LY12Event("SCR009"));
    v.add(new LZ02Event());
    v.add(new LY13Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}