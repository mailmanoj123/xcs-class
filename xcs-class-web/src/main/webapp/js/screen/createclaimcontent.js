// createclaimcontent validation
//
// Ins-sure Ltd
// Patrick Cogan.
//
// See end of file for change log
//
// ==========================================================================================
try {
var uoForm = new VForm(createclaimcontent) ;

var osndsssss = new VField(createclaimcontent.osndsssss, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "Original Signing Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
var osnddd = new VField(createclaimcontent.osnddd, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "Original Signing Date dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var osndmm = new VField(createclaimcontent.osndmm, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "Original Signing Date mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var osndyy = new VField(createclaimcontent.osndyy, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "Original Signing Date yy", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "99", VField.CHECK_NO_COMMAS, true);
var apsndsssss = new VField(createclaimcontent.apsndsssss, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP Signing Number",  VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
var apsnddd = new VField(createclaimcontent.apsnddd, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP Signing Date dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var apsndmm = new VField(createclaimcontent.apsndmm, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP Signing Date mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var apsndyy = new VField(createclaimcontent.apsndyy, VField.TYPE_RESTRICTED_NUMERIC, VField.LONG_NAME, "AP Signing Date yy", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "99", VField.CHECK_NO_COMMAS, true);

var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "Original Signing Date");
uoForm.add(vGroup1);
vGroup1.add(osnddd);
vGroup1.add(osndmm);
vGroup1.add(osndyy);

var vGroup2 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy",VGroup.LONG_NAME, "AP Signing Date");
uoForm.add(vGroup2);
vGroup2.add(apsnddd);
vGroup2.add(apsndmm);
vGroup2.add(apsndyy);

uoForm.add(osndsssss);
uoForm.add(apsndsssss);

var vbool = new BooleanEntered(BooleanEntered.AND,"OSND Number and OSND Date ",false,osndsssss,vGroup1);
uoForm.add(vbool);

var vbool = new BooleanEntered(BooleanEntered.AND,"APSND Number and APSND Date ",false,apsndsssss,vGroup2);
uoForm.add(vbool);

var uoCustom1 = new CustomCreateClaimContent("Create Claim Content");
uoForm.add(uoCustom1);

uoForm.initialise(false) ;

} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}

/*

$Log: createclaimcontent.js,v $
Revision 1.3  2004/03/16 16:34:41  coganp
Fix for SIR 41134.
Added cheching for - and + in all osnd and apnd date fields.

Revision 1.2  2004/03/09 09:51:05  coganp
Fix for SIR 41134
Added restrictednumericvalidator.js to page.


*/
