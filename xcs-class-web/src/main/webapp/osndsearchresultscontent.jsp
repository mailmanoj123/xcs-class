<%@ page import="com.xchanging.xcc.web.html.*,java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="osndResults" type="com.xchanging.xcc.web.models.OsndSearchResultsModel" scope="session" />

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
						<%=HTMLUtils.createHeader("OSND Search Results")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR006\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<% if (!osndResults.getPrevButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev","submitForm(\"" + request.getContextPath() + "/control/prevosndresults\")")%>
					<% } %>
					<% if (!osndResults.getNextButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next","submitForm(\"" + request.getContextPath() + "/control/nextosndresults\")")%>
					<% } %>
                                        <% if (!osndResults.getContButtonFlag()) { %>
                                                <%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Cont with New Advice","submitForm(\"" + request.getContextPath() + "/control/continuewithnewadvice\")")%>
                                        <% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/osndresultscancel\", false)")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
            <table class="headerInfo" border="0">
              <tr>
                <td><b>OSND:</b>&nbsp;&nbsp;<%=HTMLUtils.createOsnd("osnd",HTMLUtils.DISPLAY,osndResults.getOsnd())%></td>
              </tr>
						</table>
          </div>
          <br>
					<!-- end of optional header information -->
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="scrollmain" style="height:373px" id="scrollpane">
									<div class="scrollmaincontent">
										<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="searchresults">
                        <tr>
                          <th align="left">COR/UCR</th>
                          <th align="left">Name 1/2</th>
													<th align="left">DOL From/To</th>
													<th align="left">State Code</th>
                          <th align="left">Bkr Claim Ref 1</th>
                           <th align="left">O/S Q</th>
                        </tr>

                        <% Enumeration results = osndResults.getResults();
                        	while (results.hasMoreElements()) {
                        		OSNDResult result = (OSNDResult)results.nextElement();
                        	%>

                        <tr>
													<td><span class="link" onclick="submitForm('<%=request.getContextPath()%>/control/selectosndresult?ucrTrSysRef=<%=result.getUcrTrSysRef()%>&currNo=<%=result.getCurrNo()%>&sdnNo=<%=result.getSdnNo()%>&statSplitNo=<%=result.getStatSplitNo()%>&breakdownNo=<%=result.getBreakdownNo()%>')"><%=HTMLUtils.createCor("",HTMLUtils.DISPLAY,result.getCor())%></span></td>
                          <td><%=result.getName1()%></td>
                          <td><%=HTMLUtils.createDate("dolFrom",HTMLUtils.DISPLAY,result.getDolFrom())%></td>
													<td><%=result.getStateCode()%></td>
													<td><%=result.getBkrClaimRef1()%></td>
													<td><%=result.getOutStanQual()%></td>
                        </tr>
												<tr>
													<td><%=HTMLUtils.createUcr("ucr",HTMLUtils.DISPLAY,result.getUcr())%></td>
													<td><%=result.getName2()%></td>
													<td><%=HTMLUtils.createDate("dolTo",HTMLUtils.DISPLAY,result.getDolTo())%></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
						<% } %>
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
<script>altColumnRows('searchresults',2);</script>