package com.xchanging.xcc.utils;

// <moan tone="tidy minded, possibly obsessive">
//    Please try to keep the commareas in ascending order - it makes
//    checking to see if something is defined much easier.
// </moan>

public class Keys {

  private static String fileSeparator() {
    return System.getProperty("file.separator");
  }

  public static void setWebAppPath(String path) {
    webAppPath = path;
  }

  public static String getWebAppPath() {
    return webAppPath;
  }

  public static final boolean LOCAL_MODE                    = false;

  private static String webAppPath;

  public static final String TrasactionFlowKey              = "transactionFlow";
  public static final String ContinueFlagKey                = "continueFlag";
  public static final String CurrentScreenKey               = "currentScreen";

  public static final String RequestMappingsKey             = "requestMappings";
  public static final String ScreenMappingsKey              = "screenMappings";
  public static final String ExceptionMappingsKey           = "exceptionMappings";
  public static final String ModelManagerKey                = "modelManager";
  public static final String RequestProcessorKey            = "requestProcessor";
  public static final String ScreenManagerKey               = "screenManager";
  public static final String ScreenKey                      = "screen";
  public static final String ScreenOkKey                    = "screenok";
  public static final String WebControllerKey               = "webClaimsController";
  public static final String WebEventKey                    = "claimsEvent";
  public static final String CicsDataKey                    = "cicsData";
  public static final String UserSessionKey                 = "userSession";
  public static final String RefDataKey                     = "refData";
  public static final String WebEventList                   = "webEventList";
  public static final String VersionNoKey                   = "version";

  // Ref Data Keys
  public static final String RefGUIErrorList                = "guiErrorList";
  public static final String RefCatCodeList                 = "catCodeList";
  public static final String RefPCSCodeList                 = "pcsCodeList";
  public static final String RefStateCodeList               = "stateCodeList";
  public static final String RefTrustFundList               = "trustFundList";
  public static final String RefAdjSurvCodeList             = "adjSurvCodeList";
  public static final String RefLawyerCodeList              = "lawyerCodeList";
  public static final String RefFinderCodeList              = "finderCodeList";
  public static final String RefCurrencyCodeList            = "currencyCodeList";
  public static final String RefExpertCodeList              = "expertCodeList";
  public static final String RefCauseCodeList               = "causeCodeList";
  public static final String RefSlipTypeList                = "slipTypeList";        // added for CR7
  
  // CCN#538 - BA - 26-3
  public static final String RefSettCurrencyCodeList        = "settCurrencyCodeList";

  public static final String RefBrokerCodeList              = "brokerCodeList";
  public static final String RefSectionCodeList             = "sectionCodeList";
  public static final String RefNAICCodeList                = "naicCodeList";
  public static final String RefCountryCodeList             = "countryCodeList";
  public static final String RefDTICodeList                 = "dtiCodeList";
  public static final String RefFILCodeList                 = "filCodeList";
  public static final String RefNarrativeList               = "narrativeList";
  public static final String RefVATRateList                 = "vatRateList";
  public static final String RefPeerReviewList              = "peerReviewList";
  public static final String RefAccountList                 = "accountList";
  public static final String RefBasisOfLimitList            = "basisOfLimitList";
  public static final String RefChargeTypeList              = "chargeTypeList";
  public static final String RefEcfClassList                = "ecfClassList";
  public static final String RefClmRefRecList               = "clmRefRecList";
  public static final String RefCoverLineslipQualList       = "coverLineslipQualList";
  public static final String RefDCMQualList                 = "dcmQualList";
  public static final String RefDOLQualList                 = "dolQualList";
  public static final String RefNaicQualList                = "naicQualList";
  public static final String RefOsFeeQualList               = "osFeeQualList";
  public static final String RefOsLossQualList              = "osLossQualList";
  public static final String RefOsTotalQualList             = "osTotalQualList";
  public static final String RefBrokerTrQualList            = "brokerTrQualList"; // ECF Phase 6 change
  public static final String RefPolCertQualList             = "polCertQualList";
  public static final String OsAmountQualList               = "osAmtQualList";
  public static final String RefRiskTypeList                = "riskTypeList";
  public static final String RefMarketList                  = "marketList";
  public static final String RefSchemeCodeList              = "schemeCodeList";
  public static final String RefSectionList                 = "sectionList";
  public static final String RefSettAdvList                 = "settAdvList";
  public static final String RefRedenomIndList              = "redenomIndList";
  public static final String RefSyndicateList               = "syndicateList";
  public static final String RefPaidByChequeList            = "paidByChequeList";
  public static final String RefExpertTypeList              = "expertTypeList";
  public static final String RefServiceTypeList             = "serviceTypeList";  // CLASS 4 for CR8
  public static final String RefBinderClaimTypeList         = "binderClaimTypeList";

  // Database Table Names
  public static final String RefDataDir                     = fileSeparator() + "export" + fileSeparator() + "home" + fileSeparator() + "refdata" + fileSeparator();
  public static final String GUIErrorTable                  = "TCLGEMA-EXTRACT.CSV";
  public static final String CatCodeTable                   = "TGLCCDA-EXTRACT.CSV";
  public static final String PCSCodeTable                   = "TGLPCCA-EXTRACT.CSV";
  public static final String StateCodeTable                 = "TGLSCDA-EXTRACT.CSV";
  public static final String TrustFundTable                 = "TGLTFCA-EXTRACT.CSV";
  public static final String ExpertCodeTable                = "TGLFEEA-EXTRACT.CSV";
  public static final String FinderCodeTable                = "TGLCGCA-EXTRACT.CSV";
  public static final String CurrencyCodeTable              = "TGLCURA-EXTRACT.CSV";
  public static final String BrokerCodeTable                = "TGLBKRA-EXTRACT.CSV";
  public static final String CountryCodeTable               = "TGLCNTA-EXTRACT.CSV";
  public static final String DTICodeTable                   = "TDTDTI-EXTRACT.CSV";
  public static final String FILCodeTable                   = "TGLFILA-EXTRACT.CSV";
  public static final String NarrativeTable                 = "TGLCNDA-EXTRACT.CSV";
  public static final String VATRateTable                   = "TDTVRT-EXTRACT.CSV";
  public static final String RiskCodeTable                  = "TDTRGPA-EXTRACT.CSV";
  public static final String SectionCodeTable               = "TGLSCTA-EXTRACT.CSV";
  public static final String SyndicateTable                 = "TGLCOYA-EXTRACT.CSV";
  public static final String NaicCodeTable                  = "TDTNAC-EXTRACT.CSV";
  public static final String PoolCodeTable                  = "TDTNPO-EXTRACT.CSV";
  public static final String GroupCodeTable                 = "TDTNGP-EXTRACT.CSV";
  public static final String CauseCodeTable                 = "TGLLCCA-EXTRACT.CSV";
  public static final String EcfClassTable                  = "TGLECCA-EXTRACT.CSV";

  // Keys for web models
  public static final String AdvancedSearchResultsModelKey  = "searchResults";
  public static final String QuestionModelKey               = "question";
  public static final String TransactionStatusModelKey      = "txnStatus";
  public static final String HistoryModelKey                = "history";
  public static final String NextScreenModelKey             = "nextScreen";
  public static final String NavigationBarKey               = "navBar";
  public static final String BulkCcsCorrectionModelKey      = "bulkccscorr";
  public static final String CCSAmountsModelKey             = "ccsamounts";
  public static final String ClaimDetailsModelKey           = "claimDetails";
  public static final String ClaimTransCreationModelKey     = "claimCreation";
  public static final String ClaimTransOptionsModelKey      = "claimTxnOptions";
  public static final String ConcOfBulkSettlementModelKey   = "concofbulksett";
  public static final String CopyFromUcrModelKey            = "copyfromucr";
  public static final String EuroConversionDetailsModelKey  = "euroconv";
  public static final String FinancialDetailsModelKey       = "financialDetails";
  public static final String FindClaimModelKey              = "findclaim";
  public static final String GroupEnquiryModelKey           = "groupenq";
  public static final String GroupSearchResultsModelKey     = "groupresults";
  public static final String UserWebModelKey                = "user";
  public static final String DiaryListWebModelKey           = "diary";
  public static final String MaintainGroupModelKey          = "mg";
  public static final String MarketDetailsModelKey          = "marketDetails";
  public static final String MarketsModelKey                = "markets";
  public static final String MovementHistoryModelKey        = "mvmthistory";
  public static final String NarrativeModelKey              = "narrative";
  public static final String OsndSearchResultsModelKey      = "osndResults";
  public static final String PolicyRiskDetailsModelKey      = "policyrisk";
  public static final String RateOfExchangeAdjModelKey      = "roeadj";
  public static final String SCMAdviceModelKey              = "scmadvice";
  public static final String SecurityNotesModelKey          = "securitynotes";
  public static final String BulkComponentSelectionModelKey = "bulkcompselect";
  public static final String SetDiaryDateModelKey           = "setdiarydate";
  public static final String SingleClaimLossResModelKey     = "sclr";
  public static final String SubAdviceScheduleModelKey      = "sas";
  public static final String SummaryNonSettlementModelKey   = "summaryNonSett";
  public static final String SummarySettlementModelKey      = "summarySett";
  public static final String TransactionHistoryModelKey     = "txnhistory";
  public static final String VATRatesModelKey               = "vatrates";
  public static final String ConfirmationModelKey           = "confirmation";
  public static final String GroupingSessionModelKey        = "groupsession";
  public static final String SchemeCanadaModelKey           = "schemecanada";
  public static final String PremiumComparisonModelKey      = "premcomp";
  public static final String CreateReadviceModelKey         = "createreadvice";
  public static final String ExpertFeeBreakDownModelKey     = "expertfeebreakdown";  
  public static final String PhoneNoKey 	            = "phonenumber";
  public static final String MaxExpertLimit                 = "maxexpertlimit";

  /*CCVC Questionnaire R3B*/
  public static final String CCVCQuestionnaireModelKey      = "ccvcquestionnaire";

  
  // BA&PD: 24-11-2003: Settlement search screen
  public static final String SettSearchScreenModelKey                   = "settsearchscreen";
  public static final String SettSearchResultsScreenModelKey            = "settsearchresultsscreen";
  public static final String SettSearchDetailedResultsScreenModelKey    = "settsearchdetailedresultsscreen";


  // LY02 input keys
  public static final String LY02AccountCodeField           = "@C002_ACCOUNT_CODE";
  public static final String LY02UsernameField              = "@C002_NET_USER_ID";
  public static final String LY02PasswordField              = "@C002_PASSWORD";
  public static final String LY02SectionCodeField           = "@C002_SECTION_CODE";

  // LY02 output keys
  public static final String LY02SessionIDField             = "@C002_SESSION_NO";
  public static final String LY02LoginStatusField           = "@C002_LOGIN_STATUS";

  // LY03 input keys
  public static final String LY03SessionIDField             = "@C003_SESSION_NO";
  public static final String LY03NewPasswordField           = "@C003_NEW_PASSWORD";

  // LY03 output keys
  public static final String LY03LoginStatusField           = "@C003_LOGIN_STATUS";

  // LY04 input keys
  public static final String LY04SessionIDField             = "@C004_SESSION_NO";

  // LY05 input keys
  public static final String LY05SessionIDField             = "@C005_SESSION_NO";
  public static final String LY05OrigRefField               = "@C005_ORIG_REF";
  public static final String LY05APRefField                 = "@C005_AP_REF";

  // LY06 input keys
  public static final String LY06SessionIDField             = "@C006_SESSION_NO";
  public static final String LY06SearchOSNDField            = "@C006_SEARCH_OSDN";
  public static final String LY06LASTSysRefField            = "@C006_LAST_SYS_REF" ;
  public static final String LY06LASTCurrNoField            = "@C006_LAST_CURR_NO";
  public static final String LY06LASTSdnNoField             = "@C006_LAST_SDN_NO";
  public static final String LY06LASTSplitNoField           = "@C006_LAST_SPLIT_NO";
  public static final String LY06LASTBdownNoField           = "@C006_LAST_BDOWN_NO";
  public static final String LY06FIRSTSysRefField           = "@C006_FIRST_SYS_REF" ;
  public static final String LY06FIRSTCurrNoField           = "@C006_FIRST_CURR_NO";
  public static final String LY06FIRSTSdnNoField            = "@C006_FIRST_SDN_NO";
  public static final String LY06FIRSTSplitNoField          = "@C006_FIRST_SPLIT_NO";
  public static final String LY06FIRSTBdownNoField          = "@C006_FIRST_BDOWN_NO";
  public static final String LY06PrevScreenId               = "@C006_PREV_SCREEN_ID";

  // LY06 output keys
  public static final String LY06UCRField                   = "@C006_UCR";
  public static final String LY06TRField                    = "@C006_TR";
  public static final String LY06UCR_TR_SYS_REFField        = "@C006_UCR_TR_SYS_REF";
  public static final String LY06CURR_NOField               = "@C006_CURR_NO";
  public static final String LY06SDN_NOField                = "@C006_SDN_NO";
  public static final String LY06STAT_SPLIT_NOField         = "@C006_STAT_SPLIT_NO";
  public static final String LY06BREAKDOWN_NOField          = "@C006_BREAKDOWN_NO";
  public static final String LY06CORField                   = "@C006_COR";
  public static final String LY06NAME_1Field                = "@C006_NAME_1";
  public static final String LY06NAME_2Field                = "@C006_NAME_2";
  public static final String LY06LOSS_DATE_FROMField        = "@C006_LOSS_DATE_FROM";
  public static final String LY06LOSS_DATE_TOField          = "@C006_LOSS_DATE_TO";
  public static final String LY06STATE_CODEField            = "@C006_STATE_CODE";
  public static final String LY06OUTST_AMT_QLField           = "@C006_OUTST_TOT_QL";
  
  // LY07 input keys
  public static final String LY07_SessionID_Field           = "@C007_SESSION_NO";
  public static final String LY07_SEARCH_UCR_Field          = "@C007_SEARCH_UCR";
  public static final String LY07_SEARCH_TR_Field           = "@C007_SEARCH_TR";
  public static final String LY07_SEARCH_COR_Field          = "@C007_SEARCH_COR";
  public static final String LY07_SEARCH_TDN_Field          = "@C007_SEARCH_TDN";
  public static final String LY07_SEARCH_CERT_NO_Field      = "@C007_SEARCH_CERT_NO";

  // LY07 output keys
  public static final String LY07_UCR                       = "@C007_UCR";
  public static final String LY07_TR                        = "@C007_TR";
  public static final String LY07_UCR_TR_SYS_REF            = "@C007_UCR_TR_SYS_REF";
  public static final String LY07_CURR_NO                   = "@C007_CURR_NO";
  public static final String LY07_SDN_NO                    = "@C007_SDN_NO";
  public static final String LY07_STAT_SPLIT_NO             = "@C007_STAT_SPLIT_NO";
  public static final String LY07_BREAKDOWN_NO              = "@C007_BREAKDOWN_NO";
  public static final String LY07_NEXT_PROG                 = "@C007_NEXT_PROG";

  // LY08 input keys
  public static final String LY08_SessionID_Field           = "@C008_SESSION_NO";
  public static final String LY08_SEARCH_GRP_REF_Field      = "@C008_SEARCH_GRP_REF";
  public static final String LY08_SEARCH_BKR_UCR_Field      = "@C008_SEARCH_BKR_UCR";
  public static final String LY08_SEARCH_GRP_REF           = "@C008_SEARCH_GRP_REF";
  public static final String LY08_SEARCH_BKR_UCR           = "@C008_SEARCH_BKR_UCR";
  public static final String LY08_FIRST_KEY                = "#C008_FIRST_KEY[]";
  public static final String LY08_FIRST_SYS_REF            = "@C008_FIRST_SYS_REF";
  public static final String LY08_FIRST_CURR_NO            = "@C008_FIRST_CURR_NO";
  public static final String LY08_FIRST_SDN_NO             = "@C008_FIRST_SDN_NO";
  public static final String LY08_FIRST_SPLIT_NO           = "@C008_FIRST_SPLIT_NO";
  public static final String LY08_FIRST_BDOWN_NO           = "@C008_FIRST_BDOWN_NO";
  public static final String LY08_LAST_KEY                 = "#C008_LAST_KEY[]";
  public static final String LY08_LAST_SYS_REF             = "@C008_LAST_SYS_REF";
  public static final String LY08_LAST_CURR_NO             = "@C008_LAST_CURR_NO";
  public static final String LY08_LAST_SDN_NO              = "@C008_LAST_SDN_NO";
  public static final String LY08_LAST_SPLIT_NO            = "@C008_LAST_SPLIT_NO";
  public static final String LY08_LAST_BDOWN_NO            = "@C008_LAST_BDOWN_NO";

  // LY08 output keys
  public static final String LY08_MORE_NEXT_FIELD           = "@C008_MORE_NEXT";
  public static final String LY08_MORE_PREV_FIELD           = "@C008_MORE_PREV";

  public static final String LY08_RESULTS_TABLE             = "#C008_RESULTS_TABLE[]";
  public static final String LY08_RESULT_LINE               = "#C008_RESULT_LINE[]";
  public static final String LY08_UCR_Field                 = "@C008_UCR";
  public static final String LY08_TR_Field                  = "@C008_TR";
  public static final String LY08_UCR_TR_SYS_REF_Field      = "@C008_UCR_TR_SYS_REF";
  public static final String LY08_CURR_NO_Field             = "@C008_CURR_NO";
  public static final String LY08_SDN_NO_Field              = "@C008_SDN_NO";
  public static final String LY08_STAT_SPLIT_NO_Field       = "@C008_STAT_SPLIT_NO";
  public static final String LY08_BREAKDOWN_NO_Field        = "@C008_BREAKDOWN_NO";
  public static final String LY08_COR_Field                 = "@C008_COR";
  public static final String LY08_REINS_LOSS_Field          = "@C008_REINS_LOSS";
  public static final String LY08_BKR_REF_1_Field           = "@C008_BKR_REF_1";
  public static final String LY08_TF_CODE_Field             = "@C008_TF_CODE";
  public static final String LY08_STATE_CODE_Field          = "@C008_STATE_CODE";
  public static final String LY08_LOSS_DATE_FROM_Field      = "@C008_LOSS_DATE_FROM";
  public static final String LY08_LOSS_DATE_TO_Field        = "@C008_LOSS_DATE_TO";
  public static final String LY08_CAT_CODE_Field            = "@C008_CAT_CODE";
  public static final String LY08_PCS_CAT_CODE_Field        = "@C008_PCS_CAT_CODE";
  public static final String LY08_NAIC_CODE_Field           = "@C008_NAIC_CODE";
  public static final String LY08_NAIC_QUAL_Field           = "@C008_NAIC_QUAL";
  public static final String LY08_ORIG_CURR_Field           = "@C008_ORIG_CURR";
  public static final String LY08_PTD_AMT_Field             = "@C008_PTD_AMT";
  public static final String LY08_OUTST_AMT_Field           = "@C008_OUTST_AMT";
  public static final String LY08_OUTST_AMT_QL_Field         = "@C008_OUTST_TOT_QL";

  // LY09 input keys
  public static final String LY09_SessionID_Field           = "@C009_SESSION_NO";

  // LY09 output keys
  public static final String LY09_PROG_STATUS               = "@C009_PROG_STATUS";
  public static final String LY09_UCR                       = "@C009_UCR";
  public static final String LY09_TR                        = "@C009_TR";
  public static final String LY09_ORIG_REF_1                = "@C009_ORIG_REF_1";
  public static final String LY09_ORIG_REF_2                = "@C009_ORIG_REF_2";
  public static final String LY09_ORIG_REF_3                = "@C009_ORIG_REF_3";
  public static final String LY09_ORIG_BKR_CODE             = "@C009_ORIG_BKR_CODE";
  public static final String LY09_SECURITY_NOTES            = "#C009_SECURITY_NOTES[]";
  public static final String LY09_NOTES_LINE                = "@C009_NOTES_LINE";

  // LY10 input keys
  public static final String LY10SessionIDField             = "@C010_SESSION_NO";
  public static final String LY10_UCR_TR_SYS_REF_Field      = "@C010_UCR_TR_SYS_REF";
  public static final String LY10_CURR_NO_Field             = "@C010_CURR_NO";
  public static final String LY10_SDN_NO_Field              = "@C010_SDN_NO";
  public static final String LY10_STAT_SPLIT_NO_Field       = "@C010_STAT_SPLIT_NO";
  public static final String LY10_BREAKDOWN_NO_Field        = "@C010_BREAKDOWN_NO";
  public static final String LY10_RETURN_SCREEN_Field       = "@C010_RETURN_SCREEN";

  // LY11 input keys
  public static final String LY11SessionIDField             = "@C011_SESSION_NO";
  public static final String LY11PrevProgField              = "@C011_PREV_PROG";
  public static final String LY11SCMAdvCodeField            = "@C011_SCM_ADV_CODE";
  public static final String LY11ExitIndField               = "@C011_EXIT_IND";

  // LY11 output
  public static final String LY11NextProgField              = "@C011_NEXT_PROG";

  // LY12 input keys
  public static final String LY12SessionIDField             = "@C012_SESSION_NO";
  public static final String LY12CurrentScreen              = "@C012_CURR_SCREEN";

  // LY13 input keys
  public static final String LY13SessionIDField             = "@C013_SESSION_NO";

  // LY13 output keys
  public static final String LY13FieldValuesList            = "#C013_FIELD_VALUES[]";
  public static final String LY13FieldAttributesList        = "#C013_FIELD_ATTRIBUTES[]";
  public static final String LY13CommandAttrList            = "#C013_COMMAND_ATTRS[]";
  public static final String LY13OrigRefList                = "#C013_ORIG_REF_TABLE[]";
  public static final String LY13OrigRefAttrList            = "#C013_ORIG_REF_ATTR_TABLE[]";

  public static final String LY13XCRField                   = "@C013_XCR";
  public static final String LY13UCRField                   = "@C013_UCR";
  public static final String LY13TRField                    = "@C013_TR";
  public static final String LY13ORIG_BKRField              = "@C013_ORIG_BKR";
  public static final String LY13PEER_REV_INDField          = "@C013_PEER_REV_IND";
  public static final String LY13TRANS_SYNOPSISField        = "#C013_TRANS_SYNOPSIS[]";
  public static final String LY13TRANS_SYSNOPSIS_LINE       = "#C013_TRANS_SYNOPSIS_LINE[]";
  public static final String LY13SYNOPSIS_TEXT              = "@C013_SYNOPSIS_TEXT";
  public static final String LY13SETT_ADV_INDField          = "@C013_SETT_ADV_IND";
  public static final String LY13NON_SCM_ADVField           = "@C013_NON_SCM_ADV";
  public static final String LY13BULK_INDField              = "@C013_BULK_IND";
  public static final String LY13UNSIGNED_RISKField         = "@C013_UNSIGNED_RISK";
  public static final String LY13TREATY_INDField            = "@C013_TREATY_IND";
  public static final String LY13ECF_CLAIM_INDField         = "@C013_ECF_XCR_IND";
  public static final String LY13ECF_CLASSField             = "@C013_ECF_CLASSIFICATION";
  public static final String LY13LOSS_RESERVE_INDField      = "@C013_LOSS_RESERVE_IND";
  public static final String LY13LOC_INDField               = "@C013_LOC_IND";
  public static final String LY13SIM_RI_INDField            = "@C013_SIM_RI_IND";

  public static final String LY13LOSS_FUND_INDField         = "@C013_LOSS_FUND_IND";
  public static final String LY13CHEQUE_PYMTField           = "@C013_CHEQUE_PYMT";
  public static final String LY13CHARGE_TYPEField           = "@C013_CHARGE_TYPE";
  public static final String LY13NON_CHARGE_INDField        = "@C013_NON_CHARGE_IND";
  public static final String LY13PREV_ADV_NO_NETField       = "@C013_PREV_ADV_NO_NET";
  public static final String LY13PREV_PAID_INDField         = "@C013_PREV_PAID_IND";

  // CCN# N0058 - 09/01/2003 - BA
  public static final String LY13LOC_DRAWING_INDField       = "@C013_LOC_DRAWING_IND";

  // CCN# ????? - 03/12/2003 - S.Caine
  public static final String LY13SPECIAL_PYMT_INDField      = "@C013_SPECIAL_PYMT_IND";

  // CCN# N0021 - 15/01/2003 - devo
  public static final String LY13SCHEME_CAN_INDField        = "@C013_SCHEME_CAN_IND";
  public static final String LY13CPA_INDField               = "@C013_CPA_IND";
  public static final String LY13DIR_LSTOCK_INDField        = "@C013_DIR_LSTOCK_IND";
  public static final String LY13SCHEME_CAN_ATTRField       = "@C013_SCHEME_CAN_ATTR";
  public static final String LY13CPA_IND_ATTRField          = "@C013_CPA_IND_ATTR";
  public static final String LY13DIR_LSTOCK_INDATTRField    = "@C013_DIR_LSTOCK_ATTR";



  public static final String LY13PRES_DATEField             = "@C013_PRES_DATE";

  public static final String LY13XCR_ATTRField              = "@C013_XCR_ATTR";
  public static final String LY13UCR_ATTRField              = "@C013_UCR_ATTR";
  public static final String LY13TR_ATTRField               = "@C013_TR_ATTR";
  public static final String LY13ORIG_BKR_ATTRField         = "@C013_ORIG_BKR_ATTR";
  public static final String LY13PEER_REV_ATTRField         = "@C013_PEER_REV_ATTR";
  public static final String LY13TRANS_SYN_ATTRField        = "@C013_TRANS_SYN_ATTR";
  public static final String LY13SETT_ADV_ATTRField         = "@C013_SETT_ADV_ATTR";
  public static final String LY13NON_SCM_ADV_ATTRField      = "@C013_NON_SCM_ADV_ATTR";
  public static final String LY13BULK_IND_ATTRField         = "@C013_BULK_IND_ATTR";
  public static final String LY13UNSGN_RISK_ATTRField       = "@C013_UNSGN_RISK_ATTR";
  public static final String LY13TREATY_IND_ATTRField       = "@C013_TREATY_IND_ATTR";
  public static final String LY13ECF_CLAIM_IND_ATTRField    = "@C013_ECF_XCR_IND_ATTR";
  public static final String LY13ECF_CLASS_ATTRField        = "@C013_ECF_CLASSIFICATION_ATTR";
  public static final String LY13LOSS_RES_ATTRField         = "@C013_LOSS_RES_ATTR";
  public static final String LY13LOC_IND_ATTRField          = "@C013_LOC_IND_ATTR";
  public static final String LY13LOSS_FUND_ATTRField        = "@C013_LOSS_FUND_ATTR";
  public static final String LY13CHEQUE_PYMT_ATTRField      = "@C013_CHEQUE_PYMT_ATTR";
  public static final String LY13CHARGE_TYPE_ATTRField      = "@C013_CHARGE_TYPE_ATTR";
  public static final String LY13NON_CHG_ATTRField          = "@C013_NON_CHG_ATTR";
  public static final String LY13PREV_ADV_ATTRField         = "@C013_PREV_ADV_ATTR";
  public static final String LY13PREV_PAID_ATTRField        = "@C013_PREV_PAID_ATTR";
  public static final String LY13SIM_RI_IND_ATTRField       = "@C013_SIM_RI_IND_ATTR";

  // CCN# N0058 - 09/01/2003 - BA
  public static final String LY13LOC_DRAWING_IND_ATTRField  = "@C013_LOC_DRAWING_ATTR";

  // CCN# ????? - 03/12/2003 - S.Caine
  public static final String LY13SPECIAL_PYMT_IND_ATTRField = "@C013_SPECIAL_PYMT_ATTR";

  public static final String LY13PRES_DATE_ATTRField        = "@C013_PRES_DATE_ATTR";

  public static final String LY13BRING_FWD_ATTRField        = "@C013_BRING_FWD_ATTR";
  public static final String LY13DEL_BDOWN_ATTRField        = "@C013_DEL_BDOWN_ATTR";

  public static final String LY13ORIG_REFField              = "@C013_ORIG_REF";
  public static final String LY13AP_REFField                = "@C013_AP_REF";
  public static final String LY13ORIG_CURRField             = "@C013_ORIG_CURR";
  public static final String LY13ORIG_REF_ATTRField         = "@C013_ORIG_REF_ATTR";
  public static final String LY13AP_REF_ATTRField           = "@C013_AP_REF_ATTR";
  public static final String LY13ORIG_CURR_ATTRField        = "@C013_ORIG_CURR_ATTR";

  // LY14 input keys
  public static final String LY14_SessionID_Field           = "@C014_SESSION_NO";
  public static final String LY14_CONFIRMATION_MSG          = "@C014_CONFIRMATION_MSG";
  public static final String LY14_GROUP_REF                 = "@C014_GROUP_REF";

  // LY15 input keys
  public static final String LY15_SessionID_Field           = "@C015_SESSION_NO";
  public static final String LY15_CONFIRMATION_MSG          = "@C015_CONFIRMATION_MSG";
  public static final String LY15_GROUP_REF                 = "@C015_GROUP_REF";

  // LY16 input keys
  public static final String LY16SessionIDField             = "@C016_SESSION_NO";

  // LY16 ouput keys
  public static final String LY16_UCR                       = "@C016_UCR";
  public static final String LY16_TR                        = "@C016_TR";
  public static final String LY16_PROG_STATUS               = "@C016_PROG_STATUS";

  // LY17 input keys
  public static final String LY17SessionIDField             = "@C017_SESSION_NO";

  // LY18 input keys
  public static final String LY18_SessionID_Field           = "@C018_SESSION_NO";

  // LY19 input keys
  public static final String LY19_SessionID_Field           = "@C019_SESSION_NO";
  public static final String LY19_CURR_NO_Field             = "@C019_CURR_NO";

  // LY20 input keys
  public static final String LY20SessionIDField             = "@C020_SESSION_NO";
  public static final String LY20TransTypeField             = "@C020_TRANS_TYPE";

  // LY21 input keys
  public static final String LY21SessionIDField             = "@C021_SESSION_NO";

  // LY22 input keys
  public static final String LY22_SessionID_Field           = "@C022_SESSION_NO";

  // LY23 input keys
  public static final String LY23_SessionID_Field           = "@C023_SESSION_NO";

  // LY24 input keys
  public static final String LY24SessionIDField             = "@C024_SESSION_NO";

  // LY25 input keys
  public static final String LY25SessionIDField             = "@C025_SESSION_NO";
  public static final String LY25RiskCodeField              = "@C025_RISK_CODE" ;
  public static final String LY25SettAdvIndField            = "@C025_SETT_ADV_IND";
  public static final String LY25NonScmAdvField             = "@C025_NON_SCM_ADV";
  public static final String LY25BulkIndField               = "@C025_BULK_IND";
  public static final String LY25UnsignedRiskField          = "@C025_UNSIGNED_RISK";
  public static final String LY25TreatyIndField             = "@C025_TREATY_IND";
  public static final String LY25EcfClaimIndField           = "@C025_ECF_XCR_IND";
  public static final String LY25EcfClassField              = "@C025_ECF_CLASSIFICATION";  //added for Ecf class
  public static final String LY25SimRIIndField              = "@C025_SIM_RI_IND";
  public static final String LY25LossReserveIndField        = "@C025_LOSS_RESERVE_IND";
  public static final String LY25LocIndField                = "@C025_LOC_IND" ;
  public static final String LY25LossFundIndField           = "@C025_LOSS_FUND_IND" ;
  public static final String LY25ChequePymtField            = "@C025_CHEQUE_PYMT";
  public static final String LY25ChargeTypeField            = "@C025_CHARGE_TYPE";
  public static final String LY25NonChargeIndField          = "@C025_NON_CHARGE_IND";
  public static final String LY25PrevAdvNoNetField          = "@C025_PREV_ADV_NO_NET";
  public static final String LY25PrevPaidIndField           = "@C025_PREV_PAID_IND";

  // CCN# N0058 - 09/01/2003 - BA
  public static final String LY25LOCDrawingIndField         = "@C025_LOC_DRAWING_IND" ;

  // CCN# ????? - 03/12/2003 - S.Caine
  public static final String LY25SpecialPymtIndField        = "@C025_SPECIAL_PYMT_IND" ;

