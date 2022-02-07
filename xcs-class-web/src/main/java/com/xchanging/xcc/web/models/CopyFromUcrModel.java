package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

// NOTE:
//  LY24 is called immediately prior to the showing of the
//  "CopyFromUCR Screen"- it contains no data.
//  When the user enters data (the UCR and TR) then we will stash the details
//  into this model from LY84
//

public class CopyFromUcrModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String ucr = "";
  private String tr = "";

  public CopyFromUcrModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.CopyFromUcrModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    ucr = (String) results.get(Keys.LY84_UCR);
    tr  = (String) results.get(Keys.LY84_TR);

  }

  public String getUcr() {
    return ucr;
  }

  public String getTr() {
    return tr;
  }
}