package com.tdc.cleancode.collection;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
  public static void main(String[] args) {

    Map<String, String> namesCommunity = new HashMap<>();
    namesCommunity.put("Paula", "Paula Santana");
    namesCommunity.put("Otavio", "Otavio Santana");
    namesCommunity.put("Roan", "Roan Brasil");

    String paula = namesCommunity.getOrDefault("Paula", "Otavio");
    namesCommunity.replaceAll((k, v) -> "SouJava");


  }
}
