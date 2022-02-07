<%@ page import="com.xchanging.xcc.web.html.*" %>
<jsp:useBean id="ccsamounts" type="com.xchanging.xcc.web.models.CCSAmountsModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form>
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("CCS Amounts")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR032\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Close","back()")%>
				</div>
				<div class="content">
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top">
								<div class="noscroll">
									<table class="custom">
										<tr>
											<td></td>
											<td><strong>Orig Ccy:</strong> <%=ccsamounts.getOrigCcy()%></td>
											<td><strong>Sett Ccy:</strong> <%=ccsamounts.getCcsCurr()%></td>
											<td><strong>OS Exch Rate:</strong><script>document.write(insertCommas("<%=ccsamounts.getOutstRateExch()%>"));</script></td>
											<td></td>
										</tr>
										<tr>
											<td colspan="5">&nbsp;</td>
										</tr>
										<tr>
											<td width="10%">&nbsp;</td>
											<td width="27%">&nbsp;</td>
											<td width="27%"><strong>PTT</strong></td>
											<td width="27%"><strong>PTD</strong></td>
											<td width="10%">&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td><strong>100% Order Amount</strong></td>
											<td><script>document.write(insertCommas("<%=ccsamounts.getOrderAmountPTT()%>"));</script></td>
											<td><script>document.write(insertCommas("<%=ccsamounts.getOrderAmountPTD()%>"));</script></td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td><strong>Sett Rate <%=ccsamounts.getOrigCcy()%>:<%=ccsamounts.getCcsCurr()%></strong></td>
											<td>&nbsp;</td>
											<td><script>document.write(insertCommas("<%=ccsamounts.getSettRate()%>"));</script></td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td><strong>Treasury Rate <%=ccsamounts.getSettCcy()%>:<%=ccsamounts.getCcsCurr()%></strong></td>
											<td>&nbsp;</td>
											<td><script>document.write(insertCommas("<%=ccsamounts.getTreasuryRate()%>"));</script></td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td><strong>100% Sett Amt in GBP</strong></td>
											<td><script>document.write(insertCommas("<%=ccsamounts.getSettAmountPTT()%>"));</script></td>
											<td><script>document.write(insertCommas("<%=ccsamounts.getSettAmountPTD()%>"));</script></td>
											<td>&nbsp;</td>
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
</form>
</table>
</span>