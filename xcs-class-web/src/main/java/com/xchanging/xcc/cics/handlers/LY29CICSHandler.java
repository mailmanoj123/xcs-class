package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY29Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY29CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C029";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY29Event event = (LY29Event)ce;
    Logger.info("Policy/Risk Details Validation (LY29)...");

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Policy Check 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly29");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly29");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY29_SessionID_Field,Integer.toString(event.getUserSession()));

        MappedRecord fieldValuesRecord = rf.createMappedRecord("C029_FIELD_VALUES");
        Vector fieldTable = new Vector(1);

        fieldValuesRecord.put(Keys.LY29_PEER_REV_IND_Field,event.getPEER_REV_IND());
        fieldValuesRecord.put(Keys.LY29_CURRENT_BKR_Field,event.getCURRENT_BKR());
        fieldValuesRecord.put(Keys.LY29_RISK_CODE_Field,event.getRISK_CODE());
        // CCN # N0030 - BA - 7/1/2002
        fieldValuesRecord.put(Keys.LY29_MARKET_CODE_Field,event.getMARKET_CODE());
        fieldValuesRecord.put(Keys.LY29_YEAR_OF_ACC_Field,event.getYEAR_OF_ACC());
        fieldValuesRecord.put(Keys.LY29_INTEREST_Field,event.getINTEREST());

        Vector limitTable = new Vector(3);
        for (int x = 0; x < 3; x++) {
          MappedRecord aRecord = rf.createMappedRecord("C029_LIMIT_TABLE");
          aRecord.put(Keys.LY29_LIMIT_CURR_Field,event.getLIMIT_CURR()[x]);
          aRecord.put(Keys.LY29_SI_LIMIT_Field,event.getSI_LIMIT()[x]);
          aRecord.put(Keys.LY29_EXCESS_LIMIT_Field,event.getEXCESS_LIMIT()[x]);

          limitTable.add(aRecord);
        }


         // Add the queryRecord table Vector to its parent 'Field Values' record
        fieldValuesRecord.put("#element[]", limitTable.toArray());

        fieldValuesRecord.put(Keys.LY29_SLIP_ORDER_1_Field,event.getSLIP_ORDER_1());
        fieldValuesRecord.put(Keys.LY29_SLIP_ORDER_2_Field,event.getSLIP_ORDER_2());
        fieldValuesRecord.put(Keys.LY29_PERILS_CONDS_Field,event.getPERILS_CONDS());
        fieldValuesRecord.put(Keys.LY29_LOCATION_VOYAGE_Field,event.getLOCATION_VOYAGE());
        fieldValuesRecord.put(Keys.LY29_BASIS_OF_LIMIT_Field,event.getBASIS_OF_LIMIT());
        fieldValuesRecord.put(Keys.LY29_POL_CERT_FROM_Field,event.getPOL_CERT_FROM());
        fieldValuesRecord.put(Keys.LY29_POL_CERT_TO_Field,event.getPOL_CERT_TO());
        fieldValuesRecord.put(Keys.LY29_POL_CERT_QUAL_Field,event.getPOL_CERT_QUAL());

        fieldValuesRecord.put(Keys.LY29_COVER_LS_FROM_Field,event.getCOVER_LS_FROM());
        fieldValuesRecord.put(Keys.LY29_COVER_LS_TO_Field,event.getCOVER_LS_TO());

        fieldValuesRecord.put(Keys.LY29_COVER_LS_QUAL_Field,event.getCOVER_LS_QUAL());
        fieldValuesRecord.put(Keys.LY29_WAR_IND_Field,event.getWAR_IND());

        fieldValuesRecord.put(Keys.LY29_SLIP_TYPE_Field, event.getSLIP_TYPE());
        fieldValuesRecord.put(Keys.LY29_UMR_Field,event.getUMR());
        fieldValuesRecord.put(Keys.LY29_UMR_LIDS_Field,event.getUMR_LIDS());

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