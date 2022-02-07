var submitting=false;
var narrativeBeingSaved=false; // This flag required as part of the fix for Remedy 17752

/*
* This function will not return until (at least)
* the specified number of milliseconds have passed.
* It does a busy-wait loop.
*/
function pause(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return;
    }
}
    
  

// Call the validation framework finalisation to ensure
// all memory is freed before submitting.
// if (document.forms[0].uoVForm != null) {
//   document.forms[0].uoVForm.finalise() ;
// }
// This block of code fixes a bug associated with claim narratives.
// It became apparent during testing of	remedy 17752.  Unless an alert
// is used before submitting the form, truncated data is received by the
// OC4J server.  
function submitMethod() {
  submitting=true; 
  if (document.forms[0] != null) {
   if (document.forms[0].narr != null) {
     if (narrativeBeingSaved == true) {
       alert ('Saving narrative to database.') ;
     }
   }
  }   
  //pause(1000);
  document.forms[0].submit();  
  var showSplash = false;
  for (i=0;i<document.forms[0].elements.length;i++) {
    if (document.forms[0].elements[i].type!="hidden" && document.forms[0].elements[i].type!="submit") {
      showSplash=true;
      break;
    }
  }
  if (document.forms[0].elements.length>0 && showSplash) {
    document.all.mainTable.style.display='none';
    document.all.splash.style.display='';
  }  
  return false;
}

function closeWindow() {
  if (!isPrimarySession()) {
    try {
      window.opener.resetLogoffTimer();
    } catch(e) {

    }
  }
  window.close();
}

function removeCommas(value) {
  while (value.indexOf(",")>-1) {
    value = value.substring(0,value.indexOf(",")) + value.substring(value.indexOf(",")+1);
  }
  return value;
}

function isPrimarySession() {
  try {
    if ((window.opener==null) || (window.opener.window.opener==null))
      return true;
    else
      return false;
  } catch (e) {
    return true;
  }
}

function appendSessionId(target,newsession) {
  var target;
  newsession = newsession!=null?newsession:false;
  var s = newsession?"":sessionid;
  if (target.indexOf("?")==-1) {
    target = target + ";jsessionid=" + s;
  } else {
    target = target.substring(0,target.indexOf("?")) + ";jsessionid=" + s + target.substring(target.indexOf("?"));
  }
  return target;
}

function winCloseCheck(dontLogoff) {
  //if (document.forms[0].uoVForm != null)
  //  document.forms[0].uoVForm.finalise();
  if (dontLogoff==null)
    dontLogoff=false;
  if (!submitting) {
    if (!dontLogoff)
      var lWin = window.open(appendSessionId("logoff?ts=" + new Date().getTime() + "&closeWindow=true&primarySession=" + isPrimarySession()),"","directories=no,location=no,menubar=no,resizable=no,status=no,toolbar=no,scrollbars=no,width=200,height=100,top=" + screen.height);
    window.close();
  }
}

function back() {
  if (!submitting) {
    submitting=true;
    history.go(-1);
  }
}

function logoff(quiet) {
  if (quiet!=true)
    conf = confirm("Are you sure you want to logoff?");
  else
    conf = true;

  if (conf) {
    submitting=true;
    /* submits http get request to logoff */
    if (isPrimarySession())
      document.location=appendSessionId("logoff?ts=" + new Date().getTime() + "&primarySession=true");
    else
      document.location=appendSessionId("logoff?ts=" + new Date().getTime() + "&closeWindow=true&primarySession=false");
  }
}

function errorBack() {
  if (!submitting) {
    if ((history.length==0) && (window.opener!=null)) {
      logoff(true);
    } else {
      if ((window.location + "").indexOf("marketdetails")>-1) {
        submitForm("marketdetailserror");
      }
      else if ( (window.location + "").indexOf("scUpdateItem")>-1){
        submitForm("scUpdateError");
      }
      else if ((window.location + "").indexOf("ignoreWarnings=true")>-1) {
        submitting = true;
        history.go(-2);
      }
      else if ((window.location + "").indexOf("/premcompok")>-1) {
        submitForm("claimtransactioncreation");
      }
      else {
        submitting = true;
        history.go(-1);
      }
    }
  }
}

