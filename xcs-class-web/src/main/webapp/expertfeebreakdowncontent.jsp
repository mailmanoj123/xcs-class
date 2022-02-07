<%@ page import="com.xchanging.xcc.web.html.HTMLUtils,java.util.*,com.xchanging.xcc.web.models.SCMAdviceModel,com.xchanging.xcc.web.models.ExpertFeeBreakDownModel,com.xchanging.xcc.web.models.reference.ExpertCodeList,com.xchanging.xcc.web.models.reference.ExpertTypeList,com.xchanging.xcc.web.models.reference.DropdownList" %>
<jsp:useBean id="scmadvice" type="com.xchanging.xcc.web.models.SCMAdviceModel" scope="session" />
<jsp:useBean id="expertfeebreakdown" type="com.xchanging.xcc.web.models.ExpertFeeBreakDownModel" scope="session" />

<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/vframework.css" rel="stylesheet" type="text/css"></link>

<jsp:useBean id="expertCodeList" type="com.xchanging.xcc.web.models.reference.ExpertCodeList" scope="application" />
<jsp:useBean id="expertTypeList" type="com.xchanging.xcc.web.models.reference.ExpertTypeList" scope="application" />
<script language="JavaScript" src="<%=request.getContextPath()%>/js/main.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/debug.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/error.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/messagelist.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/positionlayer.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vfield.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vform.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/vtab.js"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/VGroup.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/comparator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphavalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/numericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/alphanumericvalidator.js"></script>
<script language="JavaScript" src ="<%=request.getContextPath()%>/js/validators/booleanentered.js"></script> 

<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/alphaextendedvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/numericvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/decimalvalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/datevalidator.js'></script>
<script language='JavaScript' src ='<%=request.getContextPath()%>/js/validators/comparator.js'></script>


<script type="text/javascript">
<%
int expertCount = expertfeebreakdown.getExpertCount()!=null && !expertfeebreakdown.getExpertCount().equals("")?Integer.parseInt(expertfeebreakdown.getExpertCount()):1;

String maxExpertLimit = (String)application.getAttribute("maxexpertlimit");

if(maxExpertLimit == null || maxExpertLimit.trim().equals(""))
{
    maxExpertLimit = "30";
}

StringBuffer expertTypeComboHTML = new StringBuffer();
expertTypeComboHTML.append("<select name='expertType' onChange = 'updateExpertNames(this); validateExpertTypeCodeAndName(this,null,null)' protected = 'false'>");
DropdownList.DropdownValue[] expertTypes = expertTypeList.getValues();
for (int i =0 ; i < expertTypes.length ; i++) 
{
    expertTypeComboHTML.append("<option value='"+expertTypes[i].getValue()+"'>"+expertTypes[i].getDisplayValue()+"</option>");
}
expertTypeComboHTML.append("</select>");

StringBuffer expertOrgNameComboHTML = new StringBuffer();
StringBuffer expertNameRefData = new StringBuffer();
StringBuffer adjusterNamecomboHTML= new StringBuffer();
StringBuffer lawyerNamecomboHTML= new StringBuffer();

StringBuffer expertNameOptionHTML = new StringBuffer();
StringBuffer adjusterNameOptionHTML = new StringBuffer();
StringBuffer lawyerNameOptionHTML = new StringBuffer();

expertNameRefData.append("<select name=\"expertNameRefData\" style=\"display:none\">");
expertOrgNameComboHTML.append("<select name=\"expertName\" onfocus=\"mksResetSelect();\" onblur=\"mksResetSelect(); mksShowSearchPattern(false, null); \" onkeydown=\"mksKeyDown(this);\" onkeypress=\"mksKeyPress(this);\" onChange = \"validateExpertTypeCodeAndName(null,null,this)\" protected = \"false\">");
adjusterNamecomboHTML.append("<select name=\"expertName\" onfocus=\"mksResetSelect();\" onblur=\"mksResetSelect(); mksShowSearchPattern(false, null); \" onkeydown=\"mksKeyDown(this);\" onkeypress=\"mksKeyPress(this);\" onChange = \"validateExpertTypeCodeAndName(null,null,this)\" protected = \"false\">");
lawyerNamecomboHTML.append("<select name=\"expertName\" onfocus=\"mksResetSelect();\" onblur=\"mksResetSelect(); mksShowSearchPattern(false, null); \" onkeydown=\"mksKeyDown(this);\" onkeypress=\"mksKeyPress(this);\" onChange = \"validateExpertTypeCodeAndName(null,null,this)\" protected = \"false\">");

