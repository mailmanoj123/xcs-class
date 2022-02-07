<%@ page import="com.xchanging.xcc.web.html.*,java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="settsearchresultsscreen" type="com.xchanging.xcc.web.models.FindSettlementSearchResultsModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="<%=request.getContextPath()%>/js/alternateRows.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/formatfordisplay.js"></script>

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
                                                <%=HTMLUtils.createHeader("Settlement Enquiry Search Results")%>
                                                <!-- Below help button is no longer required since the information displayed is out of date -->
                                                <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR006\")")%> -->
                                        </div>
                                </div>
                                <div class="menuBar">
                                        <!-- MENU BUTTONS GO HERE -->
                                        <!-- Changed Cancel to go to Settlement Search input screen - STH 23/12/2003 -->
                                        <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel"," submitForm(\"" + request.getContextPath() + "/control/settlementsearchdetailresultscancel\")")%>
                                </div>
                                <div class="content">
                                        <!-- Optional header information -->
                                        <div>
            <table class="headerInfo" border="0">
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
                <tr>
                        <th align="left" width="32%">TDN</th>
                        <th align="left" width="16%">Vers No</th>
                        <th align="left" width="16%">YOA</th>
                        <th align="left" width="16%">Payee Bkr</th>
                        <th align="left" width="16%">100% Sett Amt</th>
               </tr>
                        </tr>

                        <% Enumeration results = settsearchresultsscreen.getVAllSearchDetails().elements();
                                while (results.hasMoreElements()) {
                                        FindSettlementSearchResultsModel.singleSearchResultsLine result = (FindSettlementSearchResultsModel.singleSearchResultsLine)results.nextElement();
                                %>

                        <tr>
                          <td><span class="link" onclick="submitForm('<%=request.getContextPath()%>/control/settlementsearchdetailresults?C116_TAKE_DOWN_DATE=<%=result.getLidstdnDate()%>&C116_TAKE_DOWN_NO=<%=result.getLidstdnNo()%>&C116_VERSION_NO=<%=result.getVersion()%>')"> <%=result.getLidstdnNo()%> * <%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,result.getLidstdnDate())%></span></td>
                          <td><%=result.getVersion()%></td>
                          <td><%=result.getLidsyoa()%></td>
                          <td><%=result.getLidspbkr()%></td>
                                <!-- Align right and line up to 2 dp - STH 29/12/2003-->
                          <td align="Right">
                             <script language="JavaScript">document.write(roundOff(<%=result.getLidshpc()%>,2,'y'))</script>
                          </td>
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

<!-- Changed shading from every 2 rows to every other row - STH 23/12/2003 -->
<script>altColumnRows('searchresults',1);</script>
