// Decimal validator class DecimalValidator.
// Version 0.1.

// September 2002.

// Steria AM Ltd.
// Brian Ambrose, Max Bodimeade, Paul Deevoy.

function DecimalValidator(iInts,iDps,bLeadingZeros,bSign,bNoCommas,oUIObject){
// ======================================================================
// Description: Checks a string is a valid alphanumeric A-Z or 0-9
// Parameters:
//            Ints          - Maximun number of places before decimal
//            Dps           - Maximum number after decimal places
//            LeadingZeros  - are leading zeros allowed (boolean)
//            Sign          - is the number signed (boolean)
// Returns:
// Notes:
// ======================================================================

debugMessage("Entering DecimalValidator constructor",1) ;
  try {
    // ========================================
    // store initial values
    // set up error message array array
    // ========================================

      this.Value        = "";
      this.Ints         = iInts;
      this.Dps          = iDps;
      this.LeadingZeros = bLeadingZeros;
      this.Sign         = bSign;
      this.NoCommas     = bNoCommas;
      this.uoUIObject   = oUIObject;
      this.Errors       = new MessageList();
      this.regexpFailed = "";    // Used to differentiate which regular expression failed

  } catch(e) {
        e.description += "\nDecimalValidator.constructor" ;
        throw e ;
  }
  debugMessage("Leaving DecimalValidator constructor",-1) ;
}

DecimalValidator.prototype.isValid = function(sValue) {
// ======================================================================
// Description:   check valid numeric with decimal places
// Parameters:
// Returns:       boolean
// Notes:
// ======================================================================

debugMessage("Entering DecimalValidator isValid",1) ;
  try {
    // ========================================
    // clear down error store
    // store value to be validated
    // calculate regular expression required
    // test regular expression and return result
    // ========================================

      this.Errors.clear();

// Add decimal place if none entered so it can be validated against regular expression
/*      if (sValue.indexOf(".") == -1)
        this.Value    = removeCommas(sValue) + ".";
      else*/

      this.Value    = removeCommas(sValue);
/*
      // if expecting a sign add a + to the front if no sign entered
      if (this.Sign && this.Value.substr(0,1) != "+" && this.Value.substr(0,1) != "-")
        this.Value = "+" + this.Value;

      var sExpression;
      var iStart;

      this.regexpFailed = "";

      // Check characters are valid (before checking digits before/after decimal point)
      if (this.Sign) {
        sExpression = "^[+-]\\d{1,}.\\d{0,}$";
        iStart  = 1;
      } else {
        sExpression = "^\\d{1,}.\\d{0,}$";
        iStart  = 0;
      }

      var re = new RegExp(sExpression);

      if (!re.test(this.Value)) {
          this.Errors.add("string contains invalid characters");
          this.regexpFailed="1";
          return false;
      }

      if (this.Sign) {
        sExpression = "^[+-]\\d{1," + this.Ints + "}.\\d{0," + this.Dps + "}$";
        iStart  = 1;
      } else {
        sExpression = "^\\d{1," + this.Ints + "}.\\d{0," + this.Dps + "}$";
        iStart  = 0;
      }

      var re = new RegExp(sExpression);

      if (!re.test(this.Value)) {
          this.Errors.add("string contains invalid characters");
          this.regexpFailed="2";
          return false;
      }*/

      if (isNaN(this.Value)) {
        this.Errors.add("Not a valid number.");
        return false;
      }

      var number;
      var decimal;
      var isNegative = Number(this.Value)<0;
      var wholeNumber;

      if (isNegative && !this.Sign) {
        this.Errors.add("This number cannot be negative.");
        return false;
      }

      if (isNegative)
        wholeNumber = this.Value.substring(1);
      else
        wholeNumber = this.Value;

      if (wholeNumber.indexOf(".")!=-1) {
        number = wholeNumber.substring(0,wholeNumber.indexOf("."));
        decimal = wholeNumber.substring(wholeNumber.indexOf(".")+1);
      }
      else {
        number = wholeNumber;
        decimal = "";
      }

      if (number.length>this.Ints) {
        this.Errors.add("Too many digits before decimal point. Max " + this.Ints + ".");
        return false;
      }

      if (decimal.length>this.Dps) {
        this.Errors.add("Too many digits after decimal point. Max " + this.Dps + ".");
        return false;
      }

      if (!this.LeadingZeros && wholeNumber.substr(0,1) == "0" && wholeNumber.substr(1,2) != ".") {
        this.Errors.add("string contains invalid leading zeros");
        return false;
      }

      if (!this.NoCommas && this.uoUIObject.type!=null && this.uoUIObject.type!="select-one")
        this.uoUIObject.value = insertCommas(this.Value);

      return true;

} catch(e) {
    e.description += "\nDecimalValidator.isValid" ;
    throw e ;
  }
debugMessage("Leaving DecimalValidator isValid",-1) ;
}

