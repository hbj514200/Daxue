package com.qq.qzone.a133689237.daxue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUntil {

    private Calendar calendar;

    public TimeUntil(){
        calendar = Calendar.getInstance();
    }

    public int year(){
        return calendar.get(Calendar.YEAR);
    }

    public int month(){
        return (calendar.get(Calendar.MONTH)+1);
    }

    public int day(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int hour(){
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public int minute(){
        updata();
        return calendar.get(Calendar.MINUTE);
    }

    public int second(){
        updata();
        return calendar.get(Calendar.SECOND);
    }

    public String qujian(){
        int hour = hour();
        if( hour<8)                return "早上";
        if( hour>=8&&hour<12)     return "上午";
        if( hour>=12&&hour<14)     return "中午";
        if( hour>=14&&hour<17)     return "下午";
        if( hour>=17&&hour<19)     return "傍晚";
        if(hour>=19)               return "晚上";
        return "";
    }

    public void updata(){
        calendar = Calendar.getInstance();
    }

    public static long timecha(int daji, Date datenow){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df.parse("2016-09_12 8:00:00");
            if(daji==1)             d1 = df.parse("2016-09_12 8:00:00");
            if(daji==2)             d1 = df.parse("2015-09-12 8:00:00");
            if(daji==3)             d1 = df.parse("2014-09-12 8:00:00");
            if(daji==4)             d1 = df.parse("2013-09-12 8:00:00");
            long diff = datenow.getTime() - d1.getTime();//这样得到的差值是微秒级别
            //long days = diff / (1000 * 60 * 60 * 24);
            //long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            //long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            return diff;
        }
        catch (Exception e) {}
        return 0;
    }

}
