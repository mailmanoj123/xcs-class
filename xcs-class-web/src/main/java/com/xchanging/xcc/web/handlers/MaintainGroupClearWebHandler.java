package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.MaintainGroupModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class MaintainGroupClearWebHandler extends WebHandler {

  public void doStart(HttpServletRequest request) {
  }

  public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException {

    ModelManager mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    MaintainGroupModel maintainGroup = mm.getMaintainGroupModel();

    // Model needs to be cleared in addition to the screen being cleared when
    // the Clear button is pressed
    maintainGroup.clear();

    Vector v = new Vector();
    return v;
  }

  public void doEnd(HttpServletRequest request) {
  }
}