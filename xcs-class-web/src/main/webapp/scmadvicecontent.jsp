<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="scmadvice" type="com.xchanging.xcc.web.models.SCMAdviceModel" scope="session" />
<jsp:useBean id="markets" type="com.xchanging.xcc.web.models.MarketsModel" scope="session" />
<jsp:useBean id="claimDetails" type="com.xchanging.xcc.web.models.ClaimDetailsModel" scope="session" />
<jsp:useBean id="expertfeebreakdown" type="com.xchanging.xcc.web.models.ExpertFeeBreakDownModel" scope="session" />

<jsp:useBean id="clmRefRecList" type="com.xchanging.xcc.web.models.reference.ClmRefRecList" scope="application" />
<jsp:useBean id="dcmQualList" type="com.xchanging.xcc.web.models.reference.DCMQualList" scope="application" />
<jsp:useBean id="dolQualList" type="com.xchanging.xcc.web.models.reference.DOLQualList" scope="application" />
<jsp:useBean id="naicQualList" type="com.xchanging.xcc.web.models.reference.NaicQualList" scope="application" />
<jsp:useBean id="osFeeQualList" type="com.xchanging.xcc.web.models.reference.OsFeeQualList" scope="application" />
<jsp:useBean id="osLossQualList" type="com.xchanging.xcc.web.models.reference.OsLossQualList" scope="application" />
<jsp:useBean id="osTotalQualList" type="com.xchanging.xcc.web.models.reference.OsTotalQualList" scope="application" />
<jsp:useBean id="polCertQualList" type="com.xchanging.xcc.web.models.reference.PolCertQualList" scope="application" />
<jsp:useBean id="schemeCodeList" type="com.xchanging.xcc.web.models.reference.SchemeCodeList" scope="application" />
<jsp:useBean id="narrativeList" type="com.xchanging.xcc.web.models.reference.NarrativeList" scope="application" />
<jsp:useBean id="stateCodeList" type="com.xchanging.xcc.web.models.reference.StateCodeList" scope="application" />
<jsp:useBean id="adjSurvCodeList" type="com.xchanging.xcc.web.models.reference.AdjSurvCodeList" scope="application" />
<jsp:useBean id="lawyerCodeList" type="com.xchanging.xcc.web.models.reference.LawyerCodeList" scope="application" />
<jsp:useBean id="countryCodeList" type="com.xchanging.xcc.web.models.reference.CountryCodeList" scope="application" />
<jsp:useBean id="catCodeList" type="com.xchanging.xcc.web.models.reference.CatCodeList" scope="application" />
<jsp:useBean id="pcsCodeList" type="com.xchanging.xcc.web.models.reference.PCSCodeList" scope="application" />
<jsp:useBean id="filCodeList" type="com.xchanging.xcc.web.models.reference.FILCodeList" scope="application" />
<jsp:useBean id="trustFundList" type="com.xchanging.xcc.web.models.reference.TrustFundList" scope="application" />
<jsp:useBean id="dtiCodeList" type="com.xchanging.xcc.web.models.reference.DTICodeList" scope="application" />
<jsp:useBean id="naicCodeList" type="com.xchanging.xcc.web.models.reference.NaicCodeList" scope="application" />
<jsp:useBean id="currencyCodeList" type="com.xchanging.xcc.web.models.reference.CurrencyCodeList" scope="application" />
<jsp:useBean id="serviceTypeList" type="com.xchanging.xcc.web.models.reference.ServiceTypeList" scope="application" />
<%-- clintonj - SIR 101172 - 16/09/2004 --%>
<jsp:useBean id="peerReviewList" type="com.xchanging.xcc.web.models.reference.PeerReviewList" scope="application" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script src='<%=request.getContextPath()%>/js/tabs.js'></script>

<script language='JavaScript' src='<%=request.getContextPath()%>/js/debug.js'></script>
<script language='JavaScript' src='<%=request.getContextPath()%>/js/error.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/messagelist.js'></script>
<script language='JavaScript' src='<%=request.getContextPath()%>/js/vfield.js'></script>
<script language='JavaScript' src='<%=request.getContextPath()%>/js/vform.js'></script>
<script language='JavaScript' src='<%=request.getContextPath()%>/js/vtab.js'></script>
<script language='JavaScript' src='<%=request.getContextPath()%>/js/VGroup.js'></script>
<script language='JavaScript' src='<%=request.getContextPath()%>/js/positionlayer.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/alphavalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/alphaextendedvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/numericvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/decimalvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/datevalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/comparator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/screen/scmadvicecontentcustom.js'></script>

<script>
  function vatRates() {
		if ((document.all.vatAmount.value=="") || (Number(document.all.vatAmount.value)==0))
			alert("VAT Rates cannot be entered without VAT Amount");
		else {
			submitForm("<%=request.getContextPath()%>/control/vatrates");
		}
	}
	function expertFees() 
	{
<%
		if(expertfeebreakdown.getExpertScreenMode()!=null && expertfeebreakdown.getExpertScreenMode().equalsIgnoreCase("E"))
		{
%>
			submitForm("<%=request.getContextPath()%>/control/expertfeebreakdownupdateenquiry");
<%		    
		}
		else
		{
%>
			submitForm("<%=request.getContextPath()%>/control/expertfeebreakdownupdateupdate");
<%
		}
%>	
		
	}

	function vatRateChange() {
		if ((document.all.vatAmount.value=="") || (Number(document.all.vatAmount.value)==0)) {
			submitForm("<%=request.getContextPath()%>/control/scmadvicevatdelete");
		}
	}

// Patrick Cogan made these methods conditionally included only when needed - fix for contra javascript problem for SIR 37546.  
<% if (!(scmadvice.getAdjusterNameFlag() && scmadvice.getLawyerNameFlag())) { %>
	function validateCode(src, target) {
		var code = src.value;    
		for (i=0; i<target.options.length; i++) {
			if (code == target.options[i].code) {				
        target.selectedIndex=i;
				return;
			}
		}
		target.selectedIndex=0;
	}
<%}%>

	function more() {
		var qual = document.all.naicQual.options[document.all.naicQual.selectedIndex].value;
		var code = document.all.naicCode.value;
		var target = "<%=request.getContextPath()%>/naiccodepopup.jsp?qual=" + qual + "&enquiry=<%=!scmadvice.getNaicCodeFlag().trim().equals("")%>";

		if (code!="")
			target += "#" + code;

		if (qual!="")
			window.open(target, 'naicCodes',  'scrollbars, status=no, toolbar=no, resizable=no, width=450, height=530');
		else
			alert("Please select a NAIC qualifier before clicking 'more'");
	}
	
	// Patrick Cogan: Added to fix SIR 37546
	// Enables of updating of codes then reseting multikey select function
	
  // Patrick Cogan made these methods conditionally included only when needed - fix for contra javascript problem for SIR 37546.  
<% if (!scmadvice.getAdjusterNameFlag()) { %>
	function setAdjusterCode(){
	  document.all.adjusterCode.value=document.all.adjusterName.options[document.all.adjusterName.selectedIndex].code;
	  mksResetSelect();
	}
<%}%>

  // Patrick Cogan made these methods conditionally included only when needed - fix for contra javascript problem for SIR 37546.  
<% if (!scmadvice.getLawyerNameFlag()) { %>
	function setLawyerCode(){
    document.all.lawyerCode.value=document.all.lawyerName.options[document.all.lawyerName.selectedIndex].code;
	  mksResetSelect();
	} 
<%}%>
  
  // clintonj: SIR 37546.
  // Patrick Cogan made these methods conditionally included only when needed - fix for contra javascript problem for SIR 37546.  
  // Function called to ensure that the Adjuster code matches the Adjuster drop down list value
