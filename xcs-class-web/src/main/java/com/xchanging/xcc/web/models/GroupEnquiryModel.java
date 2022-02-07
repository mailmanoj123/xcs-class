package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY71Event;
import com.xchanging.xcc.events.LY75Event;
import com.xchanging.xcc.events.LY76Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class GroupEnquiryModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String aggGrpNonAggRef = "";
  private String groupType = "";
  private String origCcy = "";

  private boolean addToGroupButtonFlag;
  private Vector lines;
  private String ptdTotal = "";
  private String OSAmountTotal = "";
  private String sCurrencyCount = "";

  private String groupScreen = "";
  private String histSessionNo = "";

  private Vector vCurrencyTable;
  private int iPosition = 0;

  public void reset() {
    aggGrpNonAggRef = "";
    groupType = "";
    origCcy = "";
    addToGroupButtonFlag = false;
    lines = null;
    ptdTotal = "";
    OSAmountTotal = "";
    sCurrencyCount = "0";
    groupScreen = "";
    histSessionNo = "";
    vCurrencyTable = null;
    iPosition = 0;
  }

  public GroupEnquiryModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.GroupEnquiryModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY75Event) {
      // The field values is just a single level- hence just need element 0 of the vector
      MappedRecord subResults = (MappedRecord)((Vector)results.get(Keys.LY75_FIELD_VALUES_Table)).get(0);
      aggGrpNonAggRef = (String) subResults.get(Keys.LY75_GROUP_REF_Field);
      groupType       = (String) subResults.get(Keys.LY75_GROUP_TYPE_Field);
      sCurrencyCount  = (String) subResults.get(Keys.LY75_CURRENCY_COUNT_Field);

      MappedRecord commandAttrs = (MappedRecord)((Vector)results.get("#C075_COMMAND_ATTRS[]")).get(0);
      addToGroupButtonFlag = convertToBoolean((String) commandAttrs.get(Keys.LY75_ADD_ATTR_Field));

      // Store the currency details in a class level vector.
      vCurrencyTable =  (Vector) subResults.get(Keys.LY75_CURRENCY_DETAILS_Table);
    } else if (event instanceof LY71Event) {
      // This is the event that will lead to this screen initially-
      // There are no screen details to stash
      sCurrencyCount = "0";
      groupType = "";
      aggGrpNonAggRef = "";
      addToGroupButtonFlag = true;

      groupScreen = (String) results.get(Keys.LY71_GROUP_SCREEN_FIELD);
      histSessionNo = (String) results.get(Keys.LY71_GROUP_SCREEN_FIELD);
      // CCN 53- Devo.
      aggGrpNonAggRef = (String) results.get(Keys.LY71_GROUP_REF_FIELD);

    } else if (event instanceof LY76Event) {
      // This is the validation event which is executed when the 'Add Claim' is pressed.
      aggGrpNonAggRef = (String) results.get(Keys.LY76_Group_Ref_Field);

    }

    // Has an inner class
  }

  public boolean getAddToGroupButtonFlag() {
    return addToGroupButtonFlag;
  }
  public String getAggGrpNonAggRef() {
    return aggGrpNonAggRef;
  }
  public String getGroupType() {
    return groupType;
  }

  // The following three fields are at the currency detail level and must be extracted
  // from the vCurrencytable Vector- depending on the state of the iPosition integer.
  public String getOrigCcy() {
    if ((vCurrencyTable!=null) && (iPosition<=vCurrencyTable.size()-1)) {
      // Now we need to extract the mapped record from the relevant vector element.
      MappedRecord ccyDetails = (MappedRecord) vCurrencyTable.get(iPosition);
      // Now we have the mappedrecord- extract the data we require
      return (String) ccyDetails.get(Keys.LY75_ORIG_CURR_Field);
    } else
      return "";
  }
  public String getPtdTotal() {
    if ((vCurrencyTable!=null) && (iPosition<=vCurrencyTable.size()-1)) {
      // Now we need to extract the mapped record from the relevant vector element.
      MappedRecord ccyDetails = (MappedRecord) vCurrencyTable.get(iPosition);
      // Now we have the mappedrecord- extract the data we require
      return (String) ccyDetails.get(Keys.LY75_PAID_AMT_TOTAL_Field);
    } else
      return "";
  }
  public String getOSAmountTotal() {
    if ((vCurrencyTable!=null) && (iPosition<=vCurrencyTable.size()-1)) {
      // Now we need to extract the mapped record from the relevant vector element.
      MappedRecord ccyDetails = (MappedRecord) vCurrencyTable.get(iPosition);
      // Now we have the mappedrecord- extract the data we require
      return (String) ccyDetails.get(Keys.LY75_OUTST_AMT_TOTAL_Field);
    } else
      return "";
  }

  /**
   * The next and prev functions will be called to move through the
   * currencies stashed on the screens.
   * The JSP then calls the getLines method which has all the relevant ccy details
   * stored in the vCurrencyTable array- and through the iPosition integer
   * returns the relevant ccy details
   **/

  public void next() {
    iPosition++;
  }

  public void prev() {
    iPosition--;
  }

  public Enumeration getLines() {
    if (vCurrencyTable!=null) {
      // Now we need to extract the mapped record from the relevant vector element.
      MappedRecord ccyDetails = (MappedRecord) vCurrencyTable.get(iPosition);
      // Now we have the mappedrecord- extract the Transaction Vector of mappedrecords.
      Vector V1 =  (Vector) ccyDetails.get(Keys.LY75_TRANSACTION_DETS_Table);
      // (Re-)Initialise "lines" array which will contain the GroupEnquiryObjects.
      lines = new Vector(V1.size());
      for (int objInd = 0; objInd < V1.size(); objInd++) {
        MappedRecord record = (MappedRecord)V1.get(objInd);
        if (!(record.get(Keys.LY75_UCR).equals(""))) {
          lines.add(new GroupEnquiryLine(record));
        }
      }

      return lines.elements();
    }
    else
      return new Vector(0).elements();
  }


  /**
   * The following two methods are called to determine whether or not the
   * previous and next buttons should be enabled or not- depending on whether there
   * are previous or next currencies.
   */
  public boolean getPrevButtonFlag() {
    return iPosition<1;
  }

  public boolean getNextButtonFlag() {
    if (sCurrencyCount.equals("0"))
      return true;
    else
      return iPosition >= Integer.parseInt(sCurrencyCount)-1;
  }


  public class GroupEnquiryLine {
    private String ucr;
    private String ptt;
    private String OSAmount;

    public GroupEnquiryLine(MappedRecord mp1){
      this.ucr      = (String) mp1.get(Keys.LY75_UCR);
      this.ptt      = (String) mp1.get(Keys.LY75_PTT_AMT);
      this.OSAmount = (String) mp1.get(Keys.LY75_OUTST_AMT);
    }

    public String getUcr() {
      return ucr;
    }
    public String getPtd() {
      // spec says ptd commarea says ptt.
      return ptt;
    }
    public String getOSAmount() {
      return OSAmount;
    }
  }
}