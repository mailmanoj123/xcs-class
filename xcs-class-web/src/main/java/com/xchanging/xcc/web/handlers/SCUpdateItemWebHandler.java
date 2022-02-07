package com.xchanging.xcc.web.handlers;

import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ50Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel.Row;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SCUpdateItemWebHandler extends WebHandler {

  private ModelManager mm;
  private SchemeCanadaWebModel scwm;

  public void doStart(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    scwm = mm.getSchemeCanadaModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    String[] rowNumber       = new String[1];
    String[] processFlags    = new String[1];
    String[] flagChangedInds = new String[1];

    boolean keepLooking = true;
    Enumeration rows = scwm.getFieldValues();
    while (rows.hasMoreElements() && keepLooking) {
      Row row = (Row)rows.nextElement();
      String existingAction = row.getAction();
      String newAction = request.getParameter("processFlag_" + row.getRowNumber());

      if (!newAction.equals(existingAction)) {
        rowNumber[0]       = row.getRowNumber();
        processFlags[0]    = newAction;
        flagChangedInds[0] = "Y";
        keepLooking = false;
      }
    }

    Vector v = new Vector();

    // 26/04/04 changes for S456/S457, new stats. Patrick Cogan.
    v.add(new LZ50Event("ACTION",
                        scwm.getSavedFlagString(),
                        scwm.getBusinessClass(),
                        "N",
                        "N",
                        rowNumber,
                        processFlags,
                        flagChangedInds,
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