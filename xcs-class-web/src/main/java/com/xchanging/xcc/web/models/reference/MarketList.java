/* CCN# N0030 - BA - 7/1/2002 */

package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class MarketList extends DropdownList {

  public MarketList() {
    values = new Vector();
  }

  public void createMarket(String code, String description) {
    values.add(new DropdownValue(code));
  }
}