// ==========================================================================================
// Validated Group class VGroup.
// Version 0.1.
// October 2002.
// Steria Ltd.
// Brian Ambrose, Paul Deevoy, Max Bodimeade.
// ==========================================================================================

// Constants for Types
// At the moment this only deals with dates.
VGroup.TYPE_DATE = 101;

// Constants for Check Attributes
VGroup.CHECK_FORMAT = 1;
VGroup.CHECK_MANDATORY = 2;

// Constants for Format Attributes
VGroup.LONG_NAME = 2000;

// Constructor
function VGroup(iType) {
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VGroup Constructor::VGroup ([number] [then a variable number of type definers])
// ~
// ~   this will do the required initialisation for this class. Also it will parse through the
// ~   parameters passed into this constructor.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  var sFunctionName = "VGroup Constructor" ;

  try
  {
    debugMessage("Entering " + sFunctionName, 1) ;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Store mandatory parameter- which will be the Group Type
    // This must be populated
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    if (iType==null)
      throw new ErrorObject("The Group Type must be determined.");
    else
      this.iType= iType ;

    this.checkFormat=null;
    this.longName= "" ;
    this.errorLongName = "" ;
    this.checkMandatory= false ;

    // ========================================
    // Get and store the optional parameters
    // ========================================
    this.parseParameters(arguments) ;

     // this.uoMessageList is an array which will hold all the errors.
    this.uoMessageList= new MessageList() ;

    // this.arrFields holds all the VFields that will be handled by each instance of VGroup.
    this.arrFields= new Array()


    // ========================================
    // Create a data validator
    // At the moment this only handles the "TYPE DATE"- although there is scope to expand this.
    // ========================================
    validatorSwitch: switch (this.iType)
    {
      case VGroup.TYPE_DATE:
        if (this.checkFormat==null)
          throw new ErrorObject("An input format must be supplied for date fields.") ;
        else
          this.uoDataValidator = new DateValidator(this.checkFormat) ;
          break validatorSwitch ;
      default:
        throw new ErrorObject("Unrecognised field data type.") ;
    }

    debugMessage("Leaving " + sFunctionName, -1) ;
  }
  catch(e)
  {
    e.description += "\n" + sFunctionName + "(iType=" ;
    e.description += iType ;
    if (arguments.length > 1) {
      for (var i=1; i<arguments.length; i++) {
        e.description += ", " + arguments[i] ;
      }
    }
    e.description += ")" ;
    throw e ;
  }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~  VGroup.getType ()
// ~
// ~  Return the type of this group as a string
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VGroup.prototype.getType = function()
{
  var sFunctionName= "VGroup.getType";
  debugMessage("Entering " + sFunctionName, 1) ;

  try{
    var sReturn = "" ;
    typeSwitch: switch (this.iType)
    {
      case VGroup.TYPE_DATE:
        sReturn = "date" ;
        break typeSwitch;
      default:
        sReturn = "unknown type" ;
    }
    return sReturn
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
  debugMessage("Leaving " + sFunctionName,-1) ;
}

VGroup.prototype.parseParameters = function(uoArguments) {
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // Description:
  //   Looks at the constructor parameter list and strips out the optional
  //   name / value parameter pairs.
  // Parameters:
  //   uoArguments - an array of arguments.  Usually the function.argument
  //   object from a previous call would be passed in.
  // Returns:  Nothing
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  var sFunctionName= "VGroup.parseParameters"

  try
  {
    debugMessage("Entering " + sFunctionName, 1) ;
    // ========================================
    // Parse optional parameters
    // ========================================
    // If there are no optional parameters, do nothing.
    if (uoArguments.length==1)
      throw new ErrorObject("VGroup must have more than just a single (iType) parameter passed in.") ;

    // Make sure there are an odd number of parameters as only one parameter
    // is manditory. A simple check value name and argument pairs have been used.
    if ((uoArguments.length % 2)==0)
      throw new ErrorObject("VGroup must have an even number of parameters") ;

    var value;
    // Iterate optional parameters.
    argumentsLoop: for (i=1; i < uoArguments.length; i += 2)
    {
      value=uoArguments[i+1] ;

      //  This switch statement will be expanded as and when extra formaters are requried.
      //  At the moment this only checks for a date mask and a long name.
      argumentsSwitch: switch (uoArguments[i])
      {
        // this will have the date mask.
        case VGroup.CHECK_MANDATORY:
            this.checkMandatory= value ;
            break argumentsSwitch;
        case VGroup.CHECK_FORMAT:
             this.checkFormat= value ;
             break argumentsSwitch ;
        // This will pass in the name of the VGroup instance.
        case VGroup.LONG_NAME:
             this.longName= value ;
             this.errorLongName = "<br/><strong>Grouping(Control) Name: " + value + "<br/>Reason(s): </strong><br/>";
             break argumentsSwitch ;
        default:
          throw new ErrorObject("Unknown attribute type within the VGROUP parms check.") ;
      }
    }

    debugMessage("Leaving " + sFunctionName, -1) ;
   }
   catch(e)
   {
    e.description += "\nVField.parseParameters." ;
    throw e ;
   }
}

VGroup.prototype.getUIValue= function() {
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // Description: Gets the current contents of the input field.
  // Parameters: appended grouping of VFields held in this group.
  // Returns: This will append all the VFields that exist in the VGroup.
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  var sFunctionName= "VGroup.getUIValue"

  try {
    debugMessage("Entering " + sFunctionName, 1) ;

  var appendedValue = "";

  for(var x=0; x < this.arrFields.length; x++)
  {
      appendedValue += this.arrFields[x].uoUIObject.value ;
  }

  debugMessage("Leaving " + sFunctionName, -1) ;

  return appendedValue;

  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::add ([uoContainer Object])
// ~
// ~  This will add a reference to the passed in container to the this.arrFields array.
// ~  Note that the uoContainer can be either a VField or a VTab object.
// ~
// ~  The parm passed into this function will be a VField object.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VGroup.prototype.add= function(uoContainer) {
  var sFunctionName= "VGroup::add" ;
  try {
    debugMessage("Entering " + sFunctionName, -1) ;

    // Many arguments may be passed in
    for (var i=0; i<arguments.length; i++) {
      // Extend the UOContainer class (which will be a VField) by
      // giving it a handle to the VForm (which is represented as a
      // property of VGroup- added in within the VForm::add function)
      arguments[i].uoVForm = this.uoVForm ;
      // Also give the VField container a reference to this Group class instance.
      // This is required as the onblur event will need to call the isValid.
      // The date will only be fully correct when the full date is correct.
      arguments[i].uoVGroup = this;

      // Now add the passed uoContainer to the this.arrFields array.
      this.arrFields[this.arrFields.length]= arguments[i] ;
    }
    debugMessage("Leaving VForm::" + sFunctionName, -1) ;
  }
  catch(e)
  {
      e.description += "\n" + sFunctionName ;
      throw e ;
  }
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::getFields ()
// ~
// ~   This will retrieve the this.arrFields array to the callee
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VGroup.prototype.getFields= function() {
  return this.arrFields
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::getNumberOfFields ()
// ~
// ~   This will retrieve the number of VField/VTab objects in the
// ~   this.arrFields array to the callee.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VGroup.prototype.getNumberOfFields= function() {
  return this.arrFields.length
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::isValid ()
// ~
// ~   This will do the following to validate whether the VGroup instance is valid:
// ~
// ~        1) Call the isValid methods of the individual VFields.
// ~               If this comes back as true then.....
// ~        2) VGroup will validate that the group level validator is correct
// ~
// ~    In the example of a date field split up into three different textboxes. The VGroup will
// ~    find out first that the three VFields are correct (checking they are numeric) and will
// ~    then (if this comes back as True) check that all three values represent a valid date.
// ~
// ~    The value returned will detail whether the VGroup (and all its associated VFields)
// ~    are valid.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

VGroup.prototype.isValid= function(bSetStyle) {

  var sFunctionName= "VGroup::isValid" ;
  var bIsValid = true;

  try
  {
        if ((this.arrFields.length!=0) && ((this.arrFields[0].uoUIObject.readOnly==true) || (this.arrFields[0].uoUIObject.disabled==true))) {
          debugMessage("Group readonly - not validating.");
          return true;
        }

        debugMessage("Entering " + sFunctionName, 1) ;
        this.uoMessageList.clear() ;

        if ((this.checkMandatory== false) && (this.getUIValue().length==0)) {
          // No point checking the empty value of a non-mandatory field
            for(var x=0; x < this.arrFields.length; x++)   {
                                     this.arrFields[x].setStyle(true) ;
                  }
        } else {

          // ~ First check that the individual VFields that make up the VGroup are all valid.
          for (var i=0; i < this.getNumberOfFields(); i++)
          {
            var uoField = this.arrFields[i] ;
            // for each field that needs to be validated on the tab- check that it is indeed valid.
            if (!uoField.isValid(true))
            {
            // If the field is not valid then retrieve the field name together with the
            // listing of errors associated with that field.

              this.uoMessageList.add(uoField.errorLongName + uoField.uoMessageList.toString());
              bIsValid = false;
            }
          }


          // ~ If the individual VFields are correct then we check that the Group level validation- the
          // ~ values from all the VFields added together are valid.
          if (bIsValid == true)
          {

            // alert("value " + this.getValue());
            // alert(this.uoDataValidator.isValid(this.getValue()));
              if (this.uoDataValidator.isValid(this.getFields()) == false)
              {
                // We have a false result- therefore set the background to error on all the
                // vFields within this grouping.
                for(var x=0; x < this.arrFields.length; x++)
                {
                   this.arrFields[x].setStyle(false) ;
                }
                bIsValid = false ;
                // alert(this.uoDataValidator.getHelpText().toString());
                this.uoMessageList.add(this.uoDataValidator.getHelpText().toString()) ;
              } else {
                // reset any error styles
                  for(var x=0; x < this.arrFields.length; x++)   {
                         this.arrFields[x].setStyle(true) ;
                  }

                }
          }
          else
          {
                for(var x=0; x < this.arrFields.length; x++)
                 {
                     this.arrFields[x].setStyle(false) ;
                 }
                bIsValid = false ;
          }
    }
   }
   catch(e)
   {
      e.description += "\n" + sFunctionName ;
      throw e ;
   }

 debugMessage("Leaving " + sFunctionName + " rtn value = " + bIsValid, 1) ;


  // false will be returned if at least one of the fields is invalid.
  return bIsValid
}


VGroup.prototype.finalise= function() {
  var sFunctionName = "VGroup.finalise (" + this.longName + ")" ;
  try {
    // Iterate through all "V" framework objects contained by this VGroup and ensure
    // that their finalisations are called (If they have one!)
    for (var i=0; i < this.getNumberOfFields(); i++) {
      if (this.arrFields[i].finalise != null) {
        this.arrFields[i].finalise() ;
      }
    }
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}