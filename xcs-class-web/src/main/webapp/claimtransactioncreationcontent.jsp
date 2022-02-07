<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>

<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />

<jsp:useBean id="claimCreation" type="com.xchanging.xcc.web.models.ClaimTransactionCreationModel" scope="session" />

<jsp:useBean id="settAdvList" type="com.xchanging.xcc.web.models.reference.SettAdvList" scope="application" />

<jsp:useBean id="chargeTypeList" type="com.xchanging.xcc.web.models.reference.ChargeTypeList" scope="application" />

<jsp:useBean id="currencyCodeList" type="com.xchanging.xcc.web.models.reference.CurrencyCodeList" scope="application" />

<!-- TP871424 Changes for quality validation project--> <!--  jsp:useBean id="paidByChequeList" type="com.xchanging.xcc.web.models.reference.PaidByChequeList" scope="application" />  -->

<jsp:useBean id="ecfClassList" type="com.xchanging.xcc.web.models.reference.EcfClassList" scope="application" />

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

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/restrictednumericvalidator.js"></script>

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/decimalvalidator.js"></script>

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/claimtransactioncreationcontentcustom.js"></script>

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/booleanentered.js"></script>

 

<!-- To remove menu bar, remove below span class and remove any menu buttons -->

<span class="lhsNav">

<table class="formCenter">

<form name="form1">

