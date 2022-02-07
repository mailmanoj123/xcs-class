<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.DiaryEntry" %>

<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session"/>
<jsp:useBean id="diary" type="com.xchanging.xcc.web.models.DiaryListWebModel" scope="session"/>

<form method="post">
<input type="submit" name="submitButton" style="display:none">
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>
<!-- content centering table -->
<table class="formCenter">
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
          <%=HTMLUtils.createHeader("Home")%>
          <!-- form help button -->
          <!-- Below help button is no longer required since the information displayed is out of date -->
          <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR003\")")%> -->
        </div>
        <!-- content div -->
                                </div>
        <div class="content">
          <!-- content tables -->
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <table width="100%" border="0" class="1column">
                  <tr>
                                        <td><strong>Welcome <%=user.getUsername()%>,</strong></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td> Here are your Diary entries for today: </td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td>
                                                                                        <div class="scrolling">
                      <div class="scrollcontent">
                                                                                        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="competencyDisplay">
                        <tr>
                          <th align="left">UCR</th>
                          <th align="left">Name1</th>
                          <th align="left">Name 2</th>
                          <th align="left">Bkr Claim Ref 1</th>
                          <th align="left">DOL From</th>
                          <th align="left">DOL To</th>
                        </tr>
            <% Enumeration diaryEntries = diary.getEntries();
                 DiaryEntry entry;
            %>
            <% while (diaryEntries.hasMoreElements()) {
                     entry = (DiaryEntry)diaryEntries.nextElement(); %>
                            <tr>
                                    <td><%=entry.getUcr()%></td>
                                           <td><%=entry.getName1()%></td>
                                    <td><%=entry.getName2()%></td>
                                    <td><%=entry.getBkrRef()%></td>
                                    <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,entry.getLossDateFrom())%></td>
                                    <td><%=HTMLUtils.createDate("",HTMLUtils.DISPLAY,entry.getLossDateTo())%></td>
                            </tr>
            <% } %>
</table>
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
</div></td>
<td></td>
</tr>
</table>
<script>altColumnRows('competencyDisplay',1)</script>
</form>