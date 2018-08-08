package com.apm.app;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import com.apm.service.*;

public class AdvancedView {

  private static AdvancedController advancedController = new AdvancedController();
  protected static boolean selectOperation = false;

  public static void startActivity(String[] file) {
    try{
      runActivity(file[0]);
    } catch ( ArrayIndexOutOfBoundsException e){
      try {
        OutputUtilities.systemMessageNewFile();
        runActivity(advancedController.generateNewFile(InputUtilities.getNewFileName()));
      } catch ( IOException ex ){
        System.out.println("Failed to create file");
      }
    }
  }

  public static void runActivity ( String file ) {
    try {
      if(advancedController.getKeyList().isEmpty()) {
        advancedController.retrieveFile(file);
      } printList();
    } catch ( NullPointerException e) {
      OutputUtilities.systemMessageFileNotFoundExit();
    }
  }

  public static void switchOperation(){
    OutputUtilities.printSelectOperation();
    switch(InputUtilities.selectOperation()){
			    		case 1:								//Search
                System.out.println(advancedController.searchResult(
                                  InputUtilities.validateInputCharToSearch(
                                  InputUtilities.inputCharToSearch())));
			    			break;
			    		case 2:								//Edit specific key value
                editOptions();
                advancedController.updateFile();
			    			break;
			    		case 3:								//Add row
                int valuesToAdd = InputUtilities.inputNumberOfValuesToAdd();
                advancedController.addRow( valuesToAdd,
                                          InputUtilities.inputKey(valuesToAdd), InputUtilities.inputValue(valuesToAdd));
                printList();
                advancedController.updateFile();
                break;
			    		case 4:								//Print method
			    			printList();
			    			break;
			    		case 5:								// Sort by Row
                advancedController.sortArray();
                printList();
                advancedController.updateFile();
			    			break;
			    		case 6:								// randomize Reset
                advancedController.randomizeArrayList();
                printList();
			    			break;
			    		case 7:								//Exit method
			           OutputUtilities.systemMessageExit();
			    			break;
			    		default:							//Default message if not within case.
			    			System.out.print("Selection not Valid! Input Again: ");
                printList();
			    	}
  }

  public static void editOptions(){
    boolean editOptionsOperation = true;
    do{
      try{
        switch(InputUtilities.selectOptionEdit()){
          case 1:
            InputUtilities.editKey(advancedController.getKeyList());
            editOptionsOperation = false;
            break;
          case 2:
            InputUtilities.editValue(advancedController.getValueList());
            editOptionsOperation = false;
            break;
          case 3:
            InputUtilities.editBothKeyValue(advancedController.getKeyList(), advancedController.getValueList());
            editOptionsOperation = false;
            break;
          default:
            OutputUtilities.systemMessageSelectionNotValid();
            printList();
        }
      } catch (Exception e) {
        OutputUtilities.systemMessageSelectionNotValid();
        printList();
      }
    } while ( editOptionsOperation == true );
  }

  public static void printList(){
    OutputUtilities.printArrayList(advancedController.getKeyList(),advancedController.getValueList());
  }


}
