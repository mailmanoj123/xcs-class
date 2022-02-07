package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.flow.handlers.helpers.LY25Helper;
import com.xchanging.xcc.flow.handlers.helpers.LY27Helper;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ClaimTransactionOptionsFlowHandler extends FlowHandler {
  private ModelManager mm;

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    MarketsModel marketsModel = mm.getMarketsModel();

    String currentScreen = request.getParameter("currentScreen");
    String options = request.getParameter("options");
    Vector list = new Vector();

    if (options.equals("yes")) {
      if (currentScreen.equals("SCR009")) {
        request.getSession().setAttribute(Keys.ContinueFlagKey,"exit");

        /* REMOVED AS PER CCN #627
        boolean premComp = marketsModel.getProgStatus().equals("5");
        if (premComp) {
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
        }*/

        Vector v = new Vector(1);
        v.add(LY25Helper.buildLY25Event(request));
        fireEvents(v);

        ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();

        int marketCount = marketsModel.getMarketsCount();

        request.getSession().setAttribute(Keys.CurrentScreenKey,currentScreen);

        if (marketCount > 1) {
          return "5";
        }
        else {
          if (mm.getUserWebModel().updateMode())
            list.add(LY27Helper.buildLY27Event(request));
        }
      }
    }

    list.add(new LY11Event(currentScreen,"","Y"));

    fireEvents(list);

    NextScreenModel nextScreen = mm.getNextScreenModel();

    if (nextScreen.getNextScreen().equals("SCR004")) {
      return "1";
    } else if (nextScreen.getNextScreen().equals("SCR005")) {
      return "2";
    } else if (nextScreen.getNextScreen().equals("SCR025")) {
      return "3";
    } else if (nextScreen.getNextScreen().equals("SCR026")) {
      return "4";
    } else if (nextScreen.getNextScreen().equals("SCR007")) {
      return "8";
    } else if (nextScreen.getNextScreen().equals("NONE")) {
      return "9";
    } else if (nextScreen.getNextScreen().equals("SCR006")) {
      return "10";
    } else if (nextScreen.getNextScreen().equals("SCR045")) {
      return "11";
    } else //should never happen
      return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

  private String constructPresDate(HttpServletRequest request) {
    String presDateyyyy = (String)request.getParameter("presDateyyyy");
    String presDatemm = (String)request.getParameter("presDatemm");
    String presDatedd = (String)request.getParameter("presDatedd");

    if ((presDateyyyy!=null) && (!presDateyyyy.equals(""))) {
      return presDateyyyy + "-" + presDatemm + "-" + presDatedd;
    }
    else {
      return "";
    }
  }
}