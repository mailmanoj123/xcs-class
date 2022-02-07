package com.xchanging.xcc.web.models.manager;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    ModelManager.java
 * Date:    September 2002
 * Version: 1.0
 *
 * Author:  Dave Houlden
 *          Steria UK
 *
 * Description: This is responsible for the instantiation and general management
 * of web tier business objects (beans) that are used to represent the Claims
 * data.
 *
 * Modification History
 * --------------------
 * Author:
 * Date:
 * Description:
 *
 */

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.xchanging.xcc.beans.ClaimsController;
import com.xchanging.xcc.beans.ClaimsControllerEJBHome;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.controller.ClaimsControllerWeb;
import com.xchanging.xcc.web.models.AdvancedSearchResultsModel;
import com.xchanging.xcc.web.models.BulkCcsCorrectionModel;
import com.xchanging.xcc.web.models.BulkComponentSelectionModel;
import com.xchanging.xcc.web.models.CCSAmountsModel;
import com.xchanging.xcc.web.models.CCVCQuestionnaireModel;
import com.xchanging.xcc.web.models.ClaimDetailsModel;
import com.xchanging.xcc.web.models.ClaimTransactionCreationModel;
import com.xchanging.xcc.web.models.ClaimTransactionOptionsModel;
import com.xchanging.xcc.web.models.ConcOfBulkSettlementModel;
import com.xchanging.xcc.web.models.ConfirmationModel;
import com.xchanging.xcc.web.models.CopyFromUcrModel;
import com.xchanging.xcc.web.models.CreateReadviceModel;
import com.xchanging.xcc.web.models.DiaryListWebModel;
import com.xchanging.xcc.web.models.EuroConversionDetailsModel;
import com.xchanging.xcc.web.models.ExpertFeeBreakDownModel;
import com.xchanging.xcc.web.models.FinancialDetailsModel;
import com.xchanging.xcc.web.models.FindClaimModel;
import com.xchanging.xcc.web.models.FindSettlementSearchResultsDetailsModel;
import com.xchanging.xcc.web.models.FindSettlementSearchResultsModel;
import com.xchanging.xcc.web.models.GroupEnquiryModel;
import com.xchanging.xcc.web.models.GroupSearchResultsModel;
import com.xchanging.xcc.web.models.GroupingSessionModel;
import com.xchanging.xcc.web.models.HistoryModel;
import com.xchanging.xcc.web.models.MaintainGroupModel;
import com.xchanging.xcc.web.models.MarketDetailsModel;
import com.xchanging.xcc.web.models.MarketsModel;
import com.xchanging.xcc.web.models.MovementHistoryModel;
import com.xchanging.xcc.web.models.NarrativeModel;
import com.xchanging.xcc.web.models.NavigationBarModel;
import com.xchanging.xcc.web.models.NextScreenModel;
import com.xchanging.xcc.web.models.OsndSearchResultsModel;
import com.xchanging.xcc.web.models.PolicyRiskDetailsModel;
import com.xchanging.xcc.web.models.PremiumComparisonModel;
import com.xchanging.xcc.web.models.QuestionModel;
import com.xchanging.xcc.web.models.RateOfExchangeAdjustmentModel;
import com.xchanging.xcc.web.models.SCMAdviceModel;
import com.xchanging.xcc.web.models.SchemeCanadaWebModel;
import com.xchanging.xcc.web.models.SecurityNotesModel;
import com.xchanging.xcc.web.models.SetDiaryDateModel;
import com.xchanging.xcc.web.models.SettlementSearchModel;
import com.xchanging.xcc.web.models.SingleClaimLossReservesModel;
import com.xchanging.xcc.web.models.SubsequentAdviceScheduleModel;
import com.xchanging.xcc.web.models.SummaryNonSettlementModel;
import com.xchanging.xcc.web.models.SummarySettlementModel;
import com.xchanging.xcc.web.models.TransactionHistoryModel;
import com.xchanging.xcc.web.models.TransactionStatusModel;
import com.xchanging.xcc.web.models.UserWebModel;
import com.xchanging.xcc.web.models.VATRatesModel;

public class ModelManager extends ModelUpdateNotifier {

  private ServletContext context;
  private HttpSession session;

