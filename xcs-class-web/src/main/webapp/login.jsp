<%@ page import="com.xchanging.xcc.web.html.*, com.xchanging.xcc.web.models.reference.*, java.util.*" %>

<jsp:useBean id="accountList" type="com.xchanging.xcc.web.models.reference.AccountList" scope="application"/>
<jsp:useBean id="sectionList" type="com.xchanging.xcc.web.models.reference.SectionList" scope="application"/>
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/login.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css">

<title>
  Login - <%=request.getSession().getServletContext().getAttribute("version")%>
</title>

<script language="JavaScript">
  var hasLogoffTimer = false ;
</script>

<script src="<%=request.getContextPath()%>/js/tabs.js"></script>

<script language="JavaScript" src="<%=request.getContextPath()%>/js/main.js"></script>
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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/logincustom.js"></script>


<script>
function login() {
  if (uoLogin.onsubmit_Handler()) {
    opener.document.all.accountCode.value=document.all.accountCode.value;
    opener.document.all.username.value=document.all.username.value;
    opener.document.all.password.value=document.all.password.value;
    opener.document.all.section.value=document.all.section.value;
    opener.submitMethod();
    close();
  }
}
</script>
<form name="loginForm">
<input type="submit" name="submitButton" style="display:none">
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <!-- main content div -->
      <div class="loginWindow">
        <!-- main top graphic placement div -->
        <div class="top"></div>
        <!-- form heading div -->
          <div class="header">
            <!-- heading table -->
            <%=HTMLUtils.createHeader("Login")%>
            <!-- form help button -->
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"LOGIN\")")%> -->
            </div>
        <!-- content div -->
          <div class="content">
            <!-- content tables -->
            <%=HTMLUtils.createTitle("Please login")%>
            <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
              <tr>
                <td valign="top" >
                  <table border="0" cellspacing="0" cellpadding="0" class="formTable">
                    <tr>
                      <td colspan="2">Account Code<span class="compMarker">*</span></td>
                      <td width="42%">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">
                        <%=HTMLUtils.createDropdown("accountCode","",false,accountList,false)%>
                      </td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">User Name<span class="compMarker">*</span></td>
                      <td width="42%">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">
                        <input name="username" type="text" maxlength="8">
                      </td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">Password</td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">
                        <input name="password" type="password" maxlength="8">
                      </td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">Section</td>
                      <td width="42%">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">
                        <%=HTMLUtils.createDropdown("section","",false,sectionList,false)%>
                      </td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td width="27%"><%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Ok","login()")%></td>
                      <td width="31%" align="right"><%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Cancel","self.close()")%></td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">&nbsp;</td>
                      <td width="42%">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="2">&nbsp;</td>
                      <td>&nbsp; </td>
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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/login.js"></script>
<script language="JavaScript">mksInitialise();</script>
</form>

