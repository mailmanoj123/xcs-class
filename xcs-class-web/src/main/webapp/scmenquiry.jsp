<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="scmadvice" type="com.xchanging.xcc.web.models.SCMAdviceModel" scope="session" />
<jsp:useBean id="markets" type="com.xchanging.xcc.web.models.MarketsModel" scope="session" />
<jsp:useBean id="claimDetails" type="com.xchanging.xcc.web.models.ClaimDetailsModel" scope="session" />
<jsp:useBean id="expertfeebreakdown" type="com.xchanging.xcc.web.models.ExpertFeeBreakDownModel" scope="session" />


<%-- clintonj - SIR 101172 - 16/09/2004 --%>
<jsp:useBean id="peerReviewList" type="com.xchanging.xcc.web.models.reference.PeerReviewList" scope="application" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>
<script>
	function vatRates() {
                submitForm("<%=request.getContextPath()%>/control/vatrates");
	}
	
	function expertFees() 
	{
<%
		if(expertfeebreakdown.getExpertScreenMode()!=null && expertfeebreakdown.getExpertScreenMode().equalsIgnoreCase("E"))
		{
%>
			submitForm("<%=request.getContextPath()%>/control/expertfeebreakdownenquiryenquiry");
<%		    
		}
		else
		{
%>
			submitForm("<%=request.getContextPath()%>/control/expertfeebreakdownenquiryupdate");
<%
		}
%>	
		
	}
	
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
								<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save"," submitForm(\"" + request.getContextPath() + "/control/scmadvicesave\")")%>
							<% } %>

							<% if (!scmadvice.getNewMovementFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Create New Movement","submitForm(\"" + request.getContextPath() + "/control/scmadvicenewmvmt\")")%>
							<% } %>

							<% if (!scmadvice.getEndBDFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"End Breakdown"," submitForm(\"" + request.getContextPath() + "/control/scmadviceendbd\")")%>
							<% } %>

							<% if (!scmadvice.getNewBDFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"New Breakdown"," submitForm(\"" + request.getContextPath() + "/control/scmadvicenewbd\")")%>
							<% } %>

							<% if (!scmadvice.getRiSchdFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Create R/I Schedule"," submitForm(\"" + request.getContextPath() + "/control/scmadvicecreaterischedule\")")%>
							<% } %>

							<% if (!scmadvice.getBindSchdFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Create Bndr Schedule"," submitForm(\"" + request.getContextPath() + "/control/scmadvicecreatebinderschedule\")")%>
							<% } %>

							<% if (!scmadvice.getBackFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Back to Schedule"," submitForm(\"" + request.getContextPath() + "/control/scmadvicebacktoschedule\")")%>
							<% } %>

							<% if (!scmadvice.getEuroFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Euro Conv Details"," submitForm(\"" + request.getContextPath() + "/control/scmadviceeuroconvdetails\")")%>
							<% } %>

							<% if (!scmadvice.getCcsFlag()) { %>
								<%=HTMLUtils.createButton(HTMLUtils.ACTION,"CCS Amounts"," submitForm(\"" + request.getContextPath() + "/control/scmadviceccsamounts\")")%>
							<% } %>

							<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/scmadvicecancel\", false)")%>
						</div> <!--Menu Bar-->

						<div class="content">
							<!-- SCM Section 1 starts here -->
							<div>
								<a name="policy"></a>
								<!-- Optional header information -->
								<table class="headerInfo" width="100%">
									<tr>
										<td style="width:12%"></td>
										<td style="width:38%"></td>
										<td style="width:12%"></td>
										<td style="width:38%"></td>
									</tr>
									<tr>
										<td><b>XCR:</b></td>
										<td><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,scmadvice.getHXcr())%></td>
										<td><b>Bkr UCR:</b></td>
										<td><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,scmadvice.getHUcr())%></td>
									</tr>
									</tr>
										<td><b>COR:</b></td>
										<td><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY,scmadvice.getHCor())%></td>
									  <td><b>Group Ref:</b></td>
										<td><%=HTMLUtils.createGroupRef("group ref", HTMLUtils.DISPLAY,scmadvice.getsGROUP_REF())%></td>
									</tr>
									<tr>
										<td><b>OSND:</b></td>
										<td><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY,scmadvice.getHOsnd())%></td>
										<td><b>AP Number</b></td>
										<td><%=scmadvice.getsAP_REF()%></td>
									</tr>
									<tr>
										<td><b>YOA</b></td>
										<td><%=scmadvice.getsYEAR_OF_ACC()%></td>
										<td><b>Peer Review:</b> </td>
										<td><%=scmadvice.getHPeerReview()%></td>
									</tr>
								</table> <!-- headerInfo -->

								<table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
									<tr>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Policy Details","document.location=\"#policy\"")%>
										</td>
                                                                                <td align="center">
                                                                                        <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Market Details","document.location=\"#market\"")%>
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

                                                        <%=HTMLUtils.createTitle("Policy Details")%>

							<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
								<tr>
									<td valign="top" >
										<div class="noscroll">
											<table class="custom" border="0">
												<tr>
													<td style="width:25%"></td>
													<td style="width:45%"></td>
													<td style="width:20%"></td>
													<td style="width:10%"></td>
												</tr>
												<tr>
													<td><b>UMR:</b></td>
													<td><%=scmadvice.getsUMR()%></td>
													<td><b>Market Code:</b></td>
													<td><%=scmadvice.getsMKT_CODE()%></td>
												</tr>
											</table>
											<table class="custom" border="0">
												<tr>
													<td style="width:25%"></td>
													<td style="width:75%"></td>
												</tr>

												<tr>
													<td><b>Coverholder</b></td>
													<td><%=scmadvice.getClaimholder()%></td>
												</tr>

												<tr>
													<td><b>Insured</b></td>
													<td><%=scmadvice.getInsured()%></td>
												</tr>

												<tr>
													<td><b>Reinsured</b></td>
													<td><%=scmadvice.getResinsured()%></td>
												</tr>

												<tr>
													<td><b>Orig Insured</b></td>
													<td><%=scmadvice.getOrigInsured()%></td>
												</tr>

												<tr>
													<td><b>Other Name</b></td>
													<td><%=scmadvice.getOtherName()%></td>
												</tr>

												<tr>
													<td><b>Loss Name</b></td>
													<td><%=scmadvice.getLossName()%></td>
												</tr>

												<tr>
													<td><b>Vessel/ Aircraft/ Conveyance</b></td>
													<td><%=scmadvice.getVesselAircraft()%></td>
												</tr>
												
												<tr>
													<td><b>Slip Type</b></td>
													<td><%=scmadvice.getSlipTypeDesc()%></td>
												</tr>
											</table> <!-- custom -->

											<table class="custom" border="0">
												<tr>
													<td style="width:21%"></td>
													<td style="width:18%"></td>
													<td style="width:21%"></td>
													<td style="width:18%"></td>
													<td style="width:13%"></td>
													<td style="width:9%"></td>
												</tr>

												<tr>
													<td><b>Cover/ Lineslip Period From</b></td>
													<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,scmadvice.getsCOV_DATE_FROM())%></td>
													<td><b>Cover/ Lineslip Period To</b></td>
													<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,scmadvice.getsCOV_DATE_TO())%></td>
													<td><b>Cover/ Lineslip Qualifier</b></td>
													<td><%=scmadvice.getsCOV_QUAL()%></td>
												</tr>

												<tr>
													<td><b>Pol/ Cert Period From</b></td>
													<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,scmadvice.getPolCertPeriodFrom())%></td>
													<td><b>Pol/ Cert Period To</b></td>
													<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,scmadvice.getPolCertPeriodTo())%></td>
													<td><b>Pol/ Cert Qualifier</b></td>
													<td><%=scmadvice.getPolCertQual()%></td>
												</tr>

												<tr>
													<td><b>Policy Cert Narrative</b></td>
													<td colspan="5"><%=scmadvice.getsPER_NARR()%></td>
												</tr>

												<tr>
													<td><b>DOL From</b></td>
													<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,scmadvice.getDOLFrom())%></td>
													<td><b>DOL To</b></td>
													<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,scmadvice.getDOLTo())%></td>
													<td><b>DOL Qual</b></td>
													<td><%=scmadvice.getDOLQual()%></td>
												</tr>

												<tr>
													<td><b>Loss Date Narrative</b></td>
													<td colspan="3"><%=scmadvice.getDOLNarrative()%></td>
													<td><b>War Ind</b></td>
													<td><%=scmadvice.getWarInd()%></td>
												</tr>

												<tr>
													<td><b>DCM/DOD From</b></td>
													<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,scmadvice.getDCMFrom())%></td>
													<td><b>DCM/DOD To</b></td>
													<td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,scmadvice.getDCMTo())%></td>
													<td><b>DCM/DOD Qualifier</b></td>
													<td><%=scmadvice.getDCMQual()%></td>
												</tr>
											</table> <!-- custom 6 -->

											<table class="6column" border="0">

												<tr>
													<td><b>Slip Order 1</b></td>
													<td><%=scmadvice.getsSLIP_ORD_1()%>
													<td><b>Slip Order 2</b></td>
													<td><%=scmadvice.getsSLIP_ORD_2()%>
													<td><b>Basis of Limit</b></td>
													<td colspan="2"><%=scmadvice.getsLIMIT_BASIS()%>
												</tr>

												<tr>
													<td><b>Ccy of Limits</b></td>
													<td><%=scmadvice.getCcyOfLimits()%></td>
													<td><b>SCM Limits</b></td>
													<td colspan="2"><%=scmadvice.getLimitsFormatted()%></td>
												</tr>
												
												<tr>
													<td colspan="2"></td>
													<td><b>SCM Excess</b></td>
													<td colspan="2"><%=scmadvice.getExcessFormatted()%></td>
												</tr>

												<tr>
													<td><b>Sum Insured Narrative 1</b></td>
													<td colspan="6"><%=scmadvice.getsSI_NARR()%></td>
												</tr>

												<tr>
													<td><b>Perils/ Condition</b></td>
													<td colspan="6"><%=scmadvice.getPerilsCondition()%></td>
												</tr>

												<tr>
													<td><b>Policy Details</b></td>
													<td colspan="6"><%=scmadvice.getsPOLICY_NARR_LINE1()%></td>
												</tr>
												<tr>
													<td></td>
													<td colspan="6"><%=scmadvice.getsPOLICY_NARR_LINE2()%></td>
												</tr>
												<tr>
													<td></td>
													<td colspan="6"><%=scmadvice.getsPOLICY_NARR_LINE3()%></td>
												</tr>
												<tr>
													<td></td>
													<td colspan="6"><%=scmadvice.getsPOLICY_NARR_LINE4()%></td>
												</tr>
											</table> <!-- custom 7 -->
										</div> <!-- noscroll -->
									</td>
								</tr>
							</table> <!-- mainContent -->
							<!-- SCM Section 1 ends here -->

                                                        <!-- SCM Section 2 starts here -->
                                                        <div>
                                                                <a name="market"></a>
                                                                <!-- Optional header information -->
                                                                <table class="headerInfo" width="100%">
                                                                        <tr>
                                                                                <td style="width:12%"></td>
                                                                                <td style="width:38%"></td>
                                                                                <td style="width:12%"></td>
                                                                                <td style="width:38%"></td>
                                                                        </tr>
                                                                        <tr>
                                                                                <td><b>XCR:</b></td>
                                                                                <td><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,scmadvice.getHXcr())%></td>
                                                                                <td><b>Bkr UCR:</b></td>
                                                                                <td><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,scmadvice.getHUcr())%></td>
                                                                        </tr>
                                                                        </tr>
                                                                                <td><b>COR:</b></td>
                                                                                <td><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY,scmadvice.getHCor())%></td>
                                                                          <td><b>Group Ref:</b></td>
                                                                                <td><%=HTMLUtils.createGroupRef("group ref", HTMLUtils.DISPLAY,scmadvice.getsGROUP_REF())%></td>
                                                                        </tr>
                                                                        <tr>
                                                                                <td><b>OSND:</b></td>
                                                                                <td><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY,scmadvice.getHOsnd())%></td>
                                                                                <td><b>AP Number</b></td>
                                                                                <td><%=scmadvice.getsAP_REF()%></td>
                                                                        </tr>
                                                                        <tr>
                                                                                <td><b>YOA</b></td>
                                                                                <td><%=scmadvice.getsYEAR_OF_ACC()%></td>
                                                                                <td><b>Peer Review:</b> </td>
                                                                                <td><%=scmadvice.getHPeerReview()%> </td>
                                                                        </tr>
                                                                </table> <!-- headerInfo -->

                                                                <table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
                                                                        <tr>
                                                                                <td align="center">
                                                                                        <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Policy Details","document.location=\"#policy\"")%>
                                                                                </td>
                                                                                <td align="center">
                                                                                        <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Market Details","document.location=\"#market\"")%>
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

                                                        <%=HTMLUtils.createTitle("Market Details")%>

                                                        <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
                                                                                        <tr>
                                                                                                <td valign="top" >
                                                                                                        <div class="noscroll">
                                                                                                                <table width="100%" border="0" class="custom">
                                                                                                                        <tr>
                                                                                                                                <td style="width:21%"></td>
                                                                                                                                <td style="width:12%"></td>
                                                                                                                                <td style="width:17%"></td>
                                                                                                                                <td style="width:17%"></td>
                                                                                                                                <td style="width:16%"></td>
                                                                                                                                <td style="width:16%"></td>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                                <td><b>Audit/Risk:</b></td>
                                                                                                                                <td><%=scmadvice.getsRISK_CODE()%></td>
                                                                                                                                <td><b>US/Can Ind:</b></td>
                                                                                                                                <td><%=scmadvice.getUsaCanInd()%></td>
                                                                                                                                <td><b>US/Can TF:</b></td>
                                                                                                                                <td><%=scmadvice.getTfCode()%></td>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                                <td><b>Other TF:</b></td>
                                                                                                                                <td><%=scmadvice.getOtherTfCode()%></td>
                                                                                                                                <td><b>DTI:</b></td>
                                                                                                                                <td><%=scmadvice.getDti()%></td>
                                                                                                                                <td></td>
                                                                                                                                <td></td>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                                <td><b>Country Of Origin:</b></td>
                                                                                                                                <td><%=scmadvice.getCountryOfOrigin()%></td>
                                                                                                                                <td><b>State:</b></td>
                                                                                                                                <td><%=scmadvice.getStateCode()%></td>
                                                                                                                                <td><b>County Code:</b></td>
                                                                                                                                <td><%=scmadvice.getCountyCode()%></td>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                          		<td><b>FIL 1:</b></td>
                                                                                                                                <td><%=scmadvice.getFilCode1()%></td>
                                                                                                                                <td><b>FIL 2:</b></td>
                                                                                                                                <td><%=scmadvice.getFilCode2()%></td>
                                                                                                                                <td></td>
                                                                                                                                <td></td>
                                                                                                                        </tr>
                                                                                                                        
                                                                                                                        <tr>
                                                                                                                                <td><b>NAIC:</b></td>
                                                                                                                                <td><%=scmadvice.getNaicCode()%></td>
                                                                                                                                <td><b>NAIC Qual:</b></td>
                                                                                                                                <td><%=scmadvice.getNaicQual()%></td>
                                                                                                                                <td><b></b></td>
                                                                                                                                <td></td>
                                                                                                                        </tr>

                                                      																	<tr>
                                                                                                                                <td><strong>No of Syndicates:</strong></td>
                                                                                                                                <td><%=scmadvice.getsNO_SYNDS()%></td>
                                                                                                                                <td><strong>Total Line:</strong></td>
                                                                                                                                <td><%=scmadvice.getTotalLine()%><input type="hidden" name="totalLine" value="<%=scmadvice.getTotalLine()%>"></td>
                                                                                                                                <td><strong>Market Source</strong></td>
                                                                                                                                <td><%=scmadvice.getsMARKET_SOURCE()%></td>
                                                                                                                        </tr>
                                                                                                                </table>
                                                                                                                        <br>
                                                                                                                        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="marketdetails">
                                                                                                                                <tr>
                                                                                                                                        <th align="left" width="11%">Line No</th>
                                                                                                                                        <th align="left" width="11%">Syndicate No</th>
                                                                                                                                        <th align="left" width="18%">Syndicate %</th>
                                                                                                                                        <th align="left" width="24%">Syndicate Ref</th>
                                                                                                                                        <th align="left" width="14%">Opt Out Status</th>
                                                                                                                                        <th align="left" width="16%">Opt Out Date</th>
                                                                                                                                        <th align="left" width="6%">Bureau Leader</th>
                                                                                                                                </tr>
                                                                                                                                <% Enumeration marketLines = scmadvice.getSyndicates();
                                                                                                                                while (marketLines.hasMoreElements()) {
                                                                                                                                  SCMAdviceModel.singleMarketDetailLine line = (SCMAdviceModel.singleMarketDetailLine)marketLines.nextElement();
                                                                                                                                  %>
                                                                                                                                <tr>
                                                                                                                                        <td><%=line.getsClaimLineNo()%></td>
                                                                                                                                        <td><%=line.getsCoyCode()%></td>
                                                                                                                                        <td><%=line.getsCoyLine()%></td>
                                                                                                                                        <td><%=line.getsCoyRef1()%></td>
                                                                                                                                        <td><%=line.getsOptOutStatus()%></td>
                                                                                                                                        <td><%=line.getsOptOutDate()%></td>
                                                                                                                                        <td><%=line.getsBureauLeadInd()%></td>
                                                                                                                                </tr>
                                                                                                                                <% } %>
                                                                                                                        </table>
                                                                                                        </div>
                                                                                                </td>
                                                                                        </tr>
										</table>
                                                        <!-- SCM Section 2 ends here -->

							<!-- SCM Section 3 starts here -->
							<div>
								<a name="claim"></a>
								<!-- Optional header information -->
								<table class="headerInfo" width="100%">
									<tr>
										<td style="width:12%"></td>
										<td style="width:38%"></td>
										<td style="width:12%"></td>
										<td style="width:38%"></td>
									</tr>
									<tr>
										<td><b>XCR:</b></td>
										<td><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,scmadvice.getHXcr())%></td>
										<td><b>Bkr UCR:</b></td>
										<td><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,scmadvice.getHUcr())%></td>
									</tr>
									</tr>
										<td><b>COR:</b></td>
										<td><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY,scmadvice.getHCor())%></td>
									  <td><b>Group Ref:</b></td>
										<td><%=HTMLUtils.createGroupRef("group ref", HTMLUtils.DISPLAY,scmadvice.getsGROUP_REF())%></td>
									</tr>
									<tr>
										<td><b>OSND:</b></td>
										<td><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY,scmadvice.getHOsnd())%></td>
										<td><b>AP Number</b></td>
										<td><%=scmadvice.getsAP_REF()%></td>
									</tr>
									<tr>
										<td><b>YOA</b></td>
										<td><%=scmadvice.getsYEAR_OF_ACC()%></td>
										<td><b>Peer Review:</b> </td>
										<td><%=scmadvice.getHPeerReview()%> </td>
									</tr>
								</table> <!-- headerInfo -->

								<table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
									<tr>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Policy Details","document.location=\"#policy\"")%>
										</td>
                                                                                <td align="center">
                                                                                        <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Market Details","document.location=\"#market\"")%>
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

							<%=HTMLUtils.createTitle("Claim Details")%>

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
													<td><b>Current Bkr</b></td>
													<td><%=scmadvice.getHOrigBkr()%></td>
												</tr>
												<tr>
													<td><b>Bkr Contact</b></td>
													<td><%=scmadvice.getBrokerContact()%></td>
													<td><b>Bkr Phone No</b></td>
													<td><%=scmadvice.getBrokerPhoneNo()%></td>
												</tr>
												<tr>
													<td><b>Claim Bkr Ref 1</b></td>
													<td><%=scmadvice.getClaimBrokerRef1()%></td>
													<td><b>Claim Bkr Ref 2</b></td>
													<td><%=scmadvice.getClaimBrokerRef2()%></td>
													</tr>
											</table>
                                                        <!--TP866603 Changes for newly added barcode field --> 
											<table class="custom">
												<tr>
													<td style="width:12%"></td>
													<td style="width:8%"></td>
													<td style="width:12%"></td>
													<td style="width:8%"></td>
													<td style="width:12%"></td>
													<!--SIR 229665 Changes to increase width for barcode field display-->
													<td style="width:15%"></td>
													<td style="width:12%"></td>
													<td style="width:8%"></td>
												</tr>

												<tr>
													<td><b>Block</b></td>
													<td><%=scmadvice.getBlockInd()%></td>
													<td><b>Loss Fund Entry</b></td>
													<td><%=scmadvice.getLfEntryInd()%></td>
													<td><b>Loss Fund Advanced</b></td>
													<td><%=scmadvice.getLFAdvanceInd()%></td>
													<td><b>Claim/ Risk Type</b></td>
													<td><%=scmadvice.getsLLOYDS_CLAIM_TYPE()%></td>
												</tr>
	                               <!-- ****************************ECF Phase 6 changes start  -->
												<tr>
												<td><b>Direct Report</b></td>
												<td><%=scmadvice.getDirectReportInd()%></td>
												<td><b>Claim in Litigation</b></td>
												<td><%=scmadvice.getClmInLitigationInd()%></td>
									<!--TP866603 Changes for newly added barcode field --> 
												<td><b>Barcode</b></td>
												<td><%=scmadvice.getBarcode()%></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
									<!-- ****************************ECF Phase 6 changes start  -->
											</table> <!-- custom 6 -->
											
											<% 
											String serviceType = "";
											if(scmadvice.getServiceType().equalsIgnoreCase("C")){
											    serviceType = "COMPLEX"; 
											}else if(scmadvice.getServiceType().equalsIgnoreCase("S")){
											    serviceType = "STANDARD"; 
											}else if(scmadvice.getServiceType().equalsIgnoreCase("A")){
											    serviceType = "TECHNICAL ACCOUNTING";
											}else if(scmadvice.getServiceType().equalsIgnoreCase("P")){
											    serviceType = "STANDARD TP"; 
											}else if(scmadvice.getServiceType().equalsIgnoreCase("T")){
											    serviceType = "THRESHOLD TP"; 
											}
											        
											        %>
											<table class="custom">
												<tr>
													<td style="width:25%"></td>
													<td style="width:75%"></td>
												</tr>
													<tr>
													<td><b>Service Type</b></td>
													<td><%=serviceType%></td>
												</tr>
												<tr>
													<td><b>Claimant</b></td>
													<td><%=scmadvice.getClaimant()%></td>
												</tr>

												<tr>
													<td><b>Interest</b></td>
													<td><%=scmadvice.getsINTEREST()%></td>
												</tr>

												<tr>
													<td><b>Voyage</b></td>
													<td><%=scmadvice.getVoyage()%></td>
												</tr>

												<tr>
													<td><b>Loss Location</b></td>
													<td><%=scmadvice.getLossLocation()%></td>
												</tr>

												<tr>
													<td><b>Location/ Voyage of Risk</b></td>
													<td><%=scmadvice.getsLOC_VOYAGE()%>
												</tr>

												<tr>
													<td><b>XCR Claim Narrative</b></td>
													<td><%=scmadvice.getsCLM_NARR_LINE1()%>
												</tr>
												<tr>
													<td></td>
													<td><%=scmadvice.getsCLM_NARR_LINE2()%>
												</tr>
												<tr>
													<td></td>
													<td><%=scmadvice.getsCLM_NARR_LINE3()%>
												</tr>
												<tr>
													<td><b>SCM Claim Narrative</b></td>
													<td><%=scmadvice.getClaimNarrative()%></td>
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
													<td><b>CAT Code</b></td>
													<td><%=scmadvice.getCatCode()%></td>
													<td><b>PCS Cat</b></td>
													<td><%=scmadvice.getPcsCode()%></td>
												</tr>
											</table>

											<table class="custom">
												<tr>
													<td style="width:22%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
													<td style="width:6.5%"></td>
												</tr>
												<tr>
													<td><b>Cause Codes</b></td>
													<td><b>1</b></td>
                                                                                                        <td></td>
													<td><b>2</b></td>
                                                                                                        <td></td>
													<td><b>3</b></td>
                                                                                                        <td></td>
													<td><b>4</b></td>
                                                                                                        <td></td>
													<td><b>5</b></td>
                                                                                                        <td></td>
													<td><b>6</b></td>
                                                                                                        <td></td>
												</tr>
											</table>

											<table class="custom" border="0">
												<tr>
													<td style="width:23%"></td>
													<td style="width:27%"></td>
													<td style="width:20%"></td>
													<td style="width:30%"></td>
												</tr>

												<tr>
													<td><b>SCM Adjuster Code</b></td>
													<td><%=scmadvice.getAdjusterCode()%></td>
													<td><b>SCM Adjuster Ref</b></td>
													<td><%=scmadvice.getAdjusterRef()%></td>
												</tr>

												<tr>
													<td><b>SCM Adjuster Name</b></td>
													<td colspan="3"><%=scmadvice.getAdjusterName()%></td>
												</tr>

												<tr>
													<td><b>SCM Lawyer Code</b></td>
													<td><%=scmadvice.getLawyerCode()%></td>
													<td><b>SCM Lawyer Ref</b></td>
													<td><%=scmadvice.getLawyerRef()%></td>
												</tr>

												<tr>
													<td><b>SCM Lawyer Name</b></td>
													<td colspan="3"><%=scmadvice.getLawyerName()%></td>
												</tr>

												<tr>
													<td><b>Scheme Code</b></td>
													<td><%=scmadvice.getSchemeCode()%></td>
													<td><b>Coverholder Claim Ref</b></td>
													<td><%=scmadvice.getsCHOLDER_CLM_REF()%></td>
												</tr>
											</table> <!-- custom 4 -->

											<table class="custom">
												<tr>
													<td style="width:20%"></td>
													<td style="width:20%"></td>
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
													<td><b>XCS Recovery</b></td>
													<td><%=scmadvice.getXCSRecovery()%></td>
													<td><b>Finder Code</b></td>
													<td><b>1</b></td>
													<td><%=scmadvice.getFinderCode1()%></td>
													<td><b>2</b></td>
													<td><%=scmadvice.getFinderCode2()%></td>
													<td><b>3</b></td>
													<td><%=scmadvice.getFinderCode3()%></td>
													<td><b>LOC</b></td>
													<td><%=scmadvice.getHLoc()%></td>
												</tr>
											</table> <!-- Custom 11 -->
										</div>
									</td>
								</tr>
							</table>
							<!-- SCM Section 3 ends here -->

							<!-- SCM Section 4 starts here -->
							<div>
								<a name="financials"></a>
								<!-- Optional header information -->
								<table class="headerInfo" width="100%">
									<tr>
										<td style="width:12%"></td>
										<td style="width:38%"></td>
										<td style="width:12%"></td>
										<td style="width:38%"></td>
									</tr>
									<tr>
										<td><b>XCR:</b></td>
										<td><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,scmadvice.getHXcr())%></td>
										<td><b>Bkr UCR:</b></td>
										<td><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,scmadvice.getHUcr())%></td>
									</tr>
									</tr>
										<td><b>COR:</b></td>
										<td><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY,scmadvice.getHCor())%></td>
									  <td><b>Group Ref:</b></td>
										<td><%=HTMLUtils.createGroupRef("group ref", HTMLUtils.DISPLAY,scmadvice.getsGROUP_REF())%></td>
									</tr>
									<tr>
										<td><b>OSND:</b></td>
										<td><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY,scmadvice.getHOsnd())%></td>
										<td><b>AP Number</b></td>
										<td><%=scmadvice.getsAP_REF()%></td>
									</tr>
									<tr>
										<td><b>YOA</b></td>
										<td><%=scmadvice.getsYEAR_OF_ACC()%></td>
										<td><b>Peer Review:</b> </td>
										<td><%=scmadvice.getHPeerReview()%> </td>
									</tr>
								</table> <!-- headerInfo -->

								<table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
									<tr>
										<td align="center">
											<%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Policy Details","document.location=\"#policy\"")%>
										</td>
                                                                                <td align="center">
                                                                                        <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Market Details","document.location=\"#market\"")%>
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

							<%=HTMLUtils.createTitle("Financials")%>

							<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
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

												<tr>
													<td><b>Transaction Synopsis:</b></td>
													<td colspan="3"><%=scmadvice.getsSYNOPSIS_TEXT1()%></td>
												</tr>
												<tr>
													<td></td>
													<td colspan="3"><%=scmadvice.getsSYNOPSIS_TEXT2()%></td>
												</tr>
												<tr>
													<td></td>
													<td colspan="3"><%=scmadvice.getsSYNOPSIS_TEXT3()%></td>
												</tr>
												<tr>
													<td></td>
													<td colspan="3"><%=scmadvice.getsSYNOPSIS_TEXT4()%></td>
												</tr>

												<tr>
													<%-- <td><b>Peer Review</b></td>       <td><%=scmadvice.getHPeerReview()%> </td> --%>                                        
                          
                          <td><b>Payee Bkr:</b></td>
													<td><%=scmadvice.getHPayeeBkr()%></td>
												</tr>

												<tr>
													<td><b>TR:</b></td>
													<td colspan="3"><%=HTMLUtils.createUcr("tr", HTMLUtils.DISPLAY,scmadvice.getHTr())%></td>
												</tr>

												<tr>
													<td><b>Settlement Bkr Ref 1</b></td>
													<td><%=scmadvice.getBrokerClaimRef1()%></td>
													<td><b>Settlement Bkr Ref 2</b></td>
													<td><%=scmadvice.getBrokerClaimRef2()%></td>
												</tr>

											</table> <!-- custom 4 -->

											<table class="customfinancialdetail">
												<tr >
													<td style="width:12%"></td>
													<td   style="width:23%"></td>
													<td  style="width:11%"></td>
													<td  style="width:23%"></td>
													<td style="width:10%"></td>
													<td  style="width:22%"></td>
												</tr>

												<tr>
													<td><b>Orig Ccy</b></td>
													<td>
														<table border="0" cellpadding="0" cellspacing="0" width="100%">
															<tr>
																<td width="50%" style="padding-left:0px;">
																	<%=scmadvice.getOrigCcy()%>
																</td>
																<td>&nbsp;</td>
															</tr>
														</table>
													</td>
													<td><b>Sett Ccy</b></td>
													<td>
														<table border="0" cellpadding="0" cellspacing="0" width="100%">
															<tr>
																<td width="50%" style="padding-left:0px;">
																	<%=scmadvice.getSettCcy()%>
																</td>
																<td>&nbsp;</td>
															</tr>
														</table>
													</td>
													<td><b>Redenom Ind:</b></td>
													<td><%=scmadvice.getHRedenomInd()%></td>
												</tr>

												<!-- Commented out to avoid excessive scrolling - STH - 07/01/2004
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
													<td><b>Clm/ Ref/ Rec</b></td>
													<td>
														<table border="0" cellpadding="0" cellspacing="0" width="100%">
															<tr>
																<td width="50%" style="padding-left:0px;">
																<%=scmadvice.getClaimRefRec()%>
																</td>
																<td>&nbsp;</td>
															</tr>
														</table>
													</td>
													<td><b>O/S ROE</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatROE(scmadvice.getOsRateOfExch()))%></td>
												</tr>

												<tr>
													<td><b>PTD Loss</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTDLoss()))%></td>
													<td><b>PTT Loss</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTTLoss()))%></td>
													<td><b>O/S Loss</b></td>
													<td>
														<table border="0" width="100%" cellpadding="0" cellspacing="0">
															<tr>
																<td  style="padding-left:0px"><%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(scmadvice.getOsLoss()))%></td>
																<td  style="padding-left:0px">
																	<%=scmadvice.getOsLossQual()%>
																</td>
															</tr>
														</table>
													</td>
												</tr>

												<tr>
													<td><b>PTD Exp</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTDExp()))%></td>
													<td><b>PTT Exp</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTTExp()))%></td>
													<td><b>O/S Exp</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(scmadvice.getOsExp()))%></td>
												</tr>

												<tr>
													<td><b>PTD Fee</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTDFee()))%></td>
													<td><b>PTT Fee</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTTFee()))%></td>
													<td><b>O/S Fee</b></td>
													<td>
														<table border="0" width="100%" cellpadding="0" cellspacing="0">
															<tr>
																<td  style="padding-left:0px"><%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(scmadvice.getOsFee()))%></td>
																<td  style="padding-left:0px">
																	<%=scmadvice.getOsFeeQual()%>
																</td>
															</tr>
														</table>
													</td>
												</tr>

												<tr>
													<td><b>PTD Total</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTDTotal()))%></td>
													<td><b>PTT Total</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTTTotal()))%></td>
													<td><b>O/S Total</b></td>
													<td>
														<table border="0" width="100%" cellpadding="0" cellspacing="0">
															<tr>
																<td  style="padding-left:0px"><%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(scmadvice.getOsTotal()))%></td>
																<td  style="padding-left:0px">
																	<%=scmadvice.getOsTotalQual()%>
																</td>
															</tr>
														</table>
													</td>
												</tr>

												<tr>
													<td><b>PTD in Sett Ccy</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTDInSettCcy()))%></td>
													<td><b>Incurred</b><span class="compMarker"></span></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getIncurred()))%></td>
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
													<td><b>Highest Est</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getHighestEst()))%></td>
													<td><b>Sett ROE</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatROE(scmadvice.getSettRateOfExch()))%></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td><b>Settled in Sett Ccy</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getSettledRateInSettCcy()))%></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td><b>Total Line</b></td>
													<td><%=scmadvice.getTotalLine()%></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td><b>Bureau Ppn</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getBureauPpn()))%></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td><b>100% VAT Amt</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getVATAmount()))%><input type="hidden" name="vatAmount" value="<%=scmadvice.getVATAmount()%>"></td>
													<td colspan="2">
														<% if (!scmadvice.getVATRatesButtonFlag()) { %>
															<span class="link" onclick="vatRates()"><i>VAT Rates</i></span>
														<% } %>
													</td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td><b>War Amount</b></td>
													<td><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal( scmadvice.getWARAmount()))%></td>
													<td></td>
													<td></td>
												</tr>

												<tr>
													<td></td>
													<td></td>
													<td><b>TDN</b></td>
													<td colspan="2"><%=HTMLUtils.createTdn("",HTMLUtils.DISPLAY,scmadvice.getsTDN_REF())%></td>
													<td></td>
												</tr>
											</table> <!-- custom 6 -->

											<table class="custom" cellspacing="0">
												<tr>
													<td width="12%"></td>
													<td width="8%"></td>
													<td width="12%"></td>
													<td width="33%"></td>
													<td width="2%"></td>
													<td width="33%"></td>
												</tr>

												<tr>
													<td><b>Narrative Code</b></td>
													<td><%=scmadvice.getNarrativeCode1()%></td>
													<td><b>Current Narrative</b></td>
													<td colspan="3"><%=scmadvice.getNarrativeForSet()%></td>
												</tr>

												<tr>
													<td><b>Narrative Code</b></td>
													<td><%=scmadvice.getNarrativeCode2()%></td>
													<td></td>
													<td><%=scmadvice.getNarrativeForSet2()%></td>
													<td>&nbsp;</td>
													<td><%=scmadvice.getNarrativeForSet3()%></td>
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
													<td><b>Subrogation</b></td>
													<td><%=scmadvice.getSubrogation()%></td>
													<td><b>Attachments Ind</b></td>
													<td><%=scmadvice.getAttachmentsInd()%></td>
												</tr>

												<tr>
													<td><b>Mov't Ref/ Date:</b></td>
													<td><%=scmadvice.getHMvmtRefDate()%></td>
													<td><b>User ID:</b></td>
													<td><%=scmadvice.getsUSER_ID()%></td>
												</tr>

												<tr>
													<td><b>Charge Type:</b></td>
													<td colspan="3"><%=scmadvice.getsCHARGE_TYPE()%></td>
												</tr>

                                                                                                <tr>
                                                                                                        <td><b>Claim Opt Out Status:</b></td>
                                                                                                        <td><%=scmadvice.getClmOptOutStatus()%></td>
                                                                                                        <td><b>Claim Opt Out Date:</b></td>
                                                                                                        <td><%=scmadvice.getClmOptOutDate()%></td>
												</tr>
											</table> <!-- custom 4 -->
										</div>
									</td>
								</tr>
							</table>
							<!-- SCM Section 4 ends here -->
                                                        <br>
                                                        <%=HTMLUtils.createButton(HTMLUtils.ACTION,"re-advice"," submitForm(\"" + request.getContextPath() + "/control/createreadvice\")")%>
						</div> <!-- Content -->

						<div class="bot">
						</div> <!-- Bot -->
					</div> <!-- OuterWindow -->
				</td>
				<td></td>
			</tr>
		</table>
                <script>altColumnRows('marketdetails',1);</script>
	</form>
</span>
