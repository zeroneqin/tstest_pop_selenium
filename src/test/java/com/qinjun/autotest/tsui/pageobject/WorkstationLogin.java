package com.qinjun.autotest.tsui.pageobject;

import java.util.logging.Level;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.ILoadable;
import com.ca.FUAT.Core.PageException;
import com.ca.FUAT.Driver.*;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;

public class WorkstationLogin extends GUIPage  {
    
	private WorkstationLogin() throws PageException {
		load();
	}
	
	
	public static WorkstationLogin open() throws PageException {
	    return new WorkstationLogin();

	}
	
	   
	public void load() throws PageException {
	   logger.info("Start to load workstaton login page");
	    try {
	        SikuliDriver.waitFor(GUIMap.getElement("Load"), 60);
	       logger.info("Load workstation login page successfully");
	    }
	    catch (DriverException de) {
	        Logs.caseError("Failed to load workstation login page, exception:"+de.getMessage());
	        throw new PageException("Failed to load workstation login page, exception:"+de.getMessage());
	    }

	}
	
	
    public Workstation Login(String userName, String passWord)  throws PageException {
       logger.info("Login workstation with username "+userName+" password "+passWord);
        try {
                    SikuliDriver.click(GUIMap.getElement("Text_Password"));
                    SikuliDriver.keyDown(Key.SHIFT);
                    SikuliDriver.type(Key.TAB);
                    SikuliDriver.keyUp(Key.SHIFT);
                    SikuliDriver.keyDown(Key.CTRL);
                    SikuliDriver.type("a");
                    SikuliDriver.keyUp(Key.CTRL);
                    SikuliDriver.paste(userName);
                    SikuliDriver.type(Key.TAB);
                    SikuliDriver.paste(passWord);
                    SikuliDriver.type(Key.ENTER);
                    Workstation lisaWorkstation = Workstation.open();
                    return lisaWorkstation;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to login workstation, exception:"+e.getMessage());
            throw new PageException("Failed to login workstation, exception:"+e.getMessage());
        }
    }
    
    

    
    public void close() throws PageException {
       logger.info("Close workstation login");
        try {
            SikuliDriver.click(GUIMap.getElement("Button_Cancel"));
            SikuliDriver.waitVanish(GUIMap.getElement("Button_Cancel"), 5);
        }
        catch (DriverException de) {
            Logs.caseError("Failed to close workstation login, exception:"+de.getMessage());
            throw new PageException("Failed to close workstation login, exception:"+de.getMessage());
        }
    }
    
}
