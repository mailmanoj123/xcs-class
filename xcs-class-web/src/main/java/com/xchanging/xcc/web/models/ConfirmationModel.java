package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY14Event;
import com.xchanging.xcc.events.LY15Event;
import com.xchanging.xcc.events.LY78Event;
import com.xchanging.xcc.events.LY79Event;
import com.xchanging.xcc.events.LY92Event;
import com.xchanging.xcc.events.LY96Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ConfirmationModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String title = "";
  private String text = "";
  private String referenceType = "";
  private String reference = "";

  public ConfirmationModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.ConfirmationModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY14Event) {
      title = "Grouping Confirmation";
      text = (String)results.get(Keys.LY14_CONFIRMATION_MSG);
      referenceType = "Group Ref:";
      reference = (String)results.get(Keys.LY14_GROUP_REF);
    } else if (event instanceof LY15Event) {
      title = "Grouping Confirmation";
      text = (String)results.get(Keys.LY15_CONFIRMATION_MSG);
      referenceType = "Group Ref:";
      reference = (String)results.get(Keys.LY15_GROUP_REF);
    } else if (event instanceof LY78Event) {
      title = "Rate of Exchange Adjustment Confirmation";
      text = "The Rate of Exchange Adjustment has been successfully created";
      referenceType = "Transaction Reference:";
      reference = (String)results.get(Keys.LY78_TR);
    } else if (event instanceof LY79Event) {
      title = "Contra Correction Confirmation";
      text = "The Contra Correction has been successfully created";
      referenceType = "Transaction Reference:";
      reference = (String)results.get(Keys.LY79_TR);
    } else if (event instanceof LY92Event) {
      title = "Contra Correction Confirmation";
      text = "The Contra Correction has been successfully created";
      referenceType = "Transaction Reference:";
      reference = (String)results.get(Keys.LY92_TR);
    } else if (event instanceof LY96Event) {
      title = "File Last Seen Confirmation";
      text = "The File Last Seen date has been successfully updated.";
      referenceType = "";
      reference = "";
    }
  }
  public String getReference() {
    return reference;
  }
  public String getReferenceType() {
    return referenceType;
  }
  public String getText() {
    return text;
  }
  public String getTitle() {
    return title;
  }
}