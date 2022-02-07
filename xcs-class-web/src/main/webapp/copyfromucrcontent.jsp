<%@ page import="com.xchanging.xcc.web.html.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="copyfromucr" type="com.xchanging.xcc.web.models.CopyFromUcrModel" scope="session" />

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/copyfromucrcontentcustom.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<form name="copyfromucrcontent" method="Post">
<input type="submit" name="submitButton" style="display:none">
<span class="lhsNav">
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Copy From UCR")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR033\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/copyfromucrok\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="noscroll">
                  <table class="custom">
                    <tr>
                      <td style="width:20%"></td>
                      <td style="width:25%"></td>
                      <td style="width:35%"></td>
                      <td style="width:20%"></td>
                    </tr>
                    <tr>
                      <td colspan="4">
                        Please enter claim from which details are to be copied
                      </td>
                    </tr>
                    <tr>
                      <td colspan="4">&nbsp;</td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td>UCR or XCR</td>
                      <td><%=HTMLUtils.createUcr("ucr",HTMLUtils.NORMAL,copyfromucr.getUcr())%></td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td>TR</td>
                      <td><%=HTMLUtils.createUcr("tr",HTMLUtils.NORMAL,copyfromucr.getTr())%></td>
                      <td>&nbsp;</td>
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
<% if (user.updateMode()) { %>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/copyfromucrcontent.js"></script>
<% } %>
</form>