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

  // Start by clearing the message list
  this.uoMessageList.clear() ;

  // This is the boolean that will be passed back.
  this.uoBoolean = true;


// First we need to determine whether we are validating "aggregate" or "non-aggregate" fields.
// If the former is true then the inserted lines will be OSND; the latter and the inserted
// lines will be UCR.

var GroupType = document.forms[0].groupType.value.toUpperCase();
// Note this count will be 1 more than is actually present
var TotalNewRows = currentInsert;

if (document.forms[0].groupType.readOnly != true) {
  if (GroupType != "NON-AGGREGATE" && GroupType != "AGGREGATE")
  {
    this.uoMessageList.add("Please note the Group Type must either be 'Aggregate' or 'Non-Aggregate'.<br><br>");
    return false;
  }
}

if (GroupType == "AGGREGATE")
{

  for (var i=1; i < Number(currentInsert); i++)
  {
     // first check the OSNDSSSSS
     var osdnsssss = eval("document.forms[0].osndsssssInsert" + i + ".value");
       if (osdnsssss.length > 0)
          {
            if (isNaN(osdnsssss) || osdnsssss.length != 5 )
            {
                  this.uoBoolean    = false;
                  this.uoMessageList.add("OSND number on (manually inserted) line number " + i + " must a valid numeric and 5 digits in length.<br><br>");

            }

          }
     var dv = new DateValidator("ddmmyy");
     var date = eval("document.forms[0].osndddInsert" + i + ".value") + eval("document.forms[0].osndmmInsert" + i + ".value") + eval("document.forms[0].osndyyInsert" + i + ".value");
     if (date.length > 0)
     {
          if (!dv.isValid(date))
          {
             this.uoBoolean    = false;
             this.uoMessageList.add("OSND date on (manually inserted) line number " + i + " is not valid- it should adhere to the following date map: DD MM YY.<br><br>");
          }
     }

  }
}
else
{

for (var i=1; i < Number(currentInsert); i++)
  {

  var sUCRpt1 = eval("document.forms[0].ucr1ptInsert" + i + ".value").toUpperCase();
  var sUCRpt2 = eval("document.forms[0].ucr2ptInsert" + i + ".value").toUpperCase();
  var sUCRpt3 = eval("document.forms[0].ucr3ptInsert" + i + ".value").toUpperCase();

  eval("document.forms[0].ucr1ptInsert" + i + ".value = sUCRpt1");
  eval("document.forms[0].ucr2ptInsert" + i + ".value = sUCRpt2");
  eval("document.forms[0].ucr3ptInsert" + i + ".value = sUCRpt3");

  var anv = new AlphaNumericValidator(VField.CASE_UPPER);
          if ((anv.isValid(sUCRpt1) == false) || (sUCRpt1.length != 1))
          {
              this.uoBoolean    = false;
              this.uoMessageList.add("UCR (part1) on line number " + i + " must a valid alphanumeric and must be 1 char long.<br><br>");
          }

 var anv = new AlphaNumericValidator(VField.CASE_UPPER);
          if ((anv.isValid(sUCRpt2) == false) || (sUCRpt2.length != 4))
          {
              this.uoBoolean    = false;
              this.uoMessageList.add("UCR (part2) on line number " + i + " must a valid alphanumeric and must be 4 char long.<br><br>");
          }

 var anv = new AlphaNumericValidator(VField.CASE_UPPER);
          if ((anv.isValid(sUCRpt3) == false) || (sUCRpt3.length != 12))
          {
              this.uoBoolean    = false;
              this.uoMessageList.add("UCR (part3) on line number " + i + " must a valid alphanumeric and must be 12 char long.<br><br>");
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

