package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.TransactionHistoryModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class TxnHistoryNextCcyWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    TransactionHistoryModel txnHistory = mm.getTransactionHistoryModel();

    txnHistory.next();

    Vector v = new Vector();
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}