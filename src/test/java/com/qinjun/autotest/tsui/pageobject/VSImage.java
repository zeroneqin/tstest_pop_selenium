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

public class VSImage extends GUIPage {

    
	private VSImage() throws PageException {
	    load();
	}
	

	
	public static VSImage open() throws PageException{
	    return new VSImage();

	}
	
	public void load() throws PageException {
	   logger.info("Start to load virtual service image page");
	    try {
	        SikuliDriver.waitFor(GUIMap.getElement("Load"), 10);
	       logger.info("Load virtual service image page successfully");
	    }
	    catch (DriverException e) {
	        Logs.caseError("Failed to load virtual service image page, exception:"+e.getMessage());
	        throw new PageException("Failed to load virtual service image page, exception:"+e.getMessage());
	    }

	}
	
	

       

    

    
    public void close() {

            
    }	
	
    
    public boolean verifyExist(String type, HashMap<String,String> stepAttr) {

        return false;
    }
    
    
    
	
}
