package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY43Event;
import com.xchanging.xcc.events.LY44Event;
import com.xchanging.xcc.events.LY45Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class ExpertFeeBreakDownModel extends WebModel implements ModelUpdateListener
{
    private ModelManager mm;

    private Vector vctExpertFeeBreakDownROWS;
    private String strExpertCount;
    private String strExpertCountAttribute;
    private String strExpertScreenMode;
    private String strFEE_PTD_ATTR;
    private String strEXP_PTD_ATTR;
    
    public ExpertFeeBreakDownModel(ModelManager mm)
    {
        this.mm = mm;
        mm.addListener(Keys.ExpertFeeBreakDownModelKey, this);
    }

    public void performUpdate()
    {
        MappedRecord results = (MappedRecord) session.getAttribute((Keys.CicsDataKey));
        ClaimsEvent event = (ClaimsEvent) session.getAttribute(Keys.WebEventKey);
                
        if (event instanceof LY43Event)
        {
            MappedRecord mrFieldValues = (MappedRecord) ((Vector) results.get(Keys.LY43_FIELD_VALUES)).get(0);
            MappedRecord mrFieldAttributes = (MappedRecord) ((Vector) results.get(Keys.LY43_FIELD_ATTRIBUTES)).get(0);

            strExpertCount = (String)mrFieldValues.get(Keys.LY43_EXPERT_COUNT);
            strExpertScreenMode = (String)mrFieldAttributes.get(Keys.LY43_EXP_SCREEN_ATTR);
            strExpertCountAttribute = (String)mrFieldAttributes.get(Keys.LY43_EXPERT_ATTR_COUNT);
            strFEE_PTD_ATTR = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_FEE_PTD_ATTR));
            strEXP_PTD_ATTR = enabledStatus((String)mrFieldAttributes.get(Keys.LY43_EXP_PTD_ATTR));
                       
            Vector vctExpertFeeBreakDownDetails = (Vector) mrFieldValues.get(Keys.LY43_EXPERT_DETAILS);
            Vector vctExpertFeeBreakDownAttributes = (Vector) mrFieldAttributes.get(Keys.LY43_EXPERT_ATTR);
            
            int expertIndex = 0;
            if(strExpertCount!=null && !"".equals(strExpertCount))
            {
                expertIndex = Integer.parseInt(strExpertCount);
            }
            
            vctExpertFeeBreakDownROWS = new Vector();

            for (int i = 0; i < expertIndex; i++)
            {
                MappedRecord mrExpertFeeBreakDownDetail = (MappedRecord) vctExpertFeeBreakDownDetails.get(i);
                MappedRecord mrExpertFeeBreakDownAttribute = (MappedRecord) vctExpertFeeBreakDownAttributes.get(i);

                ExpertFeeBreakDownDetail expertFeeBreakDownDetail = new ExpertFeeBreakDownDetail((String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_CODE), (String) mrExpertFeeBreakDownDetail
                        .get(Keys.LY43_EXPERT_TYPE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_REF), (String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_SCM),
                        (String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_NAME), (String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_CNTCT), (String) mrExpertFeeBreakDownDetail
                                .get(Keys.LY43_EXPERT_PTD_EXP), (String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_PTD_FEE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_PTT_EXP),
                        (String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_PTT_FEE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY43_EXPERT_OS_EXP), (String) mrExpertFeeBreakDownDetail
                                .get(Keys.LY43_EXPERT_OS_FEE));

                expertFeeBreakDownDetail.addFlags(enabledStatus((String) mrExpertFeeBreakDownAttribute.get(Keys.LY43_EX_CODE_ATTR)), convertToBoolean((String) mrExpertFeeBreakDownAttribute
                        .get(Keys.LY43_EX_TYPE_ATTR)), enabledStatus((String) mrExpertFeeBreakDownAttribute.get(Keys.LY43_EX_REF_ATTR)), enabledStatusCheckbox((String) mrExpertFeeBreakDownAttribute
                        .get(Keys.LY43_EX_SCM_ATTR)), convertToBoolean((String) mrExpertFeeBreakDownAttribute.get(Keys.LY43_EX_NAME_ATTR)), enabledStatus((String) mrExpertFeeBreakDownAttribute
                        .get(Keys.LY43_EX_CNTCT_ATTR)), enabledStatus((String) mrExpertFeeBreakDownAttribute.get(Keys.LY43_EX_PTD_EXP_ATTR)), enabledStatus((String) mrExpertFeeBreakDownAttribute
                        .get(Keys.LY43_EX_PTD_FEE_ATTR)), enabledStatus((String) mrExpertFeeBreakDownAttribute.get(Keys.LY43_EX_PTT_EXP_ATTR)), enabledStatus((String) mrExpertFeeBreakDownAttribute
                        .get(Keys.LY43_EX_PTT_FEE_ATTR)), enabledStatus((String) mrExpertFeeBreakDownAttribute.get(Keys.LY43_EX_OS_EXP_ATTR)), enabledStatus((String) mrExpertFeeBreakDownAttribute
                        .get(Keys.LY43_EX_OS_FEE_ATTR)), enabledStatusCheckbox((String) mrExpertFeeBreakDownAttribute.get(Keys.LY43_EX_DEL_ATTR)));

                vctExpertFeeBreakDownROWS.add(expertFeeBreakDownDetail);
            }
        }
        else if (event instanceof LY44Event)
        {
            MappedRecord mrFieldValues = (MappedRecord) ((Vector) results.get(Keys.LY44_FIELD_VALUES)).get(0);
            
            strExpertCount = (String)mrFieldValues.get(Keys.LY44_EXPERT_COUNT);
            Vector vctExpertFeeBreakDownDetails = (Vector) mrFieldValues.get(Keys.LY44_EXPERT_DETAILS);

            int expertIndex = 0;
            if(strExpertCount!=null && !"".equals(strExpertCount))
            {
                expertIndex = Integer.parseInt(strExpertCount);
            }

            for (int i = 0; i < expertIndex; i++)
            {
                MappedRecord mrExpertFeeBreakDownDetail = (MappedRecord) vctExpertFeeBreakDownDetails.get(i);
                ExpertFeeBreakDownDetail expertFeeBreakDownDetail = (ExpertFeeBreakDownDetail) vctExpertFeeBreakDownROWS.get(i);

                expertFeeBreakDownDetail.updateValues((String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_CODE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_TYPE),
                        (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_REF), (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_SCM), (String) mrExpertFeeBreakDownDetail
                                .get(Keys.LY44_EXPERT_NAME), (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_CNTCT), (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_PTD_EXP),
                        (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_PTD_FEE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_PTT_EXP), (String) mrExpertFeeBreakDownDetail
                                .get(Keys.LY44_EXPERT_PTT_FEE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_OS_EXP), (String) mrExpertFeeBreakDownDetail.get(Keys.LY44_EXPERT_OS_FEE));
            }
        }

        else if (event instanceof LY45Event)
        {
            MappedRecord mrFieldValues = (MappedRecord) ((Vector) results.get(Keys.LY45_FIELD_VALUES)).get(0);

            strExpertCount = (String)mrFieldValues.get(Keys.LY45_EXPERT_COUNT);
            Vector vctExpertFeeBreakDownDetails = (Vector) mrFieldValues.get(Keys.LY45_EXPERT_DETAILS);

            int expertIndex = 0;
            if(strExpertCount!=null && !"".equals(strExpertCount))
            {
                expertIndex = Integer.parseInt(strExpertCount);
            }

            for (int i = 0; i < expertIndex; i++)
            {
                MappedRecord mrExpertFeeBreakDownDetail = (MappedRecord) vctExpertFeeBreakDownDetails.get(i);
                ExpertFeeBreakDownDetail expertFeeBreakDownDetail = (ExpertFeeBreakDownDetail) vctExpertFeeBreakDownROWS.get(i);

                expertFeeBreakDownDetail.updateValues((String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_CODE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_TYPE),
                        (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_REF), (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_SCM), (String) mrExpertFeeBreakDownDetail
                                .get(Keys.LY45_EXPERT_NAME), (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_CNTCT), (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_PTD_EXP),
                        (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_PTD_FEE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_PTT_EXP), (String) mrExpertFeeBreakDownDetail
                                .get(Keys.LY45_EXPERT_PTT_FEE), (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_OS_EXP), (String) mrExpertFeeBreakDownDetail.get(Keys.LY45_EXPERT_OS_FEE));
            }
        }
    }

    public Vector getExpertFeeBreakDownROWS()
    {
        return vctExpertFeeBreakDownROWS;
    }
    
    public void setExpertFeeBreakDownROWS(Vector vctExpertFeeBreakDownROWS0)
    {
        vctExpertFeeBreakDownROWS = vctExpertFeeBreakDownROWS0;
    }
    
    public String getExpertCount()
    {
        return this.strExpertCount;
    }
    public void setExpertCount(String strExpertCount0)
    {
        this.strExpertCount = strExpertCount0;
    }
    
    public String getExpertCountAttribute()
    {
        return this.strExpertCountAttribute;
    }
    
    public String getExpertScreenMode()
    {
        return this.strExpertScreenMode;
    }
    
    public String getEXP_PTD_ATT()
    {
        return this.strEXP_PTD_ATTR;
    }
    
    public String getFEE_PTD_ATT()
    {
        return this.strFEE_PTD_ATTR;
    }


    public class ExpertFeeBreakDownDetail
    {

        private String strExpertCode;

        private String strExpertType;

        private String strExpertRef;

        private String strExpertSCM;

        private String strExpertName;

        private String strExpertCNTCT;

        private String strExpertPTDExp;

        private String strExpertPTDFee;

        private String strExpertPTTExp;

        private String strExpertPTTFee;

        private String strExpertOSExp;

        private String strExpertOSFee;

        /*Flag*/
        private String strExpertCodeFlag;

        private boolean blnExpertTypeFlag;

        private String strExpertRefFlag;

        private String strExpertSCMFlag;

        private boolean blnExpertNameFlag;

        private String strExpertCNTCTFlag;

        private String strExpertPTDExpFlag;

        private String strExpertPTDFeeFlag;

        private String strExpertPTTExpFlag;

        private String strExpertPTTFeeFlag;

        private String strExpertOSExpFlag;

        private String strExpertOSFeeFlag;

        private String strExpertDeleteFlag;

        public ExpertFeeBreakDownDetail(String strExpertCode0, String strExpertType0, String strExpertRef0, String strExpertSCM0, String strExpertName0, String strExpertCNTCT0,
                String strExpertPTDExp0, String strExpertPTDFee0, String strExpertPTTExp0, String strExpertPTTFee0, String strExpertOSExp0, String strExpertOSFee0)
        {
            this.strExpertCode = strExpertCode0;
            this.strExpertType = strExpertType0;
            this.strExpertRef = strExpertRef0;
            this.strExpertSCM = strExpertSCM0;
            this.strExpertName = strExpertName0;
            this.strExpertCNTCT = strExpertCNTCT0;
            this.strExpertPTDExp = strExpertPTDExp0;
            this.strExpertPTDFee = strExpertPTDFee0;
            this.strExpertPTTExp = strExpertPTTExp0;
            this.strExpertPTTFee = strExpertPTTFee0;
            this.strExpertOSExp = strExpertOSExp0;
            this.strExpertOSFee = strExpertOSFee0;
        }

        public void updateValues(String strExpertCode0, String strExpertType0, String strExpertRef0, String strExpertSCM0, String strExpertName0, String strExpertCNTCT0,
                String strExpertPTDExp0, String strExpertPTDFee0, String strExpertPTTExp0, String strExpertPTTFee0, String strExpertOSExp0, String strExpertOSFee0)
        {
            this.strExpertCode = strExpertCode0;
            this.strExpertType = strExpertType0;
            this.strExpertRef = strExpertRef0;
            this.strExpertSCM = strExpertSCM0;
            this.strExpertName = strExpertName0;
            this.strExpertCNTCT = strExpertCNTCT0;
            this.strExpertPTDExp = strExpertPTDExp0;
            this.strExpertPTDFee = strExpertPTDFee0;
            this.strExpertPTTExp = strExpertPTTExp0;
            this.strExpertPTTFee = strExpertPTTFee0;
            this.strExpertOSExp = strExpertOSExp0;
            this.strExpertOSFee = strExpertOSFee0;
        }

        public void addFlags(String strExpertCodeFlag0, boolean blnExpertTypeFlag0, String strExpertRefFlag0, String strExpertSCMFlag0, boolean blnExpertNameFlag0, String strExpertCNTCTFlag0,
                String strExpertPTDExpFlag0, String strExpertPTDFeeFlag0, String strExpertPTTExpFlag0, String strExpertPTTFeeFlag0, String strExpertOSExpFlag0, String strExpertOSFeeFlag0,
                String strExpertDeleteFlag0)
        {
            this.strExpertCodeFlag = strExpertCodeFlag0;
            this.blnExpertTypeFlag = blnExpertTypeFlag0;
            this.strExpertRefFlag = strExpertRefFlag0;
            this.strExpertSCMFlag = strExpertSCMFlag0;
            this.blnExpertNameFlag = blnExpertNameFlag0;
            this.strExpertCNTCTFlag = strExpertCNTCTFlag0;
            this.strExpertPTDExpFlag = strExpertPTDExpFlag0;
            this.strExpertPTDFeeFlag = strExpertPTDFeeFlag0;
            this.strExpertPTTExpFlag = strExpertPTTExpFlag0;
            this.strExpertPTTFeeFlag = strExpertPTTFeeFlag0;
            this.strExpertOSExpFlag = strExpertOSExpFlag0;
            this.strExpertOSFeeFlag = strExpertOSFeeFlag0;
            this.strExpertDeleteFlag = strExpertDeleteFlag0;

        }

        public String getStrExpertCode()
        {
            return this.strExpertCode;
        }

        public String getStrExpertType()
        {
            return this.strExpertType;
        }

        public String getStrExpertRef()
        {
            return this.strExpertRef;
        }

        public String getStrExpertSCM()
        {
            return this.strExpertSCM;
        }

        public String getStrExpertName()
        {
            return this.strExpertName;
        }

        public String getStrExpertCNTCT()
        {
            return this.strExpertCNTCT;
        }

        public String getStrExpertPTDExp()
        {
            return this.strExpertPTDExp;
        }

        public String getStrExpertPTDFee()
        {
            return this.strExpertPTDFee;
        }

        public String getStrExpertPTTExp()
        {
            return this.strExpertPTTExp;
        }

        public String getStrExpertPTTFee()
        {
            return this.strExpertPTTFee;
        }

        public String getStrExpertOSExp()
        {
            return this.strExpertOSExp;
        }

        public String getStrExpertOSFee()
        {
            return this.strExpertOSFee;
        }

        /*Flags*/
        public String getStrExpertCodeFlag()
        {
            return this.strExpertCodeFlag;
        }

        public boolean getBlnExpertTypeFlag()
        {
            return this.blnExpertTypeFlag;
        }

        public String getStrExpertRefFlag()
        {
            return this.strExpertRefFlag;
        }

        public String getStrExpertSCMFlag()
        {
            return this.strExpertSCMFlag;
        }

        public boolean getBlnExpertNameFlag()
        {
            return this.blnExpertNameFlag;
        }

        public String getStrExpertCNTCTFlag()
        {
            return this.strExpertCNTCTFlag;
        }

        public String getStrExpertPTDExpFlag()
        {
            return this.strExpertPTDExpFlag;
        }

        public String getStrExpertPTDFeeFlag()
        {
            return this.strExpertPTDFeeFlag;
        }

        public String getStrExpertPTTExpFlag()
        {
            return this.strExpertPTTExpFlag;
        }

        public String getStrExpertPTTFeeFlag()
        {
            return this.strExpertPTTFeeFlag;
        }

        public String getStrExpertOSExpFlag()
        {
            return this.strExpertOSExpFlag;
        }

        public String getStrExpertOSFeeFlag()
        {
            return this.strExpertOSFeeFlag;
        }
        
        public String getStrExpertDeleteFlag()
        {
            return this.strExpertDeleteFlag;
        }

    }
}
