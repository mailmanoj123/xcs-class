package com.xchanging.xcc.web.models.reference;

import java.util.Vector;

public class CauseCodeList extends DropdownList
{

    public CauseCodeList()
    {
        values = new Vector();
    }

    public void createCauseCode(String code, String desc)
    {
        values.add(new DropdownValue(code, code +" - "+desc));
    }
}
