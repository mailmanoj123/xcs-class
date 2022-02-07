<%@ page import="com.xchanging.xcc.web.html.*" %> <span class="standard">
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/portalHomePage.css" rel="stylesheet" type="text/css">
<script>
function launch() {
	var loginWindow = window.open("<%=request.getContextPath()%>/control/loginScreen","login","height=413, width=400, left=" + (screen.width/2-200) + ", top=" + (screen.height/2-207));
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
<form method="post" action="control/login">
  <input type="submit" name="submitButton" style="display:none">
  <input type="hidden" name="accountCode">
  <input type="hidden" name="username">
  <input type="hidden" name="password">
  <input type="hidden" name="section">
</form>
</span>