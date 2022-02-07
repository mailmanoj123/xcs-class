package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY73Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C073 (LY73)
 Program  - Associated Screen/Process:- Validate Group Details (Maintain Group Screen)

 Devo
 */

public class LY73CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C073";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY73Event event = (LY73Event)ce;
    Logger.info("Validate Group Details (Maintain Group Screen)- C073 (LY73)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly73");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly73");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY73SessionIDField,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY73_GROUP_REF_Field,event.getGROUP_REF());

        int GroupContentsArraysize = event.getUCR_OSND().length;
        Vector groupLines = new Vector(GroupContentsArraysize);

        for (int x = 0; x < GroupContentsArraysize; x++) {
          MappedRecord aRecord = rf.createMappedRecord("C073_GROUP_CONTENTS");
          aRecord.put(Keys.LY73_UCR_OSND_Field,event.getUCR_OSND()[x]);
          aRecord.put(Keys.LY73_DELETE_IND_Field,event.getDELETE_IND()[x]);
          groupLines.add(aRecord);
        }

        queryRecord.put("#element[]",groupLines.toArray());

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