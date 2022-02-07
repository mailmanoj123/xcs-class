package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ17Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.UserWebModel;

/**
 Commarea - C116 (LZ17)
 Program  - Associated Screen/Process:- 'Settlement Search Results Details Screen'
 */

public class LZ17CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C116";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LZ17Event event = (LZ17Event)ce;
    Logger.info("Settlement Search Results Details screen..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("lz17");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("lz17");

        /**
         * Map the user entered data into the MappedRecord
         */

        // We need to pass the secondary mainframe session number into the session_no field in the commarea. This will enable us
        // to ensure the mainframe refers to the second session.
        String SecondSession = (String)((UserWebModel)ce.getHttpSession().getAttribute(Keys.UserWebModelKey)).getSecondarySessionNo();
        queryRecord.put(Keys.C116_SESSION_NO,SecondSession);
        // The line below has been commented out- as it puts the primary session into the session_no!
        //queryRecord.put(Keys.C116_SESSION_NO,Integer.toString(event.getUserSession()));

        Vector fieldTable = new Vector(1);

        MappedRecord fieldValues = rf.createMappedRecord("C116_SELECTED_VALUES");

        fieldValues.put(Keys.C116_TAKE_DOWN_NO,event.getC116_TAKE_DOWN_NO());
        fieldValues.put(Keys.C116_TAKE_DOWN_DATE,event.getC116_TAKE_DOWN_DATE());
        fieldValues.put(Keys.C116_VERSION_NO,event.getC116_VERSION_NO());

        fieldTable.add(fieldValues);
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