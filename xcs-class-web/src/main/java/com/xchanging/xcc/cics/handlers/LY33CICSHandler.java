package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY33Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C033 (LY33)
 Program  - Associated Screen/Process:- Market Details Screen D/B Updates
 Devo
 */

public class LY33CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C033";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY33Event event = (LY33Event)ce;
    Logger.info("Market Details Screen D/B Updates-  LY33 (C033) " + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly33");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly33");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY33_SessionID_Field,Integer.toString(event.getUserSession()));

        queryRecord.put(Keys.LY33_TOTAL_LINE_Field,event.getTOTAL_LINE());

        // Now create the third layer- represented by bRecord
        MappedRecord bRecord = rf.createMappedRecord("C033_MARKET_TABLE");
        Vector marketTable = new Vector(1);

        // Now create the fourth layer- represented by cRecord
        int MarketLineArraySize = event.getSYNDICATE_NO().length;
        Vector marketLines = new Vector(MarketLineArraySize);

        for (int x = 0; x < MarketLineArraySize; x++) {
          MappedRecord cRecord = rf.createMappedRecord("C033_MARKET_LINE");
          cRecord.put(Keys.LY33_SYNDICATE_NO_Field,event.getSYNDICATE_NO()[x]);
          cRecord.put(Keys.LY33_SYNDICATE_LINE_Field,event.getSYNDICATE_LINE()[x]);
          cRecord.put(Keys.LY33_SYNDICATE_REF_Field,event.getSYNDICATE_REF()[x]);
          cRecord.put(Keys.LY33_BUREAU_LEAD_Field,event.getBUREAU_LEAD()[x]);
          cRecord.put(Keys.LY33_DELETE_IND_Field,event.getDELETE_IND()[x]);
          marketLines.add(cRecord);
        }
        // now add the fourth layer to the third
        bRecord.put("#element[]",marketLines.toArray());
        // now add the third layer to the second
        marketTable.add(bRecord);
        queryRecord.put("#element[]",marketTable.toArray());

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