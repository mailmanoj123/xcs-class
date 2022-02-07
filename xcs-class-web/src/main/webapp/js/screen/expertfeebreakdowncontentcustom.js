function createExpert()
{
	okButtonClicked = false; newExpertButtonClicked = true;
	var bFormValid = false;
	if (document.forms[0].uoVForm != null) 
	{
		bFormValid = document.forms[0].uoVForm.onsubmit_Handler();
	}
	
	if(bFormValid == true)
	{
		var maintable=document.getElementById('expertbreakdowntablebody');
		
		//create Table for upper rows
		var topRow=document.createElement('tr');
		var topTD=document.createElement('td');	
		topTD.appendChild(createTableTop());
		topRow.appendChild(topTD);
		topRow.setAttribute("id","toprow"+counter);
		
		//create Table for bottom rows
		var bottomRow=document.createElement('tr');
		var bottomTD=document.createElement('td');	
		bottomTD.appendChild(createTableBottom());
		bottomRow.appendChild(bottomTD);
		bottomRow.setAttribute("id","bottomrow"+counter);
	
		maintable.appendChild(topRow);
		maintable.appendChild(bottomRow);
	
		counter++;
		
		rowCountObject = document.getElementById("rowCount");
		rowCountObject.value = eval(rowCountObject.value) + 1;
		
		updateTableBackgrounds();
		updateScreenValidators();
	}

}

function removeExpert()
{
	okButtonClicked = false; newExpertButtonClicked = false; 

	var removeExpert=confirm(" Are you sure you want to  \n  remove the selected experts ? ");
	var deleteSelected = false;
  	if (removeExpert==true)
    {
    	while (true)
    	{
		  	var allInputTypes = document.getElementsByTagName("input");
		  	
		  	for(i =0 ; i < allInputTypes.length ; i++)
		  	{
		  		if(allInputTypes[i].type=="checkbox")
		  		{
			  		var checkBoxObject = allInputTypes[i];
			  		if(checkBoxObject.name.indexOf("deleteexpert")>=0 && checkBoxObject.checked == true)
			  		{
			  			var rowIndex = checkBoxObject.name.substring(12);
			  			var topRowTobeDeleted = document.getElementById('toprow'+rowIndex);
			  			var bottomRowTobeDeleted = document.getElementById('bottomrow'+rowIndex);
			  			topRowTobeDeleted.parentNode.removeChild(topRowTobeDeleted);
			  			bottomRowTobeDeleted.parentNode.removeChild(bottomRowTobeDeleted);
			  			
			  			deleteSelected = true;
			  			
			  			rowCountObject = document.getElementById("rowCount");
						rowCountObject.value = eval(rowCountObject.value) - 1;
			  			
			  			break;
			  		}
		  		}
		  	}
		  	if(i == allInputTypes.length)
		  	{
		  		break;
		  	}
		  }
		  
		  if(deleteSelected == false)
		  {
		  	alert("Please select at least one expert for deletion. ");
		  	return;
		  }
		  
		  updateTableBackgrounds();
    	  updateScreenValidators();
	}	
}

