package com.xchanging.xcc.cics.handlers;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY64Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C064 (LY64)
 Program  - Associated Screen/Process:- Build Bulk Component Selection Screen
 Devo
 */

public class LY64CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C064";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY64Event event = (LY64Event)ce;
    Logger.info("Build Bulk Component Selection Screen - C064 (LY64)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly64");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly64");

        /**
         * Map the user entered data into the MappedRecord
         */
          queryRecord.put(Keys.LY64SessionIDField,Integer.toString(event.getUserSession()));
          queryRecord.put(Keys.LY64_PREV_PRESSED_Field, event.getPREV_PRESSED());
          queryRecord.put(Keys.LY64_NEXT_PRESSED_Field, event.getNEXT_PRESSED());

          MappedRecord aRecord = rf.createMappedRecord("C064_START_KEY");

          aRecord.put(Keys.LY64_START_UCR_Field,event.getSTART_UCR());
          aRecord.put(Keys.LY64_START_SYS_REF_Field,event.getSTART_SYS_REF());

          queryRecord.put("#element[]",new Object[]{aRecord});

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