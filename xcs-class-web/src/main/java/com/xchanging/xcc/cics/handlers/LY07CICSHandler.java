package com.xchanging.xcc.cics.handlers;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY07Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C007 (LY07)
 Program  - Associated Screen/Process:- Specific Claim Search
 Devo
 */

public class LY07CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C007";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY07Event event = (LY07Event)ce;
    Logger.info("Specific Claim Search- LY07 (CO07) " + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly07");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly07");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY07_SessionID_Field,Integer.toString(event.getUserSession()));

        queryRecord.put(Keys.LY07_SEARCH_UCR_Field,event.getSEARCH_UCR());
        queryRecord.put(Keys.LY07_SEARCH_TR_Field,event.getSEARCH_TR());
        queryRecord.put(Keys.LY07_SEARCH_COR_Field,event.getSEARCH_COR());
        queryRecord.put(Keys.LY07_SEARCH_TDN_Field,event.getSEARCH_TDN());
        queryRecord.put(Keys.LY07_SEARCH_CERT_NO_Field,event.getSEARCH_CERT_NO());

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