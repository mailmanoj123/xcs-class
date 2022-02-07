package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ50Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCSavePressedWebHandler extends WebHandler{

  private ModelManager mm;
  private SchemeCanadaWebModel scwm;

  public void doStart(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    scwm = mm.getSchemeCanadaModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    Vector v = new Vector();
    // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
    v.add(new LZ50Event("SAVE",
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
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}