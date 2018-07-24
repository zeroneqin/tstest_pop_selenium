package com.qinjun.autotest.tsui.pageobject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;


import com.ca.FUAT.Driver.*;
import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.GUIMap;
import com.ca.FUAT.Core.ILoadable;
import com.ca.FUAT.Core.PageException;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;

public class StepExtFtp extends Step  {

	private String Step_Info = "Step_reallocateMouse_RightTop.png.png";
	private String img_FTP_Upload = "CoreSteps_Default_FTP_StepName\\FTP_Upload.png";
	private String img_FTP_Host = "CoreSteps_Default_FTP_StepName\\FTP_Host.png";
	private String img_FTP_Step_Locator = "CoreSteps_Default_FTP_StepName\\FTP_Step_Locator.png";
	private String img_FTP_Host_Input = "CoreSteps_Default_FTP_StepName\\FTP_Host_Input.png";
	private String img_Workstation_UpdateName = "Workstation_UpdateName.png";
	
	private StepExtFtp() throws PageException {
	    load();

	}
	

	
	public static StepExtFtp open() throws PageException {
	    return new StepExtFtp();

	}
	
	public void load() throws PageException {
	    try {
          SikuliDriver.waitFor(GUIMap.getElement("Load"), 10);
	    }
	    catch (DriverException de) {
	        throw new PageException("Failed to load FTP step, exception:"+de.getMessage());
	    }

	}
	
	public void  updateAttr(HashMap<String,String> stepAttrs) throws PageException{
	    try {
			    SikuliDriver.doubleClick(GUIMap.getElement("Load"));
		        Iterator<Entry<String, String>> it = stepAttrs.entrySet().iterator();  
		        while(it.hasNext()){  
		            Entry<String, String>  entry=(Entry<String, String>)it.next();  
		            String key = entry.getKey();
		            String value = entry.getValue();
		            
		            System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue());
		            if (key == "Input_Host") {
		                SikuliDriver.clickRightOf(GUIMap.getElement("Label_Host"), GUIMap.getElement("Text_Host"));
		                SikuliDriver.type(value);
		            	
		            }
		            else if (key == "Input_User") {
		                SikuliDriver.clickRightOf(GUIMap.getElement("Label_Host"), GUIMap.getElement("Text_Host"));
						SikuliDriver.typeDupKeys(Key.TAB, 2);
						SikuliDriver.type(value);
		            	
		            }
		            else if (key == "Input_Password") {
		                SikuliDriver.clickRightOf(GUIMap.getElement("Label_Host"), GUIMap.getElement("Text_Host"));
						SikuliDriver.typeDupKeys(Key.TAB, 3);
						SikuliDriver.type(value);
		            	
		            }
		            else if (key == "Input_Host Path") {
		                SikuliDriver.clickRightOf(GUIMap.getElement("Label_Host"), GUIMap.getElement("Text_Host"));
						SikuliDriver.typeDupKeys(Key.TAB, 14);
						SikuliDriver.type(value);
		            	
		            }
		            else if (key == "Input_Local Path") {
		                SikuliDriver.clickRightOf(GUIMap.getElement("Label_Host"), GUIMap.getElement("Text_Host"));
						SikuliDriver.typeDupKeys(Key.TAB, 15);
						SikuliDriver.type(value);
		            	
		            }
		            else if (key == "Select_Upload_Download") {
		                SikuliDriver.click(GUIMap.getElement("Choice_Upload"));
		            }
		        } 	
				SikuliDriver.click(GUIMap.getElement("Button_Update"));
		
	        }
	    catch (DriverException de) {
	        throw new PageException("Failed to update ftp step attributes");
	    }

	}
	
	
    public void close() {
    }
	
}