  // CCN 21 - devo
  public static final String LY25SchemeCanIndField         = "@C025_SCHEME_CAN_IND" ;
  public static final String LY25CPAIndField               = "@C025_CPA_IND" ;
  public static final String LY25DirLSTockIndField         = "@C025_DIR_LSTOCK_IND" ;


  public static final String LY25PresDateField              = "@C025_PRES_DATE";
  public static final String LY25SlipTypeField              = "@C025_SLIP_TYPE";
  public static final String LY25FieldValuesList            = "#C025_FIELD_VALUES[]";
  public static final String LY25OrigRefList                = "#C025_ORIG_REF_TABLE[]";

  public static final String LY25OrigRefField               = "@C025_ORIG_REF";
  public static final String LY25ApRefField                 = "@C025_AP_REF";
  public static final String LY25OrigCurrField              = "@C025_ORIG_CURR";
  public static final String LY25OrigCcyField               = "@C025_ORIG_CCY";
  public static final String LY25ValueCountField            = "@C025_VALUE_COUNT";
  public static final String LY25ErrorIndicatorsList        = "#C025_ERROR_INDICATORS[]";
  public static final String LY25OrigRefErrList             = "#C025_ORIG_REF_ERR_TABLE[]";
  public static final String LY25OrigRefErrField            = "@C025_ORIG_REF_ERR";
  public static final String LY25ApRefErrField              = "@C025_AP_REF_ERR";
  public static final String LY25OrigCurrErrField           = "@C025_ORIG_CURR_ERR";
  public static final String LY25SetAdvIndErrField          = "@C025_SETT_ADV_IND_ERR";
  public static final String LY25NonScmAdvErrField          = "@C025_NON_SCM_ADV_ERR";
  public static final String LY25BulkIndErrField            = "@C025_BULK_IND_ERR";
  public static final String LY25UnsignedRiskErrField       = "@C025_UNSIGNED_RISK_ERR";
  public static final String LY25TreatyIndErrField          = "@C025_TREATY_IND_ERR";
  public static final String LY25SimRiIndErrField           = "@C025_SIM_RI_IND_ERR";
  public static final String LY25LossReserveIndErrField     = "@C025_LOSS_RESERVE_IND_ERR";
  public static final String LY25LocIndErrField             = "@C025_LOC_IND_ERR";
  public static final String LY25LossFundIndErrField        = "@C025_LOSS_FUND_IND_ERR";
  public static final String LY25ChequePymtErrField         = "@C025_CHEQUE_PYMT_ERR";
  public static final String LY25ChargeTypeErrField         = "@C025_CHARGE_TYPE_ERR";
  public static final String LY25NonChargeIndErrField       = "@C025_NON_CHARGE_IND_ERR";
  public static final String LY25PrevAdvNoNetErrField       = "@C025_PREV_ADV_NO_NET_ERR";
  public static final String LY25PrevPaidIndErrField        = "@C025_PREV_PAID_IND_ERR";
  public static final String LY25LocDrawingErrField         = "@C025_LOC_DRAWING_ERR";
  public static final String LY25SchemeCanErrField          = "@C025_SCHEME_CAN_ERR";
  public static final String LY25CpaIndErrField             = "@C025_CPA_IND_ERR";
  public static final String LY25DirLstockErrField          = "@C025_DIR_LSTOCK_ERR";
  public static final String LY25PresDateErrField           = "@C025_PRES_DATE_ERR";

  // LY27 input keys
  public static final String LY27SessionIDField             = "@C027_SESSION_NO";
  public static final String LY27VersionNoField             = "@C027_VERSION_NO";
  public static final String LY27SettAdvIndField            = "@C027_SETT_ADV_IND";
  public static final String LY27NonScmAdvField             = "@C027_NON_SCM_ADV";
  public static final String LY27BulkIndField               = "@C027_BULK_IND";
  public static final String LY27UnsignedRiskField          = "@C027_UNSIGNED_RISK";
  public static final String LY27TreatyIndField             = "@C027_TREATY_IND";
  public static final String LY27EcfClaimIndField           = "@C027_ECF_XCR_IND";
  public static final String LY27EcfClassField              = "@C027_ECF_CLASSIFICATION"; // added for ECFclass 
  // public static final String LY27SimRIIndField              = "@C027_SIM_RI_IND";
  public static final String LY27LossReserveIndField        = "@C027_LOSS_RESERVE_IND";
  public static final String LY27LocIndField                = "@C027_LOC_IND" ;
  public static final String LY27LossFundIndField           = "@C027_LOSS_FUND_IND" ;
  public static final String LY27ChequePymtField            = "@C027_CHEQUE_PYMT";
  public static final String LY27ChargeTypeField            = "@C027_CHARGE_TYPE";
  public static final String LY27NonChargeIndField          = "@C027_NON_CHARGE_IND";
  public static final String LY27PrevAdvNoNetField          = "@C027_PREV_ADV_NO_NET";
  public static final String LY27PrevPaidIndField           = "@C027_PREV_PAID_IND";

  // CCN# N0058 - 09/01/2003 - BA
  public static final String LY27LOCDrawingIndField         = "@C027_LOC_DRAWING_IND" ;

  // CCN# ????? - 03/12/2003 - S.Caine
  public static final String LY27SpecialPymtIndField        = "@C027_SPECIAL_PYMT_IND" ;

  //CCN 21 - devo
  public static final String LY27SimRIIndField              = "@C027_SIM_RI_IND" ;
  public static final String LY27RIPRequiredField           = "@C027_RIP_REQUIRED_IND" ;
  public static final String LY27SchemeCanIndField          = "@C027_SCHEME_CAN_IND" ;
  public static final String LY27CPAIndField                = "@C027_CPA_IND" ;
  public static final String LY27DirLStockIndField          = "@C027_DIR_LSTOCK_IND" ;
  public static final String LY27PresDateField              = "@C027_PRES_DATE";
  public static final String LY27SlipTypeField              = "@C027_SLIP_TYPE";
  public static final String LY27RiskCodeField              = "@C027_RISK_CODE" ;
  public static final String LY27YearOfAccField             = "@C027_YEAR_OF_ACC";
  public static final String LY27UmrField                   = "@C027_UMR";
  public static final String LY27SlipOrder1Field            = "@C027_SLIP_ORDER_1";
  public static final String LY27SlipOrder2Field            = "@C027_SLIP_ORDER_2";
  public static final String LY27LineSlipCHField            = "@C027_LINESLIP_CH";
  public static final String LY27InsuredField               = "@C027_INSURED";
  public static final String LY27ReinsuredField             = "@C027_REINSURED";
  public static final String LY27VesselAircraftField        = "@C027_VESSEL_AIRCRAFT";
  public static final String LY27InterestField              = "@C027_INTEREST";
  public static final String LY27SiLimitField               = "@C027_SI_LIMIT";
  public static final String LY27ExcessLimitField           = "@C027_EXCESS_LIMIT";
  public static final String LY27SiCurrField                = "@C027_SI_CURR";
  public static final String LY27PerilsCondsField           = "@C027_PERILS_CONDS";
  public static final String LY27PolicyPeriodFromField      = "@C027_POLICY_PERIOD_FROM";
  public static final String LY27PolicyPeriodToField        = "@C027_POLICY_PERIOD_TO";
  public static final String LY27NoOfSyndicatesField        = "@C027_NO_SYNDICATES";
  public static final String LY27TotalLineField             = "@C027_TOTAL_LINE";
  public static final String LY27LidsDataTable              = "#C027_LIDS_DATA[]";
  public static final String LY27LidsOrigBkr                = "@C027_ORIG_BKR_CODE";
  public static final String LY27LidsOrigCurr               = "@C027_ORIG_CURR_L";
  public static final String LY27LidsSettCurr               = "@C027_SETT_CURR";
  public static final String LY27LidsFilCode1               = "@C027_FIL_CODE_1";
  public static final String LY27LidsFilCode2               = "@C027_FIL_CODE_2";
  public static final String LY27LidsTfCode                 = "@C027_TF_CODE";
  public static final String LY27LidsStateCode              = "@C027_STATE_CODE";
  public static final String LY27LidsNaicCode               = "@C027_NAIC_CODE";
  public static final String LY27LidsNaicQual               = "@C027_NAIC_QUAL";
  public static final String LY27LidsNonUsTfCode            = "@C027_NON_US_TF_CODE";
  public static final String LY27LidsCountryCode            = "@C027_CNTRY_CODE";
  public static final String LY27LidsWarInd                 = "@C027_WAR_IND";
  public static final String LY27LidsDtiCode                = "@C027_DTI_CODE";


  // LY28 input keys
  public static final String LY28_SessionID_Field           = "@C028_SESSION_NO";

  // LY28 output keys
  public static final String LY28_SCREEN_MODE_Field      = "@C028_SCREEN_MODE";
  public static final String LY28_FIELD_VALUES_Table 	 = "#C028_FIELD_VALUES[]";

  public static final String LY28_XCR_Field        	 = "@C028_XCR";
  public static final String LY28_UCR_Field      	 = "@C028_UCR";
  public static final String LY28_TR_Field        	 = "@C028_TR";
  public static final String LY28_ORIG_REF_1_Field       = "@C028_ORIG_REF_1";
  public static final String LY28_ORIG_REF_2_Field    	 = "@C028_ORIG_REF_2";
  public static final String LY28_ORIG_REF_3_Field       = "@C028_ORIG_REF_3";
  public static final String LY28_PEER_REV_IND_Field     = "@C028_PEER_REV_IND";
  public static final String LY28_RISK_CODE_Field        = "@C028_RISK_CODE";
  public static final String LY28_MARKET_CODE            = "@C028_MARKET_CODE";
  public static final String LY28_YEAR_OF_ACC_Field  	 = "@C028_YEAR_OF_ACC";
  public static final String LY28_INTEREST_Field         = "@C028_INTEREST";
  public static final String LY28_LIMIT_TABLE_Table 	 = "#C028_LIMIT_TABLE[]";

  public static final String LY28_LIMIT_CURR_Field       = "@C028_LIMIT_CURR";
  public static final String LY28_SI_LIMIT_Field      	 = "@C028_SI_LIMIT";
  public static final String LY28_EXCESS_LIMIT_Field   	 = "@C028_EXCESS_LIMIT";
  public static final String LY28_SI_NARR_1_Field      	 = "@C028_SI_NARR_1";

  /*  CCN: N0047
      Changed on: 11/12/02 (DH)
  public static final String LY28_SI_NARR_2_Field     	 = "@C028_SI_NARR_2";
  */

  public static final String LY28_C028_SLIP_ORDER_1_Field  = "@C028_SLIP_ORDER_1";
  public static final String LY28_C028_SLIP_ORDER_2_Field  = "@C028_SLIP_ORDER_2";
  public static final String LY28_PERILS_CONDS_Field  	 = "@C028_PERILS_CONDS";
  public static final String LY28_LOCATION_VOYAGE_Field  = "@C028_LOCATION_VOYAGE";

  public static final String LY28_BASIS_OF_LIMIT_Field   = "@C028_BASIS_OF_LIMIT";
  public static final String LY28_POL_CERT_FROM_Field    = "@C028_POL_CERT_FROM";
  public static final String LY28_POL_CERT_TO_Field    	 = "@C028_POL_CERT_TO";
  public static final String LY28_POL_CERT_QUAL_Field    = "@C028_POL_CERT_QUAL";
  public static final String LY28_POL_PERIOD_NARR_Field  = "@C028_POL_PERIOD_NARR";
  public static final String LY28_COVER_LS_FROM_Field    = "@C028_COVER_LS_FROM";
  public static final String LY28_COVER_LS_TO_Field      = "@C028_COVER_LS_TO";
  public static final String LY28_COVER_LS_QUAL_Field  	 = "@C028_COVER_LS_QUAL";
  public static final String LY28_WAR_IND_Field        	 = "@C028_WAR_IND";
  public static final String LY28_SLIP_TYPE_Field        = "@C028_SLIP_TYPE";   // added for CR7
  
  // CCN # N0030 - Add UMR Field
  public static final String LY28_UMR_Field              = "@C028_UMR";

  public static final String LY28_FIELD_ATTRIBUTES_Table = "#C028_FIELD_ATTRIBUTES[]";

  public static final String LY28_XCR_ATTR_Field     	 = "@C028_XCR_ATTR";
  public static final String LY28_UCR_ATTR_Field      	 = "@C028_UCR_ATTR";
  public static final String LY28_TR_ATTR_Field    	 = "@C028_TR_ATTR";
  public static final String LY28_ORIG_REF_ATTR1_Field   = "@C028_ORIG_REF_ATTR1";
  public static final String LY28_ORIG_REF_ATTR2_Field   = "@C028_ORIG_REF_ATTR2";
  public static final String LY28_ORIG_REF_ATTR3_Field   = "@C028_ORIG_REF_ATTR3";
  public static final String LY28_PEER_REV_ATTR_Field    = "@C028_PEER_REV_ATTR";
  public static final String LY28_RISK_CODE_ATTR_Field   = "@C028_RISK_CODE_ATTR";
  // CCN# N0039 - Add market code field
  public static final String LY28_MKT_CODE_ATTR_Field    = "@C028_MKT_CODE_ATTR" ;
  public static final String LY28_YOA_ATTR_Field         = "@C028_YOA_ATTR";
  public static final String LY28_INTEREST_ATTR_Field    = "@C028_INTEREST_ATTR";
  public static final String LY28_LIMIT_CURR_ATTR_Field  = "@C028_LIMIT_CURR_ATTR";

  public static final String LY28_SI_LIMIT_ATTR_Field    = "@C028_SI_LIMIT_ATTR";
  public static final String LY28_EXCESS_LIM_ATTR_Field  = "@C028_EXCESS_LIM_ATTR";
  public static final String LY28_SI_NARR_ATTR1_Field    = "@C028_SI_NARR_ATTR1";
  public static final String LY28_ORIG_BKR_Field    	 = "@C028_ORIG_BKR";
  public static final String LY28_CURRENT_BKR_Field      = "@C028_CURR_BKR";

  /*  CCN: N0047
      Changed on: 11/12/02 (DH)
  public static final String LY28_SI_NARR_ATTR2_Field    = "@C028_SI_NARR_ATTR2";
  */
  public static final String LY28_SLIP_ORDER_ATTR1_Field = "@C028_SLIP_ORDER_ATTR1";
  public static final String LY28_SLIP_ORDER_ATTR2_Field = "@C028_SLIP_ORDER_ATTR2";

  public static final String LY28_PERILS_CONDS_ATTR_Field  = "@C028_PERILS_CONDS_ATTR";
  public static final String LY28_LOC_VGE_ATTR_Field       = "@C028_LOC_VGE_ATTR";
  public static final String LY28_BASIS_OF_LIMIT_ATTR_Field = "@C028_BASIS_OF_LIMIT_ATTR";
  public static final String LY28_POL_FROM_ATTR_Field     = "@C028_POL_FROM_ATTR";
  public static final String LY28_POL_TO_ATTR_Field       = "@C028_POL_TO_ATTR";
  public static final String LY28_POL_CERT_Q_ATTR_Field   = "@C028_POL_CERT_Q_ATTR";
  public static final String LY28_POL_NARR_ATTR_Field     = "@C028_POL_NARR_ATTR";
  public static final String LY28_COVER_FROM_ATTR_Field   = "@C028_COVER_FROM_ATTR";
  public static final String LY28_COVER_TO_ATTR_Field     = "@C028_COVER_TO_ATTR";

  public static final String LY28_COVER_LS_Q_ATTR_Field   = "@C028_COVER_LS_Q_ATTR";
  public static final String LY28_WAR_IND_ATTR_Field      = "@C028_WAR_IND_ATTR";
  // CCN # N0030 - Add UMR Field
  public static final String LY28_UMR_ATTR_Field          = "@C028_UMR_ATTR";
  public static final String LY28_ORIG_BKR_ATTR_Field  	  = "@C028_ORIG_BKR_ATTR";
  public static final String LY28_CURRENT_BKR_ATTR_Field  = "@C028_CURR_BKR_ATTR";
  public static final String LY28_SLIP_TYPE_ATTR_Field   = "@C028_SLIP_TYPE_ATTR"; // added for CR7
  

  // LY29 input and output keys
  //** Note that the LY29 event hasn't been written yet due to query on the commarea **/
  public static final String LY29_SessionID_Field          = "@C029_SESSION_NO";
  public static final String LY29_FIELD_VALUES_Table 	   = "#C029_FIELD_VALUES[]";

  public static final String LY29_PEER_REV_IND_Field       = "@C029_PEER_REV_IND";
  public static final String LY29_CURRENT_BKR_Field    	   = "@C029_ORIG_BKR";
  public static final String LY29_RISK_CODE_Field          = "@C029_RISK_CODE";
  public static final String LY29_MARKET_CODE_Field        = "@C029_MARKET_CODE";
  public static final String LY29_YEAR_OF_ACC_Field  	   = "@C029_YEAR_OF_ACC";
  public static final String LY29_INTEREST_Field           = "@C029_INTEREST";
  public static final String LY29_LIMIT_TABLE_Table 	   = "#C029_LIMIT_TABLE[]";

  public static final String LY29_LIMIT_CURR_Field         = "@C029_LIMIT_CURR";
  public static final String LY29_SI_LIMIT_Field      	   = "@C029_SI_LIMIT";
  public static final String LY29_EXCESS_LIMIT_Field       = "@C029_EXCESS_LIMIT";

  public static final String LY29_SLIP_ORDER_1_Field       = "@C029_SLIP_ORDER_1";
  public static final String LY29_SLIP_ORDER_2_Field       = "@C029_SLIP_ORDER_2";
  public static final String LY29_PERILS_CONDS_Field  	   = "@C029_PERILS_CONDS";
  public static final String LY29_LOCATION_VOYAGE_Field    = "@C029_LOCATION_VOYAGE";

  public static final String LY29_BASIS_OF_LIMIT_Field     = "@C029_BASIS_OF_LIMIT";
  public static final String LY29_POL_CERT_FROM_Field      = "@C029_POL_CERT_FROM";
  public static final String LY29_POL_CERT_TO_Field    	   = "@C029_POL_CERT_TO";
  public static final String LY29_POL_CERT_QUAL_Field      = "@C029_POL_CERT_QUAL";
  public static final String LY29_POL_PERIOD_NARR_Field    = "@C029_POL_PERIOD_NARR";
  public static final String LY29_COVER_LS_FROM_Field      = "@C029_COVER_LS_FROM";
  public static final String LY29_COVER_LS_TO_Field        = "@C029_COVER_LS_TO";
  public static final String LY29_COVER_LS_QUAL_Field  	   = "@C029_COVER_LS_QUAL";
  public static final String LY29_WAR_IND_Field        	   = "@C029_WAR_IND";
  public static final String LY29_UMR_Field        	   = "@C029_UMR";
  public static final String LY29_UMR_LIDS_Field       	   = "@C029_UMR_LIDS";
  public static final String LY29_SLIP_TYPE_Field      = "@C029_SLIP_TYPE";              // added for cr7
  // LY30 input keys
  public static final String LY30_FIELD_VALUES              = "#C030_FIELD_VALUES[]";
  public static final String LY30_SESSION_NO                = "@C030_SESSION_NO";
  public static final String LY30_SCREEN_MODE               = "@C030_SCREEN_MODE";
  public static final String LY30_XCR                       = "@C030_XCR";
  public static final String LY30_UCR                       = "@C030_UCR";
  public static final String LY30_TR                        = "@C030_TR";
  public static final String LY30_ORIG_REF_1                = "@C030_ORIG_REF_1";
  public static final String LY30_ORIG_REF_2                = "@C030_ORIG_REF_2";
  public static final String LY30_ORIG_REF_3                = "@C030_ORIG_REF_3";
  public static final String LY30_PEER_REV_IND              = "@C030_PEER_REV_IND";
  public static final String LY30_CURRENT_BKR               = "@C030_ORIG_BKR";
  public static final String LY30_RISK_CODE                 = "@C030_RISK_CODE";
  // CCN# N0039 - Add Market Code Field
  public static final String LY30_MARKET_CODE               = "@C030_MARKET_CODE";
  public static final String LY30_YEAR_OF_ACC               = "@C030_YEAR_OF_ACC";
  public static final String LY30_INTEREST                  = "@C030_INTEREST";
  public static final String LY30_SI_NARR_1                 = "@C030_SI_NARR_1";
  public static final String LY30_SI_NARR_2                 = "@C030_SI_NARR_2";
  public static final String LY30_SLIP_ORDER_1              = "@C030_SLIP_ORDER_1";
  public static final String LY30_SLIP_ORDER_2              = "@C030_SLIP_ORDER_2";
  public static final String LY30_PERILS_CONDS              = "@C030_PERILS_CONDS";
  public static final String LY30_LOCATION_VOYAGE           = "@C030_LOCATION_VOYAGE";
  public static final String LY30_BASIS_OF_LIMIT            = "@C030_BASIS_OF_LIMIT";
  public static final String LY30_POL_CERT_FROM             = "@C030_POL_CERT_FROM";
  public static final String LY30_POL_CERT_TO               = "@C030_POL_CERT_TO";
  public static final String LY30_POL_CERT_QUAL             = "@C030_POL_CERT_QUAL";
  public static final String LY30_POL_PERIOD_NARR           = "@C030_POL_PERIOD_NARR";
  public static final String LY30_COVER_LS_FROM             = "@C030_COVER_LS_FROM";
  public static final String LY30_COVER_LS_TO               = "@C030_COVER_LS_TO";
  public static final String LY30_COVER_LS_QUAL             = "@C030_COVER_LS_QUAL";
  public static final String LY30_WAR_IND                   = "@C030_WAR_IND";
  public static final String LY30_SLIP_TYPE                 = "@C030_SLIP_TYPE";          // added for CR7
  
  // CCN # N0030 - Add UMR Field
  public static final String LY30_UMR_Field                 = "@C030_UMR";
  public static final String LY30_LIMIT_CURR                = "@C030_LIMIT_CURR";
  public static final String LY30_SI_LIMIT                  = "@C030_SI_LIMIT";
  public static final String LY30_EXCESS_LIMIT              = "@C030_EXCESS_LIMIT";
  public static final String LY30_LIMIT_TABLE               = "#C030_LIMIT_TABLE[]";

  // LY31 input keys
  public static final String LY31SessionIDField             = "@C031_SESSION_NO";

  // LY31 output keys
  public static final String LY31_SCREEN_MODE               = "@C031_SCREEN_MODE";
  public static final String LY31_FIELD_VALUES              = "#C031_FIELD_VALUES[]";
  public static final String LY31_XCR                       = "@C031_XCR";
  public static final String LY31_UCR                       = "@C031_UCR";
  public static final String LY31_TR                        = "@C031_TR";
  public static final String LY31_ORIG_REF_1                = "@C031_ORIG_REF_1";
  public static final String LY31_ORIG_REF_2                = "@C031_ORIG_REF_2";
  public static final String LY31_ORIG_REF_3                = "@C031_ORIG_REF_3";
  public static final String LY31_ORIG_BKR                  = "@C031_ORIG_BKR";
  public static final String LY31_SIGNED_IND                = "@C031_SIGNED_IND";
  public static final String LY31_PEER_REV_IND              = "@C031_PEER_REV_IND";
  public static final String LY31_NO_SYNDICATES             = "@C031_NO_SYNDICATES";
  public static final String LY31_TOTAL_LINE                = "@C031_TOTAL_LINE";
  public static final String LY31_MKT_SOURCE                = "@C031_MKT_SOURCE";
  public static final String LY31_MARKET_TABLE              = "#C031_MARKET_TABLE[]";
  public static final String LY31_MARKET_LINE               = "#C031_MARKET_LINE[]";
  public static final String LY31_SYNDICATE_NO              = "@C031_SYNDICATE_NO";
  public static final String LY31_SYNDICATE_LINE            = "@C031_SYNDICATE_LINE";
  public static final String LY31_SYNDICATE_REF             = "@C031_SYNDICATE_REF";

  // CR ??? D.Smith - 09/12/03
  public static final String LY31_OPT_OUT_STATUS            = "@C031_OPT_OUT_STATUS";
  public static final String LY31_OPT_OUT_EFF_DATE          = "@C031_OPT_OUT_EFF_DATE";

  public static final String LY31_AGREEMENT_ROLE            = "@C031_AGREEMENT_ROLE";
  public static final String LY31_SYND_RESP_CODE            = "@C031_SYND_RESP_CODE";
  public static final String LY31_USER_NAME_AUTH            = "@C031_USER_NAME_AUTH";
  public static final String LY31_RESP_TIMESTAMP            = "@C031_RESP_TIMESTAMP";
  public static final String LY31_FIELD_ATTRIBUTES          = "#C031_FIELD_ATTRIBUTES[]";
  public static final String LY31_XCR_ATTR                  = "@C031_XCR_ATTR";
  public static final String LY31_UCR_ATTR                  = "@C031_UCR_ATTR";
  public static final String LY31_TR_ATTR                   = "@C031_TR_ATTR";
  public static final String LY31_ORIG_REF_ATTR1            = "@C031_ORIG_REF_ATTR1";
  public static final String LY31_ORIG_REF_ATTR2            = "@C031_ORIG_REF_ATTR2";
  public static final String LY31_ORIG_REF_ATTR3            = "@C031_ORIG_REF_ATTR3";
  public static final String LY31_ORIG_BKR_ATTR             = "@C031_ORIG_BKR_ATTR";
  public static final String LY31_SIGNED_IND_ATTR           = "@C031_SIGNED_IND_ATTR";
  public static final String LY31_PEER_REV_IND_ATTR         = "@C031_PEER_REV_IND_ATTR";
  public static final String LY31_NO_SYNDICATES_ATTR        = "@C031_NO_SYNDICATES_ATTR";
  public static final String LY31_TOTAL_LINE_ATTR           = "@C031_TOTAL_LINE_ATTR";
  public static final String LY31_MKT_SRCE_ATTR             = "@C031_MKT_SRCE_ATTR";
  public static final String LY31_MKT_CHANGE_ATTR           = "@C031_MKT_CHANGE_ATTR";
  public static final String LY31_MKT_ATTR_TABLE            = "#C031_MKT_ATTR_TABLE[]";
  public static final String LY31_SYND_NO_ATTR              = "@C031_SYND_NO_ATTR";
  public static final String LY31_SYND_LINE_ATTR            = "@C031_SYND_LINE_ATTR";
  public static final String LY31_SYND_REF_ATTR             = "@C031_SYND_REF_ATTR";

  // LY32 input keys
  public static final String LY32_SessionID_Field           = "@C032_SESSION_NO";
  public static final String LY32_FIELD_VALUES_Table        = "#C032_FIELD_VALUES[]";
  public static final String LY32_NO_SYNDICATES_Field       = "@C032_NO_SYNDICATES";
  public static final String LY32_TOTAL_LINE_Field          = "@C032_TOTAL_LINE";
  public static final String LY32_MKT_SOURCE_Field          = "@C032_MKT_SOURCE";
  public static final String LY32_MARKET_TABLE_Table        = "#C032_MARKET_TABLE[]";
  public static final String LY32_MARKET_LINE_Table         = "#C032_MARKET_LINE[]";
  public static final String LY32_SYNDICATE_NO_Field        = "@C032_SYNDICATE_NO";
  public static final String LY32_SYNDICATE_LINE_Field      = "@C032_SYNDICATE_LINE";
  public static final String LY32_SYNDICATE_REF_Field       = "@C032_SYNDICATE_REF";
  public static final String LY32_DELETE_IND_Field          = "@C032_DELETE_IND";

  // LY33 input keys
  public static final String LY33_SessionID_Field           = "@C033_SESSION_NO";

  // LY33 output keys
  public static final String LY33_TOTAL_LINE_Field          = "@C033_TOTAL_LINE";
  public static final String LY33_MARKET_TABLE_Table        = "#C033_MARKET_TABLE[]";
  public static final String LY33_MARKET_LINE_Table         = "#C033_MARKET_LINE[]";
  public static final String LY33_SYNDICATE_NO_Field        = "@C033_SYNDICATE_NO";
  public static final String LY33_SYNDICATE_LINE_Field      = "@C033_SYNDICATE_LINE";
  public static final String LY33_SYNDICATE_REF_Field       = "@C033_SYNDICATE_REF";
  public static final String LY33_BUREAU_LEAD_Field         = "@C033_BUREAU_LEAD";
  public static final String LY33_DELETE_IND_Field          = "@C033_DELETE_IND";

  // LY34 input keys
  public static final String LY34_SessionID_Field           = "@C034_SESSION_NO";

  // LY34 output keys
  public static final String LY34_SCREEN_MODE_Field      = "@C034_SCREEN_MODE";
  public static final String LY34_FIELD_VALUES_Table     = "#C034_FIELD_VALUES[]";
  public static final String LY34_XCR_Field     	 = "@C034_XCR";
  public static final String LY34_UCR_Field     	 = "@C034_UCR";
  public static final String LY34_TR_Field     	         = "@C034_TR";
  public static final String LY34_ORIG_REF_1_Field     	 = "@C034_ORIG_REF_1";
  public static final String LY34_ORIG_REF_2_Field     	 = "@C034_ORIG_REF_2";
  public static final String LY34_ORIG_REF_3_Field     	 = "@C034_ORIG_REF_3";
  public static final String LY34_ORIG_BKR_Field     	 = "@C034_ORIG_BKR";
  public static final String LY34_SIGNED_IND_Field     	 = "@C034_SIGNED_IND";
  public static final String LY34_PEER_REV_IND_Field   	 = "@C034_PEER_REV_IND";
  public static final String LY34_BKR_CNTCT_Field     	 = "@C034_BKR_CNTCT";
  public static final String LY34_BKR_CNTCT_PHONE_Field  = "@C034_BKR_CNTCT_PHONE";
  public static final String LY34_BKR_REF_1_Field     	 = "@C034_BKR_REF_1";
  public static final String LY34_BKR_REF_2_Field     	 = "@C034_BKR_REF_2";
  public static final String LY34_BROKER_UCR_Field     	 = "@C034_BROKER_UCR";
  public static final String LY34_ORIG_INSURED_Field     = "@C034_ORIG_INSURED";
  public static final String LY34_INSURED_Field     	 = "@C034_INSURED";
  public static final String LY34_REINSURED_Field     	 = "@C034_REINSURED";
  public static final String LY34_COVER_HOLDER_Field     = "@C034_COVER_HOLDER";
  public static final String LY34_CLAIMANT_Field     	 = "@C034_CLAIMANT";
  public static final String LY34_OTHER_NAME_Field     	 = "@C034_OTHER_NAME";
  public static final String LY34_LOSS_NAME_Field     	 = "@C034_LOSS_NAME";
  public static final String LY34_VESSEL_AIRCRAFT_Field  = "@C034_VESSEL_AIRCRAFT";
  public static final String LY34_LOSS_DATE_FROM_Field   = "@C034_LOSS_DATE_FROM";
  public static final String LY34_LOSS_DATE_TO_Field     = "@C034_LOSS_DATE_TO";
  public static final String LY34_LOSS_DATE_QUAL_Field   = "@C034_LOSS_DATE_QUAL";
  public static final String LY34_LOSS_DATE_NARR_Field   = "@C034_LOSS_DATE_NARR";
  public static final String LY34_DCM_DOD_FROM_Field     = "@C034_DCM_DOD_FROM";
  public static final String LY34_DCM_DOD_TO_Field     	 = "@C034_DCM_DOD_TO";
  public static final String LY34_DCM_DOD_QUAL_Field     = "@C034_DCM_DOD_QUAL";
  public static final String LY34_LOSS_LOCATION_Field    = "@C034_LOSS_LOCATION";
  public static final String LY34_VOYAGE_Field     	 = "@C034_VOYAGE";

