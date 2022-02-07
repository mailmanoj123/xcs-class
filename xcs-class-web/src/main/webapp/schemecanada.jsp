<%@ page import="com.xchanging.xcc.web.html.*,com.xchanging.xcc.web.models.*,java.util.*" %>
<jsp:useBean id="schemecanada" type="com.xchanging.xcc.web.models.SchemeCanadaWebModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script src="<%=request.getContextPath()%>/js/tabs.js"></script>
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>

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
            <%=HTMLUtils.createHeader("Scheme Canada Unmatched Items")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"CANADA\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
					<% if (!schemecanada.getPrevButtonFlag()) { %>
                                          <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Prev","submitForm(\"" + request.getContextPath() + "/control/scPrevPressed\")")%>
					<% } %>
					<% if (!schemecanada.getNextButtonFlag()) { %>
		 			  <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Next","submitForm(\"" + request.getContextPath() + "/control/scNextPressed\")")%>
					<% } %>
					<% if (!schemecanada.getSaveButtonFlag()) { %>
					  <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","submitForm(\"" + request.getContextPath() + "/control/scSavePressed\")")%>
                                        <% } %>
				        <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Process","submitForm(\"" + request.getContextPath() + "/control/scProcessPressed\")")%>
				        <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Exit","window.opener.resetLogoffTimer(); submitForm(\"" + request.getContextPath() + "/control/scExitPressed\")")%>
					<% if (!schemecanada.getAutomotiveButtonFlag()) { %>
					  <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Automotive","submitForm(\"" + request.getContextPath() + "/control/scAutoPressed\")")%>
					<% } %>
					<% if (!schemecanada.getCommercialButtonFlag()) { %>
					  <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Commercial","submitForm(\"" + request.getContextPath() + "/control/scCommercialPressed\")")%>
					<% } %>
					<% if (!schemecanada.getResidentialButtonFlag()) { %>
					  <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Residential","submitForm(\"" + request.getContextPath() + "/control/scResidentialPressed\")")%>
					<% } %>
        </div>
        <div class="content">
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td width="17%"><b>Business Class:</b></td>
                <td width="17%"><%=schemecanada.getBusinessClassDisplay()%></td>
                <td width="40%"></td>
								<td width="10%"><b>Rows:</b></td>
                <td width="17%"><%=schemecanada.getRowsFrom()%> to <%=schemecanada.getRowsTo()%> of <%=schemecanada.getRowsTotal()%></td>
              </tr>
            </table>
          </div>
          <!--
            clintonj 29/04/2004
                       changes most of this code because it was untidy and becoming difficult to maintain.
                       custom inline styles have been used and much of the content has been removed.  See
                       TP
          -->
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="noscroll">
                  	<table class="dataTable" id="sctable" cellpadding="0" cellspacing="0" style="width:600" border=0>
                     <tr>              
                      <td width=40><b>Item</b></td>                        
                      <td width=140>&nbsp;</td>
                      <td width=160><b>OSN&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OSD</b></td>                      
                      <td width=130><b>CCR</b></td>
                      <td width=130><b>UCR</b></td>
                    </tr>
                   <tr>
                      <td style="border-bottom: 1px solid;">&nbsp;</td>
                      <td style="border-bottom: 1px solid;"><b>Claim Type</b></td>
                      <td style="border-bottom: 1px solid;" colspan="3" ><b>Error Message</b></td>
                   </tr>   
                   <%-- Required to make alernative row colour work property --%>
                   <tr><td bgcolor="D1ECF5"></td></tr> 
                   <tr><td bgcolor="D1ECF5"></td></tr> 
                   <tr><td bgcolor="D1ECF5"></td></tr> 

										<% Enumeration e = schemecanada.getFieldValues();
										   while(e.hasMoreElements()) {
											 		SchemeCanadaWebModel.Row row = (SchemeCanadaWebModel.Row)e.nextElement();
										%>
			              
                    <tr>
                      <td><%=row.getRowNumber()%> </td>
											<td>
                          <% String action = row.getAction(); %>
                          <select name="processFlag_<%=row.getRowNumber()%>" style="width:120" onChange="submitForm('<%=request.getContextPath()%>/control/scUpdateItem')">
                          <!-- Changed list contents for S456/S457. 26.04/04 Patrick Cogan -->
                             <option value="N" <%=action.equals("N")?"SELECTED":""%>>None</option>
                             <option value="I" <%=action.equals("I")?"SELECTED":""%>>Reprocess OSND</option>
                             <option value="X" <%=action.equals("X")?"SELECTED":""%>>Refer to XCS</option>                     
                          </select>
											</td> 
											<td style="white-space:nowrap"><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,row.getTableSignRef())%></td>
											<td><%=row.getTableCcr()%></td>
											<td ><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,row.getUcr())%></td>
                    </tr>                      
                    <tr>
                      <td></td>
                      <td><%=row.getClaimTypeDisplay()%></td>														
                      <td colspan="3"><font size=1><%=row.getErrorMessage()%></font></td>
                    </tr>			                      
                    <%  }  %>                     
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
<script>altColumnRows('sctable',2);</script>
</span>
</form>

<!--
$Log: schemecanada.jsp,v $
Revision 1.7  2004/06/02 14:29:31  coganp
Additional fix For Paul Warren, done on the Back of the Sceme Canada changes.
Changed where the osnd and cct fieilds get ther info from to Table ccr and osnd


-->