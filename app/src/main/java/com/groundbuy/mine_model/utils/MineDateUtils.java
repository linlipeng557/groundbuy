package com.groundbuy.mine_model.utils;

/**
 * @Author PoQiao
 * 邮箱：116
 * 创建时间： 2019/9/19
 */

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: ade
 * @date: 2017-09-20
 */

public class MineDateUtils {

    // ==格式到年==
    /**
     * 日期格式，年份，例如：2004，2008
     */
    public static final String DATE_FORMAT_YYYY = "yyyy";


    // ==格式到年月 ==
    /**
     * 日期格式，年份和月份，例如：200707，200808
     */
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";

    /**
     * 日期格式，年份和月份，例如：200707，2008-08
     */
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";


    // ==格式到年月日==
    /**
     * 日期格式，年月日，例如：050630，080808
     */
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：06-12-25，08-08-08
     */
    public static final String DATE_FORMAT_YY_MM_DD = "yy-MM-dd";

    /**
     * 日期格式，年月日，例如：20050630，20080808
     */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
     */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期格式，年月日，例如：2016.10.05
     */
    public static final String DATE_FORMAT_POINTYYYYMMDD = "yyyy.MM.dd";

    /**
     * 日期格式，年月日，例如：2016年10月05日
     */
    public static final String DATE_TIME_FORMAT_YYYY年MM月DD日 = "yyyy年MM月dd日";


    // ==格式到年月日 时分 ==

    /**
     * 日期格式，年月日时分，例如：200506301210，200808081210
     */
    public static final String DATE_FORMAT_YYYYMMDDHHmm = "yyyyMMddHHmm";

    /**
     * 日期格式，年月日时分，例如：20001230 12:00，20080808 20:08
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";
    public static final String DATE_TIME_FORMAT_YYYYMMDD_HH_MI_2 = "yyyy/MM/dd HH:mm";

    /**
     * 日期格式，年月日时分，例如：2000-12-30 12:00，2008-08-08 20:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";


    // ==格式到年月日 时分秒==
    /**
     * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";

    /**
     * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开
     * 例如：2005-05-10 23：20：00，2008-08-08 20:08:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";


    // ==格式到年月日 时分秒 毫秒==
    /**
     * 日期格式，年月日时分秒毫秒，例如：20001230120000123，20080808200808456
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";


    // ==特殊格式==
    /**
     * 日期格式，月日时分，例如：10-05 12:00
     */
    public static final String DATE_FORMAT_MMDDHHMI = "MM-dd HH:mm";


    /**
     * 格式化日期为yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String formateDate(Date date) {
        return dateToString(date, DATE_FORMAT_YYYY_MM_DD);
    }

    /**
     * 格式化日期为yyyy-MM
     *
     * @param date
     * @return
     */
    public static String formateYearAndMonth(Date date) {
        return dateToString(date, DATE_FORMAT_YYYY_MM);
    }

