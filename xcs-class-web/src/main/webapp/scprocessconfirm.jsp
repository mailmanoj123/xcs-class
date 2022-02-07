<%@ page import="com.xchanging.xcc.web.html.*,com.xchanging.xcc.web.models.*,java.util.*" %>
<jsp:useBean id="schemecanada" type="com.xchanging.xcc.web.models.SchemeCanadaWebModel" scope="session" />
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>
<script src="<%=request.getContextPath()%>/js/tabs.js"></script>
<script src="<%=request.getContextPath()%>/js/debug.js"></script>
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
            <%=HTMLUtils.createHeader("Scheme Canada Process Confirmed")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCCONF\")")%> -->
          </div>
        </div>
        <div class="menuBar">          
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/getunmatchedlist\")")%>
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="noscroll">
                  <table class="custom">
                    <tr>
											<td colspan="4">
												Processing has completed.
											</td>
										</tr>
										<tr>
											<td style="width:10%"></td>
											<td style="width:75%"></td>
											<td style="width:10%"><u>This Run</u></td>
											<td style="width:5%"></td>
										</tr>
										<tr>
           <td></td>
											<td><u>Sent for re-matching</u></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sent for re-matching</td>
											<td><%=schemecanada.getReprocThisRunStat()%></td>
											<td></td>
										</tr>
										<tr>
											<td colspan="4">
The re-matching process have been initiated.
</td>
										</tr>
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

<!--

$Log: scprocessconfirm.jsp,v $
Revision 1.3  2004/05/26 12:24:28  coganp
Fixed page compile error bug. for SIRS 37839/37844.


-->