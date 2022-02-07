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
	</head>

	<body leftmargin="0" topmargin="0" rightmargin="0" onUnload="winCloseCheck((window.location+'').indexOf('/narrative')>-1)">
        <div id="splash" style="display:block">
          <jsp:include page="splashscreen.jsp" />
        </div>

		<table id="mainTable" border="0" cellspacing="0" cellpadding="0" width="100%" style="display:none">
			<tr>
				<td width="1%"><screen:insert parameter="ScreenBanner" /></td>
                <td background="<%=request.getContextPath()%>/images/headerLink.gif"><screen:insert parameter="AccessButtons" /></td>
			</tr>
			<tr>
				<td colspan="2"><screen:insert parameter="ScreenBody" /></td>
			</tr>
		</table>
        <script language="JavaScript">
	         document.all.mainTable.style.display='block';
	    	 document.all.splash.style.display='none';

	         mksInitialise();
	         document.forms[0].onsubmit=submitMethod;
        </script>
	</body>
</html>