function submitForm(target) {
  if (!submitting) {
    var bFormValid = false ;

    if (document.forms[0].uoVForm != null) {
      // There is a VForm for this screen
      if ((arguments.length > 1) && (arguments[1] == false)) {
        // 2nd parameter was provided and it indicates validation is NOT to be called
        // therefore always indicate that this form is valid.
        bFormValid = true ;
      } else {
        // Either:
        // there was no 2nd parameter, so by default validation will be called, or
        // there was a 2nd parameter and its true value indicates validation to be called.
        bFormValid = document.forms[0].uoVForm.onsubmit_Handler() ;
      }
    } else {
      // There is no VForm for this screen, it will always be valid.
      bFormValid = true ;
    }

    if (bFormValid == true) {
      if (hasLogoffTimer)
        disableLogoffTimer();

      for (i=0;i<document.forms[0].elements.length;i++) {
        document.forms[0].elements[i].disabled=false;
        if ((document.forms[0].elements[i].uoVField!=null) && (document.forms[0].elements[i].uoVField.iType!=null) && (document.forms[0].elements[i].uoVField.iType==3))
          document.forms[0].elements[i].value=removeCommas(document.forms[0].elements[i].value);
      }

      var prefix = target.indexOf("?")>-1?"&":"?";
      document.forms[0].action=appendSessionId(target + prefix + "primarySession=" + isPrimarySession());
      document.forms[0].method="post";      
      document.forms[0].submitButton.click();
      //document.forms[0].submit();
      //submitting=true;
    }
  }
}

function newWindow(target) {
  if (!submitting) {
    disableLogoffTimer();
    var prefix = target.indexOf("?")>-1?"&":"?";
    var newWindowParams = "account=" + account + "&username=" + username +
                          "&section=" + section + "&primarySessionNo=" + primarySessionNo +
                          "&secondarySessionNo=" + secondarySessionNo +
                          "&screenMode=" + screenMode;
    window.open(appendSessionId(target + prefix + newWindowParams + "&primarySession=false&ts=" + new Date().getTime(),true),"","height=500, width=800, top=" + (screen.height-500)/2 + ", left=" + (screen.width-800)/2 + ", location=false, menubar=false, status=yes, toolbar=false, scrollbars=yes, resizable=yes");
  }
}

function showHelp(target) {
  if (!submitting) {
    //CURRENTLY USING STUB HELP FILE. SWITCH COMMENTS WHEN HELP TEXT UPLOADED.
    //window.open("/help/nohelp.htm","","height=500, width=500, top=" + (screen.height-500)/2 + ", left=" + (screen.width-500)/2 + ", location=false, menubar=false, status=yes, toolbar=false, scrollbars=yes, resizable=yes");
    window.open("/help/" + target + ".htm","","height=600, width=800, top=" + (screen.height-500)/2 + ", left=" + (screen.width-500)/2 + ", location=false, menubar=false, status=yes, toolbar=false, scrollbars=yes, resizable=yes");
  }
}

function goTo(target) {
  if (!submitting) {
    submitting = true;
    var prefix = target.indexOf("?")>-1?"&":"?";
    document.location=appendSessionId(target + prefix + "primarySession=" + isPrimarySession());
  }
}

function showHide(target) {
  if (target.style.display!=null) {
    if (target.style.display=="")
      target.style.display="none";
    else
      target.style.display="";
  }
}

function updateUcr(hiddenField,ucrPt1,ucrPt2,ucrPt3) {
  hiddenField.value=ucrPt1.value + ucrPt2.value + ucrPt3.value;
}

// Fix for SIR 41158
// Build the value from its constituents
// Patrick Cogan
function updateUmr(hiddenField,umrb,umrbn,umranum) {
  hiddenField.value=umrb.value + umrbn.value + umranum.value;
}

function updateOsnd(hiddenField,osndSssss,osndDd,osndMm,osndYy) {
  var temp="";
  if (osndYy.value>30)
    temp+="19";
  else
    temp+="20";
  temp+=osndYy.value + osndMm.value + osndDd.value + osndSssss.value;
  hiddenField.value=temp;
}

