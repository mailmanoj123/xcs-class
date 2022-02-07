// ==========================================================================================
// Validated Field class VField.
// Version 0.1.
// September 2002.
// Steria Ltd.
// Brian Ambrose, Paul Deevoy, Max Bodimeade.
//
// Ins-sure Ltd
// Patrick Cogan.
//
// See end of file for change log
//
// ==========================================================================================

// Constants for Types
VField.TYPE_ALPHA = 0;
VField.TYPE_ALPHANUMERIC= 1;
VField.TYPE_DATE= 2;
VField.TYPE_NUMERIC= 3;
VField.TYPE_TEXT = 4;
VField.TYPE_TIME= 5;
// Patrick Cogan: Added to fix SIR 41134
VField.TYPE_RESTRICTED_NUMERIC= 6;
// Patrick Cogan: Added for fix of SIR: 41158
VField.TYPE_REGEX_VALIDATION= 7;
// Patrick Cogan: Added for fix of SIR: 41158
VField.TYPE_NULL_VALIDATION= 8;

// Constants for Check Attributes
VField.CHECK_CASE= 1000;
VField.CHECK_DECIMAL_PLACES= 1001;
VField.CHECK_FORMAT= 1002;
VField.CHECK_LINES_MAXIMUM= 1003;
VField.CHECK_LINES_MINIMUM= 1004;
VField.CHECK_MANDATORY= 1005;
VField.CHECK_NUMERIC_PLACES= 1006;
VField.CHECK_SIGNED= 1007;
VField.CHECK_VALIDATOR_DATA= 1008;
VField.CHECK_VALIDATOR_KEYPRESS= 1009;
VField.CHECK_VALUE_MAXIMUM= 1010;
VField.CHECK_VALUE_MINIMUM= 1011;
VField.CHECK_WIDTH_MAXIMUM= 1012;
VField.CHECK_WIDTH_MINIMUM= 1013;
VField.CHECK_WIDTH_OPTIONAL_EXACT= 1014;
VField.CHECK_NO_COMMAS= 1015;

// Constants for Format Attributes
VField.FORMAT_CASE= 2000;
VField.FORMAT_STYLE_CORRECT= 2001;
VField.FORMAT_STYLE_ERROR= 2002;
VField.HELP_TEXT= 2003;
VField.LONG_NAME= 2004;
VField.FORMAT_OTHER= 2005;

// Constants for Attribute Values
VField.CASE_IGNORE= 3000;
VField.CASE_LOWER= 3001;
VField.CASE_UPPER= 3002;
VField.MANDATORY= 3003;
VField.OPTIONAL= 3004;
VField.SIGNED= 3005;
VField.SIGNED_BRACKETS= 3006;
VField.SIGNED_NEGATIVE= 3007;
VField.SIGNED_POSITIVE= 3008;
VField.SCM_CHARACTERS= 3009;

// Constants for regEx validator
VField.REGEX = 4001; 
VField.REGEX_ERROR_MSG = 4002;