function createTableTop()
{
	var oTable = document.createElement('table');
	oTable.width="100%";
	oTable.className="custom";
	
	var oTBody; 
	var oTR;
	var oTD;

	oTBody = document.createElement('tbody');
			
	/*******************ROW 1*****************/
	oTR = document.createElement('tr');
	
	oTD = document.createElement('td');
	oTD.width = "25%";
	oTD.appendChild(document.createTextNode('Expert Type'));
	var redStarSpan = document.createElement('span');
	redStarSpan.style.color='red';
	redStarSpan.appendChild(document.createTextNode('*'));
	oTD.appendChild(redStarSpan);
	oTR.appendChild(oTD);
	
	oTD = document.createElement('td');	
	oTD.width = "25%";
	oTD.innerHTML=expertTypeComboHTML + " <input type='hidden' name='expertTypeFlag' value=''>";
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "25%";
	oTD.appendChild(document.createTextNode('Advise On SCM'));
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "25%";
	var currCounter = counter ;
	oTD.innerHTML="<input type='checkbox' name='expertSCMCheckBox'  onClick='updateCheckBoxHidden(this,"+currCounter+")' > <input type='hidden' name='expertSCM'  value ='N'>  <input type='hidden' name='expertSCMFlag'  value =''>";
	oTR.appendChild(oTD);
	/*******************ROW 1*****************/		
	oTBody.appendChild(oTR);
	
	
	/*******************ROW 2*****************/
	
	oTR = document.createElement('tr');
	
	oTD = document.createElement('td');
	oTD.width = "25%";
	oTD.appendChild(document.createTextNode('Expert Code'));
	var redStarSpan = document.createElement('span');
	redStarSpan.style.color='red';
	redStarSpan.appendChild(document.createTextNode('*'));
	oTD.appendChild(redStarSpan);
	oTR.appendChild(oTD);
	
	oTD = document.createElement('td');	
	oTD.width = "25%";
	oTD.innerHTML="<input type='text' name='expertCode'  onChange = 'validateExpertTypeCodeAndName(null,this,null)' autocomplete='off' > <input type='hidden' name='expertCodeFlag'  value =''>";
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "25%";
	oTD.appendChild(document.createTextNode('Expert Ref'));
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "25%";
	oTD.innerHTML="<input type='text' name='expertRef'  autocomplete='off'  > <input type='hidden' name='expertRefFlag'  value =''>";
	oTR.appendChild(oTD);
	/*******************ROW 2*****************/
	oTBody.appendChild(oTR);
	
	/*******************ROW 3*****************/		
	oTR = document.createElement('tr');
	
	oTD = document.createElement('td');
	oTD.width = "25%";
	oTD.appendChild(document.createTextNode('Expert Org Name'));
	oTR.appendChild(oTD);
	
	oTD = document.createElement('td');	
	oTD.setAttribute('colSpan','3');
	oTD.setAttribute('id','expertOrgNameTD');
	oTD.innerHTML=expertOrgNameComboHTML + '<input type="hidden" name="expertNameFlag"  value ="">';
	oTR.appendChild(oTD);

	/*******************ROW 3*****************/
	oTBody.appendChild(oTR);	


	/*******************ROW 4*****************/		
	oTR = document.createElement('tr');
	
	oTD = document.createElement('td');
	oTD.width = "25%";
	oTD.appendChild(document.createTextNode('Expert Name'));
	oTR.appendChild(oTD);
	
	oTD = document.createElement('td');	
	oTD.setAttribute('colSpan','3');
	oTD.innerHTML="<input type='text' name='expertCNTC'  autocomplete='off'   > <input type='hidden' name='expertCNTCFlag'  value =''> ";
	oTR.appendChild(oTD);

	/*******************ROW 4*****************/
	oTBody.appendChild(oTR);	
	
	oTable.appendChild(oTBody);
	
	oTable.setAttribute("id", "tabletop"+counter);
	return oTable;
}
	
	
	
function createTableBottom()
{
	var oTable = document.createElement('table');
	oTable.width="100%";
	oTable.className="custom";
	
	var oTBody; 
	var oTR;
	var oTD;

	oTBody = document.createElement('tbody');
			
	/*******************ROW 1*****************/
	oTR = document.createElement('tr');
	
	oTD = document.createElement('td');
	oTD.width = "11%";
	oTD.appendChild(document.createTextNode('PTD Exp'));
	oTR.appendChild(oTD);
	
	oTD = document.createElement('td');	
	oTD.width = "22%";
	oTD.innerHTML="<input type='text' value = '0.00' name='expertPTD_EXP' "+expPTDFlag+"  autocomplete='off' > <input type='hidden' name='expertPTD_EXPFlag'  value ='"+expPTDFlag+"'>";
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "12%";
	oTD.appendChild(document.createTextNode('PTT Exp'));
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "22%";
	oTD.innerHTML="<input type='text' value ='0.00' name='expertPTT_EXP' "+expPTTFlag+"  autocomplete='off' > <input type='hidden' name='expertPTT_EXPFlag'  value ='"+expPTTFlag+"'>";
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "12%";
	oTD.appendChild(document.createTextNode('O/S Exp'));
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "21%";
	oTD.innerHTML="<input type='text' value = '0' name='expertOS_EXP'  autocomplete='off' > <input type='hidden' name='expertOS_EXPFlag'  value =''>";
	oTR.appendChild(oTD);
	/*******************ROW 1*****************/		
	oTBody.appendChild(oTR);
	
	
	/*******************ROW 2*****************/
	oTR = document.createElement('tr');
	
	oTD = document.createElement('td');
	oTD.width = "12%";
	oTD.appendChild(document.createTextNode('PTD Fee'));
	oTR.appendChild(oTD);
	
	oTD = document.createElement('td');	
	oTD.width = "21%";
	oTD.innerHTML="<input type='text' value = '0.00' name='expertPTD_FEE' "+feePTDFlag+"  autocomplete='off' > <input type='hidden' name='expertPTD_FEEFlag'  value ='"+feePTDFlag+"'>";
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "13%";
	oTD.appendChild(document.createTextNode('PTT Fee'));
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "21%";
	oTD.innerHTML="<input type='text' value ='0.00' name='expertPTT_FEE' "+feePTTFlag+"  autocomplete='off' > <input type='hidden' name='expertPTT_FEEFlag'  value ='"+feePTTFlag+"'> ";
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "12%";
	oTD.appendChild(document.createTextNode('O/S Fee'));
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "21%";
	oTD.innerHTML="<input type='text' value = '0' name='expertOS_FEE'  autocomplete='off' > <input type='hidden' name='expertOS_FEEFlag'  value =''>";
	oTR.appendChild(oTD);
	/*******************ROW 2*****************/		
	oTBody.appendChild(oTR);
	
	/*******************ROW 3*****************/
	oTR = document.createElement('tr');
	
	oTD = document.createElement('td');	
	oTD.setAttribute('colSpan','5');
	oTD.setAttribute('align','right');
	oTD.appendChild(document.createTextNode('Delete Expert ?'));
	oTR.appendChild(oTD);

	oTD = document.createElement('td');	
	oTD.width = "16.6%";
	oTD.setAttribute('align','middle');
	oTD.innerHTML="<input type='checkbox' name=deleteexpert"+counter+" > <input type='hidden' name='deleteExpertFlag'  value =''> ";
	oTR.appendChild(oTD);
	/*******************ROW 3*****************/		
	oTBody.appendChild(oTR);
	
	oTable.appendChild(oTBody);
	
	oTable.setAttribute("id", "tablebottom"+counter);
	return oTable;
}

