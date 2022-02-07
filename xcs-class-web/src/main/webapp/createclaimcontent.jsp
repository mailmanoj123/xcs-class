<%@ page import="com.xchanging.xcc.web.html.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/restrictednumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/createclaimcontentcustom.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/booleanentered.js"></script>

<script>
function createnewadvice() {
	if ((document.all.osndsssss.value=="") && (document.all.osnddd.value=="") && (document.all.osndmm.value=="") && (document.all.osndyy.value=="") && (document.all.apsndsssss.value=="") && (document.all.apsnddd.value=="") && (document.all.apsndmm.value=="") && (document.all.apsndyy.value=="")) {
		if (confirm("Are you sure you want to create claim against Unsigned Policy?"))
			submitForm("<%=request.getContextPath()%>/control/createnewadvice");
	} else
		submitForm("<%=request.getContextPath()%>/control/createnewadvice");
}
</script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="createclaimcontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Create Claim")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR004\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
          <%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Create New Advice","createnewadvice()")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/home\",false)")%>
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top">
              	<div class="noscroll">
                    <table class="custom">
                      <tr>
                        <td width="25%"></td>
                        <td width="20%">OSND</td>
                        <td width="30%"><%=HTMLUtils.createOsnd("osnd",HTMLUtils.NORMAL,"")%></td>
                        <td width="25%"></td>
                      </tr>
                      <tr>
                        <td></td>
                        <td>APSND</td>
                        <td><%=HTMLUtils.createOsnd("apsnd",HTMLUtils.NORMAL,"")%></td>
                        <td></td>
                      </tr>
                    </table>
                 </div>
              </td>
            </tr>
          </table>
        </div>
        <div class="bot"></div>
      </div>
    </td>
    <td></td>
  </tr>
<% if (user.updateMode()) { %>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/createclaimcontent.js"></script>
<% } %>
</form>
</table>
</span>

<%
/*

$Log: createclaimcontent.jsp,v $
Revision 1.2  2004/03/11 09:47:44  coganp
Fix for SIR 41134. osnd and apsnd numbers can't now contain - or +.


*/
%>