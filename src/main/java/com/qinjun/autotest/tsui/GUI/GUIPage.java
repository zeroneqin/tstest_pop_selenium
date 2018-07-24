package com.qinjun.autotest.tsui.GUI;


import com.qinjun.autotest.tsui.core.ILoadable;
import com.qinjun.autotest.tsui.core.IVerifiable;
import com.qinjun.autotest.tsui.exception.PageException;


public  class GUIPage implements ILoadable,IVerifiable {
	
	public GUIPage() {
	    
	}

	   
	public void load() throws PageException {

	}

	public void close() throws PageException {

	}
	
	public boolean verifyExist() {
	    return false;
	}
	
	public boolean verifyTrue() {
	    return false;
	}
	   
	public boolean verifyEqual() {
	    return false;
	}
	
}
