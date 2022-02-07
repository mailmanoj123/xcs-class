package com.xchanging.xcc.events;

public class LY06Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String osnd;
  private String sysRef;
  private String currNo;
  private String sdnNo;
  private String splitNo;
  private String bDownNo;
  private String direction;
  private String prevScreenId = "";

  public LY06Event(String osnd, String prevScreenId) {
    this.osnd = osnd;
    this.prevScreenId = prevScreenId;
  }

  public LY06Event(String osnd,
                   String prevScreenId,
                   String sysRef,
                   String currNo,
                   String sdnNo,
                   String splitNo,
                   String bDownNo,
                   String direction){

    this.osnd = osnd;
    this.prevScreenId = prevScreenId;
    this.sysRef = sysRef;
    this.currNo = currNo;
    this.sdnNo = sdnNo;
    this.splitNo = splitNo;
    this.bDownNo = bDownNo;
    this.direction = direction;
  }

  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LY06Event";
  }

  public int getType() {
    return OTHER;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY06CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }

  public String getOsnd() {
    if (osnd == null) {
      osnd = " ";
    }
    return osnd;
  }

  public String getSysRef() {
    return sysRef;
  }

  public String getCurrNo() {
    return currNo;
  }

  public String getSdnNo() {
    return sdnNo;
  }

  public String getSplitNo() {
    return splitNo;
  }

  public String getBdownNo() {
    return bDownNo;
  }

  public String getDirection() {
    return direction;
  }
  public String getPrevScreenId() {
    return prevScreenId;
  }

}