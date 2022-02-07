package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY06Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY06CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C006";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY06Event event = (LY06Event)ce;
    Logger.info("OSND Claim Search...");

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Claim Search 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly06");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly06");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY06SessionIDField,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY06PrevScreenId,event.getPrevScreenId());
        queryRecord.put(Keys.LY06SearchOSNDField,event.getOsnd());

        Vector key = new Vector(1);

        if (event.getDirection()!=null) {
          if (event.getDirection().equals("NEXT")) {
            MappedRecord lastKey = rf.createMappedRecord("C006_LAST_KEY");

            lastKey.put(Keys.LY06LASTSysRefField,event.getSysRef());
            lastKey.put(Keys.LY06LASTCurrNoField,event.getCurrNo());
            lastKey.put(Keys.LY06LASTSdnNoField,event.getSdnNo());
            lastKey.put(Keys.LY06LASTSplitNoField,event.getSplitNo());
            lastKey.put(Keys.LY06LASTBdownNoField,event.getBdownNo());

            key.add(lastKey);
          }
          else if (event.getDirection().equals("PREV")) {
            MappedRecord firstKey = rf.createMappedRecord("C006_FIRST_KEY");

            firstKey.put(Keys.LY06FIRSTSysRefField,event.getSysRef());
            firstKey.put(Keys.LY06FIRSTCurrNoField,event.getCurrNo());
            firstKey.put(Keys.LY06FIRSTSdnNoField,event.getSdnNo());
            firstKey.put(Keys.LY06FIRSTSplitNoField,event.getSplitNo());
            firstKey.put(Keys.LY06FIRSTBdownNoField,event.getBdownNo());

            key.add(firstKey);
          }
          queryRecord.put("#element[]",key.toArray());
        }

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
