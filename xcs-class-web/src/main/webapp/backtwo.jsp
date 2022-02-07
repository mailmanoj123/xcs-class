<script src="<%=request.getContextPath()%>/js/main.js"></script>
<script>
var backThree = <%=request.getParameter("fromWarning")%>;
if (backThree)
  history.go(-3);
else if (history.length>1)
  history.go(-2);
else
  closeWindow();
</script>