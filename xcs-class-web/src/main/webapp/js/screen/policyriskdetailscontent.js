try {
  var uoForm = new VForm(policyriskdetailscontent) ;

    var peerReview = new VField(policyriskdetailscontent.peerReview, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Peer Review", VField.CHECK_WIDTH_MINIMUM, 1, VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);

    // CCN# N0030 - BA - 13/01/2003
    var marketCode = new VField(policyriskdetailscontent.marketCode, VField.TYPE_ALPHA, VField.LONG_NAME, "Market Code", VField.CHECK_MANDATORY, true) ;

    var currentBkr = new VField(policyriskdetailscontent.currentBkr, VField.TYPE_NUMERIC, VField.LONG_NAME, "Current Broker", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 4, VField.CHECK_WIDTH_MAXIMUM, 4, VField.FORMAT_CASE, VField.CASE_UPPER, VField.CHECK_NO_COMMAS, true);
    var riskCode = new VField(policyriskdetailscontent.riskCode, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Risk Code", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 1, VField.CHECK_WIDTH_MAXIMUM, 2, VField.FORMAT_CASE, VField.CASE_UPPER);
    var yoa = new VField(policyriskdetailscontent.yoa, VField.TYPE_NUMERIC, VField.LONG_NAME, "Year Of Account", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    // CCN #555 - BA - Only allow 50 chars for interest
    var interest = new VField(policyriskdetailscontent.interest, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Interest", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER);
    var perilsCondition = new VField(policyriskdetailscontent.perilsCondition, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Perils/Condition", VField.CHECK_WIDTH_MAXIMUM, 70, VField.FORMAT_CASE, VField.CASE_UPPER);
    var locationVoyageOfRisk = new VField(policyriskdetailscontent.locationVoyageOfRisk, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Location/Voyage of Risk", VField.CHECK_WIDTH_MAXIMUM, 70, VField.FORMAT_CASE, VField.CASE_UPPER);
    var slipOrder1 = new VField(policyriskdetailscontent.slipOrder1, VField.TYPE_NUMERIC, VField.LONG_NAME, "Slip Order 1", VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "100", VField.CHECK_NUMERIC_PLACES, 3, VField.CHECK_DECIMAL_PLACES, 7);
    var slipOrder2 = new VField(policyriskdetailscontent.slipOrder2, VField.TYPE_NUMERIC, VField.LONG_NAME, "Slip Order 2", VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "100", VField.CHECK_NUMERIC_PLACES, 3, VField.CHECK_DECIMAL_PLACES, 7);
    var ccyOfLimits1 = new VField(policyriskdetailscontent.ccyOfLimits1, VField.TYPE_ALPHA, VField.LONG_NAME, "Ccy of Limits 1", VField.CHECK_WIDTH_OPTIONAL_EXACT, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
    var limits1 = new VField(policyriskdetailscontent.limits1, VField.TYPE_NUMERIC, VField.LONG_NAME, "Limits 1", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var excess1 = new VField(policyriskdetailscontent.excess1, VField.TYPE_NUMERIC, VField.LONG_NAME, "Excess 1", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var ccyOfLimits2 = new VField(policyriskdetailscontent.ccyOfLimits2, VField.TYPE_ALPHA, VField.LONG_NAME, "Ccy of Limits 2", VField.CHECK_WIDTH_OPTIONAL_EXACT, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
    var limits2 = new VField(policyriskdetailscontent.limits2, VField.TYPE_NUMERIC, VField.LONG_NAME, "Limits 2", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true); 
    var excess2 = new VField(policyriskdetailscontent.excess2, VField.TYPE_NUMERIC, VField.LONG_NAME, "Excess 2", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var ccyOfLimits3 = new VField(policyriskdetailscontent.ccyOfLimits3, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Ccy of Limits 3", VField.CHECK_WIDTH_OPTIONAL_EXACT, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
    var limits3 = new VField(policyriskdetailscontent.limits3, VField.TYPE_NUMERIC, VField.LONG_NAME, "Limits 3", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var excess3 = new VField(policyriskdetailscontent.excess3, VField.TYPE_NUMERIC, VField.LONG_NAME, "Excess 3", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var basisOfLimit = new VField(policyriskdetailscontent.basisOfLimit, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Basis of Limit", VField.CHECK_WIDTH_MAXIMUM, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
    var polCertPeriodFromdd = new VField(policyriskdetailscontent.polCertPeriodFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy Certificate Period From dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodFrommm = new VField(policyriskdetailscontent.polCertPeriodFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy Certificate Period From mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodFromyyyy = new VField(policyriskdetailscontent.polCertPeriodFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy Certificate Period From yyyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1800", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodTodd = new VField(policyriskdetailscontent.polCertPeriodTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy Certificate Period To dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodTomm = new VField(policyriskdetailscontent.polCertPeriodTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy Certificate Period To mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodToyyyy = new VField(policyriskdetailscontent.polCertPeriodToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy Certificate Period To yyyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1800", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var polCertQualifier = new VField(policyriskdetailscontent.polCertQualifier, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Pol/Cert Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var coverLineslipFromdd = new VField(policyriskdetailscontent.coverLineslipFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Cover Line Slip From dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var coverLineslipFrommm = new VField(policyriskdetailscontent.coverLineslipFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Cover Line Slip From mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var coverLineslipFromyyyy = new VField(policyriskdetailscontent.coverLineslipFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Cover Line Slip From yyyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1800", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var coverLineslipTodd = new VField(policyriskdetailscontent.coverLineslipTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Cover Line Slip To dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var coverLineslipTomm = new VField(policyriskdetailscontent.coverLineslipTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Cover Line Slip To mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var coverLineslipToyyyy = new VField(policyriskdetailscontent.coverLineslipToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Cover Line Slip To yyyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1800", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var coverLineslipQualifier = new VField(policyriskdetailscontent.coverLineslipQualifier, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Cover/Lineslip Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER); 
    var umrb = new VField(policyriskdetailscontent.umrumrb, VField.TYPE_REGEX_VALIDATION, VField.LONG_NAME, "UMR Source Code", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER, VField.REGEX, "[Bb]", VField.REGEX_ERROR_MSG, "The Source Code must contain B.");
    var umrbn = new VField(policyriskdetailscontent.umrumrbn, VField.TYPE_REGEX_VALIDATION, VField.LONG_NAME, "UMR Broker Number", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_NO_COMMAS, true, VField.REGEX, "^[0-9]{4}$", VField.REGEX_ERROR_MSG, "The Broker Number must contain four digits. If less than four digits please prefix with leading zeros.");
    var umranum = new VField(policyriskdetailscontent.umrumranum, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "UMR Reference", VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);
    var policyPeriodNarrative = new VField(policyriskdetailscontent.policyPeriodNarrative, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Policy/Risk Details", VField.CHECK_WIDTH_MAXIMUM, 40, VField.FORMAT_CASE, VField.CASE_UPPER);
	var slipType = new VField(policyriskdetailscontent.slipType, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Slip Type", VField.CHECK_MANDATORY, true);
	
  var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "POL Cert Period From Date");
  uoForm.add(vGroup1);
  vGroup1.add(polCertPeriodFromdd);
  vGroup1.add(polCertPeriodFrommm);
  vGroup1.add(polCertPeriodFromyyyy);
 
  var vGroup2 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy",VGroup.LONG_NAME, "POL Cert Period To Date");
  uoForm.add(vGroup2);
  vGroup2.add(polCertPeriodTodd);
  vGroup2.add(polCertPeriodTomm);
  vGroup2.add(polCertPeriodToyyyy);
  var vcomp1 = new Comparator(vGroup1, "<=", vGroup2, "POL Cert Period start and end dates", true);
  uoForm.add(vcomp1);

  var vGroup3 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Cover Lines Slip Period From Date");
  uoForm.add(vGroup3);
  vGroup3.add(coverLineslipFromdd);
  vGroup3.add(coverLineslipFrommm);
  vGroup3.add(coverLineslipFromyyyy);
  var vGroup4 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy",VGroup.LONG_NAME, "Cover Lines Slip Period To Date");
  uoForm.add(vGroup4);
  vGroup4.add(coverLineslipTodd);
  vGroup4.add(coverLineslipTomm);
  vGroup4.add(coverLineslipToyyyy);

  var vcomp2 = new Comparator(vGroup3, "<", vGroup4, "Cover Lines Slip start and end dates", true);
  uoForm.add(vcomp2);

  uoForm.add(peerReview);

  // CCN# N0030 - BA - 13/01/2003
  uoForm.add(marketCode) ;

  uoForm.add(currentBkr);
  uoForm.add(riskCode);
  uoForm.add(yoa);
  uoForm.add(interest);
  uoForm.add(perilsCondition);
  uoForm.add(locationVoyageOfRisk);
  uoForm.add(slipOrder1);
  uoForm.add(slipOrder2);
  uoForm.add(ccyOfLimits1);
  uoForm.add(limits1);
  uoForm.add(excess1);
  uoForm.add(ccyOfLimits2);
  uoForm.add(limits2);
  uoForm.add(excess2);
  uoForm.add(ccyOfLimits3);
  uoForm.add(limits3);
  uoForm.add(excess3);
  uoForm.add(basisOfLimit);
  uoForm.add(polCertQualifier);

  uoForm.add(policyPeriodNarrative);
  uoForm.add(coverLineslipQualifier);
  uoForm.add(umrb);
  uoForm.add(umrbn);
  uoForm.add(umranum);
  uoForm.add(slipType);

	var vbool = new BooleanEntered(BooleanEntered.AND,"UMR Field (Parts 1 to 3):",false,umrb,umrbn,umranum);
	uoForm.add(vbool);

  var uoCustom1 = new MyCustomValidator("Policy Risk Details");
  uoForm.add(uoCustom1);
  
  

  uoForm.initialise(false) ;
} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}

/*
$Log: policyriskdetailscontent.js,v $
Revision 1.11  2004/03/29 09:04:36  coganp
SIR 41158:
changed urm broker number error msg to be consisted 'fours'.

Revision 1.10  2004/03/29 08:51:41  coganp
SIR 41158:
changed urm broker number error msg.

Revision 1.9  2004/03/26 15:18:06  coganp
sir 41158:

Changed error text to revision two.

Revision 1.8  2004/03/26 15:10:06  coganp
sir 41158:

Changed error text to revision two.

Revision 1.7  2004/03/26 14:59:27  coganp
sir 41158:

Changed error text to revision two.

Revision 1.6  2004/03/25 18:06:44  coganp
changed error message to UMR brocker field.

Revision 1.5  2004/03/25 17:55:49  coganp
SIR41158 fix.Added GenericRegexValidator:
changed regex's for UMR to match for what we want and not what we don't want.

Revision 1.4  2004/03/25 14:54:34  coganp
SIR41158 fix.Added GenericRegexValidator:
This goes yellow if the b field is not a b

Revision 1.3  2004/03/23 16:54:02  coganp
fixed for SIR 41158
Changed validation message type and content for UMR fields.

Revision 1.2  2004/03/15 15:38:10  coganp
Fix for SIR 41158:
Changed the format of UMR field from one part to become three parts


*/