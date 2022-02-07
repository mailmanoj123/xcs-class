package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY08Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C008 (LY08)
 Program  - Associated Screen/Process:- Group Claim Search
 Devo
 */

public class LY08CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C008";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY08Event event = (LY08Event)ce;
    Logger.info("Group Claim Search- LY08 (CO08) " + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly08");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly08");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LY08_SessionID_Field,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY08_SEARCH_GRP_REF_Field,event.getSEARCH_GRP_REF());
        queryRecord.put(Keys.LY08_SEARCH_BKR_UCR_Field,event.getSEARCH_BKR_UCR());

        MappedRecord firstKey = rf.createMappedRecord("C008_FIRST_KEY");
        firstKey.put(Keys.LY08_FIRST_SYS_REF,event.getFIRST_SYS_REF());
        firstKey.put(Keys.LY08_FIRST_CURR_NO,event.getFIRST_CURR_NO());
        firstKey.put(Keys.LY08_FIRST_SDN_NO,event.getFIRST_SDN_NO());
        firstKey.put(Keys.LY08_FIRST_SPLIT_NO,event.getFIRST_SPLIT_NO());
        firstKey.put(Keys.LY08_FIRST_BDOWN_NO,event.getFIRST_BDOWN_NO());

        MappedRecord lastKey = rf.createMappedRecord("C008_LAST_KEY");
        lastKey.put(Keys.LY08_LAST_SYS_REF,event.getLAST_SYS_REF());
        lastKey.put(Keys.LY08_LAST_CURR_NO,event.getLAST_CURR_NO());
        lastKey.put(Keys.LY08_LAST_SDN_NO,event.getLAST_SDN_NO());
        lastKey.put(Keys.LY08_LAST_SPLIT_NO,event.getLAST_SPLIT_NO());
        lastKey.put(Keys.LY08_LAST_BDOWN_NO,event.getLAST_BDOWN_NO());

        Vector firstKeyV = new Vector(1);
        firstKeyV.add(firstKey);
        queryRecord.put("#element[]",firstKeyV.toArray());

        Vector lastKeyV = new Vector(1);
        lastKeyV.add(lastKey);
        queryRecord.put("#element[]",lastKeyV.toArray());

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