function updateTdn(hiddenField,tdnPt1,tdnPt2) {
  if (tdnPt2.value.length==8)
    hiddenField.value=tdnPt2.value.substring(4,8) + tdnPt2.value.substring(2,4) + tdnPt2.value.substring(0,2) + tdnPt1.value;
}

function updateGroupRef(hiddenField,groupRefPt1,groupRefPt2) {
  hiddenField.value=groupRefPt1.value + "/" + groupRefPt2.value;
}

function updateCor(hiddenField,cor) {
  var s = cor.value;
  for (i=0; i<s.length; i++) {
    if ((s.charAt(i)==' ') || (s.charAt(i)=='\\') || (s.charAt(i)=='/') || (s.charAt(i)=='-'))
      s=s.substring(0,i) + s.substring(i+1,s.length);
  }
  hiddenField.value=s;
}

function updateDate(hiddenField,dd,mm,yyyy) {
  hiddenField.value=yyyy.value + "-" + mm.value + "-" + dd.value;
}

var tip=0;
function createToolTip(text,maxlength) {
  if (text.length<maxlength) {
    document.write(text);
  } else {
    document.write("<span id='tool" + tip + "' onmouseout='hideTip(tip" + tip + ")' onmouseover='showTip(tip" + tip + ",-3,-3)' class='tool'>" + text.substring(0,maxlength) + "...</span>");
    document.write("<table cellpadding='0' cellspacing='0' showMe='false' id='tip" + tip + "' onmouseover='showTip(this,-3,-3)' onmouseout='hideTip(this)' class='toolTip' style='display:none;z-index:100'><tr><td>" + text + "</td></tr></table>");
    tip++;
  }
}
function createRowTip(row,id,text) {
  document.write("<table cellpadding='0' cellspacing='0' showMe='false' id='" + id + "' onmouseover='showTip(this,0,0)' onmouseout='hideTip(this)' class='toolTip' style='display:none;z-index:100'><tr><td>" + text + "</td></tr></table>");
  row.onmouseout=function anonymous () { hideTip(eval(id)); };
  row.onmouseover=function anonymous () { showTip(eval(id),-1,1); };
}
function showTip(tip,x1,y1) {
  tip.showMe=true;
  // alert(tip.style.display);
  if (tip.style.display!='') {
    tip.style.display='';
    var tw = tip.clientWidth;
    var th = tip.clientHeight;
    tip.style.display='none';
    var x = ((getAbsPos(event.srcElement,"Left") + tw) < getParentDiv(tip).clientWidth)?getAbsPos(event.srcElement,"Left"):getParentDiv(tip).clientWidth-tw-1;
    var y = ((getAbsPos(event.srcElement,"Top") + th) < getParentDiv(tip).clientHeight)?getAbsPos(event.srcElement,"Top"):getParentDiv(tip).clientHeight-th;
    tip.style.position='absolute';
    tip.style.left=x + x1;
    tip.style.top=y + y1;
    tip.style.display='';
  }
}
function hideTip(tip) {
  tip.showMe=false;
  setTimeout(function test() { if (!tip.showMe) tip.style.display='none'; },100);
}
function getAbsPos(CntrlHandle, PositionType)
{
  iPos = 0;
  while ((CntrlHandle != null) && (CntrlHandle.className != "scrollmain") && (CntrlHandle.className != "noscroll"))
  {
    iPos += CntrlHandle["offset"+PositionType];
    CntrlHandle = CntrlHandle.offsetParent;
  }
  return iPos;
}
function getParentDiv(CntrlHandle, PositionType)
{
  var CntrlHandle;
  while ((CntrlHandle != null) && (CntrlHandle.className != "scrollmain") && (CntrlHandle.className != "noscroll"))
  {
    CntrlHandle = CntrlHandle.offsetParent;
  }
  return CntrlHandle;
}

// ---------- Begin Multi-Key Select (MKS) code. ----------
var mksKeyed = "";
var mksMaxLength=7;

var mksExactMatchFound = false ;
var mksPartialMatchFound = false ;
var mksMatchFoundString = "" ;

var mksCurrentShow = false ;
var mksCurrentControl = null ;
var mksCurrentText = "" ;


