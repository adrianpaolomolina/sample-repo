package com.apm.app;

import static org.junit.Assert.*;
import org.junit.Test;
import com.apm.service.AdvancedController;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputUtilitiesTest
{

  InputUtilities inputUtilities = new InputUtilities();

  @Test
  public void testValidateInputCharToSearch_Empty(){
    String charToSearch = " ";
    assertEquals(charToSearch, inputUtilities.validateInputCharToSearch(""));
  }

  @Test
  public void testValidateInputCharToSearch_NotEmpty(){
    String charToSearch = "AB";
    assertEquals(charToSearch, inputUtilities.validateInputCharToSearch("AB"));
  }

}
