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
