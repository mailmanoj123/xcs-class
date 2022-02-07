package com.xchanging.xcc.web.models.reference;

import java.util.Enumeration;
import java.util.Vector;

import com.xchanging.xcc.web.models.WebModel;

public class ExpertCodeList extends ReferenceList
{

    private Vector expertCodes;

    public ExpertCodeList()
    {
        expertCodes = new Vector();
    }

    public void sort()
    {
        expertCodes = doSort(expertCodes);
    }

    public void createExpertCode(String type, String code, String sname, String name)
    {
        expertCodes.add(new ExpertCode(type, code, sname, name));
    }

    public Enumeration getExpertCodes()
    {
        return expertCodes.elements();
    }

    public boolean validate(String code)
    {
        boolean found = false;
        for (int i = 0; i < expertCodes.size(); i++)
        {
            ExpertCode b = (ExpertCode) expertCodes.get(i);
            if (b.getCode().equals(code))
            {
                found = true;
                break;
            }
        }
        return found;
    }

    public class ExpertCode extends WebModel implements Comparable
    {

        private String type;

        private String code;

        private String sname;

        private String name;

        public ExpertCode(String type, String code, String sname, String name)
        {
            this.type = type;
            this.code = code;
            this.sname = sname;
            this.name = name;
        }

        public String getType()
        {
            return type;
        }

        public String getCode()
        {
            return code;
        }

        public String getSname()
        {
            return sname;
        }

        public String getName()
        {
            return name;
        }

        public int compareTo(Object o)
        {
            return name.compareTo(((ExpertCode) o).getName());
        }
    }
}
