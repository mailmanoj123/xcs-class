// File for custom validators.

// My Custom Validator class - MyCustomValidator
// Constructor
function MyCustomValidator(CustomNameTag) {
  // Initialise a new list for error messages
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
    this.errorLongName = "<br/><strong>Other Constraints Broken: " + CustomNameTag + " Screen<br/>Reason(s): </strong><br/>";

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

  var bDol = vGroup1.getUIValue() != "";
  var bDolQual = dolQual.getUIValue() != "";

  /*
  // If the Date of Loss is populated then its qualifier must be blank.
  if (bDol && bDolQual)
  {
        this.uoMessageList.add("Note the Date of Loss Qualifier must be absent when the Date of Loss is present <br/><br/>" ) ;
        this.uoBoolean = false;
  }

  // If the Date of Loss Qualifier is populated then it must contain one of the following valid values: T, V, N
  if (bDolQual)
  {
    var tempQual = dolQual.getUIValue();
    if (tempQual == "T" || tempQual == "V" || tempQual == "N" || tempQual == "S")
    {
      // this is what is required
    }
    else
    {
        this.uoMessageList.add("If the Date of Loss Qualifier is populated then it must contain one of the following values: 'T', 'V', 'N' or 'S' <br/><br/>") ;
        this.uoBoolean = false;
    }
    // The Date of Loss narrative must be completed if the DOL qual is set to S
    if (!(dolNarrative.getUIValue() != "") && (tempQual == "S"))
    {
         this.uoMessageList.add("The Date of Loss Narrative must be completed when the DOL qualifier is set to S <br/><br/>") ;
         this.uoBoolean = false;
    }
  }*/

  var bDcm = vGroup3.getUIValue() != "";
  var bDcmQual = dcmQual.getUIValue() != "";

  // If the Date Claim Made is populated then its qualifier must be blank.
   if (bDcm && bDcmQual)
   {
         this.uoMessageList.add("Note the Date Claim Made Qualifier must be absent when the Date Claim Made is present <br/><br/>" ) ;
         this.uoBoolean = false;
   }

   // If the Date Claim Made Qualifier is populated then it must contain one of the following valid values: T, V, N
   if (dcmQual.getUIValue() != "")
   {
     var tempQual = dcmQual.getUIValue();
     if (tempQual == "T" || tempQual == "V" || tempQual == "N")
     {
       // this is what is required
     }
     else
     {
         this.uoMessageList.add("If the Date Claim Made Qualifier is populated then it must contain one of the following values: 'T', 'V', 'N' <br/><br/>") ;
         this.uoBoolean = false;
     }
  }

  if (!(bDol || bDolQual) && !(bDcm || bDcmQual)) {
    this.uoMessageList.add("Either the Date of Loss or Date Claim Made must be entered <br/><br/>") ;
    this.uoBoolean = false;
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
