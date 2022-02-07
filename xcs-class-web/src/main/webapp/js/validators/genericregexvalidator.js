// ==========================================================================================
// Generic Regex Comparison validator class GenericRegexValidator.
// Version 0.1.
// March 2004.
// Xchanging.
// Patrick Cogab
// ==========================================================================================

function GenericRegexValidator(regex, errorMsg){
	// ====================================================================== 
	// Description: Checks a string is valid against an entered regular expression. 
	// Parameters:  
	//    regex    - the regular expression to validate against.
	//    errorMsg - The error message for validation failures.
	// Returns:			Nothing
	// ====================================================================== 
	var sFunctionName = "GenericRegexValidator.constructor" ;

  try {
		debugMessage("Entering " + sFunctionName + ": regex = " + regex, 1) ;

    // Store initial values
    this.Value    = "";
    this.Regex			= regex;
    this.ErrorMsg 	=	errorMsg;
		
/*		this.digitLength = 0;
		this checkLength = false;
		
		
		// A hack for lack of regex knowledge
		if(this.regex.match('_LEngth')){
			this.splitString = this.regex.split('_LEngth');
			this.regex = this.splitString[0];
			this.digitLength = this.splitString[1];
		  this checkLength = true;
		} */
		
    // Set up error message array array
    this.Errors   = new MessageList();

		// Create a regular expression dependant on the case checking type
				this.regExp = new RegExp(regex);

		debugMessage("Leaving " + sFunctionName, -1) ;
	} catch(e) {
		e.description+= "\n"+ sFunctionName ;
		throw e ;
  }
}

GenericRegexValidator.prototype.isValid = function(sValue) {
  // ====================================================================== 
  // Description:   check valid alpha A-Z
  // Parameters:    None
  // Returns:       boolean
  // ====================================================================== 
	var sFunctionName = "GenericRegexValidator.isValid()" ;
  try {
		debugMessage("Entering " + sFunctionName, 1) ;

		// Clear down error store
		this.Errors.clear();

		// Store value to be validated
		this.Value  = sValue;
	
		// Test value against regular expression
		// The regular expression contains the list of characters that SHOULD BE in the value
		var bReturnValue = (this.regExp.test(this.Value)) ;

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

GenericRegexValidator.prototype.compare = function(vInput) {
  // ====================================================================== 
  // Description:   Compare this string to another passed in
  // Parameters:    vInput - value to be compared against
  // Returns:       Integer  - either 0,1 or -1
  // Notes:         Can be compared against either a string or an object
  //                of type GenericRegexValidator, AlphaExtendedValidator or
	//								AlphaNumericValidator
  // ====================================================================== 
	var sFunctionName= "GenericRegexValidator.compare()" ;

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
			case GenericRegexValidator:
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


GenericRegexValidator.prototype.getValue = function() {
  // ====================================================================== 
  // Description:   Returns value to be validated
  // Parameters: 		None
  // Returns:       String to be validated
  // ====================================================================== 
	var sFunctionName = "GenericRegexValidator.getValue" ;
  try {
		debugMessage("Entering " + sFunctionName, 1) ;

		debugMessage("Leaving " + sFunctionName, -1) ;
		return this.Value;
  } catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
  }
}


GenericRegexValidator.prototype.getErrorText = function() {
  // ====================================================================== 
  // Description:   return string containing all errors
  // Parameters: 		none
  // Returns:       string
  // ====================================================================== 
	var sFunctionName = "GenericRegexValidator.getErrorText" ;
	
	try {
		debugMessage("Entering " + sFunctionName, 1) ;

		debugMessage("Leaving " + sFunctionName + " this.ErrorMsg = " + this.ErrorMsg, -1) ;

		return this.ErrorMsg;
	} catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
	}
}

GenericRegexValidator.prototype.getHelpText = function() {
  // ====================================================================== 
  // Description:   Returns help description of the function
  // Parameters: 		None
  // Returns:       String
  // ====================================================================== 
	var sFunctionName = "GenericRegexValidator.getHelpText" ;

  try {
  	
		debugMessage("Entering " + sFunctionName, 1) ; 
    var sDesc = this.ErrorMsg ;

		debugMessage("Leaving " + sFunctionName +" sDesc = " + sDesc, -1) ;
    return sDesc;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

/*
$Log: genericregexvalidator.js,v $
Revision 1.3  2004/03/25 18:04:02  coganp
removed alerts used for testing

Revision 1.2  2004/03/25 17:56:28  coganp
SIR41158 fix.Added GenericRegexValidator:
changed regex's to match for what we want and not what we don't want.
As this works better and is more logical.

Revision 1.1  2004/03/25 14:53:06  coganp
Added GenericRegexValidator:
This requires two parameters to be passed: the regular expression that you are testing for.
and the error help message.


*/
