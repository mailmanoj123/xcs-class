package com.xchanging.xcc.web.models.manager;

/**
 * Claims Convergence Web GUI Project
 *
 * File:    ModelUpdateNotifier.java
 * Date:    September 2002
 * Version: 1.0
 *
 * Author:  Dave Houlden
 *          Steria UK
 *
 * Description: Parent class of the ModelManager. It is used to maintain a list
 * of all web models that require to be notified of any data updates from the
 * commarea.
 *
 * Modification History
 * --------------------
 * Author:
 * Date:
 * Description:
 *
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.xchanging.xcc.web.models.ModelUpdateListener;

public class ModelUpdateNotifier {

  private HashMap listenerMap;

  public ModelUpdateNotifier() {
    listenerMap = new HashMap();
  }

  public void addListener(String modelType, Object listener) {

    if (listenerMap.get(modelType) == null) {
      ArrayList listeners = new ArrayList();
      listeners.add(listener);
      listenerMap.put(modelType,listeners);
    }
    else {
      ((ArrayList) listenerMap.get(modelType)).add(listener);
    }
  }

  public void notifyListeners(Collection updatedModelList) {

    for (Iterator it1 = updatedModelList.iterator() ; it1.hasNext() ;) {
      String modelType = (String) it1.next();
      Collection listeners = (Collection)listenerMap.get(modelType);
      if (listeners != null) {
        for (Iterator it2 = listeners.iterator(); it2.hasNext(); ) {
          ((ModelUpdateListener) it2.next()).performUpdate();
        }
      }
    }
  }
}