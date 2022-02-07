<%@ page import="com.xchanging.xcc.web.html.*,java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="summarySett" type="com.xchanging.xcc.web.models.SummarySettlementModel" scope="session" />

<%!
private String findTdn(String def, String tdnName, HttpServletRequest request) {
  if ((def!=null) && (!def.equals(""))) {
    return def;
  } else {
    String tdn = "";
    if (request.getParameter(tdnName + "ccyy")!=null) {
      tdn = request.getParameter(tdnName + "ccyy");
      tdn += request.getParameter(tdnName + "mm");
      tdn += request.getParameter(tdnName + "dd");
      tdn += request.getParameter(tdnName + "sssss");
    }
    return tdn;
  }
}
%>

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphaextendedvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/decimalvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/booleanentered.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/policyriskdetailscontentCustom.js"></script>

<script>
        var appletLoaded = false;
	function summDelete() {
		if (confirm("Are you sure you want to delete this claim transaction?\n\nThis action cannot be reversed."))
			submitForm("<%=request.getContextPath()%>/control/summarysdelete");
	}
        function summRelease() {
                if (confirm("Has the Claim File been seen?\n\nOK = Yes, Cancel = No")) {
                        document.all.fileseen.value="Y";
                        submitForm("<%=request.getContextPath()%>/control/summarysrelease");
                }
                else {
                        document.all.fileseen.value="N";
                        submitForm("<%=request.getContextPath()%>/control/summarysrelease");
                }
	}
        function printaPen() {
        if ((document.forms[0].uoVForm==null) || (document.forms[0].uoVForm.onsubmit_Handler())) {
          if (document.forms[0].uoVForm.onsubmit_Handler()) {
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
        }
        function showWriteRelDlg() {
          alert("The following information should be written down:\n"
          <% if (summarySett.getUcr().length() > 0 ) { %>
             + "\n UCR:\t" + document.all.ucr.innerText + "\n"
          <% } %>
          <% if (summarySett.getXcr().length() > 0 ) { %>
             + "\n XCR:\t" + document.all.xcr.innerText + "\n"
          <% } %>
          + "\n"
          <%
            Enumeration currenciesForScript = (Enumeration)summarySett.getCurrencies();
            SummSettCurrency currencyForScript;
            int colorindForScript = 0;

            while(currenciesForScript.hasMoreElements()) {
              colorindForScript++;
              currencyForScript = (SummSettCurrency)currenciesForScript.nextElement();
              Enumeration collections = currencyForScript.getCollections();
              SummSettCollection collection;
              int i=0;

              while (collections.hasMoreElements()) {
                collection = (SummSettCollection)collections.nextElement();
                i++;
                if ( collection.gettdnFlag() ) {
                  if( collection.getTdn().length() > 0 ) {
          %>
                    + "TDN:\t" + document.all.TDNCURR<%=colorindForScript%>COLL<%=i%>.innerText + "\n"
          <%      }
                } else { %>
                    + "TDN:\t"
                    + document.all.TDNCURR<%=colorindForScript%>COLL<%=i%>sssss.value
                    + " * "
                    + document.all.TDNCURR<%=colorindForScript%>COLL<%=i%>dd.value
                    + "/"
                    + document.all.TDNCURR<%=colorindForScript%>COLL<%=i%>mm.value
                    + "/"
                    + document.all.TDNCURR<%=colorindForScript%>COLL<%=i%>ccyy.value
                    + "\n"
          <%    }
              }
            }
          %>
          );
          summRelease();
        }
</script>
<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="summarysett">
<input type="submit" name="submitButton" style="display:none">
<input type="hidden" name="fileseen" id="fileseen">
<script>var uoForm = new VForm(summarysett);</script>
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
				<div class="top">
					<div class="header">
						<%=HTMLUtils.createHeader("Summary (settlement)")%>
						<!-- Below help button is no longer required since the information displayed is out of date -->
						<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR022\")")%> -->
					</div>
				</div>
				<div class="menuBar">
					<% if (!summarySett.getReleaseButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Release","printaPen()")%>
					<% } %>
					<% if (!summarySett.getDeleteButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Delete","summDelete()")%>
					<% } %>
					<% if (!summarySett.getHoldButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Hold","submitForm(\"" + request.getContextPath() + "/control/summaryshold\")")%>
					<% } %>
					<% if (!summarySett.getExitButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Exit","submitForm(\"" + request.getContextPath() + "/control/summarysexit\")")%>
					<% } %>
					<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/summaryscancel\", false)")%>
					
					<!-- CCVC Questionnaire Button release:R3B, Sachin Goyal-->
					<% if (!summarySett.getCCVCButtonFlag()) { %>
						<%=HTMLUtils.createButton(HTMLUtils.ACTION,"CCVC","submitForm(\"" + request.getContextPath() + "/control/ccvcquestionnaire\")")%>
					<% } %>
					
					
					<APPLET id="PrintaPenApplet" archive="sPrintaPen.jar" codebase="<%=request.getContextPath()%>" code="com.xchanging.xcc.web.applets.PrintaPenApplet.class" width=84 height=21 mayscript scriptable>
						<PARAM NAME="bgcolor" VALUE="#D1ECF5">
						<PARAM NAME="jsfunction" VALUE="summRelease">
                                              <% if (summarySett.getUcr().length() > 0 ) { %>
						<PARAM NAME="ucr" value="<%=summarySett.getUcr()%>">
                                              <% } %>
                                              <% if (summarySett.getXcr().length() > 0 ) { %>
						<PARAM NAME="xcr" value="<%=summarySett.getXcr()%>">
                                              <% } %>
                                              <%
                                                Enumeration currenciesForApplet = (Enumeration)summarySett.getCurrencies();
                                                SummSettCurrency currencyForApplet;
                                                int colorindForApplet = 0;

                                                while(currenciesForApplet.hasMoreElements()) {
                                                  colorindForApplet++;
                                                  currencyForApplet = (SummSettCurrency)currenciesForApplet.nextElement();
                                                  Enumeration collections = currencyForApplet.getCollections();
                                                  SummSettCollection collection;
                                                  int i=0;

                                                  while (collections.hasMoreElements()) {
                                                    collection = (SummSettCollection)collections.nextElement();
                                                    i++;
                                              %>
                                                <PARAM NAME="TDNCURR<%=colorindForApplet%>COLL<%=i%>" value="<%=collection.getTdn()%>">
                                              <%
                                                  }
                                                }
                                              %>

					</APPLET>
				</div>
				<div class="content">
					<div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR</b></td>
  		<td><%=HTMLUtils.createUcr("ucr",HTMLUtils.DISPLAY,summarySett.getUcr())%></td>
                <td><b>XCR</b></td>
  		<td><%=HTMLUtils.createUcr("xcr",HTMLUtils.DISPLAY,summarySett.getXcr())%></td>
                <td><b>TR</b></td>
  		<td><%=HTMLUtils.createUcr("tr",HTMLUtils.DISPLAY,summarySett.getTr())%></td>
              </tr>
              <tr>
                <td><b>Payee Bkr:</b></td>
                <td><%=summarySett.getOrigBkr()%></td>
                <td><b>Paid By Cheque:</b></td>
                <td><%=summarySett.getPaidByCheque()%></td>
                <td></td>
                <td></td>
              </tr>
            </table>
          </div>
					<br>
					<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
						<tr>
							<td valign="top" >
								<div class="scrollmain" style="height:372px" id="scrollpane">
									<div class="scrollmaincontent">
										<table width="100%" border="0	" cellspacing="0" cellpadding="0" class="dataTable" id="summary">
                        <tr>
                          <th align="left" width="">Orig Ccy</th>
													<th align="left" width="">Sett Ccy</th>
                          <th align="left" width="">OSND</th>
													<th align="left" <%=summarySett.hasEditableTdns()?"style='width:170'":""%>>TDN</th>
                                                                                                        <% if (summarySett.hasTreasuryRates()) { %>
                                                                                                            <th align="left" style="width:90">Treasury Rate</th>
                                                                                                        <% } %>
													<th align="left" width="">PTT Orig</th>
                          <th align="left" width="">O/S Amt Orig</th>
													<th align="left" width="">PTT Sett</th>
													<th align="left" width="">&nbsp;</th>
                        </tr>


                        <% Enumeration currencies = (Enumeration)summarySett.getCurrencies();
                           SummSettCurrency currency;
                           int colorind = 0;

                           while(currencies.hasMoreElements()) {
                           		colorind++;
                        		currency = (SummSettCurrency)currencies.nextElement();
                        		Enumeration collections = currency.getCollections();
                        		SummSettCollection collection;
                        		int i=0;

                        		while (collections.hasMoreElements()) {
                        			collection = (SummSettCollection)collections.nextElement();
	                        		i++;
                        %>

                        <tr style="<%=(colorind%2==0?"backgroundColor:#9DD7EB":"")%>">
													<td>
														<% if (i==1) { %>
															<%=currency.getOrigCurr()%>
														<% } %>
													</td>
													<td>
														<% if (i==1) { %>
															<%=currency.getSettCurr()%>
														<% } %>
													</td>
													<td>
														<% if (i==1) { %>
															<%=HTMLUtils.createOsnd("osnd1",HTMLUtils.DISPLAY,currency.getOsnd())%>
														<% } %>
													</td>
													<td><%=HTMLUtils.createTdn("TDNCURR" + colorind + "COLL" + i,collection.gettdnFlag()?HTMLUtils.DISPLAY:HTMLUtils.NORMAL,findTdn(collection.getTdn(),"TDNCURR" + colorind + "COLL" + i,request))%></td>
                                                                                                        <script>
                                                                                                          if (<%=!collection.gettdnFlag()%>) {
                                                                                                            var <%="TDNCURR" + colorind + "COLL" + i%>sssss = new VField(summarysett.<%="TDNCURR" + colorind + "COLL" + i%>sssss, VField.TYPE_NUMERIC, VField.LONG_NAME, "TDN Number", VField.CHECK_WIDTH_OPTIONAL_EXACT, 5, VField.CHECK_NO_COMMAS, true);
                                                                                                            var <%="TDNCURR" + colorind + "COLL" + i%>dd = new VField(summarysett.<%="TDNCURR" + colorind + "COLL" + i%>dd, VField.TYPE_NUMERIC, VField.LONG_NAME, "TDN Date dd", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "31", VField.CHECK_NO_COMMAS, true);
                                                                                                            var <%="TDNCURR" + colorind + "COLL" + i%>mm = new VField(summarysett.<%="TDNCURR" + colorind + "COLL" + i%>mm, VField.TYPE_NUMERIC, VField.LONG_NAME, "TDN Date mm", VField.CHECK_WIDTH_MAXIMUM, 2, VField.CHECK_VALUE_MINIMUM, "01", VField.CHECK_VALUE_MAXIMUM, "12", VField.CHECK_NO_COMMAS, true);
                                                                                                            var <%="TDNCURR" + colorind + "COLL" + i%>ccyy = new VField(summarysett.<%="TDNCURR" + colorind + "COLL" + i%>ccyy, VField.TYPE_NUMERIC, VField.LONG_NAME, "TDN Date ccyy", VField.CHECK_WIDTH_MAXIMUM, 4, VField.CHECK_VALUE_MINIMUM, "0", VField.CHECK_VALUE_MAXIMUM, "2100", VField.CHECK_NO_COMMAS, true);
                                                                                                            var vGroup<%="TDNCURR" + colorind + "COLL" + i%> = new VGroup(VGroup.TYPE_DATE, VGroup.CHECK_FORMAT, "ddmmccyy", VGroup.LONG_NAME, "TDN Date");
                                                                                                            uoForm.add(vGroup<%="TDNCURR" + colorind + "COLL" + i%>);
                                                                                                            uoForm.add(<%="TDNCURR" + colorind + "COLL" + i%>sssss);
                                                                                                            vGroup<%="TDNCURR" + colorind + "COLL" + i%>.add(<%="TDNCURR" + colorind + "COLL" + i%>dd);
                                                                                                            vGroup<%="TDNCURR" + colorind + "COLL" + i%>.add(<%="TDNCURR" + colorind + "COLL" + i%>mm);
                                                                                                            vGroup<%="TDNCURR" + colorind + "COLL" + i%>.add(<%="TDNCURR" + colorind + "COLL" + i%>ccyy);
                                                                                                          }
                                                                                                        </script>
                                                                                                        <% if (summarySett.hasTreasuryRates()) { %>
                                                                                                            <td><input type="text" name="<%="TREASURYCURR" + colorind + "COLL" + i%>" value="<%=collection.getTreasuryRate()%>" <%=collection.getTreasuryRateFlag()%>>
                                                                                                            <script>
                                                                                                              var <%="TREASURYCURR" + colorind + "COLL" + i%> = new VField(summarysett.<%="TREASURYCURR" + colorind + "COLL" + i%>, VField.TYPE_NUMERIC, VField.LONG_NAME, "Treasury Rate", VField.CHECK_NUMERIC_PLACES, 5, VField.CHECK_DECIMAL_PLACES, 7);
                                                                                                              uoForm.add(<%="TREASURYCURR" + colorind + "COLL" + i%>);
                                                                                                            </script>
                                                                                                        <% } %>
													<td>
                                                                                                          <% if (collection.getPTTOrig().indexOf("-")>=0) { %>
                                                                                                            <table cellspacing="0" cellpadding="0">
                                                                                                              <tr>
                                                                                                                <td style="padding:0px">-</td>
                                                                                                                <td style="padding:0px"><script>document.write(insertCommas("<%=collection.getPTTOrig().substring(1)%>"));</script></td>
                                                                                                              </tr>
                                                                                                            </table>
                                                                                                          <% } else { %>
                                                                                                            <script>document.write(insertCommas("<%=collection.getPTTOrig()%>"));</script>
                                                                                                          <% } %>
                                                                                                        </td>
													<td>
                                                                                                          <% if (collection.getOSAmtOrig().indexOf("-")>=0) { %>
                                                                                                            <table cellspacing="0" cellpadding="0">
                                                                                                              <tr>
                                                                                                                <td style="padding:0px">-</td>
                                                                                                                <td style="padding:0px"><script>document.write(insertCommas("<%=collection.getOSAmtOrig().substring(1)%>"));</script></td>
                                                                                                              </tr>
                                                                                                            </table>
                                                                                                          <% } else { %>
                                                                                                            <script>document.write(insertCommas("<%=collection.getOSAmtOrig()%>"));</script>
                                                                                                          <% } %>
                                                                                                        </td>
													<td>
                                                                                                          <% if (collection.getPTTSett().indexOf("-")>=0) { %>
                                                                                                            <table cellspacing="0" cellpadding="0">
                                                                                                              <tr>
                                                                                                                <td style="padding:0px">-</td>
                                                                                                                <td style="padding:0px"><script>document.write(insertCommas("<%=collection.getPTTSett().substring(1)%>"));</script></td>
                                                                                                              </tr>
                                                                                                            </table>
                                                                                                          <% } else { %>
                                                                                                            <script>document.write(insertCommas("<%=collection.getPTTSett()%>"));</script>
                                                                                                          <% } %>
                                                                                                        </td>
             <td>
														<i><a style="cursor:hand;text-decoration:underline;" onClick="submitForm('<%=request.getContextPath()%>/control/summarySelect?statSplitNo=<%=collection.getstatSplitNo()%>&currNo=<%=currency.getCurrNo()%>&sdnNo=<%=currency.getSdnNo()%>')">more</a></i>
													</td>
	                      						</tr>
												<% if (collection.hasBreakdowns()) {
													 Enumeration breakdowns = collection.getBreakdowns();
													 SummSettBreakdown breakdown; %>

														<tr>
															<td colspan="<%=summarySett.hasTreasuryRates()?"8":"7"%>">
																<table class="subtable">
																<tr>
																	<td><strong>COR</strong></td>
																	<td><strong>PTT Orig</strong></td>
																	<td><strong>O/S Amt Orig</strong></td>
																	<td><strong>Mvmt Ref</strong></td>
																</tr>

															<% while (breakdowns.hasMoreElements()) {
																breakdown = (SummSettBreakdown)breakdowns.nextElement();

																%>
																							<tr>
																								<td><%=HTMLUtils.createCor("cor",HTMLUtils.DISPLAY,breakdown.getCor())%></td>
																								<td><script>document.write(insertCommas("<%=breakdown.getPTTOrig()%>"));</script></td>
																								<td><script>document.write(insertCommas("<%=breakdown.getOSAmtOrig()%>"));</script></td>
																								<td><%=breakdown.getMvmtReg()%></td>
																							</tr>
															<% } %>
															</table>
														<% }
													 } %>
												</td>
											<td></td>
											</tr>


	                      <% } %>
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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/summarysettlement.js"></script>
</table>
</span>
<script>document.body.onload=function anon() {appletLoaded = true;}</script>
