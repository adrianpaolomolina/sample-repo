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
public class InputUtilities_validateInputRowTest {
  private int row;
  private boolean expectedResult;
  private AdvancedController advancedController = new AdvancedController();
  private InputUtilities inputUtilities = new InputUtilities();

  public InputUtilities_validateInputRowTest(int row, boolean expectedResult){
    this.row = row;
    this.expectedResult = expectedResult;
  }
  @Parameterized.Parameters
  public static Collection<Object[]> inputRow(){
    return Arrays.asList(new Object[][] {
      {-1, false},
      {4, false},
      {0, true}
    });
  }
  @Test
  public void testValidateInputRow(){
    advancedController.retrieveFile("testText.txt");
    assertEquals(expectedResult, inputUtilities.validateInputRow(row, advancedController.getKeyList()));
  }
}
