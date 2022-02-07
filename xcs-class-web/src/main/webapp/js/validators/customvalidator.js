// File for custom validators.

// My Custom Validator class - MyCustomValidator
// Constructor
function MyCustomValidator(CustomNameTag) {
  // Initialise a new list for error messages
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
  this.errorLongName = "<br/><strong>Controlzzz Name: " + CustomNameTag + "<br/>Reason(s): </strong><br/>";          
  
}

// isValid
MyCustomValidator.prototype.isValid = function() {
  // This isValid is called after a VField has been verified as containing a value that has
  // already been checked against mandatory, min, max and exact character width, 
  // min and max value and any rules regarding data type.
  
  // Note that a custom validator is bound to a single VField.  If the validator needs to
  // check on more than one VField, it is unsafe to assume any other VFields have had their 
  // basic syntactical validation performed.  In this case, use if(VField.isValid(false)) to 
  // check the other fields before using them.  For performance, however, this can be ignored
  // if sure that the other field has already had its validation carried out.
  // Validation is carried out in the order that VFields were added to the VForm.


  // Start by clearing the message list
  this.uoMessageList.clear() ;
  
  // This is the boolean that will be passed back.
  this.uoBoolean = true;

  // Do your validation in here.
  
  // If the Amt field has nothing in it- that is it is blank then we will not want to
  // carry on with this level of validation.
  if (document.forms[0].osTotal.uoVField.getUIValue().length != "")
  {
      // If the value is equal to zero then it must contain on of the values below.
      if (Number(document.forms[0].osTotal.uoVField.getUIValue()) == 0)
      {
          var tempQual = document.forms[0].osTotalQual.uoVField.getUIValue();
          if (tempQual == "E" || tempQual == "T" || tempQual == "F"|| tempQual == "N"|| tempQual == "R"|| tempQual == "S"|| tempQual == "V"|| tempQual == "Z"  || tempQual == "C")
          {
              // this is valid
          }
          else
          {
              this.uoMessageList.add("The O/S amt and O/S amt qualifier are linked together. If the value in the amount field is 0 then this Qual field should contain either E,T,F,N,R,S,V,Z or C") ;          
              this.uoBoolean = false;
          }
      }
  }
  
  return this.uoBoolean
}

// getHelpText
MyCustomValidator.getHelpText = function() {
  
  // If there are already values in the message list, these came out of error processing
  if (this.uoMessageList.length > 0) {
    return this.uoMessageList.toString()
  } else {
    // There are no values in the message list, return whatever general help is appropriate
    // for this custom validator
  }
}