  private ClaimsController ccEjb = null;
  private ClaimsControllerWeb ccWeb = null;

  public ModelManager() {
  }

  /*
    Retain handles to the session and context objects,
    so we can place objects in them
  */
  public void init(ServletContext context, HttpSession session) {
    this.session = session;
    this.context = context;
  }

  public PremiumComparisonModel getPremiumComparisonModel() {
    PremiumComparisonModel premComp = (PremiumComparisonModel) session.getAttribute(Keys.PremiumComparisonModelKey);
    if (premComp == null) {
      premComp = new PremiumComparisonModel(this);
      session.setAttribute(Keys.PremiumComparisonModelKey, premComp);
    }
    premComp.init(session);
    return premComp;
  }

  public AdvancedSearchResultsModel getAdvancedSearchModel() {

    AdvancedSearchResultsModel searchResults = (AdvancedSearchResultsModel) session.getAttribute(Keys.AdvancedSearchResultsModelKey);
    if (searchResults == null) {
      searchResults = new AdvancedSearchResultsModel(this);
      session.setAttribute(Keys.AdvancedSearchResultsModelKey, searchResults);
    }
    searchResults.init(session);
    return searchResults;
  }

  public SchemeCanadaWebModel getSchemeCanadaModel() {

    SchemeCanadaWebModel schemeCanada = (SchemeCanadaWebModel) session.getAttribute(Keys.SchemeCanadaModelKey);
    if (schemeCanada == null) {
      schemeCanada = new SchemeCanadaWebModel(this);
      session.setAttribute(Keys.SchemeCanadaModelKey, schemeCanada);
    }
    schemeCanada.init(session);
    return schemeCanada;
  }

  public QuestionModel getQuestionModel() {

    QuestionModel questionModel = (QuestionModel) session.getAttribute(Keys.QuestionModelKey);
    if (questionModel == null) {
      questionModel = new QuestionModel(this);
      session.setAttribute(Keys.QuestionModelKey, questionModel);
    }
    questionModel.init(session);
    return questionModel;
  }

  public TransactionStatusModel getTransactionStatusModel() {

    TransactionStatusModel txnStatusModel = (TransactionStatusModel) session.getAttribute(Keys.TransactionStatusModelKey);
    if (txnStatusModel == null) {
      txnStatusModel = new TransactionStatusModel(this);
      session.setAttribute(Keys.TransactionStatusModelKey, txnStatusModel);
    }
    txnStatusModel.init(session);
    return txnStatusModel;
  }

  public GroupingSessionModel getGroupingSessionModel() {

    GroupingSessionModel groupingSessionModel = (GroupingSessionModel) session.getAttribute(Keys.GroupingSessionModelKey);
    if (groupingSessionModel == null) {
      groupingSessionModel = new GroupingSessionModel(this);
      session.setAttribute(Keys.GroupingSessionModelKey, groupingSessionModel);
    }
    groupingSessionModel.init(session);
    return groupingSessionModel;
  }

  public NextScreenModel getNextScreenModel() {

    NextScreenModel screenModel = (NextScreenModel) session.getAttribute(Keys.NextScreenModelKey);
    if (screenModel == null) {
      screenModel = new NextScreenModel(this);
      session.setAttribute(Keys.NextScreenModelKey, screenModel);
    }
    screenModel.init(session);
    return screenModel;
  }

  public DiaryListWebModel getDiaryWebModel() {

    DiaryListWebModel diary = (DiaryListWebModel) session.getAttribute(Keys.DiaryListWebModelKey);
    if (diary == null) {
      diary = new DiaryListWebModel(this);
      session.setAttribute(Keys.DiaryListWebModelKey, diary);
    }
    diary.init(session);
    return diary;
  }

  public ClaimTransactionCreationModel getClaimTransactionCreationModel() {

    ClaimTransactionCreationModel claimTrans = (ClaimTransactionCreationModel) session.getAttribute(Keys.ClaimTransCreationModelKey);
    if (claimTrans == null) {
      claimTrans = new ClaimTransactionCreationModel(this);
      session.setAttribute(Keys.ClaimTransCreationModelKey, claimTrans);
    }
    claimTrans.init(session);
    return claimTrans;
  }

