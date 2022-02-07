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

  /*var maxLines = claimNarrative.uoUIObject.maxLines;
  var lineLength = claimNarrative.uoUIObject.cols;

  if (!lengthCheck1(claimNarrative.uoUIObject,maxLines,lineLength)) {
    this.uoMessageList.add("Too many narrative lines.<br/><br/>") ;
    this.uoBoolean = false;
  }*/

  return this.uoBoolean
}

function wordwraps1(val,lineLength) {
        var lastCr=0;
        var counter=0;
        while (val.length-lastCr>lineLength) {
                counter++;
                var temp = val.substring(lastCr,lastCr+lineLength);
                if (temp.lastIndexOf(" ")==-1)
                        lastCr += lineLength;
                else
                        lastCr += val.substring(lastCr,lastCr+lineLength).lastIndexOf(" ")+1;
        }
        return counter;
}

function lengthCheck1(ta,maxLines,lineLength) {
        if (event.keyCode==13)
                event.returnValue=false;

  var val = ta.value;
  var counter=0;
  var lastCr=0;

        while (val.indexOf("\r\n")>-1) {
                counter++;
                var temp = val.substring(0,val.indexOf("\r\n"));
                counter += wordwraps1(temp,lineLength);
                val = val.substring(val.indexOf("\r\n")+2);
        }
        counter += wordwraps1(val,lineLength);

  if (counter<maxLines) {
    return true;
  } else {
    return false;
  }
}

// getHelpText
MyCustomValidator.prototype.getHelpText = function() {
  return this.uoMessageList.toString()
}
