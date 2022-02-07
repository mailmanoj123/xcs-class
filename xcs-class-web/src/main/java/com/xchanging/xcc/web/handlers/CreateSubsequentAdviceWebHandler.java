package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY20Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CreateSubsequentAdviceWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getClaimTransactionCreationModel();

    Vector v = new Vector();
    v.add(new LY20Event("V"));
    v.add(new LY20Event("U"));
    v.add(new LY12Event("SCR009"));
    v.add(new LZ02Event());
    v.add(new LY13Event());
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}