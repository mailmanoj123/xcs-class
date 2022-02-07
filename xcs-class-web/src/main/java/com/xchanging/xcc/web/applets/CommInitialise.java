package com.xchanging.xcc.web.applets;

import javax.comm.*;		// Java Communications API - for access to serial port

/**
 * Initialises communications driver
 */
class CommInitialise {

  public CommInitialise() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NullPointerException {
    // Workaround - manually initialise driver
    CommDriver driver = (CommDriver) Class.forName("com.sun.comm.Win32Driver").newInstance();
    driver.initialize();
  }

}