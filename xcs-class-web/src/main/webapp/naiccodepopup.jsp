<%@ page import="com.xchanging.xcc.web.html.*, java.util.*, com.xchanging.xcc.web.models.reference.*" %>
<jsp:useBean id="naicCodeList" type="com.xchanging.xcc.web.models.reference.NaicCodeList" scope="application" />
<% String qual = request.getParameter("qual");
   if (qual==null)
     qual="";
%>
<html>
 <head>
<link href="<%=request.getContextPath()%>/Xtech.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/portalHomePage.css" rel="stylesheet" type="text/css">

  <script src="<%=request.getContextPath()%>/js/main.js"></script>
  <script src="<%=request.getContextPath()%>/js/alternateRows.js"></script>

  <title>Loading <%=naicCodeList.getSize(qual)%> NAIC codes, please wait</title>
 </head>

 <body leftmargin="0" topmargin="0" rightmargin="0">

  <table width="100%" border="0" class="dataContent">

   <tr><td><strong>NAIC Code Selection</strong></td></tr>
   <tr><td>&nbsp;</td></tr>
   <tr><td>Please select a NAIC code from the following list:</td></tr>
   <tr><td>&nbsp;</td></tr>

   <tr>
    <td>
     <table width="100%" border="0" cellspacing="0" cellpadding="0" class="dataTable" id="NAICCodes">
     <% if (qual.equals("F") || qual.equals("C")) { %>
      <tr>
       <th align="left">Code</th>
       <th align="left">Company Name</th>
       <th align="left">State of Domicile</th>
      </tr>

<% Enumeration naicCodes = naicCodeList.getNaicCodes(qual);
  while (naicCodes.hasMoreElements()) {

      NaicCodeList.CompanyNaicCode naicCode = (NaicCodeList.CompanyNaicCode)naicCodes.nextElement();
      String code;
      if (qual.equals("F"))
        code = naicCode.getFeinCode();
      else
        code = naicCode.getNaicCode();
%>
      <tr><td><%=code%></td><td>
      <% if (request.getParameter("enquiry").equals("false")) { %>
        <a href="#" name="<%=code%>" onclick="updateParent('naicCode', '<%=code%>') ;">
      <% } %>
      <%=naicCode.getCompany()%>
      <% if (request.getParameter("enquiry").equals("false")) { %>
      </a>
      <% } %>
      </td><td><%=naicCode.getState()%></td></tr>
<%
  }
%>

<% } else if (qual.equals("G") || qual.equals("P")) { %>

  <tr>
       <th align="left">Code</th>
       <th align="left">Name</th>
  </tr>
<% Enumeration naicCodes = naicCodeList.getNaicCodes(qual);
  while (naicCodes.hasMoreElements()) {

      NaicCodeList.NaicCode naicCode = (NaicCodeList.NaicCode)naicCodes.nextElement();
%>
      <tr><td><%=naicCode.getCode()%></td><td>

      <% if (request.getParameter("enquiry").equals("false")) { %>
        <a href="#" name="<%=naicCode.getCode()%>" onclick="updateParent('naicCode', '<%=naicCode.getCode()%>') ;">
      <% } %>
      <%=naicCode.getName()%>
      <% if (request.getParameter("enquiry").equals("false")) { %>
        </a>
      <% } %>
      </td></tr>
<%
  }
%>

<% } %>
     </table>
    </td>
   </tr>

  </table>

  <script language="JavaScript">
    altColumnRows('NAICCodes',1) ;
    document.title="NAIC Code Selection" ;
  </script>

 </body>
</html>