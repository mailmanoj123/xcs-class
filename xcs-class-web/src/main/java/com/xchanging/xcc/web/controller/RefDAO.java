package com.xchanging.xcc.web.controller;

import java.util.Vector;

import javax.servlet.ServletContext;

import com.xchanging.xcc.refdata.RefDataHandler;
import com.xchanging.xcc.refdata.TableRow;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.reference.AccountList;
import com.xchanging.xcc.web.models.reference.AdjSurvCodeList;
import com.xchanging.xcc.web.models.reference.BasisOfLimitList;
import com.xchanging.xcc.web.models.reference.BinderClaimTypeList;
import com.xchanging.xcc.web.models.reference.BrokerList;
import com.xchanging.xcc.web.models.reference.BrokerTrQualList;
import com.xchanging.xcc.web.models.reference.CatCodeList;
import com.xchanging.xcc.web.models.reference.CauseCodeList;
import com.xchanging.xcc.web.models.reference.ChargeTypeList;
import com.xchanging.xcc.web.models.reference.ClmRefRecList;
import com.xchanging.xcc.web.models.reference.CountryCodeList;
import com.xchanging.xcc.web.models.reference.CoverLineslipQualList;
import com.xchanging.xcc.web.models.reference.CurrencyCodeList;
import com.xchanging.xcc.web.models.reference.DCMQualList;
import com.xchanging.xcc.web.models.reference.DOLQualList;
import com.xchanging.xcc.web.models.reference.DTICodeList;
import com.xchanging.xcc.web.models.reference.EcfClassList;
import com.xchanging.xcc.web.models.reference.ExpertCodeList;
import com.xchanging.xcc.web.models.reference.ExpertTypeList;
import com.xchanging.xcc.web.models.reference.FILCodeList;
import com.xchanging.xcc.web.models.reference.FinderCodeList;
import com.xchanging.xcc.web.models.reference.GUIErrorList;
import com.xchanging.xcc.web.models.reference.LawyerCodeList;
import com.xchanging.xcc.web.models.reference.MarketList;
import com.xchanging.xcc.web.models.reference.NaicCodeList;
import com.xchanging.xcc.web.models.reference.NaicQualList;
import com.xchanging.xcc.web.models.reference.NarrativeList;
import com.xchanging.xcc.web.models.reference.OsAmountQualList;
import com.xchanging.xcc.web.models.reference.OsFeeQualList;
import com.xchanging.xcc.web.models.reference.OsLossQualList;
import com.xchanging.xcc.web.models.reference.OsTotalQualList;
import com.xchanging.xcc.web.models.reference.PCSCodeList;
import com.xchanging.xcc.web.models.reference.PaidByChequeList;
import com.xchanging.xcc.web.models.reference.PeerReviewList;
import com.xchanging.xcc.web.models.reference.PolCertQualList;
import com.xchanging.xcc.web.models.reference.RiskCodeList;
import com.xchanging.xcc.web.models.reference.RiskTypeList;
import com.xchanging.xcc.web.models.reference.SchemeCodeList;
import com.xchanging.xcc.web.models.reference.SectionList;
import com.xchanging.xcc.web.models.reference.ServiceTypeList;
import com.xchanging.xcc.web.models.reference.SettAdvList;
import com.xchanging.xcc.web.models.reference.SlipTypeList;
import com.xchanging.xcc.web.models.reference.StateCodeList;
import com.xchanging.xcc.web.models.reference.SyndicateList;
import com.xchanging.xcc.web.models.reference.TrustFundList;
import com.xchanging.xcc.web.models.reference.VATRateList;

public class RefDAO {

	ServletContext context;
	RefDataHandler refData;

	public RefDAO(ServletContext context) {
		this.context = context;

		refData = new RefDataHandler();
		loadTables();
	}

	public void loadTables() {

		// CSV Ref Data
		loadCatCodeTable();
		loadPCSCodeTable();
		loadStateCodeTable();
		loadTrustFundTable();
		loadExpertCodeTable();
		loadAdjusterAndLawyerCodeTable();
		loadFinderCodeTable();
		loadCurrencyCodeTable();
		loadBrokerCodeTable();
		loadSectionCodeTable();
		loadCountryCodeTable();
		loadDTICodeTable();
		loadFILCodeTable();
		loadNarrativeTable();
		loadVATRateTable();
		// loadRiskCodeTable(); Don't know what this is supposed to be used for. Where did it come from?
		loadSyndicateTable();
		loadNaicCodeTable();
		loadErrorListTable();

		// Hard Coded Data
		loadAccountTable();
		loadDolQualTable();
		loadDcmQualTable();
		loadRiskTypeTable();

		loadMarketCodeTable();

		loadSettAdvTable();
		loadChargeTypeTable();
		loadBasisOfLimitTable();
		loadClmRefRecTable();
		loadCoverLineslipQualTable();
		loadNaicQualTable();
		loadOsFeeQualTable();
		loadOsLossQualTable();
		loadOsTotalQualTable();
		loadBrokerTrQualTable(); // ECF Phase 6 change
		loadPolCertQualTable();
		loadOsAmountQualTable();
		loadSchemeCodeTable();
		loadSectionCodeTable();
		loadPeerReviewTable();
		loadPaidByChequeTable();

		loadCauseCodeTable();
		loadEcfClassTable();
		loadSlipTypeTable();
		loadServiceTypeTable();
		loadBinderClaimTypeTable();
	}

