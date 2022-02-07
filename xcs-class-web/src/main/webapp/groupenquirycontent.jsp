<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="groupenq" type="com.xchanging.xcc.web.models.GroupEnquiryModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script src="<%=request.getContextPath()%>/js/tabs.js"></script>
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>

<script language="JavaScript" src="<%=request.getContextPath()%>/js/debug.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/error.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/messagelist.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vfield.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vform.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vtab.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/VGroup.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/positionlayer.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphavalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/groupenquirycontentcustom.js"></script>


<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="groupenquirycontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Group Enquiry")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR028\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
	<% if (!groupenq.getAddToGroupButtonFlag()) { %>
              <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Add to Group","submitForm(\"" + request.getContextPath() + "/control/groupenquiryadd\")")%>
	<% } %>
        <% if (!groupenq.getPrevButtonFlag()) { %>
          <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev Ccy","submitForm(\"" + request.getContextPath() + "/control/groupenquiryprevccy\",false)")%>
        <% } %>
        <% if (!groupenq.getNextButtonFlag()) { %>
          <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next Ccy","submitForm(\"" + request.getContextPath() + "/control/groupenquirynextccy\",false)")%>
        <% } %>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","logoff(true)")%>
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="scrollmain" style="height:410px" id="scrollpane">
                  <div class="scrollmaincontent">
                    <table class="4column">
                      <tr>
                        <td>&nbsp;</td>
                        <td>Aggregate/Non-Aggregate Group Ref</td>
                        <td><input type="text" name="aggGrpNonAggRef" value="<%=groupenq.getAggGrpNonAggRef()%>"></td>
                        <td><span class="link" onclick="submitForm('<%=request.getContextPath()%>/control/groupenquiryfind')"><i>Find Group</i></span></td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>Group Type</td>
                        <td><%=groupenq.getGroupType()%></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>Orig Ccy</td>
                        <td><%=groupenq.getOrigCcy()%></td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
                    <br>
					<center>
                    <table class="dataTable" cellpadding="0" cellspacing="0" border="0" id="groupTable" width="75%">
                      <tr>
                        <th align="left">UCR</td>
                        <th align="left">PTD</td>
                        <th align="left">O/S</td>
                      </tr>

					  <% Enumeration lines = groupenq.getLines();

						 while (lines.hasMoreElements()) {
						 	GroupEnquiryModel.GroupEnquiryLine line = (GroupEnquiryModel.GroupEnquiryLine)lines.nextElement();
						 	%>
					  		  <tr>
                        		<td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,line.getUcr())%></td>
		                        <td><script>document.write(insertCommas("<%=line.getPtd()%>"));</script></td>
        		                <td><script>document.write(insertCommas("<%=line.getOSAmount()%>"));</script></td>
                		      </tr>
							<%
						  }
						%>

                      <tr>
                        <td align="right"><strong>Totals</strong></td>
                        <td><script>document.write(insertCommas("<%=groupenq.getPtdTotal()%>"));</script></td>
                        <td><script>document.write(insertCommas("<%=groupenq.getOSAmountTotal()%>"));</script></td>
                      </tr>
                    </table>
					</center>
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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/groupenquirycontent.js"></script>
<script>altColumnRows('groupTable',1);</script>
</form>
</table>
</span>