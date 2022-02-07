<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*,com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="ccvcquestionnaire" type="com.xchanging.xcc.web.models.CCVCQuestionnaireModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script language="JavaScript" src="<%=request.getContextPath()%>/js/debug.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/error.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/messagelist.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/positionlayer.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vfield.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vform.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vtab.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/VGroup.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphavalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/booleanentered.js"></script> 

<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/alphaextendedvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/numericvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/decimalvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/datevalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/comparator.js'></script>

<script language='JavaScript' src ='<%=request.getContextPath()%>/js/screen/ccvcquestionnairecontentcustom.js'></script>

<script src='<%=request.getContextPath()%>/js/tabs.js'></script>


<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
	<form name="ccvcquestionnairecontent">
		<input type="submit" name="submitButton" style="display:none">
		<table class="formCenter">
			<tr>
				<td></td>
				<td class="content">
					<div class="outerWindow">
						<div class="top">
							<div class="header">
								<%=HTMLUtils.createHeader("CCVC Questionnaire")%>
								<!-- Below help button is no longer required since the information displayed is out of date -->
								<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"CCVCQEUSTIONNAIRE\")")%> -->
							</div>
						</div> 

						<div class="menuBar">
							<!-- MENU BUTTONS GO HERE -->
<%
							if(ccvcquestionnaire.getSCREEN_MODE()!=null && ccvcquestionnaire.getSCREEN_MODE().trim().equalsIgnoreCase("U"))
							{
%>
								<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/ccvcquestionnaireok\")")%>
								<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/ccvcquestionnairecancel\",false)")%>
								<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Reset Form","resetForm();")%>
<%
							}
							else
							{
%>
								<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/ccvcquestionnairecancel\",false)")%>
<%
							}
