package com.xchanging.xcc.cics.handlers;

import java.beans.FeatureDescriptor;
import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY44Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SCMAdviceModel;
import com.xchanging.xcc.web.models.ExpertFeeBreakDownModel.ExpertFeeBreakDownDetail;

public class LY44CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C044";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY44Event event = (LY44Event)ce;
    Logger.info("SCM Advice Validation..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly44");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly44");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY44_SESSION_NO,Integer.toString(event.getUserSession()));

        Vector fieldTable = new Vector(1);

        MappedRecord fieldValues = rf.createMappedRecord("C044_FIELD_VALUES");
        fieldValues.put(Keys.LY44_CURR_NO_VAL,event.getCURR_NO_VAL());
        fieldValues.put(Keys.LY44_SDN_NO_VAL,event.getSDN_NO_VAL());
        fieldValues.put(Keys.LY44_BDOWN_NO_VAL,event.getBDOWN_NO_VAL());
        fieldValues.put(Keys.LY44_CLM_REF_REC,event.getCLM_REF_REC());
        fieldValues.put(Keys.LY44_ORIG_CURR,event.getORIG_CURR());
        fieldValues.put(Keys.LY44_SETT_CURR,event.getSETT_CURR());
        fieldValues.put(Keys.LY44_EXCH_RATE,event.getEXCH_RATE());
        fieldValues.put(Keys.LY44_PTD_LOSS,event.getPTD_LOSS());
        fieldValues.put(Keys.LY44_PTD_FEE,event.getPTD_FEE());
        
        // Added JC 28/09/2005
        fieldValues.put(Keys.LY44_PTD_EXP,event.getPTT_EXP());
        
        fieldValues.put(Keys.LY44_PTD_TOTAL,event.getPTD_TOTAL());
        fieldValues.put(Keys.LY44_PTT_LOSS,event.getPTT_LOSS());
        fieldValues.put(Keys.LY44_PTT_EXP,event.getPTT_EXP());
        fieldValues.put(Keys.LY44_PTT_FEE,event.getPTT_FEE());
        fieldValues.put(Keys.LY44_PTT_TOTAL,event.getPTT_TOTAL());
        fieldValues.put(Keys.LY44_OUTST_LOSS,event.getOUTST_LOSS());
        fieldValues.put(Keys.LY44_OUTST_LOSS_QUAL,event.getOUTST_LOSS_QUAL());
        fieldValues.put(Keys.LY44_OUTST_EXP,event.getOUTST_EXP());
        fieldValues.put(Keys.LY44_OUTST_FEE,event.getOUTST_FEE());
        fieldValues.put(Keys.LY44_OUTST_FEE_QUAL,event.getOUTST_FEE_QUAL());
        fieldValues.put(Keys.LY44_OUTST_TOT,event.getOUTST_TOT());
        fieldValues.put(Keys.LY44_OUTST_TOT_QUAL,event.getOUTST_TOT_QUAL());
        fieldValues.put(Keys.LY44_PTD_SETT_AMT,event.getPTD_SETT_AMT());
        fieldValues.put(Keys.LY44_CLAIM_AMT_SETT,event.getCLAIM_AMT_SETT());
        fieldValues.put(Keys.LY44_BUREAU_LINE,event.getBUREAU_LINE());
        fieldValues.put(Keys.LY44_BUR_PROP_AMT,event.getBUR_PROP_AMT());
        fieldValues.put(Keys.LY44_HPC_VAT_AMT,event.getHPC_VAT_AMT());
        fieldValues.put(Keys.LY44_OUTST_TOT,event.getOUTST_TOT());

        // Add the VAT Rates and Amounts
        Vector vatRates = new Vector(6);
        for (int x = 0; x < 6; x++) {
          MappedRecord vatRateRecord = rf.createMappedRecord("C044_VAT_RATE_TABLE");
          vatRateRecord.put(Keys.LY44_VAT_RATE,event.getVAT_RATE()[x]);
          vatRateRecord.put(Keys.LY44_VAT_AMT,event.getVAT_AMT()[x]);
          vatRates.add(vatRateRecord);
        }
        fieldValues.put("#element[]",vatRates.toArray());

        fieldValues.put(Keys.LY44_WAR_AMT,event.getWAR_AMT());
        fieldValues.put(Keys.LY44_NARR_CODE_1,event.getNARR_CODE_1());
        fieldValues.put(Keys.LY44_NARR_CODE_2,event.getNARR_CODE_2());
        fieldValues.put(Keys.LY44_SETT_NARR_1,event.getSETT_NARR_1());
        fieldValues.put(Keys.LY44_SETT_NARR_2,event.getSETT_NARR_2());
        fieldValues.put(Keys.LY44_SETT_NARR_3,event.getSETT_NARR_3());
        fieldValues.put(Keys.LY44_SUBROGATION,event.getSUBROGATION());
        fieldValues.put(Keys.LY44_XCS_REC_REF,event.getXCS_REC_REF());
        fieldValues.put(Keys.LY44_HIGHEST_EST,event.getHIGHEST_EST());
        fieldValues.put(Keys.LY44_INCURRED_AMT,event.getINCURRED_AMT());
        fieldValues.put(Keys.LY44_RATE_EXCH_OUTST,event.getRATE_EXCH_OUTST());
        fieldValues.put(Keys.LY44_FINDER_CODE_1,event.getFINDER_CODE_1());
        fieldValues.put(Keys.LY44_FINDER_CODE_2,event.getFINDER_CODE_2());
        fieldValues.put(Keys.LY44_FINDER_CODE_3,event.getFINDER_CODE_3());
        fieldValues.put(Keys.LY44_ATTACHMENT_IND,event.getATTACHMENT_IND());
        //fieldValues.put(Keys.LY44_CASH_COR,event.getCASH_COR());
        fieldValues.put(Keys.LY44_BKR_CNTCT,event.getBKR_CNTCT());
        fieldValues.put(Keys.LY44_BKR_CNTCT_PHONE,event.getBKR_CNTCT_PHONE());
        fieldValues.put(Keys.LY44_BKR_REF_1,event.getBKR_REF_1());
        fieldValues.put(Keys.LY44_BKR_REF_2,event.getBKR_REF_2());
        fieldValues.put(Keys.LY44_CNTRY_OF_ORIGIN,event.getCNTRY_OF_ORIGIN());
        fieldValues.put(Keys.LY44_ORIG_INSURED,event.getORIG_INSURED());
        fieldValues.put(Keys.LY44_INSURED,event.getINSURED());
        fieldValues.put(Keys.LY44_REINSURED,event.getREINSURED());
        fieldValues.put(Keys.LY44_COVER_HOLDER,event.getCOVER_HOLDER());
        fieldValues.put(Keys.LY44_CLAIMANT,event.getCLAIMANT());
        fieldValues.put(Keys.LY44_VESSEL_AIRCRAFT,event.getVESSEL_AIRCRAFT());
        fieldValues.put(Keys.LY44_OTHER_NAME,event.getOTHER_NAME());
        fieldValues.put(Keys.LY44_POL_CERT_FROM,event.getPOL_CERT_FROM());
        fieldValues.put(Keys.LY44_POL_CERT_TO,event.getPOL_CERT_TO());
        fieldValues.put(Keys.LY44_POL_CERT_QUAL,event.getPOL_CERT_QUAL());
        fieldValues.put(Keys.LY44_LOSS_DATE_FROM,event.getLOSS_DATE_FROM());
        fieldValues.put(Keys.LY44_LOSS_DATE_TO,event.getLOSS_DATE_TO());
        fieldValues.put(Keys.LY44_LOSS_DATE_QUAL,event.getLOSS_DATE_QUAL());
        fieldValues.put(Keys.LY44_CLAIM_DATE_FROM,event.getCLAIM_DATE_FROM());
        fieldValues.put(Keys.LY44_CLAIM_DATE_TO,event.getCLAIM_DATE_TO());
        fieldValues.put(Keys.LY44_CLAIM_DATE_QUAL,event.getCLAIM_DATE_QUAL());
        fieldValues.put(Keys.LY44_CAT_CODE,event.getCAT_CODE());
        fieldValues.put(Keys.LY44_PCS_CAT_CODE,event.getPCS_CAT_CODE());
        fieldValues.put(Keys.LY44_LIMIT_CURR,event.getLIMIT_CURR());
        fieldValues.put(Keys.LY44_SI_LIMIT,event.getSI_LIMIT());
        fieldValues.put(Keys.LY44_EXCESS_AMT,event.getEXCESS_AMT());
        fieldValues.put(Keys.LY44_PERILS_CONDS,event.getPERILS_CONDS());
        fieldValues.put(Keys.LY44_LOSS_LOCATION,event.getLOSS_LOCATION());
        fieldValues.put(Keys.LY44_VOYAGE,event.getVOYAGE());
        fieldValues.put(Keys.LY44_LOSS_NAME,event.getLOSS_NAME());

        Vector claimDetails = new Vector(event.getCLAIM_DETAILS().length);
        for (int x = 0; x < event.getCLAIM_DETAILS().length && x < 3; x++) {
          MappedRecord claimDetLine = rf.createMappedRecord("C044_CLAIM_DETAILS");
          claimDetLine.put("@C044_CLAIM_DET_LINE",event.getCLAIM_DETAILS()[x]);
          claimDetails.add(claimDetLine);
        }
        fieldValues.put("#element[]",claimDetails.toArray());

        fieldValues.put(Keys.LY44_LAWYER_NAME,event.getLAWYER_NAME());
        fieldValues.put(Keys.LY44_LAWYER_REF,event.getLAWYER_REF());
        fieldValues.put(Keys.LY44_LAWYER_CODE,event.getLAWYER_CODE());
        fieldValues.put(Keys.LY44_ADJUSTER_NAME,event.getADJUSTER_NAME());
        fieldValues.put(Keys.LY44_ADJUSTER_REF,event.getADJUSTER_REF());
        fieldValues.put(Keys.LY44_ADJUSTER_CODE,event.getADJUSTER_CODE());
        fieldValues.put(Keys.LY44_SCHEME_CODE,event.getSCHEME_CODE());
        fieldValues.put(Keys.LY44_TF_CODE,event.getTF_CODE());
        fieldValues.put(Keys.LY44_STATE_CODE,event.getSTATE_CODE());
        fieldValues.put(Keys.LY44_NAIC_CODE,event.getNAIC_CODE());
        fieldValues.put(Keys.LY44_NAIC_QUAL,event.getNAIC_QUAL());
        fieldValues.put(Keys.LY44_WAR_IND,event.getWAR_IND());
        fieldValues.put(Keys.LY44_FIL_CODE_1,event.getFIL_CODE_1());
        fieldValues.put(Keys.LY44_FIL_CODE_2,event.getFIL_CODE_2());
        fieldValues.put(Keys.LY44_OTHER_TF_CODE,event.getOTHER_TF_CODE());
        fieldValues.put(Keys.LY44_DTI_CODE,event.getDTI_CODE());
        fieldValues.put(Keys.LY44_USA_CAN_IND,event.getUSA_CAN_IND());
        fieldValues.put(Keys.LY44_COUNTY_CODE,event.getCOUNTY_CODE());
        // CCN #N0031 and N0021 - BA - 15/01/2003
        fieldValues.put(Keys.LY44_LF_ADVANCE_IND,event.getLF_ADVANCED_IND());
        fieldValues.put(Keys.LY44_LF_ENTRY_IND,event.getLF_ENTRY_IND());
        fieldValues.put(Keys.LY44_BLOCK_IND,event.getBLOCK_IND());
		fieldValues.put(Keys.LY44_DIRECT_REPORT_IND,event.getDIRECT_REPORT_IND());
		fieldValues.put(Keys.LY44_LITIGATION_IND,event.getLITIGATION_IND());
                fieldValues.put(Keys.LY44_SERVICE_TPYE,event.getSERVICE_TYPE());
        // TP866603 -Changes for barcode field 
        fieldValues.put(Keys.LY44_BARCODE,event.getBARCODE());

        // CCN69
        fieldValues.put(Keys.LY44_LOSS_DATE_NARR,event.getLOSS_DATE_NARR());

        /*
        Vector causeCodes = new Vector(1);

        MappedRecord causeCodesRecord = rf.createMappedRecord("C044_CAUSE_CODE_TABLE");
        causeCodesRecord.put(Keys.LY44_CAUSE_CODE,event.getCAUSE_CODE()[0]);

        Logger.info("++++++++++++++++++++++++++ " + event.getCAUSE_CODE()[0]);
        causeCodesRecord.put(Keys.LY44_CAUSE_CODE,event.getCAUSE_CODE()[1]);
        causeCodesRecord.put(Keys.LY44_CAUSE_CODE,event.getCAUSE_CODE()[2]);
        causeCodesRecord.put(Keys.LY44_CAUSE_CODE,event.getCAUSE_CODE()[3]);
        causeCodesRecord.put(Keys.LY44_CAUSE_CODE,event.getCAUSE_CODE()[4]);
        causeCodesRecord.put(Keys.LY44_CAUSE_CODE,event.getCAUSE_CODE()[5]);
        causeCodes.add(causeCodesRecord);
        fieldValues.put("#element[]",causeCodes.toArray());
        */

        
        /********************
         * Expert Fee Breakdown *************/
        
        /*Expert Count*/
        fieldValues.put(Keys.LY44_EXPERT_COUNT,event.getExpertCount());
        
        /*Expert Details*/
        Vector vctExpertDetails = new Vector();
        
        Vector vctExpertFeeBreakDownROWS = event.getExpertFeeBreakDownDetails();
        Enumeration enExpertFeeBreakDownROWS = vctExpertFeeBreakDownROWS.elements();
        
        while (enExpertFeeBreakDownROWS.hasMoreElements())
        {
            ExpertFeeBreakDownDetail expertFeeBreakDownDetail = (ExpertFeeBreakDownDetail)enExpertFeeBreakDownROWS.nextElement();
            
            MappedRecord mrExpertFeeBDRecord = rf.createMappedRecord("C044_EXPERT_DETAILS");
            
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_CODE,expertFeeBreakDownDetail.getStrExpertCode());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_TYPE,expertFeeBreakDownDetail.getStrExpertType());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_REF,expertFeeBreakDownDetail.getStrExpertRef());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_SCM,expertFeeBreakDownDetail.getStrExpertSCM());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_NAME,expertFeeBreakDownDetail.getStrExpertName());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_CNTCT,expertFeeBreakDownDetail.getStrExpertCNTCT());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_PTD_EXP,expertFeeBreakDownDetail.getStrExpertPTDExp());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_PTD_FEE,expertFeeBreakDownDetail.getStrExpertPTDFee());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_PTT_EXP,expertFeeBreakDownDetail.getStrExpertPTTExp());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_PTT_FEE,expertFeeBreakDownDetail.getStrExpertPTTFee());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_OS_EXP,expertFeeBreakDownDetail.getStrExpertOSExp());
            mrExpertFeeBDRecord.put(Keys.LY44_EXPERT_OS_FEE,expertFeeBreakDownDetail.getStrExpertOSFee());
            
            vctExpertDetails.add(mrExpertFeeBDRecord);

        }
        fieldValues.put("#element[]",vctExpertDetails.toArray());
        
        /*********************/
        
        
        
        fieldTable.add(fieldValues);
        queryRecord.put("#element[]",fieldTable.toArray());

        /**
         * Execute the query
         */
        Record oRec = interaction.execute(iSpeq, queryRecord);
        writeXML(oRec);

        results = (MappedRecord)oRec;
        int errorCount = errorsFound(results,fieldHdr);
        int warningCount = warningsFound(results,fieldHdr);

        /**
         * Check for errors
         */
        if (errorCount > 0) {
          processErrors(results,fieldHdr);
        }
        /**
         * Check for warnings
         */
        else if (warningCount > 0) {
          processWarnings(results,fieldHdr);
        }

      }
      catch (ClaimsErrorException cee) {        
        throw new ClaimsErrorException(cee.getErrors());
      }
      catch (ClaimsWarningException cee) {
        throw new ClaimsWarningException(cee.getWarnings());
      }
      catch (Exception re) {
        throw new GeneralFailureException(re.getMessage());
      }
  }
}
