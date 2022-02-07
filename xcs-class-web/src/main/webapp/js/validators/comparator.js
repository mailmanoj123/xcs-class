// ==========================================================================================
// Date Comparator class dateComparator.
// Version 0.1.
// September 2002.
// Steria AM Ltd.
// Brian Ambrose, Max Bodimeade, Paul Deevoy.
// ==========================================================================================

function Comparator(LHS,sOperator,RHS, sLongName,RHSMandatory) {
  // ======================================================================
  // Description: Compares 2 fields using criteria passed in
  // Parameters:
  //    LHS       - handle to element on the left hand side of the compare
  //    sOperator - operator to test with.
  //    RHS       - handle to element on the right hand side of the compare
  //    RHSMandatory - this will determine whether the right hand date must be populated
  //                   if the first date is populated (at run time).
  // Returns: None
  // ======================================================================
  var sFunctionName= "Comparator.constructor" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    this.LHS           = LHS;
    this.RHS           = RHS;
    this.longName      = sLongName ;
    this.errorLongName = "<br/><strong>The Following Grouping rule has been broken: <br> " + sLongName + "</strong><br/>";
    this.RHSMandatory  = RHSMandatory;

    comparatorSwitch: switch (sOperator) {
      case "=":
        this.sOperator = sOperator ;
        this.sOperatorError = "must be equal to" ;
        break comparatorSwitch;
      case "!=":
        this.sOperator = sOperator ;
        this.sOperatorError = "must not be equal to" ;
        break comparatorSwitch;
      case ">=":
        this.sOperator = sOperator ;
        this.sOperatorError = "must be greater than or equal to" ;
        break comparatorSwitch;
      case "<=":
        this.sOperator = sOperator ;
        this.sOperatorError = "must be less than or equal to" ;
        break comparatorSwitch;
      case ">":
        this.sOperator = sOperator ;
        this.sOperatorError = "must be greater than" ;
        break comparatorSwitch;
      case "<":
        this.sOperator = sOperator ;
        this.sOperatorError = "must be less than" ;
        break comparatorSwitch;
      default:
        throw new ErrorObject("Invalid compare operator: "+ sOperator)  ;
    }

    this.uoMessageList = new MessageList() ;

    debugMessage("Leaving " + sFunctionName, -1) ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

Comparator.prototype.isValid = function() {
  // ======================================================================
  // Description:   A class function definition
  // Parameters:
  // Returns:
  // Notes:
  // ======================================================================
  var sFunctionName= "Comparator.isValid()" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    var LHSValue ;
    var LHSLength ;
    var RHSValue ;
    var RHSLength ;

    var bLHSValid;
    var bRHSValid;
    var bReturn ;
		var bCompareError = false ;
    var iCompare= 0;

    this.uoMessageList.clear() ;

    if (this.LHS.constructor == String) {
      LHSValue = this.LHS ;
    } else {
      LHSValue = this.LHS.getUIValue() ;
    }
    LHSLength = LHSValue.length ;
    if (this.RHS.constructor == String) {
      RHSValue = this.RHS ;
    } else {
      RHSValue = this.RHS.getUIValue() ;
    }
    RHSLength = RHSValue.length ;

    // Quick first check. If both fields are empty then just return true.
    if ((LHSLength == 0) && (RHSLength==0))
    {
        // If both dates are empty then do nothing.
        return true;
    }

   // if left hand side hasn't been entered but the right hand side has
   // then flag an error
    if ((LHSLength == 0) && (RHSLength!=0)) {
        this.uoMessageList.add("Second field cannot be entered if first field is blank.<br>");
        return false;
    }

    // If the left hand side has been entered but the right hand side is empty- but the rule
    // is that the right hand side must be populated when the left hand side is populated then error
    if ((LHSLength != 0) && (RHSLength==0) && (this.RHSMandatory == true)) {

            this.uoMessageList.add("Second field must be entered if the first field has been populated.<br>");
            return false;
    }


    // By the time we get to here if the right hand field is blank then there is no need to
    // carry out the compare. Note that the check above will check the right hand fields manditory flag.
    if ((LHSLength != 0) && (RHSLength==0))
    {
        bReturn = true;
    }
    else
    {
        bLHSValid = this.LHS.uoDataValidator.isValid(LHSValue);
        object2test: switch (this.RHS.constructor) {
          case VField:
            bRHSValid = this.RHS.uoDataValidator.isValid(RHSValue);
            break object2test;
          case VGroup:
            bRHSValid = this.RHS.uoDataValidator.isValid(RHSValue);
            break object2test;
          case String:
            bRHSValid = true;
            break object2test;
          default:
            bRHSValid = false;
        }

        if (bLHSValid && bRHSValid) {

					try {
						if (this.RHS.constructor == String) {
							iCompare = this.LHS.uoDataValidator.compare(RHSValue);
						} else {
								iCompare = this.LHS.uoDataValidator.compare(this.RHS.uoDataValidator);
						}
	
						comparatortest: switch (this.sOperator) {
							case "=":
								bReturn = (iCompare == 0 ? true : false);
								break comparatortest;
							case ">=":
								bReturn = (iCompare != -1 ? true : false);
								break comparatortest;
							case "<=":
								bReturn = (iCompare != 1 ? true : false);
								break comparatortest;
							case ">":
								bReturn = (iCompare == 1 ? true : false);
								break comparatortest;
							case "<":
								bReturn = (iCompare == -1 ? true : false);
								break comparatortest;
							case "!=":
								bReturn = (iCompare != 0 ? true : false);
								break comparatortest;
							default:
								throw new ErrorObject("Invalid compare operator: "+ this.sOperator)  ;
						}
					} catch (e) {
						// An exception occurred during the compare - report it.
						if (e.bSevereError) {
							throw e ;
						} else {
							bReturn = false ;
							bCompareError = true ;
							this.uoMessageList.add(e.description) ;
						}
					}
        } else {
          bReturn = false ;
          this.uoMessageList.add("One of the fields in the compare is invalid. The " +  this.LHS.longName +  " " + this.sOperatorError + " the " +  this.RHS.longName);
        }

        if (bLHSValid && bRHSValid && !bReturn) {
          this.uoMessageList.add(
						(bCompareError ? " This error occurred when checking that: " : "") +
            this.LHS.longName + " " +
            this.sOperatorError + " " +
            (this.RHS.constructor == String ? RHSValue : this.RHS.longName)
          )
        }

        debugMessage("Leaving " + sFunctionName + ", Returning: " + bReturn, -1) ;
    }

    return bReturn ;

  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

// ======================================================================
// Description:   A class function definition
// Parameters:
// Returns:
// Notes:
// ======================================================================
Comparator.prototype.getHelpText = function() {
  var sFunctionName= "Comparator.getHelpText()" ;

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    var sDesc ;

    sDesc = "Comapares 2 fields against each other.";
    sDesc = "\n" + "Returns the relationship of field2 to field1";
    sDesc = "\n" + "Valid Comparisons are :- >,<,=,>=,<=,!=,gt,lt,equals,gte,lte or ne";

    debugMessage("Leaving " + sFunctionName, -1) ;
    return sDesc;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

// ======================================================================
// Description:   A class function definition
// Parameters:
// Returns:
// Notes:
// ======================================================================
Comparator.prototype.getErrorText = function() {
  var sFunctionName= "Comparator.getErrorText()" ;
  try {
    debugMessage("Entering " + sFunctionName, 1) ;

    debugMessage("Leaving " + sFunctionName, -1) ;
    return this.uoMessageList.toString();
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}