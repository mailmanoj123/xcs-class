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

  // If the Cover/Lineslip dates are populated (or its Qualifier) then the
  // either the Policy/Cert date or its qualifier must be populated.
  // There are no E error numbers for these errors!
  if (((vGroup3.getUIValue() != "") && (vGroup4.getUIValue() != ""))  || (document.forms[0].coverLineslipQualifier.uoVField.getUIValue() != ""))
  {
    if (((vGroup1.getUIValue() == "") && (vGroup2.getUIValue() == ""))  && (document.forms[0].polCertQualifier.uoVField.getUIValue() == ""))
        {
           this.uoMessageList.add("If the Cover/Lineslip dates are populated (or its Qualifier) then either the Policy/Cert dates or its Qualifier must be populated <br/><br/>") ;
           this.uoBoolean = false;
        }
  }

  // If the Policy/Cert date is populated then its qualifier must be blank.
  // Error number: E0104
  if (((vGroup1.getUIValue() != "") || (vGroup2.getUIValue() != ""))  && (document.forms[0].polCertQualifier.uoVField.getUIValue() != ""))
  {
        this.uoMessageList.add("Note the Policy/Cert Qualifier must be absent when the Policy/Cert Period Dates are present <br/><br/>" ) ;
        this.uoBoolean = false;
  }

  // If the Policy/Cert date is NOT populated then its qualifier MUST BE populated.
  // Error number: E0103
  if (((vGroup1.getUIValue() == "") || (vGroup2.getUIValue() == ""))  && (document.forms[0].polCertQualifier.uoVField.getUIValue() == ""))
  {
          this.uoMessageList.add("Note the Policy/Cert Qualifier MUST BE populated when the Policy/Cert Period Dates are NOT present <br/><br/>") ;
          this.uoBoolean = false;
  }


  // If the Policy/Cert is populated then it must contain one of the following valid values: T, V, N
  // Error number: E0104
  if (document.forms[0].polCertQualifier.uoVField.getUIValue() != "")
  {
    var tempQual = document.forms[0].polCertQualifier.uoVField.getUIValue();
    if (tempQual == "T" || tempQual == "V" || tempQual == "N")
    {
      // this is what is required
    }
    else
    {
        this.uoMessageList.add("If the Policy/Cert Qualifier is populated then it must contain one of the following values: T, V, N <br/><br/>") ;
        this.uoBoolean = false;
    }
  }


  // If the Cover/Line date is populated then its qualifier must also be populated.
  // error number E0170
  if (((vGroup3.getUIValue() != "") || (vGroup4.getUIValue() != ""))  && (document.forms[0].coverLineslipQualifier.uoVField.getUIValue() == ""))
  {
        this.uoMessageList.add("Note the Cover/Line Slip Qualifier must be populated when the Cover/Line Period Dates are present <br/><br/>") ;
        this.uoBoolean = false;
  }

  // If the Policy/Cert date is NOT populated then its qualifier MUST BE populated with T or V
  // error E0171
  if (((vGroup3.getUIValue() != "") || (vGroup4.getUIValue() != ""))  && (document.forms[0].coverLineslipQualifier.uoVField.getUIValue() != ""))
  {
      var tempQual = document.forms[0].coverLineslipQualifier.uoVField.getUIValue();
      if (tempQual == "C" || tempQual == "L" || tempQual == "P" || tempQual == "R")
      {
        // this is what is required
      }
      else
      {
          this.uoMessageList.add("If the Cover/Line Dates are populated then the Cover/Line Qualifier must contain one of the following values: C, L, P or R <br/><br/>") ;
          this.uoBoolean = false;
      }
  }


  // If the Policy/Cert date is NOT populated then its qualifier MUST BE populated with T or V
  // error E0171 (as in check directly above- although different values are needed!!)
  if (((vGroup3.getUIValue() == "") || (vGroup4.getUIValue() == ""))  && (document.forms[0].coverLineslipQualifier.uoVField.getUIValue() != ""))
  {
      var tempQual = document.forms[0].coverLineslipQualifier.uoVField.getUIValue();
      if (tempQual == "T" || tempQual == "V")
      {
        // this is what is required
      }
      else
      {
          this.uoMessageList.add("If the Cover/Line Dates are blank then the Cover/Line Qualifier must contain one of the following values: T or V <br/><br/>") ;
          this.uoBoolean = false;
      }
  }

  var tempPeerReview = document.forms[0].peerReview.uoVField.getUIValue();
  if (tempPeerReview == "N" || tempPeerReview == "D" || tempPeerReview == "F" || tempPeerReview == "Y")
  {
    // this is what we want
  }
  else
  {
    this.uoMessageList.add("The Peer Review field should be one of the following values: N, D, F or Y <br/><br/>") ;
    this.uoBoolean = false;
  }

  if (((slipOrder1.getUIValue()=="") || (Number(slipOrder1.getUIValue())==0)) && ((slipOrder2.getUIValue()!="") && (Number(slipOrder2.getUIValue())!=0))) {
    this.uoMessageList.add("Slip Order 2 cannot be entered unless Slip Order 1 is populated.");
    this.uoBoolean = false;
  }
  
  // Patrick Cogan, SIR 41158.
  // Check to see if the UMR broker field is make up of 4 characters
/*  var tempBn = document.forms[0].umrumrbn.uoVField.getUIValue();
  if(tempBn.length != 4){
  		this.uoMessageList.add("The UMR Broker number field should be four digits. <br/><br/>") ;
	    this.uoBoolean = false;
  	
  } */
  
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

/*
$Log: policyriskdetailscontentCustom.js,v $
Revision 1.7  2004/03/25 17:54:42  coganp
SIR41158 fix.Added GenericRegexValidator:
removed checking of umr brocker numberfrom post checking on submition
to be done in the validation framework.

Revision 1.6  2004/03/25 14:54:34  coganp
SIR41158 fix.Added GenericRegexValidator:
This goes yellow if the b field is not a b

Revision 1.5  2004/03/23 16:54:02  coganp
fixed for SIR 41158
Changed validation message type and content for UMR fields.

Revision 1.4  2004/03/18 08:59:15  coganp
Furthur fixes for SIR 41158.

Revision 1.3  2004/03/16 16:33:51  coganp
Fix for SIR 41158: Fixed typo stopping submition even thought the fields was B.

Revision 1.2  2004/03/15 15:38:10  coganp
Fix for SIR 41158:
Changed the format of UMR field from one part to become three parts


*/