<% if (!scmadvice.getAdjusterNameFlag()) { %>
  function adjusterNameFix() {
    validateCode(document.all.adjusterCode,document.all.adjusterName);      
	}
<%}%>
	
  // clintonj: SIR 37546.
  // Patrick Cogan made these methods conditionally included only when needed - fix for contra javascript problem for SIR 37546.  
  // Function called to ensure that the Lawyer code matches the Lawyer drop down list value
<% if (!scmadvice.getLawyerNameFlag()) { %>
	function lawyerNameFix() {    
    validateCode(document.all.lawyerCode,document.all.lawyerName);    
	}
<%}%>
  
  	/*Getting the original Currency*/
    var origCcy = '<%=scmadvice.getOrigCcy() %>';
  
</script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
	<form name="scmadvicecontent">
		<input type="submit" name="submitButton" style="display:none">
		<input type="hidden" name="claimNarrative" value="<%=scmadvice.getClaimNarrative()%>">
		<table class="formCenter">
			<tr>
				<td></td>
				<td class="content">
					<div class="outerWindow">
						<div class="top">
							<div class="header">
								<%=HTMLUtils.createHeader("Breakdown - SCM Advice")%>
								<!-- Below help button is no longer required since the information displayed is out of date -->
								<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR017\")")%> -->
							</div> <!--Header-->
						</div> <!--Top-->

						<div class="menuBar">
							<!-- MENU BUTTONS GO HERE -->
							<% if (!scmadvice.getSaveButtonFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/scmadvicesave\")")%>
							<% } %>

							<% if (!scmadvice.getNewMovementFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Create New Movement","submitForm(\"" + request.getContextPath() + "/control/scmadvicenewmvmt\")")%>
							<% } %>

							<% if (!scmadvice.getEndBDFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"End Breakdown","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/scmadviceendbd\")")%>
							<% } %>

							<% if (!scmadvice.getNewBDFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"New Breakdown","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/scmadvicenewbd\")")%>
							<% } %>

							<% if (!scmadvice.getRiSchdFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Create R/I Schedule","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/scmadvicecreaterischedule\")")%>
							<% } %>

							<% if (!scmadvice.getBindSchdFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Create Bndr Schedule","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/scmadvicecreatebinderschedule\")")%>
							<% } %>

							<% if (!scmadvice.getBackFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Back to Schedule","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/scmadvicebacktoschedule\")")%>
							<% } %>

							<% if (!scmadvice.getEuroFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Euro Conv Details","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/scmadviceeuroconvdetails\")")%>
							<% } %>

							<% if (!scmadvice.getCcsFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.ACTION,"CCS Amounts","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/scmadviceccsamounts\")")%>
							<% } %>

							<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/scmadvicecancel\", false)")%>
						</div> <!--Menu Bar-->

						<div class="content">
							<!-- SCM Section 1 starts here -->
							<div>
								<a name="policy">
								<!-- Optional header information -->
								<table class="headerInfo" width="100%">
									<tr>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
									</tr>
									<tr>
										<td><b>XCR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,scmadvice.getHXcr())%></td>
										<td><b>Bkr UCR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,scmadvice.getHUcr())%></td>
									</tr>
									</tr>
										<td><b>COR:</b></td>
										<td colspan="3"><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY,scmadvice.getHCor())%></td>
									  <td><b>TR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("tr", HTMLUtils.DISPLAY,scmadvice.getHTr())%></td>
									</tr>
									<tr>
										<td><b>OSND:</b></td>
										<td colspan="2"><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY,scmadvice.getHOsnd())%></td>
										<td><b>Mov't Ref/ Date:</b></td>
										<td colspan="2"><%=scmadvice.getHMvmtRefDate()%></td>
										<td><b>Peer Review:</b></td>
                          				<td><%=scmadvice.getHPeerReview()%></td>
									</tr>
								</table> <!-- headerInfo --> 

								<table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
									<tr>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Policy Details","document.location=\"#policy\"")%>
										</td>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Claim Details","document.location=\"#claim\"")%>
										</td>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Financials","document.location=\"#financials\"")%>
										</td>
									</tr>
								</table> <!-- end of optional header information -->
								<br>
							</div>

              <table  border='0' cellpadding='0' cellspacing='0' class='formHeading' >
								<tr>
									<td class='left'>&nbsp;</td>
									<td class='middle' nowrap>Policy Details</td>
									<td class='right'>&nbsp;</td>
								</tr>
							</table>

							<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
								<tr>
									<td valign="top" >
										<div class="noscroll">
											<table class="custom" border="0">
												<tr>
													<td style="width:25%"></td>
													<td style="width:75%"></td>
												</tr>

												<tr>
													<td>Coverholder</td>
													<td><input type="text" name="ch" value="<%=scmadvice.getClaimholder()%>" <%=scmadvice.getClaimholderFlag()%>></td>
												</tr>

												<tr>
													<td>Insured</td>
													<td><input type="text" name="insured" value="<%=scmadvice.getInsured()%>" <%=scmadvice.getInsuredFlag()%>></td>
												</tr>

												<tr>
													<td>Reinsured</td>
													<td><input type="text" name="reinsured" value="<%=scmadvice.getResinsured()%>" <%=scmadvice.getReinsuredFlag()%>></td>
												</tr>

												<tr>
													<td>Orig Insured</td>
													<td><input type="text" name="origInsured" value="<%=scmadvice.getOrigInsured()%>" <%=scmadvice.getOrigInsuredFlag()%>></td>
												</tr>

												<tr>
													<td>Other Name</td>
													<td><input type="text" name="otherName" value="<%=scmadvice.getOtherName()%>" <%=scmadvice.getOtherNameFlag()%>></td>
												</tr>

												<tr>
													<td>Loss Name</td>
													<td><input type="text" name="lossName" value="<%=scmadvice.getLossName()%>" <%=scmadvice.getLossNameFlag()%>></td>
												</tr>

												<tr>
													<td>Vessel/ Aircraft/ Conveyance</td>
													<td><input type="text" name="vesselAircraftConveyance" value="<%=scmadvice.getVesselAircraft()%>" <%=scmadvice.getVesselAircraftFlag()%>></td>
												</tr>
											</table> <!-- custom -->

											<table class="custom" border="0">
												<tr>
													<td style="width:13%"></td>
													<td style="width:26%"></td>
													<td style="width:13%"></td>
													<td style="width:26%"></td>
													<td style="width:13%"></td>
													<td style="width:9%"></td>
												</tr>

												<tr>
													<td>Pol/Cert Period From</td>
													<td><%=HTMLUtils.createDate("polCertPeriodFrom",(scmadvice.getPolCertPeriodFromFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,scmadvice.getPolCertPeriodFrom())%></td>
													<td>Pol/Cert Period To</td>
													<td><%=HTMLUtils.createDate("polCertPeriodTo",(scmadvice.getPolCertPeriodToFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,scmadvice.getPolCertPeriodTo())%></td>
													<td>Pol/Cert Qualifier</td>
													<td>
														<%=HTMLUtils.createDropdown("polCertQualifier",scmadvice.getPolCertQual(),scmadvice.getPolCertQualFlag(),polCertQualList)%>
													</td>
												</tr>

												<tr>
													<td>DOL From</td>
													<td><%=HTMLUtils.createDate("dolFrom",(scmadvice.getDOLFromFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,scmadvice.getDOLFrom())%></td>
													<td>DOL To</td>
													<td><%=HTMLUtils.createDate("dolTo",(scmadvice.getDOLToFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,scmadvice.getDOLTo())%></td>
													<td>DOL Qual</td>
													<td>
														<%=HTMLUtils.createDropdown("dolQual",scmadvice.getDOLQual(),scmadvice.getDOLQualFlag(),dolQualList)%>
													</td>
												</tr>

												<tr>
													<td>Loss Date Narrative</td>
													<td colspan="3">
														<input type="text" name="dolNarr" value="<%=scmadvice.getDOLNarrative()%>" <%=scmadvice.getDOLNarrativeFlag()%>>
													</td>
													<td>War Ind</td>
													<td>
														<input type="checkbox" name="warInd" <%=scmadvice.getCheckedWarInd()%> <%=scmadvice.getWarIndFlag()%>>
													</td>
												</tr>

												<tr>
													<td>DCM/DOD From</td>
													<td><%=HTMLUtils.createDate("dcmDodFrom",(scmadvice.getDCMFromFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,scmadvice.getDCMFrom())%></td>
													<td>DCM/DOD To</td>
													<td><%=HTMLUtils.createDate("dcmDodTo",(scmadvice.getDCMToFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,scmadvice.getDCMTo())%></td>
													<td>DCM/DOD Qualifier</td>
													<td>
														<%=HTMLUtils.createDropdown("dcmDodQual",scmadvice.getDCMQual(),scmadvice.getDCMQualFlag(),dcmQualList)%>
													</td>
												</tr>
											</table> <!-- custom 6 -->

											<table class="custom" border="0">
												<tr>
													<td style="width:15%"></td>
													<td style="width:12%"></td>
													<td style="width:12%"></td>
													<td style="width:12%"></td>
													<td style="width:12%"></td>
													<td style="width:11%"></td>
													<td style="width:25%"></td>
												</tr>

												<tr>
													<td>Ccy of Limits</td>
													<td>
														<%=HTMLUtils.createDropdown("ccyOfLimits",scmadvice.getCcyOfLimits(),scmadvice.getCcyOfLimitsFlag(),currencyCodeList)%>
													</td>
													<td>Limits</td>
													<td colspan="2"><input type="text" name="limits" value="<%=scmadvice.getLimits()%>" <%=scmadvice.getLimitsFlag()%>></td>
													<td>Excess</td>
													<td><input type="text" name="excess" value="<%=scmadvice.getExcess()%>" <%=scmadvice.getExcessFlag()%>></td>
												</tr>

												<tr>
													<td>Perils/ Condition</td>
													<td colspan="4"><input type"text" name="perilsCondition" value="<%=scmadvice.getPerilsCondition()%>" <%=scmadvice.getPerilsConditionFlag()%>></td>
													<td>Signed</td>
													<td><%=scmadvice.getHSigned()%></td>
												</tr>
											</table> <!-- custom 7 -->

											<table class="custom" border="0">
												<tr>
													<td style="width:8%"></td>
													<td style="width:12%"></td>
													<td style="width:8%"></td>
													<td style="width:12%"></td>
													<td style="width:12%"></td>
													<td style="width:8%"></td>
													<td style="width:8%"></td>
													<td style="width:12%"></td>
													<td style="width:8%"></td>
													<td style="width:12%"></td>
												</tr>
												<tr>
													<td>FIL Code1</td>
													<td>
														<% Enumeration filCodes;
														if (scmadvice.getFilCode1Flag()) { %>
															<input type="text" value="<%=scmadvice.getFilCode1()%>" class="fieldProtect" readonly="true">
															<input type="hidden" name="filCode1" value="<%=scmadvice.getFilCode1()%>">
														<% } else { %>
															<select name="filCode1">
																<% filCodes = filCodeList.getFILCodes();
																while (filCodes.hasMoreElements()) {
																	FILCodeList.FILCode filCode = (FILCodeList.FILCode)filCodes.nextElement(); %>
																	<option value="<%=filCode.getCode()%>" <%=filCode.getCode().equals(scmadvice.getFilCode1())?"SELECTED":""%>><%=filCode.getCode()%></option>
																<% } %>
															</select>
														<% } %>
													</td>
													<td>FIL Code2</td>
													<td>
														<% if (scmadvice.getFilCode2Flag()) { %>
															<input type="text" value="<%=scmadvice.getFilCode2()%>" class="fieldProtect" readonly="true">
															<input type="hidden" name="filCode2" value="<%=scmadvice.getFilCode2()%>">
														<% } else { %>
															<select name="filCode2" <%=scmadvice.getFilCode2Flag()%>>
																<% filCodes = filCodeList.getFILCodes();
																while (filCodes.hasMoreElements()) {
																	FILCodeList.FILCode filCode = (FILCodeList.FILCode)filCodes.nextElement();%>
																	<option value="<%=filCode.getCode()%>" <%=filCode.getCode().equals(scmadvice.getFilCode2())?"SELECTED":""%>><%=filCode.getCode()%></option>
																<% } %>
															</select>
														<% } %>
													</td>
													<td>USA/CAN Ind</td>
													<td>
														<input type="checkbox" name="usaCanInd" <%=scmadvice.getCheckedUsaCanInd()%> <%=scmadvice.getUsaCanIndFlag()%>>
													</td>
													<td>TF Code</td>
													<td>
														<% Enumeration tfCodes;
														if (scmadvice.getTfCodeFlag()) { %>
															<input type="text" value="<%=scmadvice.getTfCode()%>" class="fieldProtect" readonly="true">
															<input type="hidden" name="tfCode" value="<%=scmadvice.getTfCode()%>">
														<% } else { %>
															<select name="tfCode">
																<% tfCodes = trustFundList.getTrustFunds();
																while (tfCodes.hasMoreElements()) {
																	TrustFundList.TrustFund tfCode = (TrustFundList.TrustFund)tfCodes.nextElement();%>
																	<option value="<%=tfCode.getCode()%>" <%=tfCode.getCode().equals(scmadvice.getTfCode())?"SELECTED":""%>><%=tfCode.getCode()%></option>
																<% } %>
															</select>
														<% } %>
													</td>
													<td>State Code</td>
													<td>
														<%=HTMLUtils.createDropdown("stateCode",scmadvice.getStateCode(),scmadvice.getStateCodeFlag(),stateCodeList)%>
													</td>
												</tr>
												<tr>
													<td colspan="7"></td>
													<td colspan="2">County Code</td>
													<td>
														<input type="text" name="countyCode" id="countyCode" value="<%=scmadvice.getCountyCode() %>" <%=scmadvice.getCountyCodeFlag() %>>
													</td>
												</tr>
											</table> <!-- custom 10 -->

											<table class="custom" border="0">
												<tr>
													<td style="width:14%"></td>
													<td style="width:32%"></td>
													<td style="width:14%"></td>
													<td style="width:14%"></td>
													<td style="width:26%"></td>
												</tr>

												<tr>
													<td>NAIC Code</td>
													<td>
														<input type="text" name="naicCode" value="<%=scmadvice.getNaicCode()%>" <%=scmadvice.getNaicCodeFlag()%>>
													</td>
													<td>
														<a href="#" onclick="more()">more</a>
													</td>
													<td>NAIC Qual</td>
													<td>
														<%=HTMLUtils.createDropdown("naicQual",scmadvice.getNaicQual(),scmadvice.getNaicQualFlag(),naicQualList)%>
													</td>
												</tr>
											</table> <!-- custom 5 -->

											<table class="custom" border="0">
												<tr>
													<td style="width:14%"></td>
													<td style="width:14%"></td>
													<td style="width:6%"></td>
													<td style="width:14%"></td>
													<td style="width:14%"></td>
													<td style="width:38%"></td>
												</tr>

												<tr>
													<td>Other TF Code</td>
													<td>
														<% if (scmadvice.getOtherTfCodeFlag()) { %>
															<input type="text" value="<%=scmadvice.getOtherTfCode()%>" class="fieldProtect" readonly="true">
															<input type="hidden" name="otherTfCode" value="<%=scmadvice.getOtherTfCode()%>">
														<% } else { %>
															<select name="otherTfCode" <%=scmadvice.getOtherTfCodeFlag()%>>
																<% tfCodes = trustFundList.getTrustFunds();
																while (tfCodes.hasMoreElements()) {
																	TrustFundList.TrustFund tfCode = (TrustFundList.TrustFund)tfCodes.nextElement(); %>
																	<option value="<%=tfCode.getCode()%>" <%=tfCode.getCode().equals(scmadvice.getOtherTfCode())?"SELECTED":""%>><%=tfCode.getCode()%></option>
																<% } %>
															</select>
														<% } %>
													</td>
													<td>DTI<span class="compMarker">*</span></td>
													<td>
														<%=HTMLUtils.createDropdown("dti",scmadvice.getDti(),scmadvice.getDtiFlag(),dtiCodeList)%>
													</td>
													<td>Country of Origin<span class="compMarker">*</span></td>
													<td>
														<%=HTMLUtils.createDropdown("countryOfOrigin",scmadvice.getCountryOfOrigin(),scmadvice.getCountryOfOriginFlag(),countryCodeList)%>
													</td>
												</tr>
											</table> <!-- custom 6 -->
										</div> <!-- noscroll -->
									</td>
								</tr>
							</table> <!-- mainContent -->
							<!-- SCM Section 1 ends here -->

							<!-- SCM Section 2 starts here -->
							<div>
								<a name="claim">
								<!-- Optional header information -->
								<table class="headerInfo" width="100%">
									<tr>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
									</tr>
									<tr>
										<td><b>XCR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,scmadvice.getHXcr())%></td>
										<td><b>Bkr UCR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,scmadvice.getHUcr())%></td>
									</tr>
									</tr>
										<td><b>COR:</b></td>
										<td colspan="3"><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY,scmadvice.getHCor())%></td>
									  <td><b>TR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("tr", HTMLUtils.DISPLAY,scmadvice.getHTr())%></td>
									</tr>
									<tr>
										<td><b>OSND:</b></td>
										<td colspan="2"><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY,scmadvice.getHOsnd())%></td>
										<td><b>Mov't Ref/ Date:</b></td>
										<td colspan="2"><%=scmadvice.getHMvmtRefDate()%></td>
										<td><b>Peer Review:</b></td>                
                          				<td><%=scmadvice.getHPeerReview()%></td>
									</tr>
								</table> <!-- headerInfo -->

								<table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
									<tr>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Policy Details","document.location=\"#policy\"")%>
										</td>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Claim Details","document.location=\"#claim\"")%>
										</td>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Financials","document.location=\"#financials\"")%>
										</td>
									</tr>
								</table>
								<br>
							</div>

							<table  border='0' cellpadding='0' cellspacing='0' class='formHeading' >
								<tr>
									<td class='left'>&nbsp;</td>
									<td class='middle' nowrap>Claim Details</td>
									<td class='right'>&nbsp;</td>
								</tr>
							</table>

							<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
								<tr>
									<td valign="top" >
										<div class="noscroll">
											<table class="custom" border="0">
												<tr>
													<td style="width:18%"></td>
													<td style="width:32%"></td>
													<td style="width:18%"></td>
													<td style="width:32%"></td>
												</tr>
												<tr>
													<td>Current Bkr</td>
													<td><%=scmadvice.getHOrigBkr()%></td>
												</tr>
												<tr>
													<td>Bkr Contact<span class="compMarker">*</span></td>
													<td><input type="text" name="brokerContact" value="<%=scmadvice.getBrokerContact()%>" <%=scmadvice.getBrokerContactFlag()%>></td>
													<td>Bkr Phone No</td>
													<td><input type="text" name="brokerPhoneNo" value="<%=scmadvice.getBrokerPhoneNo()%>" <%=scmadvice.getBrokerPhoneNoFlag()%>></td>
												</tr>
											</table>
                                                                <!--TP866603 Changes for newly added barcode field --> 
											<table class="custom">
												<tr>
													<td style="width:22%"></td>
													<td style="width:10%"></td>
													<td style="width:21%"></td>
													<td style="width:10%"></td>
													<td style="width:20%"></td>
													<td style="width:15%"></td>
												</tr>

												<tr>
													<td>Block</td>
													<td><input type="checkbox" name="blockInd" <%=scmadvice.getCheckedBlockInd()%> <%=scmadvice.getBlockFlag()%>></td>
													<td>Loss Fund Entry</td>
													<td><input type="checkbox" name="lfEntryInd" <%=scmadvice.getCheckedLFEntryInd()%> <%=scmadvice.getLFEntryFlag()%>></td>
													<td>Loss Fund Advanced</td>
													<td><input type="checkbox" name="lfAdvancedInd" <%=scmadvice.getCheckedLFAdvanceInd()%> <%=scmadvice.getLFAdvanceFlag()%>></td>
												</tr>
												
							<!-- ****************  ECF Phase 6 changes ******************************** -->
												<tr>
												<td>Direct Report</td>
												<td><input type="checkbox" name="directReportInd" <%=scmadvice.getCheckedDirectReportInd()%> <%=scmadvice.getDirectReportFlag()%>></td>
												<td>Claim in Litigation</td>
												<td><input type="checkbox" name="clmInLitigationInd" <%=scmadvice.getCheckedClmInLitigationInd()%> <%=scmadvice.getClmInLitigationFlag()%>></td>
							<!--TP866603 Changes for newly added barcode field --> 
												<td>Barcode</td>
												<td><input type="text" name="barcode" value="<%=scmadvice.getBarcode()%>" <%=scmadvice.getBarcodeFlag()%>></td>
											    </tr>



							<!-- ****************** ECF Phase 6 changes **********************************	 -->
												
											</table> <!-- custom 6 -->
												<table class="custom">
												<tr>												
												<td style="width:25%"></td>
												<td style="width:30%"></td>
												<td style="width:45%"></td>
											</tr>

												<tr>
												<td>Service Type</td>
												<td><%=HTMLUtils.createDropdown("serviceType",scmadvice.getServiceType(),scmadvice.getServiceTypeFlag(),serviceTypeList)%></td>
												<td></td>
												
												
											   </tr>

											</table>
											

											<table class="custom">
												<tr>
													<td style="width:25%"></td>
													<td style="width:75%"></td>
												</tr>
												<tr>
													<td>Claimant</td>
													<td><input type="text" name="claimant" value="<%=scmadvice.getClaimant()%>" <%=scmadvice.getClaimantFlag()%>></td>
												</tr>

												<tr>
													<td>Voyage</td>
													<td><input type="text" name="voyage" value="<%=scmadvice.getVoyage()%>" <%=scmadvice.getVoyageFlag()%>></td>
												</tr>

												<tr>
													<td>Loss Location</td>
													<td><input type="text" name="lossLocation" value="<%=scmadvice.getLossLocation()%>" <%=scmadvice.getLossLocationFlag()%>></td>
												</tr>

												<tr>
													<td>SCM Claim Narrative<span class="compMarker">*</span></td>
													<td><textarea name="claimNarr" wrap="hard" rows="3" style="width:auto;font-family:courier" cols="50" rows="3" <%=scmadvice.getClaimNarrativeFlag()%> onChange="claimNarrativeFix()"><%=scmadvice.getClaimNarrative()%></textarea></td>
												</tr>
											</table> <!-- custom 2 -->

											<table class="custom" border="0">
												<tr>
													<td style="width:20%"></td>
													<td style="width:30%"></td>
													<td style="width:20%"></td>
													<td style="width:30%"></td>
												</tr>

												<tr>
													<td>CAT Code</td>
													<td>
														<%=HTMLUtils.createDropdown("catCode",scmadvice.getCatCode(),scmadvice.getCatCodeFlag(),catCodeList)%>
													</td>
													<td>PCS Cat</td>
													<td>
														<%=HTMLUtils.createDropdown("pcsCode",scmadvice.getPcsCode(),scmadvice.getPcsCodeFlag(),pcsCodeList)%>
													</td>
												</tr>
                        
                       
                        <script>
                          // clintonj SIR 37546
                          // Changed onChange event to onBlur
                          //Sachin Goyal: Made Adjuster and Lawyer details invisible to the user, for expert fee breakdown change.
                        </script>
												<tr style="display:none">
													<td>Adjuster Code</td>
													<td><!-- Patrick Cogan SIR: 37546 made onblur conditional to when its needed -->
														<input type="text" name="adjusterCode" value="<%=scmadvice.getAdjusterCode()%>" <%=scmadvice.getAdjusterCodeFlag()%> <% if (!scmadvice.getAdjusterNameFlag()) { %>onblur="validateCode(this,document.all.adjusterName)"<%}%>>
													</td>
													<td>Adjuster Ref</td>
													<td>
														<input type="text" name="adjusterRef" value="<%=scmadvice.getAdjusterRef()%>" <%=scmadvice.getAdjusterRefFlag()%>>                            
													</td>
												</tr>  

												<tr style="display:none">
													<td>Adjuster Name</td>
													<td colspan="3">
														<% if (scmadvice.getAdjusterNameFlag()) { %>
															<input type="text" value="<%=scmadvice.getAdjusterName()%>" class="fieldProtect" readonly="true">
															<input type="hidden" name="adjusterName" value="<%=scmadvice.getAdjusterName()%>">
                              <!-- Patrick Cogan SIR: 37546 removed this javascript as not needed in this mode -->                             
														<% } else { %>   
                            <!-- Patrick Cogan SIR: 37546
                                 Created a custon onChange event and dissabled the one in main.js.mksInitialise() 
                                 to get the codes to update when you key out, used on key up event.                          
                                 
                            -->                           
                              <select name="adjusterName" <%=scmadvice.getAdjusterNameFlag()%> onKeyUp="document.all.adjusterCode.value=document.all.adjusterName.options[document.all.adjusterName.selectedIndex].code" onChange="setAdjusterCode()">  
																<% Enumeration adjSurvNames = adjSurvCodeList.getAdjSurvCodes();                                                                          
																while (adjSurvNames.hasMoreElements()) {                                  
																	AdjSurvCodeList.AdjSurvCode adjSurvCode = (AdjSurvCodeList.AdjSurvCode)adjSurvNames.nextElement(); %>                                        
																	<option value="<%=adjSurvCode.getName()%>" code="<%=adjSurvCode.getCode()%>"><%=adjSurvCode.getName()%></option>
																<% } %>                                  
															</select>                          
                        
														<% } %>
													</td>
												</tr>
                        
                         <script>
                          // clintonj SIR 37546
                          // Changed onChange event to onBlur
                        </script>
												<tr style="display:none">
													<td>Lawyer Code</td>
													<td>
														<input type="text" name="lawyerCode" value="<%=scmadvice.getLawyerCode()%>" <%=scmadvice.getLawyerCodeFlag()%> onblur="validateCode(this,document.all.lawyerName)">
													</td>
													<td>Lawyer Ref</td>
													<td>
														<input type="text" name="lawyerRef" value="<%=scmadvice.getLawyerRef()%>" <%=scmadvice.getLawyerRefFlag()%>>
													</td>
												</tr>

												<tr style="display:none">
													<td>Lawyer Name</td>
													<td colspan="3">
														<% if (scmadvice.getLawyerNameFlag()) { %>
															<input type="text" value="<%=scmadvice.getLawyerName()%>" class="fieldProtect" readonly="true">
															<input type="hidden" name="lawyerName" value="<%=scmadvice.getLawyerName()%>">
														<% } else { %>
                             <!-- Patrick Cogan SIR: 37546
                                 Created a custon onChange event and dissabled the one in main.js.mksInitialise() 
                                 to get the codes to update when you key out, used on key up event.
                             -->                                
                              <select name="lawyerName" <%=scmadvice.getLawyerNameFlag()%> onKeyUp="document.all.lawyerCode.value=document.all.lawyerName.options[document.all.lawyerName.selectedIndex].code" onChange="setLawyerCode()">                              
																<% Enumeration lawyerNames = lawyerCodeList.getLawyerCodes();
																while (lawyerNames.hasMoreElements()) {
																	LawyerCodeList.LawyerCode lawyerCode = (LawyerCodeList.LawyerCode)lawyerNames.nextElement(); %>
																	<option value="<%=lawyerCode.getName()%>" code="<%=lawyerCode.getCode()%>"><%=lawyerCode.getName()%></option>
																<% } %>
															</select>                             
														<% } %>
													</td>
												</tr>

												<tr>
													<td>Scheme Code</td>
													<td>
														<%=HTMLUtils.createDropdown("schemeCode",scmadvice.getSchemeCode(),scmadvice.getSchemeCodeFlag(),schemeCodeList)%>
													</td>
													<td></td>
													<td></td>
												</tr>
											</table> <!-- custom 4 -->

											<table class="custom">
												<tr>
													<td style="width:12.5%"></td>
													<td style="width:27.5%"></td>
													<td style="width:10%"></td>
													<td style="width:6.25%"></td>
													<td style="width:6.25%"></td>
													<td style="width:6.25%"></td>
													<td style="width:6.25%"></td>
													<td style="width:6.25%"></td>
													<td style="width:6.25%"></td>
													<td style="width:6.25%"></td>
													<td style="width:6.25%"></td>
												</tr>
												<tr>
													<td>XCS Recovery</td>
													<td><input type="text" name="xcsRecovery" value="<%=scmadvice.getXCSRecovery()%>" <%=scmadvice.getXCSRecoveryFlag()%>></td>
													<td>Finder Code</td>
													<td>1</td>
													<td><input type="text" name="finderCode1" value="<%=scmadvice.getFinderCode1()%>" <%=scmadvice.getFinderCode1Flag()%>></td>
													<td>2</td>
													<td><input type="text" name="finderCode2" value="<%=scmadvice.getFinderCode2()%>" <%=scmadvice.getFinderCode2Flag()%>></td>
													<td>3</td>
													<td><input type="text" name="finderCode3" value="<%=scmadvice.getFinderCode3()%>" <%=scmadvice.getFinderCode3Flag()%>></td>
													<td>LOC</td>
													<td><%=scmadvice.getHLoc()%></td>
												</tr>
											</table> <!-- Custom 11 -->
										</div>
									</td>
								</tr>
							</table>
							<!-- SCM Section 2 ends here -->

							<!-- SCM Section 3 starts here -->
							<div>
								<a name="financials">
								<!-- Optional header information -->
								<table class="headerInfo" width="100%">
									<tr>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
										<td style="width:8%"></td>
										<td style="width:17%"></td>
									</tr>
									<tr>
										<td><b>XCR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,scmadvice.getHXcr())%></td>
										<td><b>Bkr UCR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,scmadvice.getHUcr())%></td>
									</tr>
									</tr>
										<td><b>COR:</b></td>
										<td colspan="3"><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY,scmadvice.getHCor())%></td>
									  <td><b>TR:</b></td>
										<td colspan="3"><%=HTMLUtils.createUcr("tr", HTMLUtils.DISPLAY,scmadvice.getHTr())%></td>
									</tr>
									<tr>
										<td><b>OSND:</b></td>
										<td colspan="2"><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY,scmadvice.getHOsnd())%></td>
										<td><b>Mov't Ref/ Date:</b></td>
										<td colspan="2"><%=scmadvice.getHMvmtRefDate()%></td>
										<td><b>Peer Review:</b></td>                
                          				<td><%=scmadvice.getHPeerReview()%></td>
									</tr>
								</table> <!-- headerInfo -->

								<table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
									<tr>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Policy Details","document.location=\"#policy\"")%>
										</td>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Claim Details","document.location=\"#claim\"")%>
										</td>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Financials","document.location=\"#financials\"")%>
										</td>
									</tr>
								</table>
								<br>
							</div>

							<table  border='0' cellpadding='0' cellspacing='0' class='formHeading' >
								<tr>
									<td class='left'>&nbsp;</td>
									<td class='middle' nowrap>Financials</td>
									<td class='right'>&nbsp;</td>
								</tr>
							</table>

							<table  border="1" cellpadding="0" cellspacing="0" class="mainContent" >
								<tr>
									<td valign="top" >
										<div class="noscroll">
											<table class="custom">
												<tr>
													<td style="width:23%"></td>
													<td style="width:27%"></td>
													<td style="width:23%"></td>
													<td style="width:27%"></td>
												</tr>
                        <%-- clintonj - SIR 101172 - 16/09/2004 --%>
												<tr>
													<%--
														<td>Peer Review</td>
														<td><%=scmadvice.getHPeerReview()%></td> --%>
														<%-- <%=HTMLUtils.createDropdown("hPeerReview",scmadvice.getHPeerReview(),(scmadvice.getHPeerRevFlag().trim().equals("onClick=\"return false\" readonly=\"true\" class=\"fieldProtect\""))?true:false,peerReviewList)%> --%>
							                          <td>Payee Bkr:</td>
													<td><%=scmadvice.getHPayeeBkr()%></td>
												</tr>

												<tr>
													<td>Claim Bkr Ref 1</td>
													<td><input type="text" name="claimBrokerRef" value="<%=scmadvice.getClaimBrokerRef1()%>" <%=scmadvice.getClaimBrokerRef1Flag()%>></td>
													<td>Claim Bkr Ref 2</td>
													<td><input type="text" name="claimBrokerRef2" value="<%=scmadvice.getClaimBrokerRef2()%>" <%=scmadvice.getClaimBrokerRef2Flag()%>></td>
													</tr>
												<tr>
													<td>Settlement Bkr Ref 1</td>
													<td><input type="text" name="brokerClaimRef" value="<%=scmadvice.getBrokerClaimRef1()%>" <%=scmadvice.getBrokerClaimRef1Flag()%>></td>
													<td>Settlement Bkr Ref 2</td>
													<td><input type="text" name="brokerClaimRef2" value="<%=scmadvice.getBrokerClaimRef2()%>" <%=scmadvice.getBrokerClaimRef2Flag()%>></td>
												</tr>

											</table> <!-- custom 4 -->

											<table class="custom">
												<tr>
													<td style="width:13%"></td>
													<td style="width:21%"></td>
													<td style="width:13%"></td>
													<td style="width:20%"></td>
													<td style="width:13%"></td>
													<td style="width:20%"></td>
												</tr>

												<tr>
													<td>Orig Ccy</td>
													<td>
														<table border="0" cellpadding="0" cellspacing="0" width="100%">
															<tr>
																<td width="50%" style="padding-left:0px;">
																	<%=HTMLUtils.createDropdown("origCcy",scmadvice.getOrigCcy(),scmadvice.getOrigCcyFlag(),currencyCodeList)%>
																</td>
																<td>&nbsp;</td>
															</tr>
														</table>
													</td>
													<td>Sett Ccy</td>
													<td>
														<table border="0" cellpadding="0" cellspacing="0" width="100%">
															<tr>
																<td width="50%" style="padding-left:0px;">
																	<%=HTMLUtils.createDropdown("settCcy",scmadvice.getSettCcy(),scmadvice.getSettCcyFlag(),currencyCodeList)%>
																</td>
																<td>&nbsp;</td>
															</tr>
														</table>
													</td>
													<td>Redenom Ind:</td>
													<td><%=scmadvice.getHRedenomInd()%></td>
												</tr>

												<!--Commented out to remove blank line which is causing extra scrolling - STH - 07/01/2004
                                                                                                <tr>
													<td colspan="6">&nbsp;</td>
												</tr>
                                                                                                -->

												<tr>
													<td colspan="2" align="center"><b>Paid to Date (PTD)</b></td>
													<td colspan="2" align="center"><b>Paid this Time (PTT)</b></td>
													<td colspan="2" align="center"><b>Outstandings</b></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td>Clm/ Ref/ Rec</td>
													<td>
														<table border="0" cellpadding="0" cellspacing="0" width="100%">
															<tr>
																<td width="50%" style="padding-left:0px;">
																<%=HTMLUtils.createDropdown("clmRefRec",scmadvice.getClaimRefRec(),scmadvice.getClaimRefRecFlag(),clmRefRecList)%>
																</td>
																<td>&nbsp;</td>
															</tr>
														</table>
													</td>
													<td>O/S ROE</td>
													<td>
														<input type="text" name="osRateOfExch" value="<%=scmadvice.getOsRateOfExch()%>" <%=scmadvice.getOsRateOfExchFlag()%>>
													</td>
												</tr>

												<tr>
													<td>PTD Loss</td>
													<td><input type="text" name="ptdLoss" value="<%=scmadvice.getPTDLoss()%>" <%=scmadvice.getPTDLossFlag()%>></td>
													<td>PTT Loss</td>
													<td><input type="text" name="pttLoss" value="<%=scmadvice.getPTTLoss()%>" <%=scmadvice.getPTTLossFlag()%>></td>
													<td>O/S Loss</td>
													<td>
														<table border="0" width="100%" cellpadding="0" cellspacing="0">
															<tr>
																<td width="60%" style="padding-left:0px"><input type="text" name="osLoss" value="<%=scmadvice.getOsLoss()%>" <%=scmadvice.getOsLossFlag()%>></td>
																<td width="40%" style="padding-left:0px">
																	<%=HTMLUtils.createDropdownWOldVals("osLossqual",scmadvice.getOsLossQual(),scmadvice.getOsLossQualFlag(),osLossQualList)%>
																</td>
															</tr>
														</table>
													</td>
												</tr>

												<tr>
													<td>PTD Exp</td>
													<td><input type="text" name="ptdExp" value="<%=scmadvice.getPTDExp()%>" <%=scmadvice.getPTDExpFlag()%>></td>
													<td>PTT Exp</td>
													<td><input type="text" name="pttExp" value="<%=scmadvice.getPTTExp()%>" <%=scmadvice.getPTTExpFlag()%>></td>
													<td>O/S Exp</td>
													<td><input type="text" name="osExp" value="<%=scmadvice.getOsExp()%>" <%=scmadvice.getOsExpFlag()%>></td>
												</tr>

												<tr>
													<td>PTD Fee</td>
													<td><input type="text" name="ptdFee" value="<%=scmadvice.getPTDFee()%>" <%=scmadvice.getPTDFeeFlag()%>></td>
													<td>PTT Fee</td>
													<td><input type="text" name="pttFee" value="<%=scmadvice.getPTTFee()%>" <%=scmadvice.getPTTFeeFlag()%>></td>
													<td>O/S Fee</td>
													<td>
														<table border="0" width="100%" cellpadding="0" cellspacing="0">
															<tr>
																<td width="60%" style="padding-left:0px"><input type="text" name="osFee" value="<%=scmadvice.getOsFee()%>" <%=scmadvice.getOsFeeFlag()%>></td>
																<td width="40%" style="padding-left:0px">
																	<%=HTMLUtils.createOsFeeDropdown("osFeeQual",scmadvice.getOsFeeQual(),scmadvice.getOsFeeQualFlag(),osFeeQualList, scmadvice.getOsFee())%>
																</td>
															</tr>
														</table>
													</td>
												</tr>

												<tr>
													<td>PTD Total</td>
													<td><input type="text" name="ptdTotal" value="<%=scmadvice.getPTDTotal()%>" <%=scmadvice.getPTDTotalFlag()%>></td>
													<td>PTT Total</td>
													<td><input type="text" name="pttTotal" value="<%=scmadvice.getPTTTotal()%>" <%=scmadvice.getPTTTotalFlag()%>></td>
													<td>O/S Total</td>
													<td>
														<table border="0" width="100%" cellpadding="0" cellspacing="0">
															<tr>
																<td width="60%" style="padding-left:0px"><input type="text" name="osTotal" value="<%=scmadvice.getOsTotal()%>" <%=scmadvice.getOsTotalFlag()%>></td>
																<td width="40%" style="padding-left:0px">
																	<%=HTMLUtils.createDropdownWOldVals("osTotalQual",scmadvice.getOsTotalQual(),scmadvice.getOsTotalQualFlag(),osTotalQualList)%>
																</td>
															</tr>
														</table>
													</td>
												</tr>

												<tr>
													<td>PTD in Sett Ccy</td>
													<td><input type="text" name="ptdInSettCcy" value="<%=scmadvice.getPTDInSettCcy()%>" <%=scmadvice.getPTDInSettCcyFlag()%>></td>
													<td>Incurred<span class="compMarker">*</span></td>
													<td><input type="text" name="incurred" value="<%=scmadvice.getIncurred()%>" <%=scmadvice.getIncurredFlag()%>></td>

													<!-- Expert Fee Breakdown screen link -->
													<%
														if(!scmadvice.getExpertFeeBreakDownLinkFlag())
														{
													%>
															    <td colspan="2"><span class="link" onclick="expertFees()"><i>Expert Fees Breakdown</i></span></td>
													<%
														}
														else
														{
													%>
																<td></td><td></td>
													<%
														}
													%>
													
													
												</tr>

												<tr>
													<td>Highest Est</td>
													<td><input type="text" name="highestEst" value="<%=scmadvice.getHighestEst()%>" <%=scmadvice.getHighestEstFlag()%>></td>
													<td>Sett ROE</td>
													<td><input type="text" name="settRateOfExc" value="<%=scmadvice.getSettRateOfExch()%>" <%=scmadvice.getSettRateOfExchFlag()%>></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td>Settled in Sett Ccy</td>
													<td><input type="text" name="settledRateInSettCcy" value="<%=scmadvice.getSettledRateInSettCcy()%>" <%=scmadvice.getSettledRateInSettCcyFlag()%>></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td>Total Line</td>
													<td><input type="text" name="totalLine" value="<%=scmadvice.getTotalLine()%>" <%=scmadvice.getTotalLineFlag()%>></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td>Bureau Ppn</td>
													<td><input type="text" name="bureauPpn" value="<%=scmadvice.getBureauPpn()%>" <%=scmadvice.getBureauPpnFlag()%>></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td>100% VAT Amt</td>
													<td><input type="text" name="vatAmount" value="<%=scmadvice.getVATAmount()%>" <%=scmadvice.getVATAmountFlag()%>></td>
													<td colspan="2">
														<% if (!scmadvice.getVATRatesButtonFlag()) { %>
															<span class="link" onclick="vatRates()"><i>VAT Rates</i></span>
														<% } %>
													</td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td>War Amount</td>
													<td><input type="text" name="warAmount" value="<%=scmadvice.getWARAmount()%>" <%=scmadvice.getWARAmountFlag()%>></td>
													<td></td>
													<td></td>
												</tr>
											</table> <!-- custom 6 -->

											<table class="custom" cellspacing="0">
												<tr>
													<td width="10%"></td>
													<td width="10%"></td>
													<td width="10%"></td>
													<td width="34%"></td>
													<td width="2%"></td>
													<td width="34%"></td>
												</tr>

												<tr>
													<td>Narrative Code</td>
													<td>
														<% Enumeration narrativeCodes;
														if (scmadvice.getNarrativeCode1Flag()) { %>
															<input type="text" value="<%=scmadvice.getNarrativeCode1()%>" class="fieldProtect" readonly="true">
															<input type="hidden" name="narrativeCode1" value="<%=scmadvice.getNarrativeCode1()%>">
														<% } else { %>
															<select name="narrativeCode1" onKeyUp="narrativeForSet2.value = document.all.narrativeCode1.options[document.all.narrativeCode1.selectedIndex].narr" onChange="narrativeForSet2.value = document.all.narrativeCode1.options[document.all.narrativeCode1.selectedIndex].narr">
																<% narrativeCodes = narrativeList.getNarratives();
																while (narrativeCodes.hasMoreElements()) {
																	NarrativeList.Narrative narrative = (NarrativeList.Narrative)narrativeCodes.nextElement(); %>
																	<option value="<%=narrative.getCode()%>" narr="<%=narrative.getText()%>" <%=scmadvice.getNarrativeCode1().equals(narrative.getCode())?"SELECTED":""%>><%=narrative.getCode()%></option>
																<% } %>
															</select>
														<% } %>
													</td>
													<td>Current Narrative</td>
													<td colspan="3"><input type="text" name="narrativeForSet" value="<%=scmadvice.getNarrativeForSet()%>" <%=scmadvice.getNarrativeForSetFlag()%>></td>
												</tr>

												<tr>
													<td>Narrative Code</td>
													<td>
														<% if (scmadvice.getNarrativeCode2Flag()) { %>
															<input type="text" value="<%=scmadvice.getNarrativeCode2()%>" class="fieldProtect" readonly="true">
															<input type="hidden" name="narrativeCode2" value="<%=scmadvice.getNarrativeCode2()%>">
														<% } else { %>
															<select name="narrativeCode2" onKeyUp="narrativeForSet3.value = document.all.narrativeCode2.options[document.all.narrativeCode2.selectedIndex].narr" onChange="narrativeForSet3.value = document.all.narrativeCode2.options[document.all.narrativeCode2.selectedIndex].narr">
																<% narrativeCodes = narrativeList.getNarratives();
																while (narrativeCodes.hasMoreElements()) {
																	NarrativeList.Narrative narrative = (NarrativeList.Narrative)narrativeCodes.nextElement(); %>
																	<option value="<%=narrative.getCode()%>" narr="<%=narrative.getText()%>" <%=scmadvice.getNarrativeCode2().equals(narrative.getCode())?"SELECTED":""%>><%=narrative.getCode()%></option>
																<% } %>
															</select>
														<% } %>
													</td>
													<td></td>
													<td><input type="text" name="narrativeForSet2" value="<%=scmadvice.getNarrativeForSet2()%>" <%=scmadvice.getNarrativeForSet2Flag()%>></td>
													<td>&nbsp;</td>
													<td><input type="text" name="narrativeForSet3" value="<%=scmadvice.getNarrativeForSet3()%>" <%=scmadvice.getNarrativeForSet3Flag()%>></td>
												</tr>
											</table> <!-- custom 6 -->

											<table class="custom">
												<tr>
													<td style="width:23%"></td>
													<td style="width:10%"></td>
													<td style="width:23%"></td>
													<td style="width:10%"></td>
												</tr>

												<tr>
													<td>Subrogation</td>
													<td><input type="checkbox" name="subrogation" <%=scmadvice.getCheckedSubrogation()%> <%=scmadvice.getSubrogationFlag()%>></td>
													<td>Attachments Ind</td>
													<td><input type="checkbox" name="attachmentsInd" <%=scmadvice.getCheckedAttachmentsInd()%> <%=scmadvice.getAttachmentsIndFlag()%>></td>
												</tr>
                                                                                                 <tr>
                                                                                                        <td>Claim Opt Out Status:</td>
                                                                                                        <td><%=scmadvice.getClmOptOutStatus()%></td>
                                                                                                        <td>Claim Opt Out Date:</td>
                                                                                                        <td><%=scmadvice.getClmOptOutDate()%></td>
												</tr>
											</table> <!-- custom 4 -->
										</div>
									</td>
								</tr>
							</table>
							<!-- SCM Section 3 ends here -->

						</div> <!-- Content -->

						<div class="bot">
						</div> <!-- Bot -->
					</div> <!-- OuterWindow -->
				</td>
				<td></td>
			</tr>
		</table>
		<% if (user.updateMode()) { %>
			<script language="JavaScript" src="<%=request.getContextPath()%>/js/screen/scmadvicecontent.js"></script>
		<% } %>
		<script>   
      claimNarrativeFix();   
      
      // clintonj SIR 37546
      // Patrick Cogan made these methods conditionally included only when needed - fix for contra javascript problem for SIR 37546.
      // Ensures that the adjuster and lawyer codes are in sync with the adjuster and lawyer name drop downs.
      <% if (!scmadvice.getAdjusterNameFlag()) { %>adjusterNameFix(); <%}%>     
      <% if (!scmadvice.getLawyerNameFlag()) { %>lawyerNameFix();  <%}%>
    </script>
    
	</form>
