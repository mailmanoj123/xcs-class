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
grouping.add(new menuItem("Maintain Group","submitForm(&quot;<%=request.getContextPath()%>/control/maintaingroup&quot;)"));
grouping.add(new menuItem("Group Enquiry","submitForm(&quot;<%=request.getContextPath()%>/control/groupenquiry&quot;)"));
grouping.add(new menuItem("Add to Aggregate Group","submitForm(&quot;<%=request.getContextPath()%>/control/addtoagggroup&quot;)"));
grouping.add(new menuItem("Create Non-Aggregate Group","submitForm(&quot;<%=request.getContextPath()%>/control/createnonagggroup&quot;)"));
grouping.add(new menuItem("Add to Non-Aggregate Group","submitForm(&quot;<%=request.getContextPath()%>/control/addtononagggroup&quot;)"));
groupingitem.add(grouping);
rootmenu.add(groupingitem);

var notesitem = new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"notes","")%>","");
var notes = new menu(false);
notes.add(new menuItem("Security Notes","submitForm(&quot;<%=request.getContextPath()%>/control/securitynotes&quot;)"));
notes.add(new menuItem("Claim Notes","submitForm(&quot;<%=request.getContextPath()%>/control/claimnotes&quot;)"));
notes.add(new menuItem("Loss Details","submitForm(&quot;<%=request.getContextPath()%>/control/lossdetails&quot;)"));
notes.add(new menuItem("Policy Details","submitForm(&quot;<%=request.getContextPath()%>/control/policydetails&quot;)"));
notes.add(new menuItem("Formatted Narrative (FMT)","submitForm(&quot;<%=request.getContextPath()%>/control/formattednarrative&quot;)"));
notes.add(new menuItem("EURO Conversion Details (FME)","submitForm(&quot;<%=request.getContextPath()%>/control/euroconversiondetails&quot;)"));
notes.add(new menuItem("Broker Additional Details","submitForm(&quot;<%=request.getContextPath()%>/control/brokeradditionaldetails&quot;)"));
notes.add(new menuItem("Broker Aggregate Details","submitForm(&quot;<%=request.getContextPath()%>/control/brokeraggregatedetails&quot;)"));
notes.add(new menuItem("Slip Lead Comments","submitForm(&quot;<%=request.getContextPath()%>/control/slipleadcomments&quot;)"));
notes.add(new menuItem("Lead Comments","submitForm(&quot;<%=request.getContextPath()%>/control/leadcomments&quot;)"));
notes.add(new menuItem("Lead Additional Detail","submitForm(&quot;<%=request.getContextPath()%>/control/leadadditionaldetail&quot;)"));
notesitem.add(notes);
rootmenu.add(notesitem);

rootmenu.add(new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"history","submitForm(&quot;" + request.getContextPath() + "/control/createnewclaim&quot;)")%>","submitForm(&quot;<%=request.getContextPath()%>/control/history&quot;)"));

var funcitem = new menuItem("<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"function","")%>","");
var func = new menu(false);
func.add(new menuItem("Create Subsequent Advice","submitForm(&quot;<%=request.getContextPath()%>/control/createsubsequentadvice&quot;)"));
func.add(new menuItem("Create Rate of Exchange Adjustment","submitForm(&quot;<%=request.getContextPath()%>/control/createrateofexchangeadj&quot;)"));
func.add(new menuItem("Create Contra Correction","submitForm(&quot;<%=request.getContextPath()%>/control/createcontracorrection&quot;)"));
func.add(new menuItem("Add Take Down Numbers","submitForm(&quot;<%=request.getContextPath()%>/control/addtakedownnumbers&quot;)"));
func.add(new menuItem("Set Diary Date","submitForm(&quot;<%=request.getContextPath()%>/control/setdiarydate&quot;)"));
func.add(new menuItem("Create Bulk/CCS Correction","submitForm(&quot;<%=request.getContextPath()%>/control/createbulkccscorrection&quot;)"));
func.add(new menuItem("Set File Last Seen Date","if (confirm(&quot;Are you sure you want to update the File Last Seen date?&quot;)) submitForm(&quot;<%=request.getContextPath()%>/control/setfilelastseendate&quot;)"));
funcitem.add(func);
rootmenu.add(funcitem);



rootmenu.createMenu();

writeMenus();
</script>
</center>