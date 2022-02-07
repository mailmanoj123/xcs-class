package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class DiaryListWebModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;
  private Vector entries;

  public DiaryListWebModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.DiaryListWebModelKey, this);
  }

  public Enumeration getEntries() {
    if (entries == null) {
      return new Vector().elements();
    }
    else {
      return entries.elements();
    }
  }

  public void performUpdate() {

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    Vector recordV = (Vector)(results).get(Keys.LY87FieldValuesList);
    if (!(recordV == null)) {
      entries = new Vector(recordV.size());

      boolean hasNext = true;
      int count = 0;

      while (count < recordV.size()) {
        MappedRecord record = (MappedRecord)recordV.get(count);
        entries.add(  new DiaryEntry(
            (String)record.get(Keys.LY87BrokerRef1Field),
            (String)record.get(Keys.LY87LossDateFromField),
            (String)record.get(Keys.LY87LossDateToField),
            (String)record.get(Keys.LY87Name1Field),
            (String)record.get(Keys.LY87Name2Field),
            (String)record.get(Keys.LY87UCRField)));
        count++;
      }
    }
  }
}