// Message list class MessageList.
// Version 0.1.

// September 2002.

// Steria Ltd.
// Brian Ambrose, Paul Deevoy, Max Bodimeade.

// Constructor
function MessageList() {
	this.clear()
}

MessageList.prototype.add = function (sMessage) {
  this.sMessageList[this.sMessageList.length] = sMessage
}

MessageList.prototype.get = function() {
	return this.sMessageList
}

MessageList.prototype.length = function() {
	return this.sMessageList.length
}

MessageList.prototype.clear = function() {
  this.sMessageList = new Array()
}

MessageList.prototype.toString = function() {
  sReturnValue = "" ;
	for (i=0; i < this.sMessageList.length; i++) {
	  sReturnValue += "\n" + this.sMessageList[i]
	}
	return sReturnValue
}