try {
var uoForm = new VForm(findclaimcontent) ;

// Basic Search
var vtab1 = new VTab(document.all.tab1);
uoForm.add(vtab1);

var ucrpt1 = new VField(findclaimcontent.ucrXcrpt1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "UCR/XCR (part 1)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
var ucrpt2 = new VField(findclaimcontent.ucrXcrpt2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "UCR/XCR (part 2)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
var ucrpt3 = new VField(findclaimcontent.ucrXcrpt3, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "UCR/XCR (part 3)", VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);

var trpt1 = new VField(findclaimcontent.trpt1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Transaction Reference (part 1)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
var trpt2 = new VField(findclaimcontent.trpt2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Transaction Reference (part 2)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
var trpt3 = new VField(findclaimcontent.trpt3, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Transaction Reference (part 3)", VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);

var bkrUcrpt1 = new VField(findclaimcontent.bkrUcrpt1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker UCR (part 1)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
var bkrUcrpt2 = new VField(findclaimcontent.bkrUcrpt2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker UCR (part 2)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
var bkrUcrpt3 = new VField(findclaimcontent.bkrUcrpt3, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker UCR (part 3)", VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);

var corpt1 = new VField(findclaimcontent.corpt1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Claims Office Reference", VField.CHECK_WIDTH_MAXIMUM, 15, VField.FORMAT_CASE, VField.CASE_UPPER);

var osndsssss = new VField(findclaimcontent.osndsssss, VField.TYPE_NUMERIC, VField.LONG_NAME, "Original Signing Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
var osnddd = new VField(findclaimcontent.osnddd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Original Signing Date dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var osndmm = new VField(findclaimcontent.osndmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Original Signing Date mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var osndyy = new VField(findclaimcontent.osndyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Original Signing Date yy", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "99", VField.CHECK_NO_COMMAS, true);
var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "OSND Date");
vtab1.add(vGroup1);
vGroup1.add(osnddd);
vGroup1.add(osndmm);
vGroup1.add(osndyy);

var tdnsssss = new VField(findclaimcontent.tdnsssss, VField.TYPE_NUMERIC, VField.LONG_NAME, "TDN Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
var tdndd = new VField(findclaimcontent.tdndd, VField.TYPE_NUMERIC, VField.LONG_NAME, "TDN Date dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var tdnmm = new VField(findclaimcontent.tdnmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "TDN Date mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var tdnccyy = new VField(findclaimcontent.tdnccyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "TDN Date ccyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
var vGroup2 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "TDN Date");
vtab1.add(vGroup2);
vGroup2.add(tdndd);
vGroup2.add(tdnmm);
vGroup2.add(tdnccyy);

var groupRefpt1 = new VField(findclaimcontent.groupRefpt1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Group Ref (part 1)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
var groupRefpt2 = new VField(findclaimcontent.groupRefpt2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Group Ref (part 2)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 6, VField.FORMAT_CASE, VField.CASE_UPPER);

var certNo = new VField(findclaimcontent.certNo, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Certificate of Insurance Number", VField.CHECK_WIDTH_MAXIMUM, 20 , VField.FORMAT_CASE, VField.CASE_UPPER);

var vbool1 = new BooleanEntered(BooleanEntered.AND,"UCR or XCR  (parts 1-3)",false,ucrpt1,ucrpt2,ucrpt3);
vtab1.add(vbool1);

var vbool2 = new BooleanEntered(BooleanEntered.AND,"Transaction Reference (parts 1-3)",false,trpt1,trpt2,trpt3);
vtab1.add(vbool2);

var vbool3 = new BooleanEntered(BooleanEntered.AND,"Broker UCR (parts 1-3)",false,bkrUcrpt1,bkrUcrpt2,bkrUcrpt3);
vtab1.add(vbool3);

var vbool4 = new BooleanEntered(BooleanEntered.AND,"OSND Number and Date",false,osndsssss,osnddd,osndmm,osndyy);
vtab1.add(vbool4);

// var vbool5 = new BooleanEntered(BooleanEntered.AND,"Taking Down Number and Date",false,tdnpt1,vGroup1);
// vtab1.add(vbool5);

var vbool6 = new BooleanEntered(BooleanEntered.AND,"Group Reference",false,groupRefpt1,groupRefpt2);
vtab1.add(vbool6);

vtab1.add(ucrpt1);
vtab1.add(ucrpt2);
vtab1.add(ucrpt3);

vtab1.add(trpt1);
vtab1.add(trpt2);
vtab1.add(trpt3);

vtab1.add(bkrUcrpt1);
vtab1.add(bkrUcrpt2);
vtab1.add(bkrUcrpt3);

vtab1.add(corpt1);

vtab1.add(osndsssss);
// vtab1.add(osnddd);
// vtab1.add(osndmm);
// vtab1.add(osndyy);

vtab1.add(tdnsssss);

vtab1.add(groupRefpt1);
vtab1.add(groupRefpt2);

vtab1.add(certNo);

// Advanced Search - Tab 2
var vtab2 = new VTab(document.all.tab2);
uoForm.add(vtab2);

// name1
var name1 = new VField(findclaimcontent.name1, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Name 1", VField.FORMAT_CASE, VField.CASE_UPPER, VField.CHECK_WIDTH_MAXIMUM, 50) ;

// name2
var name2 = new VField(findclaimcontent.name2, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Name 2", VField.FORMAT_CASE, VField.CASE_UPPER, VField.CHECK_WIDTH_MAXIMUM, 50) ;

// dateOfLossFrom
var dateOfLossFromdd = new VField(findclaimcontent.dateOfLossFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss From (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var dateOfLossFrommm = new VField(findclaimcontent.dateOfLossFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss From (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var dateOfLossFromyyyy = new VField(findclaimcontent.dateOfLossFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss From (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
var vGroup3 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Date of Loss From");
vtab2.add(vGroup3);
vGroup3.add(dateOfLossFromdd);
vGroup3.add(dateOfLossFrommm);
vGroup3.add(dateOfLossFromyyyy);

// dateOfLossTo
var dateOfLossTodd = new VField(findclaimcontent.dateOfLossTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss To (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var dateOfLossTomm = new VField(findclaimcontent.dateOfLossTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss To (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var dateOfLossToyyyy = new VField(findclaimcontent.dateOfLossToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss To (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
var vGroup4 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Date of Loss To");
vtab2.add(vGroup4);
vGroup4.add(dateOfLossTodd);
vGroup4.add(dateOfLossTomm);
vGroup4.add(dateOfLossToyyyy);

var vcomp1 = new Comparator(vGroup3, "<=", vGroup4, "DOL start and end dates", false);
vtab2.add(vcomp1);

// catCode
var catCode = new VField(findclaimcontent.catCode, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "CAT Code") ;

// user
var user = new VField(findclaimcontent.user, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "User Id", VField.FORMAT_CASE, VField.CASE_UPPER, VField.CHECK_WIDTH_MINIMUM, 5, VField.CHECK_WIDTH_MAXIMUM, 8) ;
var claimant = new VField(findclaimcontent.claimant, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Claimant", VField.FORMAT_CASE, VField.CASE_UPPER,VField.CHECK_WIDTH_MAXIMUM, 50); 
var bkrRef = new VField(findclaimcontent.bkrRef, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Reference", VField.FORMAT_CASE, VField.CASE_UPPER,VField.CHECK_WIDTH_MAXIMUM, 12); 
// dateProcessedFrom
var dateProcessedFromdd = new VField(findclaimcontent.dateProcessedFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Processed From (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var dateProcessedFrommm = new VField(findclaimcontent.dateProcessedFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Processed From (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var dateProcessedFromyyyy = new VField(findclaimcontent.dateProcessedFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Processed From (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
var vGroup5 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Date Processed From");
vtab2.add(vGroup5);
vGroup5.add(dateProcessedFromdd);
vGroup5.add(dateProcessedFrommm);
vGroup5.add(dateProcessedFromyyyy);

// dateProcessedTo
var dateProcessedTodd = new VField(findclaimcontent.dateProcessedTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Processed To (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var dateProcessedTomm = new VField(findclaimcontent.dateProcessedTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Processed To (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var dateProcessedToyyyy = new VField(findclaimcontent.dateProcessedToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Processed To (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
var vGroup6 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Date Processed To");
vtab2.add(vGroup6);
vGroup6.add(dateProcessedTodd);
vGroup6.add(dateProcessedTomm);
vGroup6.add(dateProcessedToyyyy);

var vcomp1 = new Comparator(vGroup5, "<=", vGroup6, "Processed start and end dates", false);
vtab2.add(vcomp1);

vtab2.add(name1) ;
vtab2.add(name2) ;
vtab2.add(catCode) ;
vtab2.add(user) ;
vtab2.add(claimant) ;
vtab2.add(bkrRef) ;


// Custom Validation
var uoCustom1 = new CustomFindClaimContent("Find Claim Content");
uoForm.add(uoCustom1);

uoForm.initialise(false) ;

} catch(e) {
  e.description+= "\nSearch form initialisation." ;
  alert(e.description)
}