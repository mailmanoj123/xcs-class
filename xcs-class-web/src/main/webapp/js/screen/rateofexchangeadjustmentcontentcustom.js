// Rate of Exchange Adjustment Content Custom Validation
function RateOfExchangeAdjustmentContentCustom(CustomNameTag) {
  // Initialise a new list for error messages
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
  this.errorLongName = "<br/><strong>Other Constraints Broken: " + CustomNameTag + "<br/>Reason(s): </strong><br/>";
}

// isValid
RateOfExchangeAdjustmentContentCustom.prototype.isValid = function() {
  // Start by clearing the message list
  this.uoMessageList.clear() ;
  
  // This is the boolean that will be passed back.
  this.uoBoolean = true;

	// At least one Revised Exchange Rate must be entered.
	var rerc = 0;
	
	// Original Exchange Rate
	var oer ;
	var oerl ;
	var oerv ;
	// Revised Exchange Rate
	var rer ;
	var rerl ;
	var rerv ;
	// Revised Settlement Amount
	var rsa ;
	var rsal ;
	var rsav ;
	var rsacv ;
	// Paid Amount
	var pa ;
	var pav ;

	for (var i = 1; i<4; i++) 
	{
		pa = eval("document.forms[0].paidAmt"+i+".value") ;
		pav = Number(removeCommas(pa)) ;
		
		oer = eval("document.forms[0].origExchangeRate"+i+".value") ;
		oer = removeCommas(oer);
		oerl = oer.length ;
		oerv = Number(oer) ;
		
		rer = eval("revisedExchangeRate" + i + ".getUIValue()") ;
		rer = removeCommas(rer);
		rerl = rer.length ;
		rerv = Number(rer) ;
		
		rsa = eval("revisedSettAmt" + i + ".getUIValue()") ;
		rsa = removeCommas(rsa);
		rsal = rsa.length ;
		rsav = Number(rsa) ;
		
		if (oerl == 0 || oerv == 0 || isNaN(oerv) == true ) 
		{
			// No original exchange rate present
			if (rerl != 0 && rerv != 0 && isNaN(rerv) == false) 
			{
				// increment the count of revised exchange rates
				rerc++ ;
				// A revised exchange rate was entered with no original exchange rate
				// No error number for this in the May 2002 spec
				this.uoMessageList.add("Currency " + i +  ": " + "Revised exchange rate must not be entered when there is no corresponding Original Exchange Rate.<br>") ;
				this.uoBoolean = false ;
			}
		}
		else 
		{
			// Original exchange rate present
			if (rerl==0 || rerv == 0 || isNaN(rerv) == true) 
			{
				// No revised exchange rate present
				if (rsal != 0 && rsav != 0 && isNaN(rsav) == false) 
				{
					// Revised settlement amount present with no revised exchange rate
					// Error E0137 
					this.uoMessageList.add("Error E0137: " + "Currency " + i +  ": " + "Revised Settlement Amount must not be entered without Revised Rate of Exchange.<br>") ;
					this.uoBoolean = false ;
				}
			}
			else 
			{
				// Revised exchange rate present
				// increment the count of revised exchange rates
				rerc++ ;
				if (rsal==0 || rsav == 0 || isNaN(rsav) == true) 
				{
					// Revised exchange rate present with revised settlement amount not present 
					// Error E0136
					this.uoMessageList.add("Error E0136: " + "Currency " + i +  ": " + "Revised Settlement Amount must be entered with Revised Rate of Exchange.<br>")
					this.uoBoolean = false ;
				} 
				else 
				{
					// Both revised exchange rate and revised settlement amount present
					if (rerv == oerv)
					{
						// Revised exchange rate must not equal original exchange rate
						this.uoMessageList.add("Error E0140: " + "Currency " + i +  ": " + "Revised Exchange Rate must not be the same as the Original Exchange Rate<br>")
						this.uoBoolean = false ;
					}
					else 
					{
						rsacv = pav / rerv
						/* Cannot check as the tolerance is not supplied in May 2002 spec
						if (rsacv != rsav) {
							Error E0135						
							this.uoMessageList.add("Error E0135: " + "Currency " + i +  ": " + "Revised Settlement Amount is outside tolerance.<br>") ;
							this.uoBoolean = false ;
						}
						*/
					}
				}
			}
		}
	}
	
	if (rerc == 0) 
	{
		// At least one revised exchange rate must be present
		// Error E0139
		this.uoMessageList.add("Error E0139: " + "Please enter at least one Revised Exchange Rate.<br>")
		this.uoBoolean = false ;
	}
	
  return this.uoBoolean
}

// getHelpText
RateOfExchangeAdjustmentContentCustom.prototype.getHelpText = function() {
  // If there are already values in the message list, these came out of error processing
  if (this.uoMessageList.length > 0) {
    return this.uoMessageList.toString()
  } else {
    // There are no values in the message list, return whatever general help is appropriate
    // for this custom validator
  }
}