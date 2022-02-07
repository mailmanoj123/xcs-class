package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY99Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C099 (LY99)
 Program  - Associated Screen/Process:-  Store Selected/Deselected Components
 Devo
 */

public class LY99CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C099";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY99Event event = (LY99Event)ce;
    Logger.info("Store Selected/Deselected Components- LY99 (CO99) " + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly99");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly99");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY99_SessionID_Field,Integer.toString(event.getUserSession()));

        Vector compDets = new Vector();

        for (int i=0; i<event.getCompSysRef().length; i++) {
          MappedRecord componentDetails = rf.createMappedRecord("C099_COMPONENT_DETAILS");
          componentDetails.put(Keys.LY99_COMP_SYS_REF,event.getCompSysRef()[i]);
          componentDetails.put(Keys.LY99_INCLUDE_IND,event.getIncludeInd()[i]);

          compDets.add(componentDetails);
        }

        queryRecord.put("#element[]",compDets.toArray());

        /**
         * Execute the query
         */
        Record oRec = interaction.execute(iSpeq, queryRecord);
        writeXML(oRec);

        results = (MappedRecord)oRec;
        int errorCount = errorsFound(results,fieldHdr);
        int warningCount = warningsFound(results,fieldHdr);

        if (errorCount > 0) {
          processErrors(results,fieldHdr);
        }
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
