// Error Handler Object class ErrorObject.
// Version 0.1.

// September 2002.

// Steria Ltd.
// Brian Ambrose, Paul Deevoy, Max Bodimeade.

// Constructor
function ErrorObject(sMessage) {
  // ErrorObject Constructor
  // sClass - the name of the class that is raising this error
	// sMessage - user supplied error message
	
  this.description = "\"" + sMessage + "\".\n";
	this.bSevereError = true ;
}

ErrorObject.prototype.add = function (sFunctionName) {
  this.description = this.description + (sFunctionName + ".\n");
}