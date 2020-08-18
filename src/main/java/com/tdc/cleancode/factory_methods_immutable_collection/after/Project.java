package com.tdc.cleancode.factory_methods_immutable_collection.after;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Project {

  public List<String> getProjectTypes(){
    return List.of("P", "M", "G");
  }

  public Map<String, String> getProjectTypesDescriptions(){
    return Map.of (
        "P", "Pequeno",
        "M", "Médio",
        "G", "Grande");
  }

  public Set<String> getProjects(){
    return Set.of("Alcatraz","Fijutson","Ternor");
  }
}