function mksGetAbsPos(uoControl, sPositionType)
{
  var iPos = 0;
  while (uoControl != null)
  {
        iPos += uoControl["offset"+sPositionType];
        uoControl = uoControl.offsetParent;
  }
  return iPos;
}

function mksOnPopupChange() {
        mksShowPopup(mksCurrentShow, mksCurrentControl, mksCurrentText) ;
}

function mksShowPopup(bShow, uoControl, sText) {
        // Get a handle to the popup layer
        uoPopup = document.getElementById("selectPopup")

        // Save the current parameters
        mksCurrentShow = bShow ;
        mksCurrentControl = uoControl ;
        mksCurrentText = sText ;

        if (bShow) {
                // set the popup text
                uoPopup.innerHTML = sText;

                // Position the popup off screen and show to resize the window
                uoPopup.style.left = 0 ;
                uoPopup.style.top = -30 ;
                uoPopup.style.visibility = "visible" ;
                uoPopup.style.visibility = "hidden";

                // Get the xPos and yPos which define the bottom left point of the control
                var xPos = mksGetAbsPos(uoControl, "Left");
                var yPos = mksGetAbsPos(uoControl, "Top") - uoPopup.offsetHeight - 2 ;
                if (eval("document.all.scrollpane" + getTab())!=null)
                  yPos -= eval("document.all.scrollpane" + getTab() + ".scrollTop");

                // Get the size of the viewport
                var screenWidth = document.body.offsetWidth ;

                var xMax = screenWidth - uoPopup.offsetWidth - 40
                if (xPos > xMax) {
                        var xTry = xPos - (uoPopup.offsetWidth - uoControl.offsetWidth) - 2;
                        if (xTry > xMax) {
                                xTry = screenWidth - uoPopup.offsetWidth - 40;
                        }
                        uoPopup.style.left = xTry ;
                } else {
                        uoPopup.style.left = xPos ;
                }
                uoPopup.style.top  = yPos ;
                uoPopup.style.visibility = "visible";

                window.onresize = function () {mksOnPopupChange();}
        } else {
                uoPopup.style.visibility = "hidden";
                window.onresize = null ;
        }
}

function mksShowSearchPattern(bShow, uoSelect)
{
        var sOutput = "" ;
        var sStatus = "" ;
        if ((bShow==true) && mksKeyed.length > 0) {
                sOutput = 'Searching for "<strong>' + mksKeyed + '</strong>"';
                sStatus = 'Searching for "' + mksKeyed + '"';
                if (mksExactMatchFound) {
                        sOutput += ", match found." ;
                        sStatus += ", match found." ;
                } else if (mksPartialMatchFound) {
                        sOutput += ', best match found: "<strong>' + mksMatchFoundString + '</strong>"' ;
                        sStatus += ', best match found: "' + mksMatchFoundString + '"' ;
                } else {
                        sOutput += ", no match found." ;
                        sStatus += ", no match found." ;
                }
        }

        window.status=sStatus ;
        mksShowPopup(bShow, uoSelect, sOutput) ;
}

function mksAddEventHandler (uoEvent, uoNewHandler) {
        if (uoEvent == null) {
                return uoNewHandler ;
        } else {
                if (!uoEvent.hasManyHandlers) {
                        var newMasterHandler = function() {
                                for (var i=0; i<newMasterHandler.handlers.length; i++) {
                                        newMasterHandler.handlers[i]() ;
                                }
                        }
                        newMasterHandler.hasManyHandlers = true ;
                        newMasterHandler.handlers = new Array() ;
                        newMasterHandler.handlers[0] = uoEvent ;
                        newMasterHandler.handlers[1] = uoNewHandler ;
                        return newMasterHandler ;
                } else {
                        uoEvent.handlers[uoEvent.handlers.length] = uoNewHandler ;
                        return uoEvent ;
                }
        }
}