    /**
     * 取当天日期
     *
     * @param
     * @return
     */
    public static Date getDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 取指定年月日的日期,格式为yyyy-MM-dd,HH-mm-ss 00-00-00
     *
     * @param
     * @return
     */
    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        return cal.getTime();

    }

    /**
     * 获取当前北京时间
     *
     * @return
     */
    public static Date getBeiJinDate() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        TimeZone defaultZone = TimeZone.getDefault();
        Date date = new Date();
        return changeTimeZone(date, defaultZone, timeZone);
    }

    /**
     * 获取更改时区后的日期
     *
     * @param date    日期
     * @param oldZone 旧时区对象
     * @param newZone 新时区对象
     * @return 日期
     */
    public static Date changeTimeZone(Date date, TimeZone oldZone, TimeZone newZone) {
        Date dateTmp = null;
        if (date != null) {
            int timeOffset = oldZone.getRawOffset() - newZone.getRawOffset();

            dateTmp = new Date(date.getTime() - timeOffset);
        }

        return dateTmp;
    }


    /**
     * 取指定年,月,日,小时,分,秒的时间
     *
     * @param
     * @return
     */
    public static Date getDate(int year, int month, int date, int hour, int mintue, int second) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, date);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, mintue);
        cal.set(Calendar.SECOND, second);
        return cal.getTime();
    }


    /**
     * @param days=n n为-,则取n天前,n为+,则取n天后的日期
     * @param date
     * @param days
     * @return
     */
    public static Date getSomeDaysBeforeAfter(Date date, int days) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.DAY_OF_MONTH, days);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
        return gc.getTime();
    }

    /**
     * @param months=n n为-,则取n月前,n为+,则取n月后的日期
     * @param date
     * @return Date
     */
    public static Date getSomeDaysBeforeAfterByMonth(Date date, int months) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.MONTH, months);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
        return gc.getTime();
    }

    /**
     * 取指定日期年份
     *
     * @param
     * @return
     */
    public static int getDateYear(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    /**
     * 取指定日期月份
     *
     * @param
     * @return
     */
    public static int getDateMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 取指定日期日份
     *
     * @param
     * @return
     */
    public static int getDateDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DATE);
    }

    /**
     * 取指定日期小时
     *
     * @param
     * @return
     */
    public static int getDateHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 取指定日期分钟
     *
     * @param
     * @return
     */
    public static int getDateMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 取指定日期的第二天的开始时间,小时,分,秒为00:00:00
     *
     * @param
     * @return
     */
    public static Date getNextDayStartTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return getNextDayStart(c.get(Calendar.YEAR),
                c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
    }


    /**
     * 取指定年,月,日的下一日的开始时间,小时,分,秒为00:00:00
     * 主要是用来取跨月份的日期
     *
     * @param
     * @param
     * @return
     */
    public static Date getNextDayStart(int year, int monthIn, int date) {
        int month = monthIn - 1;
        boolean lastDayOfMonth = false;
        boolean lastDayOfYear = false;

        Calendar time = Calendar.getInstance();
        time.set(year, month, date, 0, 0, 0);
        Calendar nextMonthFirstDay = Calendar.getInstance();
        nextMonthFirstDay.set(year, month + 1, 1, 0, 0, 0);

        if (time.get(Calendar.DAY_OF_YEAR) + 1 == nextMonthFirstDay.get(Calendar.DAY_OF_YEAR))
            lastDayOfMonth = true;

        if (time.get(Calendar.DAY_OF_YEAR) == time.getMaximum(Calendar.DATE))
            lastDayOfYear = true;

        time.roll(Calendar.DATE, 1);

        if (lastDayOfMonth)
            time.roll(Calendar.MONTH, 1);

        if (lastDayOfYear)
            time.roll(Calendar.YEAR, 1);


        return time.getTime();
    }

    /**
     * 取指定日期的下一日的时间
     *
     * @param
     * @return
     */
    public static Date nextDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    /**
     * 取指定日期的下一月的时间
     *
     * @param
     * @return
     */
    public static Date nextMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return cal.getTime();
    }

    /**
     * 指定日期的下一日的开始时间,小时,分,秒为00:00:00
     *
     * @param
     * @return
     */
    public static Date getStartDateNext(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定日期的开始时间,小时,分,秒为00:00:00
     *
     * @param
     * @return
     */
    public static Date getStartDateDay(Date date) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定日期的结束时间,小时,分,秒为23:59:59
     *
     * @param
     * @return
     */
    public static Date getEndDateDay(Date date) {
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 将指定日期,以指定pattern格式,输出String值
     *
     * @param
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.format(date);
        }
    }

    /**
     * 将指定日期,以指定pattern格式,输出String值
     *
     * @param
     * @return
     */
    public static String dateToString(Date date, String pattern, Locale locale) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
            return format.format(date);
        }
    }

    public static String dateToString1(Date date, String formatIn) {
        String format = formatIn;
        if (date == null) {
            return "";
        }
        if (format == null) {
            format = DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    /**
     * 将指定年,月,日的日期转为字符型,格式为yyyy-MM-dd
     *
     * @param
     * @return
     */
    public static String dateToString(int year, int month, int day, String pattern) {
        return dateToString(getDate(year, month, day), pattern);
    }


    /**
     * 将指定字符型日期转为日期型,,格式为指定的pattern
     *
     * @param
     * @return
     */
    public static Date stringToDate(String string, String pattern) {
        SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance();
        format.applyPattern(pattern);
        try {
            return format.parse(string);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将指定字符型日期转为日期型,指定格式为yyyy-MM-dd
     *
     * @param
     * @return
     */
    public static Date stringToDate(String strTime) {
        if (strTime == null || strTime.trim().length() <= 0)
            return null;
        if (strTime == null || strTime.trim().length() <= 0)
            return null;

        Date date = null;
        List<String> list = new ArrayList<String>(0);

        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS);
        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);
        list.add(DATE_TIME_FORMAT_YYYYMMDD_HH_MI);
        list.add(DATE_TIME_FORMAT_YYYYMMDD_HH_MI_2);
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISS);
        list.add(DATE_FORMAT_YYYY_MM_DD);
        //list.add(DATE_FORMAT_YY_MM_DD);
        list.add(DATE_FORMAT_YYYYMMDD);
        list.add(DATE_FORMAT_YYYY_MM);
        list.add(DATE_FORMAT_YYYYMM);
        list.add(DATE_FORMAT_YYYY);


        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            String format = (String) iter.next();
            if (strTime.indexOf("-") > 0 && format.indexOf("-") < 0)
                continue;
            if (strTime.indexOf("-") < 0 && format.indexOf("-") > 0)
                continue;
            if (strTime.length() > format.length())
                continue;
            date = stringToDate(strTime, format);
            if (date != null)
                break;
        }

        return date;
    }

    /**
     * 获得两个日期之间间隔的天数
     *
     * @param startDate 起始年月日
     * @param endDate   结束年月日
     * @return int
     */
    public static int getDays(Date startDate, Date endDate) {
        int elapsed = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        Date d1 = cal.getTime();

        cal.setTime(endDate);
        Date d2 = cal.getTime();

        long daterange = d2.getTime() - d1.getTime();
        long time = 1000 * 3600 * 24; //一天的毫秒数
        elapsed = (int) (daterange / time);
        return elapsed;
    }

    /**
     * @param date
     * @param startTimeIn 格式为0800，表示上午8点00分
     * @param endTimeIn   格式为2200
     * @return
     */
    public static boolean isWorkHour(Date date, String startTimeIn, String endTimeIn) {//是否是工作时间
        String startTime = startTimeIn;
        String endTime = endTimeIn;
        if (TextUtils.isEmpty(startTime))
            startTime = "0800";
        if (TextUtils.isEmpty(endTime))
            endTime = "2200";
        int start = Integer.parseInt(startTime);
        int end = Integer.parseInt(endTime);
        int hour = getDateHour(date);
        int m = getDateMinute(date);
        String hstr = hour <= 9 ? "0" + hour : hour + "";
        String mstr = m <= 9 ? "0" + m : m + "";
        int dateInt = Integer.parseInt(hstr + mstr);
        if (dateInt >= start && dateInt <= end) {
            return true;
        }
        return false;
    }

    /**
     * 根据传入日期，返回此月有多少天
     *
     * @param date 格式为  201408
     * @return
     */
    public static int getDayOfMonth(String date) {
        int year = Integer.parseInt(date.substring(0, 3));
        int month = Integer.parseInt(date.substring(date.length() - 1, date.length()));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);//Java月份才0开始算  6代表上一个月7月
        int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
        return dateOfMonth;
    }

    /**
     * 取指定日期月份前一月
     *
     * @param
     * @return
     */
    public static int getLastDateMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH);
    }

    //取日期的当前月第一天
    public static Date getMonthFirstDay(Date date) {
        return getDate(getDateYear(date), getDateMonth(date), 1);
    }

    //前月第一天
    public static Date getLastDateMonthDay(Date date) {
        return getDate(getDateYear(date), getLastDateMonth(date), 1);
    }


    /**
     * 获取指定日期是星期几
     * 参数为null时表示获取当前日期是星期几
     *
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekOfDays = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }

    /**
     * 获取指定日期是星期几
     * 参数为null时表示获取当前日期是星期几
     *
     * @param date
     * @return 0 是周日
     */
    public static int getWeekOfDateInt(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return w;
    }


    public static boolean isToday(Long time) {

        Date date = new Date(time);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH) + 1;
        int day1 = c1.get(Calendar.DAY_OF_MONTH);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH) + 1;
        int day2 = c2.get(Calendar.DAY_OF_MONTH);

        if (year1 == year2 && month1 == month2 && day1 == day2) {
            return true;
        }
        return false;
    }

    /**
     * 判断二个时间是否为同年同月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Boolean compareIsSameMonth(Date date1, Date date2) {
        boolean flag = false;
        int year1 = getYear(date1);
        int year2 = getYear(date2);
        if (year1 == year2) {
            int month1 = getMonth(date1);
            int month2 = getMonth(date2);
            if (month1 == month2) flag = true;
        }
        return flag;
    }

    /**
     * 获取某日期的年份
     *
     * @param date
     * @return
     */
    public static Integer getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取某日期的月份
     *
     * @param date
     * @return
     */
    public static Integer getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取某日期的日数
     *
     * @param date
     * @return
     */
    public static Integer getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);//获取日
        return day;
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }
    //获得相隔时间
    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return (day * 24 + hour) + "时" + min + "分";
    }

    public static String getDatePoor2(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        String str = "";
        if (day >= 1) {
            str += day + "d";
        }
        if (hour >= 1 || !TextUtils.isEmpty(str)) {
            str += hour + "h";
        }

        if (min >= 1 || !TextUtils.isEmpty(str)) {
            str += min + "min";
        }

        return str;
    }

    /**
     * 比较两个日期的大小，日期格式为yyyy-MM-dd
     *
     * @param str1 the first date
     * @param str2 the second date
     * @return true <br/>false
     */
    public static int isDateOneBigger(String str1, String str2) {
        int type = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = sdf.parse(str1);
            dt2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dt1.getTime() > dt2.getTime()) {
            type = 2;
        } else if (dt1.getTime() < dt2.getTime()) {
            type = 1;
        } else {
            type = 0;
        }
        return type;
    }


    /**
     * java 获取 获取某年某月 所有日期（yyyy-mm-dd格式字符串）
     *
     * @param year
     * @param month
     * @return
     */
    public static List<Date> getMonthFullDay(int year, int month) {
        List<Date> fullDayList = new ArrayList<>(32);
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        // 当月1号
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 1; j <= count; j++) {
            fullDayList.add(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return fullDayList;
    }

    public static String stringToString(String dateStr, String pattern) {
        if (TextUtils.isEmpty(dateStr)) {
            return "";
        }
        Date date = stringToDate(dateStr);
        if (date == null) {
            return "";
        }
        return dateToString(date, pattern);
    }

    /**
     * 比较两个Date大小
     */
    public static boolean isDate(Date startTime, Date endTiem) {
        String start = dateToString(startTime, DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);
        String end = dateToString(endTiem, DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);
        int value = isDateYMDHM(start, end);
        if (value == 1 || value == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 比较两个日期的大小，日期格式为yyyy-MM-dd HH:mm
     *
     * @param str1 the first date
     * @param str2 the second date
     * @return true <br/>false
     */
    public static int isDateYMDHM(String str1, String str2) {
        int type = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = sdf.parse(str1);
            dt2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dt1.getTime() > dt2.getTime()) {
            type = 2;
        } else if (dt1.getTime() < dt2.getTime()) {
            type = 1;
        } else {
            type = 0;
        }
        return type;
    }

    /**
     * 判断两个日期是否同一周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeek(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar dateCal1 = Calendar.getInstance();
        Calendar dateCal2 = Calendar.getInstance();
        dateCal1.setTime(date1);
        dateCal2.setTime(date2);
        if (dateCal2.get(Calendar.YEAR) == dateCal1.get(Calendar.YEAR)
                && dateCal2.get(Calendar.WEEK_OF_YEAR) == dateCal1.get(Calendar.WEEK_OF_YEAR)) {
            return true;
        } else {
            return false;
        }
    }
}