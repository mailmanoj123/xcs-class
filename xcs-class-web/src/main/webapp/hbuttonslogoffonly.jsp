<%@ page import="com.xchanging.xcc.web.html.*" %>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/Xtech.css">
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="40">
	<tr>
		<td align="right" valign="bottom">
			<table border="0" cellpadding="0" cellspacing="0" class="headerNav">
				<tr>
					<!-- leave this blank td alone -->
					<td></td>
					<!-- logoff button -->
					<td>
						<%=HTMLUtils.createButton(HTMLUtils.HEADER,"logoff","logoff()")%>
					</td>
          <td class="spacer">&nbsp;</td>
          <td><%=HTMLUtils.createButton(HTMLUtils.HEADER, "autologoffButton", "30", "window.open(\"" + request.getContextPath() + "/autologoffhelp.jsp\",\"\",\"HEIGHT=250,WIDTH=800,menubar, resizable, scrollbars\");")%></td>
				</tr>
			</table>
		</td>

	</tr>
</table>