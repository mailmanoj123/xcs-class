<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="securitynotes" type="com.xchanging.xcc.web.models.SecurityNotesModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form>
<input type="submit" name="submitButton" style="display:none">
<input type="hidden" name="prevScreen" value="<%=securitynotes.getPrevScreen()%>">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("Security Notes")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR008\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<!-- MENU BUTTONS GO HERE -->
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Exit Claim","submitForm(\"" + request.getContextPath() + "/control/securitynotesexit\")")%>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Proceed","submitForm(\"" + request.getContextPath() + "/control/securitynotesproceed\")")%>
				</div>
				<div class="content">
					<!-- Optional header information -->
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,securitynotes.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,securitynotes.getXcr())%></td>
				<td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("",HTMLUtils.DISPLAY,securitynotes.getTr())%></td>
			  </tr>
			  <tr>
                <td><b>OSND 1:</b></td>
                <td><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,securitynotes.getOsnd1())%></td>
				<td><b>OSND 2:</b></td>
                <td><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,securitynotes.getOsnd2())%></td>
				<td><b>OSND 3:</b></td>
                <td><%=HTMLUtils.createOsnd("",HTMLUtils.DISPLAY,securitynotes.getOsnd3())%></td>
              </tr>
              <tr>
                <td><b>Orig Bkr:</b></td>
                <td><%=securitynotes.getOrigBkr()%></td>
                <td></td>
                <td></td>
				<td></td>
				<td></td>
              </tr>
            </table>
          </div>
          <br>
					<!-- end of optional header information -->
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="noscroll">
									<table class="custom">
										<tr><td>Security Notes exist for this claim - please read carefully</td></tr>
										<tr>
											<td>
                                                                                                <textarea readonly="<%=securitynotes.getNotesFlag()%>" rows="23" name="notes" wrap="hard" cols="70" style="width:auto;font-family:courier"><%=securitynotes.getNote()%></textarea>
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
</form>
</table>
</span>