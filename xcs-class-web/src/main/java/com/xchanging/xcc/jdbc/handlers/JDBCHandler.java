package com.xchanging.xcc.jdbc.handlers;

import java.util.HashMap;

import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;

public abstract class JDBCHandler {

  public abstract void perform(ClaimsEvent ce, StateMachine sm);
  public abstract HashMap getResults();

}