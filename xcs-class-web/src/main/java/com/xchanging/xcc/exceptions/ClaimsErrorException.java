package com.xchanging.xcc.exceptions;

import java.util.Enumeration;

public class ClaimsErrorException extends ClaimsEventException {

  private Enumeration errors;

  public ClaimsErrorException(Enumeration errors) {
    this.errors = errors;
  }

  public Enumeration getErrors() {
    return errors;
  }
}