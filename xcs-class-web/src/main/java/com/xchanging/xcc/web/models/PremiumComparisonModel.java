package com.xchanging.xcc.web.models;

import java.util.Enumeration;
import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class PremiumComparisonModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;

  private String classRiskCode;
  private String premRiskCode;
  private String riskCodeHL;
  private String classYearOfAcc;
  private String premYearOfAcc;
  private String yearOfAccHL;
  private String[] osnds = new String[3];
  private Vector classValues;
  private Vector premiumValues;

  public PremiumComparisonModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.PremiumComparisonModelKey, this);
  }

  public void performUpdate() {
    MappedRecord results = (MappedRecord)session.getAttribute(Keys.CicsDataKey);

    osnds[0] = (String)results.get(Keys.LZ07_ORIG_REF_1);
    osnds[1] = (String)results.get(Keys.LZ07_ORIG_REF_2);
    osnds[2] = (String)results.get(Keys.LZ07_ORIG_REF_3);

    MappedRecord classData = (MappedRecord)((Vector)results.get(Keys.LZ07_CLASS_DATA)).get(0);
    classRiskCode = (String)classData.get(Keys.LZ07_RISK_CODE_C);
    riskCodeHL = (String)classData.get(Keys.LZ07_RISK_CODE_DIFF);
    classYearOfAcc = (String)classData.get(Keys.LZ07_YEAR_OF_ACC_C);
    yearOfAccHL = (String)classData.get(Keys.LZ07_YEAR_OF_ACC_DIFF);

    Vector classDetails = (Vector)classData.get(Keys.LZ07_CLASS_DETAILS);
    if (classDetails==null)
      classDetails = new Vector(0);

    classValues = new Vector(classDetails.size());
    for (int i=0; i<classDetails.size(); i++) {
      MappedRecord cd = (MappedRecord)classDetails.get(i);
      classValues.add(new Value((String)cd.get(Keys.LZ07_COR_C),
                                (String)cd.get(Keys.LZ07_CNTRY_CODE_C),
                                (String)cd.get(Keys.LZ07_CNTRY_CODE_DIFF),
                                (String)cd.get(Keys.LZ07_DTI_CODE_C),
                                (String)cd.get(Keys.LZ07_DTI_CODE_DIFF),
                                (String)cd.get(Keys.LZ07_FIL_CODE_1_C),
                                (String)cd.get(Keys.LZ07_FIL_CODE_1_DIFF),
                                (String)cd.get(Keys.LZ07_FIL_CODE_2_C),
                                (String)cd.get(Keys.LZ07_FIL_CODE_2_DIFF),
                                (String)cd.get(Keys.LZ07_ORIG_CURR_C),
                                (String)cd.get(Keys.LZ07_ORIG_CURR_DIFF),
                                (String)cd.get(Keys.LZ07_OTHER_TF_C),
                                (String)cd.get(Keys.LZ07_OTHER_TF_DIFF),
                                (String)cd.get(Keys.LZ07_TF_CODE_C),
                                (String)cd.get(Keys.LZ07_TF_CODE_DIFF)));
    }

    MappedRecord lidsData = (MappedRecord)((Vector)results.get(Keys.LZ07_LIDS_DATA)).get(0);
    premRiskCode = (String)lidsData.get(Keys.LZ07_RISK_CODE_L);
    premYearOfAcc = (String)lidsData.get(Keys.LZ07_YEAR_OF_ACC_L);

    Vector lidsDetails = (Vector)lidsData.get(Keys.LZ07_LIDS_DETAILS);
    if (lidsDetails==null)
      lidsDetails = new Vector(0);

    premiumValues = new Vector(lidsDetails.size());
    for (int i=0; i<lidsDetails.size(); i++) {
      MappedRecord ld = (MappedRecord)lidsDetails.get(i);
      premiumValues.add(new Value("",
                                  (String)ld.get(Keys.LZ07_CNTRY_CODE_L),"",
                                  (String)ld.get(Keys.LZ07_DTI_CODE_L),"",
                                  (String)ld.get(Keys.LZ07_FIL_CODE_1_L),"",
                                  (String)ld.get(Keys.LZ07_FIL_CODE_2_L),"",
                                  (String)ld.get(Keys.LZ07_ORIG_CURR_L),"",
                                  (String)ld.get(Keys.LZ07_OTHER_TF_L),"",
                                  (String)ld.get(Keys.LZ07_TF_CODE_L),""));
    }
  }

  public String getClassRiskCode() {
    return classRiskCode;
  }
  public String getClassYearOfAcc() {
    return classYearOfAcc;
  }
  public String getPremRiskCode() {
    return premRiskCode;
  }
  public String getPremYearOfAcc() {
    return premYearOfAcc;
  }
  public String getRiskCodeHL() {
    return getHighlight(riskCodeHL);
  }
  public String getYearOfAccHL() {
    return getHighlight(yearOfAccHL);
  }
  public String getOsnd(int i) {
    if ((i>osnds.length) || (osnds[i]==null))
      return "";
    else
      return osnds[i];
  }
  public Enumeration getClassValues() {
    if (classValues==null)
      return new Vector(0).elements();
    else
      return classValues.elements();
  }
  public Enumeration getPremiumValues() {
    if (premiumValues==null)
      return new Vector(0).elements();
    else
      return premiumValues.elements();
  }
  private String getHighlight(String hl) {
    if ((hl!=null) && (hl.equals("Y")))
      return "style=\"color:red\"";
    else
      return "";
  }

  public class Value {
    private String filCode1HL;
    private String filCode2HL;
    private String dtiCodeHL;
    private String tfCodeHL;
    private String otherTfCodeHL;
    private String origCcyHL;
    private String countryHL;
    private String cor;
    private String filCode1;
    private String filCode2;
    private String dtiCode;
    private String tfCode;
    private String otherTfCode;
    private String origCcy;
    private String country;

    public Value(String cor,
                 String country, String countryHL,
                 String dtiCode, String dtiCodeHL,
                 String filCode1, String filCode1HL,
                 String filCode2, String filCode2HL,
                 String origCcy, String origCcyHL,
                 String otherTfCode, String otherTfCodeHL,
                 String tfCode, String tfCodeHL) {

      this.cor = cor;
      this.country = country;
      this.countryHL = countryHL;
      this.dtiCode = dtiCode;
      this.dtiCodeHL = dtiCodeHL;
      this.filCode1 = filCode1;
      this.filCode1HL = filCode1HL;
      this.filCode2 = filCode2;
      this.filCode2HL = filCode2HL;
      this.origCcy = origCcy;
      this.origCcyHL = origCcyHL;
      this.otherTfCode = otherTfCode;
      this.otherTfCodeHL = otherTfCodeHL;
      this.tfCode = tfCode;
      this.tfCodeHL = tfCodeHL;
    }

    public String getCor() {
      return cor;
    }
    public String getCountry() {
      return country;
    }
    public String getCountryHL() {
      return getHighlight(countryHL);
    }
    public String getDtiCode() {
      return dtiCode;
    }
    public String getDtiCodeHL() {
      return getHighlight(dtiCodeHL);
    }
    public String getFilCode1() {
      return filCode1;
    }
    public String getFilCode1HL() {
      return getHighlight(filCode1HL);
    }
    public String getFilCode2() {
      return filCode2;
    }
    public String getFilCode2HL() {
      return getHighlight(filCode2HL);
    }
    public String getOrigCcy() {
      return origCcy;
    }
    public String getOrigCcyHL() {
      return getHighlight(origCcyHL);
    }
    public String getOtherTfCode() {
      return otherTfCode;
    }
    public String getOtherTfCodeHL() {
      return getHighlight(otherTfCodeHL);
    }
    public String getTfCode() {
      return tfCode;
    }
    public String getTfCodeHL() {
      return getHighlight(tfCodeHL);
    }
  }
}