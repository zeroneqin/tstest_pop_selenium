package com.qinjun.autotest.tsui.driver;


import org.openqa.selenium.logging.Logs;
import org.sikuli.api.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;

public class SikuliDriver {
    final private static Logger logger = LoggerFactory.getLogger(SikuliDriver.class);

    private static Screen screen = new Screen();
    
    public SikuliDriver( ) {
    }
    
    
    public static void captureScreen(String imgName)  {
       logger.info("Capture screenshot to "+imgName);
        if (imgName == null || imgName.isEmpty()) {
           logger.warn("Image name is empty");
        }
        else {
            BufferedImage scImg;
            scImg = screen.capture().getImage();
            if (scImg == null) {
               logger.warn("Failed to capture screenshot");
            }
            
            try {
                imgName = imgName.substring(0, imgName.indexOf(".png"));
                imgName += "_" + CollectResults.RunStarttime + ".png";
                ImageIO.write(scImg,
                                "png",
                                new File(CommonFuncs.GetScreenshotFullName(imgName)));
               logger.info("Captured screenshot "+imgName);
            }
            catch (IOException e) {
               logger.warn("Get exception when write screenshot to file"+e.getMessage());
            }
        }
    }


    public static void wait(int seconds) {
        int milliseconds = seconds * 1000;
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {
           logger.warn( "Get exception when wait for "+seconds+" seconds");
        }
    }



    public static void keyDown(String key) {
        screen.keyDown(key);
       logger.info( "Key down "+getKeyName(key));
    }

    public static void keyUp(String key) {
        screen.keyUp(key);
       logger.info( "Key up "+getKeyName(key));
    }

    public static void type(String text) throws DriverException {
        if (screen.type(text) == 1) {
           logger.info("typed text: " + getKeyName(text));
            CommonFuncs.Wait(1);
        }
        else {
            Logs.caseError("Failed to type text:"+text);
            throw new DriverException("Failed to type text:"+text);
        }
    }

    public static void paste(String text) throws DriverException {
            if (screen.paste(text) == 1) {
                Logs.getCaseLogger().WriteLog("typed text:" + getKeyName(text));
                CommonFuncs.Wait(1);
            }
            else {
                Logs.caseError("Failed to paste text:"+text);
                throw new DriverException("Failed to paste text:"+text);
            }
    }

    public static void paste(String img, String text) throws DriverException {
            try {
                if (screen.paste(img, text) ==1) {
                   logger.info("Paste text:" + text + ", on image:"+img);
                    CommonFuncs.Wait(3);
                }
            }
            catch (FindFailed e) {
                Logs.caseError("Failed to paste text:"+text+", on image:"+img+ ", exception:"+e.getMessage());
                throw new DriverException("Failed to paste text:"+text+" on image:"+img+", exception:"+e.getMessage());
            }

    }



    public static Region find(String target) throws DriverException {
        Region region = null;
        try {
            region = screen.find(target);
           logger.info("Find GUI element:" + target);
            return region;
        }
        catch (FindFailed e) {
            Logs.caseError( "Failed to find GUI element:"+target+", exception:"+e.getMessage());
            throw new DriverException("Failed to find GUI element:"+target+", exception:"+e.getMessage());
        }

    }

    public static Region findAbove(String baseImg, String targetImg) throws DriverException {
            try {
                Region region = screen.find(baseImg);
               logger.info("find base GUI element:" + baseImg);
                try {
                    Region region2 = region.above().find(targetImg);
                   logger.info("find above GUI element:"+targetImg);
                    return region2;
                }
                catch (FindFailed e) {
                    Logs.caseError( "Failed to find above GUI element:"+targetImg+", exception:"+e.getMessage());
                    throw new DriverException("Failed to find above GUI element:"+targetImg+", exception:"+e.getMessage());
                }
            }
            catch (FindFailed e) {
                Logs.caseError( "Failed to find base GUI element:"+baseImg+", exception:"+e.getMessage());
                throw new DriverException("Failed to find base GUI element:"+targetImg+", exception:"+e.getMessage());
            }
    }
    
