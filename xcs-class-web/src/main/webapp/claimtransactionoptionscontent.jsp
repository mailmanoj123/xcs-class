<%@ page import="com.xchanging.xcc.web.html.*, com.xchanging.xcc.web.models.*,java.util.*" %>
<jsp:useBean id="txnStatus" type="com.xchanging.xcc.web.models.TransactionStatusModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">

<script>
	function ctoSubmit(yes) {
		if (yes)
			document.all.options.value="yes";
		else
			document.all.options.value="no";
		submitForm("<%=request.getContextPath()%>/control/claimtransactionoptions");
	}
</script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
	<table class="formCenter">
		<form>
			<input type="submit" name="submitButton" style="display:none">
			<input type="hidden" name="currentScreen" value="<%=txnStatus.getCurrentScreen()%>">
			<input type="hidden" name="options">
			<%
				Enumeration e = request.getParameterNames();
				while (e.hasMoreElements()) {
					String s = (String)e.nextElement();
					if (!s.equals("ignoreWarnings")) { %>
					<input type="hidden" name="<%=s%>" value="<%=HTMLUtils.escapeChars(request.getParameter(s))%>">
				<% }
			} %>
			<tr>
				<td></td>
				<td class="content">
					<div class="outerWindow">

						<div class="top">
							<div class="header">
								<%=HTMLUtils.createHeader("Claim Transaction Options")%>
								<!-- Below help button is no longer required since the information displayed is out of date -->
								<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR010\")")%> -->
							</div>
						</div>

						<div class="menuBar">
							<!-- MENU BUTTONS GO HERE -->
							<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Exit","ctoSubmit(false)")%>
							<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Delete Transaction","if (confirm(\"Are you sure you want to delete this claim transaction?\")) submitForm(\"" + request.getContextPath() + "/control/ctodelete&quot;)")%>
							<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
						</div>

						<div class="content">
							<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
								<tr>
									<td valign="top" >
										<div class="noscroll">
											<table class="custom">
												<tr>
													<td style="width:15%"></td>
													<td style="width:35%"></td>
													<td style="width:15%"></td>
													<td style="width:35%"></td>
												</tr>
												<tr>
													<td colspan="4">You are about to exit the claim transaction.</td>
												</tr>
												<tr>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td><strong>UCR/XCR</strong></td>
													<td><%=HTMLUtils.createUcr("ucr",HTMLUtils.DISPLAY,txnStatus.getUcr())%></td>
													<td><strong>TR</strong></td>
													<td><%=HTMLUtils.createUcr("tr",HTMLUtils.DISPLAY,txnStatus.getTr())%></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
												</tr>
												<tr>
													<td colspan="4">Warning: the data you have entered on this screen will not be saved.</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</div>

						<div class="bot"></div>
						</div>
					</div> <!-- Outer Window -->
				</td> <!-- Content -->
				<td></td>
			</tr>
		</form>
	</table>
</span>