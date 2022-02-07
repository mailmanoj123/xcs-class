var HORIZONTAL_X=0;
var HORIZONTAL_Y=14;
var VERTICAL_X=-4;
var VERTICAL_Y=0;
var hTimer=null;

var menuhtml = new Array();

function menu(horizontal) {
	this.horizontal = horizontal;
	this.menuItems = new Array();
}
menu.prototype.add=function(menuItem) {
	this.menuItems[this.menuItems.length]=menuItem;
}
menu.prototype.show=function(id,x,y) {
	this.forceHide(id.substring(0,id.length-3));
	var target = eval("document.all.t" + id);
	target.style.position='absolute';
        target.style.display='';
        target.style.left=(x+target.clientWidth > document.body.clientWidth) ? document.body.clientWidth-target.clientWidth : x;
	target.style.top=y;
}
menu.prototype.forceHide=function(id) {
	var ret=true;
	if (id==null) id="";

	var c=eval(idToPath(id));
	for (var i=0; i<c.menuItems.length; i++) {
			if (c.menuItems[i].mimenu!=null) {
				var ret2 = this.forceHide(id + "" + zeroFill(i,3));
				if (!ret2) ret=false;
				if (eval("document.all.t" + id + "" + zeroFill(i,3) + ".style.display")=="") {
					ret=false;
				}
				eval("document.all.t" + id + "" + zeroFill(i,3) + ".style.display='none';");
			}
	}
	return ret;
}
menu.prototype.createMenu=function(id) {
	if (id==null) id="";

	var menuStr="";
	menuStr+="<div id='t" + id + "'";
	if (!this.horizontal)
		menuStr+=" style='display:none;z-index:10;'";
	menuStr+=">";
	menuStr+="<table border='0'";
	if (this.horizontal)
		menuStr+=" class='horizontal'";
	else
		menuStr+=" class='vertical' onmouseenter='window.clearTimeout(hTimer)' onmouseleave='rootmenu.forceHide()'";

	menuStr+=">";

	if (this.horizontal)
		menuStr+="<tr>";

	for (var i=0; i<this.menuItems.length; i++) {
		if (this.menuItems[i].mimenu!=null)
			this.menuItems[i].mimenu.createMenu(id + "" + zeroFill(i,3));

		if (!this.horizontal)
			menuStr+="<tr>";
		menuStr+="<td type='menuroot'";
		if (this.menuItems[i].mimenu!=null) {
			menuStr+="onmouseleave='hTimer=window.setTimeout(\"rootmenu.forceHide()\",300)' onmouseover='window.clearTimeout(hTimer);" + idToPath(id + '' + zeroFill(i,3)) + ".show(\"" + id + "" + zeroFill(i,3) + "\",";
			if (this.horizontal) {
				menuStr+="HORIZONTAL_X + getAbsPos(getParentCell(event.srcElement),\"Left\"),";
				menuStr+="HORIZONTAL_Y + getAbsPos(getParentCell(event.srcElement),\"Top\"))'";
			} else {
				menuStr+="VERTICAL_X + event.x - event.offsetX + document.body.scrollLeft + t" + id + ".clientWidth,";
				menuStr+="VERTICAL_Y + event.y - event.offsetY + document.body.scrollTop)'";
			}
		}
		menuStr+="><span style='cursor:hand;' onclick='" + this.menuItems[i].url + "'";
		menuStr+=">" + this.menuItems[i].value + "</span></td>";

		if (!this.horizontal) {
			menuStr+="<td>";
			if (this.menuItems[i].mimenu!=null)
				menuStr+="	&gt;";
			menuStr+="</td>";
		}

		if (!this.horizontal)
			menuStr+="</tr>";
	}

	if (this.horizontal)
		menuStr+="</tr>";

	menuStr+="</table>";
	menuStr+="</div>";

	menuhtml[menuhtml.length]=menuStr;
}

function menuItem(value, url) {
	this.value=value;
	this.url=url;
	this.mimenu=null;
}
menuItem.prototype.add=function(mimenu) {
	this.mimenu=mimenu;
}

function writeMenus() {
	for (var i=menuhtml.length-1; i>=0 ;i--) {
		document.write(menuhtml[i]);
	}
}

function idToPath(id) {
	var path = "rootmenu";
	while (id.length>0) {
		path += ".menuItems[" + id.substring(0,3) + "].mimenu";
		id = id.substring(3);
	}
	return path;
}

function zeroFill(s,length) {
	s = "" + s;
	while (s.length<length) {
		s = "0" + s;
	}
	return s;
}

function clickIE() {
	if ((event.srcElement.offsetParent!=null) && (event.srcElement.onclick!=null))
		event.srcElement.onclick;
	else {
                try {
                   rootmenu.forceHide();
		} catch (e) {}

                try {
                   navbar.forceHide();
		} catch (e) {}
		return true
	}
}
function getParentCell(CntrlHandle)
{
  while ((CntrlHandle != null) && (CntrlHandle.type != "menuroot"))
  {
    CntrlHandle = CntrlHandle.offsetParent;
  }
  return CntrlHandle;
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