function CCVCQuestionnaireContentCustom(CustomNameTag) 
{
	this.uoMessageList = new MessageList() ;
	this.longName= CustomNameTag ;
	this.errorLongName = "<br/><strong>Other Constraints Broken: " + CustomNameTag + " Screen<br/>Reason(s): </strong><br/>";
}

CCVCQuestionnaireContentCustom.prototype.isValid = function() 
{
	this.uoMessageList.clear() ;
	this.result = true;

	/*Check that all the radio questions are slected*/
	if(isRadioChecked("LLOYDS_LEAD_IND") == false || isRadioChecked("BORD_IND") == false ||
	   isRadioChecked("DOL_IN_POL_Q") == false || isRadioChecked("CLAIM_IN_POL_Q") == false ||
	   isRadioChecked("CORRECT_IDENT_Q") == false || isRadioChecked("DEDUCT_EXCESS_Q") == false ||
	   isRadioChecked("COVERAGE_Q") == false || isRadioChecked("CAUSE_CODE_Q") == false ||
	   isRadioChecked("LEAD_AGREEMENT_Q") == false || isRadioChecked("MKT_AGREEMENT_Q") == false  )
	{
		this.result = false ;
		this.uoMessageList.add("Please provide answers to all mandatory questions.");
	}
	return this.result
}

function isRadioChecked(radioName)
{
	var radioElements = document.getElementsByName(radioName);
	for(var i = 0 ; i < radioElements.length ; i++)
	{
		if(radioElements[i].checked == true || radioElements[i].readOnly == true || radioElements[i].disabled == true)
		{
			return true;
		}
	}
	return false;
}

CCVCQuestionnaireContentCustom.getHelpText = function() 
{
	if (this.uoMessageList.length > 0) 
	{
		return this.uoMessageList.toString()
	} 
	else 
	{
	}
}

function resetForm()
{
	var resetFormFlag = false;
	
	resetFormFlag = confirm("Are you sure you want to reset the questionnaire ?");
	
	if(resetFormFlag == true)
	{
		document.forms[0].reset();
	}
}

function changeSubs5QuesNA(BORD_IND_Object)
{
	if(BORD_IND_Object.value == "Y" && BORD_IND_Object.disabled != true && BORD_IND_Object.readOnly != true)
	{
		var DOL_IN_POL_Q_Obj = document.getElementsByName("DOL_IN_POL_Q");
		var CLAIM_IN_POL_Q_Obj = document.getElementsByName("CLAIM_IN_POL_Q");
		var CORRECT_IDENT_Q_Obj = document.getElementsByName("CORRECT_IDENT_Q");
		var DEDUCT_EXCESS_Q_Obj = document.getElementsByName("DEDUCT_EXCESS_Q");
		var COVERAGE_Q_Obj = document.getElementsByName("COVERAGE_Q");
		
		DOL_IN_POL_Q_Obj[2].checked = true;
		CLAIM_IN_POL_Q_Obj[2].checked = true;
		CORRECT_IDENT_Q_Obj[2].checked = true;
		DEDUCT_EXCESS_Q_Obj[2].checked = true;
		COVERAGE_Q_Obj[2].checked = true;
	}
}

