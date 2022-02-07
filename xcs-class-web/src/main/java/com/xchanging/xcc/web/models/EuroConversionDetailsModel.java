package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class EuroConversionDetailsModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private String origNCUCcy;
  private String PTDLossPrior;
  private String PTDLossAsAt;
  private String PTDExpensePrior;
  private String PTDExpenseAsAt;
  private String PTDFeePrior;
  private String PTDFeeAsAt;
  private String PTDVATPrior;
  private String PTDVATAsAt;
  private String PTDPrior;
  private String PTDAsAt;
  private String incurredPrior;
  private String incurredAsAt;
  private String highestEstPrior;
  private String highestEstAsAt;
  private String rExchFrmEspToEuro;
  private String currentMovement;
  private String PTDLossPost;
  private String PTDLossCombined;
  private String PTDExpPost;
  private String PTDExpCombined;
  private String PTDFeePost;
  private String PTDFeeCombined;
  private String PTDVATPost;
  private String PTDVATCombined;
  private String incurredPost;
  private String incurredCombined;
  private String highestEstPost;
  private String highestEstCombined;
  private String PTDPost;
  private String PTDCombined;

  // extra values
  private String origCcyName;

  public EuroConversionDetailsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.EuroConversionDetailsModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    MappedRecord fieldValues = (MappedRecord)((Vector)results.get(Keys.LY80_FIELD_VALUES)).get(0);

    origNCUCcy = (String)fieldValues.get(Keys.LY80_ORIG_NCU_CURR);
    origCcyName = (String)fieldValues.get(Keys.LY80_ORIG_CURR_NAME);  //extra value
    rExchFrmEspToEuro = (String)fieldValues.get(Keys.LY80_RATE_EXCH);
    currentMovement = (String)fieldValues.get(Keys.LY80_MOVE_REF);

    MappedRecord ncuPreConv = (MappedRecord)((Vector)fieldValues.get(Keys.LY80_NCU_PRE_CONV)).get(0);

    PTDLossPrior = (String)ncuPreConv.get(Keys.LY80_PTD_LOSS_NCU);
    PTDExpensePrior = (String)ncuPreConv.get(Keys.LY80_PTD_EXP_NCU);
    PTDFeePrior = (String)ncuPreConv.get(Keys.LY80_PTD_FEE_NCU);
    PTDVATPrior = (String)ncuPreConv.get(Keys.LY80_PTD_VAT_NCU);
    PTDPrior = (String)ncuPreConv.get(Keys.LY80_PTD_TOTAL_NCU);
    incurredPrior = (String)ncuPreConv.get(Keys.LY80_INCURRED_NCU);
    highestEstPrior = (String)ncuPreConv.get(Keys.LY80_HIGH_EST_NCU);

    MappedRecord euroAtConv = (MappedRecord)((Vector)fieldValues.get(Keys.LY80_EURO_AT_CONV)).get(0);

    PTDLossAsAt = (String)euroAtConv.get(Keys.LY80_PTD_LOSS_EAC);
    PTDExpenseAsAt = (String)euroAtConv.get(Keys.LY80_PTD_EXP_EAC);
    PTDFeeAsAt = (String)euroAtConv.get(Keys.LY80_PTD_FEE_EAC);
    PTDVATAsAt = (String)euroAtConv.get(Keys.LY80_PTD_VAT_EAC);
    PTDAsAt = (String)euroAtConv.get(Keys.LY80_PTD_TOTAL_EAC);
    incurredAsAt = (String)euroAtConv.get(Keys.LY80_INCURRED_EAC);
    highestEstAsAt = (String)euroAtConv.get(Keys.LY80_HIGH_EST_EAC);

    MappedRecord euroPostConv = (MappedRecord)((Vector)fieldValues.get(Keys.LY80_EURO_POST_CONV)).get(0);

    PTDLossPost = (String)euroPostConv.get(Keys.LY80_PTD_LOSS_EPC);
    PTDExpPost = (String)euroPostConv.get(Keys.LY80_PTD_EXP_EPC);
    PTDFeePost = (String)euroPostConv.get(Keys.LY80_PTD_FEE_EPC);
    PTDVATPost = (String)euroPostConv.get(Keys.LY80_PTD_VAT_EPC);
    PTDPost = (String)euroPostConv.get(Keys.LY80_PTD_TOTAL_EPC);
    incurredPost = (String)euroPostConv.get(Keys.LY80_INCURRED_EPC);
    highestEstPost = (String)euroPostConv.get(Keys.LY80_HIGH_EST_EPC);

    MappedRecord euroTotalComb = (MappedRecord)((Vector)fieldValues.get(Keys.LY80_EURO_TOTAL_COMB)).get(0);

    PTDLossCombined = (String)euroTotalComb.get(Keys.LY80_PTD_LOSS_ETOT);
    PTDExpCombined = (String)euroTotalComb.get(Keys.LY80_PTD_EXP_ETOT);
    PTDFeeCombined = (String)euroTotalComb.get(Keys.LY80_PTD_FEE_ETOT);
    PTDVATCombined = (String)euroTotalComb.get(Keys.LY80_PTD_VAT_ETOT);
    PTDCombined = (String)euroTotalComb.get(Keys.LY80_PTD_TOTAL_ETOT);
    incurredCombined = (String)euroTotalComb.get(Keys.LY80_INCURRED_ETOT);
    highestEstCombined = (String)euroTotalComb.get(Keys.LY80_HIGH_EST_ETOT);


  }


  public String getOrigNCUCcy() {
    return origNCUCcy;
  }
  public String getPTDLossPrior() {
    return PTDLossPrior;
  }
  public String getPTDLossAsAt() {
    return PTDLossAsAt;
  }
  public String getPTDExpensePrior() {
    return PTDExpensePrior;
  }
  public String getPTDExpenseAsAt() {
    return PTDExpenseAsAt;
  }
  public String getPTDFeePrior() {
    return PTDFeePrior;
  }
  public String getPTDFeeAsAt() {
    return PTDFeeAsAt;
  }
  public String getPTDVATPrior() {
    return PTDVATPrior;
  }
  public String getPTDVATAsAt() {
    return PTDVATAsAt;
  }
  public String getPTDPrior() {
    return PTDPrior;
  }
  public String getPTDAsAt() {
    return PTDAsAt;
  }
  public String getIncurredPrior() {
    return incurredPrior;
  }
  public String getIncurredAsAt() {
    return incurredAsAt;
  }
  public String getHighestEstPrior() {
    return highestEstPrior;
  }
  public String getHighestEstAsAt() {
    return highestEstAsAt;
  }
  public String getRExchFrmEspToEuro() {
    return rExchFrmEspToEuro;
  }
  public String getCurrentMovement() {
    return currentMovement;
  }
  public String getPTDLossPost() {
    return PTDLossPost;
  }
  public String getPTDLossCombined() {
    return PTDLossCombined;
  }
  public String getPTDExpPost() {
    return PTDExpPost;
  }
  public String getPTDExpCombined() {
    return PTDExpCombined;
  }
  public String getPTDFeePost() {
    return PTDFeePost;
  }
  public String getPTDFeeCombined() {
    return PTDFeeCombined;
  }
  public String getPTDVATPost() {
    return PTDVATPost;
  }
  public String getPTDVATCombined() {
    return PTDVATCombined;
  }
  public String getIncurredPost() {
    return incurredPost;
  }
  public String getIncurredCombined() {
    return incurredCombined;
  }
  public String getHighestEstPost() {
    return highestEstPost;
  }
  public String getHighestEstCombined() {
    return highestEstCombined;
  }
  public String getPTDPost() {
    return PTDPost;
  }
  public String getPTDCombined() {
    return PTDCombined;
  }
  public String getOrigCcyName() {
    return origCcyName;
  }
}