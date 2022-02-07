<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>

<jsp:useBean id="createreadvice" type="com.xchanging.xcc.web.models.CreateReadviceModel" scope="session" />

<jsp:useBean id="narrativeList" type="com.xchanging.xcc.web.models.reference.NarrativeList" scope="application" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script language="JavaScript" src="<%=request.getContextPath()%>/js/debug.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/error.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/messagelist.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vfield.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vform.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/positionlayer.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphaextendedvalidator.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="createreadvicecontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("Create Re-Advice")%>
                        <!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR_CREATE_READVICE\")")%> -->

					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/createreadviceok\")")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
				</div>
				<div class="content">
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="noscroll">
									<table class="custom" cellspacing="0">
										<tr>
											<td width="30%"></td>
											<td width="15%"></td>
											<td width="5%"></td>
											<td width="50%"></td>
										</tr>
										<tr>
											<td colspan="4">Please enter Current Narrative:-</td>
										</tr>
										<tr>
											<td colspan="4">&nbsp;</td>
										</tr>
										<tr>
											<td colspan="4"><input type="text" name="currentNarrative1" value="<%=createreadvice.getCurrentNarrative1()%>" <%=createreadvice.getCurrentNarrative1Flag()%>></td>
										</tr>
										<tr>
											<td colspan="4">&nbsp;</td>
										</tr>
										<tr>
                                                                                	<td>&nbsp;</td>
											<td>
											<% Enumeration narrativeCodes;
											if ( createreadvice.getNarrativeCode1Flag()) { %>
												<input type="text" value="<%=createreadvice.getNarrativeCode1()%>" class="fieldProtect" readonly="true">
												<input type="hidden" name="narrativeCode1" value="<%=createreadvice.getNarrativeCode1()%>">
											<% } else { %>
												<select name="narrativeCode1" onKeyUp="currentNarrative2A.value = document.all.narrativeCode1.options[document.all.narrativeCode1.selectedIndex].narr" onChange="currentNarrative2A.value = document.all.narrativeCode1.options[document.all.narrativeCode1.selectedIndex].narr">
											  	<% narrativeCodes = narrativeList.getNarratives();
												  while (narrativeCodes.hasMoreElements()) {
												          NarrativeList.Narrative narrative = (NarrativeList.Narrative)narrativeCodes.nextElement(); %>
											          <option value="<%=narrative.getCode()%>" narr="<%=narrative.getText()%>" <%=createreadvice.getNarrativeCode1().equals(narrative.getCode())?"SELECTED":""%>><%=narrative.getCode()%></option>
												  <% } %>
												</select>
											<% } %>
											</td>
											<td>&nbsp;</td>
											<td><input type="text" name="currentNarrative2A" value="<%=createreadvice.getCurrentNarrative2A()%>" <%=createreadvice.getCurrentNarrative2AFlag()%>></td>
										</tr>
										<tr>
											<td colspan="4">&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td>
											<% if (createreadvice.getNarrativeCode2Flag()) { %>
												<input type="text" value="<%=createreadvice.getNarrativeCode2()%>" class="fieldProtect" readonly="true">
												<input type="hidden" name="narrativeCode2" value="<%=createreadvice.getNarrativeCode2()%>">
											<% } else { %>
												<select name="narrativeCode2" onKeyUp="currentNarrative2B.value = document.all.narrativeCode2.options[document.all.narrativeCode2.selectedIndex].narr" onChange="currentNarrative2B.value = document.all.narrativeCode2.options[document.all.narrativeCode2.selectedIndex].narr">
												  <% narrativeCodes = narrativeList.getNarratives();
												  while (narrativeCodes.hasMoreElements()) {
											          	NarrativeList.Narrative narrative = (NarrativeList.Narrative)narrativeCodes.nextElement(); %>
											          	<option value="<%=narrative.getCode()%>" narr="<%=narrative.getText()%>" <%=createreadvice.getNarrativeCode2().equals(narrative.getCode())?"SELECTED":""%>><%=narrative.getCode()%></option>
												  <% } %>
												</select>
											<% } %>
											</td>
											<td>&nbsp;</td>
											<td><input type="text" name="currentNarrative2B" value="<%=createreadvice.getCurrentNarrative2B()%>" <%=createreadvice.getCurrentNarrative2BFlag()%>></td>
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
  <script language="JavaScript" src="<%=request.getContextPath()%>/js/screen/createreadvicecontent.js"></script>
</form>
</table>
</span>