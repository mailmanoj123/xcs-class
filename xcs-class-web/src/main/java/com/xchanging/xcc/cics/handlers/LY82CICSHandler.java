package com.xchanging.xcc.cics.handlers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY82Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LY82CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C082";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LY82Event event = (LY82Event)ce;
    Logger.info("Treaty/LOC Take Down Number Processing..." + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("ly82");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("ly82");

        /**
         * Map the user entered data into the MappedRecord
         */
        queryRecord.put(Keys.LY82_SESSION_NO,Integer.toString(event.getUserSession()));
        queryRecord.put(Keys.LY82_HOLD_RELEASE_CODE,event.getHoldReleaseCode());

        Enumeration e = event.getCcys();
        Vector currencyDetails = new Vector();
        while(e.hasMoreElements()) {
          HashMap ccy = (HashMap)e.nextElement();
          MappedRecord aRecord = rf.createMappedRecord("C082_CURRENCY_DETAILS");
          aRecord.put(Keys.LY82_CURR_NO,ccy.get("CURR_NO"));
          aRecord.put(Keys.LY82_SDN_NO,ccy.get("SDN_NO"));

          Enumeration f = (Enumeration)ccy.get("COLLECTION_DETAILS");
          Vector collections = new Vector();
          while(f.hasMoreElements()) {
            HashMap coll = (HashMap)f.nextElement();
            MappedRecord bRecord = rf.createMappedRecord("C082_COLLECTION_DETAILS");
            bRecord.put(Keys.LY82_STAT_SLPIT_NO,coll.get("STAT_SPLIT_NO"));
            bRecord.put(Keys.LY82_TDN_REF,coll.get("TDN_REF"));
            bRecord.put(Keys.LY82_TDN_ATTR,coll.get("TDN_ATTR"));
            bRecord.put(Keys.LY82_TREASURY_RATE_Field,coll.get("TREASURY_RATE"));
            bRecord.put(Keys.LY82_TREASURY_ATTR_Field,coll.get("TREASURY_ATTR"));
            collections.add(bRecord);
          }
          aRecord.put("#element[]",collections.toArray());
          currencyDetails.add(aRecord);
        }

        queryRecord.put("#element[]",currencyDetails.toArray());

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