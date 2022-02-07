// Rate of Exchange Adjustment Content
try {
	var uoForm = new VForm(document.forms[0]) ;

	var revisedExchangeRate1 = new VField(rateofexchangeadjustmentcontent.revisedExchangeRate1, VField.TYPE_NUMERIC, VField.LONG_NAME, "Revised Exchange Rate 1", VField.CHECK_NUMERIC_PLACES, 4, VField.CHECK_DECIMAL_PLACES, 7);
	var revisedExchangeRate2 = new VField(rateofexchangeadjustmentcontent.revisedExchangeRate2, VField.TYPE_NUMERIC, VField.LONG_NAME, "Revised Exchange Rate 2", VField.CHECK_NUMERIC_PLACES, 4, VField.CHECK_DECIMAL_PLACES, 7);
	var revisedExchangeRate3 = new VField(rateofexchangeadjustmentcontent.revisedExchangeRate3, VField.TYPE_NUMERIC, VField.LONG_NAME, "Revised Exchange Rate 3", VField.CHECK_NUMERIC_PLACES, 4, VField.CHECK_DECIMAL_PLACES, 7);
	var revisedSettAmt1 = new VField(rateofexchangeadjustmentcontent.revisedSettAmt1, VField.TYPE_NUMERIC, VField.LONG_NAME, "Revised Settlement Amount 1", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
	var revisedSettAmt2 = new VField(rateofexchangeadjustmentcontent.revisedSettAmt2, VField.TYPE_NUMERIC, VField.LONG_NAME, "Revised Settlement Amount 2", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
	var revisedSettAmt3 = new VField(rateofexchangeadjustmentcontent.revisedSettAmt3, VField.TYPE_NUMERIC, VField.LONG_NAME, "Revised Settlement Amount 3", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);

	uoForm.add(revisedExchangeRate1) ;
	uoForm.add(revisedExchangeRate2) ;
	uoForm.add(revisedExchangeRate3) ;
	uoForm.add(revisedSettAmt1) ;
	uoForm.add(revisedSettAmt2) ;
	uoForm.add(revisedSettAmt3) ;
	
	uoCustom = new RateOfExchangeAdjustmentContentCustom("Rate of Exchange Adjustment Content") ;
	uoForm.add(uoCustom) ;

	uoForm.initialise(false) ;
} catch(e) {
	e.description+= "\nRate of Exchange Adjustment form initialisation." ;
	alert(e.description)
}
