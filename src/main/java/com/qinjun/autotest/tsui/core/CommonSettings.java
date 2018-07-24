package com.qinjun.autotest.tsui.core;

import java.io.File;
import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class CommonSettings {
    public static int WaitSeconds;
    public static float ImgSimilarity;
    public static String LogFolder;
    public static String ImgFolder;
    public static String ImgFolder_VSE;
    public static String ImgFolder_Workstation;
    public static String ImgFolder_Common;
    public static String ImgFoler_Pathfinder;

    public static String InstallPath_Lisa;
    public static String vseDeployPath;
    public static String LISA_TEMP;
    public static String LogVSEName;

    public static String GUI_Repository;

    public static String URLLISAConsole;
    public static String LogName;

    public static String InstallPath_Firefox;
    public static String InstallPath_Firefox_64;
    public static String InstallPath_IE;
    public static String Monitor_TargetPath;

    public static String Monitor_TargetPath_recursive;
    public static String InstallPath_Registry;
    public static String InstallPath_Workstation;
    public static String InstallPath_ServiceManager;
    public static String InstallPath_DemoServer;
    public static String QATests_Path;

    public static String RegistryName;
    public static String VSEprocessName;
    public static String CoordinatorName;
    public static String SimulatorName;

    public static String Mail_From;
    public static String Mail_To;
    public static String Mail_Server;
    public static String Mail_Subject;
    public static String Result_Pass;
    public static String Result_Fail;
    public static String Result_Skip;
    public static String xmlFolder;

    public static String XmlFile;

    public static int TimesToCheckWindows;

    public static boolean RetryFailedCases;

    public static void init() {
    }

    static {
        try {
            File fXmlFile = new File("CommonSettings.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                            .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            Field[] f = CommonSettings.class.getDeclaredFields();
            NodeList nl;

            for (int i = 0; i < f.length; i++) {
                nl = doc.getDocumentElement().getElementsByTagName(
                                f[i].getName());
                switch (f[i].getType().toString()) {
                    case "int":
                        f[i].set(f[i],
                                        Integer.parseInt(nl.item(0)
                                                        .getFirstChild()
                                                        .getTextContent()));
                        break;
                    case "float":
                        f[i].set(f[i],
                                        Float.parseFloat(nl.item(0)
                                                        .getFirstChild()
                                                        .getTextContent()));
                        break;
                    case "boolean":
                        f[i].set(f[i],
                                        Boolean.parseBoolean(nl.item(0)
                                                        .getFirstChild()
                                                        .getTextContent()));
                        break;
                    default:
                        f[i].set(f[i], nl.item(0).getFirstChild()
                                        .getTextContent());
                }
            }

            vseDeployPath = InstallPath_Lisa + vseDeployPath;
            InstallPath_Registry = InstallPath_Lisa + InstallPath_Registry;
            InstallPath_Workstation = InstallPath_Lisa
                            + InstallPath_Workstation;
            InstallPath_ServiceManager = InstallPath_Lisa
                            + InstallPath_ServiceManager;
            InstallPath_DemoServer = InstallPath_Lisa + InstallPath_DemoServer;
            LogVSEName = LISA_TEMP + LogVSEName;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
