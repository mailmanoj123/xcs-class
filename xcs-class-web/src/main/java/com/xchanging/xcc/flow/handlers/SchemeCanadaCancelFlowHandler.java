package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ50Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SchemeCanadaCancelFlowHandler extends FlowHandler {

  private ModelManager mm;
  private SchemeCanadaWebModel scwm;

  public SchemeCanadaCancelFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    scwm = mm.getSchemeCanadaModel();

    if (scwm.getSaveButtonFlag()) {
      // Already saved/no changes - do we need to cancel?
      Vector list = new Vector();
      // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
      list.add(new LZ50Event("CANCEL",
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
      return "2";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}