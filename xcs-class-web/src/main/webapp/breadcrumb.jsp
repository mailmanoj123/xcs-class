<%@ page import="com.xchanging.xcc.web.models.*,com.xchanging.xcc.web.html.*,java.util.*" %>
<jsp:useBean id="navBar" type="com.xchanging.xcc.web.models.NavigationBarModel" scope="session" />

<script src="<%= request.getContextPath()%>/js/navmenu.js"></script>
<script src="<%= request.getContextPath()%>/js/main.js"></script>
<link href="<%= request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script>
var navbar = new menu(true);
<%	Vector rootMenus = navBar.getRootMenus();
	int i=0;
	for (int c=rootMenus.size()-1;c>=0; c--) {
		RootMenu rootMenu = (RootMenu)rootMenus.get(c);
		%>
		var navbari<%=i%> = new menuItem("<%=rootMenu.getText()%>","");
		<%=NavBarBuilder.build((MenuEntry)rootMenu.getMenu(),"navbar" + i,request)%>
		navbari<%=i%>.add(navbar<%=i%>);
		navbar.add(navbari<%=i%>);
		<%
		i++;
	}
%>

navbar.createMenu();

writeNavMenus();
</script>