package com.xchanging.xcc.web.html;

import java.text.DecimalFormat;

import com.xchanging.xcc.logging.Logger;
import com.xchanging.xcc.web.models.reference.DropdownList;

/**
 * General utilyty class that generates various input fields, for various values. 
 * 
 * @author Steria
 * @author Patrick Cogan
 */
// For changes see bottom of file.
public class HTMLUtils {

    public static final int ACTION = 1;

    public static final int NAVIGATION = 2;

    public static final int HEADER = 3;

    public static final int HELP = 4;

    public static final int FATACTION = 5;

    public static final int FATNAVIGATION = 6;

    public static final int NORMAL = 1;

    public static final int READONLY = 2;

    public static final int DISPLAY = 3;

    public static final int ERROR = 4;

    public static String escapeChars(String s) {
        int x;
        while ((x = s.indexOf("\"")) > -1) {
            s = s.substring(0, x) + "&quot;" + s.substring(x + 1);
        }
        return s;
    }

    private static String stripOutSpaces(String in) {
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == ' ') {
                in = in.substring(0, i) + in.substring(i + 1);
            }
        }
        return in;
    }

    public static String createButton(int buttonType, String name, String title, String onClick) {
        String buttonMagic;
        String buttonClass = "";

        switch (buttonType) {
            case 1:
                buttonClass = "actionButton";
                break;
            case 2:
                buttonClass = "navigationButton";
                break;
            case 3:
                buttonClass = "headerButton";
                break;
            case 4:
                buttonClass = "helpButton";
                break;
            case 5:
                buttonClass = "fatActionButton";
                break;
            case 6:
                buttonClass = "fatNavigationButton";
        }

        buttonMagic = "" + "<table name='" + stripOutSpaces(name) + "' id='" + stripOutSpaces(name)
                                        + "' border='0' cellpadding='0' cellspacing='0' class='" + buttonClass + "' onClick='" + onClick
                                        + "'> " + "<tr> " + "<td class='left'>&nbsp;</td> " + "<td class='middle'> " + title + "</td> "
                                        + "<td class='right'>&nbsp;</td> " + "</tr> " + "</table>";

        return buttonMagic;
    }

    public static String createButton(int buttonType, String title, String onClick) {
        return createButton(buttonType, title.toLowerCase() + "Button", title, onClick);
    }

    public static String createTitle(String title) {
        String titleMagic;

        titleMagic = "" + "<table  border='0' cellpadding='0' cellspacing='0' class='formHeading' > " + "<tr> "
                                        + "<td class='left'>&nbsp;</td> " + "<td class='middle' nowrap> " + title + "</td> "
                                        + "<td class='right'>&nbsp;</td> " + "</tr> " + "</table> ";

        return titleMagic;
    }

    public static String createHeader(String title) {
        String headerMagic;

        headerMagic = "" + "<table border='0' cellpadding='0' cellspacing='0' class='heading'> " + "<tr> "
                                        + "<td class='left'>&nbsp;</td> " + "<td class='middle' nowrap > " + title + "</td> "
                                        + "<td class='right'>&nbsp;</td> " + "</tr> " + "</table> ";

        return headerMagic;
    }

    private static String subStr(String s, int start, int end) {
        if ((s != null) && (start < s.length())) {
            if (end < s.length()) {
                s = s.substring(start, end);
            } else {
                s = s.substring(start);
            }
        }
        return s;
    }

    public static String createOsnd(String name, int format, String value) {
        String textFieldMagic = "";
        if (value == null)
            value = "";

        if ((value.length() == 13) || (value.length() == 0)) {
            if ((format == NORMAL) || (format == READONLY) || (format == ERROR)) {
                textFieldMagic += "<table class='osnd' border='0' cellpadding='0' id='" + name + "'>";
                textFieldMagic += "  <tr>";
                textFieldMagic += "    <td class='sssss'>";
                textFieldMagic += "      <input type='text' maxlength='5' name='" + name + "sssss' value='" + subStr(value, 8, 13) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\"";

                textFieldMagic += " onBlur='updateOsnd(" + name + "HF," + name + "sssss, " + name + "dd," + name + "mm," + name + "yy)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      *";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='dd'>";
                textFieldMagic += "      <input type='text' maxlength='2' name='" + name + "dd' value='" + subStr(value, 6, 8) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\"";

                textFieldMagic += " onBlur='updateOsnd(" + name + "HF," + name + "sssss, " + name + "dd," + name + "mm," + name + "yy)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      /";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='mm'>";
                textFieldMagic += "      <input type='text' maxlength='2' name='" + name + "mm' value='" + subStr(value, 4, 6) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\"";

                textFieldMagic += " onBlur='updateOsnd(" + name + "HF," + name + "sssss, " + name + "dd," + name + "mm," + name + "yy)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      /";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='yy'>";
                textFieldMagic += "      <input type='text' maxlength='2' name='" + name + "yy' value='" + subStr(value, 2, 4) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\"";

                textFieldMagic += " onBlur='updateOsnd(" + name + "HF," + name + "sssss," + name + "dd," + name + "mm," + name + "yy)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "  </tr>";
                textFieldMagic += "</table>";
                textFieldMagic += "<input type='hidden' name='" + name + "HF'>";
            } else {
                if (value.length() > 0)
                    textFieldMagic += "<span id='" + name + "'>" + subStr(value, 8, 13) + " * " + subStr(value, 6, 8) + "/"
                                                    + subStr(value, 4, 6) + "/" + subStr(value, 2, 4) + "</span>";
            }
        } else {
            textFieldMagic += value;
        }

        return textFieldMagic;
    }

    /**
     * Creates formated UMR imput fields.
     * 
     * @author Patrick Cogan
     * 
     * @param name the name of the fields
     * @param format the format, wether input, readonly or error.
     * @param value the value to be formated, pussed in in the form UMR="BNNNNXXXXXXXXXXXX", where B is always B, N is the 4 digit broker num and X is 
     * any alphanum charinc space but not imbeded spaces, and of length 1 to 12 chars long.
     * 
     * @return The html outputed string
     * 
     * @author Patrick Cogan
     */
    public static String createUmr(String name, int format, String value) {
        Logger.debug("In HTMLUtils: format = " + format);
        String textFieldMagic = "";
        if (value == null)
            value = "";

        if ((value.length() > 6) || (value.length() < 17)) {
            if ((format == NORMAL) || (format == READONLY) || (format == ERROR)) {
                textFieldMagic += "<table class='umr' border='0' cellpadding='0' id='" + name + "'>";
                textFieldMagic += "  <tr>";
                // First Part - B
                textFieldMagic += "    <span>";
                textFieldMagic += "    <td class='umrb'>";
                textFieldMagic += "      <input type='text' maxlength='1' name='" + name + "umrb' value='" + subStr(value, 0, 1) + "'";

                if (format == READONLY) {
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";
                }

                if (format == ERROR) {
                    textFieldMagic += " class=\"fieldError\"";
                }

                textFieldMagic += " onBlur='updateUmr(" + name + "HF," + name + "umrb, " + name + "umrbn," + name + "umranum)'>";
                textFieldMagic += "    </td>";
                // Second Part - NNNN
//                textFieldMagic += "    <td>";
//                textFieldMagic += "      &nbsp;";
//                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='umrbn'>";
                textFieldMagic += "      <input type='text' maxlength='4' name='" + name + "umrbn' value='" + subStr(value, 1, 5) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\"";

                textFieldMagic += " onBlur='updateUmr(" + name + "HF," + name + "umrb, " + name + "umrbn," + name + "umranum)'>";
                textFieldMagic += "    </td>";
                // Third Part - XXXXXXXXXXXX
//                textFieldMagic += "    <td>";
//                textFieldMagic += "      ";
//                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='umranum'>";
                textFieldMagic += "      <input type='text' length='12' maxlength='12' name='" + name + "umranum' value='" + subStr(value, 5, 17) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\"";

                textFieldMagic += " onBlur='updateUmr(" + name + "HF," + name + "umrb, " + name + "umrbn," + name + "umranum)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "  </tr>";
                textFieldMagic += "  </span>";
                textFieldMagic += "</table>";
                textFieldMagic += "<input type='hidden' name='" + name + "HF'>";
            } else {
                if (value.length() > 0)
                    textFieldMagic += "<span id='" + name + "'>" + value + "</span>";
            }
        } else {
            textFieldMagic += value;
        }

        return textFieldMagic;
    }

    public static String createUcr(String name, int format, String value) {
        String textFieldMagic = "";
        if (value == null)
            value = "";

        if (((value.length() > 5) && (value.length() <= 17)) || (value.length() == 0)) {
            if ((format == NORMAL) || (format == READONLY)) {
                textFieldMagic += "<table class='ucr' border='0' cellpadding='0' id='" + name + "'>";
                textFieldMagic += "  <tr>";
                textFieldMagic += "    <td class='1'>";
                textFieldMagic += "      <input type='text' maxlength='1' name='" + name + "pt1' value='" + subStr(value, 0, 1) + "'";

                if (format == READONLY) {
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";
                }

                textFieldMagic += " onBlur='updateUcr(" + name + "HF," + name + "pt1," + name + "pt2," + name + "pt3)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      /";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='2'>";
                textFieldMagic += "      <input type='text' maxlength='4' name='" + name + "pt2' value='" + subStr(value, 1, 5) + "'";

                if (format == READONLY) {
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";
                }

                textFieldMagic += " onBlur='updateUcr(" + name + "HF," + name + "pt1," + name + "pt2," + name + "pt3)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      /";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='3'>";
                textFieldMagic += "      <input type='text' maxlength='12' name='" + name + "pt3' value='"
                                                + subStr(value, 5, value.length()) + "'";

                if (format == READONLY) {
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";
                }

                textFieldMagic += " onBlur='updateUcr(" + name + "HF," + name + "pt1," + name + "pt2," + name + "pt3)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "  </tr>";
                textFieldMagic += "</table>";
                textFieldMagic += "<input type='hidden' name='" + name + "HF'>";
            } else {
                if (value.length() > 0)
                    textFieldMagic += "<span id='" + name + "'>" + subStr(value, 0, 1) + "/" + subStr(value, 1, 5) + "/"
                                                    + subStr(value, 5, value.length()) + "</span>";
            }
        } else {
            textFieldMagic = value;
        }

        return textFieldMagic;
    }

    public static String createTdn(String name, int format, String value) {
        String textFieldMagic = "";
        if (value == null)
            value = "";

        if ((value.length() == 13) || (value.length() == 0)) {
            if ((format == NORMAL) || (format == READONLY) || (format == ERROR)) {
                textFieldMagic += "<table class='tdn' border='0' cellpadding='0' id='" + name + "'>";
                textFieldMagic += "  <tr>";
                textFieldMagic += "    <td class='sssss'>";
                textFieldMagic += "      <input type='text' maxlength='5' name='" + name + "sssss' value='" + subStr(value, 8, 13) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\">";

                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      *";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='dd'>";
                textFieldMagic += "      <input type='text' maxlength='2' name='" + name + "dd' value='" + subStr(value, 6, 8) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\">";

                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      /";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='mm'>";
                textFieldMagic += "      <input type='text' maxlength='2' name='" + name + "mm' value='" + subStr(value, 4, 6) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\">";

                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      /";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='yy'>";
                textFieldMagic += "      <input type='text' maxlength='4' name='" + name + "ccyy' value='" + subStr(value, 0, 4) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                if (format == ERROR)
                    textFieldMagic += " class=\"fieldError\">";

                textFieldMagic += "    </td>";
                textFieldMagic += "  </tr>";
                textFieldMagic += "</table>";
                textFieldMagic += "<input type='hidden' name='" + name + "HF'>";
            } else {
                if (value.length() > 0)
                    textFieldMagic += "<span id='" + name + "'>" + subStr(value, 8, 13) + " * " + subStr(value, 6, 8) + "/"
                                                    + subStr(value, 4, 6) + "/" + subStr(value, 0, 4) + "</span>";
            }
        } else {
            textFieldMagic += value;
        }

        return textFieldMagic;
    }

    public static String createGroupRef(String name, int format, String value) {
        String textFieldMagic = "";
        if (value == null)
            value = "";

        if ((value.length() == 11) || (value.length() == 0)) {
            if ((format == NORMAL) || (format == READONLY)) {
                textFieldMagic += "<table class='groupRef' border='0' cellpadding='0' id='" + name + "'>";
                textFieldMagic += "  <tr>";
                textFieldMagic += "    <td class='1'>";
                textFieldMagic += "      <input type='text' maxlength='4' name='" + name + "pt1' value='" + subStr(value, 0, 4) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                textFieldMagic += " onBlur='updateGroupRef(" + name + "HF," + name + "pt1," + name + "pt2)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td>";
                textFieldMagic += "      *";
                textFieldMagic += "    </td>";
                textFieldMagic += "    <td class='2'>";
                textFieldMagic += "      <input type='text' maxlength='6' name='" + name + "pt2' value='" + subStr(value, 5, 11) + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                textFieldMagic += " onBlur='updateGroupRef(" + name + "HF," + name + "pt1," + name + "pt2)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "  </tr>";
                textFieldMagic += "</table>";
                textFieldMagic += "<input type='hidden' name='" + name + "HF'>";
            } else {
                if (value.length() > 0)
                    textFieldMagic += "<span id='" + name + "'>" + subStr(value, 0, 4) + "/" + subStr(value, 5, 11) + "</span>";
            }
        } else {
            textFieldMagic += value;
        }

        return textFieldMagic;
    }

    public static String createCor(String name, int format, String value) {
        String textFieldMagic = "";
        if (value == null)
            value = "";

        value = value.trim();
        if (((value.length() == 11) || (value.length() == 12)) || (value.length() == 0)) {
            if ((format == NORMAL) || (format == READONLY)) {
                textFieldMagic += "<table class='cor' border='0' cellpadding='0' id='" + name + "'>";
                textFieldMagic += "  <tr>";
                textFieldMagic += "    <td class='1'>";
                textFieldMagic += "      <input type='text' maxlength='15' name='" + name + "pt1' value='" + value + "'";

                if (format == READONLY)
                    textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

                textFieldMagic += " onBlur='updateCor(" + name + "HF," + name + "pt1)'>";
                textFieldMagic += "    </td>";
                textFieldMagic += "  </tr>";
                textFieldMagic += "</table>";
                textFieldMagic += "<input type='hidden' name='" + name + "HF'>";
            } else {
                textFieldMagic += "<span id='" + name + "'>";

                if (value.length() > 0) {
                    if (value.substring(0, 1).equalsIgnoreCase("M"))
                        textFieldMagic += subStr(value, 0, 1) + " " + subStr(value, 1, 3) + "/" + subStr(value, 3, 5) + " "
                                                        + subStr(value, 5, 10) + " " + subStr(value, 10, 11);
                    else if ((value.substring(0, 1).equalsIgnoreCase("A")) || (value.substring(0, 1).equalsIgnoreCase("N")))
                        textFieldMagic += subStr(value, 0, 1) + " " + subStr(value, 1, 6) + "/" + subStr(value, 6, 12);
                    else
                        textFieldMagic += value;
                }

                textFieldMagic += "</span>";
            }
        } else {
            textFieldMagic += value;
        }

        return textFieldMagic;
    }

    public static String createDate(String name, int format, String value) {
        String day = "";
        String month = "";
        String year = "";
        String textFieldMagic = "";

        if (value == null)
            value = "";

        if ((value.length() == 10) && (!value.equals("1900-01-01"))) {
            if (!value.substring(7, 10).equals("-00"))
                day = value.substring(8, 10);

            if (!value.substring(4, 7).equals("-00"))
                month = value.substring(5, 7);

            year = value.substring(0, 4);
        }

        if ((value.length() == 8) && (!value.equals("19000101"))) {
            if (!value.substring(6, 8).equals("00"))
                day = value.substring(6, 8);

            if (!value.substring(4, 6).equals("00"))
                month = value.substring(4, 6);

            if (!value.substring(0, 4).equals("0000"))
                year = value.substring(0, 4);
        }

        if ((format == NORMAL) || (format == READONLY) || (format == ERROR)) {
            textFieldMagic += "<table class='dateField' border='0' cellpadding='0' id='" + name + "'>";
            textFieldMagic += "  <tr>";
            textFieldMagic += "    <td class='dd'>";
            textFieldMagic += "      <input type='text' maxlength='2' name='" + name + "dd' value='" + day + "'";

            if (format == READONLY)
                textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

            if (format == ERROR)
                textFieldMagic += " class=\"fieldError\"";

            textFieldMagic += " onBlur='updateDate(" + name + "HF," + name + "dd," + name + "mm," + name + "yyyy)'>";
            textFieldMagic += "    </td>";
            textFieldMagic += "    <td>/</td>";
            textFieldMagic += "    <td class='mm'>";
            textFieldMagic += "      <input type='text' maxlength='2' name='" + name + "mm' value='" + month + "'";

            if (format == READONLY)
                textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

            if (format == ERROR)
                textFieldMagic += " class=\"fieldError\"";

            textFieldMagic += " onBlur='updateDate(" + name + "HF," + name + "dd," + name + "mm," + name + "yyyy)'>";
            textFieldMagic += "    </td>";
            textFieldMagic += "    <td>";
            textFieldMagic += "      /";
            textFieldMagic += "    </td>";
            textFieldMagic += "    <td class='yyyy'>";
            textFieldMagic += "      <input type='text' maxlength='4' name='" + name + "yyyy' value='" + year + "'";

            if (format == READONLY)
                textFieldMagic += " readonly=\"true\" class=\"fieldProtect\"";

            if (format == ERROR)
                textFieldMagic += " class=\"fieldError\"";

            textFieldMagic += " onBlur='updateDate(" + name + "HF," + name + "dd," + name + "mm," + name + "yyyy)'>";
            textFieldMagic += "    </td>";
            textFieldMagic += "  </tr>";
            textFieldMagic += "</table>";
            textFieldMagic += "<input type='hidden' name='" + name + "HF'>";
        } else {
            String fullDate = "";
            if (year.length() > 0) {
                fullDate = year;

                if (month.length() > 0) {
                    fullDate = month + "/" + fullDate;

                    if (day.length() > 0) {
                        fullDate = day + "/" + fullDate;
                    }
                }
            }
            textFieldMagic += "<span id='" + name + "'>" + fullDate + "</span>";
        }

        return textFieldMagic;
    }

    public static String createDropdown(String name, String value, boolean protect, DropdownList refData, boolean error) {
        String ddl = "";
        if (protect) {
            ddl += "<input type=\"text\" value=\"" + refData.getDisplayValue(value) + "\" class=\"fieldProtect\" readonly=\"true\">";
            ddl += "<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\">";
        } else {
            ddl += "<select name=\"" + name + "\">\n";
            DropdownList.DropdownValue[] values = refData.getValues();
            for (int i = 0; i < values.length; i++) {
                ddl += "<option value=\"" + values[i].getValue() + "\"";

                if (error)
                    ddl += " class=\"fieldError\"";

                if (value.equals(values[i].getValue()))
                    ddl += " SELECTED";

                ddl += ">" + values[i].getDisplayValue() + "</option>\n";
            }
            ddl += "</select>";
        }
        return ddl;
    }

    public static String createDropdown(String name, String value, boolean protect, DropdownList refData) {
        return createDropdown(name, value, protect, refData, false);
    }
    
    /**
     * Creates a dropdown with the old values there for the updated quals list on the protected field.
     * @param name
     * @param value
     * @param protect
     * @param refData
     * @param error
     * @return
     */
    public static String createDropdownWOldVals(String name, String value, boolean protect, DropdownList refData, boolean error) {
        String ddl = "";
        if (protect) {
            ddl += "<input type=\"text\" value=\"" + value + "\" class=\"fieldProtect\" readonly=\"true\">";
            ddl += "<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\">";
        } else {
            ddl += "<select name=\"" + name + "\">\n";
            DropdownList.DropdownValue[] values = refData.getValues();
            for (int i = 0; i < values.length; i++) {
                ddl += "<option value=\"" + values[i].getValue() + "\"";

                if (error)
                    ddl += " class=\"fieldError\"";

                if (value.equals(values[i].getValue()))
                    ddl += " SELECTED";

                ddl += ">" + values[i].getDisplayValue() + "</option>\n";
            }
            ddl += "</select>";
        }
        return ddl;
    }

    
    /**
     * Creates a dropdown with the old values there for the updated quals list on the protected field.
     *
     * @param name
     * @param value
     * @param protect
     * @param refData
     * @return
     */public static String createDropdownWOldVals(String name, String value, boolean protect, DropdownList refData) {
        return createDropdownWOldVals(name, value, protect, refData, false);
    }
    
    public static String createOsFeeDropdown(String name, String dropdownValue, boolean protect, DropdownList refData, String feeValue) {
        if (feeValue == null) {
            feeValue = "";
        }
        String ddl = "";
        if (protect) {
            ddl += "<input type=\"text\" value=\"" + dropdownValue + "\" class=\"fieldProtect\" readonly=\"true\">";
            ddl += "<input type=\"hidden\" name=\"" + name + "\" value=\"" + dropdownValue + "\">";
        } else {
            ddl += "<select name=\"" + name + "\">\n";
            DropdownList.DropdownValue[] values = refData.getValues();
            for (int i = 0; i < values.length; i++) {
                String optnVal = values[i].getValue();
                ddl += "<option value=\"" + optnVal + "\"";
                if (dropdownValue.equals(values[i].getValue()))
                    ddl += " SELECTED";
                if ("N".equals(optnVal) && ("".equals(feeValue) || "0".equals(feeValue)))
                    ddl += " SELECTED";

                ddl += ">" + values[i].getDisplayValue() + "</option>\n";
            }
            ddl += "</select>";
        }
        return ddl;
    }
    
    public static String removeCommas(String value)
    {
        if(value==null || value.trim().equals(""))
        {
            return "";
        }
        while (value.indexOf(",") > -1)
        {
            value = value.substring(0, value.indexOf(",")) + value.substring(value.indexOf(",") + 1);
        }
        return value;
    }

    public static String insertCommas(String value)
    {
        value = removeCommas(value);

        if (value == null || value.trim().equals(""))
        {
            return "";
        }

        if (Double.isNaN(Double.parseDouble(value)))
        {
            return "";
        }

        double valueDouble = Double.parseDouble(value);

        String number = "";
        String decimal = "";
        boolean isNegative = valueDouble < 0 ? true : false;

        if (isNegative)
        {
            value = value.substring(1);
        }

        if (value.indexOf(".") != -1)
        {
            number = value.substring(0, value.indexOf("."));
            decimal = value.substring(value.indexOf("."));
        }
        else
        {
            number = value;
            decimal = "";
        }

        double loopLength = Math.floor((double) number.length() / 3);
        int insertPoint = number.length() % 3;
        if (insertPoint == 0)
        {
            loopLength--;
            insertPoint += 3;
        }

        for (int i = 0; i < loopLength; i++)
        {
            number = number.substring(0, insertPoint) + "," + number.substring(insertPoint);
            insertPoint += 4;
        }

        if (isNegative)
            number = "-" + number;

        number += decimal;

        return number;

    }
    
    public static String formatDecimal(String value)
    {
        if(value==null || value.trim().equals("") || value.trim().equals("0"))
        {
            return "0.00";
        }
        
        DecimalFormat dFormat = new DecimalFormat("#0.00");
        
        return dFormat.format(Double.parseDouble(value));
    }
    
    public static String formatNoDecimal(String value)
    {
        if(value==null || value.trim().equals("") || value.trim().equals("0.00"))
        {
            return "0";
        }
        
        DecimalFormat dFormat = new DecimalFormat("#0");
        
        return dFormat.format(Double.parseDouble(value));
    }
    
    public static String formatROE(String value)
    {
        if(value==null || value.trim().equals("") || value.trim().equals("0.00") || value.trim().equals("0"))
        {
            return "0.00000";
        }
        
        DecimalFormat dFormat = new DecimalFormat("#,###,##0.00000");
        
        return dFormat.format(Double.parseDouble(value));
    }
    public static String replaceAll(String value, String oldValue, String newValue)
    {
        final int valueLen = value.length();
        final int oldValueLen = oldValue.length();
        final int newValueLen = newValue.length();
        int oldPos = 0;
        int newPos = 0;
 
        if (oldValueLen == newValueLen)
        {
            StringBuffer sb = new StringBuffer( value );
 
            while( (newPos = value.indexOf(oldValue, oldPos)) > -1)
            {
                sb.replace(newPos, newPos + newValueLen, newValue);
                oldPos = newPos + oldValueLen;
            }
 
            return sb.toString();
        }
        else
        {
            int size = Math.max(valueLen, valueLen * newValueLen / oldValueLen);
            StringBuffer sb = new StringBuffer( size );
 
            while( (newPos = value.indexOf( oldValue, oldPos ) ) > -1)
            {
                sb.append( value.substring(oldPos, newPos) );
                sb.append( newValue );
                oldPos = newPos + oldValueLen;
            }
 
            sb.append(value.substring( oldPos ) );
 
            return sb.toString();
        }
    }
    
}

/*
$Log: HTMLUtils.java,v $
Revision 1.6.12.1  2005/09/30 12:09:58  coganp
fixed conflicts between different branches

Revision 1.6.10.2  2005/08/19 07:30:38  coganp
Fixed to show values in the readonly version

Revision 1.6.10.1  2005/08/12 10:04:05  coganp
created createOsFeeDropdown for the os fee dropdown on scm adv screen

Revision 1.6  2004/03/23 16:55:40  coganp
added logging


*/