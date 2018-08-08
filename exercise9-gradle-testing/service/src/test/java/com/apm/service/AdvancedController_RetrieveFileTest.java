package com.apm.service;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import com.apm.model.*;
import java.util.Arrays;
import java.util.Collection;
import java.lang.NullPointerException;

@RunWith(Parameterized.class)
public class AdvancedController_RetrieveFileTest {
  private String file;
  private String resultType;
  private AdvancedController advancedController = new AdvancedController();


  public AdvancedController_RetrieveFileTest(String resultType, String file){
    this.resultType = resultType;
    this.file = file;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> files(){
    return Arrays.asList(new Object[][] {
      {"Success", "testText.txt"},
      {"Fail", "testText20.txt"}
    });
  }

  @Test
  public void testRetrieveFile_Success(){
    if(resultType.equals("Success")){
      advancedController.retrieveFile(file);
      System.out.println("Successful Test! File Exists.");
    }
  }

  @Test
  public void testRetrieveFile_Fail(){
    if(resultType.equals("Fail")){
      try {
        advancedController.retrieveFile(file);
        fail("Exception was not thrown.");
      } catch (NullPointerException e){
        System.out.println("Successful Test! Error Was Thrown");
      }
    }
  }
}
