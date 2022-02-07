<%@ taglib uri="/tlds/taglib.tld" prefix="screen" %>

<html>
  <head>
    <title>
      <screen:insert parameter="ScreenTitle" />
    </title>
    <script language="JavaScript">
      var hasLogoffTimer = false ;
    </script>
    <script src='<%=request.getContextPath()%>/js/main.js'></script>
  </head>

  <body leftmargin="0" topmargin="0" rightmargin="0" onUnload="winCloseCheck()">
    <table id="mainTable" width="100%" cellspacing="0" border="0">
      <tr>
        <td valign="middle">
          <screen:insert parameter="ScreenBody" />
        </td>
      </tr>
    </table>
    <div id="splash" style="display:none">
      <jsp:include page="splashscreen.jsp" />
    </div>
    <script language="JavaScript">
      document.forms[0].onsubmit=submitMethod;
    </script>
  </body>

</html>
