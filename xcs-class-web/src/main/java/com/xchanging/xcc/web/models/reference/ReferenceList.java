package com.xchanging.xcc.web.models.reference;

import java.util.Arrays;
import java.util.Vector;

public abstract class ReferenceList {

  public abstract void sort();

  protected Vector doSort(Vector v) {
    Object[] vals = v.toArray();

    Arrays.sort(vals);

    v = new Vector(vals.length);
    for (int i=0; i<vals.length; i++) {
      v.add(i,vals[i]);
    }

    return v;
  }
}