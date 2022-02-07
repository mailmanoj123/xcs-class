// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~ Debugging Functions
// ~ Version 0.1.
// ~ September 2002.
// ~ Desc :The collection of properties and methods here deals with showing
// ~ debug messages
// ~   - if they are required.
// ~
// ~ Steria Ltd.
// ~ Brian Ambrose, Paul Deevoy, Max Bodimeade.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// ======================================================================
// Cookie Class Code
// ======================================================================
function Cookie(uoDocument, name, hours, path, domain, secure) {
	this.$document= uoDocument ;
	this.$name = name ;
	if (hours)
		this.$expiration = new Date((new Date()).getTime() + hours * 3600000) ;
	else
		this.$expiration = null ;
	if (path) this.$path = path; else this.$path = null ;
	if (domain) this.$domain = path; else this.$domain = null ;
	if (secure) this.$secure = secure; else this.$secure = null ;
}

Cookie.prototype.store = function() {
	var cookieVal = "" ;
	for (var prop in this) {
		if ((prop.charAt(0)=='$') || ((typeof this[prop]) == 'function'))
			continue ;
		if (cookieVal != "") cookieVal += '&' ;
		cookieVal += prop + ':' + escape(this[prop]) ;
	}

	var cookie = this.$name + '=' + cookieVal ;
	if (this.$expiration)	cookie += '; expires=' + this.$expiration.toGMTString() ;
	if (this.$path) cookie += '; path=' + this.$path ;
	if (this.$path) cookie += '; domain=' + this.$domain ;
	if (this.$path) cookie += '; secure=' + this.$secure ;

	this.$document.cookie = cookie;
}

Cookie.prototype.load = function() {
	var allCookies = this.$document.cookie;
	if (allCookies == "") return false;

	var start=allCookies.indexOf(this.$name + '=');
	if (start == -1) return false;
	start += this.$name.length + 1;
	var end = allCookies.indexOf(';', start) ;
	if (end== -1) end=allCookies.length;
	var cookieVal = allCookies.substring(start, end) ;

	var a = cookieVal.split('&');
	for (var i=0; i<a.length; i++)
		a[i]=a[i].split(':');

	for (var i=0; i<a.length; i++) {
		this[a[i][0]] = unescape(a[i][1]);
	}

	return true ;
}

Cookie.prototype.remove = function() {
	var cookie;
	cookie = this.$name + '=' ;
	if (this.$path) cookie += '; path=' + this.$path ;
	if (this.$path) cookie += '; domain=' + this.$domain ;
	cookie += '; expires=Fri, 02-Jan-1970 00:00:00 GMT' ;

	this.$document.cookie = cookie;
}

// ======================================================================
// Debug Handler Code
// ======================================================================

// ~ This is a global catchall for all onkeydown events
// ~ It will redirect users to the GlobalKeyPressHandler function.
document.onkeydown= GlobalKeyPressHandler ;
document.onhelp= GlobalKeyPressHandlerONHELP;

// Create a cookie for storing the debug state
var debugCookie = new Cookie(document, "debug_state", 240);
debugCookie.load() ;
debugCookie.store() ;

// ~ Global flag to indicate if debugging is on or off
var bDebuggingOn= false ;
if (debugCookie.bDebuggingOn == "true") bDebuggingOn = true ;

// Global flag to indicate if validation is on or off
var bValidationOn = true ;
if (debugCookie.bValidationOn == "false") bValidationOn = false ;

// ~ Global flag to indicate if messages should go to an alert box or to the window status bar.
// ~ NOTE: the debug messages are thrown to a new browser window. It has been determined that
// ~       throwing out the errors to an alert box would be too much hassle.
// ~       However the code has been left in, just in case it is determined whether
// ~       or not this will change in the

var bDebuggingUseAlert= false;

// Global string to hold the current indentation
var iIndentation = 0;

