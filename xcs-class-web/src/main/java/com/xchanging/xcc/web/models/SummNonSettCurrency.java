package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;

public class SummNonSettCurrency {

  private String origCcy = "";
  private String osnd = "";

  private Vector collections;

  public SummNonSettCurrency(MappedRecord mp) {
    this.origCcy = (String) mp.get(Keys.LY59_ORIG_CURR_Field);
    this.osnd    = (String) mp.get(Keys.LY59_ORIG_REF_Field);
    Vector v1 = (Vector) mp.get(Keys.LY59_BREAKDOWN_DETS_Table);
    if (v1==null)
      v1 = new Vector(0);

    collections = new Vector(v1.size());
    for (int x=0; x < v1.size(); x++){
      MappedRecord mp1 = (MappedRecord) v1.get(x);
      if (!(mp1.get(Keys.LY59_COR_Field).equals(""))) {
        collections.add(new SummNonSettCollection(mp1));
      }
    }
  }

  public String getOrigCcy() {
    return origCcy;
  }

  public String getOsnd() {
    return osnd;
  }

  public Enumeration getCollections() {
    return collections.elements();
  }

}