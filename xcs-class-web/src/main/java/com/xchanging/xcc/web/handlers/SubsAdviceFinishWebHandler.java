package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY17Event;
import com.xchanging.xcc.events.LY19Event;
import com.xchanging.xcc.events.LY57Event;
import com.xchanging.xcc.events.LY58Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.SubsequentAdviceScheduleModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class SubsAdviceFinishWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    mm.getSummaryNonSettlementModel();
    mm.getSummarySettlementModel();
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {
    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    SubsequentAdviceScheduleModel subs = mm.getSubsequentAdviceScheduleModel();

    Vector dels = new Vector();
    Vector name1s = new Vector();
    Vector name1quals = new Vector();
    Vector statecodes = new Vector();
    Vector naiccodes = new Vector();
    Vector naicquals = new Vector();
    Vector dolquals = new Vector();
    Vector catcodes = new Vector();
    Vector name2s = new Vector();
    Vector name2quals = new Vector();
    Vector tfcodes = new Vector();
    Vector filcodes = new Vector();
    Vector pcscodes = new Vector();
    Vector dolfroms = new Vector();
    Vector doltos = new Vector();
    Vector cors = new Vector();
    Vector statsplits = new Vector();
    Vector mvmtrefs = new Vector();
    Vector breakdownnos = new Vector();
    Vector osamts = new Vector();
    Vector pttamts = new Vector();

    int i=1;

    while(request.getParameter("cor" + i)!=null) {

      dels.add(checkboxValue(request.getParameter("delchkbox" + i)));
      name1s.add(request.getParameter("name1" + i));
      name1quals.add(request.getParameter("name1qual" + i));
      statecodes.add(request.getParameter("statecode" + i));
      naiccodes.add(request.getParameter("naiccode" + i));
      naicquals.add(request.getParameter("naicqual" + i));
      dolquals.add(request.getParameter("dolqual" + i));
      catcodes.add(request.getParameter("catcode" + i));
      name2s.add(request.getParameter("name2" + i));
      name2quals.add(request.getParameter("name2qual" + i));
      tfcodes.add(request.getParameter("tfcode" + i));
      filcodes.add(request.getParameter("filcode" + i));
      pcscodes.add(request.getParameter("pcscode" + i));
      dolfroms.add(request.getParameter("dolfrom" + i + "yyyy") + "-" + request.getParameter("dolfrom" + i + "mm") + "-" + request.getParameter("dolfrom" + i + "dd"));
      doltos.add(request.getParameter("dolto" + i + "yyyy") + "-" + request.getParameter("dolto" + i + "mm") + "-" + request.getParameter("dolto" + i + "dd"));
      cors.add(request.getParameter("cor" + i));
      statsplits.add(request.getParameter("statsplit" + i));
      mvmtrefs.add(request.getParameter("mvmtref" + i));
      breakdownnos.add(request.getParameter("breakdownno" + i));
      osamts.add(request.getParameter("osAmt" + i));
      pttamts.add(request.getParameter("pttAmt" + i));

      i++;
    }

    i=i-1;

    String[] delsA = new String[i];
    String[] name1sA = new String[i];
    String[] name1qualsA = new String[i];
    String[] statecodesA = new String[i];
    String[] naiccodesA = new String[i];
    String[] naicqualsA = new String[i];
    String[] dolqualsA = new String[i];
    String[] catcodesA = new String[i];
    String[] name2sA = new String[i];
    String[] name2qualsA = new String[i];
    String[] tfcodesA = new String[i];
    String[] filcodesA = new String[i];
    String[] pcscodesA = new String[i];
    String[] dolfromsA = new String[i];
    String[] doltosA = new String[i];
    String[] corsA = new String[i];
    String[] statsplitsA = new String[i];
    String[] mvmtrefsA = new String[i];
    String[] breakdownnosA = new String[i];
    String[] osamtsA = new String[i];
    String[] pttamtsA = new String[i];

    for (int j=0; j<cors.size(); j++) {

      delsA[j] = (String)dels.elementAt(j);
      name1sA[j] = (String)name1s.elementAt(j);
      name1qualsA[j] = (String)name1quals.elementAt(j);
      statecodesA[j] = (String)statecodes.elementAt(j);
      naiccodesA[j] = (String)naiccodes.elementAt(j);
      naicqualsA[j] = (String)naicquals.elementAt(j);
      dolqualsA[j] = (String)dolquals.elementAt(j);
      catcodesA[j] = (String)catcodes.elementAt(j);
      name2sA[j] = (String)name2s.elementAt(j);
      name2qualsA[j] = (String)name2quals.elementAt(j);
      tfcodesA[j] = (String)tfcodes.elementAt(j);
      filcodesA[j] = (String)filcodes.elementAt(j);
      pcscodesA[j] = (String)pcscodes.elementAt(j);
      dolfromsA[j] = (String)dolfroms.elementAt(j);
      doltosA[j] = (String)doltos.elementAt(j);
      corsA[j] = (String)cors.elementAt(j);
      statsplitsA[j] = (String)statsplits.elementAt(j);
      mvmtrefsA[j] = (String)mvmtrefs.elementAt(j);
      breakdownnosA[j] = (String)breakdownnos.elementAt(j);
      osamtsA[j] = (String)osamts.elementAt(j);
      pttamtsA[j] = (String)pttamts.elementAt(j);
    }

    Vector v = new Vector();
    v.add(new LY57Event(corsA,delsA,statsplitsA,breakdownnosA,mvmtrefsA,name1sA,name1qualsA,name2sA,name2qualsA,filcodesA,tfcodesA,
                        statecodesA,dolfromsA,doltosA,dolqualsA,catcodesA,pcscodesA,naiccodesA,naicqualsA,osamtsA,pttamtsA));
    v.add(new LY58Event(corsA,delsA,statsplitsA,breakdownnosA,mvmtrefsA,name1sA,name1qualsA,name2sA,name2qualsA,filcodesA,tfcodesA,
                        statecodesA,dolfromsA,doltosA,dolqualsA,catcodesA,pcscodesA,naiccodesA,naicqualsA,osamtsA,pttamtsA));
    v.add(new LY19Event(subs.getcurrNo()));
    v.add(new LY17Event());
    v.add(new LY11Event("SCR020","","N"));

    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}