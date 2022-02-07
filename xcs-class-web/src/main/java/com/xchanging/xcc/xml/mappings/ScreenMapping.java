package com.xchanging.xcc.xml.mappings;

/**
 * <p>Description: Object representation of an XML screen definition</p>
 * <p>Date: September 2002</p>
 * <p>Company: Steria UK</p>
 * @author Dave Houlden
 * @version 1.0
 */

import java.util.HashMap;

public class ScreenMapping {

  private String screenName;
  private String template;
  private HashMap parameters;

  public ScreenMapping(String screenName, String template, HashMap parameters) {
    this.screenName = screenName;
    this.template = template;
    this.parameters = parameters;
  }

  /**
   *
   * @return Returns the name of the Claims screen definition to be used
   */
  public String getScreenName() {
    return screenName;
  }

  public String getTemplate() {
    return template;
  }

  public HashMap getParameters() {
    return parameters;
  }}