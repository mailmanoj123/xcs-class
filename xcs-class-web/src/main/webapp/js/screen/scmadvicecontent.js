  // scmadvicecontent validation
  try {
    var uoForm = new VForm(scmadvicecontent) ;

    var ptdLoss = new VField(scmadvicecontent.ptdLoss, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid To Date Loss", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var ptdExp = new VField(scmadvicecontent.ptdExp, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid To Date Expenses", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var ptdFee = new VField(scmadvicecontent.ptdFee, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid To Date Fees", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var ptdTotal = new VField(scmadvicecontent.ptdTotal, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid To Date Total", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var highestEst = new VField(scmadvicecontent.highestEst, VField.TYPE_NUMERIC, VField.LONG_NAME, "Highest Est", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var settRateOfExc = new VField(scmadvicecontent.settRateOfExc, VField.TYPE_NUMERIC, VField.LONG_NAME, "Settlement Currency Rate of Exchange", VField.CHECK_NUMERIC_PLACES, 7, VField.CHECK_DECIMAL_PLACES, 5);
    var ptdInSettCcy = new VField(scmadvicecontent.ptdInSettCcy, VField.TYPE_NUMERIC, VField.LONG_NAME, "PTD in Settlement Currency", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);

    var clmRefRec = new VField(scmadvicecontent.clmRefRec, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Claim / Refund / Recovery Code", VField.CHECK_MANDATORY, false, VField.CHECK_WIDTH_MAXIMUM, 3, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var pttLoss = new VField(scmadvicecontent.pttLoss, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid This Time Loss", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
	var pttExp = new VField(scmadvicecontent.pttExp, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid This Time Expenses", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
	var pttFee = new VField(scmadvicecontent.pttFee, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid This Time Fees", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
	var pttTotal = new VField(scmadvicecontent.pttTotal, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid This Time Total", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var osRateOfExch = new VField(scmadvicecontent.osRateOfExch, VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Rate of Exchange", VField.CHECK_NUMERIC_PLACES, 7, VField.CHECK_DECIMAL_PLACES, 5);
    var osLoss = new VField(scmadvicecontent.osLoss, VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Loss", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var osLossqual = new VField(scmadvicecontent.osLossqual, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Outstanding Loss Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var osExp = new VField(scmadvicecontent.osExp, VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Expenses", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var osFee = new VField(scmadvicecontent.osFee, VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Fees", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var osFeeQual = new VField(scmadvicecontent.osFeeQual, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Outstanding Fees Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var osTotal = new VField(scmadvicecontent.osTotal, VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Total", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var osTotalQual = new VField(scmadvicecontent.osTotalQual, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Outstanding Total Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var incurred = new VField(scmadvicecontent.incurred, VField.TYPE_NUMERIC, VField.LONG_NAME, "Incurred Amount (or Current Estimate)", VField.CHECK_MANDATORY, true, VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var settledRateInSettCcy = new VField(scmadvicecontent.settledRateInSettCcy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Settled in Settlement Currency", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var bureauPpn = new VField(scmadvicecontent.bureauPpn, VField.TYPE_NUMERIC, VField.LONG_NAME, "Bureau Proportion", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    // TP866603 Changes for newly added barcode field
    var barcode= new VField(scmadvicecontent.barcode, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Barcode", VField.CHECK_WIDTH_MAXIMUM, 9, VField.FORMAT_CASE, VField.CASE_UPPER);

    /* VAT Amount Fixed
     * clintonj TP101172
     * 16/09/2004
     */    
    var vatAmount = new VField(scmadvicecontent.vatAmount, VField.TYPE_NUMERIC, VField.LONG_NAME, "VAT Amount", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2 ,VField.CHECK_SIGNED, true); 
    var warAmount = new VField(scmadvicecontent.warAmount, VField.TYPE_NUMERIC, VField.LONG_NAME, "War Amount", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var narrativeCode1 = new VField(scmadvicecontent.narrativeCode1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Narrative Code 1", VField.CHECK_WIDTH_MAXIMUM, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
    var narrativeCode2 = new VField(scmadvicecontent.narrativeCode2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Narrative Code 2", VField.CHECK_WIDTH_MAXIMUM, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
    var narrativeForSet = new VField(scmadvicecontent.narrativeForSet, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Current Narrative", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER);
    var narrativeForSet2 = new VField(scmadvicecontent.narrativeForSet2, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Current Narrative 2 (part 1)", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER);
    var narrativeForSet3 = new VField(scmadvicecontent.narrativeForSet3, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Current Narrative 2 (part 2)", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER);
    var finderCode1 = new VField(scmadvicecontent.finderCode1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Finder Code 1", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var finderCode2 = new VField(scmadvicecontent.finderCode2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Finder Code 2", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var finderCode3 = new VField(scmadvicecontent.finderCode3, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Finder Code 3", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var xcsRecovery = new VField(scmadvicecontent.xcsRecovery, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "XCS Recovery Reference", VField.CHECK_WIDTH_MAXIMUM, 14, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);

    var filCode1 = new VField(scmadvicecontent.filCode1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "FIL Code 1", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
    var filCode2 = new VField(scmadvicecontent.filCode2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "FIL Code 2", VField.CHECK_WIDTH_MAXIMUM, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
    var tfCode = new VField(scmadvicecontent.tfCode, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Trust Fund Code", VField.CHECK_WIDTH_MAXIMUM, 2, VField.FORMAT_CASE, VField.CASE_UPPER);
    var stateCode = new VField(scmadvicecontent.stateCode, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "State Code", VField.CHECK_WIDTH_MAXIMUM, 2, VField.FORMAT_CASE, VField.CASE_UPPER);

    var countyCode = new VField(scmadvicecontent.countyCode,VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "County Code", VField.CHECK_WIDTH_MAXIMUM, 6, VField.FORMAT_CASE, VField.CASE_UPPER);

    var naicCode = new VField(scmadvicecontent.naicCode, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "NAIC Code", VField.CHECK_WIDTH_MAXIMUM, 11, VField.FORMAT_CASE, VField.CASE_UPPER);
    var naicQual = new VField(scmadvicecontent.naicQual, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "NAIC Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var brokerContact = new VField(scmadvicecontent.brokerContact, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Contact", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 15, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var brokerPhoneNo = new VField(scmadvicecontent.brokerPhoneNo, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Phone Number", VField.CHECK_WIDTH_MAXIMUM, 20, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var claimBrokerRef = new VField(scmadvicecontent.claimBrokerRef, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Claim Reference 1 (Claim)", VField.CHECK_WIDTH_MAXIMUM, 16, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var claimBrokerRef2 = new VField(scmadvicecontent.claimBrokerRef2, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Claim Reference 2 (Claim)", VField.CHECK_WIDTH_MAXIMUM, 16, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var brokerClaimRef = new VField(scmadvicecontent.brokerClaimRef, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Claim Reference 1 (Settlement)", VField.CHECK_WIDTH_MAXIMUM, 16, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var brokerClaimRef2 = new VField(scmadvicecontent.brokerClaimRef2, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Broker Claim Reference 2 (Settlement)", VField.CHECK_WIDTH_MAXIMUM, 16, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);

    var origInsured = new VField(scmadvicecontent.origInsured, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Original Insured", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var insured = new VField(scmadvicecontent.insured, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Insured", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var reinsured = new VField(scmadvicecontent.reinsured, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Reinsured", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var ch = new VField(scmadvicecontent.ch, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Coverholder", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var claimant = new VField(scmadvicecontent.claimant, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Claimant", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var vesselAircraftConveyance = new VField(scmadvicecontent.vesselAircraftConveyance, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Name of Vessel / Aircraft / Conveyance", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var otherName = new VField(scmadvicecontent.otherName, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Other Name", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var countryOfOrigin = new VField(scmadvicecontent.countryOfOrigin, VField.TYPE_ALPHA, VField.LONG_NAME, "Country of Origin", VField.CHECK_MANDATORY, true) ;
    var polCertPeriodFromdd = new VField(scmadvicecontent.polCertPeriodFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy / Certificate Period From (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodFrommm = new VField(scmadvicecontent.polCertPeriodFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy / Certificate Period From (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodFromyyyy = new VField(scmadvicecontent.polCertPeriodFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy / Certificate Period From (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodTodd = new VField(scmadvicecontent.polCertPeriodTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy / Certificate Period To (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodTomm = new VField(scmadvicecontent.polCertPeriodTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy / Certificate Period To (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var polCertPeriodToyyyy = new VField(scmadvicecontent.polCertPeriodToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Policy / Certificate Period To (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var polCertQualifier = new VField(scmadvicecontent.polCertQualifier, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Policy / Certificate Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var dolFromdd = new VField(scmadvicecontent.dolFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss From (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var dolFrommm = new VField(scmadvicecontent.dolFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss From (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var dolFromyyyy = new VField(scmadvicecontent.dolFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss From (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var dolTodd = new VField(scmadvicecontent.dolTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss To (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var dolTomm = new VField(scmadvicecontent.dolTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss To (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var dolToyyyy = new VField(scmadvicecontent.dolToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date of Loss To (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var dolQual = new VField(scmadvicecontent.dolQual, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Date of Loss Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var dolNarr = new VField(scmadvicecontent.dolNarr, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Loss Date Narrative", VField.CHECK_WIDTH_MAXIMUM, 30, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var dcmDodFromdd = new VField(scmadvicecontent.dcmDodFromdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made From (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var dcmDodFrommm = new VField(scmadvicecontent.dcmDodFrommm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made From (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var dcmDodFromyyyy = new VField(scmadvicecontent.dcmDodFromyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made From (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var dcmDodTodd = new VField(scmadvicecontent.dcmDodTodd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made To (Day Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var dcmDodTomm = new VField(scmadvicecontent.dcmDodTomm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made To (Month Part)", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var dcmDodToyyyy = new VField(scmadvicecontent.dcmDodToyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Date Claim Made To (Year Part)", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var dcmDodQual = new VField(scmadvicecontent.dcmDodQual, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Date Claim Made Qualifier", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var ccyOfLimits = new VField(scmadvicecontent.ccyOfLimits, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Currency Applied to Policy Limits", VField.CHECK_WIDTH_OPTIONAL_EXACT, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
    var limits = new VField(scmadvicecontent.limits, VField.TYPE_NUMERIC, VField.LONG_NAME, "Sum Insured Limit", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var excess = new VField(scmadvicecontent.excess, VField.TYPE_NUMERIC, VField.LONG_NAME, "Excess Limit", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var perilsCondition = new VField(scmadvicecontent.perilsCondition, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Perils / Conditions", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var lossLocation = new VField(scmadvicecontent.lossLocation, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Loss Location", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var voyage = new VField(scmadvicecontent.voyage, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Voyage", VField.CHECK_WIDTH_MAXIMUM, 30, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var lossName = new VField(scmadvicecontent.lossName, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Name of Loss", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var claimNarrative = new VField(scmadvicecontent.claimNarr, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Claim Narrative", VField.CHECK_MANDATORY, true, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    //var lawyerName = new VField(scmadvicecontent.lawyerName, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Lawyer Name", VField.CHECK_WIDTH_MAXIMUM, 40, VField.FORMAT_CASE, VField.CASE_UPPER);
	// Expert Fee BD Change, disable adjuster and lawyer details validations
    //var adjusterName = new VField(scmadvicecontent.adjusterName, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Adjuster Name", VField.CHECK_WIDTH_MAXIMUM, 40, VField.FORMAT_CASE, VField.CASE_UPPER);
    // CCN #554 -  Only allow 15 characters for adjuster and lawyer ref
    //var lawyerRef = new VField(scmadvicecontent.lawyerRef, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Lawyer Reference", VField.CHECK_WIDTH_MAXIMUM, 15, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    //var adjusterRef = new VField(scmadvicecontent.adjusterRef, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Adjuster Reference", VField.CHECK_WIDTH_MAXIMUM, 15, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS);
    var otherTfCode = new VField(scmadvicecontent.otherTfCode, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Other Trust Fund Code", VField.CHECK_WIDTH_MAXIMUM, 2, VField.FORMAT_CASE, VField.CASE_UPPER);
    var dti = new VField(scmadvicecontent.dti, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "DTI Code", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MAXIMUM, 2, VField.FORMAT_CASE, VField.CASE_UPPER);
    var schemeCode = new VField(scmadvicecontent.schemeCode, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Scheme Code", VField.CHECK_WIDTH_MAXIMUM, 2, VField.FORMAT_CASE, VField.CASE_UPPER);

    var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "POL Cert Period From Date");
    uoForm.add(vGroup1);
    vGroup1.add(polCertPeriodFromdd);
    vGroup1.add(polCertPeriodFrommm);
    vGroup1.add(polCertPeriodFromyyyy);
    vGroup1.uoDataValidator.addMask("mmccyy") ;
    vGroup1.uoDataValidator.addMask("ccyy") ;

    var vGroup2 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy",VGroup.LONG_NAME, "POL Cert Period To Date");
    uoForm.add(vGroup2);
    vGroup2.add(polCertPeriodTodd);
    vGroup2.add(polCertPeriodTomm);
    vGroup2.add(polCertPeriodToyyyy);
    vGroup2.uoDataValidator.addMask("mmccyy") ;
    vGroup2.uoDataValidator.addMask("ccyy") ;
    var vcomp1 = new Comparator(vGroup1, "<=", vGroup2, "POL Cert Period start and end dates", true);
    uoForm.add(vcomp1);

    var vGroup3 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Date of Loss From Date");
    uoForm.add(vGroup3);
    vGroup3.add(dolFromdd);
    vGroup3.add(dolFrommm);
    vGroup3.add(dolFromyyyy);
    vGroup3.uoDataValidator.addMask("mmccyy") ;
    vGroup3.uoDataValidator.addMask("ccyy") ;

    var vGroup4 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy",VGroup.LONG_NAME, "Date of Loss To Date");
    uoForm.add(vGroup4);
    vGroup4.add(dolTodd);
    vGroup4.add(dolTomm);
    vGroup4.add(dolToyyyy);
    vGroup4.uoDataValidator.addMask("mmccyy") ;
    vGroup4.uoDataValidator.addMask("ccyy") ;
    var vcomp2 = new Comparator(vGroup3, "<", vGroup4, "DOL start and end dates", false);
    uoForm.add(vcomp2);

    var vGroup5 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Date Claim Made From Date");
    uoForm.add(vGroup5);
    vGroup5.add(dcmDodFromdd);
    vGroup5.add(dcmDodFrommm);
    vGroup5.add(dcmDodFromyyyy);
    vGroup5.uoDataValidator.addMask("mmccyy") ;
    vGroup5.uoDataValidator.addMask("ccyy") ;

    var vGroup6 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy",VGroup.LONG_NAME, "Date Claim Made To Date");
    uoForm.add(vGroup6);
    vGroup6.add(dcmDodTodd);
    vGroup6.add(dcmDodTomm);
    vGroup6.add(dcmDodToyyyy);
    vGroup6.uoDataValidator.addMask("mmccyy") ;
    vGroup6.uoDataValidator.addMask("ccyy") ;

    var vcomp3 = new Comparator(vGroup5, "<", vGroup6, "DCM/DOD start and end dates", false);
    uoForm.add(vcomp3);
    //TP866603 Changes for newly added barcode field 
    uoForm.add(
      ptdLoss, ptdExp, ptdFee, ptdTotal, highestEst, settRateOfExc, ptdInSettCcy,
      clmRefRec, osRateOfExch, pttLoss, osLoss, osLossqual, pttExp, osExp, pttFee, osFee,
      osFeeQual, pttTotal, osTotal, osTotalQual, incurred, settledRateInSettCcy, bureauPpn,
      vatAmount, warAmount, narrativeCode1, narrativeCode2, narrativeForSet, narrativeForSet2,
      narrativeForSet3, finderCode1, finderCode2, finderCode3, xcsRecovery
    ) ;
    
    uoForm.add(
      filCode1, filCode2, tfCode, stateCode,countyCode, naicCode, naicQual, brokerContact, brokerPhoneNo,
      brokerClaimRef, brokerClaimRef2, origInsured, insured, reinsured, ch, claimant,
      vesselAircraftConveyance, otherName, countryOfOrigin,barcode
    ) ;
    uoForm.add(
      polCertQualifier, dolQual, dolNarr, dcmDodQual, ccyOfLimits, limits, excess,
      perilsCondition, lossLocation, voyage,lossName
    ) ;
    //Expert Fee BD Change removed adjuster and lawyer objects
    uoForm.add(
      claimNarrative,otherTfCode, dti, schemeCode
    ) ;

    var uoCustom = new SCMAdviceContentCustom("SCM Advice Content") ;
    uoForm.add(uoCustom);

    uoForm.initialise(false) ;
  } catch(e) {
    e.description+= "\nform1 form initialisation." ;
    alert(e.description)
  }