	private void loadCauseCodeTable() {
		CauseCodeList list = new CauseCodeList();

		list.createCauseCode("", "");

		Vector results = refData.readTable(Keys.CauseCodeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createCauseCode(((TableRow) results.get(i)).getColumn(0), ((TableRow) results.get(i)).getColumn(1));
		}

		context.setAttribute(Keys.RefCauseCodeList, list);
	}

	/**
	 * Reference Data loads
	 */
	private void loadCatCodeTable() {

		CatCodeList list = new CatCodeList();

		list.createCatCode("", "");

		Vector results = refData.readTable(Keys.CatCodeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createCatCode(((TableRow) results.get(i)).getColumn(0), ((TableRow) results.get(i)).getColumn(3));
		}

		context.setAttribute(Keys.RefCatCodeList, list);
	}

	private void loadPCSCodeTable() {

		PCSCodeList list = new PCSCodeList();

		list.createPCSCode("");

		Vector results = refData.readTable(Keys.PCSCodeTable);

		for (int i = 0; i < results.size(); i++) {
			String v1 = (((TableRow) results.get(i)).getColumn(0));
			if (!v1.trim().equals("")) {
				list.createPCSCode(v1);
			}
		}

		context.setAttribute(Keys.RefPCSCodeList, list);
	}

	private void loadStateCodeTable() {

		StateCodeList list = new StateCodeList();

		list.createStateCode("");

		Vector results = refData.readTable(Keys.StateCodeTable);

		for (int i = 0; i < results.size(); i++) {
			String v1 = (((TableRow) results.get(i)).getColumn(0));
			if (!v1.trim().equals("")) {
				list.createStateCode(v1);
			}
		}

		list.sort();

		context.setAttribute(Keys.RefStateCodeList, list);
	}

	private void loadTrustFundTable() {

		TrustFundList list = new TrustFundList();

		list.createTrustFund("");

		Vector results = refData.readTable(Keys.TrustFundTable);

		for (int i = 0; i < results.size(); i++) {
			String v1 = (((TableRow) results.get(i)).getColumn(0));
			if (!v1.trim().equals("")) {
				list.createTrustFund(v1);
			}
		}

		list.sort();
		context.setAttribute(Keys.RefTrustFundList, list);
	}

	private void loadAdjusterAndLawyerCodeTable() {

		AdjSurvCodeList adjSurvList = new AdjSurvCodeList();
		LawyerCodeList lawyerList = new LawyerCodeList();

		adjSurvList.createAdjSurvCode("", "", "", "");
		lawyerList.createLawyerCode("", "", "", "");

		Vector results = refData.readTable(Keys.ExpertCodeTable);

		String type = "";
		String code = "";
		String sname = "";
		String name = "";

		TableRow tr;

		for (int i = 0; i < results.size(); i++) {
			tr = (TableRow) results.get(i);
			type = tr.getColumn(0);
			code = tr.getColumn(1);
			sname = tr.getColumn(2);
			name = tr.getColumn(3);

			if (type.equals("A"))
				adjSurvList.createAdjSurvCode(type, code, sname, name);
			if (type.equals("L"))
				lawyerList.createLawyerCode(type, code, sname, name);

		}

		/*
		 * String type = ""; String code = ""; String sname = ""; StringBuffer name; TableRow tr; int cols; for (int
		 * i=0; i<results.size(); i++) { tr = (TableRow) results.get(i); cols = tr.size(); type = tr.getColumn(0); code
		 * = tr.getColumn(1); sname = tr.getColumn(2); // clintonj SIR 37546 // Fields from 3 to the end of the line are
		 * concat together. name = new StringBuffer(); for(int j=3; j<cols; j++) { name.append(tr.getColumn(j)+", "); }
		 * int end=0; if (name.toString().lastIndexOf(",") != -1) { end = name.toString().lastIndexOf(","); } else { end
		 * = name.toString().length(); } if (type.equals("A"))
		 * adjSurvList.createAdjSurvCode(type,code,sname,name.substring(0,end).toString()); if (type.equals("L"))
		 * lawyerList.createLawyerCode(type,code,sname,name.substring(0,end).toString()); name = null; }
		 */

		adjSurvList.sort();
		lawyerList.sort();

		context.setAttribute(Keys.RefAdjSurvCodeList, adjSurvList);

		context.setAttribute(Keys.RefLawyerCodeList, lawyerList);
	}

