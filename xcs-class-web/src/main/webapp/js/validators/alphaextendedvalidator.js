// ==========================================================================================
// AlphaExtended validator class AlphaExtendedValidator.
// Version 0.1.
// September 2002.
// Steria AM Ltd.
// Brian Ambrose, Max Bodimeade, Paul Deevoy.
// ==========================================================================================

function AlphaExtendedValidator(){
  // ======================================================================
  // Description: Checks a string is a valid AlphaExtended A-Z, 0-9 and
  //  EDI extended characters.
  // Parameters:  None
  // Returns:     Nothing
  // ======================================================================
  var sFunctionName = "AlphaExtendedValidator.constructor" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    // Store initial values
    this.Value    = "";

    // Set up error message array array
    this.Errors   = new MessageList();

    // Create a checking regular expression
    // D.Smith - CR 1454 - Remove Double Quotes from list of allowable characters
    this.regExp = new RegExp("[^ A-Za-z0-9\\,\\.\\-\\(\\)\\/\\=\\'\\*\\+\\:\\?\\!\\%\\&\\;\\<\\>\\n\\r\\f]");

    debugMessage("Leaving " + sFunctionName, -1) ;
  } catch(e) {
    e.description+= "\n"+ sFunctionName ;
    throw e ;
  }
}

AlphaExtendedValidator.prototype.isValid = function(sValue) {
  // ======================================================================
  // Description:   check valid AlphaExtended A-Z
  // Parameters:    None
  // Returns:       boolean
  // ======================================================================
  var sFunctionName = "AlphaExtendedValidator.isValid()" ;
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

AlphaExtendedValidator.prototype.compare = function(vInput) {
  // ======================================================================
  // Description:   Compare this string to another passed in
  // Parameters:    vInput - value to be compared against
  // Returns:       Integer  - either 0,1 or -1
  // Notes:         Can be compared against either a string or an object
  //                of type AlphaValidator, AlphaExtendedValidator or
  //                AlphaNumericValidator
  // ======================================================================
  var sFunctionName= "AlphaExtendedValidator.compare()" ;

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


AlphaExtendedValidator.prototype.getValue = function() {
  // ======================================================================
  // Description:   Returns value to be validated
  // Parameters:    None
  // Returns:       String to be validated
  // ======================================================================
  var sFunctionName = "AlphaExtendedValidator.getValue" ;
  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    debugMessage("Leaving " + sFunctionName, -1) ;
    return this.Value;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}


AlphaExtendedValidator.prototype.getErrorText = function() {
  // ======================================================================
  // Description:   return string containing all errors
  // Parameters:    none
  // Returns:       string
  // ======================================================================
  var sFunctionName = "AlphaExtendedValidator.getErrorText" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    debugMessage("Leaving " + sFunctionName, -1) ;
    return this.Errors.toString();
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

AlphaExtendedValidator.prototype.getHelpText = function() {
  // ======================================================================
  // Description:   Returns help description of the function
  // Parameters:    None
  // Returns:       String
  // ======================================================================
  var sFunctionName = "AlphaExtendedValidator.getHelpText" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;
    var sDesc = "" ;

    sDesc+= "Only alpha (A-Z or a-z), numeric (0-9) and any of the characters listed below can be entered:<br>, .- ( ) / = ' * + : ? ! % & ; < >" ;

    debugMessage("Leaving " + sFunctionName, -1) ;
    return sDesc;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

/*
  $Log: alphaextendedvalidator.js,v $
  Revision 1.3  2004/03/23 16:52:50  coganp
  added log

  
*/
