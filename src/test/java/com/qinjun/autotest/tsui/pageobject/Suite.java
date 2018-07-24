/*
 * LisaCase
 * 
 * 1.0
 *
// * 2014/03/10
 * 
 * Copyright notice
 */

package com.qinjun.autotest.tsui.pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map.Entry;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

import com.ca.FUAT.Driver.*;
import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.PageException;
import com.ca.FUAT.BZ.Lisa.StepExtFtp;
import com.ca.FUAT.Core.ILoadable;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;

public class Suite extends GUIPage {

    
	private Suite() throws PageException {
	    load();
	}
	

	
	public static Suite open() throws PageException{
	    return new Suite();

	}
	
	public void load() throws PageException {
	    try {
	        SikuliDriver.waitFor(GUIMap.getElement("Load"), 10);
	    }
	    catch (DriverException de) {
	        throw new PageException("Failed to load suite");
	    }

	}
	
	
	public Case  addCase(List<String> caseAttrs) throws PageException{
	    Case testCase = null;
	    try {
				    for (String attr : caseAttrs) {
				        SikuliDriver.click(GUIMap.getElement("Button_Add"));
				        if (attr.equals("External/SubProcess\\FTP Step")) {    

				        }
				        else if (attr.equals("Utilities\\Do-Nothing Step")) {

				        }
				        testCase = Case.open();
				    }
				

				    return testCase;
	    }
	    catch (DriverException|PageException e) {
	        throw new PageException("Failed to add case to suite, exception:"+e.getMessage());
	        
	    }
	}
       

    
    
    public void close() {

            
    }	
	
    
    public boolean verifyExist(String type, HashMap<String,String> stepAttr) {

        return false;
    }
    
    
    
	
}