if(session.getAttribute("expertNameOptionHTML")!=null && session.getAttribute("adjusterNameOptionHTML")!=null && session.getAttribute("lawyerNameOptionHTML")!=null)
{
    expertNameOptionHTML = (StringBuffer)session.getAttribute("expertNameOptionHTML");
    adjusterNameOptionHTML = (StringBuffer)session.getAttribute("adjusterNameOptionHTML");
    lawyerNameOptionHTML = (StringBuffer)session.getAttribute("lawyerNameOptionHTML");
}
else
{
    adjusterNameOptionHTML.append("<option value=\"\" expCode= \"\" expType=\"\" ></option>");
    lawyerNameOptionHTML.append("<option value=\"\" expCode= \"\" expType=\"\" ></option>");
    
    Enumeration expertCodes = expertCodeList.getExpertCodes();
    while(expertCodes.hasMoreElements())
    {
        ExpertCodeList.ExpertCode expertCode = (ExpertCodeList.ExpertCode)expertCodes.nextElement();
       
        String expertName = HTMLUtils.replaceAll(expertCode.getName(),"'","\\'");

        expertNameOptionHTML.append("<option value=\""+expertName+"\" expCode= \""+expertCode.getCode()+"\" expType=\""+ expertCode.getType() +"\" >"+expertName+"</option>");

        if(expertCode.getType().equals("L"))
    		lawyerNameOptionHTML.append("<option value=\""+expertName+"\" expCode= \""+expertCode.getCode()+"\" expType=\""+ expertCode.getType() +"\" >"+expertName+"</option>");
    	else if(expertCode.getType().equals("A"))
    		adjusterNameOptionHTML.append("<option value=\""+expertName+"\" expCode= \""+expertCode.getCode()+"\" expType=\""+ expertCode.getType() +"\" >"+expertName+"</option>");
    }
    
    session.setAttribute("expertNameOptionHTML",expertNameOptionHTML);
    session.setAttribute("adjusterNameOptionHTML",adjusterNameOptionHTML);
    session.setAttribute("lawyerNameOptionHTML",lawyerNameOptionHTML);
}

expertNameRefData.append(expertNameOptionHTML);
expertOrgNameComboHTML.append(expertNameOptionHTML);
adjusterNamecomboHTML.append(adjusterNameOptionHTML);
lawyerNamecomboHTML.append(lawyerNameOptionHTML);

expertNameRefData.append("</select>");
expertOrgNameComboHTML.append("</select>");
adjusterNamecomboHTML.append("</select>");
lawyerNamecomboHTML.append("</select>");


String pttFeeTotal = "0";
String ptdFeeTotal = "0";
String osFeeTotal = "0";
String pttExpTotal = "0";
String ptdExpTotal = "0";
String osExpTotal = "0";