<input type="submit" name="submitButton" style="display:none">

  <tr>

    <td></td>

    <td class="content">

      <div class="outerWindow">

        <div class="top">

          <div class="header">

            <%=HTMLUtils.createHeader("Claim Transaction Creation")%> 

            <!-- Below help button is no longer required since the information displayed is out of date -->

            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR009\")")%> -->

          </div>

        </div>

        <div class="menuBar">

              <% if (!claimCreation.getSaveButtonFlag()) { %>

                <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","submitForm(\"" + request.getContextPath() + "/control/claimtxncreationsave\")")%>

              <% } %>

          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Continue","submitForm(\"" + request.getContextPath() + "/control/claimtxncreationcontinue\")")%>

              <% if (!claimCreation.getBringFwdBDButtonFlag()) { %>

            <%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Bring Fwd Breakdown","submitForm(\"" + request.getContextPath() + "/control/claimtxncreationbringfwdbd\")")%>

              <% } %>

              <% if (!claimCreation.getDeleteBDButtonFlag()) { %>

            <%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Delete Breakdown","submitForm(\"" + request.getContextPath() + "/control/claimtxncreationdeletebd\")")%>

              <% } %>

          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/claimtxncancel\", false)")%>

        </div>

        <div class="content">

          <!-- Optional header information -->

          <div>

            <table class="headerInfo" width="100%">

              <tr>

                <td><b>UCR:</b></td>

                <td><%=HTMLUtils.createUcr("ucr1",HTMLUtils.DISPLAY,claimCreation.getUcr())%></td>

                <td><b>XCR:</b></td>

                <td><%=HTMLUtils.createUcr("xcr1",HTMLUtils.DISPLAY,claimCreation.getXcr())%></td>

                <td><b>TR:</b></td>

                <td><%=HTMLUtils.createUcr("tr1",HTMLUtils.DISPLAY,claimCreation.getTr())%></td>

              </tr>

              <tr>

                <td><b>OSND1:</b></td>

                <td><%=HTMLUtils.createOsnd("hOsnd1",HTMLUtils.DISPLAY,claimCreation.getHOsnd1())%></td>

                <td><b>OSND2:</b></td>

                <td><%=HTMLUtils.createOsnd("hOsnd2",HTMLUtils.DISPLAY,claimCreation.getHOsnd2())%></td>

                <td><b>OSND3:</b></td>

                <td><%=HTMLUtils.createOsnd("hOsnd3",HTMLUtils.DISPLAY,claimCreation.getHOsnd3())%></td>

              </tr>

              <tr>

                <td><b>Peer Review:</b></td>

                <td><%=claimCreation.getPeerRevInd()%></td>

                <td colspan="4"></td>

              </tr>

            </table>

          </div>

          <br>

          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >

            <tr>

              <td valign="top" >

                <div class="scrollmain" style="height:367px" id="scrollpane">

                  <div class="scrollmaincontent">

                    <table width="100%" border="0" class="custom">

                    <tr>

                      <td style="width:25%"></td>

                      <td style="width:35%"></td>

                      <td style="width:25%"></td>

                      <td style="width:15%"></td>

                    </tr>

                     <tr>

                      <td colspan="4">

                        <table cellspacing="0" cellpadding="0">

                          <tr>

                            <td style="width:15%;padding-left:0px">Transaction Synopsis</td>

                            <td style="width:15%"><textarea name="transactionSynopsis" wrap="none" style="width:auto;font-family:courier new;font-size:12" cols="60" rows="2" <%=claimCreation.getTransactionSynopsisFlag()?"onClick=\"return false\" readonly=\"true\" class=\"fieldProtect\"":""%>><%=claimCreation.getTransactionSynopsis()%></textarea></td>

                          </tr>

                        </table>

                      </td>

                    </tr>

                    <tr>

                      <td>OSND1</td>

                      <% if ( claimCreation.getOsnd1ErrFlg() ) { %>

                        <td><%=HTMLUtils.createOsnd("osnd1",HTMLUtils.ERROR,claimCreation.getOsnd1())%></td>

                      <% } else { %>

                        <td><%=HTMLUtils.createOsnd("osnd1",(claimCreation.getOsnd1Flag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimCreation.getOsnd1())%></td>

                      <% } %>

                      <td>Orig Ccy<span class="compMarker">*</span></td>

                      <td>

                        <%=HTMLUtils.createDropdown("origCcy1",claimCreation.getCurr1(),claimCreation.getCurr1Flag(),currencyCodeList)%>

                      </td>

                   </tr>

                   <tr>

                    <td>AP SND</td>

                    <% if ( claimCreation.getApsnd1ErrFlg() ) { %>

                      <td><%=HTMLUtils.createOsnd("apsnd1",HTMLUtils.ERROR,claimCreation.getApsnd1())%></td>

                    <% } else { %>

                      <td><%=HTMLUtils.createOsnd("apsnd1",(claimCreation.getApsnd1Flag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimCreation.getApsnd1())%></td>

                    <% } %>

                    <td>&nbsp;</td>

                    <td>&nbsp;</td>

                  </tr>

                  <tr>

                    <td>OSND2</td>

                    <% if ( claimCreation.getOsnd2ErrFlg() ) { %>

                      <td><%=HTMLUtils.createOsnd("osnd2",HTMLUtils.ERROR,claimCreation.getOsnd2())%></td>

                    <% } else { %>

                      <td><%=HTMLUtils.createOsnd("osnd2",(claimCreation.getOsnd2Flag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimCreation.getOsnd2())%></td>

                    <% } %>

                    <td>Orig Ccy</td>

                    <td>

                      <%=HTMLUtils.createDropdown("origCcy2",claimCreation.getCurr2(),claimCreation.getCurr2Flag(),currencyCodeList)%>

                    </td>

                  </tr>

                  <tr>

                    <td>AP SND</td>

                    <% if ( claimCreation.getApsnd2ErrFlg() ) { %>

                      <td><%=HTMLUtils.createOsnd("apsnd2",HTMLUtils.ERROR,claimCreation.getApsnd2())%></td>

                    <% } else { %>

                      <td><%=HTMLUtils.createOsnd("apsnd2",(claimCreation.getApsnd2Flag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimCreation.getApsnd2())%></td>

                    <% } %>

                    <td>&nbsp;</td>

                    <td>&nbsp;</td>

                  </tr>

                  <tr>

                    <td>OSND3</td>

                    <% if ( claimCreation.getOsnd3ErrFlg() ) { %>

                      <td><%=HTMLUtils.createOsnd("osnd3",HTMLUtils.ERROR,claimCreation.getOsnd3())%></td>

                    <% } else { %>

                      <td><%=HTMLUtils.createOsnd("osnd3",(claimCreation.getOsnd3Flag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimCreation.getOsnd3())%></td>

                    <% } %>

                    <td>Orig Ccy</td>

                    <td>

                      <%=HTMLUtils.createDropdown("origCcy3",claimCreation.getCurr3(),claimCreation.getCurr3Flag(),currencyCodeList)%>

                    </td>

                  </tr>

                  <tr>

                    <td>AP SND</td>

                    <% if ( claimCreation.getApsnd3ErrFlg() ) { %>

                      <td><%=HTMLUtils.createOsnd("apsnd3",HTMLUtils.ERROR,claimCreation.getApsnd3())%></td>

                    <% } else { %>

                      <td><%=HTMLUtils.createOsnd("apsnd3",(claimCreation.getApsnd3Flag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimCreation.getApsnd3())%></td>

                    <% } %>

                    <td>&nbsp;</td>

                    <td>&nbsp;</td>

                  </tr>

                </table>

                <table width="100%" border="0" class="6column">

                  <tr>

                                                                              <td style="width:17%"></td>

                                                                                <td style="width:17%"></td>

                                                                                <td style="width:17%"></td>

                                                                                <td style="width:17%"></td>

                                                                                <td style="width:17%"></td>

                                                                                <td style="width:17%"></td>

                                                      </tr>

                  <tr>

                    <td>Sett/Adv<span class="compMarker">*</span></td>

                    <td>

                      <%=HTMLUtils.createDropdown("settAdv",claimCreation.getSettAdv(),claimCreation.getSettAdvFlag(),settAdvList)%>

                    </td>

                    <td>Pres Date<span class="compMarker">*</span></td>

                    <td colspan="3">

                      <table border="0" cellspacing="0" cellpadding="0" width="100%">

                        <tr>

                          <td width="50%">

                            <% if (claimCreation.getPresDateErrFlg()) { %>

                              <%=HTMLUtils.createDate("presDate",HTMLUtils.ERROR,claimCreation.getPresDate())%>

                            <% } else { %>

                              <%=HTMLUtils.createDate("presDate",(claimCreation.getPresDateFlag()==false)?HTMLUtils.NORMAL:HTMLUtils.READONLY,claimCreation.getPresDate())%>

                            <% } %>

                          </td>

                          <td></td>

                        </tr>

                      </table>

                    </td>

                  </tr>

                  <tr>

                    <td>Bulk Ind</td>

                    <td><input type="checkbox" name="bulkInd" <%=claimCreation.getBulkInd()%> <%=claimCreation.getBulkIndFlag()%>></td>

                    <td>Treaty</td>

                    <td><input type="checkbox" name="treaty" <%=claimCreation.getTreaty()%> <%=claimCreation.getTreatyFlag()%>></td>

                    <td>Sim RI</td>

                    <td><input type="checkbox" name="simRi" <%=claimCreation.getSimRI()%> <%=claimCreation.getSimRIFlag()%>></td>

                  </tr>

                  <tr>

                    <td>Non SCM Advised</td>

                    <td><input type="checkbox" name="nonScmAdvised" <%=claimCreation.getNonScmAdvised()%> <%=claimCreation.getNonScmAdvisedFlag()%>></td>

                    <td>ECF Claim</td>

                    <td><input type="checkbox" name="ecfClaim" <%=claimCreation.getEcfClaim()%> <%=claimCreation.getEcfClaimFlag()%>></td>

                          <td></td>

                          <td></td>

                  </tr>

                        <tr>

                          <td>ECF Class<span class="compMarker">*</span></td>

                    <td colspan="3"><%=HTMLUtils.createDropdown("ecfClass",claimCreation.getEcfClass(),claimCreation.getEcfClassFlag(),ecfClassList)%></td>

                              <td></td>

                              <td></td>

                    </tr>                  

                  <tr>

                    <td>Loss Reserve</td>

                    <td><input type="checkbox" name="lossReserve" <%=claimCreation.getLossReserve()%> <%=claimCreation.getLossReserveFlag()%>></td>

                    <td>Risk Unsigned</td>

                    <td><input type="checkbox" name="riskUnsigned" <%=claimCreation.getRiskUnsigned()%> <%=claimCreation.getRiskUnsignedFlag()%>></td>

                    <td>Prev Adv Non-net</td>

                    <td><input type="checkbox" name="prevAdvNonNet" <%=claimCreation.getPrevAdvNonNet()%> <%=claimCreation.getPrevAdvNonNetFlag()%>></td>

                  </tr>

                  <tr>

                    <td>Prev Paid Ind</td>

                    <td><input type="checkbox" name="prevPaidInd" <%=claimCreation.getPrevPaidInd()%> <%=claimCreation.getPrevPaidIndFlag()%>></td>

                    <td>LOC</td>

                    <td><input type="checkbox" name="loc" <%=claimCreation.getLoc()%> <%=claimCreation.getLocFlag()%>></td>

                    <td>Loss Fund</td>

                    <td><input type="checkbox" name="lossFund" <%=claimCreation.getLossFund()%> <%=claimCreation.getLossFundFlag()%>></td>

                  </tr>

                  <tr>

                  <!-- CCN N0021 - devo - 15/01/2003 -->

                    <td>CPA Ind</td>

                    <td><input type="checkbox" name="cpaInd" <%=claimCreation.getCPAInd()%> <%=claimCreation.getCPAIndFlag()%>></td>
                    <td>Pay by Cheque</td>
                      <!-- TP871424 Changes for quality validation project-->
                      <td colspan="1">
                      <table cellspacing="0" cellpadding="0">
                      <tr>
                         <td><input type="radio" name="payByCheque" id="payByCheque" value="Y" <%= (claimCreation.getPayByCheque()!=null && claimCreation.getPayByCheque().trim().equalsIgnoreCase("Y"))?"checked":"" %> style="width:10px" <%=claimCreation.getPayByCheque_ATTR() %>>Yes</td>
 						 <!-- SIR 229129 Removed defaulting of indicator to value N -->
 						 <td><input type="radio" name="payByCheque" id="payByCheque" value="N" <%= (claimCreation.getPayByCheque()!=null && claimCreation.getPayByCheque().trim().equalsIgnoreCase("N"))?"checked":"" %> style="width:10px" <%=claimCreation.getPayByCheque_ATTR() %>>No</td>
	                  </tr>
	                  </table>
	                  </td>
                  

                <td>Non-chargeable Ind</td>

                    <td><input type="checkbox" name="noChargeableInd" <%=claimCreation.getNonChargeableInd()%> <%=claimCreation.getNonChargeableIndFlag()%>></td>

                  </tr>

                  <tr>

                    <!-- CCN N0058 - BA - 09/01/2003 -->

                    <td>LOC Drawing</td>

                    <td><input type="checkbox" name="locDrawingInd" <%=claimCreation.getLocDrawingInd()%> <%=claimCreation.getLocDrawingIndFlag()%>></td>

                    <td>Direct LStock Ind</td>

                    <td><input type="checkbox" name="dirLStockInd" <%=claimCreation.getDirLStockInd()%> <%=claimCreation.getDirLStockIndFlag()%>></td>

                    <td>Scheme Can Ind</td>

                    <td><input type="checkbox" name="schemeCanInd" <%=claimCreation.getSchemeCanInd()%> <%=claimCreation.getSchemeCanIndFlag()%>></td>

                  </tr>

                  <tr>

                  <!-- CCN ????????? - S.Caine - 03/12/2003 -->

                    <td>Special Payment Ind</td>

                    <td><input type="checkbox" name="specPymtInd" <%=claimCreation.getSpecPymtInd()%> <%=claimCreation.getSpecPymtIndFlag()%>></td>

                    <td>Charge Type<span class="compMarker">*</span></td>

                    <td colspan="2">

                      <%=HTMLUtils.createDropdown("chargeType",claimCreation.getChargeType(),claimCreation.getChargeTypeFlag(),chargeTypeList)%>

                    </td>

                    <td>&nbsp;</td>

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

<% if (user.updateMode()) { %>

<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/claimtransactioncreationcontent.js"></script>

<% } %>

</form>

</table>

</span>

 

<%

/*

 

$Log: claimtransactioncreationcontent.jsp,v $

Revision 1.3  2004/03/11 09:47:44  coganp

Fix for SIR 41134. osnd and apsnd numbers can't now contain - or +.

 

 

*/

%>
