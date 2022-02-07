<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="premcomp" type="com.xchanging.xcc.web.models.PremiumComparisonModel" scope="session"/>

<form method="post">
<input type="submit" name="submitButton" style="display:none">
<link href="Xtech.css" rel="stylesheet" type="text/css">
<!-- content centering table -->
<span class="lhsNav">
<table class="formCenter">
 <%
 Enumeration e = request.getParameterNames();
  while (e.hasMoreElements()) {
   String s = (String)e.nextElement();
   if (!s.equals("ignoreWarnings")) { %>
    <input type="hidden" name="<%=s%>" value="<%=HTMLUtils.escapeChars(request.getParameter(s))%>">
   <% }
 }%>
 <tr>
  <td></td>
  <td class="content">
   <!-- main content div -->
   <div class="outerWindow">
    <!-- main top graphic placement div -->
    <div class="top">
     <!-- form heading div -->
     <div class="header">
      <!-- heading table -->
      <%=HTMLUtils.createHeader("Premium Comparison")%>
      <!-- form help button -->
      <!-- Below help button is no longer required since the information displayed is out of date -->
      <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"PRMCMP\")")%> -->
     </div>
    </div>
    <div class="menuBar">
     <!-- MENU BUTTONS GO HERE -->
     <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","submitForm(\"" + request.getContextPath() + "/control/premcompok\")")%>
     <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","errorBack()")%>
    </div>
    <div class="content">
     <!-- content tables -->
     <div>
      <table class="headerInfo" border="0">
       <tr>
         <td style="width:33%"></td>
         <td style="width:33%"></td>
         <td style="width:33%"></td>
       </tr>
       <tr>
        <td><b>OSND 1:</b>&nbsp;&nbsp;<%=HTMLUtils.createOsnd("osnd",HTMLUtils.DISPLAY,premcomp.getOsnd(0))%></td>
        <td><b>OSND 2:</b>&nbsp;&nbsp;<%=HTMLUtils.createOsnd("osnd",HTMLUtils.DISPLAY,premcomp.getOsnd(1))%></td>
        <td><b>OSND 3:</b>&nbsp;&nbsp;<%=HTMLUtils.createOsnd("osnd",HTMLUtils.DISPLAY,premcomp.getOsnd(2))%></td>
       </tr>
      </table>
     </div>
     <br>
     <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
      <tr>
       <td valign="top" >
        <table width="100%" border="0" class="custom">
         <tr>
          <td style="width:10%"></td>
          <td style="width:20%"></td>
          <td style="width:30%"></td>
          <td style="width:30%"></td>
          <td style="width:10%"></td>
         </tr>
         <tr>
          <td></td>
          <td></td>
          <td><strong>CLASS System</strong></td>
          <td><strong>Premium System</strong></td>
          <td></td>
         </tr>
         <tr>
          <td></td>
          <td><strong>Risk Code</strong></td>
          <td <%=premcomp.getRiskCodeHL()%>><%=premcomp.getClassRiskCode()%></td>
          <td><%=premcomp.getPremRiskCode()%></td>
          <td></td>
         </tr>
         <tr>
          <td></td>
          <td><strong>Year of Acc</strong></td>
          <td <%=premcomp.getYearOfAccHL()%>><%=premcomp.getClassYearOfAcc()%></td>
          <td><%=premcomp.getPremYearOfAcc()%></td>
          <td></td>
         </tr>
         <tr>
          <td>&nbsp;</td>
         </tr>
         <tr>
          <td colspan="5">
           <div style="width:580; border:thin solid #0099CC">
            <table width="562" border="0" cellspacing="0" cellpadding="0" class="dataTable" style="border-bottom:0px">
             <tr>
              <td style="width:20%"></td>
              <td style="width:11%"></td>
              <td style="width:11%"></td>
              <td style="width:10%"></td>
              <td style="width:11%"></td>
              <td style="width:11%"></td>
              <td style="width:11%"></td>
              <td style="width:15%"></td>
             </tr>
             <tr>
              <th align="left">COR</th>
              <th align="left">FIL 1</th>
              <th align="left">FIL 2</th>
              <th align="left">DTI Code</th>
              <th align="left">US TF Code</th>
              <th align="left">Other TF</th>
              <th align="left">Orig Ccy</th>
              <th align="left">Ctry Origin</th>
             </tr>
           </table>
           <div style="overflow:auto; width:578; height:90;padding-left:10px">
            <div class="scrollcontent" style="width:552">
             <table border="0" cellpadding="0" cellspacing="0" width="100%">
              <tr>
               <td style="width:20%"></td>
               <td style="width:11%"></td>
               <td style="width:11%"></td>
               <td style="width:10%"></td>
               <td style="width:11%"></td>
               <td style="width:11%"></td>
               <td style="width:11%"></td>
               <td style="width:15%"></td>
              </tr>
              <tr>
               <td colspan="8"><strong>CLASS System</strong></td>
              </tr>
              <% Enumeration clas = premcomp.getClassValues();
              while (clas.hasMoreElements()) {
               PremiumComparisonModel.Value value = (PremiumComparisonModel.Value)clas.nextElement(); %>
               <tr>
                <td><%=value.getCor()%></td>
                <td <%=value.getFilCode1HL()%>><%=value.getFilCode1()%></td>
                <td <%=value.getFilCode2HL()%>><%=value.getFilCode2()%></td>
                <td <%=value.getDtiCodeHL()%>><%=value.getDtiCode()%></td>
                <td <%=value.getTfCodeHL()%>><%=value.getTfCode()%></td>
                <td <%=value.getOtherTfCodeHL()%>><%=value.getOtherTfCode()%></td>
                <td <%=value.getOrigCcyHL()%>><%=value.getOrigCcy()%></td>
                <td <%=value.getCountryHL()%>><%=value.getCountry()%></td>
               </tr>
              <% } %>
            </table>
           </div>
          </div>
          <div style="overflow:auto; width:578; height:90;padding-left:10px;background-color:#9DD7EB">
           <div class="scrollcontent" style="width:552;">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
             <tr>
              <td style="width:20%"></td>
              <td style="width:11%"></td>
              <td style="width:11%"></td>
              <td style="width:10%"></td>
              <td style="width:11%"></td>
              <td style="width:11%"></td>
              <td style="width:11%"></td>
              <td style="width:15%"></td>
             </tr>
             <tr>
              <td colspan="8"><strong>Premium System</strong></td>
             </tr>
             <% Enumeration premium = premcomp.getPremiumValues();
             while (premium.hasMoreElements()) {
              PremiumComparisonModel.Value value = (PremiumComparisonModel.Value)premium.nextElement(); %>
              <tr>
               <td><%=value.getCor()%></td>
               <td <%=value.getFilCode1HL()%>><%=value.getFilCode1()%></td>
               <td <%=value.getFilCode2HL()%>><%=value.getFilCode2()%></td>
               <td <%=value.getDtiCodeHL()%>><%=value.getDtiCode()%></td>
               <td <%=value.getTfCodeHL()%>><%=value.getTfCode()%></td>
               <td <%=value.getOtherTfCodeHL()%>><%=value.getOtherTfCode()%></td>
               <td <%=value.getOrigCcyHL()%>><%=value.getOrigCcy()%></td>
               <td <%=value.getCountryHL()%>><%=value.getCountry()%></td>
              </tr>
            <% } %>
           </table>
          </div>
         </div>
        </div>
       </td>
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
</form>