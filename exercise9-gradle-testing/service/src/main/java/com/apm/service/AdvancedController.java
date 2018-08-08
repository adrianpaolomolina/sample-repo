package com.apm.service;

import java.util.Scanner;
import java.util.ArrayList;
import org.apache.commons.lang3.RandomUtils;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.apm.model.*;

public class AdvancedController {

  AdvancedModel advancedModel = new AdvancedModel();
  private int rowIncrement;
  private int columnIncrement;

  public void retrieveFile( String file ) {
    advancedModel.setFile(new File(file));
    int row = countRow(file);
    advancedModel.setFileScan(file);
    Scanner scan;
  	scan = advancedModel.getFileScan().useDelimiter("\\s+[\\|]\\s+");
  	for( rowIncrement = 0 ; rowIncrement < row; rowIncrement++){
      generateRow();
      ArrayList<Integer> column = new ArrayList<Integer>();
      column.addAll(countColumn(file));
  		for( columnIncrement = 0; columnIncrement < column.get(rowIncrement); columnIncrement++){
  			if(scan.hasNext()){
  			  String str = scan.next();
  			  String[] split=str.split(" , ");
  				advancedModel.addKeyColumnVal( rowIncrement, split[0]);
          advancedModel.addValueColumnVal( rowIncrement, split[1]);
  			}
  		}
  	}
  }

  public int countRow(String file){
      int count = 0;
      advancedModel.setFileScan(file);
      while(advancedModel.getFileScan().hasNextLine()){
        advancedModel.getFileScan().nextLine();
        count++;
      }
      return count;
	}

  public ArrayList<Integer> countColumn(String file){
      ArrayList<Integer> countColumn = new ArrayList<Integer>();
      advancedModel.setFileScan(file);
      while(advancedModel.getFileScan().hasNextLine()){
        int count = 0;
        String row = advancedModel.getFileScan().nextLine();
        String[] splitRow = row.split("(\\s+)(\\,)(\\s+)|(\\s+)(\\|)(\\s+)|(\\|)");
  			for(String s: splitRow){
  			count++;
  			}
        countColumn.add(count/2);
      }
      return countColumn;
	}

  public void generateRow() {
    advancedModel.addKeyString(new ArrayList<String>());
    advancedModel.addValueString(new ArrayList<String>());
  }

  public String generateNewFile(String fileName) throws IOException {
    FileUtils.touch(new File(fileName));
    advancedModel.setFile(new File(fileName));
    generateDefaultContent();
    randomizeArrayList();
    return fileName;
  }

  public void generateDefaultContent(){
    for( rowIncrement = 0 ; rowIncrement < 3; rowIncrement++){
      generateRow();
      for( columnIncrement = 0; columnIncrement < 3; columnIncrement++){
        advancedModel.addKeyColumnVal( rowIncrement, "d");
        advancedModel.addValueColumnVal( rowIncrement, "d");
      }
    }
  }

  public void randomizeArrayList(){
    StringBuilder tempKey;
    StringBuilder tempValue;
    Integer charLength = new Integer(RandomUtils.nextInt(1,4));
    for ( rowIncrement = 0; rowIncrement < advancedModel.getKeyListSize(); rowIncrement++ ){
      for( columnIncrement = 0; columnIncrement < advancedModel.getColumnSize(rowIncrement); columnIncrement++){
        tempKey = new StringBuilder(new Character((char)randomAsciiValue()).toString());
        tempValue = new StringBuilder(new Character((char)randomAsciiValue()).toString());
        for( int i = 0 ; i < charLength ; i++){
          tempKey.append(new Character((char)randomAsciiValue()).toString());
          tempValue.append(new Character((char)randomAsciiValue()).toString());
        }
        advancedModel.getKeyList().get(rowIncrement).set(columnIncrement, tempKey.toString());
        advancedModel.getValueList().get(rowIncrement).set(columnIncrement, tempValue.toString());
      }
    }
    updateFile();
  }

