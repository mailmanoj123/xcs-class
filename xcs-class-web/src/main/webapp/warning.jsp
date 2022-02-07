<%@ page import="com.xchanging.xcc.web.html.*,com.xchanging.xcc.exceptions.*,java.util.*" %>
<%@ page isErrorPage="true" %>

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">

<span class="lhsNav">

<table class="formCenter">
<form>
<input type="submit" name="submitButton" style="display:none">
<%
   Enumeration e = request.getParameterNames();
   while (e.hasMoreElements()) {
     String s = (String)e.nextElement();
     if (!s.equals("ignoreWarnings")) { %>
       <input type="hidden" name="<%=s%>" value="<%=HTMLUtils.escapeChars(request.getParameter(s))%>">
     <% }
   }%>



	<tr>

		<td></td>

		<td class="content">

			<!-- main content div -->

			<div class="outerWindow">

				<!-- main top graphic placement div -->

				<div class="top">

					<!-- form heading div -->

					<div class="header"> 
					 <%=HTMLUtils.createHeader("Warning")%> 
					 <!-- Below help button is no longer required since the information displayed is out of date -->
					 <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"WARNING\")")%> -->
					</div>

				</div>

				<div class="menuBar"> <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Continue","submitForm((window.location + \"\").substring(0,(window.location + \"\").indexOf(\";\")) + \"?ignoreWarnings=true\")")%>

					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","errorBack()")%> </div>

				<div class="content">

					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >

						<tr>

							<td valign="top" >

								<table width="100%" border="0" class="1column">

									<tr>

										<td>Please take a moment to read the following warning(s)

											before proceeding:-</td>

									</tr>

									<tr>

										<td>&nbsp;</td>

									</tr>

									<tr>

										<td>

											<table border="0">

												<% 	Enumeration warnings = ((ClaimsWarningException)exception).getWarnings();

														while(warnings.hasMoreElements()) {

															ClaimsWarning warning = (ClaimsWarning)warnings.nextElement(); %>

																<tr>

																	<td valign="top"><%=warning.getCode()%></td>

																	<td><%=warning.getDescription1()%></td>

																</tr>

															<% if (!warning.getDescription2().equals("")) { %>

																<tr>

																	<td></td>

																	<td><%=warning.getDescription2()%></td>

																</tr>

															<% } %>

														<% } %>

											</table>

										</td>

									</tr>

								</table>

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