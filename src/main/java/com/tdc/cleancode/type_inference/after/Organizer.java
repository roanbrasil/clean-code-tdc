package com.tdc.cleancode.type_inference.after;

import com.tdc.cleancode.type_inference.Compromise;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Organizer {

  public boolean checkTimeAndDateAreAvailable(LocalDate date, LocalTime time, long user) {
    var compromises = getCompromisesOfUser(user);
    boolean available = true;

    for (var compromise: compromises){
      if (compromise.getDate().equals(date) && compromise.getTime().equals(time)) {
        available = false;
        break;
      }
    }

    return available;
  }

  private List<Compromise> getCompromisesOfUser(long user) {
    return List.of(
        Compromise.create(LocalTime.of(10, 20), LocalDate.of(2020, 8, 31), "Dentista"),
        Compromise.create(LocalTime.of(15, 45), LocalDate.of(2020, 8, 31), "Reunião com Fornecedores"),
        Compromise.create(LocalTime.of(16, 30), LocalDate.of(2020, 8, 2),"Entrevista"),
        Compromise.create(LocalTime.of(20, 00), LocalDate.of(2020, 9, 5), "Aniversário Online da Joana"),
        Compromise.create(LocalTime.of(17, 00), LocalDate.of(2020, 9, 7),"Voo para Rio de Janeiro")
    );
  }
}
