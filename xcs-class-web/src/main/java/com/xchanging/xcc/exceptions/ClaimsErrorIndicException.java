package com.xchanging.xcc.exceptions;

import java.util.Enumeration;

public class ClaimsErrorIndicException extends ClaimsErrorException {

  private String url;

  public String getUrl() {
    return url;
  }

  public ClaimsErrorIndicException(String url, Enumeration errors) {
    super(errors);
    this.url = new String(url);
  }

}