package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

// NOTES:
// The LY69 spec details the following values which will be passed from the GUI.
// Next_Pressed, Prev_Pressed and Start_sys_ref
// The last value will be stashed in a getter here- one for both the very first transaction
// details row on the screen and one for the last transaction details row on the screen.
// These will have to be extracted in the Web Handler through accessing this model.
// The first two are determined by whether the next or the previous button was pressed. We will
// have to have a little logic in the Web Handler which will determine this- perhaps through the URL
// itself.
public class TransactionHistoryModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String xcr;
  private String ucr;
  private String origBkr;
  private String peerRevInd;
  private String ccyCount;

  private String origCcy;
  private String osnd;
  private String total;
  private Vector transactions;
  private boolean prevButtonFlag;
  private boolean nextButtonFlag;

  // This will have stored within it the value for the
  // first line of transaction details on the screen
  private String SysRefPrev;
  // This will have stored within it the value for the
  // last line of transaction details on the screen
  private String SysRefNext;

  private int iCurrencyCounter;
  private Vector vCurrencies;

  public TransactionHistoryModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.TransactionHistoryModelKey, this);
  }

  public void performUpdate() {
    iCurrencyCounter = 0;
    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    // First hide the previous or next buttons if required.
    prevButtonFlag = convertToBoolean((String)results.get(Keys.LY69_PREV_ATTR_Field));
    nextButtonFlag = convertToBoolean((String)results.get(Keys.LY69_NEXT_ATTR_Field));

    // First we will retrieve the highest level variables- which contains a vector
    // with a single element within it.
    MappedRecord subResults1 = (MappedRecord) ((Vector) results.get(Keys.LY69_FIELD_VALUES_Table)).get(0);
    xcr = (String) subResults1.get(Keys.LY69_XCR_Field);
    ucr = (String) subResults1.get(Keys.LY69_UCR_Field);
    origBkr = (String) subResults1.get(Keys.LY69_ORIG_BKR_Field);
    peerRevInd = (String) subResults1.get(Keys.LY69_PEER_REV_IND_Field);
    ccyCount = (String) subResults1.get(Keys.LY69_CURRENCY_COUNT_Field);

    // Now store all the currencies within this class wide vector variable.
    vCurrencies = (Vector) subResults1.get(Keys.LY69_CURRENCY_DETAILS_Table);

    // Has an Inner class
  }

  // The following three getters will return currency level details
  public String getOrigCcy() {
    MappedRecord mp = (MappedRecord) vCurrencies.get(iCurrencyCounter);
    return (String) mp.get(Keys.LY69_ORIG_CURR_Field);
  }

  public String getTotal() {
    MappedRecord mp = (MappedRecord) vCurrencies.get(iCurrencyCounter);
    return (String) mp.get(Keys.LY69_TOTAL_PAID_Field);
  }
  public String getOsnd() {
    MappedRecord mp = (MappedRecord) vCurrencies.get(iCurrencyCounter);
    return (String) mp.get(Keys.LY69_ORIG_REF_Field);
  }

  // This will return the transaction details level of data
  public Enumeration getTransactions() {
    MappedRecord mp = (MappedRecord) vCurrencies.get(iCurrencyCounter);

    Vector v1 = (Vector) mp.get(Keys.LY69_TRANSACTION_DETS_Table);
    // Re-initialise the transactions array-
    transactions = new Vector();
    // Store the TransactionHistory objects within a vector and return it in Enumeration format.
    for (int x= 0; x < v1.size(); x++){
      MappedRecord mp1 = (MappedRecord) v1.get(x);
      if (!(mp1.get(Keys.LY69_UCR_TR_SYS_REF_Field).equals("0"))){
        transactions.add(new TransactionHistory(mp1));
      }
    }
    return transactions.elements();
  }

  public void next(){
    iCurrencyCounter++;
  }

  public void prev(){
    iCurrencyCounter--;
  }
  public boolean getPrevButtonFlag() {
    return prevButtonFlag;
  }

  public boolean getNextButtonFlag() {
    return nextButtonFlag;
  }

  public boolean getPrevCcyButtonFlag() {
    return iCurrencyCounter==0;
  }

  public boolean getNextCcyButtonFlag() {
    return iCurrencyCounter==Integer.parseInt(ccyCount)-1;
  }


  public String getXcr() {
    return xcr;
  }
  public String getUcr() {
    return ucr;
  }
  public String getPeerRevInd() {
    return peerRevInd;
  }
  public String getOrigBkr() {
    return origBkr;
  }
  public String getCcyCount() {
    return ccyCount;
  }
  public String getSysRefPrev() {
    // Get the first line of the transaction details that will be shown on the screen
    MappedRecord mp = (MappedRecord) vCurrencies.get(iCurrencyCounter);
    MappedRecord mp2 = (MappedRecord) ((Vector) mp.get(Keys.LY69_TRANSACTION_DETS_Table)).get(0);
    return (String) mp2.get(Keys.LY69_UCR_TR_SYS_REF_Field);
  }
  public String getSysRefNext() {
    // Get the last line of the transaction details that will be shown on the screen
    MappedRecord mp = (MappedRecord) vCurrencies.get(iCurrencyCounter);
    Vector v1 = (Vector) mp.get(Keys.LY69_TRANSACTION_DETS_Table);
    MappedRecord mp2 = (MappedRecord) v1.get(v1.size()-1);
    return (String) mp2.get(Keys.LY69_UCR_TR_SYS_REF_Field);
  }

  public int getNoOfTransactions() {
    return transactions.size();
  }

  public TransactionHistory getTransaction(int i) {
    return (TransactionHistory)transactions.get(i);
  }

  public class TransactionHistory {

    private boolean trButtonFlag;

    private String seqNo;
    private String tr;
    private String paidToDate;
    private String OSAmount;
    private String OSAmountQual;
    private String transDate;
    private String status;
    private String sysRef;

    public TransactionHistory(MappedRecord mp){
      tr = (String) mp.get(Keys.LY69_TR_Field);
      paidToDate = (String) mp.get(Keys.LY69_PTT_AMT_Field);
      OSAmount = (String) mp.get(Keys.LY69_OUTST_AMT_Field);
      OSAmountQual = (String) mp.get(Keys.LY69_OUTST_QUAL_Field);
      transDate = (String) mp.get(Keys.LY69_TRANS_DATE_Field);
      status = (String) mp.get(Keys.LY69_TRANS_STATUS_Field);
      seqNo = (String) mp.get(Keys.LY69_SEQ_NO_Field);
      trButtonFlag = convertToBoolean((String) mp.get(Keys.LY69_TR_SELECT_ATTR_Field));
      sysRef = (String) mp.get(Keys.LY69_UCR_TR_SYS_REF_Field);

      if (((String) mp.get(Keys.LY69_CURR_PRESENT_Field)).toLowerCase() == "n"){
        paidToDate = "";
        OSAmount = "";
      }
    }

    public boolean getTrButtonFlag() {
      return trButtonFlag;
    }

    public String getTr() {
      return tr;
    }

    public String getPaidToDate() {
      return paidToDate;
    }

    public String getOSAmount() {
      return OSAmount;
    }

    public String getOSAmountQual() {
      return OSAmountQual;
    }

    public String getTransDate() {
      return transDate;
    }

    public String getStatus() {
      return status;
    }

    public String getSeqNo() {
      return seqNo;
    }
    public String getsysRef() {
      return sysRef;
    }
  }
}