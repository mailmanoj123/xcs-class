package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY89Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C089 (LY89)
 Program  - Associated Screen/Process:- Update Narrative Details
 Devo
 */

public class LY89CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C089";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY89Event event = (LY89Event)ce;
    Logger.info("Update Narrative Details C089 (LY89)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly89");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly89");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY89_SESSION_NO,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY89_TEXT_ID_Field,event.getTEXT_ID());
        queryRecord.put(Keys.LY89_CALL_NUMBER_Field,event.getCALL_NUMBER());


        int textArraysize = event.getTEXT_LINE().length;
        Vector textLines = new Vector(textArraysize);

        // Remedy 177552 - Narrative lines 300 to 600
        // C089_LINE_COUNT not being explicitly populated.
        queryRecord.put(Keys.LY89_LINE_COUNT, Integer.toString(textArraysize)) ;

        for (int x = 0; x < textArraysize; x++) {
          MappedRecord aRecord = rf.createMappedRecord("C089_TEXT_LINE");
          aRecord.put(Keys.LY89_TEXT_LINE_Field,event.getTEXT_LINE()[x]);
          textLines.add(aRecord);
        }

        queryRecord.put("#element[]",textLines.toArray());

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