function updateCheckBoxHidden(checkBoxObject, rowUniqueIndex)
{
	topRowObject = document.getElementById('toprow'+rowUniqueIndex);
	topRowTableObject = topRowObject.cells[0].children[0];
	expertSCMHiddenObject = topRowTableObject.rows[0].cells[3].children[1];

	if(checkBoxObject.checked == true)
	{
		expertSCMHiddenObject.value = 'Y';
	}
	else
	{
		expertSCMHiddenObject.value = 'N';
	}
}

function updateTableBackgrounds()
{
	allRows = document.getElementsByTagName("tr");
	var bgColor='';
	if(allRows != null)
	{
		for(i=0; i < allRows.length ; i++)
		{
			if(allRows[i].id != null && allRows[i].id != '')
			{
				if(allRows[i].id.indexOf("toprow")>=0 )
				{
					allRows[i].bgColor = bgColor;
					
					for( j = i+1 ; j < allRows.length ; j++)
					{
						if(allRows[j].id.indexOf("bottomrow")>=0 )
						{
							allRows[j].bgColor = bgColor;
							break;
						}
					}
					
					if(bgColor == '')
					{
						bgColor= '#9DD7EB';
					}
					else
					{
						bgColor = '';
					}
					
				}
			}
		}
	}
}



/*VALIDATION STUFF*/
var arrExpertType = new Array();
var arrExpertCode = new Array();
var arrExpertName = new Array();
var arrExpertCNTC = new Array();

var arrExpertSCM = new Array();
var arrExpertRef = new Array();
	
var arrPTD_EXP = new Array();
var arrPTD_FEE = new Array();
var arrPTT_EXP = new Array();
var arrPTT_FEE = new Array();
var arrOS_EXP = new Array();
var arrOS_FEE = new Array();

var arrDeleteExpert = new Array();

