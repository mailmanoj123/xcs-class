<%@ page import="com.xchanging.xcc.web.html.*,java.util.*,com.xchanging.xcc.web.models.*,com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="scmadvice" type="com.xchanging.xcc.web.models.SCMAdviceModel" scope="session" />
<jsp:useBean id="expertfeebreakdown" type="com.xchanging.xcc.web.models.ExpertFeeBreakDownModel" scope="session" />

<span class="lhsNav">
<table class="formCenter">
<form name="exprtfeebreakdowncontent">
<input type="submit" name="submitButton" style="display:none">
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
        <div class="menuBar">
<%
		  if(scmadvice.getScreenMode()!=null && scmadvice.getScreenMode().trim().equalsIgnoreCase("E"))
		  {
%>		      
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel"," bValidationOn = false; submitForm(\"" + request.getContextPath() + "/control/expertfeebreakdownenquirycancel\", false );")%>
<%		  }
		  else
		  {
%>
	          <%=HTMLUtils.createButton(HTMLUtils.ACTION,"Cancel"," bValidationOn = false; submitForm(\"" + request.getContextPath() + "/control/expertfeebreakdownupdatecancel\", false );")%>
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
						<b>PTD Exp Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTDExp())) %>
					</td>
					<td width="9%" style="padding-left:0px;">
						<b>PTT Exp Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTTExp())) %>
					</td>
					<td width="10%" style="padding-left:0px;">
						<b>O/S Exp Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(scmadvice.getOsExp())) %>
					</td>
				</tr>
				<tr>
					<td width="9%" style="padding-left:0px;">
						<b>PTD Fee Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTDFee())) %>
					</td>
					<td width="9%" style="padding-left:0px;">
						<b>PTT Fee Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(scmadvice.getPTTFee())) %>
					</td>
					<td width="10%" style="padding-left:0px;">
						<b>O/S Fee Total</b>
					</td>
					<td width="24%" style="padding-left:0px;">
						<%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(scmadvice.getOsFee())) %>
					</td>
				</tr>
				<tr>
				</tr>
			</tbody>
		  </table>  
		  
     <table  border="0" cellpadding="0" cellspacing="0" class="mainContent" >
      <tr>
       <td valign="top" >
         <div class="scrollmain" style="height:420px" id="scrollpane">
           <div class="scrollmaincontent">
          	<table width="100%" class="custom" cellpadding="0" cellspacing="0">
          	<tbody id='expertbreakdowntablebody'>
            
<%
				if(expertfeebreakdown!=null)
				{
				    String bgColor = "";
				    Vector vctExpertFeeBDROWS = expertfeebreakdown.getExpertFeeBreakDownROWS();
				    Enumeration expertFeeBDROWS = vctExpertFeeBDROWS.elements();
				    while (expertFeeBDROWS.hasMoreElements())
				    {
			                ExpertFeeBreakDownModel.ExpertFeeBreakDownDetail expertFeeBreakDownDetail = (ExpertFeeBreakDownModel.ExpertFeeBreakDownDetail)expertFeeBDROWS.nextElement();

			                if(expertFeeBreakDownDetail!=null)
			                {
%>
								<tr bgcolor="<%=bgColor %>" >
									<td>
										<table width="100%" cellpadding="3" cellspacing="3">
											<tbody>
												<tr>
													<td width="25%"  style="padding-left:0px;">
														<b>Expert Type</b>
													</td>
													<td width="25%" style="padding-left:0px;">
														<%=expertFeeBreakDownDetail.getStrExpertType().equalsIgnoreCase("A")?"ADJUSTER":"LAWYER"%>
													</td>
													<td width="25%" style="padding-left:0px;">
														<b>Advise On SCM</b>
													</td>
													<td width="25%" style="padding-left:0px;">
														<%=expertFeeBreakDownDetail.getStrExpertSCM().equalsIgnoreCase("Y")?"YES":"NO"%>
													</td>
												</tr>
												<tr>
													<td width="25%" style="padding-left:0px;">
														<b>Expert Code</b>
													</td>
													<td width="25%" style="padding-left:0px;">
														<%=expertFeeBreakDownDetail.getStrExpertCode() %>
													</td>
													<td width="25%" style="padding-left:0px;">
														<b>Expert Ref</b>
													</td>
													<td width="25%" style="padding-left:0px;">
														<%=expertFeeBreakDownDetail.getStrExpertRef() %>
													</td>
												</tr>
												<tr>
													<td width="25%" style="padding-left:0px;">
														<b>Expert Org Name</b>
													</td>
													<td colspan = "3" style="padding-left:0px;">
														<%=expertFeeBreakDownDetail.getStrExpertName() %>
													</td>
												</tr>
												<tr>
													<td width="25%" style="padding-left:0px;">
														<b>Expert Name</b>
													</td>
													<td colspan = "3" style="padding-left:0px;">
														<%=expertFeeBreakDownDetail.getStrExpertCNTCT() %> 
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr bgcolor="<%=bgColor %>">
									<td>
										<table width="100%" cellpadding="3" cellspacing="1" border="0"  style="padding-left:0px;">
											<tbody>
												<tr>
													<td width="9%" style="padding-left:0px;">
														<b>PTD Exp</b>
													</td>
													<td width="24%" style="padding-left:0px;">
														<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(expertFeeBreakDownDetail.getStrExpertPTDExp()))%> 
													</td>
													<td width="9%" style="padding-left:0px;">
														<b>PTT Exp</b>
													</td>
													<td width="24%" style="padding-left:0px;">
														<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(expertFeeBreakDownDetail.getStrExpertPTTExp())) %> 
													</td>
													<td width="10%" style="padding-left:0px;">
														<b>O/S Exp</b>
													</td>
													<td width="24%" style="padding-left:0px;">
														<%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(expertFeeBreakDownDetail.getStrExpertOSExp())) %> 
													</td>
												
												</tr>
												<tr>
													<td width="9%" style="padding-left:0px;">
														<b>PTD Fee</b>
													</td>
													<td width="24%" style="padding-left:0px;">
														<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(expertFeeBreakDownDetail.getStrExpertPTDFee())) %> 
													</td>
													<td width="9%" style="padding-left:0px;">
														<b>PTT Fee</b>
													</td>
													<td width="24%" style="padding-left:0px;">
														<%=HTMLUtils.insertCommas(HTMLUtils.formatDecimal(expertFeeBreakDownDetail.getStrExpertPTTFee())) %> 
													</td>
													<td width="10%" style="padding-left:0px;">
														<b>O/S Fee</b>
													</td>
													<td width="24%" style="padding-left:0px;">
														<%=HTMLUtils.insertCommas(HTMLUtils.formatNoDecimal(expertFeeBreakDownDetail.getStrExpertOSFee())) %> 
													</td>
												
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								
<%			                  
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
  
</form>
</table>
</span>



