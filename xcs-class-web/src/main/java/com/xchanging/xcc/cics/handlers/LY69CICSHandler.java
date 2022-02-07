package com.xchanging.xcc.cics.handlers;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY69Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY69CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C069";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY69Event event = (LY69Event)ce;
    Logger.info("Build Transaction History...");

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Policy Check 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly69");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly69");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY69_SESSION_NO,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY69_NEXT_PRESSED,event.getNEXT_PRESSED());
        queryRecord.put(Keys.LY69_PREV_PRESSED,event.getPREV_PRESSED());
        queryRecord.put(Keys.LY69_START_SYS_REF,event.getSTART_SYS_REF());

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