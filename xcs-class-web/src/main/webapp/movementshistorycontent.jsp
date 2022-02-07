<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="mvmthistory" type="com.xchanging.xcc.web.models.MovementHistoryModel" scope="session" />

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
						<%=HTMLUtils.createHeader("Movements History")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR026\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<% if (!mvmthistory.getPrevButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev","submitForm(\"" + request.getContextPath() + "/control/mvmthistoryprev\")")%>
					<% } %>
					<% if (!mvmthistory.getNextButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next","submitForm(\"" + request.getContextPath() + "/control/mvmthistorynext\")")%>
					<% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","logoff(true)")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,mvmthistory.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,mvmthistory.getXcr())%></td>
                <td><b>OSND:</b></td>
                <td><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,mvmthistory.getOsnd())%></td>
              </tr>
              <tr>
				<td><b>Signed:</b></td>
                <td><%=mvmthistory.getSigned()%></td>
                <td><b>Current Bkr:</b></td>
                <td><%=mvmthistory.getOrigBkr()%></td>
                <td><b>COR:</b></td>
                <td><%=HTMLUtils.createCor("",HTMLUtils.DISPLAY,mvmthistory.getCor())%></td>
              </tr>
			  <tr>
			  	<td><b>Peer Review:</b></td>
                <td><%=mvmthistory.getPeerReview()%></td>
				<td><b>Orig Ccy:</b></td>
				<td><%=mvmthistory.getOrigCcy()%></td>
				<td></td>
				<td>

                               </td>
			  </tr>
            </table>
          </div>
          <br>
					<!-- end of optional header information -->
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top">
								<div class="scrollmain" style="height:346px" id="scrollpane">
									<div class="scrollmaincontent">
										<table class="dataTable" width="100%" id="movementsHistoryTable" cellpadding="0" cellspacing="0" id="tab1">
											<tr>
												<th align="left">Mvmt Ref</th>
												<th align="left">PTT in Orig</th>
												<th align="left">O/S</th>
												<th align="left">O/S Qual</th>
												<th align="left">Trans Date</th>
												<th align="left">TDN</th>
												<th align="left">User Id</th>
											</tr>

											<%	Enumeration mvmts = mvmthistory.getMovements();
												int i = 1;

												while (mvmts.hasMoreElements()) {
													MovementHistoryModel.MovementHistory mvmt = (MovementHistoryModel.MovementHistory)mvmts.nextElement(); %>
													<tr id="row<%=i%>">
														<td>
															<% if (!mvmt.getMvmtRefButtonFlag()) { %>
																<span class="link" onclick="submitForm('<%=request.getContextPath()%>/control/selectmovement?mvmtref=<%=mvmt.getMvmtRef()%>&sysRef=<%=mvmt.getSysRef()%>&currNo=<%=mvmt.getCurrNo()%>&sdnNo=<%=mvmt.getSdnNo()%>&statSplitNo=<%=mvmt.getStatSplitNo()%>&breakdownNo=<%=mvmt.getBreakdownNo()%>')">
															<% } %>
															<%=mvmt.getMvmtRef()%>
															<% if (!mvmt.getMvmtRefButtonFlag()) { %>
																</span>
															<% } %>
														</td>
														<td><script>document.write(insertCommas("<%=mvmt.getPTTInOrig()%>"));</script></td>
														<td><script>document.write(insertCommas("<%=mvmt.getOSAmount()%>"));</script></td>
														<td><%=mvmt.getOSAmountQual()%></td>
														<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,mvmt.getTransDate())%></td>
														<td><%=HTMLUtils.createTdn("",HTMLUtils.DISPLAY,mvmt.getTdn())%></td>
														<td id="hover<%=i%>"><%=mvmt.getUserId()%></td>
													</tr>
                                                                                                    <% i++;
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
<script>altColumnRows('movementsHistoryTable',1);</script>
</span>


