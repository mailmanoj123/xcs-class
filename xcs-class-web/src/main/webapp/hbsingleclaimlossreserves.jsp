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
grouping.add(new menuItem("Add to Aggregate Group","newWindow(&quot;<%=request.getContextPath()%>/control/addtoagggroup&quot;)"));
grouping.add(new menuItem("Create Non-Aggregate Group","newWindow(&quot;<%=request.getContextPath()%>/control/createnonagggroup&quot;)"));
grouping.add(new menuItem("Add to Non-Aggregate Group","newWindow(&quot;<%=request.getContextPath()%>/control/addtononagggroup&quot;)"));
groupingitem.add(grouping);
rootmenu.add(groupingitem);

var notesitem = new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"notes","")%>","");
var notes = new menu(false);
notes.add(new menuItem("Security Notes","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=70&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Claim Notes","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=80&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Loss Details","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=100&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Policy Details","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=90&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Settlement Narrative","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=130&screen=SCR016&quot;,false)"));
notes.add(new menuItem("EURO Conversion Details (FME)","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=120&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Broker Additional Details","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=10&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Broker Aggregate Details","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=20&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Slip Lead Comments","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=30&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Lead Comments","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=40&screen=SCR016&quot;,false)"));
notes.add(new menuItem("Lead Additional Detail","submitForm(&quot;<%=request.getContextPath()%>/control/narrative?id=50&screen=SCR016&quot;,false)"));
notesitem.add(notes);
rootmenu.add(notesitem);

rootmenu.add(new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"history","newWindow(&quot;" + request.getContextPath() + "/control/history?currentScreen=SCR016&quot;)")%>",""));

var funcitem = new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"function","")%>","");
var func = new menu(false);
func.add(new menuItem("Create Subsequent Advice","submitForm(&quot;<%=request.getContextPath()%>/control/createsubsequentadvice&quot;)"));
func.add(new menuItem("Create Rate of Exchange Adjustment","submitForm(&quot;<%=request.getContextPath()%>/control/createrateofexchangeadj&quot;)"));
func.add(new menuItem("Create Contra Correction","submitForm(&quot;<%=request.getContextPath()%>/control/createcontracorrection&quot;)"));
func.add(new menuItem("Add Take Down Numbers","submitForm(&quot;<%=request.getContextPath()%>/control/addtakedownnumbers&quot;)"));
func.add(new menuItem("Set Diary Date","newWindow(&quot;<%=request.getContextPath()%>/control/setdiarydate&quot;)"));
func.add(new menuItem("Create Bulk/CCS Correction","submitForm(&quot;<%=request.getContextPath()%>/control/bulkccscorrection&quot;)"));
func.add(new menuItem("Set File Last Seen Date","if (confirm(&quot;Are you sure you want to update the File Last Seen date?&quot;)) newWindow(&quot;<%=request.getContextPath()%>/control/setfilelastseendate&quot;)"));
func.add(new menuItem("Reset Claim Transaction","submitForm(&quot;<%=request.getContextPath()%>/control/resetclaimtransaction?screen=SCR016&quot;)"));
func.add(new menuItem("Create Re-advice","submitForm(&quot;<%=request.getContextPath()%>/control/createreadvice&quot;)"));
funcitem.add(func);
rootmenu.add(funcitem);

<!-- // STH: 23-12-2003: Settlement search screen -->
rootmenu.add(new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"settlement search","newWindow(&quot;" + request.getContextPath() + "/control/settlementsearch&quot;)")%>",""));

rootmenu.createMenu();

writeMenus();
</script>
</center>