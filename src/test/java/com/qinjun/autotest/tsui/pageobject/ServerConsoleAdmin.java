package com.qinjun.autotest.tsui.pageobject;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import com.ca.FUAT.Driver.DriverException;
import com.ca.FUAT.Driver.GUIDriver;
import com.ca.FUAT.Driver.SeleniumDriver;
import com.ca.FUAT.Driver.SikuliDriver;
import com.ca.FUAT.Driver.DriverType;
import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.ILoadable;
import com.ca.FUAT.Core.PageException;
import com.ca.LISA.UITest.CommonFuncs;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;

public class ServerConsoleAdmin extends GUIPage  {

        private ServerConsoleAdmin() throws PageException {
            load();

         }   
        
         
          public static ServerConsoleAdmin open() throws PageException {
              return new ServerConsoleAdmin();
          }
        
          public void load() throws PageException {
              try {
                  SikuliDriver.waitFor(GUIMap.getElement("Load",DriverType.SIKULI),30);
              }
              catch (DriverException de) {
                  Logs.caseError("Failed to load server console administration panel, exception:"+de.getMessage());
                  throw new PageException("Failed to load server console administration panel, exception:"+de.getMessage());
              }

        }
          

          
          
          public void addUser() throws PageException{
              try {
                      SikuliDriver.click(GUIMap.getElement("Button_AddUser"));
                          SikuliDriver.waitFor(GUIMap.getElement("Label_UserId"),30);
                          SikuliDriver.clickRightOf(GUIMap.getElement("Label_UserId"),GUIMap.getElement("Blank"));
                          SikuliDriver.wait(5);
                          SikuliDriver.type("LikeTestRunner");
                          SikuliDriver.type(Key.TAB);
                          SikuliDriver.type("MyPass");
                          SikuliDriver.type(Key.TAB);
                          SikuliDriver.type("MyPass");
                          SikuliDriver.type(Key.TAB);
                          SikuliDriver.type("LikeTestRunner");
                          SikuliDriver.type(Key.TAB);
                          SikuliDriver.type("My Test Runner User");
                          SikuliDriver.typeDupKeys(Key.TAB, 5);
                          SikuliDriver.type(Key.SPACE);
                          SikuliDriver.wait(5);
                          SikuliDriver.click(GUIMap.getElement("Button_Add"));
                          SikuliDriver.wait(2);
                          SikuliDriver.type(Key.ENTER);
              }
              catch (DriverException de) {
                  throw new PageException("Failed to add user in administration panel, exception:"+de.getMessage());
              }
          }

          public void delUser() throws PageException{
              try {
                      SikuliDriver.click(GUIMap.getElement("Choice_UserLikeTestRunner"));
                      SikuliDriver.wait(3);
                      SikuliDriver.click(GUIMap.getElement("Button_DelUser"));
                      SikuliDriver.wait(3);
                      SikuliDriver.click(GUIMap.getElement("Button_Yes"));
                      SikuliDriver.wait(3);
              }
              catch (DriverException de) {
                  Logs.caseError("Failed to delete user in administrator panel, exception:"+de.getMessage());
                  throw new PageException("Failed to delete user in administrator panel, exception:"+de.getMessage());
              }

          }
          
          
          public void closeUserPanel() throws PageException{
              try {
                      SikuliDriver.click(GUIMap.getElement("Lisa","ServerConsoleAdmin","Button_Security",DriverType.SIKULI));
              }
              catch (DriverException de) {
                  Logs.caseError("Failed to close user panel, exception:"+de.getMessage());
                  throw new PageException("Failed to close user panel, exception:"+de.getMessage());
              }
                 
                  
          }

          
          public void close() throws PageException{
              try {
                  SikuliDriver.click(GUIMap.getElement("Lisa","ServerConsole","Button_LisaNet",DriverType.SIKULI));
              }
              catch (DriverException de) {
                  Logs.caseError("Failed to close server console administration panel, exception:"+de.getMessage());
                  throw new PageException("Failed to close server console administration panel, exception:"+de.getMessage());
              }
                  
          }
          
    

}
