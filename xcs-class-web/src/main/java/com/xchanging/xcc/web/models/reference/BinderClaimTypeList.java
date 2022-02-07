package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class BinderClaimTypeList extends DropdownList {

	public BinderClaimTypeList() {
		values = new Vector();
	}

	public void createBinderClaimType(String value) {
		 values.add(new DropdownValue(value));

	}

}