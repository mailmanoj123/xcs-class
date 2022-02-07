package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY07Event;
import com.xchanging.xcc.events.LY09Event;
import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Format;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SelectSearchResultWebHandler extends WebHandler{

  public SelectSearchResultWebHandler() {
  }

  ModelManager mm = null;
  public void doStart(HttpServletRequest request) {
      
     mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
     mm.getOsndSearchResultsModel();
     mm.getFindClaimModel();
     mm.getSecurityNotesModel();
     mm.getGroupSearchResultsModel();
     mm.getNavigationBar();
     mm.getClaimTransactionCreationModel();
     mm.getAdvancedSearchModel();
     mm.getFinancialDetailsModel();
     mm.getNextScreenModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    

    String tempCor = request.getParameter("cor");
    String cor = Format.justify('L',tempCor,15);
    mm.getFindClaimModel().setCor("");
    
      Vector v = new Vector();
    
    request.setAttribute(Keys.TrasactionFlowKey,"3");
    v.add(new LY10Event("0","0","0","0","0","SCR045"));
    v.add(new LY07Event("","",cor,"",""));
    v.add(new LY09Event("SCR045"));

   
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}