	private void loadExpertCodeTable() {
		ExpertCodeList expertCodeList = new ExpertCodeList();
		expertCodeList.createExpertCode("", "", "", "");

		Vector results = refData.readTable(Keys.ExpertCodeTable);

		String type = "";
		String code = "";
		String sname = "";
		String name = "";

		TableRow tr;

		for (int i = 0; i < results.size(); i++) {
			tr = (TableRow) results.get(i);
			type = tr.getColumn(0);
			code = tr.getColumn(1);
			sname = tr.getColumn(2);
			name = tr.getColumn(3);

			expertCodeList.createExpertCode(type, code, sname, name);
		}

		expertCodeList.sort();

		context.setAttribute(Keys.RefExpertCodeList, expertCodeList);

		ExpertTypeList list = new ExpertTypeList();
		list.createExpertType("", "");
		list.createExpertType("A", "ADJUSTER");
		list.createExpertType("L", "LAWYER");

		context.setAttribute(Keys.RefExpertTypeList, list);

	}

	private void loadFinderCodeTable() {

		FinderCodeList list = new FinderCodeList();

		list.createFinderCode("");

		Vector results = refData.readTable(Keys.FinderCodeTable);

		for (int i = 0; i < results.size(); i++) {
			String v1 = (((TableRow) results.get(i)).getColumn(1));
			if (!v1.trim().equals("")) {
				list.createFinderCode(v1);
			}
		}

		list.sort();

		context.setAttribute(Keys.RefFinderCodeList, list);
	}

	private void loadCurrencyCodeTable() {

		CurrencyCodeList fullList = new CurrencyCodeList();
		CurrencyCodeList settList = new CurrencyCodeList();

		fullList.createCurrencyCode("", "");
		settList.createCurrencyCode("", "");

		Vector results = refData.readTable(Keys.CurrencyCodeTable);

		for (int i = 0; i < results.size(); i++) {
			TableRow tr = ((TableRow) results.get(i));

			String code = (tr.getColumn(0));
			String desc = (tr.getColumn(1));
			String settInd = (tr.getColumn(2));

			if (!code.trim().equals("")) {
				String fullDesc = code + " - " + desc;
				fullList.createCurrencyCode(code, fullDesc);
				if (settInd.toUpperCase().equals("Y")) {
					settList.createCurrencyCode(code, fullDesc);
				}
			}
		}

		fullList.sort();
		settList.sort();
		context.setAttribute(Keys.RefCurrencyCodeList, fullList);
		context.setAttribute(Keys.RefSettCurrencyCodeList, settList);
	}

	private void loadSlipTypeTable() {

		SlipTypeList slipTypeList = new SlipTypeList();
		slipTypeList.createSlipTypeList("");
		slipTypeList.createSlipTypeList("M");
		slipTypeList.createSlipTypeList("C");
		slipTypeList.createSlipTypeList("E");
		slipTypeList.createSlipTypeList("X");
		slipTypeList.createSlipTypeList("B");
		slipTypeList.createSlipTypeList("F");
		slipTypeList.createSlipTypeList("T");
		slipTypeList.createSlipTypeList("Y");
		slipTypeList.createSlipTypeList("L");

		// slipTypeList.sort();
		context.setAttribute(Keys.RefSlipTypeList, slipTypeList);
	}

	private void loadBrokerCodeTable() {

		BrokerList list = new BrokerList();

		list.createBroker("", "");

		Vector results = refData.readTable(Keys.BrokerCodeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createBroker(((TableRow) results.get(i)).getColumn(0), ((TableRow) results.get(i)).getColumn(1));
		}

		list.sort();
		context.setAttribute(Keys.RefBrokerCodeList, list);
	}

	private void loadCountryCodeTable() {

		CountryCodeList list = new CountryCodeList();

		list.createCountryCode("", "");

		Vector results = refData.readTable(Keys.CountryCodeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createCountryCode(((TableRow) results.get(i)).getColumn(7), ((TableRow) results.get(i)).getColumn(1));
		}

		list.sort();

		context.setAttribute(Keys.RefCountryCodeList, list);
	}

	private void loadDTICodeTable() {

		DTICodeList list = new DTICodeList();

		list.createDTICode("");

		Vector results = refData.readTable(Keys.DTICodeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createDTICode(((TableRow) results.get(i)).getColumn(0));
		}

		list.sort();
		context.setAttribute(Keys.RefDTICodeList, list);
	}

	private void loadFILCodeTable() {

		FILCodeList list = new FILCodeList();

		list.createFILCode("", "");

		Vector results = refData.readTable(Keys.FILCodeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createFILCode(((TableRow) results.get(i)).getColumn(0), ((TableRow) results.get(i)).getColumn(2));
		}

		list.sort();
		context.setAttribute(Keys.RefFILCodeList, list);
	}

	private void loadNarrativeTable() {

		NarrativeList list = new NarrativeList();

		list.createNarrative("", "");

		Vector results = refData.readTable(Keys.NarrativeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createNarrative(((TableRow) results.get(i)).getColumn(0), ((TableRow) results.get(i)).getColumn(1));
		}

		list.sort();

		context.setAttribute(Keys.RefNarrativeList, list);
	}