</span>

<!-- To insert comma in the financial amount fields on load of this screen -->
<!-- Though commas are inserted by vField, but this is required when user comes on the screen after history.go(-1) -->
<script>
	document.body.onload = (function() {
										document.forms[0].ptdLoss.value               =   insertCommas(document.forms[0].ptdLoss.value);
										document.forms[0].pttLoss.value               =   insertCommas(document.forms[0].pttLoss.value);
										document.forms[0].osLoss.value                =   insertCommas(document.forms[0].osLoss.value);
										document.forms[0].ptdExp.value                =   insertCommas(document.forms[0].ptdExp.value);
										document.forms[0].pttExp.value                =   insertCommas(document.forms[0].pttExp.value);
										document.forms[0].osExp.value                 =   insertCommas(document.forms[0].osExp.value);
										document.forms[0].ptdFee.value                =   insertCommas(document.forms[0].ptdFee.value);
										document.forms[0].pttFee.value                =   insertCommas(document.forms[0].pttFee.value);
										document.forms[0].osFee.value                 =   insertCommas(document.forms[0].osFee.value);
										document.forms[0].ptdTotal.value              =   insertCommas(document.forms[0].ptdTotal.value);
										document.forms[0].pttTotal.value              =   insertCommas(document.forms[0].pttTotal.value);
										document.forms[0].osTotal.value               =   insertCommas(document.forms[0].osTotal.value);
										document.forms[0].ptdInSettCcy.value          =   insertCommas(document.forms[0].ptdInSettCcy.value);
										document.forms[0].incurred.value              =   insertCommas(document.forms[0].incurred.value);
										document.forms[0].highestEst.value            =   insertCommas(document.forms[0].highestEst.value);
										document.forms[0].settRateOfExc.value         =   insertCommas(document.forms[0].settRateOfExc.value);
										document.forms[0].settledRateInSettCcy.value  =   insertCommas(document.forms[0].settledRateInSettCcy.value);
										document.forms[0].bureauPpn.value             =   insertCommas(document.forms[0].bureauPpn.value);
										document.forms[0].vatAmount.value             =   insertCommas(document.forms[0].vatAmount.value);
										document.forms[0].warAmount.value             =   insertCommas(document.forms[0].warAmount.value);							
									});
