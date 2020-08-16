package com.tdc.cleancode.records.before;

import java.util.Objects;

public class Adress {

  private String country;

  private String city;

  private String neighborhood;

  private String street;

  private String number;

  private String reference;

  public Adress(String country, String city, String neighborhood, String street,
                String number, String reference) {
    this.country = country;
    this.city = city;
    this.neighborhood = neighborhood;
    this.street = street;
    this.number = number;
    this.reference = reference;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Adress)) {
      return false;
    }
    Adress adress = (Adress) o;
    return getCountry().equals(adress.getCountry()) &&
        getCity().equals(adress.getCity()) &&
        getNeighborhood().equals(adress.getNeighborhood()) &&
        getStreet().equals(adress.getStreet()) &&
        getNumber().equals(adress.getNumber()) &&
        Objects.equals(getReference(), adress.getReference());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getCountry(), getCity(), getNeighborhood(), getStreet(), getNumber(), getReference());
  }

  @Override
  public String toString() {
    return "Adress{" +
        "country='" + country + '\'' +
        ", city='" + city + '\'' +
        ", neighborhood='" + neighborhood + '\'' +
        ", street='" + street + '\'' +
        ", number='" + number + '\'' +
        ", reference='" + reference + '\'' +
        '}';
  }
}