	private void loadVATRateTable() {

		VATRateList list = new VATRateList();

		list.createVATRate("");

		Vector results = refData.readTable(Keys.VATRateTable);

		for (int i = 0; i < results.size(); i++) {
			list.createVATRate(((TableRow) results.get(i)).getColumn(0));
		}

		context.setAttribute(Keys.RefVATRateList, list);
	}

	private void loadRiskCodeTable() {

		RiskCodeList list = new RiskCodeList();

		list.createRiskCode("");

		Vector results = refData.readTable(Keys.RiskCodeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createRiskCode(((TableRow) results.get(i)).getColumn(0));
		}

		context.setAttribute(Keys.RefVATRateList, list);
	}

	private void loadSyndicateTable() {

		SyndicateList list = new SyndicateList();

		list.createNo("");

		Vector results = refData.readTable(Keys.SyndicateTable);

		for (int i = 0; i < results.size(); i++) {
			list.createNo(((TableRow) results.get(i)).getColumn(0));
		}

		context.setAttribute(Keys.RefSyndicateList, list);
	}

	private void loadMarketCodeTable() {
		MarketList list = new MarketList();
		list.createMarket("", "");
		list.createMarket("A", "Aviation");
		list.createMarket("M", "Marine");
		list.createMarket("N", "Non-Marine");

		context.setAttribute(Keys.RefMarketList, list);
	}

	private void loadSectionCodeTable() {

		SectionList list = new SectionList();

		list.createSection("");

		Vector results = refData.readTable(Keys.SectionCodeTable);

		for (int i = 0; i < results.size(); i++) {
			list.createSection(((TableRow) results.get(i)).getColumn(0));
		}

		list.sort();
		context.setAttribute(Keys.RefSectionList, list);
	}

	private void loadNaicCodeTable() {

		NaicCodeList list = new NaicCodeList();

		list.createCompanyCode("", "", "", "");
		list.createPoolCode("", "");
		list.createGroupCode("", "");

		Vector results = refData.readTable(Keys.NaicCodeTable);
		for (int i = 0; i < results.size(); i++) {
			String v1 = (((TableRow) results.get(i)).getColumn(0));
			String v2 = (((TableRow) results.get(i)).getColumn(10));
			String v3 = (((TableRow) results.get(i)).getColumn(1));
			String v4 = (((TableRow) results.get(i)).getColumn(2));
			if (!v1.trim().equals("") || !v2.trim().equals("")) {
				list.createCompanyCode(v1, v2, v3, v4);
			}
		}

		results = refData.readTable(Keys.PoolCodeTable);
		for (int i = 0; i < results.size(); i++) {
			String v1 = (((TableRow) results.get(i)).getColumn(0));
			String v2 = (((TableRow) results.get(i)).getColumn(1));
			if (!v1.trim().equals("")) {
				list.createPoolCode(v1, v2);
			}
		}

		results = refData.readTable(Keys.GroupCodeTable);
		for (int i = 0; i < results.size(); i++) {
			String v1 = (((TableRow) results.get(i)).getColumn(0));
			String v2 = (((TableRow) results.get(i)).getColumn(1));
			if (!v1.trim().equals("")) {
				list.createGroupCode(v1, v2);
			}
		}

		list.sort();
		context.setAttribute(Keys.RefNAICCodeList, list);
	}

	public void loadErrorListTable() {

		GUIErrorList errorList = new GUIErrorList();

		Vector results = refData.readTable(Keys.GUIErrorTable);

		for (int i = 0; i < results.size(); i++) {
			errorList.createGUIError(((TableRow) results.get(i)).getColumn(0),
					((TableRow) results.get(i)).getColumn(1));
		}

		context.setAttribute(Keys.RefGUIErrorList, errorList);
	}

	private void loadAccountTable() {

		AccountList list = new AccountList();
		list.createAccount("XCHU");
		list.createAccount("XCHE");

		context.setAttribute(Keys.RefAccountList, list);
	}

	private void loadDolQualTable() {
		DOLQualList list = new DOLQualList();

		list.createDOLQual("", "");
		list.createDOLQual("N", "Not Applicable");
		list.createDOLQual("T", "To Be Advised");
		list.createDOLQual("V", "Various");

		context.setAttribute(Keys.RefDOLQualList, list);
	}

	private void loadDcmQualTable() {
		DCMQualList list = new DCMQualList();
		list.createDCMQual("", "");
		list.createDCMQual("N", "Not Applicable");
		list.createDCMQual("T", "To Be Advised");
		list.createDCMQual("V", "Various");

		context.setAttribute(Keys.RefDCMQualList, list);
	}

	private void loadRiskTypeTable() {
		RiskTypeList list = new RiskTypeList();

		list.createRiskType("");
		list.createRiskType("CGO");
		list.createRiskType("CPA");
		list.createRiskType("CXL");
		list.createRiskType("ERI");
		list.createRiskType("G/A");
		list.createRiskType("HLL");
		list.createRiskType("HRI");
		list.createRiskType("LBY");
		list.createRiskType("LOE");
		list.createRiskType("LOH");
		list.createRiskType("MII");
		list.createRiskType("OIL");
		list.createRiskType("R/I");
		list.createRiskType("SXL");
		list.createRiskType("TTY");
		list.createRiskType("X/L");

		context.setAttribute(Keys.RefRiskTypeList, list);
	}

