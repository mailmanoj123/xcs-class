<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="bulkcompselect" type="com.xchanging.xcc.web.models.BulkComponentSelectionModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>
<script src="<%=request.getContextPath()%>/js/selectitemsforbulksettlement.js"></script>

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
						<%=HTMLUtils.createHeader("Select Items for Bulk Settlement")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR023\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<% if (!bulkcompselect.getPrevButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev","submitForm(\"" + request.getContextPath() + "/control/bulkcompselectprev\")")%>
					<% } %>
					<% if (!bulkcompselect.getNextButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next","submitForm(\"" + request.getContextPath() + "/control/bulkcompselectnext\")")%>
					<% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Refresh","submitForm(\"" + request.getContextPath() + "/control/bulkcompselectrefresh\")")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Proceed","submitForm(\"" + request.getContextPath() + "/control/bulkcompselectproceed\")")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/bulkcompselectcancel\", false)")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,bulkcompselect.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,bulkcompselect.getXcr())%></td>
				<td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,bulkcompselect.getTr())%></td>
			  </tr>
			  <tr>
                <td><b>OSND 1:</b></td>
                <td><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,bulkcompselect.getOsnd1())%></td>
				<td><b>OSND 2:</b></td>
                <td><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,bulkcompselect.getOsnd2())%></td>
				<td><b>OSND 3:</b></td>
                <td><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,bulkcompselect.getOsnd3())%></td>
              </tr>
              <tr>
				<td><b>Peer Review:</b></td>
                <td><%=bulkcompselect.getPeerReview()%></td>
                <td><b>Current Bkr:</b></td>
                <td><%=bulkcompselect.getOrigBkr()%></td>
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
								<div class="scrollmain" style="height:346px" id="scrollpane">
									<div class="scrollmaincontent">
                                                                                <table width="100%">
                                                                                  <tr>
                                                                                    <td><b>Target PTT Amount:</b></td>
                                                                                    <td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal( bulkcompselect.getTargetPTTAmount()))%></td>
                                                                                    <td><b>Target OS Amount:</b></td>
                                                                                    <td><%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(bulkcompselect.getTargetOSAmount()))%></td>
                                                                                  </tr>
                                                                                  <tr>
                                                                                    <td><b>Actual PTT Amount:</b></td>
                                                                                    <td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(bulkcompselect.getActualPTTAmount()))%></td>
                                                                                    <td><b>Actual OS Amount:</b></td>
                                                                                    <td><%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(bulkcompselect.getActualOSAmount()))%></td>
                                                                                  </tr>
                                                                                </table>
										<table class="dataTable" width="100%" id="movementsHistoryTable" cellpadding="0" cellspacing="0">
											<tr>
												<th align="left">Inc</th>
												<th align="left">UCR/COR</th>
												<th align="left">Name 1/2</th>
												<th align="left">DCM/DOL</th>
												<th align="left">Bkr Claim Ref 1</th>
												<th align="left">Setup and Released</th>
                                                                                                <th>&nbsp;</th>
											</tr>

											<%	Enumeration items = bulkcompselect.getItems();
												int i=1;
												while (items.hasMoreElements()) {
													BulkComponentSelectionModel.BulkSettlementItem item = (BulkComponentSelectionModel.BulkSettlementItem)items.nextElement();
													%>
													<tr>
                                                                                                                <td><input type="checkbox" <%=item.getInclude()%> name="item<%=i%>" onclick="includeClicked(<%=i%>)" <%=item.getIncludeFlag()%>></td>
                                                                                                                <td><a id="ucrlink<%=i%>" href="javascript:newWindow('<%=request.getContextPath()%>/control/selectbulksettlement?compSysRef=<%=item.getCompSysRef()%>')"><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,item.getUcr())%></a></td>
														<td style="white-space:nowrap"><script>createToolTip("<%=item.getName1()%>",15)</script></td>
														<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,item.getDCM())%></td>
														<td><%=item.getBkrClaimRef1()%></td>
														<td><input type="checkbox" <%=item.getProcessed()%> name="processed<%=i%>" onClick="return false" readonly="true" DISABLED></td>
                                                                                                                <td><i><a style="cursor:hand;text-decoration:underline;" onClick="submitForm('<%=request.getContextPath()%>/control/bulkcompselectmore?compSysRef=<%=item.getCompSysRef()%>')">more</a></i></td>
													</tr>
													<tr>
														<td></td>
														<td><%=item.getCOR()%></td>
														<td style="white-space:nowrap"><script>createToolTip("<%=item.getName2()%>",15)</script></td>
														<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,item.getDOL())%></td>
														<td></td>
														<td></td>
                                                                                                                <td></td>
													</tr>
                                                                                                        <% if (item.showMore()) {
                                                                                                          for (int j=0; j<item.getBreakdownDetails().size(); j++) {
                                                                                                            BulkComponentSelectionModel.BreakdownDetail bdown = (BulkComponentSelectionModel.BreakdownDetail)item.getBreakdownDetails().get(j);
                                                                                                          %>

                                                                                                          <tr>
                                                                                                            <td colspan="7">
                                                                                                              <table class="subtable">
                                                                                                                <tr>
                                                                                                                  <td><b>COR:</b></td>
                                                                                                                  <td><%=bdown.getCOR()%></td>
                                                                                                                  <td><b>Orig Ccy:</b></td>
                                                                                                                  <td><%=bdown.getOrigCcy()%></td>
                                                                                                                </tr>
                                                                                                                <tr>
                                                                                                                  <td><b>Name 1:</b></td>
                                                                                                                  <td colspan="3"><%=bdown.getName1()%></td>
                                                                                                                </tr>
                                                                                                                <tr>
                                                                                                                  <td><b>DOL From:</b></td>
                                                                                                                  <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,bdown.getDOLFrom())%></td>
                                                                                                                  <td><b>DOL To:</b></td>
                                                                                                                  <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,bdown.getDOLTo())%></td>
                                                                                                                </tr>
                                                                                                                <tr>
                                                                                                                  <td><b>DCM From:</b></td>
                                                                                                                  <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,bdown.getDCMFrom())%></td>
                                                                                                                  <td><b>DCM To:</b></td>
                                                                                                                  <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,bdown.getDCMTo())%></td>
                                                                                                                </tr>
                                                                                                                <tr>
                                                                                                                  <td><b>State Code:</b></td>
                                                                                                                  <td><%=bdown.getStateCode()%></td>
                                                                                                                  <td><b>NAIC Code/Qual:</b></td>
                                                                                                                  <td><%=bdown.getNaicCode()%> <%=bdown.getNaicQual()%></td>
                                                                                                                </tr>
                                                                                                                <tr>
                                                                                                                  <td><b>Cat Code:</b></td>
                                                                                                                  <td><%=bdown.getCatCode()%></td>
                                                                                                                  <td><b>PCS Cat Code:</b></td>
                                                                                                                  <td><%=bdown.getPCSCatCode()%></td>
                                                                                                                </tr>
                                                                                                                <tr>
                                                                                                                  <td><b>PTT Amount:</b></td>
                                                                                                                  <td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(bdown.getPTTAmount()))%></td>
                                                                                                                  <td><b>OS Amount:</b></td>
                                                                                                                  <td><%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(bdown.getOSAmount()))%></td>
                                                                                                                </tr>
                                                                                                              </table>
                                                                                                            </td>
                                                                                                          </tr>

                                                                                                        <% }
												        }%>

													<%
													i++;
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
<script language="JavaScript">
includeAllClicked(<%=i%>);
altColumnRows('movementsHistoryTable',2);
</script>
</span>