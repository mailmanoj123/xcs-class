package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;
import javax.resource.cci.RecordFactory;

import com.attunity.adapter.AttuInteractionSpec;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ25Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.utils.Keys;

public class LZ25CICSHandler extends CICSHandler implements java.io.Serializable
{

    private MappedRecord results;

    private String fieldHdr = "C123";

    public MappedRecord getResults()
    {
        return results;
    }

    public void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException
    {

        LZ25Event event = (LZ25Event) ce;
        Logger.info("CCVC Validation..." + event.getUserSession());

        try
        {

            /**
             * Create a new InteractionSpec and create a RecordFactory for the
             * Logoff 'in' parameters
             */
            AttuInteractionSpec iSpeq = new AttuInteractionSpec("lz25");
            iSpeq.setExecutionTimeout(WAIT_TIME);
            RecordFactory rf = sm.getRecordFactory();
            MappedRecord queryRecord = rf.createMappedRecord("lz25");

            /**
             * Map the user entered data into the MappedRecord
             */

            queryRecord.put(Keys.LZ25_SESSION_NO, Integer.toString(event.getUserSession()));

            Vector fieldTable = new Vector(1);

            MappedRecord fieldValues = rf.createMappedRecord("C123_FIELD_VALUES");
            fieldValues.put(Keys.LZ25_XCR, event.getXCR());
            fieldValues.put(Keys.LZ25_UCR, event.getUCR());
            fieldValues.put(Keys.LZ25_TR, event.getTR());
            fieldValues.put(Keys.LZ25_ORIG_REF_1, event.getORIG_REF_1());
            fieldValues.put(Keys.LZ25_ORIG_REF_2, event.getORIG_REF_2());
            fieldValues.put(Keys.LZ25_ORIG_REF_3, event.getORIG_REF_3());
            fieldValues.put(Keys.LZ25_ORIG_BKR, event.getORIG_BKR());
            fieldValues.put(Keys.LZ25_SIGNED_IND, event.getSIGNED_IND());
            fieldValues.put(Keys.LZ25_PEER_REV_IND, event.getPEER_REV_IND());
            fieldValues.put(Keys.LZ25_PAYEE_BKR, event.getPAYEE_BKR());
            fieldValues.put(Keys.LZ25_PAID_BY_CHEQUE, event.getPAID_BY_CHEQUE());
            fieldValues.put(Keys.LZ25_BKR_PRES_DATE, event.getBKR_PRES_DATE());
            fieldValues.put(Keys.LZ25_LDR_PRES_DATE, event.getLDR_PRES_DATE());
            fieldValues.put(Keys.LZ25_LLOYDS_LEAD_IND, event.getLLOYDS_LEAD_IND());
            fieldValues.put(Keys.LZ25_BORD_IND, event.getBORD_IND());
            fieldValues.put(Keys.LZ25_DOL_IN_POL_Q, event.getDOL_IN_POL_Q());
            fieldValues.put(Keys.LZ25_CLAIM_IN_POL_Q, event.getCLAIM_IN_POL_Q());
            fieldValues.put(Keys.LZ25_CORRECT_IDENT_Q, event.getCORRECT_IDENT_Q());
            fieldValues.put(Keys.LZ25_DEDUCT_EXCESS_Q, event.getDEDUCT_EXCESS_Q());
            fieldValues.put(Keys.LZ25_COVERAGE_Q, event.getCOVERAGE_Q());
            fieldValues.put(Keys.LZ25_CAUSE_CODE_Q, event.getCAUSE_CODE_Q());
            fieldValues.put(Keys.LZ25_LEAD_AGREEMENT_Q, event.getLEAD_AGREEMENT_Q());
            fieldValues.put(Keys.LZ25_MKT_AGREEMENT_Q, event.getMKT_AGREEMENT_Q());
            fieldValues.put(Keys.LZ25_POLICY_DOC_IND, event.getPOLICY_DOC_IND());
            fieldValues.put(Keys.LZ25_SLIP_DOC_IND, event.getSLIP_DOC_IND());
            fieldValues.put(Keys.LZ25_COVER_DOC_IND, event.getCOVER_DOC_IND());
            fieldValues.put(Keys.LZ25_LOSS_DETS_DOC_IND, event.getLOSS_DETS_DOC_IND());
            fieldValues.put(Keys.LZ25_OTHER_DOC_IND, event.getOTHER_DOC_IND());

            fieldTable.add(fieldValues);
            queryRecord.put("#element[]", fieldTable.toArray());

            /**
             * Execute the query
             */
            Record oRec = interaction.execute(iSpeq, queryRecord);
            writeXML(oRec);

            results = (MappedRecord) oRec;
            int errorCount = errorsFound(results, fieldHdr);
            int warningCount = warningsFound(results, fieldHdr);

            /**
             * Check for errors
             */
            if (errorCount > 0)
            {
                processErrors(results, fieldHdr);
            }
            /**
             * Check for warnings
             */
            else if (warningCount > 0)
            {
                processWarnings(results, fieldHdr);
            }

        }
        catch (ClaimsErrorException cee)
        {
            throw new ClaimsErrorException(cee.getErrors());
        }
        catch (ClaimsWarningException cee)
        {
            throw new ClaimsWarningException(cee.getWarnings());
        }
        catch (Exception re)
        {
            throw new GeneralFailureException(re.getMessage());
        }
    }
}