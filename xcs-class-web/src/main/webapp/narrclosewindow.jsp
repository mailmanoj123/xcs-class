<script src="<%=request.getContextPath()%>/js/main.js"></script>
<script>
if (<%=request.getParameter("cd")%>)
  window.opener.submitForm("<%=request.getContextPath()%>/control/refreshclaimdetails");
closeWindow();
</script>