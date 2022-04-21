package com.core.common.util.date;

import com.core.common.regex.DateRegex;
import org.springframework.util.StringUtils;

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
public class DateUtil {

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

    /**
     * 验证时间是否过期
     * @param now 当前时间
     * @param end 过期时间
     * @return 过期（true） 不过期 （false）
     */
    public static boolean checktime(Date now, Date end ){
        if (now != null && end != null) {
            long diff = now.getTime() - end.getTime();
            if (diff>0){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取 指定小时 之前/之后的时间
     * @param date 日期
     * @param hours 指定小时
     * @param order 前后（front 前）（after 后）
     * @return 指定小时之后的时间
     */
    public static Date getToHourByOrder(Date date,Integer hours,String order) {
        if (date!=null) {
            int hour = 0;
            //前
            if ("front".equals(order)) {
                hour=hours;
            }
            //后
            if ("after".equals(order))  {
                hour=-hours;
            }
            return new Date(date.getTime() - 60 * 60 * 1000 * hour);
        }
        return new Date();
    }

    public static Date getToMinuteByOrder(Date date,Integer minute,String order) {
        if (date!=null) {
            int hour = 0;
            //前
            if ("front".equals(order)) {
                hour=minute;
            }
            //后
            if ("after".equals(order))  {
                hour=-minute;
            }
            return new Date(date.getTime() - 60 * 1000 * minute);
        }
        return new Date();
    }

    /**
     * 获取 指定天数 之前/之后的日期
     * @param str 日期字符串
     * @param dateFormat 返回的日期格式
     * @param days 指定天数（1天，2天，3天）
     * @param order 前后（front 前）（after 后）
     * @return
     */
    public static String getToDayByOrder(String str,String dateFormat,Integer days,String order) {
        Calendar c = Calendar.getInstance();
        Date date=new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);

        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(order) && days!=null) {

            int day=c.get(Calendar.DATE);
            //前一天
            if ("front".equals(order)) {
                c.set(Calendar.DATE,day-days);
            }
            //后一天
            if ("after".equals(order))  {
                c.set(Calendar.DATE,day+days);
            }
        }
        return new SimpleDateFormat(dateFormat).format(c.getTime());
    }

    /**
     * 获取 指定分钟 之前/之后的时间
     * @param str 日期字符串
     * @param minutes 指定分钟数（1分钟，2分钟，3分钟）
     * @param order 前后（front 前）（after 后）
     * @return
     */
    public static String getToMinuteByOrder(String str,Integer minutes,String order) {
        Calendar c = Calendar.getInstance();
        Date date=new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);

        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(order) && minutes!=null) {

            int minute=c.get(Calendar.MINUTE);
            //前一天
            if ("front".equals(order)) {
                c.set(Calendar.MINUTE,minute-minutes);
            }
            //后一天
            if ("after".equals(order))  {
                c.set(Calendar.MINUTE,minute+minutes);
            }
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
    }

    /**
     * 日期格式化为字符串
     * @param date 日期
     * @return 日期格式的字符串
     * @author daixu
     * @date 2021-07-28 11:33
     */
    public static String dateFormat(Date date){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 判断是否超过24小时
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return （true 不超过 24 小时）（false 超过24小时）
     * @throws Exception
     * @author daixu
     * @date 2021-08-03 14:58
     */
    public static boolean jisuan(String startDate, String endDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        Date start = sdf.parse(startDate);
        Date end = sdf.parse(endDate);
        long cha = end.getTime() - start.getTime();
        double result = cha * 1.0 / (1000 * 60 * 60);
        if(result<=24){
            return true;
        }
        return false;
    }

    /**
     * 校验2个日期之间的间隔天数
     * @param date1 开始日期
     * @param date2 结束日期
     * @return 间隔天数
     */
    public static int daysBetween(Date date1,Date date2){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
}
