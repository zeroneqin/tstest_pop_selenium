package com.qinjun.autotest.tsui.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;

import com.ca.LISA.UITest.CommonFuncs;
import com.ca.LISA.UITest.CommonSettings;
import com.ca.LISA.UITest.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {
    final private static Logger logger = LoggerFactory.getLogger(Utility.class);

    public static boolean OpenProject(String projectName) {
       logger.info("Open project"+projectName);
        File lisaProjectDirectory = new File(projectName);

        if (lisaProjectDirectory.exists() == true) {
            App.open(CommonSettings.InstallPath_Workstation + " " + projectName);
        }
        else{
            logger.error("The project "+projectName+" not exist");
        }
        return false;
    }
    
    public static void DeleteProject(String projectPath) throws IOException {
        logger.error("Delete project "+projectPath);
        if(CommonFuncs.ExistFile(projectPath)){
            CommonFuncs.DeleteFolder(projectPath);
        }
        else {
            logger.error("The project "+projectPath+" not exist");
        }
    }
}
