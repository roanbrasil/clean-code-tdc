package com.tdc.cleancode.type_inference;

import java.time.LocalDate;
import java.time.LocalTime;

public class Compromise {

  private LocalTime time;

  private LocalDate date;

  private String comments;

  private Compromise(LocalTime time, LocalDate date, String comments) {
    this.time = time;
    this.date = date;
    this.comments = comments;
  }

  public static Compromise create(LocalTime time, LocalDate date, String comments){
    return new Compromise( time, date, comments);
  }

  public LocalTime getTime() {
    return time;
  }

  public LocalDate getDate() {
    return date;
  }
}
