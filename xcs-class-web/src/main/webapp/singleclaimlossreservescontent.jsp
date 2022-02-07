<%@ page import="com.xchanging.xcc.web.html.*,com.xchanging.xcc.web.models.reference.*,java.util.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="sclr" type="com.xchanging.xcc.web.models.SingleClaimLossReservesModel" scope="session" />
<jsp:useBean id="osAmtQualList" type="com.xchanging.xcc.web.models.reference.OsAmountQualList" scope="application" />

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/singleclaimlossreservescontentcustom.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="singleclaimlossreservescontent" method="Post">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Single Claim Loss Reserves")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR016\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
		  <% if (!sclr.getSaveButtonFlag()) { %>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","submitForm(\"" + request.getContextPath() + "/control/singleclaimlosssave\")")%>
		  <% } %>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Continue","submitForm(\"" + request.getContextPath() + "/control/singleclaimlosscontinue\")")%>
          <% if (!sclr.getNewMovementFlag()) { %>
            <%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Create New Movement","submitForm(\"" + request.getContextPath() + "/control/singleclaimlossnewmvmt\")")%>
          <% } %>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/singleclaimlosscancel\", false)")%>
        </div>
        <div class="content">
          <!-- Optional header information -->
          <div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("ucr", HTMLUtils.DISPLAY, sclr.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("xcr", HTMLUtils.DISPLAY, sclr.getXcr())%></td>
                <td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("tr", HTMLUtils.DISPLAY, sclr.getTr())%></td>
              </tr>
              <tr>
                <td><b>OSND:</b></td>
                <td><%=HTMLUtils.createOsnd("osnd", HTMLUtils.DISPLAY, sclr.getOsnd())%></td>
                <td><b>Current Bkr:</b></td>
                <td><%=sclr.getOrigBkr()%></td>
                <td><b>Signed:</b></td>
                <td><%=sclr.getSigned()%></td>
              </tr>
        <tr>
          <td><b>Orig Ccy:</b></td>
        <td><%=sclr.getOrigCcy()%></td>
        <td><b>COR:</b></td>
        <td><%=HTMLUtils.createCor("cor", HTMLUtils.DISPLAY, sclr.getCor())%></td>
        <td><b>LOC:</b></td>
        <td><%=sclr.getLoc()%></td>
        </tr>
        <tr>
          <td><b>Peer Review:</b></td>
        <td><%=sclr.getPeerReview()%></td>
        <td><b>Mvmt Ref/Date:</b></td>
        <td><%=sclr.getMvmtRefDate()%></td>
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
                <div class="noscroll">
                <table class="custom" border="0">
                  <tr>
                    <td width="25%">L/R Adjustment as at</td>
                    <td width="25%"><%=HTMLUtils.createDate("lrAdjustmentAsAt", (sclr.getLrAdjustmentAtFlag()?HTMLUtils.READONLY:HTMLUtils.NORMAL), sclr.getLrAdjustmentAt())%></td>
                    <td width="20%">Interest</td>
                    <td width="30%"><input type="text" name="interest" value="<%=sclr.getInterest()%>" <%=sclr.getInterestFlag()%>></td>
                  </tr>
                  <tr>
                    <td>Refunded L/R</td>
                    <td><input type="text" name="refundedLR" value="<%=sclr.getRefundedLR()%>" <%=sclr.getRefundedLRFlag()%>></td>
                    <td>Tax</td>
                    <td><input type="text" name="tax" value="<%=sclr.getTax()%>" <%=sclr.getTaxFlag()%>></td>
                  </tr>
                  <tr>
                    <td>Paid Claim</td>
                    <td><input type="text" name="paidClaim" value="<%=sclr.getPaidClaim()%>" <%=sclr.getPaidClaimFlag()%>></td>
                    <td>Net</td>
                    <td><input type="text" name="net" value="<%=sclr.getNet()%>" <%=sclr.getNetFlag()%>></td>
                  </tr>
                  <tr>
                    <td>L/R Advanced</td>
                    <td><input type="text" name="lrAdvanced" value="<%=sclr.getLrAdvanced()%>" <%=sclr.getLrAdvancedFlag()%>></td>
                    <td>O/S</td>
                    <td>
                      <table class="custom" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="75%" style="padding-left:0px"><input type="text" name="osAmount" value="<%=sclr.getOSAmount()%>" <%=sclr.getOSAmountFlag()%>></td>
                          <td width="25%" style="padding-left:0px">
                            <%=HTMLUtils.createDropdownWOldVals("osQualifier",sclr.getOSQual(),sclr.getOSQualFlag(),osAmtQualList)%>
                          </td>
                        </tr>
                      </table>
                    </td>
                  </tr>
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
<%-- if (user.updateMode()) { --%>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/singleclaimlossreservescontent.js"></script>
<%-- } --%>
</form>
</table>
</span>

<!-- To insert comma in the financial amount fields on load of this screen -->
<!-- Though commas are inserted by vField, but this is required when user comes on the screen after history.go(-1) -->
<script>
	document.body.onload = (function() {
							document.forms[0].interest.value = insertCommas(document.forms[0].interest.value)
							document.forms[0].refundedLR.value = insertCommas(document.forms[0].refundedLR.value)
							document.forms[0].paidClaim.value = insertCommas(document.forms[0].paidClaim.value)

							document.forms[0].net.value = insertCommas(document.forms[0].net.value)
							document.forms[0].lrAdvanced.value = insertCommas(document.forms[0].lrAdvanced.value)
							document.forms[0].osAmount.value = insertCommas(document.forms[0].osAmount.value)
							});
</script>
