package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY27Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY27CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C027";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY27Event event = (LY27Event)ce;
    Logger.info("DB Claim Creation update... " + event.getUserSession());

    String[] osnd     = event.getOsnd();
    String[] apsnd    = event.getApsnd();
    String[] currency = event.getCurrency();
    String[] lidsLine = event.getLidsSyndicateLine();
    String[] lidsNo   = event.getLidsSyndicateNo();
    String[] lidsRef  = event.getLidsSyndicateRef();

      try {

        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly27");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly27");

        queryRecord.put(Keys.LY27SessionIDField,Integer.toString(event.getUserSession()));

        /**
         * Create a MappedRecord for the Field Values and a Vector
         * to store it in
         */
        MappedRecord fieldValuesRecord = rf.createMappedRecord("C027_FIELD_VALUES");
        Vector fieldTable = new Vector(1);

        /**
         * Build the ORIG_REF_TABLE
         */
        Vector origRefTable = new Vector(3);
        for (int x = 0; x < 3; x++) {
          MappedRecord recordEntry = rf.createMappedRecord("C027_ORIG_REF_TABLE");
          recordEntry.put("@C027_ORIG_REF",osnd[x]);
          recordEntry.put("@C027_AP_REF",apsnd[x]);
          recordEntry.put("@C027_ORIG_CURR",currency[x]);
          origRefTable.add(recordEntry);
        }

        /**
         * Add the ORIG REF table Vector to its parent 'Field Values' record
         */
        fieldValuesRecord.put("#element[]", origRefTable.toArray());

        /**
         * Add the other values to the Field Value record
         */
        fieldValuesRecord.put(Keys.LY27VersionNoField,event.getVersionNo());
        fieldValuesRecord.put(Keys.LY27SettAdvIndField,event.getSettAdv());
        fieldValuesRecord.put(Keys.LY27NonScmAdvField,event.getNonScmAdvised());
        fieldValuesRecord.put(Keys.LY27BulkIndField,event.getBulkInd());
        fieldValuesRecord.put(Keys.LY27UnsignedRiskField,event.getRiskUnsigned());
        fieldValuesRecord.put(Keys.LY27TreatyIndField,event.getTreaty());
		fieldValuesRecord.put(Keys.LY27EcfClaimIndField,event.getEcfClaim());
                fieldValuesRecord.put(Keys.LY27EcfClassField,event.getEcfClass());
        fieldValuesRecord.put(Keys.LY27LossReserveIndField,event.getLossReserve());
        fieldValuesRecord.put(Keys.LY27LocIndField,event.getLoc());
        fieldValuesRecord.put(Keys.LY27LossFundIndField,event.getLossFund());
        fieldValuesRecord.put(Keys.LY27ChequePymtField,event.getPayByCheque());
        fieldValuesRecord.put(Keys.LY27ChargeTypeField,event.getChargeType());
        fieldValuesRecord.put(Keys.LY27NonChargeIndField,event.getNonChargeableInd());
        fieldValuesRecord.put(Keys.LY27PrevAdvNoNetField,event.getPrevAdvNonNet());
        fieldValuesRecord.put(Keys.LY27PrevPaidIndField,event.getPrevPaidInd());

        // CCN # N0058 - BA - 09/01/2003
        fieldValuesRecord.put(Keys.LY27LOCDrawingIndField,event.getLocDrawingInd());

        // CCN # ????? - 03/12/2003 - S.Caine
        fieldValuesRecord.put(Keys.LY27SpecialPymtIndField,event.getSpecPymtInd());
        
        //Phase 3a enhancements
        fieldValuesRecord.put(Keys.LY27SlipTypeField,event.getSlipType());

        // CCN 21 devo
        fieldValuesRecord.put(Keys.LY27SimRIIndField,event.getSimRi());
        fieldValuesRecord.put(Keys.LY27RIPRequiredField,event.getSimRi());
        fieldValuesRecord.put(Keys.LY27SchemeCanIndField,event.getSchemeCanInd());
        fieldValuesRecord.put(Keys.LY27CPAIndField,event.getCpaInd());
        fieldValuesRecord.put(Keys.LY27DirLStockIndField,event.getDirLStockInd());


        fieldValuesRecord.put(Keys.LY27PresDateField,event.getPresDate());
        fieldValuesRecord.put(Keys.LY27RiskCodeField,event.getRiskCode());
        fieldValuesRecord.put(Keys.LY27YearOfAccField,event.getYearOfAcc());
        fieldValuesRecord.put(Keys.LY27UmrField,event.getUmr());
        fieldValuesRecord.put(Keys.LY27SlipOrder1Field,event.getSlipOrder1());
        fieldValuesRecord.put(Keys.LY27SlipOrder2Field,event.getSlipOrder2());
        fieldValuesRecord.put(Keys.LY27LineSlipCHField,event.getLineSlipCh());
        fieldValuesRecord.put(Keys.LY27InsuredField,event.getInsured());
        fieldValuesRecord.put(Keys.LY27ReinsuredField,event.getReinsured());
        fieldValuesRecord.put(Keys.LY27VesselAircraftField,event.getVesselAircraft());
        fieldValuesRecord.put(Keys.LY27InterestField,event.getInterest());
        fieldValuesRecord.put(Keys.LY27SiLimitField,event.getSiLimit());
        fieldValuesRecord.put(Keys.LY27ExcessLimitField,event.getExcessLimit());
        fieldValuesRecord.put(Keys.LY27SiCurrField,event.getSiCurr());
        fieldValuesRecord.put(Keys.LY27PerilsCondsField,event.getPerilsConds());
        fieldValuesRecord.put(Keys.LY27PolicyPeriodFromField,event.getPolicyPeriodFrom());
        fieldValuesRecord.put(Keys.LY27PolicyPeriodToField,event.getPolicyPeriodTo());
        fieldValuesRecord.put(Keys.LY27NoOfSyndicatesField,event.getNoOfSyndicates());
        fieldValuesRecord.put(Keys.LY27TotalLineField,event.getTotalLine());


        /**
         * Create a MappedRecord for the Market Table and a Vector
         * to store it in
         */
        MappedRecord marketTableRec = rf.createMappedRecord("C027_MARKET_TABLE");
        Vector marketTable = new Vector(1);

        Vector marketLines = new Vector(lidsLine.length);
        for (int x = 0; x < lidsLine.length; x++) {
          MappedRecord recordEntry = rf.createMappedRecord("C027_MARKET_LINE");
          recordEntry.put("@C027_SYNDICATE_NO",lidsNo[x]);
          recordEntry.put("@C027_SYNDICATE_LINE",lidsLine[x]);
          recordEntry.put("@C027_SYNDICATE_REF",lidsRef[x]);
          marketLines.add(recordEntry);
        }
        /**
         * Add the Market Lines Vector to its parent Record
         */
        marketTableRec.put("#element[]",marketLines.toArray());
        marketTable.add(marketTableRec);

        /**
         * Add the Market Table to its parent record
         */
        fieldValuesRecord.put("#element[]",marketTable.toArray());

        MappedRecord lidsData = rf.createMappedRecord("C027_LIDS_DATA");
        lidsData.put(Keys.LY27LidsOrigBkr,event.getLidsOrigBkr());
        lidsData.put(Keys.LY27LidsOrigCurr,event.getLidsOrigCurr());
        lidsData.put(Keys.LY27LidsSettCurr,event.getLidsSettCurr());
        lidsData.put(Keys.LY27LidsFilCode1,event.getLidsFilCode1());
        lidsData.put(Keys.LY27LidsFilCode2,event.getLidsFilCode2());
        lidsData.put(Keys.LY27LidsTfCode,event.getLidsTfCode());
        lidsData.put(Keys.LY27LidsStateCode,event.getLidsStateCode());
        lidsData.put(Keys.LY27LidsNaicCode,event.getLidsNaicCode());
        lidsData.put(Keys.LY27LidsNaicQual,event.getLidsNaicQual());
        lidsData.put(Keys.LY27LidsNonUsTfCode,event.getLidsNonUsTfCode());
        lidsData.put(Keys.LY27LidsCountryCode,event.getLidsCountryCode());
        lidsData.put(Keys.LY27LidsWarInd,event.getLidsWarInd());
        lidsData.put(Keys.LY27LidsDtiCode,event.getLidsDtiCode());

        fieldValuesRecord.put("#element[]",new Object[]{lidsData});

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