  public static final String LY34_CAT_CODE_Field     	 = "@C034_CAT_CODE";
  public static final String LY34_PCS_CAT_CODE_Field     = "@C034_PCS_CAT_CODE";
  public static final String LY34_CLM_RISK_TYPE_Field  	 = "@C034_CLM_RISK_TYPE";
  public static final String LY34_LOSS_DETAILS_Field   	 = "@C034_LOSS_DETAILS";
  public static final String LY34_ADJUSTER_NAME_Field  	 = "@C034_ADJUSTER_NAME";
  public static final String LY34_ADJUSTER_REF_Field   	 = "@C034_ADJUSTER_REF";
  public static final String LY34_LAWYER_NAME_Field      = "@C034_LAWYER_NAME";
  public static final String LY34_LAWYER_REF_Field     	 = "@C034_LAWYER_REF";
  public static final String LY34_CAUSE_CODE_Field       = "@C034_CAUSE_CODE";
  public static final String LY34_COI_TABLE_Table        = "#C034_COI_TABLE[]";
  public static final String LY34_CERT_INS_NO_Field      = "@C034_CERT_INS_NO";
  public static final String LY34_FIELD_ATTRIBUTES_Table = "#C034_FIELD_ATTRIBUTES[]";
  public static final String LY34_XCR_ATTR_Field     	 = "@C034_XCR_ATTR";
  public static final String LY34_UCR_ATTR_Field     	 = "@C034_UCR_ATTR";
  public static final String LY34_TR_ATTR_Field     	 = "@C034_TR_ATTR";
  public static final String LY34_ORIG_REF_ATTR1_Field   = "@C034_ORIG_REF_ATTR1";
  public static final String LY34_ORIG_REF_ATTR2_Field   = "@C034_ORIG_REF_ATTR2";
  public static final String LY34_ORIG_REF_ATTR3_Field     = "@C034_ORIG_REF_ATTR3";
  public static final String LY34_ORIG_BKR_ATTR_Field      = "@C034_ORIG_BKR_ATTR";
  public static final String LY34_SIGN_IND_ATTR_Field      = "@C034_SIGN_IND_ATTR";
  public static final String LY34_PEER_REV_ATTR_Field      = "@C034_PEER_REV_ATTR";
  public static final String LY34_BKR_CNTCT_ATTR_Field     = "@C034_BKR_CNTCT_ATTR";
  public static final String LY34_BKR_PHONE_ATTR_Field     = "@C034_BKR_PHONE_ATTR";
  public static final String LY34_BKR_REF_ATTR1_Field      = "@C034_BKR_REF_ATTR1";
  public static final String LY34_BKR_REF_ATTR2_Field      = "@C034_BKR_REF_ATTR2";
  public static final String LY34_BROKER_UCR_ATTR_Field    = "@C034_BROKER_UCR_ATTR";
  public static final String LY34_ORIG_INS_ATTR_Field      = "@C034_ORIG_INS_ATTR";
  public static final String LY34_INSURED_ATTR_Field       = "@C034_INSURED_ATTR";
  public static final String LY34_REINSURED_ATTR_Field     = "@C034_REINSURED_ATTR";
  public static final String LY34_COV_HOLD_ATTR_Field      = "@C034_COV_HOLD_ATTR";
  public static final String LY34_CLAIMANT_ATTR_Field      = "@C034_CLAIMANT_ATTR";
  public static final String LY34_OTHER_NAME_ATTR_Field    = "@C034_OTHER_NAME_ATTR";
  public static final String LY34_LOSS_NAME_ATTR_Field     = "@C034_LOSS_NAME_ATTR";
  public static final String LY34_VESS_AIR_ATTR_Field      = "@C034_VESS_AIR_ATTR";
  public static final String LY34_DOL_FROM_ATTR_Field      = "@C034_DOL_FROM_ATTR";
  public static final String LY34_DOL_TO_ATTR_Field        = "@C034_DOL_TO_ATTR";
  public static final String LY34_DOL_QUAL_ATTR_Field      = "@C034_DOL_QUAL_ATTR";
  public static final String LY34_DOL_NARR_ATTR_Field      = "@C034_DOL_NARR_ATTR";
  public static final String LY34_DCM_FROM_ATTR_Field      = "@C034_DCM_FROM_ATTR";
  public static final String LY34_DCM_TO_ATTR_Field        = "@C034_DCM_TO_ATTR";
  public static final String LY34_DCM_QUAL_ATTR_Field      = "@C034_DCM_QUAL_ATTR";
  public static final String LY34_LOSS_LOC_ATTR_Field      = "@C034_LOSS_LOC_ATTR";
  public static final String LY34_VOYAGE_ATTR_Field        = "@C034_VOYAGE_ATTR";
  public static final String LY34_CAT_ATTR_Field     	   = "@C034_CAT_ATTR";
  public static final String LY34_PCS_CAT_ATTR_Field       = "@C034_PCS_CAT_ATTR";
  public static final String LY34_CLM_RISK_ATTR_Field      = "@C034_CLM_RISK_ATTR";
  public static final String LY34_LOSS_DETS_ATTR_Field     = "@C034_LOSS_DETS_ATTR";
  public static final String LY34_ADJ_NAME_ATTR_Field      = "@C034_ADJ_NAME_ATTR";
  public static final String LY34_ADJ_REF_ATTR_Field       = "@C034_ADJ_REF_ATTR";
  public static final String LY34_LAW_NAME_ATTR_Field      = "@C034_LAW_NAME_ATTR";
  public static final String LY34_LAW_REF_ATTR_Field       = "@C034_LAW_REF_ATTR";

  public static final String LY34_CAUSE_CODE_ATTR_Field    = "@C034_CAUSE_CODE_ATTR";

  public static final String LY34_COI_ATTRS_Table          = "#C034_COI_ATTRS[]";
  public static final String LY34_CERT_NO_ATTR_Field       = "@C034_CERT_NO_ATTR";

  // CCN 21 devo 15/01/2003
  public static final String  LY34_CH_CLM_REF               = "@C034_CH_CLM_REF";
  public static final String  LY34_CH_CLM_REF_ATTR          = "@C034_CH_CLM_REF_ATTR";

  //Binders fields BND_CLASS
  public static final String  LY34_BND_CLASS               = "@C034_BND_CLASS";
  public static final String  LY34_BND_CLASS_ATTR          = "@C034_BND_CLASS_ATTR";
  
  // LY35 input keys
  public static final String LY35_SessionID_Field           = "@C035_SESSION_NO";
  public static final String LY35_FIELD_VALUES_Table        = "#C035_FIELD_VALUES[]";

  public static final String  LY35_BKR_CNTCT                = "@C035_BKR_CNTCT";
  public static final String  LY35_BKR_CNTCT_PHONE          = "@C035_BKR_CNTCT_PHONE";
  public static final String  LY35_BKR_REF_1                = "@C035_BKR_REF_1";
  public static final String  LY35_BKR_REF_2                = "@C035_BKR_REF_2";
  public static final String  LY35_BROKER_UCR               = "@C035_BROKER_UCR";
  public static final String  LY35_ORIG_INSURED             = "@C035_ORIG_INSURED";
  public static final String  LY35_INSURED                  = "@C035_INSURED";
  public static final String  LY35_REINSURED                = "@C035_REINSURED";
  public static final String  LY35_COVER_HOLDER             = "@C035_COVER_HOLDER";
  public static final String  LY35_CLAIMANT                 = "@C035_CLAIMANT";
  public static final String  LY35_OTHER_NAME               = "@C035_OTHER_NAME";
  public static final String  LY35_LOSS_NAME                = "@C035_LOSS_NAME";
  public static final String  LY35_VESSEL_AIRCRAFT          = "@C035_VESSEL_AIRCRAFT";
  public static final String  LY35_LOSS_DATE_FROM           = "@C035_LOSS_DATE_FROM";
  public static final String  LY35_LOSS_DATE_TO             = "@C035_LOSS_DATE_TO";
  public static final String  LY35_LOSS_DATE_QUAL           = "@C035_LOSS_DATE_QUAL";
  public static final String  LY35_LOSS_DATE_NARR           = "@C035_LOSS_DATE_NARR";
  public static final String  LY35_DCM_DOD_FROM             = "@C035_DCM_DOD_FROM";
  public static final String  LY35_DCM_DOD_TO               = "@C035_DCM_DOD_TO";
  public static final String  LY35_DCM_DOD_QUAL             = "@C035_DCM_DOD_QUAL";
  public static final String  LY35_LOSS_LOCATION            = "@C035_LOSS_LOCATION";
  public static final String  LY35_VOYAGE                   = "@C035_VOYAGE";
  public static final String  LY35_CAT_CODE                 = "@C035_CAT_CODE";
  public static final String  LY35_PCS_CAT_CODE             = "@C035_PCS_CAT_CODE";
  public static final String  LY35_CLM_RISK_TYPE            = "@C035_CLM_RISK_TYPE";
  public static final String  LY35_LOSS_DETAILS             = "@C035_LOSS_DETAILS";
  public static final String  LY35_ADJUSTER_NAME            = "@C035_ADJUSTER_NAME";
  public static final String  LY35_ADJUSTER_REF             = "@C035_ADJUSTER_REF";
  public static final String  LY35_LAWYER_NAME              = "@C035_LAWYER_NAME";
  public static final String  LY35_LAWYER_REF               = "@C035_LAWYER_REF";
  public static final String  LY35_CAUSE_CODE               = "@C035_CAUSE_CODE";

  // CCN 21 devo 15/01/2003
  public static final String  LY35_CH_CLM_REF               = "@C035_CH_CLM_REF";

  public static final String  LY35_COI_Table                = "#C035_COI_TABLE[]";
  public static final String  LY35_CERT_INS_NO              = "@C035_CERT_INS_NO";


  // LY36 input keys
  public static final String LY36_SessionID_Field           = "@C036_SESSION_NO";
  public static final String LY36_SCREEN_MODE               = "@C036_SCREEN_MODE";
  public static final String LY36_FIELD_VALUES_Table        = "#C036_FIELD_VALUES[]";

  public static final String  LY36_XCR                      = "@C036_XCR";
  public static final String  LY36_UCR                      = "@C036_UCR";
  public static final String  LY36_TR                       = "@C036_TR";
  public static final String  LY36_ORIG_REF_1               = "@C036_ORIG_REF_1";
  public static final String  LY36_ORIG_REF_2               = "@C036_ORIG_REF_2";
  public static final String  LY36_ORIG_REF_3               = "@C036_ORIG_REF_3";
  public static final String  LY36_ORIG_BKR                 = "@C036_ORIG_BKR";
  public static final String  LY36_SIGNED_IND               = "@C036_SIGNED_IND";
  public static final String  LY36_PEER_REV_IND             = "@C036_PEER_REV_IND";
  public static final String  LY36_BKR_CNTCT                = "@C036_BKR_CNTCT";
  public static final String  LY36_BKR_CNTCT_PHONE          = "@C036_BKR_CNTCT_PHONE";
  public static final String  LY36_BKR_REF_1                = "@C036_BKR_REF_1";
  public static final String  LY36_BKR_REF_2                = "@C036_BKR_REF_2";
  public static final String  LY36_BROKER_UCR               = "@C036_BROKER_UCR";
  public static final String  LY36_ORIG_INSURED             = "@C036_ORIG_INSURED";
  public static final String  LY36_INSURED                  = "@C036_INSURED";
  public static final String  LY36_REINSURED                = "@C036_REINSURED";
  public static final String  LY36_COVER_HOLDER             = "@C036_COVER_HOLDER";
  public static final String  LY36_CLAIMANT                 = "@C036_CLAIMANT";
  public static final String  LY36_OTHER_NAME               = "@C036_OTHER_NAME";
  public static final String  LY36_LOSS_NAME                = "@C036_LOSS_NAME";
  public static final String  LY36_VESSEL_AIRCRAFT          = "@C036_VESSEL_AIRCRAFT";
  public static final String  LY36_LOSS_DATE_FROM           = "@C036_LOSS_DATE_FROM";
  public static final String  LY36_LOSS_DATE_TO             = "@C036_LOSS_DATE_TO";
  public static final String  LY36_LOSS_DATE_QUAL           = "@C036_LOSS_DATE_QUAL";
  public static final String  LY36_LOSS_DATE_NARR           = "@C036_LOSS_DATE_NARR";
  public static final String  LY36_DCM_DOD_FROM             = "@C036_DCM_DOD_FROM";
  public static final String  LY36_DCM_DOD_TO               = "@C036_DCM_DOD_TO";
  public static final String  LY36_DCM_DOD_QUAL             = "@C036_DCM_DOD_QUAL";
  public static final String  LY36_LOSS_LOCATION            = "@C036_LOSS_LOCATION";
  public static final String  LY36_VOYAGE                   = "@C036_VOYAGE";
  public static final String  LY36_CAT_CODE                 = "@C036_CAT_CODE";
  public static final String  LY36_PCS_CAT_CODE             = "@C036_PCS_CAT_CODE";
  public static final String  LY36_CLM_RISK_TYPE            = "@C036_CLM_RISK_TYPE";
  public static final String  LY36_LOSS_DETAILS             = "@C036_LOSS_DETAILS";
  public static final String  LY36_ADJUSTER_NAME            = "@C036_ADJUSTER_NAME";
  public static final String  LY36_ADJUSTER_REF             = "@C036_ADJUSTER_REF";
  public static final String  LY36_LAWYER_NAME              = "@C036_LAWYER_NAME";
  public static final String  LY36_LAWYER_REF               = "@C036_LAWYER_REF";
  public static final String  LY36_CAUSE_CODE               = "@C036_CAUSE_CODE";

  public static final String  LY36_COI_TABLE                = "#C036_COI_TABLE[]";
  public static final String  LY36_CERT_INS_NO              = "@C036_CERT_INS_NO";

  // CCN 21 devo 15/01/2003
  public static final String  LY36_CH_CLM_REF               = "@C036_CH_CLM_REF";


  // LY37 input keys
  public static final String LY37SessionIDField             = "@C037_SESSION_NO";

  // LY37 output keys
  public static final String LY37_SCREEN_MODE               = "@C037_SCREEN_MODE";
  public static final String LY37_FIELD_VALUES              = "#C037_FIELD_VALUES[]";
  public static final String LY37_XCR                       = "@C037_XCR";
  public static final String LY37_UCR                       = "@C037_UCR";
  public static final String LY37_TR                        = "@C037_TR";
  public static final String LY37_ORIG_REF_1                = "@C037_ORIG_REF_1";
  public static final String LY37_ORIG_REF_2                = "@C037_ORIG_REF_2";
  public static final String LY37_ORIG_REF_3                = "@C037_ORIG_REF_3";
  public static final String LY37_ORIG_BKR                  = "@C037_ORIG_BKR";
  public static final String LY37_SIGNED_IND                = "@C037_SIGNED_IND";
  public static final String LY37_PEER_REV_IND              = "@C037_PEER_REV_IND";
  public static final String LY37_PAYEE_BKR_CODE            = "@C037_PAYEE_BKR_CODE";
  public static final String LY37_PAYEE_BKR_PSEUD           = "@C037_PAYEE_BKR_PSEUD";
  public static final String LY37_REDENOM_IND               = "@C037_REDENOM_IND";
  public static final String LY37_ORIG_CURR                 = "@C037_ORIG_CURR";
  public static final String LY37_SETT_CURR                 = "@C037_SETT_CURR";
  public static final String LY37_SETT_IND                  = "@C037_SETT_IND";
  public static final String LY37_EXCH_RATE                 = "@C037_EXCH_RATE";
  public static final String LY37_PAYED_TO_DATE             = "@C037_PAYED_TO_DATE";
  public static final String LY37_PAYED_THIS_TIME           = "@C037_PAYED_THIS_TIME";
  public static final String LY37_OUTST_AMT                 = "@C037_OUTST_AMT";
  public static final String LY37_OUTST_QUAL                = "@C037_OUTST_QUAL";
  public static final String LY37_CLAIM_AMT_SETT            = "@C037_CLAIM_AMT_SETT";
  public static final String LY37_TOTAL_LINE                = "@C037_TOTAL_LINE";
  public static final String LY37_BUR_PROP_AMT              = "@C037_BUR_PROP_AMT";
  public static final String LY37_HPC_VAT_AMT               = "@C037_HPC_VAT_AMT";
  public static final String LY37_WAR_AMT                   = "@C037_WAR_AMT";
  public static final String LY37_INCURRED_AMT              = "@C037_INCURRED_AMT";
  
  public static final String LY37_BKR_TR      			    = "@C037_BKR_TR";    //SIR:150695 -ECF Phase 6 changes 
  public static final String LY37_BKR_TR_QUAL            	= "@C037_BKR_TR_QL"; //SIR:150695 -ECF Phase 6 changes 
  
  
  //Binder changes to include cash loss_ind, indv_ucr,indv_tr
 
  public static final String LY37_INDV_UCR      			= "@C037_INDV_UCR";    
  public static final String LY37_INDV_UCR_ATTR            	= "@C037_INDV_UCR_ATTR";   
  public static final String LY37_INDV_TR      			    = "@C037_INDV_TR";    
  public static final String LY37_INDV_TR_ATTR            	= "@C037_INDV_TR_ATTR"; 
  
  /* Removed PREV_AMT_SETT for CCN #41
  public static final String LY37_PREV_AMT_SETT             = "@C037_PREV_AMT_SETT";
  */
  public static final String LY37_FIELD_ATTRIBUTES          = "#C037_FIELD_ATTRIBUTES[]";
  public static final String LY37_XCR_ATTR                  = "@C037_XCR_ATTR";
  public static final String LY37_UCR_ATTR                  = "@C037_UCR_ATTR";
  public static final String LY37_TR_ATTR                   = "@C037_TR_ATTR";
  public static final String LY37_ORIG_REF_ATTR1            = "@C037_ORIG_REF_ATTR1";
  public static final String LY37_ORIG_REF_ATTR2            = "@C037_ORIG_REF_ATTR2";
  public static final String LY37_ORIG_REF_ATTR3            = "@C037_ORIG_REF_ATTR3";
  public static final String LY37_ORIG_BKR_ATTR             = "@C037_ORIG_BKR_ATTR";
  public static final String LY37_SIGN_IND_ATTR             = "@C037_SIGN_IND_ATTR";
  public static final String LY37_PEER_REV_ATTR             = "@C037_PEER_REV_ATTR";
  public static final String LY37_PAYEE_BKR_ATTR            = "@C037_PAYEE_BKR_ATTR";
  public static final String LY37_PAY_BKR_PSD_ATTR          = "@C037_PAY_BKR_PSD_ATTR";
  public static final String LY37_REDENOM_ATTR              = "@C037_REDENOM_ATTR";
  public static final String LY37_ORIG_CURR_ATTR            = "@C037_ORIG_CURR_ATTR";
  public static final String LY37_SETT_CURR_ATTR            = "@C037_SETT_CURR_ATTR";
  public static final String LY37_SETT_IND_ATTR             = "@C037_SETT_IND_ATTR";
  public static final String LY37_EXCH_RATE_ATTR            = "@C037_EXCH_RATE_ATTR";
  public static final String LY37_PTD_ATTR                  = "@C037_PTD_ATTR";
  public static final String LY37_PTT_ATTR                  = "@C037_PTT_ATTR";
  public static final String LY37_OUTST_AMT_ATTR            = "@C037_OUTST_AMT_ATTR";
  public static final String LY37_OUTST_QUAL_ATTR           = "@C037_OUTST_QUAL_ATTR";
  public static final String LY37_CLM_AMT_SETT_ATTR         = "@C037_CLM_AMT_SETT_ATTR";
  public static final String LY37_TOTAL_LINE_ATTR           = "@C037_TOTAL_LINE_ATTR";
  public static final String LY37_BUR_PROP_ATTR             = "@C037_BUR_PROP_ATTR";
  public static final String LY37_VAT_AMT_ATTR              = "@C037_VAT_AMT_ATTR";
  public static final String LY37_WAR_AMT_ATTR              = "@C037_WAR_AMT_ATTR";
  public static final String LY37_INCURRED_ATTR             = "@C037_INCURRED_ATTR";
  
  public static final String LY37_BKR_TR_ATTR             	= "@C037_BKR_TR_ATTR"; 		//SIR:150695 -ECF Phase 6 changes
  public static final String LY37_BKR_TR_QUAL_ATTR          = "@C037_BKR_TR_QL_ATTR";   //SIR:150695 -ECF Phase 6 changes 
  
  /* Removed PREV_SETT_ATTR for CCN #41
  public static final String LY37_PREV_SETT_ATTR            = "@C037_PREV_SETT_ATTR";
  */
  // LY37 input keys
  public static final String LY39SessionIDField             = "@C039_SESSION_NO";

  // LY38 input keys
  public static final String LY38_SESSION_NO_Field          = "@C038_SESSION_NO";
  public static final String LY38_FIELD_VALUES_Table        = "#C038_FIELD_VALUES[]";
  public static final String LY38_PAYEE_BKR_CODE_Field      = "@C038_PAYEE_BKR_CODE";
  public static final String LY38_PAYEE_BKR_PSEUD_Field     = "@C038_PAYEE_BKR_PSEUD";
  public static final String LY38_REDENOM_IND_Field         = "@C038_REDENOM_IND";
  public static final String LY38_ORIG_CURR_Field           = "@C038_ORIG_CURR";
  public static final String LY38_SETT_CURR_Field           = "@C038_SETT_CURR";
  public static final String LY38_SETT_IND_Field            = "@C038_SETT_IND";
  public static final String LY38_EXCH_RATE_Field           = "@C038_EXCH_RATE";
  public static final String LY38_PAYED_TO_DATE_Field       = "@C038_PAYED_TO_DATE";
  public static final String LY38_PAYED_THIS_TIME_Field     = "@C038_PAYED_THIS_TIME";
  public static final String LY38_OUTST_AMT_Field           = "@C038_OUTST_AMT";
  public static final String LY38_OUTST_QUAL_Field          = "@C038_OUTST_QUAL";
  public static final String LY38_CLAIM_AMT_SETT_Field      = "@C038_CLAIM_AMT_SETT";
  public static final String LY38_TOTAL_LINE_Field          = "@C038_TOTAL_LINE";
  public static final String LY38_BUR_PROP_AMT_Field        = "@C038_BUR_PROP_AMT";
  public static final String LY38_HPC_VAT_AMT_Field         = "@C038_HPC_VAT_AMT";
  public static final String LY38_WAR_AMT_Field             = "@C038_WAR_AMT";
  public static final String LY38_INCURRED_AMT_Field        = "@C038_INCURRED_AMT";
  public static final String LY38_PREV_AMT_SETT_Field       = "@C038_PREV_AMT_SETT";
  public static final String LY38_PEER_REV_IND_Field        = "@C038_PEER_REV_IND";
  
  public static final String LY38_BKR_TR_Field      		= "@C038_BKR_TR";
  public static final String LY38_BKR_TR_QL_Field      		= "@C038_BKR_TR_QL";
  
  //Binders fields
  

  public static final String LY38_INDV_UCR      			= "@C038_INDV_UCR";
  public static final String LY38_INDV_TR      				= "@C038_INDV_TR";
 

  // LY38 output keys
  public static final String LY38_FIELD_ERRORS              = "#C038_FIELD_ERRORS[]";
  public static final String LY38_PAYEE_BKR_ERR             = "@C038_PAYEE_BKR_ERR";
  public static final String LY38_PAY_BKR_PSD_ERR           = "@C038_PAY_BKR_PSD_ERR";
  public static final String LY38_REDENOM_ERR               = "@C038_REDENOM_ERR";
  public static final String LY38_PEER_REV_ERR              = "@C038_PEER_REV_ERR";
  public static final String LY38_ORIG_CURR_ERR             = "@C038_ORIG_CURR_ERR";
  public static final String LY38_SETT_CURR_ERR             = "@C038_SETT_CURR_ERR";
  public static final String LY38_SETT_IND_ERR              = "@C038_SETT_IND_ERR";
  public static final String LY38_EXCH_RATE_ERR             = "@C038_EXCH_RATE_ERR";
  public static final String LY38_PTD_ERR                   = "@C038_PTD_ERR";
  public static final String LY38_PTT_ERR                   = "@C038_PTT_ERR";
  public static final String LY38_OUTST_AMT_ERR             = "@C038_OUTST_AMT_ERR";
  public static final String LY38_OUTST_QUAL_ERR            = "@C038_OUTST_QUAL_ERR";
  public static final String LY38_CLM_AMT_SETT_ERR          = "@C038_CLM_AMT_SETT_ERR";
  public static final String LY38_TOTAL_LINE_ERR            = "@C038_TOTAL_LINE_ERR";
  public static final String LY38_BUR_PROP_ERR              = "@C038_BUR_PROP_ERR";
  public static final String LY38_VAT_AMT_ERR               = "@C038_VAT_AMT_ERR";
  public static final String LY38_WAR_AMT_ERR               = "@C038_WAR_AMT_ERR";
  public static final String LY38_INCURRED_ERR              = "@C038_INCURRED_ERR";
  public static final String LY38_PREV_SETT_ERR             = "@C038_PREV_SETT_ERR";
  
  public static final String LY38_BKR_TR_ERR                = "@C038_BKR_TR_ERR";
  public static final String LY38_BKR_TR_QUAL_ERR           = "@C038_BKR_TR_QL_ERR";
  
  //Binders fields 
 
  public static final String LY38_INDV_UCR_ERR           	= "@C038_INDV_UCR_ERR";
  public static final String LY38_INDV_TR_ERR          		= "@C038_INDV_TR_ERR";
  // LY39 output keys
  public static final String LY39_SCREEN_MODE               = "@C039_SCREEN_MODE";
  public static final String LY39_FIELD_VALUES              = "#C039_FIELD_VALUES[]";
  public static final String LY39_SESSION_NO                = "@C039_SESSION_NO";
  public static final String LY39_XCR                       = "@C039_XCR";
  public static final String LY39_UCR                       = "@C039_UCR";
  public static final String LY39_TR                        = "@C039_TR";
  public static final String LY39_ORIG_REF_1                = "@C039_ORIG_REF_1";
  public static final String LY39_ORIG_REF_2                = "@C039_ORIG_REF_2";
  public static final String LY39_ORIG_REF_3                = "@C039_ORIG_REF_3";
  public static final String LY39_ORIG_BKR                  = "@C039_ORIG_BKR";
  public static final String LY39_SIGNED_IND                = "@C039_SIGNED_IND";
  public static final String LY39_PEER_REV_IND              = "@C039_PEER_REV_IND";
  public static final String LY39_PAYEE_BKR_CODE            = "@C039_PAYEE_BKR_CODE";
  public static final String LY39_PAYEE_BKR_PSEUD           = "@C039_PAYEE_BKR_PSEUD";
  public static final String LY39_REDENOM_IND               = "@C039_REDENOM_IND";
  public static final String LY39_ORIG_CURR                 = "@C039_ORIG_CURR";
  public static final String LY39_SETT_CURR                 = "@C039_SETT_CURR";
  public static final String LY39_SETT_IND                  = "@C039_SETT_IND";
  public static final String LY39_EXCH_RATE                 = "@C039_EXCH_RATE";
  public static final String LY39_PAYED_TO_DATE             = "@C039_PAYED_TO_DATE";
  public static final String LY39_PAYED_THIS_TIME           = "@C039_PAYED_THIS_TIME";
  public static final String LY39_OUTST_AMT                 = "@C039_OUTST_AMT";
  public static final String LY39_OUTST_QUAL                = "@C039_OUTST_QUAL";
  public static final String LY39_CLAIM_AMT_SETT            = "@C039_CLAIM_AMT_SETT";
  public static final String LY39_TOTAL_LINE                = "@C039_TOTAL_LINE";
  public static final String LY39_BUR_PROP_AMT              = "@C039_BUR_PROP_AMT";
  public static final String LY39_HPC_VAT_AMT               = "@C039_HPC_VAT_AMT";
  public static final String LY39_WAR_AMT                   = "@C039_WAR_AMT";
  public static final String LY39_INCURRED_AMT              = "@C039_INCURRED_AMT";
  
  public static final String LY39_BKR_TR             		= "@C039_BKR_TR";
  public static final String LY39_BKR_TR_QUAL             	= "@C039_BKR_TR_QL";
  
 
  public static final String LY39_INDV_UCR      			= "@C039_INDV_UCR";
  public static final String LY39_INDV_TR      				= "@C039_INDV_TR";

  // LY40 input keys
  public static final String LY40SessionIDField             = "@C040_SESSION_NO";

  // LY40 output keys
  public static final String LY40_SCREEN_MODE_Field    = "@C040_SCREEN_MODE";

  public static final String LY40_FIELD_VALUES         = "#C040_FIELD_VALUES[]";
  public static final String LY40_XCR_Field            = "@C040_XCR";
  public static final String LY40_UCR_Field            = "@C040_UCR";
  public static final String LY40_TR_Field             = "@C040_TR";
  public static final String LY40_ORIG_REF_Field       = "@C040_ORIG_REF";
  public static final String LY40_ORIG_BKR_Field       = "@C040_ORIG_BKR";
  public static final String LY40_SIGNED_IND_Field     = "@C040_SIGNED_IND";
  public static final String LY40_PEER_REV_IND_Field   = "@C040_PEER_REV_IND";
  public static final String LY40_ORIG_CURR_Field      = "@C040_ORIG_CURR";
  public static final String LY40_COR_Field            = "@C040_COR";
  public static final String LY40_LOC_IND_Field        = "@C040_LOC_IND";
  public static final String LY40_MOVE_REF_Field       = "@C040_MOVE_REF";
  public static final String LY40_LR_ADJ_DATE_Field    = "@C040_LR_ADJ_DATE";
  public static final String LY40_LR_REFUNDED_Field    = "@C040_LR_REFUNDED";
  public static final String LY40_LR_PAID_CLAIM_Field  = "@C040_LR_PAID_CLAIM";
  public static final String LY40_LR_ADVANCED_Field    = "@C040_LR_ADVANCED";
  public static final String LY40_LR_INTEREST_Field    = "@C040_LR_INTEREST";
  public static final String LY40_LR_TAX_Field         = "@C040_LR_TAX";
  public static final String LY40_LR_NET_AMT_Field     = "@C040_LR_NET_AMT";
  public static final String LY40_LR_OUTST_AMT_Field   = "@C040_LR_OUTST_AMT";
  public static final String LY40_LR_OUTST_QUAL_Field  = "@C040_LR_OUTST_QUAL";

  public static final String LY40_FIELD_ATTR_VALUES        = "#C040_FIELD_ATTRIBUTES[]";
  public static final String LY40_XCR_ATTR_Field            = "@C040_XCR_ATTR";
  public static final String LY40_UCR_ATTR_Field            = "@C040_UCR_ATTR";
  public static final String LY40_TR_ATTR_Field             = "@C040_TR_ATTR";
  public static final String LY40_ORIG_REF_ATTR_Field       = "@C040_ORIG_REF_ATTR";
  public static final String LY40_ORIG_BKR_ATTR_Field       = "@C040_ORIG_BKR_ATTR";
  public static final String LY40_SIGNED_IND_ATTR_Field     = "@C040_SIGN_IND_ATTR";
  public static final String LY40_PEER_REV_IND_ATTR_Field   = "@C040_PEER_REV_ATTR";
  public static final String LY40_ORIG_CURR_ATTR_Field      = "@C040_ORIG_CURR_ATTR";
  public static final String LY40_COR_ATTR_Field            = "@C040_COR_ATTR";
  public static final String LY40_LOC_IND_ATTR_Field        = "@C040_LOC_IND_ATTR";
  public static final String LY40_MOVE_REF_ATTR_Field       = "@C040_MOVE_REF_ATTR";
  public static final String LY40_LR_ADJ_DATE_ATTR_Field    = "@C040_LR_ADJ_DATE_ATTR";
  public static final String LY40_LR_REFUNDED_ATTR_Field    = "@C040_LR_REFUNDED_ATTR";
  public static final String LY40_LR_PAID_CLAIM_ATTR_Field  = "@C040_LR_PAID_CLAIM_ATTR";
  public static final String LY40_LR_ADVANCED_ATTR_Field    = "@C040_LR_ADVANCED_ATTR";
  public static final String LY40_LR_INTEREST_ATTR_Field    = "@C040_LR_INTEREST_ATTR";
  public static final String LY40_LR_TAX_ATTR_Field         = "@C040_LR_TAX_ATTR";
  public static final String LY40_LR_NET_AMT_ATTR_Field     = "@C040_LR_NET_AMT_ATTR";
  public static final String LY40_LR_OUTST_AMT_ATTR_Field   = "@C040_LR_OUTST_AMT_ATTR";
  public static final String LY40_LR_OUTST_QUAL_ATTR_Field  = "@C040_LR_OUTST_QUAL_ATTR";