// Constructor
function VField(uoUIObject, iType) {
  // ======================================================================
  // Description: Validated Field Constructor
  // Parameters:
  //   uoUIObject: JS object representing the HTML Input field.
  //   iType: data type to validate (Date, number etc.)
  // Returns: Nothing
  // Notes:
  //   Paramater list can be any length.  3rd and subsequent parameters must
  //   be in pairs.  The first of each pair is the name of the property to
  //   set.  The second of each pair contains the value for the property.
  //   eg WIDTH_MINIMUM, 5, WIDTH_MAXIMUM, 20
  // ======================================================================
  var sFunctionName = "VField.constructor" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;
    // ========================================
    // Store mandatory parameters
    // ========================================
    // Handle to the JS object representing the HTML input field
    if (uoUIObject==null)
      throw new ErrorObject("A handle to a valid input object must be supplied");
    else
      this.uoUIObject= uoUIObject ;

    // Data type to validate (Date, number etc.))
    this.iType = iType ;

    // ========================================
    // Get optional parameters
    // ========================================
    this.initialiseOptionalProperties() ;
    this.parseParameters(arguments) ;
    this.uoVGroup = null;
    // ========================================
    // Create a data validator
    // ========================================
    debugMessage("about to switch this.iType, iType = " + this.iType) ;
   
    validatorSwitch: switch (this.iType) {
      case VField.TYPE_ALPHA:
        this.uoDataValidator = new AlphaValidator(this.checkCase) ;
        break validatorSwitch ;
      case VField.TYPE_ALPHANUMERIC:
        this.uoDataValidator = new AlphaNumericValidator(this.checkCase) ;
        break validatorSwitch ;
      case VField.TYPE_ALPHAEXTENDED:
        this.uoDataValidator = new AlphaExtendedValidator() ;
        break validatorSwitch ;
      case VField.TYPE_DATE:
        if (this.checkFormat==false)
          throw new ErrorObject("An input format must be supplied for date fields") ;
        else
          this.uoDataValidator = new DateValidator(this.checkFormat) ;
        break validatorSwitch ;
      case VField.TYPE_NUMERIC:
        if (this.checkDecimalPlaces == false) {
          this.uoDataValidator = new NumericValidator(this.checkNumericPlaces,this.checkNoCommas,this.uoUIObject) ;
          if (this.checkNumericPlaces!=false) {
            var maxLength = this.checkNumericPlaces;
            if (!this.checkNoCommas)
              maxLength += Math.floor(this.checkNumericPlaces/3);
            if (this.checkSigned != false)
              maxLength++ ;
            this.uoUIObject.maxLength = maxLength;
          }
        } else {
          this.uoDataValidator = new DecimalValidator(this.checkNumericPlaces, this.checkDecimalPlaces, true, this.checkSigned, this.checkNoCommas, this.uoUIObject) ;
          // Set the maximum input field width to numeric places + decimal places + 1.
          // The extra 1 allows for a decimal point.
          var maxLength = this.checkNumericPlaces + this.checkDecimalPlaces + 1;
          if (!this.checkNoCommas)
            maxLength += Math.floor(this.checkNumericPlaces/3);
          if (this.checkSigned != false)
            maxLength++ ;
          this.uoUIObject.maxLength = maxLength;

          // adding trailing zeros as attunity strips them off
          if (this.uoUIObject.type=="text") {
            var val = this.uoUIObject.value;
            if (val=="")
              val = "0";

            if (val.indexOf(".")<0)
              val += ".";

            while ((val.length-(val.indexOf(".")+1))<this.checkDecimalPlaces)
              val += "0";

            this.uoUIObject.value = val;
          }
        }
        if (!this.checkNoCommas && this.uoUIObject.type!="select-one")
          this.uoUIObject.value = insertCommas(this.uoUIObject.value);
        break validatorSwitch ;
        
        // Added to fix SIR 41134
      case VField.TYPE_RESTRICTED_NUMERIC:
          this.uoDataValidator = new RestrictedNumericValidator(this.checkNumericPlaces,this.checkNoCommas,this.uoUIObject) ;
          if (this.checkNumericPlaces!=false) {
            var maxLength = this.checkNumericPlaces;
            if (!this.checkNoCommas)
              maxLength += Math.floor(this.checkNumericPlaces/3);
            if (this.checkSigned != false)
              maxLength++ ;
            this.uoUIObject.maxLength = maxLength;
          }
        if (!this.checkNoCommas && this.uoUIObject.type!="select-one")
          this.uoUIObject.value = insertCommas(this.uoUIObject.value);
        break validatorSwitch ; 
    	// Patrick Cogan:SIR41158 fix.
      case VField.TYPE_REGEX_VALIDATION:
        this.uoDataValidator = new GenericRegexValidator(this.regexp, this.regexErrorMsg) ;
        break validatorSwitch ;
      case VField.TYPE_NULL_VALIDATION:
        this.uoDataValidator = new NullValidator(this.checkCase) ;
        break validatorSwitch ;
      case VField.TYPE_TEXT:
        break validatorSwitch ;
      case VField.TYPE_TIME:
        break validatorSwitch ;
      default:
        throw new ErrorObject("Unrecognised field data type.") ;
    }
    // Store a reference to this VField in the validator
    this.uoDataValidator.uoVField= this ;

    // ========================================
    // Initialise internal members
    // ========================================
    // Data parser messages
    this.uoMessageList = new MessageList();

    // ========================================
    // Store a reference to this VField in the
    // input object and set its event handlers
    // ========================================
    // Store a reference to this object in the JS HTML Input field object
    uoUIObject.uoVField = this ;

    // Register event handlers with the JS HTML Input field object
    uoUIObject.onblur   = function() {uoUIObject.uoVField.onblur_Handler()}
    uoUIObject.onhelp   = function() {return uoUIObject.uoVField.onhelp_Handler()}

    debugMessage("Leaving " + sFunctionName + " -- " + uoUIObject.name, -1) ;
  } catch(e) {
    /*e.description += "\n" + sFunctionName + "(" ;
    if (uoUIObject==null) e.description +="null" ;  e.description += uoUIObject.name ;
    e.description += ")." ;
    throw e ;*/
    alert(arguments[3] + " does not exist.");
  }
}

