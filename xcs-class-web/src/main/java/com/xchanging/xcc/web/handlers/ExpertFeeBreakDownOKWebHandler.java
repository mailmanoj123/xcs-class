package com.xchanging.xcc.web.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.html.HTMLUtils;
import com.xchanging.xcc.web.models.ExpertFeeBreakDownModel;
import com.xchanging.xcc.web.models.ExpertFeeBreakDownModel.ExpertFeeBreakDownDetail;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ExpertFeeBreakDownOKWebHandler extends WebHandler
{
    
    Vector v = new Vector();
    ModelManager mm;
    ExpertFeeBreakDownModel expertFeeBDModel;
    
    public void doStart(HttpServletRequest request)
    {
        mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
        mm.getSCMAdviceModel();
        expertFeeBDModel = mm.getExpertFeeBreakDownModel();
    }

    public Vector processRequest(HttpServletRequest request) throws ClaimsErrorException
    {
        Vector vctExpertFeeBreakDownROWS = new Vector();

        /*Explicitly setting the previous vector to NULL so that it can be used in GC*/
        expertFeeBDModel.setExpertFeeBreakDownROWS(null);
        
        expertFeeBDModel.setExpertFeeBreakDownROWS(vctExpertFeeBreakDownROWS);
        expertFeeBDModel.setExpertCount(0+"");
        
        /*Populate with the screen values*/
        int rowCount = request.getParameter("rowCount")!=null && !request.getParameter("rowCount").equals("")?Integer.parseInt(request.getParameter("rowCount")):0;
        
        if(rowCount==1)
        {
            ExpertFeeBreakDownDetail expertFeeBreakDownDetail = expertFeeBDModel.new ExpertFeeBreakDownDetail(request.getParameter("expertCode"), request.getParameter("expertType"), request
                    .getParameter("expertRef"), request.getParameter("expertSCM"), request.getParameter("expertName"), request.getParameter("expertCNTC"),HTMLUtils.removeCommas(request
                    .getParameter("expertPTD_EXP")), HTMLUtils.removeCommas(request.getParameter("expertPTD_FEE")), HTMLUtils.removeCommas(request.getParameter("expertPTT_EXP")), HTMLUtils.removeCommas(request
                    .getParameter("expertPTT_FEE")), HTMLUtils.removeCommas(request.getParameter("expertOS_EXP")), HTMLUtils.removeCommas(request.getParameter("expertOS_FEE")));

            expertFeeBreakDownDetail.addFlags(request.getParameter("expertCodeFlag"), Boolean.valueOf(request.getParameter("expertTypeFlag")).booleanValue(), request
                    .getParameter("expertRefFlag"), request.getParameter("expertSCMFlag"), Boolean.valueOf(request.getParameter("expertNameFlag")).booleanValue(), request.getParameter("expertCNTCFlag"), request
                    .getParameter("expertPTD_EXPFlag"), request.getParameter("expertPTD_FEEFlag"), request.getParameter("expertPTT_EXPFlag"), request
                    .getParameter("expertPTT_FEEFlag"), request.getParameter("expertOS_EXPFlag"), request.getParameter("expertOS_FEEFlag"), request.getParameter("deleteExpertFlag"));
            
            vctExpertFeeBreakDownROWS.add(expertFeeBreakDownDetail);
  
        }
        else if(rowCount>1)
        {
            String expertCodes[] = request.getParameterValues("expertCode");
            String expertTypes[] = request.getParameterValues("expertType");
            String expertRefs[] = request.getParameterValues("expertRef");
            String expertSCMs[] = request.getParameterValues("expertSCM");
            String expertNames[] = request.getParameterValues("expertName");
            String expertCNTCs[] = request.getParameterValues("expertCNTC");
            
            String expertPTD_EXPs[] = request.getParameterValues("expertPTD_EXP");
            String expertPTD_FEEs[] = request.getParameterValues("expertPTD_FEE");
            String expertPTT_EXPs[] = request.getParameterValues("expertPTT_EXP");
            String expertPTT_FEEs[] = request.getParameterValues("expertPTT_FEE");
            String expertOS_EXPs[] = request.getParameterValues("expertOS_EXP");
            String expertOS_FEEs[] = request.getParameterValues("expertOS_FEE");
            
            String expertCodeFlags[] = request.getParameterValues("expertCodeFlag");
            String expertTypeFlags[] = request.getParameterValues("expertTypeFlag");
            String expertRefFlags[] = request.getParameterValues("expertRefFlag");
            String expertSCMFlags[] = request.getParameterValues("expertSCMFlag");
            String expertNameFlags[] = request.getParameterValues("expertNameFlag");
            String expertCNTCFlags[] = request.getParameterValues("expertCNTCFlag");
            
            String expertPTD_EXPFlags[] = request.getParameterValues("expertPTD_EXPFlag");
            String expertPTD_FEEFlags[] = request.getParameterValues("expertPTD_FEEFlag");
            String expertPTT_EXPFlags[] = request.getParameterValues("expertPTT_EXPFlag");
            String expertPTT_FEEFlags[] = request.getParameterValues("expertPTT_FEEFlag");
            String expertOS_EXPFlags[] = request.getParameterValues("expertOS_EXPFlag");
            String expertOS_FEEFlags[] = request.getParameterValues("expertOS_FEEFlag");
            String deleteExpertFlags[] = request.getParameterValues("deleteExpertFlag");
            

            for (int i = 0; i < rowCount; i++)
            {
                ExpertFeeBreakDownDetail expertFeeBreakDownDetail = expertFeeBDModel.new ExpertFeeBreakDownDetail(expertCodes[i], expertTypes[i], expertRefs[i], expertSCMs[i], expertNames[i], expertCNTCs[i], HTMLUtils.removeCommas(expertPTD_EXPs[i]), HTMLUtils.removeCommas(expertPTD_FEEs[i]), HTMLUtils.removeCommas(expertPTT_EXPs[i]), HTMLUtils.removeCommas(expertPTT_FEEs[i]), HTMLUtils.removeCommas(expertOS_EXPs[i]), HTMLUtils.removeCommas(expertOS_FEEs[i]));
                expertFeeBreakDownDetail.addFlags(expertCodeFlags[i], Boolean.valueOf(expertTypeFlags[i]).booleanValue(), expertRefFlags[i], expertSCMFlags[i], Boolean.valueOf(expertNameFlags[i]).booleanValue(), expertCNTCFlags[i], expertPTD_EXPFlags[i], expertPTD_FEEFlags[i], expertPTT_EXPFlags[i], expertPTT_FEEFlags[i], expertOS_EXPFlags[i], expertOS_FEEFlags[i], deleteExpertFlags[i]);

                vctExpertFeeBreakDownROWS.add(expertFeeBreakDownDetail);
            }
        }
        
        expertFeeBDModel.setExpertFeeBreakDownROWS(vctExpertFeeBreakDownROWS);
        expertFeeBDModel.setExpertCount(rowCount+"");

        return v;
    }

    public void doEnd(HttpServletRequest request)
    {
    }

}
