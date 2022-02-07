// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm
// ~
// ~  functions included:
// ~    single constructor:
// ~
// ~  This class is a wrapper for the form container defined within the html page.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VTab Constructor::VTab ([tab(div) object])
// ~
// ~   uoUIObject (the single parameter) represents the form container as defined on the.
// ~   html page. This html form will be a container to 1 or more elements which need to be
// ~   validated.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

function VForm(uoUIObject) {

  var sFunctionName= "VForm.constructor" ;

  try {
      debugMessage("Entering " + sFunctionName, 1) ;

      this.uoUIObject= uoUIObject ;
      uoUIObject.uoVForm= this ;
      uoUIObject.onsubmit= function() {return this.uoVForm.onsubmit_Handler()}

      this.uoHelpDiv = new positionLayer(2) ;
      this.uoMessageList= new MessageList() ;
      this.arrFields= new Array()
      // Default this object's name to that of the UI control
      this.longName= this.uoUIObject.name ;

      debugMessage("Leaving " + sFunctionName, -1) ;
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
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VForm.prototype.add= function() {
  var sFunctionName= "VForm::add" ;
  debugMessage("Entering VForm::" + sFunctionName, -1) ;

  try {
    // Many arguments may be passed in
    for (var i=0; i<arguments.length; i++) {
      // Extend the UOContainer class by giving it a handle to this VForm into the
      // passed in container (this can be either a VField or a VTab)
      arguments[i].uoVForm = this ;

      // Now add the passed uoContainer to the this.arrFields array.
      this.arrFields[this.arrFields.length]= arguments[i] ;
    }
    debugMessage("Leaving VForm::" + sFunctionName, -1) ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::getFields ()
// ~
// ~   This will retrieve the this.arrFields array to the callee
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VForm.prototype.getFields= function() {
  return this.arrFields
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::getNumberOfFields ()
// ~
// ~   This will retrieve the number of VField/VTab objects in the
// ~   this.arrFields array to the callee.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VForm.prototype.getNumberOfFields= function() {
  return this.arrFields.length
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::isValid ([boolean]) rtn boolean.
// ~
// ~   This will check that all the fields on the form (and fields on any tabs) are valid.
// ~   It will loop round all the vfields- adding any error messages to the this.uoMessageList
// ~
// ~   The boolean returned will tell the callee whether all the VFields are valid or not.
// ~
// ~   The boolean passed in is used to determine whether or not the callee wants the
// ~   background color to change if the VField is invalid
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VForm.prototype.isValid= function(bSetStyle) {
var sFunctionName= "VForm::isValid" ;
  debugMessage("Entering " + sFunctionName, 1) ;

  try {
    var bIsValid= true ;
    if (bValidationOn) {
      this.uoMessageList.clear() ;

      for (var i=0; i < this.getNumberOfFields(); i++) {
        var uoField = this.arrFields[i] ;
        if (!uoField.isValid(bSetStyle)) {
          if (uoField.uoMessageList.length() > 0) {
            this.uoMessageList.add(uoField.errorLongName + uoField.uoMessageList.toString());
            //this.uoMessageList.add(uoField.uoMessageList.toString());
          }
          bIsValid = false
        }
      }
    }
    debugMessage("Leaving VForm::" + sFunctionName + " rtn value = " + bIsValid, -1) ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }

  return bIsValid
}


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::initialise ()
// ~
// ~   This will initialise the position layer class- and in particular create the Help Div
// ~   that will be used to show the help and/or errors in the popup.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VForm.prototype.initialise= function(bValidate) {
  this.uoHelpDiv.initialise("HelpDiv") ;
  if (bValidate) this.isValid(true)
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VForm function::onsubmit_Handler () rtn boolean
// ~
// ~   This will be the function fired off when the submit event is fired off.
// ~   It will go through all the VFields and VTabs (and their respective VFields)
// ~   and check that everything is valid.
// ~
// ~   A boolean will be returned to the callee determining whether or not the
// ~   all the VFields are valid or not.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VForm.prototype.onsubmit_Handler= function() {

  if (this.isValid(true))
  {
    return true
  }
  else
  {
   if (this.uoMessageList.length() > 0)
   {
      // need to ensure that the output is thrown to a new window rather than
      // a popup.
      if (this.uoHelpDiv.LayerType == 1) {this.uoHelpDiv.switchLayer()}
      // now throw the output to this new window.
      this.uoHelpDiv.ShowHideLayer(this.uoMessageList.toString(), this.uoUIObject);
      // alert(this.uoMessageList.toString()) ;

   }
    return false;
  }
}

VForm.prototype.finalise= function() {
  var sFunctionName = "VForm.finalise (" + this.longName + ")" ;
  debugMessage("Entering VForm." + sFunctionName, 1) ;

  try {
    // Iterate through all "V" framework objects contained by this VForm and ensure
    // that their finalisations are called (If they have one!)
    for (var i=0; i < this.getNumberOfFields(); i++) {
      if (this.arrFields[i].finalise != null) {
        this.arrFields[i].finalise() ;
      }
    }
    // Set all references in the DOM object to this VForm object to null
    // This ensures that memory is freed.
    this.uoUIObject.uoVForm = null ;
    this.uoUIObject.onsubmit = null ;
    this.uoUIObject = null ;

    debugMessage("Leaving VForm." + sFunctionName, -1) ;
 } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}