<script src="<%=request.getContextPath()%>/js/main.js"></script>

<script language="JavaScript">
  var logoffTimerObject = null ;
  var logoffTimer = 0;
  var hasLogoffTimer = true ;

  function resetLogoffTimer() {
    if (logoffTimerObject != null) {
      window.clearInterval(logoffTimerObject) ;
    }
    logoffTimer = 30 ;
    logoffTimerObject = window.setInterval("doLogoffTimer();", 60000) ;

    // Change the autologoff button text
    if (document.all.autologoffButton != null) {
      document.all.autologoffButton.rows(0).cells(1).innerText=logoffTimer ;
    }
  }

  function disableLogoffTimer() {
    if (logoffTimerObject != null) {
      window.clearInterval(logoffTimerObject) ;
    }
    logoffTimer = 30 ;
    // Change the autologoff button text
    if (document.all.autologoffButton != null) {
      document.all.autologoffButton.rows(0).cells(1).innerText="disabled" ;
    }
  }

  function doLogoffTimer() {
    logoffTimer-- ;

    logoffTimerSwitch: switch (logoffTimer) {
      case 5:
        // Display the warning message
        window.open("<%=request.getContextPath()%>/autologoffwarning.jsp", "", "HEIGHT=250,WIDTH=830,menubar, resizable, scrollbars") ;
        break logoffTimerSwitch;
      case 0:
        // Perform the logout
        scAutoLogoff() ;
        break logoffTimerSwitch;
    }

    // Change the autologoff button text
    if (document.all.autologoffButton != null) {
      document.all.autologoffButton.rows(0).cells(1).innerText=logoffTimer ;
    }
  }

  function scAutoLogoff() {
    window.opener.resetLogoffTimer() ;
    goTo("<%=request.getContextPath()%>/control/scautologoff");
  }

  resetLogoffTimer() ;

</script>
