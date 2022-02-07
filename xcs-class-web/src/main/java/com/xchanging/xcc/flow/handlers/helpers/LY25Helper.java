package com.xchanging.xcc.flow.handlers.helpers;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY25Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class LY25Helper {
  public static LY25Event buildLY25Event(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();
    MarketsModel marketsModel = mm.getMarketsModel();

    String[] curr  = new String[3];
    String[] osnd  = new String[3];
    String[] apsnd = new String[3];

    for (int x = 0; x < 3; x++) {
      curr[x] = "";
      osnd[x] = "";
      apsnd[x] = "";
    }

    /**
     * Get the data for the LY25 Validation Event
     */

    // Check boxes
    String bulkInd          = checkboxValue(request.getParameter("bulkInd"));
    String nonScmAdvised    = checkboxValue(request.getParameter("nonScmAdvised"));
    String lossReserve      = checkboxValue(request.getParameter("lossReserve"));
    String prevPaidInd      = checkboxValue(request.getParameter("prevPaidInd"));

    // CCN# N0058 - BA - 09/01/2003
    String locDrawingInd    = checkboxValue(request.getParameter("locDrawingInd"));

    // CCN# ????? - S.Caine - 03/12/2003
    String SpecPymtInd      = checkboxValue(request.getParameter("specPymtInd"));

    // CCN# N0021 - devo - 15/01/2003
    String schemeCanInd    = checkboxValue(request.getParameter("schemeCanInd"));
    String cpaInd          = checkboxValue(request.getParameter("cpaInd"));
    String dirLStockInd    = checkboxValue(request.getParameter("dirLStockInd"));



    String treaty           = checkboxValue(request.getParameter("treaty"));
    String ecfClaim         = checkboxValue(request.getParameter("ecfClaim"));
    String ecfClass         = request.getParameter("ecfClass");
    String riskUnsigned     = checkboxValue(request.getParameter("riskUnsigned"));
    String loc              = checkboxValue(request.getParameter("loc"));
    String payByCheque      = request.getParameter("payByCheque");
    String simRi            = checkboxValue(request.getParameter("simRi"));
    String prevAdvNonNet    = checkboxValue(request.getParameter("prevAdvNonNet"));
    String lossFund         = checkboxValue(request.getParameter("lossFund"));
    String noChargeableInd  = checkboxValue(request.getParameter("noChargeableInd"));

    /**
     * Get the data from the drop down lists
     */
    String settAdv          = request.getParameter("settAdv");
    String chargeType       = request.getParameter("chargeType");

    /**
     * Get the Pres Date
     */
    String presDate         = constructPresDate(request);

    /**
     * Get the three currencies
     */
    curr[0] = request.getParameter("origCcy1");
    curr[1] = request.getParameter("origCcy2");
    curr[2] = request.getParameter("origCcy3");

    /**
     * Get the three OSND and APSND values
     */
    String osnd1sssss  = request.getParameter("osnd1sssss");
    String osnd1dd     = request.getParameter("osnd1dd");
    String osnd1mm     = request.getParameter("osnd1mm");
    String osnd1yy     = request.getParameter("osnd1yy");

    String osnd2sssss  = request.getParameter("osnd2sssss");
    String osnd2dd     = request.getParameter("osnd2dd");
    String osnd2mm     = request.getParameter("osnd2mm");
    String osnd2yy     = request.getParameter("osnd2yy");

    String osnd3sssss  = request.getParameter("osnd3sssss");
    String osnd3dd     = request.getParameter("osnd3dd");
    String osnd3mm     = request.getParameter("osnd3mm");
    String osnd3yy     = request.getParameter("osnd3yy");

    String apsnd1sssss = request.getParameter("apsnd1sssss");
    String apsnd1dd    = request.getParameter("apsnd1dd");
    String apsnd1mm    = request.getParameter("apsnd1mm");
    String apsnd1yy    = request.getParameter("apsnd1yy");

    String apsnd2sssss = request.getParameter("apsnd2sssss");
    String apsnd2dd    = request.getParameter("apsnd2dd");
    String apsnd2mm    = request.getParameter("apsnd2mm");
    String apsnd2yy    = request.getParameter("apsnd2yy");

    String apsnd3sssss = request.getParameter("apsnd3sssss");
    String apsnd3dd    = request.getParameter("apsnd3dd");
    String apsnd3mm    = request.getParameter("apsnd3mm");
    String apsnd3yy    = request.getParameter("apsnd3yy");

    /**
     * Construct the OSND and APSND values to the correct
     * format
     */

    if (!osnd1yy.equals("")) {
      osnd[0] = getCentury(osnd1yy) + osnd1yy + osnd1mm + osnd1dd + osnd1sssss;
    }
    if (!osnd2yy.equals("")) {
      osnd[1] = getCentury(osnd2yy) + osnd2yy + osnd2mm + osnd2dd + osnd2sssss;
    }
    if (!osnd3yy.equals("")) {
      osnd[2] = getCentury(osnd3yy) + osnd3yy + osnd3mm + osnd3dd + osnd3sssss;
    }

    if (!apsnd1yy.equals("")) {
      apsnd[0] = getCentury(apsnd1yy) + apsnd1yy + apsnd1mm + apsnd1dd + apsnd1sssss;
    }
    if (!apsnd2yy.equals("")) {
      apsnd[1] = getCentury(apsnd2yy) + apsnd2yy + apsnd2mm + apsnd2dd + apsnd2sssss;
    }
    if (!apsnd3yy.equals("")) {
      apsnd[2] = getCentury(apsnd3yy) + apsnd3yy + apsnd3mm + apsnd3dd + apsnd3sssss;
    }

    String riskCode         = ctcModel.getRiskCode();
    String slipType         = ctcModel.getSlipType();

    return new LY25Event(osnd,apsnd,curr,riskCode,
                         settAdv,nonScmAdvised,bulkInd,
                         riskUnsigned,treaty,ecfClaim,ecfClass,simRi,lossReserve,
                         loc,lossFund,payByCheque,chargeType,
                         noChargeableInd,prevAdvNonNet,prevPaidInd,
                         locDrawingInd, /* CCN# N0058 - BA - 09/01/2003 */
                         SpecPymtInd, /* CCN# ????? - S.Caine - 03/12/2003 */
                         presDate,slipType,schemeCanInd, cpaInd,dirLStockInd,marketsModel.getOrigBkrCurr());
  }

  private static String checkboxValue(String checkbox) {
    if ((checkbox==null) || (checkbox.equals("")) || (checkbox.equals("null")))
      return "N";
    else
      return "Y";
  }

  private static String constructPresDate(HttpServletRequest req) {
    String presDateyyyy = req.getParameter("presDateyyyy");
    String presDatemm = req.getParameter("presDatemm");
    String presDatedd = req.getParameter("presDatedd");

    if (!presDateyyyy.equals("")) {
      return presDateyyyy + "-" + presDatemm + "-" + presDatedd;
    }
    else {
      return "";
    }
  }

  protected static String getCentury(String yearStr) {
    String century;
    int year = Integer.parseInt(yearStr);
    if (year > 35) {
      return "19";
    }
    else {
      return "20";
    }
  }
}