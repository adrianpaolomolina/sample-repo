package com.apm.app;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.InputMismatchException;

public class InputUtilities {

  private static Scanner scan = new Scanner(System.in);

  public static ArrayList<String> inputKey(int keysToAdd) {
    ArrayList<String> newKey = new ArrayList<String>();
    String key;
    for ( int keys = 0; keys < keysToAdd; keys++){
    System.out.print("Input Key: ");
    key = scan.next();
    newKey.add(key);
    }
    return newKey;
  }

  public static ArrayList<String> inputValue(int valuesToAdd) {
    ArrayList<String> newValue= new ArrayList<String>();
    String value;
    for ( int values = 0 ; values < valuesToAdd ; values++ ){
    System.out.print("Input Value: ");
    value = scan.next();
    newValue.add(value);
    }
    return newValue;
  }

  public static int selectOptionEdit(){
    System.out.println("1. Edit Key?\n"
              + "2. Edit Value?\n"
              + "3. Edit Key AND Value\n"
              + "Select: ");
    return inputSelection();
  }

  public static int inputSelection() {
    boolean isCorrectInput = false;
    int inputSelection = 0;
    do {
      try {
        inputSelection = scan.nextInt();
        isCorrectInput = true;
      } catch (InputMismatchException e){
        System.out.print("Input is not a number. Input Again: ");
        scan.next();
      }
    } while (isCorrectInput == false);
    return inputSelection;
  }

  public static void editKey(ArrayList<ArrayList<String>> key){
    boolean isCorrectInput = false;
    do {
      System.out.print("Input Row: ");
      int rowInput = inputRow();
      boolean rowValid = validateInputRow(rowInput, key);
      if(rowValid){
        do {
          System.out.print("Input Column: ");
          int columnInput = inputColumn();
          boolean columnValid = validateInputColumn(rowInput, columnInput, key);
          if(columnValid){
            System.out.print("New Key: ");
            String newKey = scan.next();
            key.get(rowInput).set(columnInput, newKey);
            isCorrectInput = true;
          }
        } while (isCorrectInput == false);
      }
    } while (isCorrectInput == false);
  }

  public static int inputRow(){
    boolean isCorrectInput = false;
    int rowInput = 0;
    do {
      try {
        rowInput = scan.nextInt();
        isCorrectInput = true;
      } catch (InputMismatchException e){
        System.out.print("Input is not a number. Try Again: ");
        scan.next();
      }
    } while (isCorrectInput == false);
    return rowInput;
  }

  public static int inputColumn(){
    boolean isCorrectInput = false;
    int columnInput = 0;
    do {
      try {
        columnInput = scan.nextInt();
        isCorrectInput = true;
      } catch (InputMismatchException e){
        System.out.print("Input is not a number. Try Again: ");
        scan.next();
      }
    } while (isCorrectInput == false);
    return columnInput;
  }

  public static boolean validateInputRow(int row, ArrayList<ArrayList<String>> key){
      if(row > key.size()-1){
        System.out.println("Input Exceeds Size of Collection");
        return false;
      } else if (row < 0) {
        System.out.println("Input not valid. Try Again!  ");
        return false;
      } else {
        return true;
      }
  }

  public static boolean validateInputColumn(int row, int column, ArrayList<ArrayList<String>> key){
    if(column > key.get(row).size()-1){
      System.out.println("Input Exceeds Size of Collection");
      return false;
    } else if (column < 0) {
      System.out.println("Input not valid. Try Again! ");
      return false;
    } else {
      return true;
    }
  }

  public static void editValue(ArrayList<ArrayList<String>> value){
    boolean isCorrectInput = false;
    do {
      System.out.print("Input Row: ");
      int rowInput = inputRow();
      boolean rowValid = validateInputRow(rowInput, value);
      if(rowValid){
        do {
          System.out.print("Input Column: ");
          int columnInput = inputColumn();
          boolean columnValid = validateInputColumn(rowInput, columnInput, value);
          if(columnValid){
            System.out.print("New Value: ");
            String newValue = scan.next();
            value.get(rowInput).set(columnInput, newValue);
            isCorrectInput = true;
          }
        } while (isCorrectInput == false);
      }
    } while (isCorrectInput == false);
  }

  public static void editBothKeyValue ( ArrayList<ArrayList<String>> key, ArrayList<ArrayList<String>> value ) {
    boolean isCorrectInput = false;
    do {
      System.out.print("Input Row: ");
      int rowInput = inputRow();
      boolean rowValid = validateInputRow(rowInput, key);
      if(rowValid){
        do {
          System.out.print("Input Column: ");
          int columnInput = inputColumn();
          boolean columnValid = validateInputColumn(rowInput, columnInput, key);
          if(columnValid){
            System.out.print("New Key: ");
            String newKey = scan.next();
            System.out.print("New Value: ");
            key.get(rowInput).set(columnInput, newKey);
            String newValue = scan.next();
            value.get(rowInput).set(columnInput, newValue);
            isCorrectInput = true;
          }
        } while (isCorrectInput == false);
      }
    } while (isCorrectInput == false);
  }

  public static String inputCharToSearch() {
    System.out.print("Input characters to Search: ");
    return scan.nextLine();
  }

  public static String validateInputCharToSearch(String inputChar){
    System.out.println(inputChar);
    if(inputChar.isEmpty()){
      return " ";
    } else {
      return inputChar;
    }
  }

  public static int inputNumberOfValuesToAdd() {
    boolean isCorrectInput = false;
    int number = 0;
    System.out.print("Number of Values To Add: ");
    do{
      try {
          number = scan.nextInt();
          if ( number > 0 ) {
            isCorrectInput = true;
          } else {
            System.out.print("Input should be a POSITIVE number: ");
          }
      } catch (InputMismatchException e){
          System.out.print("Input should be a NUMBER: ");
          scan.next();
      }
    } while (isCorrectInput == false);
    return number;
  }

  public static String getNewFileName(){
    String filename="";
    System.out.println("File Does Not Exist. Generate New File?");
    System.out.print("Input Name of File You Want To Create: ");
    filename = scan.next();
    return filename;
  }

  public static int selectOperation(){
    int select = 0;
    boolean isCorrectSelection = false;
      do {
        try{
          select = scan.nextInt();
          isCorrectSelection = true;
        } catch(Exception e){
          System.out.println("Selection Not Valid. Please Input Again.");
          scan.next();
          }
      } while (!isCorrectSelection) ;
    return select;
  }

}
