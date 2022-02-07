// claimtransactioncreationcontent validation
//
// Ins-sure Ltd
// Patrick Cogan.
//
// See end of file for change log
//
// ==========================================================================================
try {

  var claimtransactioncreationcontent = new VForm(form1) ;

  var osnd1sssss = new VField(form1.osnd1sssss, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 1 Signing Number",  VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
  var osnd1dd = new VField(form1.osnd1dd, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 1 Day",  VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
  var osnd1mm = new VField(form1.osnd1mm, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 1 Month", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
  var osnd1yy = new VField(form1.osnd1yy, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 1 Year",  VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_NO_COMMAS, true);
  var origCcy1 = new VField(form1.origCcy1, VField.TYPE_ALPHA, VField.LONG_NAME, "Original Currency 1", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 3, VField.CHECK_WIDTH_MAXIMUM, 3,VField.FORMAT_CASE, VField.CASE_UPPER);
  var apsnd1sssss = new VField(form1.apsnd1sssss, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 1 Signing Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
  var apsnd1dd = new VField(form1.apsnd1dd, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 1 Day", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
  var apsnd1mm = new VField(form1.apsnd1mm, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 1 Month", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
  var apsnd1yy = new VField(form1.apsnd1yy, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 2 Year", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "00", VField.CHECK_VALUE_MAXIMUM, "99", VField.CHECK_NO_COMMAS, true);
  var osnd2sssss = new VField(form1.osnd2sssss, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 2 Signing Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
  var osnd2dd = new VField(form1.osnd2dd, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 2 Day", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
  var osnd2mm = new VField(form1.osnd2mm, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 2 Month", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
  var osnd2yy = new VField(form1.osnd2yy, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 2 Year", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "00", VField.CHECK_VALUE_MAXIMUM, "99", VField.CHECK_NO_COMMAS, true);
  var origCcy2 = new VField(form1.origCcy2, VField.TYPE_ALPHA, VField.LONG_NAME, "Original Currency 2", VField.CHECK_WIDTH_OPTIONAL_EXACT, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
  var apsnd2sssss = new VField(form1.apsnd2sssss, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 2 Signing Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
  var apsnd2dd = new VField(form1.apsnd2dd, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 2 Day", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
  var apsnd2mm = new VField(form1.apsnd2mm, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 2 Month", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
  var apsnd2yy = new VField(form1.apsnd2yy, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 2 Year", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "00", VField.CHECK_VALUE_MAXIMUM, "99", VField.CHECK_NO_COMMAS, true);
  var osnd3sssss = new VField(form1.osnd3sssss, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 3 Signing Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
  var osnd3dd = new VField(form1.osnd3dd, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 3 Day", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
  var osnd3mm = new VField(form1.osnd3mm, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 3 Month", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
  var osnd3yy = new VField(form1.osnd3yy, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "OSND 3 Year", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "00", VField.CHECK_VALUE_MAXIMUM, "99", VField.CHECK_NO_COMMAS, true);
  var origCcy3 = new VField(form1.origCcy3, VField.TYPE_ALPHA, VField.LONG_NAME, "Original Currency 3", VField.CHECK_WIDTH_OPTIONAL_EXACT, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
  var apsnd3sssss = new VField(form1.apsnd3sssss, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 3 Signing Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
  var apsnd3dd = new VField(form1.apsnd3dd, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 3 Day", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
  var apsnd3mm = new VField(form1.apsnd3mm, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 3 Month", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
  var apsnd3yy = new VField(form1.apsnd3yy, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP SND 3 Year", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, " ", VField.CHECK_VALUE_MAXIMUM, " ", VField.CHECK_NO_COMMAS, true);

  // CCN# N0058 - BA - 09/01/2003
  var settAdv = new VField(form1.settAdv, VField.TYPE_ALPHA, VField.LONG_NAME, "Settlement / Advice") ;

  var presDatedd = new VField(form1.presDatedd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Presentation Date Day", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_NO_COMMAS, true);
  var presDatemm = new VField(form1.presDatemm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Presentation Date Month", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_NO_COMMAS, true);
  var presDateyyyy = new VField(form1.presDateyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Presentation Date Year", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_NO_COMMAS, true);

  var chargeType = new VField(form1.chargeType, VField.TYPE_ALPHA, VField.LONG_NAME, "Charge Type", VField.CHECK_MANDATORY, true) ;

  var ecfClass = new VField(form1.ecfClass, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "ECF Class", VField.CHECK_MANDATORY, true) ;

  var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "OSND 1 Date");
  claimtransactioncreationcontent.add(vGroup1);
  vGroup1.add(osnd1dd);
  vGroup1.add(osnd1mm);
  vGroup1.add(osnd1yy);

  var vGroup2 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "AP SND 1 Date");
  claimtransactioncreationcontent.add(vGroup2);
  vGroup2.add(apsnd1dd);
  vGroup2.add(apsnd1mm);
  vGroup2.add(apsnd1yy);

  var vGroup3 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "OSND 2  Date");
  claimtransactioncreationcontent.add(vGroup3);
  vGroup3.add(osnd2dd);
  vGroup3.add(osnd2mm);
  vGroup3.add(osnd2yy);

  var vGroup4 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "AP SND 2 Date");
  claimtransactioncreationcontent.add(vGroup4);
  vGroup4.add(apsnd2dd);
  vGroup4.add(apsnd2mm);
  vGroup4.add(apsnd2yy);

  var vGroup5 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "OSND 3 Date");
  claimtransactioncreationcontent.add(vGroup5);
  vGroup5.add(osnd3dd);
  vGroup5.add(osnd3mm);
  vGroup5.add(osnd3yy);

  var vGroup6 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "AP SND 3");
  claimtransactioncreationcontent.add(vGroup6);
  vGroup6.add(apsnd3dd);
  vGroup6.add(apsnd3mm);
  vGroup6.add(apsnd3yy);

  var vGroup7 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Presentation Date",VGroup.CHECK_MANDATORY,true);
  claimtransactioncreationcontent.add(vGroup7);
  vGroup7.add(presDatedd);
  vGroup7.add(presDatemm);
  vGroup7.add(presDateyyyy);

  claimtransactioncreationcontent.add(osnd1sssss);
  claimtransactioncreationcontent.add(origCcy1);
  claimtransactioncreationcontent.add(apsnd1sssss);
  claimtransactioncreationcontent.add(osnd2sssss);
  claimtransactioncreationcontent.add(origCcy2);
  claimtransactioncreationcontent.add(apsnd2sssss);
  claimtransactioncreationcontent.add(osnd3sssss);
  claimtransactioncreationcontent.add(origCcy3);
  claimtransactioncreationcontent.add(apsnd3sssss);

  // CCN# N0058 - BA - 09/01/2003
  claimtransactioncreationcontent.add(settAdv);

  claimtransactioncreationcontent.add(chargeType);
  claimtransactioncreationcontent.add(ecfClass);

  var uoCustom = new MyCustomValidator("Claim Transaction Creation ");
  claimtransactioncreationcontent.add(uoCustom);

  var vbool = new BooleanEntered(BooleanEntered.AND,"OSND1 Number and OSND1 Date ",false,osnd1sssss,vGroup1);
  claimtransactioncreationcontent.add(vbool);
  var vbool1 = new BooleanEntered(BooleanEntered.AND,"APSND1 Number and APSND1 Date ",false,apsnd1sssss,vGroup2);
  claimtransactioncreationcontent.add(vbool1);
  var vbool2 = new BooleanEntered(BooleanEntered.AND,"OSND2 Number and OSND2 Date ",false,osnd2sssss,vGroup3);
  claimtransactioncreationcontent.add(vbool2);
  var vbool3 = new BooleanEntered(BooleanEntered.AND,"APSND2 Number and APSND2 Date ",false,apsnd2sssss,vGroup4);
  claimtransactioncreationcontent.add(vbool3);
  var vbool4 = new BooleanEntered(BooleanEntered.AND,"OSND3 Number and OSND3 Date ",false,osnd3sssss,vGroup5);
  claimtransactioncreationcontent.add(vbool4);
  var vbool5 = new BooleanEntered(BooleanEntered.AND,"APSND3 Number and APSND3 Date ",false,apsnd3sssss,vGroup6);
  claimtransactioncreationcontent.add(vbool5);


  claimtransactioncreationcontent.initialise(false) ;
} catch(e) {
  e.description+= "\nClaim transaction creation content: form1 initialisation." ;
  alert(e.description)
}

/*

$Log: claimtransactioncreationcontent.js,v $
Revision 1.3  2004/03/16 16:34:41  coganp
Fix for SIR 41134.
Added cheching for - and + in all osnd and apnd date fields.

Revision 1.2  2004/03/09 09:51:04  coganp
Fix for SIR 41134
Added restrictednumericvalidator.js to page.


*/
