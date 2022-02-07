// ==========================================================================================
// Null validator class NullValidator.
// Version 0.1.
// March 2004.
// Xchanging.
// Patrick Cogan.
// Created for fix to SIR 41158
// ==========================================================================================

function NullValidator(iFormat){
	// ====================================================================== 
	// Description: Does no validation at all 
	// Parameters:  
	//    iFormat  - case format identifier , uses VField constants
	// Returns:			Nothing
	// ====================================================================== 
	var sFunctionName = "NullValidator.constructor" ;

  try {
		debugMessage("Entering " + sFunctionName, 1) ;

    // Store initial values
    this.Value    = "";
    this.Format   = iFormat;

    // Set up error message array array
    this.Errors   = new MessageList();

		debugMessage("Leaving " + sFunctionName, -1) ;
	} catch(e) {
		e.description+= "\n"+ sFunctionName ;
		throw e ;
  }
}

NullValidator.prototype.isValid = function(sValue) {
  // ====================================================================== 
  // Description:   check valid alpha A-Z
  // Parameters:    None
  // Returns:       boolean
  // ====================================================================== 
	var sFunctionName = "NullValidator.isValid()" ;
		debugMessage("Entering " + sFunctionName, 1) ;
		debugMessage("Leaving " + sFunctionName, -1) ;
		return true;
}

NullValidator.prototype.compare = function(vInput) {
  // ====================================================================== 
  // Description:   Compare this string to another passed in
  // Parameters:    vInput - value to be compared against
  // Returns:       Integer  - either 0,1 or -1
  // Notes:         Can be compared against either a string or an object
  //                of type AlphaValidator, AlphaExtendedValidator or
	//								AlphaNumericValidator
  // ====================================================================== 
	var sFunctionName= "NullValidator.compare()" ;

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


NullValidator.prototype.getValue = function() {
  // ====================================================================== 
  // Description:   Returns value to be validated
  // Parameters: 		None
  // Returns:       String to be validated
  // ====================================================================== 
	var sFunctionName = "NullValidator.getValue" ;
  try {
		debugMessage("Entering " + sFunctionName, 1) ;

		debugMessage("Leaving " + sFunctionName, -1) ;
		return this.Value;
  } catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
  }
}


NullValidator.prototype.getErrorText = function() {
  // ====================================================================== 
  // Description:   return string containing all errors
  // Parameters: 		none
  // Returns:       string
  // ====================================================================== 
	var sFunctionName = "NullValidator.getErrorText" ;
	
	try {
		debugMessage("Entering " + sFunctionName, 1) ;

		debugMessage("Leaving " + sFunctionName, -1) ;
		return this.Errors.toString();
	} catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
	}
}

NullValidator.prototype.getHelpText = function() {
  // ====================================================================== 
  // Description:   Returns help description of the function
  // Parameters: 		None
  // Returns:       String
  // ====================================================================== 
	var sFunctionName = "NullValidator.getHelpText" ;

  try {
		debugMessage("Entering " + sFunctionName, 1) ;
    var sDesc = "This is a validator that alows anything. For use when you are forced to use a validator but don't want one." ;

		debugMessage("Leaving " + sFunctionName, -1) ;
    return sDesc;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

/*
  $Log: nullvalidator.js,v $
  Revision 1.1  2004/03/23 16:53:24  coganp
  fixed for SIR 41158
  Added validation type of null (no validation done).

  
*/