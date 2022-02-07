package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY70Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C070 (LY70)
 Program  - Associated Screen/Process:- Build Movement History Screen
 Devo
 */

public class LY70CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C070";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY70Event event = (LY70Event)ce;
    Logger.info("Build Movement History Screen- C070 (LY70)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly70");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly70");

        /**
         * Map the user entered data into the MappedRecord
         */
          queryRecord.put(Keys.LY70_SessionID_Field,Integer.toString(event.getUserSession()));

          queryRecord.put(Keys.LY70_NEXT_PRESSED_Field, event.getNEXT_PRESSED());
          queryRecord.put(Keys.LY70_PREV_PRESSED_Field, event.getPREV_PRESSED());

          MappedRecord aRecord = rf.createMappedRecord("C070_START_KEY");

          aRecord.put(Keys.LY70_START_SYS_REF_Field,event.getSTART_SYS_REF());
          aRecord.put(Keys.LY70_START_CURR_NO_Field,event.getSTART_CURR_NO());
          aRecord.put(Keys.LY70_START_SDN_NO_Field,event.getSTART_SDN_NO());
          aRecord.put(Keys.LY70_START_SPLIT_NO_Field,event.getSTART_SPLIT_NO());
          aRecord.put(Keys.LY70_START_BDOWN_NO_Field,event.getSTART_BDOWN_NO());

          Vector v = new Vector(1);
          v.add(aRecord);

          queryRecord.put("#element[]",v.toArray());

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