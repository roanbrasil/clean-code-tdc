package com.tdc.cleancode.records.before;

import java.time.LocalDate;
import java.util.Objects;

public class PersonDto {

  private String name;

  private int document;

  private String email;

  private Adress adress;

  private String phone;

  private LocalDate dateOfBirth;

  public PersonDto(String name, int document, String email,
                   Adress adress, String phone, LocalDate dateOfBirth) {
    this.name = name;
    this.document = document;
    this.email = email;
    this.adress = adress;
    this.phone = phone;
    this.dateOfBirth = dateOfBirth;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDocument() {
    return document;
  }

  public void setDocument(int document) {
    this.document = document;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Adress getAdress() {
    return adress;
  }

  public void setAdress(Adress adress) {
    this.adress = adress;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PersonDto)) {
      return false;
    }
    PersonDto personDto = (PersonDto) o;
    return getDocument() == personDto.getDocument() &&
        getName().equals(personDto.getName()) &&
        getEmail().equals(personDto.getEmail()) &&
        Objects.equals(getAdress(), personDto.getAdress()) &&
        Objects.equals(getPhone(), personDto.getPhone()) &&
        Objects.equals(getDateOfBirth(), personDto.getDateOfBirth());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getName(), getDocument(), getEmail(), getAdress(), getPhone(), getDateOfBirth());
  }

  @Override
  public String toString() {
    return "PersonDto{" +
        "name='" + name + '\'' +
        ", document=" + document +
        ", email='" + email + '\'' +
        ", adress=" + adress +
        ", phone='" + phone + '\'' +
        ", dateOfBirth=" + dateOfBirth +
        '}';
  }
}
