package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY30Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY30CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C030";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY30Event event = (LY30Event)ce;
    Logger.info("Policy/Risk Details DB Updates...");

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Policy Check 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly30");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly30");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY30_SESSION_NO,Integer.toString(event.getUserSession()));

        MappedRecord fieldValuesRecord = rf.createMappedRecord("C030_FIELD_VALUES");
        Vector fieldTable = new Vector(1);

        fieldValuesRecord.put(Keys.LY30_XCR,event.getXCR());
        fieldValuesRecord.put(Keys.LY30_UCR,event.getUCR());
        fieldValuesRecord.put(Keys.LY30_TR,event.getTR());
        fieldValuesRecord.put(Keys.LY30_ORIG_REF_1,event.getORIG_REF_1());
        fieldValuesRecord.put(Keys.LY30_ORIG_REF_2,event.getORIG_REF_2());
        fieldValuesRecord.put(Keys.LY30_ORIG_REF_3,event.getORIG_REF_3());
        fieldValuesRecord.put(Keys.LY30_PEER_REV_IND,event.getPEER_REV_IND());
        fieldValuesRecord.put(Keys.LY30_CURRENT_BKR,event.getCURRENT_BKR());
        fieldValuesRecord.put(Keys.LY30_RISK_CODE,event.getRISK_CODE());

        // CCN # N0030 - BA - 7/1/2002
        fieldValuesRecord.put(Keys.LY30_MARKET_CODE,event.getMARKET_CODE());
        fieldValuesRecord.put(Keys.LY30_YEAR_OF_ACC,event.getYEAR_OF_ACC());
        fieldValuesRecord.put(Keys.LY30_INTEREST,event.getINTEREST());

        Vector limitTable = new Vector(3);
        for (int x = 0; x < 3; x++) {
          MappedRecord aRecord = rf.createMappedRecord("C030_LIMIT_TABLE");
          aRecord.put(Keys.LY30_LIMIT_CURR,event.getLIMIT_CURR()[x]);
          aRecord.put(Keys.LY30_SI_LIMIT,event.getSI_LIMIT()[x]);
          aRecord.put(Keys.LY30_EXCESS_LIMIT,event.getEXCESS_LIMIT()[x]);

          limitTable.add(aRecord);
        }

         // Add the queryRecord table Vector to its parent 'Field Values' record
        fieldValuesRecord.put("#element[]", limitTable.toArray());


        fieldValuesRecord.put(Keys.LY30_SI_NARR_1,event.getSI_NARR_1());
        /*  CCN: N0047
        Changed on: 11/12/02 (DH)
        fieldValuesRecord.put(Keys.LY30_SI_NARR_2,event.getSI_NARR_2());
        */
        fieldValuesRecord.put(Keys.LY30_SLIP_ORDER_1,event.getSLIP_ORDER_1());
        fieldValuesRecord.put(Keys.LY30_SLIP_ORDER_2,event.getSLIP_ORDER_2());
        fieldValuesRecord.put(Keys.LY30_PERILS_CONDS,event.getPERILS_CONDS());
        fieldValuesRecord.put(Keys.LY30_LOCATION_VOYAGE,event.getLOCATION_VOYAGE());
        fieldValuesRecord.put(Keys.LY30_BASIS_OF_LIMIT,event.getBASIS_OF_LIMIT());
        fieldValuesRecord.put(Keys.LY30_POL_CERT_FROM,event.getPOL_CERT_FROM());
        fieldValuesRecord.put(Keys.LY30_POL_CERT_TO,event.getPOL_CERT_TO());
        fieldValuesRecord.put(Keys.LY30_POL_CERT_QUAL,event.getPOL_CERT_QUAL());
        fieldValuesRecord.put(Keys.LY30_POL_PERIOD_NARR,event.getPOL_PERIOD_NARR());
        fieldValuesRecord.put(Keys.LY30_COVER_LS_FROM,event.getCOVER_LS_FROM());
        fieldValuesRecord.put(Keys.LY30_COVER_LS_TO,event.getCOVER_LS_TO());

        fieldValuesRecord.put(Keys.LY30_SLIP_TYPE, event.getSLIP_TYPE());
        fieldValuesRecord.put(Keys.LY30_COVER_LS_QUAL,event.getCOVER_LS_QUAL());
        fieldValuesRecord.put(Keys.LY30_WAR_IND,event.getWAR_IND());

        // CCN # N0039 - BA - 7/1/2002
        fieldValuesRecord.put(Keys.LY30_UMR_Field, event.getUMR());
        // now add our fieldvalues to the fieldtable vector
        fieldTable.add(fieldValuesRecord);
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