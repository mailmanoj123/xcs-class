package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY31Event;
import com.xchanging.xcc.events.LY32Event;
import com.xchanging.xcc.events.LY33Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.MarketDetailsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MarketDetailsSaveWebHandler extends WebHandler {

  private Vector syndicateNos = new Vector();
  private Vector syndicatePercs = new Vector();
  private Vector syndicateRefs = new Vector();
  private Vector bureauLeaders = new Vector();
  private Vector deleteInds = new Vector();
  private String sTotalLine;
  private String sNoSynds;


  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    MarketDetailsModel marketDetails = mm.getMarketDetailsModel();

    sTotalLine = request.getParameter("vTotalAmt");
    sNoSynds   = request.getParameter("vSyndCount");

    int i=1;

    String delInd = checkboxValue(request.getParameter("del" + i));
    String syndNo = request.getParameter("syndicateNo" + i);
    String syndPerc = request.getParameter("syndicatePerc" + i);
    String syndRef = request.getParameter("syndicateRef" + i);
    String burLeader = checkboxValue(request.getParameter("bureauLeader" + i));


    while ((syndNo!=null) && (!syndNo.equals(""))) {
      deleteInds.add(delInd);
      syndicateNos.add(syndNo);
      syndicatePercs.add(syndPerc);
      syndicateRefs.add(syndRef);
      bureauLeaders.add(burLeader);

      i++;
      delInd = checkboxValue(request.getParameter("del" + i));
      syndNo = request.getParameter("syndicateNo" + i);
      syndPerc = request.getParameter("syndicatePerc" + i);
      syndRef = request.getParameter("syndicateRef" + i);
      burLeader = checkboxValue(request.getParameter("bureauLeader" + i));
    }

    i=1;
    delInd = checkboxValue(request.getParameter("delInsert" + i));
    syndNo = request.getParameter("syndicateInsertNo" + i);
    syndPerc = request.getParameter("syndicatePercInsert" + i);
    syndRef = request.getParameter("syndicateRefInsert" + i);
    burLeader = checkboxValue(request.getParameter("bureauLeaderInsert" + i));

    while ((syndNo!=null) && (!syndNo.equals(""))) {
      deleteInds.add(delInd);
      syndicateNos.add(syndNo);
      syndicatePercs.add(syndPerc);
      syndicateRefs.add(syndRef);
      bureauLeaders.add(burLeader);

      i++;
      delInd = checkboxValue(request.getParameter("delInsert" + i));
      syndNo = request.getParameter("syndicateInsertNo" + i);
      syndPerc = request.getParameter("syndicatePercInsert" + i);
      syndRef = request.getParameter("syndicateRefInsert" + i);
      burLeader = checkboxValue(request.getParameter("bureauLeaderInsert" + i));
    }

    // place the vectors into string arrays.
    String[] aDeleteInds = new String[deleteInds.size()];
    String[] aSyndicateNos = new String[syndicateNos.size()];
    String[] aSyndicatePercs = new String[syndicatePercs.size()];
    String[] aSyndicateRefs = new String[syndicateRefs.size()];
    String[] aBureauLeaders = new String[bureauLeaders.size()];

    for(int x = 0; x < syndicateNos.size(); x++){
      aDeleteInds[x] = (String)deleteInds.get(x);
      aSyndicateNos[x] = (String)syndicateNos.get(x);
      aSyndicatePercs[x] = (String)syndicatePercs.get(x);
      aSyndicateRefs[x] = (String)syndicateRefs.get(x);
      aBureauLeaders[x] = (String)bureauLeaders.get(x);
    }

    marketDetails.updateModel(aSyndicateNos, aSyndicatePercs, aSyndicateRefs, aBureauLeaders, aDeleteInds);

    Vector v = new Vector();

    v.add(new LY32Event(sNoSynds,sTotalLine,marketDetails.getMarketSource(), aSyndicateNos, aSyndicatePercs, aSyndicateRefs, aDeleteInds));
    v.add(new LY33Event(sTotalLine, aSyndicateNos, aSyndicatePercs, aSyndicateRefs, aBureauLeaders,aDeleteInds));

    v.add(new LY31Event());

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}