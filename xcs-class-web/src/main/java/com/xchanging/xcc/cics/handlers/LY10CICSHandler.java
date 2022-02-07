package com.xchanging.xcc.cics.handlers;

/**
 * <p>Title: LY10CICSHandler</p>
 * <p>Description: LY10 CICS Handler - Update Session Record </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Steria</p>
 * @author Brian Ambrose
 * @version 1.0
 */

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY10Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY10CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C010";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY10Event event = (LY10Event)ce;
    Logger.info("Updating Session Record..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly10");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly10");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY10SessionIDField,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY10_UCR_TR_SYS_REF_Field,event.getUCR_TR_SYSREF());
        queryRecord.put(Keys.LY10_CURR_NO_Field,event.getCURR_NO());
        queryRecord.put(Keys.LY10_SDN_NO_Field,event.getSDN_NO()) ;
        queryRecord.put(Keys.LY10_STAT_SPLIT_NO_Field, event.getSTAT_SPLIT_NO()) ;
        queryRecord.put(Keys.LY10_BREAKDOWN_NO_Field, event.getBREAKDOWN_NO()) ;
        queryRecord.put(Keys.LY10_RETURN_SCREEN_Field, event.getRETURN_SCREEN()) ;

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