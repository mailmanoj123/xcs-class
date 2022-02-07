
package com.xchanging.xcc.flow.handlers;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.events.LZ17Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.FindSettlementSearchResultsModel;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class FindSettlementResultsFlowHandler extends FlowHandler {

  private ModelManager mm;
  private FindSettlementSearchResultsModel srm;

  public FindSettlementResultsFlowHandler() {
  }

  public void doStart(HttpServletRequest request) {
    this.session = request.getSession();
  }

  public String processFlow(HttpServletRequest request) {
    mm = (ModelManager)request.getSession().getAttribute(Keys.ModelManagerKey);
    srm = mm.getFindSettlementSearchResults();
    // Get the FindSettlementDetailsWebHandler ready for action- as it will be required if more than one result from the search
    // is returned.
    mm.getFindSettlementSearchDetailResults();


    // Basically if there is more than one result line returned from the search then we throw the user to the
    // search results screen. However if there is only one result returned then we throw them straight to the
    // search results detail screen.
    // NOTE: If no records are thrown then the Mainframe will pass back an warning.
    if ((Integer.parseInt(srm.getNoSearchResults()) > 1) || (Integer.parseInt(srm.getNoSearchResults()) == 0)) {
      return "1";
    } else {

      // There is only one result returned- hence we will go straight to the details screen.
      Vector list = new Vector();
      list.add(new LZ17Event(((FindSettlementSearchResultsModel.singleSearchResultsLine) srm.getVAllSearchDetails().get(0)).getLidstdnNo(),
                             ((FindSettlementSearchResultsModel.singleSearchResultsLine) srm.getVAllSearchDetails().get(0)).getLidstdnDate(),
                             ((FindSettlementSearchResultsModel.singleSearchResultsLine) srm.getVAllSearchDetails().get(0)).getVersion()));
      fireEvents(list);
      return "2";
    }
  }

  public void doEnd(HttpServletRequest request) {

  }

}
