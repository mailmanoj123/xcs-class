package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SetDiaryDateModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;
  private String diaryDate;

  public SetDiaryDateModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SetDiaryDateModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    /**
     * Code goes here to process the above MappedRecord
     */
     diaryDate = (String)results.get(Keys.LY85_DIARY_DATE);
  }

  public String getDiaryDate() {
    return diaryDate;
  }
}