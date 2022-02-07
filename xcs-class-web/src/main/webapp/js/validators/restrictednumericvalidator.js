// ==========================================================================================
// Restricted numeric validator class RestrictedNumericValidator. Does not alow + or -.
// Version 0.1.
// March 2004.
// Patrick Cogan.
//
// See end of file for change log
//
// ==========================================================================================

function RestrictedNumericValidator(iInts,bNoCommas,oUIObject){
  // ======================================================================
  // Description: Checks a string is a valid Numeric 0-9 
  // Parameters:  None
  // Returns:     Nothing
  // ======================================================================
  var sFunctionName = "RestrictedNumericValidator.constructor" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;  

    // Store initial values
    this.Value = "";
    this.Ints         = iInts;
    this.NoCommas     = bNoCommas;
    this.uoUIObject   = oUIObject;

    // Set up error message array array
    this.Errors   = new MessageList();

    debugMessage("Leaving " + sFunctionName, -1) ;
  } catch(e) {
    e.description+= "\n"+ sFunctionName ;
    throw e ;
  }
}

RestrictedNumericValidator.prototype.isValid = function(sValue) {
  // ======================================================================
  // Description:   check valid Numeric 0-9 with no - or +
  // Parameters:    None
  // Returns:       boolean
  // ======================================================================
  var sFunctionName = "RestrictedNumericValidator.isValid()" ;
  try {
    debugMessage("Entering " + sFunctionName + ": evaluating " + sValue, 1) ;

    var regExp = null ;
    var bReturnValue = true ;

    // Clear down error store
    this.Errors.clear();
    // Store value to be validated
    this.Value  = removeCommas(sValue);

    // Check for a decimal point
    regExp = new RegExp("\\.");
    if (regExp.test(this.Value)) {
      debugMessage("Cannot contain decimal places or a decimal point.") ;
      this.Errors.add("Cannot contain decimal places or a decimal point.") ;
      bReturnValue = false ;
    }

		// Check to see if there is not a + or -
    regExp = new RegExp("\\+-");
    if (regExp.test(this.Value)) {
      debugMessage("Cannot contain a + or - symbol.") ;
      this.Errors.add("Cannot contain a + or - symbol.") ;
      bReturnValue = false ;
    }

    // Check for any non-numeric characters
    regExp = new RegExp("[^\\.0-9]");
    if (regExp.test(this.Value)) {
      debugMessage("Only numeric characters 0-9 can be entered.") ;
      this.Errors.add("Only numeric characters 0-9 can be entered.") ;
      bReturnValue = false ;
    }

    if (this.Ints!=false) {
      var length = this.Value.length;

      if (this.Value.indexOf("-")!=-1)
        length--;

      if (length>this.Ints) {
        debugMessage("Number too large. Maximum of " + this.Ints + " digits allowed.") ;
        this.Errors.add("Number too large. Maximum of " + this.Ints + " digits allowed.") ;
        bReturnValue = false ;
      }
    }

    debugMessage("Leaving " + sFunctionName + ": returning " + bReturnValue, -1) ;

    if (bReturnValue && !this.NoCommas && this.uoUIObject.type!=null && this.uoUIObject.type!="select-one")
      this.uoUIObject.value = insertCommas(this.Value);

    return bReturnValue ;
  } catch(e) {
    e.description+= "\n"+ sFunctionName ;
    throw e ;
  }
}

RestrictedNumericValidator.prototype.compare = function(vInput) {
  // ======================================================================
  // Description:   Compare this string to another passed in
  // Parameters:    vInput - value to be compared against
  // Returns:       Integer  - either 0,1 or -1
  // Notes:         Can be compared against either a string or an object
  //                of type RestrictedNumericValidator
  // ======================================================================
  var sFunctionName= "RestrictedNumericValidator.compare()" ;

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
      case RestrictedNumericValidator:
        sCompareString = vInput.getValue();
        break compareTypeSwitch;
      default:
        throw new ErrorObject("Cannot compare against "+ vInput.constructor);
    }

    // BA - 25/02/2003 - perform numeric compare

    // BA - 25/02/2003 - convert to number
    var fThis = parseFloat(this.Value) ;
    var fCompare = parseFloat(sCompareString) ;

    // BA - 25/02/2003 - check for conversion error
    if (isNaN(fThis))
      throw new ErrorObject("Not a Number: "+ this.Value) ;
    if (isNaN(fCompare))
      throw new ErrorObject("Not a Number: "+ sCompareString) ;

    // compare returning appropiate value
    // 0 = equals, 1 = greater than, -1 = less than
    if (fThis == fCompare)
      iReturn = 0;
    else {
      if (fThis > fCompare)
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


RestrictedNumericValidator.prototype.getValue = function() {
  // ======================================================================
  // Description:   Returns value to be validated
  // Parameters:    None
  // Returns:       String to be validated
  // ======================================================================
  var sFunctionName = "RestrictedNumericValidator.getValue" ;
  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    debugMessage("Leaving " + sFunctionName, -1) ;
    return this.Value;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}


RestrictedNumericValidator.prototype.getErrorText = function() {
  // ======================================================================
  // Description:   return string containing all errors
  // Parameters:    none
  // Returns:       string
  // ======================================================================
  var sFunctionName = "RestrictedNumericValidator.getErrorText" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    debugMessage("Leaving " + sFunctionName, -1) ;
    return this.Errors.toString();
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

RestrictedNumericValidator.prototype.getHelpText = function() {
  // ======================================================================
  // Description:   Returns help description of the function
  // Parameters:    None
  // Returns:       String
  // ======================================================================
  var sFunctionName = "RestrictedNumericValidator.getHelpText" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;
    var sDesc = "" ;
    var sErrors = this.getErrorText() ;

    if (sErrors.length > 0) {
      sDesc = sErrors ;
    } else {
      sDesc = "Only numeric characters (0-9) can be entered." ;
    }

    debugMessage("Leaving " + sFunctionName, -1) ;

    return sDesc;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

/*

$Log: restrictednumericvalidator.js,v $
Revision 1.2  2004/04/02 10:26:59  clintonj
Fixed typo.

Revision 1.1  2004/03/09 09:56:17  coganp
Fix for SIR 41134

This validator check to see if the input is only the number 0 to 9 and doesn't allow plus or minus signs.


*/