package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY13Event;
import com.xchanging.xcc.events.LY28Event;
import com.xchanging.xcc.events.LY31Event;
import com.xchanging.xcc.events.LY34Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY56Event;
import com.xchanging.xcc.events.LY59Event;
import com.xchanging.xcc.events.LY62Event;
import com.xchanging.xcc.events.LY64Event;
import com.xchanging.xcc.events.LY67Event;
import com.xchanging.xcc.events.LY98Event;
import com.xchanging.xcc.events.LZ02Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class NarrativeOkFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    String screen = request.getParameter("screen");
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    Vector v = new Vector();
    String ret = "";

    if (screen.equals("SCR009")) {
      v.add(new LY12Event("SCR009"));
      v.add(new LZ02Event());
      v.add(new LY13Event());
      ret = "1";
    } else if (screen.equals("SCR012")) {
      v.add(new LY12Event("SCR012"));
      v.add(new LY28Event());
      ret = "2";
    } else if (screen.equals("SCR013")) {
      v.add(new LY12Event("SCR013"));
      v.add(new LY31Event());
      ret = "3";
    } else if (screen.equals("SCR014")) {
      v.add(new LY12Event("SCR014"));
      v.add(new LY34Event());
      ret = "4";
    } else if (screen.equals("SCR015")) {
      v.add(new LY12Event("SCR015"));
      v.add(new LY37Event());
      ret = "5";
    } else if (screen.equals("SCR016")) {
      v.add(new LY12Event("SCR016"));
      v.add(new LY40Event());
      ret = "6";
    } else if (screen.equals("SCR020")) {
      v.add(new LY12Event("SCR020"));
      v.add(new LY56Event("","",""));
      ret = "8";
    } else if (screen.equals("SCR021")) {
      v.add(new LY12Event("SCR021"));
      v.add(new LY59Event());
      ret = "9";
    } else if (screen.equals("SCR022")) {
      v.add(new LY12Event("SCR022"));
      v.add(new LY62Event());
      ret = "10";
    } else if (screen.equals("SCR023")) {
      v.add(new LY12Event("SCR023"));
      v.add(new LY98Event());
      v.add(new LY64Event("","","",""));
      ret = "11";
    } else if (screen.equals("SCR024")) {
      v.add(new LY12Event("SCR024"));
      v.add(new LY67Event());
      ret = "12";
    } else if (screen.equals("SCR017")) {
      v.add(new LY12Event("SCR017"));
      v.add(new LY43Event());
      // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
      // Hence we do a check here to ensure which screen we are directing the user towards.
      // Devo September 2003   CCN s299
    } else
      return screen;

    fireEvents(v);

    if (screen.equals("SCR017")) {
      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        ret ="13";
      else
        ret = "7";
    }

    return ret;
  }

  public void doEnd(HttpServletRequest request) {

  }

}