   public static Region findBelow(String baseImg, String targetImg) throws DriverException {
           try {
               Region region = screen.find(baseImg);
              logger.info("Find base GUI element:" + baseImg);
               try {
                   Region region2 = region.below().find(targetImg);
                  logger.info("Find below GUI element:"+targetImg);
                   return region2;
               }
               catch (FindFailed e) {
                   Logs.caseError( "Failed to find below GUI element:"+targetImg+", exception:"+e.getMessage()); 
                   throw new DriverException("Failed to find below GUI element:"+targetImg+", exception:"+e.getMessage());
               }
           }
           catch (FindFailed e) {
               Logs.caseError( "Failed to find base GUI element:"+baseImg+", exception:"+e.getMessage());
               throw new DriverException("Failed to find below GUI element:"+targetImg+", exception:"+e.getMessage());
           }
    }
    
    public static Iterator<Match> findAll(String img) throws DriverException {
       try {
           return screen.findAll(img);
       }
       catch (FindFailed e) {
           Logs.caseError("Failed to find all GUI element match:"+img+", exception:"+e.getMessage());
           throw new DriverException("Failed to find all GUI element match:"+img+", exception:"+e.getMessage());
       }

    }
    
    
    public static int findAllNum(String img) throws DriverException {
        try {
            Iterator<Match> matches = screen.findAll(img);
            int num = 0;
            while(matches != null && matches.hasNext()){
                num ++;
                matches.next();
            }
            return num;
        }
        catch(FindFailed e) {
            Logs.caseError("Failed to get the GUI element number match:"+img+", exception:"+e.getMessage());
            throw new DriverException("Failed to get the GUI element number match:"+img+", exception:"+e.getMessage());
        }
        
     }
   
    
    public static void click()  {
           screen.click();
          logger.info("Click on screen");
    }

    public static void click(String img) throws DriverException {
            try {
                screen.click(img, 0);
               logger.info("Click GUI element:" + img +" successfully");
            }
            catch (FindFailed e) {
                Logs.caseError("Failed to click GUI element:"+img+", exception:"+ e.getMessage());
                throw new DriverException("Failed to click GUI element:"+img+", exception:"+ e.getMessage());
            }
    }

    public static void doubleClick(String img) throws DriverException {
            try {
                screen.doubleClick(img);
               logger.info("Double click GUI element:"+img);

            }
            catch (FindFailed e) {
                Logs.caseError("Failed to double click GUI element:"+img+ ", exception:"+ e.getMessage());
                throw new DriverException("Failed to double click GUI element:"+img+ ", exception:"+ e.getMessage());
            }

    }

    public static void doubleClick() {
            screen.doubleClick();
           logger.info("Double click on the screen");
    }

    public static void rightClick(String img) throws DriverException {
        try {
            screen.click(img, 0);
            screen.rightClick();
           logger.info("Right click GUI element:" + img);
            CommonFuncs.Wait(1);  
        }
        catch (FindFailed e) {
            Logs.caseError("Failed to right click GUI element:"+img+", exception:"+e.getMessage());
            throw new DriverException("Failed to right click GUI element:"+img+", exception:"+e.getMessage());
        }
        
    }


    public static void clickLeftOf(String img1, String img2) throws DriverException {
        try {
            screen.find(img1).left().find(img2).click();
           logger.info("Click GUI element:" + img2 + " which is left of GUI element:" + img1 + " successfully");
        }
        catch (FindFailed e) {
            Logs.caseError("Failed to click GUI element:" + img2 + " which is left of GUI element:" + img1 + " ,exception:"+e.getMessage());
            throw new DriverException("Failed to click GUI element:" + img2 + " which is left of GUI element:" + img1 + " ,exception:"+e.getMessage());
        }
    }

    public static void clickRightOf(String img1, String img2) throws DriverException {
        try {
            screen.find(img1).right().find(img2).click();
           logger.info("Click GUI element:" + img2 + " which is right of GUI element:" + img1+" successfully");
        }
        catch (FindFailed e) {
            Logs.caseError("Failed to lick GUI element:" + img2 + " which is right of GUI element:" + img1+" ,exception:"+e.getMessage() );
            throw new DriverException("Failed to lick GUI element:" + img2 + " which is right of GUI element:" + img1+" ,exception:"+e.getMessage());
        }
    }

    public static void clickAboveOf(String baseImg, String targetImg) throws DriverException {
        try {
            screen.find(baseImg).above().find(targetImg).click();
           logger.info("Click GUI element:" + targetImg + " which is above of GUI element:" + baseImg+" successfully");
        }
        catch (FindFailed e) {
            Logs.caseError("Failed to click GUI element:" + targetImg + " which is above of GUI element:" + baseImg+" ,exception:"+e.getMessage());
            throw new DriverException("Failed to click GUI element:" + targetImg + " which is above of GUI element:" + baseImg+" ,exception:"+e.getMessage());
        }
    }

