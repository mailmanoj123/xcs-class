package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY58Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY58CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C058";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY58Event event = (LY58Event)ce;
    Logger.info("Subsequent Advice Schedule Screen D/B Update..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly58");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly58");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY58_SESSION_NO,Integer.toString(event.getUserSession()));

        MappedRecord fieldValues = rf.createMappedRecord("C058_FIELD_VALUES");

        Vector breakdownTable = new Vector(100);
        for (int x = 0; x < event.getCOR().length; x++) {
          MappedRecord aRecord = rf.createMappedRecord("C058_BREAKDOWN_TABLE");
          aRecord.put(Keys.LY58_COR,event.getCOR()[x]);
          aRecord.put(Keys.LY58_DELETE_IND,event.getDELETE_IND()[x]);
          aRecord.put(Keys.LY58_STAT_SPLIT_NO,event.getSTAT_SPLIT_NO()[x]);
          aRecord.put(Keys.LY58_BREAKDOWN_NO,event.getBREAKDOWN_NO()[x]);
          aRecord.put(Keys.LY58_MOVE_REF,event.getMOVE_REF()[x]);
          aRecord.put(Keys.LY58_NAME_1,event.getNAME_1()[x]);
          aRecord.put(Keys.LY58_NAME_1_QUAL,event.getNAME_1_QUAL()[x]);
          aRecord.put(Keys.LY58_NAME_2,event.getNAME_2()[x]);
          aRecord.put(Keys.LY58_NAME_2_QUAL,event.getNAME_2_QUAL()[x]);
          aRecord.put(Keys.LY58_FIL_CODE,event.getFIL_CODE()[x]);
          aRecord.put(Keys.LY58_TF_CODE,event.getTF_CODE()[x]);
          aRecord.put(Keys.LY58_STATE_CODE,event.getSTATE_CODE()[x]);
          aRecord.put(Keys.LY58_LOSS_DATE_FROM,event.getLOSS_DATE_FROM()[x]);
          aRecord.put(Keys.LY58_LOSS_DATE_TO,event.getLOSS_DATE_TO()[x]);
          aRecord.put(Keys.LY58_LOSS_DATE_QUAL,event.getLOSS_DATE_QUAL()[x]);
          aRecord.put(Keys.LY58_CAT_CODE,event.getCAT_CODE()[x]);
          aRecord.put(Keys.LY58_PCS_CAT_CODE,event.getPCS_CAT_CODE()[x]);
          aRecord.put(Keys.LY58_NAIC_CODE,event.getNAIC_CODE()[x]);
          aRecord.put(Keys.LY58_NAIC_QUAL,event.getNAIC_QUAL()[x]);
          aRecord.put(Keys.LY58_PTT_AMT_TOTAL,event.getPTT_AMT()[x]);
          aRecord.put(Keys.LY58_OUTST_AMT,event.getOS_AMT()[x]);

          breakdownTable.add(aRecord);
        }

        fieldValues.put("#element[]",breakdownTable.toArray());

        Vector fieldValuesTable = new Vector(1);

        fieldValuesTable.add(fieldValues);

        queryRecord.put("#element[]",fieldValuesTable.toArray());

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