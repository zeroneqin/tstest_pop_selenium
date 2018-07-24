package com.qinjun.autotest.tsui.core;





import com.qinjun.autotest.tsui.driver.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GUIMap {
    final private static Logger logger = LoggerFactory.getLogger(GUIMap.class);
    private static final int nIndexProduct          = 0;
    private static final int nIndexPage             = 1;
    private static final int nIndexElement          = 2;
    private static final int nIndexSikuliLocator    = 3;    
    private static final int nIndexSeleniumLocator  = 4;
    public  static List<String[]> listGUIMaps;

    private static final String [] sTableHeader = {"Product", "Page", "Element", "Type", "SikuliLocator","SeleniumLocator"};
    
    static {
        if (CommonSettings.GUI_Repository == null) {
            System.out.println("Please set GUI repository in CommonSettings file");
            System.exit(1);
        }
    
        listGUIMaps = GUIMap.loadGUIMap(CommonSettings.GUI_Repository+"\\GUIMap.csv");
    }
    
    
    public static int getIndexProduct() {
        return nIndexProduct;
    }
    
    public static int getIndexPage() {
        return nIndexPage;
    }

    public static int getIndexElement() {
        return nIndexElement;
    }


    public static int getIndexSikuliLocator() {
        return nIndexSikuliLocator;
    }   
    
    public static int getIndexSeleniumLocator() {
        return nIndexSeleniumLocator;
    }


    public static String [] getActionTableHeader(){
        return sTableHeader;
    }

    public static String getElement(String product, String page, String element, DriverType driverType) {
       logger.info("Get element ["+element+"] from product["+product+"],page["+page+"],driver["+driverType+"]");
        for (int i=1; i < listGUIMaps.size(); i++){         
            String[] guiMapLine = listGUIMaps.get(i);
            String productInMap = guiMapLine[GUIMap.getIndexProduct()];
            String pageInMap    = guiMapLine[GUIMap.getIndexPage()];
            String elementInMap = guiMapLine[GUIMap.getIndexElement()];
            String sikuliLocator= guiMapLine[GUIMap.getIndexSikuliLocator()];
            String seleniumLocator= guiMapLine[GUIMap.getIndexSeleniumLocator()];
            
            if (product.equals(productInMap)) {
                if (page.equals(pageInMap)) {
                    if (element.equals(elementInMap)) {
                        if (driverType == DriverType.SIKULI) {
                            return CommonSettings.GUI_Repository+"\\"+sikuliLocator.substring(sikuliLocator.indexOf('=')+1);
                        }
                        else if (driverType == DriverType.SELENIUM) {
                            return seleniumLocator;
                        }
                    }
                }
            }
        }
        return null;   
    }
  
    
    public static String getElement(String product, String page, String element) {
       logger.info("Get element ["+element+"] from product["+product+"],page["+page+"],driver["+CommonSettings.Default_Driver+"]");
        for (int i=1; i < listGUIMaps.size(); i++){         
            String[] guiMapLine = listGUIMaps.get(i);
            String productInMap = guiMapLine[GUIMap.getIndexProduct()];
            String pageInMap    = guiMapLine[GUIMap.getIndexPage()];
            String elementInMap = guiMapLine[GUIMap.getIndexElement()];
            String sikuliLocator= guiMapLine[GUIMap.getIndexSikuliLocator()];
            String seleniumLocator= guiMapLine[GUIMap.getIndexSeleniumLocator()];
            String driverType = CommonSettings.Default_Driver;
            if (product.equals(productInMap)) {
                if (page.equals(pageInMap)) {
                    if (element.equals(elementInMap)) {
                        if (driverType.equals("SIKULI")) {
                            return CommonSettings.GUI_Repository+"\\"+sikuliLocator.substring(sikuliLocator.indexOf('=')+1);
                        }
                        else if (driverType.equals("SELENIUM")) {
                            return seleniumLocator;
                        }
                    }
                }
            }
        }
        return null;   
    }
    
    
    public static String getElement(String element) {
 
        String callerClassNameWithPackage = Thread.currentThread().getStackTrace()[2].getClassName();
        String callerClassName = callerClassNameWithPackage.substring(callerClassNameWithPackage.lastIndexOf('.')+1);
        String product = getProductFromClassName(callerClassNameWithPackage);
        String page= callerClassName;
        String driverType = CommonSettings.Default_Driver;
       logger.info("Get element ["+element+"] from product["+product+"],page["+page+"],driver["+driverType+"]");
        for (int i=1; i < listGUIMaps.size(); i++){         
            String[] guiMapLine = listGUIMaps.get(i);
            String productInMap = guiMapLine[GUIMap.getIndexProduct()];
            String pageInMap    = guiMapLine[GUIMap.getIndexPage()];
            String elementInMap = guiMapLine[GUIMap.getIndexElement()];
            String sikuliLocator= guiMapLine[GUIMap.getIndexSikuliLocator()];
            String seleniumLocator= guiMapLine[GUIMap.getIndexSeleniumLocator()];
            
            if (product.equals(productInMap)) {
                if (page.equals(pageInMap)) {
                    if (element.equals(elementInMap)) {
                        if (driverType.equals("SIKULI")) {
                            return CommonSettings.GUI_Repository+"\\"+sikuliLocator.substring(sikuliLocator.indexOf('=')+1);
                        }
                        else if (driverType.equals("SELENIUM")) {
                            return seleniumLocator;
                        }
                    }
                }
            }
        }
        return null;   
    }
    
    public static String getElement(String element, DriverType driverType) {
        String callerClassNameWithPackage = Thread.currentThread().getStackTrace()[2].getClassName();
        String callerClassName = callerClassNameWithPackage.substring(callerClassNameWithPackage.lastIndexOf('.')+1);
        String product = getProductFromClassName(callerClassNameWithPackage);
        String page= callerClassName;
       logger.info("Get element ["+element+"] from product["+product+"],page["+page+"],driver["+driverType+"]");
        for (int i=1; i < listGUIMaps.size(); i++){         
            String[] guiMapLine = listGUIMaps.get(i);
            String productInMap = guiMapLine[GUIMap.getIndexProduct()];
            String pageInMap    = guiMapLine[GUIMap.getIndexPage()];
            pageInMap.replace("\\", "");
            String elementInMap = guiMapLine[GUIMap.getIndexElement()];
            String sikuliLocator= guiMapLine[GUIMap.getIndexSikuliLocator()];
            String seleniumLocator= guiMapLine[GUIMap.getIndexSeleniumLocator()];
            
            if (product.equals(productInMap)) {
                if (page.equals(pageInMap)) {
                    if (element.equals(elementInMap)) {
                        if (driverType == DriverType.SIKULI) {
                            return CommonSettings.GUI_Repository+"\\"+sikuliLocator.substring(sikuliLocator.indexOf('=')+1);
                        }
                        else if (driverType == DriverType.SELENIUM) {
                            return seleniumLocator;
                        }
                    }
                }
            }
        }
        return null;   
    }
    
    
    private static String getProductFromClassName(String classNameWithPackage) {   
       int bzIndex = classNameWithPackage.indexOf("BZ.");
       int lastDotIndex = classNameWithPackage.lastIndexOf('.');
       if (bzIndex > 0 && lastDotIndex > 0 && lastDotIndex > bzIndex) { 
           return classNameWithPackage.substring(bzIndex+3, lastDotIndex);
       }
       else {
           return null;
       }
    }
    

    
    
    public static List<String[]> loadGUIMap(String guiMapFile) {
        List<String[]> guiMap = null;
        Logs.systemDebug("Load GUIMap");
        try {
            CSVReader reader = new CSVReader(new FileReader(guiMapFile),',', '"', '|');
            guiMap = reader.readAll();
            reader.close();
        }
        catch (IOException ie){
            Logs.systemError("Failed to load GUI map file [" + guiMapFile + "].");
            Logs.writeSystemLog(ie.getMessage());
        }
        
        return guiMap;
        
    }


    
    
    
    
    
    
}
