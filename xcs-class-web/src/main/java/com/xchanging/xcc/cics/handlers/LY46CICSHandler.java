package com.xchanging.xcc.cics.handlers;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY46Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C046 (LY46)
 Program - Associated Screen/Process:- Check whether Currency/Transaction
                                        Validation Required
 Devo
 */

public class LY46CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C046";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY46Event event = (LY46Event)ce;
    Logger.info("Associated Screen/Process- LY46 (CO46) " + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly46");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly46");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY46_SessionID_Field,Integer.toString(event.getUserSession()));

        queryRecord.put(Keys.LY46_NEW_UCR_TR_SYS_REF_Field,event.getNEW_UCR_TR_SYS_REF());
        queryRecord.put(Keys.LY46_NEW_CURR_NO_Field,event.getNEW_CURR_NO());
        queryRecord.put(Keys.LY46_NEW_SDN_NO_Field,event.getNEW_SDN_NO());
        queryRecord.put(Keys.LY46_NEW_STAT_SPLIT_NO_Field,event.getNEW_STAT_SPLIT_NO());
        queryRecord.put(Keys.LY46_NEW_BREAKDOWN_NO_Field,event.getNEW_BREAKDOWN_NO());
        queryRecord.put(Keys.LY46_NEXT_PROGRAM_Field,event.getNEXT_PROGRAM());

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