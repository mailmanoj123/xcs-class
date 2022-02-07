package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY39Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY39CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C039";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY39Event event = (LY39Event)ce;
    Logger.info("Financial Details Screen DB Updates...");

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Policy Check 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly39");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly39");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY39_SESSION_NO,Integer.toString(event.getUserSession()));

        MappedRecord aRecord = rf.createMappedRecord("C039_FIELD_VALUES");
        Vector fieldTable = new Vector(1);

        aRecord.put(Keys.LY39_XCR,event.getXCR());
        aRecord.put(Keys.LY39_UCR,event.getUCR());
        aRecord.put(Keys.LY39_TR,event.getTR());
        aRecord.put(Keys.LY39_ORIG_REF_1,event.getORIG_REF_1());
        aRecord.put(Keys.LY39_ORIG_REF_2,event.getORIG_REF_2());
        aRecord.put(Keys.LY39_ORIG_REF_3,event.getORIG_REF_3());
        aRecord.put(Keys.LY39_ORIG_BKR,event.getORIG_BKR());
        aRecord.put(Keys.LY39_SIGNED_IND,event.getSIGNED_IND());
        aRecord.put(Keys.LY39_PEER_REV_IND,event.getPEER_REV_IND());
        aRecord.put(Keys.LY39_PAYEE_BKR_CODE,event.getPAYEE_BKR_CODE());
        aRecord.put(Keys.LY39_PAYEE_BKR_PSEUD,event.getPAYEE_BKR_PSEUD());
		aRecord.put(Keys.LY39_BKR_TR,event.getBKR_TR());
		aRecord.put(Keys.LY39_BKR_TR_QUAL,event.getBKR_TR_QL());
        aRecord.put(Keys.LY39_REDENOM_IND,event.getREDENOM_IND());
        aRecord.put(Keys.LY39_ORIG_CURR,event.getORIG_CURR());
        aRecord.put(Keys.LY39_SETT_CURR,event.getSETT_CURR());
        aRecord.put(Keys.LY39_SETT_IND,event.getSETT_IND());
        aRecord.put(Keys.LY39_EXCH_RATE,event.getEXCH_RATE());
        aRecord.put(Keys.LY39_PAYED_TO_DATE,event.getPAYED_TO_DATE());
        aRecord.put(Keys.LY39_PAYED_THIS_TIME,event.getPAYED_THIS_TIME());
        aRecord.put(Keys.LY39_OUTST_AMT,event.getOUTST_AMT());
        aRecord.put(Keys.LY39_OUTST_QUAL,event.getOUTST_QUAL());
        aRecord.put(Keys.LY39_CLAIM_AMT_SETT,event.getCLAIM_AMT_SETT());
        aRecord.put(Keys.LY39_TOTAL_LINE,event.getTOTAL_LINE());
        aRecord.put(Keys.LY39_BUR_PROP_AMT,event.getBUR_PROP_AMT());
        aRecord.put(Keys.LY39_HPC_VAT_AMT,event.getHPC_VAT_AMT());
        aRecord.put(Keys.LY39_WAR_AMT,event.getWAR_AMT());
        aRecord.put(Keys.LY39_INCURRED_AMT,event.getINCURRED_AMT());

        //Binders changes..
        aRecord.put(Keys.LY39_INDV_UCR,event.getIndividualUCR());
        aRecord.put(Keys.LY39_INDV_TR,event.getIndividualTR());
           
        fieldTable.add(aRecord);
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