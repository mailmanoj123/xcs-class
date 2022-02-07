try {
  var uoForm = new VForm(maintaingroupcontent) ;
  var aggGrpNonAggRef = new VField(maintaingroupcontent.aggGrpNonAggRef, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Agg Ref/Non-Agg Ref", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 10, VField.CHECK_WIDTH_MAXIMUM, 10, VField.FORMAT_CASE, VField.CASE_UPPER);
  uoForm.add(aggGrpNonAggRef);

  var vCustom1 = new MyCustomValidator("Maintain Group Content");
  uoForm.add(vCustom1);

  uoForm.initialise(false) ;
} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}