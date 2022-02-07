// File for custom validators.

// My Custom Validator class - MyCustomValidator
// Constructor
function Customsingleclaimlossreservescontent(CustomNameTag) {
  // Initialise a new list for error messages
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
    this.errorLongName = "<br/><strong>Other Constraints Broken: " + CustomNameTag + " Screen<br/>Reason(s): </strong><br/>";
  
}

// isValid
Customsingleclaimlossreservescontent.prototype.isValid = function() {

  // Start by clearing the message list
  this.uoMessageList.clear() ;
  
  // This is the boolean that will be passed back.
  this.uoBoolean = true;

// The outstanding amount qualifier  must contain one of the following values T, R or N
// error number E0188
if (osQualifier.getUIValue().length != 0)
{
  if ((osQualifier.getUIValue() != "A") && (osQualifier.getUIValue() != "C") && (osQualifier.getUIValue() != "L") && (osQualifier.getUIValue() != "M") && (osQualifier.getUIValue() != "P") && (osQualifier.getUIValue() != "R") && (osQualifier.getUIValue() != "S") && (osQualifier.getUIValue() != "X"))
    {
       this.uoMessageList.add("The Outstanding Amount Qualifier must be one of the following values: 'A' (Awaiting advice from cedant to coverholder), 'C' (Closed), 'L' (Circumstance of loss notified - Long tail only), 'M' (Claim Notified - Awaiting report from lawyer or adjuster), 'P' (Precautionary ? Reserve below attachment point), 'R' (Recovery), 'S' (Subrogation) or 'X' (Erroneous Entry) . <br/><br/>") ;          
       this.uoBoolean = false;     
    }
}

return this.uoBoolean;
}
// getHelpText
Customsingleclaimlossreservescontent.getHelpText = function() {
  
  // If there are already values in the message list, these came out of error processing
  if (this.uoMessageList.length > 0) {
    return this.uoMessageList.toString()
  } else {
    // There are no values in the message list, return whatever general help is appropriate
    // for this custom validator
  }
}
