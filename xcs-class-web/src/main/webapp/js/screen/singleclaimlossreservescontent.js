try {
var uoForm = new VForm(singleclaimlossreservescontent) ;

var lrAdjustmentAsAtdd = new VField(singleclaimlossreservescontent.lrAdjustmentAsAtdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Loss Reserve Adjustment As At Date (day part)",   VField.CHECK_WIDTH_OPTIONAL_EXACT, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
var lrAdjustmentAsAtmm = new VField(singleclaimlossreservescontent.lrAdjustmentAsAtmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Loss Reserve Adjustment As At Date (month part)",  VField.CHECK_WIDTH_OPTIONAL_EXACT, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
var lrAdjustmentAsAtyyyy = new VField(singleclaimlossreservescontent.lrAdjustmentAsAtyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Loss Reserve Adjustment As At Date (year part)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Loss Reserve Adjustment As At Date", VGroup.CHECK_MANDATORY, true);
vGroup1.add(lrAdjustmentAsAtdd);
vGroup1.add(lrAdjustmentAsAtmm);
vGroup1.add(lrAdjustmentAsAtyyyy);
uoForm.add(vGroup1);

var refundedLR = new VField(singleclaimlossreservescontent.refundedLR, VField.TYPE_NUMERIC, VField.LONG_NAME, "Amount of Loss Reserve Refunded", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);

var paidClaim = new VField(singleclaimlossreservescontent.paidClaim, VField.TYPE_NUMERIC, VField.LONG_NAME, "Amount of Claim Paid on Loss Reserve", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
var lrAdvanced = new VField(singleclaimlossreservescontent.lrAdvanced, VField.TYPE_NUMERIC, VField.LONG_NAME, "Amount of Loss Reserve Retained This Time", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);

var interest = new VField(singleclaimlossreservescontent.interest, VField.TYPE_NUMERIC, VField.LONG_NAME, "Amount of Interest on Loss Reserve", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
var tax = new VField(singleclaimlossreservescontent.tax, VField.TYPE_NUMERIC, VField.LONG_NAME, "Amount of Tax on Loss Reserve", VField.CHECK_NUMERIC_PLACES, 3, VField.CHECK_DECIMAL_PLACES, 7);
var net = new VField(singleclaimlossreservescontent.net, VField.TYPE_NUMERIC, VField.LONG_NAME, "Net Loss Reserve", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
var osAmount = new VField(singleclaimlossreservescontent.osAmount, VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Amount", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true);
var osQualifier = new VField(singleclaimlossreservescontent.osQualifier, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Outstanding Amount Qualifier", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.CHECK_SIGNED, true);

uoForm.add(refundedLR);
uoForm.add(paidClaim);
uoForm.add(lrAdvanced);

uoForm.add(interest);
uoForm.add(tax);
uoForm.add(net);
uoForm.add(osAmount);
uoForm.add(osQualifier);

var uoCustom1 = new Customsingleclaimlossreservescontent("Loss Reserves Detail");
uoForm.add(uoCustom1);

uoForm.initialise(false) ;
} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}
