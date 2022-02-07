<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="findclaim" type="com.xchanging.xcc.web.models.FindClaimModel" scope="session" />
<jsp:useBean id="catCodeList" type="com.xchanging.xcc.web.models.reference.CatCodeList" scope="application" />

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/findclaimcontentcustom.js"></script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="findclaimcontent" method="Post">
<input type="submit" name="submitButton" style="display:none">
<input type="hidden" name="mode">

<script>
function changeTab(num) {
  if (Number(num) == 1) {
    document.all.mode.value = "BASIC";
  }
  else {
    document.all.mode.value = "ADVANCED";
  }
  showTab(num);
}
</script>

  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Find Claim")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR005\")")%> -->
          </div>
        </div>

        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Claim Search","submitForm(\"" + request.getContextPath() + "/control/findclaimsearch\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/home\", false)")%>
        </div>

        <div class="content">
          <table border="0" cellpadding="0" cellspacing="0" class="multiPartTabbed" >
            <tr>
              <td align="center">
                <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Basic Search","changeTab(1)")%>
              </td>
              <td align="center">
                <%=HTMLUtils.createButton(HTMLUtils.NAVIGATION,"Advanced Search","changeTab(2)")%>
              </td>
            </tr>
          </table>
          <br>
         <div id="tab1" style="display:none">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
              <div class="noscroll">
                <table class="custom" width="100%" border="0">
                  <tr>
                    <td width="10%"></td>
                    <td width="30%">UCR/XCR</td>
                    <td width="50%"><%=HTMLUtils.createUcr("ucrXcr", HTMLUtils.NORMAL, findclaim.getUcr())%></td>
                    <td width="10%"></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>Bkr UCR</td> 
                    <td><%=HTMLUtils.createUcr("bkrUcr", HTMLUtils.NORMAL, findclaim.getBkrUcr())%></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>TR</td>
                    <td><%=HTMLUtils.createUcr("tr", HTMLUtils.NORMAL, findclaim.getTr())%></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>COR</td>
                    <td><%=HTMLUtils.createCor("cor", HTMLUtils.NORMAL, findclaim.getCor())%></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>OSND</td>
                    <td><%=HTMLUtils.createOsnd("osnd", HTMLUtils.NORMAL, findclaim.getOsnd())%></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>TDN</td>
                    <td><%=HTMLUtils.createTdn("tdn", HTMLUtils.NORMAL, findclaim.getTdn())%></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>Group Ref</td>
                    <td><%=HTMLUtils.createGroupRef("groupRef", HTMLUtils.NORMAL, findclaim.getGroupRef())%></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>Certificate of Insurance No.</td>
                    <td><input type="text" name="certNo" id="certNo" value="<%=findclaim.getCertNo() %>"></td>
                    <td></td>
                  </tr>
                </table>
                </div>
              </td>
            </tr>
          </table>
          </div>
         <script>changeTab(1)</script>
        <div id="tab2" style="display:none">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent">
            <tr>
              <td valign="top" >
              <div class="noscroll">
                <table class="custom" border="0">
				  <tr>
				  	<td style="width:35%"></td>
					<td style="width:30%"></td>
					<td style="width:5%"></td>
					<td style="width:30%"></td>
				  </tr>
                  <tr>
                    <td>Name 1</td>
                    <td colspan="3"><input type="text" name="name1" value=""></td>
                  </tr>
                  <tr>
                    <td>Name 2</td>
                    <td colspan="3"><input type="text" name="name2" value=""></td>
                  </tr>
                  <tr>
                    <td>DOL/DCM</td>
                    <td><%=HTMLUtils.createDate("dateOfLossFrom",HTMLUtils.NORMAL,"")%></td>
                    <td>To</td>
                    <td><%=HTMLUtils.createDate("dateOfLossTo",HTMLUtils.NORMAL,"")%></td>
                  </tr>
                  <tr>
                    <td>CAT Code</td>
                    <td>
                      <%=HTMLUtils.createDropdown("catCode","",false,catCodeList)%>
                    </td>
                  </tr>
                  <tr>
                    <td>User Id</td>
                    <td> <input type="text" name="user" value=""></td>
                  </tr>
                  <tr>
                    <td>Date Processed Range</td>
                    <td><%=HTMLUtils.createDate("dateProcessedFrom",HTMLUtils.NORMAL,"")%></td>
                    <td>To</td>
                    <td><%=HTMLUtils.createDate("dateProcessedTo",HTMLUtils.NORMAL,"")%></td>
                  </tr>
                   <tr>
                    <td>Claimant</td>
                    <td colspan="3"><input type="text" name="claimant" value=""></td>
                  </tr>
                   <tr>
                    <td>Broker Reference</td>
                    <td> <input type="text" name="bkrRef" value=""></td>
                  </tr>
                </table>
                </div>
              </td>
            </tr>
          </table>
        </div>
        </div>
        <div class="bot"></div>
      </div>
    </td>
    <td></td>
  </tr>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/findclaimcontent.js"></script>
</form>
</table>
</span>