function updateScreenValidators()
{
	var prevUoHelpDiv = null;
	if(document.forms[0].uoVForm)
	{
		prevUoHelpDiv = document.forms[0].uoVForm.uoHelpDiv;

		document.forms[0].uoVForm.finalise();
	}
	
	var uoForm = new VForm(exprtfeebreakdowncontent) ;
	
	if(prevUoHelpDiv != null )
	{
		uoForm.uoHelpDiv = prevUoHelpDiv;
	}
  	arrExpertType = document.getElementsByName("expertType");
  	arrExpertCode = document.getElementsByName("expertCode");
  	arrExpertName = document.getElementsByName("expertName");
  	arrExpertCNTC = document.getElementsByName("expertCNTC");
  	
  	arrExpertSCM = document.getElementsByName("expertSCMCheckBox");
  	arrExpertRef = document.getElementsByName("expertRef");
  	
  	arrPTD_EXP = document.getElementsByName("expertPTD_EXP");
 	arrPTD_FEE = document.getElementsByName("expertPTD_FEE");
  	arrPTT_EXP = document.getElementsByName("expertPTT_EXP");
 	arrPTT_FEE = document.getElementsByName("expertPTT_FEE");
  	arrOS_EXP =  document.getElementsByName("expertOS_EXP");
 	arrOS_FEE =  document.getElementsByName("expertOS_FEE");

  	var allInputTypesEx = document.getElementsByTagName("input");
  	arrDeleteExpert = new Array();
  	
  	for(delExCount =0 ; delExCount < allInputTypesEx.length ; delExCount++)
  	{
  		if(allInputTypesEx[delExCount].type=="checkbox")
  		{
	  		var checkBoxObject = allInputTypesEx[delExCount];
	  		if(checkBoxObject.name.indexOf("deleteexpert")>=0)
	  		{
			 	arrDeleteExpert[arrDeleteExpert.length] = checkBoxObject;
			}
		}
	}

  	for(j =0 ; j < arrExpertType.length ; j++)
  	{
  		/*dont know why but we have to assign it to a different var, javascript has it's reasons*/
  		var i = j;
  		if(arrExpertType[i].protected != 'true')
  		{
 			uoForm.add(new VField(arrExpertType[i], VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Expert Type", VField.CHECK_WIDTH_MAXIMUM, 8,VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 1 ));
 		}
  		if(arrExpertCode[i].readOnly != true)
  		{
	  		uoForm.add(new VField(arrExpertCode[i], VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Expert Code", VField.CHECK_WIDTH_MAXIMUM, 4,VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER ));
		}
  		if(arrExpertName[i].protected != 'true')
  		{
  			uoForm.add(new VField(arrExpertName[i], VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Expert Organization Name", VField.CHECK_WIDTH_MAXIMUM, 40,VField.CHECK_MANDATORY, true, VField.CHECK_WIDTH_MINIMUM, 1 ));
	  		arrExpertName[i].onblur=function(){mksResetSelect(); mksShowSearchPattern(false, null);this.uoVField.onblur_Handler();}

		}
  		if(arrExpertCNTC[i].readOnly != true)
  		{
	  		uoForm.add(new VField(arrExpertCNTC[i], VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Expert Name", VField.CHECK_WIDTH_MAXIMUM, 40, VField.CHECK_WIDTH_MINIMUM, 1, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS ));
		}
 		if(arrExpertRef[i].readOnly != true)
  		{
	  		uoForm.add(new VField(arrExpertRef[i], VField.TYPE_ALPHAEXTENDED, VField.LONG_NAME, "Expert Ref", VField.CHECK_WIDTH_MAXIMUM, 16, VField.FORMAT_CASE, VField.CASE_UPPER, VField.FORMAT_OTHER, VField.SCM_CHARACTERS ));
		}
 		
 		/*Making 0 to the amounts if NaN before passing to the validator*/
 		var pttFee = Number(removeCommas(arrPTT_FEE[i].value));
 		var pttExp = Number(removeCommas(arrPTT_EXP[i].value));
 		var ptdFee = Number(removeCommas(arrPTD_FEE[i].value));
 		var ptdExp = Number(removeCommas(arrPTD_EXP[i].value));
 		var osFee = Number(removeCommas(arrOS_FEE[i].value));
 		var osExp = Number(removeCommas(arrOS_EXP[i].value));
 		
 		if(isNaN(pttFee) == true || pttFee == 0){arrPTT_FEE[i].value = "0.00";}
 		if(isNaN(pttExp) == true || pttExp == 0){arrPTT_EXP[i].value = "0.00";}
		if(isNaN(ptdFee) == true || ptdFee == 0){arrPTD_FEE[i].value = "0.00";}
		if(isNaN(ptdExp) == true || ptdExp == 0){arrPTD_EXP[i].value = "0.00";}
		if(isNaN(osFee) == true || osFee == 0){arrOS_FEE[i].value = "0";}
		if(isNaN(osExp) == true || osExp == 0){arrOS_EXP[i].value = "0";}
 		
		if(arrPTD_EXP[i].readOnly != true)
  		{
			uoForm.add(new VField(arrPTD_EXP[i], VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid To Date Expenses", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true));
		}
		if(arrPTD_FEE[i].readOnly != true)
  		{
	  		uoForm.add(new VField(arrPTD_FEE[i], VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid To Date Fees", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true));
	  	}

		if(arrPTT_EXP[i].readOnly != true)
		{
			uoForm.add(new VField(arrPTT_EXP[i], VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid This Time Expenses", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true));
		}
		if(arrPTT_FEE[i].readOnly != true)
		{
			uoForm.add(new VField(arrPTT_FEE[i], VField.TYPE_NUMERIC, VField.LONG_NAME, "Paid This Time Fees", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_DECIMAL_PLACES, 2, VField.CHECK_SIGNED, true));
		}
		
		if(arrOS_EXP[i].readOnly != true)
		{
			uoForm.add(new VField(arrOS_EXP[i], VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Expenses", VField.CHECK_NUMERIC_PLACES, 13, VField.CHECK_SIGNED, true));
		}
		if(arrOS_FEE[i].readOnly != true)
		{
			uoForm.add(new VField(arrOS_FEE[i], VField.TYPE_NUMERIC, VField.LONG_NAME, "Outstanding Fees", VField.CHECK_NUMERIC_PLACES, 13,  VField.CHECK_SIGNED, true));
		}
	}
	
	/*Adding custom validator */
	var uoCustom1 = new MyCustomValidator("Expert Fee Breakdown selected check");
  	uoForm.add(uoCustom1);
}



/* 
* My Custom Validator class - MyCustomValidator
*/

function MyCustomValidator(CustomNameTag)
{
  /* Initialise a new list for error messages */
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
  this.errorLongName = "<br/><strong>Other Constraints Broken: " + CustomNameTag + " Screen<br/>Reason(s): </strong><br/>";
}

/*Is Valid*/
MyCustomValidator.prototype.isValid = function()
{
 	this.uoMessageList.clear() ;
	
  	/* This is the boolean that will be passed back.*/
	this.uoBoolean = true;
	
	/*Dont do custom validation when new expert button is clicked*/
	if(	okButtonClicked == false && newExpertButtonClicked == true)
	{
		/*Check for max expert limit*/
		if(eval(document.getElementById("rowCount").value) < maxexpertlimit)
		{
			this.uoBoolean = true;
		}
		else
		{
			this.uoMessageList.add("Expert limit exceeded - limit is "+ maxexpertlimit) ;
	      	this.uoBoolean = false;
		}
      	return this.uoBoolean;
	}
	
	var hasCheckedValidAdjuster=false;
	var hasCheckedValidLawyer=false;
	var hasValidAdjuster = false;
	var hasValidLawyer = false;
	var checkedValidAdjusterCount = 0;
	var checkedValidLawyerCount = 0;
	
	var expertNameRefData = document.getElementById("expertNameRefData");
	
	for (i =0 ; i < arrExpertSCM.length ; i++)
	{
		var isValidExpert = false;
		
		if(arrExpertSCM[i].checked == true)
		{
			if(arrExpertType[i].value.toUpperCase() == 'A')
			{
				/*Check if the protected adjuster details are valid or not*/
				if(arrExpertType[i].protected == 'true' || arrExpertName[i].protected == 'true' || arrExpertCode[i].readOnly == true)
				{
					for( l = 0 ; l < expertNameRefData.options.length ; l ++)
					{
						if(expertNameRefData.options[l].value.toUpperCase() == arrExpertName[i].value.toUpperCase() && expertNameRefData.options[l].expCode.toUpperCase() == arrExpertCode[i].value.toUpperCase() &&   expertNameRefData.options[l].expType.toUpperCase() == arrExpertType[i].value.toUpperCase())
						{
							hasCheckedValidAdjuster = true ;
							hasValidAdjuster = true;
							isValidExpert = true;
							checkedValidAdjusterCount = checkedValidAdjusterCount +1;
							break;
						}
					}
					
					if(isValidExpert == false)
					{
						this.uoMessageList.add(" Adjuster to be advised on SCM is no longer valid, Please select another adjuster <br> Expert Name: "+arrExpertName[i].value+"  and Expert Code: "+arrExpertCode[i].value+"<br><br>" ) ;
				      	this.uoBoolean = false;
					}
				}
				else
				{
					hasValidAdjuster = true;
					hasCheckedValidAdjuster = true ;
					checkedValidAdjusterCount = checkedValidAdjusterCount +1;
					
				}
			}
			else if(arrExpertType[i].value.toUpperCase() == 'L')
			{
				/*Check if the protected adjuster details are valid or not*/
				if(arrExpertType[i].protected == 'true' || arrExpertName[i].protected == 'true' || arrExpertCode[i].readOnly == true)
				{
					for( l = 0 ; l < expertNameRefData.options.length ; l ++)
					{
						if(expertNameRefData.options[l].value.toUpperCase() == arrExpertName[i].value.toUpperCase() && expertNameRefData.options[l].expCode.toUpperCase() == arrExpertCode[i].value.toUpperCase() &&   expertNameRefData.options[l].expType.toUpperCase() == arrExpertType[i].value.toUpperCase())
						{
							hasCheckedValidLawyer = true ;
							hasValidLawyer = true;
							isValidExpert = true;
							checkedValidLawyerCount = checkedValidLawyerCount +1;
							
							break;
						}
					}
					
					if(isValidExpert == false)
					{
						this.uoMessageList.add(" Lawyer to be advised on SCM is no longer valid, Please select another lawyer <br> Expert Name: "+arrExpertName[i].value+"  and Expert Code: "+arrExpertCode[i].value+"<br><br>" ) ;
				      	this.uoBoolean = false;
					}
				}
				else
				{
					hasValidLawyer = true;
					hasCheckedValidLawyer = true ;
					checkedValidLawyerCount = checkedValidLawyerCount +1;
				}
			}
		}
		else
		{
			if(arrExpertType[i].value.toUpperCase() == 'A')
			{
				hasValidAdjuster = true;
			}
			else if(arrExpertType[i].value.toUpperCase() == 'L')
			{
				hasValidLawyer = true;			
			}
		}
	}

	if((hasValidAdjuster == true) && (hasCheckedValidAdjuster == false))
	{
		this.uoMessageList.add("Please select an adjuster to be advised on the SCM. <br>" ) ;
      	this.uoBoolean = false;
	}
	
	if((hasValidLawyer == true) && (hasCheckedValidLawyer == false))
	{
		this.uoMessageList.add("Please select a lawyer to be advised on the SCM. <br>" ) ;
    	this.uoBoolean = false;
	}

	if(checkedValidAdjusterCount > 1)
	{
		this.uoMessageList.add(" One and only one valid adjuster can be advised on the SCM. <br>" ) ;
    	this.uoBoolean = false;
	}
	
	if(checkedValidLawyerCount > 1)
	{
		this.uoMessageList.add(" One and only one valid lawyer can be advised on the SCM. <br>" ) ;
    	this.uoBoolean = false;
	}

	var blnDuplicateFound = false;
	for(j=0 ; j< arrExpertCode.length ; j++)
	{
		var i = j;
		var expertTypeVal = arrExpertType[i].value.toUpperCase();
		var expertCodeVal = arrExpertCode[i].value.toUpperCase();
		var expertNameVal = arrExpertName[i].value.toUpperCase();
		
		if(expertTypeVal != '' && expertCodeVal != '' && expertNameVal != '')
		{
			for(l = 0 ; l < arrExpertCode.length ; l ++)
			{
				var k = l;
				
				if( (k != i) && (expertTypeVal == arrExpertType[k].value.toUpperCase()) && (expertCodeVal == arrExpertCode[k].value.toUpperCase()) && (expertNameVal == arrExpertName[k].value.toUpperCase()))
				{
					blnDuplicateFound = true;
					break;
				}
			}
		}
		
		if(blnDuplicateFound == true)
		{
			this.uoMessageList.add(" Duplicate Expert Type / Expert Code have been specified <br> Expert Type  = "+(expertTypeVal=='A'?" Adjuster ":" Lawyer ")+" and Expert Code = "+expertCodeVal+"<br><br>") ;
	    	this.uoBoolean = false;
			break;		
		}
	}

  	/*Check if delete selected check is checked.*/
	for (i =0 ; i < arrDeleteExpert.length ; i++)
	{
		if(arrDeleteExpert[i].checked == true)
		{
			this.uoMessageList.add(" Please delete selected expert(s) before proceeding.<br><br>" ) ;
      		this.uoBoolean = false;
      		break;
		}
	}
	
	/*First check if any of the feilds (besides PTD) in a row is unprotected then
	take the amount of all the fields in to the sum validation*/

	var pttFeeSum = Number("0.00");
	var pttExpSum = Number("0.00");
	
	var osFeeSum = Number("0");
	var osExpSum = Number("0");
	
	for (i =0 ; i < arrPTT_FEE.length ; i++)
	{
		if(arrPTT_FEE[i].readOnly == false || arrPTT_EXP[i].readOnly == false || arrOS_FEE[i].readOnly == false || arrOS_EXP[i].readOnly == false )
		{
	 		var pttFee = Number(removeCommas(arrPTT_FEE[i].value));
	 		var pttExp = Number(removeCommas(arrPTT_EXP[i].value));
	 		var ptdFee = Number(removeCommas(arrPTD_FEE[i].value));
	 		var ptdExp = Number(removeCommas(arrPTD_EXP[i].value));
	 		var osFee = Number(removeCommas(arrOS_FEE[i].value));
	 		var osExp = Number(removeCommas(arrOS_EXP[i].value));
	 		
	 		if(isNaN(pttFee) == true || pttFee == 0){arrPTT_FEE[i].value = "0.00";pttFee = Number("0.00");}
	 		if(isNaN(pttExp) == true || pttExp == 0){arrPTT_EXP[i].value = "0.00";pttExp = Number("0.00");}
			if(isNaN(ptdFee) == true || ptdFee == 0){arrPTD_FEE[i].value = "0.00";ptdFee = Number("0.00");}
			if(isNaN(ptdExp) == true || ptdExp == 0){arrPTD_EXP[i].value = "0.00";ptdExp = Number("0.00");}
			if(isNaN(osFee) == true || osFee == 0){arrOS_FEE[i].value = "0";osFee = Number("0");}
			if(isNaN(osExp) == true || osExp == 0){arrOS_EXP[i].value = "0";osExp = Number("0");}

			/*Check in case of Currency as JPY or ITL does not contain decimal*/
			if(origCcy != null && origCcy!= '' && (origCcy == 'JPY' || origCcy == 'ITL'))
			{
				var pttFeeInt = parseInt(pttFee);
				var pttExpInt = parseInt(pttExp);
				
				if(pttFee != pttFeeInt)
				{
					this.uoMessageList.add(" Paid this time amounts must not contain decimal places for 'JPY' <br> PTT Fee ="+pttFee.toFixed(2)+"<br><br>") ;
			        this.uoBoolean = false;
					return this.uoBoolean;
				}
				if(pttExp != pttExpInt)
				{
					this.uoMessageList.add(" Paid this time amounts must not contain decimal places for 'JPY' <br> PTT Exp ="+pttExp.toFixed(2)+"<br><br>") ;
			        this.uoBoolean = false;
					return this.uoBoolean;
				}
			}
						
			pttFeeSum += pttFee;
			pttExpSum += pttExp;
			osFeeSum += osFee;
			osExpSum += osExp;
		}
	}

	pttFeeTotal = Number(removeCommas(pttFeeTotal+'')).toFixed(2);
	pttExpTotal = Number(removeCommas(pttExpTotal+'')).toFixed(2);
	pttFeeSum = pttFeeSum.toFixed(2);
	pttExpSum = pttExpSum.toFixed(2);
	
	osFeeTotal = parseInt(Number(removeCommas(osFeeTotal+'')));
	osExpTotal = parseInt(Number(removeCommas(osExpTotal+'')));
	osFeeSum = parseInt(osFeeSum);
	osExpSum = parseInt(osExpSum);
	
	/*Check if pttfeetotal is equal to sum of expertPTT_FEE*/
	if(pttFeeTotal != pttFeeSum)
	{
		this.uoMessageList.add(" PTT Fee amounts for experts not equal to Total PTT Fee amount <br> Expert Amount= "+insertCommas(pttFeeSum.toString())+ " Total Amount="+insertCommas(pttFeeTotal.toString())+"<br><br>") ;
        this.uoBoolean = false;
	}
	
	/*Check if pttexptotal is equal to sum of expertPTT_EXP*/
	if(pttExpTotal != pttExpSum)
	{
		this.uoMessageList.add(" PTT expense amounts for experts not equal to Total PTT expense amount <br> Expert Amount= "+insertCommas(pttExpSum.toString())+ " Total Amount="+insertCommas(pttExpTotal.toString())+"<br><br>") ;
        this.uoBoolean = false;
	}
		
	/*Check if osfeetotal is equal to sum of expertOS_FEE*/
	if(osFeeTotal != osFeeSum)
	{
		this.uoMessageList.add(" O/S Fee amounts for experts not equal to Total O/S Fee amounts <br> Expert Amount= "+insertCommas(osFeeSum.toString())+ " Total Amount="+insertCommas(osFeeTotal.toString())+"<br><br>") ;
        this.uoBoolean = false;
	}
	
	/*Check if osexptotal is equal to sum of expertOS_EXP*/
	if(osExpTotal != osExpSum)
	{
		this.uoMessageList.add(" O/S expense amounts for experts not equal to Total O/S expense amount <br> Expert Amount= "+insertCommas(osExpSum.toString())+ " Total Amount="+insertCommas(osExpTotal.toString())+"<br><br>") ;
        this.uoBoolean = false;
	}
	
	/*Check if ptdfeetotal is equal to sum of expertPTD_FEE*/
//	var ptdFeeSum = 0;
//	for (i =0 ; i < arrPTD_FEE.length ; i++)
//	{
//		ptdFeeSum += parseFloat(arrPTD_FEE[i].value);
//	}
//	if(ptdFeeTotal != ptdFeeSum)
//	{
//		this.uoMessageList.add(" PTD FEE AMTS FOR EXPERTS NOT = TOTAL PTD FEE AMT <br><br>") ;
//      this.uoBoolean = false;
//	}
	
	/*Check if ptdexptotal is equal to sum of expertPTD_EXP*/
//	var ptdExpSum = 0;
//	for (i =0 ; i < arrPTD_EXP.length ; i++)
//	{
//		ptdExpSum += parseFloat(arrPTD_EXP[i].value);
//	}
//	if(ptdExpTotal != ptdExpSum)
//	{
//		this.uoMessageList.add(" PTD EXPENSE AMTS FOR EXPERTS NOT = TOTAL PTD EXPENSE AMT <br><br>") ;
//      this.uoBoolean = false;
//	}
	
	
	return this.uoBoolean;
}

/*GetHelpText*/
MyCustomValidator.getHelpText = function() 
{
  // If there are already values in the message list, these came out of error processing
  if (this.uoMessageList.length > 0) 
  {
    return this.uoMessageList.toString();
  }
  else 
  {
    // There are no values in the message list, return whatever general help is appropriate
    // for this custom validator
  }
}

function updateExpertNames(typeObj)
{
	var arrExpertOrgNameTd = document.getElementsByName("expertOrgNameTD");
	for( j = 0; j < arrExpertType.length ; j ++)
	{
		var i = j;
		
		if(arrExpertType[i] == typeObj)
		{
			/*Reset Expert Name combo*/			
			if(typeObj.value=='L')
			{
				arrExpertOrgNameTd[i].innerHTML=lawyerNamecomboHTML + '<input type="hidden" name="expertNameFlag"  value ="">';
				break;
			}
			else if(typeObj.value=='A')
			{
				arrExpertOrgNameTd[i].innerHTML=adjusterNamecomboHTML + '<input type="hidden" name="expertNameFlag"  value ="">';
				break;				
			}
			else if(typeObj.value=='')
			{
				arrExpertOrgNameTd[i].innerHTML=expertOrgNameComboHTML + '<input type="hidden" name="expertNameFlag"  value ="">';
				break;				
			}
		}
	}
	updateScreenValidators();
}

function validateExpertTypeCodeAndName(typeObj,codeObj,nameObj)
{
	for( j = 0; j < arrExpertType.length ; j ++)
	{
		var i = j;
		
		/*If Type is sent*/
		if(typeObj != null && typeObj.value != '' )
		{
			if(arrExpertType[i] == typeObj)
			{
				var expertTypeObject = arrExpertType[i];
				var expertCodeObject = arrExpertCode[i];
				var expertNameObject = arrExpertName[i];
				
				if(expertCodeObject.value != '' || expertNameObject.value != '')
				{
					for (k = 0 ; k < expertNameObject.options.length ; k++)
					{
						if(expertTypeObject.value.toUpperCase() == expertNameObject.options[k].expType.toUpperCase())
						{
							if(expertCodeObject.value != '' && expertNameObject.protected == 'false') 
							{
								expertNameObject.selectedIndex = 0;	
								if(expertCodeObject.value.toUpperCase() == expertNameObject.options[k].expCode.toUpperCase())
								{
									expertNameObject.selectedIndex = k;	
									break;
								}
							}
							else if(expertNameObject.value != '' && expertCodeObject.readOnly == false)
							{
								expertCodeObject.value = '';
								if(expertNameObject.value.toUpperCase() == expertNameObject.options[k].value.toUpperCase())
								{
									expertCodeObject.value = expertNameObject.options[k].expCode;
									break;
								}
							}
						}
					}
				}
				break;
			}
		}

		/*If Code is sent*/
		else if(codeObj != null  && codeObj.value != '')
		{
			if(arrExpertCode[i] == codeObj)
			{
				var expertTypeObject = arrExpertType[i];
				var expertCodeObject = arrExpertCode[i];
				var expertNameObject = arrExpertName[i];
				
				if(expertTypeObject.value != '' || expertNameObject.value != '')
				{
					if(expertTypeObject.value != '' && expertNameObject.protected == 'false') 
					{
						expertNameObject.selectedIndex = 0;	
						
						for (k = 0 ; k < expertNameObject.options.length ; k++)
						{
							if(expertCodeObject.value.toUpperCase() == expertNameObject.options[k].expCode.toUpperCase() && expertTypeObject.value.toUpperCase() == expertNameObject.options[k].expType.toUpperCase())
							{
								expertNameObject.selectedIndex = k;	
								break;
							}
						}
					}
							
					else if(expertNameObject.value != '' && expertTypeObject.protected == 'false')
					{
						expertTypeObject.selectedIndex = 0;
						for (k = 0 ; k < expertNameObject.options.length ; k++)
						{
							if(expertCodeObject.value.toUpperCase() == expertNameObject.options[k].expCode.toUpperCase() && expertNameObject.value.toUpperCase() == expertNameObject.options[k].value.toUpperCase())
							{
								expertTypeObject.value = expertNameObject.options[k].expType;
								break;
							}
						}
					}
				}
				break;
			}
		}
			
		/*If Name is sent*/
		else if(nameObj != null  && nameObj.value != '')
		{
			if(arrExpertName[i] == nameObj)
			{
				var expertTypeObject = arrExpertType[i];
				var expertCodeObject = arrExpertCode[i];
				var expertNameObject = arrExpertName[i];
				
				if(expertTypeObject.value != '' || expertCodeObject.value != '')
				{
					for (k = 0 ; k < expertNameObject.options.length ; k++)
					{
						if(expertNameObject.selectedIndex == k)
						{
							if(expertTypeObject.value != '' && expertCodeObject.readOnly == false) 
							{
								expertCodeObject.value = '';
								if(expertTypeObject.value.toUpperCase() == expertNameObject.options[k].expType.toUpperCase())
								{
									expertCodeObject.value = expertNameObject.options[k].expCode;
									break;
								}
							}
							else if(expertCodeObject.value != '' && expertTypeObject.protected == 'false')
							{
								expertTypeObject.selectedIndex = 0;
								if(expertCodeObject.value.toUpperCase() == expertNameObject.options[k].expCode.toUpperCase())
								{
									expertTypeObject.value = expertNameObject.options[k].expType;
									break;
								}
							}
						}
					}
				}
				break;
			}
		}
	}
	
}

function showExpertNamesOnLoad()
{
	for (i = 0 ; i < arrExpertCode.length ; i++ )
	{
		validateExpertTypeCodeAndName(null,arrExpertCode[i],null);
	}
}

