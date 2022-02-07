var NAVHORIZONTAL_X=0;
var NAVHORIZONTAL_Y=14;
var NAVVERTICAL_X=-4;
var NAVVERTICAL_Y=0;

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
	var target = eval("document.all.nb" + id);
	target.style.position='absolute';
	target.style.left=x;
	target.style.top=y;
	target.style.display='';
}
menu.prototype.forceHide=function(id) {
	var ret=true;
	if (id==null) id="";

	var c=eval(idToPathNav(id));
	for (var i=0; i<c.menuItems.length; i++) {
			if (c.menuItems[i].mimenu!=null) {
				var ret2 = this.forceHide(id + "" + zeroFill(i,3));
				if (!ret2) ret=false;
				if (eval("document.all.nb" + id + "" + zeroFill(i,3) + ".style.display")=="") {
					ret=false;
				}
				eval("document.all.nb" + id + "" + zeroFill(i,3) + ".style.display='none';");
			}
	}
	return ret;
}
menu.prototype.createMenu=function(id) {
	if (id==null) id="";

	var menuStr="";
	menuStr+="<div id='nb" + id + "'";
	if (!this.horizontal)
		menuStr+=" style='display:none;z-index:10;'";
	menuStr+=">";
	menuStr+="<table border='0'";
	if (this.horizontal)
		menuStr+=" class='horizontal'";
	else
		menuStr+=" class='vertical'";

	menuStr+=">";

	if (this.horizontal)
		menuStr+="<tr>";

	for (var i=0; i<this.menuItems.length; i++) {
		if (this.menuItems[i].mimenu!=null)
			this.menuItems[i].mimenu.createMenu(id + "" + zeroFill(i,3));

		if (!this.horizontal)
		  menuStr+="<tr>";
                else {
                  if (i>0)
                    menuStr+="<td>&gt;</td>";
		}
		menuStr+="<td style='cursor:hand' type='menuroot'";
		if (this.menuItems[i].mimenu!=null) {
			menuStr+=" onmouseover='" + idToPathNav(id + '' + zeroFill(i,3)) + ".show(\"" + id + "" + zeroFill(i,3) + "\",";
			if (this.horizontal) {
				menuStr+="NAVHORIZONTAL_X + event.x - event.offsetX + document.body.scrollLeft,";
				menuStr+="NAVHORIZONTAL_Y + event.y - event.offsetY + document.body.scrollTop)'";
			} else {
				menuStr+="NAVVERTICAL_X + event.x - event.offsetX + document.body.scrollLeft + nb" + id + ".clientWidth,";
				menuStr+="NAVVERTICAL_Y + event.y - event.offsetY + document.body.scrollTop)'";
			}
		}
		else {
			menuStr+=" onmouseover='" + idToPathNav(id) + ".forceHide(\"" + id + "\")'";
		}
		menuStr+="><span style='cursor:hand' onclick='" + this.menuItems[i].url + "'";
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

function writeNavMenus() {
	for (var i=menuhtml.length-1; i>=0 ;i--) {
		document.write(menuhtml[i]);
	}
}

function idToPathNav(id) {
	var path = "navbar";
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
                   navbar.forceHide();
		} catch (e) {}

                try {
                   rootmenu.forceHide();
		} catch (e) {}
		return true
	}
}
document.onclick=clickIE;