  public OsndSearchResultsModel getOsndSearchResultsModel() {
    OsndSearchResultsModel osndSearchresults = (OsndSearchResultsModel) session.getAttribute(Keys.OsndSearchResultsModelKey);
    if (osndSearchresults == null) {
      osndSearchresults = new OsndSearchResultsModel(this);
      session.setAttribute(Keys.OsndSearchResultsModelKey, osndSearchresults);
    }
    osndSearchresults.init(session);
    return osndSearchresults;
  }

  public MarketsModel getMarketsModel() {
    MarketsModel markets = (MarketsModel) session.getAttribute(Keys.MarketsModelKey);
    if (markets == null) {
      markets = new MarketsModel(this);
      session.setAttribute(Keys.MarketsModelKey, markets);
    }
    markets.init(session);
    return markets;
  }

  public UserWebModel getUserWebModel() {
    UserWebModel user = (UserWebModel) session.getAttribute(Keys.UserWebModelKey);
    if (user == null) {
      user = new UserWebModel(this);
      session.setAttribute(Keys.UserWebModelKey, user);
    }
    user.init(session);
    return user;
  }

  public NavigationBarModel getNavigationBar() {
    NavigationBarModel navBar = (NavigationBarModel) session.getAttribute(Keys.NavigationBarKey);
    if (navBar == null) {
      navBar = new NavigationBarModel(this);
      session.setAttribute(Keys.NavigationBarKey, navBar);
    }
    navBar.init(session);
    return navBar;
  }

  // BA&PD: 24-11-2003: Settlement search screen
  public SettlementSearchModel getSettlementSearch() {
    SettlementSearchModel searchsett = (SettlementSearchModel) session.getAttribute(Keys.SettSearchScreenModelKey);
    if (searchsett == null) {
      searchsett = new SettlementSearchModel(this);
      session.setAttribute(Keys.SettSearchScreenModelKey, searchsett);
    }
    searchsett.init(session);
    return searchsett;
  }
  // BA&PD: 24-11-2003: Settlement search screen
  public FindSettlementSearchResultsModel getFindSettlementSearchResults() {
    FindSettlementSearchResultsModel searchsettresults = (FindSettlementSearchResultsModel) session.getAttribute(Keys.SettSearchResultsScreenModelKey);
    if (searchsettresults == null) {
      searchsettresults = new FindSettlementSearchResultsModel(this);
      session.setAttribute(Keys.SettSearchResultsScreenModelKey, searchsettresults);
    }
    searchsettresults.init(session);
    return searchsettresults;
  }
  // BA&PD: 24-11-2003: Settlement search screen
  public FindSettlementSearchResultsDetailsModel getFindSettlementSearchDetailResults() {
    FindSettlementSearchResultsDetailsModel searchsettdets = (FindSettlementSearchResultsDetailsModel) session.getAttribute(Keys.SettSearchDetailedResultsScreenModelKey);
    if (searchsettdets == null) {
      searchsettdets = new FindSettlementSearchResultsDetailsModel(this);
      session.setAttribute(Keys.SettSearchDetailedResultsScreenModelKey, searchsettdets);
    }
    searchsettdets.init(session);
    return searchsettdets;
  }




  public HistoryModel getHistoryModel() {
    HistoryModel historyModel = (HistoryModel)session.getAttribute(Keys.HistoryModelKey);
    if (historyModel == null) {
      historyModel = new HistoryModel(this);
      session.setAttribute(Keys.HistoryModelKey, historyModel);
    }
    historyModel.init(session);
    return historyModel;
  }

  public VATRatesModel getVATRatesModel() {
    VATRatesModel model = (VATRatesModel) session.getAttribute(Keys.VATRatesModelKey);
    if (model == null) {
      model = new VATRatesModel(this);
      session.setAttribute(Keys.VATRatesModelKey, model);
    }
    model.init(session);
    return model;
  }

  public TransactionHistoryModel getTransactionHistoryModel() {
    TransactionHistoryModel model = (TransactionHistoryModel) session.getAttribute(Keys.TransactionHistoryModelKey);
    if (model == null) {
      model = new TransactionHistoryModel(this);
      session.setAttribute(Keys.TransactionHistoryModelKey, model);
    }
    model.init(session);
    return model;
  }