    public static void clickBelowOf(String baseImg, String targetImg) throws DriverException {
        try {
            screen.find(baseImg).below().find(targetImg).click();
           logger.info("Click GUI element:" + targetImg + " which is below of GUI element:"+ baseImg+ " successfully");

        }
        catch (FindFailed e) {
            Logs.caseError("Failed to click GUI element:" + targetImg + " which is below of GUI element:"+ baseImg+ " ,exception:"+e.getMessage());
            throw new DriverException("Failed to click GUI element:" + targetImg + " which is below of GUI element:"+ baseImg+ " ,exception:"+e.getMessage());
        }
    }

    public static boolean exists(String img) {
        if (screen.exists(img) != null) {
           logger.info("GUI elment:"+img + " exists");
            return true;
        }
        else {
           logger.info("GUI element:"+img + " does not exist");
            return false;
        }
    }


    public static boolean exists(String img, float similarity) {
        Pattern pattern = new Pattern(img);
        pattern.similar(similarity);
        if (screen.exists(pattern) != null) {
           logger.info(":GUI element:"+img + " exists");
            return true;
        }
        else {
           logger.info("GUI element:"+img + " does not exist");
            return false;
        }
    }

    public static boolean verify(String img) {
        if (screen.exists(img) != null) {
           logger.info("GUI element:"+img + " exists");
            return true;
        }
        else {
           logger.info("GUI element:"+img + " does not exist");
            return false;
        }
    }

    public static boolean verify(String img, double d) {
        if (screen.exists(img, d) != null) {
           logger.info("GUI element:"+img + " exists");
            return true;
        }
        else {
           logger.info("GUI element:"+img + " does not exist");
            return false;
        }
    }

    public static void typeDupKeys(String key, int times) throws DriverException {
            int i;
            for (i = 0; i < times; i++) {
                if (screen.type(key) != 1) {
                    Logs.caseError("Failed to type key:"+getKeyName(key)+" the "+Integer.toString(i+1)+" times");
                    throw new DriverException("Failed to type key:"+getKeyName(key)+" the "+Integer.toString(i+1)+" times");
                }
            }

           logger.info("Type" +getKeyName(key) + " " + Integer.toString(times) + " times successfully");

    }

    public static void waitFor(String img, int seconds) throws DriverException {
            try {
                screen.wait(img, seconds);
               logger.info("Wait for GUI element:"+img+" "+seconds+" seconds sucessfully");

            }
            catch (FindFailed e) {
                Logs.caseError("Failed to wait for GUI element:"+img+" "+seconds+" seconds ,exception:"+e.getMessage());
                throw new DriverException("Failed to wait for GUI element:"+img+" "+seconds+" seconds ,exception:"+e.getMessage());
            }
    }

    public static void waitForText(String text, int seconds) throws DriverException {
            try {
                screen.wait(text, seconds);
               logger.info("Wait for text:"+text+" Sucessfully");
            }
            catch (FindFailed e) {
                Logs.caseError("Failed to wait for text:"+text+" ,exception:"+e.getMessage());
                throw new DriverException("Failed to wait for text:"+text+" ,exception:"+e.getMessage());
            }
    }

    public static void waitVanish(String img, int seconds) throws DriverException {
            if (screen.waitVanish(img, seconds)) {
               logger.info("Waited for" + img + "vanish in "+ Integer.toString(seconds) + " seconds");
            }
            else {
               logger.info("Failed to waited for" + img + "vanish in "+ Integer.toString(seconds) + " seconds");
                throw new DriverException("Failed to waited for" + img + "vanish in "+ Integer.toString(seconds) + " seconds");
            }
    }


    public static void type(String text, int key) throws DriverException {
            if (screen.type(text, key) ==1) {
               logger.info( "Type text:"+text);
                CommonFuncs.Wait(3);
            }
            else {
                Logs.caseError("Failed to type text:"+text);
                throw new DriverException("Failed to type text:"+text);
            }
    }



    public static void type(String img, String text) throws DriverException {

            if (screen.type(img, text) ==1) {
               logger.info( "Type text:"+text+" on image:"+img);
                CommonFuncs.Wait(3);
            }
            else {
                Logs.caseError("Failed to type text:"+text+" on image:"+img);
                throw new DriverException("Failed to type text:"+text+" on image:"+img);
            }

    }

