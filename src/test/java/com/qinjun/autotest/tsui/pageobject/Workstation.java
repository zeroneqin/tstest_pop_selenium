package com.qinjun.autotest.tsui.pageobject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;



import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.ILoadable;
import com.ca.FUAT.Core.PageException;
import com.ca.FUAT.Driver.*;
import com.ca.FUAT.BZ.Lisa.Case;
import com.ca.FUAT.BZ.Lisa.Project;
import com.ca.LISA.UITest.CommonFuncs;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;
import com.ca.LISA.UITest.TestFailedWithReason;


public class Workstation extends GUIPage  {
	 
	 private Workstation() throws PageException {
	     load();
	 }	 
	
	 
	  public static Workstation open() throws PageException{
	      return new Workstation();

	  }
	
	  public void load() throws PageException  {
	     logger.info("Start to load workstation");
	      String load = GUIMap.getElement("Load");
	      try {
	          SikuliDriver.waitFor(load, 100);
	          maximize();
	          SikuliDriver.click(load); 
	         logger.info("Load workstation successfully");
	      }
	      catch (DriverException|PageException e) {
	          Logs.caseError("Failed to load workstation, exception:"+e.getMessage());
	          throw new PageException("Failed to load workstation, exception:"+e.getMessage());
	      }
	}
	
	public Suite  newSuite(String suiteName) throws PageException {
	    Suite suite = null;
	    try {
				SikuliDriver.keyDown(Key.ALT);
				SikuliDriver.type("f");
				SikuliDriver.keyUp(Key.ALT);
				SikuliDriver.type(Key.RIGHT);
				SikuliDriver.typeDupKeys(Key.DOWN, 6);
				SikuliDriver.type(Key.ENTER);				
				CommonFuncs.Wait(2);
				SikuliDriver.keyDown(Key.CTRL);
				SikuliDriver.type("a");
				SikuliDriver.keyUp(Key.CTRL);
				SikuliDriver.type(Key.BACKSPACE);
				SikuliDriver.paste(suiteName);
				SikuliDriver.type(Key.ENTER);
				suite = Suite.open();
				return suite;
	    }
	    catch (DriverException|PageException e) {
	        Logs.caseError("Failed to create suite, exception:"+e.getMessage());
	        throw new PageException("Failed to create suite, exception:"+e.getMessage());
	    }
	}
	

	   public Case  newCase(String caseName) throws PageException {
	        Case testCase = null;
	        try {
	                SikuliDriver.keyDown(Key.ALT);
	                SikuliDriver.type("f");
	                SikuliDriver.keyUp(Key.ALT);
	                SikuliDriver.type(Key.RIGHT);
	                SikuliDriver.typeDupKeys(Key.DOWN, 2);
	                SikuliDriver.type(Key.ENTER);              
	                CommonFuncs.Wait(2);
	                SikuliDriver.keyDown(Key.CTRL);
	                SikuliDriver.type("a");
	                SikuliDriver.keyUp(Key.CTRL);
	                SikuliDriver.type(Key.BACKSPACE);
	                SikuliDriver.paste(caseName);
	                SikuliDriver.type(Key.ENTER);
	                testCase = Case.open();
	                return testCase;
	        }
	        catch (DriverException|PageException e) {
	            Logs.caseError("Failed to create case, exception:"+e.getMessage());
	            throw new PageException("Failed to create case, exception:"+e.getMessage());
	        }
	    }
	   
	   
	    public StagingDoc  newStagingDoc(String stagingDocName) throws PageException {
	        StagingDoc stagingDoc = null;
	        try {
	                SikuliDriver.keyDown(Key.ALT);
	                SikuliDriver.type("f");
	                SikuliDriver.keyUp(Key.ALT);
	                SikuliDriver.type(Key.RIGHT);
	                SikuliDriver.typeDupKeys(Key.DOWN, 5);
	                SikuliDriver.type(Key.ENTER);              
	                CommonFuncs.Wait(2);
	                SikuliDriver.keyDown(Key.CTRL);
	                SikuliDriver.type("a");
	                SikuliDriver.keyUp(Key.CTRL);
	                SikuliDriver.type(Key.BACKSPACE);
	                SikuliDriver.paste(stagingDocName);
	                SikuliDriver.type(Key.ENTER);
	                stagingDoc = StagingDoc.open();
	                return stagingDoc;
	        }
	        catch (DriverException|PageException e){
	            Logs.caseError("Failed to create stagging document, exception:"+e.getMessage());
	            throw new PageException("Failed to create stagging document, exception:"+e.getMessage());
	        }
	    }
	    
	    
	    public VSImage  newVSImage(String vsImageName) throws PageException {
	        VSImage vsImage = null;
	        try {
	                SikuliDriver.keyDown(Key.ALT);
	                SikuliDriver.type("f");
	                SikuliDriver.keyUp(Key.ALT);
	                SikuliDriver.type(Key.RIGHT);
	                SikuliDriver.typeDupKeys(Key.DOWN, 4);
	                SikuliDriver.type(Key.ENTER);              
	                CommonFuncs.Wait(2);
	                SikuliDriver.keyDown(Key.CTRL);
	                SikuliDriver.type("a");
	                SikuliDriver.keyUp(Key.CTRL);
	                SikuliDriver.type(Key.BACKSPACE);
	                SikuliDriver.paste(vsImageName);
	                SikuliDriver.type(Key.ENTER);
	                vsImage = VSImage.open();
	                return vsImage;
	        }
	        catch (DriverException|PageException e) {
	            Logs.caseError("Failed to create virtual service image, exception:"+e.getMessage());
	            throw new PageException("Failed to create virtual service image, exception:"+e.getMessage());
	        }
	    }
	    
