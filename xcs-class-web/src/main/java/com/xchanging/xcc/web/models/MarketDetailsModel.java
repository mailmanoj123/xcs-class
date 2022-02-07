package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY31Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MarketDetailsModel extends WebModel implements ModelUpdateListener{

  private ModelManager mm;

  private Vector syndicates;
  private String ucr;
  private boolean ucrFlag;
  private String xcr;
  private boolean xcrFlag;
  private String tr;
  private boolean trFlag;
  private String osnd1;
  private String osnd2;
  private String osnd3;
  private String origBkr;
  private boolean origBkrFlag;
  private String signed;
  private boolean signedFlag;
  private String peerReview;
  private boolean peerReviewFlag;
  private boolean saveButtonFlag;
  private String screenMode;
  private String noSyndicates;
  private String totalLine;
  private String marketSource;

  // Extra values
  private boolean osnd1Flag;
  private boolean osnd2Flag;
  private boolean osnd3Flag;
  private boolean noSyndicatesFlag;
  private boolean totalLineFlag;
  private boolean mktSourceFlag;
  private String mktChangeFlag;

  public void updateModel(String[] aSyndicateNos, String[] aSyndicatePercs, String[] aSyndicateRefs, String[] aBureauLeaders, String[] aDeleteInds) {
    for (int i=0; i<aSyndicateNos.length; i++) {
      if (i<syndicates.size()) {
        MarketDetailsSyndicate synd = (MarketDetailsSyndicate)syndicates.get(i);
        synd.update(aSyndicateNos[i],aSyndicatePercs[i],aSyndicateRefs[i]);
        syndicates.set(i,synd);
      } else {
        syndicates.add(new MarketDetailsSyndicate(i+1,aSyndicateNos[i],aSyndicatePercs[i],aSyndicateRefs[i],aBureauLeaders[i],"","","","","","","","",""));
      }
    }
  }

  public MarketDetailsModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.MarketDetailsModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));
    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);

    if (event instanceof LY31Event){
      screenMode = (String)results.get(Keys.LY31_SCREEN_MODE);
      saveButtonFlag = screenMode.equals("E");
      mm.getUserWebModel().setUpdateMode(screenMode);

      MappedRecord fieldValues = (MappedRecord)((Vector)results.get(Keys.LY31_FIELD_VALUES)).get(0);
      xcr = (String)fieldValues.get(Keys.LY31_XCR);
      ucr = (String)fieldValues.get(Keys.LY31_UCR);
      tr = (String)fieldValues.get(Keys.LY31_TR);
      osnd1 = (String)fieldValues.get(Keys.LY31_ORIG_REF_1);
      osnd2 = (String)fieldValues.get(Keys.LY31_ORIG_REF_2);
      osnd3 = (String)fieldValues.get(Keys.LY31_ORIG_REF_3);
      origBkr = (String)fieldValues.get(Keys.LY31_ORIG_BKR);
      signed = (String)fieldValues.get(Keys.LY31_SIGNED_IND);
      peerReview = (String)fieldValues.get(Keys.LY31_PEER_REV_IND);
      noSyndicates = (String)fieldValues.get(Keys.LY31_NO_SYNDICATES);
      totalLine = (String)fieldValues.get(Keys.LY31_TOTAL_LINE);
      marketSource = (String)fieldValues.get(Keys.LY31_MKT_SOURCE);

      MappedRecord marketTable = (MappedRecord)((Vector)fieldValues.get(Keys.LY31_MARKET_TABLE)).get(0);
      Vector synds = (Vector)marketTable.get(Keys.LY31_MARKET_LINE);

      if (synds == null) {
        synds = new Vector();
      }

      MappedRecord fieldAttributes = (MappedRecord)((Vector)results.get(Keys.LY31_FIELD_ATTRIBUTES)).get(0);
      xcrFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_XCR_ATTR));
      ucrFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_UCR_ATTR));
      trFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_TR_ATTR));
      osnd1Flag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_ORIG_REF_ATTR1));
      osnd2Flag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_ORIG_REF_ATTR2));
      osnd3Flag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_ORIG_REF_ATTR3));
      origBkrFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_ORIG_BKR_ATTR));
      signedFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_SIGNED_IND_ATTR));
      peerReviewFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_PEER_REV_IND_ATTR));
      noSyndicatesFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_NO_SYNDICATES_ATTR));
      totalLineFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_TOTAL_LINE_ATTR));
      mktSourceFlag = convertToBoolean((String)fieldAttributes.get(Keys.LY31_MKT_SRCE_ATTR));
      mktChangeFlag = (String)fieldAttributes.get(Keys.LY31_MKT_CHANGE_ATTR);

      Vector marketAttrs = (Vector)fieldAttributes.get(Keys.LY31_MKT_ATTR_TABLE);

      if (marketAttrs == null) {
        marketAttrs = new Vector();
      }

      syndicates = new Vector();
      for (int i=0; (i<synds.size()) && (i<marketAttrs.size()); i++) {
        MappedRecord syndicate = (MappedRecord)synds.get(i);
        if (!(((String)syndicate.get(Keys.LY31_SYNDICATE_NO)).equals(""))){
          MappedRecord marketAttr = (MappedRecord)marketAttrs.get(i);

          MarketDetailsSyndicate syndModel = new MarketDetailsSyndicate(
              i+1,
              (String)syndicate.get(Keys.LY31_SYNDICATE_NO),
              (String)syndicate.get(Keys.LY31_SYNDICATE_LINE),
              (String)syndicate.get(Keys.LY31_SYNDICATE_REF),
              (String)syndicate.get(Keys.LY31_AGREEMENT_ROLE),
              (String)syndicate.get(Keys.LY31_SYND_RESP_CODE),
              (String)syndicate.get(Keys.LY31_USER_NAME_AUTH),
              (String)syndicate.get(Keys.LY31_RESP_TIMESTAMP),
              (String)syndicate.get(Keys.LY31_OPT_OUT_STATUS),
              (String)syndicate.get(Keys.LY31_OPT_OUT_EFF_DATE),
              (String)marketAttr.get(Keys.LY31_SYND_NO_ATTR),
              (String)marketAttr.get(Keys.LY31_SYND_LINE_ATTR),
              (String)marketAttr.get(Keys.LY31_SYND_REF_ATTR),
              mktChangeFlag);

          syndicates.add(syndModel);
        }
      }
    }
  }

  public Enumeration getSyndicates() {

    if (syndicates == null){
       return new Vector().elements();
    }
    else{
       return syndicates.elements();
    }

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

  public String getOsnd1() {
    return osnd1;
  }

  public String getOsnd2() {
    return osnd2;
  }
  public String getOsnd3() {
    return osnd3;
  }

  public String getOrigBkr() {
    return origBkr;
  }

  public String getSigned() {
    return signed;
  }

  public String getPeerReview() {
    return peerReview;
  }

  public boolean getDelSelButtonFlag() {
    return convertToBoolean(mktChangeFlag);
  }

  public boolean getInsertButtonFlag() {
    return convertToBoolean(mktChangeFlag);
  }

  public boolean getSaveButtonFlag() {
    return saveButtonFlag;
  }

  public String isMktChangeFlag() {
    return mktChangeFlag;
  }

  public boolean isMktSourceFlag() {
    return mktSourceFlag;
  }
  public String getNoSyndicates() {
    return noSyndicates;
  }
  public boolean isNoSyndicatesFlag() {
    return noSyndicatesFlag;
  }
  public boolean isOsnd1Flag() {
    return osnd1Flag;
  }
  public boolean isOsnd2Flag() {
    return osnd2Flag;
  }
  public boolean isOsnd3Flag() {
    return osnd3Flag;
  }
  public boolean isOrigBkrFlag() {
    return origBkrFlag;
  }
  public boolean isPeerReviewFlag() {
    return peerReviewFlag;
  }
  public String getScreenMode() {
    return screenMode;
  }
  public boolean isSignedFlag() {
    return signedFlag;
  }
  public String getTotalLine() {
    return totalLine;
  }
  public boolean isTotalLineFlag() {
    return totalLineFlag;
  }
  public boolean isTrFlag() {
    return trFlag;
  }
  public boolean isUcrFlag() {
    return ucrFlag;
  }
  public boolean isXcrFlag() {
    return xcrFlag;
  }
  public String getMarketSource() {
    return marketSource;
  }
}