package com.gxf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日期工具类
 * */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 当前日期 + - days
     * */
    public static Date addDays(int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 档期日期 + - minutes
     * */
    public static Date addMinutes(Date date, int minutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    /**
     * 将日期转换成 指定格式字符串如 yyyyMMddHHmmss
     * */
    public static String getDateStr(Date date, String formmat){
        SimpleDateFormat sdf = new SimpleDateFormat(formmat);
        return sdf.format(date);
    }


    /**
     * 当前时间分钟设置为0或者5
     * ex:10:23 --> 10:20,  10:26 --> 10:25
     * */
    public static Date setDateMinute2ZeroOrFive(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int minute = cal.get(Calendar.MINUTE);
        int remain = minute % 5;
        cal.add(Calendar.MINUTE,  -remain);
        return cal.getTime();
    }

    /**
     * 字符串转date
     * */
    public static Date parseStr2Date(String dateStr, String format){
        Date resDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            resDate = formatter.parse(dateStr);
        } catch (Exception e) {
            logger.error("#DateUtil parseStr2Date dateStr:{}, format:{}", dateStr, format, e);
        }
        return resDate;
    }
}
