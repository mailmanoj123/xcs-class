try {
    var uoForm = new VForm(financialdetailscontrolcontent) ;



    var redenomInd = new VField(financialdetailscontrolcontent.redenomInd, VField.TYPE_ALPHA, VField.LONG_NAME, "Redenomination Indicator", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER) ;
    var payeeBroker = new VField(financialdetailscontrolcontent.payeeBroker, VField.TYPE_NUMERIC, VField.LONG_NAME, "Payee Broker", VField.CHECK_WIDTH_MINIMUM, 4, VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_NO_COMMAS, true);
    var payeeBrokerPseud = new VField(financialdetailscontrolcontent.payeeBrokerPseud, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Payee Broker Pseudonym", VField.CHECK_WIDTH_MINIMUM, 1, VField.CHECK_WIDTH_MAXIMUM, 3, VField.FORMAT_CASE, VField.CASE_UPPER);

    var peerReview = new VField(financialdetailscontrolcontent.peerReview, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Peer Review", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 1, VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    
    var origCcy = new VField(financialdetailscontrolcontent.origCcy, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Original Currency", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 3, VField.CHECK_WIDTH_MAXIMUM, 3);
    var pttTotal = new VField(financialdetailscontrolcontent.pttTotal, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid This Time Total", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2,VField.CHECK_SIGNED, true);
    var osTotal = new VField(financialdetailscontrolcontent.osTotal, VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Amount", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
    var settCcy = new VField(financialdetailscontrolcontent.settCcy, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Settlement Currency", VField.CHECK_WIDTH_OPTIONAL_EXACT, 3, VField.FORMAT_CASE, VField.CASE_UPPER);
    var settRateOfExch = new VField(financialdetailscontrolcontent.settRateOfExch, VField.TYPE_NUMERIC, VField.LONG_NAME, "Settlement Currency Rate of Exchange", VField.CHECK_NUMERIC_PLACES, 7, VField.CHECK_DECIMAL_PLACES, 5);
    var bureauPpnAmt = new VField(financialdetailscontrolcontent.bureauPpnAmt, VField.TYPE_NUMERIC, VField.LONG_NAME, "Bureau Proportion Amount", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    
    /*
     * Changed vatAmt to allow negatives
     * clintonj TP 114444
     * 26/10/2004
     */
    var vatAmt = new VField(financialdetailscontrolcontent.vatAmt, VField.TYPE_NUMERIC, VField.LONG_NAME, "Vat Amount", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true); 
    var warAmount = new VField(financialdetailscontrolcontent.warAmount, VField.TYPE_NUMERIC, VField.LONG_NAME, "War Amount", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var incurred = new VField(financialdetailscontrolcontent.incurred, VField.TYPE_NUMERIC, VField.LONG_NAME, "Incurred", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    /* Removed prevSettled for CCN#41
    var prevSettled = new VField(financialdetailscontrolcontent.prevSettled, VField.TYPE_NUMERIC, VField.LONG_NAME, "Previously Settled", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    */
    var osTotalQual = new VField(financialdetailscontrolcontent.osTotalQual, VField.TYPE_ALPHA, VField.LONG_NAME, "OS Total Qual", VField.CHECK_WIDTH_MAXIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER);

    var ptdTotal = new VField(financialdetailscontrolcontent.ptdTotal, VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid To Date Total", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var settledInSettCcy = new VField(financialdetailscontrolcontent.settledInSettCcy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Settled In Sett Ccy", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
    var totalLine = new VField(financialdetailscontrolcontent.totalLine, VField.TYPE_NUMERIC, VField.LONG_NAME, "Settled In Sett Ccy", VField.CHECK_NUMERIC_PLACES, 2, VField.CHECK_DECIMAL_PLACES, 5);
    
    // ECF Phase 6 changes
    var brokerTr = new VField(financialdetailscontrolcontent.brokerTr, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker Transaction Id", VField.CHECK_WIDTH_MAXIMUM, 17, VField.FORMAT_CASE, VField.CASE_UPPER);
    var brokerTrQual = new VField(financialdetailscontrolcontent.brokerTrQual, VField.TYPE_ALPHA, VField.LONG_NAME, "Broker Transaction Id Qualifier");
		
   var individualUcr = new VField(financialdetailscontrolcontent.individualUcr, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Individual UCR",VField.CHECK_WIDTH_MAXIMUM, 17, VField.FORMAT_CASE, VField.CASE_UPPER);
   var individualTr = new VField(financialdetailscontrolcontent.individualTr, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Individual  TR",VField.CHECK_WIDTH_MAXIMUM, 17, VField.FORMAT_CASE, VField.CASE_UPPER);

    uoForm.add(redenomInd);
    uoForm.add(payeeBroker);
    uoForm.add(payeeBrokerPseud);
    uoForm.add(peerReview);
    uoForm.add(origCcy);
    uoForm.add(pttTotal);
    uoForm.add(osTotal);
    uoForm.add(settCcy);
    uoForm.add(osTotalQual);
    uoForm.add(settRateOfExch);
    uoForm.add(bureauPpnAmt);
    uoForm.add(vatAmt);
    uoForm.add(warAmount);
    uoForm.add(incurred);
    
    /* 
    Removed prevSettled for CCN#41
    uoForm.add(prevSettled);
    */
    uoForm.add(ptdTotal);
    uoForm.add(settledInSettCcy);
    uoForm.add(totalLine);
    
    uoForm.add(brokerTr); // ECF Phase 6 changes
    uoForm.add(brokerTrQual); // ECF Phase 6 changes
	
    uoForm.add(individualUcr); // Binders changes
    uoForm.add(individualTr); // Binders changes
	
    var uoCustom1 = new MyCustomValidator("O/S Amt and Qualifier");
 
    uoForm.add(uoCustom1);
    
    
  
 
    uoForm.initialise(false) ;

} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}


