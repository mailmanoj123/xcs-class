<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="narrative" type="com.xchanging.xcc.web.models.NarrativeModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>

<script language="JavaScript" src="<%=request.getContextPath()%>/js/debug.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/error.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/messagelist.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vfield.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vform.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vtab.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/VGroup.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/positionlayer.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphavalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphaextendedvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/decimalvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/datevalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/narrativecustom.js"></script>
<script>
function wordwraps(val,lineLength) {
        var lastCr=0;
        var counter=0;
        while (val.length-lastCr>lineLength) {
                counter++;
                var temp = val.substring(lastCr,lastCr+lineLength);
                if (temp.lastIndexOf(" ")==-1)
                        lastCr += lineLength;
                else
                        lastCr += val.substring(lastCr,lastCr+lineLength).lastIndexOf(" ")+1;
        }
        return counter;
}

function lengthCheck(ta,maxLines,lineLength) {
        if (event.keyCode==13)
                event.returnValue=false;

  var val = ta.value;
  var counter=0;
  var lastCr=0;

        while (val.indexOf("\r\n")>-1) {
                counter++;
                var temp = val.substring(0,val.indexOf("\r\n"));
                counter += wordwraps(temp,lineLength);
                val = val.substring(val.indexOf("\r\n")+2);
        }
        counter += wordwraps(val,lineLength);

  if (counter<maxLines) {
    ta.className="field";
  } else {
    ta.className="fieldError";
  }
}
</script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="narrativeContent">
<input type="submit" name="submitButton" style="display:none">
<input type="hidden" name="id" value="<%=narrative.getTextId()%>">
<input type="hidden" name="screen" value="<%=request.getParameter("screen")%>">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Narrative")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR035\")")%> -->
          </div>
        </div>

        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->

          <!-- Remedy 17752 - set the state of narrativeBeingSaved to true if it -->
          <!-- is being saved and false if cancel is pressed -->
 <% if (narrative.getScreenMode().equals("U")) { %>
 <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","narrativeBeingSaved=true; submitForm(\"" + request.getContextPath() + "/control/narrativeok\")")%>
 <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","narrativeBeingSaved=true; submitForm(\"" + request.getContextPath() + "/control/narrativesave\")")%>
 <% } %>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","narrativeBeingSaved=false; submitForm(\"" + request.getContextPath() + "/control/narrativecancel\")")%>

        </div>

        <div class="content">
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="noscroll">
                  <table class="custom">
                    <tr>
                      <td width="100%"><%=narrative.getTextType()%></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td>
                        <% Enumeration explText = narrative.getExplanatoryText();
                             while (explText.hasMoreElements()) { %>
                            <%=(String)explText.nextElement()%><br>
                        <% } %>
                      </td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td>
                                                                                                <% String narr = "";
                                                                                                   Enumeration narrDets = narrative.getNarrativeDetails();
                                                                                                   boolean first = true;
                                                                                                   while(narrDets.hasMoreElements()) {
                                                                                                     if (first)
                                                                                                       first = false;
                                                                                                     else
                                                                                                       narr += "\r\n";

                                                                                                     narr += ((String)narrDets.nextElement());
                           } %>

                        <textarea name="narr" wrap="hard" rows="20" cols="<%=narrative.getLineLength()%>" style="width:auto;font-family:courier" onKeyUp="lengthCheck(this,<%=narrative.getMaxNoLines()%>,<%=narrative.getLineLength()%>)" maxLines="<%=narrative.getMaxNoLines()%>" <%=narrative.getNarrativeDetailsFlag()%>><%=narr%></textarea>
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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/narrativecontent.js"></script>
<input type="hidden" name="cd" value="<%=(request.getParameter("cd")!=null)&&(request.getParameter("cd").equals("true"))%>">
</form>
</table>
</span>
<script>
if ((document.all.cd.value=="true") && (<%=narrative.isSaved()%>))
  window.opener.submitForm("<%=request.getContextPath()%>/control/refreshclaimdetails");
</script>
