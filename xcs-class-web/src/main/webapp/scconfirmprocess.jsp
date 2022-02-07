<%@ page import="com.xchanging.xcc.web.html.*,com.xchanging.xcc.web.models.*,java.util.*" %>
<jsp:useBean id="schemecanada" type="com.xchanging.xcc.web.models.SchemeCanadaWebModel" scope="session" />
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>
<script src="<%=request.getContextPath()%>/js/tabs.js"></script>
<script src="<%=request.getContextPath()%>/js/debug.js"></script>
<form>
<input type="submit" name="submitButton" style="display:none">
<span class="lhsNav">
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header"> 
            <%=HTMLUtils.createHeader("Scheme Canada Confirm Re-Process")%>                        
          </div>
        </div>
        <div class="menuBar">          
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/scConfirmProcess\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","back()")%>                   
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="noscroll">
                  <table class="custom">
                    <tr>
                      <td>
                        <br>Are you sure you wish to proceed with Re-processing?<br><br>
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
</form>



