try {
var uoForm = new VForm(copyfromucrcontent) ;

    var ucrpt1 = new VField(copyfromucrcontent.ucrpt1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "UCR or XCR (part 1)", VField.CHECK_WIDTH_MINIMUM, 1, VField.CHECK_WIDTH_MAXIMUM, 1,  VField.FORMAT_CASE, VField.CASE_UPPER, VField.CHECK_MANDATORY, true);
    var ucrpt2 = new VField(copyfromucrcontent.ucrpt2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker or XCR (part 2)", VField.CHECK_WIDTH_MINIMUM, 4, VField.CHECK_WIDTH_MAXIMUM, 4, VField.FORMAT_CASE, VField.CASE_UPPER,  VField.CHECK_MANDATORY, true);
    var ucrpt3 = new VField(copyfromucrcontent.ucrpt3, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "Broker or XCR (part 3)", VField.CHECK_WIDTH_MINIMUM, 1, VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER,  VField.CHECK_MANDATORY, true);

    var trpt1 = new VField(copyfromucrcontent.trpt1, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "TR (part 1)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.FORMAT_CASE, VField.CASE_UPPER);
    var trpt2 = new VField(copyfromucrcontent.trpt2, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "TR (part 2)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.FORMAT_CASE, VField.CASE_UPPER);
    var trpt3 = new VField(copyfromucrcontent.trpt3, VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "TR (part 3)", VField.CHECK_WIDTH_MINIMUM, 1, VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);
    
    var vbool1 = new BooleanEntered(BooleanEntered.AND,"UCR or XCR",false,ucrpt1,ucrpt2,ucrpt3);
    uoForm.add(vbool1);
    
    var vbool2 = new BooleanEntered(BooleanEntered.AND,"Broker UCR",false,trpt1,trpt2,trpt3);
    uoForm.add(vbool2);
    
uoForm.add(ucrpt1);
uoForm.add(ucrpt2);
uoForm.add(ucrpt3);

uoForm.add(trpt1);
uoForm.add(trpt2);
uoForm.add(trpt3);

uoForm.initialise(false) ;  
} catch(e) {
  e.description+= "\nform1 form initialisation." ;
  alert(e.description)
}
