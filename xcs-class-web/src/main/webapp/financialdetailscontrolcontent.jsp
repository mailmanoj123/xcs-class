<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="financialDetails" type="com.xchanging.xcc.web.models.FinancialDetailsModel" scope="session" />
<jsp:useBean id="osTotalQualList" type="com.xchanging.xcc.web.models.reference.OsTotalQualList" scope="application" />
<jsp:useBean id="currencyCodeList" type="com.xchanging.xcc.web.models.reference.CurrencyCodeList" scope="application" />
<jsp:useBean id="brokerTrQualList" type="com.xchanging.xcc.web.models.reference.BrokerTrQualList" scope="application" />
<jsp:useBean id="peerReviewList" type="com.xchanging.xcc.web.models.reference.PeerReviewList" scope="application" />

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/financialdetailscontrolcontentCustom.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="financialdetailscontrolcontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Financial Details Control")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR015\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
		  <% if (!financialDetails.getSaveButtonFlag()) { %>
          	<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","submitForm(\""+ request.getContextPath() +"/control/financialdetailscontrolsave\")")%>
		  <% } %>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Continue","submitForm(\""+ request.getContextPath() +"/control/financialdetailscontrolcontinue\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\""+ request.getContextPath() +"/control/financialdetailscontrolcancel\", false)")%>
        </div>
        <div class="content">
          <!-- Optional header information -->
          <div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY, financialDetails.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY, financialDetails.getXcr())%></td>
                <td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("tr", HTMLUtils.DISPLAY, financialDetails.getTr())%></td>
              </tr>
              <tr>
                <td><b>OSND1:</b></td>
                <td><%=HTMLUtils.createOsnd("osnd1", HTMLUtils.DISPLAY, financialDetails.getOsnd1())%></td>
                <td><b>Current Bkr:</b></td>
                <td><%=financialDetails.getOrigBkr()%></td>
                <td><b>COR:</b></td>
                <td><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY, financialDetails.getCor())%></td>
              </tr>
        <tr>
          <td><b>Signed:</b></td>
        <td><%=financialDetails.getSigned()%></td>
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
                <div class="scrollmain" style="height:350px" id="scrollpane">
                  <div class="scrollmaincontent">
                    <table class="6column" border="0">
                      <tr>
                        <td colspan="2">Payee Broker</td>
                        <td colspan="2">Payee Broker Pseud</td>
                        <td colspan="2">Redenom Ind</td>
                      </tr>
                      <tr>
                        <td colspan="2"><input type="text" name="payeeBroker" value="<%=financialDetails.getPayeeBroker()%>" <%=financialDetails.getPayeeBrokerFlag()%>></td>
                        <td colspan="2"><input type="text" name="payeeBrokerPseud" value="<%=financialDetails.getPayeeBrokerPseud()%>" <%=financialDetails.getPayeeBrokerPseudFlag()%>></td>
                        <td colspan="2">
                       <input type="text" name="redenomInd" value="<%=financialDetails.getRedenomInd()%>" <%=financialDetails.getRedenomsFlag()%>>
                        </td>
                      </tr>
                      
                   <!-- Binders changes  -->   
                   	
                    
                   		
                    <!-- Binders Changes  -->   
                      
                   <!-- ********** ECF Phase-6 changes ************************ -->
                      <tr>
                      <td colspan="2">Broker TR</td>
                      <td colspan="2">Broker TR Qual</td>
                      <td colspan="2"></td>
                    </tr>
                    <tr>
                      <td colspan="2"><input type="text" name="brokerTr" value="<%=financialDetails.getBrokerTr()%>" <%=financialDetails.getBrokerTrFlag()%>></td>
                      <td colspan="2">
                      <%=HTMLUtils.createDropdown("brokerTrQual",financialDetails.getBrokerTrQual(),financialDetails.getBrokerTrQualFlag(),(DropdownList)brokerTrQualList)%>
                      </td>
                       <!-- ********** XCS/0008 Release 3B changes ? Peer Review Indicator on FDC Screen ************************ -->
                      <td colspan="2">
                      	<table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td style="padding-left:0px;width:75%">
                               Peer Review<span class="compMarker">*</span>
                              </td>
                              <td style="padding-left:0px;width:25%">
                              	<%=HTMLUtils.createDropdown("peerReview",financialDetails.getPeerReview(),financialDetails.getPeerReviewFlag(),peerReviewList)%>
                              </td>
                            </tr>
                          </table>
                      </td>
                                           
                    </tr>
                    
                                        
                     <tr>
                                              
                       
                        <td colspan="2"><span id="individialUCRSpan">Individual UCR</span></td>
                        <td colspan="2"><span id="individialTRSpan">Individual TR</span></td>
                      	<td colspan="2"></td> 
                       
                     </tr>
                     
                      <tr>
                        
                        
                        <td colspan="2"><input type="text" name="individualUcr" value="<%=financialDetails.getIndividualUCR()%>" <%=financialDetails.getIndividualUCRFlag()%>></td>
                        <td colspan="2"><input type="text" name="individualTr" value="<%=financialDetails.getIndividualTR()%>" <%=financialDetails.getIndividualTRFlag()%>></td>
                     	<td colspan="2">                        
                        </td>
                       
                     </tr>

                    <!-- ********** ECF Phase-6 changes  ******************************* -->
 
                    <tr>
                        <td colspan="2">Orig Ccy<span class="compMarker">*</span></td>
                        <td colspan="2"></td>
                        <td colspan="2"></td>
                      </tr>
                      <tr>
                        <td colspan="2">
                          <%=HTMLUtils.createDropdown("origCcy",financialDetails.getOrigCcy(),financialDetails.getOrigCcyFlag(),currencyCodeList)%>
                        </td>
                        <td colspan="2"></td>
                        <td>Settlement Ind</td>
                        <td><input type="checkbox" name="settCcyInd" <%=financialDetails.getSettCcyInd()%> <%=financialDetails.getSettCcyIndFlag()%>></td>
                      </tr>
                      
                      <tr>
                        <td colspan="2">PTD Total</td>
                        <td colspan="2">PTT Total</td>
                        <td colspan="2">O/S Total</td>
                      </tr>
                      <tr>
                        <td colspan="2"><input type="text" name="ptdTotal" value="<%=financialDetails.getPTDTotal()%>" <%=financialDetails.getPTDTotalFlag()%>></td>
                        <td colspan="2"><input type="text" name="pttTotal" value="<%=financialDetails.getPTTTotal()%>" <%=financialDetails.getPTTTotalFlag()%>></td>
                        <td colspan="2">
                          <table cellspacing="0" cellpadding="0" border="0" width="100%">
                            <tr>
                              <td style="padding-left:0px;width:75%">
                                <input type="text" name="osTotal" value="<%=financialDetails.getOsTotal()%>" <%=financialDetails.getOsTotalFlag()%>>
                              </td>
                              <td style="padding-left:0px;width:25%">
                                <%=HTMLUtils.createDropdownWOldVals("osTotalQual",financialDetails.getOsTotalQual(),financialDetails.getOsTotalQualFlag(),osTotalQualList)%>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <tr>
                        <td colspan="2">Sett Ccy</td>
                        <td colspan="2">Sett Rate of Exch</td>
                        <td colspan="2">Settled in Sett Ccy</td>
                      </tr>
                      <tr>
                        <td colspan="2">
                          <%=HTMLUtils.createDropdown("settCcy",financialDetails.getSettCcy(),financialDetails.getSettCcyFlag(),currencyCodeList)%>
                        </td>
                        <td colspan="2"><input type="text" name="settRateOfExch" value="<%= financialDetails.getSettRateOfExch()%>" <%=financialDetails.getSettRateOfExchFlag()%>></td>
                        <td colspan="2"><input type="text" name="settledInSettCcy" value="<%=financialDetails.getSettledInSettCcy()%>" <%=financialDetails.getSettledInSettCcyFlag()%>></td>
                      </tr>
                      <tr>
                        <td colspan="2">Total Line</td>
                        <td colspan="2">Bureau Ppn Amt</td>
                        <td colspan="2">100% VAT Amt</td>
                      </tr>
                      <tr>
                        <td colspan="2"><input type="text" name="totalLine" value="<%=financialDetails.getTotalLine()%>" <%=financialDetails.getTotalLineFlag()%>></td>
                        <td colspan="2"><input type="text" name="bureauPpnAmt" value="<%=financialDetails.getBureauPpnAmt()%>" <%=financialDetails.getBureauPpnAmtFlag()%>></td>
                        <td colspan="2"><input type="text" name="vatAmt" value="<%=financialDetails.getVatAmt()%>" <%=financialDetails.getVatAmtFlag()%>></td>
                      </tr>
                      <tr>
                        <td colspan="2">War Amount</td>
                        <td colspan="2">Incurred</td>
                        <td colspan="2"></td>
                      </tr>
                      <tr>
                        <td colspan="2"><input type="text" name="warAmount" value="<%=financialDetails.getWarAmount()%>" <%=financialDetails.getWarAmountFlag()%>></td>
                        <td colspan="2"><input type="text" name="incurred" value="<%=financialDetails.getIncurred()%>" <%=financialDetails.getIncurredFlag()%>></td>
                        <td colspan="2"></td>
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
</form>
<%-- Uncommected because we are showing commas in enquiry mode also, so those values should be removed when submitting --%>
<%-- if (user.updateMode()) { --%>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/financialdetailscontrolcontent.js"></script>
<%-- } --%>
</table>
</span>

<!-- To insert comma in the financial amount fields on load of this screen -->
<!-- Though commas are inserted by vField, but this is required when user comes on the screen after history.go(-1) -->
<script>
	document.body.onload = (function() {
							document.forms[0].ptdTotal.value = insertCommas(document.forms[0].ptdTotal.value)
							document.forms[0].pttTotal.value = insertCommas(document.forms[0].pttTotal.value)
							document.forms[0].osTotal.value =  insertCommas(document.forms[0].osTotal.value)
							document.forms[0].settRateOfExch.value = insertCommas(document.forms[0].settRateOfExch.value)
							document.forms[0].settledInSettCcy.value = insertCommas(document.forms[0].settledInSettCcy.value)
							document.forms[0].bureauPpnAmt.value = insertCommas(document.forms[0].bureauPpnAmt.value)
							document.forms[0].vatAmt.value = insertCommas(document.forms[0].vatAmt.value)
							document.forms[0].warAmount.value = insertCommas(document.forms[0].warAmount.value)
							document.forms[0].incurred.value = insertCommas(document.forms[0].incurred.value)
							
								
							});
	
</script>
