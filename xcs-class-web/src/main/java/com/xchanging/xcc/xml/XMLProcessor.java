package com.xchanging.xcc.xml;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    XMLProcessor.java
 * Date:    September 2002
 * Version: 1.0
 *
 * Author:  Dave Houlden
 *          Steria UK
 *
 * Description: Helper class used to parse the request and screen definitions
 * XML files.
 *
 * Modification History
 * --------------------
 * Author:
 * Date:
 * Description:
 *
 */

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.xml.mappings.RequestMapping;
import com.xchanging.xcc.xml.mappings.ScreenMapping;
import com.xchanging.xcc.xml.mappings.ScreenParameter;

public class XMLProcessor {

  // Request Mappings

  private static final String REQUEST                = "request";
  private static final String URL                    = "url";
  private static final String NEXT_SCREEN            = "screen";
  private static final String REQUIRES_SIGNIN        = "requiresSignin";
  private static final String USE_WEB_HANDLER        = "useWebHandler";
  private static final String WEB_HANDLER_CLASS      = "web-handler-class";
  private static final String USE_FLOW_HANDLER       = "useFlowHandler";
  private static final String FLOW_HANDLER           = "flow-handler";
  private static final String FLOW_HANDLER_CLASS     = "class";
  private static final String HANDLER_RESULT         = "handler-result";
  private static final String RESULT                 = "result";
  private static final String EXCEPTION_MAPPING      = "exception-mapping";
  private static final String EXCEPTION_CLASS        = "exception-class";
  private static final String SCREEN                 = "screen";


  // Screen Definitions

  private static final String SCREEN_DEFINITION       = "screen";
  private static final String SCREEN_NAME             = "screen-name";
  private static final String TEMPLATE                = "template";
  private static final String PARAMETER               = "parameter";
  private static final String KEY                     = "key";
  private static final String VALUE                   = "value";
  private static final String DIRECT                  = "direct";


  public static HashMap loadRequestMappings(String location) {

    Document document = getDocument(location);
    HashMap requestMappings = new HashMap();

    /*
      Get the root element - <request-mappings>
    */
    Element root = document.getDocumentElement();
    NodeList list = root.getElementsByTagName(REQUEST);
    for (int loop = 0; loop < list.getLength(); loop++) {
      Node node = list.item(loop);
      if (node != null) {
        String url = null;
        String screen = null;
        String useWebHandlerString = null;
        String useFlowHandlerString = null;
        String requiresSigninString = null;
        String flowHandler = null;
        String webHandler =null;
        HashMap resultMappings = null;
        boolean useFlowHandler = false;
        boolean useWebHandler = false;
        boolean requiresSignin = false;

        /*
          Get all possible attributes for the element named <request>
        */
        if (node instanceof Element) {
          Element element = ((Element)node);
          url = element.getAttribute(URL);
          screen = element.getAttribute(NEXT_SCREEN);
          useWebHandlerString = element.getAttribute(USE_WEB_HANDLER);
          useFlowHandlerString = element.getAttribute(USE_FLOW_HANDLER);
          requiresSigninString = element.getAttribute(REQUIRES_SIGNIN);
        }

        /*
          Does this request require a signin first
        */
        if ((requiresSigninString != null) && requiresSigninString.equals("true")) {
          requiresSignin = true;
        }

        /*
          If the element has 'true' set for its useRequestHandlerString then set
          its useRequestHandler to true and parse out the handler class name
        */
        if ((useWebHandlerString != null) && useWebHandlerString.equals("true")) {
          useWebHandler = true;
          webHandler = getSubTagValue(node, WEB_HANDLER_CLASS);
        }

        /*
          If the element has 'true' set for its useFlowHandlerString then set
          its useFlowHandler to true
        */
        if ((useFlowHandlerString != null) && useFlowHandlerString.equals("true")) {
          useFlowHandler = true;
          /*
            Need to be an element to find sub nodes by name - Get the
            'flow-handler' node
          */
          if (node instanceof Element) {
            Element element = (Element)node;
            NodeList children = element.getElementsByTagName(FLOW_HANDLER);
            Node flowHandlerNode = null;

            /*
              Check that we only have one flow-handler node
            */
            if (children.getLength() >= 1) {
              flowHandlerNode = children.item(0);
            }
            if (children.getLength() > 1) {
              Logger.warn("WARNING: There can be only one <" + FLOW_HANDLER + "> definition in a <" + REQUEST + ">");
            }

            /*
              Get the flow-handler details
                flow-handler-class
                handler-result      (can be multiple - store in HashMap)

            */
            if (flowHandlerNode != null) {
              if (flowHandlerNode instanceof Element) {
                Element flowElement = (Element)flowHandlerNode;

                /*
                  Get the flow-handler class
                */
                flowHandler = flowElement.getAttribute(FLOW_HANDLER_CLASS);

                /*
                  Get all handler-result nodes ( could be many )
                */
                NodeList results = flowElement.getElementsByTagName(HANDLER_RESULT);
                if (results.getLength() > 0){
                  resultMappings = new HashMap();
                }

                /*
                  Iterate over the handler-result nodes and extract the
                  'result' and 'screen' attributes
                */
                for (int resultLoop=0; resultLoop < results.getLength(); resultLoop++) {
                  Node resultNode = results.item(resultLoop);
                  if (resultNode instanceof Element) {
                    Element resultElement = (Element)resultNode;
                    String key = resultElement.getAttribute(RESULT);
                    String value = resultElement.getAttribute(NEXT_SCREEN);
                    if (!resultMappings.containsKey(key)) {
                      resultMappings.put(key,value);
                    }
                    else {
                      Logger.warn("WARNING: Request " + url + " <" + FLOW_HANDLER + "> key " + "\"" + key + "\" defined more than one time");
                    }
                  }
                } // end for
              }
            } // end if (flowHandler != null)
          }
        }

        RequestMapping mapping = new RequestMapping(  url,
                                                      screen,
                                                      useWebHandler,
                                                      useFlowHandler,
                                                      webHandler,
                                                      flowHandler,
                                                      resultMappings,
                                                      requiresSignin);

        if (!requestMappings.containsKey(url)) {
          requestMappings.put(url, mapping);
        }
        else {
          Logger.warn("WARNING: Request " + url + " defined more than once in screen definitions file");
        }
      }
    }
    return requestMappings;
  }