if(expertfeebreakdown.getExpertScreenMode()!=null && !expertfeebreakdown.getExpertScreenMode().equalsIgnoreCase("E"))
{
	pttFeeTotal = request.getParameter("pttFee")!=null && !request.getParameter("pttFee").trim().equals("")?request.getParameter("pttFee"):"0";
	ptdFeeTotal = request.getParameter("ptdFee")!=null && !request.getParameter("ptdFee").trim().equals("")?request.getParameter("ptdFee"):"0";
	osFeeTotal = request.getParameter("osFee")!=null && !request.getParameter("osFee").trim().equals("")?request.getParameter("osFee"):"0";
	pttExpTotal = request.getParameter("pttExp")!=null && !request.getParameter("pttExp").trim().equals("")?request.getParameter("pttExp"):"0";
	ptdExpTotal = request.getParameter("ptdExp")!=null && !request.getParameter("ptdExp").trim().equals("")?request.getParameter("ptdExp"):"0";
	osExpTotal = request.getParameter("osExp")!=null && !request.getParameter("osExp").trim().equals("")?request.getParameter("osExp"):"0";
}
else
{
	pttFeeTotal = scmadvice.getPTTFee()!=null && !scmadvice.getPTTFee().trim().equals("")?scmadvice.getPTTFee():"0";
	ptdFeeTotal = scmadvice.getPTDFee()!=null && !scmadvice.getPTDFee().trim().equals("")?scmadvice.getPTDFee():"0";
	osFeeTotal = scmadvice.getOsFee()!=null && !scmadvice.getOsFee().trim().equals("")?scmadvice.getOsFee():"0";
	pttExpTotal = scmadvice.getPTTExp()!=null && !scmadvice.getPTTExp().trim().equals("")?scmadvice.getPTTExp():"0";
	ptdExpTotal = scmadvice.getPTDExp()!=null && !scmadvice.getPTDExp().trim().equals("")?scmadvice.getPTDExp():"0";
	osExpTotal = scmadvice.getOsExp()!=null && !scmadvice.getOsExp().trim().equals("")?scmadvice.getOsExp():"0";
}
%>

var counter = "<%=expertCount+1 %>";
var maxexpertlimit="<%=maxExpertLimit.trim()%>";
var pttFeeTotal = "<%=pttFeeTotal %>";
var ptdFeeTotal = "<%=ptdFeeTotal %>";
var osFeeTotal = "<%=osFeeTotal %>";
var pttExpTotal = "<%=pttExpTotal %>";
var ptdExpTotal = "<%=ptdExpTotal %>";
var osExpTotal = "<%=osExpTotal %>";

var expertTypeComboHTML = "<%=expertTypeComboHTML%>";

var expertOrgNameComboHTML = '<%=expertOrgNameComboHTML%>';
var adjusterNamecomboHTML='<%=adjusterNamecomboHTML%>';
var lawyerNamecomboHTML='<%=lawyerNamecomboHTML%>';
var expertNameRefData = '<%=expertNameRefData%>';

var expPTDFlag = '<%=expertfeebreakdown.getEXP_PTD_ATT()%>';
var feePTDFlag = '<%=expertfeebreakdown.getFEE_PTD_ATT()%>';

var expPTTFlag = '<%=scmadvice.getPTTFeeFlag()%>';
var feePTTFlag = '<%=scmadvice.getPTTExpFlag()%>';
var origCcy = '<%=scmadvice.getOrigCcy() %>';

var newExpertButtonClicked = false;
var okButtonClicked = false;

</script>

<script src='<%=request.getContextPath()%>/js/screen/expertfeebreakdowncontentcustom.js'></script>

<span class="lhsNav">
<table class="formCenter">
<form name="exprtfeebreakdowncontent" >
<!-- on click of the button set the submiting to true -->
<input type="submit" name="submitButton" onclick = "submitting=true;" style="display:none">
  <tr>
    <td></td>
    <td class="content">
      <div class="outerWindow">
        <div class="top">
          <div class="header">
            <%=HTMLUtils.createHeader("Expert Fees Breakdown")%>
            <!-- Below help button is no longer required since the information displayed is out of date -->
            <!-- <%=HTMLUtils.createButton(HTMLUtils.HELP,"help","showHelp(\"EXPERTFEESBD\")")%> -->
          </div>
        </div>
        <div class="menuBar" style="width:98px;">
<%
		  if(scmadvice.getScreenMode()!=null && scmadvice.getScreenMode().trim().equalsIgnoreCase("E"))
		  {
%>		      
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","okButtonClicked = true; newExpertButtonClicked = false; submitForm(\"" + request.getContextPath() + "/control/expertfeebreakdownenquiryok\")")%>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel"," bValidationOn = false; submitForm(\"" + request.getContextPath() + "/control/expertfeebreakdownenquirycancel\", false );")%>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"New Expert","javascript:createExpert();")%>
	          <%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Delete Selected","javascript:removeExpert();")%>
