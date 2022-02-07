package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ25Event;
import com.xchanging.xcc.events.LZ26Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.CCVCQuestionnaireModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class CCVCQuestionnaireOKWebHandler extends WebHandler
{

    public void doStart(HttpServletRequest request)
    {
    }

    public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException
    {
        Vector v = new Vector();
        ModelManager mm = (ModelManager) request.getSession().getAttribute(Keys.ModelManagerKey);
        CCVCQuestionnaireModel ccvcQuestionnaireModel = mm.getCCVCQuestionnaireModel();

        String XCR = ccvcQuestionnaireModel.getXCR();
        String UCR = ccvcQuestionnaireModel.getUCR();
        String TR = ccvcQuestionnaireModel.getTR();
        String ORIG_REF_1 = ccvcQuestionnaireModel.getORIG_REF_1();
        String ORIG_REF_2 = ccvcQuestionnaireModel.getORIG_REF_2();
        String ORIG_REF_3 = ccvcQuestionnaireModel.getORIG_REF_3();
        String ORIG_BKR = ccvcQuestionnaireModel.getORIG_BKR();
        String SIGNED_IND = ccvcQuestionnaireModel.getSIGNED_IND();
        String PEER_REV_IND = ccvcQuestionnaireModel.getPEER_REV_IND();
        String PAYEE_BKR = ccvcQuestionnaireModel.getPAYEE_BKR();
        String PAID_BY_CHEQUE = ccvcQuestionnaireModel.getPAID_BY_CHEQUE();

        String BKR_PRES_DATE = formatDate(request.getParameter("BKR_PRES_DATEyyyy"), request.getParameter("BKR_PRES_DATEmm"), request.getParameter("BKR_PRES_DATEdd"));
        String LDR_PRES_DATE = formatDate(request.getParameter("LDR_PRES_DATEyyyy"), request.getParameter("LDR_PRES_DATEmm"), request.getParameter("LDR_PRES_DATEdd"));

        String LLOYDS_LEAD_IND = request.getParameter("LLOYDS_LEAD_IND") == null ? ccvcQuestionnaireModel.getLLOYDS_LEAD_IND() : request.getParameter("LLOYDS_LEAD_IND");
        String BORD_IND = request.getParameter("BORD_IND")== null ? ccvcQuestionnaireModel.getBORD_IND() : request.getParameter("BORD_IND");
        String DOL_IN_POL_Q = request.getParameter("DOL_IN_POL_Q")== null ? ccvcQuestionnaireModel.getDOL_IN_POL_Q() : request.getParameter("DOL_IN_POL_Q");
        String CLAIM_IN_POL_Q = request.getParameter("CLAIM_IN_POL_Q")== null ? ccvcQuestionnaireModel.getCLAIM_IN_POL_Q() : request.getParameter("CLAIM_IN_POL_Q");
        String CORRECT_IDENT_Q = request.getParameter("CORRECT_IDENT_Q")== null ? ccvcQuestionnaireModel.getCORRECT_IDENT_Q() : request.getParameter("CORRECT_IDENT_Q");
        String DEDUCT_EXCESS_Q = request.getParameter("DEDUCT_EXCESS_Q")== null ? ccvcQuestionnaireModel.getDEDUCT_EXCESS_Q() : request.getParameter("DEDUCT_EXCESS_Q");
        String COVERAGE_Q = request.getParameter("COVERAGE_Q")== null ? ccvcQuestionnaireModel.getCOVERAGE_Q() : request.getParameter("COVERAGE_Q");
        String CAUSE_CODE_Q = request.getParameter("CAUSE_CODE_Q")== null ? ccvcQuestionnaireModel.getCAUSE_CODE_Q() : request.getParameter("CAUSE_CODE_Q");
        String LEAD_AGREEMENT_Q = request.getParameter("LEAD_AGREEMENT_Q")== null ? ccvcQuestionnaireModel.getLEAD_AGREEMENT_Q() : request.getParameter("LEAD_AGREEMENT_Q");
        String MKT_AGREEMENT_Q = request.getParameter("MKT_AGREEMENT_Q")== null ? ccvcQuestionnaireModel.getMKT_AGREEMENT_Q() : request.getParameter("MKT_AGREEMENT_Q");

        String POLICY_DOC_IND = request.getParameter("POLICY_DOC_IND") == null ? "N" : "Y";
        String SLIP_DOC_IND = request.getParameter("SLIP_DOC_IND") == null ? "N" : "Y";
        String COVER_DOC_IND = request.getParameter("COVER_DOC_IND") == null ? "N" : "Y";
        String LOSS_DETS_DOC_IND = request.getParameter("LOSS_DETS_DOC_IND") == null ? "N" : "Y";
        String OTHER_DOC_IND = request.getParameter("OTHER_DOC_IND") == null ? "N" : "Y";

        v.add(new LZ25Event(XCR, UCR, TR, ORIG_REF_1, ORIG_REF_2, ORIG_REF_3, ORIG_BKR, SIGNED_IND, PEER_REV_IND, PAYEE_BKR, PAID_BY_CHEQUE, BKR_PRES_DATE, LDR_PRES_DATE, LLOYDS_LEAD_IND, BORD_IND,
                DOL_IN_POL_Q, CLAIM_IN_POL_Q, CORRECT_IDENT_Q, DEDUCT_EXCESS_Q, COVERAGE_Q, CAUSE_CODE_Q, LEAD_AGREEMENT_Q, MKT_AGREEMENT_Q, POLICY_DOC_IND, SLIP_DOC_IND, COVER_DOC_IND,
                LOSS_DETS_DOC_IND, OTHER_DOC_IND));

        v.add(new LZ26Event(XCR, UCR, TR, ORIG_REF_1, ORIG_REF_2, ORIG_REF_3, ORIG_BKR, SIGNED_IND, PEER_REV_IND, PAYEE_BKR, PAID_BY_CHEQUE, BKR_PRES_DATE, LDR_PRES_DATE, LLOYDS_LEAD_IND, BORD_IND,
                DOL_IN_POL_Q, CLAIM_IN_POL_Q, CORRECT_IDENT_Q, DEDUCT_EXCESS_Q, COVERAGE_Q, CAUSE_CODE_Q, LEAD_AGREEMENT_Q, MKT_AGREEMENT_Q, POLICY_DOC_IND, SLIP_DOC_IND, COVER_DOC_IND,
                LOSS_DETS_DOC_IND, OTHER_DOC_IND));

        return v;
    }

    public void doEnd(HttpServletRequest request)
    {

    }
}
