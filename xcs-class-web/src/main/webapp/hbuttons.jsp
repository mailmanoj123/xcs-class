<%@ page import="com.xchanging.xcc.web.html.*" %>

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<table cellpadding="0" cellspacing="0" width="100%" height="40">
  <tr>
    <td align="right" valign="bottom"> <table border="0" cellpadding="0" cellspacing="0" background="<%=request.getContextPath()%>/images/headerLink.gif" class="headerNav">
      <tr>
          <td></td>
          <td><%=HTMLUtils.createButton(HTMLUtils.HEADER,"home","submitForm(\"" + request.getContextPath() + "/control/home\")")%></td>
          <td class="spacer">&nbsp;</td>
          <td><%=HTMLUtils.createButton(HTMLUtils.HEADER,"logoff","logoff()")%></td>
          <td class="spacer">&nbsp;</td>
          <td><%=HTMLUtils.createButton(HTMLUtils.HEADER, "autologoffButton", "30", "window.open(\"" + request.getContextPath() + "/autologoffhelp.jsp\",\"\",\"HEIGHT=250,WIDTH=830,menubar, resizable, scrollbars\");")%></td>
        </tr>
      </table></td>
  </tr>
</table>