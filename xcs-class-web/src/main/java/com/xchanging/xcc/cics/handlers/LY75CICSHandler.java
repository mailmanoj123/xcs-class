package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY75Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C075 (LY75)
 Program  - Associated Screen/Process:- Build Group Enquiry Screen
 Devo
 */

public class LY75CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C075";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY75Event event = (LY75Event)ce;
    Logger.info("Build Group Enquiry Screen- C075 (LY75)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly75");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly75");

        /**
         * Map the user entered data into the MappedRecord
         */
          queryRecord.put(Keys.LY75SessionIDField,Integer.toString(event.getUserSession()));

          Vector fieldValues = new Vector(1);
          MappedRecord aRecord = rf.createMappedRecord("C075_FIELD_VALUES");

          aRecord.put(Keys.LY75_GROUP_REF_Field,event.getGROUP_REF());
          fieldValues.add(aRecord);

          queryRecord.put("#element[]",fieldValues.toArray());

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