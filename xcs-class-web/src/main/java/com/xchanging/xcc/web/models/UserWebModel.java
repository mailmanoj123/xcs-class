package com.xchanging.xcc.web.models;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.ChangePasswordEvent;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.GetDiaryEvent;
import com.xchanging.xcc.events.LoginEvent;
import com.xchanging.xcc.events.LogoffEvent;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class UserWebModel extends WebModel implements ModelUpdateListener {

  private String account;
  private String username;
  private String section;
  private String primarySessionNo;
  private String secondarySessionNo;
  private String screenMode;

  private boolean loggedIn;
  private boolean changePasswordNeeded;

  private boolean schemeCanadaButtonFlag;

  private ModelManager mm;

  public UserWebModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.UserWebModelKey, this);
  }

  public void setUpdateMode(String screenMode) {
    this.screenMode = screenMode;
  }

  public boolean updateMode() {
    if (screenMode==null) {
      if (account==null || ((account.length() == 4) & account.substring(3).equals("U"))) {
        return true;
      }
      else {
        return false;
      }
    } else {
      return screenMode.equals("U");
    }
  }

  public boolean accountCodeIsXCHU() {
    return account.equals("XCHU");
  }

  public boolean isChangePasswordNeeded() {
    return changePasswordNeeded;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public String getAccount() {
    return account;
  }

  public String getUsername() {
    return username;
  }

  public String getSection() {
    return section;
  }

  public void performUpdate() {

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LogoffEvent) {
      if (((LogoffEvent)event).isPrimarySession()) {
        primarySessionNo = null;
        secondarySessionNo = null;
        loggedIn = false;
      } else {
        secondarySessionNo = null;
      }
    }
    else if (event instanceof LoginEvent) {

      String loginStatus = (String)results.get(Keys.LY02LoginStatusField);
      if (loginStatus.equals("Y")) {
        loggedIn = true;
        account = (String)results.get(Keys.LY02AccountCodeField);
        setPrimarySessionNo((String)results.get(Keys.LY02SessionIDField));
      }
      else if (loginStatus.equals("N")) {
        loggedIn = false;
      }
      else if (loginStatus.equals("C")) {
        loggedIn = true;
        changePasswordNeeded = true;
        account = (String)results.get(Keys.LY02AccountCodeField);
        setPrimarySessionNo((String)results.get(Keys.LY02SessionIDField));
      }
    }
    else if (event instanceof ChangePasswordEvent) {
      String loginStatus = (String)results.get(Keys.LY03LoginStatusField);
      if (loginStatus.equals("Y")) {
        loggedIn = true;
        changePasswordNeeded = false;
      }
      else if (loginStatus.equals("C")) {
        changePasswordNeeded = true;
      }
      else {
        loggedIn = false;
      }
    }
    else if (event instanceof GetDiaryEvent) {

      username = "";

      StringTokenizer st = new StringTokenizer((String)results.get(Keys.LY87UsernameField));
      while (st.hasMoreTokens()) {
        String token = st.nextToken().toLowerCase();
        char c = Character.toUpperCase(token.charAt(0));
        username += c + token.substring(1,(token.length())) + " ";
      }

      Vector vCommandAttrs = (Vector)results.get(Keys.LY87CommandAttrsList);
      MappedRecord rCommandAttrs = (MappedRecord)vCommandAttrs.get(0);
      schemeCanadaButtonFlag = convertToBoolean((String)rCommandAttrs.get(Keys.LY87SchemeCanAttr));
    }
  }

  public String getPrimarySessionNo() {
    return primarySessionNo;
  }

  public String getSecondarySessionNo() {
    if (secondarySessionNo==null)
      return primarySessionNo;
    else
      return secondarySessionNo;
  }

  public void setPrimarySessionNo(String sessionNo) {
    primarySessionNo = sessionNo;
  }

  public void setSecondaySessionNo(String sessionNo) {
    secondarySessionNo = sessionNo;
  }

  public boolean hasSecondarySession() {
    return secondarySessionNo != null;
  }

  public void populate(HttpServletRequest request) {
    account = request.getParameter("account");
    username = request.getParameter("username");
    section = request.getParameter("section");
    primarySessionNo = request.getParameter("primarySessionNo");
    secondarySessionNo = request.getParameter("secondarySessionNo").equals(primarySessionNo)?null:request.getParameter("secondarySessionNo");
    screenMode = request.getParameter("screenMode");
    loggedIn = true;
  }
  public String getScreenMode() {
    if (screenMode==null) {
      if ((account!=null) && (account.length()==4) && (account.substring(0,3).equals("XCH"))) {
        return account.substring(3);
      } else
        return "";
    } else
      return screenMode;
  }

  public boolean getSchemeCanadaButtonFlag() {
    return schemeCanadaButtonFlag;
  }

}