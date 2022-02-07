package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ16Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.UserWebModel;

/**
 Commarea - C115 (LZ16)
 Program  - Associated Screen/Process:- 'Settlement Search Results'
 */

public class LZ16CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C115";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LZ16Event event = (LZ16Event)ce;
    Logger.info("Settlement Search Results..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("lz16");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("lz16");

        /**
         * Map the user entered data into the MappedRecord
         */

        // We need to pass the secondary mainframe session number into the session_no field in the commarea. This will enable us
        // to ensure the mainframe refers to the second session.
        String SecondSession = (String)((UserWebModel)ce.getHttpSession().getAttribute(Keys.UserWebModelKey)).getSecondarySessionNo();
        queryRecord.put(Keys.C115_SESSION_NO,SecondSession);
        // The line below has been commented out- as it puts the primary session into the session_no!
        //queryRecord.put(Keys.C115_SESSION_NO,Integer.toString(event.getUserSession()));

        Vector fieldTable = new Vector(1);
        MappedRecord fieldValues = rf.createMappedRecord("C115_FIELD_VALUES");

        fieldValues.put(Keys.C115_INCLUDE_POST_IMPN_TDNS,event.getC115_INCLUDE_POST_IMPN_TDNS());
        fieldValues.put(Keys.C115_TAKE_DOWN_NO,event.getC115_TAKE_DOWN_NO());
        fieldValues.put(Keys.C115_TAKE_DOWN_DATE,event.getC115_TAKE_DOWN_DATE());
        fieldValues.put(Keys.C115_ORIG_SIGNING_NO,event.getC115_ORIG_SIGNING_NO());
        fieldValues.put(Keys.C115_ORIG_SIGNING_DATE,event.getC115_ORIG_SIGNING_DATE());
        fieldValues.put(Keys.C115_YEAR_OF_ACC,event.getC115_YEAR_OF_ACC());
        fieldValues.put(Keys.C115_PAYEE_BKR,event.getC115_PAYEE_BKR());
        fieldValues.put(Keys.C115_COMP_BTW_FROM,event.getC115_COMP_BTW_FROM());
        fieldValues.put(Keys.C115_COMP_BTW_TO,event.getC115_COMP_BTW_TO());
        fieldValues.put(Keys.C115_NAME_1,event.getC115_NAME_1());
        fieldValues.put(Keys.C115_NAME_1_PARTIAL_IND,event.getC115_NAME_1_PARTIAL_IND());
        fieldValues.put(Keys.C115_NAME_2,event.getC115_NAME_2());
        fieldValues.put(Keys.C115_NAME_2_PARTIAL_IND,event.getC115_NAME_2_PARTIAL_IND());

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