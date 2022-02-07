<%@ page import="com.xchanging.xcc.web.html.*" %>
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script src="<%= request.getContextPath()%>/js/menus.js"></script>
<center>
<script>
HORIZONTAL_X=5;
HORIZONTAL_Y=24;
VERTICAL_X=0;
VERTICAL_Y=0;
var rootmenu = new menu(true);
rootmenu.add(new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"account enquiry","submitForm(&quot;" + request.getContextPath() + "/control/accountenquiry&quot;)")%>",""));
rootmenu.add(new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"repository","submitForm(&quot;" + request.getContextPath() + "/control/repository&quot;)")%>",""));
rootmenu.add(new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"data warehouse","submitForm(&quot;" + request.getContextPath() + "/control/datawarehouse&quot;)")%>",""));

var groupingitem = new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"grouping","")%>","");
var grouping = new menu(false);
grouping.add(new menuItem("Maintain Group","newWindow(&quot;<%=request.getContextPath()%>/control/maintaingroup&quot;)"));
grouping.add(new menuItem("Group Enquiry","newWindow(&quot;<%=request.getContextPath()%>/control/groupenquiry&quot;)"));
groupingitem.add(grouping);
rootmenu.add(groupingitem);

<!-- // STH: 23-12-2003: Settlement search screen -->
rootmenu.add(new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"settlement search","newWindow(&quot;" + request.getContextPath() + "/control/settlementsearch&quot;)")%>",""));

rootmenu.createMenu();

writeMenus();
</script>
</center>