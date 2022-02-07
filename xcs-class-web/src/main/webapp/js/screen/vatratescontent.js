try {
  var uoForm = new VForm(vatratescontent);  
 
  var vatAmt1 = new VField(vatratescontent.vatAmt1, VField.TYPE_NUMERIC, VField.LONG_NAME, "VAT Amount 1", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
  var vatAmt2 = new VField(vatratescontent.vatAmt2, VField.TYPE_NUMERIC, VField.LONG_NAME, "VAT Amount 2", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
  var vatAmt3 = new VField(vatratescontent.vatAmt3, VField.TYPE_NUMERIC, VField.LONG_NAME, "VAT Amount 3", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
  var vatAmt4 = new VField(vatratescontent.vatAmt4, VField.TYPE_NUMERIC, VField.LONG_NAME, "VAT Amount 4", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
  var vatAmt5 = new VField(vatratescontent.vatAmt5, VField.TYPE_NUMERIC, VField.LONG_NAME, "VAT Amount 5", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true); 
  var vatAmt6 = new VField(vatratescontent.vatAmt6, VField.TYPE_NUMERIC, VField.LONG_NAME, "VAT Amount 6", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
  uoForm.add(vatAmt1);
  uoForm.add(vatAmt2);
  uoForm.add(vatAmt3);
  uoForm.add(vatAmt4);
  uoForm.add(vatAmt5);
  uoForm.add(vatAmt6);
  var vCustom1 = new MyCustomValidator("VAT Rates Page");
  uoForm.add(vCustom1);
  uoForm.initialise(false);
} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}