DecimalValidator.prototype.compare = function(vInput) {
  // ======================================================================
  // Description:   compare this string to another passed in
  // Parameters:    vInput - value to be compared against
  // Returns:       integer  - either 0,1 or -1
  // Notes:         can be compared against either a string or an object
  //                of type NumericValidator or DecimalValidator
  // ======================================================================

debugMessage("Entering DecimalValidator compare",1) ;
  try {

    // ========================================
    // check either a string or another valid object
    // compare returning appropiate value
    // 0 = equals, 1 = greater than, 2 = less than
    // ========================================

    var iAmount1      = parseFloat(this.getValue());
    var iAmount2 ;
    var iReturn;

    instance : switch (vInput.constructor) {

                  case String:
                    iAmount2     = parseFloat(vInput);
                    break instance;

                  case NumericValidator:
                  case DecimalValidator:
                    iAmount2 = parseFloat(vInput.getValue());
                    break instance;

                  default:
                 //   this.Errors.add("Invalid type passed in");
                    // throw error
                    throw "DecimalValidator.compare Invalid type passed in";
                   // return -999;
                }

    if (iAmount1 == iAmount2)
      iReturn = 0;
    else {
          if (iAmount1 > iAmount2)
            iReturn = 1;
          else
            iReturn = -1;
          }

    return iReturn;
  } catch(e) {
    e.description += "\nDecimalValidator.compare" ;
    throw e ;
  }
debugMessage("Leaving DecimalValidator compare",-1) ;
}

DecimalValidator.prototype.getValue = function() {
  // ======================================================================
  // Description:   Returns value to be validated
  // Parameters:
  // Returns:       String to be validated
  // Notes:
  // ======================================================================

debugMessage("Entering DecimalValidator getValue",1) ;
  try {
          return this.Value;

  } catch(e) {
    e.description += "\nDecimalValidator.getValue>" ;
    throw e ;
  }
  debugMessage("Leaving DecimalValidator getValue",-1) ;
}


DecimalValidator.prototype.getErrorText = function() {
  // ======================================================================
  // Description:   return string containing all errors
  // Parameters:
  // Returns:       string
  // Notes:
  // ======================================================================

debugMessage("Entering DecimalValidator getErrorText",1) ;
  try {
          return this.Errors.toString();

  } catch(e) {
    e.description += "\nDecimalValidator.getErrorText>" ;
    throw e ;
  }
  debugMessage("Leaving DecimalValidator getErrorText",-1) ;
}

DecimalValidator.prototype.getHelpText = function() {
  // ======================================================================
  // Description:   returns help description of the function
  // Parameters:
  // Returns:       string
  // Notes:
  // ======================================================================

debugMessage("Entering DecimalValidator getHelpText",1) ;
  try {
    var sDesc ;

		sDesc = "" ;

                if ( this.regexpFailed=="1" ) {
                  // Characters not valid
                  sDesc="Must be a valid number: Only digits and a decimal point may be entered.";
                  if (!this.Sign) {
                      sDesc += "\nNo sign can be entered.";
                  } else {
                      sDesc += "\nA sign can be entered.";
                  }
                  return sDesc;
                }

		if (this.iDps == 0) {
	    sDesc = "Must be a whole number with no more than " + this.Dps + "digits."  ;
		} else {
	    sDesc =  "No more than " + this.Ints  + " digits before the decimal point." ;
			sDesc += "\n  No more than " + this.Dps + " digits after the decimal point." ;
		}
		if (!this.Sign) {
    	sDesc += "\nNo sign can be entered.";
		}
		if (!this.LeadingZeros) {
    	sDesc += "\nNo leading zeroes can be entered.";
		}

    return sDesc;
  } catch(e) {
    e.description += "\nDecimalValidator.getHelpText" ;
    throw e ;
  }
   debugMessage("Leaving DecimalValidator getHelpText",-1) ;
  }
