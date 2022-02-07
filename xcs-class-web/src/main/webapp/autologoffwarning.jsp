<%@ page import="com.xchanging.xcc.web.html.*,com.xchanging.xcc.exceptions.*,java.util.*" %>
<%@ page isErrorPage="true" %>

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<span class="lhsNav">
<table class="formCenter">
  <tr>
    <td></td>
    <td class="content">
      <!-- main content div -->
      <div class="outerWindow">
        <!-- main top graphic placement div -->
        <div class="top">
          <!-- form heading div -->
          <div class="header"> <%=HTMLUtils.createHeader("Automatic Logoff")%>
          </div>
        </div>
        <div class="menuBar"> <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","window.close();")%>
        </div>
        <div class="content">
          <!-- content tables -->
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <table width="100%" border="0" class="1column">

                  <tr>
                    <td> To conserve resources, you will be automatically logged out from the system if
                    you do not navigate to another screen in 5 minutes time.<p>

                    You should save or continue to prevent loss of work.</td>
                  </tr>
                  <tr>
                    <td colspan="2">&nbsp;</td>
                  </tr>
                </table>
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