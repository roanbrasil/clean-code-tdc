package com.tdc.cleancode.java_time_api.before;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BeforeJava8JavaTimeApi {

    public Date getCurrentDateTime(){
        return new Date();
    }

    public Date getSpecificDate(int year, int month, int day){
        return new GregorianCalendar(year, month, day).getTime();
    }

    public int getMonth(){
        return new GregorianCalendar().get(Calendar.MONTH);
    }

    public Date subtractHours(int valueToSubtract){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR_OF_DAY, valueToSubtract * -1);
        return calendar.getTime();
    }

    public Date truncatedTo(){
        Calendar now = Calendar.getInstance();
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        return now.getTime();
    }

    public long spanBetweenTimes(){
        GregorianCalendar calendar = new GregorianCalendar();
        Date now = new Date();
        calendar.add(Calendar.HOUR, 5);
        Date hourLater = calendar.getTime();
        return hourLater.getTime() - now.getTime();
    }

    public static void main(String[] args) {
        BeforeJava8JavaTimeApi beforeJava8JavaTimeApi = new BeforeJava8JavaTimeApi();
        System.out.println("Current Time: " + beforeJava8JavaTimeApi.getCurrentDateTime());
        System.out.println("Get Specific Time, Roan's Birthday: "
                + beforeJava8JavaTimeApi.getSpecificDate(1985, 7, 19));
        System.out.println("Get Month: " + beforeJava8JavaTimeApi.getMonth());
        System.out.println("Subtracting Hours: " + beforeJava8JavaTimeApi.subtractHours(10));
        System.out.println("Hours Truncated: "+ beforeJava8JavaTimeApi.truncatedTo());
        System.out.println("Span Between Times: "+ beforeJava8JavaTimeApi.spanBetweenTimes());
    }
}
