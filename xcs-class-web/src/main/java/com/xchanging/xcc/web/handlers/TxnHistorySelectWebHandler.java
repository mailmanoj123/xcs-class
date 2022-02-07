package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.TransactionHistoryModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class TxnHistorySelectWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getNavigationBar();
    mm.getClaimTransactionCreationModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    TransactionHistoryModel txnHistory = mm.getTransactionHistoryModel();

    int i = Integer.parseInt(request.getParameter("txn"));
    TransactionHistoryModel.TransactionHistory txn = txnHistory.getTransaction(i);

    Vector v = new Vector();
    v.add(new LY10Event(txn.getsysRef(),"","","","","SCR025"));
    v.add(new LY12Event("SCR009"));
    v.add(new LZ02Event());
    v.add(new LY13Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}