  private static Document getDocument(String location) {
    try {
      /*
        Create a URL to the location of requestmappings.xml and use an
        InputSource object to access it.
      */
      URL urlLocation = new URL(location);
      InputSource xmlInp = new InputSource(urlLocation.openStream());

      /*
        Define a new DOM parser
      */
      DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();

      /*
        Parse the xml document into a DOM and return
      */
      return (parser.parse(xmlInp));
    }
    catch(ParserConfigurationException pce) {
      Logger.error("XMLProcessor - Parser Config Error");
      pce.printStackTrace();
    }
    catch(IOException ioe) {
      Logger.error("XMLProcessor - I/O Error");
      ioe.printStackTrace();
    }
    catch(SAXException se) {
      Logger.error("XMLProcessor - SAX Error");
      se.printStackTrace();
    }
    return null;
  }

  private static String getSubTagValue(Node node, String subTagName) {
    String returnString = "";
    if (node != null) {
      NodeList  children = node.getChildNodes();
      for (int innerLoop =0; innerLoop < children.getLength(); innerLoop++) {
        Node  child = children.item(innerLoop);
        if ((child != null) && (child.getNodeName() != null) && child.getNodeName().equals(subTagName) ) {
          Node grandChild = child.getFirstChild();
          if (grandChild.getNodeValue() != null) {
            return grandChild.getNodeValue();
          }
        }
      } // end inner loop
    }
    return returnString;
  }

  public static HashMap loadScreenDefinitions(String location) {

    Document document = getDocument(location);
    HashMap screenDefinitions = new HashMap();

    Element root = document.getDocumentElement();
    NodeList list = root.getElementsByTagName(SCREEN_DEFINITION);
    for (int x = 0; x < list.getLength(); x++) {
      Node node = list.item(x);
      if (node != null) {

        String screenName = getSubTagValue(node,SCREEN_NAME);
        String template = getSubTagValue(node,TEMPLATE);
        String key = "";
        String value = "";
        String directStr = "";
        boolean direct = false;

        /*
          Get all the 'parameter' elements and extract their
          key and value definitions
        */
        if (node instanceof Element) {
          Element element = (Element)node;
          NodeList paramList = element.getElementsByTagName(PARAMETER);
          HashMap parameters = new HashMap();
          for (int y = 0; y < paramList.getLength(); y++) {
            key = ((Element)paramList.item(y)).getAttribute(KEY);
            value = ((Element)paramList.item(y)).getAttribute(VALUE);
            directStr = ((Element)paramList.item(y)).getAttribute(DIRECT);
            if ((directStr != null) && directStr.equals("true")) {
              direct = true;
            }
            else {
              direct = false;
            }
            ScreenParameter parameter = new ScreenParameter(key,value,direct);
            parameters.put(key, parameter);
          }
          ScreenMapping screen = new ScreenMapping(screenName,template,parameters);
          screenDefinitions.put(screenName,screen);
        }
      }
    }
    return screenDefinitions;
  }

  public static HashMap getExceptionMappings(String location) {

    Document document = getDocument(location);
    Element root = document.getDocumentElement();

    HashMap exceptionMappings = new HashMap();
    NodeList list = root.getElementsByTagName(EXCEPTION_MAPPING);
    for (int loop = 0; loop < list.getLength(); loop++) {
      Node node = list.item(loop);
      if (node != null) {
        String exceptionClassName = "";
        String screen = null;
        // get exception nodes
        // need to be a element to get attributes
        if (node instanceof Element) {
          Element element = ((Element)node);
          exceptionClassName = element.getAttribute(EXCEPTION_CLASS);
          screen = element.getAttribute(SCREEN);
          exceptionMappings.put(exceptionClassName, screen);
        }

      }
    }
    return exceptionMappings;
  }
}