	    public VSModel  newVSModel(String vsModelName) throws PageException {
	        VSModel vsModel = null;
	        try {
	                SikuliDriver.keyDown(Key.ALT);
	                SikuliDriver.type("f");
	                SikuliDriver.keyUp(Key.ALT);
	                SikuliDriver.type(Key.RIGHT);
	                SikuliDriver.typeDupKeys(Key.DOWN, 7);
	                SikuliDriver.type(Key.ENTER);              
	                CommonFuncs.Wait(2);
	                SikuliDriver.keyDown(Key.CTRL);
	                SikuliDriver.type("a");
	                SikuliDriver.keyUp(Key.CTRL);
	                SikuliDriver.type(Key.BACKSPACE);
	                SikuliDriver.paste(vsModelName);
	                SikuliDriver.type(Key.ENTER);
	                vsModel = VSModel.open();
	                return vsModel;
	        }
	        catch (DriverException|PageException e) {
	            Logs.caseError("Failed to create virtual service model, exception:"+e.getMessage());
	            throw new PageException("Failed to create virtual service model, exception:"+e.getMessage());
	        }
	    }
	    
	    
	    public AuditDoc  newAuditDoc(String auditDocName) throws PageException {
	        AuditDoc auditDoc = null;
	        try {
	                SikuliDriver.keyDown(Key.ALT);
	                SikuliDriver.type("f");
	                SikuliDriver.keyUp(Key.ALT);
	                SikuliDriver.type(Key.RIGHT);
	                SikuliDriver.type(Key.ENTER);              
	                CommonFuncs.Wait(2);
	                SikuliDriver.keyDown(Key.CTRL);
	                SikuliDriver.type("a");
	                SikuliDriver.keyUp(Key.CTRL);
	                SikuliDriver.type(Key.BACKSPACE);
	                SikuliDriver.paste(auditDocName);
	                SikuliDriver.type(Key.ENTER);
	                auditDoc = AuditDoc.open();
	                return auditDoc;
	        }
	        catch (DriverException|PageException e) {
	            Logs.caseError("Failed to create audit document, exception:"+e.getMessage());
	            throw new PageException("Failed to create audit document, exception:"+e.getMessage());
	        }
	    }
	     
	    
	    public Project  newProject(String projectName) throws PageException {
	        Project project = null;
	        try {
	                SikuliDriver.keyDown(Key.ALT);
	                SikuliDriver.type("f");
	                SikuliDriver.keyUp(Key.ALT);
	                SikuliDriver.type(Key.RIGHT);
	                SikuliDriver.type(Key.ENTER);              
	                CommonFuncs.Wait(2);
	                SikuliDriver.keyDown(Key.CTRL);
	                SikuliDriver.type("a");
	                SikuliDriver.keyUp(Key.CTRL);
	                SikuliDriver.type(Key.BACKSPACE);
	                SikuliDriver.paste(projectName);
	                SikuliDriver.type(Key.ENTER);
	                project = Project.open();
	                return project;
	        }
	        catch (DriverException|PageException e) {
	            Logs.caseError("Failed to create project, exception:"+e.getMessage());
	            throw new PageException("Failed to create project, exception:"+e.getMessage());
	        }
	    }
	
	
    public void maximize() throws PageException { 
       logger.info("Start to maximize workstation");
        try {
            SikuliDriver.keyDown(Key.ALT);
            SikuliDriver.keyDown(Key.SPACE);
            SikuliDriver.keyUp(Key.ALT);
            SikuliDriver.keyUp(Key.SPACE);
            SikuliDriver.type("x");
            SikuliDriver.wait(3);
           logger.info("Maximize workstation successfully");
        }
        catch (DriverException de) {
            Logs.caseError("Failed to maximize workstation");
            throw new PageException("Failed to maximize workstation, exception:"+de.getMessage());
        }
    }	
    
    
    public static ServerConsole openServerConsole() throws PageException {
        ServerConsole serverConsole = null;
        try {
            SikuliDriver.click(GUIMap.getElement("Button_ServerConsole"));
            serverConsole = ServerConsole.open();
            return serverConsole;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to open server console, exception:"+e.getMessage());
            throw new PageException("Failed to open server console, exception:"+e.getMessage());
        }
    }


    
    public  void close() throws PageException {

         if (CommonFuncs.killWinProcess("LISAWorkstation.exe") == false) {
             Logs.caseError("Failed to close workstation");
             throw new PageException("Failed to close workstation");
         }

    }

