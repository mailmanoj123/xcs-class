package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.AdvancedSearchEvent;
import com.xchanging.xcc.events.LY06Event;
import com.xchanging.xcc.events.LY07Event;
import com.xchanging.xcc.events.LY08Event;
import com.xchanging.xcc.events.LY09Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindClaimSearchWebHandler extends WebHandler {

  private ModelManager mm;
  private String osnd = "";
  private String bkrUcr = "";
  private String tdn = "";
  private String tr = "";
  private String ucrXcr = "";
  private String groupRef = "";
  private String cor = "";
  private String certNo = "";
  private String screen = "";

  public void doStart(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getOsndSearchResultsModel();
    mm.getFindClaimModel();
    mm.getFindClaimModel().setCor("");
    mm.getSecurityNotesModel();
    mm.getGroupSearchResultsModel();
    mm.getNavigationBar();
    mm.getClaimTransactionCreationModel();
    mm.getAdvancedSearchModel();
    mm.getFinancialDetailsModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();

    if ((request.getParameter("mode")==null) || (request.getParameter("mode").equals("BASIC"))) {

      if (!request.getParameter("osndyy").equals("")) {
        osnd = getCentury(request.getParameter("osndyy")) +
               request.getParameter("osndyy") +
               request.getParameter("osndmm") +
               request.getParameter("osnddd") +
               request.getParameter("osndsssss");
      }
      else {
        osnd = "";
      }

      bkrUcr = request.getParameter("bkrUcrpt1") +
               request.getParameter("bkrUcrpt2") +
               request.getParameter("bkrUcrpt3");

      String tdn = request.getParameter("tdnccyy") +
                   request.getParameter("tdnmm") +
                   request.getParameter("tdndd") +
                   request.getParameter("tdnsssss");

      tr = request.getParameter("trpt1") +
           request.getParameter("trpt2") +
           request.getParameter("trpt3");

      ucrXcr = request.getParameter("ucrXcrpt1") +
               request.getParameter("ucrXcrpt2") +
               request.getParameter("ucrXcrpt3");

      String groupRef1 = request.getParameter("groupRefpt1");
      String groupRef2 = request.getParameter("groupRefpt2");
      if ((!groupRef1.equals("")) && (!groupRef2.equals("")))
        groupRef = groupRef1 + groupRef2;

      cor = request.getParameter("corpt1");
      for (int i=0; i<cor.length(); i++) {
        if ((cor.substring(i,i+1).equals(" ")) || (cor.substring(i,i+1).equals("\\")) || (cor.substring(i,i+1).equals("/")) || (cor.substring(i,i+1).equals("-")))
          cor=cor.substring(0,i) + cor.substring(i+1,cor.length());
      }

      certNo = request.getParameter("certNo");

      if (!osnd.equals("")) {
        request.setAttribute(Keys.TrasactionFlowKey,"1");
        v.add(new LY06Event(osnd,"SCR005"));
      }
      else if (!groupRef.equals("") || (!bkrUcr.equals(""))) {
        request.setAttribute(Keys.TrasactionFlowKey,"2");
        v.add(new LY08Event(groupRef,bkrUcr,"0","0","0","0","0","0","0","0","0","0"));
      }
      else if ((!ucrXcr.equals("")) || (!tr.equals("")) || (!cor.equals("")) || (!tdn.equals("")) || (!certNo.equals(""))) {
        request.setAttribute(Keys.TrasactionFlowKey,"3");
        v.add(new LY07Event(ucrXcr,tr,cor,tdn,certNo));
        v.add(new LY09Event("SCR005"));
      }
      else {
        request.setAttribute(Keys.TrasactionFlowKey,"x");
      }
    }
    else { // Advanced Search

      String name1 = request.getParameter("name1");
      String name2 = request.getParameter("name2");

      String dateOfLossFromDay = request.getParameter("dateOfLossFromdd");
      String dateOfLossFromMonth = request.getParameter("dateOfLossFrommm");
      String dateOfLossFromYear = request.getParameter("dateOfLossFromyyyy");
      String dateOfLossFrom = formatDate(dateOfLossFromYear,dateOfLossFromMonth,dateOfLossFromDay);

      String dateOfLossToDay = request.getParameter("dateOfLossTodd");
      String dateOfLossToMonth = request.getParameter("dateOfLossTomm");
      String dateOfLossToYear = request.getParameter("dateOfLossToyyyy");
      String dateOfLossTo = formatDate(dateOfLossToYear,dateOfLossToMonth,dateOfLossToDay);

      String catCode = request.getParameter("catCode");
      String user = request.getParameter("user");

      String dateProcessedFromDay = request.getParameter("dateProcessedFromdd");
      String dateProcessedFromMonth = request.getParameter("dateProcessedFrommm");
      String dateProcessedFromYear = request.getParameter("dateProcessedFromyyyy");
      String dateProcessedFrom = formatDate(dateProcessedFromYear,dateProcessedFromMonth,dateProcessedFromDay);

      String dateProcessedToDay = request.getParameter("dateProcessedTodd");
      String dateProcessedToMonth = request.getParameter("dateProcessedTomm");
      String dateProcessedToYear = request.getParameter("dateProcessedToyyyy");
      String dateProcessedTo = formatDate(dateProcessedToYear,dateProcessedToMonth,dateProcessedToDay);
      String claimant = request.getParameter("claimant");
      String brokerRef = request.getParameter("bkrRef");
      
      String[] queries = getQuery(name1,name2,dateOfLossFrom,dateOfLossTo,catCode,user,dateProcessedFrom,dateProcessedTo,claimant,brokerRef);

      /*
        Set the SQL query into the model so we can reuse the query
        from the Next and Prev web handler
      */
      mm.getAdvancedSearchModel().setQuery(queries[0]);

      /*
        Set the display details of the query into the model so we
        can reuse it from the Next and Prev web handler
      */
      mm.getAdvancedSearchModel().setDisplayQuery(queries[1]);

      /*
        Pass the event the SQL query to be executed
      */
      v.add(new AdvancedSearchEvent(queries[0]));
    }
    return v;
    }

  public void doEnd(HttpServletRequest request) {
  }

  private String[] getQuery( String name1,
                           String name2,
                           String dolFrom,
                           String dolTo,
                           String catCode,
                           String user,
                           String dateProcFrom,
                           String dateProcTo,
                           String claimant,
                           String brokerRef) {

    name1        = "'" + name1.trim()        + "'";
    name2        = "'" + name2.trim()        + "'";
    dolFrom      = "'" + dolFrom.trim()      + "'";
    dolTo        = "'" + dolTo.trim()        + "'";
    catCode      = "'" + catCode.trim()      + "'";
    user         = "'" + user.trim()         + "'";
    dateProcFrom = "'" + dateProcFrom.trim() + "'";
    dateProcTo   = "'" + dateProcTo.trim()   + "'";
    claimant     = "'" + claimant.trim()   + "'";
    brokerRef   = "'" + brokerRef.trim()   + "'";
    
    name1 = name1.replace('*','%');
    name2 = name2.replace('*','%');

    String query = "from addsrch where ";
    String display = "";

    if (!name1.equals("''")) {
      query += " upper(trim(name_1)) ";
      display += "Name 1: " + name1;
      if (name1.indexOf("%") < 0) {
        query += " = ";
      }
      else {
        query += " like ";
      }
      query += name1;

      if (!dolFrom.equals("''") && !dolTo.equals("''")) {
        query += " and trim(date_of_loss) between " + dolFrom + " and " + dolTo;
        display += " DOL/DCM: " + dolFrom + " To " + dolTo;
      }
      else if (!dolFrom.equals("''")) {
        query += " and trim(date_of_loss) = " + dolFrom;
        display += " DOL/DCM: " + dolFrom;
      }
    }
    else if (!name2.equals("''")) {
      query += " upper(trim(name_2)) ";
      display += "Name 2: " + name2;
      if (name2.indexOf("%") < 0) {
        query += " = ";
      }
      else {
        query += " like ";
      }
      query += name2;

      if (!dolFrom.equals("''") && !dolTo.equals("''")) {
        query += " and trim(date_of_loss) between " + dolFrom + " and " + dolTo;
        display += " DOL/DCM: " + dolFrom + " To " + dolTo;
      }
      else if (!dolFrom.equals("''")) {
        query += " and trim(date_of_loss) = " + dolFrom;
        display += " DOL/DCM: " + dolFrom;
      }
    }
    else if (!catCode.equals("''")) {
      query += " upper(trim(cat_code)) = " + catCode;
      display += "CAT Code: " + catCode;
    }
    else if (!user.equals("''")) {
      query += " upper(trim(processing_user)) = " + user;
      display += "User Id: " + user;
      if (!dateProcFrom.equals("''") && !dateProcTo.equals("''")) {
        query += " and trim(date_processed) between " + dateProcFrom + " and " + dateProcTo;
        display += " Date Processed Range: " + dateProcFrom + " To " + dateProcTo;
      }
      else if (!dateProcFrom.equals("''")) {
        query += " and trim(date_processed) = " + dateProcFrom;
        display += " Date Processed From: " + dateProcFrom;
      }
    } else if (!claimant.equals("''")) {
        query += " upper(trim(claimant)) = " + claimant;
        display += "Claimant: " + claimant;
        if (!dolFrom.equals("''") && !dolTo.equals("''")) {
            query += " and trim(date_of_loss) between " + dolFrom + " and " + dolTo;
            display += " DOL/DCM: " + dolFrom + " To " + dolTo;
          }
        else if (!dolFrom.equals("''")) {
            query += " and trim(date_of_loss) = " + dolFrom;
            display += " DOL/DCM: " + dolFrom;
          }
      }else if (!brokerRef.equals("''")) {
          query += " upper(trim(bkr_ref_1)) = " + brokerRef;
          display += "Broker Reference: " + brokerRef;
          if (!dolFrom.equals("''") && !dolTo.equals("''")) {
              query += " and trim(date_of_loss) between " + dolFrom + " and " + dolTo;
              display += " DOL/DCM: " + dolFrom + " To " + dolTo;
            }
          else if (!dolFrom.equals("''")) {
              query += " and trim(date_of_loss) = " + dolFrom;
              display += " DOL/DCM: " + dolFrom;
            }
      }else if (!dolFrom.equals("''") && !dolTo.equals("''")) {
      query += " trim(date_of_loss) between " + dolFrom + " and " + dolTo;
      display += " DOL/DCM: " + dolFrom + " To " + dolTo;
    } else if (!dolFrom.equals("''")) {
      query += " trim(date_of_loss) = " + dolFrom;
      display += " DOL/DCM: " + dolFrom;
    } else if (!dateProcFrom.equals("''") && !dateProcTo.equals("''")) {
      query += " trim(date_processed) between " + dateProcFrom + " and " + dateProcTo;
      display += " Date Processed: " + dateProcFrom + " To " + dateProcTo;
    } else if (!dateProcFrom.equals("''")) {
      query += " trim(date_processed) = " + dateProcFrom;
      display += " Date Processed: " + dateProcFrom;
    }

    String queries[] = new String[2];
    queries[0] = query;
    queries[1] = display;
    return queries;
  }
}

