package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY05Event;
import com.xchanging.xcc.events.LZ01Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CreateNewAdviceWebHandler extends WebHandler {

  private String osnd = "";
  private String apsnd = "";
  private ModelManager modelManager;

  public void doStart(HttpServletRequest request) {
    modelManager = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    modelManager.getClaimTransactionCreationModel();
    modelManager.getOsndSearchResultsModel();
    modelManager.getNavigationBar();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    String osndsssss = request.getParameter("osndsssss");
    String osnddd = request.getParameter("osnddd");
    String osndmm = request.getParameter("osndmm");
    String osndyy = request.getParameter("osndyy");

    String apsndsssss = request.getParameter("apsndsssss");
    String apsnddd = request.getParameter("apsnddd");
    String apsndmm = request.getParameter("apsndmm");
    String apsndyy = request.getParameter("apsndyy");

    /**
     * Construct the OSND and APSND fields from the
     * data within the request
     */
    if (!osndyy.equals("")) {
      osnd = getCentury(osndyy) + osndyy + osndmm + osnddd + osndsssss;
    }
    if (!apsndyy.equals("")) {
      apsnd = getCentury(apsndyy) + apsndyy + apsndmm + apsnddd + apsndsssss;
    }

    /**
     * Do a Create Skeleton Claim
     */
    if ((osnd.equals("")) && (apsnd.equals(""))) {

      request.setAttribute(Keys.TrasactionFlowKey,"1");
      v.add(new LZ01Event(" "," "));
    }
    /**
     * Do a Policy Check on LIDS
     */
    else {
      request.setAttribute(Keys.TrasactionFlowKey,"2");
      v.add(new LY05Event(osnd,apsnd));
    }

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}