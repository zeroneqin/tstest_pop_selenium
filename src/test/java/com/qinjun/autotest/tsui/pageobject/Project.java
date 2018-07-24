package com.qinjun.autotest.tsui.pageobject;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import com.ca.FUAT.Driver.*;
import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.ILoadable;
import com.ca.FUAT.Core.PageException;
import com.ca.FUAT.Driver.DriverType;
import com.ca.FUAT.Driver.GUIDriver;
import com.ca.FUAT.Driver.SeleniumDriver;
import com.ca.FUAT.Driver.SikuliDriver;
import com.ca.LISA.UITest.CommonFuncs;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;

public class Project extends GUIPage {
 
	private Project() throws PageException {
	    load();
	}
	

	
	public static Project open() throws PageException {
	    return new Project();
	}
	
	public void load() throws PageException {
	   logger.info("Start to load project page");
	    try {
	        SikuliDriver.waitVanish(GUIMap.getElement("Load"), 20);
	       logger.info("Load project page successfully");
	    }
	    catch (DriverException de) {
	        Logs.caseError("Failed to load project page, exception:"+de.getMessage());
	        throw new PageException("Failed to load project page, exception:"+de.getMessage());
	    }

	}
	
	
	public Case  newCase(String caseName) throws PageException{
	    try {
				SikuliDriver.keyDown(Key.ALT);
				SikuliDriver.type("f");
				SikuliDriver.keyUp(Key.ALT);
				SikuliDriver.type(Key.RIGHT);
				SikuliDriver.type(Key.DOWN);
				SikuliDriver.type(Key.ENTER);
				SikuliDriver.paste(caseName);
				SikuliDriver.type(Key.ENTER);
				SikuliDriver.waitFor(GUIMap.getElement("Lisa", "Case", "Load", DriverType.SIKULI), 20);
		        Case guiLisaCaseEditor = Case.open();
		        return guiLisaCaseEditor;
	    }
	    catch (DriverException|PageException e) {
	        Logs.caseError("Failed to create case, exception:"+e.getMessage());
			throw new PageException("Failed to create case, exception:"+e.getMessage());
		}


	}
	
	
    public void close() throws PageException {
        try {
            SikuliDriver.click(GUIMap.getElement("Button_Close"));
        }
        catch (DriverException de) {
           logger.info("Failed to close project page, exception:"+de.getMessage());
            throw new PageException("Failed to close project page, exception:"+de.getMessage());
        }

            
    }
}
