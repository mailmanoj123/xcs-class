package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

import com.xchanging.xcc.web.models.reference.DropdownList.DropdownValue;
public class ServiceTypeList extends DropdownList {

    
    public ServiceTypeList(){
        values = new Vector();
    }

    
    public void createServiceType(String code, String description) {
            values.add(new DropdownValue(code,code + " - " + description));
          }
}
