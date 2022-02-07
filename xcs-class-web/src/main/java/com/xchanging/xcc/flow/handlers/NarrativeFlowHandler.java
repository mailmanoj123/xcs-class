// Remedy 177552: Changes by Brian Ambrose, Steria Limited, 19-02-2004

package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY88Event;
import com.xchanging.xcc.flow.handlers.helpers.LY25Helper;
import com.xchanging.xcc.flow.handlers.helpers.LY27Helper;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.NarrativeModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class NarrativeFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    String screen = request.getParameter("screen");
    String id = request.getParameter("id");

    if (screen.equals("SCR009")) {
      request.getSession().setAttribute(Keys.ContinueFlagKey,"notes");
      request.getSession().setAttribute("notesId",request.getParameter("id"));

      MarketsModel marketsModel = mm.getMarketsModel();
      /* REMOVED AS PER CCN 647
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
        return "2";
      }*/

      Vector v1 = new Vector(1);
      v1.add(LY25Helper.buildLY25Event(request));
      fireEvents(v1);

      ClaimTransactionCreationModel ctcModel = mm.getClaimTransactionCreationModel();

      int marketCount = marketsModel.getMarketsCount();

      if (marketCount > 1) {
        return "3";
      }
      else {
        Vector list = new Vector();

        if (mm.getUserWebModel().updateMode())
          list.add(LY27Helper.buildLY27Event(request));

        list.add(new LY88Event(id,"Y"));

        fireEvents(list);

        // Remedy 177552 - Narrative lines 300 to 600
        // Check the narrativeModel to see if a subsequent LY88 call is required
        // to retrieve further narrative lines.
        NarrativeModel nm = mm.getNarrativeModel() ;
        if (nm.getMoreLines().equalsIgnoreCase("Y"))
        {
          // Remedy 177552 - Narrative lines 300 to 600
          // There are more narrative lines to retrieve, fire another LY88 event
          // Note that the second parameter must be "N" to indicate that this
          // is not the first call to LY88 for this narrative.
          list.removeAllElements();
          list.add(new LY88Event(id,"N"));
          fireEvents(list) ;
        }
      }
    } else {
      // Remedy 177552 - Narrative lines 300 to 600
      // Moved the creation of vector v and the fireEvents(v) to inside this
      // conditional block (else screen is not scr009 (the ctc screen)),
      // as the vector v was only accessed inside this conditional block
      Vector v = new Vector();
      v.add(new LY88Event(id,"Y"));
      fireEvents(v);

      // Remedy 177552 - Narrative lines 300 to 600
      // Check the narrativeModel to see if a subsequent LY88 call is required
      // to retrieve further narrative lines.
      NarrativeModel nm = mm.getNarrativeModel() ;
      if (nm.getMoreLines().equalsIgnoreCase("Y"))
      {
      // Remedy 177552 - Narrative lines 300 to 600
        // There are more narrative lines to retrieve, fire another LY88 event
        // Note that the second parameter must be "N" to indicate that this
        // is not the first call to LY88 for this narrative.
        v.removeAllElements();
        v.add(new LY88Event(id,"N"));
        fireEvents(v) ;
      }
    }

    return "1";
  }

  public void doEnd(HttpServletRequest request) {

  }

  private String constructPresDate(HttpServletRequest req) {
    String presDateyyyy = req.getParameter("presDateyyyy");
    String presDatemm = req.getParameter("presDatemm");
    String presDatedd = req.getParameter("presDatedd");

    if ((presDateyyyy!=null) && (!presDateyyyy.equals(""))) {
      return presDateyyyy + "-" + presDatemm + "-" + presDatedd;
    }
    else {
      return "";
    }
  }

  protected String checkboxValue(String checkbox) {
    if ((checkbox==null) || (checkbox.equals("")) || (checkbox.equals("null")))
      return "N";
    else
      return "Y";
  }
}