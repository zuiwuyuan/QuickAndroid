package com.lnyp.quickandroid.util;

import android.text.TextUtils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 日期时间工具类
 * <p/>
 * 主要用于：
 * 1. 格式化日期时间输出
 * 2. 获取日期时间对象
 * <p/>
 * 注： 关于日期时间的计算，具体参照文档资料
 */
public class DateUtil {

    private static final String DATE_TIME_PATTERN1 = "yyyy-MM-dd HH:mm:ss";

    private static final String DATE_TIME_PATTERN2 = "yyyy-MM-dd HH:mm";


    private static DateTimeFormatter dateTimeFormatter1 = DateTimeFormat.forPattern(DATE_TIME_PATTERN1);

    private static DateTimeFormatter dateTimeFormatter2 = DateTimeFormat.forPattern(DATE_TIME_PATTERN2);

    /**
     * 获取当前时间的DateTime对象
     *
     * @return
     */
    public static DateTime getCurrentDateTime() {

        DateTime dateTime = new DateTime(System.currentTimeMillis());

        return dateTime;
    }

    /**
     * 获取Date : yyyy-MM-dd HH:mm:ss
     *
     * @param datetime
     * @return
     */
    public static Date parseDateTime1(String datetime) {

        if (TextUtils.isEmpty(datetime)) {

            return null;
        }

        DateTime dateTime = null;

        try {
            dateTime = DateTime.parse(datetime, dateTimeFormatter1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (dateTime != null) {
            return dateTime.toDate();
        }

        return null;

    }

    /**
     * 获取Date : yyyy-MM-dd HH:mm
     *
     * @param datetime
     * @return
     */
    public static Date parseDateTime2(String datetime) {

        if (TextUtils.isEmpty(datetime)) {

            return null;
        }

        DateTime dateTime = null;

        try {
            dateTime = DateTime.parse(datetime, dateTimeFormatter2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (dateTime != null) {
            return dateTime.toDate();
        }

        return null;
    }

    /**
     * 格式化输出日期: 2016-1-16 13:04:11
     *
     * @param date
     * @return
     */
    public static String formatDateTime1(Date date) {

        if (date == null) {
            return null;
        }

        DateTime dateTime = new DateTime(date);

        return dateTime.toString(DATE_TIME_PATTERN1);
    }

    /**
     * 格式化输出日期: 2016-1-16 13:04:11
     *
     * @param instant
     * @return
     */
    public static String formatDateTime1(long instant) {

        DateTime dateTime = new DateTime(instant);

        return dateTime.toString(DATE_TIME_PATTERN1);
    }

    /**
     * 格式化输出日期: 2016-1-16 13:04
     *
     * @param date
     * @return
     */
    public static String formatDateTime2(Date date) {

        if (date == null) {
            return null;
        }

        DateTime dateTime = new DateTime(date);

        return dateTime.toString(DATE_TIME_PATTERN2);
    }

    /**
     * 格式化输出日期: 2016-1-16 13:04:11
     *
     * @param instant
     * @return
     */
    public static String formatDateTime2(long instant) {

        DateTime dateTime = new DateTime(instant);

        return dateTime.toString(DATE_TIME_PATTERN2);
    }

}
