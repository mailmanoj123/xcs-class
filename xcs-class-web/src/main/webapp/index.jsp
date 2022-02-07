<%@ page import="com.xchanging.xcc.web.html.*" %> <span class="standard">
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/portalHomePage.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/main.js"></script>
<script>
var sessionid="<%=request.getSession().getId()%>";
function launch() {
        document.forms[0].action=appendSessionId("<%=request.getContextPath()%>/control/login");
	var loginWindow = window.open("<%=request.getContextPath()%>/control/loginScreen","login","height=413, width=400, left=" + (screen.width/2-200) + ", top=" + (screen.height/2-207));
}

function submitMethod() {
        var mainWindow = window.open("","main","location=false, menubar=false, status=yes, toolbar=false, scrollbars=yes, resizable=yes, fullscreen=no");
        mainWindow.moveTo(0,0);
	mainWindow.resizeTo(screen.availWidth,screen.availHeight);
        document.forms[0].target="main";
        document.forms[0].submit();
}
</script>
<table class="portalIndexFormCenter">
  <tr>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td class="content"> <table  border="0" cellpadding="0" cellspacing="0" class="portalIndexMainTable" >
        <tr>
          <td valign="top" > <table width="100%"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td colspan="2" class="indexBanner">&nbsp;</td>
              </tr>
              <tr>
                <td align="center" valign="middle" class="left"> <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"login","launch()")%>
                </td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
  </tr>
</table>
<form method="post">
<input type="submit" name="submitButton" style="display:none">
  <input type="hidden" name="accountCode">
  <input type="hidden" name="username">
  <input type="hidden" name="password">
  <input type="hidden" name="section">
  <input type="hidden" name="openerCount">
</form>
</span>