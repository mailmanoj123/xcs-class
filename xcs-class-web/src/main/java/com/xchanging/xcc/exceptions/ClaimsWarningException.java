package com.xchanging.xcc.exceptions;

import java.util.Enumeration;

public class ClaimsWarningException extends ClaimsEventException {

  private Enumeration warnings;

  public ClaimsWarningException(Enumeration warnings) {
    this.warnings = warnings;
  }

  public Enumeration getWarnings() {
    return warnings;
  }

}