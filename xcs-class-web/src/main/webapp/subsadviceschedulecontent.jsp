<%@ page import="com.xchanging.xcc.web.html.*, java.util.*,com.xchanging.xcc.web.models.*,com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="sas" type="com.xchanging.xcc.web.models.SubsequentAdviceScheduleModel" scope="session" />
<jsp:useBean id="stateCodeList" type="com.xchanging.xcc.web.models.reference.StateCodeList" scope="application" />

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
						<%=HTMLUtils.createHeader("Subs Advice Schedule")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR020\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<% if (!sas.getSaveButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","submitForm(\"" + request.getContextPath() + "/control/subsadvicesave\")")%>
					<% } %>
					<% if (!sas.getPrevButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev","submitForm(\"" + request.getContextPath() + "/control/subsadviceprev\")")%>
					<% } %>
					<% if (!sas.getNextButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next","submitForm(\"" + request.getContextPath() + "/control/subsadvicenext\")")%>
					<% } %>
					<% if (!sas.getNewBreakdownButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"New Breakdown","submitForm(\"" + request.getContextPath() + "/control/subsadvicenewbd\")")%>
					<% } %>
					<% if (!sas.getDeleteSelectedButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Delete Selected","if (confirm(\"Are you sure you want to delete the selected lines?\")) submitForm(\"" + request.getContextPath() + "/control/subsadvicedelete\")")%>
					<% } %>
					<% if (!sas.getNextCcyFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next Ccy","submitForm(\"" + request.getContextPath() + "/control/subsadvicenextccy\")")%>
					<% } %>
					<% if (!sas.getFinishButtonFlag()) { %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Finish","submitForm(\"" + request.getContextPath() + "/control/subsadvicefinish\")")%>
					<% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/subsadvicecancel\", false)")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,sas.getucr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,sas.getxcr())%></td>
                <td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,sas.gettr())%></td>
              </tr>
              <tr>
                <td><b>OSND:</b></td>
                <td><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,sas.getorigRef1())%></td>
		<td><b>Signed:</b></td>
                <td><%=sas.getsignedInd()%></td>
                <td><b>Current Bkr:</b></td>
                <td><%=sas.getorigBkr()%></td>
              </tr>
              <tr>
                <td><b>Orig Ccy:</b></td>
                <td><%=sas.getorigCurr()%></td>
                <td><b>Peer Review:</b></td>
                <td><%=sas.getpeerRevInd()%></td>
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
										<table class="dataTable" width="100%" id="movementsHistoryTable" border="0" cellspacing="0">
											<tr>
                                                                                                <th>
												<th align="left">Del</th>
												<th align="left">Cor</th>
												<th align="left">Mvmt Ref</th>
												<th align="left">Name 1/2</th>
												<th align="left">Q</th>
                                                                                                <th align="left">State/TF Code</th>
												<th align="left">NAIC/Fil Code</th>
												<th align="left">Q</th>
												<th align="left">DOL From/To</th>
												<th align="left">Q</th>
												<th align="left">CAT/PCS Code</th>
											</tr>
											<% 	Enumeration bkdwns = sas.getbreakdowns();
												int i = 1;
												while(bkdwns.hasMoreElements()){
												SubsequentAdviceScheduleModel.SubsAdviceSchedule bkdwn = (SubsequentAdviceScheduleModel.SubsAdviceSchedule)bkdwns.nextElement();%>
												<tr>
                                                                                                        <td><input type="hidden" name="statsplit<%=i%>" value="<%=bkdwn.getstatSplitNo()%>">
                                                                                                        <input type="hidden" name="mvmtref<%=i%>" value="<%=bkdwn.getmvmtRef()%>">
                                                                                                        <input type="hidden" name="breakdownno<%=i%>" value="<%=bkdwn.getbreakdownNo()%>"></td>
													<td><input type="checkbox" name="delchkbox<%=i%>" <%=bkdwn.getdelChkBoxFlag()%>></td>
													<td style="white-space:nowrap;"><span class="link" onclick="submitForm('<%=request.getContextPath()%>/control/selectsubsadvice?cor=<%=i%>')"><%=HTMLUtils.createCor("",HTMLUtils.DISPLAY, bkdwn.getcor())%></span><input type="hidden" name="cor<%=i%>" value="<%=bkdwn.getcor()%>"></td>
													<td><%=bkdwn.getmvmtRef()%></td>
													<td><input type="hidden" name="name1<%=i%>" value="<%=bkdwn.getname1()%>"><%=bkdwn.getname1()%></td>
													<td><input type="hidden" name="name1qual<%=i%>" value="<%=bkdwn.getname1Qual()%>"><%=bkdwn.getname1Qual()%></td>
													<td>
                                                                                                        <% if (bkdwn.getstateCodeFlag()) { %>
                                                                                                            <input type="hidden" name="statecode<%=i%>" value="<%=bkdwn.getstateCode()%>"><%=bkdwn.getstateCode()%></td>
                                                                                                        <% } else { %>
                                                                                                            <%=HTMLUtils.createDropdown("statecode" + i,bkdwn.getstateCode(),false,stateCodeList)%>
                                                                                                            </select>
                                                                                                        <% } %>
                                                                                                        </td>
													<td><input type="hidden" name="naiccode<%=i%>" value="<%=bkdwn.getnaicCode()%>"><%=bkdwn.getnaicCode()%></td>
													<td><input type="hidden" name="naicqual<%=i%>" value="<%=bkdwn.getnaicQual()%>"><%=bkdwn.getnaicQual()%></td>
													<td><input type="hidden" name="dolfrom<%=i%>" value="<%=bkdwn.getdolFrom()%>"><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY, bkdwn.getdolFrom())%></td>
													<td><input type="hidden" name="dolqual<%=i%>" value="<%=bkdwn.getdolQual()%>"><%=bkdwn.getdolQual()%></td>
													<td><input type="hidden" name="catcode<%=i%>" value="<%=bkdwn.getcatCode()%>"><%=bkdwn.getcatCode()%></td>
												</tr>
												<tr>
                                                                                                        <td></td>
													<td></td>
													<td></td>
													<td></td>
													<td><input type="hidden" name="name2<%=i%>" value="<%=bkdwn.getname2()%>"><%=bkdwn.getname2()%></td>
													<td><input type="hidden" name="name2qual<%=i%>" value="<%=bkdwn.getname2Qual()%>"><%=bkdwn.getname2Qual()%></td>
													<td><input type="hidden" name="tfcode<%=i%>" value="<%=bkdwn.gettfCode()%>"><%=bkdwn.gettfCode()%></td>
													<td><input type="hidden" name="filcode<%=i%>" value="<%=bkdwn.getfilCode()%>"><%=bkdwn.getfilCode()%></td>
													<td></td>
													<td><input type="hidden" name="dolto<%=i%>" value="<%=bkdwn.getdolTo()%>"><%=HTMLUtils.createDate("dolto" + i,HTMLUtils.DISPLAY, bkdwn.getdolTo())%></td>
													<td></td>
													<td><input type="hidden" name="pcscode<%=i%>" value="<%=bkdwn.getpcsCode()%>"><%=bkdwn.getpcsCode()%></td>
												</tr>
                                                                                                <tr>
                                                                                                  <td></td>
                                                                                                  <td></td>
                                                                                                  <td></td>
                                                                                                  <td><b>PTT:</b></td>
                                                                                                  <td colspan="3"><input type="hidden" name="pttAmt<%=i%>" value="<%=bkdwn.getPttAmt()%>"><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal( bkdwn.getPttAmt()))%></td>
                                                                                                  <td><b>O/S:</b></td>
                                                                                                  <td colspan="2"><input type="hidden" name="osAmt<%=i%>" value="<%=bkdwn.getOsAmt()%>"><%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(bkdwn.getOsAmt()))%></td>
                                                                                                  <td></td>
																								  <td><b>Qual:</b>&nbsp&nbsp<%=bkdwn.getOsAmtTotQual()%></td>                                                                                               
                                                                                                </tr>
											<%i++; }%>
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
<script>altColumnRows('movementsHistoryTable',3);</script>
</span>

