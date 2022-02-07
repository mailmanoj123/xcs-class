// ==========================================================================================
// Alphanumeric validator class AlphaNumericValidator.
// Version 0.1.
// September 2002.
// Steria AM Ltd.
// Brian Ambrose, Max Bodimeade, Paul Deevoy.
// ==========================================================================================

function AlphaNumericValidator(iFormat){
	// ====================================================================== 
	// Description: Checks a string is a valid alphanumeric A-Z 
	// Parameters:  
	//    iFormat  - case format identifier , uses VField constants
	// Returns:			Nothing
	// ====================================================================== 
	var sFunctionName = "AlphaNumericValidator.constructor" ;

  try {
		debugMessage("Entering " + sFunctionName, 1) ;

    // Store initial values
    this.Value    = "";
    this.Format   = iFormat;

    // Set up error message array array
    this.Errors   = new MessageList();

		// Create a regular expression dependant on the case checking type
		formatSwitch: switch(this.Format) {
			case VField.CASE_UPPER:
				this.regExp = new RegExp("[^A-Z0-9]");
				break formatSwitch;
			case VField.CASE_LOWER:
				this.regExp = new RegExp("[^a-z0-9]");
				break formatSwitch;
			case VField.CASE_IGNORE:
				this.regExp = new RegExp("[^A-Za-z0-9]");
				break formatSwitch;
			default:
				throw new ErrorObject("Invalid upper/lower/ignore case format.") ;
    }

		debugMessage("Leaving " + sFunctionName, -1) ;
	} catch(e) {
		e.description+= "\n"+ sFunctionName ;
		throw e ;
  }
}

AlphaNumericValidator.prototype.isValid = function(sValue) {
  // ====================================================================== 
  // Description:   check valid alphanumeric A-Z
  // Parameters:    None
  // Returns:       boolean
  // ====================================================================== 
	var sFunctionName = "AlphaNumericValidator.isValid()" ;
  try {
		debugMessage("Entering " + sFunctionName, 1) ;

		// Clear down error store
		this.Errors.clear();

		// Store value to be validated
		this.Value  = sValue;
	
		// Test value against regular expression
		// The regular expression contains the list of characters that should not be in the value
		var bReturnValue = !(this.regExp.test(this.Value)) ;

		if (bReturnValue){
			// If there was an error - generate some error text
			this.Errors.add(this.getHelpText()) ;
		}
	
		debugMessage("Leaving " + sFunctionName, -1) ;
		return bReturnValue ;
	} catch(e) {
		e.description+= "\n"+ sFunctionName ;
		throw e ;
  }
}

AlphaNumericValidator.prototype.compare = function(vInput) {
  // ====================================================================== 
  // Description:   Compare this string to another passed in
  // Parameters:    vInput - value to be compared against
  // Returns:       Integer  - either 0,1 or -1
  // Notes:         Can be compared against either a string or an object
  //                of type AlphaValidator, AlphaExtendedValidator or
	//								AlphaNumericValidator
  // ====================================================================== 
	var sFunctionName= "AlphaNumericValidator.compare()" ;

  try {
		debugMessage("Entering " + sFunctionName, 1) ;
    
    var sCompareString ;
    var iReturn;
  
    // check either a string or another valid object
    compareTypeSwitch:
		switch (vInput.constructor) {
			case String:
				sCompareString = vInput;
				break compareTypeSwitch;
			case AlphaValidator:
			case AlphaExtendedValidator:
			case AlphaNumericValidator:
				sCompareString = vInput.getValue();
				break compareTypeSwitch;
			default:
				throw new ErrorObject("Cannot compare against "+ vInput.constructor);
		}
 
    // compare returning appropiate value
    // 0 = equals, 1 = greater than, -1 = less than
		if (this.Value == sCompareString)
			iReturn = 0;
		else {
			if (this.Value > sCompareString)
				iReturn = 1;
			else
				iReturn = -1;    
		}
		
		debugMessage("Leaving " + sFunctionName, -1) ;
		return iReturn;
  } catch(e) {
    e.description += sFunctionName ;
    throw e ;
  }
}


AlphaNumericValidator.prototype.getValue = function() {
  // ====================================================================== 
  // Description:   Returns value to be validated
  // Parameters: 		None
  // Returns:       String to be validated
  // ====================================================================== 
	var sFunctionName = "AlphaNumericValidator.getValue" ;
  try {
		debugMessage("Entering " + sFunctionName, 1) ;

		debugMessage("Leaving " + sFunctionName, -1) ;
		return this.Value;
  } catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
  }
}


AlphaNumericValidator.prototype.getErrorText = function() {
  // ====================================================================== 
  // Description:   return string containing all errors
  // Parameters: 		none
  // Returns:       string
  // ====================================================================== 
	var sFunctionName = "AlphaNumericValidator.getErrorText" ;
	
	try {
		debugMessage("Entering " + sFunctionName, 1) ;

		debugMessage("Leaving " + sFunctionName, -1) ;
		return this.Errors.toString();
	} catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
	}
}

AlphaNumericValidator.prototype.getHelpText = function() {
  // ====================================================================== 
  // Description:   Returns help description of the function
  // Parameters: 		None
  // Returns:       String
  // ====================================================================== 
	var sFunctionName = "AlphaNumericValidator.getHelpText" ;

  try {
		debugMessage("Entering " + sFunctionName, 1) ;
    var sDesc = "" ;

		caseSwitch: switch (this.Format) {
			case VField.CASE_IGNORE:
				sDesc+= "Only alphanumeric characters (a-z, A-Z or 0-9) can be entered." ;
				break caseSwitch ;
			case VField.CASE_UPPER:
				sDesc+= "Only upper case alpha and numeric characters (A-Z or 0-9) can be entered." ;
				break caseSwitch ;
			case VField.CASE_LOWER:
				sDesc+= "Only lower case alpha and numeric characters (a-z or 0-9) can be entered." ;
				break caseSwitch ;
		}
      
		debugMessage("Leaving " + sFunctionName, -1) ;
    return sDesc;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}