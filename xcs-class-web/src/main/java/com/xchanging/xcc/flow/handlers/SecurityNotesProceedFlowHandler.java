package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SecurityNotesProceedFlowHandler extends FlowHandler {

  public SecurityNotesProceedFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    String nextScreen = ((NextScreenModel)mm.getNextScreenModel()).getNextScreen();

    Vector v = new Vector(2);

    if (nextScreen.equals("SCR009")) {
      v.add(new LY12Event("SCR009"));
      v.add(new LZ02Event());
      v.add(new LY13Event());
      fireEvents(v);
      return "2";
    }
    else if (nextScreen.equals("SCR016")) {
      v.add(new LY12Event("SCR016"));
      v.add(new LY40Event());
      fireEvents(v);
      return "3";
    }
    else if (nextScreen.equals("SCR017")) {
      v.add(new LY12Event("SCR017"));
      v.add(new LY43Event());
      fireEvents(v);

      // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
      // Hence we do a check here to ensure which screen we are directing the user towards.
      // Devo September 2003   CCN s229

      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        return "7";
      else
        return "4";
    }
    else if (nextScreen.equals("SCR015")) {
      v.add(new LY12Event("SCR015"));
      v.add(new LY37Event());
      fireEvents(v);
      return "5";
    }
    else if (nextScreen.equals("SCR020")) {
      v.add(new LY12Event("SCR020"));
      v.add(new LY56Event("","",""));
      fireEvents(v);
      return "6";
    }
    else {
      // Should never happen
      return "1";
    }

  }

  public void doEnd(HttpServletRequest request) {

  }

}