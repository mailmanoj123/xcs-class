<%@ page import="com.xchanging.xcc.web.html.*" %>
<form method="post" name="form1">
<input type="submit" name="submitButton" style="display:none">
<span class="lhsNav">
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/tabs.js"></script>

<script language="JavaScript" src="<%=request.getContextPath()%>/js/debug.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/error.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/messagelist.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vfield.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vform.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vtab.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/VGroup.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/positionlayer.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphavalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphaextendedvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/decimalvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/changepasswordcustom.js"></script>

<script>
function checkPasswords() {
  if ((document.all.password.value)==(document.all.passwordConfirm.value)) {
    return true;
  }
  else {
    alert("Paswords do not match. Please re-enter and try again.");
  }
}
</script>
<!-- content centering table -->
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <!-- main content div -->
      <div class="outerWindow">
        <!-- main top graphic placement div -->
        <div class="top">
        <!-- form heading div -->
        <div class="header">
          <%=HTMLUtils.createHeader("Change Password")%>
          <!-- form help button -->
          <!-- Below help button is no longer required since the information displayed is out of date -->
          <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR002\")")%> -->
        </div>
        </div>
        <div class="menuBar">
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","if(checkPasswords()) submitForm(\"changePassword\");")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","")%>
        </div>
        <div class="content">
          <!-- content tables -->
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <table width="100%" border="0" class="4column">
                  <tr>
                    <td colspan="4">Your password has expired - please enter/confirm
                      your new password</td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>New Password<span class="compMarker">*</span></td>
                    <td><input name="password" type="password" maxlength="8"></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>Confirm Password<span class="compMarker">*</span></td>
                    <td><input type="password" name="passwordConfirm" maxlength="8"></td>
                    <td></td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
        </div>
        <div class="bot"></div>
      </div></td>
    <td></td>
  </tr>
</table>
</span>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/changepassword.js"></script>
</form>