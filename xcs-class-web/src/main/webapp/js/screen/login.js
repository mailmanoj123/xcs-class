try {
  var uoLogin = new VForm(loginForm) ;

  var username = new VField(loginForm.username, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "User Name", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 5, VField.CHECK_WIDTH_MAXIMUM, 8, VField.FORMAT_CASE, VField.CASE_UPPER);
  var password = new VField(loginForm.password, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Password", VField.CHECK_MANDATORY, false, VField.CHECK_WIDTH_MINIMUM, 5, VField.CHECK_WIDTH_MAXIMUM, 8, VField.FORMAT_CASE, VField.CASE_UPPER);
  uoLogin.add(username);
  uoLogin.add(password);
  uoLogin.initialise() ;
  document.all.accountCode.focus();

} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}
