package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY74Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C074 (LY74)
 Program  - Associated Screen/Process:- Update Group Details (Maintain Group Screen)
 Devo
 */

public class LY74CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C074";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY74Event event = (LY74Event)ce;
    Logger.info("Update Group Details (Maintain Group Screen)- C074 (LY74)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly74");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly74");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY74SessionIDField,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY74_GROUP_REF_Field,event.getGROUP_REF());

        int GroupContentsArraysize = event.getUCR_OSND().length;
        Vector groupLines = new Vector(GroupContentsArraysize);

        for (int x = 0; x < GroupContentsArraysize; x++) {
          MappedRecord aRecord = rf.createMappedRecord("C074_GROUP_CONTENTS");
          aRecord.put(Keys.LY74_UCR_OSND_Field,event.getUCR_OSND()[x]);
          aRecord.put(Keys.LY74_DELETE_IND_Field,event.getDELETE_IND()[x]);
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