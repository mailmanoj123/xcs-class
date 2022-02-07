try {
  var uoLogin = new VForm(groupenquirycontent) ;

  var aggGrpNonAggRef = new VField(groupenquirycontent.aggGrpNonAggRef, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Agg Ref/Non-Agg Ref", VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 10, VField.CHECK_WIDTH_MAXIMUM, 10, VField.FORMAT_CASE, VField.CASE_UPPER);
  
  uoLogin.add(aggGrpNonAggRef);
  uoLogin.initialise() ;
 
} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}
