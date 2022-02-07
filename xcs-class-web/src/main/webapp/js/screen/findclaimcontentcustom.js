// File for custom validators.

// My Custom Validator class - MyCustomValidator
// Constructor
function CustomFindClaimContent(CustomNameTag) {
  // Initialise a new list for error messages
  this.uoMessageList = new MessageList() ;
  this.longName= CustomNameTag ;
    this.errorLongName = "<br/><strong>Other Constraints Broken: " + CustomNameTag + " Screen<br/>Reason(s): </strong><br/>";

}

// isValid
CustomFindClaimContent.prototype.isValid = function() {
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

//If the TR is populated then the UCR/XCR must also be populated
// Although each is made up of more than one textbox we are only interested in the first- as
// the rest will have been validated elsewhere to check that they are populated (this will be
// continued throughout this custom module).
// error = E0013
if ((trpt1.getUIValue() != "") && (ucrpt1.getUIValue() == ""))
  {
     this.uoMessageList.add("The Transaction Reference can only be populated when the UCR/XCR is also populated. <br/><br/>") ;
     this.uoBoolean = false;
  }

//If the Broker UCR is populated then all other fields on the screen must be blank.
// error = E0163
if ((bkrUcrpt1.getUIValue() != "") && (ucrpt1.getUIValue() != "" || trpt1.getUIValue() != "" || corpt1.getUIValue() != "" || osndsssss.getUIValue() != "" || tdnsssss.getUIValue() != "" || groupRefpt1.getUIValue() != "" || certNo.getUIValue() != "" ))
  {
     this.uoMessageList.add("When the Broker UCR is populated then all other fields on this screen should be blank. <br/><br/>") ;
     this.uoBoolean = false;
  }

// The COR can only be populated when the TR and UCR/XCR are blank.
// error = E0014
if ((corpt1.getUIValue() != "") && (trpt1.getUIValue() != "" || ucrpt1.getUIValue() != ""))
  {
     this.uoMessageList.add("When the Claims Office Reference is populated, both the UCR/XCR and the Transaction Reference must be blank. <br/><br/>") ;
     this.uoBoolean = false;
  }
// Note: The COR field can be the following two formats:
// If 1st char is M then the following format applies: X YY/MM SSSSS C
// If 1st char is N or A then the following format applies: X SSSSS/DDMMYY
// NOTE: AT THE MOMENT WE ARE JUST CHECKING THAT THIS FIELD IS A MAX OF 15 CHARS.


// The OSND can only be populated when the TR, UCR/XCR and COR are blank.
// error = E0015
if ((osndsssss.getUIValue() != "") && (trpt1.getUIValue() != "" || ucrpt1.getUIValue() != "" || corpt1.getUIValue() != "" || certNo.getUIValue() != ""))
  {
     this.uoMessageList.add("When the OSND number and date is populated, the UCR/XCR, Claims Office Reference, Transaction Reference and the Certificate of Insurance Number must be blank. <br/><br/>") ;
     this.uoBoolean = false;
  }

// The Take Down number and date  can only be populated when the TR and UCR/XCR are blank.
// error = E0016
if ((tdnsssss.getUIValue() != "") && (trpt1.getUIValue() != "" || ucrpt1.getUIValue() != "" || certNo.getUIValue() != ""))
  {
     this.uoMessageList.add("When the Taking Down Number and Date are populated, UCR/XCR, Transaction Reference and Certificate of Insurance Number must be blank. <br/><br/>") ;
     this.uoBoolean = false;
  }


// The OSND can only be populated when the TR, UCR/XCR and COR are blank.
// error = E0017
if (groupRefpt1.getUIValue().length == 4)
  {

     if (groupRefpt1.getUIValue().substr(0,1) != "L")
     {
        this.uoMessageList.add("The Group Reference must start with the following letter 'L'. <br/><br/>") ;
        this.uoBoolean = false;
     }
      if (isNaN(groupRefpt1.getUIValue().substr(1,3)))
     {
        this.uoMessageList.add("Letters 2,3 and 4 of the Group Reference (part 1) must be numeric <br/><br/>") ;
        this.uoBoolean = false;
     }
  }
// error = E0017 continued
if (groupRefpt2.getUIValue().length == 6)
  {
     if (isNaN(groupRefpt2.getUIValue().substr(0,2)))
        {
             this.uoMessageList.add("Letters 1 and 2 of the Group Reference (part 2) must be numeric <br/><br/>") ;
             this.uoBoolean = false;
        }
     var dv = new DateValidator("mmyy");
     if (! dv.isValid(groupRefpt2.getUIValue().substr(2,4)) == true)
        {
                  this.uoMessageList.add("Letters 3 to 6 of the Group Reference (part 2) must match the following date format: MMYY <br/><br/>") ;
                  this.uoBoolean = false;
        }
  }

//If the Group Reference is populated then the UCR, TR, COR, OSND and TDN
// error = E0163
if ((groupRefpt1.getUIValue() != "") && (ucrpt1.getUIValue() != "" || trpt1.getUIValue() != "" || corpt1.getUIValue() != "" || osndsssss.getUIValue() != "" || tdnsssss.getUIValue() != "" || certNo.getUIValue() != ""))
  {
     this.uoMessageList.add("When the Group Reference is populated then the UCR/XCR, Transaction Reference, Claims Office Reference, OSND, Taking Down Number/Date and the Certificate of Insurance Number must be blank. <br/><br/>") ;
     this.uoBoolean = false;
  }

// If the first character of the UCR/XCR is an X (eg an XCR), then the third
// part of the field must be 12 characters exactly.
// CCN Key Seq 244 and conversation between BA and DW 19/02/2003
if ((ucrpt1.getUIValue().toUpperCase() == "X") && (ucrpt3.getUIValue().length < 12)) {
  this.uoMessageList.add("An XCR must be exactly 17 characters long. <br/><br/>") ;
  this.uoBoolean = false;
}


// ADVANCED SEARCH ADDITIONAL VALIDATION

var advError = "Invalid search combination. Valid combinations are:<br>"
               + "<ul>"
               + "<li>Name 1 and Date of Loss From/To</li>"
               + "<li>Name 1 and Date Claim Made From/To</li>"
               + "<li>Name 2 and Date of Loss From/To</li>"
               + "<li>Name 2 and Date Claim Made From/To</li>"
               + "<li>User ID and Date Processed From/To</li>"
               + "<li>Claimant and Date of Loss From/To</li>"
               + "<li>Claimant and Date Claim Made From/To</li>"
               + "<li>Broker Reference and Date of Loss From/To</li>"
               + "<li>Broker Reference and Date Claim Made From/To</li>"
               + "</ul>";

var name1Entered = name1.getUIValue() != "";
var name2Entered = name2.getUIValue() != "";
var dolFromEntered = vGroup3.getUIValue() != "";
var dolToEntered = vGroup4.getUIValue() != "";
var catCodeEntered = catCode.getUIValue() != "";
var userEntered = user.getUIValue() != "";
var claimantEntered = claimant.getUIValue() != "";
var bkrRefEntered = bkrRef.getUIValue() != "";
var procFromEntered = vGroup5.getUIValue() != "";
var procToEntered = vGroup6.getUIValue() != "";

var enteredCount = 0;

if (name1Entered) enteredCount++;
if (name2Entered) enteredCount++;
if (dolFromEntered) enteredCount++;
if (dolToEntered) enteredCount++;
if (catCodeEntered) enteredCount++;
if (userEntered) enteredCount++;
if (procFromEntered) enteredCount++;
if (procToEntered) enteredCount++;
if (claimantEntered) enteredCount++;
if (bkrRefEntered) enteredCount++;

if (enteredCount <2) {
  //Do nothing
} else if (enteredCount == 2) {
  if (((procToEntered) && (procFromEntered)) || ((dolToEntered) && (dolFromEntered)) || ((name1Entered) && (dolFromEntered)) || ((name2Entered) && (dolFromEntered)) || ((userEntered) && (procFromEntered)) || ((claimantEntered) && (dolFromEntered)) || ((bkrRefEntered) && (dolFromEntered))      ) {
    // Do nothing
  } else {
    this.uoMessageList.add(advError) ;
    this.uoBoolean = false;
  }
} else if (enteredCount == 3) {
  if (((name1Entered) && (dolFromEntered) && (dolToEntered)) || ((name2Entered) && (dolFromEntered) && (dolToEntered)) || ((userEntered) && (procFromEntered) && (procToEntered)) || ((claimantEntered) && (dolFromEntered) && (dolToEntered)) || ((bkrRefEntered) && (dolFromEntered) && (dolToEntered)) ) {
    // Do nothing
  } else {
    this.uoMessageList.add(advError) ;
    this.uoBoolean = false;
  }
} else {
  this.uoMessageList.add(advError) ;
  this.uoBoolean = false;
}


/*If Certificate of Insurance is entered then no other field should be entered*/
if(certNo.getUIValue() != "")
{
  if(ucrpt1.getUIValue() != "" || bkrUcrpt1.getUIValue() != ""  || trpt1.getUIValue() != "" || corpt1.getUIValue() != "" || osndsssss.getUIValue() != "" || osnddd.getUIValue() != "" || osndmm.getUIValue() != "" || osndyy.getUIValue() != "" || tdnsssss.getUIValue() != "" || tdndd.getUIValue() != "" || tdnmm.getUIValue() != "" || tdnccyy.getUIValue() != "" ||  groupRefpt1.getUIValue() != "" || groupRefpt2.getUIValue() != "" || name1.getUIValue() != "" || name2.getUIValue() != "" || dateOfLossFromdd.getUIValue() != "" || dateOfLossFrommm.getUIValue() != "" || dateOfLossFromyyyy.getUIValue() != "" || dateOfLossTodd.getUIValue() != "" || dateOfLossTomm.getUIValue() != "" || dateOfLossToyyyy.getUIValue() != "" || catCode.getUIValue() != "" || user.getUIValue() != "" || dateProcessedFromdd.getUIValue() != "" || dateProcessedFrommm.getUIValue() != "" || dateProcessedFromyyyy.getUIValue() != "" || dateProcessedTodd.getUIValue() != "" || dateProcessedTomm.getUIValue() != "" || dateProcessedToyyyy.getUIValue() != "")
  {
  	this.uoMessageList.add("<br>Can not enter certificate of insurance no. with other search fields. <br><br>") ;
  	this.uoBoolean = false;
  }
}

return this.uoBoolean;
}
// getHelpText
CustomFindClaimContent.getHelpText = function() {

  // If there are already values in the message list, these came out of error processing
  if (this.uoMessageList.length > 0) {
    return this.uoMessageList.toString()
  } else {
    // There are no values in the message list, return whatever general help is appropriate
    // for this custom validator
  }
}
