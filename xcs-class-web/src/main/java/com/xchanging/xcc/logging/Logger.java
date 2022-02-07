package com.xchanging.xcc.logging;

import org.apache.log4j.PropertyConfigurator;

import com.xchanging.xcc.utils.Keys;

public class Logger {
  private static org.apache.log4j.Logger log;

  private static void init() {
	  if (Keys.getWebAppPath()!=null) {
		  PropertyConfigurator.configure(Keys.getWebAppPath() + "/WEB-INF/properties/log4j.properties");  
	      log = org.apache.log4j.Logger.getLogger("com.xchanging.xcc");
	  }
  }

  public static void debug(Object obj) {
      if (log==null)
        init();
	  if (log!=null)
	    log.debug(obj);
    }

    public static void info(Object obj) {
      if (log==null)
        init();
	  if (log!=null)
	    log.info(obj);
    }

    public static void warn(Object obj) {
      if (log==null)
        init();
	  if (log!=null)
	    log.warn(obj);
    }

    public static void error(Object obj) {
      if (log==null)
        init();
	  if (log!=null)
	    log.error(obj);
    }

    public static void fatal(Object obj) {
      if (log==null)
        init();
	  if (log!=null)
	    log.fatal(obj);
    }
    
    // These below take this object so that we know where the msgs came from.
    // hack for the absolutely crap way the logging has been implemented in this system.
    public static void debug(Object obj, String msg) {
        if (log==null)
          init();
		if (log!=null)
		  log.debug(obj.getClass().getName().substring(17) + ": " + msg);
      }

      public static void info(Object obj, String msg) {
        if (log==null)
          init();
		if (log!=null)
		  log.info(obj.getClass().getName().substring(17) + ": " + msg);
      }

      public static void warn(Object obj, String msg) {
        if (log==null)
          init();
		if (log!=null)
		  log.warn(obj.getClass().getName().substring(17) + ": " + msg);
      }

      public static void error(Object obj, String msg) {
        if (log==null)
          init();
		if (log!=null)
		  log.error(obj.getClass().getName().substring(17) + ": " + msg);
      }

      public static void fatal(Object obj, String msg) {
        if (log==null)
          init();
		if (log!=null)
		  log.fatal(obj.getClass().getName().substring(17) + ": " + msg);
      }
}
