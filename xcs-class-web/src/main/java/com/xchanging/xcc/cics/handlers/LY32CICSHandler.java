package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY32Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C032 (LY32)
 Program  - Associated Screen/Process:- Market Details Screen Validation
 Devo
 */

public class LY32CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C032";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY32Event event = (LY32Event)ce;
    Logger.info(" Market Details Screen Validation- C032 (LY32)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly32");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly32");

        /**
         * Map the user entered data into the MappedRecord
         */

        // create the parent layer- represented by queryRecord
        queryRecord.put(Keys.LY32_SessionID_Field,Integer.toString(event.getUserSession()));

        // Now create the second layer- represented by aRecord
        MappedRecord aRecord = rf.createMappedRecord("C032_FIELD_VALUES");
        Vector fieldTable = new Vector(1);

        aRecord.put(Keys.LY32_NO_SYNDICATES_Field,event.getNO_SYNDICATES());
        aRecord.put(Keys.LY32_TOTAL_LINE_Field,event.getTOTAL_LINE());
        aRecord.put(Keys.LY32_MKT_SOURCE_Field,event.getMKT_SOURCE());

        // Now create the third layer- represented by bRecord
        MappedRecord bRecord = rf.createMappedRecord("C032_MARKET_TABLE");
        Vector marketTable = new Vector(1);

        // Now create the fourth layer- represented by cRecord
        int MarketLineArraySize = event.getSYNDICATE_NO().length;
        Vector marketLines = new Vector(MarketLineArraySize);

        for (int x = 0; x < MarketLineArraySize; x++) {
          MappedRecord cRecord = rf.createMappedRecord("C032_MARKET_LINE");
          cRecord.put(Keys.LY32_SYNDICATE_NO_Field,event.getSYNDICATE_NO()[x]);
          cRecord.put(Keys.LY32_SYNDICATE_LINE_Field,event.getSYNDICATE_LINE()[x]);
          cRecord.put(Keys.LY32_SYNDICATE_REF_Field,event.getSYNDICATE_REF()[x]);
          cRecord.put(Keys.LY32_DELETE_IND_Field,event.getDELETE_IND()[x]);
          marketLines.add(cRecord);
        }
        // now add the fourth layer to the third
        bRecord.put("#element[]",marketLines.toArray());
        // now add the third layer to the second
        marketTable.add(bRecord);
        aRecord.put("#element[]",marketTable.toArray());
        // Now add the second layer to the overall parent layer
        fieldTable.add(aRecord);
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