  public static final String LY40_COMMAND_ATTRIBUTES        = "#C040_COMMAND_ATTRIBUTES[]";
  public static final String LY40_NEW_MOVE_ATTR             = "@C040_NEW_MOVE_ATTR";


  // LY41 input keys
  public static final String LY41_SESSION_NO                = "@C041_SESSION_NO";
  public static final String LY41_FIELD_VALUES              = "#C041_FIELD_VALUES[]";
  public static final String LY41_XCR                       = "@C041_XCR";
  public static final String LY41_UCR                       = "@C041_UCR";
  public static final String LY41_TR                        = "@C041_TR";
  public static final String LY41_ORIG_REF                  = "@C041_ORIG_REF";
  public static final String LY41_ORIG_BKR                  = "@C041_ORIG_BKR";
  public static final String LY41_SIGNED_IND                = "@C041_SIGNED_IND";
  public static final String LY41_PEER_REV_IND              = "@C041_PEER_REV_IND";
  public static final String LY41_ORIG_CURR                 = "@C041_ORIG_CURR";
  public static final String LY41_COR                       = "@C041_COR";
  public static final String LY41_LOC_IND                   = "@C041_LOC_IND";
  public static final String LY41_MOVE_REF                  = "@C041_MOVE_REF";
  public static final String LY41_LR_ADJ_DATE               = "@C041_LR_ADJ_DATE";
  public static final String LY41_LR_REFUNDED               = "@C041_LR_REFUNDED";
  public static final String LY41_LR_PAID_CLAIM             = "@C041_LR_PAID_CLAIM";
  public static final String LY41_LR_ADVANCED               = "@C041_LR_ADVANCED";
  public static final String LY41_LR_INTEREST               = "@C041_LR_INTEREST";
  public static final String LY41_LR_TAX                    = "@C041_LR_TAX";
  public static final String LY41_LR_NET_AMT                = "@C041_LR_NET_AMT";
  public static final String LY41_LR_OUTST_AMT              = "@C041_LR_OUTST_AMT";
  public static final String LY41_LR_OUTST_QUAL             = "@C041_LR_OUTST_QUAL";

  // LY41 output keys
  public static final String LY41_FIELD_VALUES_OUTPUT  = "#C041_FIELD_VALUES[]";
  public static final String LY41_XCR_Field            = "@C041_XCR";
  public static final String LY41_UCR_Field            = "@C041_UCR";
  public static final String LY41_TR_Field             = "@C041_TR";
  public static final String LY41_ORIG_REF_Field       = "@C041_ORIG_REF";
  public static final String LY41_ORIG_BKR_Field       = "@C041_ORIG_BKR";
  public static final String LY41_SIGNED_IND_Field     = "@C041_SIGNED_IND";
  public static final String LY41_PEER_REV_IND_Field   = "@C041_PEER_REV_IND";
  public static final String LY41_ORIG_CURR_Field      = "@C041_ORIG_CURR";
  public static final String LY41_COR_Field            = "@C041_COR";
  public static final String LY41_LOC_IND_Field        = "@C041_LOC_IND";
  public static final String LY41_MOVE_REF_Field       = "@C041_MOVE_REF";
  public static final String LY41_LR_ADJ_DATE_Field    = "@C041_LR_ADJ_DATE";
  public static final String LY41_LR_REFUNDED_Field    = "@C041_LR_REFUNDED";
  public static final String LY41_LR_PAID_CLAIM_Field  = "@C041_LR_PAID_CLAIM";
  public static final String LY41_LR_ADVANCED_Field    = "@C041_LR_ADVANCED";
  public static final String LY41_LR_INTEREST_Field    = "@C041_LR_INTEREST";
  public static final String LY41_LR_TAX_Field         = "@C041_LR_TAX";
  public static final String LY41_LR_NET_AMT_Field     = "@C041_LR_NET_AMT";
  public static final String LY41_LR_OUTST_AMT_Field   = "@C041_LR_OUTST_AMT";
  public static final String LY41_LR_OUTST_QUAL_Field  = "@C041_LR_OUTST_QUAL";

  public static final String LY41_FIELD_ERRORS         = "#C041_FIELD_ERRORS[]";

  // LY42 input keys
  public static final String LY42_SESSION_NO                = "@C042_SESSION_NO";
  public static final String LY42_FIELD_VALUES              = "#C042_FIELD_VALUES[]";
  public static final String LY42_XCR                       = "@C042_XCR";
  public static final String LY42_UCR                       = "@C042_UCR";
  public static final String LY42_TR                        = "@C042_TR";
  public static final String LY42_ORIG_REF                  = "@C042_ORIG_REF";
  public static final String LY42_ORIG_BKR                  = "@C042_ORIG_BKR";
  public static final String LY42_SIGNED_IND                = "@C042_SIGNED_IND";
  public static final String LY42_PEER_REV_IND              = "@C042_PEER_REV_IND";
  public static final String LY42_ORIG_CURR                 = "@C042_ORIG_CURR";
  public static final String LY42_COR                       = "@C042_COR";
  public static final String LY42_LOC_IND                   = "@C042_LOC_IND";
  public static final String LY42_MOVE_REF                  = "@C042_MOVE_REF";
  public static final String LY42_LR_ADJ_DATE               = "@C042_LR_ADJ_DATE";
  public static final String LY42_LR_REFUNDED               = "@C042_LR_REFUNDED";
  public static final String LY42_LR_PAID_CLAIM             = "@C042_LR_PAID_CLAIM";
  public static final String LY42_LR_ADVANCED               = "@C042_LR_ADVANCED";
  public static final String LY42_LR_INTEREST               = "@C042_LR_INTEREST";
  public static final String LY42_LR_TAX                    = "@C042_LR_TAX";
  public static final String LY42_LR_NET_AMT                = "@C042_LR_NET_AMT";
  public static final String LY42_LR_OUTST_AMT              = "@C042_LR_OUTST_AMT";
  public static final String LY42_LR_OUTST_QUAL             = "@C042_LR_OUTST_QUAL";

  // LY43 input keys
  public static final String LY43_SESSION_NO                = "@C043_SESSION_NO";

  // LY43 output keys
  public static final String LY43_FIELD_VALUES                ="#C043_FIELD_VALUES[]" ;
  public static final String LY43_XCR                         ="@C043_XCR";
  public static final String LY43_UCR                         ="@C043_UCR";
  public static final String LY43_TR                          ="@C043_TR";
  public static final String LY43_ORIG_REF                    ="@C043_ORIG_REF";
  public static final String LY43_ORIG_BKR                    ="@C043_ORIG_BKR";
  public static final String LY43_SIGNED_IND                  ="@C043_SIGNED_IND";
  public static final String LY43_PEER_REV_IND                ="@C043_PEER_REV_IND";
  public static final String LY43_ORIG_CURR_HDR               ="@C043_ORIG_CURR_HDR";
  public static final String LY43_COR                         ="@C043_COR";
  public static final String LY43_LOC_IND                     ="@C043_LOC_IND";
  public static final String LY43_PAYEE_BKR_CODE              ="@C043_PAYEE_BKR_CODE";
  public static final String LY43_REDENOM_IND                 ="@C043_REDENOM_IND";
  public static final String LY43_MOVE_REF                    ="@C043_MOVE_REF";
  public static final String LY43_CLM_REF_REC                 ="@C043_CLM_REF_REC";
  public static final String LY43_ORIG_CURR                   ="@C043_ORIG_CURR";
  public static final String LY43_SETT_CURR                   ="@C043_SETT_CURR";
  public static final String LY43_EXCH_RATE                   ="@C043_EXCH_RATE";
  public static final String LY43_PTD_LOSS                    ="@C043_PTD_LOSS";
  public static final String LY43_PTD_EXP                     ="@C043_PTD_EXP";
  public static final String LY43_PTD_FEE                     ="@C043_PTD_FEE";
  public static final String LY43_PTD_TOTAL                   ="@C043_PTD_TOTAL";
  public static final String LY43_PTT_LOSS                    ="@C043_PTT_LOSS";
  public static final String LY43_PTT_EXP                     ="@C043_PTT_EXP";
  public static final String LY43_PTT_FEE                     ="@C043_PTT_FEE";
  public static final String LY43_PTT_TOTAL                   ="@C043_PTT_TOTAL";
  public static final String LY43_OUTST_LOSS                  ="@C043_OUTST_LOSS";
  public static final String LY43_OUTST_LOSS_QUAL             ="@C043_OUTST_LOSS_QUAL";
  public static final String LY43_OUTST_EXP                   ="@C043_OUTST_EXP";
  public static final String LY43_OUTST_FEE                   ="@C043_OUTST_FEE";
  public static final String LY43_OUTST_FEE_QUAL              ="@C043_OUTST_FEE_QUAL";
  public static final String LY43_OUTST_TOT                   ="@C043_OUTST_TOT";
  public static final String LY43_OUTST_TOT_QUAL              ="@C043_OUTST_TOT_QUAL";
  public static final String LY43_PTD_SETT_AMT                ="@C043_PTD_SETT_AMT";
  public static final String LY43_CLAIM_AMT_SETT              ="@C043_CLAIM_AMT_SETT";
  public static final String LY43_BUREAU_LINE                 ="@C043_BUREAU_LINE";
  public static final String LY43_BUR_PROP_AMT                ="@C043_BUR_PROP_AMT";
  public static final String LY43_HPC_VAT_AMT                 ="@C043_HPC_VAT_AMT";
  public static final String LY43_VAT_RATE_TABLE              ="#C043_VAT_RATE_TABLE[]";
  public static final String LY43_VAT_RATE                    ="@C043_VAT_RATE";
  public static final String LY43_VAT_AMT                     ="@C043_VAT_AMT";
  public static final String LY43_WAR_AMT                     ="@C043_WAR_AMT";
  public static final String LY43_NARR_CODE_1                 ="@C043_NARR_CODE_1";
  public static final String LY43_NARR_CODE_2                 ="@C043_NARR_CODE_2";
  public static final String LY43_SETT_NARR_1                 ="@C043_SETT_NARR_1";
  public static final String LY43_SETT_NARR_2                 ="@C043_SETT_NARR_2";
  public static final String LY43_SETT_NARR_3                 ="@C043_SETT_NARR_3";
  public static final String LY43_SUBROGATION                 ="@C043_SUBROGATION";
  public static final String LY43_XCS_REC_REF                 ="@C043_XCS_REC_REF";
  public static final String LY43_HIGHEST_EST                 ="@C043_HIGHEST_EST";
  public static final String LY43_INCURRED_AMT                ="@C043_INCURRED_AMT";
  public static final String LY43_RATE_EXCH_OUTST             ="@C043_RATE_EXCH_OUTST";
  public static final String LY43_FINDER_CODE_1               ="@C043_FINDER_CODE_1";
  public static final String LY43_FINDER_CODE_2               ="@C043_FINDER_CODE_2";
  public static final String LY43_FINDER_CODE_3               ="@C043_FINDER_CODE_3";
  public static final String LY43_ATTACHMENT_IND              ="@C043_ATTACHMENT_IND";
  public static final String LY43_CASH_COR                    ="@C043_CASH_COR";
  public static final String LY43_BKR_CNTCT                   ="@C043_BKR_CNTCT";
  public static final String LY43_BKR_CNTCT_PHONE             ="@C043_BKR_CNTCT_PHONE";
  public static final String LY43_CLM_BKR_REF_1               ="@C043_CLM_BKR_REF_1";
  public static final String LY43_CLM_BKR_REF_2               ="@C043_CLM_BKR_REF_2";
  public static final String LY43_BKR_REF_1                   ="@C043_BKR_REF_1";
  public static final String LY43_BKR_REF_2                   ="@C043_BKR_REF_2";
  public static final String LY43_CNTRY_OF_ORIGIN             ="@C043_CNTRY_OF_ORIGIN";
  public static final String LY43_ORIG_INSURED                ="@C043_ORIG_INSURED";
  public static final String LY43_INSURED                     ="@C043_INSURED";
  public static final String LY43_REINSURED                   ="@C043_REINSURED";
  public static final String LY43_COVER_HOLDER                ="@C043_COVER_HOLDER";
  public static final String LY43_CLAIMANT                    ="@C043_CLAIMANT";
   
  public static final String LY43_VESSEL_AIRCRAFT             ="@C043_VESSEL_AIRCRAFT";
  public static final String LY43_SLIP_TYPE_DESC              ="@C043_SLIP_TYPE_DESC";       //C043_SLIP_TYPE_DESC     // added for CR7
  public static final String LY43_OTHER_NAME                  ="@C043_OTHER_NAME";
  public static final String LY43_POL_CERT_FROM               ="@C043_POL_CERT_FROM";
  public static final String LY43_POL_CERT_TO                 ="@C043_POL_CERT_TO";
  public static final String LY43_POL_CERT_QUAL               ="@C043_POL_CERT_QUAL";
  public static final String LY43_LOSS_DATE_FROM              ="@C043_LOSS_DATE_FROM";
  public static final String LY43_LOSS_DATE_TO                ="@C043_LOSS_DATE_TO";
  public static final String LY43_LOSS_DATE_QUAL              ="@C043_LOSS_DATE_QUAL";
  public static final String LY43_LOSS_DATE_NARR              ="@C043_LOSS_DATE_NARR";
  public static final String LY43_CLAIM_DATE_FROM             ="@C043_CLAIM_DATE_FROM";
  public static final String LY43_CLAIM_DATE_TO               ="@C043_CLAIM_DATE_TO";
  public static final String LY43_CLAIM_DATE_QUAL             ="@C043_CLAIM_DATE_QUAL";
  public static final String LY43_CAT_CODE                    ="@C043_CAT_CODE";
  public static final String LY43_PCS_CAT_CODE                ="@C043_PCS_CAT_CODE";
  public static final String LY43_LIMIT_CURR                  ="@C043_LIMIT_CURR";
  public static final String LY43_SI_LIMIT                    ="@C043_SI_LIMIT";
  public static final String LY43_EXCESS_AMT                  ="@C043_EXCESS_AMT";
  public static final String LY43_PERILS_CONDS                ="@C043_PERILS_CONDS";
  public static final String LY43_LOSS_LOCATION               ="@C043_LOSS_LOCATION";
  public static final String LY43_VOYAGE                      ="@C043_VOYAGE";
  public static final String LY43_LOSS_NAME                   ="@C043_LOSS_NAME";
  public static final String LY43_CLAIM_DETAILS               ="#C043_CLAIM_DETAILS[]";
  public static final String LY43_CLAIM_DET_LINE              ="@C043_CLAIM_DET_LINE";
  public static final String LY43_LAWYER_NAME                 ="@C043_LAWYER_NAME";
  public static final String LY43_LAWYER_REF                  ="@C043_LAWYER_REF";
  public static final String LY43_LAWYER_CODE                 ="@C043_LAWYER_CODE";
  public static final String LY43_ADJUSTER_NAME               ="@C043_ADJUSTER_NAME";
  public static final String LY43_ADJUSTER_REF                ="@C043_ADJUSTER_REF";
  public static final String LY43_ADJUSTER_CODE               ="@C043_ADJUSTER_CODE";
  public static final String LY43_SCHEME_CODE                 ="@C043_SCHEME_CODE";
  public static final String LY43_TF_CODE                     ="@C043_TF_CODE";
  public static final String LY43_STATE_CODE                  ="@C043_STATE_CODE";
  public static final String LY43_NAIC_CODE                   ="@C043_NAIC_CODE";
  public static final String LY43_NAIC_QUAL                   ="@C043_NAIC_QUAL";
  public static final String LY43_WAR_IND                     ="@C043_WAR_IND";
  public static final String LY43_FIL_CODE_1                  ="@C043_FIL_CODE_1";
  public static final String LY43_FIL_CODE_2                  ="@C043_FIL_CODE_2";
  public static final String LY43_OTHER_TF_CODE               ="@C043_OTHER_TF_CODE";
  public static final String LY43_DTI_CODE                    ="@C043_DTI_CODE";
  public static final String LY43_CAUSE_CODE_TABLE            ="#C043_CAUSE_CODE_TABLE[]";
  public static final String LY43_CAUSE_CODE                  ="@C043_CAUSE_CODE";
  public static final String LY43_USA_CAN_IND                 ="@C043_USA_CAN_IND" ;
  public static final String LY43_COUNTY_CODE                 ="@C043_COUNTY_CODE" ;
  // CCN #N0031 and N0021 - BA - 15/01/2003
  public static final String LY43_LF_ENTRY_IND                ="@C043_LF_ENTRY_IND";
  public static final String LY43_LF_ADVANCE_IND              ="@C043_LF_ADVANCE_IND" ;
  public static final String LY43_BLOCK_IND                   ="@C043_BLOCK_IND" ;
  
  //** SIR:150695 ECF Phase 6 changes start *****  
  public static final String LY43_DIRECT_REPORT_IND           ="@C043_DIRECT_REPORT_IND" ;
  public static final String LY43_LITIGATION_IND              ="@C043_LITIGATION_IND" ;
//TP866603 - Changes for adding new barcode field
  public static final String  LY43_BARCODE                    ="@C043_BARCODE";
  public static final String LY43_SERVICE_TYPE                ="@C043_SERVICE_TYPE";        // ADDED FOR CR8 - CLASS PH4
  //** SIR:150695 ECF Phase 6 changes end *****  

  // CR 1442 - D.Smith - 12/12/03
  public static final String LY43_CLM_OPT_OUT_STATUS          ="@C043_CLM_OPT_OUT_STATUS" ;
  public static final String LY43_CLM_OPT_OUT_DATE            ="@C043_CLM_OPT_OUT_DATE" ;


  // CCN s229       - September 2003   adding of new fields to create the new
  //                                    scm enquiry screen
  public static final String LY43_AP_REF                      ="@C043_AP_REF" ;
  public static final String LY43_YEAR_OF_ACC                 ="@C043_YEAR_OF_ACC" ;
  public static final String LY43_GROUP_REF                   ="@C043_GROUP_REF" ;
  public static final String LY43_UMR                         ="@C043_UMR" ;
  public static final String LY43_MKT_CODE                    ="@C043_MKT_CODE" ;
  public static final String LY43_COV_DATE_FROM               ="@C043_COV_DATE_FROM" ;
  public static final String LY43_COV_DATE_TO                 ="@C043_COV_DATE_TO" ;
  public static final String LY43_COV_QUAL                    ="@C043_COV_QUAL" ;
  public static final String LY43_PER_NARR                    ="@C043_PER_NARR" ;
  public static final String LY43_SLIP_ORD_1                  ="@C043_SLIP_ORD_1" ;
  public static final String LY43_SLIP_ORD_2                  ="@C043_SLIP_ORD_2" ;
  public static final String LY43_LIMIT_BASIS                 ="@C043_LIMIT_BASIS" ;
  public static final String LY43_SI_NARR                     ="@C043_SI_NARR" ;
  public static final String LY43_POLICY_NARR_TABLE           ="#C043_POLICY_NARR[]";
  public static final String LY43_POLICY_NARR_LINE            ="@C043_POL_NARR_LINE";

  public static final String LY43_RISK_CODE                   ="@C043_RISK_CODE";
  public static final String LY43_NO_SYNDS                    ="@C043_NO_SYNDS";
  public static final String LY43_MARKET_SOURCE               ="@C043_MARKET_SOURCE";
  public static final String LY43_MARKET_COUNT                ="@C043_MARKET_COUNT";
  public static final String LY43_MARKET_TABLE                ="#C043_MARKET_TABLE[]";
  public static final String LY43_CLAIM_LINE_NO               ="@C043_CLAIM_LINE_NO";
  public static final String LY43_COY_CODE                    ="@C043_COY_CODE";
  public static final String LY43_COY_LINE                    ="@C043_COY_LINE";
  public static final String LY43_COY_REF_1                   ="@C043_COY_REF_1";

  // CR 1442 - D.Smith - 12/12/03
  public static final String LY43_SY_OPT_OUT_STATUS           ="@C043_SY_OPT_OUT_STATUS" ;
  public static final String LY43_SY_OPT_OUT_DATE            ="@C043_SY_OPT_OUT_DATE" ;

  public static final String LY43_BUREAU_LEAD_IND             ="@C043_BUREAU_LEAD_IND";
  public static final String LY43_LLOYDS_CLAIM_TYPE           ="@C043_LLOYDS_CLAIM_TYPE";
  public static final String LY43_INTEREST                    ="@C043_INTEREST";
  public static final String LY43_LOC_VOYAGE                  ="@C043_LOC_VOYAGE";
  public static final String LY43_XCR_CLAIM_NARR              ="#C043_XCR_CLAIM_NARR[]";
  public static final String LY43_CLM_NARR_LINE               ="@C043_CLM_NARR_LINE";
  public static final String LY43_CHOLDER_CLM_REF             ="@C043_CHOLDER_CLM_REF";
  public static final String LY43_TRANS_SYNOPSIS              ="#C043_TRANS_SYNOPSIS[]";
  public static final String LY43_TRANS_SYNOPSIS_LINE         ="#C043_TRANS_SYNOPSIS_LINE[]";
  public static final String LY43_SYNOPSIS_TEXT   	          ="@C043_SYNOPSIS_TEXT";
  public static final String LY43_TDN_REF             	      ="@C043_TDN_REF";
  public static final String LY43_USER_ID             	      ="@C043_USER_ID";
  public static final String LY43_CHARGE_TYPE                 ="@C043_CHARGE_TYPE";

  /*Expert Fee Break Down function*/
  public static final String LY43_EXPERT_COUNT                ="@C043_EXPERT_COUNT";
  public static final String LY43_EXPERT_DETAILS              ="#C043_EXPERT_DETAILS[]";
  public static final String LY43_EXPERT_CODE                 ="@C043_EXPERT_CODE";
  public static final String LY43_EXPERT_TYPE                 ="@C043_EXPERT_TYPE";
  public static final String LY43_EXPERT_REF                  ="@C043_EXPERT_REF";
  public static final String LY43_EXPERT_SCM                  ="@C043_EXPERT_SCM";
  public static final String LY43_EXPERT_NAME                 ="@C043_EXPERT_NAME";
  public static final String LY43_EXPERT_CNTCT                ="@C043_EXPERT_CNTCT";
  public static final String LY43_EXPERT_PTD_EXP              ="@C043_EXPERT_PTD_EXP";
  public static final String LY43_EXPERT_PTD_FEE              ="@C043_EXPERT_PTD_FEE";
  public static final String LY43_EXPERT_PTT_EXP              ="@C043_EXPERT_PTT_EXP";
  public static final String LY43_EXPERT_PTT_FEE              ="@C043_EXPERT_PTT_FEE";
  public static final String LY43_EXPERT_OS_EXP               ="@C043_EXPERT_OS_EXP";
  public static final String LY43_EXPERT_OS_FEE               ="@C043_EXPERT_OS_FEE";



  public static final String LY43_FIELD_ATTRIBUTES            ="#C043_FIELD_ATTRIBUTES[]";
  public static final String LY43_XCR_ATTR                    ="@C043_XCR_ATTR";
  public static final String LY43_UCR_ATTR                    ="@C043_UCR_ATTR";
  public static final String LY43_TR_ATTR                     ="@C043_TR_ATTR";
  public static final String LY43_ORIG_REF_ATTR               ="@C043_ORIG_REF_ATTR";
  public static final String LY43_ORIG_BKR_HDR_ATTR           ="@C043_ORIG_BKR_HDR_ATTR";
  public static final String LY43_SIGN_IND_ATTR               ="@C043_SIGN_IND_ATTR";
  public static final String LY43_PEER_REV_ATTR               ="@C043_PEER_REV_ATTR";

  /** @todo  LY43_ORIG_CURR_HDR_ATTR is defined in the spec as LY43_ORIG_CURR_ATTR.
    LY43_ORIG_CURR_ATTR is a non-unique name that repeats later in the commarea.
    It has been assumed that LY43_ORIG_CURR_HDR_ATTR was intended as this would tie up
    with the field value definitions of LY43_ORIG_CURR_HDR and LY43_ORIG_CURR
    earlier in the commarea.
  */
  public static final String LY43_ORIG_CURR_HDR_ATTR          ="@C043_ORIG_CURR_ATTR";
  public static final String LY43_COR_ATTR                    ="@C043_COR_ATTR";
  public static final String LY43_LOC_IND_ATTR                ="@C043_LOC_IND_ATTR";
  public static final String LY43_PAYEE_BKR_ATTR              ="@C043_PAYEE_BKR_ATTR";
  public static final String LY43_REDENOM_ATTR                ="@C043_REDENOM_ATTR";
  public static final String LY43_MOVE_REF_ATTR               ="@C043_MOVE_REF_ATTR";
  public static final String LY43_CLM_REF_REC_ATTR            ="@C043_CLM_REF_REC_ATTR";
  public static final String LY43_ORIG_CURR_ATTR              ="@C043_ORIG_CURR_ATTR";
  public static final String LY43_SETT_CURR_ATTR              ="@C043_SETT_CURR_ATTR";
  public static final String LY43_EXCH_RATE_ATTR              ="@C043_EXCH_RATE_ATTR";
  public static final String LY43_PTD_LOSS_ATTR               ="@C043_PTD_LOSS_ATTR";
  public static final String LY43_PTD_EXP_ATTR                ="@C043_PTD_EXP_ATTR";
  public static final String LY43_PTD_FEE_ATTR                ="@C043_PTD_FEE_ATTR";
  public static final String LY43_PTD_TOTAL_ATTR              ="@C043_PTD_TOTAL_ATTR";
  public static final String LY43_PTT_LOSS_ATTR               ="@C043_PTT_LOSS_ATTR";
  public static final String LY43_PTT_EXP_ATTR                ="@C043_PTT_EXP_ATTR";
  public static final String LY43_PTT_FEE_ATTR                ="@C043_PTT_FEE_ATTR";
  public static final String LY43_PTT_TOTAL_ATTR              ="@C043_PTT_TOTAL_ATTR";
  public static final String LY43_OUTST_LOSS_ATTR             ="@C043_OUTST_LOSS_ATTR";
  public static final String LY43_OUT_LOSS_Q_ATTR             ="@C043_OUT_LOSS_Q_ATTR";
  public static final String LY43_OUTST_EXP_ATTR              ="@C043_OUTST_EXP_ATTR";
  public static final String LY43_OUTST_FEE_ATTR              ="@C043_OUTST_FEE_ATTR";
  public static final String LY43_OUT_FEE_Q_ATTR              ="@C043_OUT_FEE_Q_ATTR";
  public static final String LY43_OUTST_TOT_ATTR              ="@C043_OUTST_TOT_ATTR";
  public static final String LY43_OUT_TOT_Q_ATTR              ="@C043_OUT_TOT_Q_ATTR";
  public static final String LY43_PTD_SETT_ATTR               ="@C043_PTD_SETT_ATTR";
  public static final String LY43_SETT_AMT_ATTR               ="@C043_SETT_AMT_ATTR";
  public static final String LY43_BUR_LINE_ATTR               ="@C043_BUR_LINE_ATTR";
  public static final String LY43_BUR_PROP_ATTR               ="@C043_BUR_PROP_ATTR";
  public static final String LY43_VAT_AMT_ATTR                ="@C043_VAT_AMT_ATTR";
  public static final String LY43_VAT_RATE_ATTRS              ="#C043_VAT_RATE_ATTRS[]";
  public static final String LY43_VAT_RATE_ATTR               ="@C043_VAT_RATE_ATTR";
  public static final String LY43_VAT_ATTR                    ="@C043_VAT_ATTR";
  public static final String LY43_WAR_AMT_ATTR                ="@C043_WAR_AMT_ATTR";
  public static final String LY43_NARR_CODE_ATTR1             ="@C043_NARR_CODE_ATTR1";
  public static final String LY43_NARR_CODE_ATTR2             ="@C043_NARR_CODE_ATTR2";
  public static final String LY43_SETT_NARR_ATTR1             ="@C043_SETT_NARR_ATTR1";
  public static final String LY43_SETT_NARR_ATTR2             ="@C043_SETT_NARR_ATTR2";
  public static final String LY43_SETT_NARR_ATTR3             ="@C043_SETT_NARR_ATTR3";
  public static final String LY43_SUBROG_ATTR                 ="@C043_SUBROG_ATTR";
  public static final String LY43_XCS_REC_REF_ATTR            ="@C043_XCS_REC_REF_ATTR";
  public static final String LY43_HIGHEST_EST_ATTR            ="@C043_HIGHEST_EST_ATTR";
  public static final String LY43_INCURRED_ATTR               ="@C043_INCURRED_ATTR";
  public static final String LY43_OUTST_ROE_ATTR              ="@C043_OUTST_ROE_ATTR";
  public static final String LY43_FIND_CODE_ATTR1             ="@C043_FIND_CODE_ATTR1";
  public static final String LY43_FIND_CODE_ATTR2             ="@C043_FIND_CODE_ATTR2";
  public static final String LY43_FIND_CODE_ATTR3             ="@C043_FIND_CODE_ATTR3";
  public static final String LY43_ATTACH_IND_ATTR             ="@C043_ATTACH_IND_ATTR";
  public static final String LY43_CASH_COR_ATTR               ="@C043_CASH_COR_ATTR";
  public static final String LY43_BKR_CNTCT_ATTR              ="@C043_BKR_CNTCT_ATTR";
  public static final String LY43_BKR_PHONE_ATTR              ="@C043_BKR_PHONE_ATTR";
  public static final String LY43_CLM_BKR_REF_ATTR1           ="@C043_CLM_BKR_REF_ATTR1";
  public static final String LY43_CLM_BKR_REF_ATTR2           ="@C043_CLM_BKR_REF_ATTR2";
  public static final String LY43_BKR_REF_ATTR1               ="@C043_BKR_REF_ATTR1";
  public static final String LY43_BKR_REF_ATTR2               ="@C043_BKR_REF_ATTR2";
  public static final String LY43_CNTRY_ATTR                  ="@C043_CNTRY_ATTR";
  public static final String LY43_ORIG_INS_ATTR               ="@C043_ORIG_INS_ATTR";
  public static final String LY43_INSURED_ATTR                ="@C043_INSURED_ATTR";
  public static final String LY43_REINSURED_ATTR              ="@C043_REINSURED_ATTR";
  public static final String LY43_COV_HOLD_ATTR               ="@C043_COV_HOLD_ATTR";
  public static final String LY43_CLAIMANT_ATTR               ="@C043_CLAIMANT_ATTR";
  public static final String LY43_VESS_AIR_ATTR               ="@C043_VESS_AIR_ATTR";
  public static final String LY43_SLIP_TYPE_DESC_ATTR         ="@C043_SLIP_TYPE_DESC_ATTR";   //C043_SLIP_TYPE_DESC_ATTR   added for CR7   
  public static final String LY43_OTHER_NAME_ATTR             ="@C043_OTHER_NAME_ATTR";
  public static final String LY43_POL_FROM_ATTR               ="@C043_POL_FROM_ATTR";
  public static final String LY43_POL_TO_ATTR                 ="@C043_POL_TO_ATTR";
  public static final String LY43_POL_QUAL_ATTR               ="@C043_POL_QUAL_ATTR";
  public static final String LY43_DOL_FROM_ATTR               ="@C043_DOL_FROM_ATTR";
  public static final String LY43_DOL_TO_ATTR                 ="@C043_DOL_TO_ATTR";
  public static final String LY43_DOL_QUAL_ATTR               ="@C043_DOL_QUAL_ATTR";
  public static final String LY43_DOL_NARR_ATTR               ="@C043_DOL_NARR_ATTR";
  public static final String LY43_DCM_FROM_ATTR               ="@C043_DCM_FROM_ATTR";
  public static final String LY43_DCM_TO_ATTR                 ="@C043_DCM_TO_ATTR";
  public static final String LY43_DCM_QUAL_ATTR               ="@C043_DCM_QUAL_ATTR";
  public static final String LY43_SERVICE_TYPE_ATTR           ="@C043_SERVICE_TYPE_ATTR";  // added for CR8-CLASS ph4
  public static final String LY43_CAT_ATTR                    ="@C043_CAT_ATTR";
  public static final String LY43_PCS_CAT_ATTR                ="@C043_PCS_CAT_ATTR";
  public static final String LY43_LIMIT_CURR_ATTR             ="@C043_LIMIT_CURR_ATTR";
  public static final String LY43_SI_LIMIT_ATTR               ="@C043_SI_LIMIT_ATTR";
  public static final String LY43_EXCESS_AMT_ATTR             ="@C043_EXCESS_AMT_ATTR";
  public static final String LY43_PERILS_COND_ATTR            ="@C043_PERILS_COND_ATTR";
  public static final String LY43_LOSS_LOC_ATTR               ="@C043_LOSS_LOC_ATTR";
  public static final String LY43_VOYAGE_ATTR                 ="@C043_VOYAGE_ATTR";
  public static final String LY43_LOSS_NAME_ATTR              ="@C043_LOSS_NAME_ATTR";
  public static final String LY43_CLAIM_DETS_ATTR             ="@C043_CLAIM_DETS_ATTR";
  public static final String LY43_LAW_NAME_ATTR               ="@C043_LAW_NAME_ATTR";
  public static final String LY43_LAW_REF_ATTR                ="@C043_LAW_REF_ATTR";
  public static final String LY43_LAW_CODE_ATTR               ="@C043_LAW_CODE_ATTR";
  public static final String LY43_ADJ_NAME_ATTR               ="@C043_ADJ_NAME_ATTR";
  public static final String LY43_ADJ_REF_ATTR                ="@C043_ADJ_REF_ATTR";
  public static final String LY43_ADJ_CODE_ATTR               ="@C043_ADJ_CODE_ATTR";
  public static final String LY43_SCH_CODE_ATTR               ="@C043_SCH_CODE_ATTR";
  public static final String LY43_TF_CODE_ATTR                ="@C043_TF_CODE_ATTR";
  public static final String LY43_STATE_CODE_ATTR             ="@C043_STATE_CODE_ATTR";
  public static final String LY43_NAIC_CODE_ATTR              ="@C043_NAIC_CODE_ATTR";
  public static final String LY43_NAIC_QUAL_ATTR              ="@C043_NAIC_QUAL_ATTR";
  public static final String LY43_WAR_IND_ATTR                ="@C043_WAR_IND_ATTR";
  public static final String LY43_FIL_CODE_ATTR1              ="@C043_FIL_CODE_ATTR1";
  public static final String LY43_FIL_CODE_ATTR2              ="@C043_FIL_CODE_ATTR2";
  public static final String LY43_OTHER_TF_ATTR               ="@C043_OTHER_TF_ATTR";
  public static final String LY43_DTI_CODE_ATTR               ="@C043_DTI_CODE_ATTR";
  public static final String LY43_CAUSE_CODE_ATTR             ="@C043_CAUSE_CODE_ATTR";
  public static final String LY43_USA_CAN_ATTR                ="@C043_USA_CAN_ATTR" ;
  public static final String LY43_COUNTY_CODE_ATTR            ="@C043_COUNTY_CODE_ATTR" ;

