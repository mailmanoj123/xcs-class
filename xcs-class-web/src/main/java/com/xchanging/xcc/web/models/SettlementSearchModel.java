package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ15Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SettlementSearchModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  // All values are initialised to blank.
  // There are no values to extract from the Mapped Record detailed below.
  private String tdnDate = "";
  private String tdnNo = "";
  private String osndDate = "";
  private String osndNo = "";
  private String yoa = "";
  private String pbkr = "";
  private String name1 = "";
  private String name2 = "";

  private String secondSessionNo;

  public SettlementSearchModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SettSearchScreenModelKey, this);
  }

  public void performUpdate() {

    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LZ15Event) {
      MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

      // First deal with the fact that we need a new mainframe session number for this new window.
      secondSessionNo = (String)results.get(Keys.C114_HCSE_SESSION_NO);
      mm.getUserWebModel().setSecondaySessionNo(secondSessionNo);

      // MappedRecord for the field values table
      MappedRecord mp1 = (MappedRecord) ((Vector) results.get(Keys.C114_SEARCH_FIELDS)).get(0);

      // It should be noted that these values will all be blank- however there
      // is a future requirement that these be included for "future" reasons.
      tdnNo = (String)mp1.get(Keys.C114_TAKE_DOWN_NO);
      tdnDate = (String)mp1.get(Keys.C114_TAKE_DOWN_DATE);
      osndNo = (String)mp1.get(Keys.C114_ORIG_SIGNING_NO);
      osndDate = (String)mp1.get(Keys.C114_ORIG_SIGNING_DATE);
      yoa = (String)mp1.get(Keys.C114_YEAR_OF_ACC);
      pbkr = (String)mp1.get(Keys.C114_PAYEE_BKR);
      name1 = (String)mp1.get(Keys.C114_NAME_1);
      name2 = (String)mp1.get(Keys.C114_NAME_2);

    }

  }
  public String getName1() {
    return name1;
  }
  public String getName2() {
    return name2;
  }
  public String getOsndDate() {
    return osndDate;
  }
  public String getOsndNo() {
    return osndNo;
  }
  public String getPbkr() {
    return pbkr;
  }
  public String getTdnDate() {
    return tdnDate;
  }
  public String getTdnNo() {
    return tdnNo;
  }
  public String getYoa() {
    return yoa;
  }
  public String getSecondSessionNo() {
    return secondSessionNo;
  }
  public void setName1(String name1) {
    this.name1 = name1;
  }
  public void setName2(String name2) {
    this.name2 = name2;
  }
  public void setOsndDate(String osndDate) {
    this.osndDate = osndDate;
  }
  public void setOsndNo(String osndNo) {
    this.osndNo = osndNo;
  }
  public void setPbkr(String pbkr) {
    this.pbkr = pbkr;
  }
  public void setTdnDate(String tdnDate) {
    this.tdnDate = tdnDate;
  }
  public void setTdnNo(String tdnNo) {
    this.tdnNo = tdnNo;
  }
  public void setYoa(String yoa) {
    this.yoa = yoa;
  }


}
