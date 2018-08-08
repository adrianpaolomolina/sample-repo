package com.apm.app;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import com.apm.service.AdvancedController;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class InputUtilitiesTestMock
{
  @Mock
  InputUtilities inputUtilities;

  @BeforeClass
  public void setup(){
    inputUtilities = new InputUtilities();
  }

  @AfterClass
  public void tearDown(){
    inputUtilities = null;
  }

  @Test
  public void testInputKey(){
    int keysToAdd = 3;
    String[] inputKey = {"def", "def", "def"};
    ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(inputKey));
    when(inputUtilities.inputKey(keysToAdd)).thenReturn(inputs);
    assertTrue(inputs.equals(inputUtilities.inputKey(keysToAdd)));
  }

  @Test
  public void testInputValue(){
    int keysToAdd = 4;
    String[] inputValue = {"def", "def", "def", "def"};
    ArrayList<String> inputs = new ArrayList<String>(Arrays.asList(inputValue));
    when(inputUtilities.inputValue(keysToAdd)).thenReturn(inputs);
    assertTrue(inputs.equals(inputUtilities.inputValue(keysToAdd)));
  }

  @Test
  public void testInputSelection(){
    int input = 3;
    when(inputUtilities.inputSelection()).thenReturn(3);
    assertEquals(input, inputUtilities.inputSelection());
  }

  @Test(expected = InputMismatchException.class)
  public void testInputSelection_Exception(){
    when(inputUtilities.inputSelection()).thenThrow(new InputMismatchException());
    inputUtilities.inputSelection();
  }

  @Test
  public void testEditKey(){
    ArrayList<ArrayList<String>> arrayListKey = new ArrayList<ArrayList<String>>();
    arrayListKey.add(new ArrayList<String>());
    arrayListKey.get(0).add("default");
    verify(inputUtilities).editKey(arrayListKey);
  }

  @Test
  public void testEditVaue(){
    ArrayList<ArrayList<String>> arrayListValue = new ArrayList<ArrayList<String>>();
    arrayListValue.add(new ArrayList<String>());
    arrayListValue.get(0).add("default");
    verify(inputUtilities).editValue(arrayListValue);
  }

  @Test
  public void testBothKeyAndValue(){
    ArrayList<ArrayList<String>> arrayListKey = new ArrayList<ArrayList<String>>();
    arrayListKey.add(new ArrayList<String>());
    arrayListKey.get(0).add("default");
    verify(inputUtilities).editKey(arrayListKey);
    ArrayList<ArrayList<String>> arrayListValue = new ArrayList<ArrayList<String>>();
    arrayListValue.add(new ArrayList<String>());
    arrayListValue.get(0).add("default");
    verify(inputUtilities).editBothKeyValue(arrayListKey, arrayListValue);
  }

  @Test
  public void testInputRow(){
    int row = 3;
    when(inputUtilities.inputRow()).thenReturn(row);
    assertEquals(row, inputUtilities.inputRow());
  }

  @Test
  public void testInputColumn(){
    int column = 3;
    when(inputUtilities.inputColumn()).thenReturn(column);
    assertEquals(column, inputUtilities.inputRow());
  }

  @Test(expected = InputMismatchException.class)
  public void testInputRow_Exception(){
    when(inputUtilities.inputRow()).thenThrow(new InputMismatchException());
    inputUtilities.inputRow();
  }

  @Test(expected = InputMismatchException.class)
  public void testInputColumn_Exception(){
    when(inputUtilities.inputColumn()).thenThrow(new InputMismatchException());
    inputUtilities.inputColumn();
  }




}
