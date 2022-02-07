<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="policyrisk" type="com.xchanging.xcc.web.models.PolicyRiskDetailsModel" scope="session" />
<jsp:useBean id="marketList" type="com.xchanging.xcc.web.models.reference.MarketList" scope="application" />
<jsp:useBean id="basisOfLimitList" type="com.xchanging.xcc.web.models.reference.BasisOfLimitList" scope="application" />
<jsp:useBean id="coverLineslipQualList" type="com.xchanging.xcc.web.models.reference.CoverLineslipQualList" scope="application" />
<jsp:useBean id="polCertQualList" type="com.xchanging.xcc.web.models.reference.PolCertQualList" scope="application" />
<jsp:useBean id="peerReviewList" type="com.xchanging.xcc.web.models.reference.PeerReviewList" scope="application" />
<jsp:useBean id="brokerCodeList" type="com.xchanging.xcc.web.models.reference.BrokerList" scope="application" />
<jsp:useBean id="currencyCodeList" type="com.xchanging.xcc.web.models.reference.CurrencyCodeList" scope="application" />
<jsp:useBean id="slipTypeList" type="com.xchanging.xcc.web.models.reference.SlipTypeList" scope="application" />

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/genericregexvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/restrictednumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/decimalvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/booleanentered.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/policyriskdetailscontentCustom.js"></script>


<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="policyriskdetailscontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Policy/Risk Details")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR012\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
		  <% if (!policyrisk.getSaveButtonFlag()) { %>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","submitForm(\"" + request.getContextPath() + "/control/policyriskdetailssave\")")%>
		  <% } %>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Continue","submitForm(\"" + request.getContextPath() + "/control/policyriskdetailscontinue\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/policyriskdetailscancel\", false)")%>

        </div>
        <div class="content">
        <div>
          <table class="headerInfo" width="100%">
            <tr>
            <td><b>UCR:</b></td>
            <td><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY,policyrisk.getUcr())%></td>
            <td><b>XCR:</b></td>
            <td><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY,policyrisk.getXcr())%></td>
            <td><b>TR:</b></td>
            <td><%=HTMLUtils.createUcr("tr", HTMLUtils.DISPLAY,policyrisk.getTr())%></td>
            </tr>
            <tr>
            <td><b>OSND1:</b></td>
            <td><%=HTMLUtils.createOsnd("osnd1", HTMLUtils.DISPLAY,policyrisk.getOsnd1())%></td>
            <td><b>OSND2:</b></td>
            <td><%=HTMLUtils.createOsnd("osnd2", HTMLUtils.DISPLAY,policyrisk.getOsnd2())%></td>
            <td><b>OSND3:</b></td>
            <td><%=HTMLUtils.createOsnd("osnd3", HTMLUtils.DISPLAY,policyrisk.getOsnd3())%></td>
            </tr>
          </table>
          </div>
          <br>
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent">
            <tr>
              <td valign="top" >
                <div class="scrollmain" style="height:368px" id="scrollpane">
                  <div class="scrollmaincontent">
                     <table width="100%" class="custom">
                     <tr width="100%">
                         <td style="width:16%;"></td>
                         <td style="width:9%;PADDING-LEFT:4px;PADDING-RIGHT:10px;"></td>
                         <td style="width:17%; PADDING-LEFT:22px;PADDING-RIGHT:0px;"></td>
                         <td style="width:10%;"></td>
                         
                         <td style="width:17%;"></td>
                         <td style="width:10%;"></td>
                         <td style="width:10%;"></td>
                         <td style="width:13%;"></td>
                             
                      </tr>
                      <tr >
                        
                      	<td style="width:16%;" >Peer Review<span class="compMarker">*</span></td>
                        <td style="width:9%;PADDING-LEFT:4px;PADDING-RIGHT:5px;" > 
                        
                          	<%=HTMLUtils.createDropdown("peerReview",policyrisk.getPeerReview(),policyrisk.getPeerReviewFlag(),peerReviewList)%>
                        
                        </td>
                        
                        
                        <td style="width:17%;PADDING-LEFT:22px;PADDING-RIGHT:0px;">Risk Code<span class="compMarker">*</span></td>
                        <td style="width:10%;"><input type="text" name="riskCode" value="<%=policyrisk.getRiskCode()%>" <%=policyrisk.getRiskCodeFlag()%>></td>

                        <!-- CCN #30 - BA - 7/1/2002 -->
                        <td style="width:15%;">Market Code<span class="compMarker">*</span></td>
                        <td style="width:10%;">
                            <%=HTMLUtils.createDropdown("marketCode",policyrisk.getMarketCode(),policyrisk.getMktCodeFlag(),marketList)%>
                        </td>
                        <td style="width:13%;">YOA<span class="compMarker">*</span></td>
                        <td style="width:10%;"><input type="text" name="yoa" value="<%=policyrisk.getYoa()%>" <%=policyrisk.getYoaFlag()%>></td>
                      </tr>
                    </table>
                     <table width="100%" class="custom">
                     <tr width="100%">
                         <td style="width:15%;"></td>
                         <td style="width:12%;"></td>
                         <td style="width:15%;"></td>
                         <td style="width:10%;PADDING-LEFT:10px;"></td>
                         
                         <td style="width:17%;"></td>
                         <td style="width:10%;"></td>
                         <td style="width:10%;"></td>
                         <td style="width:13%;"></td>
                             
                      </tr>
                      <tr>
	                      <td style="width:15%;">Current Bkr<span class="compMarker">*</span></td>
	                      <td style="width:12%;">
