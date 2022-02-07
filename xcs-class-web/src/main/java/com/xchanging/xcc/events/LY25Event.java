package com.xchanging.xcc.events;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class LY25Event extends ClaimsEvent implements java.io.Serializable {

  private int userSession;
  private String[] osnd;
  private String[] apsnd;
  private String[] currencies;
  private String settAdv;
  private String nonScmAdvised;
  private String bulkInd;
  private String riskUnsigned;
  private String treaty;
  private String ecfClaim;
  private String ecfClass;
  private String simRi;
  private String lossReserve;
  private String loc;
  private String lossFund;
  private String payByCheque;
  private String chargeType;
  private String noChargeableInd;
  private String prevAdvNoNet;
  private String prevPaidInd;

  // CCN 21 - devo 15/01/2003 - all other references to scheme Canada Ind (etc) are part of this ccn.
  private String schemeCanInd;
  private String cpaInd;
  private String dirLStockInd;
  private String origCcys[];


  // CCN# N0058 - BA - 09/01/2003
  private String locDrawingInd;
  // CCN# ????? - S.Caine - 03/12/2003
  private String SpecPymtInd;

  private String presDate;
  private String slipType;
  private String riskCode;

  public LY25Event(String[] osnd,
                   String[] apsnd,
                   String[] curr,
                   String riskCode,
                   String settAdv,
                   String nonScmAdvised,
                   String bulkInd,
                   String riskUnsigned,
                   String treaty,
                   String ecfClaim,
                   String ecfClass,
                   String simRi,
                   String lossReserve,
                   String loc,
                   String lossFund,
                   String payByCheque,
                   String chargeType,
                   String noChargeableInd,
                   String prevAdvNoNet,
                   String prevPaidInd,
                   String locDrawingInd,   /* CCN# N0058 - BA - 09/01/2003 */
                   String SpecPymtInd,     /* CCN# ????? - S.Caine - 03/12/2003 */
                   String presDate,
                   String slipType,
                   String schemeCanInd,
                   String cpaInd,
                   String dirLStockInd,
                   String[] origCcys) {


    this.osnd            = osnd;
    this.apsnd           = apsnd;
    this.currencies      = curr;
    this.riskCode        = riskCode;
    this.settAdv         = settAdv;
    this.nonScmAdvised   = nonScmAdvised;
    this.bulkInd         = bulkInd;
    this.riskUnsigned    = riskUnsigned;
    this.treaty          = treaty;
    this.ecfClaim        = ecfClaim;
    this.ecfClass       = ecfClass;
        this.simRi           = simRi;
    this.lossReserve     = lossReserve;
    this.loc             = loc;
    this.lossFund        = lossFund;
    this.payByCheque     = payByCheque;
    this.chargeType      = chargeType;
    this.noChargeableInd = noChargeableInd;
    this.prevAdvNoNet    = prevAdvNoNet;
    this.prevPaidInd     = prevPaidInd;
    this.presDate        = presDate;

    // CCN# N0058 - BA - 09/01/2003
    this.locDrawingInd = locDrawingInd ;

    // CCN# ????? - S.Caine - 03/12/2003
    this.SpecPymtInd = SpecPymtInd ;

    this.slipType        = slipType;

    this.schemeCanInd = schemeCanInd;
    this.cpaInd = cpaInd;
    this.dirLStockInd = dirLStockInd;
    this.origCcys = origCcys;
  }


  public void update() {

    ModelManager mm = (ModelManager)getHttpSession().getAttribute(Keys.ModelManagerKey);
    ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();

    riskCode = ctcModel.getRiskCode();
    slipType = ctcModel.getSlipType();
  }


  /*
    Need to add getters as the CICS Handler needs to get the data out of the
    event
  */

  public String getName() {
    return "java:comp/env/event/LY25Event";
  }

  public int getType() {
    return VALIDATE;
  }

  public String getHandlerName() {
    return "com.xchanging.xcc.cics.handlers.LY25CICSHandler";
  }

  public int getUserSession() {
    return userSession;
  }

  public void setUserSession(int userSession) {
    this.userSession = userSession;
  }



  public String[] getOsnd() {
    for (int i=0; i<osnd.length; i++)
      if (osnd[i]==null)
        osnd[i] = "";
    return osnd;
  }

  public String[] getApsnd() {
    for (int i=0; i<apsnd.length; i++)
      if (apsnd[i]==null)
        apsnd[i] = "";
    return apsnd;
  }

  public String[] getCurrencies() {
    for (int i=0; i<currencies.length; i++)
      if (currencies[i]==null)
        currencies[i] = "";
    return currencies;
  }

  public String getRiskCode() {
    if (riskCode != null) {
      return riskCode;
    } else {
      return("");
    }
  }

  public String getSettAdv() {
    if (settAdv != null) {
      return settAdv;
    } else {
      return("");
    }
  }

  public String getNonScmAdvised() {
    if (nonScmAdvised != null) {
      return nonScmAdvised;
    } else {
      return("");
    }
  }

  public String getBulkInd() {
    if (bulkInd != null) {
      return bulkInd;
    } else {
      return("");
    }
  }

  public String getRiskUnsigned() {
    if (riskUnsigned != null) {
      return riskUnsigned;
    } else {
      return("");
    }
  }

  public String getTreaty() {
    if (treaty != null) {
      return treaty;
    } else {
      return("");
    }
  }
  
  public String getEcfClaim() {
    if (ecfClaim != null) {
      return ecfClaim;
    } else {
      return("");
    }
  }

  public String getSimRi() {
    if (simRi != null) {
      return simRi;
    } else {
      return("");
    }
  }

  public String getLossReserve() {
    if (lossReserve != null) {
      return lossReserve;
    } else {
      return("");
    }
  }

  public String getLoc() {
    if (loc != null) {
      return loc;
    } else {
      return("");
    }
  }

  public String getLossFund() {
    if (lossFund != null) {
      return lossFund;
    } else {
      return("");
    }
  }

  public String getPayByCheque() {
    if (payByCheque != null) {
      return payByCheque;
    } else {
      return("");
    }
  }

  public String getChargeType() {
    if (chargeType != null) {
      return chargeType;
    } else {
      return("");
    }
  }

  public String getNonChargeableInd() {
    if (noChargeableInd != null) {
      return noChargeableInd;
    } else {
      return("");
    }
  }

  public String getPrevAdvNoNet() {
    if (prevAdvNoNet != null) {
      return prevAdvNoNet;
    } else {
      return("");
    }
  }

  public String getPrevPaidInd() {
    if (prevPaidInd != null) {
      return prevPaidInd;
    } else {
      return("");
    }
  }

  // CCN# N0058 - BA - 09/01/2003
  public String getLocDrawingInd() {
    if (locDrawingInd != null) {
      return locDrawingInd ;
    } else {
      return("");
    }
  }

  // CCN# ????? - S.Caine - 03/12/2003
  public String getSpecPymtInd() {
    if (SpecPymtInd != null) {
      return SpecPymtInd ;
    } else {
      return("");
    }
  }

  public String getPresDate() {
    if (presDate != null) {
      return presDate;
    } else {
      return("");
    }
  }

  public String getSlipType() {
    if (slipType != null) {
      return slipType;
    } else {
      return("");
    }
  }
  public String getSchemeCanInd() {
    if (schemeCanInd != null) {
      return schemeCanInd;
    } else {
      return("");
    }
  }
  public String getCpaInd() {
    if (cpaInd != null) {
      return cpaInd;
    } else {
      return("");
    }
  }
  public String getDirLStockInd() {
    if (dirLStockInd != null) {
      return dirLStockInd;
    } else {
      return("");
    }
  }

  public String[] getOrigCcys() {
    for (int i=0; i<origCcys.length; i++)
      if (origCcys[i]==null)
        origCcys[i] = "";
    return origCcys;
  }

  public String getValueCount() {
    if (origCcys==null)
      return "0";
    else
      return String.valueOf(origCcys.length);
  }



public String getEcfClass()
{
    if (ecfClass != null) {
        return ecfClass;
      } else {
        return("");
      }
}
}