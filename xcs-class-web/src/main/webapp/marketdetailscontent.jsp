<%@ page import="com.xchanging.xcc.web.html.*,java.util.*, com.xchanging.xcc.web.models.*" %>
<jsp:useBean id="user" type="com.xchanging.xcc.web.models.UserWebModel" scope="session" />
<jsp:useBean id="marketDetails" type="com.xchanging.xcc.web.models.MarketDetailsModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<script src="<%=request.getContextPath()%>/js/tabs.js"></script>
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
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/marketdetailscontentCustom.js"></script>


<script>
	function deleteSelected() {
		if (confirm("Are you sure you want to delete the selected lines?"))
			submitForm("<%=request.getContextPath()%>/control/marketdetailsdelete",false);
	}

        function checkDeleteSelected() {
          var anySelected = false;

          i=1;
          while ((delbox=eval("document.all.del" + i))!=null) {
            if (delbox.checked==true) {
              anySelected = true;
              break;
            }
            i++;
          }

          if (!anySelected) {
            i=1;
            while ((delbox=eval("document.all.delInsert" + i))!=null) {
              if (delbox.checked==true) {
                anySelected = true;
                break;
              }
              i++;
            }
          }

          if (anySelected) {
            alert("Lines have been selected for deletion.\n\nPlease press 'Delete Selected Lines' button or remove selections.");
            return false;
          } else
            return true;
        }
</script>


<script>
var lastRow=0;
var currentInsert=1;
var numberOfSyndicates = <%=marketDetails.getNoSyndicates()%> ;

function insertBlankRow() {
  var newRow;
  var newCell;

  // First time through we allow the user to insert a row.
  if (currentInsert != 1)
  {
    // Before insert is allowed check that the previous row has been fully populated.
    var previousInsert = currentInsert -1;
    if ((eval("document.forms[0].syndicateInsertNo" + previousInsert + ".value")=="") || (eval("document.forms[0].syndicatePercInsert" + previousInsert + ".value")=="") || (eval("document.forms[0].syndicateRefInsert" + previousInsert + ".value")==""))
    {
      alert("User cannot insert new lines without the previous line being populated");
      return;
    }
  }

  newRow = marketdetails.insertRow();

  newCell = newRow.insertCell();
  newCell.innerHTML="<input type='checkbox' name='delInsert" + currentInsert + "'>";

  newCell = newRow.insertCell();
  newCell.innerText=lastRow + currentInsert;

  newCell = newRow.insertCell();
  newCell.innerHTML="<input type='text' name='syndicateInsertNo" + currentInsert + "' maxlength='4'>";

  newCell = newRow.insertCell();
  newCell.innerHTML="<input type='text' name='syndicatePercInsert" + currentInsert + "' onBlur='recalculateTotalAmt();'  maxlength='10'>";

  newCell = newRow.insertCell();
  newCell.innerHTML="<input type='text' name='syndicateRefInsert" + currentInsert + "' maxlength='15'>";

  newCell = newRow.insertCell();
  newCell.innerHTML="&nbsp;";

  newCell = newRow.insertCell();
  newCell.innerHTML="&nbsp;";


  newCell = newRow.insertCell();
  newCell.innerHTML="<input type='checkbox' name='bureauLeaderInsert" + currentInsert + "'>";

  newCell = newRow.insertCell();
  newCell.innerText="";

  currentInsert++;

  marketdetails.insertRow();
  altColumnRows('marketdetails',2);

  // Update the total number of syndicates
  numberOfSyndicates++ ;
  document.all.noSyndicates.innerText = numberOfSyndicates ;
  document.all.vSyndCount.value =  numberOfSyndicates ;

}
</script>
<script>

