<%@ page import="com.xchanging.xcc.web.html.*,com.xchanging.xcc.web.models.*,java.util.*" %>
<jsp:useBean id="schemecanada" type="com.xchanging.xcc.web.models.SchemeCanadaWebModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script src="<%=request.getContextPath()%>/js/tabs.js"></script>


<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<form>
<input type="submit" name="submitButton" style="display:none">
<span class="lhsNav">
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Scheme Canada Save Confirmed")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCSAVE\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
          <% if (schemecanada.isSave()) { %>
            <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/scsaveexit?previous=save\")")%>
          <% } else { %>
            <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Exit","submitForm(\"" + request.getContextPath() + "/control/scsaveexit?previous=exit\")")%>
          <% } %>
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="noscroll">
                  <table class="custom">
                    <tr>
											<td colspan="4">
												The save process has completed.
											</td>
										</tr>
										<tr>
											<td style="width:10%"></td>
											<td style="width:70%"></td>
											<td style="width:10%"><u>This Run</u></td>
											<td style="width:10%"><u>Total</u></td>
										</tr>
										<tr>
											<td></td>
											<td>&nbsp;</td>
											<td></td>
											<td></td>
										</tr>
                    <tr>
                      <td></td>
                      <td>Marked for re-processing</td>
                      <td><%=schemecanada.getReprocThisRunStat()%></td>
                      <td><%=schemecanada.getReprocTotalStat()%></td>
                    </tr>
                    <tr>
                      <td></td>
                      <td>Refered to XCS</td>
                      <td><%=schemecanada.getXcsThisRunStat()%></td>
                      <td><%=schemecanada.getXcsTotalStat()%></td>
                    </tr>
<%-- 26/04/04 changes for S456/S457 Patrick Cogan
                    <tr>
                      <td></td>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Individuals</td>
                      <td><%=schemecanada.getIndivThisRunStat()%></td>
                      <td><%=schemecanada.getIndivTotalStat()%></td>
                    </tr>
                    <tr>
                      <td></td>
                      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Individuals</td>
                      <td><%=schemecanada.getIndivThisRunStat()%></td>
                      <td><%=schemecanada.getIndivTotalStat()%></td>
                    </tr>
										<tr>
											<td></td>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Block Items</td>
											<td><%=schemecanada.getBlockThisRunStat()%></td>
											<td><%=schemecanada.getBlockTotalStat()%></td>
										</tr>
										<tr>
											<td></td>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Zero O/S Items</td>
											<td><%=schemecanada.getZerosThisRunStat()%></td>
											<td><%=schemecanada.getZerosTotalStat()%></td>
										</tr>
Not needed PRC --%>
<%--
										<tr>
											<td></td>
											<td>Marked for rejecting to Canada</td>
											<td><%=schemecanada.getRejectThisRunStat()%></td>
											<td><%=schemecanada.getRejectTotalStat()%></td>
										</tr>
--%>
<%--										<tr>
											<td></td>
											<td>Marked for deletion</td>
											<td><%=schemecanada.getDeleteThisRunStat()%></td>
											<td><%=schemecanada.getDeleteTotalStat()%></td>
										</tr>
Not needed PRC --%>
                  </table>
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
</span>
</form>