VField.prototype.initialiseOptionalProperties = function() {
  // ======================================================================
  // Description: Initialises all optional class properties
  // Parameters:  None
  // Returns:     Nothing
  // ======================================================================
  var sFunctionName= "VField.initialiseOptionalParameters"

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    // ========================================
    // optional properties for input checking
    // ========================================
    // Mandatory data value
    this.checkMandatory= false ;
    // Maximum number of input characters (data width)
    this.checkWidthMaximum= false ;
    // Minimum number of input characters (data width)
    this.checkWidthMinimum= false ;
    // Optional, but exact width if data entered
    this.checkWidthOptionalExact= false ;
    // Input format checking, eg dd/mm/ccyy
    this.checkFormat= false ;
    // Case checking - eg uppercase, lower case, ignore.
    this.checkCase= VField.CASE_IGNORE ;
    //  Decimal, Numeric Places and Sign
    this.checkDecimalPlaces = false ;
    this.checkNumericPlaces = false ;
    this.checkSigned = false ;
    // Minimum and maximum value width
    this.checkValueMinimum = false ;
    this.checkValueMaximum = false ;
    // Data validator - dependant on the data type of this field
    this.uoDataValidator= false ;
    // Custom validator
    this.checkValidatorData= false ;
    // No commas
    this.checkNoCommas = false;

    // ========================================
    // optional properties for formatting input
    // ========================================
    // Case formatting
    this.formatCase = VField.CASE_IGNORE ;
    // Other formatting - eg conversion of SCM characters.
    this.formatOther = false ;
    // Default Styles for correct and incorrect values
    this.formatStyleCorrect= "field" ;
    this.formatStyleError= "fieldError" ;
    // Default this object's name to that of the UI control
    this.longName= this.uoUIObject.name ;
    this.errorLongName = "Control Name: " + this.uoUIObject.name + "<br/>";
    // Default extended help text to false
    this.helpText= false ;
    
    // ===============================================
    // Patrick Cogan
    // Optional parameters for geneic regex validation
    // ===============================================
    this.regexp = "";
    this.regexErrorMsg = "";

    debugMessage("Leaving " + sFunctionName, -1) ;
  } catch(e) {
    e.description += "\nVField.initialiseOptionalProperties." ;
    throw e ;
  }
}

