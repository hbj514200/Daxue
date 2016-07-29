package com.qq.qzone.a133689237.daxue;

import java.util.Calendar;

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
        return calendar.get(Calendar.MINUTE);
    }

    public int second(){
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

}
