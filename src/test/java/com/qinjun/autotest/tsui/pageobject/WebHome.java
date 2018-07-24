package com.qinjun.autotest.tsui.pageobject;

import org.openqa.selenium.By;

import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.ILoadable;
import com.ca.FUAT.Core.PageException;
import com.ca.FUAT.Driver.DriverException;
import com.ca.FUAT.Driver.DriverType;
import com.ca.FUAT.Driver.GUIDriver;
import com.ca.FUAT.Driver.SeleniumDriver;
import com.ca.FUAT.Driver.SikuliDriver;

import com.ca.LISA.UITest.CommonFuncs;
import com.ca.LISA.UITest.Logs;

public class WebHome extends GUIPage {
    
    private WebHome() throws PageException {
        load();
    }
    
    
    public static WebHome open() throws PageException {
        return new WebHome();

    }
    
    public void load() throws PageException {
       logger.info("Start to load Web home page");
        try {
            SikuliDriver.waitFor(GUIMap.getElement("Load"), 100);
        }
        catch (DriverException de) {
            Logs.caseError("Failed to load web home page, exception:"+de.getMessage());
            throw new PageException("Failed to load web home page, exception:"+de.getMessage());
        }
    }
    
    public ServerConsole OpenServerConsole() throws PageException {
        ServerConsole lisaServerConsole = null;
        try {
            SikuliDriver.click(GUIMap.getElement("Button_ServerConsole"));
            lisaServerConsole = ServerConsole.open();
            return lisaServerConsole;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to open server console, exception:"+e.getMessage());
            throw new PageException("Failed to open server console, exception:"+e.getMessage());
        }
    }
    
    public ServerConsole OpenDashboard() throws PageException {
        ServerConsole serverConsole = null;
        try {
            SikuliDriver.click(GUIMap.getElement("Button_Dashboard"));
            serverConsole = ServerConsole.open();
            return serverConsole;
        }
        catch (DriverException|PageException e){
            Logs.caseError("Failed to open dashboard, exception:"+e.getMessage());
            throw new PageException("Failed to open dashboard, exception:"+e.getMessage());
        }
    }
    
    
    public ServerConsole OpenCVS() throws PageException {
        ServerConsole lisaServerConsole = null;
        try {
            SikuliDriver.click(GUIMap.getElement("Button_CVS"));
            lisaServerConsole = ServerConsole.open();
            return lisaServerConsole;
        }
        catch (DriverException|PageException e){
            Logs.caseError("Failed to open CVS, exception:"+e.getMessage());
            throw new PageException("Failed to open CVS, exception:"+e.getMessage());
        }
    }
    
    public ServerConsole OpenVSEasy() throws PageException {
        ServerConsole lisaServerConsole = null;
        try {
                     SikuliDriver.click(GUIMap.getElement("Button_VSEasy"));
                    lisaServerConsole = ServerConsole.open();

                    return lisaServerConsole;
        }
        catch (DriverException|PageException e){
            Logs.caseError("Failed to open VSEasy, exception:"+e.getMessage());
            throw new PageException("Failed to open VSEasy, exception:"+e.getMessage());
        }
    }
    
    public void close() throws PageException {
        if (CommonFuncs.killWinProcess("iexplore.exe")== false) {
            throw new PageException("Failed to close server console page");
        }
    }
            
}
