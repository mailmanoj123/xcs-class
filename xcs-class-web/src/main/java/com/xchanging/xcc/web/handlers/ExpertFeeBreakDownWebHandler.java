package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SCMAdviceModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ExpertFeeBreakDownWebHandler extends WebHandler
{

    public void doStart(HttpServletRequest request)
    {
    }

    public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException
    {
        ModelManager mm = (ModelManager) request.getSession().getAttribute(Keys.ModelManagerKey);
        SCMAdviceModel scmAdvice = mm.getSCMAdviceModel();
        Vector v = new Vector();

        if (scmAdvice.getScreenMode() != null && scmAdvice.getScreenMode().trim().equalsIgnoreCase("U"))
        {
            String dolTo = formatDate(request.getParameter("dolToyyyy"), request.getParameter("dolTomm"), request.getParameter("dolTodd"));
            String dolFrom = formatDate(request.getParameter("dolFromyyyy"), request.getParameter("dolFrommm"), request.getParameter("dolFromdd"));
            String dcmFrom = formatDate(request.getParameter("dcmDodFromyyyy"), request.getParameter("dcmDodFrommm"), request.getParameter("dcmDodFromdd"));
            String dcmTo = formatDate(request.getParameter("dcmDodToyyyy"), request.getParameter("dcmDodTomm"), request.getParameter("dcmDodTodd"));
            String polPerFrom = formatDate(request.getParameter("polCertPeriodFromyyyy"), request.getParameter("polCertPeriodFrommm"), request.getParameter("polCertPeriodFromdd"));
            String polPerTo = formatDate(request.getParameter("polCertPeriodToyyyy"), request.getParameter("polCertPeriodTomm"), request.getParameter("polCertPeriodTodd"));

            scmAdvice.setClaimNarrative(request.getParameter("claimNarrative"));
            scmAdvice.setClaimRefRec(request.getParameter("clmRefRec"));
            scmAdvice.setOrigCcy(request.getParameter("origCcy"));
            scmAdvice.setSettCcy(request.getParameter("settCcy"));
            scmAdvice.setSettRateOfExch(request.getParameter("settRateOfExc"));
            scmAdvice.setPTDLoss(request.getParameter("ptdLoss"));
            scmAdvice.setPTDExp(request.getParameter("ptdExp"));
            scmAdvice.setPTDFee(request.getParameter("ptdFee"));
            scmAdvice.setPTDTotal(request.getParameter("ptdTotal"));
            scmAdvice.setPTTLoss(request.getParameter("pttLoss"));
            scmAdvice.setPTTExp(request.getParameter("pttExp"));
            scmAdvice.setPTTFee(request.getParameter("pttFee"));
            scmAdvice.setPTTTotal(request.getParameter("pttTotal"));
            scmAdvice.setOsLoss(request.getParameter("osLoss"));
            scmAdvice.setOsLossQual(request.getParameter("osLossqual"));
            scmAdvice.setOsExp(request.getParameter("osExp"));
            scmAdvice.setOsFee(request.getParameter("osFee"));
            scmAdvice.setOsFeeQual(request.getParameter("osFeeQual"));
            scmAdvice.setOsTotal(request.getParameter("osTotal"));
            scmAdvice.setOsTotalQual(request.getParameter("osTotalQual"));
            scmAdvice.setPTDInSettCcy(request.getParameter("ptdInSettCcy"));
            scmAdvice.setSettledRateInSettCcy(request.getParameter("settledRateInSettCcy"));
            scmAdvice.setTotalLine(request.getParameter("totalLine"));
            scmAdvice.setBureauPpn(request.getParameter("bureauPpn"));
            scmAdvice.setVATAmount(request.getParameter("vatAmount"));
            scmAdvice.setWARAmount(request.getParameter("warAmount"));
            scmAdvice.setNarrativeCode1(request.getParameter("narrativeCode1"));
            scmAdvice.setNarrativeCode2(request.getParameter("narrativeCode2"));
            scmAdvice.setNarrativeForSet(request.getParameter("narrativeForSet"));
            scmAdvice.setNarrativeForSet2(request.getParameter("narrativeForSet2"));
            scmAdvice.setNarrativeForSet3(request.getParameter("narrativeForSet3"));
            scmAdvice.setCheckedSubrogation(checkBoxStatus(checkboxValue(request.getParameter("subrogation"))));
            scmAdvice.setXCSRecovery(request.getParameter("xcsRecovery"));
            scmAdvice.setHighestEst(request.getParameter("highestEst"));
            scmAdvice.setIncurred(request.getParameter("incurred"));
            scmAdvice.setOsRateOfExch(request.getParameter("osRateOfExch"));
            scmAdvice.setFinderCode1(request.getParameter("finderCode1"));
            scmAdvice.setFinderCode2(request.getParameter("finderCode2"));
            scmAdvice.setFinderCode3(request.getParameter("finderCode3"));
            scmAdvice.setCheckedAttachmentsInd(checkBoxStatus(checkboxValue(request.getParameter("attachmentsInd"))));
            scmAdvice.setBrokerContact(request.getParameter("brokerContact"));
            scmAdvice.setBrokerPhoneNo(request.getParameter("brokerPhoneNo"));
            scmAdvice.setServiceType(request.getParameter("serviceType"));
            scmAdvice.setBrokerClaimRef1(request.getParameter("brokerClaimRef"));
            scmAdvice.setBrokerClaimRef2(request.getParameter("brokerClaimRef2"));
            scmAdvice.setCountryOfOrigin(request.getParameter("countryOfOrigin"));
            scmAdvice.setOrigInsured(request.getParameter("origInsured"));
            scmAdvice.setInsured(request.getParameter("insured"));
            scmAdvice.setResinsured(request.getParameter("reinsured"));
            scmAdvice.setClaimholder(request.getParameter("ch"));
            scmAdvice.setClaimant(request.getParameter("claimant"));
            scmAdvice.setVesselAircraft(request.getParameter("vesselAircraftConveyance"));
            scmAdvice.setOtherName(request.getParameter("otherName"));
            scmAdvice.setPolCertPeriodFrom(polPerFrom);
            scmAdvice.setPolCertPeriodTo(polPerTo);
            scmAdvice.setPolCertQual(request.getParameter("polCertQualifier"));
            scmAdvice.setDOLFrom(dolFrom);
            scmAdvice.setDOLTo(dolTo);
            scmAdvice.setDOLQual(request.getParameter("dolQual"));
            scmAdvice.setDolNarr(request.getParameter("dolNarr"));
            scmAdvice.setDCMFrom(dcmFrom);
            scmAdvice.setDCMTo(dcmTo);
            scmAdvice.setDCMQual(request.getParameter("dcmDodQual"));
            scmAdvice.setCatCode(request.getParameter("catCode"));
            scmAdvice.setPcsCode(request.getParameter("pcsCode"));
            scmAdvice.setCcyOfLimits(request.getParameter("ccyOfLimits"));
            scmAdvice.setLimits(request.getParameter("limits"));
            scmAdvice.setExcess(request.getParameter("excess"));
            scmAdvice.setPerilsCondition(request.getParameter("perilsCondition"));
            scmAdvice.setLossLocation(request.getParameter("lossLocation"));
            scmAdvice.setVoyage(request.getParameter("voyage"));
            scmAdvice.setLossName(request.getParameter("lossName"));
            scmAdvice.setLawyerName(request.getParameter("lawyerName"));
            scmAdvice.setLawyerRef(request.getParameter("lawyerRef"));
            scmAdvice.setLawyerCode(request.getParameter("lawyerCode"));
            scmAdvice.setAdjusterName(request.getParameter("adjusterName"));
            scmAdvice.setAdjusterRef(request.getParameter("adjusterRef"));
            scmAdvice.setAdjusterCode(request.getParameter("adjusterCode"));
            scmAdvice.setSchemeCode(request.getParameter("schemeCode"));
            scmAdvice.setTfCode(request.getParameter("tfCode"));
            scmAdvice.setStateCode(request.getParameter("stateCode"));
            scmAdvice.setNaicCode(request.getParameter("naicCode"));
            scmAdvice.setNaicQual(request.getParameter("naicQual"));
            scmAdvice.setCheckedWarInd(checkBoxStatus(checkboxValue(request.getParameter("warInd"))));
            scmAdvice.setFilCode1(request.getParameter("filCode1"));
            scmAdvice.setFilCode2(request.getParameter("filCode2"));
            scmAdvice.setOtherTfCode(request.getParameter("otherTfCode"));
            scmAdvice.setDti(request.getParameter("dti"));
            scmAdvice.setCheckedUsaCanInd(checkBoxStatus(checkboxValue(request.getParameter("usaCanInd"))));
            scmAdvice.setCheckedLFEntryInd(checkBoxStatus(checkboxValue(request.getParameter("lfEntryInd"))));
            scmAdvice.setCheckedLFAdvanceInd(checkBoxStatus(checkboxValue(request.getParameter("lfAdvancedInd"))));
            scmAdvice.setCheckedBlockInd(checkBoxStatus(checkboxValue(request.getParameter("blockInd"))));
            scmAdvice.setCheckedDirectReportInd(checkBoxStatus(checkboxValue(request.getParameter("directReportInd"))));
            scmAdvice.setCheckedClmInLitigationInd(checkBoxStatus(checkboxValue(request.getParameter("clmInLitigationInd"))));

            scmAdvice.setCountyCode(request.getParameter("countyCode"));
            // To fix SIR 232475
            scmAdvice.setBarcode(request.getParameter("barcode"));
        }
        return v;
    }

    private String checkBoxStatus(String str)
    {
        if (str.equals("N"))
        {
            return "";
        }
        else
        {
            return "CHECKED";
        }
    }

    public void doEnd(HttpServletRequest request)
    {
    }

}
