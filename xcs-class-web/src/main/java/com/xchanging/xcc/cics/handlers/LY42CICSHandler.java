package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY42Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY42CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C042";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY42Event event = (LY42Event)ce;
    Logger.info("Single claim loss DB Update..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly42");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly42");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY42_SESSION_NO,Integer.toString(event.getUserSession()));

        MappedRecord fieldValues = rf.createMappedRecord("C042_FIELD_VALUES");
        Vector fieldTable = new Vector(1);

        fieldValues.put(Keys.LY42_XCR,event.getXCR());
        fieldValues.put(Keys.LY42_UCR,event.getUCR());
        fieldValues.put(Keys.LY42_TR,event.getTR());
        fieldValues.put(Keys.LY42_ORIG_REF,event.getORIG_REF());
        fieldValues.put(Keys.LY42_ORIG_BKR,event.getORIG_BKR());
        fieldValues.put(Keys.LY42_SIGNED_IND,event.getSIGNED_IND());
        fieldValues.put(Keys.LY42_PEER_REV_IND,event.getPEER_REV_IND());
        fieldValues.put(Keys.LY42_ORIG_CURR,event.getORIG_CURR());
        fieldValues.put(Keys.LY42_COR,event.getCOR());
        fieldValues.put(Keys.LY42_LOC_IND,event.getLOC_IND());
        fieldValues.put(Keys.LY42_MOVE_REF,event.getMOVE_REF());
        fieldValues.put(Keys.LY42_LR_ADJ_DATE,event.getLR_ADJ_DATE());
        fieldValues.put(Keys.LY42_LR_REFUNDED,event.getLR_REFUNDED());
        fieldValues.put(Keys.LY42_LR_PAID_CLAIM,event.getLR_PAID_CLAIM());
        fieldValues.put(Keys.LY42_LR_ADVANCED,event.getLR_ADVANCED());
        fieldValues.put(Keys.LY42_LR_INTEREST,event.getLR_INTEREST());
        fieldValues.put(Keys.LY42_LR_TAX,event.getLR_TAX());
        fieldValues.put(Keys.LY42_LR_NET_AMT,event.getLR_NET_AMT());
        fieldValues.put(Keys.LY42_LR_OUTST_AMT,event.getLR_OUTST_AMT());
        fieldValues.put(Keys.LY42_LR_OUTST_QUAL,event.getLR_OUTST_QUAL());

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