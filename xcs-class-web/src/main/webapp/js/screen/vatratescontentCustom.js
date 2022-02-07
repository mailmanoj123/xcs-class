// File for custom validators.

// My Custom Validator class - MyCustomValidator
// Constructor
function MyCustomValidator(CustomNameTag) {
  // Initialise a new list for error messages
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
  this.errorLongName = "<br/><strong>Control Name: " + CustomNameTag + "<br/>Reason(s): </strong><br/>";

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

  var i;
  var iRate;
  var iRateValue;
  var iAmt;
  var iTotal = Number(0);
  var hundpercAmtInt = removeCommas(document.all.hundpercAmt.innerText);

  for (i=1;i<=6;i++) {
      iRate = eval("document.forms[0].vatRate" + i + ".selectedIndex");
      iAmt  = removeCommas(eval("vatAmt" + i + ".getUIValue()"));

    // If VAT Rate isn't populated then VAT amount MUST NOT BE populated.
    if ((iRate == -1) && (iAmt != "") && (Number(iAmt)!=0)) {
           this.uoMessageList.add("Note VAT Amount" + i + " CANNOT BE populated when VAT Rate" + i + " is NOT present <br/><br/>") ;
           this.uoBoolean = false;
    }
    if (iRate != -1) {
      iRateValue = eval("document.forms[0].vatRate" + i + ".options[" + iRate + "].text");
      if ( (Trim(iRateValue) == "") && (iAmt != "") && (Number(iAmt)!=0)) {
        this.uoMessageList.add("Note VAT Amount" + i + " CANNOT BE populated when VAT Rate" + i + " is NOT present <br/><br/>") ;
        this.uoBoolean = false;
      }
    }

    // If VAT Rate is populated then VAT amount MUST BE populated.
    if (iRate != -1 && iAmt == "") {
      iRateValue = eval("document.forms[0].vatRate" + i + ".options[" + iRate + "].text");
      if (Trim(iRateValue) != "") {
           this.uoMessageList.add("Note VAT Amount" + i + " MUST BE populated when VAT Rate" + i + " is present <br/><br/>") ;
           this.uoBoolean = false;
      }
    }

    if (hundpercAmtInt > 0) {
        if (iAmt != "")
            if (Number(iAmt) > hundpercAmtInt){
                 this.uoMessageList.add("Note VAT Amount" + i + " cannot be greater than the Bureau Proportion of the 100% VAT Amount <br/><br/>") ;
                 this.uoBoolean = false;
            }
     } else {
          if (iAmt != "")
              if (Number(iAmt) < hundpercAmtInt){
                  this.uoMessageList.add("Note VAT Amount" + i + " cannot be less than the Bureau Proportion of the 100% VAT Amount <br/><br/>") ;
                  this.uoBoolean = false;
              }
      }

      if (iAmt != "") {
        iTotal += Number(iAmt);
      }
  }

  if (Number(iTotal).toFixed(2) != Number(hundpercAmtInt).toFixed(2)){
      this.uoMessageList.add("VAT Amounts must add up to Bureau Proportion of the 100% VAT Amount <br/><br/>") ;
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

