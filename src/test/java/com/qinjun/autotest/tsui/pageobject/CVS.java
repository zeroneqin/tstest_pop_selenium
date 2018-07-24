package com.qinjun.autotest.tsui.pageobject;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.ca.FUAT.Driver.DriverException;
import com.ca.FUAT.Driver.GUIDriver;
import com.ca.FUAT.Driver.SeleniumDriver;
import com.ca.FUAT.Driver.SikuliDriver;
import com.ca.FUAT.Driver.DriverType;
import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.PageException;
import com.ca.LISA.UITest.CommonFuncs;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;

public class CVS extends GUIPage {

    private CVS() throws PageException {
        Load();
     }   
    
     
      public static CVS open() throws PageException {
          return new CVS();

      }
    
      public void Load() throws PageException {
         logger.info("Start to load CVS page");
          try {
              SikuliDriver.waitFor(GUIMap.getElement("Load"), 60);
             logger.info("Load CVS page sucessfully");
          }
          catch (DriverException de) {
              Logs.caseError("Failed to load CVS page, exception:"+de.getMessage());
              throw new PageException("Failed to load CVS page, exception:"+de.getMessage());
          }
    }
      

      
      public void close() throws PageException {
          throw new PageException("Failed to close CVS page");
              
      }
      
}
