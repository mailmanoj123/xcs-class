package com.xchanging.xcc.beans;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    ClaimsControllerEJBHome.java
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

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ClaimsControllerEJBHome extends EJBHome {
  public ClaimsController create() throws RemoteException, CreateException;
}