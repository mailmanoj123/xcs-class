package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY65Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class QuestionModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String title = "";
  private String text = "";
  private Vector answers;

  public QuestionModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.QuestionModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    answers = new Vector();

    if (event instanceof LY65Event) {
      title = "Delete Component Confirmation";
      text = "You have deselected one or more previously released bulk components.\n\n" +
             "Are you sure you want to delete these component(s)?";
      String params = "&navbar=" + ((LY65Event)event).ignoreErrors() + "&ucrTrSysRef=" + ((LY65Event)event).getUcrTrSysRef() + "&currNo=" + ((LY65Event)event).getCurrNo() + "&sdnNo=" + ((LY65Event)event).getSdnNo() + "&statSplitNo=" + ((LY65Event)event).getStatSplitNo() + "&breakdownNo=" + ((LY65Event)event).getBreakdownNo() + "&currentScreen=" + ((LY65Event)event).getCurrentScreen() + "&screenId=" + ((LY65Event)event).getScreenId();
      answers.add(new Answer("Yes","/control/deletebulkconf?answer=yes" + params));
      answers.add(new Answer("No","/control/deletebulkconf?answer=no" + params));
    }
  }
  public String getText() {
    return text;
  }
  public String getTitle() {
    return title;
  }
  public Enumeration getAnswers() {
    return answers.elements();
  }

  public class Answer {
    private String text;
    private String target;

    private Answer(String text, String target) {
      this.text = text;
      this.target = target;
    }

    public String getText() {
      return text;
    }
    public String getTarget() {
      return target;
    }
  }
}