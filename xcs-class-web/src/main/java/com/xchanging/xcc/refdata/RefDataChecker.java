package com.xchanging.xcc.refdata;

import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsError;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimDetailsModel;
import com.xchanging.xcc.web.models.FinancialDetailsModel;
import com.xchanging.xcc.web.models.MarketDetailsModel;
import com.xchanging.xcc.web.models.SCMAdviceModel;
import com.xchanging.xcc.web.models.manager.ModelManager;
import com.xchanging.xcc.web.models.reference.BrokerList;
import com.xchanging.xcc.web.models.reference.GUIErrorList;
import com.xchanging.xcc.web.models.reference.NaicCodeList;
import com.xchanging.xcc.web.models.reference.SyndicateList;

public class RefDataChecker {
  private static Vector errors;
  private static GUIErrorList errorList;

  public static Enumeration checkRefData(HttpServletRequest request) {
    ServletContext context = request.getSession().getServletContext();
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    errors = new Vector();
    if (errorList==null) {
      errorList = (GUIErrorList)context.getAttribute(Keys.RefGUIErrorList);
    }

    String screen = (String)request.getSession().getAttribute(Keys.ScreenKey);

    if ((screen!=null) && (!request.getPathInfo().equals("/logoff")) && (!request.getPathInfo().equals("/resetclaimtransaction"))) {
      if ((screen.equals("BACK_TWO")) || (screen.equals("BACK")))
        screen = (String)request.getSession().getAttribute(Keys.ScreenOkKey);

      if (screen.equals("SCR017")) {
        SCMAdviceModel scm = mm.getSCMAdviceModel();

          /**
           * Expert Fee Breakdown changes
           * 
           * Sachin Goyal
           */
//        String adjusterCode = request.getParameter("adjusterCode");
//        if (adjusterCode==null)
//          adjusterCode = "";
//        String lawyerCode = request.getParameter("lawyerCode");
//        if (lawyerCode==null)
//          lawyerCode = "";
//
//        AdjSurvCodeList adjusterCodes = (AdjSurvCodeList)context.getAttribute(Keys.RefAdjSurvCodeList);
//        LawyerCodeList lawyerCodes = (LawyerCodeList)context.getAttribute(Keys.RefLawyerCodeList);
//
//        if ((!adjusterCode.equals("")) && (!adjusterCodes.validate(adjusterCode))) {
//          addError(new ClaimsError("G007","ADJUSTER CODE IS INVALID",""));
//        }
//        if ((!lawyerCode.equals("")) && (!lawyerCodes.validate(lawyerCode))) {
//          addError(new ClaimsError("G008","LAWYER CODE IS INVALID",""));
//        }

        String naicQual = request.getParameter("naicQual");
        if (naicQual==null)
          naicQual = "";
        String naicCode = request.getParameter("naicCode");
        if (naicCode==null)
          naicCode = "";

        NaicCodeList naicCodes = (NaicCodeList)context.getAttribute(Keys.RefNAICCodeList);
        if ((!naicQual.equals("")) && (!naicCode.equals("")) && (!naicCodes.validate(naicCode,naicQual))) {
          addError(new ClaimsError("G010","NAIC CODE NOT VALID FOR QUALIFIER",""));
        }
      }
      else  if (screen.equals("SCR015")) {

        FinancialDetailsModel fdm = mm.getFinancialDetailsModel();

        if ((fdm.getPayeeBrokerFlag()!=null) &&
            (fdm.getPayeeBrokerPseudFlag()!=null) &&
            (fdm.getPayeeBrokerFlag().equals("")) &&
            (fdm.getPayeeBrokerPseudFlag().equals(""))) {

          String broker = request.getParameter("payeeBroker");
          String brokerPseud = request.getParameter("payeeBrokerPseud");

          BrokerList brokers = (BrokerList)context.getAttribute(Keys.RefBrokerCodeList);

          if (!brokers.validate(broker,brokerPseud)) {
            addError(new ClaimsError("G004","BROKER CODE DOES NOT MATCH BROKER PSEUD",""));
          }
        }
      } else if (screen.equals("SCR013")) {
        if (!request.getPathInfo().equals("/marketdetailsdelete")) {

          SyndicateList syndicates = (SyndicateList)context.getAttribute(Keys.RefSyndicateList);

          String syndicateNo;
          int i=1;
          while ((syndicateNo=request.getParameter("syndicateNo" + i))!=null) {
            if (!syndicates.validate(syndicateNo)) {
              addError(new ClaimsError("G006","SYNDICATE NO " + syndicateNo + " INVALID",""));
            }
            i++;
          }
          i=1;
          while ((syndicateNo=request.getParameter("syndicateInsertNo" + i))!=null) {
            if (!syndicates.validate(syndicateNo)) {
              addError(new ClaimsError("G006","SYNDICATE NO " + syndicateNo + " INVALID",""));
            }
            i++;
          }

          if (request.getRequestURI().indexOf("marketdetailserror")<0) {
            Vector syndicateNos = new Vector();
            Vector syndicatePercs = new Vector();
            Vector syndicateRefs = new Vector();
            Vector bureauLeaders = new Vector();
            Vector deleteInds = new Vector();
            String sTotalLine;
            String sNoSynds;


            MarketDetailsModel marketDetails = mm.getMarketDetailsModel();
            ClaimDetailsModel cdm =  mm.getClaimDetailsModel();

            sTotalLine = request.getParameter("vTotalAmt");
            sNoSynds   = request.getParameter("vSyndCount");

            i=1;

            String delInd = checkboxValue(request.getParameter("del" + i));
            String syndNo = request.getParameter("syndicateNo" + i);
            String syndPerc = request.getParameter("syndicatePerc" + i);
            String syndRef = request.getParameter("syndicateRef" + i);
            String burLeader = checkboxValue(request.getParameter("bureauLeader" + i));


            while ((syndNo!=null) && (!syndNo.equals(""))) {
              deleteInds.add(delInd);
              syndicateNos.add(syndNo);
              syndicatePercs.add(syndPerc);
              syndicateRefs.add(syndRef);
              bureauLeaders.add(burLeader);

              i++;
              delInd = checkboxValue(request.getParameter("del" + i));
              syndNo = request.getParameter("syndicateNo" + i);
              syndPerc = request.getParameter("syndicatePerc" + i);
              syndRef = request.getParameter("syndicateRef" + i);
              burLeader = checkboxValue(request.getParameter("bureauLeader" + i));
            }

            i=1;
            delInd = checkboxValue(request.getParameter("delInsert" + i));
            syndNo = request.getParameter("syndicateInsertNo" + i);
            syndPerc = request.getParameter("syndicatePercInsert" + i);
            syndRef = request.getParameter("syndicateRefInsert" + i);
            burLeader = checkboxValue(request.getParameter("bureauLeaderInsert" + i));

            while ((syndNo!=null) && (!syndNo.equals(""))) {
              deleteInds.add(delInd);
              syndicateNos.add(syndNo);
              syndicatePercs.add(syndPerc);
              syndicateRefs.add(syndRef);
              bureauLeaders.add(burLeader);

              i++;
              delInd = checkboxValue(request.getParameter("delInsert" + i));
              syndNo = request.getParameter("syndicateInsertNo" + i);
              syndPerc = request.getParameter("syndicatePercInsert" + i);
              syndRef = request.getParameter("syndicateRefInsert" + i);
              burLeader = checkboxValue(request.getParameter("bureauLeaderInsert" + i));
            }

            // place the vectors into string arrays.
            String[] aDeleteInds = new String[deleteInds.size()];
            String[] aSyndicateNos = new String[syndicateNos.size()];
            String[] aSyndicatePercs = new String[syndicatePercs.size()];
            String[] aSyndicateRefs = new String[syndicateRefs.size()];
            String[] aBureauLeaders = new String[bureauLeaders.size()];

            for(int x = 0; x < syndicateNos.size(); x++){
              aDeleteInds[x] = (String)deleteInds.get(x);
              aSyndicateNos[x] = (String)syndicateNos.get(x);
              aSyndicatePercs[x] = (String)syndicatePercs.get(x);
              aSyndicateRefs[x] = (String)syndicateRefs.get(x);
              aBureauLeaders[x] = (String)bureauLeaders.get(x);
            }

            marketDetails.updateModel(aSyndicateNos, aSyndicatePercs, aSyndicateRefs, aBureauLeaders, aDeleteInds);
          }
        }
      }
    }

    return errors.elements();
  }

  private static String checkboxValue(String checkbox) {
    if ((checkbox==null) || (checkbox.equals("")) || (checkbox.equals("null")))
      return "N";
    else
      return "Y";
  }

  private static void addError(ClaimsError e) {
    if (errors.size()<9) {
      errors.add(e);
    } else if (errors.size()==9) {
      errors.add(new ClaimsError("E999",errorList.getErrorText("E999"),""));
    }
  }
}