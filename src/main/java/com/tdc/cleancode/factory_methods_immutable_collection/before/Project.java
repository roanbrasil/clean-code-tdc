package com.tdc.cleancode.factory_methods_immutable_collection.before;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Project {

  public List<String> getProjectTypes(){
    List <String> types = Arrays.asList("P", "M", "G");
    types = Collections.unmodifiableList (types);
    return types;
  }

  public Map<String, String> getProjectTypesDescriptions(){
    Map<String, String> types = new HashMap<>();
    types.put ("P", "Pequeno");
    types.put ("M", "Médio");
    types.put ("G", "Grande");
    types = Collections.unmodifiableMap (types);

    return types;
  }

  public Set<String> getProjects(){
    Set<String> projects = new HashSet<>();
    projects.add("Alcatraz");
    projects.add("Fijutson");
    projects.add("Ternor");
    projects = Collections.unmodifiableSet(projects);

    return projects;
  }
}
