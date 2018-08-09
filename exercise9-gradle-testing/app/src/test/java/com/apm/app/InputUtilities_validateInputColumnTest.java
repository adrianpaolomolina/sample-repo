package com.apm.app;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import com.apm.service.AdvancedController;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class InputUtilities_validateInputColumnTest {
  private int row;
  private int column;
  private boolean expectedResult;
  private AdvancedController advancedController = new AdvancedController();
  private InputUtilities inputUtilities = new InputUtilities();

  public InputUtilities_validateInputColumnTest(int row, int column, boolean expectedResult){
    this.row = row;
    this.column = column;
    this.expectedResult = expectedResult;
  }
  @Parameterized.Parameters
  public static Collection<Object[]> inputRow(){
    return Arrays.asList(new Object[][] {
      {0, 3, false},
      {0, -1, false},
      {0, 0, true}
    });
  }
  
  @Test
  public void testValidateInputColumnTest(){
    advancedController.retrieveFile("testText.txt");
    assertEquals(expectedResult, inputUtilities.validateInputColumn(row, column, advancedController.getKeyList()));
  }
}