  // CCN #N0031 and N0021 - BA - 15/01/2003
  public static final String LY43_LF_ENTRY_ATTR               ="@C043_LF_ENTRY_ATTR";
  public static final String LY43_LF_ADVANCE_ATTR             ="@C043_LF_ADVANCE_ATTR" ;
  public static final String LY43_BLOCK_ATTR                  ="@C043_BLOCK_IND_ATTR" ;
  
  //** SIR:150695 ECF Phase 6 changes start *****
  public static final String LY43_DIRECT_REPORT_ATTR           ="@C043_DIRECT_REPORT_IND_ATTR" ;
  public static final String LY43_LITIGATION_ATTR              ="@C043_LITIGATION_IND_ATTR" ;
  // TP866603 - Changes for barcode field to behave as protected
  public static final String LY43_BARCODE_ATTR                 ="@C043_BARCODE_ATTR";
  //** SIR:150695 ECF Phase 6 changes end *****

// CR 1442 - D.Smith - 12/12/03
  public static final String LY43_CLM_OO_STAT_ATTR            ="@C043_CLM_OO_STAT_ATTR" ;
  public static final String LY43_CLM_OO_DATE_ATTR            ="@C043_CLM_OO_DATE_ATTR" ;




  // CCN s229 			august 2003
  //  added in new fields for the new scm enquiry screen which has had alot of fields added to it.
  //
  public static final String LY43_AP_REF_ATTR                  ="@C043_AP_REF_ATTR" ;
  public static final String LY43_YOA_ATTR                     ="@C043_YOA_ATTR" ;
  public static final String LY43_GROUP_REF_ATTR               ="@C043_GROUP_REF_ATTR" ;
  public static final String LY43_UMR_ATTR                     ="@C043_UMR_ATTR" ;
  public static final String LY43_MKT_CODE_ATTR                ="@C043_MKT_CODE_ATTR" ;
  public static final String LY43_COV_DATE_FROM_ATTR           ="@C043_COV_DATE_FROM_ATTR" ;
  public static final String LY43_COV_DATE_TO_ATTR             ="@C043_COV_DATE_TO_ATTR" ;
  public static final String LY43_COV_QUAL_ATTR                ="@C043_COV_QUAL_ATTR" ;
  public static final String LY43_PER_NARR_ATTR                ="@C043_PER_NARR_ATTR" ;
  public static final String LY43_SLIP_ORD_1_ATTR              ="@C043_SLIP_ORD_1_ATTR" ;
  public static final String LY43_SLIP_ORD_2_ATTR              ="@C043_SLIP_ORD_2_ATTR" ;
  public static final String LY43_LIMIT_BASIS_ATTR             ="@C043_LIMIT_BASIS_ATTR" ;
  public static final String LY43_SI_NARR_ATTR                 ="@C043_SI_NARR_ATTR" ;
  public static final String LY43_POLICY_NARR_ATTR             ="@C043_POLICY_NARR_ATTR" ;
  public static final String LY43_RISK_CODE_ATTR               ="@C043_RISK_CODE_ATTR" ;
  public static final String LY43_NO_SYNDS_ATTR                ="@C043_NO_SYNDS_ATTR" ;
  public static final String LY43_MARKET_SOURCE_ATTR           ="@C043_MARKET_SOURCE_ATTR" ;
  public static final String LY43_MARKET_ATTR                  ="@C043_MARKET_ATTR" ;
  public static final String LY43_LLOYDS_CLAIM_TYPE_ATTR       ="@C043_LLOYDS_CLAIM_TYPE_ATTR" ;
  public static final String LY43_INTEREST_ATTR                ="@C043_INTEREST_ATTR" ;
  public static final String LY43_LOC_VOY_ATTR                 ="@C043_LOC_VOY_ATTR" ;
  public static final String LY43_XCR_CLAIM_NARR_ATTR          ="@C043_XCR_CLAIM_NARR_ATTR" ;
  public static final String LY43_CHOLDER_CLM_REF_ATTR         ="@C043_CHOLDER_CLM_REF_ATTR" ;
  public static final String LY43_TRANS_SYNOPSIS_ATTR          ="@C043_TRANS_SYNOPSIS_ATTR" ;
  public static final String LY43_TDN_REF_ATTR                 ="@C043_TDN_REF_ATTR" ;
  public static final String LY43_USER_ID_ATTR                 ="@C043_USER_ID_ATTR" ;
  public static final String LY43_CHARGE_TYPE_ATTR             ="@C043_CHARGE_TYPE_ATTR" ;


  /*Expert Fee Break Down function [attributes]*/
  
  public static final String LY43_EXP_PTD_ATTR                 ="@C043_EXP_PTD_ATTR";
  public static final String LY43_FEE_PTD_ATTR                 ="@C043_FEE_PTD_ATTR";
  public static final String LY43_EXP_SCREEN_ATTR              ="@C043_EXP_SCREEN_ATTR";
  public static final String LY43_EXPERT_ATTR_COUNT            ="@C043_EXPERT_ATTR_COUNT";
  public static final String LY43_EXPERT_ATTR                  ="#C043_EXPERT_ATTR[]";
  public static final String LY43_EX_CODE_ATTR                 ="@C043_EX_CODE_ATTR";
  public static final String LY43_EX_TYPE_ATTR                 ="@C043_EX_TYPE_ATTR";
  public static final String LY43_EX_REF_ATTR                  ="@C043_EX_REF_ATTR";
  public static final String LY43_EX_SCM_ATTR                  ="@C043_EX_SCM_ATTR";
  public static final String LY43_EX_NAME_ATTR                 ="@C043_EX_NAME_ATTR";
  public static final String LY43_EX_CNTCT_ATTR                ="@C043_EX_CNTCT_ATTR";
  public static final String LY43_EX_PTD_EXP_ATTR              ="@C043_EX_PTD_EXP_ATTR";
  public static final String LY43_EX_PTD_FEE_ATTR              ="@C043_EX_PTD_FEE_ATTR";
  public static final String LY43_EX_PTT_EXP_ATTR              ="@C043_EX_PTT_EXP_ATTR";
  public static final String LY43_EX_PTT_FEE_ATTR              ="@C043_EX_PTT_FEE_ATTR";
  public static final String LY43_EX_OS_EXP_ATTR               ="@C043_EX_OS_EXP_ATTR";
  public static final String LY43_EX_OS_FEE_ATTR               ="@C043_EX_OS_FEE_ATTR";
  public static final String LY43_EX_DEL_ATTR                  ="@C043_EX_DEL_ATTR";

  

  public static final String LY43_COMMAND_ATTRIBUTES          ="#C043_COMMAND_ATTRIBUTES[]";
  public static final String LY43_END_BD_ATTR                 ="@C043_END_BD_ATTR";
  public static final String LY43_NEW_BD_ATTR                 ="@C043_NEW_BD_ATTR";
  public static final String LY43_BIND_SCHD_ATTR              ="@C043_BIND_SCHD_ATTR";
  public static final String LY43_RI_SCHD_ATTR                ="@C043_RI_SCHD_ATTR";
  public static final String LY43_BACK_ATTR                   ="@C043_BACK_ATTR";
  public static final String LY43_EURO_ATTR                   ="@C043_EURO_ATTR";
  public static final String LY43_CCS_ATTR                    ="@C043_CCS_ATTR";
  public static final String LY43_NEW_MOVE_ATTR               ="@C043_NEW_MOVE_ATTR";

  /*Expert Fee Break Down function [Command]*/
  public static final String LY43_FEES_BDOWN_ATTR             ="@C043_FEES_BDOWN_ATTR";

  
  
  // LY44 input keys
  public static final String  LY44_SESSION_NO               = "@C044_SESSION_NO";
  public static final String  LY44_FIELD_VALUES             = "#C044_FIELD_VALUES[]";
  public static final String  LY44_CURR_NO_VAL              = "@C044_CURR_NO_VAL";
  public static final String  LY44_SDN_NO_VAL               = "@C044_SDN_NO_VAL";
  public static final String  LY44_BDOWN_NO_VAL             = "@C044_BDOWN_NO_VAL";
  public static final String  LY44_CLM_REF_REC              = "@C044_CLM_REF_REC";
  public static final String  LY44_ORIG_CURR                = "@C044_ORIG_CURR";
  public static final String  LY44_SETT_CURR                = "@C044_SETT_CURR";
  public static final String  LY44_EXCH_RATE                = "@C044_EXCH_RATE";
  public static final String  LY44_PTD_LOSS                 = "@C044_PTD_LOSS";
  public static final String  LY44_PTD_EXP                  = "@C044_PTD_EXP";
  public static final String  LY44_PTD_FEE                  = "@C044_PTD_FEE";
  public static final String  LY44_PTD_TOTAL                = "@C044_PTD_TOTAL";
  public static final String  LY44_PTT_LOSS                 = "@C044_PTT_LOSS";
  public static final String  LY44_PTT_EXP                  = "@C044_PTT_EXP";
  public static final String  LY44_PTT_FEE                  = "@C044_PTT_FEE";
  public static final String  LY44_PTT_TOTAL                = "@C044_PTT_TOTAL";
  public static final String  LY44_OUTST_LOSS               = "@C044_OUTST_LOSS";
  public static final String  LY44_OUTST_LOSS_QUAL          = "@C044_OUTST_LOSS_QUAL";
  public static final String  LY44_OUTST_EXP                = "@C044_OUTST_EXP";
  public static final String  LY44_OUTST_FEE                = "@C044_OUTST_FEE";
  public static final String  LY44_OUTST_FEE_QUAL           = "@C044_OUTST_FEE_QUAL";
  public static final String  LY44_OUTST_TOT                = "@C044_OUTST_TOT";
  public static final String  LY44_OUTST_TOT_QUAL           = "@C044_OUTST_TOT_QUAL";
  public static final String  LY44_PTD_SETT_AMT             = "@C044_PTD_SETT_AMT";
  public static final String  LY44_CLAIM_AMT_SETT           = "@C044_CLAIM_AMT_SETT";
  public static final String  LY44_BUREAU_LINE              = "@C044_BUREAU_LINE";
  public static final String  LY44_BUR_PROP_AMT             = "@C044_BUR_PROP_AMT";
  public static final String  LY44_HPC_VAT_AMT              = "@C044_HPC_VAT_AMT";
  public static final String  LY44_VAT_RATE_TABLE           = "#C044_VAT_RATE_TABLE[]";
  public static final String  LY44_VAT_RATE                 = "@C044_VAT_RATE";
  public static final String  LY44_VAT_AMT                  = "@C044_VAT_AMT";
  public static final String  LY44_WAR_AMT                  = "@C044_WAR_AMT";
  public static final String  LY44_NARR_CODE_1              = "@C044_NARR_CODE_1";
  public static final String  LY44_NARR_CODE_2              = "@C044_NARR_CODE_2";
  public static final String  LY44_SETT_NARR_1              = "@C044_SETT_NARR_1";
  public static final String  LY44_SETT_NARR_2              = "@C044_SETT_NARR_2";
  public static final String  LY44_SETT_NARR_3              = "@C044_SETT_NARR_3";
  public static final String  LY44_SUBROGATION              = "@C044_SUBROGATION";
  public static final String  LY44_XCS_REC_REF              = "@C044_XCS_REC_REF";
  public static final String  LY44_HIGHEST_EST              = "@C044_HIGHEST_EST";
  public static final String  LY44_INCURRED_AMT             = "@C044_INCURRED_AMT";
  public static final String  LY44_RATE_EXCH_OUTST          = "@C044_RATE_EXCH_OUTST";
  public static final String  LY44_FINDER_CODE_1            = "@C044_FINDER_CODE_1";
  public static final String  LY44_FINDER_CODE_2            = "@C044_FINDER_CODE_2";
  public static final String  LY44_FINDER_CODE_3            = "@C044_FINDER_CODE_3";
  public static final String  LY44_ATTACHMENT_IND           = "@C044_ATTACHMENT_IND";
  public static final String  LY44_CASH_COR                 = "@C044_CASH_COR";
  public static final String  LY44_BKR_CNTCT                = "@C044_BKR_CNTCT";
  public static final String  LY44_BKR_CNTCT_PHONE          = "@C044_BKR_CNTCT_PHONE";
  public static final String  LY44_CLM_BKR_REF_1            = "@C044_CLM_BKR_REF_1";
  public static final String  LY44_CLM_BKR_REF_2            = "@C044_CLM_BKR_REF_2";
  public static final String  LY44_BKR_REF_1                = "@C044_BKR_REF_1";
  public static final String  LY44_BKR_REF_2                = "@C044_BKR_REF_2";
  public static final String  LY44_CNTRY_OF_ORIGIN          = "@C044_CNTRY_OF_ORIGIN";
  public static final String  LY44_ORIG_INSURED             = "@C044_ORIG_INSURED";
  public static final String  LY44_INSURED                  = "@C044_INSURED";
  public static final String  LY44_REINSURED                = "@C044_REINSURED";
  public static final String  LY44_COVER_HOLDER             = "@C044_COVER_HOLDER";
  public static final String  LY44_CLAIMANT                 = "@C044_CLAIMANT";
  public static final String  LY44_VESSEL_AIRCRAFT          = "@C044_VESSEL_AIRCRAFT";
  public static final String  LY44_OTHER_NAME               = "@C044_OTHER_NAME";
  public static final String  LY44_POL_CERT_FROM            = "@C044_POL_CERT_FROM";
  public static final String  LY44_POL_CERT_TO              = "@C044_POL_CERT_TO";
  public static final String  LY44_POL_CERT_QUAL            = "@C044_POL_CERT_QUAL";
  public static final String  LY44_LOSS_DATE_FROM           = "@C044_LOSS_DATE_FROM";
  public static final String  LY44_LOSS_DATE_TO             = "@C044_LOSS_DATE_TO";
  public static final String  LY44_LOSS_DATE_QUAL           = "@C044_LOSS_DATE_QUAL";
  public static final String  LY44_LOSS_DATE_NARR           = "@C044_LOSS_DATE_NARR";
  public static final String  LY44_CLAIM_DATE_FROM          = "@C044_CLAIM_DATE_FROM";
  public static final String  LY44_CLAIM_DATE_TO            = "@C044_CLAIM_DATE_TO";
  public static final String  LY44_CLAIM_DATE_QUAL          = "@C044_CLAIM_DATE_QUAL";
  public static final String  LY44_CAT_CODE                 = "@C044_CAT_CODE";
  public static final String  LY44_PCS_CAT_CODE             = "@C044_PCS_CAT_CODE";
  public static final String  LY44_LIMIT_CURR               = "@C044_LIMIT_CURR";
  public static final String  LY44_SI_LIMIT                 = "@C044_SI_LIMIT";
  public static final String  LY44_EXCESS_AMT               = "@C044_EXCESS_AMT";
  public static final String  LY44_PERILS_CONDS             = "@C044_PERILS_CONDS";
  public static final String  LY44_LOSS_LOCATION            = "@C044_LOSS_LOCATION";
  public static final String  LY44_VOYAGE                   = "@C044_VOYAGE";
  public static final String  LY44_LOSS_NAME                = "@C044_LOSS_NAME";
  public static final String  LY44_CLAIM_DETAILS            = "#C044_CLAIM_DETAILS[]";
  public static final String  LY44_CLAIM_DET_LINE           = "@C044_CLAIM_DET_LINE";
  public static final String  LY44_LAWYER_NAME              = "@C044_LAWYER_NAME";
  public static final String  LY44_LAWYER_REF               = "@C044_LAWYER_REF";
  public static final String  LY44_LAWYER_CODE              = "@C044_LAWYER_CODE";
  public static final String  LY44_ADJUSTER_NAME            = "@C044_ADJUSTER_NAME";
  public static final String  LY44_ADJUSTER_REF             = "@C044_ADJUSTER_REF";
  public static final String  LY44_ADJUSTER_CODE            = "@C044_ADJUSTER_CODE";
  public static final String  LY44_SCHEME_CODE              = "@C044_SCHEME_CODE";
  public static final String  LY44_TF_CODE                  = "@C044_TF_CODE";
  public static final String  LY44_STATE_CODE               = "@C044_STATE_CODE";
  public static final String  LY44_NAIC_CODE                = "@C044_NAIC_CODE";
  public static final String  LY44_NAIC_QUAL                = "@C044_NAIC_QUAL";
  public static final String  LY44_WAR_IND                  = "@C044_WAR_IND";
  public static final String  LY44_FIL_CODE_1               = "@C044_FIL_CODE_1";
  public static final String  LY44_FIL_CODE_2               = "@C044_FIL_CODE_2";
  public static final String  LY44_OTHER_TF_CODE            = "@C044_OTHER_TF_CODE";
  public static final String  LY44_DTI_CODE                 = "@C044_DTI_CODE";
  public static final String  LY44_CAUSE_CODE_TABLE         = "#C044_CAUSE_CODE_TABLE[]";
  public static final String  LY44_CAUSE_CODE               = "@C044_CAUSE_CODE";
  public static final String  LY44_FIELD_ERRORS             = "#C044_FIELD_ERRORS[]" ;
  public static final String  LY44_USA_CAN_IND              = "@C044_USA_CAN_IND" ;
  public static final String  LY44_COUNTY_CODE              = "@C044_COUNTY_CODE" ;
  public static final String  LY44_COUNTY_CODE_ERR          = "@C044_COUNTY_CODE_ERR" ;
  
  //public static final String  LY44_BARCODE_ERR              = "@C044_BARCODE_ERR" ;
  

  // CCN #N0031 and N0021 _ BA - 15/01/2003
  public static final String LY44_LF_ENTRY_IND                ="@C044_LF_ENTRY_IND";
  public static final String LY44_LF_ADVANCE_IND              ="@C044_LF_ADVANCE_IND" ;
  public static final String LY44_BLOCK_IND                   ="@C044_BLOCK_IND" ;

  //** SIR:150695 ECF Phase 6 changes start *****  
  public static final String LY44_DIRECT_REPORT_IND           ="@C044_DIRECT_REPORT_IND" ;
  public static final String LY44_LITIGATION_IND              ="@C044_LITIGATION_IND" ;
//  TP866603 -Changes for barcode field to behave as protected
  public static final String LY44_BARCODE                     ="@C044_BARCODE" ;
  public static final String LY44_SERVICE_TPYE              ="@C044_SERVICE_TYPE" ; // ADDED FOR CR8 - CLASS PH4
  
  //** SIR:150695 ECF Phase 6 changes end *****  

  
  /*Expert Fee Break Down function*/
  public static final String LY44_EXPERT_COUNT                ="@C044_EXPERT_COUNT";
  public static final String LY44_EXPERT_DETAILS              ="#C044_EXPERT_DETAILS[]";
  public static final String LY44_EXPERT_CODE                 ="@C044_EXPERT_CODE";
  public static final String LY44_EXPERT_TYPE                 ="@C044_EXPERT_TYPE";
  public static final String LY44_EXPERT_REF                  ="@C044_EXPERT_REF";
  public static final String LY44_EXPERT_SCM                  ="@C044_EXPERT_SCM";
  public static final String LY44_EXPERT_NAME                 ="@C044_EXPERT_NAME";
  public static final String LY44_EXPERT_CNTCT                ="@C044_EXPERT_CNTCT";
  public static final String LY44_EXPERT_PTD_EXP              ="@C044_EXPERT_PTD_EXP";
  public static final String LY44_EXPERT_PTD_FEE              ="@C044_EXPERT_PTD_FEE";
  public static final String LY44_EXPERT_PTT_EXP              ="@C044_EXPERT_PTT_EXP";
  public static final String LY44_EXPERT_PTT_FEE              ="@C044_EXPERT_PTT_FEE";
  public static final String LY44_EXPERT_OS_EXP               ="@C044_EXPERT_OS_EXP";
  public static final String LY44_EXPERT_OS_FEE               ="@C044_EXPERT_OS_FEE";


  
  

  // LY45 input keys
  public static final String  LY45_SESSION_NO               = "@C045_SESSION_NO";
  public static final String  LY45_FIELD_VALUES             = "#C045_FIELD_VALUES[]";
  public static final String LY45_XCR                       = "@C045_XCR";
  public static final String LY45_UCR                       = "@C045_UCR";
  public static final String LY45_TR                        = "@C045_TR";
  public static final String LY45_ORIG_REF                  = "@C045_ORIG_REF";
  public static final String LY45_ORIG_BKR                  = "@C045_ORIG_BKR";
  public static final String LY45_SIGNED_IND                = "@C045_SIGNED_IND";
  public static final String LY45_PEER_REV_IND              = "@C045_PEER_REV_IND";
  public static final String LY45_ORIG_CURR_HDR             = "@C045_ORIG_CURR_HDR";
  public static final String LY45_COR                       = "@C045_COR";
  public static final String LY45_LOC_IND                   = "@C045_LOC_IND";
  public static final String LY45_PAYEE_BKR_CODE            = "@C045_PAYEE_BKR_CODE";
  public static final String LY45_REDENOM_IND               = "@C045_REDENOM_IND";
  public static final String LY45_MOVE_REF                  = "@C045_MOVE_REF";
  public static final String  LY45_CURR_NO_VAL              = "@C045_CURR_NO_VAL";
  public static final String  LY45_SDN_NO_VAL               = "@C045_SDN_NO_VAL";
  public static final String  LY45_BDOWN_NO_VAL             = "@C045_BDOWN_NO_VAL";
  public static final String  LY45_CLM_REF_REC              = "@C045_CLM_REF_REC";
  public static final String  LY45_ORIG_CURR                = "@C045_ORIG_CURR";
  public static final String  LY45_SETT_CURR                = "@C045_SETT_CURR";
  public static final String  LY45_EXCH_RATE                = "@C045_EXCH_RATE";
  public static final String  LY45_PTD_LOSS                 = "@C045_PTD_LOSS";
  public static final String  LY45_PTD_EXP                  = "@C045_PTD_EXP";
  public static final String  LY45_PTD_FEE                  = "@C045_PTD_FEE";
  public static final String  LY45_PTD_TOTAL                = "@C045_PTD_TOTAL";
  public static final String  LY45_PTT_LOSS                 = "@C045_PTT_LOSS";
  public static final String  LY45_PTT_EXP                  = "@C045_PTT_EXP";
  public static final String  LY45_PTT_FEE                  = "@C045_PTT_FEE";
  public static final String  LY45_PTT_TOTAL                = "@C045_PTT_TOTAL";
  public static final String  LY45_OUTST_LOSS               = "@C045_OUTST_LOSS";
  public static final String  LY45_OUTST_LOSS_QUAL          = "@C045_OUTST_LOSS_QUAL";
  public static final String  LY45_OUTST_EXP                = "@C045_OUTST_EXP";
  public static final String  LY45_OUTST_FEE                = "@C045_OUTST_FEE";
  public static final String  LY45_OUTST_FEE_QUAL           = "@C045_OUTST_FEE_QUAL";
  public static final String  LY45_OUTST_TOT                = "@C045_OUTST_TOT";
  public static final String  LY45_OUTST_TOT_QUAL           = "@C045_OUTST_TOT_QUAL";
  public static final String  LY45_PTD_SETT_AMT             = "@C045_PTD_SETT_AMT";
  public static final String  LY45_CLAIM_AMT_SETT           = "@C045_CLAIM_AMT_SETT";
  public static final String  LY45_BUREAU_LINE              = "@C045_BUREAU_LINE";
  public static final String  LY45_BUR_PROP_AMT             = "@C045_BUR_PROP_AMT";
  public static final String  LY45_HPC_VAT_AMT              = "@C045_HPC_VAT_AMT";
  public static final String  LY45_VAT_RATE_TABLE           = "#C045_VAT_RATE_TABLE[]";
  public static final String  LY45_VAT_RATE                 = "@C045_VAT_RATE";
  public static final String  LY45_VAT_AMT                  = "@C045_VAT_AMT";
  public static final String  LY45_WAR_AMT                  = "@C045_WAR_AMT";
  public static final String  LY45_NARR_CODE_1              = "@C045_NARR_CODE_1";
  public static final String  LY45_NARR_CODE_2              = "@C045_NARR_CODE_2";
  public static final String  LY45_SETT_NARR_1              = "@C045_SETT_NARR_1";
  public static final String  LY45_SETT_NARR_2              = "@C045_SETT_NARR_2";
  public static final String  LY45_SETT_NARR_3              = "@C045_SETT_NARR_3";
  public static final String  LY45_SUBROGATION              = "@C045_SUBROGATION";
  public static final String  LY45_XCS_REC_REF              = "@C045_XCS_REC_REF";
  public static final String  LY45_HIGHEST_EST              = "@C045_HIGHEST_EST";
  public static final String  LY45_INCURRED_AMT             = "@C045_INCURRED_AMT";
  public static final String  LY45_RATE_EXCH_OUTST          = "@C045_RATE_EXCH_OUTST";
  public static final String  LY45_FINDER_CODE_1            = "@C045_FINDER_CODE_1";
  public static final String  LY45_FINDER_CODE_2            = "@C045_FINDER_CODE_2";
  public static final String  LY45_FINDER_CODE_3            = "@C045_FINDER_CODE_3";
  public static final String  LY45_ATTACHMENT_IND           = "@C045_ATTACHMENT_IND";
  public static final String  LY45_CASH_COR                 = "@C045_CASH_COR";
  public static final String  LY45_BKR_CNTCT                = "@C045_BKR_CNTCT";
  public static final String  LY45_BKR_CNTCT_PHONE          = "@C045_BKR_CNTCT_PHONE";
  public static final String  LY45_CLM_BKR_REF_1            = "@C045_CLM_BKR_REF_1";
  public static final String  LY45_CLM_BKR_REF_2            = "@C045_CLM_BKR_REF_2";
  public static final String  LY45_BKR_REF_1                = "@C045_BKR_REF_1";
  public static final String  LY45_BKR_REF_2                = "@C045_BKR_REF_2";
  public static final String  LY45_CNTRY_OF_ORIGIN          = "@C045_CNTRY_OF_ORIGIN";
  public static final String  LY45_ORIG_INSURED             = "@C045_ORIG_INSURED";
  public static final String  LY45_INSURED                  = "@C045_INSURED";
  public static final String  LY45_REINSURED                = "@C045_REINSURED";
  public static final String  LY45_COVER_HOLDER             = "@C045_COVER_HOLDER";
  public static final String  LY45_CLAIMANT                 = "@C045_CLAIMANT";
  public static final String  LY45_VESSEL_AIRCRAFT          = "@C045_VESSEL_AIRCRAFT";
  public static final String  LY45_OTHER_NAME               = "@C045_OTHER_NAME";
  public static final String  LY45_POL_CERT_FROM            = "@C045_POL_CERT_FROM";
  public static final String  LY45_POL_CERT_TO              = "@C045_POL_CERT_TO";
  public static final String  LY45_POL_CERT_QUAL            = "@C045_POL_CERT_QUAL";
  public static final String  LY45_LOSS_DATE_FROM           = "@C045_LOSS_DATE_FROM";
  public static final String  LY45_LOSS_DATE_TO             = "@C045_LOSS_DATE_TO";
  public static final String  LY45_LOSS_DATE_QUAL           = "@C045_LOSS_DATE_QUAL";
  public static final String  LY45_LOSS_DATE_NARR           = "@C045_LOSS_DATE_NARR";
  public static final String  LY45_CLAIM_DATE_FROM          = "@C045_CLAIM_DATE_FROM";
  public static final String  LY45_CLAIM_DATE_TO            = "@C045_CLAIM_DATE_TO";
  public static final String  LY45_CLAIM_DATE_QUAL          = "@C045_CLAIM_DATE_QUAL";
  public static final String  LY45_CAT_CODE                 = "@C045_CAT_CODE";
  public static final String  LY45_PCS_CAT_CODE             = "@C045_PCS_CAT_CODE";
  public static final String  LY45_LIMIT_CURR               = "@C045_LIMIT_CURR";
  public static final String  LY45_SI_LIMIT                 = "@C045_SI_LIMIT";
  public static final String  LY45_EXCESS_AMT               = "@C045_EXCESS_AMT";
  public static final String  LY45_PERILS_CONDS             = "@C045_PERILS_CONDS";
  public static final String  LY45_LOSS_LOCATION            = "@C045_LOSS_LOCATION";
  public static final String  LY45_VOYAGE                   = "@C045_VOYAGE";
  public static final String  LY45_LOSS_NAME                = "@C045_LOSS_NAME";
  public static final String  LY45_CLAIM_DETAILS            = "#C045_CLAIM_DETAILS[]";
  public static final String  LY45_CLAIM_DET_LINE           = "@C045_CLAIM_DET_LINE";
  public static final String  LY45_LAWYER_NAME              = "@C045_LAWYER_NAME";
  public static final String  LY45_LAWYER_REF               = "@C045_LAWYER_REF";
  public static final String  LY45_LAWYER_CODE              = "@C045_LAWYER_CODE";
  public static final String  LY45_ADJUSTER_NAME            = "@C045_ADJUSTER_NAME";
  public static final String  LY45_ADJUSTER_REF             = "@C045_ADJUSTER_REF";
  public static final String  LY45_ADJUSTER_CODE            = "@C045_ADJUSTER_CODE";
  public static final String  LY45_SCHEME_CODE              = "@C045_SCHEME_CODE";
  public static final String  LY45_TF_CODE                  = "@C045_TF_CODE";
  public static final String  LY45_STATE_CODE               = "@C045_STATE_CODE";
  public static final String  LY45_NAIC_CODE                = "@C045_NAIC_CODE";
  public static final String  LY45_NAIC_QUAL                = "@C045_NAIC_QUAL";
  public static final String  LY45_WAR_IND                  = "@C045_WAR_IND";
  public static final String  LY45_FIL_CODE_1               = "@C045_FIL_CODE_1";
  public static final String  LY45_FIL_CODE_2               = "@C045_FIL_CODE_2";
  public static final String  LY45_OTHER_TF_CODE            = "@C045_OTHER_TF_CODE";
  public static final String  LY45_DTI_CODE                 = "@C045_DTI_CODE";
  public static final String  LY45_CAUSE_CODE_TABLE         = "#C045_CAUSE_CODE_TABLE[]";
  public static final String  LY45_CAUSE_CODE               = "@C045_CAUSE_CODE";
  public static final String  LY45_USA_CAN_IND              = "@C045_USA_CAN_IND" ;
  public static final String  LY45_COUNTY_CODE              = "@C045_COUNTY_CODE" ;

