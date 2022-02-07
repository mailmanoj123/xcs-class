package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.events.LY37Event;
import com.xchanging.xcc.events.LY40Event;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.SecurityNotesModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class OSNDSearchCorFlowHandler extends FlowHandler {

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    SecurityNotesModel securityNotes = mm.getSecurityNotesModel();

    if (securityNotes.getProgStatus().equals("2")) {
      return "2";
    } else {

      /*Vector list = new Vector(1);
      list.add(new LY11Event("SCR007","","N"));
      fireEvents(list);*/

      NextScreenModel nextScreen =  mm.getNextScreenModel();

      if (nextScreen.getNextScreen().equals("SCR017")) {
        Vector list = new Vector();
        list.add(new LY12Event("SCR017"));
        list.add(new LY43Event());
        fireEvents(list);
        // The scm advice screen is split into an SCM Enquiry and SCM Update screen.
        // Hence we do a check here to ensure which screen we are directing the user towards.
        // Devo September 2003   CCN s229

        if (mm.getSCMAdviceModel().getScreenMode().equals("E"))
          return "6";
        else
          return "3";

      } else if (nextScreen.getNextScreen().equals("SCR016")) {
        Vector list = new Vector();
        list.add(new LY12Event("SCR016"));
        list.add(new LY40Event());
        fireEvents(list);

        return "4";
      } else if (nextScreen.getNextScreen().equals("SCR015")) {
        Vector list = new Vector();
        list.add(new LY12Event("SCR015"));
        list.add(new LY37Event());
        fireEvents(list);

        return "5";
      }
      else //should never happen
        return "1";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}