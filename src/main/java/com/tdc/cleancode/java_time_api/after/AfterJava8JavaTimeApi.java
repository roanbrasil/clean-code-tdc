package com.tdc.cleancode.java_time_api.after;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.WeekFields;

public class AfterJava8JavaTimeApi {

  public static final int ONE_MONTH_TO_ADD = 1;

  public ZonedDateTime getCurretTime() {
    return ZonedDateTime.now();
  }

  public LocalDate getSpecificDate(int year, int month, int day) {
    return LocalDate.of(year, month, day);
  }

  public Month getMonth() {
    return LocalDateTime.now().getMonth();
  }

  public LocalDateTime subtractHours(int valueToSubtract) {
    return LocalDateTime.now().minusHours(valueToSubtract);
  }

  public LocalTime truncatedTo() {
    return LocalTime.now().truncatedTo(ChronoUnit.HOURS);
  }

  public Duration spanBetweenTimes() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime hourLater = LocalDateTime.now().plusHours(5);
    return Duration.between(now, hourLater);
  }

  //ChronoUnit.DAYS.between(Instant.ofEpochMilli(getRegistrationDate()), Instant.now());

  public int numberOfDaysInAMonth(int year, int month) {
    return YearMonth.of(year, month).lengthOfMonth();
  }

  public static void main(String[] args) {
    AfterJava8JavaTimeApi afterJava8JavaTimeApi = new AfterJava8JavaTimeApi();
    System.out.println("Current Time: " + afterJava8JavaTimeApi.getCurretTime());
    System.out.println("Get Specific Time, Roan's Birthday: "
        + afterJava8JavaTimeApi.getSpecificDate(1985, 8, 19));
    System.out.println("Get Month: " + afterJava8JavaTimeApi.getMonth());
    System.out.println("Subtracting Hours: " + afterJava8JavaTimeApi.subtractHours(10));
    System.out.println("Hours Truncated: " + afterJava8JavaTimeApi.truncatedTo());
    System.out.println("Span Between Times: " + afterJava8JavaTimeApi.spanBetweenTimes());
    System.out.println(
        "Number Of Days In a Month: " + afterJava8JavaTimeApi.numberOfDaysInAMonth(2020, 2));
  }

  public LocalDate createNextMonthCalendar() {
    return LocalDate.now().plusMonths(ONE_MONTH_TO_ADD);
  }

  public void exampleDatePlus() {

    LocalDate lastYear = LocalDate.now().minusYears(1);
    LocalDate lastWeek = LocalDate.now().minusWeeks(1);
    LocalDateTime nextCompleteDateTime = LocalDateTime.now().plusMinutes(25);
    LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
    LocalDate.now().withYear(1978);
    ZonedDateTime dateWithHourAndTimezone =
        LocalDate.now()
        .atTime(12,0)
        .atZone(ZoneId.of("America/Sao_Paulo"));
  }

  public void exampleTimePlus() {
    LocalTime noon = LocalTime.MIDNIGHT.plusHours(12);
    int hourNow = LocalTime.now().getHour();



  }

  public void exampleEnum(){

    LocalDate myBirthDay = LocalDate.of(1990,12,13);
    int monthEqual = Month.DECEMBER.compareTo(myBirthDay.getMonth());

    DayOfWeek dayMeet = DayOfWeek.FRIDAY.minus(3);
    Instant myMarriage = Instant.ofEpochSecond(1288441849);

    ChronoField.DAY_OF_YEAR.getFrom(myMarriage);

  }

  public void exampleBetween(){
    Instant myMarriage = Instant.ofEpochSecond(1288441849);
    long yearsMarried =ChronoUnit.YEARS.between(myMarriage, Instant.now());
  }


}
