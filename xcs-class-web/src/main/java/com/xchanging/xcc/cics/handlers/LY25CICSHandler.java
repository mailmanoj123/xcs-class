package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY25Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY25CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C025";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY25Event event = (LY25Event)ce;
    Logger.info("Claim Creation Screen Validation... " + event.getUserSession());

    String osnd[] = event.getOsnd();
    String apsnd[] = event.getApsnd();
    String currency[] = event.getCurrencies();

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Create Skeleton Initial Claim 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly25");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly25");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY25SessionIDField,Integer.toString(event.getUserSession()));

        Vector origRefTable = new Vector(3);
        for (int x = 0; x < 3; x++) {
          MappedRecord recordEntry = rf.createMappedRecord("C025_ORIG_REF_TABLE");
          recordEntry.put(Keys.LY25OrigRefField,osnd[x]);
          recordEntry.put(Keys.LY25ApRefField,apsnd[x]);
          recordEntry.put(Keys.LY25OrigCurrField,currency[x]);
          origRefTable.add(recordEntry);
        }

        Vector fieldTable = new Vector(1);

        MappedRecord fieldValuesRecord = rf.createMappedRecord("C025_FIELD_VALUES");
        fieldValuesRecord.put("#element[]", origRefTable.toArray());

        fieldValuesRecord.put(Keys.LY25RiskCodeField,event.getRiskCode());
        fieldValuesRecord.put(Keys.LY25SettAdvIndField,event.getSettAdv());
        fieldValuesRecord.put(Keys.LY25NonScmAdvField,event.getNonScmAdvised());
        fieldValuesRecord.put(Keys.LY25BulkIndField,event.getBulkInd());
        fieldValuesRecord.put(Keys.LY25UnsignedRiskField,event.getRiskUnsigned());
        fieldValuesRecord.put(Keys.LY25TreatyIndField,event.getTreaty());
	fieldValuesRecord.put(Keys.LY25EcfClaimIndField,event.getEcfClaim());
        fieldValuesRecord.put(Keys.LY25EcfClassField,event.getEcfClass());   
        fieldValuesRecord.put(Keys.LY25SimRIIndField,event.getSimRi());
        fieldValuesRecord.put(Keys.LY25LossReserveIndField,event.getLossReserve());
        fieldValuesRecord.put(Keys.LY25LocIndField,event.getLoc());
        fieldValuesRecord.put(Keys.LY25LossFundIndField,event.getLossFund());
        fieldValuesRecord.put(Keys.LY25ChequePymtField,event.getPayByCheque());
        fieldValuesRecord.put(Keys.LY25ChargeTypeField,event.getChargeType());
        fieldValuesRecord.put(Keys.LY25NonChargeIndField,event.getNonChargeableInd());
        fieldValuesRecord.put(Keys.LY25PrevAdvNoNetField,event.getPrevAdvNoNet());
        fieldValuesRecord.put(Keys.LY25PrevPaidIndField,event.getPrevPaidInd());

        // CCN # N0058 - BA - 09/01/2003
        fieldValuesRecord.put(Keys.LY25LOCDrawingIndField,event.getLocDrawingInd());

        // CCN # ???? - S.Caine - 03/12/2003
        fieldValuesRecord.put(Keys.LY25SpecialPymtIndField,event.getSpecPymtInd());

        // CCN 21 devo
        fieldValuesRecord.put(Keys.LY25SchemeCanIndField,event.getSchemeCanInd());
        fieldValuesRecord.put(Keys.LY25CPAIndField,event.getCpaInd());
        fieldValuesRecord.put(Keys.LY25DirLSTockIndField,event.getDirLStockInd());

        fieldValuesRecord.put(Keys.LY25SlipTypeField,event.getSlipType());
        fieldValuesRecord.put(Keys.LY25PresDateField,event.getPresDate());

        fieldValuesRecord.put(Keys.LY25ValueCountField,event.getValueCount());
        Vector valueOccurrences = new Vector(Integer.parseInt(event.getValueCount()));
        for (int i=0; i<Integer.parseInt(event.getValueCount()); i++) {
          MappedRecord valueOccurrence = rf.createMappedRecord("C025_VALUE_OCCURRENCE");
          valueOccurrence.put(Keys.LY25OrigCcyField,event.getOrigCcys()[i]);
          valueOccurrences.add(valueOccurrence);
        }
        fieldValuesRecord.put("#element[]",valueOccurrences.toArray());

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
//        else if (warningCount > 0) {
         if (warningCount > 0) {
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