  // CCN #N0031 and N0021 - BA - 15/01/2003
  public static final String  LY45_LF_ENTRY_IND             ="@C045_LF_ENTRY_IND";
  public static final String  LY45_LF_ADVANCE_IND           ="@C045_LF_ADVANCE_IND" ;
  public static final String  LY45_BLOCK_IND                ="@C045_BLOCK_IND" ;
  
  //** SIR:150695 ECF Phase 6 changes start *****  
  public static final String LY45_DIRECT_REPORT_IND           ="@C045_DIRECT_REPORT_IND" ;
  public static final String LY45_LITIGATION_IND              ="@C045_LITIGATION_IND" ;
  public static final String LY45_BARCODE                     ="@C045_BARCODE" ;

  public static final String LY45_SERVICE_TYPE                ="@C045_SERVICE_TYPE" ;         // ADDED FOR CR8 CLASS PH4
  //** SIR:150695 ECF Phase 6 changes end *****  

  /*Expert Fee Break Down function*/
  public static final String LY45_EXPERT_COUNT                ="@C045_EXPERT_COUNT";
  public static final String LY45_EXPERT_DETAILS              ="#C045_EXPERT_DETAILS[]";
  public static final String LY45_EXPERT_CODE                 ="@C045_EXPERT_CODE";
  public static final String LY45_EXPERT_TYPE                 ="@C045_EXPERT_TYPE";
  public static final String LY45_EXPERT_REF                  ="@C045_EXPERT_REF";
  public static final String LY45_EXPERT_SCM                  ="@C045_EXPERT_SCM";
  public static final String LY45_EXPERT_NAME                 ="@C045_EXPERT_NAME";
  public static final String LY45_EXPERT_CNTCT                ="@C045_EXPERT_CNTCT";
  public static final String LY45_EXPERT_PTD_EXP              ="@C045_EXPERT_PTD_EXP";
  public static final String LY45_EXPERT_PTD_FEE              ="@C045_EXPERT_PTD_FEE";
  public static final String LY45_EXPERT_PTT_EXP              ="@C045_EXPERT_PTT_EXP";
  public static final String LY45_EXPERT_PTT_FEE              ="@C045_EXPERT_PTT_FEE";
  public static final String LY45_EXPERT_OS_EXP               ="@C045_EXPERT_OS_EXP";
  public static final String LY45_EXPERT_OS_FEE               ="@C045_EXPERT_OS_FEE";



  // LY46 input keys
  public static final String LY46_SessionID_Field           = "@C046_SESSION_NO";
  public static final String LY46_NEW_UCR_TR_SYS_REF_Field  = "@C046_NEW_UCR_TR_SYS_REF";
  public static final String LY46_NEW_CURR_NO_Field         = "@C046_NEW_CURR_NO";
  public static final String LY46_NEW_SDN_NO_Field          = "@C046_NEW_SDN_NO";
  public static final String LY46_NEW_STAT_SPLIT_NO_Field   = "@C046_NEW_STAT_SPLIT_NO";
  public static final String LY46_NEW_BREAKDOWN_NO_Field    = "@C046_NEW_BREAKDOWN_NO";
  public static final String LY46_NEXT_PROGRAM_Field        = "@C046_NEXT_PROGRAM";

  // LY47 input keys
  public static final String LY47_SessionID_Field           = "@C047_SESSION_NO";

  // LY48 input keys
  public static final String LY48_SESSION_NO                = "@C048_SESSION_NO";
  public static final String LY48_PREV_PRESSED              = "@C048_PREV_PRESSED";
  public static final String LY48_NEXT_PRESSED              = "@C048_NEXT_PRESSED";
  public static final String LY48_START_KEY                 = "#C048_START_KEY[]";
  public static final String LY48_START_SYS_REF             = "@C048_START_SYS_REF";
  public static final String LY48_START_CURR_NO             = "@C048_START_CURR_NO";
  public static final String LY48_START_SDN_NO              = "@C048_START_SDN_NO";
  public static final String LY48_START_BDOWN_NO            = "@C048_START_BDOWN_NO";

  // LY49 input keys
  public static final String LY49_SessionID_Field           = "@C049_SESSION_NO";

  // LY50 input keys
  public static final String LY50_SessionID_Field           = "@C050_SESSION_NO";

  // LY51 input keys
  public static final String LY51SessionIDField             = "@C051_SESSION_NO";

  // LY52 input keys
  public static final String LY52SessionIDField             = "@C052_SESSION_NO";

  // LY53 input keys
  public static final String LY53_SESSION_NO                = "@C053_SESSION_NO";
  public static final String LY53_PREV_PRESSED              = "@C053_PREV_PRESSED";
  public static final String LY53_NEXT_PRESSED              = "@C053_NEXT_PRESSED";
  public static final String LY53_START_KEY                 = "#C053_START_KEY[]";
  public static final String LY53_START_SYS_REF             = "@C053_START_SYS_REF";
  public static final String LY53_START_CURR_NO             = "@C053_START_CURR_NO";
  public static final String LY53_START_SDN_NO              = "@C053_START_SDN_NO";
  public static final String LY53_START_BDOWN_NO            = "@C053_START_BDOWN_NO";

  // LY54 input keys
  public static final String LY54_SessionID_Field           = "@C054_SESSION_NO";

  // LY55 input keys
  public static final String LY55_SessionID_Field           = "@C055_SESSION_NO";

  // LY56 input keys
  public static final String LY56SessionIDField             = "@C056_SESSION_NO";
  public static final String LY56_PREV_PRESSED_FIELD        = "@C056_PREV_PRESSED" ;
  public static final String LY56_NEXT_PRESSED_FIELD        = "@C056_NEXT_PRESSED" ;
  public static final String LY56_START_BDOWN_NO            = "@C056_START_BDOWN_NO" ;

  // LY56 output keys
  public static final String LY56_SCREEN_MODE_Field           = "@C056_SCREEN_MODE" ;
  public static final String LY56_FIELD_VALUES_Table          = "#C056_FIELD_VALUES[]" ;
  public static final String LY56_XCR_Field                   = "@C056_XCR" ;
  public static final String LY56_UCR_Field                   = "@C056_UCR" ;
  public static final String LY56_TR_Field                    = "@C056_TR" ;
  public static final String LY56_ORIG_REF_1_Field            = "@C056_ORIG_REF_1" ;
  public static final String LY56_ORIG_BKR_Field              = "@C056_ORIG_BKR" ;
  public static final String LY56_SIGNED_IND_Field            = "@C056_SIGNED_IND" ;
  public static final String LY56_PEER_REV_IND_Field          = "@C056_PEER_REV_IND" ;
  public static final String LY56_ORIG_CURR_Field             = "@C056_ORIG_CURR" ;
  public static final String LY56_KEY_VALUES_Table            = "#C056_KEY_VALUES[]" ;
  public static final String LY56_UCR_TR_SYS_REF_Field        = "@C056_UCR_TR_SYS_REF" ;
  public static final String LY56_CURR_NO_Field               = "@C056_CURR_NO" ;
  public static final String LY56_SDN_NO_Field                = "@C056_SDN_NO" ;
  public static final String LY56_BREAKDOWN_Table             = "#C056_BREAKDOWN_TABLE[]" ;
  public static final String LY56_COR_Field                   = "@C056_COR" ;
  public static final String LY56_STAT_SPLIT_NO_Field         = "@C056_STAT_SPLIT_NO" ;
  public static final String LY56_BREAKDOWN_NO_Field          = "@C056_BREAKDOWN_NO" ;
  public static final String LY56_MOVE_REF_Field              = "@C056_MOVE_REF" ;
  public static final String LY56_NAME_1_Field                = "@C056_NAME_1" ;
  public static final String LY56_NAME_1_QUAL_Field           = "@C056_NAME_1_QUAL" ;
  public static final String LY56_NAME_2_Field                = "@C056_NAME_2" ;
  public static final String LY56_NAME_2_QUAL_Field           = "@C056_NAME_2_QUAL" ;
  public static final String LY56_FIL_CODE_Field              = "@C056_FIL_CODE" ;
  public static final String LY56_TF_CODE_Field               = "@C056_TF_CODE" ;
  public static final String LY56_STATE_CODE_Field            = "@C056_STATE_CODE" ;
  public static final String LY56_LOSS_DATE_FROM_Field        = "@C056_LOSS_DATE_FROM" ;
  public static final String LY56_LOSS_DATE_TO_Field          = "@C056_LOSS_DATE_TO" ;
  public static final String LY56_LOSS_DATE_QUAL_Field        = "@C056_LOSS_DATE_QUAL" ;
  public static final String LY56_CAT_CODE_Field              = "@C056_CAT_CODE" ;
  public static final String LY56_PCS_CAT_CODE_Field          = "@C056_PCS_CAT_CODE" ;
  public static final String LY56_NAIC_CODE_Field             = "@C056_NAIC_CODE" ;
  public static final String LY56_NAIC_QUAL_Field             = "@C056_NAIC_QUAL" ;
  public static final String LY56_PTT_AMT_TOTAL               = "@C056_PTT_AMT_TOTAL";
  public static final String LY56_OUTST_AMT                   = "@C056_OUTST_AMT";
  public static final String LY56_OUTST_AMT_TOT_QL            = "@C056_OUTST_TOT_QL";//"@C056_OUTST_TOT_QL";        // added for CR6
  public static final String LY56_FIELD_ATTRIBUTES_Table      = "#C056_FIELD_ATTRIBUTES[]" ;
  public static final String LY56_XCR_ATTR_Field              = "@C056_XCR_ATTR" ;
  public static final String LY56_UCR_ATTR_Field              = "@C056_UCR_ATTR" ;
  public static final String LY56_TR_ATTR_Field               = "@C056_TR_ATTR" ;
  public static final String LY56_ORIG_REF_1_ATTR_Field       = "@C056_ORIG_REF_1_ATTR" ;
  public static final String LY56_ORIG_BKR_ATTR_Field         = "@C056_ORIG_BKR_ATTR" ;
  public static final String LY56_SIGN_IND_ATTR_Field         = "@C056_SIGN_IND_ATTR" ;
  public static final String LY56_PEER_REV_ATTR_Field         = "@C056_PEER_REV_ATTR" ;
  public static final String LY56_ORIG_CURR_ATTR_Field        = "@C056_ORIG_CURR_ATTR" ;
  public static final String LY56_BREAKDOWN_ATTR_Table        = "#C056_BREAKDOWN_ATTRS[]" ;
  public static final String LY56_COR_ATTR_Field              = "@C056_COR_ATTR" ;
  public static final String LY56_MOVE_REF_ATTR_Field         = "@C056_MOVE_REF_ATTR" ;
  public static final String LY56_NAME_1_ATTR_Field           = "@C056_NAME_1_ATTR" ;
  public static final String LY56_NAME_1_QL_ATTR_Field        = "@C056_NAME_1_QL_ATTR" ;
  public static final String LY56_NAME_2_ATTR_Field           = "@C056_NAME_2_ATTR" ;
  public static final String LY56_NAME_2_QL_ATTR_Field        = "@C056_NAME_2_QL_ATTR" ;
  public static final String LY56_FIL_CODE_ATTR_Field         = "@C056_FIL_CODE_ATTR" ;
  public static final String LY56_TF_CODE_ATTR_Field          = "@C056_TF_CODE_ATTR" ;
  public static final String LY56_STATE_CODE_ATTR_Field       = "@C056_STATE_CODE_ATTR" ;
  public static final String LY56_DOL_ATTR_Field              = "@C056_DOL_ATTR" ;
  public static final String LY56_CAT_ATTR_Field              = "@C056_CAT_ATTR" ;
  public static final String LY56_PCS_CAT_ATTR_Field          = "@C056_PCS_CAT_ATTR" ;
  public static final String LY56_NAIC_CODE_ATTR_Field        = "@C056_NAIC_CODE_ATTR" ;
  public static final String LY56_NAIC_QUAL_ATTR_Field        = "@C056_NAIC_QUAL_ATTR" ;
  public static final String LY56_PTT_AMT_ATTR                = "@C056_PTT_AMT_ATTR";
  public static final String LY56_OUTST_AMT_ATTR              = "@C056_OUTST_AMT_ATTR";
  public static final String LY56_OUTST_AMT_TOT_QL_ATTR       = "@C056_OUTST_TOT_QL_ATTR"; //"@C056_OUTST_TOT_QL_ATTR";        // added for CR6
  public static final String LY56_COMMAND_ATTRIBUTES_Table    = "#C056_COMMAND_ATTRIBUTES[]" ;
  public static final String LY56_DELETE_ATTR_Field           = "@C056_DELETE_ATTR" ;
  public static final String LY56_DEL_BD_ATTR_Field           = "@C056_DEL_BD_ATTR" ;
  public static final String LY56_NEW_BD_ATTR_Field           = "@C056_NEW_BD_ATTR" ;
  public static final String LY56_FINISH_ATTR_Field           = "@C056_FINISH_ATTR" ;
  public static final String LY56_NEXT_CURR_ATTR_Field        = "@C056_NEXT_CURR_ATTR" ;
  public static final String LY56_PREV_ATTR_Field             = "@C056_PREV_ATTR" ;
  public static final String LY56_NEXT_ATTR_Field             = "@C056_NEXT_ATTR" ;

  // LY57 input keys
  public static final String LY57_SESSION_NO                = "@C057_SESSION_NO";
  public static final String LY57_FIELD_VALUES              = "#C057_FIELD_VALUES[]";
  public static final String LY57_BREAKDOWN_TABLE           = "#C057_BREAKDOWN_TABLE[]";
  public static final String LY57_COR                       = "@C057_COR";
  public static final String LY57_DELETE_IND                = "@C057_DELETE_IND";
  public static final String LY57_STAT_SPLIT_NO             = "@C057_STAT_SPLIT_NO";
  public static final String LY57_BREAKDOWN_NO              = "@C057_BREAKDOWN_NO";
  public static final String LY57_MOVE_REF                  = "@C057_MOVE_REF";
  public static final String LY57_NAME_1                    = "@C057_NAME_1";
  public static final String LY57_NAME_1_QUAL               = "@C057_NAME_1_QUAL";
  public static final String LY57_NAME_2                    = "@C057_NAME_2";
  public static final String LY57_NAME_2_QUAL               = "@C057_NAME_2_QUAL";
  public static final String LY57_FIL_CODE                  = "@C057_FIL_CODE";
  public static final String LY57_TF_CODE                   = "@C057_TF_CODE";
  public static final String LY57_STATE_CODE                = "@C057_STATE_CODE";
  public static final String LY57_LOSS_DATE_FROM            = "@C057_LOSS_DATE_FROM";
  public static final String LY57_LOSS_DATE_TO              = "@C057_LOSS_DATE_TO";
  public static final String LY57_LOSS_DATE_QUAL            = "@C057_LOSS_DATE_QUAL";
  public static final String LY57_CAT_CODE                  = "@C057_CAT_CODE";
  public static final String LY57_PCS_CAT_CODE              = "@C057_PCS_CAT_CODE";
  public static final String LY57_NAIC_CODE                 = "@C057_NAIC_CODE";
  public static final String LY57_NAIC_QUAL                 = "@C057_NAIC_QUAL";
  public static final String LY57_PTT_AMT_TOTAL             = "@C057_PTT_AMT_TOTAL";
  public static final String LY57_OUTST_AMT                 = "@C057_OUTST_AMT";

  // LY57 output keys
  public static final String LY57_ERROR_INDS                = "#C057_ERROR-INDS[]" ;
  public static final String LY57_BREAKDOWN_Errs            = "#C057_BREAKDOWN_ERRS[]" ;

  // LY58 input keys
  public static final String LY58_SESSION_NO                = "@C058_SESSION_NO";
  public static final String LY58_FIELD_VALUES              = "#C058_FIELD_VALUES[]";
  public static final String LY58_BREAKDOWN_TABLE           = "#C058_BREAKDOWN_TABLE[]";
  public static final String LY58_COR                       = "@C058_COR";
  public static final String LY58_DELETE_IND                = "@C058_DELETE_IND";
  public static final String LY58_STAT_SPLIT_NO             = "@C058_STAT_SPLIT_NO";
  public static final String LY58_BREAKDOWN_NO              = "@C058_BREAKDOWN_NO";
  public static final String LY58_MOVE_REF                  = "@C058_MOVE_REF";
  public static final String LY58_NAME_1                    = "@C058_NAME_1";
  public static final String LY58_NAME_1_QUAL               = "@C058_NAME_1_QUAL";
  public static final String LY58_NAME_2                    = "@C058_NAME_2";
  public static final String LY58_NAME_2_QUAL               = "@C058_NAME_2_QUAL";
  public static final String LY58_FIL_CODE                  = "@C058_FIL_CODE";
  public static final String LY58_TF_CODE                   = "@C058_TF_CODE";
  public static final String LY58_STATE_CODE                = "@C058_STATE_CODE";
  public static final String LY58_LOSS_DATE_FROM            = "@C058_LOSS_DATE_FROM";
  public static final String LY58_LOSS_DATE_TO              = "@C058_LOSS_DATE_TO";
  public static final String LY58_LOSS_DATE_QUAL            = "@C058_LOSS_DATE_QUAL";
  public static final String LY58_CAT_CODE                  = "@C058_CAT_CODE";
  public static final String LY58_PCS_CAT_CODE              = "@C058_PCS_CAT_CODE";
  public static final String LY58_NAIC_CODE                 = "@C058_NAIC_CODE";
  public static final String LY58_NAIC_QUAL                 = "@C058_NAIC_QUAL";
  public static final String LY58_PTT_AMT_TOTAL             = "@C058_PTT_AMT_TOTAL";
  public static final String LY58_OUTST_AMT                 = "@C058_OUTST_AMT";

  // LY59 input keys
  public static final String LY59_SessionID_Field           = "@C059_SESSION_NO";

  // LY59 output keys
  public static final String LY59_SCREEN_MODE_Field      = "@C059_SCREEN_MODE" ;
  public static final String LY59_FIELD_VALUES_Table     = "#C059_FIELD_VALUES[]";
  public static final String LY59_XCR_Field     	 = "@C059_XCR";
  public static final String LY59_UCR_Field              = "@C059_UCR";
  public static final String LY59_TR_Field               = "@C059_TR";
  public static final String LY59_ORIG_BKR_Field         = "@C059_ORIG_BKR";
  public static final String LY59_CURRENCY_DETAILS_Table = "#C059_CURRENCY_DETAILS[]";
  public static final String LY59_ORIG_CURR_Field        = "@C059_ORIG_CURR";
  public static final String LY59_ORIG_REF_Field         = "@C059_ORIG_REF";
  public static final String LY59_BREAKDOWN_DETS_Table   = "#C059_BREAKDOWN_DETS[]";
  public static final String LY59_COR_Field              = "@C059_COR";
  public static final String LY59_MOVE_REF_Field         = "@C059_MOVE_REF";
  public static final String LY59_OUTST_AMT_Field        = "@C059_OUTST_AMT";
  public static final String LY59_COMMAND_ATTRIBUTES_Table = "#C059_COMMAND_ATTRIBUTES[]";
  public static final String LY59_RELEASE_ATTR_Field     = "@C059_RELEASE_ATTR";
  public static final String LY59_HOLD_ATTR_Field        = "@C059_HOLD_ATTR";
  public static final String LY59_DELETE_ATTR_Field      = "@C059_DELETE_ATTR";
  public static final String LY59_EXIT_ATTR_Field        = "@C059_EXIT_ATTR";

  // LY61 input keys
  public static final String LY61_SessionID_Field           = "@C061_SESSION_NO";
  public static final String LY61_FILE_SEEN_IND_Field       = "@C061_FILE_SEEN_IND";

  // LY62 input keys
  public static final String LY62_SessionID_Field           = "@C062_SESSION_NO";

  // LY62 output keys
  public static final String LY62_SCREEN_MODE               = "@C062_SCREEN_MODE";
  public static final String LY62_FIELD_VALUES_Table        = "#C062_FIELD_VALUES[]";
  public static final String LY62_XCR_Field                 = "@C062_XCR";
  public static final String LY62_UCR_Field                 = "@C062_UCR";
  public static final String LY62_TR_Field                  = "@C062_TR";
  public static final String LY62_PAYEE_BKR_Field           = "@C062_PAYEE_BKR";
  public static final String LY62_PAID_BY_CHEQUE_Field      = "@C062_PAID_BY_CHEQUE";
  public static final String LY62_CURRENCY_DETAILS_Table    = "#C062_CURRENCY_DETAILS[]";
  public static final String LY62_CURR_NO_Field             = "@C062_CURR_NO";
  public static final String LY62_SDN_NO_Field              = "@C062_SDN_NO";
  public static final String LY62_ORIG_CURR_Field           = "@C062_ORIG_CURR";
  public static final String LY62_SETT_CURR_Field           = "@C062_SETT_CURR";
  public static final String LY62_ORIG_REF_Field            = "@C062_ORIG_REF";
  public static final String LY62_COLLECTION_DETS_Table     = "#C062_COLLECTION_DETS[]";
  public static final String LY62_STAT_SPLIT_NO_Field       = "@C062_STAT_SPLIT_NO";
  public static final String LY62_TDN_REF_Field             = "@C062_TDN_REF";
  public static final String LY62_TDN_ATTR_Field            = "@C062_TDN_ATTR";
  public static final String LY62_PTT_AMT_Field             = "@C062_PTT_AMT";
  public static final String LY62_OUTST_AMT_Field           = "@C062_OUTST_AMT";
  public static final String LY62_CLAIM_AMT_SETT_Field      = "@C062_CLAIM_AMT_SETT";
  public static final String LY62_COMMAND_ATTRIBUTES_Table  = "#C062_COMMAND_ATTRIBUTES[]";
  public static final String LY62_RELEASE_ATTR_Field        = "@C062_RELEASE_ATTR";
  public static final String LY62_HOLD_ATTR_Field           = "@C062_HOLD_ATTR";
  public static final String LY62_HIDE_RATE_Field           = "@C062_HIDE_RATE";
  public static final String LY62_DELETE_ATTR_Field         = "@C062_DELETE_ATTR";
  public static final String LY62_EXIT_ATTR_Field           = "@C062_EXIT_ATTR";
  public static final String LY62_TREASURY_RATE_Field       = "@C062_TREASURY_RATE";
  public static final String LY62_TREASURY_ATTR_Field       = "@C062_TREASURY_ATTR";

  public static final String LY62_CCVC_ATTR_Field           = "@C062_CCVC_ATTR";

  // LY63 input keys
  public static final String LY63_SessionID_Field           = "@C063_SESSION_NO";

  // LY64 input keys
  public static final String LY64SessionIDField             = "@C064_SESSION_NO";
  public static final String LY64_PREV_PRESSED_Field        = "@C064_PREV_PRESSED";
  public static final String LY64_NEXT_PRESSED_Field        = "@C064_NEXT_PRESSED";
  public static final String LY64_START_KEY_Table           = "#C064_START_KEY[]";
  public static final String LY64_START_UCR_Field           = "@C064_START_UCR";
  public static final String LY64_START_SYS_REF_Field       = "@C064_START_SYS_REF";

  // LY64 output keys
  public static final String LY64_SCREEN_MODE               = "@C064_SCREEN_MODE";
  public static final String LY64_FIELD_VALUES              = "#C064_FIELD_VALUES[]";
  public static final String LY64_XCR                       = "@C064_XCR";
  public static final String LY64_UCR                       = "@C064_UCR";
  public static final String LY64_TR                        = "@C064_TR";
  public static final String LY64_ORIG_REF_1                = "@C064_ORIG_REF_1";
  public static final String LY64_ORIG_REF_2                = "@C064_ORIG_REF_2";
  public static final String LY64_ORIG_REF_3                = "@C064_ORIG_REF_2";
  public static final String LY64_ORIG_BKR                  = "@C064_ORIG_BKR";
  public static final String LY64_PEER_REV_IND              = "@C064_PEER_REV_IND";
  public static final String LY64_COMPONENT_CLAIMS          = "#C064_COMPONENT_CLAIMS[]";
  public static final String LY64_COMP_SYS_REF              = "@C064_COMP_SYS_REF";
  public static final String LY64_INCLUDE_IND               = "@C064_INCLUDE_IND";
  public static final String LY64_COMP_UCR                  = "@C064_COMP_UCR";
  public static final String LY64_NAME_1                    = "@C064_NAME_1";
  public static final String LY64_NAME_2                    = "@C064_NAME_2";
  public static final String LY64_LOSS_DATE_FROM            = "@C064_LOSS_DATE_FROM";
  public static final String LY64_CLAIM_DATE_FROM           = "@C064_CLAIM_DATE_FROM";
  public static final String LY64_BKR_REF_1                 = "@C064_BKR_REF_1";
  public static final String LY64_PROC_IND                  = "@C064_PROC_IND";
  public static final String LY64_FIELD_ATTRIBUTES          = "#C064_FIELD_ATTRIBUTES[]";
  public static final String LY64_INCLUDE_ATTR              = "@C064_INCLUDE_ATTR";
  public static final String LY64_PREV_ATTR                 = "@C064_PREV_ATTR";
  public static final String LY64_NEXT_ATTR                 = "@C064_NEXT_ATTR";
  public static final String LY64_COMP_ATTRIBUTES           = "#C064_COMP_ATTRIBUTES[]";
  public static final String LY64_PTT_AMT_TARGET            = "@C064_PTT_AMT_TARGET";
  public static final String LY64_OUT_AMT_TARGET            = "@C064_OUT_AMT_TARGET";
  public static final String LY64_PTT_AMT_ACTUAL            = "@C064_PTT_AMT_ACTUAL";
  public static final String LY64_OUT_AMT_ACTUAL            = "@C064_OUT_AMT_ACTUAL";
  public static final String LY64_COR                       = "@C064_COR";

  // LY65 input keys
  public static final String LY65_SessionID_Field           = "@C065_SESSION_NO";
  public static final String LY65_PROCESS_IND               = "@C065_PROCESS_IND";

  // LY65 output keys
  public static final String LY65_PROG_STATUS               = "@C065_PROG_STATUS";

  // LY66 input keys
  public static final String LY66_SessionID_Field           = "@C066_SESSION_NO";
  public static final String LY66_COMP_SYS_REF_Field        = "@C066_COMP_SYS_REF";
  public static final String LY66_COMP_SESSION_NO           = "@C066_COMP_SESSION_NO";

  // LY67 input keys
  public static final String LY67_SessionID_Field           = "@C067_SESSION_NO";

  // LY67 output keys
  public static final String LY67_SCREEN_MODE               = "@C067_SCREEN_MODE";
  public static final String LY67_FIELD_VALUES              = "#C067_FIELD_VALUES[]";
  public static final String LY67_XCR                       = "@C067_XCR";
  public static final String LY67_UCR                       = "@C067_UCR";
  public static final String LY67_TR                        = "@C067_TR";
  public static final String LY67_ORIG_BKR                  = "@C067_ORIG_BKR";
  public static final String LY67_CURRENCY_COUNT            = "@C067_CURRENCY_COUNT";
  public static final String LY67_CURRENCY_DETAILS          = "#C067_CURRENCY_DETAILS[]";
  public static final String LY67_ORIG_CURR                 = "@C067_ORIG_CURR";
  public static final String LY67_ORIG_REF                  = "@C067_ORIG_REF";
  public static final String LY67_TOTAL_PTT                 = "@C067_TOTAL_PTT";
  public static final String LY67_COMPONENT_CLAIMS          = "#C067_COMPONENT_CLAIMS[]";
  public static final String LY67_COMP_UCR                  = "@C067_COMP_UCR";
  public static final String LY67_COMP_TR                   = "@C067_COMP_TR";
  public static final String LY67_NAME_1                    = "@C067_NAME_1";
  public static final String LY67_NAME_2                    = "@C067_NAME_2";
  public static final String LY67_PTT_AMT                   = "@C067_PTT_AMT";
  public static final String LY67_OUTST_AMT                 = "@C067_OUTST_AMT";

  // LY68 input keys
  public static final String LY68_SessionID_Field           = "@C068_SESSION_NO";

  // LY68 output keys
  public static final String LY68_HIST_SESSION_NO           = "@C068_HIST_SESSION_NO";

  // LY69 input keys
  public static final String LY69_SESSION_NO                = "@C069_SESSION_NO";
  public static final String LY69_NEXT_PRESSED              = "@C069_NEXT_PRESSED";
  public static final String LY69_PREV_PRESSED              = "@C069_PREV_PRESSED";
  public static final String LY69_START_SYS_REF             = "@C069_START_SYS_REF";

 // LY69 output keys
  public static final String LY69_PREV_ATTR_Field        = "@C069_PREV_ATTR";
  public static final String LY69_NEXT_ATTR_Field        = "@C069_NEXT_ATTR";

  public static final String LY69_FIELD_VALUES_Table     = "#C069_FIELD_VALUES[]";

  public static final String LY69_XCR_Field              = "@C069_XCR";
  public static final String LY69_UCR_Field              = "@C069_UCR";
  public static final String LY69_ORIG_BKR_Field         = "@C069_ORIG_BKR";
  public static final String LY69_PEER_REV_IND_Field     = "@C069_PEER_REV_IND";
  public static final String LY69_CURRENCY_COUNT_Field   = "@C069_CURRENCY_COUNT";

  public static final String LY69_CURRENCY_DETAILS_Table = "#C069_CURRENCY_DETAILS[]";
  public static final String LY69_ORIG_CURR_Field        = "@C069_ORIG_CURR";
  public static final String LY69_ORIG_REF_Field         = "@C069_ORIG_REF";
  public static final String LY69_TOTAL_PAID_Field       = "@C069_TOTAL_PAID";

  public static final String LY69_TRANSACTION_DETS_Table = "#C069_TRANSACTION_DETS[]";
  public static final String LY69_TR_SELECT_ATTR_Field   = "@C069_TR_SELECT_ATTR";
  public static final String LY69_UCR_TR_SYS_REF_Field   = "@C069_UCR_TR_SYS_REF";
  public static final String LY69_SEQ_NO_Field           = "@C069_SEQ_NO";
  public static final String LY69_TR_Field               = "@C069_TR";
  public static final String LY69_CURR_PRESENT_Field     = "@C069_CURR_PRESENT";
  public static final String LY69_PTT_AMT_Field          = "@C069_PTT_AMT";
  public static final String LY69_OUTST_AMT_Field        = "@C069_OUTST_AMT";
  public static final String LY69_OUTST_QUAL_Field       = "@C069_OUTST_QUAL";
  public static final String LY69_TRANS_DATE_Field       = "@C069_TRANS_DATE";
  public static final String LY69_TRANS_STATUS_Field     = "@C069_TRANS_STATUS";

