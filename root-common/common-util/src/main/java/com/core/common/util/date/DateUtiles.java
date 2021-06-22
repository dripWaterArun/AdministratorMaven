package com.core.common.util.date;

import com.core.common.regex.DateRegex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author daixu
 */
public class DateUtiles {

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String HH_MM_SS = "HH:mm:ss";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    /**
     * 判断是否是日期格式的字符串
     * @return
     */
   public static boolean isDateStr(Object obj){
        if (obj !=null) {
            String strDate = String.valueOf(obj);
            if (strDate.matches(DateRegex.YYYY_MM_DD_HH_MM_SS)){
                return true;
            }else if (strDate.matches(DateRegex.YYYY_MM_DD)){
                return true;
            } else if (strDate.matches(DateRegex.YYYY)) {
                return true;
            }else if (strDate.matches(DateRegex.YYYY_MM)) {
                return true;
            }else if (strDate.matches(DateRegex.HH_MM_SS)) {
                return true;
            }else if (strDate.matches(DateRegex.YYYYMMDDHHMMSS)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 日期格式化，返回日期类型（LocalDateTime）
     * @param strDate 日期格式的字符串
     * @return 如参数为 null 返回当前时间
     */
   public static LocalDateTime localDateTimeFormat(Object strDate){
        LocalDateTime localDateTime = LocalDateTime.now();
        if (isDateStr(strDate)) {
            String time = " 00:00:00";
            //转换为字符串
            String str = String.valueOf(strDate);
            //获取月
            int month = localDateTime.get(ChronoField.MONTH_OF_YEAR);
            //获取日
            int day = localDateTime.getDayOfMonth();

            //默认是 LocalDateTime 格式的字符串
            if (str.matches(DateRegex.YYYY_MM_DD)){
                //获取 时分秒 拼接成 YYY-MM-DD HH:mm:ss 格式
                str = str + time;
            } else if (str.matches(DateRegex.YYYY_MM)){
                //获取 月 日 拼接成 YYY-MM-DD HH:mm:ss 格式
                str = str + day + time;
            } else if (str.matches(DateRegex.YYYY)) {
                //获取月 日 拼接成 YYY-MM-DD HH:mm:ss 格式
                str = str + month + day + time;
            } else if(str.matches(DateRegex.YYYYMMDDHHMMSS)){
                //字符串，转化为 yyyy-MM-dd HH:mm:ss 格式
                //字符串转日期
                DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS);
                localDateTime = LocalDateTime.parse(str, timeDtf);
            }

            //判断是否符合日期格式化规范
            if (str.matches(DateRegex.YYYY_MM_DD_HH_MM_SS)){
                //字符串转日期
                DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
                localDateTime = LocalDateTime.parse(str, timeDtf);
            }
        }

        return localDateTime;
    }

    /**
     * 日期格式化，返回日期类型（LocalDate）
     * @param strDate 日期格式的字符串
     * @return 如参数为 null 返回当前时间
     */
   public static LocalDate localDateFormat(Object strDate) {
        LocalDate localDate = LocalDate.now();
        if (isDateStr(strDate)) {
            LocalDateTime localDateTime = LocalDateTime.now();
            //转换为字符串
            String str = String.valueOf(strDate);
            //获取月
            int month = localDateTime.get(ChronoField.MONTH_OF_YEAR);
            //获取日
            int day = localDateTime.getDayOfMonth();
            //是 LocalDate 格式的字符串
            if (str.matches(DateRegex.YYYY_MM_DD_HH_MM_SS)){
                //字符串截取，只取 年 月 日
                //获取空格的位置
                int end = str.indexOf("\\t");
                //从头开始，一直截取到空格之前的位置
                str = str.substring(0,end);
            } else if (str.matches(DateRegex.YYYY)){
                //获取月 日 拼接成 YYY-MM-DD 格式
                str = str + month + day;
            } else if (str.matches(DateRegex.YYYY_MM)){
                //获取月 日 拼接成 YYY-MM-DD 格式
                str = str + day;
            }

            //是 LocalDate 格式的字符串
            if (str.matches(DateRegex.YYYY_MM_DD)){
                //字符串转日期
                DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern(YYYY_MM_DD);
                localDate = LocalDate.parse(str, timeDtf);
            }
        }
        return localDate;
    }

    /**
     * 日期格式化，返回日期类型（LocalTime）
     * @param strDate 日期格式的字符串
     * @return 如参数为 null 返回当前时间
     */
   public static LocalTime localTimeFormat(Object strDate) {
       //获取
       LocalTime localTime = LocalTime.now();
       if (isDateStr(strDate)) {
           //转换为字符串
           String str = String.valueOf(strDate);
           //是 LocalTime 格式的字符串
           if (str.matches(DateRegex.HH_MM_SS)){
               //字符串转日期
               DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern(HH_MM_SS);
               localTime = LocalTime.parse(str, timeDtf);
           }
       }
        return localTime;
    }

    /**
     * 日期格式化，返回日期类型（Date）
      * @param strDate
     * @return
     */
   public static Date dateFormat(Object strDate){
       //普通日期格式
       Date date = new Date();
       if (isDateStr(strDate)) {
           //转换为字符串
           String str = String.valueOf(strDate);
           SimpleDateFormat format = new SimpleDateFormat(strFormat(str));
           try {
               date = format.parse(str);
           } catch (ParseException e) {
               e.printStackTrace();
           }
       }
       return date;
   }

    /**
     * 字符串转化日期的格式
     * @param strDate 字符串
     * @return 字符串应该转化为日期的格式（如果格式不对，默认返回 yyyy-MM-dd）
     */
   public static String strFormat(String strDate){

        if (strDate.length() == YYYY_MM_DD_HH_MM_SS.length()) {
            return YYYY_MM_DD_HH_MM_SS;
        }else if (strDate.length() == YYYY.length()){
            return YYYY;
        }else if (strDate.length() == YYYY_MM.length()){
            return YYYY_MM;
        }else if (strDate.length() == YYYYMMDDHHMMSS.length()){
            return YYYYMMDDHHMMSS;
        }

        return YYYY_MM_DD;

    }

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        //由于Date存在时区以及千年虫问题,方法都被Calendar的相关方法取代。
        //默认表示当前系统时间
        Calendar calendar = Calendar.getInstance();
        //将其表示的时间以一个Date实例形式返回。
        return calendar.getTime();
    }

    /**
     * 获取指定月份，的初始日期
     * @param montd （0 本月1号）（1 前1个月的1号）（2 前2个月的1号）
     * @return 月份日期 字符串
     * @author daixu
     */
    public static String getMonth(int montd){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -montd);
        calendar.set(Calendar.DATE, 1);
        Date date = calendar.getTime();
        return format.format(date);
    }

    /**
     * 获取指定年份，的初始日期
     * @param year （0 本年1月1号）（1 前1年的 1月1号）（2 前2年的 1月1号）
     * @return 年份日期 字符串
     * @author daixu
     */
    public static String getYear(int year){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -year);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        Date date = calendar.getTime();
        return format.format(date);
    }
}
