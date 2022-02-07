try {
  var uoReadvice = new VForm(createreadvicecontent) ;

  var currentNarrative1  = new VField(createreadvicecontent.currentNarrative1,  VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Current Narrative", VField.CHECK_WIDTH_MAXIMUM, 50, VField.FORMAT_CASE, VField.CASE_UPPER);
  var currentNarrative2A = new VField(createreadvicecontent.currentNarrative2A, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Current Narrative 2 (part 1)", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER);
  var currentNarrative2B = new VField(createreadvicecontent.currentNarrative2B, VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Current Narrative 2 (part 1)", VField.CHECK_WIDTH_MAXIMUM, 25, VField.FORMAT_CASE, VField.CASE_UPPER);

  uoReadvice.add(currentNarrative1);
  uoReadvice.add(currentNarrative2A);
  uoReadvice.add(currentNarrative2B);


} catch(e) {
  e.description+= "\nReadvice form initialisation." ;
  alert(e.description)
}
