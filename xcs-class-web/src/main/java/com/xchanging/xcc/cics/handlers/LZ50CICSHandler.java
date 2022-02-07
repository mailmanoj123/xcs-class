package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.ResourceException;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ50Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

/**
 Commarea - C150 (LZ50)
 Program  - Associated Screen/Process:- Scheme Canada
 Devo
 */

public class LZ50CICSHandler extends CICSHandler implements java.io.Serializable {

  private MappedRecord results;
  private String fieldHdr = "C150";

  public MappedRecord getResults() {
    return results;
  }

  public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException {

    LZ50Event event = (LZ50Event)ce;
    Logger.info("Build Scheme Canada Unmatched Items... " + event.getUserSession());

      try {

        /**
         * Create a new InteractionSpec and create a RecordFactory for
         * the Logoff 'in' parameters
         */
        AttuInteractionSpec iSpeq = new AttuInteractionSpec("lz50");
        iSpeq.setExecutionTimeout(WAIT_TIME);
RecordFactory rf = sm.getRecordFactory();
        MappedRecord queryRecord = rf.createMappedRecord("lz50");

        /**
         * Map the user entered data into the MappedRecord
         */

        queryRecord.put(Keys.LZ50_SessionID_Field,Integer.toString(event.getUserSession()));

        queryRecord.put(Keys.LZ50_FUNCTION,event.getFunction());
        queryRecord.put(Keys.LZ50_SAVED_FLAG, event.getSavedFlag());
        queryRecord.put(Keys.LZ50_HEADER_BUS_CLASS, event.getHeaderBusClass());
        queryRecord.put(Keys.LZ50_PREV_PRESSED, event.getPrevPressed());
        queryRecord.put(Keys.LZ50_NEXT_PRESSED, event.getNextPressed());

        if (event.getFunction().equals("ACTION") && event.getRowNumber() != null) {
          // Action dropdown
          // Get the details for the Row that has changed
          String rowNumber = event.getRowNumber()[0];
          String processFlag = event.getProcessFlag()[0];
          String flagChangedInd = event.getFlagChangedInd()[0];

          // Place blanks in the function name and create the MappedRecord
          MappedRecord fieldValuesRecord = rf.createMappedRecord("C150_FIELD_VALUES");
          Vector vFieldTable = new Vector(1);

          // Update the MappedRecord with the new details for the Row
          fieldValuesRecord.put(Keys.LZ50_ROW_NUMBER,rowNumber);
          fieldValuesRecord.put(Keys.LZ50_PROCESS_FLAG,processFlag);
          fieldValuesRecord.put(Keys.LZ50_FLAG_CHANGED_IND,flagChangedInd);

          vFieldTable.add(fieldValuesRecord);
          queryRecord.put("#element[]",vFieldTable.toArray());

        }

        MappedRecord fieldAttributesRecord = rf.createMappedRecord("C150_FIELD_ATTRIBUTES");
        Vector vFieldAttributesTable = new Vector(1);

        // Update the MappedRecord with the new details
        fieldAttributesRecord.put(Keys.LZ50_PREV_ATTR,event.getPrevAttr());
        fieldAttributesRecord.put(Keys.LZ50_NEXT_ATTR,event.getNextAttr());
        fieldAttributesRecord.put(Keys.LZ50_AUTO_ATTR,event.getAutoAttr());
        fieldAttributesRecord.put(Keys.LZ50_COMMERCIAL_ATTR,event.getCommercialAttr());
        fieldAttributesRecord.put(Keys.LZ50_RESIDENTIAL_ATTR,event.getResidentialAttr());

        vFieldAttributesTable.add(fieldAttributesRecord);
        queryRecord.put("#element[]",vFieldAttributesTable.toArray());

        MappedRecord displayCountsRecord = rf.createMappedRecord("C150_DISPLAY_COUNTS");
        Vector vDisplayCountsTable = new Vector(1);

        // Update the MappedRecord with the new details
        displayCountsRecord.put(Keys.LZ50_SCR_FIRST_ROW,event.getFirstRow());
        displayCountsRecord.put(Keys.LZ50_SCR_LAST_ROW,event.getLastRow());
        displayCountsRecord.put(Keys.LZ50_DB_TOTAL_ROWS,event.getTotalRows());

        vDisplayCountsTable.add(displayCountsRecord);
        queryRecord.put("#element[]",vDisplayCountsTable.toArray());

        MappedRecord statsRecord = rf.createMappedRecord("C150_STATS");
        Vector vStatsTable = new Vector(1);

        // Update the MappedRecord with the new details
        // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
        statsRecord.put(Keys.LZ50_REPROC_TOTAL,event.getReprocTotal());
        statsRecord.put(Keys.LZ50_XCS_TOTAL,event.getXcsTotal());
        statsRecord.put(Keys.LZ50_FILLER," ");
        statsRecord.put(Keys.LZ50_FILLER1," ");
        
        
        /* 26/04/04 changes for S456/S457. Patrick Cogan
        statsRecord.put(Keys.LZ50_DELETE_TOTAL,event.getDeleteTotal());
        statsRecord.put(Keys.LZ50_REJECT_TOTAL,event.getRejectTotal());
        statsRecord.put(Keys.LZ50_INDIV_TOTAL,event.getIndivTotal());
        statsRecord.put(Keys.LZ50_BLOCK_TOTAL,event.getBlockTotal());
        statsRecord.put(Keys.LZ50_ZEROS_TOTAL,event.getZerosTotal());
*/
        vStatsTable.add(statsRecord);
        queryRecord.put("#element[]",vStatsTable.toArray());
        // PRC: Added this statement so that we can see what data is sent to the MF.
        writeXML(queryRecord);

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
      catch (ResourceException re) {
          // Changed Ecxeption to resourceException, so that other exceptions raised are more meaningfull.
        throw new GeneralFailureException(re.getMessage());
      }
  }
}
