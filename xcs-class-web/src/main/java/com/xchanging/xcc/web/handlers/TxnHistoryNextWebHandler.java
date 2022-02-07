package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY69Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.TransactionHistoryModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class TxnHistoryNextWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    TransactionHistoryModel txnHistory = mm.getTransactionHistoryModel();

    Vector v = new Vector();
    v.add(new LY69Event("Y","",txnHistory.getTransaction(txnHistory.getNoOfTransactions()-1).getsysRef()));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}