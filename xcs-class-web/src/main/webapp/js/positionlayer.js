// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::positionLayer
// ~
// ~   All "public" functions are detailed below:
// ~
// ~   single constructor:
// ~   switchLayer
// ~   ShowHideLayer
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::positionLayer Constructor::positionLayer ([Number object])
// ~
// ~   Simply assigns and initialises the required properties.
// ~
// ~   The incoming parameter will determine the initial method in which errors/help are
// ~   shown to the user- whether it be via a popup (1) or via a new window (2).
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function positionLayer(iLayerType)
{
  debugMessage("Entering positionLayer Constructor" + " iLayerType= " + iLayerType,1) ;
  var sFunctionName= "positionLayer Constructor";

  try{

          this.LayerType = iLayerType
          this.bShowLayer = false;
          this.POPUP_LAYER = 1;
          this.WINDOW_LAYER = 2;

          this.CntrlHandle = null;
          this.LayerHandle = null ;

          // ~ get the xPos and yPos which define the bottom left point
          // ~ of the control
          this.xPos = 0;
          this.yPos = 0;
          this.idd = 0;

     } catch(e) {
       e.description += "\n" + sFunctionName ;
       // add parameters to the description if you feel it helps.
       // newlines (\n) at the beginning of lines.
       throw e ;
     }

  debugMessage("Leaving positionLayer Constructor",-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::positionLayer function::switchLayer ()
// ~
// ~  This function (called by pressing ctrl-F1 on the respective element) will
// ~  toggle the way in which errors and/or help are thrown out. They are either thrown out
// ~  to a new window or a popup.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
positionLayer.prototype.switchLayer = function()
{
  debugMessage("Entering positionLayer::switchLayer" + " Layer type = " + this.LayerType,1) ;
  var sFunctionName= "positionLayer::switchLayer";

  try{

      if (this.bShowLayer == true)
      {
          if (this.LayerType == this.POPUP_LAYER)
          {
              tempLayerHandle = this.LayerHandle;
              timerProcess = window.setInterval("fadeAway()",20);
              this.LayerType = this.WINDOW_LAYER;
              window.status = "Errors thrown to new Browser";
          }
          else
          {
              this.LayerHandle.close() ;
              this.LayerType = this.POPUP_LAYER;
              window.status = "Errors thrown to popup";
          }
          this.bShowLayer = false;
      }
      else
      {
            if (this.LayerType == this.POPUP_LAYER)
            {
                this.LayerType = this.WINDOW_LAYER;
                window.status = "Errors thrown to new Browser";
            }
            else
            {
                this.LayerType = this.POPUP_LAYER;
                window.status = "Errors thrown to popup";
            }
      }

      this.LayerHandle = null;

 } catch(e) {
   e.description += "\n" + sFunctionName ;
   // add parameters to the description if you feel it helps.
   // newlines (\n) at the beginning of lines.
   throw e ;
 }

 debugMessage("Leaving positionLayer::switchLayer",-1) ;

}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::positionLayer function::ShowHideLayer ([String object, FormElement Object])
// ~
// ~ This function (called by pressing F1 on the respective element) will call either
// ~ the respective function to show the method in which the errors and/or help will be shown
// ~ or hide the method in which the errors are shown.
// ~
// ~ The FormElement object handle being passed in will be the control from which the user has asked
// ~ for help (via pressing F1 (onblur event). This handle will be used to correctly position the
// ~ popup box.
// ~
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
positionLayer.prototype.ShowHideLayer = function(sText, ElementObj)
{
 debugMessage("Entering positionLayer::ShowHideLayer" + " Layer type = " + this.LayerType,1) ;
 var sFunctionName= "positionLayer::ShowHideLayer";

 try{

        debugMessage(" text = " + sText + " bShowLayer = " + this.bShowLayer + " this.LayerType " + this.LayerType, -1);
        this.CntrlHandle = ElementObj;

        if (this.LayerType==this.POPUP_LAYER)
        {
            if (this.bShowLayer == false)
            {
                this.showLayer(sText);
                this.bShowLayer = true;
                debugMessage(" after " + this.bShowLayer);
            }
            else
            {
                this.hideLayer() ;
                this.bShowLayer = false;
            }
        }
        else
            {
                this.bShowLayer = true;
                this.showLayer(sText);
            }

   } catch(e) {
     e.description += "\n" + sFunctionName ;
     // add parameters to the description if you feel it helps.
     // newlines (\n) at the beginning of lines.
     throw e ;
   }

 debugMessage("Leaving positionLayer::ShowHideLayer",-1) ;

}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::positionLayer Function::showLayer ([String Object])
// ~
// ~   Depending on the LayerType selected the error and/or help will be thrown to either
// ~   the pop-up or a new window. The text passed in will be the message to be selected.
// ~
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
positionLayer.prototype.showLayer = function(sText) {
	var sFunctionName= "positionLayer::showLayer";

	try {
		debugMessage("Entering " + sFunctionName,1) ;

		layerTypeSwitch: switch (this.LayerType) {
			case (1) :
				// first get a handle to the layer in question
				this.LayerHandle = document.getElementById("HelpDiv")
				// ~ get the xPos and yPos which define the bottom left point
				// ~ of the control
				this.xPos = this.getAbsX();
				this.yPos = this.getAbsY() + this.CntrlHandle.offsetHeight;
				// ~ However if we hit the form width or height limits then
				// ~ move the div accordingly.
				this.LayerHandle.style.left = this.MoveLeft();
				this.LayerHandle.style.top  = this.MoveTop() ;
				this.LayerHandle.innerHTML = sText;
				this.LayerHandle.style.visibility = "visible";
				break layerTypeSwitch ;
			case (2)  :
				// do a window here
                                if (this.LayerHandle!=null)
                                  this.LayerHandle.close();
				this.LayerHandle = window.open("","subwindow","HEIGHT=400,WIDTH=400,menubar, resizable,scrollbars");
                                var htmlStart = "<body>";
                                var htmlFinish = "</body>"
				this.LayerHandle.document.write(htmlStart + sText + htmlFinish);
                                this.LayerHandle.focus();
				break layerTypeSwitch ;
			default :
				alert("throw error here 1");
		}

                // LD 09/01/03
                // ===============
                // Don't know what the line below does but it
                // was producing an error so I've commented it out.

		//window.event.returnValue='';

	} catch(e) {
		e.description += "\n" + sFunctionName ;
		throw e ;
	}
	debugMessage("Leaving positionLayer::showLayer",-1) ;
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::hideDiv Function::setPosition ()
// ~
// ~   This function will make the pop-up fade away- although if the error and/or help
// ~   are being thrown to another window then we will leave the window open. The onus
// ~   will be on the user to close the window.
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
positionLayer.prototype.hideLayer = function()
{
  layerTypeSwitch: switch (this.LayerType)
    {
    case (1) :
        tempLayerHandle = this.LayerHandle;
        timerProcess = window.setInterval("fadeAway()",90);
        break layerTypeSwitch;
    case (2) :
        // this.LayerHandle.close();
        break layerTypeSwitch;
    default :
      alert("throw error here 3");
     }
  window.event.returnValue='';
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~   CLASS::positionLayer Function::initialise()
// ~     This function writes a div definition to the HTML document.  The parameter
// ~		 defines the name of the DIV.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
positionLayer.prototype.initialise = function(sLayerName, sClassName) {
	document.write (
		"<div " +
			"id='" + sLayerName +  "' " +
			"name='" + sLayerName + "' " +
			"class='help_popup'>" +
		"</div>"
	)
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~ All the functions below can be treated as "private"
// ~
// ~ These functions only apply when the user has decided to throw out the errors/help to
// ~ the popup box, and are used to get the position in which the pop-up box is displayed on
// ~ the screen.
// ~
// ~ These functions are:
// ~    getAbsPos
// ~    getAbsX
// ~    getAbsY
// ~    MoveLeft
// ~    MoveTop
// ~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

positionLayer.prototype.getAbsPos = function(CntrlHandle, PositionType)
{
  iPos = 0;
  while (CntrlHandle != null)
  {
    iPos += CntrlHandle["offset"+PositionType];
    CntrlHandle = CntrlHandle.offsetParent;
  }
  return iPos;
}

positionLayer.prototype.getAbsX = function ()
{
  // ~ If CntrlHandle.x has a non-null value.....
  return (this.CntrlHandle.x) ? this.CntrlHandle.x : this.getAbsPos(this.CntrlHandle,"Left");
}


positionLayer.prototype.getAbsY = function ()
{
  return (this.CntrlHandle.y) ? this.CntrlHandle.y : this.getAbsPos(this.CntrlHandle,"Top");
}

positionLayer.prototype.MoveLeft = function ()
{
  iPos = 0;
  if (document.body.offsetWidth < (this.xPos + this.LayerHandle.offsetWidth))
  {
    iPos = (this.xPos + this.CntrlHandle.offsetWidth) - this.LayerHandle.offsetWidth;
  }
  else
  {
    iPos = this.xPos;
  }
  return iPos
}

positionLayer.prototype.MoveTop = function ()
{
  iPos = 0;
  if (document.body.offsetHeight < (this.yPos + this.LayerHandle.offsetHeight))
  {
    iPos = this.yPos - this.CntrlHandle.offsetHeight - this.LayerHandle.offsetHeight;
  }
  else
  {
    iPos = this.yPos;
  }
  return iPos
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~ GLOBAL FUNCTION :: fadeAway()
// ~
// ~ This is treated as a global function as we had problems with feeding in
// ~ a reference to "this.fadeAway" in the "window.setInterval("[function]()",20); statement.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
var timerProcess = 0;
var tempLayerHandle;

function fadeAway()
{
  var intFader = 40;
    tempLayerHandle.filters.item('DXImageTransform.Microsoft.alpha').opacity -= intFader;
    tempLayerHandle.filters.item('DXImageTransform.Microsoft.alpha').finishOpacity -= intFader;

    if (tempLayerHandle.filters.item('DXImageTransform.Microsoft.alpha').opacity<=0)
    {
        tempLayerHandle.style.visibility = "hidden";
        tempLayerHandle.filters.item('DXImageTransform.Microsoft.alpha').opacity = 100;
    tempLayerHandle.filters.item('DXImageTransform.Microsoft.alpha').finishOpacity = 100;
        window.clearInterval(timerProcess);
    }
}

