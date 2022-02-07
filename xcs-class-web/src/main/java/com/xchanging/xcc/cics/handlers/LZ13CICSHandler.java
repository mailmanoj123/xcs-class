package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ13Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C112 (LZ13)
 Program  - Associated Screen/Process:- 'Re-advice Screen Validation'
 */

public class LZ13CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C112";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LZ13Event event = (LZ13Event)ce;
    Logger.info("Re-advice Screen Validation..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("lz13");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("lz13");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LZ13_SESSION_NO,Integer.toString(event.getUserSession()));

        Vector fieldTable = new Vector(1);

        MappedRecord fieldValues = rf.createMappedRecord("C112_FIELD_VALUES");
        fieldValues.put(Keys.LZ13_CURR_NARR_1,event.getCURR_NARR_1());
        fieldValues.put(Keys.LZ13_NARR_CODE_1,event.getNARR_CODE_1());
        fieldValues.put(Keys.LZ13_CURR_NARR_2A,event.getCURR_NARR_2A());
        fieldValues.put(Keys.LZ13_NARR_CODE_2,event.getNARR_CODE_2());
        fieldValues.put(Keys.LZ13_CURR_NARR_2B,event.getCURR_NARR_2B());

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