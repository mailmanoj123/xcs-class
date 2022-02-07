<%@ page import="com.xchanging.xcc.web.html.*" %>
<jsp:useBean id="bulkccscorr" type="com.xchanging.xcc.web.models.BulkCcsCorrectionModel" scope="session" />
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/bulkccscorrectioncontentcustom.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<form name="bulkccscorrectioncontent" method="Post">
<input type="submit" name="submitButton" style="display:none">
<span class="lhsNav">
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Bulk/CCS Correction")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
			<!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR036\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/bulkccscorrectionok\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="noscroll">
                  <table class="custom">
                    <tr>
                      <td colspan="5">
                        Are you sure you want to release this Bulk/CCS Correction?
                      </td>
                    </tr>
                    <tr>
                      <td colspan="5">&nbsp;</td>
                    </tr>
                    <tr>
                      <td colspan="5">
                        Please enter treasury rate(s)
                      </td>
                    </tr>
                    <tr>
                      <td width="20%">&nbsp;</td>
                      <td width="20%" align="center">Orig Ccy</td>
                      <td width="20%" align="center">Sett Ccy</td>
                      <td width="20%" align="center">Treasury Rate Sett: GBP</td>
                      <td width="20%">&nbsp;</td>
                    </tr>
                    <tr>

                      <td>&nbsp;</td>
                      <td>
                        <table width="100%" cellpadding="0" cellspacing="0" border="0">
                          <tr>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                            <td width="50%" style="padding-left:0px;"><input type="text" name="origCcy1" value="<%=bulkccscorr.getOrigCcy1()%>" <%=bulkccscorr.getOrigCcy1Flag()%>></td>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" cellpadding="0" cellspacing="0" border="0">
                          <tr>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                            <td width="50%" style="padding-left:0px;"><input type="text" name="settCcy1"  value="<%=bulkccscorr.getSettCcy1()%>" <%=bulkccscorr.getSettCcy1Flag()%>></td>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                      <td><input type="text" name="treasuryRate1" <%=bulkccscorr.getTreasuryRate1Flag()%> value="<%=bulkccscorr.getTreasuryRate1()%>"></td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td>
                        <table width="100%" cellpadding="0" cellspacing="0" border="0">
                          <tr>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                            <td width="50%" style="padding-left:0px;"><input type="text" name="origCcy2" value="<%=bulkccscorr.getOrigCcy2()%>" <%=bulkccscorr.getOrigCcy2Flag()%>></td>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" cellpadding="0" cellspacing="0" border="0">
                          <tr>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                            <td width="50%" style="padding-left:0px;"><input type="text" name="settCcy2" value="<%=bulkccscorr.getSettCcy2()%>" <%=bulkccscorr.getSettCcy2Flag()%>></td>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                      <td><input type="text" name="treasuryRate2" <%=bulkccscorr.getTreasuryRate2Flag()%> value="<%=bulkccscorr.getTreasuryRate2()%>"></td>
                      <td>&nbsp;</td>
                    </tr>
					<tr>
                      <td>&nbsp;</td>
                      <td>
                        <table width="100%" cellpadding="0" cellspacing="0" border="0">
                          <tr>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                            <td width="50%" style="padding-left:0px;"><input type="text" name="origCcy3" value="<%=bulkccscorr.getOrigCcy3()%>" <%=bulkccscorr.getOrigCcy3Flag()%>></td>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" cellpadding="0" cellspacing="0" border="0">
                          <tr>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                            <td width="50%" style="padding-left:0px;"><input type="text" name="settCcy3" value="<%=bulkccscorr.getSettCcy3()%>" <%=bulkccscorr.getSettCcy3Flag()%>></td>
                            <td width="25%" style="padding-left:0px;">&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                      <td><input type="text" name="treasuryRate3" <%=bulkccscorr.getTreasuryRate3Flag()%> value="<%=bulkccscorr.getTreasuryRate3()%>"></td>
                      <td>&nbsp;</td>
                    </tr>
					<tr>
                      <td colspan="5" align="center">
                        <table>
                          <tr>
                            <td>Reduce outstanding amount to zero?</td>
                            <td width="15px"><input type="checkbox" name="reduceOSAmount"></td>
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
</table>
</span>
<%-- if (!user.updateMode()) { --%>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/bulkccscorrectioncontent.js"></script>
<%-- } --%>
</form>
