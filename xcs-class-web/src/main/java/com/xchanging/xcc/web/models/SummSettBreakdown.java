package com.xchanging.xcc.web.models;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;

public class SummSettBreakdown {

  private String cor = "";
  private String mvmtReg = "";
  private String pTTOrig = "";
  private String oSAmtOrig = "";
  private String clmAmtSettBD = "" ;

  public SummSettBreakdown(MappedRecord mrData) {
    cor = (String)mrData.get(Keys.LZ03_COR_Field) ;
    mvmtReg = (String)mrData.get(Keys.LZ03_MOVE_REF_Field) ;
    pTTOrig = (String)mrData.get(Keys.LZ03_PTT_AMT_BD_Field) ;
    oSAmtOrig = (String)mrData.get(Keys.LZ03_OUTST_AMT_Field) ;
    clmAmtSettBD = (String)mrData.get(Keys.LZ03_CLM_AMT_SETT_BD_Field) ;
  }

  public String getCor() {
    return cor;
  }

  public String getPTTOrig() {
    return pTTOrig;
  }

  public String getOSAmtOrig() {
    return oSAmtOrig;
  }

  public String getMvmtReg() {
    return mvmtReg;
  }

  public String getClmAmtSettBD() {
    return clmAmtSettBD;
  }
}