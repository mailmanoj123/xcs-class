// Summator class Summator.
// Version 0.1.

// September 2002.

// Steria AM Ltd.
// Brian Ambrose, Max Bodimeade, Paul Deevoy.
BooleanEntered.AND  = 1;
BooleanEntered.OR   = 2;
BooleanEntered.XOR  = 3;


function BooleanEntered(sOperator,sLongName,bMandatory) {
  // ====================================================================== 
  // Description: Compares the sum of a list of fields against a total field 
  // Parameters:  
  //    vid1  - handle to total amount
  //    sOperator - boolean operator to be used - 1 = AND, 2 = OR, 3 = XOR
  //    sLongName - description of the check
  // Returns:
  // Notes: 
  // ====================================================================== 

  debugMessage("BooleanEntered",1) ;

  try {
    // ========================================
    // Top level comment for large block
    // use what you want, but make it
    // consistent and easily distinguished
    // ========================================
  
    // detail comment
    
    this.uoMessageList = new MessageList() ;
    this.longName      = sLongName ;
    this.Mandatory     = bMandatory ;
    this.errorLongName = "<br/><strong>The Following Grouping rule has been broken: <br> " + sLongName + "</strong><br/>"; 
  
    booleanSwitch: switch (sOperator) {
      case BooleanEntered.AND:
        this.sOperator = sOperator ;
        this.sOperatorError = "All fields must be entered." ;
        break booleanSwitch;
      case BooleanEntered.OR:
        this.sOperator = sOperator ;
        this.sOperatorError = "At least 1 field must be entered" ;
        break booleanSwitch;
      case BooleanEntered.XOR:
        this.sOperator = sOperator ;
        this.sOperatorError = "Only 1 field can be entered" ;
        break booleanSwitch;
      default:
        throw new ErrorObject("Invalid boolean operator value: "+ sOperator)  ;
    }
    
    if (arguments.length < 5) 
        throw new ErrorObject("Invalid number of arguments passed " + arguments.length)  ;
     
    this.Fields          = new Array();
    
    for (var i=3;i < arguments.length;i++)
        this.Fields[i-3] = arguments[i];
  
  } catch(e) {
    e.description += "\n BooleanEntered.constructor" ;
    throw e ;
  }
    debugMessage("Leaving BooleanEntered constructor",-1) ;
}

BooleanEntered.prototype.isValid = function() {
  // ====================================================================== 
  // Description:   A class function definition
  // Parameters: 
  // Returns:
  // Notes: 
  // ====================================================================== 

debugMessage("Entering BooleanEntered isValid",1) ;
  
    this.uoMessageList.clear();
  
    var bTest1;
    var bTest2;
    
    var bValid;
    var bEntered   = false;
    var bFailedXOR = false;

    try {
    
    bTest1  = (this.Fields[0].getUIValue().length > 0);
    bTest2  = (this.Fields[1].getUIValue().length > 0);
    
    if (bTest1 || bTest2)
      bEntered = true;
      
    inittest: switch (this.sOperator) {
       case BooleanEntered.AND:
           bValid = bTest1 && bTest2;
           break inittest;
       case BooleanEntered.OR:
           bValid = bTest1 || bTest2;
           break inittest;
       case BooleanEntered.XOR:
           bFailedXOR = (bTest1 && bTest2);
           bValid = (bFailedXOR)? false:(!bTest1 && bTest2) || (bTest1 && !bTest2);
           break inittest;
       default:
           throw new ErrorObject("Invalid boolean operator value: "+ this.sOperator)  ;
    }
      
    for (var i=2; i < this.Fields.length; i++)
    { 
      bTest1  = (this.Fields[i].getUIValue().length > 0);
      if (bTest1)
        bEntered = true;
      
      nexttest: switch (this.sOperator) {
          case BooleanEntered.AND:
             bValid = bValid && bTest1;
             break nexttest;
          case BooleanEntered.OR:
             bValid = bValid || bTest1;
             break nexttest;
          case BooleanEntered.XOR:
             bFailedXOR = (bFailedXOR)? true : (bValid && bTest1);
             bValid = (bFailedXOR) ? false : (!bValid && bTest1) || (bValid && !bTest1);
             break nexttest;
          default:
             throw new ErrorObject("Invalid boolean operator value: "+ this.sOperator)  ;
        }
    }
        
          if (this.sOperator == BooleanEntered.XOR && !bEntered)
            bValid  = false;
        
          if (!this.Mandatory && !bEntered)
            return true;
        
          if (!bValid)
            this.uoMessageList.add(this.sOperatorError);
      
          return bValid;
    
  } catch(e) {
    e.description += "\nBooleanEntered.isValid>" ;
    throw e ;
  }
    debugMessage("Leaving BooleanEntered isValid",-1) ;
}

BooleanEntered.prototype.getHelpText = function() {
  // ====================================================================== 
  // Description:   A class function definition
  // Parameters: 
  // Returns:
  // Notes: 
  // ====================================================================== 

debugMessage("Entering BooleanEntered getHelpText",1) ;

  try {
    var sDesc ;
    
    sDesc = "Checks whether fields have been entered using a boolean operator";
   // sDesc = "\n" + "Returns a boolean depending on the comparison specified";
    sDesc = "\n" + "Valid operators are :- 1 = AND, 2 = OR and 3 = XOR";
    
    return sDesc;
  } catch(e) {
    e.description += "\nBooleanEntered.getHelpText" ;
    throw e ;
  }
  debugMessage("Leaving BooleanEntered getHelpText",-1) ;
}

BooleanEntered.prototype.getErrorText = function() {
  // ====================================================================== 
  // Description:   A class function definition
  // Parameters: 
  // Returns:
  // Notes: 
  // ====================================================================== 

debugMessage("Entering BooleanEntered getErrorText",1) ;

  try {
          return this.uoMessageList.toString();
          
  } catch(e) {
    e.description += "\nBooleanEntered.getErrorText>" ;
    throw e ;
  }
  
  debugMessage("Leaving BooleanEntered getErrorText",-1) ;
}