  public void updateFile(){
    File fileToBeModified = advancedModel.getFile();
    StringBuilder newString = new StringBuilder("");
    FileWriter writer = null;
  	try{
	   	writer = new FileWriter(fileToBeModified);
	   	writer.write(assignNewString(newString));
    } catch(Exception e){
    	 e.printStackTrace();
      } finally {
          try{
      			writer.flush();
      			writer.close();
      		} catch(Exception e){
      		}
    	 }
  }

  public String assignNewString(StringBuilder newString){
    newString.setLength(0);
    for(rowIncrement = 0; rowIncrement < advancedModel.getKeyListSize(); rowIncrement++){
  	 for(columnIncrement = 0; columnIncrement
  	   < advancedModel.getColumnSize(rowIncrement); columnIncrement++){
  	   	 newString.append(advancedModel.getKeyColumnValue(rowIncrement, columnIncrement)
  	 		+ " , " + advancedModel.getValueColumnValue(rowIncrement, columnIncrement) + " | ");
  	 }
  	 newString.append("\n");
   }
  	return newString.toString();
  }

  public int randomAsciiValue(){
    return RandomUtils.nextInt(33, 127);
  }

  public String searchResult(String findString){
    int lastIndex = 0;
    int totalCount = 0;
    int count;
    StringBuilder searchResult = new StringBuilder("");
    String temporaryKeyValue;
      for ( rowIncrement = 0 ; rowIncrement < advancedModel.getKeyListSize() ; rowIncrement++ ) {
        for ( columnIncrement = 0 ; columnIncrement < advancedModel.getColumnSize(rowIncrement) ; columnIncrement++ ) {
          count = 0;
          lastIndex = 0;
          temporaryKeyValue = advancedModel.getKeyColumnValue(rowIncrement, columnIncrement)
                            .concat(advancedModel.getValueColumnValue(rowIncrement, columnIncrement));
          while (lastIndex != -1) {
            lastIndex = temporaryKeyValue.indexOf(findString, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += 1;
                totalCount++;
            }
          }
          if(count!=0){
            searchResult.append("Character Found in: [ " + rowIncrement + "," + columnIncrement + "]\n"
            + "Number of Occurences: " + count + "\n");
          }
        }
      }
      searchResult.append("Total Findings: " + totalCount);
      return searchResult.toString();
  }

  public void addRow(int addCell, ArrayList<String> newKey, ArrayList<String> newValue){
    generateRow();
    for( columnIncrement = 0 ; columnIncrement < addCell ; columnIncrement++ ){
      advancedModel.addKeyColumnVal(advancedModel.getKeyListSize()-1,newKey.get(columnIncrement));
      advancedModel.addValueColumnVal(advancedModel.getKeyListSize()-1,newValue.get(columnIncrement));
    }
  }

  public void sortArray(){
    ArrayList<String> temporaryArrayList = new ArrayList<String>();
    for ( rowIncrement = 0 ; rowIncrement < advancedModel.getKeyListSize() ; rowIncrement++ ){
      temporaryArrayList.clear();
      for ( columnIncrement = 0 ; columnIncrement < advancedModel.getColumnSize(rowIncrement) ; columnIncrement++ ) {
        temporaryArrayList.add(advancedModel.getKeyColumnValue(rowIncrement, columnIncrement) + " "
                          + advancedModel.getValueColumnValue(rowIncrement, columnIncrement));
      }
      Collections.sort(temporaryArrayList);
      reSplit(rowIncrement, temporaryArrayList);
    }
  }

  public void reSplit(Integer row, ArrayList<String> temporaryArrayList){
    for( columnIncrement = 0 ; columnIncrement < advancedModel.getKeyList().get(row).size(); columnIncrement++ ){
      String[]splitted = temporaryArrayList.get(columnIncrement).split(" ");
      advancedModel.getKeyList().get(row).set(columnIncrement, splitted[0]);
      advancedModel.getValueList().get(row).set(columnIncrement, splitted[1]);
    }
  }

  public ArrayList<ArrayList<String>> getKeyList(){
    return advancedModel.getKeyList();
  }

  public ArrayList<ArrayList<String>> getValueList(){
    return advancedModel.getValueList();
  }

}