  // LY70 input keys
  public static final String LY70_SessionID_Field           = "@C070_SESSION_NO";
  public static final String LY70_NEXT_PRESSED_Field        = "@C070_NEXT_PRESSED";
  public static final String LY70_PREV_PRESSED_Field        = "@C070_PREV_PRESSED";
  public static final String LY70_START_KEY_Table           = "#C070_START_KEY[]";
  public static final String LY70_START_SYS_REF_Field       = "@C070_START_SYS_REF";
  public static final String LY70_START_CURR_NO_Field       = "@C070_START_CURR_NO";
  public static final String LY70_START_SDN_NO_Field        = "@C070_START_SDN_NO";
  public static final String LY70_START_SPLIT_NO_Field      = "@C070_START_SPLIT_NO";
  public static final String LY70_START_BDOWN_NO_Field      = "@C070_START_BDOWN_NO";

  // LY70 output keys- some of which are in the input keys listing above.
  public static final String LY70_PREV_ATTR_Field  	    = "@C070_PREV_ATTR";
  public static final String LY70_NEXT_ATTR_Field           = "@C070_NEXT_ATTR";
  public static final String LY70_FIELD_VALUES_Table        = "#C070_FIELD_VALUES[]";
  public static final String LY70_XCR_Field        	    = "@C070_XCR";
  public static final String LY70_UCR_Field        	    = "@C070_UCR";
  public static final String LY70_ORIG_REF_Field            = "@C070_ORIG_REF";
  public static final String LY70_ORIG_BKR_Field            = "@C070_ORIG_BKR";
  public static final String LY70_SIGNED_IND_Field          = "@C070_SIGNED_IND";
  public static final String LY70_ORIG_CURR_Field           = "@C070_ORIG_CURR";
  public static final String LY70_COR_Field                 = "@C070_COR";
  public static final String LY70_PEER_REV_IND_Field        = "@C070_PEER_REV_IND";
  public static final String LY70_TOTAL_PAID_Field          = "@C070_TOTAL_PAID";
  public static final String LY70_MOVEMENT_DETS_Table       = "#C070_MOVEMENT_DETS[]";
  public static final String LY70_UCR_TR_SYS_REF_Field      = "@C070_UCR_TR_SYS_REF";
  public static final String LY70_CURR_NO_Field             = "@C070_CURR_NO";
  public static final String LY70_SDN_NO_Field              = "@C070_SDN_NO";
  public static final String LY70_STAT_SPLIT_NO_Field       = "@C070_STAT_SPLIT_NO";
  public static final String LY70_BREAKDOWN_NO_Field        = "@C070_BREAKDOWN_NO";
  public static final String LY70_MOVE_REF_Field            = "@C070_MOVE_REF";
  public static final String LY70_MOVE_SEQ_NO_Field         = "@C070_MOVE_SEQ_NO";
  public static final String LY70_PTT_AMT_Field             = "@C070_PTT_AMT";
  public static final String LY70_OUTST_AMT_Field           = "@C070_OUTST_AMT";
  public static final String LY70_OUTST_QUAL_Field          = "@C070_OUTST_QUAL";
  public static final String LY70_TRANS_DATE_Field          = "@C070_TRANS_DATE";
  public static final String LY70_TAKE_DOWN_NO_Field        = "@C070_TAKE_DOWN_NO";
  public static final String LY70_USER_ID_Field             = "@C070_USER_ID";
  public static final String LY70_MOVE_STATUS_Field         = "@C070_MOVE_STATUS";
  public static final String LY70_MOVE_SELECT_ATTR_Field    = "@C070_MOVE_SELECT_ATTR";

  // LY71 input keys
  public static final String LY71SessionIDField             = "@C071_SESSION_NO";
  public static final String LY71_GROUP_SCREEN_FIELD        = "@C071_GROUP_SCREEN" ;
  // LY71 output keys
  public static final String LY71_HIST_SESSION_NO_FIELD     = "@C071_HIST_SESSION_NO" ;
  public static final String LY71_GROUP_REF_FIELD           = "@C071_GROUP_REF" ;

  // LY72 input keys
  public static final String LY72SessionIDField             = "@C072_SESSION_NO";
  public static final String LY72_GROUP_REF_FIELD           = "@C072_GROUP_REF" ;
  // LY72 output keys
  public static final String LY72_GROUP_TYPE_FIELD          = "@C072_GROUP_TYPE" ;
  public static final String LY72_GROUP_CONTENTS_TABLE      = "#C072_GROUP_CONTENTS[]" ;
  public static final String LY72_UCR_OSND_FIELD            = "@C072_UCR_OSND" ;

  // LY73 input keys
  public static final String LY73SessionIDField             = "@C073_SESSION_NO";
  public static final String LY73_GROUP_REF_Field           = "@C073_GROUP_REF";
  public static final String LY73_GROUP_CONTENTS_Table      = "#C073_GROUP_CONTENTS[]";
  public static final String LY73_UCR_OSND_Field            = "@C073_UCR_OSND";
  public static final String LY73_DELETE_IND_Field          = "@C073_DELETE_IND";

  // LY74 input keys
  public static final String LY74SessionIDField             = "@C074_SESSION_NO";
  public static final String LY74_GROUP_REF_Field           = "@C074_GROUP_REF";
  public static final String LY74_GROUP_CONTENTS_Table      = "#C074_GROUP_CONTENTS[]";
  public static final String LY74_UCR_OSND_Field            = "@C074_UCR_OSND";
  public static final String LY74_DELETE_IND_Field          = "@C074_DELETE_IND";

  // LY75 input keys
  public static final String LY75SessionIDField             = "@C075_SESSION_NO";
  public static final String LY75_FIELD_VALUES_Table        = "#C075_FIELD_VALUES[]";
  public static final String LY75_GROUP_REF_Field           = "@C075_GROUP_REF";

  // LY75 output keys
  public static final String LY75_GROUP_TYPE_Field      = "@C075_GROUP_TYPE";
  public static final String LY75_CURRENCY_COUNT_Field  = "@C075_CURRENCY_COUNT";
  public static final String LY75_CURRENCY_DETAILS_Table= "#C075_CURRENCY_DETAILS[]";
  public static final String LY75_ORIG_CURR_Field       = "@C075_ORIG_CURR";
  public static final String LY75_PAID_AMT_TOTAL_Field  = "@C075_PAID_AMT_TOTAL";
  public static final String LY75_OUTST_AMT_TOTAL_Field = "@C075_OUTST_AMT_TOTAL";
  public static final String LY75_TRANSACTION_DETS_Table= "#C075_TRANSACTION_DETS[]";
  public static final String LY75_UCR          		= "@C075_UCR";
  public static final String LY75_PTT_AMT          	= "@C075_PTT_AMT";
  public static final String LY75_OUTST_AMT          	= "@C075_OUTST_AMT";
  public static final String LY75_ADD_ATTR_Field      	= "@C075_ADD_ATTR";

  // LY76 input keys
  public static final String LY76SessionIDField         = "@C076_SESSION_NO";

  // LY76 output keys
  public static final String LY76_Group_Ref_Field       = "@C076_GROUP_REF";

  // LY77 input keys
  public static final String LY77_SESSION_NO            = "@C077_SESSION_NO";

  // LY77 output keys
  public static final String LY77_CURRENCY_DETAILS_Table = "#C077_CURRENCY_DETAILS[]";
  public static final String LY77_ORIG_CURR             = "@C077_ORIG_CURR";
  public static final String LY77_PAID_AMT              = "@C077_PAID_AMT";
  public static final String LY77_SETT_CURR             = "@C077_SETT_CURR";
  public static final String LY77_ORIG_RATE_EX          = "@C077_ORIG_RATE_EXCH";
  public static final String LY77_ORIG_SETT_AM          = "@C077_ORIG_SETT_AMT";
  public static final String LY77_REV_RATE_EXC          = "@C077_REV_RATE_EXCH";
  public static final String LY77_REV_SETT_AMT          = "@C077_REV_SETT_AMT";

  public static final String LY77_CURRENCY_ATTRS_Table  = "#C077_CURRENCY_ATTRS[]";
  public static final String LY77_REV_ROE_ATTR          = "@C077_REV_ROE_ATTR";
  public static final String LY77_REV_AMT_ATTR          = "@C077_REV_AMT_ATTR";

  // LY78 input keys
  public static final String LY78_SESSION_NO                = "@C078_SESSION_NO";
  public static final String LY78_CURRENCY_DETAILS          = "#C078_CURRENCY_DETAILS[]";
  public static final String LY78_REV_RATE_EXCH             = "@C078_REV_RATE_EXCH";
  public static final String LY78_REV_SETT_AMT              = "@C078_REV_SETT_AMT";
  public static final String LY78_TR                        = "@C078_TR";

  // LY79 input keys
  public static final String LY79_SESSION_NO                = "@C079_SESSION_NO";
  public static final String LY79_REDUCE_OUTST_IND          = "@C079_REDUCE_OUTST_IND";
  public static final String LY79_TR                        = "@C079_TR";

  // LY80 input keys
  public static final String LY80_SESSION_NO                = "@C080_SESSION_NO";

  //LY80 output keys
  public static final String LY80_FIELD_VALUES              = "#C080_FIELD_VALUES[]";
  public static final String LY80_ORIG_NCU_CURR             = "@C080_ORIG_NCU_CURR";
  public static final String LY80_ORIG_CURR_NAME            = "@C080_ORIG_CURR_NAME";
  public static final String LY80_RATE_EXCH                 = "@C080_RATE_EXCH";
  public static final String LY80_MOVE_REF                  = "@C080_MOVE_REF";
  public static final String LY80_NCU_PRE_CONV              = "#C080_NCU_PRE_CONV[]";
  public static final String LY80_PTD_LOSS_NCU              = "@C080_PTD_LOSS_NCU";
  public static final String LY80_PTD_EXP_NCU               = "@C080_PTD_EXP_NCU";
  public static final String LY80_PTD_FEE_NCU               = "@C080_PTD_FEE_NCU";
  public static final String LY80_PTD_VAT_NCU               = "@C080_PTD_VAT_NCU";
  public static final String LY80_PTD_TOTAL_NCU             = "@C080_PTD_TOTAL_NCU";
  public static final String LY80_INCURRED_NCU              = "@C080_INCURRED_NCU";
  public static final String LY80_HIGH_EST_NCU              = "@C080_HIGH_EST_NCU";
  public static final String LY80_EURO_AT_CONV              = "#C080_EURO_AT_CONV[]";
  public static final String LY80_PTD_LOSS_EAC              = "@C080_PTD_LOSS_EAC";
  public static final String LY80_PTD_EXP_EAC               = "@C080_PTD_EXP_EAC";
  public static final String LY80_PTD_FEE_EAC               = "@C080_PTD_FEE_EAC";
  public static final String LY80_PTD_VAT_EAC               = "@C080_PTD_VAT_EAC";
  public static final String LY80_PTD_TOTAL_EAC             = "@C080_PTD_TOTAL_EAC";
  public static final String LY80_INCURRED_EAC              = "@C080_INCURRED_EAC";
  public static final String LY80_HIGH_EST_EAC              = "@C080_HIGH_EST_EAC";
  public static final String LY80_EURO_POST_CONV            = "#C080_EURO_POST_CONV[]";
  public static final String LY80_PTD_LOSS_EPC              = "@C080_PTD_LOSS_EPC";
  public static final String LY80_PTD_EXP_EPC               = "@C080_PTD_EXP_EPC";
  public static final String LY80_PTD_FEE_EPC               = "@C080_PTD_FEE_EPC";
  public static final String LY80_PTD_VAT_EPC               = "@C080_PTD_VAT_EPC";
  public static final String LY80_PTD_TOTAL_EPC             = "@C080_PTD_TOTAL_EPC";
  public static final String LY80_INCURRED_EPC              = "@C080_INCURRED_EPC";
  public static final String LY80_HIGH_EST_EPC              = "@C080_HIGH_EST_EPC";
  public static final String LY80_EURO_TOTAL_COMB           = "#C080_EURO_TOTAL_COMB[]";
  public static final String LY80_PTD_LOSS_ETOT             = "@C080_PTD_LOSS_ETOT";
  public static final String LY80_PTD_EXP_ETOT              = "@C080_PTD_EXP_ETOT";
  public static final String LY80_PTD_FEE_ETOT              = "@C080_PTD_FEE_ETOT";
  public static final String LY80_PTD_VAT_ETOT              = "@C080_PTD_VAT_ETOT";
  public static final String LY80_PTD_TOTAL_ETOT            = "@C080_PTD_TOTAL_ETOT";
  public static final String LY80_INCURRED_ETOT             = "@C080_INCURRED_ETOT";
  public static final String LY80_HIGH_EST_ETOT             = "@C080_HIGH_EST_ETOT";


  //   input keys
  public static final String LY81_SESSION_NO                = "@C081_SESSION_NO";

  // LY81 output keys
  // CCN 528 - BA - 24-03-2003 - Revised commarea definition
  public static final String LY81_FIELD_VALUES              = "#C081_FIELD_VALUES[]";
  public static final String LY81_ORIG_CURR                 = "@C081_ORIG_CURR" ;
  public static final String LY81_CCS_CURR                  = "@C081_CCS_CURR" ;
  public static final String LY81_OUTST_RATE_EXCH           = "@C081_OUTST_RATE_EXCH" ;
  public static final String LY81_PTD_AMT_ORIG              = "@C081_PTD_AMT_ORIG" ;
  public static final String LY81_PTD_CCS_AMT               = "@C081_PTD_CCS_AMT" ;
  public static final String LY81_PTT_AMT_ORIG              = "@C081_PTT_AMT_ORIG" ;
  public static final String LY81_RATE_EXCH                 = "@C081_RATE_EXCH" ;
  public static final String LY81_SETT_CURR                 = "@C081_SETT_CURR" ;
  public static final String LY81_TREASURY_RATE             = "@C081_TREASURY_RATE" ;
  public static final String LY81_CCS_SETT_AMT              = "@C081_CCS_SETT_AMT" ;
  // public static final String LY81_PTD_AMT_SETT           = "@C081_PTD_AMT_SETT";
  // public static final String LY81_CLAIM_AMT_SETT         = "@C081_CLAIM_AMT_SETT";

  // LY82 input keys
  public static final String LY82_SESSION_NO                = "@C082_SESSION_NO";
  public static final String LY82_HOLD_RELEASE_CODE         = "@C082_HOLD_RELEASE_CODE";
  public static final String LY82_CURR_NO                   = "@C082_CURR_NO";
  public static final String LY82_SDN_NO                    = "@C082_SDN_NO";
  public static final String LY82_STAT_SLPIT_NO             = "@C082_STAT_SPLIT_NO";
  public static final String LY82_TDN_REF                   = "@C082_TDN_REF";
  public static final String LY82_TDN_ATTR                  = "@C082_TDN_ATTR";
  public static final String LY82_CURRENCY_DETAILS          = "#C082_CURRENCY_DETAILS[]";
  public static final String LY82_COLLECTION_DETAILS        = "#C082_COLLECTION_DETAILS[]";
  public static final String LY82_TREASURY_RATE_Field       = "@C082_TREASURY_RATE";
  public static final String LY82_TREASURY_ATTR_Field       = "@C082_TREASURY_ATTR";

  // LY83 input keys
  public static final String LY83_SESSION_NO                = "@C083_SESSION_NO";

  // LY84 input keys
  public static final String LY84_SESSION_NO                = "@C084_SESSION_NO";
  // LY84 output keys
  public static final String LY84_UCR                       = "@C084_COPY_FROM_UCR";
  public static final String LY84_TR                        = "@C084_COPY_FROM_TR";

  // LY85 input keys
  public static final String LY85_SESSION_NO                = "@C085_SESSION_NO";

  // LY85 output keys
  public static final String LY85_DIARY_DATE                = "@C085_DIARY_DATE";

  // LY86 input keys
  public static final String LY86_SESSION_NO                = "@C086_SESSION_NO";
  public static final String LY86_DIARY_DATE                = "@C086_DIARY_DATE";

  // LY87 input keys
  public static final String LY87SessionIDField             = "@C087_SESSION_NO";

  // LY87 output keys
  public static final String LY87UsernameField              = "@C087_USER_NAME";
  public static final String LY87FieldValuesList            = "#C087_FIELD_VALUES[]";
  public static final String LY87BrokerRef1Field            = "@C087_BKR_REF_1";
  public static final String LY87LossDateFromField          = "@C087_LOSS_DATE_FROM";
  public static final String LY87LossDateToField            = "@C087_LOSS_DATE_TO";
  public static final String LY87Name1Field                 = "@C087_NAME_1";
  public static final String LY87Name2Field                 = "@C087_NAME_2";
  public static final String LY87UCRField                   = "@C087_UCR";
  public static final String LY87CommandAttrsList           = "#C087_COMMAND_ATTRS[]";
  public static final String LY87SchemeCanAttr              = "@C087_SCHEME_CAN_ATTR";

  // LY88 input keys
  public static final String LY88_SESSION_NO                = "@C088_SESSION_NO";
  public static final String LY88_TEXT_ID_Field             = "@C088_TEXT_ID";
  public static final String LY88_FIRST_CALL                = "@C088_FIRST_CALL";

  // LY88 output keys
  public static final String LY88_MORE_LINES                = "@C088_MORE_LINES";
  public static final String LY88_SCREEN_MODE               = "@C088_SCREEN_MODE";
  public static final String LY88_TEXT_TABLE                = "#C088_TEXT_TABLE[]";
  public static final String LY88_TEXT_TYPE                 = "@C088_TEXT_TYPE";
  public static final String LY88_TEXT_NARRATIVE            = "#C088_TEXT_NARRATIVE[]";
  public static final String LY88_TEXT_NARR                 = "@C088_TEXT_NARR";
  public static final String LY88_LINE_LENGTH               = "@C088_LINE_LENGTH";
  public static final String LY88_MAX_NO_LINES              = "@C088_MAX_NO_LINES";
  public static final String LY88_LINE_COUNT                = "@C088_LINE_COUNT";
  public static final String LY88_PROTECT_LINES             = "@C088_PROTECT_LINES";
  public static final String LY88_TEXT_LINES                = "#C088_TEXT_LINES[]";
  public static final String LY88_TEXT_LINE                 = "@C088_TEXT_LINE";

  // LY89 input keys
  public static final String LY89_SESSION_NO                = "@C089_SESSION_NO";
  public static final String LY89_TEXT_ID_Field             = "@C089_TEXT_ID";
  public static final String LY89_CALL_NUMBER_Field         = "@C089_CALL_NUMBER";
  public static final String LY89_TEXT_LINE_Table           = "#C089_TEXT_LINE[]";
  public static final String LY89_TEXT_LINE_Field           = "@C089_TEXT_LINE";
  // Remedy 177552 - Narrative lines 300 to 600
  // C089_LINE_COUNT not being explicitly populated.
  public static final String LY89_LINE_COUNT                = "@C089_LINE_COUNT" ;

  // LY90 input keys
  public static final String LY90_SessionID_Field           = "@C090_SESSION_NO";

  // LY91 input keys
  public static final String LY91_SessionID_Field           = "@C091_SESSION_NO";

  // LY91 output keys
  public static final String LY91_CURRENCY_TABLE             = "#C091_CURRENCY_TABLE[]";
  public static final String LY91_ORIG_CURR_Field           = "@C091_ORIG_CURR";
  public static final String LY91_SETT_CURR_Table           = "@C091_SETT_CURR";
  public static final String LY91_TREASURY_ATTR_Field       = "@C091_TREASURY_ATTR";

  // LY92 input keys
  public static final String LY92_SESSION_NO                = "@C092_SESSION_NO";
  public static final String LY92_CURRENCY_TABLE            = "#C092_CURRENCY_TABLE[]";
  public static final String LY92_ORIG_CURR                 = "@C092_ORIG_CURR";
  public static final String LY92_SETT_CURR                 = "@C092_SETT_CURR";
  public static final String LY92_TREASURY_RATE             = "@C092_TREASURY_RATE";
  public static final String LY92_REDUCE_OUTST_IND          = "@C092_REDUCE_OUTST_IND";
  public static final String LY92_TR                        = "@C092_TR";

  // LY93 input keys
  public static final String LY93SessionIDField             = "@C093_SESSION_NO";

  // LY94 input keys
  public static final String LY94SessionIDField             = "@C094_SESSION_NO";
  public static final String LY94OrigRefField               = "@C094_ORIG_REF";
  public static final String LY94ApRefField                 = "@C094_AP_REF";
  public static final String LY94AvailableMarkets           = "#C094_AVAILABLE_MARKETS[]";
  public static final String LY94LIDSMarketCountField       = "@C094_LIDS_MKT_COUNT";
  public static final String LY94LIDSMarketTable            = "#C094_LIDS_MARKET[]";

  public static final String LY94BureauLineField            = "@C094_BUREAU_LINE";
  public static final String LY94VersionNoField             = "@C094_VERSION_NO";
  public static final String LY94EffectiveDateField         = "@C094_EFFECTIVE_DATE";
  public static final String LY94MarketNarrField            = "@C094_MARKET_NARR";
  public static final String LY94MarketLineCountField       = "@C094_MKT_LINE_COUNT";

  public static final String LY94KeyValuesField             = "#C094_KEY_VALUES[]";

  // LY94 Table inputs - They dont need the @ or # signs!!
  public static final String LY94SNDTable                   = "C094_SND_TABLE";

  public static final String LY94ProgStatusField            = "@C094_PROG_STATUS";
  public static final String LY94RiskCodeField              = "@C094_RISK_CODE";
  public static final String LY94YearOfAccField             = "@C094_YEAR_OF_ACC";
  public static final String LY94UmrField                   = "@C094_UMR";
  public static final String LY94SlipOrder1Field            = "@C094_SLIP_ORDER_1";
  public static final String LY94SlipOrder2Field            = "@C094_SLIP_ORDER_2";
  public static final String LY94SlipTypeField              = "@C094_SLIP_TYPE";
  public static final String LY94LineSlipCHField            = "@C094_LINESLIP_CH";
  public static final String LY94InsuredField               = "@C094_INSURED";
  public static final String LY94ReinsuredField             = "@C094_REINSURED";
  public static final String LY94VesselAircraft             = "@C094_VESSEL_AIRCRAFT";
  public static final String LY94InterestField              = "@C094_INTEREST";
  public static final String LY94SiLimitField               = "@C094_SI_LIMIT";
  public static final String LY94ExcessLimitField           = "@C094_EXCESS_LIMIT";
  public static final String LY94SiCurrField                = "@C094_SI_CURR";
  public static final String LY94PerilsCondsField           = "@C094_PERILS_CONDS";
  public static final String LY94PolicyPeriodFromField      = "@C094_POLICY_PERIOD_FROM";
  public static final String LY94PolicyPeriodToField        = "@C094_POLICY_PERIOD_TO";
  public static final String LY94ValueCount                 = "@C094_VALUE_COUNT";

  public static final String LY94OrigBkr                    = "@C094_ORIG_BKR_CODE";
  public static final String LY94OrigCcy                    = "@C094_ORIG_CURR";
  public static final String LY94SettCcy                    = "@C094_SETT_CURR";
  public static final String LY94FilCode1                   = "@C094_FIL_CODE_1";
  public static final String LY94FilCode2                   = "@C094_FIL_CODE_2";
  public static final String LY94TfCode                     = "@C094_TF_CODE";
  public static final String LY94StateCode                  = "@C094_STATE_CODE";
  public static final String LY94NaicCode                   = "@C094_NAIC_CODE";
  public static final String LY94NaicQual                   = "@C094_NAIC_QUAL";
  public static final String LY94OtherTfCode                = "@C094_NON_US_TF_CODE";
  public static final String LY94CountryCode                = "@C094_CNTRY_CODE";
  public static final String LY94WarInd                     = "@C094_WAR_IND";
  public static final String LY94DtiCode                    = "@C094_DTI_CODE";
  public static final String LY94ValueOccurrence            = "#C094_VALUE_OCCURRENCE[]";

  // LY95 input keys
  public static final String LY95_SessionID_Field           = "@C095_SESSION_NO";

  // LY96 input keys
  public static final String LY96_SessionID_Field           = "@C096_SESSION_NO";

  // LY97 input keys
  public static final String LY97SessionIDField             = "@C097_SESSION_NO";

  // LY98 input keys
  public static final String LY98_SessionID_Field           = "@C098_SESSION_NO";

  // LY99 input keys
  public static final String LY99_SessionID_Field           = "@C099_SESSION_NO";
  public static final String LY99_COMP_SYS_REF              = "@C099_COMP_SYS_REF";
  public static final String LY99_INCLUDE_IND               = "@C099_INCLUDE_IND";

  // LZ01 input keys
  public static final String LZ01SessionIDField             = "@C100_SESSION_NO";
  public static final String LZ01OrigRefField               = "@C100_ORIG_REF";
  public static final String LZ01APRefField                 = "@C100_AP_REF";

  // LZ02 input keys
  public static final String LZ02_SessionID_Field           = "@C101_SESSION_NO";

  // LZ03 input keys
  public static final String LZ03_SessionID_Field           = "@C102_SESSION_NO";
  public static final String LZ03_CURR_NO_Field             = "@C102_CURR_NO";
  public static final String LZ03_SDN_NO_Field              = "@C102_SDN_NO";
  public static final String LZ03_STAT_SPLIT_NO_Field       = "@C102_STAT_SPLIT_NO";

  // LZ03 output keys
  public static final String LZ03_BREAKDOWN_DETS_Table      = "#C102_BREAKDOWN_DETS[]";
  public static final String LZ03_COR_Field                 = "@C102_COR";
  public static final String LZ03_MOVE_REF_Field            = "@C102_MOVE_REF";
  public static final String LZ03_PTT_AMT_BD_Field          = "@C102_PTT_AMT_BD";
  public static final String LZ03_OUTST_AMT_Field           = "@C102_OUTST_AMT_BD";
  public static final String LZ03_CLM_AMT_SETT_BD_Field     = "@C102_CLM_AMT_SETT_BD";

  // LZ04 input keys
  public static final String LZ04_SessionID_Field           = "@C103_SESSION_NO";

  // LZ05 input keys
  public static final String LZ05_SessionID_Field           = "@C104_SESSION_NO";
  public static final String LZ05_MARKET_CODE_Field         = "@C104_MARKET_CODE";
  public static final String LZ05_ORIG_CURR_Field           = "@C104_ORIG_CURR";

  // LZ06 input keys
  public static final String LZ06_SessionID_Field           = "@C105_SESSION_NO";

  // LZ07 keys
  public static final String LZ07_SESSION_NO                = "@C107_SESSION_NO";
  public static final String LZ07_PROG_STATUS               = "@C107_PROG_STATUS";
  public static final String LZ07_ORIG_REF_1                = "@C107_ORIG_REF_1";
  public static final String LZ07_ORIG_REF_2                = "@C107_ORIG_REF_2";
  public static final String LZ07_ORIG_REF_3                = "@C107_ORIG_REF_3";
  public static final String LZ07_CLASS_DATA                = "#C107_CLASS_DATA[]";
  public static final String LZ07_RISK_CODE_C               = "@C107_RISK_CODE_C";
  public static final String LZ07_RISK_CODE_DIFF            = "@C107_RISK_CODE_DIFF";
  public static final String LZ07_YEAR_OF_ACC_C             = "@C107_YEAR_OF_ACC_C";
  public static final String LZ07_YEAR_OF_ACC_DIFF          = "@C107_YEAR_OF_ACC_DIFF";
  public static final String LZ07_CLASS_COUNT               = "@C107_CLASS_COUNT";
  public static final String LZ07_CLASS_DETAILS             = "#C107_CLASS_DETAILS[]";
  public static final String LZ07_COR_C                     = "@C107_COR_C";
  public static final String LZ07_FIL_CODE_1_C              = "@C107_FIL_CODE_1_C";
  public static final String LZ07_FIL_CODE_1_DIFF           = "@C107_FILE_CODE_1_DIFF";
  public static final String LZ07_FIL_CODE_2_C              = "@C107_FIL_CODE_2_C";
  public static final String LZ07_FIL_CODE_2_DIFF           = "@C107_FIL_CODE_2_DIFF";
  public static final String LZ07_DTI_CODE_C                = "@C107_DTI_CODE_C";
  public static final String LZ07_DTI_CODE_DIFF             = "@C107_DTI_CODE_DIFF";
  public static final String LZ07_TF_CODE_C                 = "@C107_TF_CODE_C";
  public static final String LZ07_TF_CODE_DIFF              = "@C107_TF_CODE_DIFF";
  public static final String LZ07_OTHER_TF_C                = "@C107_OTHER_TF_C";
  public static final String LZ07_OTHER_TF_DIFF             = "@C107_OTHER_TF_DIFF";
  public static final String LZ07_ORIG_CURR_C               = "@C107_ORIG_CURR_C";
  public static final String LZ07_ORIG_CURR_DIFF            = "@C107_ORIG_CURR_DIFF";
  public static final String LZ07_CNTRY_CODE_C              = "@C107_CNTRY_CODE_C";
  public static final String LZ07_CNTRY_CODE_DIFF           = "@C107_CNTRY_CODE_DIFF";
  public static final String LZ07_LIDS_DATA                 = "#C107_LIDS_DATA[]";
  public static final String LZ07_RISK_CODE_L               = "@C107_RISK_CODE_L";
  public static final String LZ07_YEAR_OF_ACC_L             = "@C107_YEAR_OF_ACC_L";
  public static final String LZ07_LIDS_COUNT                = "@C107_LIDS_COUNT";
  public static final String LZ07_LIDS_DETAILS              = "#C107_LIDS_DETAILS[]";
  public static final String LZ07_FIL_CODE_1_L              = "@C107_FIL_CODE_1_L";
  public static final String LZ07_FIL_CODE_2_L              = "@C107_FIL_CODE_2_L";
  public static final String LZ07_DTI_CODE_L                = "@C107_DTI_CODE_L";
  public static final String LZ07_TF_CODE_L                 = "@C107_TF_CODE_L";
  public static final String LZ07_OTHER_TF_L                = "@C107_OTHER_TF_L";
  public static final String LZ07_ORIG_CURR_L               = "@C107_ORIG_CURR_L";
  public static final String LZ07_CNTRY_CODE_L              = "@C107_CNTRY_CODE_L";

  // LZ09 keys
  public static final String LZ09_SESSION_NO                = "@C108_SESSION_NO";
  public static final String LZ09_COMP_SYS_REF              = "@C108_COMP_SYS_REF";
  public static final String LZ09_COMPONENT_DETAILS         = "#C108_COMPONENT_DETAILS[]";
  public static final String LZ09_BREAKDOWN_COUNT           = "@C108_BREAKDOWN_COUNT";
  public static final String LZ09_BREAKDOWN_DETAILS         = "#C108_BREAKDOWN_DETAILS[]";
  public static final String LZ09_COR                       = "@C108_COR";
  public static final String LZ09_ORIG_CURR                 = "@C108_ORIG_CURR";
  public static final String LZ09_NAME_1                    = "@C108_NAME_1";
  public static final String LZ09_LOSS_DATE_FROM            = "@C108_LOSS_DATE_FROM";
  public static final String LZ09_LOSS_DATE_TO              = "@C108_LOSS_DATE_TO";
  public static final String LZ09_CLAIM_DATE_FROM           = "@C108_CLAIM_DATE_FROM";
  public static final String LZ09_CLAIM_DATE_TO             = "@C108_CLAIM_DATE_TO";
  public static final String LZ09_STATE_CODE                = "@C108_STATE_CODE";
  public static final String LZ09_CAT_CODE                  = "@C108_CAT_CODE";
  public static final String LZ09_PCS_CAT_CODE              = "@C108_PCS_CAT_CODE";
  public static final String LZ09_NAIC_CODE                 = "@C108_NAIC_CODE";
  public static final String LZ09_NAIC_QUAL                 = "@C108_NAIC_QUAL";
  public static final String LZ09_PTT_AMT                   = "@C108_PTT_AMT";
  public static final String LZ09_OUTST_AMT                 = "@C108_OUTST_AMT";

  // LZ10 input keys
  public static final String LZ10SessionIDField             = "@C109_SESSION_NO";

  // LZ11 input keys
  public static final String LZ11_SESSION_NO                = "@C110_SESSION_NO";

  // LZ12 input keys
  public static final String LZ12_SESSION_NO                = "@C111_SESSION_NO";

