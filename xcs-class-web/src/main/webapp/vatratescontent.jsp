<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*,com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="vatrates" type="com.xchanging.xcc.web.models.VATRatesModel" scope="session" />
<jsp:useBean id="scmadvice" type="com.xchanging.xcc.web.models.SCMAdviceModel" scope="session" />
<jsp:useBean id="vatRateList" type="com.xchanging.xcc.web.models.reference.VATRateList" scope="application" />

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
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/decimalvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/numericvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/datevalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/comparator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/screen/vatratescontentCustom.js'></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="vatratescontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("VAT Rates")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"VATRTS\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/vatratesok\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
              	<div class="noscroll">
                    <table class="4column">
                      <tr>
                        <td></td>
                        <td>Bureau Ppn of 100% VAT Amt:</td>
                        <td><span id="hundpercAmt"><%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal((Double.toString(scmadvice.getBureauPpnOfVATAmount()))))%></span></td>
                        <td></td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td colspan="4"><center><strong>Please enter up to six VAT rates/amounts</strong></center></td>
                      </tr>
                      <tr>
                        <td></td>
                        <td>VAT Rate</td>
                        <td>VAT Amt</td>
                        <td></td>
                      </tr>
                      <% Enumeration e = vatrates.getVatRates();
                         int i=1;
                         while (e.hasMoreElements()) {
                           VATRatesModel.VATRate rate = (VATRatesModel.VATRate)e.nextElement();
                           %>
                      <tr>
                        <td></td>
                        <td>
                          <%=HTMLUtils.createDropdown("vatRate" + i,rate.getVatRate(),rate.getVatRateFlag(),vatRateList)%>
                        </td>
                        <td><input name="vatAmt<%=i%>" type="text" value="<%=rate.getVatAmt()%>" <%=rate.getVatAmtFlag()%>></td>
                        <td></td>
                      </tr>
                           <% i++;
                              } %>
                     </table>
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
<%-- if (user.updateMode()) { --%>
<script language="JavaScript" src ='<%=request.getContextPath()%>/js/screen/vatratescontent.js'></script>
<%--}--%>
</table>
</span>
