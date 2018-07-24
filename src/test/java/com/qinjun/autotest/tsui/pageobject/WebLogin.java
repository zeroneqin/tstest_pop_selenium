package com.qinjun.autotest.tsui.pageobject;


import java.util.Iterator;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.sikuli.script.Key;

import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.ILoadable;
import com.ca.FUAT.Core.PageException;
import com.ca.FUAT.Driver.*;
import com.ca.LISA.UITest.CommonFuncs;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;


public class WebLogin extends GUIPage  {
        private WebLogin() throws PageException {
            load();
        }
        
        
        public static WebLogin open() throws PageException{
            return new WebLogin();
        }
        
        public void load() throws PageException{
           logger.info("Start to load web login page");
            try {
                SikuliDriver.waitFor(GUIMap.getElement("Load"),60); 
               logger.info("Load web login page successfully");
            }
            catch (DriverException de) {
                Logs.caseError("Failed to load web login page, exception:"+de.getMessage());
                throw new PageException("Failed to load web login page, exception:"+de.getMessage());
            }
        }
        
        
        public WebHome login(String userName, String passWord) throws PageException{
            WebHome webHome = null;
            try {
                SikuliDriver.click();
                SikuliDriver.keyDown(Key.SHIFT);
                SikuliDriver.type(Key.TAB);
                SikuliDriver.keyUp(Key.SHIFT);
                SikuliDriver.keyDown(Key.CTRL);
                SikuliDriver.type("a");
                SikuliDriver.keyUp(Key.CTRL);
                SikuliDriver.type(userName);
                SikuliDriver.type(Key.TAB);
                SikuliDriver.type(passWord);
                SikuliDriver.type(Key.ENTER);
                webHome = WebHome.open();
                return webHome;
            }
            catch (DriverException de) {
               logger.info("Failed to login web page, exception:"+de.getMessage());
                throw new PageException("Failed to login web page, exception:"+de.getMessage());
            }
        }
 
   
        
        public boolean VerifyEqual(String type, String source, String target) {
            if (type.equals("String")) {
                if (source.equals(target)) {
                    return true;
                }
            }
            return false;
        }
        
    

        public void close() throws PageException{
            if (CommonFuncs.killWinProcess("iexplore.exe")== false) {
                throw new PageException("Failed to close server console page");
            }
        }

}