  public SummarySettlementModel getSummarySettlementModel() {
    SummarySettlementModel model = (SummarySettlementModel) session.getAttribute(Keys.SummarySettlementModelKey);
    if (model == null) {
      model = new SummarySettlementModel(this);
      session.setAttribute(Keys.SummarySettlementModelKey, model);
    }
    model.init(session);
    return model;
  }

  public SummaryNonSettlementModel getSummaryNonSettlementModel() {
    SummaryNonSettlementModel model = (SummaryNonSettlementModel) session.getAttribute(Keys.SummaryNonSettlementModelKey);
    if (model == null) {
      model = new SummaryNonSettlementModel(this);
      session.setAttribute(Keys.SummaryNonSettlementModelKey, model);
    }
    model.init(session);
    return model;
  }

  public SubsequentAdviceScheduleModel getSubsequentAdviceScheduleModel() {
    SubsequentAdviceScheduleModel model = (SubsequentAdviceScheduleModel) session.getAttribute(Keys.SubAdviceScheduleModelKey);
    if (model == null) {
      model = new SubsequentAdviceScheduleModel(this);
      session.setAttribute(Keys.SubAdviceScheduleModelKey, model);
    }
    model.init(session);
    return model;
  }

  public SingleClaimLossReservesModel getSingleClaimLossReservesModel() {
    SingleClaimLossReservesModel model = (SingleClaimLossReservesModel) session.getAttribute(Keys.SingleClaimLossResModelKey);
    if (model == null) {
      model = new SingleClaimLossReservesModel(this);
      session.setAttribute(Keys.SingleClaimLossResModelKey, model);
    }
    model.init(session);
    return model;
  }

  public SetDiaryDateModel getSetDiaryDateModel() {
    SetDiaryDateModel model = (SetDiaryDateModel) session.getAttribute(Keys.SetDiaryDateModelKey);
    if (model == null) {
      model = new SetDiaryDateModel(this);
      session.setAttribute(Keys.SetDiaryDateModelKey, model);
    }
    model.init(session);
    return model;
  }

  public SecurityNotesModel getSecurityNotesModel() {
    SecurityNotesModel model = (SecurityNotesModel) session.getAttribute(Keys.SecurityNotesModelKey);
    if (model == null) {
      model = new SecurityNotesModel(this);
      session.setAttribute(Keys.SecurityNotesModelKey, model);
    }
    model.init(session);
    return model;
  }

  public SCMAdviceModel getSCMAdviceModel() {
    SCMAdviceModel model = (SCMAdviceModel) session.getAttribute(Keys.SCMAdviceModelKey);
    if (model == null) {
      model = new SCMAdviceModel(this);
      session.setAttribute(Keys.SCMAdviceModelKey, model);
    }
    model.init(session);
    return model;
  }

  public RateOfExchangeAdjustmentModel getRateOfExchangeAdjustmentModel() {
    RateOfExchangeAdjustmentModel model = (RateOfExchangeAdjustmentModel) session.getAttribute(Keys.RateOfExchangeAdjModelKey);
    if (model == null) {
      model = new RateOfExchangeAdjustmentModel(this);
      session.setAttribute(Keys.RateOfExchangeAdjModelKey, model);
    }
    model.init(session);
    return model;
  }

  public PolicyRiskDetailsModel getPolicyRiskDetailsModel() {
    PolicyRiskDetailsModel model = (PolicyRiskDetailsModel) session.getAttribute(Keys.PolicyRiskDetailsModelKey);
    if (model == null) {
      model = new PolicyRiskDetailsModel(this);
      session.setAttribute(Keys.PolicyRiskDetailsModelKey, model);
    }
    model.init(session);
    return model;
  }

  public NarrativeModel getNarrativeModel() {
    NarrativeModel model = (NarrativeModel) session.getAttribute(Keys.NarrativeModelKey);
    if (model == null) {
      model = new NarrativeModel(this);
      session.setAttribute(Keys.NarrativeModelKey, model);
    }
    model.init(session);
    return model;
  }