  // LZ12 output keys
  public static final String LZ12_FIELD_VALUES              = "#C111_FIELD_VALUES[]";
  public static final String LZ12_CURR_NARR_1               = "@C111_CURR_NARR_1";
  public static final String LZ12_NARR_CODE_1               = "@C111_NARR_CODE_1";
  public static final String LZ12_CURR_NARR_2A              = "@C111_CURR_NARR_2A";
  public static final String LZ12_NARR_CODE_2               = "@C111_NARR_CODE_2";
  public static final String LZ12_CURR_NARR_2B              = "@C111_CURR_NARR_2B";
  public static final String LZ12_FIELD_ATTRIBUTES          = "#C111_FIELD_ATTRIBUTES[]";
  public static final String LZ12_CURR_NARR_ATTR1           = "@C111_CURR_NARR_ATTR1";
  public static final String LZ12_NARR_CODE_ATTR1           = "@C111_NARR_CODE_ATTR1";
  public static final String LZ12_CURR_NARR_ATTR_2A         = "@C111_CURR_NARR_ATTR_2A";
  public static final String LZ12_NARR_CODE_ATTR2           = "@C111_NARR_CODE_ATTR2";
  public static final String LZ12_CURR_NARR_ATTR_2B         = "@C111_CURR_NARR_ATTR_2B";

  // LZ13 input keys
  public static final String LZ13_SESSION_NO                = "@C112_SESSION_NO";
  public static final String LZ13_FIELD_VALUES              = "#C112_FIELD_VALUES[]";
  public static final String LZ13_CURR_NARR_1               = "@C112_CURR_NARR_1";
  public static final String LZ13_NARR_CODE_1               = "@C112_NARR_CODE_1";
  public static final String LZ13_CURR_NARR_2A              = "@C112_CURR_NARR_2A";
  public static final String LZ13_NARR_CODE_2               = "@C112_NARR_CODE_2";
  public static final String LZ13_CURR_NARR_2B              = "@C112_CURR_NARR_2B";

  // LZ13 output keys
  public static final String LZ13_FIELD_ERRORS              = "#C112_FIELD_ERRORS[]";
  public static final String LZ13_CURR_NARR_ERR1            = "@C112_CURR_NARR_ERR1";
  public static final String LZ13_NARR_CODE_ERR1            = "@C112_NARR_CODE_ERR1";
  public static final String LZ13_CURR_NARR_ERR_2A          = "@C112_CURR_NARR_ERR_2A";
  public static final String LZ13_NARR_CODE_ERR2            = "@C112_NARR_CODE_ERR2";
  public static final String LZ13_CURR_NARR_ERR_2B          = "@C112_CURR_NARR_ERR_2B";

  // LZ14 input keys
  public static final String LZ14_SESSION_NO                = "@C113_SESSION_NO";
  public static final String LZ14_FIELD_VALUES              = "#C113_FIELD_VALUES[]";
  public static final String LZ14_CURR_NARR_1               = "@C113_CURR_NARR_1";
  public static final String LZ14_NARR_CODE_1               = "@C113_NARR_CODE_1";
  public static final String LZ14_CURR_NARR_2A              = "@C113_CURR_NARR_2A";
  public static final String LZ14_NARR_CODE_2               = "@C113_NARR_CODE_2";
  public static final String LZ14_CURR_NARR_2B              = "@C113_CURR_NARR_2B";

  // LZ50 input keys (Scheme Canada)
  public static final String LZ50_SessionID_Field           = "@C150_SESSION_NO";
  public static final String LZ50_FUNCTION                  = "@C150_FUNCTION";
  public static final String LZ50_SAVED_FLAG                = "@C150_SAVED_FLAG";
  public static final String LZ50_HEADER_BUS_CLASS          = "@C150_HEADER_BUS_CLASS";
  public static final String LZ50_PREV_PRESSED              = "@C150_PREV_PRESSED";
  public static final String LZ50_NEXT_PRESSED              = "@C150_NEXT_PRESSED";
  public static final String LZ50_FIELD_COUNT               = "@C150_FIELD_COUNT";
  public static final String LZ50_ROW_NUMBER                = "@C150_ROW_NUMBER";
  public static final String LZ50_PROCESS_FLAG              = "@C150_PROCESS_FLAG";
  public static final String LZ50_FLAG_CHANGED_IND          = "@C150_FLAG_CHANGED_IND";
  public static final String LZ50_DISPLAY_COUNTS            = "#C150_DISPLAY_COUNTS[]";
  public static final String LZ50_SCR_FIRST_ROW             = "@C150_SCR_FIRST_ROW";
  public static final String LZ50_SCR_LAST_ROW              = "@C150_SCR_LAST_ROW";
  public static final String LZ50_DB_TOTAL_ROWS             = "@C150_DB_TOTAL_ROWS";
  
  public static final String LZ50_STATS                     = "#C150_STATS[]";
  // Patrick Cogan 26/04/04 new commarea; changes for S456/S457
  public static final String LZ50_REPROC_THIS_RUN           = "@C150_REPROC_THIS_RUN";
  public static final String LZ50_XCS_THIS_RUN              = "@C150_XCS_THIS_RUN";
  public static final String LZ50_REPROC_TOTAL              = "@C150_REPROC_TOTAL";
  public static final String LZ50_XCS_TOTAL                 = "@C150_XCS_TOTAL";
  public static final String LZ50_FILLER                    = "@C150_FILLER";
  public static final String LZ50_FILLER1                   = "@C150_FILLER1";
  
  /* Patrick Cogan 26/04/04 old commarea; changes for S456/S457
  public static final String LZ50_DELETE_THIS_RUN           = "@C150_DELETE_THIS_RUN";
  public static final String LZ50_REJECT_THIS_RUN           = "@C150_REJECT_THIS_RUN";
  public static final String LZ50_INDIV_THIS_RUN            = "@C150_INDIV_THIS_RUN";
  public static final String LZ50_BLOCK_THIS_RUN            = "@C150_BLOCK_THIS_RUN";
  public static final String LZ50_ZEROS_THIS_RUN            = "@C150_ZEROS_THIS_RUN";
  public static final String LZ50_DELETE_TOTAL              = "@C150_DELETE_TOTAL";
  public static final String LZ50_REJECT_TOTAL              = "@C150_REJECT_TOTAL";
  public static final String LZ50_INDIV_TOTAL               = "@C150_INDIV_TOTAL";
  public static final String LZ50_BLOCK_TOTAL               = "@C150_BLOCK_TOTAL";
  public static final String LZ50_ZEROS_TOTAL               = "@C150_ZEROS_TOTAL";
  */
  
  // LZ50 output keys (Scheme Canada)
  public static final String LZ50_FIELD_VALUES              = "#C150_FIELD_VALUES[]";
  public static final String LZ50_TABLE_DATA                = "#C150_TABLE_DATA[]";
  public static final String LZ50_TABLE_ORIG_REF            = "@C150_TABLE_ORIG_REF";
  public static final String LZ50_TABLE_CCR                 = "@C150_TABLE_CCR";
  public static final String LZ50_TABLE_UCR                 = "@C150_TABLE_UCR";
  public static final String LZ50_TABLE_BLOCK_IND           = "@C150_TABLE_BLOCK_IND";
  public static final String LZ50_FILE_DATA                 = "#C150_FILE_DATA[]";
  public static final String LZ50_FILE_OSND                 = "@C150_FILE_OSND";
  public static final String LZ50_FILE_CCR                  = "@C150_FILE_CCR";
  public static final String LZ50_BUS_CLASS                 = "@C150_BUS_CLASS";
  public static final String LZ50_CHOLDER_NO                = "@C150_CHOLDER_NO";
  public static final String LZ50_CONTRACT_CODE             = "@C150_CONTRACT_CODE";
  public static final String LZ50_CONTRACT_YEAR             = "@C150_CONTRACT_YEAR";
  public static final String LZ50_BLOCK_NUMBER              = "@C150_BLOCK_NUMBER";
  public static final String LZ50_ERROR_NUMBER              = "@C150_ERROR_NUMBER";
  public static final String LZ50_ERROR_MESSAGE             = "@C150_ERROR_MESSAGE";
  public static final String LZ50_FIELD_ATTRIBUTES          = "#C150_FIELD_ATTRIBUTES[]";
  public static final String LZ50_PREV_ATTR                 = "@C150_PREV_ATTR";
  public static final String LZ50_NEXT_ATTR                 = "@C150_NEXT_ATTR";
  public static final String LZ50_AUTO_ATTR                 = "@C150_AUTO_ATTR";
  public static final String LZ50_COMMERCIAL_ATTR           = "@C150_COMMERCIAL_ATTR";
  public static final String LZ50_RESIDENTIAL_ATTR          = "@C150_RESIDENTIAL_ATTR";




  // Settlement Enquiry screens all defined below.
  // Devo and Ambrose November 2003 changes.
  // BA&PD: 24-11-2003: Settlement search screen


  // LZ15 input keys
  public static final String C114_SESSION_NO                = "@C114_SESSION_NO";
  // LZ15 output keys
  public static final String C114_HCSE_SESSION_NO           = "@C114_HCSE_SESSION_NO";
  public static final String C114_SEARCH_FIELDS             = "#C114_SEARCH_FIELDS[]";
  public static final String C114_TAKE_DOWN_NO              = "@C114_TAKE_DOWN_NO";
  public static final String C114_TAKE_DOWN_DATE            = "@C114_TAKE_DOWN_DATE";
  public static final String C114_ORIG_SIGNING_NO           = "@C114_ORIG_SIGNING_NO";
  public static final String C114_ORIG_SIGNING_DATE         = "@C114_ORIG_SIGNING_DATE";
  public static final String C114_YEAR_OF_ACC               = "@C114_YEAR_OF_ACC";
  public static final String C114_PAYEE_BKR                 = "@C114_PAYEE_BKR";
  public static final String C114_NAME_1                    = "@C114_NAME_1";
  public static final String C114_NAME_2                    = "@C114_NAME_2";

  // LZ16 input keys
  public static final String C115_SESSION_NO                = "@C115_SESSION_NO";
  public static final String C115_FIELD_VALUES              = "#C115_FIELD_VALUES[]";
  public static final String C115_INCLUDE_POST_IMPN_TDNS    = "@C115_INCLUDE_POST_IMPN_TDNS";
  public static final String C115_TAKE_DOWN_NO              = "@C115_TAKE_DOWN_NO";
  public static final String C115_TAKE_DOWN_DATE            = "@C115_TAKE_DOWN_DATE";
  public static final String C115_ORIG_SIGNING_NO           = "@C115_ORIG_SIGNING_NO";
  public static final String C115_ORIG_SIGNING_DATE         = "@C115_ORIG_SIGNING_DATE";
  public static final String C115_YEAR_OF_ACC               = "@C115_YEAR_OF_ACC";
  public static final String C115_PAYEE_BKR                 = "@C115_PAYEE_BKR";
  public static final String C115_COMP_BTW_FROM             = "@C115_COMP_BTW_FROM";
  public static final String C115_COMP_BTW_TO               = "@C115_COMP_BTW_TO";
  public static final String C115_NAME_1                    = "@C115_NAME_1";
  public static final String C115_NAME_1_PARTIAL_IND        = "@C115_NAME_1_PARTIAL_IND";
  public static final String C115_NAME_2                    = "@C115_NAME_2";
  public static final String C115_NAME_2_PARTIAL_IND        = "@C115_NAME_2_PARTIAL_IND";

  // LZ16 output keys
  public static final String C115_NO_OF_SEARCH_RESULTS      = "@C115_NO_OF_SEARCH_RESULTS";
  public static final String C115_SEARCH_RESULTS            = "#C115_SEARCH_RESULTS[]";
  public static final String C115_LIDS_TAKE_DOWN_NO         = "@C115_LIDS_TAKE_DOWN_NO";
  public static final String C115_LIDS_TAKE_DOWN_DATE       = "@C115_LIDS_TAKE_DOWN_DATE";
  public static final String C115_VERSION_NO                = "@C115_VERSION_NO";
  public static final String C115_LIDS_YEAR_OF_ACC          = "@C115_LIDS_YEAR_OF_ACC";
  public static final String C115_LIDS_PAYEE_BKR            = "@C115_LIDS_PAYEE_BKR";
  public static final String C115_LIDS_BKR_REF              = "@C115_LIDS_BKR_REF";
  public static final String C115_LIDS_HPC_SETT_AMT         = "@C115_LIDS_HPC_SETT_AMT";
  public static final String C115_LIDS_NAME_1               = "@C115_LIDS_NAME_1";
  public static final String C115_LIDS_NAME_1_QUAL          = "@C115_LIDS_NAME_1_QUAL";
  public static final String C115_LIDS_NAME_2               = "@C115_LIDS_NAME_2";
  public static final String C115_LIDS_NAME_2_QUAL          = "@C115_LIDS_NAME_2_QUAL";

  // LZ17 input keys
  public static final String C116_SESSION_NO                = "@C116_SESSION_NO";
  public static final String C116_SELECTED_VALUES           = "#C116_SELECTED_VALUES[]";
  public static final String C116_TAKE_DOWN_NO              = "@C116_TAKE_DOWN_NO";
  public static final String C116_TAKE_DOWN_DATE            = "@C116_TAKE_DOWN_DATE";
  public static final String C116_VERSION_NO                = "@C116_VERSION_NO";

  // LZ17 output keys
  public static final String C116_SETTLEMENT_DETAILS      = "#C116_SETTLEMENT_DETAILS[]";
  public static final String C116_OSND_NO                 = "@C116_OSND_NO";
  public static final String C116_OSND_DATE               = "@C116_OSND_DATE";
  public static final String C116_ORIG_BKR                = "@C116_ORIG_BKR";
  public static final String C116_ORIG_BKR_PSEUD          = "@C116_ORIG_BKR_PSEUD";
  public static final String C116_YEAR_OF_ACC             = "@C116_YEAR_OF_ACC";
  public static final String C116_COR                     = "@C116_COR";
  public static final String C116_CLAIM_STATUS            = "@C116_CLAIM_STATUS";
  public static final String C116_PAID_BY_CHEQUE          = "@C116_PAID_BY_CHEQUE";
  public static final String C116_CLM_REF                 = "@C116_CLM_REF";
  public static final String C116_PAYEE_BKR               = "@C116_PAYEE_BKR";
  public static final String C116_PAYEE_BKR_PSEUD         = "@C116_PAYEE_BKR_PSEUD";
  public static final String C116_BKR_REF_1               = "@C116_BKR_REF_1";
  public static final String C116_BKR_REF_2               = "@C116_BKR_REF_2";
  public static final String C116_DTI_CODE                = "@C116_DTI_CODE";
  public static final String C116_RISK_CODE               = "@C116_RISK_CODE";
  public static final String C116_MARKET_CODE             = "@C116_MARKET_CODE";
  public static final String C116_FIL_CODE_1              = "@C116_FIL_CODE_1";
  public static final String C116_FIL_CODE_2              = "@C116_FIL_CODE_2";
  public static final String C116_FIL_CODE_3              = "@C116_FIL_CODE_3";
  public static final String C116_TRUST_FUND_CODE         = "@C116_TRUST_FUND_CODE";
  public static final String C116_SCHEME_CODE             = "@C116_SCHEME_CODE";
  public static final String C116_ATTACHMENTS_IND         = "@C116_ATTACHMENTS_IND";
  public static final String C116_SETT_PERIOD             = "@C116_SETT_PERIOD";
  public static final String C116_ACTUAL_PAYMENT_DATE     = "@C116_ACTUAL_PAYMENT_DATE";
  public static final String C116_CONTRA_APD              = "@C116_CONTRA_APD";
  public static final String C116_LCO_CAT_CODE            = "@C116_LCO_CAT_CODE";
  public static final String C116_NON_SCM_ADV_IND         = "@C116_NON_SCM_ADV_IND";
  public static final String C116_BULK_IND                = "@C116_BULK_IND";
  public static final String C116_COMPLETED_DATE          = "@C116_COMPLETED_DATE";
  public static final String C116_CREATED_BY_USER         = "@C116_CREATED_BY_USER";
  public static final String C116_NAME_1                  = "@C116_NAME_1";
  public static final String C116_NAME_1_QUAL             = "@C116_NAME_1_QUAL";
  public static final String C116_NAME_2                  = "@C116_NAME_2";
  public static final String C116_NAME_2_QUAL             = "@C116_NAME_2_QUAL";
  public static final String C116_ORIG_CCY                = "@C116_ORIG_CCY";
  public static final String C116_SETT_CCY                = "@C116_SETT_CCY";
  public static final String C116_REDENOM_IND             = "@C116_REDENOM_IND";
  public static final String C116_HPC_ORDER_AMOUNT        = "@C116_HPC_ORDER_AMOUNT";
  public static final String C116_RATE_EXCH               = "@C116_RATE_EXCH";
  public static final String C116_HPC_SETT_AMOUNT         = "@C116_HPC_SETT_AMOUNT";
  public static final String C116_TOTAL_LINE              = "@C116_TOTAL_LINE";
  public static final String C116_BUREAU_SHARE_AMOUNT     = "@C116_BUREAU_SHARE_AMOUNT";
  public static final String C116_HPC_VAT_AMOUNT          = "@C116_HPC_VAT_AMOUNT";
  public static final String C116_WAR_AMOUNT              = "@C116_WAR_AMOUNT";
  public static final String C116_FIL_1_AMOUNT            = "@C116_FIL_1_AMOUNT";
  public static final String C116_FIL_2_AMOUNT            = "@C116_FIL_2_AMOUNT";
  public static final String C116_CCS_DETAILS_IND         = "@C116_CCS_DETAILS_IND";
  public static final String C116_CCS_DETAILS             = "#C116_CCS_DETAILS[]";
  public static final String C116_CCS_ORIG_CCY            = "@C116_CCS_ORIG_CCY";
  public static final String C116_CCS_SETT_CCY            = "@C116_CCS_SETT_CCY";
  public static final String C116_CCS_HPC_ORDER_AMOUNT     = "@C116_CCS_HPC_ORDER_AMOUNT";
  public static final String C116_ROE_TO_GBP               = "@C116_ROE_TO_GBP";
  public static final String C116_TREASURY_RATE            = "@C116_TREASURY_RATE";
  public static final String C116_CCS_TOT_SETT_GBP         = "@C116_CCS_TOT_SETT_GBP";
  public static final String C116_VAT_COUNT                = "@C116_VAT_COUNT";
  public static final String C116_VAT_DETAILS              = "#C116_VAT_DETAILS[]";
  public static final String C116_VAT_RATE                 = "@C116_VAT_RATE";
  public static final String C116_VAT_AMOUNT               = "@C116_VAT_AMOUNT";
  public static final String C116_NARRATIVE_COUNT          = "@C116_NARRATIVE_COUNT";
  public static final String C116_NARRATIVE_DETAILS        = "#C116_NARRATIVE_DETAILS[]";
  public static final String C116_NARRATIVE_LINE           = "@C116_NARRATIVE_LINE";
  public static final String C116_LEAD_UWR                 = "@C116_LEAD_UWR";
  public static final String C116_LEAD_UWR_PC              = "@C116_LEAD_UWR_PC";
  public static final String C116_CLAIM_TOTAL_LINE         = "@C116_CLAIM_TOTAL_LINE";
  public static final String C116_LIDS_TOTAL_LINE          = "@C116_LIDS_TOTAL_LINE";
  public static final String C116_NO_OF_LIDS_LINES         = "@C116_NO_OF_LIDS_LINES";
  public static final String C116_NO_OF_CLAIM_LINES        = "@C116_NO_OF_CLAIM_LINES";
  public static final String C116_MARKET_DETAILS           = "#C116_MARKET_DETAILS[]";
  public static final String C116_SIGNED_LINE_PC           = "@C116_SIGNED_LINE_PC";
  public static final String C116_SYND_NO                  = "@C116_SYND_NO";
  public static final String C116_SYND_REF                 = "@C116_SYND_REF";

  // LZ18 input keys
  public static final String C117_SESSION_NO                = "@C117_SESSION_NO";
  //LZ18 output keys
  public static final String C117_NEXT_PROGRAM              = "@C117_NEXT_PROGRAM";
  
  
  // LZ24 input keys
  public static final String LZ24_SESSION_NO             =      "@C122_SESSION_NO";
  public static final String LZ24_SCREEN_MODE            =      "@C122_SCREEN_MODE";
  public static final String LZ24_FIELD_VALUES           =      "#C122_FIELD_VALUES[]";
  public static final String LZ24_XCR                    =      "@C122_XCR";
  public static final String LZ24_UCR                    =      "@C122_UCR";
  public static final String LZ24_TR                     =      "@C122_TR";
  public static final String LZ24_ORIG_REF_1             =      "@C122_ORIG_REF_1";
  public static final String LZ24_ORIG_REF_2             =      "@C122_ORIG_REF_2";
  public static final String LZ24_ORIG_REF_3             =      "@C122_ORIG_REF_3";
  public static final String LZ24_ORIG_BKR               =      "@C122_ORIG_BKR";
  public static final String LZ24_SIGNED_IND             =      "@C122_SIGNED_IND";
  public static final String LZ24_PEER_REV_IND           =      "@C122_PEER_REV_IND";
  public static final String LZ24_PAYEE_BKR              =      "@C122_PAYEE_BKR";
  public static final String LZ24_PAID_BY_CHEQUE         =      "@C122_PAID_BY_CHEQUE";
  public static final String LZ24_BKR_PRES_DATE          =      "@C122_BKR_PRES_DATE";
  public static final String LZ24_LLOYDS_LEAD_IND        =      "@C122_LLOYDS_LEAD_IND";
  public static final String LZ24_LDR_PRES_DATE          =      "@C122_LDR_PRES_DATE";
  public static final String LZ24_BORD_IND               =      "@C122_BORD_IND";
  public static final String LZ24_DOL_IN_POL_Q           =      "@C122_DOL_IN_POL_Q";
  public static final String LZ24_CLAIM_IN_POL_Q         =      "@C122_CLAIM_IN_POL_Q";
  public static final String LZ24_CORRECT_IDENT_Q        =      "@C122_CORRECT_IDENT_Q";
  public static final String LZ24_DEDUCT_EXCESS_Q        =      "@C122_DEDUCT_EXCESS_Q";
  public static final String LZ24_COVERAGE_Q             =      "@C122_COVERAGE_Q";
  public static final String LZ24_CAUSE_CODE_Q           =      "@C122_CAUSE_CODE_Q";
  public static final String LZ24_LEAD_AGREEMENT_Q       =      "@C122_LEAD_AGREEMENT_Q";
  public static final String LZ24_MKT_AGREEMENT_Q        =      "@C122_MKT_AGREEMENT_Q";
  public static final String LZ24_POLICY_DOC_IND         =      "@C122_POLICY_DOC_IND";
  public static final String LZ24_SLIP_DOC_IND           =      "@C122_SLIP_DOC_IND";
  public static final String LZ24_COVER_DOC_IND          =      "@C122_COVER_DOC_IND";
  public static final String LZ24_LOSS_DETS_DOC_IND        =      "@C122_LOSS_DETS_DOC_IND";
  public static final String LZ24_OTHER_DOC_IND            =      "@C122_OTHER_DOC_IND";
  
  public static final String LZ24_FIELD_ATTRIBUTES       =      "#C122_FIELD_ATTRIBUTES[]";
  public static final String LZ24_XCR_ATTR               =      "@C122_XCR_ATTR";
  public static final String LZ24_UCR_ATTR               =      "@C122_UCR_ATTR";
  public static final String LZ24_TR_ATTR                =      "@C122_TR_ATTR";
  public static final String LZ24_ORIG_REF_ATTR1         =      "@C122_ORIG_REF_ATTR1";
  public static final String LZ24_ORIG_REF_ATTR2         =      "@C122_ORIG_REF_ATTR2";
  public static final String LZ24_ORIG_REF_ATTR3         =      "@C122_ORIG_REF_ATTR3";
  public static final String LZ24_ORIG_BKR_ATTR          =      "@C122_ORIG_BKR_ATTR";
  public static final String LZ24_SIGN_IND_ATTR          =      "@C122_SIGN_IND_ATTR";
  public static final String LZ24_PEER_REV_ATTR          =      "@C122_PEER_REV_ATTR";
  public static final String LZ24_PAYEE_BKR_ATTR         =      "@C122_PAYEE_BKR_ATTR";
  public static final String LZ24_PAID_BY_CH_ATTR        =      "@C122_PAID_BY_CH_ATTR";
  public static final String LZ24_BKR_DATE_ATTR          =      "@C122_BKR_DATE_ATTR";
  public static final String LZ24_LDR_DATE_ATTR          =      "@C122_LDR_DATE_ATTR";
  public static final String LZ24_SY_LEAD_ATTR           =      "@C122_SY_LEAD_ATTR";
  public static final String LZ24_BORD_IND_ATTR          =      "@C122_BORD_IND_ATTR";
  public static final String LZ24_DOL_IN_POL_ATTR        =      "@C122_DOL_IN_POL_ATTR";
  public static final String LZ24_CLM_IN_POL_ATTR        =      "@C122_CLM_IN_POL_ATTR";
  public static final String LZ24_CORRECT_ID_ATTR        =      "@C122_CORRECT_ID_ATTR";
  public static final String LZ24_DEDUCT_EX_ATTR         =      "@C122_DEDUCT_EX_ATTR";
  public static final String LZ24_COVERAGE_ATTR          =      "@C122_COVERAGE_ATTR";
  public static final String LZ24_CAUSE_CODE_ATTR        =      "@C122_CAUSE_CODE_ATTR";
  public static final String LZ24_LEAD_AGREE_ATTR        =      "@C122_LEAD_AGREE_ATTR";
  public static final String LZ24_MKT_AGREE_ATTR         =      "@C122_MKT_AGREE_ATTR";
  public static final String LZ24_POLICY_DOC_ATTR        =      "@C122_POLICY_DOC_ATTR";
  public static final String LZ24_SLIP_DOC_ATTR          =      "@C122_SLIP_DOC_ATTR";
  public static final String LZ24_COVER_DOC_ATTR         =      "@C122_COVER_DOC_ATTR";
  public static final String LZ24_LOSS_DETS_ATTR         =      "@C122_LOSS_DETS_ATTR";
  public static final String LZ24_OTHER_DOC_ATTR         =      "@C122_OTHER_DOC_ATTR";

  // LZ25 Input keys
  public static final String LZ25_SESSION_NO              =         "@C123_SESSION_NO";
  public static final String LZ25_FIELD_VALUES            =         "#C123_FIELD_VALUES[]";
  public static final String LZ25_XCR                     =         "@C123_XCR";
  public static final String LZ25_UCR                     =         "@C123_UCR";
  public static final String LZ25_TR                      =         "@C123_TR";
  public static final String LZ25_ORIG_REF_1              =         "@C123_ORIG_REF_1";
  public static final String LZ25_ORIG_REF_2              =         "@C123_ORIG_REF_2";
  public static final String LZ25_ORIG_REF_3              =         "@C123_ORIG_REF_3";
  public static final String LZ25_ORIG_BKR                =         "@C123_ORIG_BKR";
  public static final String LZ25_SIGNED_IND              =         "@C123_SIGNED_IND";
  public static final String LZ25_PEER_REV_IND            =         "@C123_PEER_REV_IND";
  public static final String LZ25_PAYEE_BKR               =         "@C123_PAYEE_BKR";
  public static final String LZ25_PAID_BY_CHEQUE          =         "@C123_PAID_BY_CHEQUE";
  public static final String LZ25_BKR_PRES_DATE           =         "@C123_BKR_PRES_DATE";
  public static final String LZ25_LDR_PRES_DATE           =         "@C123_LDR_PRES_DATE";
  public static final String LZ25_LLOYDS_LEAD_IND         =         "@C123_LLOYDS_LEAD_IND";
  public static final String LZ25_BORD_IND                =         "@C123_BORD_IND";
  public static final String LZ25_DOL_IN_POL_Q            =         "@C123_DOL_IN_POL_Q";
  public static final String LZ25_CLAIM_IN_POL_Q          =         "@C123_CLAIM_IN_POL_Q";
  public static final String LZ25_CORRECT_IDENT_Q         =         "@C123_CORRECT_IDENT_Q";
  public static final String LZ25_DEDUCT_EXCESS_Q         =         "@C123_DEDUCT_EXCESS_Q";
  public static final String LZ25_COVERAGE_Q              =         "@C123_COVERAGE_Q";
  public static final String LZ25_CAUSE_CODE_Q            =         "@C123_CAUSE_CODE_Q";
  public static final String LZ25_LEAD_AGREEMENT_Q        =         "@C123_LEAD_AGREEMENT_Q";
  public static final String LZ25_MKT_AGREEMENT_Q         =         "@C123_MKT_AGREEMENT_Q";
  public static final String LZ25_POLICY_DOC_IND          =         "@C123_POLICY_DOC_IND";
  public static final String LZ25_SLIP_DOC_IND            =         "@C123_SLIP_DOC_IND";
  public static final String LZ25_COVER_DOC_IND           =         "@C123_COVER_DOC_IND";
  public static final String LZ25_LOSS_DETS_DOC_IND         =         "@C123_LOSS_DETS_DOC_IND";
  public static final String LZ25_OTHER_DOC_IND             =         "@C123_OTHER_DOC_IND";

  //LZ26 Input keys
  public static final String LZ26_SESSION_NO              =         "@C124_SESSION_NO";
  public static final String LZ26_FIELD_VALUES            =         "#C124_FIELD_VALUES[]";
  public static final String LZ26_XCR                     =         "@C124_XCR";
  public static final String LZ26_UCR                     =         "@C124_UCR";
  public static final String LZ26_TR                      =         "@C124_TR";
  public static final String LZ26_ORIG_REF_1              =         "@C124_ORIG_REF_1";
  public static final String LZ26_ORIG_REF_2              =         "@C124_ORIG_REF_2";
  public static final String LZ26_ORIG_REF_3              =         "@C124_ORIG_REF_3";
  public static final String LZ26_ORIG_BKR                =         "@C124_ORIG_BKR";
  public static final String LZ26_SIGNED_IND              =         "@C124_SIGNED_IND";
  public static final String LZ26_PEER_REV_IND            =         "@C124_PEER_REV_IND";
  public static final String LZ26_PAYEE_BKR               =         "@C124_PAYEE_BKR";
  public static final String LZ26_PAID_BY_CHEQUE          =         "@C124_PAID_BY_CHEQUE";
  public static final String LZ26_BKR_PRES_DATE           =         "@C124_BKR_PRES_DATE";
  public static final String LZ26_LDR_PRES_DATE           =         "@C124_LDR_PRES_DATE";
  public static final String LZ26_LLOYDS_LEAD_IND         =         "@C124_LLOYDS_LEAD_IND";
  public static final String LZ26_BORD_IND                =         "@C124_BORD_IND";
  public static final String LZ26_DOL_IN_POL_Q            =         "@C124_DOL_IN_POL_Q";
  public static final String LZ26_CLAIM_IN_POL_Q          =         "@C124_CLAIM_IN_POL_Q";
  public static final String LZ26_CORRECT_IDENT_Q         =         "@C124_CORRECT_IDENT_Q";
  public static final String LZ26_DEDUCT_EXCESS_Q         =         "@C124_DEDUCT_EXCESS_Q";
  public static final String LZ26_COVERAGE_Q              =         "@C124_COVERAGE_Q";
  public static final String LZ26_CAUSE_CODE_Q            =         "@C124_CAUSE_CODE_Q";
  public static final String LZ26_LEAD_AGREEMENT_Q        =         "@C124_LEAD_AGREEMENT_Q";
  public static final String LZ26_MKT_AGREEMENT_Q         =         "@C124_MKT_AGREEMENT_Q";
  public static final String LZ26_POLICY_DOC_IND          =         "@C124_POLICY_DOC_IND";
  public static final String LZ26_SLIP_DOC_IND            =         "@C124_SLIP_DOC_IND";
  public static final String LZ26_COVER_DOC_IND           =         "@C124_COVER_DOC_IND";
  public static final String LZ26_LOSS_DETS_DOC_IND         =         "@C124_LOSS_DETS_DOC_IND";
  public static final String LZ26_OTHER_DOC_IND             =         "@C124_OTHER_DOC_IND";
  
}
