package com.xchanging.xcc.web.models;

import java.util.Vector;

import javax.resource.cci.MappedRecord;

import com.xchanging.xcc.events.ClaimsEvent;
import com.xchanging.xcc.events.LY11Event;
import com.xchanging.xcc.events.LY12Event;
import com.xchanging.xcc.utils.Keys;
import com.xchanging.xcc.web.models.manager.ModelManager;

public class NavigationBarModel extends WebModel implements ModelUpdateListener {

  private ModelManager mm;
  private Vector navBarLines;
  private Vector rootMenus = new Vector();
  private String currentScreen;

  public NavigationBarModel(ModelManager mm) {
    this.mm = mm;
    mm.addListener(Keys.NavigationBarKey, this);
  }

  public Vector getRootMenus() {
    return rootMenus;
  }

  private int getIndent(MappedRecord current) {
    String indentInd = (String)current.get("@C012_INDENT_IND");
    return (!indentInd.equals(""))?Integer.parseInt(indentInd):-1;
  }

  private MenuEntry extractMenu(int startPoint) {
    MenuEntry menu = new MenuEntry();
    int i = startPoint;
    MappedRecord current = (MappedRecord)navBarLines.get(i);
    MappedRecord previous = null;
    int startIndex = getIndent(current);
    int currentIndex = startIndex;
    MenuItem item = null;
    boolean doExtract=true;

    while ((currentIndex!=-1) && (currentIndex>=startIndex)) {

      boolean createMenuItem = (currentIndex==startIndex);
      if (createMenuItem) {
        doExtract = true;
        item = new MenuItem((String)current.get("@C012_TEXT_LINE"),
                            (String)current.get("@C012_CURR_SCR_IND"),
                            (String)current.get("@C012_INDENT_IND"),
                            (String)current.get("@C012_SCREEN_ID"),
                            (String)current.get("@C012_UCR_TR_SYS_REF"),
                            (String)current.get("@C012_CURR_NO"),
                            (String)current.get("@C012_SDN_NO"),
                            (String)current.get("@C012_STAT_SPLIT_NO"),
                            (String)current.get("@C012_BREAKDOWN_NO"),
                            currentScreen);

        if (((String)current.get("@C012_CURR_SCR_IND")).equals("Y"))
          rootMenus.add(new RootMenu((String)current.get("@C012_TEXT_LINE"),menu));
      }

      previous = current;
      i++;

      try {
        current = (MappedRecord)navBarLines.get(i);
        currentIndex = getIndent(current);
      } catch (ArrayIndexOutOfBoundsException e) {
        currentIndex = -1;
      }

      if ((doExtract) && (currentIndex>startIndex)) {
        int numberOfRoots = rootMenus.size();
        item.setChild(extractMenu(i)); // was i
        doExtract = false;

        if (rootMenus.size()>numberOfRoots) {
          rootMenus.add(new RootMenu((String)previous.get("@C012_TEXT_LINE"),menu));
        }
      }

      if (createMenuItem)
        menu.addMenuItem(item);
    }
    return menu;
  }

  public void performUpdate() {

    rootMenus = new Vector();

    ClaimsEvent event = (ClaimsEvent)session.getAttribute(Keys.WebEventKey);
    MappedRecord record = (MappedRecord)session.getAttribute((Keys.CicsDataKey));

    if (event instanceof LY12Event) {
      currentScreen = ((LY12Event)event).getCurrentScreen();
      Vector navBar = (Vector)record.get("#C012_NAVIGATION_BAR[]");
      MappedRecord navBar1 = (MappedRecord)navBar.elementAt(0);
      navBarLines = (Vector)navBar1.get("#C012_NAV_BAR_LINE[]");
      MenuEntry menu = extractMenu(1); // was 1
      if (rootMenus.size()==0)
        rootMenus.add(new RootMenu("ROOT MENU IND",menu));
    }
    else if (event instanceof LY11Event) {
      String nextProg = (String)record.get(Keys.LY11NextProgField);
      session.setAttribute(Keys.ScreenKey,nextProg);
    }
  }
  public String getCurrentScreen() {
    return currentScreen;
  }
}