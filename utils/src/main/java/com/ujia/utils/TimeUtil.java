package com.ujia.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";

    public static String formatTime(Long timeStamp, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date(timeStamp);
        return simpleDateFormat.format(date);
    }

    /**
     * 转化时间为 刚刚  一分钟之前
     *
     * @param timeStamp
     * @return
     */
    public static String formatTimeAgo(Long timeStamp) {
        return formatTimeAgo(timeStamp, FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    public static String formatTimeAgo(Long timeStamp, String format) {
        Date date = new Date();
        long currentTimeStamp = date.getTime();
        long nowSec = currentTimeStamp / 1000;
        long timeSec = timeStamp / 1000;
        long seconds = nowSec - timeSec;
        if (seconds < 60) {
            return "刚刚";
        } else if (seconds < 3600) {
            long mins = seconds / 60;
            return mins + "分钟前";
        } else if (seconds < 3600 * 24) {
            long hours = seconds / 3600;
            return hours + "小时前";
        } else if (seconds < 3600 * 48) {
            return "昨天";
        } else {
            return formatTime(timeStamp, format);
        }
    }

}
