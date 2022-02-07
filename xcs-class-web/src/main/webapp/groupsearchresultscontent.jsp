<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="groupresults" type="com.xchanging.xcc.web.models.GroupSearchResultsModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>

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
						<%=HTMLUtils.createHeader("Group Search Results")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR007\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<% if (!groupresults.getPrevButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev","submitForm(\"" + request.getContextPath() + "/control/groupresultsprev\")")%>
					<% } %>
					<% if (!groupresults.getNextButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next","submitForm(\"" + request.getContextPath() + "/control/groupresultsnext\")")%>
					<% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/groupresultscancel\", false)")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
            <table class="headerInfo" width="100%">
              <tr>
				<td><b>Group Ref:</b></td>
                <td><%=groupresults.getGroupRef()%></td>
                <td><b>Bkr UCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,groupresults.getBkrUcr())%></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>
          </div>
          <br>
					<!-- end of optional header information -->
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="scrollmain" style="height:368px" id="scrollpane">
									<div class="scrollmaincontent">
										<table class="dataTable" width="100%" id="movementsHistoryTable" cellpadding="0" cellspacing="0">
											<tr>
												<th align="left">COR / Reinsured/Loss Name</th>
												<th align="left">NAIC Code/Bkr Claim Ref 1</th>
												<th align="left">Q</th>
												<th align="left">TF / State Code</th>
												<th align="left">DOL From/To</th>
												<th align="left">CAT / PCS Code</th>
												<th align="left">Orig Ccy</th>
												<th align="left">PTD / O/S Amount</th>
												<th align="left">O/S Q</th>
											</tr>

											<%	Enumeration results = groupresults.getResults();

												while (results.hasMoreElements()) {
													GroupSearchResultsModel.GroupResult result = (GroupSearchResultsModel.GroupResult)results.nextElement();
													%>
													<tr>
														<td><a href="javascript:submitForm('<%=request.getContextPath()%>/control/selectgroupsearchresult?ucrTrSysRef=<%=result.getUcrTRSysRef()%>&currNo=<%=result.getCurrNo()%>&sdnNo=<%=result.getSdnNo()%>&statSplitNo=<%=result.getStatSplitNo()%>&breakdownNo=<%=result.getBreakdownNo()%>')"><%=HTMLUtils.createCor("",HTMLUtils.DISPLAY,result.getCor())%></a></td>
														<td><%=result.getNaicCode()%></td>
														<td><%=result.getNaicQual()%></td>
														<td><%=result.getTFCode()%></td>
														<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,result.getDOLFrom())%></td>
														<td><%=result.getCatCode()%></td>
														<td><%=result.getOrigCcy()%></td>
														<td><script>document.write(insertCommas("<%=result.getPTDAmount()%>"));</script></td>
														<td></td>
													</tr>
													<tr>
														<td><script>createToolTip("<%=result.getReinsuredLossName()%>",13)</script></td>
														<td><%=result.getBkrClaimRef1()%></td>
														<td></td>
														<td><%=result.getStateCode()%></td>
														<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,result.getDOLTo())%></td>
														<td><%=result.getPcsCatCode()%></td>
														<td></td>
														<td><script>document.write(insertCommas("<%=result.getOSAmount()%>"));</script></td>
														<td><%=result.getOutStanQual()%></td>
													</tr>
													<%
												}
											%>
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
<script>altColumnRows('movementsHistoryTable',2);</script>
</span>