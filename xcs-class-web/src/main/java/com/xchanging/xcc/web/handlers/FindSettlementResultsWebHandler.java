package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ16Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.FindSettlementSearchResultsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindSettlementResultsWebHandler extends WebHandler {

  private ModelManager mm;

  private String tdn = "";
  private String tdnNo = "";
  private String osnd = "";
  private String osndNo = "";

  private String yoa = "";
  private String btwFrom = "";
  private String btwTo = "";
  private String name1 = "";
  private String name2 = "";
  private String name1Ind = "";
  private String name2Ind = "";
  private String pbkr = "";

  public FindSettlementResultsWebHandler() {
  }

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    FindSettlementSearchResultsModel settsearch = mm.getFindSettlementSearchResults();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();


    if (!request.getParameter("C115_TAKE_DOWN_DATEccyy").equals("")) {
     //tdn = getCentury(request.getParameter("C115_TAKE_DOWN_DATEccyy")) +
     //4 digit years will be keyed so we don't need to use getCentury - STH - 07/01/2004
       tdn = request.getParameter("C115_TAKE_DOWN_DATEccyy") +
             request.getParameter("C115_TAKE_DOWN_DATEmm") +
             request.getParameter("C115_TAKE_DOWN_DATEdd");

     tdnNo = request.getParameter("C115_TAKE_DOWN_DATEsssss");
   }
   else {
     tdn = "";
     tdnNo = "";
   }

   if (!request.getParameter("C115_ORIG_SIGNING_DATEyy").equals("")) {
     osnd = getCentury(request.getParameter("C115_ORIG_SIGNING_DATEyy")) +
            request.getParameter("C115_ORIG_SIGNING_DATEyy") +
            request.getParameter("C115_ORIG_SIGNING_DATEmm") +
            request.getParameter("C115_ORIG_SIGNING_DATEdd");

     osndNo = request.getParameter("C115_ORIG_SIGNING_DATEsssss");
   }
   else {
     osnd = "";
     osndNo = "";
   }

   yoa = request.getParameter("C115_YEAR_OF_ACC");
   pbkr = request.getParameter("C115_PAYEE_BKR");

   if (!request.getParameter("C115_COMP_BTW_FROMyyyy").equals("")) {
     //btwFrom = getCentury(request.getParameter("C115_COMP_BTW_FROMyyyy")) +
     //4 digit years will be keyed so we don't need to use getCentury - STH - 07/01/2004
     btwFrom = request.getParameter("C115_COMP_BTW_FROMyyyy") +
               request.getParameter("C115_COMP_BTW_FROMmm") +
               request.getParameter("C115_COMP_BTW_FROMdd");
   }
   else {
     btwFrom = "";
   }

   if (!request.getParameter("C115_COMP_BTW_TOyyyy").equals("")) {
     //btwFrom = getCentury(request.getParameter("C115_COMP_BTW_FROMyyyy")) +
     //4 digit years will be keyed so we don't need to use getCentury - STH - 07/01/2004
     btwTo = request.getParameter("C115_COMP_BTW_TOyyyy") +
               request.getParameter("C115_COMP_BTW_TOmm") +
               request.getParameter("C115_COMP_BTW_TOdd");
   }
   else { if (!request.getParameter("C115_COMP_BTW_FROMyyyy").equals("")) {
     //btwFrom = getCentury(request.getParameter("C115_COMP_BTW_FROMyyyy")) +
     //4 digit years will be keyed so we don't need to use getCentury - STH - 07/01/2004
     btwTo = request.getParameter("C115_COMP_BTW_FROMyyyy") +
               request.getParameter("C115_COMP_BTW_FROMmm") +
               request.getParameter("C115_COMP_BTW_FROMdd");
   }
     else {
          btwTo = "";
           }
   }


   name1 = request.getParameter("C115_NAME_1");
   // Changed to be a checkbox not a textbox - DS 2/1/04
   name1Ind = checkboxValue(request.getParameter("C115_NAME_1_PARTIAL_IND"));
   name2 = request.getParameter("C115_NAME_2");
   // Changed to be a checkbox not a textbox - DS 2/1/04
   name2Ind = checkboxValue(request.getParameter("C115_NAME_2_PARTIAL_IND"));

    v.add(new LZ16Event(tdnNo, tdn, osndNo, osnd, yoa, pbkr, btwFrom, btwTo, name1, name1Ind, name2, name2Ind));
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}