VField.prototype.parseParameters = function(uoArguments) {
  // ======================================================================
  // Description:
  //   Looks at the constructor parameter list and strips out the optional
  //   name / value parameter pairs.
  // Parameters:
  //   uoArguments - an array of arguments.  Usually the function.argument
  //   object from a previous call would be passed in.
  // Returns:  Nothing
  // ======================================================================
  var sFunctionName= "VField.parseParameters"

  try {
    debugMessage("Entering " + sFunctionName, 1) ;
    // ========================================
    // Parse optional parameters
    // ========================================
    // If there are no optional parameters, do nothing.
    if (uoArguments.length==2) return ;

    // Make sure there are an even number of parameters, a simple check
    // value name and argument pairs have been used.
    if ((uoArguments.length % 2)==1)
      throw new ErrorObject("VField must have an even number of parameters") ;

    // Iterate optional parameters.
    argumentsLoop: for (i=2; i < uoArguments.length; i += 2) {
      value=uoArguments[i+1] ;
      argumentsSwitch: switch (uoArguments[i]) {
        case VField.CHECK_MANDATORY:
          // Mandatory and optional exact are mutually exclusive
          if (this.checkWidthOptionalExact != false)
            throw new ErrorObject("A field cannot be specified as both optional and mandatory") ;
          this.checkMandatory= value ;
          break argumentsSwitch ;

        case VField.CHECK_WIDTH_MAXIMUM:
          // Maximum width and optional exact are mutually exclusive
          if (this.checkWidthOptionalExact != false)
            throw new ErrorObject("A field cannot be specified as both optional exact and having a maximum width") ;
          this.checkWidthMaximum= value ;
          // Set maximum width attribute on the input object
          if (this.uoUIObject.type=="textarea") {
            var abc = value;
            this.uoUIObject.onkeyup=function b() {eval("if (this.value.length>" + abc + ") this.value=this.value.substring(0," + abc + ");");};
          } else
            this.uoUIObject.maxLength= value ;
          break argumentsSwitch ;

        case VField.CHECK_WIDTH_MINIMUM:
          // Minimum width and optional exact are mutually exclusive
          if (this.checkWidthOptionalExact != false)
            throw new ErrorObject("A field cannot be specified as both optional exact and having a minimum width") ;
          this.checkWidthMinimum= value ;
          break argumentsSwitch ;

        case VField.CHECK_WIDTH_OPTIONAL_EXACT:
          if ((this.checkMandatory != false) ||
              (this.checkWidthMinimum != false) ||
              (this.checkWidthMaximum != false)
          ) throw new ErrorObject("A field cannot be specified as both optional exact and mandatory/minimum/maximum width") ;
          this.checkWidthOptionalExact= value ;
          // Set maximum width attribute on the input object
          this.uoUIObject.maxLength= value ;
          break argumentsSwitch ;

        case VField.CHECK_VALUE_MINIMUM:
          this.checkValueMinimum= value ;
          break argumentsSwitch ;

        case VField.CHECK_VALUE_MAXIMUM:
          this.checkValueMaximum= value ;
          break argumentsSwitch ;

        case VField.CHECK_DECIMAL_PLACES:
          this.checkDecimalPlaces = value ;
          break argumentsSwitch ;

        case VField.CHECK_NUMERIC_PLACES:
          this.checkNumericPlaces = value ;
          break argumentsSwitch ;

        case VField.CHECK_NO_COMMAS:
          this.checkNoCommas = value ;
          break argumentsSwitch ;

        case VField.CHECK_SIGNED:
          this.checkSigned = value ;
          break argumentsSwitch ;

        case VField.CHECK_FORMAT:
          this.checkFormat= value ;
          break argumentsSwitch ;

        case VField.CHECK_CASE:
          this.checkCase= value ;
          break argumentsSwitch ;

        case VField.CHECK_VALIDATOR_DATA:
          this.checkValidatorData= value ;
          break argumentsSwitch ;

        case VField.FORMAT_CASE:
          this.formatCase= value ;
          break argumentsSwitch ;

        case VField.FORMAT_OTHER:
          this.formatOther= value ;
          break argumentsSwitch ;

        case VField.FORMAT_STYLE_ERROR:
          this.formatStyleError= value ;
          break argumentsSwitch ;

        case VField.FORMAT_STYLE_CORRECT:
          this.formatStyleCorrect= value ;
          break argumentsSwitch ;

        case VField.LONG_NAME:
          this.longName= value ;
          this.errorLongName = "<br/><strong>Control Name: " + value + "<br/>Reason(s): </strong><br/>";
          break argumentsSwitch ;

        case VField.HELP_TEXT:
          this.helpText= value ;
          break argumentsSwitch ;
          
        case VField.REGEX:
          this.regexp= value ;
          break argumentsSwitch ;
          
        case VField.REGEX_ERROR_MSG:
          this.regexErrorMsg= value ;
          break argumentsSwitch ;
          
        default:
          throw new ErrorObject("Unknown attribute type") ;
      }
    }

    debugMessage("Leaving " + sFunctionName, -1) ;
  } catch(e) {
    e.description += "\nVField.parseParameters." ;
    throw e ;
  }
}

