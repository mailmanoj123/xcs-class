// Remedy 177552: Changes by Brian Ambrose, Steria Limited, 19-02-2004

package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY88Event;
import com.xchanging.xcc.events.LY89Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NarrativeModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class NarrativeOkWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    NarrativeModel narrModel = mm.getNarrativeModel();

    String narr = request.getParameter("narr");

    String[] narrLines = getNarrative(narr,Integer.parseInt(narrModel.getLineLength()),Integer.parseInt(narrModel.getMaxNoLines()));

    Vector v = new Vector();

    if (narrLines.length<300) {
      v.add(new LY89Event(request.getParameter("id"),"1",narrLines));
    } else {
      String[] narrLines1 = new String[300];
      String[] narrLines2 = new String[narrLines.length-300];
      for (int i=0; i<300; i++) {
        narrLines1[i] = narrLines[i];
      }
      for (int i=0; i<narrLines2.length; i++) {
        narrLines2[i] = narrLines[i+300];
      }
      v.add(new LY89Event(request.getParameter("id"),"1",narrLines1));
      v.add(new LY89Event(request.getParameter("id"),"2",narrLines2));
    }
    if (request.getPathInfo().equals("/narrativesave"))
    {
      v.add(new LY88Event(request.getParameter("id"),"Y"));

      // Remedy 177552 - Narrative lines 300 to 600
      // Check the number of lines that were entered by the user.  If there
      // were more than 300, a second LY88Event will be needed to rebuild the
      // narrative screen after the narrative save has completed
      // Note the second parameter must be N, to indicate that this is not the
      // first call to LY88 for this narrative.
      if (narrLines.length > 300) {
        v.add(new LY88Event(request.getParameter("id"),"N"));
      }
    }

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}