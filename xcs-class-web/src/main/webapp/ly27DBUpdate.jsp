<script src="<%=request.getContextPath()%>/js/main.js"></script>
<form>
<input type="submit" name="submitButton" style="display:none">
</form>
<script>
var sessionid="<%=request.getSession().getId()%>";
submitForm("<%=request.getContextPath()%>/control/update27DB");
</script>
