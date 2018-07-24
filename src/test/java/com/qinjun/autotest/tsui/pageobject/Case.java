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

public class Case extends GUIPage {

    
	private Case() throws PageException {
	    load();
	}
	
	public static Case open() throws PageException{
	    return new Case();

	}  
	
	public void load() throws PageException {
	   logger.info("Start to load case page");
	    try {
	        SikuliDriver.waitFor(GUIMap.getElement("Load"), 10);
	       logger.info("Load case page sucessfully");
	    }
	    catch (DriverException de) {
	        Logs.caseError("Failed to load case page, exception:"+de.getMessage());
	        throw new PageException("Failed to load case page, exception:"+de.getMessage());
	    }
	}
	
	
	public void  addSteps(List<String> steps) throws PageException {
	    try {
				    for (String step : steps) {
				        SikuliDriver.keyDown(Key.CTRL);
				        SikuliDriver.type("n");
				        SikuliDriver.keyUp(Key.CTRL);
				        if (step.equals("External/SubProcess\\FTP Step")) {    
				            SikuliDriver.typeDupKeys(Key.DOWN, 6);
				            SikuliDriver.type(Key.RIGHT);
				            SikuliDriver.typeDupKeys(Key.DOWN, 5);
				            SikuliDriver.type(Key.ENTER);
				        }
				        else if (step.equals("Utilities\\Do-Nothing Step")) {
				            SikuliDriver.typeDupKeys(Key.DOWN, 5);
				            SikuliDriver.type(Key.RIGHT);
				            SikuliDriver.typeDupKeys(Key.DOWN, 4);
				            SikuliDriver.type(Key.ENTER);
				        }
				        else {
				            throw new PageException("Not supported test step");
				        }

				    }
	    }
	    
	    catch (DriverException de) {
	        throw new PageException("Failed to add test step");
	    }
	}
	

	
	   public Step  openStep(String stepType) throws PageException {
	       Step step = null;
	       try {
	                if (stepType.equals("External/SubProcess\\FTP Step")) {
	                    SikuliDriver.click(GUIMap.getElement("Lisa","StepExtFtp","Label_FtpTitleBase",DriverType.SIKULI));
	                    step = StepExtFtp.open();
	                }
	                else if (stepType.equals("Utilities\\Do-Nothing Step")) {
                        SikuliDriver.click(GUIMap.getElement("Lisa","StepUtilNoThing","Label_NothingTitleBase",DriverType.SIKULI));
                        step = StepExtFtp.open();
	                }      

	                return step;
	       }
	       catch (DriverException|PageException e) {
	           throw new PageException("Failed to open step");
	       }
	   }
	
       public Step  renameStep(String stepType, String stepName) throws PageException {
           Step step = null;
           try {
                        if (stepType.equals("External/SubProcess\\FTP Step")) {
                            SikuliDriver.rightClick(GUIMap.getElement("Lisa","StepExtFtp","Label_Ftp_Starter",DriverType.SIKULI));
                        }
                        else if (stepType.equals("Utilities\\Do-Nothing Step")) {

                        }
                        
                        SikuliDriver.typeDupKeys(Key.DOWN, 5);
                        SikuliDriver.type(Key.ENTER);
                        SikuliDriver.keyDown(Key.CTRL);
                        SikuliDriver.type("a");
                        SikuliDriver.keyUp(Key.CTRL);
                        SikuliDriver.paste(stepName);
                        SikuliDriver.type(Key.ENTER);     
                        step = StepExtFtp.open();
                        return step;
           }
           catch (DriverException|PageException e) {
               throw new PageException("Failed to rename step, exception:"+e.getMessage());
           }
       }
       
    public void openITR() throws PageException {

        try {
                SikuliDriver.keyDown(Key.CTRL);
                SikuliDriver.keyDown(Key.SHIFT);
                SikuliDriver.type("i");
                SikuliDriver.keyUp(Key.CTRL);
                SikuliDriver.keyUp(Key.SHIFT);
            }
        catch (DriverException de) {
            throw new PageException("Failed to open ITR");
        }
    }

    
    public void runITR() throws PageException{
        try {
        
   
                SikuliDriver.click(GUIMap.getElement("Button_ITR_Run"));
            }
        catch (DriverException de) {
            throw new PageException("Failed to run ITR, exception:"+de.getMessage());
        }
    }
    
    public void close() throws PageException{
        throw new PageException("Failed to close Case");
            
    }	
	
    
    public boolean verifyExist(String type, HashMap<String,String> stepAttr) {
        if(type.equals("Step")) {
            String verifyImg=null;
            Iterator<Entry<String, String>> it = stepAttr.entrySet().iterator();  
            while(it.hasNext()){  
                Entry<String, String>  entry=(Entry<String, String>)it.next();  
                String key = entry.getKey();
                String value = entry.getValue();
                
                System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue());
                if (key.equals("Name")) {
                    if (value.equals("FTP")) {
                        verifyImg = GUIMap.getElement("Label_FtpDefaultTitle");
                    }
                    else if  (value.equals("FTP get 192.168.168.254")) {
                        verifyImg = GUIMap.getElement("Label_FtpGetTitle");
                    }
                    else if (value.equals("FTP put 192.168.168.254")) {
                        verifyImg = GUIMap.getElement("Label_FtpPutTitle");
                    }
                    if (SikuliDriver.verify(verifyImg)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    
	
}
