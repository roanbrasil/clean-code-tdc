package com.tdc.cleancode.interfaces.after;

import com.tdc.cleancode.interfaces.Information;

public interface Step {

  void execute (Information information);

  default String fallback(){
    return "ERRO";
  }

}
