package com.xchanging.xcc.beans;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    ClaimsControllerEJB.java
 * Date:    September 2002
 * Version: 1.0
 *
 * Author:  Dave Houlden
 *          Steria UK
 *
 * Description: Enterprise Java Bean used to represent the Users session.
 *
 * Modification History
 * --------------------
 * Author:
 * Date:
 * Description:
 *
 */

import java.util.Collection;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;

public class ClaimsControllerEJB implements SessionBean {

  SessionContext sessionContext;
  private StateMachine sm;

  public void ejbCreate() {
    sm = new StateMachine(sessionContext);
  }

  public void ejbRemove() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void setSessionContext(SessionContext sessionContext) {
    this.sessionContext = sessionContext;
  }

  public Collection handleEvent(ClaimsEvent ce) throws Exception {
    return sm.handleEvent(ce);
  }
}