    public Project  openProject(String projectName) throws PageException {
        Project project = null;
        try {
                SikuliDriver.keyDown(Key.ALT);
                SikuliDriver.type("f");
                SikuliDriver.keyUp(Key.ALT);
                SikuliDriver.type(Key.DOWN);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.UP, 1);
                SikuliDriver.type(Key.ENTER);
                SikuliDriver.paste(projectName);
                SikuliDriver.type(Key.ENTER);
                CommonFuncs.Wait(2);
                project = Project.open();
                return project;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to open project:"+projectName+" ,exception:"+e.getMessage());
            throw new PageException("Failed to open project:"+projectName+" ,exception:"+e.getMessage());
        }
        
    }
   
    
    public Suite  openSuite(String suiteName) throws PageException {
        Suite suite = null;
        try {
                SikuliDriver.keyDown(Key.ALT);
                SikuliDriver.type("f");
                SikuliDriver.keyUp(Key.ALT);
                SikuliDriver.type(Key.DOWN);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.DOWN, 5);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.UP, 3);
                SikuliDriver.type(Key.ENTER);
                SikuliDriver.paste(suiteName);
                SikuliDriver.type(Key.ENTER);
                CommonFuncs.Wait(2);
                suite = Suite.open();
                return suite;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to open suite:"+suiteName+" ,exception:"+e.getMessage());
            throw new PageException("Failed to open suite:"+suiteName+" ,exception:"+e.getMessage());
        }
    }
    
    public Case openCase(String caseName) throws PageException {
        Case testCase = null;
        try {
                SikuliDriver.keyDown(Key.ALT);
                SikuliDriver.type("f");
                SikuliDriver.keyUp(Key.ALT);
                SikuliDriver.type(Key.DOWN);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.type(Key.DOWN);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.UP, 3);
                SikuliDriver.type(Key.ENTER);
                SikuliDriver.paste(caseName);
                SikuliDriver.type(Key.ENTER);
                CommonFuncs.Wait(2);
                testCase = Case.open();
                return testCase;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to open case:"+caseName+", exception:"+ e.getMessage());
            throw new PageException("Failed to open case:"+caseName+", exception:"+ e.getMessage());
        }
    }
    
    
    public StagingDoc openStagingDoc(String stagingDocName) throws PageException{
        StagingDoc stagingDoc = null;
        try {
                SikuliDriver.keyDown(Key.ALT);
                SikuliDriver.type("f");
                SikuliDriver.keyUp(Key.ALT);
                SikuliDriver.type(Key.DOWN);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.DOWN, 4);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.UP, 3);
                SikuliDriver.type(Key.ENTER);
                SikuliDriver.paste(stagingDocName);
                SikuliDriver.type(Key.ENTER);
                CommonFuncs.Wait(2);
                stagingDoc = StagingDoc.open();
                return stagingDoc;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to open staging document:"+stagingDocName+", exception:"+e.getMessage());
            throw new PageException("Failed to open staging document:"+stagingDocName+", exception:"+e.getMessage());
        }
    }
 
    
    public VSImage openVSImage(String vsImageName) throws PageException {
        VSImage vsImage = null;
        try {
                SikuliDriver.keyDown(Key.ALT);
                SikuliDriver.type("f");
                SikuliDriver.keyUp(Key.ALT);
                SikuliDriver.type(Key.DOWN);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.DOWN, 3);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.UP, 3);
                SikuliDriver.type(Key.ENTER);
                SikuliDriver.paste(vsImageName);
                SikuliDriver.type(Key.ENTER);
                CommonFuncs.Wait(2);
                vsImage = VSImage.open();
                return vsImage;
        }
        catch(DriverException|PageException e) {
            Logs.caseError("Failed to open virtual service image:"+vsImageName+", exception:"+e.getMessage());
            throw new PageException("Failed to open virtual service image:"+vsImageName+", exception:"+e.getMessage());
            
        }
    }
  
    
    public VSModel openVSModule(String vsModelName) throws PageException{
        VSModel vsModel = null;
        try {
                SikuliDriver.keyDown(Key.ALT);
                SikuliDriver.type("f");
                SikuliDriver.keyUp(Key.ALT);
                SikuliDriver.type(Key.DOWN);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.DOWN, 2);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.UP, 3);
                SikuliDriver.type(Key.ENTER);
                SikuliDriver.paste(vsModelName);
                SikuliDriver.type(Key.ENTER);
                CommonFuncs.Wait(2);
                vsModel = VSModel.open();
                return vsModel;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to open virtual service model:"+vsModelName+", exception:"+e.getMessage());
            throw new PageException("Failed to open virtual service model:"+vsModelName+", exception:"+e.getMessage());
        }
    }
    
    public AuditDoc  openAuditDoc(String auditDocName) throws PageException{
        AuditDoc auditDoc = null; 
        try {
                SikuliDriver.keyDown(Key.ALT);
                SikuliDriver.type("f");
                SikuliDriver.keyUp(Key.ALT);
                SikuliDriver.type(Key.DOWN);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.DOWN, 2);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.typeDupKeys(Key.UP, 1);
                SikuliDriver.type(Key.RIGHT);
                SikuliDriver.type(Key.ENTER);
                SikuliDriver.paste(auditDocName);
                SikuliDriver.type(Key.ENTER);
                CommonFuncs.Wait(2);
                auditDoc = AuditDoc.open();
                return auditDoc;
        }
        catch (DriverException|PageException e) {
            Logs.caseError("Failed to open audit document:"+auditDocName+", exception:"+e.getMessage());
            throw new PageException("Failed to open audit document:"+auditDocName+", exception:"+e.getMessage());
        }
    }
    
    
    
    public boolean VerifyExist(String type, HashMap<String,String> elementAttr) {
        if(type.equals("Button")) {
            String verifyImg=null;
            Iterator<Entry<String, String>> it = elementAttr.entrySet().iterator();  
            while(it.hasNext()){  
                Entry<String, String>  entry=(Entry<String, String>)it.next();  
                String key = entry.getKey();
                String value = entry.getValue();
                
                System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue());
                if (key.equals("Name")) {
                    if (value.equals("ToggleRegistry")) {
                        verifyImg = GUIMap.getElement("Button_ToggleRegistry");
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
