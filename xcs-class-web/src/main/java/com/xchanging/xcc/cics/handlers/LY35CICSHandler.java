package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY35Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C035 (LY35)
 Program  - Associated Screen/Process:- Claim Details Screen Validation
 Devo
 */

public class LY35CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C035";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY35Event event = (LY35Event)ce;
    Logger.info("Claim Details Screen Validation - C035 (LY35)" + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly35");
        iSpeq.setExecutionTimeout(WAIT_TIME);
        RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly35");

        /**
         * Map the user entered data into the MappedRecord
         */
          queryRecord.put(Keys.LY35_SessionID_Field,Integer.toString(event.getUserSession()));

          MappedRecord aRecord = rf.createMappedRecord("C035_FIELD_VALUES");
          Vector fieldTable = new Vector(1);

          aRecord.put(Keys.LY35_ADJUSTER_NAME,event.getADJUSTER_NAME());
          aRecord.put(Keys.LY35_ADJUSTER_REF,event.getADJUSTER_REF());
          aRecord.put(Keys.LY35_BKR_CNTCT,event.getBKR_CNTCT());
          aRecord.put(Keys.LY35_BKR_CNTCT_PHONE,event.getBKR_CNTCT_PHONE());
          aRecord.put(Keys.LY35_BKR_REF_1,event.getBKR_REF_1());
          aRecord.put(Keys.LY35_BKR_REF_2,event.getBKR_REF_2());
          aRecord.put(Keys.LY35_BROKER_UCR,event.getBROKER_UCR());
          aRecord.put(Keys.LY35_CAT_CODE,event.getCAT_CODE());
          aRecord.put(Keys.LY35_CAUSE_CODE,event.getCAUSE_CODE());
          aRecord.put(Keys.LY35_CLAIMANT,event.getCLAIMANT());
          aRecord.put(Keys.LY35_CLM_RISK_TYPE,event.getCLM_RISK_TYPE());
          aRecord.put(Keys.LY35_COVER_HOLDER,event.getCOVER_HOLDER());
          aRecord.put(Keys.LY35_DCM_DOD_FROM,event.getDCM_DOD_FROM());
          aRecord.put(Keys.LY35_DCM_DOD_QUAL,event.getDCM_DOD_QUAL());
          aRecord.put(Keys.LY35_DCM_DOD_TO,event.getDCM_DOD_TO());
          aRecord.put(Keys.LY35_INSURED,event.getINSURED());
          aRecord.put(Keys.LY35_LAWYER_NAME,event.getLAWYER_NAME());
          aRecord.put(Keys.LY35_LAWYER_REF,event.getLAWYER_REF());
          aRecord.put(Keys.LY35_LOSS_DATE_FROM,event.getLOSS_DATE_FROM());
          aRecord.put(Keys.LY35_LOSS_DATE_NARR,event.getLOSS_DATE_NARR());
          aRecord.put(Keys.LY35_LOSS_DATE_QUAL,event.getLOSS_DATE_QUAL());
          aRecord.put(Keys.LY35_LOSS_DATE_TO,event.getLOSS_DATE_TO());

          Vector lossDetails = new Vector(event.getLOSS_DETAILS().length);
          for (int x = 0; x < event.getLOSS_DETAILS().length && x < 7; x++) {
            MappedRecord lossDetLine = rf.createMappedRecord("C035_LOSS_DETAILS");
            lossDetLine.put("@C035_LOSS_DET_LINE",event.getLOSS_DETAILS()[x]);
            lossDetails.add(lossDetLine);
          }
          aRecord.put("#element[]",lossDetails.toArray());

          aRecord.put(Keys.LY35_LOSS_LOCATION,event.getLOSS_LOCATION());
          aRecord.put(Keys.LY35_LOSS_NAME,event.getLOSS_NAME());
          aRecord.put(Keys.LY35_ORIG_INSURED,event.getORIG_INSURED());
          aRecord.put(Keys.LY35_OTHER_NAME,event.getOTHER_NAME());
          aRecord.put(Keys.LY35_PCS_CAT_CODE,event.getPCS_CAT_CODE());
          aRecord.put(Keys.LY35_REINSURED,event.getREINSURED());
          aRecord.put(Keys.LY35_VESSEL_AIRCRAFT,event.getVESSEL_AIRCRAFT());
          aRecord.put(Keys.LY35_VOYAGE,event.getVOYAGE());

          // CCN 21 devo 15/01/2003
          aRecord.put(Keys.LY35_CH_CLM_REF,event.getCoverHolderClmRef());

          //_____________________________________________________
          /*Certificate of Insurance no*/
          Vector certInsNos = new Vector(5);
          
          MappedRecord certInsNoLine1 = rf.createMappedRecord("C035_COI_TABLE");
          MappedRecord certInsNoLine2 = rf.createMappedRecord("C035_COI_TABLE");
          MappedRecord certInsNoLine3 = rf.createMappedRecord("C035_COI_TABLE");
          MappedRecord certInsNoLine4 = rf.createMappedRecord("C035_COI_TABLE");
          MappedRecord certInsNoLine5 = rf.createMappedRecord("C035_COI_TABLE");
          
          certInsNoLine1.put(Keys.LY35_CERT_INS_NO,event.getCERT_INS_NO_1());
          certInsNoLine2.put(Keys.LY35_CERT_INS_NO,event.getCERT_INS_NO_2());
          certInsNoLine3.put(Keys.LY35_CERT_INS_NO,event.getCERT_INS_NO_3());
          certInsNoLine4.put(Keys.LY35_CERT_INS_NO,event.getCERT_INS_NO_4());
          certInsNoLine5.put(Keys.LY35_CERT_INS_NO,event.getCERT_INS_NO_5());
          
          certInsNos.add(certInsNoLine1);
          certInsNos.add(certInsNoLine2);
          certInsNos.add(certInsNoLine3);
          certInsNos.add(certInsNoLine4);
          certInsNos.add(certInsNoLine5);

          aRecord.put("#element[]",certInsNos.toArray());
          //________________________________________________________
          
          fieldTable.add(aRecord);
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