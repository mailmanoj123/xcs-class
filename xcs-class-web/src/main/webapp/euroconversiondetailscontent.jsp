<%@ page import="com.xchanging.xcc.web.html.*" %>
<jsp:useBean id="euroconv" type="com.xchanging.xcc.web.models.EuroConversionDetailsModel" scope="session" />

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
						<%=HTMLUtils.createHeader("Euro Conversion Details")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR031\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Close","back()")%>
				</div>
				<div class="content">
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="scrollmain" style="height:410px" id="scrollpane">
									<div class="scrollmaincontent">
										<table class="custom">
											<tr>
												<td></td>
												<td><strong>Orig NCU Ccy:</strong> <%=euroconv.getOrigNCUCcy()%></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td width="10%">&nbsp;</td>
												<td width="27%">&nbsp;</td>
												<td width="27%"><strong>Total PTD in NCU Prior to Conversion</strong></td>
												<td width="27%"><strong>Euro Equivalent of NCU Amounts as at Conversion</strong></td>
												<td width="10%">&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Paid to Date Loss</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDLossPrior()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDLossAsAt()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Paid to Date Expense</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDExpensePrior()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDExpenseAsAt()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Paid to Date Fee</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDFeePrior()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDFeeAsAt()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Paid to Date VAT</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDVATPrior()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDVATAsAt()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Total Paid to Date</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDPrior()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDAsAt()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Incurred</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getIncurredPrior()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getIncurredAsAt()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Highest Estimate</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getHighestEstPrior()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getHighestEstAsAt()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>ROEX from <%=euroconv.getOrigNCUCcy()%> to EURO</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getRExchFrmEspToEuro()%>"));</script></td>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td colspan="5">&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Current Movement:</strong> <%=euroconv.getCurrentMovement()%></td>
												<td><strong>Paid to Date Processed in Euro After Conversion</strong></td>
												<td><strong>Total Combined Paid to Date in Euro</strong></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Paid to Date Loss</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDLossPost()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDLossCombined()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Paid to Date Expense</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDExpPost()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDExpCombined()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Paid to Date Fee</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDFeePost()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDFeeCombined()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Paid to Date VAT</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDVATPost()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDVATCombined()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Total Paid to Date</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDPost()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getPTDCombined()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Incurred</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getIncurredPost()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getIncurredCombined()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><strong>Highest Estimate</strong></td>
												<td><script>document.write(insertCommas("<%=euroconv.getHighestEstPost()%>"));</script></td>
												<td><script>document.write(insertCommas("<%=euroconv.getHighestEstCombined()%>"));</script></td>
												<td>&nbsp;</td>
											</tr>
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
</span>