  public MovementHistoryModel getMovementHistoryModel() {
    MovementHistoryModel model = (MovementHistoryModel) session.getAttribute(Keys.MovementHistoryModelKey);
    if (model == null) {
      model = new MovementHistoryModel(this);
      session.setAttribute(Keys.MovementHistoryModelKey, model);
    }
    model.init(session);
    return model;
  }

  public MarketDetailsModel getMarketDetailsModel() {
    MarketDetailsModel model = (MarketDetailsModel) session.getAttribute(Keys.MarketDetailsModelKey);
    if (model == null) {
      model = new MarketDetailsModel(this);
      session.setAttribute(Keys.MarketDetailsModelKey, model);
    }
    model.init(session);
    return model;
  }

  public MaintainGroupModel getMaintainGroupModel() {
    MaintainGroupModel model = (MaintainGroupModel) session.getAttribute(Keys.MaintainGroupModelKey);
    if (model == null) {
      model = new MaintainGroupModel(this);
      session.setAttribute(Keys.MaintainGroupModelKey, model);
    }
    model.init(session);
    return model;
  }

  public GroupSearchResultsModel getGroupSearchResultsModel() {
    GroupSearchResultsModel model = (GroupSearchResultsModel) session.getAttribute(Keys.GroupSearchResultsModelKey);
    if (model == null) {
      model = new GroupSearchResultsModel(this);
      session.setAttribute(Keys.GroupSearchResultsModelKey, model);
    }
    model.init(session);
    return model;
  }

  public GroupEnquiryModel getGroupEnquiryModel() {
    GroupEnquiryModel model = (GroupEnquiryModel) session.getAttribute(Keys.GroupEnquiryModelKey);
    if (model == null) {
      model = new GroupEnquiryModel(this);
      session.setAttribute(Keys.GroupEnquiryModelKey, model);
    }
    model.init(session);
    return model;
  }

  public FindClaimModel getFindClaimModel() {
    FindClaimModel model = (FindClaimModel) session.getAttribute(Keys.FindClaimModelKey);
    if (model == null) {
      model = new FindClaimModel(this);
      session.setAttribute(Keys.FindClaimModelKey, model);
    }
    model.init(session);
    return model;
  }

  public FinancialDetailsModel getFinancialDetailsModel() {
    FinancialDetailsModel model = (FinancialDetailsModel) session.getAttribute(Keys.FinancialDetailsModelKey);
    if (model == null) {
      model = new FinancialDetailsModel(this);
      session.setAttribute(Keys.FinancialDetailsModelKey, model);
    }
    model.init(session);
    return model;
  }

  public EuroConversionDetailsModel getEuroConversionDetailsModel() {
    EuroConversionDetailsModel model = (EuroConversionDetailsModel) session.getAttribute(Keys.EuroConversionDetailsModelKey);
    if (model == null) {
      model = new EuroConversionDetailsModel(this);
      session.setAttribute(Keys.EuroConversionDetailsModelKey, model);
    }
    model.init(session);
    return model;
  }

  public CopyFromUcrModel getCopyFromUcrModel() {
    CopyFromUcrModel model = (CopyFromUcrModel) session.getAttribute(Keys.CopyFromUcrModelKey);
    if (model == null) {
      model = new CopyFromUcrModel(this);
      session.setAttribute(Keys.CopyFromUcrModelKey, model);
    }
    model.init(session);
    return model;
  }

  public ConcOfBulkSettlementModel getConcOfBulkSettlementModel() {
    ConcOfBulkSettlementModel model = (ConcOfBulkSettlementModel) session.getAttribute(Keys.ConcOfBulkSettlementModelKey);
    if (model == null) {
      model = new ConcOfBulkSettlementModel(this);
      session.setAttribute(Keys.ConcOfBulkSettlementModelKey, model);
    }
    model.init(session);
    return model;
  }

  public ClaimTransactionOptionsModel getClaimTransactionOptionsModel() {
    ClaimTransactionOptionsModel model = (ClaimTransactionOptionsModel) session.getAttribute(Keys.ClaimTransCreationModelKey);
    if (model == null) {
      model = new ClaimTransactionOptionsModel(this);
      session.setAttribute(Keys.ClaimTransCreationModelKey, model);
    }
    model.init(session);
    return model;
  }

