// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VTab
// ~
// ~  functions included:
// ~    single constructor:
// ~
// ~  This class is a wrapper for the tab container placed onto the form
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VTab Constructor::VTab ([tab(div) object])
// ~
// ~   uoUIObject (the single parameter) represents the tab container- which will be.
// ~   a div tag. This tag will be a container to 1 or more elements which need to be
// ~   validated.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function VTab(uoUIObject) {

  var sFunctionName= "VTab::constructor" ;

  try {
        debugMessage("Entering " + sFunctionName, 1) ;

        // this.uoUIObject will hold a handle to the incoming tab (or div in this case).
        this.uoUIObject= uoUIObject ;
        //  Give the incoming tab (or div in this case) a handle to this VTab class.
        //  This is required so that all the events are able to work correctly. Although
        //  at this moment there are no events associated with the Tab wrapper.
        uoUIObject.uoVTab= this ;

        // this.uoMessageList is an array which will hold all the errors.
        this.uoMessageList= new MessageList() ;
        // this.arrFields holds all the elements on the tab which require validation.
        this.arrFields= new Array()
        this.longName= this.uoUIObject.id ;
        this.errorLongName = "<br/><strong>Errors determined on the following Tab: " + this.uoUIObject.id + "</strong><br/>";

  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
    debugMessage("Leaving VTab::constructor",-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VTab function::add ([vField Object])
// ~
// ~   This will add a VField to the this.arrFields array
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VTab.prototype.add= function(uoField) {
  var sFunctionName= "VTab.add" ;

  try {
    debugMessage("Entering VTab::" + sFunctionName, 1) ;

    // Many arguments may be passed in
    for (var i=0; i<arguments.length; i++) {
      // Add the field to the list of fields on this form
      this.arrFields[this.arrFields.length]= arguments[i] ;

      // Extend the uoField class by giving it a handle to both the VTab (this object)
      // and also the VForm object.
      arguments[i].uoVForm = this.uoVForm ;
      arguments[i].uoVTab = this ;
    }

    debugMessage("Leaving VTab::" + sFunctionName, 1) ;
  } catch(e) {
    e.description += "\n" + sFunctionName ;
    throw e ;
  }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VTab function::getFields ()
// ~
// ~   This will retrieve the this.arrFields array to the callee
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VTab.prototype.getFields= function() {
  return this.arrFields
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VTab function::getNumberOfFields ()
// ~
// ~   This will retrieve the number of VField objects in the
// ~   this.arrFields array to the callee.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VTab.prototype.getNumberOfFields= function() {
  return this.arrFields.length
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::VTab function::isValid (boolean) rtn boolean
// ~
// ~   This will retrieve the number of VField objects in the
// ~   this.arrFields array to the callee.
// ~
// ~   The boolean returned will tell the callee whether all the VFields on the Tab are
// ~   valid or not.
// ~
// ~   The boolean passed in is used to determine whether or not the callee wants the
// ~   background color to change if the VField is invalid
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
VTab.prototype.isValid= function(bSetStyle) {

  var sFunctionName= "VTab.add" ;
  var bIsValid;

  try {
        debugMessage("Entering VTab::" + sFunctionName, 1) ;

        bIsValid= true ;
        this.uoMessageList.clear() ;
        for (var i=0; i < this.getNumberOfFields(); i++)
        {
          var uoField = this.arrFields[i] ;
        // for each field that needs to be validated on the tab- check that it is indeed valid.
          if (!uoField.isValid(bSetStyle))
          {
          // If the field is not valid then retrieve the field name together with the
          // listing of errors associated with that field.

            this.uoMessageList.add(uoField.errorLongName + uoField.uoMessageList.toString());
            bIsValid = false;

          }
        }

  } catch(e) {
      e.description += "\n" + sFunctionName ;
      throw e ;
  }

 debugMessage("Leaving VTab::" + sFunctionName + " rtn value = " + bIsValid, 1) ;


  // false will be returned if at least one of the fields is invalid.
  return bIsValid
}

VTab.prototype.finalise= function() {
  var sFunctionName = "VTab.finalise (" + this.longName + ")" ;
  try {
    // Iterate through all "V" framework objects contained by this VTab and ensure
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