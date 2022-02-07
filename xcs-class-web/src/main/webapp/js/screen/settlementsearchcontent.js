  // settlementsearchcontent validation
  try {
    var uoForm = new VForm(settlementsearchcontent) ;

    var C115_YEAR_OF_ACC = new VField(settlementsearchcontent.C115_YEAR_OF_ACC, VField.TYPE_NUMERIC, VField.LONG_NAME, "Year of Account", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.CHECK_NO_COMMAS, true, VField.CHECK_VALUE_MINIMUM, "1993");
    var C115_PAYEE_BKR = new VField(settlementsearchcontent.C115_PAYEE_BKR, VField.TYPE_NUMERIC, VField.LONG_NAME, "Payee Broker", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.CHECK_NO_COMMAS, true);
    var C115_NAME_1 = new VField(settlementsearchcontent.C115_NAME_1, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Name 1", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER);
    var C115_NAME_2 = new VField(settlementsearchcontent.C115_NAME_2, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Name 2", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER);

    var C115_ORIG_SIGNING_DATEsssss = new VField(settlementsearchcontent.C115_ORIG_SIGNING_DATEsssss, VField.TYPE_NUMERIC, VField.LONG_NAME, "Original Signing Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
    var C115_ORIG_SIGNING_DATEdd = new VField(settlementsearchcontent.C115_ORIG_SIGNING_DATEdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Original Signing Date dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var C115_ORIG_SIGNING_DATEmm = new VField(settlementsearchcontent.C115_ORIG_SIGNING_DATEmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Original Signing Date mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var C115_ORIG_SIGNING_DATEyy = new VField(settlementsearchcontent.C115_ORIG_SIGNING_DATEyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Original Signing Date yy", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "99", VField.CHECK_NO_COMMAS, true);

    var C115_TAKE_DOWN_DATEsssss = new VField(settlementsearchcontent.C115_TAKE_DOWN_DATEsssss, VField.TYPE_NUMERIC, VField.LONG_NAME, "Take Down Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
    var C115_TAKE_DOWN_DATEdd = new VField(settlementsearchcontent.C115_TAKE_DOWN_DATEdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Take Down Date dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var C115_TAKE_DOWN_DATEmm = new VField(settlementsearchcontent.C115_TAKE_DOWN_DATEmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Take Down Date mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var C115_TAKE_DOWN_DATEccyy = new VField(settlementsearchcontent.C115_TAKE_DOWN_DATEccyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Take Down Date ccyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "9999", VField.CHECK_NO_COMMAS, true);

    var C115_COMP_BTW_FROMdd = new VField(settlementsearchcontent.C115_COMP_BTW_FROMdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Completed BTW From dd", VField.CHECK_WIDTH_OPTIONAL_EXACT, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var C115_COMP_BTW_FROMmm = new VField(settlementsearchcontent.C115_COMP_BTW_FROMmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Completed BTW From mm", VField.CHECK_WIDTH_OPTIONAL_EXACT, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var C115_COMP_BTW_FROMyyyy = new VField(settlementsearchcontent.C115_COMP_BTW_FROMyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Completed BTW From ccyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MAXIMUM, "9999", VField.CHECK_NO_COMMAS, true);

    var C115_COMP_BTW_TOdd = new VField(settlementsearchcontent.C115_COMP_BTW_TOdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Completed BTW To dd", VField.CHECK_WIDTH_OPTIONAL_EXACT, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var C115_COMP_BTW_TOmm = new VField(settlementsearchcontent.C115_COMP_BTW_TOmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Completed BTW To mm", VField.CHECK_WIDTH_OPTIONAL_EXACT, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var C115_COMP_BTW_TOyyyy = new VField(settlementsearchcontent.C115_COMP_BTW_TOyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Completed BTW To ccyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MAXIMUM, "9999", VField.CHECK_NO_COMMAS, true);

    var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmyy", VGroup.LONG_NAME, "Original Signing Date");
    uoForm.add(vGroup1);
    vGroup1.add(C115_ORIG_SIGNING_DATEdd);
    vGroup1.add(C115_ORIG_SIGNING_DATEmm);
    vGroup1.add(C115_ORIG_SIGNING_DATEyy);

    var vGroup2 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Take Down Date");
    uoForm.add(vGroup2);
    vGroup2.add(C115_TAKE_DOWN_DATEdd);
    vGroup2.add(C115_TAKE_DOWN_DATEmm);
    vGroup2.add(C115_TAKE_DOWN_DATEccyy);

    var vGroup3 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Completed BTW Date From");
    uoForm.add(vGroup3);
    vGroup3.add(C115_COMP_BTW_FROMdd);
    vGroup3.add(C115_COMP_BTW_FROMmm);
    vGroup3.add(C115_COMP_BTW_FROMyyyy);

    var vGroup4 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Completed BTW Date To");
    uoForm.add(vGroup4);
    vGroup4.add(C115_COMP_BTW_TOdd);
    vGroup4.add(C115_COMP_BTW_TOmm);
    vGroup4.add(C115_COMP_BTW_TOyyyy);

    var vcomp1 = new Comparator(vGroup3, "<=", vGroup4, "Completed BTW From and To dates", false);
    uoForm.add(vcomp1);


    uoForm.add(
          C115_YEAR_OF_ACC,C115_PAYEE_BKR,C115_ORIG_SIGNING_DATEsssss,C115_TAKE_DOWN_DATEsssss,C115_NAME_1,C115_NAME_2
    ) ;

    var uoCustom = new SettlementSearchContentCustom("Settlement Search Content") ;
    uoForm.add(uoCustom);


    uoForm.initialise(false) ;
  } catch(e) {
    e.description+= "\nform1 form initialisation." ;
    alert(e.description)
  }