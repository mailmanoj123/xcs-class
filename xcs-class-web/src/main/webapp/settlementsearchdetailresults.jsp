<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="settsearchdetailedresultsscreen" type="com.xchanging.xcc.web.models.FindSettlementSearchResultsDetailsModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script language="JavaScript" src="<%=request.getContextPath()%>/js/tabs.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/alternateRows.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/formatfordisplay.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">

  <table class="formCenter">
    <tr>
      <td></td>
      <td class="content">
        <div class="outerWindow">
          <div class="top">
            <div class="header">
                <%=HTMLUtils.createHeader("Settlement Details")%>
                <!-- Below help button is no longer required since the information displayed is out of date -->
                <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR043\")")%> -->
            </div>
          </div>

          <div class="menuBar">
             <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Exit","submitForm(\"" + request.getContextPath() + "/control/settlementsearchdetailexit\")")%>
             <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/settlementsearchdetailcancel\")")%>
          </div>

          <form>
            <input type="submit" name="submitButton" style="display:none">
            <div class="content">
              <!-- Optional header information -->
              <div>
                <table class="headerInfo" width="100%">
                  <tr>
                    <td><b>TDN:</b></td>
                    <td><%=HTMLUtils.createTdn("",HTMLUtils.DISPLAY,settsearchdetailedresultsscreen.getC116_TAKE_DOWN_DATE()+settsearchdetailedresultsscreen.getC116_TAKE_DOWN_NO())%></td>

                    <td><b>Vers No:</b></td>
                    <td><%=settsearchdetailedresultsscreen.getC116_VERSION_NO()%></td>

                    <td><b>OSND:</b></td>
                    <!--Only display the OSND/Date if it isn't 00000 / 00/00/0000 - STH - 14/01/2004 -->
                    <%if (settsearchdetailedresultsscreen.getC116_OSND_NO().equals("00000")) {%>
                      <td></td>
                    <%} else {%>
                      <td><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY,settsearchdetailedresultsscreen.getC116_OSND_DATE()+settsearchdetailedresultsscreen.getC116_OSND_NO())%></td>
                    <% } %>
                  </tr>
                  <tr>
                    <td><b>Orig Bkr:</b></td>
                    <td><%=settsearchdetailedresultsscreen.getC116_ORIG_BKR()%></td>
                    <td><b>Bkr Pseud:</b></td>
                    <td><%=settsearchdetailedresultsscreen.getC116_ORIG_BKR_PSEUD()%></td>
                    <td><b>YOA:</b></td>
                    <td><%=settsearchdetailedresultsscreen.getC116_YEAR_OF_ACC()%></td>
                  </tr>
                  <tr>
                    <td><b>COR:</b></td>
                    <td><%=settsearchdetailedresultsscreen.getC116_COR()%></td>
                    <td><b>Claim Status:</b></td>
                    <td><%=settsearchdetailedresultsscreen.getC116_CLAIM_STATUS()%></td>
                    <td><b>Paid By Cheque:</b></td>
                    <td><%=settsearchdetailedresultsscreen.getC116_PAID_BY_CHEQUE()%></td>
                  </tr>
                </table>
              </div>
              <br>
              <table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
                <tr>
                  <td align="center">
                    <table border='0' cellpadding='0' cellspacing='0' class='navigationButton' onClick='showTab(1)'> <tr> <td class='left'>&nbsp;</td> <td class='middle'>non-fin</td> <td class='right'>&nbsp;</td> </tr> </table>
                  </td>
                  <td align="center">
                    <table border='0' cellpadding='0' cellspacing='0' class='navigationButton' onClick='showTab(2)'> <tr> <td class='left'>&nbsp;</td> <td class='middle'>fin</td> <td class='right'>&nbsp;</td> </tr> </table>
                  </td>
                  <td align="center">
                    <table border='0' cellpadding='0' cellspacing='0' class='navigationButton' onClick='showTab(3)'> <tr> <td class='left'>&nbsp;</td> <td class='middle'>lsr</td> <td class='right'>&nbsp;</td> </tr> </table>
                  </td>
                  <td align="center">
                    <table border='0' cellpadding='0' cellspacing='0' class='navigationButton' onClick='showTab(4)'> <tr> <td class='left'>&nbsp;</td> <td class='middle'>narrative</td> <td class='right'>&nbsp;</td> </tr> </table>
                  </td>
                  <td align="center">
                    <table border='0' cellpadding='0' cellspacing='0' class='navigationButton' onClick='showTab(5)'> <tr> <td class='left'>&nbsp;</td> <td class='middle'>ccs amounts</td> <td class='right'>&nbsp;</td> </tr> </table>
                  </td>
                  <td align="center">
                    <table border='0' cellpadding='0' cellspacing='0' class='navigationButton' onClick='showTab(6)'> <tr> <td class='left'>&nbsp;</td> <td class='middle'>vat details</td> <td class='right'>&nbsp;</td> </tr> </table>
                  </td>
                </tr>
              </table>

              <br>

              <div id="tab1" style="display:none">
                <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
                  <tr>
                    <td valign="top" >
                      <div class="scrollmain" style="height:367px" id="scrollpane">
                        <div class="scrollmaincontent">
                          <table width="100%" border="0" class="custom" cellspacing="6">
                            <tr>
                              <td style="width:16%"></td>
                              <td style="width:16%"></td>
                              <td style="width:16%"></td>
                              <td style="width:16%"></td>
                              <td style="width:16%"></td>
                              <td style="width:16%"></td>
                            </tr>
                            <tr>
                              <td><b>Payee Bkr and Pseud:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_PAYEE_BKR()%> <%=settsearchdetailedresultsscreen.getC116_PAYEE_BKR_PSEUD()%></td>
                              <td><b>Bkr Ref 1:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_BKR_REF_1()%></td>
                              <td><b>Bkr Ref 2:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_BKR_REF_2()%></td>
                            </tr>
                            <tr>
                              <td><b>DTI Code:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_DTI_CODE()%></td>
                              <td><b>Risk Code:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_RISK_CODE()%></td>
                              <td><b>Market Code:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_MARKET_CODE()%></td>
                            </tr>
                            <tr>
                              <td><b>FIL Code 1:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_FIL_CODE_1()%></td>
                              <td><b>FIL Code 2:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_FIL_CODE_2()%></td>
                              <td><b>FIL Code 3:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_FIL_CODE_3()%></td>
                            </tr>
                            <tr>
                              <td><b>TF Code:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_TRUST_FUND_CODE()%></td>
                              <td><b>Scheme Code:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_SCHEME_CODE()%></td>
                              <td><b>Attachments:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_ATTACHMENTS_IND()%></td>
                            </tr>
                            <tr>
                              <td><b>Sett Period:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_SETT_PERIOD()%></td>
                              <td><b>Actual Payment Date:</b></td>
                              <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,settsearchdetailedresultsscreen.getC116_ACTUAL_PAYMENT_DATE())%></td>
                              <td><b>Contra Actual Payment Date:</b></td>
                              <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,settsearchdetailedresultsscreen.getC116_CONTRA_APD())%></td>
                            </tr>
                            <tr>
                              <td><b>LCO Cat:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_LCO_CAT_CODE()%></td>
                              <td><b>Non SCM Advised:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_NON_SCM_ADV_IND()%></td>
                              <td><b>Bulk Ind:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_BULK_IND()%></td>
                            </tr>
                            <tr>
                              <td><b>Completed Date:</b></td>
                              <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,settsearchdetailedresultsscreen.getC116_COMPLETED_DATE())%></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td><b>Created By User:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_CREATED_BY_USER()%></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td><b>Name 1:</b></td>
                              <td colspan=2><%=settsearchdetailedresultsscreen.getC116_NAME_1()%>&nbsp;&nbsp;<%=settsearchdetailedresultsscreen.getC116_NAME_1_QUAL()%></td>
                              <td><b>Name 2:</b></td>
                              <td colspan=2><%=settsearchdetailedresultsscreen.getC116_NAME_2()%>&nbsp;&nbsp;<%=settsearchdetailedresultsscreen.getC116_NAME_2_QUAL()%></td>
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
                      <div class="scrollmain" style="height:367px" id="scrollpane">
                        <div class="scrollmaincontent">
                          <table width="100%" border="0" class="custom" cellspacing="6">
                            <tr>
                              <td style="width:15%"></td>
                              <td style="width:25%"></td>
                              <td style="width:15%"></td>
                              <td style="width:16%"></td>
                              <td style="width:15%"></td>
                              <td style="width:15%"></td>
                            </tr>
                            <tr>
                              <td><b>Orig Ccy:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_ORIG_CCY()%></td>
                              <td><b>Sett Ccy:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_SETT_CCY()%></td>
                              <td><b>Redenom Ind:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_REDENOM_IND()%></td>
                            </tr>
                            <tr>
                              <td><b>100% Order Amount:</b></td>
                              <!-- Align right and line up to 2 dp - STH 29/12/2003-->
                              <td align="Right">
                                <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_HPC_ORDER_AMOUNT()%>,2,'y'))</script>
                              </td>
                            </tr>
                            <tr>
                              <td><b>Rate Of Exch:</b></td>
                              <!-- Align right and line up to 4 dp - STH 29/12/2003-->
                              <td align="Right">
                               <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_RATE_EXCH()%>,4,'n'))</script>
                              </td>
                            </tr>
                            <tr>
                              <td><b>100% Sett Amt:</b></td>
                              <!-- Align right and line up to 2 dp - STH 29/12/2003-->
                              <td align="Right">
                                <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_HPC_SETT_AMOUNT()%>,2,'y'))</script>
                              </td>
                            </tr>
                            <!-- Added % after Total line amount - STH 23/12/2003 -->
                            <tr>
                              <td><b>Total Line:</b></td>
                              <!-- Align right and line up to 4 dp - STH 29/12/2003-->
                              <td align="Right">
                               <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_TOTAL_LINE()%>,4,'n'))</script>
                               %
                             </td>
                            </tr>
                            <tr>
                              <td><b>Bureau Share:</b></td>
                              <!-- Align right and line up to 2 dp - STH 29/12/2003-->
                              <td align="Right">
                                <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_BUREAU_SHARE_AMOUNT()%>,2,'y'))</script>
                              </td>
                            </tr>
                            <tr>
                              <td><b>100% VAT Amt:</b></td>
                              <!-- Align right and line up to 2 dp - STH 29/12/2003-->
                              <td align="Right">
                                <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_HPC_VAT_AMOUNT()%>,2,'y'))</script>
                             </td>
                            </tr>
                            <tr>
                              <td><b>WAR Amt:</b></td>
                              <!-- Align right and line up to 2 dp - STH 29/12/2003-->
                              <td align="Right">
                               <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_WAR_AMOUNT()%>,2,'y'))</script>
                              </td>
                            </tr>
                            <tr>
                              <td><b>FIL 1 Amt:</b></td>
                              <!-- Align right and line up to 2 dp - STH 29/12/2003-->
                              <td align="Right">
                                <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_FIL_1_AMOUNT()%>,2,'y'))</script>
                              </td>
                            </tr>
                            <tr>
                              <td><b>FIL 2 Amt:</b></td>
                              <!-- Align right and line up to 2 dp - STH 29/12/2003-->
                              <td align="Right">
                               <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_FIL_2_AMOUNT()%>,2,'y'))</script>
                             </td>
                            </tr>
                          </table>
                        </div>
                      </div>
                    </td>
                  </tr>
                </table>
              </div>

              <div id="tab3" style="display:none">
                <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
                  <tr>
                    <td valign="top" >
                      <div class="scrollmain" style="height:367px" id="scrollpane">
                        <div class="scrollmaincontent">
                          <table width="100%" border="0" class="custom" cellspacing="6">
                            <tr>
                              <td style="width:25%"></td>
                              <td style="width:25%"></td>
                              <td style="width:30%"></td>
                              <td style="width:20%"></td>
                            </tr>
                            <!-- Added % after Total Line, LIDS total line & lead u/w values
                                 and right aligned to 4dp lead u/w, total line and LIDS total line %
                                 - STH 23/12/2003 -->
                            <tr>
                              <td><b>Leading Underwriter:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_LEAD_UWR()%></td>
                              <td><b>Leading Underwriter %:</b></td>
                              <td>
                               <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_LEAD_UWR_PC()%>,4,'n'))</script>
                              %</td>
                            </tr>
                            <tr>
                              <td><b>Total Line:</b></td>
                              <td>
                               <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_CLAIM_TOTAL_LINE()%>,4,'n'))</script>
                               %
                              </td>
                              <td><b>No Of Lines:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_NO_OF_CLAIM_LINES()%></td>
                            </tr>
                            <tr>
                              <td><b>LIDS Total Line:</b></td>
                              <td>
                                <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_LIDS_TOTAL_LINE()%>,4,'n'))</script>
                                %
                              </td>
                              <td><b>LIDS No Of Lines:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_NO_OF_LIDS_LINES()%></td>
                            </tr>
                          </table>
                          <br>
                          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="marketTable">
                            <tr>
                              <th align="right" width="25%">% Signed Line</th>
                              <th align="right" width="25%">Syndicate No</th>
                              <th align="right" width="25%">Ref</th>
                              <th align="right" width="25%">&nbsp;</th>
                            </tr>

                                <% Enumeration results = settsearchdetailedresultsscreen.getVAllMarketDetails();
                                  while (results.hasMoreElements()) {
                                          FindSettlementSearchResultsDetailsModel.singleMarketDetail result = (FindSettlementSearchResultsDetailsModel.singleMarketDetail)results.nextElement();

                                %>
                                <!-- Right Justify Syndicate and align decimal points of signed line- STH 23/12/2003 -->
                            <tr>
                              <td align="right">
                                <script language="JavaScript">document.write(roundOff(<%=result.getC116_SIGNED_LINE_PC()%>,8,'n'))</script>
                              </td>
                              <td align="right"><%=result.getC116_SYND_NO()%></td>
                              <td align="right"><%=result.getC116_SYND_REF()%></td>
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

              <div id="tab4" style="display:none">
                <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
                  <tr>
                    <td valign="top" >
                      <div class="noscroll" style="height:367px" id="scrollpane">
                        <table width="100%" border="0" class="custom" cellspacing="6">
                          <tr>
                            <td>
                              <textarea rows="21" wrap="none" READONLY style="width:auto;font-family:courier new;font-size:12" cols="70"><%=settsearchdetailedresultsscreen.getC116_NARRATIVE_LINE()%></textarea>
                            </td>
                          </tr>
                        </table>
                      </div>
                    </td>
                  </tr>
                </table>
              </div>

              <div id="tab5" style="display:none">
                <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
                  <tr>
                    <td valign="top" >
                      <div class="scrollmain" style="height:367px" id="scrollpane">
                        <div class="scrollmaincontent">
                        <%if (settsearchdetailedresultsscreen.getC116_CCS_DETAILS_IND().equals("Y")) { %>
                          <table width="100%" border="0" class="custom" cellspacing="6">
                            <tr>
                              <td style="width:25%"></td>
                              <td style="width:25%"></td>
                              <td style="width:25%"></td>
                              <td style="width:25%"></td>
                            </tr>
                            <tr>
                              <td><b>Orig Ccy:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_CCS_ORIG_CCY()%></td>
                              <td><b>Sett Ccy:</b></td>
                              <td><%=settsearchdetailedresultsscreen.getC116_CCS_SETT_CCY()%></td>
                            </tr>
                            <tr>
                              <td><b>100% Order Amt:</b></td>
                              <td align="Right">
                               <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_CCS_HPC_ORDER_AMOUNT()%>,2,'y'))</script>
                             </td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td><b>Exchange Rate:</b></td>
                              <!--Right align amounts and to appropriate dp - STH 29/12/2003 -->
                              <td align="Right">
                                <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_ROE_TO_GBP()%>,4,'n'))</script>
                              </td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td><b>Treasury Rate:</b></td>
                              <!--Right align amounts and to appropriate dp - STH 29/12/2003 -->
                              <td align="Right">
                                <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_TREASURY_RATE()%>,4,'n'))</script>
                             </td>
                              <td></td>
                              <td></td>
                            </tr>
                            <tr>
                              <td><b>Total Settled GBP:</b></td>
                              <!--Right align amounts and to appropriate dp - STH 29/12/2003 -->
                              <td align="Right">
                               <script language="JavaScript">document.write(roundOff(<%=settsearchdetailedresultsscreen.getC116_CCS_TOT_SETT_GBP()%>,2,'y'))</script>
                             </td>
                              <td></td>
                              <td></td>
                            </tr>
                          </table>
                        <% } %>
                        </div>
                      </div>
                    </td>
                  </tr>
                </table>
              </div>

              <div id="tab6" style="display:none">
                <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
                  <tr>
                    <td valign="top" >
                      <div class="scrollmain" style="height:367px" id="scrollpane">
                        <div class="scrollmaincontent">
                          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="vatRates">
                            <tr>
                              <th align="center" width="25%">VAT Rate</th>
                              <th align="center" width="25%">VAT Amt</th>
                              <th align="right" width="25%">&nbsp;</th>
                              <th align="right" width="25%">&nbsp;</th>
                            </tr>
                            <% if (settsearchdetailedresultsscreen.getC116_INT_VAT_COUNT() > 0) {
                              Enumeration results2 = settsearchdetailedresultsscreen.getVatRateTable();
                            while (results2.hasMoreElements()) {
                              FindSettlementSearchResultsDetailsModel.VATRate result2 = (FindSettlementSearchResultsDetailsModel.VATRate)results2.nextElement();
                            %>
                            <!-- Line up decimal points of vat rates and vat amounts - STH 29/12/2003 -->
                              <tr>
                                <td align="right">
                                <script language="JavaScript">document.write(roundOff(<%=result2.getVatRate()%>,2,'y'))</script>
                                </td>
                                <td align="right">
                                <script language="JavaScript">document.write(roundOff(<%=result2.getVatAmt()%>,2,'y'))</script>
                                </td>
                                <td></td>
                                <td></td>
                              </tr>
                            <% } }  %>
                          </table>
                        </div>
                      </div>
                    </td>
                  </tr>
                </table>
              </div>

              <script language="JavaScript">showTab(1);</script>

            </div>

          </form>

          <div class="bot">
          </div>

        </div>

      </td>

      <td></td>

    </tr>

  </table>

</span>
<!-- Add alternate row colours for LSR Tab and VAT Tab - STH 23/12/2003 -->
<script>altColumnRows('marketTable',1);</script>
<script>altColumnRows('vatRates',1);</script>