<%		  }
		  else
		  {
%>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Ok","okButtonClicked = true; newExpertButtonClicked = false; submitForm(\"" + request.getContextPath() + "/control/expertfeebreakdownupdateok\")")%>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel"," bValidationOn = false; submitForm(\"" + request.getContextPath() + "/control/expertfeebreakdownupdatecancel\", false );")%>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"New Expert","javascript:createExpert();")%>
	          <%=HTMLUtils.createButton(HTMLUtils.FATACTION,"Delete Selected","javascript:removeExpert();")%>
<%
		  }
%>
        </div>
        
        <div class="content">
        
        <table  border="0" cellpadding="3" cellspacing="3" class="mainContent" >
        <tbody>
				<tr>
					<td width="9%" style="padding-left:0px;">
						<b> Orig Ccy <b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=scmadvice.getOrigCcy() %>
					</td>
					<td colspan ="4">
					</td>
				</tr>
				<tr>
					<td width="9%" style="padding-left:0px;">
						<b>PTD Exp Total </b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(ptdExpTotal)) %>
					</td>
					<td width="9%" style="padding-left:0px;">
						<b>PTT Exp Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(pttExpTotal)) %>
					</td>
					<td width="10%" style="padding-left:0px;">
						<b>O/S Exp Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(osExpTotal)) %>
					</td>
				</tr>
				<tr>
					<td width="9%" style="padding-left:0px;">
						<b>PTD Fee Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(ptdFeeTotal)) %>
					</td>
					<td width="9%" style="padding-left:0px;">
						<b>PTT Fee Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(pttFeeTotal)) %>
					</td>
					<td width="10%" style="padding-left:0px;">
						<b>O/S Fee Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(osFeeTotal)) %>
					</td>
				</tr>
			</tbody>
		  </table>  
		  
     <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
      <tr>
       <td valign="top" >
         <div class="scrollmain" style="height:420px" id="scrollpane">
           <div class="scrollmaincontent">
          	<table width="100%" class="custom"  cellpadding="0" cellspacing="0">
          	<tbody id='expertbreakdowntablebody'>

			<!-- Get a Hidden Combo of Expert Name Ref Data -->
			<script>document.write(''+expertNameRefData);</script>
