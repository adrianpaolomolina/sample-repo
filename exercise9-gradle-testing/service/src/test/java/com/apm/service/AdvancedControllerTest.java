package com.apm.service;

import org.junit.Test;
import org.junit.BeforeClass;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.apm.model.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class AdvancedControllerTest
{

    private AdvancedController advancedController = new AdvancedController();

    @Test
    public void testCountRow(){
      int row = 3;
      assertEquals(row, advancedController.countRow("testText.txt"));
      System.out.println("Successful Test! Count Row Returned 3");
    }

    @Test
    public void testCountColumn(){
      ArrayList<Integer> column = new ArrayList<Integer>();
      column.add(3);
      column.add(3);
      column.add(3);
      assertTrue(column.equals(advancedController.countColumn("testText.txt")));
      System.out.println("Successful Test! Count Column Returned 3");
    }

    @Test
    public void testRowGenerateDefaultContent_rowsGenerated(){
      //Default table should contain 3 rows and 3 columns.
      int row = 3;
      advancedController.generateDefaultContent();
      assertEquals(row, advancedController.advancedModel.getKeyListSize());
      System.out.println("Successful Test! Rows Generated are Three");
    }

    @Test
    public void testColumnGenerateDefaultContent_columnsGenerated(){
      int column = 3;
      advancedController.generateDefaultContent();
      assertEquals(column, advancedController.advancedModel.getValueListSize());
      System.out.println("Successful Test! Columns generated are Three");
    }

    @Test
    public void testAssignNewString(){
      //Method should combine the contents of the array in the proper format.
      advancedController.generateDefaultContent();
      StringBuilder builder = new StringBuilder("");
      String content = "d , d | d , d | d , d | \n"
                      + "d , d | d , d | d , d | \n"
                      + "d , d | d , d | d , d | \n";
      assertEquals(content, advancedController.assignNewString(builder));
      System.out.println("Successful Test! Method Correctly Combines Array Into Proper Format!");
    }

    @Test
    public void testGenerateNewFile() throws IOException {
      String file = "testText.txt";
      try {
        assertEquals(file, advancedController.generateNewFile("testText.txt"));
        System.out.println("Successful Test! Method returns the input file name correctly.");
      } catch ( IOException e ){
        System.out.println("Error Thrown!");
      }
    }

    @Test
    public void testSearchResult(){
      int rowIncrement = 0;
      int columnIncrement = 0;
      int totalCount = 2;
      int count = 2;
      String searchCharacter = "BB";
      advancedController.retrieveFile("testText2.txt");
      String searchMessage = "Character Found in: [ " + rowIncrement + "," + columnIncrement + "]\n"
      + "Number of Occurences: " + count + "\nTotal Findings: " + totalCount;
      assertEquals(searchMessage, advancedController.searchResult(searchCharacter));
      System.out.println("Successful Test! Correct Search Count - BB is found two times in testText2.txt");
    }

    @Test
    public void testSortArray_sortKey(){
      advancedController.retrieveFile("testText3.txt");
      advancedController.sortArray();
      ArrayList<ArrayList<String>> sortedKey = new ArrayList<ArrayList<String>>();
      sortedKey.add(new ArrayList<String>());
      sortedKey.add(new ArrayList<String>());
      sortedKey.add(new ArrayList<String>());
      sortedKey.get(0).add("AAA");
      sortedKey.get(0).add("CCC");
      sortedKey.get(0).add("EEE");
      sortedKey.get(1).add("GGG");
      sortedKey.get(1).add("III");
      sortedKey.get(1).add("KKK");
      sortedKey.get(2).add("MMM");
      sortedKey.get(2).add("OOO");
      sortedKey.get(2).add("QQQ");
      assertTrue(sortedKey.equals(advancedController.getKeyList()));
      System.out.println("Successful Test! Correct Key Sort Result...");
    }

    @Test
    public void testSortArray_sortValue(){
      advancedController.retrieveFile("testText3.txt");
      advancedController.sortArray();
      ArrayList<ArrayList<String>> sortedValue = new ArrayList<ArrayList<String>>();
      sortedValue.add(new ArrayList<String>());
      sortedValue.add(new ArrayList<String>());
      sortedValue.add(new ArrayList<String>());
      sortedValue.get(0).add("BBB");
      sortedValue.get(0).add("DDD");
      sortedValue.get(0).add("FFF");
      sortedValue.get(1).add("HHH");
      sortedValue.get(1).add("JJJ");
      sortedValue.get(1).add("LLL");
      sortedValue.get(2).add("NNN");
      sortedValue.get(2).add("PPP");
      sortedValue.get(2).add("RRR");
      assertTrue(sortedValue.equals(advancedController.getValueList()));
      System.out.println("Successful Test! Correct Value Sort Result...");
    }

}
