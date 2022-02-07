package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class SlipTypeList extends DropdownList {
	
	public SlipTypeList() {
	    values = new Vector();
	  }

	  public void createSlipTypeList(String desc) {
	    values.add(new DropdownValue(desc));
	  }

}
