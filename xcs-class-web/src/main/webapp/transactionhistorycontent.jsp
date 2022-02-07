<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="txnhistory" type="com.xchanging.xcc.web.models.TransactionHistoryModel" scope="session" />

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
						<%=HTMLUtils.createHeader("Transaction History")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR025\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<% if (!txnhistory.getPrevButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev","submitForm(\"" + request.getContextPath() + "/control/txnhistoryprev\")")%>
					<% } %>
					<% if (!txnhistory.getNextButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next","submitForm(\"" + request.getContextPath() + "/control/txnhistorynext\")")%>
					<% } %>
                                        <% if (!txnhistory.getPrevCcyButtonFlag()) { %>
					        <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev Ccy","submitForm(\"" + request.getContextPath() + "/control/txnhistoryprevccy\")")%>
                                        <% } %>
                                        <% if (!txnhistory.getNextCcyButtonFlag()) { %>
                                                <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next Ccy","submitForm(\"" + request.getContextPath() + "/control/txnhistorynextccy\")")%>
                                        <% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","logoff(true)")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,txnhistory.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,txnhistory.getXcr())%></td>
                <td><b>Current Bkr:</b></td>
                <td><%=txnhistory.getOrigBkr()%></td>
              </tr>
              <tr>
				<td><b>Peer Review:</b></td>
                <td><%=txnhistory.getPeerRevInd()%></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </table>
          </div>
          <br>
					<!-- end of optional header information -->
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="scrollmain" style="height:362px" id="scrollpane">
									<div class="scrollmaincontent">
										<table class="custom">
											<tr>
												<td width="13%"><strong>Orig Ccy:</strong></td>
												<td width="15%"><%=txnhistory.getOrigCcy()%></td>
												<td width="13%"><strong>OSND:</strong></td>
												<td width="23%"><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,txnhistory.getOsnd())%></td>
												<td width="13%"><strong>Paid to Date:</strong></td>
												<td width="23%"><script>document.write(insertCommas("<%=txnhistory.getTotal()%>"));</script></td>
											</tr>
										</table>
										<br>
										<table class="dataTable" width="100%" id="movementsHistoryTable" cellpadding="0" cellspacing="0">
											<tr>
												<th align="left">Tr</th>
												<th align="left">PTT</th>
												<th align="left">O/S</th>
												<th align="left">O/S Qual</th>
												<th align="left">Trans Date</th>
												<th align="left">Status</th>
											</tr>
											<%	Enumeration txns = txnhistory.getTransactions();
												int i = 1;

												while (txns.hasMoreElements()) {
                                                                                                  TransactionHistoryModel.TransactionHistory txn = (TransactionHistoryModel.TransactionHistory)txns.nextElement();
												  if (!txn.getsysRef().trim().equals("")) {
                                                                                                   %>
													<tr id="row<%=i%>">
														<td>
															<% if (!txn.getTrButtonFlag()) { %>
																<span class="link" onclick="submitForm('<%=request.getContextPath()%>/control/selecttransaction?txn=<%=i-1%>')">
															<% } %>
															<%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,txn.getTr())%>
															<% if (!txn.getTrButtonFlag()) { %>
																</span>
															<% } %>
														</td>
														<td><script>document.write(insertCommas("<%=txn.getPaidToDate()%>"));</script></td>
														<td><script>document.write(insertCommas("<%=txn.getOSAmount()%>"));</script></td>
														<td><%=txn.getOSAmountQual()%></td>
														<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,txn.getTransDate())%></td>
														<td id="hover<%=i%>"><%=txn.getStatus()%></td>
													</tr>

													<%
													i++;
												  }
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

