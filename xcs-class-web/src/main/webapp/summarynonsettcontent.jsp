<%@ page import="com.xchanging.xcc.web.html.*,java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="summaryNonSett" type="com.xchanging.xcc.web.models.SummaryNonSettlementModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>
<script>
        var appletLoaded = false;
	function summDelete() {
		if (confirm("Are you sure you want to delete this claim transaction?\n\nThis action cannot be reversed."))
			submitForm("<%=request.getContextPath()%>/control/summarynsdelete");
	}
	function summRelease() {
		if (confirm("Has the Claim File been seen?\n\nOK = Yes, Cancel = No")) {
			document.all.fileseen.value="Y";
			submitForm("<%=request.getContextPath()%>/control/summarynsrelease");
		}
		else {
			document.all.fileseen.value="N";
			submitForm("<%=request.getContextPath()%>/control/summarynsrelease");
		}
	}
        function printaPen() {
        	
        	
        if ((document.forms[0].uoVForm==null) || (document.forms[0].uoVForm.onsubmit_Handler())) {
          if ( navigator.javaEnabled() ) {
            if ( document.applets.length > 0) {
              if (appletLoaded) {
                if ( document.applets.PrintaPenApplet.isApiInitialised() ) {
                  document.applets.PrintaPenApplet.showDialog(true);
                } else {
                  showWriteRelDlg();
                }
              } else {
                alert("PrintaPen applet has not yet loaded. Please try again in a few seconds.");
              }
            } else {
              showWriteRelDlg();
            }
          } else {
            showWriteRelDlg();
              }
        }
        }
        function showWriteRelDlg() {
          alert("The following information should be written down:\n"
          <% if (summaryNonSett.getUcr().length() > 0 ) { %>
                + "\n UCR:\t" + document.all.ucr.innerText
          <% } %>
          <% if (summaryNonSett.getXcr().length() > 0 ) { %>
                + "\n XCR:\t" + document.all.xcr.innerText
          <% } %>
          );
          summRelease();
        }
</script>
<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form>
<input type="submit" name="submitButton" style="display:none">
  <input type="hidden" name="fileseen">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("Summary (non-settlement)")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR021\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<% if (!summaryNonSett.getReleaseButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Release","printaPen()")%>
					<% } %>
					<% if (!summaryNonSett.getDeleteButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Delete","summDelete()")%>
					<% } %>
					<% if (!summaryNonSett.getHoldButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Hold","submitForm(\"" + request.getContextPath() + "/control/summarynshold\")")%>
					<% } %>
					<% if (!summaryNonSett.getExitButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Exit","submitForm(\"" + request.getContextPath() + "/control/summarynsexit\")")%>
					<% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/summarynscancel\", false)")%>
					<APPLET id="PrintaPenApplet" archive="sPrintaPen.jar" codebase="<%=request.getContextPath()%>" code="com.xchanging.xcc.web.applets.PrintaPenApplet.class" width=84 height=21 mayscript scriptable>
						<PARAM NAME="bgcolor" VALUE="#D1ECF5">
						<PARAM NAME="jsfunction" VALUE="summRelease">
                                              <% if (summaryNonSett.getUcr().length() > 0 ) { %>
						<PARAM NAME="ucr" value="<%=summaryNonSett.getUcr()%>">
                                              <% } %>
                                              <% if (summaryNonSett.getXcr().length() > 0 ) { %>
						<PARAM NAME="xcr" value="<%=summaryNonSett.getXcr()%>">
                                              <% } %>
					</APPLET>
				</div>
				<div class="content">  
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("ucr",HTMLUtils.DISPLAY,summaryNonSett.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("xcr",HTMLUtils.DISPLAY,summaryNonSett.getXcr())%></td>
                <td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("tr",HTMLUtils.DISPLAY,summaryNonSett.getTr())%></td>
              </tr>
              <tr>
                <td><b>Current Bkr:</b></td>
                <td><%=summaryNonSett.getOrigBkr()%></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
              </tr>
            </table>
          </div>
					<br>
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="scrollmain" style="height:368px" id="scrollpane">
									<div class="scrollmaincontent">
										<table class="4column">
											<tr>
												<td><strong>TR</strong></td>
												<td><%=HTMLUtils.createUcr("tr",HTMLUtils.DISPLAY,summaryNonSett.getTr())%></td>
												<td></td>
												<td></td>
											</tr>
										</table>
										<br>
										<table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="summary">
                        <tr>
                          <th align="left" width="">Orig Ccy</th>
                          <th align="left" width="">OSND</th>
													<th align="left" width="">COR</th>
													<th align="left" width="">Mvmt Ref</th>
                          <th align="left" width="">O/S Total</th>
                        </tr>

                        <% Enumeration currencies = summaryNonSett.getCurrencies();
                        	SummNonSettCurrency currency;
                        	int colorind = 0;

                        	while(currencies.hasMoreElements()) {
                                  colorind++;
				  currency = (SummNonSettCurrency)currencies.nextElement();
                                  Enumeration collections = currency.getCollections();
                                  SummNonSettCollection collection;
                                  int i=0;

                                  while (collections.hasMoreElements()) {
                                    collection = (SummNonSettCollection)collections.nextElement();
                                    i++;
                        %>

                        <tr style="<%=(colorind%2==0?"backgroundColor:#9DD7EB":"")%>">
													<td>
														<% if (i==1) { %>
															<%=currency.getOrigCcy()%>
														<% } %>
													</td>
													<td>
														<% if (i==1) { %>
															<%=HTMLUtils.createOsnd("osnd",HTMLUtils.DISPLAY,currency.getOsnd())%>
														<% } %>
													</td>
													<td><%=HTMLUtils.createCor("cor",HTMLUtils.DISPLAY,collection.getCor())%></td>
													<td><%=collection.getMvmtRef()%></td>
													<td>
                                                                                                          <% if (collection.getOSTotal().indexOf("-")>=0) { %>
                                                                                                            <table cellspacing="0" cellpadding="0">
                                                                                                              <tr>
                                                                                                                <td style="padding:0px">-</td>
                                                                                                                <td style="padding:0px"><script>document.write(insertCommas("<%=collection.getOSTotal().substring(1)%>"));</script></td>
                                                                                                              </tr>
                                                                                                            </table>
                                                                                                          <% } else { %>
                                                                                                            <script>document.write(insertCommas("<%=collection.getOSTotal()%>"));</script>
                                                                                                          <% } %>
                                                                                                        </td>
						                      </tr>
						       <% }
						     } %>
										</table>
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
</form>
</table>
</span>
<script>document.body.onload=function anon() {appletLoaded = true;}</script>