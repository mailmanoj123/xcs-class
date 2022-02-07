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

public class ResetClaimTransactionFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);

    Vector list = new Vector();
    String nextScreen = request.getParameter("screen");

    if (nextScreen.equals("SCR009")) {
      list.add(new LY12Event("SCR009"));
      list.add(new LZ02Event());
      list.add(new LY13Event());
      fireEvents(list);
      return "1";
    } else if (nextScreen.equals("SCR012")) {
      list.add(new LY12Event("SCR012"));
      list.add(new LY28Event());
      fireEvents(list);
      return "2";
    } else if (nextScreen.equals("SCR013")) {
      list.add(new LY12Event("SCR013"));
      list.add(new LY31Event());
      fireEvents(list);
      return "3";
    } else if (nextScreen.equals("SCR014")) {
      list.add(new LY12Event("SCR014"));
      list.add(new LY34Event());
      fireEvents(list);
      return "4";
    } else if (nextScreen.equals("SCR015")) {
      list.add(new LY12Event("SCR015"));
      list.add(new LY37Event());
      fireEvents(list);
      return "5";
    } else if (nextScreen.equals("SCR016")) {
      list.add(new LY12Event("SCR016"));
      list.add(new LY40Event());
      fireEvents(list);
      return "6";
    } else if (nextScreen.equals("SCR017")) {
      list.add(new LY12Event("SCR017"));
      list.add(new LY43Event());
      fireEvents(list);
      // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
      // Hence we do a check here to ensure which screen we are directing the user towards.
      // Devo September 2003   CCN s229

      if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
        return "13";
      else
        return "7";

    } else if (nextScreen.equals("SCR020")) {
      list.add(new LY12Event("SCR020"));
      list.add(new LY56Event("","",""));
      fireEvents(list);
      return "8";
    } else if (nextScreen.equals("SCR021")) {
      list.add(new LY12Event("SCR021"));
      list.add(new LY59Event());
      fireEvents(list);
      return "9";
    } else if (nextScreen.equals("SCR022")) {
      list.add(new LY12Event("SCR022"));
      list.add(new LY62Event());
      fireEvents(list);
      return "10";
    } else if (nextScreen.equals("SCR023")) {
      list.add(new LY12Event("SCR023"));
      list.add(new LY98Event());
      list.add(new LY64Event("","","",""));
      fireEvents(list);
      return "11";
    } else if (nextScreen.equals("SCR024")) {
      list.add(new LY12Event("SCR024"));
      list.add(new LY67Event());
      fireEvents(list);
      return "12";
    } else //should never happen
      return "";
  }

  public void doEnd(HttpServletRequest request) {

  }
}
