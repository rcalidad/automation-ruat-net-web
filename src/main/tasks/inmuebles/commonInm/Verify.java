package main.tasks.inmuebles.commonInm;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.CommonComponent;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.commonUI.CommonElemntsUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {
    public static void elementIsReady(WebDriver driver, ExtentTest extentTest, By locator) throws Exception {
        String message;
        verifyIfIsDisplayedProgressBar(driver);
        if (WaitUntilAlert.isPresent(driver,1)){
            message = DisplayAlert.getText(driver);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
            DisplayAlert.toAcept(driver);
            Log.recordInLog(message);
            throw new Exception(message);
        }else {
            WaitUntilElement.isElementVisible(driver, CommonElemntsUI.ttlTituloPrincipal);
            if (IsDisplayed.element(driver, locator)){
                Log.recordInLog(locator.toString() + " cargado.");
            }else {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, MessagesINM.problemWithAStep);
                throw new Exception(MessagesINM.problemWithAStep + locator.toString());
            }
        }

    }
    public static void elementsIsReady(WebDriver driver, ExtentTest extentTest, By locator, By optionalLocator) throws Exception {
        String message;
        verifyIfIsDisplayedProgressBar(driver);
        if (WaitUntilAlert.isPresent(driver,1)){
            message = DisplayAlert.getText(driver);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
            DisplayAlert.toAcept(driver);
            Log.recordInLog(message);
            throw new Exception(message);
        }else {
            WaitUntilElement.isElementVisible(driver, CommonElemntsUI.ttlTituloPrincipal);
            if (IsDisplayed.element(driver, locator, 1) || IsDisplayed.element(driver, optionalLocator, 1)){
                Log.recordInLog(locator.toString() + " cargado.");
            }else {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, MessagesINM.problemWithAStep + locator.toString());
            }
        }

    }
    public static void verifyIfIsDisplayedProgressBar(WebDriver driver){
        try {
            WaitUntilElement.isInvisibleElement(driver, CommonElemntsUI.progressBar);
        }catch (Exception exception){

        }
    }
}
