try {
  var uoForm = new VForm(narrativeContent) ;

  var vCustom1 = new MyCustomValidator("Narrative Page");
        var claimNarrative = new VField(narrativeContent.narr, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Narrative Area", VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS, VField.CHECK_VALIDATOR_DATA, vCustom1);

  uoForm.add(claimNarrative);



  uoForm.initialise(false) ;

} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}