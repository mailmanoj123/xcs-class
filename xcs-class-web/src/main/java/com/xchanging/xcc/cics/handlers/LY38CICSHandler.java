package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY38Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C038 (LY38)
 Program  - Associated Screen/Process:- Financial Details Screen Validation
 Devo
 */

public class LY38CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C038";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY38Event event = (LY38Event)ce;
    Logger.info("Financial Details Screen Validation- C038 (LY38)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly38");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly38");

        /**
         * Map the user entered data into the MappedRecord
         */
          queryRecord.put(Keys.LY38_SESSION_NO_Field,Integer.toString(event.getUserSession()));

          MappedRecord aRecord = rf.createMappedRecord("C038_FIELD_VALUES");
          Vector fieldTable = new Vector(1);



          //MappedRecord aRecord = rf.createMappedRecord(Keys.LY38_FIELD_VALUES_Table);

          aRecord.put(Keys.LY38_BUR_PROP_AMT_Field,event.getBUR_PROP_AMT());
          aRecord.put(Keys.LY38_CLAIM_AMT_SETT_Field,event.getCLAIM_AMT_SETT());
          aRecord.put(Keys.LY38_EXCH_RATE_Field,event.getEXCH_RATE());
          aRecord.put(Keys.LY38_HPC_VAT_AMT_Field,event.getHPC_VAT_AMT());
          aRecord.put(Keys.LY38_INCURRED_AMT_Field,event.getINCURRED_AMT());
          aRecord.put(Keys.LY38_ORIG_CURR_Field,event.getORIG_CURR());
          aRecord.put(Keys.LY38_OUTST_AMT_Field,event.getOUTST_AMT());
          aRecord.put(Keys.LY38_OUTST_QUAL_Field,event.getOUTST_QUAL());
          aRecord.put(Keys.LY38_PAYED_THIS_TIME_Field,event.getPAYED_THIS_TIME());
          aRecord.put(Keys.LY38_PAYED_TO_DATE_Field,event.getPAYED_TO_DATE());
          aRecord.put(Keys.LY38_PAYEE_BKR_CODE_Field,event.getPAYEE_BKR_CODE());
          aRecord.put(Keys.LY38_PAYEE_BKR_PSEUD_Field,event.getPAYEE_BKR_PSEUD());
		  aRecord.put(Keys.LY38_BKR_TR_Field,event.getBKR_TR());
		  aRecord.put(Keys.LY38_BKR_TR_QL_Field,event.getBKR_TR_QL());
          /* Removed PREV_AMT_SETT for CCN #41
          aRecord.put(Keys.LY38_PREV_AMT_SETT_Field,event.getPREV_AMT_SETT());
          */
          aRecord.put(Keys.LY38_REDENOM_IND_Field,event.getREDENOM_IND());
          aRecord.put(Keys.LY38_SETT_CURR_Field,event.getSETT_CURR());
          aRecord.put(Keys.LY38_SETT_IND_Field,event.getSETT_IND());
          aRecord.put(Keys.LY38_TOTAL_LINE_Field,event.getTOTAL_LINE());
          aRecord.put(Keys.LY38_WAR_AMT_Field,event.getWAR_AMT());

          aRecord.put(Keys.LY38_PEER_REV_IND_Field,event.getPEER_REV_IND());

      
          Logger.info("LY38_INDV_UCR:"+event.getIndividualUCR());
          Logger.info("LY38_INDV_TR:"+event.getIndividualTR());
          
          
       
          aRecord.put(Keys.LY38_INDV_UCR,event.getIndividualUCR());
          aRecord.put(Keys.LY38_INDV_TR,event.getIndividualTR());

          fieldTable.add(aRecord);
          queryRecord.put("#element[]",fieldTable.toArray());

          // NOTE::
          // Need to strip out the field errors from this document at some stage.


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