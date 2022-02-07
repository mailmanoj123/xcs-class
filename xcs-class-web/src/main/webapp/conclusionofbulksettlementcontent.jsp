<%@ page import="com.xchanging.xcc.web.html.*,java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="concofbulksett" type="com.xchanging.xcc.web.models.ConcOfBulkSettlementModel" scope="session" />

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
						<%=HTMLUtils.createHeader("Conclusion of Bulk Settlement")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR024\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
                                        <% if (concofbulksett.getPrevButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev Ccy","submitForm(\"" + request.getContextPath() + "/control/concofbulksettprevccy\")")%>
                                        <% } %>
                                        <% if (concofbulksett.getNextButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next Ccy","submitForm(\"" + request.getContextPath() + "/control/concofbulksettnextccy\")")%>
                                        <% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Proceed","submitForm(\"" + request.getContextPath() + "/control/concofbulksettproceed\")")%>
     <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,concofbulksett.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,concofbulksett.getXcr())%></td>
				<td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,concofbulksett.getTr())%></td>
			  </tr>
              <tr>
				<td><b>Current Bkr:</b></td>
                <td><%=concofbulksett.getOrigBkr()%></td>
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
												<td width="15%"><strong>Orig Ccy:</strong></td>
												<td width="10%"><%=concofbulksett.getOrigCcy()%></td>
												<td width="15%"><strong>OSND:</strong></td>
												<td width="25%"><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,concofbulksett.getOsnd())%></td>
												<td width="15%"><strong>Total:</strong></td>
												<td width="20%"><script>document.write(insertCommas("<%=concofbulksett.getTotal()%>"));</script></td>
											</tr>
										</table>
										<br>
										<table class="dataTable" width="100%" id="movementsHistoryTable" cellpadding="0" cellspacing="0">
											<tr>
												<th align="left">UCR / Name 1</th>
												<th align="left">TR</th>
												<th align="left">PTT / Name 2</th>
												<th align="left">O/S</th>
											</tr>

											<%	Enumeration items = concofbulksett.getItems();

												while (items.hasMoreElements()) {
													ConcOfBulkSettlementModel.ConclusionItem item = (ConcOfBulkSettlementModel.ConclusionItem)items.nextElement();
													%>
													<tr>
														<td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,item.getUcr())%></td>
														<td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,item.getTr())%></td>
														<td><script>document.write(insertCommas("<%=item.getPTTAmount()%>"));</script></td>
														<td><script>document.write(insertCommas("<%=item.getOSAmount()%>"));</script></td>
													</tr>
													<tr>
														<td colspan="2"><script>createToolTip("<%=item.getName1()%>",35)</script></td>
														<td colspan="2"><script>createToolTip("<%=item.getName2()%>",35)</script></td>
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