%>
							
						</div> <!--Menu Bar-->
					
						<div class="content">
							<div>
								<table class="headerInfo" width="100%" border="0" cellpadding="2" cellspacing="2" >
									<tr>
										<td style="width:8%"></td>
										<td style="width:25.3%"></td>
										<td style="width:8%"></td>
										<td style="width:25.3%"></td>
										<td style="width:8%"></td>
										<td style="width:25.3%"></td>
									</tr>
									<tr>
										<td style="width:8%"><b>UCR:</b></td>
										<td style="width:25.3%"><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,ccvcquestionnaire.getUCR())%></td>
										<td style="width:8%"><b>XCR:</b></td>
										<td style="width:25.3%"><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,ccvcquestionnaire.getXCR())%></td>
										<td style="width:8%"><b>TR:</b></td>
										<td style="width:25.3%"><%=HTMLUtils.createUcr("tr", HTMLUtils.DISPLAY,ccvcquestionnaire.getTR())%></td>
									</tr>
									<tr>
										<td style="width:8%"><b>OSND1:</b></td>
										<td style="width:25.3%"><%=HTMLUtils.createOsnd("osnd1", HTMLUtils.DISPLAY,ccvcquestionnaire.getORIG_REF_1())%></td>
										<td style="width:8%"><b>OSND2:</b></td>
										<td style="width:25.3%"><%=HTMLUtils.createOsnd("osnd2", HTMLUtils.DISPLAY,ccvcquestionnaire.getORIG_REF_2())%></td>
										<td style="width:8%"><b>OSND3:</b></td>
										<td style="width:25.3%"><%=HTMLUtils.createOsnd("osnd3", HTMLUtils.DISPLAY,ccvcquestionnaire.getORIG_REF_3())%></td>
									</tr>
									<tr>
										<td colspan="2"><b>Peer Review:</b> &nbsp; <%=ccvcquestionnaire.getPEER_REV_IND() %></td>
										<td colspan="4"><b>Current Bkr:</b> &nbsp; <%=ccvcquestionnaire.getORIG_BKR() %></td>
									</tr>
									<tr>
										<td colspan="2"><b>Payee Bkr:</b> &nbsp; <%=ccvcquestionnaire.getPAYEE_BKR() %></td>
										<td colspan="4"><b>Paid By Cheque:</b> &nbsp; <%=ccvcquestionnaire.getPAID_BY_CHEQUE() %></td>
									</tr>
								</table>
							</div>
							<br>
							<!-- CCVC Data Section 1 starts here -->
			                <table  border='0' cellpadding='0' cellspacing='0' class='formHeading' >
								<tr>
									<td class='left'>&nbsp;</td>
									<td class='middle' nowrap>CCVC Data</td>
									<td class='right'>&nbsp;</td>
								</tr>
							</table>

							<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
								<tr>
									<td valign="top" >
										<div class="noscroll">
											<table class="custom" border="0" cellpadding="5" cellspacing="3">
												<tr>
													<td style="width:35%">Broker Presentation Date</td>
													<td style="width:25%"><%=HTMLUtils.createDate("BKR_PRES_DATE",(ccvcquestionnaire.getBKR_DATE_ATTR()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,ccvcquestionnaire.getBKR_PRES_DATE())%></td>
													<td colspan="2">&nbsp;</td>
												</tr>

												<tr>
													<td style="width:35%">Leader Presentation Date</td>
													<td style="width:25%"><%=HTMLUtils.createDate("LDR_PRES_DATE",(ccvcquestionnaire.getLDR_DATE_ATTR()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,ccvcquestionnaire.getLDR_PRES_DATE())%></td>
													<td colspan="2">&nbsp;</td>
												</tr>

												<tr>
													<td colspan="2">Is Lloyd's Lead the Overall Lead ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="LLOYDS_LEAD_IND" id="LLOYDS_LEAD_IND" value="Y" <%= (ccvcquestionnaire.getLLOYDS_LEAD_IND()!=null && ccvcquestionnaire.getLLOYDS_LEAD_IND().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getSY_LEAD_ATTR() %>>Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="LLOYDS_LEAD_IND" id="LLOYDS_LEAD_IND" value="N" <%= (ccvcquestionnaire.getLLOYDS_LEAD_IND()!=null && ccvcquestionnaire.getLLOYDS_LEAD_IND().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getSY_LEAD_ATTR() %>>No
													</td>
												</tr>

												<tr>
													<td colspan ="2">Is this claim part of a Bordereaux, a Recovery or a Coverage/Defence Fee Settlement or has the issue of coverage not yet been determined on this claim ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="BORD_IND" id="BORD_IND" value="Y" onclick = "changeSubs5QuesNA(this);"  <%= (ccvcquestionnaire.getBORD_IND()!=null && ccvcquestionnaire.getBORD_IND().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getBORD_IND_ATTR() %>>Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="BORD_IND" id="BORD_IND" value="N"  <%= (ccvcquestionnaire.getBORD_IND()!=null && ccvcquestionnaire.getBORD_IND().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getBORD_IND_ATTR() %>>No
													</td>
												</tr>
											</table> <!-- custom -->
										</div> <!-- noscroll -->
									</td>
								</tr>
							</table> <!-- mainContent -->
							<br>
							<!-- Claims Coverage Validation Check Section 2 starts here...-->
							<table  border='0' cellpadding='0' cellspacing='0' class='formHeading' >
								<tr>
									<td class='left'>&nbsp;</td>
									<td class='middle' nowrap> Claims Coverage Validation Check</td>
									<td class='right'>&nbsp;</td>
								</tr>
							</table>

							<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
								<tr>
									<td valign="top" >
										<div class="noscroll">
											<table class="custom" border="0" cellpadding="5" cellspacing="3">
												<tr>
													<td colspan ="2" style="width:60%">Is the Date of Loss / Date Claim Made within Policy/Cert Period ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="DOL_IN_POL_Q" id="DOL_IN_POL_Q" value="Y" <%= (ccvcquestionnaire.getDOL_IN_POL_Q()!=null && ccvcquestionnaire.getDOL_IN_POL_Q().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getDOL_IN_POL_ATTR() %> >Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="DOL_IN_POL_Q" id="DOL_IN_POL_Q" value="N" <%= (ccvcquestionnaire.getDOL_IN_POL_Q()!=null && ccvcquestionnaire.getDOL_IN_POL_Q().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getDOL_IN_POL_ATTR() %> >No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="DOL_IN_POL_Q" id="DOL_IN_POL_Q" value="X" <%= (ccvcquestionnaire.getDOL_IN_POL_Q()!=null && ccvcquestionnaire.getDOL_IN_POL_Q().trim().equalsIgnoreCase("X"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getDOL_IN_POL_ATTR() %> >N/A
													</td>
												</tr>
												<tr>
													<td colspan ="2" style="width:60%">Is the claim within available Policy/Cert Limits ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="CLAIM_IN_POL_Q" id="CLAIM_IN_POL_Q" value="Y" <%= (ccvcquestionnaire.getCLAIM_IN_POL_Q()!=null && ccvcquestionnaire.getCLAIM_IN_POL_Q().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCLM_IN_POL_ATTR() %> >Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="CLAIM_IN_POL_Q" id="CLAIM_IN_POL_Q" value="N" <%= (ccvcquestionnaire.getCLAIM_IN_POL_Q()!=null && ccvcquestionnaire.getCLAIM_IN_POL_Q().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCLM_IN_POL_ATTR() %> >No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="CLAIM_IN_POL_Q" id="CLAIM_IN_POL_Q" value="X" <%= (ccvcquestionnaire.getCLAIM_IN_POL_Q()!=null && ccvcquestionnaire.getCLAIM_IN_POL_Q().trim().equalsIgnoreCase("X"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCLM_IN_POL_ATTR() %> >N/A
													</td>
												</tr>
												<tr>
													<td colspan ="2" style="width:60%">Is the identity of the Coverholder/Insured/Reinsured/Cedant correct ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="CORRECT_IDENT_Q" id="CORRECT_IDENT_Q" value="Y" <%= (ccvcquestionnaire.getCORRECT_IDENT_Q()!=null && ccvcquestionnaire.getCORRECT_IDENT_Q().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCORRECT_ID_ATTR() %> >Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="CORRECT_IDENT_Q" id="CORRECT_IDENT_Q" value="N" <%= (ccvcquestionnaire.getCORRECT_IDENT_Q()!=null && ccvcquestionnaire.getCORRECT_IDENT_Q().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCORRECT_ID_ATTR() %> >No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="CORRECT_IDENT_Q" id="CORRECT_IDENT_Q" value="X" <%= (ccvcquestionnaire.getCORRECT_IDENT_Q()!=null && ccvcquestionnaire.getCORRECT_IDENT_Q().trim().equalsIgnoreCase("X"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCORRECT_ID_ATTR() %> >N/A
													</td>
												</tr>
												<tr>
													<td colspan ="2" style="width:60%">Has the correct Deductible/Excess been applied ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="DEDUCT_EXCESS_Q" id="DEDUCT_EXCESS_Q" value="Y" <%= (ccvcquestionnaire.getDEDUCT_EXCESS_Q()!=null && ccvcquestionnaire.getDEDUCT_EXCESS_Q().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getDEDUCT_EX_ATTR() %> >Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="DEDUCT_EXCESS_Q" id="DEDUCT_EXCESS_Q" value="N" <%= (ccvcquestionnaire.getDEDUCT_EXCESS_Q()!=null && ccvcquestionnaire.getDEDUCT_EXCESS_Q().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getDEDUCT_EX_ATTR() %> >No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="DEDUCT_EXCESS_Q" id="DEDUCT_EXCESS_Q" value="X" <%= (ccvcquestionnaire.getDEDUCT_EXCESS_Q()!=null && ccvcquestionnaire.getDEDUCT_EXCESS_Q().trim().equalsIgnoreCase("X"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getDEDUCT_EX_ATTR() %> >N/A
													</td>
												</tr>
												<tr>
													<td colspan ="2" style="width:60%">Does the type of coverage match the claim ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="COVERAGE_Q" id="COVERAGE_Q" value="Y" <%= (ccvcquestionnaire.getCOVERAGE_Q()!=null && ccvcquestionnaire.getCOVERAGE_Q().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCOVERAGE_ATTR() %> >Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="COVERAGE_Q" id="COVERAGE_Q" value="N" <%= (ccvcquestionnaire.getCOVERAGE_Q()!=null && ccvcquestionnaire.getCOVERAGE_Q().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCOVERAGE_ATTR() %> >No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="COVERAGE_Q" id="COVERAGE_Q" value="X" <%= (ccvcquestionnaire.getCOVERAGE_Q()!=null && ccvcquestionnaire.getCOVERAGE_Q().trim().equalsIgnoreCase("X"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCOVERAGE_ATTR() %> >N/A
													</td>
												</tr>
												<tr>
													<td colspan ="2" style="width:60%">Cause Code ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="CAUSE_CODE_Q" id="CAUSE_CODE_Q" value="Y" <%= (ccvcquestionnaire.getCAUSE_CODE_Q()!=null && ccvcquestionnaire.getCAUSE_CODE_Q().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCAUSE_CODE_ATTR() %> >Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="CAUSE_CODE_Q" id="CAUSE_CODE_Q" value="N" <%= (ccvcquestionnaire.getCAUSE_CODE_Q()!=null && ccvcquestionnaire.getCAUSE_CODE_Q().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCAUSE_CODE_ATTR() %> >No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="CAUSE_CODE_Q" id="CAUSE_CODE_Q" value="X" <%= (ccvcquestionnaire.getCAUSE_CODE_Q()!=null && ccvcquestionnaire.getCAUSE_CODE_Q().trim().equalsIgnoreCase("X"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getCAUSE_CODE_ATTR() %> >N/A
													</td>
												</tr>
												<tr>
													<td colspan ="2" style="width:60%">Has the leader clearly provided agreement to settle ?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="LEAD_AGREEMENT_Q" id="LEAD_AGREEMENT_Q" value="Y" <%= (ccvcquestionnaire.getLEAD_AGREEMENT_Q()!=null && ccvcquestionnaire.getLEAD_AGREEMENT_Q().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getLEAD_AGREE_ATTR() %> >Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="LEAD_AGREEMENT_Q" id="LEAD_AGREEMENT_Q" value="N" <%= (ccvcquestionnaire.getLEAD_AGREEMENT_Q()!=null && ccvcquestionnaire.getLEAD_AGREEMENT_Q().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getLEAD_AGREE_ATTR() %> >No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="LEAD_AGREEMENT_Q" id="LEAD_AGREEMENT_Q" value="X" <%= (ccvcquestionnaire.getLEAD_AGREEMENT_Q()!=null && ccvcquestionnaire.getLEAD_AGREEMENT_Q().trim().equalsIgnoreCase("X"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getLEAD_AGREE_ATTR() %> >N/A
													</td>
												</tr>
												<tr>
													<td colspan ="2" style="width:60%">If this is a Special Category claim, have all of the agreement parties clearly indicated their agreement to settle?<span style="color:red">*</span></td>
													<td colspan ="2">
														<input type="radio" name="MKT_AGREEMENT_Q" id="MKT_AGREEMENT_Q" value="Y" <%= (ccvcquestionnaire.getMKT_AGREEMENT_Q()!=null && ccvcquestionnaire.getMKT_AGREEMENT_Q().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getMKT_AGREE_ATTR() %> >Yes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="MKT_AGREEMENT_Q" id="MKT_AGREEMENT_Q" value="N" <%= (ccvcquestionnaire.getMKT_AGREEMENT_Q()!=null && ccvcquestionnaire.getMKT_AGREEMENT_Q().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getMKT_AGREE_ATTR() %> >No &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<input type="radio" name="MKT_AGREEMENT_Q" id="MKT_AGREEMENT_Q" value="X" <%= (ccvcquestionnaire.getMKT_AGREEMENT_Q()!=null && ccvcquestionnaire.getMKT_AGREEMENT_Q().trim().equalsIgnoreCase("X"))?"checked":"" %> style="width:20px" <%=ccvcquestionnaire.getMKT_AGREE_ATTR() %> >N/A
													</td>
												</tr>
											</table>
										</div> <!-- noscroll -->
									</td>
								</tr>
							</table> <!-- mainContent -->

							<br>
							<!-- Claims Documents Sighted Section 3 starts-->
							<table  border='0' cellpadding='0' cellspacing='0' class='formHeading' >
								<tr>
									<td class='left'>&nbsp;</td>
									<td class='middle' nowrap>Claims Documents Sighted</td>
									<td class='right'>&nbsp;</td>
								</tr>
							</table>

							<table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
								<tr>
									<td valign="top" >
										<div class="noscroll">
											<table class="custom" cellpadding="5" cellspacing="3">
												<tr>
													<td><input type="checkbox" name="POLICY_DOC_IND" id="POLICY_DOC_IND" style="width:20px" <%=ccvcquestionnaire.getPOLICY_DOC_IND() %> <%=ccvcquestionnaire.getPOLICY_DOC_ATTR() %> > Policy</td>
													<td><input type="checkbox" name="SLIP_DOC_IND"   id="SLIP_DOC_IND"   style="width:20px" <%=ccvcquestionnaire.getSLIP_DOC_IND() %> <%=ccvcquestionnaire.getSLIP_DOC_ATTR() %> > Slip</td>
													<td><input type="checkbox" name="COVER_DOC_IND" id="COVER_DOC_IND"   style="width:20px" <%=ccvcquestionnaire.getCOVER_DOC_IND() %> <%=ccvcquestionnaire.getCOVER_DOC_ATTR() %> > Cover Notes</td>
												</tr>
												<tr>
													<td><input type="checkbox" name="LOSS_DETS_DOC_IND" id="LOSS_DETS_DOC_IND" style="width:20px" <%=ccvcquestionnaire.getLOSS_DETS_DOC_IND() %> <%=ccvcquestionnaire.getLOSS_DETS_ATTR() %> > Preliminary Loss Details</td>
													<td colspan ="2"><input type="checkbox" name="OTHER_DOC_IND" id="OTHER_DOC_IND"  style="width:20px" <%=ccvcquestionnaire.getOTHER_DOC_IND() %> <%=ccvcquestionnaire.getOTHER_DOC_ATTR() %> > Other</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
							<!-- Section 3 ends here -->

						</div> <!-- Content -->

						<div class="bot">
						</div> <!-- Bot -->
					</div> <!-- OuterWindow -->
				</td>
				<td></td>
			</tr>
		</table>
		<script language="JavaScript" src="<%=request.getContextPath()%>/js/screen/ccvcquestionnairecontent.js"></script>    
	</form>
</span>
