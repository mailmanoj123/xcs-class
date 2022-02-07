package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ24Event;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.CCVCQuestionnaireModel;
import com.xchanging.xcc.web.models.manager.ModelManager;


public class CCVCQuestionnaireWebHandler extends WebHandler
{
    
    Vector v = new Vector();
    ModelManager mm;
    CCVCQuestionnaireModel ccvcQuestionnaireModel;

    public void doStart(HttpServletRequest request)
    {
        mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
        ccvcQuestionnaireModel = mm.getCCVCQuestionnaireModel();
    }

    public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException
    {
        v.add(new LZ24Event());
        return v;
    }

    public void doEnd(HttpServletRequest request)
    {
    }

}
