try {
  var uoForm = new VForm(marketdetailscontent) ;

  //  var vatAmt1 = new VField(vatratescontent.vatAmt1, VField.TYPE_NUMERIC, VField.LONG_NAME, "VAT Amount 1", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true);
  //  uoForm.add(vatAmt1);

  var vCustom1 = new MyCustomValidator("Market Details Page");
  uoForm.add(vCustom1);

  uoForm.initialise(false) ;

} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}