var newWind;

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~ GlobalKeyPressHandlerONHELP function:
// ~
// ~ This is used to capture the global on_help events. This will nullify the ctrl-F1 key press
// ~ combination. F1 on its own will still fire off the IE help.
// ~ Note that the keydown method will still be called and will enter the GlobalKeyPressHandler
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function GlobalKeyPressHandlerONHELP() {
  //if (window.event.ctrlKey) window.event.returnValue='';
  window.event.returnValue='';
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~ GlobalKeyPressHandler function:
// ~ Event Bubbling will mean that key presses for ctrl-F1 ctrl-F2 and ctrl-F3 are handled in this method.
// ~ ctrl-F1 will be disabled here- this is to ensure the rather irksome IE help doesn't fire off (although
// ~         the user will still be able to get this when pressing just F1).
// ~ ctrl-F2 will toggle between the tags
// ~ ctrl-F10 will toggle the debug on or off
// ~ ctrl-F11 will toggle validation on or off
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function GlobalKeyPressHandler() {

  if (hasLogoffTimer)
    if (logoffTimer < 29) resetLogoffTimer() ;

        // The f2 and f3 button presses will only fire off if the control button is
	// being pressed too.
	if (window.event.ctrlKey) {

		keyCodeSwitch: switch(window.event.keyCode) {
			case (112):
				// the user toggles between throwing the help out to a popup or a new browser window.
				// however this will only work if the focus is in a particular element.
				// As such we will disable (for the moment) all CNTRL-F1 calls executed whilst outside
				// of a particular element.

				// As mentioned above we've disabled the ability for the people to toggle between alert
				//  boxes and a new browser window. Debug will always throw info to a new browser window.
				// The code has been left in just in case.........
				/* --
				if (bDebuggingUseAlert == true) {
					bDebuggingUseAlert = false;
					RtnStatusMessage() ;
				} else {
					bDebuggingUseAlert = true;
					RtnStatusMessage() ;
				}
				window.event.returnValue='';
				-- */
				break keyCodeSwitch ;

			case (113):
				// This will pick up CTRL-F2 button presses- and will toggle between all the
				// available tabs.
				if (document.all.tab1 != null) {
					var iTotalTabs=1 ;
					var iVisibleTab = 0 ;
					var sTemp = "" ;
					while (eval("document.all.tab" + iTotalTabs)!=null) {
						sTemp = eval("document.all.tab" + iTotalTabs + ".style.display") ;
						if (sTemp != 'none') {
							iVisibleTab=iTotalTabs
						}
						iTotalTabs++ ;
					}
					if (iTotalTabs-1 > iVisibleTab) {
						showTab(iVisibleTab+1);
					}	else {
						showTab(1)
					}
					window.event.returnValue='';
					break keyCodeSwitch;
				}

			case (121):
				// This will pick up CTRL-F10 button presses- and will toggle the debug on and off.
				// All debug messages will be thrown to a new browser.
				if (bDebuggingOn == true) {
					bDebuggingOn = false;
					debugCookie.bDebuggingOn = "false" ;
					RtnStatusMessage() ;
				} else {
					bDebuggingOn = true;
					debugCookie.bDebuggingOn = "true" ;
					RtnStatusMessage() ;
				}
				debugCookie.store() ;
				window.event.returnValue='';
				break keyCodeSwitch;

			case (122):
				// This will pick up CTRL-F11 button presses - and toggles validation on and off.
				if (bValidationOn) {
					bValidationOn = false ;
					debugCookie.bValidationOn = "false" ;
					RtnStatusMessage()
				} else {
					bValidationOn = true ;
					debugCookie.bValidationOn = "true" ;
					RtnStatusMessage()
				}
				debugCookie.store() ;
				window.event.returnValue='';
				break keyCodeSwitch;

			case (123):
				// CTRL-F12
				getInputTagNames() ;
				window.event.returnValue='';
				break keyCodeSwitch ;
		}
	} else {

          switch (window.event.keyCode) {
            case (8):
              if ((event.srcElement.type!="text") && (event.srcElement.type!="textarea") && (event.srcElement.type!="password"))
                window.event.returnValue=false;
              break;
            case (37):
              if (window.event.altKey)
                window.event.returnValue=false;
              break;
            case (39):
              if (window.event.altKey)
                window.event.returnValue=false;
              break;
          }
        }
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~ RtnStatusMessage - "private" function.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function RtnStatusMessage() {
  var rtnString;
  debugSwitch: switch(true){
    case (bDebuggingOn == false):
      rtnString = "Debug OFF";
      break debugSwitch;
    case (bDebuggingUseAlert == true):
      rtnString = "Debug ON- via Alert Boxes";
      break debugSwitch;
    default:
      rtnString = "Debug ON- via new browser window";
  }

		if (bValidationOn) {
			rtnString += ".  Validation ON." ;
		} else {
			rtnString += ".  Validation OFF." ;
		}

  window.status = rtnString;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~ debugMessage:
// ~
// ~  This function is called instead of the alert function- through this we can keep our
// ~    debug messages within our code.
// ~
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function debugMessage(sMessage) {
  // iLevel -
  // sMessage - user supplied debug message
  var sOutput= "" ;
  var iIndentationAdjustment = 0 ;
  var iSeverity = 0 ;

  if (bDebuggingOn) {
    if (arguments.length > 1) iIndentationAdjustment = arguments[1] ;
    if (arguments.length > 2) iSeverity = arguments[2] ;

    if (iIndentationAdjustment < 0) iIndentation += iIndentationAdjustment ;

    if (bDebuggingUseAlert) alert(sMessage) ; else {
      newWind= window.open("","subwindow","HEIGHT=400,WIDTH=400,menubar, resizable,scrollbars");
      if (iIndentation > 0) {
        for (i=0; i<iIndentation; i++) {
          sOutput += "&nbsp;&nbsp;&nbsp;&nbsp;"
        }
      }

      sOutput += sMessage + "<br>" ;
      newWind.document.write(sOutput) ;
    }
  }

  if (iIndentationAdjustment> 0) iIndentation += iIndentationAdjustment ;
}

function getInputTagNames() {
  if (document.forms.length != 0) {
    var uoForm=document.forms[0] ;
    if (uoForm.elements.length != 0) {
      var elementWind= window.open("","subwindow","HEIGHT=400,WIDTH=400,menubar, resizable,scrollbars");
      var uoElements=uoForm.elements ;
      for (var i=0; i<uoElements.length; i++) {
        if ((uoElements[i].type=="text") || (uoElements[i].type=="textarea")) {
          elementWind.document.write(uoElements[i].name + "<br>")
        }
      }
    }
  }
}

// Trim Functions following are:
//
// Trim  - trims whitespace from a string
// LTrim - trims whitespace before a string
// RTrim - trims whitespace after a string.

function Trim(orgString)
{
   return LTrim(RTrim(orgString));
}

function LTrim(orgString)
{
  return orgString.replace(/^\s+/,'');
}

function RTrim(orgString)
{
  return orgString.replace(/\s+$/,'');
}


