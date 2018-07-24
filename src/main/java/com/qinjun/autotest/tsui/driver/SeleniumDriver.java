package com.qinjun.autotest.tsui.driver;



import java.util.Set;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import com.qinjun.autotest.tsui.core.Utility;
import com.qinjun.autotest.tsui.exception.DriverException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SeleniumDriver {
    final private static Logger logger = LoggerFactory.getLogger(SeleniumDriver.class);

        private static WebDriver   webDriver = null;
        
        static {
            if (CommonSettings.Selenium_Driver.equals("FireFox")) {
                webDriver = new FirefoxDriver();
            }
            else if (CommonSettings.Selenium_Driver.equals("IE")) {
                webDriver = new InternetExplorerDriver();
            }
            else if (CommonSettings.Selenium_Driver.equals("Chrome")) {
                webDriver = new ChromeDriver();
            }
            else {
                System.out.println("Invalid Selenium driver type in configration file");
            }
        }

        private SeleniumDriver() {

        }
        
   
        public static By getBy(String byString) {
            By bytemp=null;
            if (byString.startsWith("id=")) {
                bytemp = By.id(byString.substring(3));
            }
            else if (byString.startsWith("xpath=")) {
                bytemp = By.xpath(byString.substring(6));
            }
            else if (byString.startsWith("css=")) {
                bytemp = By.cssSelector(byString.substring(4));
            }
            return bytemp;
        }
        
        
        public static WebElement findElement(String locator) throws DriverException {
            WebElement webElement = null;
            By by = getBy(locator);
            try {
                webElement = webDriver.findElement(by);
               logger.info("Find GUI element:"+locator);
                return webElement;
            }
            catch (NoSuchElementException e) {
                Logs.caseError("Failed to find GUI element:"+locator+" ,exception:"+e.getMessage());
                throw new DriverException("Failed to find GUI element:"+locator+" ,exception:"+e.getMessage());
            }
        }
        
        
        public static void click(WebElement webElement) throws DriverException {
            try {
                webElement.click();
               logger.info("Click GUI element:"+webElement.toString());
            }
            catch (StaleElementReferenceException e) {
               Logs.caseError("Failed to click GUI element:"+webElement.toString()+", exception:"+e.getMessage());
               throw new DriverException("Failed to click GUI element:"+webElement.toString()+", exception:"+e.getMessage());
            }
        }
        
        public static WebElement waitElement (String locator, int timeout) throws DriverException{
            WebElement targetElement=null;
            By by = getBy(locator);
            try {
                targetElement = (new WebDriverWait(webDriver, timeout)).until(ExpectedConditions.presenceOfElementLocated(by));
               logger.info("Wait for GUI element:"+locator+ " sucessfully");
                return targetElement;
            }
            catch (TimeoutException e) {
                Logs.caseError("Failed to wait for GUI element:"+locator+" ,exception:"+locator);
                throw new DriverException("Failed to wait for GUI element:"+locator+" ,exception:"+locator);
            }
        }
        
        public static void get(String url) throws DriverException {
            try {
                webDriver.get(url);
               logger.info("Open URL:"+url);
            }
            catch (TimeoutException e1) {
                try {
                    webDriver.get(url);
                }
                catch (TimeoutException e2) {
                    Logs.caseError("Failed to open URL:"+url+" ,exception:"+e2.getMessage());
                    throw new DriverException("Failed to open URL:"+url+" ,exception:"+e2.getMessage());
                }
            }

        }
        
        public static void sendKeys(WebElement element, String sText) {
            String sValue;
            sValue = element.getAttribute("value"); //$NON-NLS-1$
            if (sValue == null) sValue = "";
            
            String string = Keys.chord(Keys.END);
            if (!sValue.isEmpty()) {
                int len = sValue.length();
                for (int i =0; i < len; i++) { 
                    string = string + Keys.chord(Keys.BACK_SPACE);
                }
                element.sendKeys(string);
            }
            element.clear();
            element.sendKeys(sText);
           logger.info("Send key:"+sText);
        }
        
        public static void Maximize() {
            webDriver.manage().window().maximize();
           logger.info("Maximize the window");
        }
        
        public static void Close() {
            webDriver.close();
           logger.info("Close windows");
        }
  
        public static void Quit() {
            webDriver.quit();
            webDriver=null;
           logger.info("Quit web driver");
        }
        
        public static boolean Run(String script) {
            return true;
        }
        
        
        public static boolean sendKeys (String keys) {
            return true;
        }
        
        public static Set<String>  GetWindowHandles() {
            return webDriver.getWindowHandles();
        }
        

        public static WebDriver.TargetLocator  SwitchTo() {
            return webDriver.switchTo();
        }

        
}