//  Patrick Cogan:
//  For fix to SIR 37546: To get the codes to always update, 
//  created a custon onChange event and dissabled the one in main.js.mksInitialise() 
//  Sachin Goyal
//  In case of mks init is called explicitly dont init through it.
function mksInitialise() {
		if(document.getElementById('customMKSInit'))
		{
			return;
		}
		
        // Get all the select tags in this document
        var selectTags = document.all.tags("select") ;
        for (var i=0; i<selectTags.length; i++) {
                // Check the select for suitability.
                // If it has less than ten items or all of the items are only a single
                // character then do not register this helper.
                if (selectTags[i].options.length > 10) {
                        var bSuitable = false ;
                        suitabilityCheck: for (var e=0; e<selectTags[i].length; e++) {
                                if (selectTags[i].options[e].text.length > 1) {
                                        bSuitable = true ;
                                        break suitabilityCheck ;
                                }
                        }
                        if (bSuitable) {
                        	var useOnChange = true;
                        	if(selectTags[i].name !=null ){
                        	  useOnChange = (selectTags[i].name == "lawyerName")?false:true && (selectTags[i].name == "adjusterName")?false:true;
                        	}
                                selectTags[i].onfocus= mksAddEventHandler(
                                        selectTags[i].onfocus,
                                        function(){mksResetSelect()}
                                ) ;

                                selectTags[i].onblur=mksAddEventHandler(
                                        selectTags[i].onblur,
                                        function(){mksResetSelect(); mksShowSearchPattern(false, null)}
                                ) ; 

                                selectTags[i].onkeydown=mksAddEventHandler(
                                        selectTags[i].onkeydown,
                                        function(){mksKeyDown(this)}
                                ) ;

                                selectTags[i].onkeypress=mksAddEventHandler(
                                        selectTags[i].onkeypress,
                                        function(){mksKeyPress(this)}
                                );
																
																if(useOnChange){// PRC Added for fix to SIR  */
	                                selectTags[i].onchange = mksAddEventHandler(
	                                        selectTags[i].onchange,
	                                        function() {mksResetSelect()}
	                                ) ; 
																} 
                        }
                }
        }

        document.write('<div id="selectPopup" name="selectPopup" class="selectPopup"></div>') ;
		
}

function mksResetSelect() {
        mksKeyed = "";
        mksPartialMatchFound = false ;
        mksMatchFoundString = "" ;
        mksShowSearchPattern(false);
}

function mksKeyDown(uoSelect) {
        // Get key code
        var kp= event.keyCode;

        keyPressSwitch:switch (kp) {
                case 8:  // Backspace
                        if (mksKeyed.length > 1) {
                                mksKeyed = mksKeyed.substring(0,mksKeyed.length-1) ;
                                mksSearch(uoSelect) ;
                        } else {
                                mksResetSelect() ;
                        }
                        break keyPressSwitch ;
                case 32: // Space
                        if (mksKeyed.length!=0) mksKeyed+=" ";
                        mksSearch(uoSelect) ;
                        break keyPressSwitch ;
                case 38: // Up arrow
                case 40: // Down arrow
                        mksResetSelect();
                        break keyPressSwitch ;
                case 9: // tab
                        mksResetSelect();
                        break keyPressSwitch ;
                default:
                        // Any other keypress:
                        break keyPressSwitch ;
        }
}

function mksKeyPress(uoSelect) {
        // Get key code
        var kp= event.keyCode;

        // Check keypress was a displayable 7-bit ASCII character
        // or was either ENTER or BACKSPACE
        if ((kp>=32) && (kp<=127)) {
                // If the maximum search string length has been reached,
                //   remove the last search string character
                if (mksKeyed.length==mksMaxLength)
                        mksKeyed=mksKeyed.substring(0,mksKeyed.length-1) ;
                // Add the key press character to the search string
                mksKeyed+=String.fromCharCode(kp)

                mksSearch(uoSelect) ;
        }
}

