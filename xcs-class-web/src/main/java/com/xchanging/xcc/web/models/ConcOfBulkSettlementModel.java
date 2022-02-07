package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;


public class ConcOfBulkSettlementModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String screenMode;
  private String ucr;
  private String xcr;
  private String tr;
  private String origBkr;
  private String origCcy;
  private String osnd;
  private String total;
  private String currencyCount;
  private Vector currencies;

  private int ccy = 0;

  public ConcOfBulkSettlementModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.ConcOfBulkSettlementModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    screenMode = (String)results.get(Keys.LY67_SCREEN_MODE);
    mm.getUserWebModel().setUpdateMode(screenMode);

    MappedRecord fieldValues = (MappedRecord)((Vector)results.get(Keys.LY67_FIELD_VALUES)).get(0);

    xcr = (String)fieldValues.get(Keys.LY67_XCR);
    ucr = (String)fieldValues.get(Keys.LY67_UCR);
    tr = (String)fieldValues.get(Keys.LY67_TR);
    origBkr = (String)fieldValues.get(Keys.LY67_ORIG_BKR);
    currencyCount = (String)fieldValues.get(Keys.LY67_CURRENCY_COUNT);

    currencies = (Vector)fieldValues.get(Keys.LY67_CURRENCY_DETAILS);
    if (currencies==null)
      currencies = new Vector(0);
  }

  private MappedRecord getCurrentCcy() {
    return (MappedRecord)currencies.get(ccy);
  }

  public String getUcr() {
    return ucr;
  }
  public String getXcr() {
    return xcr;
  }
  public String getTr() {
    return tr;
  }
  public String getOrigBkr() {
    return origBkr;
  }
  public String getOrigCcy() {
    return (String)getCurrentCcy().get(Keys.LY67_ORIG_CURR);
  }
  public String getOsnd() {
    return (String)getCurrentCcy().get(Keys.LY67_ORIG_REF);
  }
  public String getTotal() {
    return (String)getCurrentCcy().get(Keys.LY67_TOTAL_PTT);
  }
  public java.util.Enumeration getItems() {
    Vector items = new Vector();

    Vector components = (Vector)getCurrentCcy().get(Keys.LY67_COMPONENT_CLAIMS);
    if (components==null)
      components = new Vector(0);

    for (int i=0; i<components.size(); i++) {
      MappedRecord comp = (MappedRecord)components.get(i);

      ConclusionItem concItem = new ConclusionItem((String)comp.get(Keys.LY67_COMP_UCR),
          (String)comp.get(Keys.LY67_COMP_TR),(String)comp.get(Keys.LY67_PTT_AMT),
          (String)comp.get(Keys.LY67_OUTST_AMT),(String)comp.get(Keys.LY67_NAME_1),
          (String)comp.get(Keys.LY67_NAME_2));

      if (!concItem.getUcr().equals(""))
        items.add(concItem);
      else
        break;
    }

    return items.elements();
  }

  public void next() {
    ccy++;
  }

  public void prev() {
    ccy--;
  }

  public boolean getPrevButtonFlag() {
    if (ccy<1)
      return false;
    else
      return true;
  }

  public boolean getNextButtonFlag() {
    if (ccy<Integer.parseInt(currencyCount)-1)
      return true;
    else
      return false;
  }

  public class ConclusionItem {
    private String ucr;
    private String tr;
    private String PTTAmount;
    private String OSAmount;
    private String name1;
    private String name2;

    public ConclusionItem(
        String ucr,
        String tr,
        String PTTAmount,
        String OSAmount,
        String name1,
        String name2) {

      this.ucr = ucr;
      this.tr = tr;
      this.PTTAmount = PTTAmount;
      this.OSAmount = OSAmount;
      this.name1 = name1;
      this.name2 = name2;
    }


    public String getUcr() {
      return ucr;
    }
    public String getTr() {
      return tr;
    }
    public String getPTTAmount() {
      return PTTAmount;
    }
    public String getOSAmount() {
      return OSAmount;
    }
    public String getName1() {
      return htmlSafe(name1);
    }
    public String getName2() {
      return htmlSafe(name2);
    }
  }
}