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

  var existstr      = "syndicateNo";
  var newstr        = "syndicateInsertNo";

  var firstrow      = 1;
  var lastrow       = 0;
  var firstinsert   = 1;
  var lastinsert    = 0;

  var sumline       = 0;
  var i             = 0;
  var leadercount   = 0;

  for (i=0;i < document.forms[0].elements.length;i++) {
     document.forms[0].elements[i].value = document.forms[0].elements[i].value.toUpperCase();

     if (document.forms[0].elements[i].name.substr(0,existstr.length) == existstr) {
              lastrow = document.forms[0].elements[i].name.substr(existstr.length,document.forms[0].elements[i].name.length - existstr.length);
     } else {
        if (document.forms[0].elements[i].name.substr(0,newstr.length) == newstr)
            lastinsert = document.forms[0].elements[i].name.substr(newstr.length,document.forms[0].elements[i].name.length -newstr.length);
       }

  }

  var delind;
  var synperc;
  var synno;
  var synref;
  var leader;

  var synrefvalid;
  var synnovalid;
  var synpercvalid;

  var lineno;

   for (i=firstrow;i<=lastrow;i++) {
      delind  = eval("document.forms[0].del" + i );
      synperc = eval("document.forms[0].syndicatePerc" + i );
      synref  = eval("document.forms[0].syndicateRef" + i );
      leader  = eval("document.forms[0].bureauLeader" + i );

      if (!delind.checked) {
          // add up syndicate percentages
          sumline += Number(synperc.value);
          // check if bureau leader checked
          if (leader.checked)
            leadercount++;
          // validate syndref
          if (synref.value.length == 0) {
              this.uoBoolean    = false;
              this.uoMessageList.add("Syndicate Ref on line number " + i + " must be entered.<br><br>");
          }
          if (synref.value.length > 15) {
              this.uoBoolean    = false;
              this.uoMessageList.add("Syndicate Ref on line number " + i + " must 15 characters maximum.<br><br>");
          }
          var synrefvalid = new AlphaExtendedValidator(VField.CASE_UPPER);
          if (synref.value.length !=0 && synref.value.length <= 15)
            if (!synrefvalid.isValid(synref.value)) {
                this.uoBoolean    = false;
                this.uoMessageList.add("Syndicate Ref on line number " + i + " must a valid alphanumeric.<br><br>");
            }
      }
   }

   for (i=firstinsert;i<=lastinsert;i++) {
        lineno  = Number(lastrow) + i;
        synperc = eval("document.forms[0].syndicatePercInsert" + i);
        synref  = eval("document.forms[0].syndicateRefInsert" + i );
        synno   = eval("document.forms[0].syndicateInsertNo" + i);
        leader  = eval("document.forms[0].bureauLeaderInsert" + i );
        del     = eval("document.forms[0].delInsert" + i );

        if ((!del.checked) && ((synperc.value == "") || (synref.value == "") || (synno.value == "")))
        {

          this.uoBoolean    = false;
           this.uoMessageList.add("Line " + lineno + " must have all its values populated.<br><br>");
        }

        // check if bureau leader checked
        if (leader.checked)
            leadercount++;
        // validate syndicateref
        if (synref.value.length > 15) {
           this.uoBoolean    = false;
           this.uoMessageList.add("Syndicate Ref on line number " + lineno + " must 15 characters maximum.<br><br>");
        }
        var synrefvalid = new AlphaNumericValidator(VField.CASE_UPPER);
        if (synref.value.length > 0)
          if (!(synrefvalid.isValid(synref.value))) {
              this.uoBoolean    = false;
              this.uoMessageList.add("Syndicate Ref on line number " + lineno + " must a valid alphanumeric.<br><br>");
          }
        // validate syndicateno
        if (synno.value.length > 4) {
            this.uoBoolean    = false;
            this.uoMessageList.add("Syndicate No on line number " + lineno + " must 4 digits maximum.<br><br>");
        }
        if (synno.value.length > 0)
          if (isNaN(synno.value)) {
              this.uoBoolean    = false;
              this.uoMessageList.add("Syndicate No on line number " + lineno + " must a valid number.<br><br>");
          }
         // validate syndicateperc
        if (synperc.value.length !=0)
          if (isNaN(synperc.value)) {
                this.uoBoolean    = false;
                this.uoMessageList.add("Syndicate Percentage on line number " + lineno + " must a valid number.<br><br>");
          } else
              sumline += Number(synperc.value);

        if (!(synperc.value.length !=0 && synno.value.length !=0 && synref.value.length !=0) && !(synperc.value.length ==0 && synno.value.length ==0 && synref.value.length ==0)) {
              this.uoBoolean    = false;
              this.uoMessageList.add("All syndicate fields on line " + lineno + " must be entered.<br><br>");
        }
   }

   // THESE LINES ADDED 5/2/03 TO REDUCE DECIMAL PLACES DUE TO JAVASCRIPT ADDING ERROR.
   sumline += "";
   if (sumline.indexOf(".")>-1)
     sumline = sumline.substring(0,sumline.indexOf(".")+8);

   if (this.uoBoolean) {
      if (leadercount == 0) {
          this.uoBoolean    = false;
          this.uoMessageList.add("1 line must be marked as the leader (note: items marked to delete cannot be marked as market leader) .<br><br>");
      }
      if (leadercount > 1) {
          this.uoBoolean    = false;
          this.uoMessageList.add("Only 1 line can be marked as the leader.<br><br>");
      }

//      if (sumline > document.all.totalLine.innerText) {
//          this.uoBoolean = false;
//          this.uoMessageList.add("Sum of syndicate percentages must not be greater than the total line.<br><br>");
//      }

      if (sumline > 100) {
        this.uoBoolean = false;
        this.uoMessageList.add("Sum of syndicate percentages must not be greater than 100(%).<br><br>");
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

