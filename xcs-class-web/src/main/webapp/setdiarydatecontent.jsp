<%@ page import="com.xchanging.xcc.web.html.*" %>
<jsp:useBean id="setdiarydate" type="com.xchanging.xcc.web.models.SetDiaryDateModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script language="JavaScript" src="<%=request.getContextPath()%>/js/debug.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/error.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/messagelist.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vfield.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vform.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/VGroup.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/positionlayer.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/screen/setdiarydatecontentcustom.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("Set Diary Date")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR034\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/setdiarydateok\")")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","closeWindow()")%>
				</div>
				<div class="content">
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="noscroll">
									<form name="setdiarydatecontent">
                                                                        <input type="submit" name="submitButton" style="display:none">
										<table class="4column">
											<tr>
												<td colspan="4">
													Please enter or amend diary date for this claim
												</td>
											</tr>
											<tr>
												<td colspan="4">&nbsp;</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>Diary Date</td>
                                                                                                <td><%=HTMLUtils.createDate("diaryDate",HTMLUtils.NORMAL,setdiarydate.getDiaryDate())%></td>
												<td>&nbsp;</td>
											</tr>
										</table>
										<script language="JavaScript" src="<%=request.getContextPath()%>/js/screen/setdiarydatecontent.js"></script>
									</form>
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