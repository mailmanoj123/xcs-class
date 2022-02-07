  try {
   // bDebuggingOn = true;

    var ClaimDetails = new VForm(claimdetailscontent) ;

    var vtab1 = new VTab(document.all.tab1);
    var vtab2 = new VTab(document.all.tab2);

    ClaimDetails.add(vtab1);
    ClaimDetails.add(vtab2);

    var bkrContact = new VField(claimdetailscontent.bkrContact, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Contact", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 15, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var bkrPhoneNo = new VField(claimdetailscontent.bkrPhoneNo, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Phone Number", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 15, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var bkrClaimRef1 = new VField(claimdetailscontent.bkrClaimRef1, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Claim Reference 1", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);
    var bkrClaimRef2 = new VField(claimdetailscontent.bkrClaimRef2, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Claim Reference 2", VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);
    var bkrUcrpt1 = new VField(claimdetailscontent.bkrUcrpt1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker UCR (part 1)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var bkrUcrpt2 = new VField(claimdetailscontent.bkrUcrpt2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker UCR (part 2)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
    var bkrUcrpt3 = new VField(claimdetailscontent.bkrUcrpt3, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker UCR (part 3)", VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);
    var origInsured = new VField(claimdetailscontent.origInsured, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Original Insured", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var insured = new VField(claimdetailscontent.insured, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Insured", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var reinsured = new VField(claimdetailscontent.reinsured, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Re-Insured", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var coverholder = new VField(claimdetailscontent.coverholder, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Cover Holder", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var claimant = new VField(claimdetailscontent.claimant, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Claimant", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var vesselAircraft = new VField(claimdetailscontent.vesselAircraft, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Vessel Aircraft", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var lossName = new VField(claimdetailscontent.lossName, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Loss Name", VField.CHECK_MANDATORY, false, VField.CHECK_WIDTH_MAXIMUM, 20, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var otherName = new VField(claimdetailscontent.otherName, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Other Name", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var chClmRef = new VField(claimdetailscontent.chClmRef, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Cover Holder Clm Ref", VField.CHECK_WIDTH_OPTIONAL_EXACT, 8, VField.FORMAT_CASE, VField.CASE_UPPER);

    // 25/02/2003 - BA - Bug Fix 327 - Remove range check from DCM DOL fields
    var dolFromdd = new VField(claimdetailscontent.dolFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Of Loss From (day part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var dolFrommm = new VField(claimdetailscontent.dolFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Of Loss From (month part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var dolFromyyyy = new VField(claimdetailscontent.dolFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Of Loss From (year part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_NO_COMMAS, true);
    var dolTodd = new VField(claimdetailscontent.dolTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Of Loss To (day part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var dolTomm = new VField(claimdetailscontent.dolTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Of Loss To (month part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var dolToyyyy = new VField(claimdetailscontent.dolToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Of Loss To (year part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_NO_COMMAS, true);
    var dolQual = new VField(claimdetailscontent.dolQual, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Date Of Loss Qualifier", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var dcmFromdd = new VField(claimdetailscontent.dcmFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made From (day part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var dcmFrommm = new VField(claimdetailscontent.dcmFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made From (month part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var dcmFromyyyy = new VField(claimdetailscontent.dcmFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made From (year part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_NO_COMMAS, true);
    var dcmTodd = new VField(claimdetailscontent.dcmTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made To (day part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var dcmTomm = new VField(claimdetailscontent.dcmTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made To (month part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var dcmToyyyy = new VField(claimdetailscontent.dcmToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made To (year part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_NO_COMMAS, true);

    var dcmQual = new VField(claimdetailscontent.dcmQual, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Date Claim Made Qualifier", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var dolNarrative = new VField(claimdetailscontent.dolNarrative, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Date Of Loss Narrative", VField.CHECK_WIDTH_MAXIMUM, 30, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var lossLocation = new VField(claimdetailscontent.lossLocation, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Loss Location", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var voyage = new VField(claimdetailscontent.voyage, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Voyage", VField.CHECK_WIDTH_MAXIMUM, 30, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var catCode = new VField(claimdetailscontent.catCode, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "CAT Code", VField.CHECK_WIDTH_MAXIMUM, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
    var pcsCat = new VField(claimdetailscontent.pcsCat, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "PCS CAT", VField.CHECK_WIDTH_MAXIMUM, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
    var claimRiskType = new VField(claimdetailscontent.claimRiskType, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Claim Risk Type", VField.CHECK_WIDTH_OPTIONAL_EXACT, 3, VField.FORMAT_CASE, VField.CASE_UPPER);

    // 14/01/2003 - BA - Bug Fix - Make claim narrative mandatory
    var claimNarrative = new VField(claimdetailscontent.claimNarr, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Claim Narrative (Loss Details)", VField.CHECK_MANDATORY, true, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);

    var adjSurvRef = new VField(claimdetailscontent.adjSurvRef, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Adjusted Surv Reference", VField.CHECK_WIDTH_MAXIMUM, 15, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var lawyerRef = new VField(claimdetailscontent.lawyerRef, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Lawyer Reference", VField.CHECK_WIDTH_MAXIMUM, 15, VField.FORMAT_CASE, VField.CASE_UPPER);

    //TP868446 Changes for Quality Validation to make Cause Code mandatory 
    var causeCode = new VField(claimdetailscontent.causeCode, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Cause Code",VField.CHECK_WIDTH_MAXIMUM, 4, VField.FORMAT_CASE, VField.CASE_UPPER);

    var certInsNo1 = new VField(claimdetailscontent.certInsNo1, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Certificate of Insurance No. 1", VField.CHECK_WIDTH_MAXIMUM, 20, VField.FORMAT_CASE, VField.CASE_UPPER);
    var certInsNo2 = new VField(claimdetailscontent.certInsNo2, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Certificate of Insurance No. 2", VField.CHECK_WIDTH_MAXIMUM, 20, VField.FORMAT_CASE, VField.CASE_UPPER);
    var certInsNo3 = new VField(claimdetailscontent.certInsNo3, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Certificate of Insurance No. 3", VField.CHECK_WIDTH_MAXIMUM, 20, VField.FORMAT_CASE, VField.CASE_UPPER);
    var certInsNo4 = new VField(claimdetailscontent.certInsNo4, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Certificate of Insurance No. 4", VField.CHECK_WIDTH_MAXIMUM, 20, VField.FORMAT_CASE, VField.CASE_UPPER);
    var certInsNo5 = new VField(claimdetailscontent.certInsNo5, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Certificate of Insurance No. 5", VField.CHECK_WIDTH_MAXIMUM, 20, VField.FORMAT_CASE, VField.CASE_UPPER);



    var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "DOL From Date");
    // CCN #533
    vGroup1.uoDataValidator.addMask("mmccyy") ;
    vGroup1.uoDataValidator.addMask("ccyy") ;
    // ClaimDetails.add(vGroup1);
    vtab1.add(vGroup1);
    vGroup1.add(dolFromdd, dolFrommm, dolFromyyyy);

    var vGroup2 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy",VGroup.LONG_NAME, "DOL To Date");
    ClaimDetails.add(vGroup2);
    vGroup2.add(dolTodd, dolTomm, dolToyyyy);

    var vcomp1 = new Comparator(vGroup1, "<", vGroup2, "DOL start and end dates", false);
    ClaimDetails.add(vcomp1);

    var vGroup3 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "DCM From Date");
    // CCN #533
    vGroup3.uoDataValidator.addMask("mmccyy") ;
    vGroup3.uoDataValidator.addMask("ccyy") ;
    vtab1.add(vGroup3);
    vGroup3.add(dcmFromdd, dcmFrommm, dcmFromyyyy);

    var vGroup4 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy",VGroup.LONG_NAME, "DCM To Date");
    ClaimDetails.add(vGroup4);
    vGroup4.add(dcmTodd, dcmTomm, dcmToyyyy);

    var vcomp2 = new Comparator(vGroup3, "<", vGroup4, "DCM start and end dates", false);
    ClaimDetails.add(vcomp2);

    var vifthen = new IfThen(dolQual,"S","Date of Loss Qualifier/Narrative",dolNarrative);
    ClaimDetails.add(vifthen);

    var vbool1 = new BooleanEntered(BooleanEntered.AND,"Broker UCR",false,bkrUcrpt1,bkrUcrpt2,bkrUcrpt3);
    ClaimDetails.add(vbool1);

    vtab1.add(
      bkrContact, bkrPhoneNo, bkrClaimRef1, bkrClaimRef2, bkrUcrpt1, bkrUcrpt2, bkrUcrpt3,
      origInsured, insured, reinsured, coverholder, claimant, vesselAircraft, lossName, otherName,
      dolQual,  dcmQual
    );
    vtab2.add(
      dolNarrative, lossLocation, voyage, catCode, pcsCat, claimRiskType, claimNarrative,
      adjSurvRef, lawyerRef, causeCode , chClmRef, 
      certInsNo1, certInsNo2, certInsNo3 , certInsNo4, certInsNo5
    );

    var vCustom1 = new MyCustomValidator("Claim Details Page");
    ClaimDetails.add(vCustom1);

    ClaimDetails.initialise(false) ;
  } catch(e) {
    e.description+= "\nLogin form initialisation." ;
    alert(e.description)
  }