	private void loadSettAdvTable() {
		SettAdvList list = new SettAdvList();
		list.createSettAdv("A", "Advice");
		list.createSettAdv("S", "Settlement");

		context.setAttribute(Keys.RefSettAdvList, list);
	}

	private void loadChargeTypeTable() {
		ChargeTypeList list = new ChargeTypeList();
		list.createChargeType("", "");
		list.createChargeType("CH", "Claims Handling");
		list.createChargeType("CP", "Settlement of Claims Payable Abroad");
		list.createChargeType("EP", "ECR Purge");
		list.createChargeType("ER", "ECR Reserve Validation");
		list.createChargeType("EU", "ECR Update");

		context.setAttribute(Keys.RefChargeTypeList, list);
	}

	private void loadServiceTypeTable() {
		ServiceTypeList list = new ServiceTypeList();
		list.createServiceType("", "");
		list.createServiceType("C", "Complex");
		list.createServiceType("S", "Standard");
		list.createServiceType("A", "Technical Accounting");
		list.createServiceType("P", "Standard TP");
		list.createServiceType("T", "Threshold TP");

		context.setAttribute(Keys.RefServiceTypeList, list);
	}

	private void loadBasisOfLimitTable() {
		BasisOfLimitList list = new BasisOfLimitList();
		list.createBasisOfLimit("", "");
		list.createBasisOfLimit("AAO", "ANY ONE ACCIDENT OR OCCURRENCE");
		list.createBasisOfLimit("AAP", "ANY ONE AIRCRAFT");
		list.createBasisOfLimit("ABL", "ANY ONE CERT/BILL OF TRADING");
		list.createBasisOfLimit("ACA", "ANY ONE CLAIM AND IN ALL");
		list.createBasisOfLimit("ACC", "EACH AND EVERY ACCEPTANCE");
		list.createBasisOfLimit("ACL", "AGG WITH 2 ROUND CLOCK REINST");
		list.createBasisOfLimit("ACM", "ANY ONE CREW MEMBER");
		list.createBasisOfLimit("ACP", "ANY ONE ACCEPTANCE");
		list.createBasisOfLimit("ACR", "AGG WITH 1 ROUND CLOCK REINST");
		list.createBasisOfLimit("ACT", "ANY ONE AIRCRAFT");
		list.createBasisOfLimit("ACV", "ANY ONE COMBINED VEHICLE");
		list.createBasisOfLimit("ADR", "IN AGG WITH ONE DIRECT REINST");
		list.createBasisOfLimit("AFE", "IN AGG FOLLOWED BY EACH/EVERY");
		list.createBasisOfLimit("AGG", "IN AGGREGATE");
		list.createBasisOfLimit("AHO", "ANY ONE HOLE");
		list.createBasisOfLimit("AIE", "INC AUTO INVEST & EVENTUELLE");
		list.createBasisOfLimit("ALA", "ANY ONE LOC ANY ONE ASSURED");
		list.createBasisOfLimit("ALC", "ANY 1 LOSS ANY 1 CONVEYANCE");
		list.createBasisOfLimit("ALE", "ANY ONE LOSS/SERIES OF LOSSES");
		list.createBasisOfLimit("ALI", "ANY ONE LIFE");
		list.createBasisOfLimit("ALL", "IN ALL");
		list.createBasisOfLimit("ALN", "ANY ONE LOSS ANY ONE LOCATION");
		list.createBasisOfLimit("ANL", "ANY ONE ANIMAL");
		list.createBasisOfLimit("AOA", "ANY ONE ACCIDENT OR OCCURRENCE");
		list.createBasisOfLimit("AOB", "ANY ONE BOTTOM");
		list.createBasisOfLimit("AOC", "ANY ONE CLAIM");
		list.createBasisOfLimit("AOD", "ANY ONE DECLARATION");
		list.createBasisOfLimit("AOE", "ANY ONE EVENT");
		list.createBasisOfLimit("AOF", "ANY ONE FIRE");
		list.createBasisOfLimit("AOG", "ANY ONE GROUNDING");
		list.createBasisOfLimit("AOH", "ANY ONE HULL");
		list.createBasisOfLimit("AOI", "ANY ONE INTEREST");
		list.createBasisOfLimit("AOL", "ANY ONE LOSS");
		list.createBasisOfLimit("AOM", "ANY ONE MEMBER");
		list.createBasisOfLimit("AOP", "ANY 1 PERSON PASSENGER PATIENT");
		list.createBasisOfLimit("AOR", "ANY ONE RISK");
		list.createBasisOfLimit("AOS", "ANY ONE SENDING");
		list.createBasisOfLimit("AOT", "ANY ONE TIME");
		list.createBasisOfLimit("AOU", "ANY ONE UNIT");
		list.createBasisOfLimit("AOV", "ANY ONE VEHICLE");
		list.createBasisOfLimit("ARR", "IN AGG WITH 2 DIRECT REINST");
		list.createBasisOfLimit("ASD", "ANY ONE ASSURED");
		list.createBasisOfLimit("ASH", "ANY ONE SHOW");
		list.createBasisOfLimit("ASO", "AS ORIGINAL");
		list.createBasisOfLimit("ASR", "ANY ONE STRUCTURE");
		list.createBasisOfLimit("AST", "ANY ONE SATELLITE");
		list.createBasisOfLimit("ATK", "ANY ONE TRUCK");
		list.createBasisOfLimit("AUR", "IN AGG WITH UNLIMITED REINST");
		list.createBasisOfLimit("AVA", "ANY ONE VESSEL ANY ONE ASSURED");
		list.createBasisOfLimit("AWP", "AGGREGATE OVER WHOLE POLICY");
		list.createBasisOfLimit("AYD", "ANY ONE YARD");
		list.createBasisOfLimit("AYR", "ANY ONE YEAR");
		list.createBasisOfLimit("BGE", "ANY ONE BARGE");
		list.createBasisOfLimit("BLG", "ANY ONE BUILDING");
		list.createBasisOfLimit("CAT", "ANY ONE CATASTROPHE");
		list.createBasisOfLimit("CGO", "ANY ONE CARGO");
		list.createBasisOfLimit("CLI", "CONTRACTUAL LIMIT OF INDEMNITY");
		list.createBasisOfLimit("CLL", "COMBINED SINGLE LMT ANY 1 LOSS");
		list.createBasisOfLimit("CON", "ANY ONE CONTRACT");
		list.createBasisOfLimit("COV", "ANY ONE CONVEYANCE");
		list.createBasisOfLimit("CSL", "COMBINED SINGLE LIMIT");
		list.createBasisOfLimit("CTR", "ANY ONE CONTAINER");
		list.createBasisOfLimit("CTY", "ANY ONE COUNTRY");
		list.createBasisOfLimit("DAY", "PER DAY");
		list.createBasisOfLimit("DSI", "DAILY SUM INSURED");
		list.createBasisOfLimit("EAC", "EACH AND EVERY AIRCRAFT");
		list.createBasisOfLimit("EAG", "EACH/EVERY CLAIM WITH AGG CAP");
		list.createBasisOfLimit("EAR", "EACH/EVERY CLM AGG CAP/RESID");
		list.createBasisOfLimit("ECL", "EACH CLAIM");
		list.createBasisOfLimit("ECT", "EACH AND EVERY CLAIMANT");
		list.createBasisOfLimit("EDO", "EACH DIRECTOR/OFFICER");
		list.createBasisOfLimit("EEA", "EACH AND EVERY ACCIDENT");
		list.createBasisOfLimit("EEC", "EACH AND EVERY CLAIM");
		list.createBasisOfLimit("EEE", "EACH & EVERY LOSS, EACH LOC");
		list.createBasisOfLimit("EEI", "EACH AND EVERY INTEREST");
		list.createBasisOfLimit("EEL", "EACH AND EVERY LOSS");
		list.createBasisOfLimit("EEO", "EACH AND EVERY OCCURENCE");
		list.createBasisOfLimit("EER", "EACH AND EVERY RISK");
		list.createBasisOfLimit("EEV", "EACH AND EVERY EVENT");
		list.createBasisOfLimit("EIN", "EACH INCIDENT");
		list.createBasisOfLimit("ELC", "EACH/EVERY LOSS XCEPT C CLAUSE");
		list.createBasisOfLimit("EOC", "EACH OCCURENCE");
		list.createBasisOfLimit("ERV", "EACH ROUND VOYAGE");
		list.createBasisOfLimit("ESE", "EACH/EVERY LOSS/SERIES/EVENT");
		list.createBasisOfLimit("EST", "ANY ONE ESTABLISHMENT");
		list.createBasisOfLimit("EVI", "EACH UNIT EACH INTEREST");
		list.createBasisOfLimit("EVV", "EACH SINGLE VOYAGE EACH VESSEL");
		list.createBasisOfLimit("EXN", "ANY ONE EXHIBITION");
		list.createBasisOfLimit("HSI", "HIGHEST SUM INSURED");
		list.createBasisOfLimit("ITM", "ANY ONE ITEM");
		list.createBasisOfLimit("LCH", "ANY ONE SATELLITE LAUNCH");
		list.createBasisOfLimit("LEL", "COMBINED SINGLE LMT, E&E  LOSS");
		list.createBasisOfLimit("LOC", "ANY ONE LOCATION");
		list.createBasisOfLimit("LOL", "LIMIT OF LOSS");
		list.createBasisOfLimit("LWA", "LOSSES WHEREVER ARISING");
		list.createBasisOfLimit("MAX", "MAXIMUM");
		list.createBasisOfLimit("MIN", "MINIMUM");
		list.createBasisOfLimit("MOP", "MAXIMUM ANY ONE PERSON");
		list.createBasisOfLimit("MTH", "PER MONTH");
		list.createBasisOfLimit("NSL", "TO PAY N% OF SALARY UP TO");
		list.createBasisOfLimit("NWW", "N% OF AVERAGE WEEKLY WAGE");
		list.createBasisOfLimit("NXS", "ANY AMOUNT X SALARY");
		list.createBasisOfLimit("OAC", "ANY ONE ACCOUNT");
		list.createBasisOfLimit("OCC", "ANY ONE OCCURENCE");
		list.createBasisOfLimit("OKA", "ANY ONE KNOWN ACCUMULATION");
		list.createBasisOfLimit("OPA", "ANY 1 PERSON,PAS,PAT ANY 1 ACC");
		list.createBasisOfLimit("OTH", "OTHER (ONLY IF NOTHING ELSE)");
		list.createBasisOfLimit("OTK", "ANY ONE TOOL KIT");
		list.createBasisOfLimit("OTR", "ANY ONE TRAILER");
		list.createBasisOfLimit("PCP", "PER COVERED PERSON");
		list.createBasisOfLimit("PER", "PER PERSON");
		list.createBasisOfLimit("PIE", "PER INSURED EVENT");
		list.createBasisOfLimit("PLA", "ANY ONE PLATFORM");
		list.createBasisOfLimit("PLL", "PRO RATA ON LESSER LIMITS/AMTS");
		list.createBasisOfLimit("POL", "ANY ONE POLICY");
		list.createBasisOfLimit("PPA", "PER PERSON PER ACC &OR ILLNESS");
		list.createBasisOfLimit("PPD", "PER PERSON PER DAY");
		list.createBasisOfLimit("PPF", "PER PERFORMANCE");
		list.createBasisOfLimit("PPW", "PER PERSON PER WEEK");
		list.createBasisOfLimit("PPY", "PER PERSON PER YEAR");
		list.createBasisOfLimit("PRM", "ANY ONE PREMISES");
		list.createBasisOfLimit("PTY", "ANY ONE PROPERTY");
		list.createBasisOfLimit("PWK", "PER WEEK");
		list.createBasisOfLimit("RET", "SELF INSURED RETENTION");
		list.createBasisOfLimit("SAL", "SEPARATE ADDITIONAL LIST");
		list.createBasisOfLimit("SCH", "ANY ONE SCHEDULE");
		list.createBasisOfLimit("SHP", "ANY ONE SHIPMENT");
		list.createBasisOfLimit("SIR", "SUM INSURED / REINSURED");
		list.createBasisOfLimit("STR", "ANY ONE STEAMER");
		list.createBasisOfLimit("SUB", "SUBLIMITED");
		list.createBasisOfLimit("TLO", "TOTAL LOSS ONLY");
		list.createBasisOfLimit("TOW", "ANY ONE TOW");
		list.createBasisOfLimit("TRA", "TRAVEL AND ACCOMODATION");
		list.createBasisOfLimit("ULD", "UNLIMITED");
		list.createBasisOfLimit("VOY", "ANY ONE VOYAGE");
		list.createBasisOfLimit("VSL", "ANY ONE VESSEL");
		list.createBasisOfLimit("WSV", "WHOLE SHIPMENT VALUE");
		list.createBasisOfLimit("WTY", "AS PER WARRANTY");
		list.createBasisOfLimit("001", "ANY ONE DEBTOR");
		list.createBasisOfLimit("002", "ROTORS IN MOTION");
		list.createBasisOfLimit("003", "ROTORS NOT IN MOTION");

		context.setAttribute(Keys.RefBasisOfLimitList, list);
	}

