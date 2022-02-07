package com.xchanging.xcc.cics.handlers;

import java.util.Vector;

import javax.resource.ResourceException;
import javax.resource.cci.Interaction;
import javax.resource.cci.MappedRecord;
import javax.resource.cci.Record;

import org.w3c.dom.Element;

import com.attunity.adapter.DOMWriter;
import com.attunity.adapter.DomRecord;
import com.xchanging.xcc.beans.manager.StateMachine;
import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.exceptions.ClaimsError;
import com.xchanging.xcc.exceptions.ClaimsErrorException;
import com.xchanging.xcc.exceptions.ClaimsWarning;
import com.xchanging.xcc.exceptions.ClaimsWarningException;
import com.xchanging.xcc.exceptions.GeneralFailureException;
import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.refdata.RefDataHandler;
import com.xchanging.xcc.refdata.TableRow;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.reference.GUIErrorList;

public abstract class CICSHandler {

  public static GUIErrorList errorList;
  public static boolean ignoreWarnings;
  public static boolean ignoreErrors;
  public abstract MappedRecord getResults();
  private javax.resource.cci.Connection con;
  Interaction interaction;
  private StateMachine sm;
  public abstract void perform(ClaimsEvent ce, StateMachine sm) throws GeneralFailureException, ClaimsErrorException, ClaimsWarningException;
  public static int WAIT_TIME = 35000;

  static {
    RefDataHandler refData = new RefDataHandler();

    errorList = new GUIErrorList();

    Vector results = refData.readTable(Keys.GUIErrorTable);

    for (int i=0; i<results.size(); i++) {
      errorList.createGUIError(((TableRow)results.get(i)).getColumn(0),((TableRow)results.get(i)).getColumn(1));
    }
  }

  protected int errorsFound(MappedRecord rec,String id) {
    String errorStr = (String)((MappedRecord)rec).get("@"+id+"_ERROR_COUNT");
    return Integer.parseInt(errorStr);
  }

  protected int warningsFound(MappedRecord rec,String id) {
    if (ignoreWarnings) {
      return 0;
    }
    String warningStr = (String)((MappedRecord)rec).get("@"+id+"_WARNING_COUNT");
    return Integer.parseInt(warningStr);
  }

  protected void writeXML(Record oRec) {
    try {
      Element outEl = ((DomRecord)oRec).getDom();
      DOMWriter domW = new DOMWriter(false);
      String xml = domW.toXMLString(outEl);
      Logger.debug(xml);
    }
    catch (ResourceException re) {
      throw new GeneralFailureException("Unable to obtain DOM from CICS Results");
    }
  }

  protected void processErrors(MappedRecord results,String id) throws ClaimsErrorException{

    String errorStr = (String)((MappedRecord)results).get("@"+id+"_ERROR_COUNT");
    int errorCount = Integer.parseInt(errorStr);
    
    Vector errorFields = (Vector)(results).get("#"+id+"_ERROR_TABLE[]");
    Vector errors = new Vector(errorFields.size());

    for (int x = 0; x < errorCount; x++) {
      MappedRecord record = (MappedRecord)errorFields.get(x);
      String code =   (String)record.get("@"+id+"_ERROR_CODE");

      errors.add(new ClaimsError(code,
                                 errorList.getErrorText(code),
                                 (String)record.get("@"+id+"_ERROR_TEXT")));
    }    
    throw new ClaimsErrorException(errors.elements());
  }

  protected void processWarnings(MappedRecord results,String id) throws ClaimsWarningException{

    String errorStr = (String)((MappedRecord)results).get("@"+id+"_WARNING_COUNT");
    int errorCount = Integer.parseInt(errorStr);

    Vector warningFields = (Vector)(results).get("#"+id+"_WARNING_TABLE[]");
    Vector warnings = new Vector(warningFields.size());

    for (int x = 0; x < errorCount; x++) {
      MappedRecord record = (MappedRecord)warningFields.get(x);
      String code = (String)record.get("@"+id+"_WARNING_CODE");
      warnings.add(new ClaimsWarning(code,
                                     errorList.getErrorText(code),
                                     (String)record.get("@"+id+"_WARNING_TEXT")));
    }
    throw new ClaimsWarningException(warnings.elements());
  }

  public void init(StateMachine sm) {
    if (!Keys.LOCAL_MODE) {
      this.sm = sm;
      try {
        con = sm.cf.getConnection();
        interaction = con.createInteraction();
      }
      catch (ResourceException re) {
        try {
          if (interaction != null) {
            interaction.close();
          }
        } catch (ResourceException re2) {
          re2.printStackTrace();
        }

        try {
          if (con != null) {
            con.close();
          }
        } catch (ResourceException re2) {
          re2.printStackTrace();
        }

        throw new GeneralFailureException(re.getMessage());
      }
    }
  }

  public void closeConnections() {
    try {
      interaction.close();
    } catch (Exception e) {
      //e.printStackTrace();
    }
    try {
      con.close();
    } catch (Exception e) {
      //e.printStackTrace();
    }
  }
}