function recalculateTotalAmt() {
var test;
var sumline = 0;

var xx = document.forms[0].origCount.value;

for (var i = 0; i < document.all.origCount.value; i++){
        test = eval("document.forms[0].syndicatePerc" + (i + 1) );
        sumline += Number(test.value);

}

for (var i = 0; i < currentInsert -1 ; i++){
        test = eval("document.forms[0].syndicatePercInsert" + (i + 1) );
        sumline += Number(test.value);

}

function toRoundString(numValue, iPlaces) {
        numWhole = new Number(numValue)
        numWhole = numWhole * Math.pow(10, iPlaces) ;
        numWhole = Math.round(numWhole) ;
        sWhole = numWhole.toString() ;
        pointPos = sWhole.length-iPlaces ;
        return sWhole.substring(0,pointPos) + "." + sWhole.substring(pointPos, sWhole.length) ;
}

document.all.totalLine.innerText = toRoundString(sumline, 7);

document.all.vTotalAmt.value = toRoundString(sumline, 7);

}
</script>

<!-- To remove menu bar, remove below span class and remove any menu buttons -->
<span class="lhsNav">
<table class="formCenter">
<form name="marketdetailscontent">
<input type="submit" name="submitButton" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Market Details")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"SCR013\")")%> -->
          </div>
        </div>
        <div class="menuBar">
          <!-- MENU BUTTONS GO HERE -->
		  <% if (!marketDetails.getDelSelButtonFlag()) { %>
	          <%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Delete Selected","deleteSelected()")%>
		  <% } %>
		  <% if (!marketDetails.getInsertButtonFlag()) { %>
          	<%=HTMLUtils.createButton(HTMLUtils.ACTION,"Insert","insertBlankRow()")%>
		  <% } %>
		  <% if (!marketDetails.getSaveButtonFlag()) { %>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Save","if (checkDeleteSelected()) submitForm(\"" + request.getContextPath() + "/control/marketdetailssave\")")%>
		  <% } %>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Continue","if (checkDeleteSelected()) submitForm(\"" + request.getContextPath() + "/control/marketdetailscontinue\")")%>
          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel","submitForm(\"" + request.getContextPath() + "/control/marketdetailscancel\", false)")%>
        </div>
        <div class="content">
          <!-- Optional header information -->
          <div>
            <table class="headerInfo" width="100%">
              <tr>
                <td><b>UCR:</b></td>
                <td><%=HTMLUtils.createUcr("hUcr",HTMLUtils.DISPLAY,marketDetails.getUcr())%></td>
                <td><b>XCR:</b></td>
                <td><%=HTMLUtils.createUcr("hXcr",HTMLUtils.DISPLAY,marketDetails.getXcr())%></td>
                <td><b>TR:</b></td>
                <td><%=HTMLUtils.createUcr("hTr",HTMLUtils.DISPLAY,marketDetails.getTr())%></td>
              </tr>
              <tr>
                <td><b>OSND1:</b></td>
                <td><%=HTMLUtils.createOsnd("hOsnd1",HTMLUtils.DISPLAY,marketDetails.getOsnd1())%></td>
                <td><b>OSND2:</b></td>
                <td><%=HTMLUtils.createOsnd("hOsnd2",HTMLUtils.DISPLAY,marketDetails.getOsnd2())%></td>
                <td><b>OSND3:</b></td>
                <td><%=HTMLUtils.createOsnd("hOsnd3",HTMLUtils.DISPLAY,marketDetails.getOsnd3())%></td>
              </tr>
              <tr>
                <td><b>Current Bkr:</b></td>
                <td><%=marketDetails.getOrigBkr()%></td>
                <td><b>Signed:</b></td>
                <td><%=marketDetails.getSigned()%></td>
                <td><b>Peer Review:</b></td>
                <td><%=marketDetails.getPeerReview()%></td>
              </tr>
            </table>
          </div>
          <br>
          <!-- end of optional header information -->
          <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
            <tr>
              <td valign="top" >
                <div class="scrollmain" style="height:340px" id="scrollpane">
                  <div class="scrollmaincontent">
                    <table class="6column">
                      <tr>
                        <td><strong>No of Syndicates</strong></td>
                        <td>
                        <span id="noSyndicates">
                        <%=marketDetails.getNoSyndicates()%>
                        </span>
                        </td>
                        <td><strong>Total Line</strong></td>
                        <td><span id="totalLine"><%=marketDetails.getTotalLine()%></span>%</td>
                        <td><strong>Market Source</strong></td>
                        <td><%=marketDetails.getMarketSource()%></td>
                      </tr>
                    </table>
                      <br><br>
                      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="marketdetails">
                        <tr>
                          <th align="left" width="5%">Del</th>
                          <th align="left" width="10%">Line No</th>
                          <th align="left" width="10%">Syndicate No</th>
                          <th align="left" width="15%">Syndicate %</th>
                          <th align="left" width="20%">Syndicate Ref</th>
                          <th align="left" width="14%">Opt Out Status</th>
                          <th align="left" width="16%">Opt Out Date</th>
                          <th align="left" width="5%">Bureau Leader</th>
                          <th align="left" width="5%">&nbsp;</th>
                        </tr>

                     <% Enumeration syndicates = marketDetails.getSyndicates();
                     	MarketDetailsSyndicate syndicate;
                     	int lineNo = 1;
                     	while (syndicates.hasMoreElements()) {
                     		syndicate = (MarketDetailsSyndicate)syndicates.nextElement(); %>


                        <tr>
                          <td><input type="checkbox" name="del<%=lineNo%>" <%=syndicate.getDeleteButtonFlag()%>></td>
                          <td><%=syndicate.getLineNo()%><input type="hidden" name="lineNo<%=lineNo%>" value="<%=lineNo%>"/><script>lastRow=<%=syndicate.getLineNo()%>;</script></td>
                          <td><input type="text" name="syndicateNo<%=lineNo%>" value="<%=syndicate.getNumber()%>" maxlength="4" <%=syndicate.getNumberFlag()%>></td>
                          <td><input type="text" name="syndicatePerc<%=lineNo%>" value="<%=syndicate.getPercentage()%>" maxlength="10" <%=syndicate.getPercentageFlag()%> onBlur="recalculateTotalAmt();"></td>
                          <td><input type="text" name="syndicateRef<%=lineNo%>" value="<%=syndicate.getReference()%>" maxlength="15" <%=syndicate.getReferenceFlag()%>></td>
                          <td><%=syndicate.getSyndicateOptOutStatus()%></td>
                          <td><%=syndicate.getSyndicateOptOutDate()%></td>
                          <td><input type="checkbox" name="bureauLeader<%=lineNo%>" <%=syndicate.isBureauLeader()%> <%=syndicate.getBureauLeaderFlag()%>></td>
                          <td>
                          	<% if (syndicate.isClassForLloydsAuthoriser()) { %>
                          		<a style="cursor:hand;text-decoration:underline" onClick="showHide(tab<%=lineNo%>);"><i>more</i></a>
                          	<% } %>
                          </td>
                        </tr>
                        <tr>
                          <% if (syndicate.isClassForLloydsAuthoriser()) { %>
							  <td colspan="7" align="center">
								<table class="subtable" style="display:none;" id="tab<%=lineNo%>">
								  <tr>
									<td><strong>Agreement Role</strong></td>
									<td><strong>Response Code</strong></td>
									<td><strong>User name</strong></td>
									<td><strong>Response Date/Time</strong></td>
								  </tr>
								  <tr>
									<td><%=syndicate.getAgreementRole()%></td>
									<td><%=syndicate.getResponseCode()%></td>
									<td><%=syndicate.getUserName()%></td>
									<td><%=syndicate.getResponseDateTime()%></td>
								  </tr>
								</table>
							  </td>
						   <% } %>
                        </tr>

                        <%  lineNo++;
                          }
                        %>
                        <input type="hidden" name="origCount" value="<%=lineNo - 1%>"/>
                      </table>
                    </div>
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
<% if (user.updateMode()) { %>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/screen/marketdetailscontent.js"></script>
<% } %>
<input type="hidden" name="vTotalAmt" value="<%=marketDetails.getTotalLine()%>" />
<input type="hidden" name="vSyndCount" value="<%=marketDetails.getNoSyndicates()%>" />
</form>

<script>altColumnRows('marketdetails',2);</script>
</table>
</span>