	private void loadClmRefRecTable() {
		ClmRefRecList list = new ClmRefRecList();
		list.createClmRefRec("");
		list.createClmRefRec("CLM");
		list.createClmRefRec("REF");
		list.createClmRefRec("REC");

		context.setAttribute(Keys.RefClmRefRecList, list);
	}

	private void loadCoverLineslipQualTable() {
		CoverLineslipQualList list = new CoverLineslipQualList();
		list.createCoverLineslipQual("");
		list.createCoverLineslipQual("C");
		list.createCoverLineslipQual("L");
		list.createCoverLineslipQual("P");
		list.createCoverLineslipQual("R");
		list.createCoverLineslipQual("T");
		list.createCoverLineslipQual("V");

		context.setAttribute(Keys.RefCoverLineslipQualList, list);
	}

	private void loadNaicQualTable() {
		NaicQualList list = new NaicQualList();
		list.createNaicQual("");
		list.createNaicQual("C");
		list.createNaicQual("F");
		list.createNaicQual("G");
		list.createNaicQual("P");

		context.setAttribute(Keys.RefNaicQualList, list);
	}

	private void loadOsFeeQualTable() {
		OsFeeQualList list = new OsFeeQualList();
		list.createOsFeeQual("");
		list.createOsFeeQual("N");

		context.setAttribute(Keys.RefOsFeeQualList, list);
	}

