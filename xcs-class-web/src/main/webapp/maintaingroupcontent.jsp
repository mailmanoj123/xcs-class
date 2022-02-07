<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="mg" type="com.xchanging.xcc.web.models.MaintainGroupModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">


<script language="JavaScript" src="<%=request.getContextPath()%>/js/debug.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/error.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/messagelist.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vfield.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vform.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vtab.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/VGroup.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/positionlayer.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphavalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/decimalvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/maintaingroupcontentcustom.js"></script>

<script>
function clearScreen() {

  if (document.all.updategroupButton != null) {
    document.all.updategroupButton.style.display="none";
  }
  if (document.all.addosnducrButton != null) {
    document.all.addosnducrButton.style.display="none";
  }
  if (document.all.spangroupcontents != null) {
    document.all.spangroupcontents.innerHTML="";
    document.all.spangroupcontents.innerText="";
  }
  currentInsert=1;

  document.forms[0].aggGrpNonAggRef.value = "";
  document.forms[0].aggGrpNonAggRef.readOnly = false;
  document.forms[0].groupType.value = "";

  submitForm("<%=request.getContextPath()%>/control/maintaingroupclear");
}


var lastRow=0;
var currentInsert=1;

function insertBlankRow() {
  var newRow;
  var newCell;

if (lastRow+currentInsert>1200) {
   alert("There are already 1200 UCRs on VCLGCDA1 for the current group reference.");
} else {

// If the group type is Aggregate then insert OSND
// otherwise insert UCR
if ((document.forms[0].groupType.value.toUpperCase() != "AGGREGATE") && (document.forms[0].groupType.value.toUpperCase() != "NON-AGGREGATE"))
{
  alert("Please note that the Group Type must either be 'AGGREGATE' or 'NON-AGGREGATE'");
  return;
}


if (document.forms[0].groupType.value.toUpperCase() == "AGGREGATE")
{

    // First time through we allow the user to insert a row.
   if (currentInsert != 1)
   {

     // Before insert is allowed check that the previous row has been fully populated.
     var previousInsert = currentInsert -1;

     if ((eval("document.forms[0].osndsssssInsert" + previousInsert + ".value")=="") || (eval("document.forms[0].osndddInsert" + previousInsert + ".value")=="") || (eval("document.forms[0].osndmmInsert" + previousInsert + ".value")=="")|| (eval("document.forms[0].osndyyInsert" + previousInsert + ".value")==""))
     {
       alert("User cannot insert new OSND line without the previous line being populated");
       return;
     }
   }
  newRow = maintaingroup.insertRow();

  newCell = newRow.insertCell();
  newCell.innerHTML="";
  newCell = newRow.insertCell();
  newCell.innerHTML="";
  newCell = newRow.insertCell();
  newCell.innerHTML="<table class='osnd' border='0' cellpadding='0'><tr><td class='sssss'><input type='text' maxlength='5' name='osndsssssInsert" + currentInsert + "'></td><td>*</td><td class='dd'><input type='text' maxlength='2' name='osndddInsert" + currentInsert + "'></td><td>/</td><td class='mm'><input type='text' maxlength='2' name='osndmmInsert" + currentInsert + "'></td><td> / </td><td class='yy'><input type='text' maxlength='2' name='osndyyInsert" + currentInsert + "'> </td> </tr></table>";

  newCell = newRow.insertCell();
  newCell.innerHTML="";

  eval('var osndsssssInsert' + currentInsert + ' = new VField(maintaingroupcontent.osndsssssInsert' + currentInsert + ', VField.TYPE_NUMERIC, VField.LONG_NAME, "OSND 1 Signing Number",  VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);');
  eval('uoForm.add(osndsssssInsert' + currentInsert + ');');
  eval('var osndddInsert' + currentInsert + ' = new VField(maintaingroupcontent.osndddInsert' + currentInsert + ', VField.TYPE_NUMERIC, VField.LONG_NAME, "OSND 1 Day",  VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);');
  eval('uoForm.add(osndddInsert' + currentInsert + ');');
  eval('var osndmmInsert' + currentInsert + ' = new VField(maintaingroupcontent.osndmmInsert' + currentInsert + ', VField.TYPE_NUMERIC, VField.LONG_NAME, "OSND 1 Month", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);');
  eval('uoForm.add(osndmmInsert' + currentInsert + ');');
  eval('var osndyyInsert' + currentInsert + ' = new VField(maintaingroupcontent.osndyyInsert' + currentInsert + ', VField.TYPE_NUMERIC, VField.LONG_NAME, "OSND 1 Year",  VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_NO_COMMAS, true);');
  eval('uoForm.add(osndyyInsert' + currentInsert + ');');

  currentInsert++;

  maintaingroup.insertRow();

}
else
{
    // First time through we allow the user to insert a row.
   if (currentInsert != 1)
   {
     // Before insert is allowed check that the previous row has been fully populated.
     var previousInsert = currentInsert -1;

     if ((eval("document.forms[0].ucr1ptInsert" + previousInsert + ".value")=="") || (eval("document.forms[0].ucr2ptInsert" + previousInsert + ".value")=="") || (eval("document.forms[0].ucr3ptInsert" + previousInsert + ".value")==""))
     {
       alert("User cannot insert new UCR line without the previous line being populated");
       return;
     }
   }

  newRow = maintaingroup.insertRow();

  newCell = newRow.insertCell();
  newCell.innerHTML="";
  newCell = newRow.insertCell();
  newCell.innerHTML="";
  newCell = newRow.insertCell();
  newCell.innerHTML="<table class='ucr' border='0' cellpadding='0' id='ucr1'><tr><td class='1'> <input type='text' maxlength='1' name='ucr1ptInsert" + currentInsert + "'></td><td> / </td><td class='2'><input type='text' maxlength='4' name='ucr2ptInsert" + currentInsert + "'></td><td> / </td><td class='3'><input type='text' maxlength='12' name='ucr3ptInsert" + currentInsert + "'></td></tr></table>"

  newCell = newRow.insertCell();
  newCell.innerHTML="";

  eval('var ucr1ptInsert' + currentInsert + ' = new VField(maintaingroupcontent.ucr1ptInsert' + currentInsert + ', VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "UCR/XCR (part 1)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 1, VField.FORMAT_CASE, VField.CASE_UPPER);');
  eval('uoForm.add(ucr1ptInsert' + currentInsert + ');');
  eval('var ucr2ptInsert' + currentInsert + ' = new VField(maintaingroupcontent.ucr2ptInsert' + currentInsert + ', VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "UCR/XCR (part 2)", VField.CHECK_WIDTH_OPTIONAL_EXACT, 4, VField.FORMAT_CASE, VField.CASE_UPPER);');
  eval('uoForm.add(ucr2ptInsert' + currentInsert + ');');
  eval('var ucr3ptInsert' + currentInsert + ' = new VField(maintaingroupcontent.ucr3ptInsert' + currentInsert + ', VField.TYPE_ALPHANUMERIC, VField.LONG_NAME, "UCR/XCR (part 3)", VField.CHECK_WIDTH_MAXIMUM, 12, VField.FORMAT_CASE, VField.CASE_UPPER);');
  eval('uoForm.add(ucr3ptInsert' + currentInsert + ');');

  currentInsert++;

  maintaingroup.insertRow();

}
}
}
</script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="maintaingroupcontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("Maintain Group")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR027\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
                                        <% if (!mg.getAddButtonFlag()) { %>
     <%=HTMLUtils.createButton(HTMLUtils.ACTION,"addosnducrButton","Add Osnd/Ucr","insertBlankRow()")%>
                                        <% } %>
                                        <% if (!mg.getUpdateButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Update Group","if (confirm(\"Are you sure you want to update this group?\")) submitForm(\"" + request.getContextPath() + "/control/maintaingroupupdategroup\")")%>
                                        <% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Clear","clearScreen()")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","logoff(true)")%>
				</div>
				<div class="content">
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="scrollmain" style="height:410px" id="scrollpane">
									<div class="scrollmaincontent">
										<table class="4column">
											<tr>
												<td>&nbsp;</td>
												<td>Aggregate/Non-Aggregate Group Ref</td>
												<td><input type="text" name="aggGrpNonAggRef" value="<%=mg.getAggGrpNonAggRef()%>" <%=mg.getAggGrpNonAggRefFlag()%>></td>
												<td><span class="link" onclick="submitForm('<%=request.getContextPath()%>/control/maintaingroupfind')"><i>Find Group</i></span></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>Group Type</td>
												<td><input type="text" name="groupType" value="<%=mg.getGroupType()%>" <%=mg.getGroupTypeFlag()%></td>
												<td>&nbsp;</td>
											</tr>
										</table>
										<br>
										<table class="custom" name="maintaingroup" id="maintaingroup">
											<tr>
												<td width="25%">&nbsp;</td>
												<td width="17%" align="center">Delete</td>
												<td width="33%">OSND/UCR</td>
												<td width="25%">&nbsp;</td>
											</tr>
                                                                                        <span id="spangroupcontents">
                                                        				<%if(mg.isAggregate()){
												Enumeration osnds = mg.getOsnds();
												int i = 1;
												while(osnds.hasMoreElements()){
													MaintainGroupModel.MaintainGroupOsnd osnd = (MaintainGroupModel.MaintainGroupOsnd)osnds.nextElement();%>
													<tr>
														<td>&nbsp;</td>
														<td><input type="checkbox" name="del<%=i%>" readonly="<%=osnd.getDelFlag()%>"></td>
														<td><%=HTMLUtils.createOsnd("osnd" + i,HTMLUtils.READONLY, osnd.getOsnd())%></td>
														<td>&nbsp;</td>
													</tr>
                                                                                                        <script>lastRow++;</script>
												<%i++;%>
											<%}} else {
												Enumeration ucrs = mg.getUcrs();
												int i = 1;
												while(ucrs.hasMoreElements()){
													MaintainGroupModel.MaintainGroupUcr ucr = (MaintainGroupModel.MaintainGroupUcr)ucrs.nextElement();%>
													<tr>
														<td>&nbsp;</td>
														<td><input type="checkbox" name="del<%=i%>" readonly="<%=ucr.getDelFlag()%>"></td>
														<td><%=HTMLUtils.createUcr("ucr" + i,HTMLUtils.READONLY, ucr.getUcr())%></td>
														<td>&nbsp;</td>
													</tr>
                                                                                                        <script>lastRow++;</script>
												<%i++;%>
											<%}}%>
                                                                                        </span>
										</table>
									</div>
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
</form>
</table>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/screen/maintaingroupcontent.js"></script>
</span>