  public ClaimDetailsModel getClaimDetailsModel() {
    ClaimDetailsModel model = (ClaimDetailsModel) session.getAttribute(Keys.ClaimDetailsModelKey);
    if (model == null) {
      model = new ClaimDetailsModel(this);
      session.setAttribute(Keys.ClaimDetailsModelKey, model);
    }
    model.init(session);
    return model;
  }

  public ConfirmationModel getConfirmationModel() {
    ConfirmationModel model = (ConfirmationModel) session.getAttribute(Keys.ConfirmationModelKey);
    if (model == null) {
      model = new ConfirmationModel(this);
      session.setAttribute(Keys.ConfirmationModelKey, model);
    }
    model.init(session);
    return model;
  }

  public CCSAmountsModel getCCSAmountsModel() {
    CCSAmountsModel model = (CCSAmountsModel) session.getAttribute(Keys.CCSAmountsModelKey);
    if (model == null) {
      model = new CCSAmountsModel(this);
      session.setAttribute(Keys.CCSAmountsModelKey, model);
    }
    model.init(session);
    return model;
  }

  public BulkComponentSelectionModel getBulkComponentSelectionModel() {
    BulkComponentSelectionModel model = (BulkComponentSelectionModel) session.getAttribute(Keys.BulkComponentSelectionModelKey);
    if (model == null) {
      model = new BulkComponentSelectionModel(this);
      session.setAttribute(Keys.BulkComponentSelectionModelKey, model);
    }
    model.init(session);
    return model;
  }

  public BulkCcsCorrectionModel getBulkCcsCorrectionModel() {
    BulkCcsCorrectionModel model = (BulkCcsCorrectionModel) session.getAttribute(Keys.BulkCcsCorrectionModelKey);
    if (model == null) {
      model = new BulkCcsCorrectionModel(this);
      session.setAttribute(Keys.BulkCcsCorrectionModelKey, model);
    }
    model.init(session);
    return model;
  }

  public CreateReadviceModel getCreateReadviceModel() {
    CreateReadviceModel model = (CreateReadviceModel) session.getAttribute(Keys.CreateReadviceModelKey);
    if (model == null) {
      model = new CreateReadviceModel(this);
      session.setAttribute(Keys.CreateReadviceModelKey, model);
    }
    model.init(session);
    return model;
  }

  public ClaimsController getCCEJB() {
    if (ccEjb == null) {
      try {
        InitialContext context = new InitialContext();
        Object objref = context.lookup("java:comp/env/ejb/ClaimsController");
        ClaimsControllerEJBHome home = (ClaimsControllerEJBHome)PortableRemoteObject.narrow(objref, ClaimsControllerEJBHome.class);
        ccEjb = home.create();
      }
      catch (CreateException ce) {
        throw new GeneralFailureException(ce.getMessage());
      }
      catch (RemoteException re) {
        throw new GeneralFailureException(re.getMessage());
      }
      catch (NamingException ne) {
        throw new GeneralFailureException(ne.getMessage());
      }
    }
    return ccEjb;
  }

  public void setCCWeb(ClaimsControllerWeb ccWeb) {
    this.ccWeb = ccWeb;
  }
  public ClaimsControllerWeb getCCWeb() {
    return ccWeb;
  }

  /* Expert Fee Breakdown model */
  public ExpertFeeBreakDownModel getExpertFeeBreakDownModel()
  {
      ExpertFeeBreakDownModel model = (ExpertFeeBreakDownModel) session.getAttribute(Keys.ExpertFeeBreakDownModelKey);
      if (model == null)
      {
          model = new ExpertFeeBreakDownModel(this);
          session.setAttribute(Keys.ExpertFeeBreakDownModelKey, model);
      }
      model.init(session);
      return model;
  }

  /* CCVC Questionnaire model */
  public CCVCQuestionnaireModel getCCVCQuestionnaireModel()
  {
      CCVCQuestionnaireModel model = (CCVCQuestionnaireModel) session.getAttribute(Keys.CCVCQuestionnaireModelKey);
      if (model == null)
      {
          model = new CCVCQuestionnaireModel(this);
          session.setAttribute(Keys.CCVCQuestionnaireModelKey, model);
      }
      model.init(session);
      return model;
  }

}