  // setdiarydatecontent validation
  try {
    var uoForm = new VForm(setdiarydatecontent) ;

    var diaryDatedd = new VField(setdiarydatecontent.diaryDatedd, VField.TYPE_NUMERIC, VField.CHECK_MANDATORY, true, VField.LONG_NAME, "Diary Date (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var diaryDatemm = new VField(setdiarydatecontent.diaryDatemm, VField.TYPE_NUMERIC, VField.CHECK_MANDATORY, true, VField.LONG_NAME, "Diary Date (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var diaryDateyyyy = new VField(setdiarydatecontent.diaryDateyyyy, VField.TYPE_NUMERIC, VField.CHECK_MANDATORY, true, VField.LONG_NAME, "Diary Date (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);

    var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.CHECK_MANDATORY, true, VGroup.LONG_NAME, "Diary Date");
    uoForm.add(vGroup1);
    vGroup1.add(diaryDatedd);
    vGroup1.add(diaryDatemm);
    vGroup1.add(diaryDateyyyy);
    var vcomp1 = new Comparator(vGroup1, ">", "today", "Diary date must be a future date", true);
    uoForm.add(vcomp1);

    uoForm.initialise(false) ;
  } catch(e) {
    e.description+= "\nsetdiarydatecontent form initialisation." ;
    alert(e.description)
  }