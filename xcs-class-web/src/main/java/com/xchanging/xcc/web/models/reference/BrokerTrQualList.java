package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class BrokerTrQualList extends DropdownList {

	public BrokerTrQualList() {
		values = new Vector();
	}

	public void createBrokerTrQual(String code, String description) {
		if (code.equals("")) {
			values.add(new DropdownValue(""));
		} else {
			values.add(new DropdownValue(code, code + " - " + description));
		}

	}

}