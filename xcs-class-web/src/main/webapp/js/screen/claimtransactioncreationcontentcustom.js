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
MyCustomValidator.prototype.isValid = function()
{
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


  // If the risk unsigned checkbox is checked (true) then the OSND(x) must not be populated.
  // The following 4 checks do not have an E error number
  if (((vGroup1.getUIValue() != "") && (osnd1sssss.getUIValue() != "")) && (document.forms[0].riskUnsigned.checked == true))
  {
     this.uoMessageList.add("If the Risk Unsigned box is ticked then the OSND1 must NOT be populated.<br/><br/>") ;
     this.uoBoolean = false;
  }

  if (((vGroup3.getUIValue() != "") && (osnd2sssss.getUIValue() != "")) && (document.forms[0].riskUnsigned.checked == true))
    {
       this.uoMessageList.add("If the Risk Unsigned box is ticked then the OSND2 must NOT be populated.<br/><br/>") ;
       this.uoBoolean = false;
  }
  if (((vGroup5.getUIValue() != "") && (osnd3sssss.getUIValue() != "")) && (document.forms[0].riskUnsigned.checked == true))
      {
         this.uoMessageList.add("If the Risk Unsigned box is ticked then the OSND3 must NOT be populated.<br/><br/>") ;
         this.uoBoolean = false;
  }
  // If the risk unsigned checkbox is NOT checked (false) then the OSND(x) MUST be populated.
  if (((vGroup1.getUIValue() == "") && (osnd1sssss.getUIValue() == "")) && (document.forms[0].riskUnsigned.checked == false))
    {
       this.uoMessageList.add("If the Risk Unsigned box is NOT ticked then the OSND1 must be populated.<br/><br/>") ;
       this.uoBoolean = false;
  }



   // The APSND fields can only be populated when their respective OSND are populated.
   // Error code is E0064 (for the following 3 checks).
  if (((vGroup1.getUIValue() == "") && (osnd1sssss.getUIValue() == "")) && (vGroup2.getUIValue() != ""))
  {
       this.uoMessageList.add("If the OSND1 is NOT populated then the APSND1 must NOT be populated.<br/><br/>") ;
       this.uoBoolean = false;
  }
  if (((vGroup3.getUIValue() == "") && (osnd2sssss.getUIValue() == "")) && (vGroup4.getUIValue() != ""))
  {
         this.uoMessageList.add("If the OSND2 is NOT populated then the APSND2 must NOT be populated.<br/><br/>") ;
         this.uoBoolean = false;
  }
  if (((vGroup5.getUIValue() == "") && (osnd3sssss.getUIValue() == "")) && (vGroup6.getUIValue() != ""))
  {
           this.uoMessageList.add("If the OSND3 is NOT populated then the APSND3 must NOT be populated.<br/><br/>") ;
           this.uoBoolean = false;
  }



  // If the OSND fields are populated then the related CCY field must be populated.
  // Error code is E0062 (for the following 3 checks).
  if (((vGroup1.getUIValue() != "") && (osnd1sssss.getUIValue() != ""))  && (origCcy1.getUIValue() == ""))
      {
         this.uoMessageList.add("If the OSND1 is populated then it will require the respective Orig CCY to be populated .<br/><br/>") ;
         this.uoBoolean = false;
  }

  if (((vGroup3.getUIValue() != "") && (osnd2sssss.getUIValue() != ""))  && (origCcy2.getUIValue() == ""))
        {
           this.uoMessageList.add("If the OSND2 is populated then it will require the respective Orig CCY to be populated .<br/><br/>") ;
           this.uoBoolean = false;
  }

  if (((vGroup5.getUIValue() != "") && (osnd3sssss.getUIValue() != ""))  && (origCcy3.getUIValue() == ""))
        {
           this.uoMessageList.add("If the OSND3 is populated then it will require the respective Orig CCY to be populated .<br/><br/>") ;
           this.uoBoolean = false;
  }



  // If the APSND fields are populated then the related CCY field must be populated.
  // Error code is E0063 (for the following 3 checks).
  if (((vGroup2.getUIValue() != "") && (apsnd1sssss.getUIValue() != ""))  && (origCcy1.getUIValue() == ""))
        {
           this.uoMessageList.add("If the APSND1 is populated then it will require the respective Orig CCY to be populated .<br/><br/>") ;
           this.uoBoolean = false;
    }

    if (((vGroup4.getUIValue() != "") && (apsnd2sssss.getUIValue() != "")) && (origCcy2.getUIValue() == ""))
          {
             this.uoMessageList.add("If the APSND2 is populated then it will require the respective Orig CCY to be populated .<br/><br/>") ;
             this.uoBoolean = false;
    }

    if (((vGroup6.getUIValue() != "") && (apsnd3sssss.getUIValue() != "")) && (origCcy3.getUIValue() == ""))
    {
             this.uoMessageList.add("If the APSND3 is populated then it will require the respective Orig CCY to be populated .<br/><br/>") ;
             this.uoBoolean = false;
    }




    // Ensure that a value has been selected in the following manditory drop down box.
    // No error number.
    if ((document.forms[0].settAdv.type!="hidden") && (document.forms[0].settAdv[document.forms[0].settAdv.selectedIndex].value == "NULL"))
    {
         this.uoMessageList.add("A value must be selected from the Sett/Adv drop down.<br/><br/>") ;
         this.uoBoolean = false;
    }


    // If the user ticks the Bulk Ind tick box then they must also have selected Settlement in the settAdv combo.
    // Error code is E0194.
    // Bug Fix - 14/01/2003 - BA - Was incorrectly comparing against the text of the
    // drop down list ("Settlement") rather than the value ("S").
    if ((document.forms[0].settAdv.type!="hidden") && (document.forms[0].bulkInd.checked == true) && (document.forms[0].settAdv[document.forms[0].settAdv.selectedIndex].value != "S"))
    {
             this.uoMessageList.add("If the Bulk Indicator has been selected then the Sett/Adv must be equal to Settlement.<br/><br/>") ;
             this.uoBoolean = false;
    }

    // If the user ticks the "Pay By Cheque" checkbox then the "Treaty" and "LOC" checkboxes must not be ticked.
    // Error code is E0202.
    //
    // CCN 656
    //if ((document.forms[0].payByCheque.checked == true) && (document.forms[0].treaty.checked == true))
    //{
    //        this.uoMessageList.add("Error E202: Treaty Claim cannot be paid by cheque. <br/><br/>") ;
    //        this.uoBoolean = false;
    //}

    // If the user ticks the "Pay By Cheque" checkbox then the "Treaty" and "LOC" checkboxes must not be ticked.
    // Error code is E0203.
    //
    // CCN 656
    //if ((document.forms[0].payByCheque.checked == true) && (document.forms[0].loc.checked == true))
    //{
    //         this.uoMessageList.add("Error E203: Letter of Credit Claim cannot be paid by cheque. <br/><br/>") ;
    //         this.uoBoolean = false;
    //}

    // CCN #N0058 - BA - 13/01/2003
    // LOC Drawing Indicator check box.  If the user ticks this box,
    // issue errors under the following circumstances:
    // (i) User must have selected Settlement in the Sett/Adv field.
    // If not, display the error E379.
    // (ii) User must not have ticked the LOC tick-box.
    // If they have, display the error E380.
    if (document.forms[0].locDrawingInd.checked == true) {
      if (settAdv.getUIValue() != "S") {
        this.uoMessageList.add("Error E379: Claim Transaction must include settlement for Letter of Credit Drawing.<br><br>") ;
        this.uoBoolean = false;
      }
      // Removed as part of CCN (F1525)
      //if (document.forms[0].loc.checked == true) {
      //  this.uoMessageList.add("Error E380: LOC Drawing Indicator cannot be ticked on Letter of Credit Claims.<br><br>") ;
      //  this.uoBoolean = false;
      //}
    }

    // CCN N0054 - BA - 14/01/2002
    if ((document.forms[0].settAdv.type!="hidden") && (document.forms[0].settAdv[document.forms[0].settAdv.selectedIndex].value == "A"))
    {
      // CCN 656
      //if (document.forms[0].payByCheque.checked == true){
      // this.uoMessageList.add("Error E376: Paid By Cheque cannot be ticked for advice-only claim transactions.<br/><br/>") ;
      //  this.uoBoolean = false;
      //}
      // CCN 602
      if (document.forms[0].lossFund.checked == true){
        this.uoMessageList.add("Error E375: Loss Fund cannot be ticked for advice-only claim transactions.<br/><br/>") ;
        this.uoBoolean = false;
      }
      if (document.forms[0].simRi.checked == true){
        this.uoMessageList.add("Error E374: Simultaneous Reinstatement not allowed for advice-only transactions.<br/><br/>") ;
        this.uoBoolean = false;
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