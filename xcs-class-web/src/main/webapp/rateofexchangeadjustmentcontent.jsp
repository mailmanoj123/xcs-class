<%@ page import="com.xchanging.xcc.web.html.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="roeadj" type="com.xchanging.xcc.web.models.RateOfExchangeAdjustmentModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/rateofexchangeadjustmentcontentcustom.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="rateofexchangeadjustmentcontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("Rate of Exchange Adjustment")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR029\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/roeadjrelease\")")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
				</div>
				<div class="content">
					<!-- end of optional header information -->
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="noscroll">
								<table class="4column" border="0">
									<tr>
										<td colspan="4">Please enter revised Rates of Exchange as required, and confirm new 100% Settlement Amounts</td>
									</tr>
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td>Orig CCy</td>
										<td><%=roeadj.getOrigCcy1()%></td>
										<td><%=roeadj.getOrigCcy2()%></td>
										<td><%=roeadj.getOrigCcy3()%></td>
									</tr>
									<tr>
										<td>Paid Amt</td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(roeadj.getPaidAmt1()))%> <input type="hidden" name="paidAmt1" id="paidAmt1" value="<%=HTMLUtils.formatDecimal(roeadj.getPaidAmt1()) %>"> </td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(roeadj.getPaidAmt2()))%> <input type="hidden" name="paidAmt2" id="paidAmt2" value="<%=HTMLUtils.formatDecimal(roeadj.getPaidAmt2()) %>"> </td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(roeadj.getPaidAmt3()))%> <input type="hidden" name="paidAmt3" id="paidAmt3" value="<%=HTMLUtils.formatDecimal(roeadj.getPaidAmt3()) %>"> </td>
									</tr>
									<tr>
										<td>Sett Ccy</td>
										<td><%=roeadj.getSettCcy1()%></td>
										<td><%=roeadj.getSettCcy2()%></td>
										<td><%=roeadj.getSettCcy3()%></td>
									</tr>
									<tr>
										<td>Orig Exchange Rate</td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatROE(roeadj.getOrigRExch1()))%> <input type="hidden" name="origExchangeRate1" id="origExchangeRate1" value="<%=HTMLUtils.formatROE(roeadj.getOrigRExch1()) %>"> </td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatROE(roeadj.getOrigRExch2()))%> <input type="hidden" name="origExchangeRate2" id="origExchangeRate2" value="<%=HTMLUtils.formatROE(roeadj.getOrigRExch2()) %>"> </td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatROE(roeadj.getOrigRExch3()))%> <input type="hidden" name="origExchangeRate3" id="origExchangeRate3" value="<%=HTMLUtils.formatROE(roeadj.getOrigRExch3()) %>"> </td>
									</tr>
									<tr>
										<td>Orig Sett Amt</td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(roeadj.getOrigSettAmt1()))%></td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(roeadj.getOrigSettAmt2()))%></td>
										<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(roeadj.getOrigSettAmt3()))%></td>
									</tr>
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td>Revised Exchange Rate</td>
										<td><input type="text" name="revisedExchangeRate1" value="<%=roeadj.getRevisedRExch1()%>" <%=roeadj.getRevisedRExch1Flag()%>></td>
										<td><input type="text" name="revisedExchangeRate2" value="<%=roeadj.getRevisedRExch2()%>" <%=roeadj.getRevisedRExch2Flag()%>></td>
										<td><input type="text" name="revisedExchangeRate3" value="<%=roeadj.getRevisedRExch3()%>" <%=roeadj.getRevisedRExch3Flag()%>></td>
									</tr>
									<tr>
										<td>Revised Sett Amt</td>
										<td><input type="text" name="revisedSettAmt1" value="<%=roeadj.getRevisedSettAmt1()%>" <%=roeadj.getRevisedSettAmt1Flag()%>></td>
										<td><input type="text" name="revisedSettAmt2" value="<%=roeadj.getRevisedSettAmt2()%>" <%=roeadj.getRevisedSettAmt2Flag()%>></td>
										<td><input type="text" name="revisedSettAmt3" value="<%=roeadj.getRevisedSettAmt3()%>" <%=roeadj.getRevisedSettAmt3Flag()%>></td>
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
<%-- if (user.updateMode()) { --%>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/rateofexchangeadjustmentcontent.js"></script>
<%-- } --%>
</form>
</table>
</span>

<!-- To insert comma in the financial amount fields on load of this screen -->
<!-- Though commas are inserted by vField, but this is required when user comes on the screen after history.go(-1) -->
<script>
	document.body.onload = (function() {
										document.forms[0].revisedExchangeRate1.value       =   insertCommas(document.forms[0].revisedExchangeRate1.value);
										document.forms[0].revisedExchangeRate2.value       =   insertCommas(document.forms[0].revisedExchangeRate2.value);
										document.forms[0].revisedExchangeRate3.value       =   insertCommas(document.forms[0].revisedExchangeRate3.value);
										document.forms[0].revisedSettAmt1.value            =   insertCommas(document.forms[0].revisedSettAmt1.value);
										document.forms[0].revisedSettAmt2.value            =   insertCommas(document.forms[0].revisedSettAmt2.value);
										document.forms[0].revisedSettAmt3.value            =   insertCommas(document.forms[0].revisedSettAmt3.value);
									});
</script>
