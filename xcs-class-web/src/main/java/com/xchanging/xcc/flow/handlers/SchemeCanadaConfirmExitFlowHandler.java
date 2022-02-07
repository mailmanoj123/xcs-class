package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ50Event;
import com.xchanging.xcc.events.LogoffEvent;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SchemeCanadaConfirmExitFlowHandler extends FlowHandler {

  private ModelManager mm;
  private SchemeCanadaWebModel scwm;

  public SchemeCanadaConfirmExitFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {

    String choice = request.getParameter("choice");
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    scwm = mm.getSchemeCanadaModel();
    Vector list = new Vector();

    if (choice.equals("ok")) {
        // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
      list.add(new LZ50Event("SAVEEXIT",
                             scwm.getSavedFlagString(),
                             scwm.getBusinessClass(),
                             "N",
                             "N",
                             null,
                             null,
                             null,
                             scwm.getPrevAttr(),
                             scwm.getNextAttr(),
                             scwm.getAutoAttr(),
                             scwm.getCommercialAttr(),
                             scwm.getResidentialAttr(),
                             scwm.getRowsFrom(),
                             scwm.getRowsTo(),
                             scwm.getRowsTotal(),
                             scwm.getReprocTotalStat(),
                             scwm.getXcsTotalStat()     ) );
      fireEvents(list);
      return "1";
    } else {
      // Abandon changes
        // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
      list.add(new LZ50Event("EXIT",
                             scwm.getSavedFlagString(),
                             scwm.getBusinessClass(),
                             "N",
                             "N",
                             null,
                             null,
                             null,
                             scwm.getPrevAttr(),
                             scwm.getNextAttr(),
                             scwm.getAutoAttr(),
                             scwm.getCommercialAttr(),
                             scwm.getResidentialAttr(),
                             scwm.getRowsFrom(),
                             scwm.getRowsTo(),
                             scwm.getRowsTotal(),
                             scwm.getReprocTotalStat(),
                             scwm.getXcsTotalStat()     ) );
      list.add(new LogoffEvent(false));
      fireEvents(list);
      return "2";
    }

  }

  public void doEnd(HttpServletRequest request) {

  }

}