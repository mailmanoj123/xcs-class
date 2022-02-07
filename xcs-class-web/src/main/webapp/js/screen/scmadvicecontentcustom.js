// scmadvicecontent custom validation

// Constructor
function SCMAdviceContentCustom(CustomNameTag) {
  // Initialise a new list for error messages
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
    this.errorLongName = "<br/><strong>Other Constraints Broken: " + CustomNameTag + " Screen<br/>Reason(s): </strong><br/>";
}

// isValid
SCMAdviceContentCustom.prototype.isValid = function() {
  // Start by clearing the message list
  this.uoMessageList.clear() ;

  // This is the boolean that will be passed back.
  this.result = true;

  // ======================================================================
  // Tab One
  // ======================================================================

  // Sum up paid this time Loss, Fee and Expenses.  Put the result in paid this time total
  var pttLossValue = Number(removeCommas(pttLoss.getUIValue())) ;
  var pttFeeValue = Number(removeCommas(pttFee.getUIValue())) ;
  var pttExpValue = Number(removeCommas(pttExp.getUIValue())) ;
  var pttTotalValue = pttLossValue + pttFeeValue + pttExpValue;
  // If any of the above were not a number (NaN) or they were all blank then set the total to blank
  if (
    (isNaN(pttTotalValue)) ||
    ((pttLoss.getUIValue().length == 0) && (pttFee.getUIValue().length == 0) && (pttExp.getUIValue().length == 0))
  )
    document.forms[0].pttTotal.value = "" ;
  else
  {
    document.forms[0].pttTotal.value = pttTotalValue.toFixed(2);
  }
  
  if(origCcy != null && origCcy!= '' && (origCcy == 'JPY' || origCcy == 'ITL'))
  {
	if(isNaN(pttLossValue) != true)
	{
  		var pttLossValueInt = parseInt(pttLossValue);
  		if(pttLossValueInt != pttLossValue)
  		{
		    this.result = false ;
		    this.uoMessageList.add(" Paid this time amounts must not contain decimal places for 'JPY' <br> PTT Loss ="+pttLossValue.toFixed(2)+"<br><br>");
  		}
  	}
	if(isNaN(pttFeeValue) != true)
	{
  		var pttFeeValueInt = parseInt(pttFeeValue);
  		if(pttFeeValueInt != pttFeeValue)
  		{
		    this.result = false ;
		    this.uoMessageList.add(" Paid this time amounts must not contain decimal places for 'JPY' <br> PTT Fee ="+pttFeeValue.toFixed(2)+"<br><br>");
  		}
  	}
	if(isNaN(pttExpValue) != true)
	{
  		var pttExpValueInt = parseInt(pttExpValue);
  		if(pttExpValueInt != pttExpValue)
  		{
		    this.result = false ;
		    this.uoMessageList.add(" Paid this time amounts must not contain decimal places for 'JPY' <br> PTT Exp ="+pttExpValue.toFixed(2)+"<br><br>");
  		}
  	}
	if(isNaN(pttTotalValue) != true)
	{
  		var pttTotalValueInt = parseInt(pttTotalValue);
  		if(pttTotalValueInt != pttTotalValue)
  		{
		    this.result = false ;
		    this.uoMessageList.add(" Paid this time amounts must not contain decimal places for 'JPY' <br> PTT Total ="+pttTotalValue.toFixed(2)+"<br><br>");
  		}
  	}
  }
  

  // Sum up outstanding Loss, Fee and Expenses.  Put the result in outstanding total.
  var osLossValue = Number(removeCommas(osLoss.getUIValue()));
  var osFeeValue = Number(removeCommas(osFee.getUIValue()));
  var osExpValue = Number(removeCommas(osExp.getUIValue()));
  var osTotalValue = osLossValue + osFeeValue + osExpValue ;
  // If any of the above were not a number (NaN) or they were all blank then set the total to blank
  if (
    (isNaN(osTotalValue)) ||
    ((osLoss.getUIValue().length == 0) && (osFee.getUIValue().length == 0) && (osExp.getUIValue().length == 0))
  )
    document.forms[0].osTotal.value = "" ;
  else
    document.forms[0].osTotal.value = osTotalValue;

  // Get the paid to date total - this was calculated in the EJT or Mainframe
  var ptdTotalValue = Number(document.forms[0].ptdTotal.value) ;

  // Incurred Amount- this is no longer needed!!!
  /*
  var incurredAmountCheckValue = pttTotalValue + ptdTotalValue + osTotalValue ;
  var incurredAmountValue = Number(incurred.getUIValue()) ;
  if (incurredAmountValue != incurredAmountCheckValue) {
    this.result = false ;
    // Error E0097
    this.uoMessageList.add("The incurred amount must be equal to the sum of: the Paid To Date Total, the Paid This Time Total and the Outstanding Total.")
  }
  */
  // Outstanding Rate of Exchange
  if ((osTotal.getUIValue() != 0) && (osRateOfExch.getUIValue()).length==0) {
    // Error E0098
    this.result = false ;
    this.uoMessageList.add("If " + osTotal.longName + " is not zero, " +  osRateOfExch.longName + " must be entered.<br>") ;
  }

  // 100% Settlement Amount
  // Screen label is Settled in Sett Ccy
  // Input tag name is SettledRateInSettCurrency
  var settledInSettCcyValue = Number(settledRateInSettCcy.getUIValue()) ;
  var pttTotalValue = Number(pttTotal.getUIValue()) ;
  var settRateOfExcValue = Number(document.forms[0].settRateOfExc.value) ;
  var settledInSettCcyCheckValue = pttTotalValue * settRateOfExcValue ;
  if (false) {
    // Check not carried out
    // Tolerance for checking is undefined (appendix J)
    // Error E0089
    this.result = false ;
    this.uoMessageList.add("The Settled in Settlement Currency amount should be equal to the Total Paid This Time multiplied by the Rate of Exchange.  A tba tolerance is permitted.<br>" )
  }

  // Bureau Proportion
  var bureauPpnValue = Number(bureauPpn.getUIValue()) ;
  var bureauLineValue = Number(document.forms[0].totalLine.value) ;
  var bureauPpnCheckValue = settledInSettCcyValue * bureauLineValue ;
  if (false) {
    // Check not carried out
    // Tolerance for checking is undefined (appendix J)
    // Error E0090
    this.result = false ;
    this.uoMessageList.add("The Bureau Proportion should be equal to the Settled in Settlement Currency amount multiplied by the Total Bureau Line.  A tba tolerance is permitted.<br>" )
  }

  // VAT Amount and War Amount
  /*
  vatAmountValue = Number(vatAmount.getUIValue()) ;
  warAmountValue = Number(warAmount.getUIValue()) ;
  if (settledInSettCcyValue >= 0) {
    if (vatAmountValue < 0) {
      // Error E0091
      this.result = false ;
      this.uoMessageList.add("The VAT Amount must be the same sign as the Settled in Settlement Currency amount.<br>")
    }
    if (vatAmountValue > settledInSettCcyValue) {
      // Error E0092
      this.result = false ;
      this.uoMessageList.add("The VAT Amount cannot be larger than the Settled in Settlement Currency amount.<br>")
    }
    if (warAmountValue < 0) {
      // Error E0093
      this.result = false ;
      this.uoMessageList.add("The War Amount must be the same sign as the Settled in Settlement Currency amount.<br>")
    }
    if (warAmountValue > settledInSettCcyValue) {
      // Error E0094
      this.result = false ;
      this.uoMessageList.add("The War Amount cannot be larger than the Settled in Settlement Currency amount.<br>")
    }
  } else if (settledInSettCcyValue < 0) {
    if (vatAmountValue > 0) {
      // Error E0091
      this.result = false ;
      this.uoMessageList.add("The VAT Amount must be the same sign as the Settled in Settlement Currency amount.<br>")
    }
    if (vatAmountValue < settledInSettCcyValue) {
      // Error E0092
      this.result = false ;
      this.uoMessageList.add("The VAT Amount cannot be larger than the Settled in Settlement Currency amount.<br>")
    }
    if (warAmountValue > 0) {
      // Error E0093
      this.result = false ;
      this.uoMessageList.add("The War Amount must be the same sign as the Settled in Settlement Currency amount.<br>")
    }
    if (warAmountValue < settledInSettCcyValue) {
      // Error E0094
      this.result = false ;
      this.uoMessageList.add("The War Amount cannot be larger than the Settled in Settlement Currency amount.<br>")
    }
  }*/

  // ======================================================================
  // Tab Two
  // ======================================================================
  // State Code

  /* CCN 31/01/03
    if ((tfCode.getUIValue().length > 0) && (stateCode.getUIValue().length == 0)) {
    // Error E0119
    this.result = false ;
    this.uoMessageList.add("State code must be entered if a Trust Fund Code is entered.<br>")
  }*/

  // NAIC Code
  if ((tfCode.getUIValue().toUpperCase() == "RI") && (naicCode.getUIValue().length == 0)) {
    // Error E0122
    this.result = false ;
    this.uoMessageList.add("NAIC code must be entered if Trust Fund Code is RI.<br>")
  }

  // NAIC Qualifier
  if ((naicCode.getUIValue().length > 0) && (naicQual.getUIValue().length == 0)) {
    // Error E0124
    this.result = false ;
    this.uoMessageList.add("NAIC Qualifier must be entered if a NAIC Code is entered.<br>")
  }

  // ======================================================================
  // Tab Three
  // ======================================================================
  if (vGroup1.getUIValue().length == 0) {
    // Date not entered. Qualifier must be entered.
    if (polCertQualifier.getUIValue().length == 0) {
      // Error E0103
      this.result = false ;
      this.uoMessageList.add("The Policy / Certificate Period Qualifier must be entered if the Policy / Certificate date is blank.<br><br>")
    } else {
      if (polCertQualifier.getUIValue() != 'T' && polCertQualifier.getUIValue() != 'V' && polCertQualifier.getUIValue() != 'N') {
        // Error E104
        this.result = false;
        this.uoMessageList.add("Policy/Certificate Period Qualifier invalid.<br>The valid value 'N'(N/A).<br>");
      }
    }
  } else {
    // Date entered.  Qualifier must not be entered
    if (polCertQualifier.getUIValue().length != 0) {
      // Error E0102
      this.result = false ;
      this.uoMessageList.add("The Policy / Certificate Period Qualifier must not be entered if the Policy / Certificate date is not blank.<br>")
    }
  }

  var dateCount = 0 ;
  // vGroup3 = Date of Loss From
  if (vGroup3.getUIValue().length != 0) {
    dateCount++ ;
    if (dolQual.getUIValue().length != 0) {
      // Error E0107
      this.result = false ;
      this.uoMessageList.add("Cannot enter Loss Date(s) with Qualifier.<br>")
    }
  } else if (dolQual.getUIValue().length != 0) dateCount++ ;

  // vGroup5 = Date Claim From
  if (vGroup5.getUIValue().length != 0) {
    dateCount++ ;
    if (dcmDodQual.getUIValue().length != 0) {
      // Error E111
      this.result = false ;
      this.uoMessageList.add("Cannot enter Claim Date(s) with Qualifier.<br>")
    }
  } else if (dcmDodQual.getUIValue().length != 0) dateCount++ ;

  // line below changed (6/2/03) as incorrect. was "if (dateCount != 1) {"
  if (false) {
    // Error E106
    this.result = false ;
    this.uoMessageList.add("Either Date of Loss or Date of Claim must be entered.<br>")
  } else {
    if (dolQual.getUIValue().length !=0 )
      if (dolQual.getUIValue() != 'T' && dolQual.getUIValue() != 'V' && dolQual.getUIValue() != 'N') {
        // Error E110
        this.result = false;
        this.uoMessageList.add("Date of Loss Qualifier invalid.<br>Valid values are 'T'(TBA), 'V'(Various) or 'N'(N/A).<br>");
      }
    if (dcmDodQual.getUIValue().length !=0 )
      if (dcmDodQual.getUIValue() != 'T' && dcmDodQual.getUIValue() != 'V' && dcmDodQual.getUIValue() != 'N') {
        // Error E114
        this.result = false;
        this.uoMessageList.add("Date Claim Made Qualifier invalid.<br>Valid values are 'T'(TBA), 'V'(Various) or 'N'(N/A).<br>");
      }
  }
  
  /* Fix added to valid the Adjuster and Lawyer field
   * clintonj TP101172 
   * 16/09/2004
   */  

   /* Commented Adjuster and Lawyer Validations for Expert Fee BD Change
   *  Sachin Goyal
   *  02 October 2007
   */
   
  //var _pttExp = pttExp.getUIValue();
  //var _pttFee = pttFee.getUIValue();
  
  //if(_pttExp == "") {    
    //document.all.pttExp.value = "0.00";
    //_pttExp = "0.00";
 // }
  
  //if(_pttFee == "") {    
    //document.all.pttFee.value = "0.00";
    //_pttFee = "0.00";
 // }
  
  /* Remove comma's [very important] */
  //_pttFee = removeCommas(_pttFee);
  //_pttExp = removeCommas(_pttExp);
      
  //if((_pttExp > 0 || _pttFee > 0) || (_pttExp < 0 || _pttFee < 0)) {   
   // var _adjusterName = adjusterName.getUIValue();          
    //var _lawyerName = lawyerName.getUIValue();        
       
    //var invalidList = new Array("N/A",".","NOT USED","TBA","T.B.A.","CANCELLED","NOT IN USE");  
    
    //if((_adjusterName.length > 0) || (_lawyerName.length > 0)) {                     
      
      /* An error is displayed if either of the adjuster/lawyer fields contains invalid valids.
       * clintonj 
       * 21/10/2004
       */
      //for(var i=0; i<invalidList.length; i++) {      
        //for(var j=0; j<invalidList.length; j++) {          
         // if(_adjusterName == invalidList[i] || _lawyerName == invalidList[j]) {
           // this.result = false;
            //this.uoMessageList.add("Invalid data entered into Adjuster/Lawyer name field.  Fee cannot be processed with invalid data in Adjuster/Lawyer name field.<br>");           // PRC: chnaged error text               
           // break;
        //  }
        //}
        //if(!this.result)
         //break;
      //}
      
      /*  if((_adjusterName == "N/A" || _adjusterName == "." || _adjusterName == "NOT USED") && (_lawyerName == "N/A" || _lawyerName == "." || _lawyerName == "NOT USED")) {
          this.result = false;
          this.uoMessageList.add("Invalid data entered into Adjuster/Lawyer name field when processing a fee.<br>");           // PRC: chnaged error text   
        
        // if either the adjuster/laweyer is blank and if either the adjuster/lawyer contains invalid data throw an error.
        } else  if((_adjusterName.length == 0 || _lawyerName.length == 0) && 
            ((_adjusterName == "N/A" || _adjusterName == "." || _adjusterName == "NOT USED") || (_lawyerName == "N/A" || _lawyerName == "." || _lawyerName == "NOT USED"))) {                     
          this.result = false;
          this.uoMessageList.add("Invalid data entered into Adjuster/Lawyer name field when processing a fee.<br>");          // PRC: chnaged error text        
        */
        // if one of the adjuster/lawyer fields are empty and the other contains VARIOUS, ensure that 
        // the block indicator is checked and dcmDod is V.
  /* PRC: removed as no longer wanted      } else if ((_adjusterName.length == 0 || _lawyerName.length == 0) && (_adjusterName == "VARIOUS" || _lawyerName == "VARIOUS") && !(dcmDodQual.getUIValue() == 'V' && document.scmadvicecontent.elements['blockInd'].checked)) {                 
           this.result = false;
           this.uoMessageList.add(adjLawyerError+"<br>");      */          
        
        // if they're both VARIOUS ensure the block indicator is checked and dcmDod is V
  /* PRC: removed as no longer wanted      } else if ((_adjusterName.length != 0 && _lawyerName.length != 0) && (_adjusterName == "VARIOUS" && _lawyerName == "VARIOUS") && !(dcmDodQual.getUIValue() == 'V' && document.scmadvicecontent.elements['blockInd'].checked)) {                 
          this.result = false;
          this.uoMessageList.add(adjLawyerError+"<br>");             */   
        /*} else {
          // valid.
        } */   
      
    //} else {      
      // fields were left blank ERROR
    //  this.result = false;
   //   this.uoMessageList.add("Adjuster/Lawyer details must be entered when processing a fee.<br>");   // PRC: chnaged error text
   // }
  //}  
  
  if (false) {
   //Error E0xxx
    this.result = false;
    this.uoMessageList.add("");
  }
  
  return this.result
}

// getHelpText
SCMAdviceContentCustom.getHelpText = function() {
  // If there are already values in the message list, these came out of error processing
  if (this.uoMessageList.length > 0) {
    return this.uoMessageList.toString()
  } else {
    // There are no values in the message list, return whatever general help is appropriate
    // for this custom validator
  }
}