package com.xchanging.xcc.web.models.reference;

import java.util.Arrays;
import java.util.Vector;

public abstract class DropdownList  {
  protected Vector values;

  public DropdownValue[] getValues() {
    return (DropdownValue[])values.toArray(new DropdownValue[0]);
  }

  public String getDisplayValue(String value) {
    for (int i=0; i<values.size(); i++) {
      DropdownValue ddValue = (DropdownValue)values.elementAt(i);
      if (ddValue.getValue().equals(value))
        return ddValue.getDisplayValue();
    }
    return "";
  }

  public void sort() {
    Object[] vals = values.toArray();

    Arrays.sort(vals);

    values = new Vector(vals.length);
    for (int i=0; i<vals.length; i++) {
      values.add(i,vals[i]);
    }
  }

  public class DropdownValue implements Comparable {
    private String value;
    private String displayValue;

    public DropdownValue(String value, String displayValue) {
      this.value = value;
      this.displayValue = displayValue;
    }

    public DropdownValue(String value) {
      this.value = value;
      this.displayValue = value;
    }

    public String getDisplayValue() {
      return displayValue;
    }

    public String getValue() {
      return value;
    }

    public int compareTo(Object o) {
      return displayValue.compareTo(((DropdownValue)o).getDisplayValue());
    }
  }
}
