package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY92Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY92CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C092";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY92Event event = (LY92Event)ce;
    Logger.info("Create Bulk/CCS Correction..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly92");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly92");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY92_SESSION_NO,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY92_REDUCE_OUTST_IND,event.getREDUCE_OUTST_IND());

        Vector currencyTable = new Vector(3);
        for (int x = 0; x < 3; x++) {
          MappedRecord aRecord = rf.createMappedRecord("C092_CURRENCY_TABLE");
          aRecord.put(Keys.LY92_ORIG_CURR,event.getORIG_CURR()[x]);
          aRecord.put(Keys.LY92_SETT_CURR,event.getSETT_CURR()[x]);
          aRecord.put(Keys.LY92_TREASURY_RATE,event.getTREASURY_RATE()[x]);

          currencyTable.add(aRecord);
        }

        queryRecord.put("#element[]",currencyTable.toArray());

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