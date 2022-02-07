package com.xchanging.xcc.exceptions;

public class GeneralFailureException extends RuntimeException {

    private Throwable t;

    public GeneralFailureException(String s) {
      super(s);
    }

    public GeneralFailureException(String s, Throwable t) {
        super(s);
        this.t = t;
    }

    public Throwable getClaimException() {
      return t;
    }

    public String getThrowable() {
        return ("Received throwable with Message: " + t.getMessage());
    }
}