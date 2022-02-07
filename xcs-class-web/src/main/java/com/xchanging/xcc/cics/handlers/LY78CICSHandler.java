package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY78Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY78CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C078";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY78Event event = (LY78Event)ce;
    Logger.info("Creating Rate of Exchange Adjustment..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly78");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly78");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY78_SESSION_NO,Integer.toString(event.getUserSession()));

        Vector currencyDetails = new Vector(3);
        for (int x = 0; x < 3; x++) {
          MappedRecord aRecord = rf.createMappedRecord("C078_CURRENCY_DETAILS");
          aRecord.put(Keys.LY78_REV_RATE_EXCH,event.getREV_RATE_EXCH()[x]);
          aRecord.put(Keys.LY78_REV_SETT_AMT,event.getREV_SETT_AMT()[x]);
          currencyDetails.add(aRecord);
        }

        queryRecord.put("#element[]",currencyDetails.toArray());

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