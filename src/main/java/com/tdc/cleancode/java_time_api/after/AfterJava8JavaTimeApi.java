package com.tdc.cleancode.java_time_api.after;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class AfterJava8JavaTimeApi {

    public ZonedDateTime getCurretTime(){
        return ZonedDateTime.now();
    }

    public LocalDate getSpecificDate(int year, int month, int day){
        return LocalDate.of(year, month, day);
    }

    public Month getMonth(){
        return LocalDateTime.now().getMonth();
    }

    public LocalDateTime subtractHours(int valueToSubtract){
        return LocalDateTime.now().minusHours(valueToSubtract);
    }

    public LocalTime truncatedTo(){
        return LocalTime.now().truncatedTo(ChronoUnit.HOURS);
    }

    public Duration spanBetweenTimes(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime hourLater = LocalDateTime.now().plusHours(5);
        return Duration.between(now, hourLater);
    }

    //ChronoUnit.DAYS.between(Instant.ofEpochMilli(getRegistrationDate()), Instant.now());

    public int numberOfDaysInAMonth(int year, int month){
        return YearMonth.of(year, month).lengthOfMonth();
    }

    public static void main(String[] args) {
        AfterJava8JavaTimeApi afterJava8JavaTimeApi = new AfterJava8JavaTimeApi();
        System.out.println("Current Time: " + afterJava8JavaTimeApi.getCurretTime());
        System.out.println("Get Specific Time, Roan's Birthday: "
                + afterJava8JavaTimeApi.getSpecificDate(1985, 8, 19));
        System.out.println("Get Month: " + afterJava8JavaTimeApi.getMonth());
        System.out.println("Subtracting Hours: " + afterJava8JavaTimeApi.subtractHours(10));
        System.out.println("Hours Truncated: "+ afterJava8JavaTimeApi.truncatedTo());
        System.out.println("Span Between Times: "+ afterJava8JavaTimeApi.spanBetweenTimes());
        System.out.println("Number Of Days In a Month: "+afterJava8JavaTimeApi.numberOfDaysInAMonth(2020, 2));
    }
}
