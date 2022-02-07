package com.xchanging.xcc.events;

import java.util.Enumeration;
import java.util.Vector;

public class LZ25Event extends ClaimsEvent implements java.io.Serializable
{

    private int userSession;

    private String XCR;

    private String UCR;

    private String TR;

    private String ORIG_REF_1;

    private String ORIG_REF_2;

    private String ORIG_REF_3;

    private String ORIG_BKR;

    private String SIGNED_IND;

    private String PEER_REV_IND;

    private String PAYEE_BKR;

    private String PAID_BY_CHEQUE;

    private String BKR_PRES_DATE;

    private String LDR_PRES_DATE;

    private String LLOYDS_LEAD_IND;

    private String BORD_IND;

    private String DOL_IN_POL_Q;

    private String CLAIM_IN_POL_Q;

    private String CORRECT_IDENT_Q;

    private String DEDUCT_EXCESS_Q;

    private String COVERAGE_Q;

    private String CAUSE_CODE_Q;

    private String LEAD_AGREEMENT_Q;

    private String MKT_AGREEMENT_Q;

    private String POLICY_DOC_IND;

    private String SLIP_DOC_IND;

    private String COVER_DOC_IND;

    private String LOSS_DETS_DOC_IND;

    private String OTHER_DOC_IND;

    public LZ25Event(String XCR, String UCR, String TR, String ORIG_REF_1, String ORIG_REF_2, String ORIG_REF_3, String ORIG_BKR, String SIGNED_IND, String PEER_REV_IND, String PAYEE_BKR,
            String PAID_BY_CHEQUE, String BKR_PRES_DATE, String LDR_PRES_DATE, String LLOYDS_LEAD_IND, String BORD_IND, String DOL_IN_POL_Q, String CLAIM_IN_POL_Q, String CORRECT_IDENT_Q,
            String DEDUCT_EXCESS_Q, String COVERAGE_Q, String CAUSE_CODE_Q, String LEAD_AGREEMENT_Q, String MKT_AGREEMENT_Q, String POLICY_DOC_IND, String SLIP_DOC_IND, String COVER_DOC_IND,
            String LOSS_DETS_DOC_IND, String OTHER_DOC_IND)
    {
        this.XCR = XCR;
        this.UCR = UCR;
        this.TR = TR;
        this.ORIG_REF_1 = ORIG_REF_1;
        this.ORIG_REF_2 = ORIG_REF_2;
        this.ORIG_REF_3 = ORIG_REF_3;
        this.ORIG_BKR = ORIG_BKR;
        this.SIGNED_IND = SIGNED_IND;
        this.PEER_REV_IND = PEER_REV_IND;
        this.PAYEE_BKR = PAYEE_BKR;
        this.PAID_BY_CHEQUE = PAID_BY_CHEQUE;
        this.BKR_PRES_DATE = BKR_PRES_DATE;
        this.LDR_PRES_DATE = LDR_PRES_DATE;
        this.LLOYDS_LEAD_IND = LLOYDS_LEAD_IND;
        this.BORD_IND = BORD_IND;
        this.DOL_IN_POL_Q = DOL_IN_POL_Q;
        this.CLAIM_IN_POL_Q = CLAIM_IN_POL_Q;
        this.CORRECT_IDENT_Q = CORRECT_IDENT_Q;
        this.DEDUCT_EXCESS_Q = DEDUCT_EXCESS_Q;
        this.COVERAGE_Q = COVERAGE_Q;
        this.CAUSE_CODE_Q = CAUSE_CODE_Q;
        this.LEAD_AGREEMENT_Q = LEAD_AGREEMENT_Q;
        this.MKT_AGREEMENT_Q = MKT_AGREEMENT_Q;
        this.POLICY_DOC_IND = POLICY_DOC_IND;
        this.SLIP_DOC_IND = SLIP_DOC_IND;
        this.COVER_DOC_IND = COVER_DOC_IND;
        this.LOSS_DETS_DOC_IND = LOSS_DETS_DOC_IND;
        this.OTHER_DOC_IND = OTHER_DOC_IND;
    }

    public String getName()
    {
        return "java:comp/env/event/LZ25Event";
    }

    public int getType()
    {
        return VALIDATE;
    }

    public String getHandlerName()
    {
        return "com.xchanging.xcc.cics.handlers.LZ25CICSHandler";
    }

    public int getUserSession()
    {
        return userSession;
    }

    public void setUserSession(int userSession)
    {
        this.userSession = userSession;
    }

    public String getBKR_PRES_DATE()
    {
        return BKR_PRES_DATE;
    }

    public String getBORD_IND()
    {
        return BORD_IND;
    }

    public String getCAUSE_CODE_Q()
    {
        return CAUSE_CODE_Q;
    }

    public String getCLAIM_IN_POL_Q()
    {
        return CLAIM_IN_POL_Q;
    }

    public String getCORRECT_IDENT_Q()
    {
        return CORRECT_IDENT_Q;
    }

    public String getCOVER_DOC_IND()
    {
        return COVER_DOC_IND;
    }

    public String getCOVERAGE_Q()
    {
        return COVERAGE_Q;
    }

    public String getDEDUCT_EXCESS_Q()
    {
        return DEDUCT_EXCESS_Q;
    }

    public String getDOL_IN_POL_Q()
    {
        return DOL_IN_POL_Q;
    }

    public String getLDR_PRES_DATE()
    {
        return LDR_PRES_DATE;
    }

    public String getLEAD_AGREEMENT_Q()
    {
        return LEAD_AGREEMENT_Q;
    }

    public String getLLOYDS_LEAD_IND()
    {
        return LLOYDS_LEAD_IND;
    }

    public String getLOSS_DETS_DOC_IND()
    {
        return LOSS_DETS_DOC_IND;
    }

    public String getMKT_AGREEMENT_Q()
    {
        return MKT_AGREEMENT_Q;
    }

    public String getORIG_BKR()
    {
        return ORIG_BKR;
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

    public String getOTHER_DOC_IND()
    {
        return OTHER_DOC_IND;
    }

    public String getPAID_BY_CHEQUE()
    {
        return PAID_BY_CHEQUE;
    }

    public String getPAYEE_BKR()
    {
        return PAYEE_BKR;
    }

    public String getPEER_REV_IND()
    {
        return PEER_REV_IND;
    }

    public String getPOLICY_DOC_IND()
    {
        return POLICY_DOC_IND;
    }

    public String getSIGNED_IND()
    {
        return SIGNED_IND;
    }

    public String getSLIP_DOC_IND()
    {
        return SLIP_DOC_IND;
    }

    public String getTR()
    {
        return TR;
    }

    public String getUCR()
    {
        return UCR;
    }

    public String getXCR()
    {
        return XCR;
    }
}