	private void loadOsLossQualTable() {
		OsLossQualList list = new OsLossQualList();
		list.createOsLossQual("");
		list.createOsLossQual("A");
		list.createOsLossQual("C");
		list.createOsLossQual("L");
		list.createOsLossQual("M");
		list.createOsLossQual("P");
		list.createOsLossQual("R");
		list.createOsLossQual("S");
		list.createOsLossQual("X");
		list.createOsLossQual("U");

		context.setAttribute(Keys.RefOsLossQualList, list);
	}

	// ECF Phase 6 - changes start
	private void loadBrokerTrQualTable() {
		BrokerTrQualList list = new BrokerTrQualList();
		list.createBrokerTrQual("", "");
		list.createBrokerTrQual("B", "Queried Broker advice");
		list.createBrokerTrQual("C", "Correction");
		list.createBrokerTrQual("D", "Direct advice or Settlement");
		list.createBrokerTrQual("F", "First advice with settlement");
		list.createBrokerTrQual("I", "Individual/Block claim");
		list.createBrokerTrQual("O", "Other");
		list.createBrokerTrQual("S", "Cash Loss");
		list.createBrokerTrQual("V", "Various");
		list.createBrokerTrQual("T", "Individual Binders");

		context.setAttribute(Keys.RefBrokerTrQualList, list);
	}

