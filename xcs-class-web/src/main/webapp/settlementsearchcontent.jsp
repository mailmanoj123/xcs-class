<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<!-- jsp:useBean id="settlementsearch" type="com.xchanging.xcc.web.models.SettlementSearchModel" scope="session" /-->

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/settlementsearchcontentcustom.js"></script>

<!-- script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/settlementsearchcontentcustom.js"></script -->
<script language="JavaScript">
function ResetForm(){
document.settlementsearchcontent.reset();
}
</script>
<!-- To remove menu bar, remove below span class and remove any menu buttons -->
  <span class="lhsNav">
    <table class="formCenter">
      <form name="settlementsearchcontent" method="Post">
        <input type="submit" name="submitButton" style="display:none">
        <tr>
          <td></td>
          <td class="content">
            <div class="outerWindow">
              <div class="top">
                <div class="header">
                  <%=HTMLUtils.createHeader("Settlement Search")%>
                  <!-- Below help button is no longer required since the information displayed is out of date -->
                  <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR005\")")%> -->                  
                </div>
              </div>

              <div class="menuBar">
                <!-- MENU BUTTONS GO HERE -->
                <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Search","submitForm(\"" + request.getContextPath() + "/control/settlementsearchresults\")")%>
                <!--<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/settlementsearchcontentcancel\")")%>
                -->
                <!--Changed cancel to reset form using javascript - STH - 14-01-2004 -->
                <table name='cancelButton' id='cancelButton' border='0' cellpadding='0' cellspacing='0' class='actionButton' onClick='ResetForm();'>
                  <tr>
                    <td class='left'>&nbsp;</td>
                    <td class='middle'> Cancel</td>
                    <td class='right'>&nbsp;</td>
                 </tr>
               </table>
              </div>

              <div class="content">
                <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
                  <tr>
                    <td valign="top" >
                      <div class="noscroll">
                      <table class="custom" width="100%" border="0">
                          <tr>
                             <td style="width:15%"></td>
                             <td style="width:60%"></td>
                             <td style="width:15%"></td>
                             <td style="width:10%"></td>
                          </tr>
                          <tr>
                            <td>TDN</td>
                            <td><%=HTMLUtils.createTdn("C115_TAKE_DOWN_DATE", HTMLUtils.NORMAL, "")%></td>
                            <td></td>
                            <td></td>
                          </tr>
                          <tr>
                            <td>OSND</td>
                            <td><%=HTMLUtils.createOsnd("C115_ORIG_SIGNING_DATE", HTMLUtils.NORMAL, "")%></td>
                            <td></td>
                            <td></td>
                          </tr>
                        </table>
                        <table class="custom" width="100%" border="0">
                          <tr>
                             <td style="width:15%"></td>
                             <td style="width:15%"></td>
                             <td style="width:20%"></td>
                             <td style="width:50%"></td>
                          </tr>
                          <tr>
                            <td>YOA</td>
                            <td><input type="text" name="C115_YEAR_OF_ACC" value="" size='5' maxlength='4'></td>
                            <td></td>
                            <td></td>
                          </tr>
                          <tr>
                            <td>Payee Broker</td>
                            <td><input type="text" name="C115_PAYEE_BKR" value="" size='5' maxlength='4'></td>
                            <td></td>
                            <td></td>
                          </tr>
                         </table>

                         <table class="custom" width="100%" border="0">
                          <tr>
                             <td style="width:15%"></td>
                             <td style="width:40%"></td>
                             <td style="width:5%"></td>
                             <td style="width:40%"></td>
                          </tr>
                          <tr>
                            <td>Completed Between</td>
                            <td><%=HTMLUtils.createDate("C115_COMP_BTW_FROM",HTMLUtils.NORMAL,"")%></td>
                            <td>and</td>
                            <td><%=HTMLUtils.createDate("C115_COMP_BTW_TO",HTMLUtils.NORMAL,"")%></td>
                          </tr>
                         </table>

                         <table class="custom" width="100%" border="0">
                          <tr>
                             <td style="width:15%"></td>
                             <td style="width:55%"></td>
                             <td style="width:20%"></td>
                             <td style="width:10%"></td>
                          </tr>
                          <!--Convert name 1 and 2 to Uppercase - STH 30/12/2003-->
                          <!--Change the Name 1 and Name 2 partial indicator fields to be check boxes -  DS 2/1/04 -->
                          <tr>
                            <td>Name 1</td>
                            <td ><input type="text" name="C115_NAME_1" value="" size='26' maxlength='25' ></td>
                            <td>Partial Name 1</td>
                            <td><input type="checkbox" name="C115_NAME_1_PARTIAL_IND"></td>
                          </tr>
                          <tr>
                            <td>Name 2</td>
                            <td><input type="text" name="C115_NAME_2" value="" size='26' maxlength='25' ></td>
                            <td>Partial Name 2</td>
                            <td><input type="checkbox" name="C115_NAME_2_PARTIAL_IND"></td>
                          </tr>
                        </table>
                      </div>
                    </td>
                  </tr>
                </table>

              </div>

              <div class="bot">
              </div>

            </div>

          </td>

          <td>
          </td>

        </tr>

        <script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/settlementsearchcontent.js"></script>

      </form>

    </table>

  </span>