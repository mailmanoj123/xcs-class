package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;

public class SummSettCurrency {

  private String currNo = "" ;
  private String sdnNo = "" ;
  private String origCurr = "" ;
  private String settCurr = "" ;
  // JSP already in place that calls getOsnd - hence getter name different to property
  private String origRef = "" ;
  private Vector collections = null ;

  public SummSettCurrency(MappedRecord mrData) {
    currNo = (String)mrData.get(Keys.LY62_CURR_NO_Field) ;
    sdnNo = (String)mrData.get(Keys.LY62_SDN_NO_Field) ;
    origCurr = (String)mrData.get(Keys.LY62_ORIG_CURR_Field) ;
    settCurr = (String)mrData.get(Keys.LY62_SETT_CURR_Field) ;
    origRef = (String)mrData.get(Keys.LY62_ORIG_REF_Field) ;

    Vector vctCollectionDets = (Vector)mrData.get(Keys.LY62_COLLECTION_DETS_Table) ;

    if (vctCollectionDets==null)
      vctCollectionDets = new Vector(0);

    collections = new Vector();
    for (int i = 0; i< vctCollectionDets.size(); i++) {
      SummSettCollection ssc = new SummSettCollection((MappedRecord)vctCollectionDets.get(i));
      if (!ssc.getstatSplitNo().trim().equals("0"))
        collections.add(ssc) ;
      else
        break;
    }
  }

  public String getCurrNo() {
    return currNo;
  }
  public String getSdnNo() {
    return sdnNo;
  }
  public String getOrigCurr() {
    return origCurr;
  }
  public String getSettCurr() {
    return settCurr;
  }
  // JSP already in place that calls getOsnd - hence getter name different to property
  public String getOsnd() {
    return origRef;
  }
  public Enumeration getCollections() {
    if (collections == null) {
      return new Vector().elements();
    }
    else {
      return collections.elements();
    }
  }
}