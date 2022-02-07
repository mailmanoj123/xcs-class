package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SchemeCanadaWebModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String function;
  private String savedFlagString;
  private boolean savedButtonFlag;
  private String businessClass;

  private String prevAttr;
  private boolean prevButtonFlag;
  private String nextAttr;
  private boolean nextButtonFlag;

  private String autoAttr;
  private boolean autoButtonFlag;
  private String commercialAttr;
  private boolean commercialButtonFlag;
  private String residentialAttr;
  private boolean residentialButtonFlag;

  private String rowFrom;
  private String rowTo;
  private String rowTotal;

  // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
  private String reprocThisRunStat;
  private String xcsThisRunStat;
  private String reprocTotalStat;
  private String xcsTotalStat;


  
  /* 26/04/04 changes for S456/S457, not needed anymore. Patrick Cogan.
  private String deleteThisRunStat;
  private String rejectThisRunStat;
  private String indivThisRunStat;
  private String blockThisRunStat;
  private String zerosThisRunStat;
  private String deleteTotalStat;
  private String rejectTotalStat;
  private String indivTotalStat;
  private String blockTotalStat;
  private String zerosTotalStat;
*/
  
  private Vector rows;

  public SchemeCanadaWebModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.SchemeCanadaModelKey, this);
  }

  public void performUpdate() {

    MappedRecord results = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    UserWebModel user = (UserWebModel)session.getAttribute(Keys.UserWebModelKey);
    String newSessionNo = (String)results.get(Keys.LZ50_SessionID_Field);

    if (!newSessionNo.equals(user.getSecondarySessionNo())) {
      user.setSecondaySessionNo((String)results.get(Keys.LZ50_SessionID_Field));
    }

    function        = (String)results.get(Keys.LZ50_FUNCTION);
    savedFlagString = (String)results.get(Keys.LZ50_SAVED_FLAG);
    savedButtonFlag = convertSavedStringToBoolean(savedFlagString);
    businessClass   = (String)results.get(Keys.LZ50_HEADER_BUS_CLASS);

    Vector vFieldValues = (Vector)results.get(Keys.LZ50_FIELD_VALUES);    

    if (function.equals("ACTION")) {
      if (vFieldValues != null) {
        // Previously called with ACTION
        // Changed row returned only - update that row
        Vector actionRow = new Vector(vFieldValues.size());
        if (vFieldValues.size() > 0) {
          MappedRecord rFieldValue = (MappedRecord)vFieldValues.get(0);
          String rowNumber   = (String)rFieldValue.get(Keys.LZ50_ROW_NUMBER);
          String processFlag = (String)rFieldValue.get(Keys.LZ50_PROCESS_FLAG);
          if (!rowNumber.equals("0")) {
            for (int x = 0; x < rows.size(); x++) {
              Row currentRow = (Row)rows.elementAt(x);
              if (rowNumber.equals(currentRow.rowNumber)) {
                currentRow.processFlag = processFlag;
                break;
              }
            }
          }
        }
      }
    }
    else if (function.equals("SAVE")) {
      // Previously called with SAVE
      // Rows not returned - keep previous rows
    }
    else
    {
      // New set of rows returned
      if (vFieldValues == null) {
        rows = new Vector();
      } else {
        rows = new Vector(vFieldValues.size());
        for (int x = 0; x < vFieldValues.size(); x++) {

          // Get the FIELD-VALUES
          MappedRecord rFieldValue = (MappedRecord)vFieldValues.get(x);
          String rowNumber   = (String)rFieldValue.get(Keys.LZ50_ROW_NUMBER);
          if (rowNumber.equals("0")) {
            // Row with row number 0 signifies end of valid rows that have been returned
            break;
          }
          String processFlag = (String)rFieldValue.get(Keys.LZ50_PROCESS_FLAG);

          // Get the TABLE-DATA
          Vector vTableData = (Vector)rFieldValue.get(Keys.LZ50_TABLE_DATA);
          MappedRecord rTableData = (MappedRecord)vTableData.get(0);
          String signingRef    = (String)rTableData.get(Keys.LZ50_TABLE_ORIG_REF);
          String tableCcr      = (String)rTableData.get(Keys.LZ50_TABLE_CCR);
          String tableUcr      = (String)rTableData.get(Keys.LZ50_TABLE_UCR);
          String tableBlockInd = (String)rTableData.get(Keys.LZ50_TABLE_BLOCK_IND);

          // Get the FILE-DATA
          Vector vFileData = (Vector)rFieldValue.get(Keys.LZ50_FILE_DATA);
          MappedRecord rFileData = (MappedRecord)vFileData.get(0);
          String errorMessage = (String)rFileData.get(Keys.LZ50_ERROR_MESSAGE);
          String fileOsnd     = (String)rFileData.get(Keys.LZ50_FILE_OSND);
          String fileCcr      = (String)rFileData.get(Keys.LZ50_FILE_CCR);
          String busClass     = (String)rFileData.get(Keys.LZ50_BUS_CLASS);
          String cHolderNo    = (String)rFileData.get(Keys.LZ50_CHOLDER_NO);
          String contractCode = (String)rFileData.get(Keys.LZ50_CONTRACT_CODE);
          String contractYear = (String)rFileData.get(Keys.LZ50_CONTRACT_YEAR);
          String blockNumber  = (String)rFileData.get(Keys.LZ50_BLOCK_NUMBER);
          String errorNumber  = (String)rFileData.get(Keys.LZ50_ERROR_NUMBER);

          rows.add(new Row(rowNumber,processFlag,signingRef,
                           tableCcr,tableUcr,tableBlockInd,
                           errorMessage,fileOsnd,fileCcr,
                           busClass,cHolderNo,contractCode,
                           contractYear,blockNumber));
        }
      }
    }

    // Get the FIELD-ATTRIBUTES
    Vector vFieldAttributes = (Vector)results.get(Keys.LZ50_FIELD_ATTRIBUTES);
    MappedRecord rFieldAttributes = (MappedRecord)vFieldAttributes.get(0);
    prevAttr        = (String)rFieldAttributes.get(Keys.LZ50_PREV_ATTR);
    prevButtonFlag        = convertToBoolean(prevAttr);
    nextAttr        = (String)rFieldAttributes.get(Keys.LZ50_NEXT_ATTR);
    nextButtonFlag        = convertToBoolean(nextAttr);
    autoAttr        = (String)rFieldAttributes.get(Keys.LZ50_AUTO_ATTR);
    autoButtonFlag        = convertToBoolean(autoAttr);
    commercialAttr  = (String)rFieldAttributes.get(Keys.LZ50_COMMERCIAL_ATTR);
    commercialButtonFlag  = convertToBoolean(commercialAttr);
    residentialAttr = (String)rFieldAttributes.get(Keys.LZ50_RESIDENTIAL_ATTR);
    residentialButtonFlag = convertToBoolean(residentialAttr);

    // Get the DISPLAY-COUNTS
    Vector vDisplayCounts = (Vector)results.get(Keys.LZ50_DISPLAY_COUNTS);
    MappedRecord rDisplayCounts = (MappedRecord)vDisplayCounts.get(0);
    rowFrom  = (String)rDisplayCounts.get(Keys.LZ50_SCR_FIRST_ROW);
    rowTo    = (String)rDisplayCounts.get(Keys.LZ50_SCR_LAST_ROW);
    rowTotal = (String)rDisplayCounts.get(Keys.LZ50_DB_TOTAL_ROWS);

    // Get the STATS
    Vector vStats = (Vector)results.get(Keys.LZ50_STATS);
    MappedRecord rStats = (MappedRecord)vStats.get(0);
    
    // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
    reprocThisRunStat = (String)rStats.get(Keys.LZ50_REPROC_THIS_RUN);
    xcsThisRunStat = (String)rStats.get(Keys.LZ50_XCS_THIS_RUN);
    reprocTotalStat = (String)rStats.get(Keys.LZ50_REPROC_TOTAL);
    xcsTotalStat = (String)rStats.get(Keys.LZ50_XCS_TOTAL);

    
    
/* 26/04/04 changes for S456/S457. Patrick Cogan
 
    deleteThisRunStat = (String)rStats.get(Keys.LZ50_DELETE_THIS_RUN);
    rejectThisRunStat = (String)rStats.get(Keys.LZ50_REJECT_THIS_RUN);
    indivThisRunStat = (String)rStats.get(Keys.LZ50_INDIV_THIS_RUN);
    blockThisRunStat = (String)rStats.get(Keys.LZ50_BLOCK_THIS_RUN);
    zerosThisRunStat = (String)rStats.get(Keys.LZ50_ZEROS_THIS_RUN);
    deleteTotalStat = (String)rStats.get(Keys.LZ50_DELETE_TOTAL);
    rejectTotalStat = (String)rStats.get(Keys.LZ50_REJECT_TOTAL);
    indivTotalStat = (String)rStats.get(Keys.LZ50_INDIV_TOTAL);
    blockTotalStat = (String)rStats.get(Keys.LZ50_BLOCK_TOTAL);
    zerosTotalStat = (String)rStats.get(Keys.LZ50_ZEROS_TOTAL);
*/
  }

  public class Row extends WebModel {

    private String rowNumber;
    private String processFlag;
    private String signingRef;
    private String tableCCr;
    private String tableUcr;
    private String tableBlockInd;
    private String errorMessage;
    private String fileOsnd;
    private String fileCcr;
    private String busClass;
    private String cHolderNo;
    private String contractCode;
    private String contractYear;
    private String blockNumber;


    public Row(  String rowNumber,
                 String processFlag,
                 String signingRef,
                 String tableCCr,
                 String tableUcr,
                 String tableBlockInd,
                 String errorMessage,
                 String fileOsnd,
                 String fileCcr,
                 String busClass,
                 String cHolderNo,
                 String contractCode,
                 String contractYear,
                 String blockNumber) {

      this.rowNumber     = rowNumber;
      this.processFlag   = processFlag;
      this.signingRef    = signingRef;
      this.tableCCr      = tableCCr;
      this.tableUcr      = tableUcr;
      this.tableBlockInd = tableBlockInd;
      this.errorMessage  = errorMessage;
      this.fileOsnd      = fileOsnd;
      this.fileCcr       = fileCcr;
      this.busClass      = busClass;
      this.cHolderNo     = cHolderNo;
      this.contractCode  = contractCode;
      this.contractYear  = contractYear;
      this.blockNumber   = blockNumber;

    }

    public String getRowNumber() {
      return rowNumber;
    }

    public String getAction() {
      return processFlag;
    }

    public String getOsnd() {
      return fileOsnd;
    }

    public String getCcr() {
      return fileCcr;
    }

    public String getCoverholderNo() {
      return cHolderNo;
    }

    public String getContractCode() {
      return contractCode;
    }

    public String getContractYear() {
      return contractYear;
    }

    public String getBlockNumber() {
      return blockNumber;
    }

    public String getTableSignRef() {
      return signingRef;
    }

    public String getTableCcr() {
      return tableCCr;
    }

    public String getUcr() {
      return tableUcr;
    }

    public String getClaimType() {
      return tableBlockInd;
    }

    public String getErrorMessage() {
      return errorMessage;
    }

    public String getClaimTypeDisplay() {
      if (tableBlockInd.equals("N")) {
        return ("Individual");
      }
      else if (tableBlockInd.equals("Y")) {
        return("Block Item");
      }
      else {        // " "
        return ("");
      }
    }

    public String getBusClassDisplay() {
      if (busClass.equals("A")) {
        return("Automotive");
      }
      else if (busClass.equals("C")) {
        return("Commercial");
      }
      else if (busClass.equals("R")) {
        return("Residential");
      }
      else {
        return("");
      }
    }

  }


  public String getFunction() {
    return function;
  }

  public String getBusinessClass() {
    return businessClass;
  }

  public String getRowsFrom() {
    return rowFrom;
  }

  public String getRowsTo() {
    return rowTo;
  }

  public String getRowsTotal() {
    return rowTotal;
  }

  public Enumeration getFieldValues() {
    if (rows == null) {
      return new Vector().elements();
    }
    else {
      return rows.elements();
    }
  }

  public boolean getPrevButtonFlag() {
    return prevButtonFlag;
  }

  public boolean getNextButtonFlag() {
    return nextButtonFlag;
  }

  public boolean getSaveButtonFlag() {
    return savedButtonFlag;
  }

  public boolean getAutomotiveButtonFlag() {
    return autoButtonFlag;
  }

  public boolean getCommercialButtonFlag() {
    return commercialButtonFlag;
  }

  public boolean getResidentialButtonFlag() {
    return residentialButtonFlag;
  }
  
  // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.

    public String getReprocThisRunStat() {
      return reprocThisRunStat;
    }

    public String getXcsThisRunStat() {
      return xcsThisRunStat;
    }

    public String getReprocTotalStat() {
      return reprocTotalStat;
    }

    public String getXcsTotalStat() {
      return xcsTotalStat;
    }


  
  /* 26/04/04 changes for S456/S457, not needed anymore. Patrick Cogan.
  public String getDeleteThisRunStat() {
    return deleteThisRunStat;
  }

  public String getRejectThisRunStat() {
    return rejectThisRunStat;
  }

  public String getIndivThisRunStat() {
    return indivThisRunStat;
  }

  public String getBlockThisRunStat() {
    return blockThisRunStat;
  }

  public String getZerosThisRunStat() {
    return zerosThisRunStat;
  }

  public String getDeleteTotalStat() {
    return deleteTotalStat;
  }

  public String getRejectTotalStat() {
    return rejectTotalStat;
  }

  public String getIndivTotalStat() {
    return indivTotalStat;
  }

  public String getBlockTotalStat() {
    return blockTotalStat;
  }

  public String getZerosTotalStat() {
    return zerosTotalStat;
  }
  */
  
  public String getBusinessClassDisplay() {
    if (businessClass.equals("A")) {
        return("Automotive");
    }
    else if (businessClass.equals("C")) {
        return("Commercial");
    }
    else if (businessClass.equals("R")) {
        return("Residential");
    }
    else {
        return("");
    }
  }

  private boolean convertSavedStringToBoolean(String str) {
    if (str.equals("Y")) {
      return true;
    }
    else {
      return false;
    }
  }

  public String getPrevAttr() {
    return prevAttr;
  }

  public String getNextAttr() {
    return nextAttr;
  }

  public String getSavedFlagString() {
    return savedFlagString;
  }

  public String getAutoAttr() {
    return autoAttr;
  }

  public String getCommercialAttr() {
    return commercialAttr;
  }

  public String getResidentialAttr() {
    return residentialAttr;
  }

  public boolean isSave() {
    if (function.equals("SAVE")) {
      return true;
    } else {
      return false;
    }
  }

}