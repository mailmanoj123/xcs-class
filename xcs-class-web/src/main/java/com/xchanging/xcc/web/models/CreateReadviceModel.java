package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ12Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CreateReadviceModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String currentNarrative1 = "" ;
  private String narrativeCode1 = "" ;
  private String currentNarrative2A = "" ;
  private String narrativeCode2 = "" ;
  private String currentNarrative2B = "" ;

  private String currentNarrative1Flag;
  private boolean narrativeCode1Flag;
  private String currentNarrative2AFlag;
  private boolean narrativeCode2Flag;
  private String currentNarrative2BFlag;

  public CreateReadviceModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.CreateReadviceModelKey, this);
  }

  public void performUpdate() {

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LZ12Event) {

      Vector v = (Vector)results.get(Keys.LZ12_FIELD_VALUES) ;
      MappedRecord mrFieldValues = (MappedRecord)v.get(0);

      currentNarrative1 = (String)mrFieldValues.get(Keys.LZ12_CURR_NARR_1) ;
      narrativeCode1 = (String)mrFieldValues.get(Keys.LZ12_NARR_CODE_1) ;
      currentNarrative2A = (String)mrFieldValues.get(Keys.LZ12_CURR_NARR_2A) ;
      narrativeCode2 = (String)mrFieldValues.get(Keys.LZ12_NARR_CODE_2) ;
      currentNarrative2B = (String)mrFieldValues.get(Keys.LZ12_CURR_NARR_2B) ;

      Vector vAttributes = (Vector)results.get(Keys.LZ12_FIELD_ATTRIBUTES);
      MappedRecord mrFieldAttributes = (MappedRecord)vAttributes.get(0);

      currentNarrative1Flag = enabledStatus((String)mrFieldAttributes.get(Keys.LZ12_CURR_NARR_ATTR1)) ;
      narrativeCode1Flag = convertToBoolean((String)mrFieldAttributes.get(Keys.LZ12_NARR_CODE_ATTR1)) ;
      currentNarrative2AFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LZ12_CURR_NARR_ATTR_2A)) ;
      narrativeCode2Flag = convertToBoolean((String)mrFieldAttributes.get(Keys.LZ12_NARR_CODE_ATTR2)) ;
      currentNarrative2BFlag = enabledStatus((String)mrFieldAttributes.get(Keys.LZ12_CURR_NARR_ATTR_2B)) ;
    }
  }

  public String getCurrentNarrative1() {
    return htmlSafe(currentNarrative1);
  }

  public String getNarrativeCode1() {
    return narrativeCode1;
  }

  public String getCurrentNarrative2A() {
    return htmlSafe(currentNarrative2A);
  }

  public String getNarrativeCode2() {
    return narrativeCode2;
  }

  public String getCurrentNarrative2B() {
    return htmlSafe(currentNarrative2B);
  }

  public String getCurrentNarrative1Flag() {
    return currentNarrative1Flag;
  }

  public boolean getNarrativeCode1Flag() {
    return narrativeCode1Flag;
  }

  public String getCurrentNarrative2AFlag() {
    return currentNarrative2AFlag;
  }

  public boolean getNarrativeCode2Flag() {
    return narrativeCode2Flag;
  }

  public String getCurrentNarrative2BFlag() {
    return currentNarrative2BFlag;
  }

}
