<%@ page import="com.xchanging.xcc.web.html.*" %>
<%@ page isErrorPage="true" %>

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
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
				<!-- BUTTONS ON LEFT -->
				<div class="menuBar"> <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","errorBack()")%>
				</div>
				<!-- END OF BUTTONS ON LEFT -->
				<div class="content">
					<!-- content tables -->
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<table width="100%" border="0" class="1column">
									<tr>
										<td colspan="1">An error has ocurred - Please contact
											Ins-sure Service desk (Tel:- <%=application.getAttribute("phonenumber") %>)</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td></td>
									</tr>
									<tr>
										<td><a class="showError" style="cursor:hand;text-decoration:underline;" onClick="showHide(errorInfo)">Click
											here to view error information</a></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>
											<div id="errorInfo" style="display:none">
												<table>
													<tr>
														<td><% exception.printStackTrace(new java.io.PrintWriter(out)); %></td>
													</tr>
												</table>
											</div>
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