	private void loadBinderClaimTypeTable() {
		BinderClaimTypeList list = new BinderClaimTypeList();
		list.createBinderClaimType("No");
		list.createBinderClaimType("Individual");
		list.createBinderClaimType("Cash Loss");

		context.setAttribute(Keys.RefBinderClaimTypeList, list);
	}
	// ECF Phase 6 - changes end
	private void loadOsTotalQualTable() {
		OsTotalQualList list = new OsTotalQualList();
		list.createOsTotalQual("");
		list.createOsTotalQual("A");
		list.createOsTotalQual("C");
		list.createOsTotalQual("L");
		list.createOsTotalQual("M");
		list.createOsTotalQual("P");
		list.createOsTotalQual("R");
		list.createOsTotalQual("S");
		list.createOsTotalQual("X");
		list.createOsTotalQual("U");

		context.setAttribute(Keys.RefOsTotalQualList, list);
	}

	private void loadPolCertQualTable() {
		PolCertQualList list = new PolCertQualList();
		list.createPolCertQual("");
		list.createPolCertQual("N");
		list.createPolCertQual("T");
		list.createPolCertQual("V");

		context.setAttribute(Keys.RefPolCertQualList, list);
	}

	private void loadOsAmountQualTable() {
		OsAmountQualList list = new OsAmountQualList();
		list.createOsAmountQual("");
		list.createOsAmountQual("A");
		list.createOsAmountQual("C");
		list.createOsAmountQual("L");
		list.createOsAmountQual("M");
		list.createOsAmountQual("P");
		list.createOsAmountQual("R");
		list.createOsAmountQual("S");
		list.createOsAmountQual("X");

		context.setAttribute(Keys.OsAmountQualList, list);
	}

	private void loadSchemeCodeTable() {
		SchemeCodeList list = new SchemeCodeList();
		list.createSchemeCode("");
		list.createSchemeCode("LS");

		context.setAttribute(Keys.RefSchemeCodeList, list);
	}

	private void loadPeerReviewTable() {
		PeerReviewList list = new PeerReviewList();
		list.addPeerReview("");
		list.addPeerReview("D");
		list.addPeerReview("F");
		list.addPeerReview("N");
		list.addPeerReview("Y");

		context.setAttribute(Keys.RefPeerReviewList, list);
	}

	private void loadPaidByChequeTable() {
		PaidByChequeList list = new PaidByChequeList();
		list.createValue("");
		list.createValue("N");
		list.createValue("Y");

		context.setAttribute(Keys.RefPaidByChequeList, list);
	}

	private void loadEcfClassTable() {
		EcfClassList list = new EcfClassList();

		Vector results = refData.readTable(Keys.EcfClassTable);

		String code = "";
		String desc = "";

		TableRow tr;

		list.createEcfClass("", "");

		for (int i = 0; i < results.size(); i++) {
			tr = (TableRow) results.get(i);
			code = tr.getColumn(0);
			desc = tr.getColumn(1);

			list.createEcfClass(code, desc);

		}

		context.setAttribute(Keys.RefEcfClassList, list);
	}
}

/*
 * $Log: RefDAO.java,v $ Revision 1.7.12.1 2005/09/30 12:09:47 coganp fixed conflicts between different branches
 * Revision 1.7.10.1 2005/08/12 09:55:44 coganp changed the dropd downs of the qualifiers to the new spec Revision 1.7
 * 2004/04/02 14:05:52 clintonj Rolled back to orignal state. Revision 1.6 2004/04/02 09:25:10 clintonj SIR 37546 Added
 * fixed to ensure that comma are ignored as delimiters from column 3 onwards to ensure that the full name is populated.
 */