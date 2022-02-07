package com.xchanging.xcc.web.controller;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import com.xchanging.xcc.beans.ClaimsController;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ClaimsControllerWeb {

  private HttpSession session;
  private ClaimsController ccEjb;

  private StateMachine sm;

  public ClaimsControllerWeb(HttpSession session) {
    this.session = session;
    ModelManager mm = (ModelManager)session.getAttribute(Keys.ModelManagerKey);
    //ccEjb = mm.getCCEJB();
  }

  public synchronized Collection handleNonEjbEvent(ClaimsEvent ce) throws Exception{
    if (sm == null) {
      this.sm = new StateMachine();
    }
    return sm.handleEvent(ce);
  }


  public synchronized Collection handleEvent(ClaimsEvent ce) throws Exception {
    try {
      return ccEjb.handleEvent(ce);
    }
    catch (RemoteException rx) {
      throw new Exception(rx.getMessage());
    }
  }

  public synchronized void remove() {
  }
  
  public StateMachine getStateMachine()
  {
      return this.sm;
  }
}
