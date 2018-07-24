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

import com.qinjun.autotest.tsui.GUI.GUIPage;
import com.qinjun.autotest.tsui.core.GUIMap;
import com.qinjun.autotest.tsui.driver.SikuliDriver;
import com.qinjun.autotest.tsui.exception.DriverException;
import com.qinjun.autotest.tsui.exception.PageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;


public class AuditDoc extends GUIPage {
	final private static Logger logger = LoggerFactory.getLogger(AuditDoc.class);
    
	private AuditDoc() throws PageException {
	    load();
	}
	

	
	public static AuditDoc open() throws PageException {
	    return new AuditDoc();
	}
	
	public void load() throws PageException {
	    logger.info("Start to load audit document page");
	    try {
	        SikuliDriver.waitFor(GUIMap.getElement("Load"), 10);
	        logger.debug("Load audit document page successfully");
	    }
	    catch (DriverException de) {
	        logger.error("Failed to load audit document, exception:"+de.getMessage());
	        throw new PageException("Failed to load audit document, exception:"+de.getMessage());
	    }
	}
	
	

       

    
    public void run() throws PageException {

    }
    
    public void close() throws PageException {

            
    }	
	
    
    public boolean verifyExist(String type, HashMap<String,String> stepAttr) {

        return false;
    }
    
    
    
	
}
