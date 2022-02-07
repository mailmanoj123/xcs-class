<%@ page import="com.xchanging.xcc.web.html.*" %>
<jsp:useBean id="markets" type="com.xchanging.xcc.web.models.MarketsModel" scope="session" />
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>
<script>
function checkSelected() {
  var selected = false;
  for (i=0; i<document.all.market.length; i++) {
    if (document.all.market[i].checked==true)
      selected = true;
  }
  if (!selected)
      alert("You must select a market before continuing.");
  return selected;
}
</script>
<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<form>
<input type="submit" name="submitButton" style="display:none">
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("Market Selection")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR011\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","if (checkSelected()) submitForm(\""+ request.getContextPath()+"/control/marketselection\")")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
				</div>
				<div class="content">
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="scrollmain" id="scrollpane">
								<div class="scrollmaincontent">
								<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="markets">
                        <tr>
                          <th align="left" width="5%">&nbsp;</th>
                          <th align="left" width="20%">Effective Date</th>
													<th align="left" width="10%">No of Syndicates</th>
													<th align="left" width="20%">Total Line</th>
                          <th align="left" width="45%">Market Narrative</th>
                        </tr>
                        <% int marketsCount = markets.getMarketsCount();
                           for (int i=0;i<marketsCount;i++) { %>
                        <tr>
						  <td><input type="radio" name="market" value="<%=i%>"></td>
                                                  <td><%=HTMLUtils.createDate("date" + i,HTMLUtils.DISPLAY,markets.getDate(i))%></td>
                                                  <td><%=markets.getNoOfSyndicates(i)%></td>
						  <td><%=markets.getBureauShareTotalLine(i)%></td>
						  <td><textarea rows="3" <%=markets.getMarketNarrativeFlag(i)%>><%=markets.getMarketNarrative(i)%></textarea></td>
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
</table>
</form>
</span>
<script>altColumnRows('markets',1);</script>