<% 
							if (policyrisk.getCurrentBrokerFlag())
							{
%>
	                            <input type="text" value="<%=policyrisk.getCurrentBroker()%>" class="fieldProtect" readonly="true">
	                            <input type="hidden" name="currentBkr" value="<%=policyrisk.getCurrentBroker()%>">
<% 
							} 
							else 
							{ 
%>
                          		<select name="currentBkr">
<% 
									Enumeration brokers = brokerCodeList.getBrokers();
	                                while (brokers.hasMoreElements()) 
	                                {
	                                	BrokerList.Broker broker = (BrokerList.Broker)brokers.nextElement();
%>
	                                    <option value="<%=broker.getCode()%>" <%=broker.getCode().equals(policyrisk.getCurrentBroker())?"SELECTED":""%>><%=broker.getCode()%></option>
<%
	                                }
%>
                          	    </select>
<% 
							}
%>
	                      </td>
	                      <td style="width:15%;">Original Bkr</td>
	                      <td style="width:10%;PADDING-LEFT:10px;"><input type="text" value="<%=policyrisk.getOrigBroker()%>" name="origBkr" class="fieldProtect" readonly="true"></td>
                      </tr>
                    </table>
                    
                    <table width="100%" class="custom">
                      <tr>
                              <td style="width:23%"></td>
                              <td style="width:11%"></td>
                              <td style="width:11%"></td>
                              <td style="width:11%"></td>
                              <td style="width:11%"></td>
                              <td style="width:11%"></td>
                              <td style="width:11%"></td>
                              <td style="width:11%"></td>
                      </tr>
                      <tr><td colspan="8">Interest</td></tr>
                      <tr>
                        <td colspan="8"><input type="text" name="interest" value="<%=policyrisk.getInterest()%>" <%=policyrisk.getInterestFlag()%>></td>
                      </tr>
                      <tr><td colspan="8">Perils/Condition</td></tr>
                      <tr>
                        <td colspan="8"><input type="text" name="perilsCondition" value="<%=policyrisk.getPerilsCondition()%>" <%=policyrisk.getPerilsConditionFlag()%>></td>
                      </tr>
                      <tr><td colspan="8">Location/Voyage of Risk</td></tr>
                      <tr>
                        <td colspan="8"><input type="text" name="locationVoyageOfRisk" value="<%=policyrisk.getLocationVoyageOfRisk()%>" <%=policyrisk.getLocationVoyageOfRiskFlag()%>></td>
                      </tr>
                      <tr><td colspan="8">Sum Insured Narrative 1</td></tr>
					  <tr>
						<td colspan="8"><input type="text" name="sumInsuredNarrative1" value="<%=policyrisk.getSumInsuredNarrative1()%>" <%=policyrisk.getSumInsuredNarrative1Flag()%>></td>
					  </tr>
                      <tr>
                        <td>Slip Order 1</td>
                        <td colspan="2"><input type="text" name="slipOrder1" value="<%=policyrisk.getSlipOrder1()%>" <%=policyrisk.getSlipOrder1Flag()%>></td>
                        <td colspan="2">Slip Order 2</td>
                        <td colspan="2"><input type="text" name="slipOrder2" value="<%=policyrisk.getSlipOrder2()%>" <%=policyrisk.getSlipOrder2Flag()%>></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td>Ccy of Limits</td>
                        <td>
                          <%=HTMLUtils.createDropdown("ccyOfLimits1",policyrisk.getCcyOfLimits1(),policyrisk.getCcyOfLimitsFlag(),currencyCodeList)%>
                        </td>
                        <td>Limits</td>
                        <td colspan="2"><input type="text" name="limits1" value="<%="".equals(policyrisk.getLimits1())?"":HTMLUtils.formatNoDecimal(policyrisk.getLimits1())%>" <%=policyrisk.getLimitsFlag()%>></td>
                        <td>Excess</td>
                        <td colspan="2"><input type="text" name="excess1" value="<%="".equals(policyrisk.getExcess1())?"":HTMLUtils.formatNoDecimal(policyrisk.getExcess1())%>" <%=policyrisk.getExcessFlag()%>></td>
                      </tr>
                      <tr>
                        <td>Ccy of Limits</td>
                        <td>
                          <%=HTMLUtils.createDropdown("ccyOfLimits2",policyrisk.getCcyOfLimits2(),policyrisk.getCcyOfLimitsFlag(),currencyCodeList)%>
                        </td>
                        <td>Limits</td>
                        <td colspan="2"><input type="text" name="limits2" value="<%="".equals(policyrisk.getLimits2())?"":HTMLUtils.formatNoDecimal(policyrisk.getLimits2())%>" <%=policyrisk.getLimitsFlag()%>></td>
                        <td>Excess</td>
                        <td colspan="2"><input type="text" name="excess2" value="<%="".equals(policyrisk.getExcess2())?"":HTMLUtils.formatNoDecimal(policyrisk.getExcess2())%>" <%=policyrisk.getExcessFlag()%>></td>
                      </tr>
                      <tr>
                        <td>Ccy of Limits</td>
                        <td>
                          <%=HTMLUtils.createDropdown("ccyOfLimits3",policyrisk.getCcyOfLimits3(),policyrisk.getCcyOfLimitsFlag(),currencyCodeList)%>
                        </td>
                        <td>Limits</td>
                        <td colspan="2"><input type="text" name="limits3" value="<%="".equals(policyrisk.getLimits3())?"":HTMLUtils.formatNoDecimal(policyrisk.getLimits3())%>" <%=policyrisk.getLimitsFlag()%>></td>
                        <td>Excess</td>
                        <td colspan="2"><input type="text" name="excess3" value="<%="".equals(policyrisk.getExcess3())?"":HTMLUtils.formatNoDecimal(policyrisk.getExcess3())%>" <%=policyrisk.getExcessFlag()%>></td>
                      </tr>
                      <tr>
                        <td>Basis of Limit</td>
                        <td colspan="5">
                          <%=HTMLUtils.createDropdown("basisOfLimit",policyrisk.getBOL(),policyrisk.getBOLFlag(),basisOfLimitList)%>
                        </td>
                        <td></td>
                        <td></td>
                      </tr>
                    </table>
                    <table class="custom" width="100%" border="0">
                      <tr>
                        <td style="width:13%"></td>
                        <td style="width:25%"></td>
                        <td style="width:12%"></td>
                        <td style="width:25%"></td>
                        <td style="width:12%"></td>
                        <td style="width:8%"></td>
                      </tr>
                      <tr>
                        <td>Cover / Lineslip From</td>
                        <td><%=HTMLUtils.createDate("coverLineslipFrom", (policyrisk.getCoverLineSlipFromFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY, policyrisk.getCoverLineSlipFrom())%></td>
                        <td>Cover / Lineslip To</td>
                        <td><%=HTMLUtils.createDate("coverLineslipTo", (policyrisk.getCoverLineSlipToFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY, policyrisk.getCoverLineSlipTo())%></td>
                        <td>Cover / Lineslip Qualifier</td>
                        <td>
                          <%=HTMLUtils.createDropdown("coverLineslipQualifier",policyrisk.getCoverLineSlipQual(),policyrisk.getCoverLineSlipQualFlag(),coverLineslipQualList)%>
                        </td>
                      </tr>
                      <tr>
                        <td>Pol / Cert Period From</td>
                        <td><%=HTMLUtils.createDate("polCertPeriodFrom",(policyrisk.getPolCertPeriodFromFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,policyrisk.getPolCertPeriodFrom())%></td>
                        <td>Pol / Cert Period To</td>
                        <td><%=HTMLUtils.createDate("polCertPeriodTo", (policyrisk.getPolCertPeriodToFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,policyrisk.getPolCertPeriodTo())%></td>
                        <td>Pol / Cert Qualifier</td>
                        <td>
                          <%=HTMLUtils.createDropdown("polCertQualifier",policyrisk.getPolCertQual(),policyrisk.getPolCertQualFlag(),polCertQualList)%>
                        </td>
                      </tr>
					  <tr>
					  	<td>Pol/Cert Narrative</td>
						<td colspan="5"><input type="text" name="policyPeriodNarrative" value="<%=policyrisk.getPolCertNarrative()%>" <%=policyrisk.getPolCertNarrativeFlag()%>></td>
					  </tr>
                    
                    </table>
                    <table class="custom" width="100%" border="0">
                   		<td style="width:13%"></td>
                        <td style="width: 5%"></td>
                        <td style="width:12%"></td>
                        <td style="width:8%"></td>
                        <td style="width:13%"></td>
                        <td style="width:40%"></td>
                        <td style="width:8%"></td>
                      </tr>
                      <tr>
                        <td>War Ind</td> 
                        <td><input type="checkbox" name="warInd" <%=policyrisk.getWarInd()%> <%=policyrisk.getWarIndFlag()%>></td>
                        <td>Slip Type</td>
                        <td>
                          <%=HTMLUtils.createDropdown("slipType",policyrisk.getSlipType(),policyrisk.getSlipTypeFlag(),slipTypeList)%>
                        </td>
                        <td align="right">UMR</td>
                        <!-- the below is done due to Steria setting this to be a long string, when from the mainframe, it is iether P or U -->
                        <td><%=HTMLUtils.createUmr("umr", " onClick=\"return false\" readonly=\"true\" class=\"fieldProtect\"".equals(policyrisk.getUmrFlag()) ? HTMLUtils.READONLY : HTMLUtils.NORMAL ,policyrisk.getUmr())%></td>
<!--                        <td colspan="2"><input type="text" name="umr" value="<%=policyrisk.getUmr()%>" <%=policyrisk.getUmrFlag()%>></td> -->
                       
                   <td></td>
                      </tr>  
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
<%-- Uncommected because we are showing commas in enquiry mode also, so those values should be removed when submitting --%>
<%-- if (user.updateMode()) { --%>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/policyriskdetailscontent.js"></script>
<%-- } --%>
</form>
</table>
</span>

<!-- To insert comma in the financial amount fields on load of this screen -->
<!-- Though commas are inserted by vField, but this is required when user comes on the screen after history.go(-1) -->
<script>
	document.body.onload = (function() {
							document.forms[0].limits1.value = insertCommas(document.forms[0].limits1.value)
							document.forms[0].limits2.value = insertCommas(document.forms[0].limits2.value)
							document.forms[0].limits3.value = insertCommas(document.forms[0].limits3.value)

							document.forms[0].excess1.value = insertCommas(document.forms[0].excess1.value)
							document.forms[0].excess2.value = insertCommas(document.forms[0].excess2.value)
							document.forms[0].excess3.value = insertCommas(document.forms[0].excess3.value)
							});
</script>

<%
/*
$Log: policyriskdetailscontent.jsp,v $
Revision 1.4.12.2  2004/09/16 14:37:03  clintonj
removed debugging stmts

Revision 1.4.12.1  2004/09/16 12:20:37  clintonj
Adjuster/Lawyer fix

Revision 1.4  2004/03/25 14:54:56  coganp
SIR41158 fix.Added GenericRegexValidator:
This goes yellow if the b field is not a b

Revision 1.3  2004/03/23 16:51:59  coganp
fixed for SIR 41158
Added validation type of null for the UMR first value

Revision 1.2  2004/03/15 15:40:01  coganp
Fix for SIR 41158:
Changed UMR format from a single field to a group of three fields.
*/
%>