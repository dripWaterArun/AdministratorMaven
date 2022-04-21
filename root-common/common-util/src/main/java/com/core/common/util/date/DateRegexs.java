package com.core.common.util.date;
/**
 * 正则表达式：日期
 * @author daixu
 */
public class DateRegexs {

    public static final String YYYY = "^\\d{4}$";

    public static final String YYYY_MM = "^\\d{4}-\\d{2}$";

    public static final String HH_MM_SS = "^\\d{2}:\\d{2}:\\d{2}$";

    public static final String YYYY_MM_DD = "^\\d{4}-\\d{2}-\\d{2}$";

    public static final String YYYYMMDDHHMMSS = "^\\d{14}$";

    public static final String YYYY_MM_DD_HH_MM_SS = "^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$";
}
