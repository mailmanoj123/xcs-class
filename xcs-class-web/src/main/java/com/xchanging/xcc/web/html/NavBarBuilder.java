package com.xchanging.xcc.web.html;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.xchanging.xcc.web.models.MenuEntry;
import com.xchanging.xcc.web.models.MenuItem;

public class NavBarBuilder {
        public static String build(MenuEntry menu,String name,HttpServletRequest request) {
                String menuStr = "";

                menuStr += "var " + name + " = new menu(false);\n";

                Enumeration e = menu.getMenuItems();
                int i = 0;
                while(e.hasMoreElements()) {
                        MenuItem item = (MenuItem)e.nextElement();
                        menuStr += "var " + name + "i" + i + " = new menuItem(\"" + item.getText() + "\",\""
                                + "submitForm(&quot;" + request.getContextPath() + "/control/navbar?"
                                + "screenId=" + item.getScreenId()
                                + "&ucrTrSysRef=" + item.getUcrTrSysRef()
                                + "&currNo=" + item.getCurrNo()
                                 + "&sdnNo=" + item.getSdnNo()
                                + "&statSplitNo=" + item.getStatSplitNo()
                                + "&breakdownNo=" + item.getBreakdownNo()
                                + "&currentScreen=" + item.getCurrentScreen()
                                + "&quot;)\");\n";

                        if (item.hasChild()) {
                                menuStr += build(item.getChild(),name + "i" + i + "m", request);
                                menuStr += name + "i" + i + ".add(" + name + "i" + i + "m);\n";
                        }

                        menuStr += name + ".add(" + name + "i" + i + ");\n";
                }

                return menuStr;
        }
}