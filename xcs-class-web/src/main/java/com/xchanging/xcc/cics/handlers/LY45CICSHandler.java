package com.xchanging.xcc.cics.handlers;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY45Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ExpertFeeBreakDownModel.ExpertFeeBreakDownDetail;

public class LY45CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C045";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY45Event event = (LY45Event)ce;
    Logger.info("SCM Advice DB Upadate..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly45");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly45");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY45_SESSION_NO,Integer.toString(event.getUserSession()));

        Vector fieldTable = new Vector(1);

        MappedRecord fieldValues = rf.createMappedRecord("C045_FIELD_VALUES");

        //XXX fieldValues.put(Keys.LY45_CURR_NO_VAL,event.getCURR_NO_VAL());
        //XXX fieldValues.put(Keys.LY45_SDN_NO_VAL,event.getSDN_NO_VAL());
        //XXX fieldValues.put(Keys.LY45_BDOWN_NO_VAL,event.getBDOWN_NO_VAL());

        fieldValues.put(Keys.LY45_XCR,event.getXCR());
        fieldValues.put(Keys.LY45_UCR,event.getUCR());
        fieldValues.put(Keys.LY45_TR,event.getTR());
        fieldValues.put(Keys.LY45_ORIG_REF,event.getORIG_REF());
        fieldValues.put(Keys.LY45_ORIG_BKR,event.getORIG_BKR());
        fieldValues.put(Keys.LY45_SIGNED_IND,event.getSIGNED_IND());
        fieldValues.put(Keys.LY45_PEER_REV_IND,event.getPEER_REV_IND());
        fieldValues.put(Keys.LY45_ORIG_CURR_HDR,event.getORIG_CURR_HDR());
        fieldValues.put(Keys.LY45_COR,event.getCOR());
        fieldValues.put(Keys.LY45_LOC_IND,event.getLOC_IND());
        fieldValues.put(Keys.LY45_PAYEE_BKR_CODE,event.getPAYEE_BKR_CODE());
        fieldValues.put(Keys.LY45_REDENOM_IND,event.getREDENOM_IND());
        fieldValues.put(Keys.LY45_MOVE_REF,event.getMOVE_REF());
        fieldValues.put(Keys.LY45_CLM_REF_REC,event.getCLM_REF_REC());
        fieldValues.put(Keys.LY45_ORIG_CURR,event.getORIG_CURR());
        fieldValues.put(Keys.LY45_SETT_CURR,event.getSETT_CURR());
        fieldValues.put(Keys.LY45_EXCH_RATE,event.getEXCH_RATE());
        fieldValues.put(Keys.LY45_PTD_LOSS,event.getPTD_LOSS());
        fieldValues.put(Keys.LY45_PTD_EXP,event.getPTD_EXP());
        fieldValues.put(Keys.LY45_PTD_FEE,event.getPTD_FEE());
        fieldValues.put(Keys.LY45_PTD_TOTAL,event.getPTD_TOTAL());
        fieldValues.put(Keys.LY45_PTT_LOSS,event.getPTT_LOSS());
        fieldValues.put(Keys.LY45_PTT_EXP,event.getPTT_EXP());
        fieldValues.put(Keys.LY45_PTT_FEE,event.getPTT_FEE());
        fieldValues.put(Keys.LY45_PTT_TOTAL,event.getPTT_TOTAL());
        fieldValues.put(Keys.LY45_OUTST_LOSS,event.getOUTST_LOSS());
        fieldValues.put(Keys.LY45_OUTST_LOSS_QUAL,event.getOUTST_LOSS_QUAL());
        fieldValues.put(Keys.LY45_OUTST_EXP,event.getOUTST_EXP());
        fieldValues.put(Keys.LY45_OUTST_FEE,event.getOUTST_FEE());
        fieldValues.put(Keys.LY45_OUTST_FEE_QUAL,event.getOUTST_FEE_QUAL());
        fieldValues.put(Keys.LY45_OUTST_TOT,event.getOUTST_TOT());
        fieldValues.put(Keys.LY45_OUTST_TOT_QUAL,event.getOUTST_TOT_QUAL());
        fieldValues.put(Keys.LY45_PTD_SETT_AMT,event.getPTD_SETT_AMT());
        fieldValues.put(Keys.LY45_CLAIM_AMT_SETT,event.getCLAIM_AMT_SETT());
        fieldValues.put(Keys.LY45_BUREAU_LINE,event.getBUREAU_LINE());
        fieldValues.put(Keys.LY45_BUR_PROP_AMT,event.getBUR_PROP_AMT());
        fieldValues.put(Keys.LY45_HPC_VAT_AMT,event.getHPC_VAT_AMT());

        // Add the VAT Rates and Amounts
        Vector vatRates = new Vector(6);
        for (int x = 0; x < 6; x++) {
          MappedRecord vatRateRecord = rf.createMappedRecord("C045_VAT_RATE_TABLE");
          vatRateRecord.put(Keys.LY45_VAT_RATE,event.getVAT_RATE()[x]);
          vatRateRecord.put(Keys.LY45_VAT_AMT,event.getVAT_AMT()[x]);
          vatRates.add(vatRateRecord);
        }
        fieldValues.put("#element[]",vatRates.toArray());

        fieldValues.put(Keys.LY45_WAR_AMT,event.getWAR_AMT());
        fieldValues.put(Keys.LY45_NARR_CODE_1,event.getNARR_CODE_1());
        fieldValues.put(Keys.LY45_NARR_CODE_2,event.getNARR_CODE_2());
        fieldValues.put(Keys.LY45_SETT_NARR_1,event.getSETT_NARR_1());
        fieldValues.put(Keys.LY45_SETT_NARR_2,event.getSETT_NARR_2());
        fieldValues.put(Keys.LY45_SETT_NARR_3,event.getSETT_NARR_3());
        fieldValues.put(Keys.LY45_SUBROGATION,event.getSUBROGATION());
        fieldValues.put(Keys.LY45_XCS_REC_REF,event.getXCS_REC_REF());
        fieldValues.put(Keys.LY45_HIGHEST_EST,event.getHIGHEST_EST());
        fieldValues.put(Keys.LY45_INCURRED_AMT,event.getINCURRED_AMT());
        fieldValues.put(Keys.LY45_RATE_EXCH_OUTST,event.getRATE_EXCH_OUTST());
        fieldValues.put(Keys.LY45_FINDER_CODE_1,event.getFINDER_CODE_1());
        fieldValues.put(Keys.LY45_FINDER_CODE_2,event.getFINDER_CODE_2());
        fieldValues.put(Keys.LY45_FINDER_CODE_3,event.getFINDER_CODE_3());
        fieldValues.put(Keys.LY45_ATTACHMENT_IND,event.getATTACHMENT_IND());
        //fieldValues.put(Keys.LY45_CASH_COR,event.getCASH_COR());
        fieldValues.put(Keys.LY45_BKR_CNTCT,event.getBKR_CNTCT());
        fieldValues.put(Keys.LY45_BKR_CNTCT_PHONE,event.getBKR_CNTCT_PHONE());
        fieldValues.put(Keys.LY45_BKR_REF_1,event.getBKR_REF_1());
        fieldValues.put(Keys.LY45_BKR_REF_2,event.getBKR_REF_2());
        fieldValues.put(Keys.LY45_CNTRY_OF_ORIGIN,event.getCNTRY_OF_ORIGIN());
        fieldValues.put(Keys.LY45_ORIG_INSURED,event.getORIG_INSURED());
        fieldValues.put(Keys.LY45_INSURED,event.getINSURED());
        fieldValues.put(Keys.LY45_REINSURED,event.getREINSURED());
        fieldValues.put(Keys.LY45_COVER_HOLDER,event.getCOVER_HOLDER());
        fieldValues.put(Keys.LY45_CLAIMANT,event.getCLAIMANT());
        fieldValues.put(Keys.LY45_VESSEL_AIRCRAFT,event.getVESSEL_AIRCRAFT());
        fieldValues.put(Keys.LY45_OTHER_NAME,event.getOTHER_NAME());
        fieldValues.put(Keys.LY45_POL_CERT_FROM,event.getPOL_CERT_FROM());
        fieldValues.put(Keys.LY45_POL_CERT_TO,event.getPOL_CERT_TO());
        fieldValues.put(Keys.LY45_POL_CERT_QUAL,event.getPOL_CERT_QUAL());
        fieldValues.put(Keys.LY45_LOSS_DATE_FROM,event.getLOSS_DATE_FROM());
        fieldValues.put(Keys.LY45_LOSS_DATE_TO,event.getLOSS_DATE_TO());
        fieldValues.put(Keys.LY45_LOSS_DATE_QUAL,event.getLOSS_DATE_QUAL());
        fieldValues.put(Keys.LY45_CLAIM_DATE_FROM,event.getCLAIM_DATE_FROM());
        fieldValues.put(Keys.LY45_CLAIM_DATE_TO,event.getCLAIM_DATE_TO());
        fieldValues.put(Keys.LY45_CLAIM_DATE_QUAL,event.getCLAIM_DATE_QUAL());
        fieldValues.put(Keys.LY45_CAT_CODE,event.getCAT_CODE());
        fieldValues.put(Keys.LY45_PCS_CAT_CODE,event.getPCS_CAT_CODE());
        fieldValues.put(Keys.LY45_LIMIT_CURR,event.getLIMIT_CURR());
        fieldValues.put(Keys.LY45_SI_LIMIT,event.getSI_LIMIT());
        fieldValues.put(Keys.LY45_EXCESS_AMT,event.getEXCESS_AMT());
        fieldValues.put(Keys.LY45_PERILS_CONDS,event.getPERILS_CONDS());
        fieldValues.put(Keys.LY45_LOSS_LOCATION,event.getLOSS_LOCATION());
        fieldValues.put(Keys.LY45_VOYAGE,event.getVOYAGE());
        fieldValues.put(Keys.LY45_LOSS_NAME,event.getLOSS_NAME());

        Vector claimDetails = new Vector(event.getCLAIM_DETAILS().length);
        for (int x = 0; x < event.getCLAIM_DETAILS().length && x < 3; x++) {
          MappedRecord claimDetLine = rf.createMappedRecord("C045_CLAIM_DETAILS");
          claimDetLine.put("@C045_CLAIM_DET_LINE",event.getCLAIM_DETAILS()[x]);
          claimDetails.add(claimDetLine);
        }
        fieldValues.put("#element[]",claimDetails.toArray());

        fieldValues.put(Keys.LY45_LAWYER_NAME,event.getLAWYER_NAME());
        fieldValues.put(Keys.LY45_LAWYER_REF,event.getLAWYER_REF());
        fieldValues.put(Keys.LY45_LAWYER_CODE,event.getLAWYER_CODE());
        fieldValues.put(Keys.LY45_ADJUSTER_NAME,event.getADJUSTER_NAME());
        fieldValues.put(Keys.LY45_ADJUSTER_REF,event.getADJUSTER_REF());
        fieldValues.put(Keys.LY45_ADJUSTER_CODE,event.getADJUSTER_CODE());
        fieldValues.put(Keys.LY45_SCHEME_CODE,event.getSCHEME_CODE());
        fieldValues.put(Keys.LY45_TF_CODE,event.getTF_CODE());
        fieldValues.put(Keys.LY45_STATE_CODE,event.getSTATE_CODE());
        fieldValues.put(Keys.LY45_NAIC_CODE,event.getNAIC_CODE());
        fieldValues.put(Keys.LY45_NAIC_QUAL,event.getNAIC_QUAL());
        fieldValues.put(Keys.LY45_WAR_IND,event.getWAR_IND());
        fieldValues.put(Keys.LY45_FIL_CODE_1,event.getFIL_CODE_1());
        fieldValues.put(Keys.LY45_FIL_CODE_2,event.getFIL_CODE_2());
        fieldValues.put(Keys.LY45_OTHER_TF_CODE,event.getOTHER_TF_CODE());
        fieldValues.put(Keys.LY45_DTI_CODE,event.getDTI_CODE());
        fieldValues.put(Keys.LY45_USA_CAN_IND,event.getUSA_CAN_IND());
        fieldValues.put(Keys.LY45_COUNTY_CODE,event.getCOUNTY_CODE());

        // CCN #N0031 and N0021 - BA - 15/01/2003
        fieldValues.put(Keys.LY45_LF_ADVANCE_IND,event.getLF_ADVANCED_IND());
        fieldValues.put(Keys.LY45_LF_ENTRY_IND,event.getLF_ENTRY_IND());
        fieldValues.put(Keys.LY45_BLOCK_IND,event.getBLOCK_IND());
		fieldValues.put(Keys.LY45_DIRECT_REPORT_IND,event.getDIRECT_REPORT_IND());
		fieldValues.put(Keys.LY45_LITIGATION_IND,event.getLITIGATION_IND());
        fieldValues.put(Keys.LY45_SERVICE_TYPE,event.getSERVICE_TYPE());
       // TP866603 -Changes for barcode field
        fieldValues.put(Keys.LY45_BARCODE,event.getBARCODE());

        // CCN 69
        fieldValues.put(Keys.LY45_LOSS_DATE_NARR,event.getLOSS_DATE_NARR());


        /*
        Vector causeCodes = new Vector(1);
        MappedRecord causeCodesRecord = rf.createMappedRecord("C045_CAUSE_CODE_TABLE");
        causeCodesRecord.put(Keys.LY45_CAUSE_CODE,event.getCAUSE_CODE()[0]);
        causeCodesRecord.put(Keys.LY45_CAUSE_CODE,event.getCAUSE_CODE()[1]);
        causeCodesRecord.put(Keys.LY45_CAUSE_CODE,event.getCAUSE_CODE()[2]);
        causeCodesRecord.put(Keys.LY45_CAUSE_CODE,event.getCAUSE_CODE()[3]);
        causeCodesRecord.put(Keys.LY45_CAUSE_CODE,event.getCAUSE_CODE()[4]);
        causeCodesRecord.put(Keys.LY45_CAUSE_CODE,event.getCAUSE_CODE()[5]);
        causeCodes.add(causeCodesRecord);
        fieldValues.put("#element[]",causeCodes.toArray());
        */

        /********************
         * Expert Fee Breakdown *************/
        
        /*Expert Count*/
        fieldValues.put(Keys.LY45_EXPERT_COUNT,event.getExpertCount());
        
        /*Expert Details*/
        Vector vctExpertDetails = new Vector();
        Vector vctExpertFeeBDDetails = event.getExpertFeeBreakDownDetails();
        Enumeration enExpertFeeBreakDownROWS = vctExpertFeeBDDetails.elements();
        
        while (enExpertFeeBreakDownROWS.hasMoreElements())
        {
            ExpertFeeBreakDownDetail expertFeeBreakDownDetail = (ExpertFeeBreakDownDetail)enExpertFeeBreakDownROWS.nextElement();
            
            MappedRecord mrExpertFeeBDRecord = rf.createMappedRecord("C045_EXPERT_DETAILS");
            
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_CODE,expertFeeBreakDownDetail.getStrExpertCode());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_TYPE,expertFeeBreakDownDetail.getStrExpertType());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_REF,expertFeeBreakDownDetail.getStrExpertRef());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_SCM,expertFeeBreakDownDetail.getStrExpertSCM());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_NAME,expertFeeBreakDownDetail.getStrExpertName());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_CNTCT,expertFeeBreakDownDetail.getStrExpertCNTCT());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_PTD_EXP,expertFeeBreakDownDetail.getStrExpertPTDExp());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_PTD_FEE,expertFeeBreakDownDetail.getStrExpertPTDFee());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_PTT_EXP,expertFeeBreakDownDetail.getStrExpertPTTExp());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_PTT_FEE,expertFeeBreakDownDetail.getStrExpertPTTFee());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_OS_EXP,expertFeeBreakDownDetail.getStrExpertOSExp());
            mrExpertFeeBDRecord.put(Keys.LY45_EXPERT_OS_FEE,expertFeeBreakDownDetail.getStrExpertOSFee());
            
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