</script>

<!-- 
  == ========================================================================
  == Change Control:
  == ===============
  == 
  == $Log: scmadvicecontent.jsp,v $
  == Revision 1.8.12.7  2005/09/30 12:05:22  coganp
  == fixed conflicts between different branches
  ==
  == Revision 1.8.10.2  2005/08/19 07:31:34  coganp
  == Fixed to show values in the readonly qual code fields
  ==
  == Revision 1.8.10.1  2005/08/12 10:05:54  coganp
  == added specific dropdown for os fee qual.
  ==
  == Revision 1.8.12.6  2004/11/17 15:05:36  clintonj
  == changed colons
  ==
  == Revision 1.8.12.5  2004/11/17 13:10:34  clintonj
  == backed out peer review change
  ==
  == Revision 1.8.12.4  2004/10/27 10:42:03  clintonj
  == Applied performance enhancements and removed unrequired main.js from timer.jsp
  ==
  == Revision 1.8.12.3  2004/09/16 14:37:03  clintonj
  == removed debugging stmts
  ==
  == Revision 1.8.12.2  2004/09/16 12:27:58  clintonj
  == no message
  ==
  == Revision 1.8.12.1  2004/09/16 12:20:37  clintonj
  == Adjuster/Lawyer fix
  ==
  == Revision 1.8  2004/04/02 12:32:29  coganp
  == SIR: 37546
  == fixed javascript errors on scm contra screen
  ==
  == Revision 1.7  2004/03/30 16:01:39  clintonj
  == SIR 37546.
  == Added adjusterFix function.
  == Added lawyerFix function.
  == Added some custom script to call the functions to ensure that the adjuster/lawyer
  == codes are in sync with the names in the drop down lists.
  == Removed alerts statements.
  ==
  == Revision 1.6  2004/03/23 15:52:25  clintonj
  == SIR 37546
  == Added focus on/off for the adjuster and lawyer fields to make sure the
  == correct name is displayed in the list due to limitations of field length in
  == the Main Frame.
  ==
  ==
  == ========================================================================
-->
