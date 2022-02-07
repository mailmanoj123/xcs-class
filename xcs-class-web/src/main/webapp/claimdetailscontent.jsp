<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="claimDetails" type="com.xchanging.xcc.web.models.ClaimDetailsModel" scope="session" />
<jsp:useBean id="riskTypeList" type="com.xchanging.xcc.web.models.reference.RiskTypeList" scope="application" />
<jsp:useBean id="dcmQualList" type="com.xchanging.xcc.web.models.reference.DCMQualList" scope="application" />
<jsp:useBean id="dolQualList" type="com.xchanging.xcc.web.models.reference.DOLQualList" scope="application" />
<jsp:useBean id="catCodeList" type="com.xchanging.xcc.web.models.reference.CatCodeList" scope="application" />
<jsp:useBean id="pcsCodeList" type="com.xchanging.xcc.web.models.reference.PCSCodeList" scope="application" />
<jsp:useBean id="causeCodeList" type="com.xchanging.xcc.web.models.reference.CauseCodeList" scope="application" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script src="<%=request.getContextPath()%>/js/tabs.js"></script>

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/ifthen.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/claimdetailscontentCustom.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="claimdetailscontent" method="post">
<input type="submit" name="submitButton" style="display:none">
<input type="hidden" name="claimNarrative" value="<%=claimDetails.getClaimNarrative()%>">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Claim Details")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR014\")")%> -->
          </div>
        </div>
        <div class="menuBar">
		  <% if (!claimDetails.getSaveButtonFlag()) { %>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/claimdetailssave\")")%>
		  <% } %>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Continue","claimNarrativeFix(); submitForm(\"" + request.getContextPath() + "/control/claimdetailscontinue\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/claimdetailscancel\", false)")%>
        </div>
        <div class="content">
          <!-- Optional header information -->
          <div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("ucr1",HTMLUtils.DISPLAY,claimDetails.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("xcr1",HTMLUtils.DISPLAY,claimDetails.getXcr())%></td>
                <td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("tr1",HTMLUtils.DISPLAY,claimDetails.getTr())%></td>
              </tr>
              <tr>
                <td><b>OSND1:</b></td>
                <td><%=HTMLUtils.createOsnd("osnd1",HTMLUtils.DISPLAY,claimDetails.getOsnd1())%></td>
                <td><b>OSND2:</b></td>
                <td><%=HTMLUtils.createOsnd("osnd2",HTMLUtils.DISPLAY,claimDetails.getOsnd2())%></td>
                <td><b>OSND3:</b></td>
                <td><%=HTMLUtils.createOsnd("osnd3",HTMLUtils.DISPLAY,claimDetails.getOsnd3())%></td>
              </tr>
              <tr>
                <td><b>Peer Review:</b></td>
                <td><%=claimDetails.getPeerReview()%></td>
                <td><b>Current Bkr:</b></td>
                <td><%=claimDetails.getOrigBroker()%></td>
                <td><b>Classification:</b></td>
                <td><%=claimDetails.getBindClass()%></td>
              </tr>
            </table>
          </div>
          <!-- end of optional header information -->
          <table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
            <tr>
              <td align="center">
                <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"page one","showTab(1)")%>
              </td>
              <td align="center">
                <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"page two","showTab(2)")%>
              </td>
            </tr>
          </table>
          <br>
          <div id="tab1" style="display:none">
            <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
              <tr>
                <td valign="top" >
                  <div class="scrollmain" style="height:320px" id="scrollpane1">
                  <div class="scrollmaincontent">
                  <table width="100%" class="4column">
                  <tr>
                    <td>Bkr Contact<span class="compMarker">*</span></td>
                    <td>
                      <input type="text" name="bkrContact" value="<%=claimDetails.getBkrContact()%>" <%=claimDetails.getBkrContactFlag()%>>
                    </td>
                    <td>Bkr Phone No<span class="compMarker">*</span></td>
                    <td>
                      <input type="text" name="bkrPhoneNo" value="<%=claimDetails.getBkrPhoneNo()%>" <%=claimDetails.getBkrPhoneNoFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Bkr Claim Ref 1<span class="compMarker">*</span></td>
                    <td>
                      <input type="text" name="bkrClaimRef1" value="<%=claimDetails.getBkrClaimRef1()%>" <%=claimDetails.getBkrClaimRef1Flag()%>>
                    </td>
                    <td>Bkr Claim Ref 2</td>
                    <td>
                      <input type="text" name="bkrClaimRef2" value="<%=claimDetails.getBkrClaimRef2()%>" <%=claimDetails.getBkrClaimRef2Flag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Bkr UCR</td>
                    <td colspan="2">
                      <%=HTMLUtils.createUcr("bkrUcr",(claimDetails.getBkrUcrFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimDetails.getBkrUcr())%>
                    </td>
                  </tr>
                  <tr>
                    <td>Orig Insured</td>
                    <td colspan="3">
                      <input type="text" name="origInsured" value="<%=claimDetails.getOrigInsured()%>" <%=claimDetails.getBkrOrigInsuredFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Insured</td>
                    <td colspan="3">
                      <input type="text" name="insured" value="<%=claimDetails.getInsured()%>" <%=claimDetails.getInsuredFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Reinsured</td>
                    <td colspan="3">
                      <input type="text" name="reinsured" value="<%=claimDetails.getReinsured()%>" <%=claimDetails.getReinsuredFlag()%>>                    </td>
                  </tr>
                  <tr>
                    <td>Coverholder</td>
                    <td colspan="3">
                      <input type="text" name="coverholder" value="<%=claimDetails.getCoverholder()%>" <%=claimDetails.getCoverholderFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Claimant</td>
                    <td colspan="3">
                      <input type="text" name="claimant" value="<%=claimDetails.getClaimant()%>" <%=claimDetails.getClaimantFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Vessel / Aircraft / Conveyance</td>
                    <td colspan="3">
                      <input type="text" name="vesselAircraft" value="<%=claimDetails.getVesselAircraft()%>" <%=claimDetails.getVesselAircraftFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Loss Name</td>
                    <td colspan="3">
                      <input type="text" name="lossName" value="<%=claimDetails.getLossName()%>" <%=claimDetails.getLossNameFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Other Name</td>
                    <td colspan="3">
                      <input type="text" name="otherName" value="<%=claimDetails.getOtherName()%>" <%=claimDetails.getOtherNameFlag()%>>
                    </td>
                  </tr>
                </table>
                <table width="100%" class="custom">
                  <tr>
                    <td style="width:13%"></td>
                    <td style="width:23%"></td>
                    <td style="width:13%"></td>
                    <td style="width:23%"></td>
                    <td style="width:13%"></td>
                    <td style="width:15%"></td>
                  </tr>
                  <tr>
                    <td>DOL From</td>
                    <td>
                      <%=HTMLUtils.createDate("dolFrom",(claimDetails.getDolFromFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimDetails.getDolFrom())%>
                    </td>
                    <td>DOL To</td>
                    <td>
                      <%=HTMLUtils.createDate("dolTo",(claimDetails.getDolToFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimDetails.getDolTo())%>
                    </td>
                    <td>DOL Qual</td>
                    <td>
                      <%=HTMLUtils.createDropdown("dolQual",claimDetails.getDolQual(),claimDetails.getDolQualFlag(),dolQualList)%>
                    </td>
                  </tr>
                  <tr>
                    <td>DCM/DOD From</td>
                    <td>
                      <%=HTMLUtils.createDate("dcmFrom",(claimDetails.getDcmFromFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimDetails.getDcmFrom())%>
                    </td>
                    <td>DCM/DOD To</td>
                    <td>
                      <%=HTMLUtils.createDate("dcmTo",(claimDetails.getDcmToFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimDetails.getDcmTo())%>
                    </td>
                    <td>DCM/DOD Qual</td>
                    <td>
                      <%=HTMLUtils.createDropdown("dcmQual",claimDetails.getDcmQual(),claimDetails.getDcmQualFlag(),dcmQualList)%>
                    </td>
                  </tr>
                </table>
                </div>
                </div>
                </td>
              </tr>
            </table>
          </div>
          <div id="tab2" style="display:none">
            <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
              <tr>
                <td valign="top" >
                  <div class="scrollmain" style="height:320px" id="scrollpane2">
                  <div class="scrollmaincontent">
                  <table class="4column" border="0">
                  <tr>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                  </tr>
                  <tr>
                    <td>Loss Date Narrative</td>
                    <td colspan="3">
                      <input type="text" name="dolNarrative" value="<%=claimDetails.getDolNarrative()%>" <%=claimDetails.getDolNarrativeFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Loss Location</td>
                    <td colspan="3">
                      <input type="text" name="lossLocation" value="<%=claimDetails.getLossLocation()%>" <%=claimDetails.getLossLocationFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td>Voyage</td>
                    <td colspan="3">
                      <input type="text" name="voyage" value="<%=claimDetails.getVoyage()%>" <%=claimDetails.getVoyageFlag()%>>
                    </td>
                  </tr>
                  <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                </table>
                  <table class="6column">
                    <tr>
                    <td style="width:17%"></td>
                    <td style="width:17%"></td>
                    <td style="width:17%"></td>
                    <td style="width:17%"></td>
                    <td style="width:17%"></td>
                    <td style="width:17%"></td>
                    </tr>
                  <tr>
                    <td>CAT Code</td>
                    <td>
                      <%=HTMLUtils.createDropdown("catCode",claimDetails.getCatCode(),claimDetails.getCatCodeFlag(),catCodeList)%>
                    </td>
                    <td>PCS Cat</td>
                    <td>
                      <%=HTMLUtils.createDropdown("pcsCat",claimDetails.getPcsCat(),claimDetails.getPcsCatFlag(),pcsCodeList)%>
                    </td>
                    <td>Claim/Risk Type</td>
                    <td>
                      <%=HTMLUtils.createDropdown("claimRiskType",claimDetails.getClaimRiskType(),claimDetails.getClaimRiskTypeFlag(),riskTypeList)%>
                    </td>
                  </tr>
                </table>
                <table class="4column">
                  <tr>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                  </tr>
                  <tr>
                    <td>Claim Narrative<span class="compMarker">*</span></td>
                    <td colspan="3">
                      <textarea name="claimNarr" wrap="hard" style="width:auto;font-family:courier" cols="50" rows="3" <%=claimDetails.getClaimNarrativeFlag()%> onChange="claimNarrativeFix()"><%=claimDetails.getClaimNarrative()%></textarea>
                    </td>
                  </tr>
                  <!-- clintonj [SIR 37546] [10/03/2004]
                         Changed Adjuster drop down list to be a protected input field   -->
                  <% // Adjuster Surv Name
                    if(claimDetails.getC034_ADJ_NAME_ATTR().equals("P")) {  %>
                  <tr>
                    <td>Adj/Surveyor Name</td>
                    <td colspan="3">                                                       
                          <input type="text" value="<%=claimDetails.getAdjSurvName()%>" class="fieldProtect" readonly="true">
                          <input type="hidden" name="adjSurvName" value="<%=claimDetails.getAdjSurvName()%>">                         
                    </td>
                  </tr>                  
                  <% } else { %>                         
                         <input type="hidden" name="adjSurvName" value="" class="fieldProtect">
                  <% } %>
                  
                  <% // Lawyer Name
                     if(claimDetails.getC034_LAW_NAME_ATTR().equals("P")) {  %>
                  <tr>
                    <td>Lawyer Name</td>
                    <td colspan="3">                   
                        <input type="text" value="<%=claimDetails.getLawyerName()%>" class="fieldProtect" readonly="true">
                        <input type="hidden" name="lawyerName" value="<%=claimDetails.getLawyerName()%>">                      
                    </td>
                  </tr>
                  <% } else { %>                         
                         <input type="hidden" name="lawyerName" value="" class="fieldProtect">   
                   <% } %>
                   
                  <tr>
                    <% // Adjuster/Surv Ref
                     if(claimDetails.getC034_ADJ_REF_ATTR().equals("P")) {  %> 
                    <td>Adj/Surveyor Ref</td>
                    <td>
                      <input name="adjSurvRef" class="fieldProtect" type="text" value="<%=claimDetails.getAdjSurvRef()%>" <%=claimDetails.getAdjSurvRefFlag()%>>
                    </td>
                    <% } else { %>                    
                    <td></td>
                    <td>
                      <input name="adjSurvRef" type="hidden" value="" class="fieldProtect">
                    </td>
                    <% } %>
                    
                    <% // Lawyer Ref
                        if(claimDetails.getC034_LAW_REF_ATTR().equals("P")) {  %>                     
                    <td>Lawyer Ref</td>
                    <td>
                      <input name="lawyerRef" class="fieldProtect" type="text" value="<%=claimDetails.getLawyerRef()%>" <%=claimDetails.getLawyerRefFlag()%>>
                    </td>
                    <% } else { %>                    
                    <td></td>
                    <td>
                      <input name="lawyerRef" class="fieldProtect" type="hidden" value="">
                    </td>
                    <% } %>
                  </tr>
                </table>
                <table width="100%" border="0" class="4column">
                  <tr>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                    <td style="width:25%"></td>
                  </tr>
                  <tr>
                    <td colspan="4">
                      <table width="100%" border="0" class="12column">
                        <tr>                 
                        <!-- TP871424 Changes for quality validation -->
						  <td colspan="3">Cause Code<span class="compMarker">*</span></td>
                          <td colspan="8" style="padding-left:0px;">
                             <%=HTMLUtils.createDropdown("causeCode",claimDetails.getCauseCode(),claimDetails.getCauseCodeFlag(),causeCodeList)%>
                          </td>
                        </tr>
                      </table>
                      <table width="100%" border="0" class="12column">
                        <tr>
                          <td colspan="4">Cover Holder Clm Ref</td>
                          <td style ="width:1%"></td>
                          <td colspan="2">
                             <input type="text" name="chClmRef" value="<%=claimDetails.getChClmRef()%>" <%=claimDetails.getChClmRefFlag()%>>
                          </td>
                          <td colspan="5"></td>
                        </tr>
                        <tr>
                          <td colspan="4">Certificate of Insurance No(s)</td>
                          <td style ="width:1%">1</td>
                          <td colspan="2">
                            <input type="text" name="certInsNo1" id="certInsNo1" value ="<%=claimDetails.getCertInsNo1()%>" <%=claimDetails.getCertInsNo1Flag()%>>
                          </td>
                          <td colspan="5"></td>
                        </tr>
                        <tr>
                          <td colspan="4"></td>
                          <td style ="width:1%">2</td>
                          <td colspan="2">
                             <input type="text" name="certInsNo2" id="certInsNo2" value ="<%=claimDetails.getCertInsNo2()%>" <%=claimDetails.getCertInsNo2Flag()%>>
                          </td>
                          <td colspan="5"></td>                          
                        </tr>
                        <tr>
                          <td colspan="4"></td>
                          <td style ="width:1%">3</td>
                          <td colspan="2">
                             <input type="text" name="certInsNo3" id="certInsNo3" value ="<%=claimDetails.getCertInsNo3()%>" <%=claimDetails.getCertInsNo3Flag()%>>
                          </td>
                          <td colspan="5"></td>
                        </tr>
                        <tr>
                          <td colspan="4"></td>
                          <td style ="width:1%">4</td>
                          <td colspan="2">
                             <input type="text" name="certInsNo4" id="certInsNo4" value ="<%=claimDetails.getCertInsNo4()%>" <%=claimDetails.getCertInsNo4Flag()%>>
                          </td>
                          <td colspan="5"></td>
                        </tr>
                        <tr>
                          <td colspan="4"></td>
                          <td style ="width:1%">5</td>
                          <td colspan="2">
                             <input type="text" name="certInsNo5" id="certInsNo5" value ="<%=claimDetails.getCertInsNo5()%>" <%=claimDetails.getCertInsNo5Flag()%>>
                          </td>
                          <td colspan="5"></td>
                        </tr>

                      </table>
                    </td>
                  </tr>
                  <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                </table>
                </div>
                </div>
                </td>
              </tr>
            </table>
          </div>
          <!-- show tab -->
          <script>showTab(1)</script>
          <!-- end of tabbed page -->
        </div>
        <div class="bot"></div>
      </div>
    </td>
    <td></td>
  </tr>
</form>
<% if (user.updateMode()) { %>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/claimdetailscontent.js"></script>
<% } %>
<script>claimNarrativeFix();</script>
</table>
</span>
