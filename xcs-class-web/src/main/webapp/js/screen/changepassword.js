try {
  var uoForm = new VForm(form1) ;
  
  var password = new VField(form1.password, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "New password", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 5, VField.CHECK_WIDTH_MAXIMUM, 8, VField.FORMAT_CASE, VField.CASE_UPPER);
  var confirmPassword = new VField(form1.passwordConfirm, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Confirmation password", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 5, VField.CHECK_WIDTH_MAXIMUM, 8, VField.FORMAT_CASE, VField.CASE_UPPER);
  
  uoForm.add(password);
  uoForm.add(confirmPassword);
  
  uoForm.initialise(false) ;
  //form1.password.focus();
  
} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}
