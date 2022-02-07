package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LZ24Event;
import com.xchanging.xcc.events.LZ25Event;
import com.xchanging.xcc.events.LZ26Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CCVCQuestionnaireModel extends WebModel implements ModelUpdateListener
{

    private ModelManager mm;

    private String XCR = "";

    private String UCR = "";

    private String TR = "";

    private String ORIG_REF_1 = "";

    private String ORIG_REF_2 = "";

    private String ORIG_REF_3 = "";

    private String ORIG_BKR = "";

    private String SIGNED_IND = "";

    private String PEER_REV_IND = "";

    private String PAYEE_BKR = "";

    private String PAID_BY_CHEQUE = "";

    private String BKR_PRES_DATE = "";

    private String LDR_PRES_DATE = "";

    private String LLOYDS_LEAD_IND = "";

    private String BORD_IND = "";

    private String DOL_IN_POL_Q = "";

    private String CLAIM_IN_POL_Q = "";

    private String CORRECT_IDENT_Q = "";

    private String DEDUCT_EXCESS_Q = "";

    private String COVERAGE_Q = "";

    private String CAUSE_CODE_Q = "";

    private String LEAD_AGREEMENT_Q = "";

    private String MKT_AGREEMENT_Q = "";

    private String POLICY_DOC_IND = "";

    private String SLIP_DOC_IND = "";

    private String COVER_DOC_IND = "";

    private String LOSS_DETS_DOC_IND = "";

    private String OTHER_DOC_IND = "";

    private String SCREEN_MODE = "";

    /*Flags*/
    private String XCR_ATTR;

    private String UCR_ATTR;

    private String TR_ATTR;

    private String ORIG_REF_ATTR1;

    private String ORIG_REF_ATTR2;

    private String ORIG_REF_ATTR3;

    private String ORIG_BKR_ATTR;

    private String SIGN_IND_ATTR;

    private String PEER_REV_ATTR;

    private String PAYEE_BKR_ATTR;

    private String PAID_BY_CH_ATTR;

    private boolean BKR_DATE_ATTR;

    private boolean LDR_DATE_ATTR;

    private String SY_LEAD_ATTR;

    private String BORD_IND_ATTR;

    private String DOL_IN_POL_ATTR;

    private String CLM_IN_POL_ATTR;

    private String CORRECT_ID_ATTR;

    private String DEDUCT_EX_ATTR;

    private String COVERAGE_ATTR;

    private String CAUSE_CODE_ATTR;

    private String LEAD_AGREE_ATTR;

    private String MKT_AGREE_ATTR;

    private String POLICY_DOC_ATTR;

    private String SLIP_DOC_ATTR;

    private String COVER_DOC_ATTR;

    private String LOSS_DETS_ATTR;

    private String OTHER_DOC_ATTR;

    public CCVCQuestionnaireModel(ModelManager mm)
    {
        this.mm = mm;
        mm.addListener(Keys.CCVCQuestionnaireModelKey, this);
    }

    public void performUpdate()
    {
        ClaimsEvent event = (ClaimsEvent) session.getAttribute(Keys.WebEventKey);

        if (event instanceof LZ24Event)
        {
            MappedRecord results = (MappedRecord) session.getAttribute((Keys.CicsDataKey));

            SCREEN_MODE = (String) results.get(Keys.LZ24_SCREEN_MODE);
            mm.getUserWebModel().setUpdateMode(SCREEN_MODE);

            Vector v = (Vector) results.get(Keys.LZ24_FIELD_VALUES);
            MappedRecord mrFieldValues = (MappedRecord) v.get(0);

            XCR = (String) mrFieldValues.get(Keys.LZ24_XCR);
            UCR = (String) mrFieldValues.get(Keys.LZ24_UCR);
            TR = (String) mrFieldValues.get(Keys.LZ24_TR);
            ORIG_REF_1 = (String) mrFieldValues.get(Keys.LZ24_ORIG_REF_1);
            ORIG_REF_2 = (String) mrFieldValues.get(Keys.LZ24_ORIG_REF_2);
            ORIG_REF_3 = (String) mrFieldValues.get(Keys.LZ24_ORIG_REF_3);
            ORIG_BKR = (String) mrFieldValues.get(Keys.LZ24_ORIG_BKR);
            SIGNED_IND = (String) mrFieldValues.get(Keys.LZ24_SIGNED_IND);
            PEER_REV_IND = (String) mrFieldValues.get(Keys.LZ24_PEER_REV_IND);
            PAYEE_BKR = (String) mrFieldValues.get(Keys.LZ24_PAYEE_BKR);
            PAID_BY_CHEQUE = (String) mrFieldValues.get(Keys.LZ24_PAID_BY_CHEQUE);
            BKR_PRES_DATE = (String) mrFieldValues.get(Keys.LZ24_BKR_PRES_DATE);
            LLOYDS_LEAD_IND = (String) mrFieldValues.get(Keys.LZ24_LLOYDS_LEAD_IND);
            LDR_PRES_DATE = (String) mrFieldValues.get(Keys.LZ24_LDR_PRES_DATE);
            BORD_IND = (String) mrFieldValues.get(Keys.LZ24_BORD_IND);
            DOL_IN_POL_Q = (String) mrFieldValues.get(Keys.LZ24_DOL_IN_POL_Q);
            CLAIM_IN_POL_Q = (String) mrFieldValues.get(Keys.LZ24_CLAIM_IN_POL_Q);
            CORRECT_IDENT_Q = (String) mrFieldValues.get(Keys.LZ24_CORRECT_IDENT_Q);
            DEDUCT_EXCESS_Q = (String) mrFieldValues.get(Keys.LZ24_DEDUCT_EXCESS_Q);
            COVERAGE_Q = (String) mrFieldValues.get(Keys.LZ24_COVERAGE_Q);
            CAUSE_CODE_Q = (String) mrFieldValues.get(Keys.LZ24_CAUSE_CODE_Q);
            LEAD_AGREEMENT_Q = (String) mrFieldValues.get(Keys.LZ24_LEAD_AGREEMENT_Q);
            MKT_AGREEMENT_Q = (String) mrFieldValues.get(Keys.LZ24_MKT_AGREEMENT_Q);
            POLICY_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ24_POLICY_DOC_IND));
            SLIP_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ24_SLIP_DOC_IND));
            COVER_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ24_COVER_DOC_IND));
            LOSS_DETS_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ24_LOSS_DETS_DOC_IND));
            OTHER_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ24_OTHER_DOC_IND));

            Vector vAttributes = (Vector) results.get(Keys.LZ24_FIELD_ATTRIBUTES);
            MappedRecord mrFieldAttributes = (MappedRecord) vAttributes.get(0);

            XCR_ATTR = (String) mrFieldAttributes.get(Keys.LZ24_XCR_ATTR);
            UCR_ATTR = (String) mrFieldAttributes.get(Keys.LZ24_UCR_ATTR);
            TR_ATTR = (String) mrFieldAttributes.get(Keys.LZ24_TR_ATTR);
            ORIG_REF_ATTR1 = (String) mrFieldAttributes.get(Keys.LZ24_ORIG_REF_ATTR1);
            ORIG_REF_ATTR2 = (String) mrFieldAttributes.get(Keys.LZ24_ORIG_REF_ATTR2);
            ORIG_REF_ATTR3 = (String) mrFieldAttributes.get(Keys.LZ24_ORIG_REF_ATTR3);
            ORIG_BKR_ATTR = (String) mrFieldAttributes.get(Keys.LZ24_ORIG_BKR_ATTR);
            SIGN_IND_ATTR = (String) mrFieldAttributes.get(Keys.LZ24_SIGN_IND_ATTR);
            PEER_REV_ATTR = (String) mrFieldAttributes.get(Keys.LZ24_PEER_REV_ATTR);
            PAYEE_BKR_ATTR = (String) mrFieldAttributes.get(Keys.LZ24_PAYEE_BKR_ATTR);
            PAID_BY_CH_ATTR = (String) mrFieldAttributes.get(Keys.LZ24_PAID_BY_CH_ATTR);
            
            BKR_DATE_ATTR = convertToBoolean((String) mrFieldAttributes.get(Keys.LZ24_BKR_DATE_ATTR));
            LDR_DATE_ATTR = convertToBoolean((String) mrFieldAttributes.get(Keys.LZ24_LDR_DATE_ATTR));
            SY_LEAD_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_SY_LEAD_ATTR));
            BORD_IND_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_BORD_IND_ATTR));
            DOL_IN_POL_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_DOL_IN_POL_ATTR));
            CLM_IN_POL_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_CLM_IN_POL_ATTR));
            CORRECT_ID_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_CORRECT_ID_ATTR));
            DEDUCT_EX_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_DEDUCT_EX_ATTR));
            COVERAGE_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_COVERAGE_ATTR));
            CAUSE_CODE_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_CAUSE_CODE_ATTR));
            LEAD_AGREE_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_LEAD_AGREE_ATTR));
            MKT_AGREE_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_MKT_AGREE_ATTR));
            POLICY_DOC_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_POLICY_DOC_ATTR));
            SLIP_DOC_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_SLIP_DOC_ATTR));
            COVER_DOC_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_COVER_DOC_ATTR));
            LOSS_DETS_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_LOSS_DETS_ATTR));
            OTHER_DOC_ATTR = enabledStatusCheckbox((String) mrFieldAttributes.get(Keys.LZ24_OTHER_DOC_ATTR));
        }
        else if (event instanceof LZ25Event)
        {
            MappedRecord results = (MappedRecord) session.getAttribute((Keys.CicsDataKey));

            Vector v = (Vector) results.get(Keys.LZ25_FIELD_VALUES);
            MappedRecord mrFieldValues = (MappedRecord) v.get(0);

            XCR = (String) mrFieldValues.get(Keys.LZ25_XCR);
            UCR = (String) mrFieldValues.get(Keys.LZ25_UCR);
            TR = (String) mrFieldValues.get(Keys.LZ25_TR);
            ORIG_REF_1 = (String) mrFieldValues.get(Keys.LZ25_ORIG_REF_1);
            ORIG_REF_2 = (String) mrFieldValues.get(Keys.LZ25_ORIG_REF_2);
            ORIG_REF_3 = (String) mrFieldValues.get(Keys.LZ25_ORIG_REF_3);
            ORIG_BKR = (String) mrFieldValues.get(Keys.LZ25_ORIG_BKR);
            SIGNED_IND = (String) mrFieldValues.get(Keys.LZ25_SIGNED_IND);
            PEER_REV_IND = (String) mrFieldValues.get(Keys.LZ25_PEER_REV_IND);
            PAYEE_BKR = (String) mrFieldValues.get(Keys.LZ25_PAYEE_BKR);
            PAID_BY_CHEQUE = (String) mrFieldValues.get(Keys.LZ25_PAID_BY_CHEQUE);
            BKR_PRES_DATE = (String) mrFieldValues.get(Keys.LZ25_BKR_PRES_DATE);
            LLOYDS_LEAD_IND = (String) mrFieldValues.get(Keys.LZ25_LLOYDS_LEAD_IND);
            LDR_PRES_DATE = (String) mrFieldValues.get(Keys.LZ25_LDR_PRES_DATE);
            BORD_IND = (String) mrFieldValues.get(Keys.LZ25_BORD_IND);
            DOL_IN_POL_Q = (String) mrFieldValues.get(Keys.LZ25_DOL_IN_POL_Q);
            CLAIM_IN_POL_Q = (String) mrFieldValues.get(Keys.LZ25_CLAIM_IN_POL_Q);
            CORRECT_IDENT_Q = (String) mrFieldValues.get(Keys.LZ25_CORRECT_IDENT_Q);
            DEDUCT_EXCESS_Q = (String) mrFieldValues.get(Keys.LZ25_DEDUCT_EXCESS_Q);
            COVERAGE_Q = (String) mrFieldValues.get(Keys.LZ25_COVERAGE_Q);
            CAUSE_CODE_Q = (String) mrFieldValues.get(Keys.LZ25_CAUSE_CODE_Q);
            LEAD_AGREEMENT_Q = (String) mrFieldValues.get(Keys.LZ25_LEAD_AGREEMENT_Q);
            MKT_AGREEMENT_Q = (String) mrFieldValues.get(Keys.LZ25_MKT_AGREEMENT_Q);
            POLICY_DOC_IND = (String) mrFieldValues.get(Keys.LZ25_POLICY_DOC_IND);
            SLIP_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ25_SLIP_DOC_IND));
            COVER_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ25_COVER_DOC_IND));
            LOSS_DETS_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ25_LOSS_DETS_DOC_IND));
            OTHER_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ25_OTHER_DOC_IND));

        }
        else if (event instanceof LZ26Event)
        {
            MappedRecord results = (MappedRecord) session.getAttribute((Keys.CicsDataKey));

            Vector v = (Vector) results.get(Keys.LZ26_FIELD_VALUES);
            MappedRecord mrFieldValues = (MappedRecord) v.get(0);

            XCR = (String) mrFieldValues.get(Keys.LZ26_XCR);
            UCR = (String) mrFieldValues.get(Keys.LZ26_UCR);
            TR = (String) mrFieldValues.get(Keys.LZ26_TR);
            ORIG_REF_1 = (String) mrFieldValues.get(Keys.LZ26_ORIG_REF_1);
            ORIG_REF_2 = (String) mrFieldValues.get(Keys.LZ26_ORIG_REF_2);
            ORIG_REF_3 = (String) mrFieldValues.get(Keys.LZ26_ORIG_REF_3);
            ORIG_BKR = (String) mrFieldValues.get(Keys.LZ26_ORIG_BKR);
            SIGNED_IND = (String) mrFieldValues.get(Keys.LZ26_SIGNED_IND);
            PEER_REV_IND = (String) mrFieldValues.get(Keys.LZ26_PEER_REV_IND);
            PAYEE_BKR = (String) mrFieldValues.get(Keys.LZ26_PAYEE_BKR);
            PAID_BY_CHEQUE = (String) mrFieldValues.get(Keys.LZ26_PAID_BY_CHEQUE);
            BKR_PRES_DATE = (String) mrFieldValues.get(Keys.LZ26_BKR_PRES_DATE);
            LLOYDS_LEAD_IND = (String) mrFieldValues.get(Keys.LZ26_LLOYDS_LEAD_IND);
            LDR_PRES_DATE = (String) mrFieldValues.get(Keys.LZ26_LDR_PRES_DATE);
            BORD_IND = (String) mrFieldValues.get(Keys.LZ26_BORD_IND);
            DOL_IN_POL_Q = (String) mrFieldValues.get(Keys.LZ26_DOL_IN_POL_Q);
            CLAIM_IN_POL_Q = (String) mrFieldValues.get(Keys.LZ26_CLAIM_IN_POL_Q);
            CORRECT_IDENT_Q = (String) mrFieldValues.get(Keys.LZ26_CORRECT_IDENT_Q);
            DEDUCT_EXCESS_Q = (String) mrFieldValues.get(Keys.LZ26_DEDUCT_EXCESS_Q);
            COVERAGE_Q = (String) mrFieldValues.get(Keys.LZ26_COVERAGE_Q);
            CAUSE_CODE_Q = (String) mrFieldValues.get(Keys.LZ26_CAUSE_CODE_Q);
            LEAD_AGREEMENT_Q = (String) mrFieldValues.get(Keys.LZ26_LEAD_AGREEMENT_Q);
            MKT_AGREEMENT_Q = (String) mrFieldValues.get(Keys.LZ26_MKT_AGREEMENT_Q);
            POLICY_DOC_IND = (String) mrFieldValues.get(Keys.LZ26_POLICY_DOC_IND);
            SLIP_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ26_SLIP_DOC_IND));
            COVER_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ26_COVER_DOC_IND));
            LOSS_DETS_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ26_LOSS_DETS_DOC_IND));
            OTHER_DOC_IND = checkBoxStatus((String) mrFieldValues.get(Keys.LZ26_OTHER_DOC_IND));

        }

    }

    public boolean getBKR_DATE_ATTR()
    {
        return BKR_DATE_ATTR;
    }

    public String getBKR_PRES_DATE()
    {
        return BKR_PRES_DATE;
    }

    public String getBORD_IND()
    {
        return BORD_IND;
    }

    public String getBORD_IND_ATTR()
    {
        return BORD_IND_ATTR;
    }

    public String getCAUSE_CODE_ATTR()
    {
        return CAUSE_CODE_ATTR;
    }

    public String getCAUSE_CODE_Q()
    {
        return CAUSE_CODE_Q;
    }

    public String getCLAIM_IN_POL_Q()
    {
        return CLAIM_IN_POL_Q;
    }

    public String getCLM_IN_POL_ATTR()
    {
        return CLM_IN_POL_ATTR;
    }

    public String getCORRECT_ID_ATTR()
    {
        return CORRECT_ID_ATTR;
    }

    public String getCORRECT_IDENT_Q()
    {
        return CORRECT_IDENT_Q;
    }

    public String getCOVER_DOC_ATTR()
    {
        return COVER_DOC_ATTR;
    }

    public String getCOVER_DOC_IND()
    {
        return COVER_DOC_IND;
    }

    public String getCOVERAGE_ATTR()
    {
        return COVERAGE_ATTR;
    }

    public String getCOVERAGE_Q()
    {
        return COVERAGE_Q;
    }

    public String getDEDUCT_EX_ATTR()
    {
        return DEDUCT_EX_ATTR;
    }

    public String getDEDUCT_EXCESS_Q()
    {
        return DEDUCT_EXCESS_Q;
    }

    public String getDOL_IN_POL_ATTR()
    {
        return DOL_IN_POL_ATTR;
    }

    public String getDOL_IN_POL_Q()
    {
        return DOL_IN_POL_Q;
    }

    public boolean getLDR_DATE_ATTR()
    {
        return LDR_DATE_ATTR;
    }

    public String getLDR_PRES_DATE()
    {
        return LDR_PRES_DATE;
    }

    public String getLEAD_AGREE_ATTR()
    {
        return LEAD_AGREE_ATTR;
    }

    public String getLEAD_AGREEMENT_Q()
    {
        return LEAD_AGREEMENT_Q;
    }

    public String getLLOYDS_LEAD_IND()
    {
        return LLOYDS_LEAD_IND;
    }

    public String getLOSS_DETS_ATTR()
    {
        return LOSS_DETS_ATTR;
    }

    public String getLOSS_DETS_DOC_IND()
    {
        return LOSS_DETS_DOC_IND;
    }

    public String getMKT_AGREE_ATTR()
    {
        return MKT_AGREE_ATTR;
    }

    public String getMKT_AGREEMENT_Q()
    {
        return MKT_AGREEMENT_Q;
    }

    public ModelManager getMm()
    {
        return mm;
    }

    public String getORIG_BKR()
    {
        return ORIG_BKR;
    }

    public String getORIG_BKR_ATTR()
    {
        return ORIG_BKR_ATTR;
    }

    public String getORIG_REF_1()
    {
        return ORIG_REF_1;
    }

    public String getORIG_REF_2()
    {
        return ORIG_REF_2;
    }

    public String getORIG_REF_3()
    {
        return ORIG_REF_3;
    }

    public String getORIG_REF_ATTR1()
    {
        return ORIG_REF_ATTR1;
    }

    public String getORIG_REF_ATTR2()
    {
        return ORIG_REF_ATTR2;
    }

    public String getORIG_REF_ATTR3()
    {
        return ORIG_REF_ATTR3;
    }

    public String getOTHER_DOC_ATTR()
    {
        return OTHER_DOC_ATTR;
    }

    public String getOTHER_DOC_IND()
    {
        return OTHER_DOC_IND;
    }

    public String getPAID_BY_CH_ATTR()
    {
        return PAID_BY_CH_ATTR;
    }

    public String getPAID_BY_CHEQUE()
    {
        return PAID_BY_CHEQUE;
    }

    public String getPAYEE_BKR()
    {
        return PAYEE_BKR;
    }

    public String getPAYEE_BKR_ATTR()
    {
        return PAYEE_BKR_ATTR;
    }

    public String getPEER_REV_ATTR()
    {
        return PEER_REV_ATTR;
    }

    public String getPEER_REV_IND()
    {
        return PEER_REV_IND;
    }

    public String getPOLICY_DOC_ATTR()
    {
        return POLICY_DOC_ATTR;
    }

    public String getPOLICY_DOC_IND()
    {
        return POLICY_DOC_IND;
    }

    public String getSIGN_IND_ATTR()
    {
        return SIGN_IND_ATTR;
    }

    public String getSIGNED_IND()
    {
        return SIGNED_IND;
    }

    public String getSLIP_DOC_ATTR()
    {
        return SLIP_DOC_ATTR;
    }

    public String getSLIP_DOC_IND()
    {
        return SLIP_DOC_IND;
    }

    public String getSY_LEAD_ATTR()
    {
        return SY_LEAD_ATTR;
    }

    public String getTR()
    {
        return TR;
    }

    public String getTR_ATTR()
    {
        return TR_ATTR;
    }

    public String getUCR()
    {
        return UCR;
    }

    public String getUCR_ATTR()
    {
        return UCR_ATTR;
    }

    public String getXCR()
    {
        return XCR;
    }

    public String getXCR_ATTR()
    {
        return XCR_ATTR;
    }

    public String getSCREEN_MODE()
    {
        return SCREEN_MODE;
    }

}