<%
				if(expertfeebreakdown!=null)
				{
				    Vector vctExpertFeeBDROWS = expertfeebreakdown.getExpertFeeBreakDownROWS();
				    Enumeration expertFeeBDROWS = vctExpertFeeBDROWS.elements();
				    int rowCounter = 1;
				    String bgColor = "";
				    while (expertFeeBDROWS.hasMoreElements())
				    {
			                ExpertFeeBreakDownModel.ExpertFeeBreakDownDetail expertFeeBreakDownDetail = (ExpertFeeBreakDownModel.ExpertFeeBreakDownDetail)expertFeeBDROWS.nextElement();

			                if(expertFeeBreakDownDetail!=null)
			                {
%>
								<tr id = "toprow<%=rowCounter %>" bgcolor="<%=bgColor %>">
									<td>
										<table width="100%" class="custom" >
											<tbody>
												<tr>
													<td width="25%">
														Expert Type<span style="color:red">*</span>
													</td>
													<td width="25%">
<%
														/*In case expert Type is protected*/
														if(expertFeeBreakDownDetail.getBlnExpertTypeFlag())
														{
%>
															<input type="hidden" name="expertType" id ="expertType" protected = "true" value="<%=expertFeeBreakDownDetail.getStrExpertType()%>">
															<input type="text" readonly="true" class="fieldProtect" value ="<%=expertFeeBreakDownDetail.getStrExpertType()!=null && expertFeeBreakDownDetail.getStrExpertType().equalsIgnoreCase("A")?"ADJUSTER":"LAWYER"%>">
<%														    
														}
														else
														{
%>													
 															<select name="expertType" onchange="updateExpertNames(this);validateExpertTypeCodeAndName(this,null,null);" protected = "false">  
<%																	DropdownList.DropdownValue[] expertTypesL = expertTypeList.getValues();                                                                          
																	for (int i =0 ; i < expertTypesL.length ; i++) 
																	{
%>	
																		<option value="<%=expertTypesL[i].getValue()%>" <%=expertTypesL[i].getValue()!=null && !expertTypesL[i].getValue().equals("") && expertTypesL[i].getValue().equalsIgnoreCase(expertFeeBreakDownDetail.getStrExpertType())?"SELECTED":""%>> <%=expertTypesL[i].getDisplayValue()%></option>
<% 																	}
%>															
															</select>
<%
														}
%>
														<input type="hidden" name="expertTypeFlag" value='<%=expertFeeBreakDownDetail.getBlnExpertTypeFlag() %>'>
													</td>
													<td width="25%">
														Advise On SCM
													</td>
													<td width="25%">
														<input type="checkbox" name="expertSCMCheckBox"  <%=expertFeeBreakDownDetail.getStrExpertSCM().equalsIgnoreCase("Y")?"CHECKED":"" %>  onClick="updateCheckBoxHidden(this,<%=rowCounter %>)" <%=expertFeeBreakDownDetail.getStrExpertSCMFlag() %>>
														<input type="hidden" name="expertSCM"  value ="<%=expertFeeBreakDownDetail.getStrExpertSCM()%>">
														<input type="hidden" name="expertSCMFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertSCMFlag() %>'>
													</td>
												</tr>
												<tr>
													<td width="25%">
														Expert Code<span style="color:red">*</span>
													</td>
													<td width="25%">
														<input type="text" name="expertCode" value ="<%=expertFeeBreakDownDetail.getStrExpertCode() %>" <%=expertFeeBreakDownDetail.getStrExpertCodeFlag() %> onchange="validateExpertTypeCodeAndName(null,this,null);" autocomplete="off" >
														<input type="hidden" name="expertCodeFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertCodeFlag() %>'>
													</td>
													<td width="25%">
														Expert Ref
													</td>
													<td width="25%">
														<input type="text" name="expertRef"  value ="<%=expertFeeBreakDownDetail.getStrExpertRef()==null?"":expertFeeBreakDownDetail.getStrExpertRef() %>" <%=expertFeeBreakDownDetail.getStrExpertRefFlag() %> autocomplete="off" >
														<input type="hidden" name="expertRefFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertRefFlag() %>'>
													</td>
												</tr>
												<tr>
													<td width="25%">
														Expert Org Name
													</td>
													<td colspan = "3" id="expertOrgNameTD">
<%
														if(expertFeeBreakDownDetail.getBlnExpertNameFlag())
														{
%>
															<input type="text" name="expertName" id ="expertName" protected = "true" value="<%=expertFeeBreakDownDetail.getStrExpertName()%>" expCode="<%=expertFeeBreakDownDetail.getStrExpertCode() %>" expType="<%=expertFeeBreakDownDetail.getStrExpertType() %>"  readonly="true" class="fieldProtect"> 
<%													    
														}
														else
														{
															if(expertFeeBreakDownDetail.getStrExpertType()!=null && expertFeeBreakDownDetail.getStrExpertType().trim().equals(""))
															{
%>
																<script>document.write(''+expertOrgNameComboHTML);</script>
<%																    
															}
															else if(expertFeeBreakDownDetail.getStrExpertType()!=null && expertFeeBreakDownDetail.getStrExpertType().trim().equals("A"))
															{
%>																    
															    <script>document.write(''+adjusterNamecomboHTML);</script>
<%																    
															}
															else if(expertFeeBreakDownDetail.getStrExpertType()!=null && expertFeeBreakDownDetail.getStrExpertType().trim().equals("L"))
															{
%>																    
															   <script>document.write(''+lawyerNamecomboHTML);</script>
<%																    
															}
														}
%>															
														<input type="hidden" name="expertNameFlag"  value ='<%=expertFeeBreakDownDetail.getBlnExpertNameFlag() %>'>
													</td>
												</tr>
												<tr>
													<td width="25%">
														Expert Name
													</td>
													<td colspan = "3">
														<input type="text" name="expertCNTC" value ="<%=expertFeeBreakDownDetail.getStrExpertCNTCT() %>" <%=expertFeeBreakDownDetail.getStrExpertCNTCTFlag() %> autocomplete="off" >
														<input type="hidden" name="expertCNTCFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertCNTCTFlag()%>'>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>

								<tr id = "bottomrow<%=rowCounter %>" bgcolor="<%=bgColor%>">
									<td>
										<table width="100%" class="custom" >
											<tbody>
												<tr>
													<td width="11%">
														PTD Exp
													</td>
													<td width="22%">
														<input type="text" name="expertPTD_EXP" value ="<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(expertFeeBreakDownDetail.getStrExpertPTDExp())) %>" <%=expertFeeBreakDownDetail.getStrExpertPTDExpFlag() %> autocomplete="off" >
														<input type="hidden" name="expertPTD_EXPFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertPTDExpFlag() %>'>
													</td>
													<td width="12%">
														PTT Exp
													</td>
													<td width="22%">
														<input type="text" name="expertPTT_EXP" value ="<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(expertFeeBreakDownDetail.getStrExpertPTTExp())) %>" <%=expertFeeBreakDownDetail.getStrExpertPTTExpFlag() %> autocomplete="off" >
														<input type="hidden" name="expertPTT_EXPFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertPTTExpFlag() %>'>
													</td>
													<td width="12%">
														O/S Exp
													</td>
													<td width="21%">
														<input type="text" name="expertOS_EXP" value ="<%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(expertFeeBreakDownDetail.getStrExpertOSExp())) %>" <%=expertFeeBreakDownDetail.getStrExpertOSExpFlag() %> autocomplete="off" >
														<input type="hidden" name="expertOS_EXPFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertOSExpFlag() %>'>
													</td>
												
												</tr>
												<tr>
													<td width="11%">
														PTD Fee
													</td>
													<td width="22%">
														<input type="text" name="expertPTD_FEE" value ="<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(expertFeeBreakDownDetail.getStrExpertPTDFee())) %>" <%=expertFeeBreakDownDetail.getStrExpertPTDFeeFlag() %> autocomplete="off" >
														<input type="hidden" name="expertPTD_FEEFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertPTDFeeFlag() %>'>
													</td>
													<td width="12%">
														PTT Fee
													</td>
													<td width="22%">
														<input type="text" name="expertPTT_FEE" value ="<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(expertFeeBreakDownDetail.getStrExpertPTTFee())) %>" <%=expertFeeBreakDownDetail.getStrExpertPTTFeeFlag() %> autocomplete="off" >
														<input type="hidden" name="expertPTT_FEEFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertPTTFeeFlag() %>'>
													</td>
													<td width="12%">
														O/S Fee
													</td>
													<td width="21%">
														<input type="text" name="expertOS_FEE" value ="<%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(expertFeeBreakDownDetail.getStrExpertOSFee())) %>" <%=expertFeeBreakDownDetail.getStrExpertOSFeeFlag() %> autocomplete="off" >
														<input type="hidden" name="expertOS_FEEFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertOSFeeFlag() %>'>
													</td>
												
												</tr>
												<tr>
													<td colspan="5" align ="right">
														Delete Expert ?
													</td>
													<td width="16.6%">
														<input type="checkbox" name="deleteexpert<%=rowCounter %>" <%=expertFeeBreakDownDetail.getStrExpertDeleteFlag() %>>
														<input type="hidden" name="deleteExpertFlag"  value ='<%=expertFeeBreakDownDetail.getStrExpertDeleteFlag() %>'>
														
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								
<%			                    
								rowCounter++;
								bgColor = bgColor.equalsIgnoreCase("#9DD7EB")?"":"#9DD7EB";
			                }
				    }
				    
				}
%>                    
            </tbody>
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

<input type="hidden" name="rowCount" value="<%=expertCount %>">

<!-- Call screen validater for the loaded rows -->
<script>updateScreenValidators();</script>
<script>showExpertNamesOnLoad();</script>

<%
	if(expertCount <= 0)
	{
%>
		<script>createExpert();</script>
<%
	}
%>
<!--  For Custom MKS Init -->
<input type ="hidden" id="customMKSInit" name="customMKSInit" value = "true">
<input type ="hidden" id="customMKSInitFunction" name="customMKSInitFunction" value = "validateExpertTypeCodeAndName(null,null,uoSelect)">
<div id="selectPopup" name="selectPopup" class="selectPopup"></div>
<div id = "HelpDiv" name = "HelpDiv" class="help_popup"></div>
</form>
</table>
</span>