function mksSearch(uoSelect) {
  // Search the select tag options
  mksExactMatchFound = false ;

  var up = mksKeyed.toLowerCase() >= uoSelect[uoSelect.selectedIndex].text.toLowerCase();
  var i = uoSelect.selectedIndex;

  optionLoop:for (; i<uoSelect.options.length && i>=0; up?i++:i--) {
          var sLoopOption = uoSelect.options[i].text.substring(0, mksKeyed.length).toLowerCase() ;
          mksKeyed = mksKeyed.toLowerCase() ;

          if (mksKeyed==sLoopOption) {
                  // Exact match found
                  mksExactMatchFound = true ;
                  mksMatchFoundString = sLoopOption ;

                  // Also note the match as a partial match.
                  // If further chars are entered and an exact match is no longer found,
                  // then what is noted now will be the best partial match found.
                  mksPartialMatchFound = true ;

                  // Change the selected option
                  uoSelect.selectedIndex=i;
                  break optionLoop ;

          }
  }
  
  
  if(document.getElementById('customMKSInit'))
  {
  	//Sachin Goyal
  	/*Expert code population on the basis of Expert name*/
  	if(document.getElementById('customMKSInitFunction'))
  	{
  		funcVal = document.getElementById('customMKSInitFunction').value;
  		(function(){eval(funcVal)}());
  	}
  	
  	// Consume the event
  	event.returnValue=false;
  }
  else
  {
  	// Consume the event
  	event.returnValue=false;
  }
  

  // Show the updated search pattern
  mksShowSearchPattern(true, uoSelect);
}
// ---------- End  Multi-Key Select (MKS) code. ----------

function updateParent(sInputTagName, sValue) {
// Given an input tag name, this function will try to update the
// value of that input tag on the window that opened this one.
  try {
    if (opener==null) {
      alert ('The opening window cannot be found, and cannot be updated with the value selected.  After clicking OK, close the window and try again.  If the problem persists then please contact the service desk.');
      return ;
    } ;
    if (opener.document.all.item(sInputTagName)==null) {
      alert ('The input tag "' + sInputTagName + '" cannot be found.  After clicking OK, close the window and try again.  If the problem persists then please contact the service desk.');
      return ;
    } ;
    opener.document.all.item(sInputTagName).value = sValue ;
    window.close() ;
  } catch (e) {
    alert (e.description + '\nAn unforseen error has occurred.  After clicking OK, close the window and try again.  If the problem persists then please contact the service desk.');
  }
}


function getTab() {
  var i=1;
  while (eval("document.all.tab" + i)!=null) {
    if (eval("document.all.tab" + i + ".style.display")=='')
      return i;
    else
      i++;
  }
  return "";
}

function claimNarrativeFix() {
  document.all.claimNarrative.value=document.all.claimNarr.value;
}

function insertCommas(value) {

  //NOTE: REMEMBER TO UNCOMMENT THE STUFF VFIELD WHEN THIS IS UNCOMMENTED TO ALLOW FOR THE
  //      NUMBER OF COMMAS TO BE ADDED TO THE MAX LENGTH OF NUMERIC AND DECIMAL FIELDS.


  value = removeCommas(value);

  if (isNaN(value)) {
    return;
  }

  var number;
  var decimal;
  var isNegative = Number(value)<0;

  if (isNegative) {
    value = value.substring(1);
  }

  if (value.indexOf(".")!=-1) {
    number = value.substring(0,value.indexOf("."));
    decimal = value.substring(value.indexOf("."));
  }
  else {
    number = value;
    decimal = "";
  }

  var loopLength = Math.floor(number.length/3);
  var insertPoint = number.length % 3;
  if (insertPoint == 0) {
    loopLength--;
    insertPoint += 3;
  }

  for (i=0; i<loopLength; i++) {
    number = number.substring(0,insertPoint) + "," + number.substring(insertPoint);
    insertPoint += 4;
  }

  if (isNegative)
    number = "-" + number;

  number += decimal;

  return number;
}


/*
$Log: main.js,v $
Revision 1.5  2004/05/07 14:18:51  clintonj
Changes double quotes to single quotes.

Revision 1.4  2004/03/23 09:24:39  coganp
fixed for SIR 37546.
Added OnKeyUp event to the adjuster and Lawyer fields in scmadvicecontent.jsp
and reimplemented to use its local onChange event rathar than the
multiKeySelect onChange, as this one will not update the ref field.

The mksInitialise will not attach an onChange event to the lawyer or surveyor
selects in scmadvicecontent.jsp.

Revision 1.3  2004/03/15 15:37:30  coganp
Added updateUMR() for SIR 41158:
Changed the format of UMR field from one part to become three parts


*/