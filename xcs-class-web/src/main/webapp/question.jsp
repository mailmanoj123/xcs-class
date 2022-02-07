<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.QuestionModel" %>
<jsp:useBean id="question" type="com.xchanging.xcc.web.models.QuestionModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script src="<%=request.getContextPath()%>/js/tabs.js"></script>


<!-- To remove menu bar, remove below span class and remove any menu buttons -->
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
            <%=HTMLUtils.createHeader(question.getTitle())%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"QUESTION\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
          <% Enumeration answers = question.getAnswers();
             while (answers.hasMoreElements()) {
               QuestionModel.Answer answer = (QuestionModel.Answer)answers.nextElement();
               %>
               <%=HTMLUtils.createButton(HTMLUtils.ACTION,answer.getText(),"submitForm(\"" + request.getContextPath() + answer.getTarget() + "\")")%>
               <%
             }%>
        </div>
        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="noscroll">
                  <table class="custom">
                    <tr>
                      <td colspan="4">
                        <%=question.getText()%>
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