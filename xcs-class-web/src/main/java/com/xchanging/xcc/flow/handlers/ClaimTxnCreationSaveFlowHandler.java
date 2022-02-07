package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LZ07Event;
import com.xchanging.xcc.flow.handlers.helpers.LY25Helper;
import com.xchanging.xcc.flow.handlers.helpers.LY27Helper;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ClaimTxnCreationSaveFlowHandler extends FlowHandler {

  private ModelManager mm;

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public void doEnd(HttpServletRequest request) {}

  public String processFlow(HttpServletRequest request) {
    boolean cont = request.getPathInfo().equals("/claimtxncreationcontinue");
    request.getSession().setAttribute(Keys.ContinueFlagKey,cont?"continue":"save");
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    MarketsModel marketsModel = mm.getMarketsModel();

    boolean premComp = marketsModel.getProgStatus().equals("5");
    if (premComp) {
      Vector list = new Vector(1);
      list.add(new LZ07Event(marketsModel.getRiskCode(),
                             marketsModel.getYearOfAcc(),
                             marketsModel.getValueCount(),
                             marketsModel.getFilCode1(),
                             marketsModel.getFilCode2(),
                             marketsModel.getDtiCode(),
                             marketsModel.getTfCode(),
                             marketsModel.getNonUSTFCode(),
                             marketsModel.getOrigBkrCurr(),
                             marketsModel.getCntryCode()));
      fireEvents(list);
      return "7";
    }

    Vector v = new Vector(1);
    v.add(LY25Helper.buildLY25Event(request));
    fireEvents(v);

    ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();

    int marketCount = marketsModel.getMarketsCount();

    if (marketCount > 1) {
      return "1";
    }
    else {
      if (cont) {
        Vector list = new Vector(1);

        if (mm.getUserWebModel().updateMode())
          list.add(LY27Helper.buildLY27Event(request));
        list.add(new LY11Event("SCR009","","N"));

        fireEvents(list);

        NextScreenModel nsm = mm.getNextScreenModel();

        // NOTE TO TEST SCR015 SCREEN- I AM JIGGING THE CODE HERE.
        // will need to uncomment code. want scr15 to act as scr012

        if (nsm.getNextScreen().equals("SCR012")) {
          mm.getPolicyRiskDetailsModel();
          Vector v1 = new Vector(2);
          v1.add(new LY12Event("SCR012"));
          v1.add(new LY28Event());
          fireEvents(v1);
          return "5";
        }

        if (nsm.getNextScreen().equals("SCR015")){
         /*  if (nsm.getNextScreen().equals("SCR012")) { */
          mm.getFinancialDetailsModel();
          Vector v1 = new Vector(2);
          v1.add(new LY12Event("SCR015"));
          v1.add(new LY37Event());
          fireEvents(v1);
          return "6";
        }

        return "2";
      }
      return "2";
    }
  }
}