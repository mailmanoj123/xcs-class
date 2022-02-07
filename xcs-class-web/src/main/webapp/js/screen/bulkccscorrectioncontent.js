try {
var uoForm = new VForm(bulkccscorrectioncontent) ;

var settRateOfExch1 = new VField(bulkccscorrectioncontent.treasuryRate1, VField.TYPE_NUMERIC, VField.LONG_NAME, "Treasury Rate Settlement: GBP 1", VField.CHECK_NUMERIC_PLACES, 5, VField.CHECK_DECIMAL_PLACES, 7, VField.CHECK_MANDATORY, true);
var settRateOfExch2 = new VField(bulkccscorrectioncontent.treasuryRate2, VField.TYPE_NUMERIC, VField.LONG_NAME, "Treasury Rate Settlement: GBP 2", VField.CHECK_NUMERIC_PLACES, 5, VField.CHECK_DECIMAL_PLACES, 7);
var settRateOfExch3 = new VField(bulkccscorrectioncontent.treasuryRate3, VField.TYPE_NUMERIC, VField.LONG_NAME, "Treasury Rate Settlement: GBP 3", VField.CHECK_NUMERIC_PLACES, 5, VField.CHECK_DECIMAL_PLACES, 7);

uoForm.add(settRateOfExch1);
uoForm.add(settRateOfExch2);
uoForm.add(settRateOfExch3);

uoForm.initialise(false) ;
} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}
