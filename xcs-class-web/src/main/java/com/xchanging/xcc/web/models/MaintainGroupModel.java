package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY71Event;
import com.xchanging.xcc.events.LY72Event;
import com.xchanging.xcc.events.LY73Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MaintainGroupModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  // The getAggGrpNonAggRef flag is used to define whether the "Agg Ref/Non-Agg Ref" should be write protected or not.
  // When displaying from LY71 event this field will be write-enabled. On displaying from LY72 this
  // field will be readonly
  private String aggGrpNonAggRefFlag;
  // The groupTypeFlag flag is used to define whether the "Group Type" should be write protected or not.
  // This will always (at present) be readonly
  private String groupTypeFlag;
  // This is an internal flag- used to determine (here and for the JSP) whether the screen
  // in question is dealing with an Aggregate or Non-Aggregate item.
  private boolean aggregate;

  private String aggGrpNonAggRef = "";
  private String groupType = "";
  private Vector osnds;
  private Vector ucrs;

  private boolean addButtonFlag;
  private boolean updateButtonFlag;

  // This is not specified within the spec- although it exists in the LY71 Commarea.
  private String histSessionNo = "";

  public MaintainGroupModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.MaintainGroupModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY71Event) {

      histSessionNo = (String) results.get(Keys.LY71_HIST_SESSION_NO_FIELD);
      aggGrpNonAggRef = (String) results.get(Keys.LY71_GROUP_REF_FIELD);
      groupType =  "";  // To prevent value from previous visit to screen being displayed
      aggGrpNonAggRefFlag = enabledStatus("");
      groupTypeFlag = enabledStatus("P");

      addButtonFlag = true;
      updateButtonFlag = true;

      // the getters on the MaintainGroupScreen are such that they will try to retrieve the
      // ucrs or the osnd vector(.elements) even though they are not populated with this
      // CICS screen. Hence we will set them to blank here- otherwise an error will be thrown.
      osnds = new Vector();
      ucrs = new Vector();
    }
    else if (event instanceof LY72Event) {

      aggGrpNonAggRef = (String) results.get(Keys.LY72_GROUP_REF_FIELD);
      groupType =  (String) results.get(Keys.LY72_GROUP_TYPE_FIELD);
      aggGrpNonAggRefFlag = enabledStatus(((LY72Event)event).ignoreErrors()?"U":"P");
      groupTypeFlag = enabledStatus("P");

      addButtonFlag = ((LY72Event)event).ignoreErrors();
      updateButtonFlag = ((LY72Event)event).ignoreErrors();

      // We first check whether the group type is aggregate or non-aggregate.
      // The spec states that we will determine this by checking the groupType
      // for the specific string 'Aggregate' or 'Non-Aggregate'
      // If the CICS transaction comes back with Aggregate then we will just be processing
      // OSND's. Otherwise it will be processing ucr's.
      if (groupType.equalsIgnoreCase("aggregate")) {
        aggregate = true;

        Vector recordV = (Vector)(results).get(Keys.LY72_GROUP_CONTENTS_TABLE);
        osnds = new Vector();
        if (!(recordV == null)) {
          osnds = new Vector(recordV.size());
          for (int objInd = 0; objInd < recordV.size(); objInd++) {
            MappedRecord record = (MappedRecord)recordV.get(objInd);
            // Only retrieve those elements that actually contain results
            if (!(record.get(Keys.LY72_UCR_OSND_FIELD).equals(""))) {
              osnds.add( new MaintainGroupOsnd((String)record.get(Keys.LY72_UCR_OSND_FIELD)));
            }
          }
        }
      }
      else{
        aggregate = false;

        Vector recordV = (Vector)(results).get(Keys.LY72_GROUP_CONTENTS_TABLE);
        ucrs = new Vector();
        if (!(recordV == null)) {
          ucrs = new Vector(recordV.size());
          for (int objInd = 0; objInd < recordV.size(); objInd++) {
            MappedRecord record = (MappedRecord)recordV.get(objInd);
            // Only retrieve those elements that actually contain results
            if (!(record.get(Keys.LY72_UCR_OSND_FIELD).equals(""))) {
              ucrs.add( new MaintainGroupUcr((String)record.get(Keys.LY72_UCR_OSND_FIELD)));
            }
          }
        }
      }

    }

    else if (event instanceof LY73Event) {

      aggGrpNonAggRef = (String) results.get(Keys.LY73_GROUP_REF_Field);
      aggGrpNonAggRefFlag = enabledStatus("P");
      groupTypeFlag = enabledStatus("P");

      // We first check whether the group type is aggregate or non-aggregate.
      // The spec states that we will determine this by checking the groupType
      // for the specific string 'Aggregate' or 'Non-Aggregate'
      // If the CICS transaction comes back with Aggregate then we will just be processing
      // OSND's. Otherwise it will be processing ucr's.
      if (groupType.equalsIgnoreCase("aggregate")) {
        aggregate = true;

        Vector recordV = (Vector)(results).get(Keys.LY73_GROUP_CONTENTS_Table);
        osnds = new Vector();
        if (!(recordV == null)) {
          osnds = new Vector(recordV.size());
          for (int objInd = 0; objInd < recordV.size(); objInd++) {
            MappedRecord record = (MappedRecord)recordV.get(objInd);
            // Only retrieve those elements that actually contain results
            if (!(record.get(Keys.LY73_UCR_OSND_Field).equals(""))) {
              osnds.add( new MaintainGroupOsnd((String)record.get(Keys.LY73_UCR_OSND_Field)));
            }
          }
        }
      }
      else{
        aggregate = false;

        Vector recordV = (Vector)(results).get(Keys.LY73_GROUP_CONTENTS_Table);
        ucrs = new Vector();
        if (!(recordV == null)) {
          ucrs = new Vector(recordV.size());
          for (int objInd = 0; objInd < recordV.size(); objInd++) {
            MappedRecord record = (MappedRecord)recordV.get(objInd);
            // Only retrieve those elements that actually contain results
            if (!(record.get(Keys.LY73_UCR_OSND_Field).equals(""))) {
              ucrs.add( new MaintainGroupUcr((String)record.get(Keys.LY73_UCR_OSND_Field)));
            }
          }
        }
      }

    }




  }
  // Has inner classes
  public String getAggGrpNonAggRef() {
    return aggGrpNonAggRef;
  }
  public String getGroupType() {
    return groupType;
  }
  public Enumeration getOsnds() {
    return osnds.elements();
  }
  public Enumeration getUcrs() {
    return ucrs.elements();
  }
  public String getAggGrpNonAggRefFlag() {
    return aggGrpNonAggRefFlag;
  }
  public String getGroupTypeFlag() {
    return groupTypeFlag;
  }
  public boolean isAggregate() {
    return aggregate;
  }
  public String getHistSessionNo() {
    return histSessionNo;
  }
  public boolean getAddButtonFlag() {
    return addButtonFlag;
  }
  public boolean getUpdateButtonFlag() {
    return updateButtonFlag;
  }

  public class MaintainGroupOsnd {

    private String osnd;
    private boolean delFlag;
    private boolean del;

    public MaintainGroupOsnd(String osnd) {
      this.osnd = osnd;
      // The spec doesn't mention this delete control. Hence we will set this checkbox to write enabled.
      this.delFlag = false;
      // The spec doesn't mention this delete control. Hence we will set the value of the delete checkbox to false.
      this.del = false;

    }
    public String getOsnd() {
      return osnd;
    }
    public boolean getDel() {
      return del;
    }
    public boolean getDelFlag() {
      return delFlag;
    }
  }

  public class MaintainGroupUcr {

    private String ucr;
    private boolean delFlag;
    private boolean del;

    public MaintainGroupUcr(String ucr){
      this.ucr = ucr;
      // The spec doesn't mention this delete control. Hence we will set this checkbox to write enabled.
      this.delFlag = false;
      // The spec doesn't mention this delete control. Hence we will set the value of the delete checkbox to false.
      this.del = false;

    }
    public String getUcr() {
      return ucr;
    }
    // This tells us whether the control is readonly.
    public boolean getDelFlag() {
      return delFlag;
    }
    // This denotes the value of the deleteline checkbox.
    public boolean getDel() {
      return del;
    }

  }

  public void clear() {
    aggGrpNonAggRef = "";
    groupType =  "";
    aggGrpNonAggRefFlag = enabledStatus("");
    groupTypeFlag = enabledStatus("P");

    addButtonFlag = true;
    updateButtonFlag = true;

    osnds = new Vector();
    ucrs = new Vector();
  }
}