package com.xchanging.xcc.beans;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    ClaimsController.java
 * Date:    September 2002
 * Version: 1.0
 *
 * Author:  Dave Houlden
 *          Steria UK
 *
 * Description: Remote (Object) interface for the ClaimsControllerEJB Session
 * Bean.
 *
 * Modification History
 * --------------------
 * Author:
 * Date:
 * Description:
 *
 */

import java.util.Collection;

import javax.ejb.EJBObject;

import com.xchanging.xcc.events.ClaimsEvent;

public interface ClaimsController extends EJBObject {
  public Collection handleEvent(ClaimsEvent ce) throws Exception;
}