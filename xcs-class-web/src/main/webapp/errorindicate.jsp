<%@ page import="com.xchanging.xcc.web.html.*,com.xchanging.xcc.exceptions.*,java.util.*" %>
<%@ page isErrorPage="true" %>

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">

<script>
function showErrors() {
  submitForm("<%=request.getContextPath()%>/control/<%=((ClaimsErrorIndicException)exception).getUrl()%>?indicateerrors=true");
}
</script>

<span class="lhsNav">

<table class="formCenter">
<form>
<input type="submit" name="submitButton" style="display:none">
  <tr>

    <td></td>

    <td class="content">

      <!-- main content div -->

      <div class="outerWindow">

				<!-- main top graphic placement div -->

				<div class="top">

					<!-- form heading div -->

					<div class="header"> 
						<%=HTMLUtils.createHeader("Error")%> 
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"ERROR\")")%> -->
					</div>

				</div>

				<div class="menuBar"> <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","showErrors()")%>

				</div>

				<div class="content">

					<!-- content tables -->

					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" width="100%">

						<tr>

							<td valign="top" >

								<table width="100%" border="0" class="1column">

									<tr>

										<td> The following error(s) have been encountered - Please

											correct data on screen or contact Ins-sure Service desk

											(Tel:- <%=application.getAttribute("phonenumber") %>)</td>

									</tr>

									<tr>

										<td>&nbsp;</td>

									</tr>

									<tr>

										<td>

											<table border="0">
												<% 	Enumeration errors = ((ClaimsErrorIndicException)exception).getErrors();

														while(errors.hasMoreElements()) {

															ClaimsError error = (ClaimsError)errors.nextElement(); %>

																<tr>

																	<td valign="top"><%=error.getCode()%></td>

																	<td><%=error.getDescription1()%></td>

																</tr>

															<% if (!error.getDescription2().equals("")) { %>

																<tr>

																	<td></td>

																	<td><%=error.getDescription2()%></td>

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