package com.qinjun.autotest.tsui.pageobject;

import java.util.HashMap;
import java.util.Map;


import com.ca.FUAT.Core.GUIPage;
import com.ca.FUAT.Core.ILoadable;
import com.ca.FUAT.Core.PageException;

public abstract class Step extends GUIPage {
	
	public abstract void  updateAttr(HashMap<String,String> stepAttrs) throws PageException; 
		
}