    public static void dragDrop(String img1, String img2) throws DriverException {
        try {
            screen.dragDrop(img1, img2);
           logger.info("Drag and drop from GUI element:"+img1+" to GUI element:"+img2);
            CommonFuncs.Wait(3);
        }
        catch (FindFailed e){
            Logs.caseError("Failed to drag and drop from GUI element:"+img1+" to GUI element:"+img2);
            throw new DriverException("Failed to drag and drop from GUI element:"+img1+" to GUI element:"+img2);
        }
    }




    public static void clickPattern(Pattern pattern) throws DriverException {
            try {
                screen.click(pattern);
               logger.info("Click pattern:"+pattern.toString());
            }
            catch (FindFailed e) {
                Logs.caseError("Failed to click pattern:"+pattern.toString()+" ,exception:"+e.getMessage());
                throw new DriverException("Failed to click pattern:"+pattern.toString()+" ,exception:"+e.getMessage());
            }
    }

    public static void clickPattern(String img, double similarity, int offset1,
                    int offset2) throws DriverException {

        Pattern imagePattern = new Pattern(img);
        imagePattern = imagePattern.similar((float) similarity).targetOffset(offset1,
                        offset2);
        try {
            screen.click(imagePattern);
           logger.info("Click pattern:"+imagePattern.toString());
        }
        catch (FindFailed e) {
            Logs.caseError("Failed to click pattern:"+imagePattern.toString()+" ,exception:"+e.getMessage());
            throw new DriverException("Failed to click pattern:"+imagePattern.toString()+" ,exception:"+e.getMessage());
        }

    }

    public static void doubleClickPattern(Pattern pattern)  throws DriverException {
            try {
                screen.doubleClick(pattern);
               logger.info("Double click pattern:"+pattern.toString());
            }
            catch (FindFailed e) {
                Logs.caseError("Failed to double click pattern:"+pattern.toString()+" ,exception:"+e.getMessage());
                throw new DriverException("Failed to double click pattern:"+pattern.toString()+" ,exception:"+e.getMessage());
            }
    }

    public static void doubleClickPattern(String img, double similarity, int offset1,
                    int offset2)  throws DriverException {
        Pattern imagePattern = new Pattern(img);
        imagePattern = imagePattern.similar((float) similarity).targetOffset(offset1,
                        offset2);
        try {
            screen.click(imagePattern);
           logger.info("Click pattern:"+imagePattern.toString());
        }
        catch (FindFailed e) {
            Logs.caseError("Failed to click pattern:"+imagePattern.toString()+" ,exception:"+e.getMessage());
            throw new DriverException("Failed to click pattern:"+imagePattern.toString()+" ,exception:"+e.getMessage());
        }
    }

    public static void hoverOn(String img) throws DriverException {
            try {
                if (screen.hover(img) == 1) {
                   logger.info("Hovering on the GUI element:"+img);
                }
            }
            catch (FindFailed e) {
                Logs.caseError("Failed to hovering on GUI element:"+img+" ,exception:"+e.getMessage());
                throw new DriverException("Failed to hovering on GUI element:"+img+" ,exception:"+e.getMessage());
            }

    }

    private static String getKeyName(String key)  {
        String keyName;
        switch (key) {
            case Key.ADD :
                keyName = "ADD";
                break;
            case Key.ALT :
                keyName = "ALT";
                break;
            case Key.BACKSPACE :
                keyName = "BACKSPACE";
                break;
            case Key.CAPS_LOCK :
                keyName = "CAPS_LOCK";
                break;
            case Key.CTRL :
                keyName = "CTRL" ;
                break;
            case Key.DELETE :
                keyName = "DELETE";
                break;
            case Key.DOWN :
                keyName = "DOWN";
                break;
            case Key.END :
                keyName = "END";
                break;
            case Key.ENTER :
                keyName = "ENTER";
                break;
            case Key.ESC :
                keyName = "ESC";
                break;
            case Key.HOME :
                keyName = "HOME";
                break;
            case Key.INSERT :
                keyName = "INSERT";
                break;
            case Key.LEFT:
                keyName = "LEFT";
                break;
            case Key.RIGHT :
                keyName = "RIGHT";
                break;
            case Key.SHIFT :
                keyName = "SHIFT";
                break;
            case Key.SPACE :
                keyName = "SPACE";
                break;
            case Key.UP :
                keyName = "UP";
                break;
            case Key.WIN :
                keyName = "WIN";
                break;
            default:
                keyName = key;
        }
        return keyName;
    }

}
