// IfThen class IfThen.
// Version 0.1.

// October 2002.

// Steria AM Ltd.
// Brian Ambrose, Max Bodimeade, Paul Deevoy.

function IfThen(vid1,vValue1,sLongName,vid2) {
  // ======================================================================
  // Description: checks filed 2 if fild 1 set to a particular value
  // Parameters:
  //    vid1      - handle to field1
  //    vValue1   - value to check field1
  //    sLongName - description of the check
  //    vid2      - handle to field2
  //    vValue2   - value to check field1 (optional)
  // Returns:
  // Notes:
  // ======================================================================

  debugMessage("Entering IfThen constructor",1) ;

  try {
    // ========================================
    // Top level comment for large block
    // use what you want, but make it
    // consistent and easily distinguished
    // ========================================


    this.uoMessageList = new MessageList() ;
    this.longName      = sLongName ;
    this.errorLongName = "<br/><strong>The Following Grouping rule has been broken: <br> " + sLongName + "</strong><br/>";

    this.id1            = vid1;
    this.Value1         = vValue1;

    this.id2            = vid2;

    if (arguments.length == 5) {
      this.id2ValueCheck  = true;
      this.Value2         = arguments[4];
    }
    else
      this.id2ValueCheck  = false;

    if (arguments.length > 5)
        throw new ErrorObject("Invalid number of arguments passed " + arguments.length)  ;


  } catch(e) {
    e.description += "\n BooleanEntered.constructor" ;
    throw e ;
  }
    debugMessage("Leaving IfThen constructor",-1) ;
}

IfThen.prototype.isValid = function() {
  // ======================================================================
  // Description:   A class function definition
  // Parameters:
  // Returns:
  // Notes:
  // ======================================================================

debugMessage("Entering IfThen isValid",1) ;

    this.uoMessageList.clear();

    var bValid;

    try {

       if (this.id1.getUIValue().length == 0)
          return true;

       if (!this.Value1=="")
         if (this.id1.getUIValue() != this.Value1)
           return true;

       if (this.id2ValueCheck) {
          if (this.id2.getUIValue() != this.Value2) {
              this.uoMessageList.add(this.id2.longName + "does not have the correct value");
              bValid = false;
          }
          else
            bValid = true;
       }
       else {
          if (this.id2.getUIValue().length == 0) {
              this.uoMessageList.add(this.id2.longName + " must be entered");
              bValid = false;
          }
          else
            bValid = true;
       }

       return bValid;

  } catch(e) {
    e.description += "\nIfThen.isValid>" ;
    throw e ;
  }
    debugMessage("Leaving IfThen isValid",-1) ;
}

IfThen.prototype.getHelpText = function() {
  // ======================================================================
  // Description:   A class function definition
  // Parameters:
  // Returns:
  // Notes:
  // ======================================================================

debugMessage("Entering IfThen getHelpText",1) ;

  try {
    var sDesc ;

    sDesc = "Checks field 2 if a particular value has been entered.";
    sDesc = "\n" + "If " + this.id1.longName + " is " + this.Value1 + "then " + this.id2.longName ;
    sDesc = "\n" + "must be " + ((this.id2ValueCheck)? this.Value2 : "entered.");

    return sDesc;
  } catch(e) {
    e.description += "\nIfThen.getHelpText" ;
    throw e ;
  }
  debugMessage("Leaving IfThen getHelpText",-1) ;
}

IfThen.prototype.getErrorText = function() {
  // ======================================================================
  // Description:   A class function definition
  // Parameters:
  // Returns:
  // Notes:
  // ======================================================================

debugMessage("Entering IfThen getErrorText",1) ;

  try {
          return this.uoMessageList.toString();

  } catch(e) {
    e.description += "\nIfThen.getErrorText>" ;
    throw e ;
  }

  debugMessage("Leaving IfThen getErrorText",-1) ;
}

