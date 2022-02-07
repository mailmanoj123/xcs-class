package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY94Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY94CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C094";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY94Event event = (LY94Event)ce;
    Logger.info("Building COMMAREA for LIDS interface... " + event.getUserSession());

    String osnd[] = event.getOsnd();
    String apsnd[] = event.getApsnd();

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Create Skeleton Initial Claim 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly94");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly94");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY94SessionIDField,Integer.toString(event.getUserSession()));

        Vector sndTable = new Vector(3);
        for (int x = 0; x < 3; x++) {
          MappedRecord recordEntry = rf.createMappedRecord(Keys.LY94SNDTable);
          recordEntry.put(Keys.LY94OrigRefField,osnd[x]);
          recordEntry.put(Keys.LY94ApRefField,apsnd[x]);
          sndTable.add(recordEntry);
        }

        queryRecord.put("#element[]", sndTable.toArray());

        /**
         * Execute the query
         */
        Record oRec = interaction.execute(iSpeq, queryRecord);
        writeXML(oRec);

        results = (MappedRecord)oRec;
        int errorCount = errorsFound(results,fieldHdr);
        int warningCount = warningsFound(results,fieldHdr);

        if (errorCount > 0) {
          processErrors(results,fieldHdr);
        }
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
