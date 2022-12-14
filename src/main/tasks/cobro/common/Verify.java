package main.tasks.cobro.common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.ui.cobroUI.commonUI.CommonElementsUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest, By controlLocator){
        String message;
        if (WaitUntilAlert.isPresent(driver, 1)){
            message = DisplayAlert.getText(driver);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
            DisplayAlert.toAcept(driver);
            Log.recordInLog(message);
            return false;
        }else {
            Log.recordInLog("Sin alertas, esperando respuesta...");
            if (WaitUntilElement.isElementVisible(driver, controlLocator)){
                Log.recordInLog("Cargando el siguiente paso...");
                return true;
            }else {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "Existen validaciones no superadas...");
                Log.recordInLog("Existen validaciones no superadas...");
                return false;
            }
        }
    }
    public static boolean isReady(WebDriver driver, ExtentTest extentTest, By controlLocator, int waitTime){
        String message;
        if (WaitUntilAlert.isPresent(driver, 1)){
            message = DisplayAlert.getText(driver);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
            DisplayAlert.toAcept(driver);
            Log.recordInLog(message);
            return false;
        }else {
            Log.recordInLog("Sin alertas, esperando respuesta...");
            if(IsDisplayed.element(driver, CommonElementsUI.imgEnProgreso)){
                WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso, waitTime);
            }
            if (WaitUntilElement.isElementVisible(driver, controlLocator, 2)){
                Log.recordInLog("Cargando el siguiente paso...");
                return true;
            }else {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "Existen validaciones no superadas...");
                Log.recordInLog("Existen validaciones no superadas...");
                return false;
            }
        }
    }
}
