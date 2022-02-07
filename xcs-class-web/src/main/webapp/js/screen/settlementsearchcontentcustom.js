// scmadvicecontent custom validation

// Constructor
function SettlementSearchContentCustom(CustomNameTag) {
  // Initialise a new list for error messages
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
    this.errorLongName = "<br/><strong>Other Constraints Broken: " + CustomNameTag + " Screen<br/>Reason(s): </strong><br/>";
}

// isValid
SettlementSearchContentCustom.prototype.isValid = function() {
  // Start by clearing the message list
  this.uoMessageList.clear() ;

  // This is the boolean that will be passed back.
  this.result = true;

  // Retrieve all the fields from SettlementSearchContent
  var C115_YEAR_OF_ACC_value = C115_YEAR_OF_ACC.getUIValue() ;
  var C115_PAYEE_BKR_value = C115_PAYEE_BKR.getUIValue() ;
  var C115_ORIG_SIGNING_DATEsssss_value = C115_ORIG_SIGNING_DATEsssss.getUIValue() ;
  var C115_ORIG_SIGNING_DATEdd_value = C115_ORIG_SIGNING_DATEdd.getUIValue() ;
  var C115_TAKE_DOWN_DATEsssss_value = C115_TAKE_DOWN_DATEsssss.getUIValue() ;
  var C115_TAKE_DOWN_DATEdd_value = C115_TAKE_DOWN_DATEdd.getUIValue() ;
  var C115_COMP_BTW_FROMdd_value = C115_COMP_BTW_FROMdd.getUIValue() ;
  var C115_COMP_BTW_TOdd_value = C115_COMP_BTW_TOdd.getUIValue() ;
  var C115_NAME_1_value = C115_NAME_1.getUIValue() ;
  var C115_NAME_2_value = C115_NAME_2.getUIValue() ;

  // If all of the above fields do not have a value then return an error
  if (((C115_NAME_2.getUIValue().length == 0) &&(C115_NAME_1.getUIValue().length == 0) &&(C115_COMP_BTW_TOdd.getUIValue().length == 0) &&(C115_COMP_BTW_FROMdd.getUIValue().length == 0) &&(C115_TAKE_DOWN_DATEdd.getUIValue().length == 0) &&(C115_TAKE_DOWN_DATEsssss.getUIValue().length == 0) &&(C115_ORIG_SIGNING_DATEdd.getUIValue().length == 0) &&(C115_ORIG_SIGNING_DATEsssss.getUIValue().length == 0) &&(C115_YEAR_OF_ACC.getUIValue().length == 0) && (C115_PAYEE_BKR.getUIValue().length == 0)) ) {
    // Error E0098
    this.result = false ;
    this.uoMessageList.add("At least one of the key fields must be entered.<br>") ;
  }


  return this.result
}

// getHelpText
SettlementSearchContentCustom.getHelpText = function() {
  // If there are already values in the message list, these came out of error processing
  if (this.uoMessageList.length > 0) {
    return this.uoMessageList.toString()
  } else {
    // There are no values in the message list, return whatever general help is appropriate
    // for this custom validator
  }
}