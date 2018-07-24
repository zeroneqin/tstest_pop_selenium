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

public class ServerConsole extends GUIPage {

    private ServerConsole() throws PageException {
        Load();
     }   
    
     
      public static ServerConsole open() throws PageException{
          return new ServerConsole();

      }
    
      public void Load() throws PageException{
         logger.info("Start to load server console page");
          try {
              SikuliDriver.waitFor(GUIMap.getElement("Load",DriverType.SIKULI), 60);
             logger.info("Load server Console page successfully");
          }
          catch (DriverException de) {
              Logs.caseError("Failed to load server console page, exception:"+de.getMessage());
              throw new PageException("Failed to load server console page, exception:"+de.getMessage());
          }

    }
      
   

      
      public ServerConsoleAdmin openAdminPanel() throws PageException{
          ServerConsoleAdmin serverConsoleAdmin = null;
          try {
              SikuliDriver.click(GUIMap.getElement("Button_Admin"));
              serverConsoleAdmin = ServerConsoleAdmin.open();
              return serverConsoleAdmin;
          }
          catch (DriverException|PageException e) {    
             logger.info("Failed to open administration panel, exception:"+e.getMessage());
              throw new PageException("Failed to open administration panel, exception:"+e.getMessage());
          }


      }
      

      
      public void close() throws PageException {
          if (CommonFuncs.killWinProcess("iexplore.exe")== false) {
              throw new PageException("Failed to close server console page");
          }
    
          

              
      }
      
}
