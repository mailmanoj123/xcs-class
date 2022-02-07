package com.xchanging.xcc.events;

public class LZ50Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String function;
  private String savedFlag;
  private String headerBusClass;
  private String prevPressed;
  private String nextPressed;
  private String[] rowNumber;
  private String[] processFlag;
  private String[] flagChangedInd;
  private String prevAttr;
  private String nextAttr;
  private String autoAttr;
  private String commercialAttr;
  private String residentialAttr;
  private String firstRow;
  private String lastRow;
  private String totalRows;
  // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
  private String reprocTotal;
  private String xcsTotal;
 
  
  /* 26/04/04 changes for S456/S457. Patrick Cogan
  private String deleteTotal;
  private String rejectTotal;
  private String indivTotal;
  private String blockTotal;
  private String zerosTotal;
  */

  public LZ50Event(  String function,
                     String savedFlag,
                     String headerBusClass,
                     String prevPressed,
                     String nextPressed,
                     String[] rowNumber,
                     String[] processFlag,
                     String[] flagChangedInd,
                     String prevAttr,
                     String nextAttr,
                     String autoAttr,
                     String commercialAttr,
                     String residentialAttr,
                     String firstRow,
                     String lastRow,
                     String totalRows,
                     
                     String reprocTotal,
                     String xcsTotal
                     ) {

    this.function = function;
    this.savedFlag = savedFlag;
    this.headerBusClass = headerBusClass;
    this.prevPressed = prevPressed;
    this.nextPressed = nextPressed;
    this.rowNumber = rowNumber;
    this.processFlag = processFlag;
    this.flagChangedInd = flagChangedInd;
    this.prevAttr = prevAttr;
    this.nextAttr = nextAttr;
    this.autoAttr = autoAttr;
    this.commercialAttr = commercialAttr;
    this.residentialAttr = residentialAttr;
    this.firstRow = firstRow;
    this.lastRow = lastRow;
    this.totalRows = totalRows;
    this.reprocTotal = reprocTotal;
    this.xcsTotal = xcsTotal;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LZ50Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LZ50CICSHandler";
  }


  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String[] getFlagChangedInd() {
    return flagChangedInd;
  }

  public String getNextPressed() {
    return nextPressed;
  }

  public String getPrevPressed() {
    return prevPressed;
  }

  public String[] getProcessFlag() {
    return processFlag;
  }

  public String[] getRowNumber() {
    return rowNumber;
  }

  public String getFunction() {
    return function;
  }

  public String getFirstRow() {
    return firstRow;
  }

  public String getLastRow() {
    return lastRow;
  }

  public String getTotalRows() {
    return totalRows;
  }

  /* 26/04/04 changes for S456/S457. Patrick Cogan
  public String getDeleteTotal() {
    return deleteTotal;
  }

  public String getRejectTotal() {
    return rejectTotal;
  }

  public String getIndivTotal() {
    return indivTotal;
  }

  public String getBlockTotal() {
    return blockTotal;
  }

  public String getZerosTotal() {
    return zerosTotal;
  }
*/
  
  public String getSavedFlag() {
    return savedFlag;
  }

  public String getHeaderBusClass() {
    return headerBusClass;
  }

  public String getPrevAttr() {
    return prevAttr;
  }

  public String getNextAttr() {
    return nextAttr;
  }

  public String getAutoAttr() {
    return autoAttr;
  }

  public String getCommercialAttr() {
    return commercialAttr;
  }

  public String getResidentialAttr() {
    return residentialAttr;
  }
/**
 * @return Returns the reprocTotal.
 */
public String getReprocTotal() {
    return reprocTotal;
}
/**
 * @return Returns the xcsTotal.
 */
public String getXcsTotal() {
    return xcsTotal;
}
}
