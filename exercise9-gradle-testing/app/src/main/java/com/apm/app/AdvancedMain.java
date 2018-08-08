package com.apm.app;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;

public class AdvancedMain {

  public static void runApp(String[] args){
      AdvancedView.startActivity(args);
      AdvancedView.selectOperation = true;
      do {
      AdvancedView.switchOperation();
    } while (AdvancedView.selectOperation == true);
  }

  public static void main( String[]args ) {
    runApp(args);
  }
}
