<%@ taglib uri="/tlds/taglib.tld" prefix="screen" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session"/>

<html>
  	<head>
           <%@ include file="timer.jsp" %>
    	<title>
           <screen:insert parameter="ScreenTitle" /> - <%=request.getSession().getServletContext().getAttribute("version")%> - <%=user.getUsername()%>
    	</title>        
        <script src='<%=request.getContextPath()%>/js/main.js'></script>
        <script>
          var sessionid="<%=request.getSession().getId()%>";
          var account = "<%=user.getAccount()%>";
          var username = "<%=user.getUsername()%>";
          var section = "<%=user.getSection()%>";
          var primarySessionNo = "<%=user.getPrimarySessionNo()%>";
          var secondarySessionNo = "<%=user.getSecondarySessionNo()%>";
          var screenMode = "<%=user.getScreenMode()%>";
        </script>
        
        <script>
          // clintonj SIR 37546
          // Function ensures that the adjuster and lawyer codes are in sync with the adjuster and lawyer
          // names in the drop down lists.  This function must be executed onLoad to ensure that the last code
          // entered into the adjuster field is picked up.
          function SIR_37546() {
            try {
              adjusterNameFix();
              lawyerNameFix();              
            } catch(e) {
            }
          }
        </script>
	</head>

	<body leftmargin="0" topmargin="0" rightmargin="0" onUnload="winCloseCheck()" onload="SIR_37546()">
		<table id="mainTable" border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td width="1%"><screen:insert parameter="ScreenBanner" /></td>
				<td background="<%=request.getContextPath()%>/images/headerLink.gif"><screen:insert parameter="AccessButtons" /></td>
			</tr>
			<tr>
				<td colspan="2"><screen:insert parameter="BreadCrumbs" /></td>
			</tr>
			<tr>
				<td colspan="2"><screen:insert parameter="HeaderButtons" /></td>
			</tr>
			<tr>
				<td colspan="2"><screen:insert parameter="ScreenBody" /></td>
			</tr>
		</table>
                <div id="splash" style="display:none">
                  <jsp:include page="splashscreen.jsp" />
                </div>
                <script language="JavaScript">
                  mksInitialise();
                  document.forms[0].onsubmit=submitMethod;
                </script>
	</body>

</html>