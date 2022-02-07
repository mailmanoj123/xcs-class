<%@ page import="com.xchanging.xcc.web.html.*" %>

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">

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
						<%=HTMLUtils.createHeader("Contra Correction")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR030\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/contracorrectionrelease\")")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
				</div>
				<div class="content">
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="noscroll">
									<table class="custom" border="0">
										<tr>
											<td width="20%"></td>
											<td width="40%">Reduce outstanding amount to zero?</td>
											<td width="20%"><input type="checkbox" name="reduceOutstandingAmtToZero"></td>
											<td width="20%"></td>
										</tr>
										<tr>
											<td colspan="3">&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;</td>
											<td colspan="2">Are you sure you want to release this Contra Correction?</td>
											<td>&nbsp;</td>
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
</form>
</table>
</span>