package com.xchanging.xcc.cics.handlers;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ07Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LZ07CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C107";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LZ07Event event = (LZ07Event)ce;
    Logger.info("Premium Comparion -  LZ07 (C107) " + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("lz07");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("lz07");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LZ07_SESSION_NO,Integer.toString(event.getUserSession()));

        MappedRecord lidsData = rf.createMappedRecord("C107_LIDS_DATA");
        lidsData.put(Keys.LZ07_RISK_CODE_L,event.getRiskCode());
        lidsData.put(Keys.LZ07_YEAR_OF_ACC_L,event.getYearOfAcc());
        lidsData.put(Keys.LZ07_LIDS_COUNT,event.getLidsCount());

        MappedRecord[] lidsDetails = new MappedRecord[Integer.parseInt(event.getLidsCount())];
        for (int i=0; i<lidsDetails.length; i++) {
          MappedRecord lidsDet = rf.createMappedRecord("C107_LIDS_DETAILS");
          lidsDet.put(Keys.LZ07_FIL_CODE_1_L,event.getFilCode1()[i]);
          lidsDet.put(Keys.LZ07_FIL_CODE_2_L,event.getFilCode2()[i]);
          lidsDet.put(Keys.LZ07_DTI_CODE_L,event.getDtiCode()[i]);
          lidsDet.put(Keys.LZ07_TF_CODE_L,event.getTfCode()[i]);
          lidsDet.put(Keys.LZ07_OTHER_TF_L,event.getOtherTf()[i]);
          lidsDet.put(Keys.LZ07_ORIG_CURR_L,event.getOrigCcy()[i]);
          lidsDet.put(Keys.LZ07_CNTRY_CODE_L,event.getCountryCode()[i]);
          lidsDetails[i] = lidsDet;
        }

        lidsData.put("#element[]",lidsDetails);
        queryRecord.put("#element[]",new MappedRecord[] {lidsData});

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