VField.prototype.isValid= function(bSetStyle) {
  // ======================================================================
  // Description: Validates the contents of an input field
  // Parameters:
  //   bSetStyle - boolean.
  //     Should the style of the input field be updated as a result of
  //     this check.
  // Returns: boolean.
  // ======================================================================
  var sFunctionName= "VField.isValid"

  try {
    debugMessage("Entering " + sFunctionName + " for " + this.longName, 1) ;

    bValid = true ;

    if ((this.uoUIObject.readOnly==true) || (this.uoUIObject.disabled==true) || ((this.uoUIObject.type!=null) && (this.uoUIObject.type=="hidden"))) {
      debugMessage("Field readonly - not validating.");
      return true;
    }

    this.uoMessageList.clear() ;
    value = this.getUIValue() ;

    checks: for (var i=0; i<1; i++) {
      if (this.checkMandatory) {
        if (value.length == 0) {
          bValid = false ;
          this.uoMessageList.add("You must enter " + this.longName + " value.<br/>")  ;
          break checks ;
        }
      }

      if (this.checkWidthOptionalExact) {
        if ((value.length > 0) && (value.length != this.checkWidthOptionalExact)) {
          bValid = false ;
          this.uoMessageList.add("You must enter exactly " + this.checkWidthOptionalExact + " characters.") ;
          break checks ;
        }
      }

      if (this.checkWidthMinimum) {
        if ((value.length > 0) && (value.length < this.checkWidthMinimum)) {
          bValid = false ;
          this.uoMessageList.add(this.longName + " must be at least " + this.checkWidthMinimum + " characters in length.") ;
          break checks ;
        }
      }

      if (this.checkWidthMaximum) {
        if (value.length > this.checkWidthMaximum) {
          bValid = false ;
          this.uoMessageList.add(this.longName + " must be no more than " + this.checkWidthMaximum + " characters in length.") ;
          break checks ;
        }
      }

      // If we have reached this stage, no minimum entry width or mandatory rules have been broken.
      // If there is no data entered, there is no point checking against data value rules
      if (value.length == 0) break checks ;

      // If there is a data validator
      if (this.uoDataValidator!= null) {
        debugMessage("Checking data validator") ;
        if (this.uoDataValidator.isValid(this.getUIValue()) == false) {
          bValid = false ;
          this.uoMessageList.add(this.uoDataValidator.getHelpText().toString()) ;
          break checks ;
        }
      }

      // There is a valid value.  Apply any minimum or maximum value checks
      if (this.checkValueMinimum != false) {
        if(this.uoDataValidator.compare(this.checkValueMinimum) < 0) {
          bValid = false ;
          this.uoMessageList.add(this.longName + " must be no less than " + this.checkValueMinimum + ".") ;
          break checks ;
        }
      }

      if (this.checkValueMaximum != false) {
        if(this.uoDataValidator.compare(this.checkValueMaximum) > 0) {
          bValid = false ;
          this.uoMessageList.add(this.longName + " must be no more than " + this.checkValueMaximum + ".") ;
          break checks ;
        }
      }

      // Apply any custom checking.
      if (this.checkValidatorData != false) {
        if (this.checkValidatorData.isValid() == false) {
          bValid = false ;
          this.uoMessageList.add(this.checkValidatorData.getHelpText()) ;
          break checks ;
        }
      }
    } // checks label ends

    if (bSetStyle) this.setStyle(bValid) ;

    debugMessage("Leaving " + sFunctionName + " rtn value = " + bValid, -1) ;

    return bValid
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

VField.prototype.setStyle= function(bValid) {
  // ======================================================================
  // Description: Change the CSS style of an input field
  // Parameters:
  //   bValid - Should the field be set to a valid or invalid state
  // Returns: Nothing
  // ======================================================================
  var sFunctionName= "VField.setStyle"

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    if (bValid) {
      this.uoUIObject.className=this.formatStyleCorrect
    } else {
      this.uoUIObject.className= this.formatStyleError
    }

    debugMessage("Leaving " + sFunctionName, -1) ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

VField.prototype.getUIValue= function() {
  // ======================================================================
  // Description: Gets the current contents of the input field.
  // Parameters: None
  // Returns: The current contents of the input field.
  // ======================================================================
  var sFunctionName= "VField.getUIValue"

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    debugMessage("Leaving " + sFunctionName, -1) ;

    if (this.uoUIObject.type.substr(0, 6).toLowerCase=="select")
      return this.uoUIObject.options[this.uoUIObject.selectedIndex].text;
    else
      return Trim(this.uoUIObject.value);

  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

VField.prototype.setUIValue= function(sNewValue) {
  // ======================================================================
  // Description: Sets the contents of the input field
  // Parameters:
  //   sNewValue - The value to set the input field to
  // Returns: Nothing
  // ======================================================================
  var sFunctionName= "VField.setUIValue"

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    this.uoUIObject.value = sNewValue ;

    debugMessage("Leaving " + sFunctionName, -1) ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

VField.prototype.toString= function() {
  // ======================================================================
  // Description: String representation of the field
  // Parameters: None
  // Returns: The current contents of the input field
  // Notes:
  // ======================================================================
  var sFunctionName= "VField.toString"

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    debugMessage("Leaving " + sFunctionName, -1) ;
    return this.getUIValue()
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

VField.prototype.applyFormat = function() {
  // ======================================================================
  // Description:
  //   Applies formatting rules to the value entered in the field.  For
  //   example, conversion to upper case or a particular date format.
  // Parameters: None
  // Returns: Nothing
  // ======================================================================
  var sFunctionName= "VField.applyFormat" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    var value = this.getUIValue() ;
    if (this.formatCase == VField.CASE_UPPER) {
      this.setUIValue(value.toUpperCase())
    } else if (this.formatCase == VField.CASE_LOWER) {
      this.setUIValue(value.toLowerCase())
    }

    // REMOVED AS CCN #40 WAS WRONG
    /*if (this.formatOther == VField.SCM_CHARACTERS) {
      var sInput        =      this.getUIValue() ;
      var sUpper        =    sInput.toUpperCase() ;
      var sNoColon      =    sUpper.replace(/:/g, ";") ;
      var sNoPlus       =  sNoColon.replace(/\+/g, "&") ;
      var sNoQnMark     =   sNoPlus.replace(/\?/g, ".") ;
      var sNoApostrophe = sNoQnMark.replace(/'/g, "\"") ;
      this.setUIValue(sNoApostrophe)
    }*/

    debugMessage("Leaving " + sFunctionName, -1)
  }
  catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

VField.prototype.onblur_Handler= function() {
  // ======================================================================
  // Description:
  //   Event handler for field losing focus.  Checks the validity of the
  //   field content and applies formatting rules to the content if valid.
  // Parameters: None
  // Returns: Nothing
  // ======================================================================
  var sFunctionName = "VField.onblur_Handler" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    // alert(this.uoVGroup);
    if (this.uoVGroup == null)
    { // Check if this field contains valid data
        var bReturnValue = this.isValid(true) ;

        // If the field contains valid data, apply any formatting necessary
        if (bReturnValue) this.applyFormat() ;

        // If the help popup is shown, then hide it
        if ((this.uoVForm.uoHelpDiv.bShowLayer) && (this.uoVForm.uoHelpDiv.LayerType == 1))
             this.uoVForm.uoHelpDiv.ShowHideLayer("",  this.uoUIObject);
    }
    else
    {
          this.uoVGroup.isValid(true);
    }

    debugMessage("Leaving " + sFunctionName, -1) ;
    return bReturnValue ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

VField.prototype.onhelp_Handler= function() {
  // ======================================================================
  // Description: Event handler for help being activated for this field
  // Parameters: None
  // Returns: false - to ensure the browser does not open its help system
  // ======================================================================
  var sFunctionName = "VField.onhelp_Handler" ;
  var sHelpText = "" ;
  var sMinMaxWidthText = "" ;
  var sMinMaxValText = ""
  try {
    debugMessage("Entering " + sFunctionName, 1) ;
    sHelpText+= "<strong>"+ this.longName + "</strong><br>" ;

    // Put in any custom help text
    if (this.helpText != false) sHelpText += this.helpText + "<p>" ;

    if ((this.checkWidthMinimum != false) || (this.checkWidthMaximum != false)) {
      sHelpText+= "A value with" ;
      if (this.checkWidthMinimum != false) {
        sHelpText+= " at least " + this.checkWidthMinimum ;
        sMinMaxWidthText = " and"
      }
      if (this.checkWidthMaximum != false) {
        sHelpText+= sMinMaxWidthText + " no more than " + this.checkWidthMaximum
      }
      sHelpText += " characters must be entered.<p>"
    } else if (this.checkMandatory != false) {
      sHelpText += "A value must be entered.<p>"
    } else if (this.checkWidthOptionalExact != false) {
      sHelpText += "Exactly " + this.checkWidthOptionalExact + " characters must be entered.<p>"
    }

    if ((this.checkValueMinimum != false) || (this.checkValueMaximum != false)) {
      sHelpText += "The value entered must be " ;
      if (this.checkValueMinimum != false) {
        sHelpText += "no less than " + this.checkValueMinimum ;
        sMinMaxValText = " and"
      }
      if (this.checkValueMaximum != false) {
        sHelpText += sMinMaxValText + " no more than " + this.checkValueMaximum ;
      }
      sHelpText += "."
    }

    if (this.uoDataValidator != null) sHelpText += "<p>" + this.uoDataValidator.getHelpText();

    if (this.uoVGroup != null)
    {
        sHelpText += "<STRONG><br><br> In addition </STRONG> this field is part of a " + this.uoVGroup.getType() + " group whose rules are : <br>";
        sHelpText += this.uoVGroup.uoDataValidator.getHelpText();
    }

    if (!window.event.ctrlKey) {
      this.isValid(false) ;
      this.uoVForm.uoHelpDiv.ShowHideLayer(sHelpText, this.uoUIObject);
    } else {
      this.uoVForm.uoHelpDiv.switchLayer()
    }

    window.event.returnValue='';

    debugMessage("Leaving " + sFunctionName, -1) ;

    return false ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}


VField.prototype.finalise= function() {
  var sFunctionName = "VField.finalise (" + this.longName + ")" ;
  try {
    // Set all references in the DOM object to this VField object to null
    // This ensures that memory is freed.
    this.uoUIObject.uoVField = null ;
    this.uoUIObject.onblur = null ;
    this.uoUIObject.onhelp = null ;
    this.uoUIObject.onkeyup = null ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

/*

$Log: vfield.js,v $
Revision 1.5  2004/03/25 14:49:49  coganp
SIR41158 fix:
added GenericRegexValidator to validate the B field, along with the extra optional fields it needs.

Revision 1.4  2004/03/23 16:52:22  coganp
fixed for SIR 41158
Added validation type of null.

Revision 1.3  2004/03/09 09:54:32  coganp
Fix for SIR 41134
Added case in which in constructor to act for restricter numeric validator.


*/