package com.xchanging.xcc.xml.mappings;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ScreenParameter {

  private String key;
  private String value;
  private boolean isDirect;

  public ScreenParameter(String key, String value, boolean isDirect) {
    this.key = key;
    this.value = value;
    this.isDirect = isDirect;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public boolean isDirect() {
    return isDirect;
  }
}
