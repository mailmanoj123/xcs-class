<%@ page import="com.xchanging.xcc.web.html.*,java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="searchResults" type="com.xchanging.xcc.web.models.AdvancedSearchResultsModel" scope="session" />

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
						<%=HTMLUtils.createHeader("Advanced Search Results")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"ADVSRC\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<% if (!searchResults.getPrevButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev","submitForm(\"" + request.getContextPath() + "/control/moresearchresults?direction=back\")")%>
					<% } %>
					<% if (!searchResults.getNextButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next","submitForm(\"" + request.getContextPath() + "/control/moresearchresults?direction=fwd\")")%>
					<% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/searchresultscancel\", false)")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
              <table width="216" border="0" class="headerInfo">
              <tr>
                <b>Results for:</b>&nbsp;&nbsp;<%= searchResults.getDisplayQuery() %>
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
                          <th align="left">DOL/DCM</th>
                        </tr>

                        <% Enumeration results = searchResults.getResults();
                        	while (results.hasMoreElements()) {
                        		SearchResult result = (SearchResult)results.nextElement();
                        	%>

                        <tr>
						<td><span class="link" onclick="submitForm('<%=request.getContextPath()%>/control/selectsearchresult?cor=<%=result.getCor()%>')"><%=HTMLUtils.createCor("",HTMLUtils.DISPLAY,result.getCor())%></span></td>
                          <td><%=result.getName1()%></td>
                          <td><%=HTMLUtils.createDate("dolFrom",HTMLUtils.DISPLAY,result.getDateOfLoss())%></td>
                        </tr>
												<tr>
													<td><%=HTMLUtils.createUcr("ucr",HTMLUtils.DISPLAY,result.getUcr())%></td>
													<td><%=result.getName2()%></td>
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