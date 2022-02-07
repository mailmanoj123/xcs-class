package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY72Event;
import com.xchanging.xcc.events.LY73Event;
import com.xchanging.xcc.events.LY74Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.MaintainGroupModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MaintainGroupUpdateWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    MaintainGroupModel maintainGroup = mm.getMaintainGroupModel();

    Vector ucrOsnds = new Vector();
    Vector delInds = new Vector();
    int i = 1;

    if (maintainGroup.isAggregate()) {
      while (request.getParameter("osnd" + i + "yy")!=null) {
        String osnd = getCentury(request.getParameter("osnd" + i + "yy")) +
                      request.getParameter("osnd" + i + "yy") +
                      request.getParameter("osnd" + i + "mm") +
                      request.getParameter("osnd" + i + "dd") +
                      request.getParameter("osnd" + i + "sssss");
        delInds.add(checkboxValue(request.getParameter("del" + i)));

        ucrOsnds.add(osnd);
        i++;
      }

      // NOW we'll deal with the rows that were Inserted by the user.
      int j = 1;
      // We'll use the signing number as a base to see if the full row has been inserted
      String signingNumber = request.getParameter("osndsssssInsert" + j);

      while ((signingNumber!=null) && (!signingNumber.equals(""))) {
        String osndInsert = getCentury(request.getParameter("osndyyInsert" + j  )) +
                            request.getParameter("osndyyInsert" + j) +
                            request.getParameter("osndmmInsert" + j) +
                            request.getParameter("osndddInsert" + j) +
                            request.getParameter("osndsssssInsert" + j );
        ucrOsnds.add(osndInsert);
        // We'll default to "N" as this is a newly inserted item which will not exist on the M/F
        delInds.add("N");
        j++;
        signingNumber = request.getParameter("osndsssssInsert" + j);
      }
    } else {
      while (request.getParameter("ucr" + i + "pt1")!=null) {
        String ucr = request.getParameter("ucr" + i + "pt1") +
                     request.getParameter("ucr" + i + "pt2") +
                     request.getParameter("ucr" + i + "pt3");
        delInds.add(checkboxValue(request.getParameter("del" + i)));

        ucrOsnds.add(ucr);
        i++;
      }

      // NOW we'll deal with the rows that were Inserted by the user.
      int k = 1;
     // We'll use part 3 of the ucr as a base to see if the full row has been inserted
      String signingNumber = request.getParameter("ucr3ptInsert" + k);

      while ((signingNumber!=null) && (!signingNumber.equals(""))) {
        String ucr = request.getParameter("ucr1ptInsert" + k) +
                     request.getParameter("ucr2ptInsert" + k) +
                     request.getParameter("ucr3ptInsert" + k);

        ucrOsnds.add(ucr);
        // We'll default to "N" as this is a newly inserted item which will not exist on the M/F
        delInds.add("N");
        k++;
        signingNumber = request.getParameter("ucr3ptInsert" + k);
      }

    }

    String[] osndUcrArray = new String[ucrOsnds.size()];
    String[] delIndArray  = new String[delInds.size()];

    for (int j=0; j<osndUcrArray.length; j++) {
      osndUcrArray[j] = (String)ucrOsnds.elementAt(j);
      delIndArray[j] = (String)delInds.elementAt(j);
    }

    Vector v = new Vector();
    v.add(new LY73Event(request.getParameter("aggGrpNonAggRef"),osndUcrArray,delIndArray));
    v.add(new LY74Event(request.getParameter("aggGrpNonAggRef"),osndUcrArray,delIndArray));
    // NEED TO REFRESH THE SCREEN //
    v.add(new LY72Event(request.getParameter("aggGrpNonAggRef"),true));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}