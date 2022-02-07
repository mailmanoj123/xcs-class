package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class NarrativeList extends ReferenceList {

  private Vector narratives;

  public NarrativeList() {
    narratives = new Vector();
  }

  public void setDefaultValue(String code) {
  }

  public void sort() {
    narratives = doSort(narratives);
  }

  public void createNarrative(String code, String text) {
    narratives.add(new Narrative(code, text));
  }

  public Enumeration getNarratives() {
    return narratives.elements();
  }

  public class Narrative extends WebModel implements Comparable {

    private String code;
    private String text;

    public Narrative(String code, String text) {
      this.code = code;
      this.text = text;
    }

    public String getCode() {
      return code;
    }

    public String getText() {
      return text;
    }

    public int compareTo(Object o) {
      return code.compareTo(((Narrative)o).getCode());
    }
  }
}
