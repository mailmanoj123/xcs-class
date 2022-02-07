try 
{
	var uoForm = new VForm(ccvcquestionnairecontent) ;
	
    var BKR_PRES_DATEdd = new VField(ccvcquestionnairecontent.BKR_PRES_DATEdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Broker Presentation Date Day ", VField.CHECK_WIDTH_MINIMUM, 2, VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31",  VField.CHECK_NO_COMMAS, true);
    var BKR_PRES_DATEmm = new VField(ccvcquestionnairecontent.BKR_PRES_DATEmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Broker Presentation Date Month ", VField.CHECK_WIDTH_MINIMUM, 2,VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var BKR_PRES_DATEyyyy = new VField(ccvcquestionnairecontent.BKR_PRES_DATEyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Broker Presentation Date Year ", VField.CHECK_WIDTH_MINIMUM, 4, VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var vGroup1 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Broker Presentation Date");
    uoForm.add(vGroup1);
    vGroup1.add(BKR_PRES_DATEdd);
    vGroup1.add(BKR_PRES_DATEmm);
    vGroup1.add(BKR_PRES_DATEyyyy);
 
    var LDR_PRES_DATEdd = new VField(ccvcquestionnairecontent.LDR_PRES_DATEdd, VField.TYPE_NUMERIC, VField.LONG_NAME, "Leader Presentation Date Day ", VField.CHECK_WIDTH_MINIMUM, 2, VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
    var LDR_PRES_DATEmm = new VField(ccvcquestionnairecontent.LDR_PRES_DATEmm, VField.TYPE_NUMERIC, VField.LONG_NAME, "Leader Presentation Date Month ",VField.CHECK_WIDTH_MINIMUM, 2, VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
    var LDR_PRES_DATEyyyy = new VField(ccvcquestionnairecontent.LDR_PRES_DATEyyyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "Leader Presentation Date Year ",VField.CHECK_WIDTH_MINIMUM, 4, VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "1900", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
    var vGroup2 = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "Leader Presentation Date");
    uoForm.add(vGroup2);
    vGroup2.add(LDR_PRES_DATEdd);
    vGroup2.add(LDR_PRES_DATEmm);
    vGroup2.add(LDR_PRES_DATEyyyy);
 
    var uoCustom = new CCVCQuestionnaireContentCustom("CCVC Questionnaire Content") ;
    uoForm.add(uoCustom);

    uoForm.initialise(false) ;
} 
catch(e) 
{
    e.description+= "\nform1 form initialisation." ;
    alert(e.description)
}