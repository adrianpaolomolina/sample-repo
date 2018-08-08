package com.apm.app;

import java.util.ArrayList;

public class OutputUtilities {

  public static void systemMessageFileNotFoundExit() {
    System.out.println("File not Found");
    System.exit(0);
  }

  public static void systemMessageExit() {
    System.out.println("\nThank you for using the program! ");
    System.exit(0);
  }

  public static void systemMessageSelectionNotValid(){
    System.out.println("Selection not Valid! Input Again!");
  }

  public static void printArrayList ( ArrayList<ArrayList<String>> key,
                                  ArrayList<ArrayList<String>> value ) {
  	System.out.println();
  		for ( int i = 0 ; i < key.size(); i++ ) {
				for ( int j = 0 ; j < key.get(i).size(); j++ ) {
  				System.out.print(key.get(i).get(j) + " , " + value.get(i).get(j) + "  |");
  			}
  				System.out.println();
			}
    System.out.println();
  	}

  public static void systemMessageNewFile(){
    System.out.println("Generate New File...");
    System.out.println("Generating Random Values...");
  }

  public static void printSelectOperation() {
    System.out.print("\n\n==Choose Operation==\n"
          + "1. Search \n"
          + "2. Edit \n"
          + "3. Add Row \n"
          + "4. Print \n"
          + "5. Sort \n"
          + "6. Reset \n"
          + "7. Exit \n"
          + "\nSelect:" );
  }

}
