package main.tasks.actividadesEconomicas.commonAEC;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import main.ui.actividadesEconomicasUI.commonUI.CommonElementsUI;
import main.ui.actividadesEconomicasUI.commonUI.NotificationsUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {
    public static void isReady(WebDriver driver, ExtentTest extentTest, By locatorPattern) throws Exception {
        String message;
        if (WaitUntilAlert.isPresent(driver, 1)){
            message = DisplayAlert.getText(driver);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
            DisplayAlert.toAcept(driver);
            Log.recordInLog(message);
            throw new Exception(message);
        }else {
            if (WaitUntilElement.isElementVisible(driver, CommonElementsUI.title, 360)) {
                if(IsDisplayed.element(driver, NotificationsUI.btnContinuar, 1)){
                    Notification.continueNow(driver, extentTest);
                    isReady(driver, extentTest, locatorPattern);
                }else if (!IsDisplayed.element(driver, locatorPattern, 1)) {
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, Messages.itemNotPresent);
                    Log.recordInLog(Messages.itemNotPresent);
                    throw new Exception(Messages.itemNotPresent);
                }else if(GetText.of(driver, CommonElementsUI.title).contains("ERROR")) {
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, Messages.itemNotPresent);
                    Log.recordInLog(Messages.itemNotPresent);
                    throw new Exception(Messages.itemNotPresent);
                }
            }else {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.FAIL, Messages.timeExceeded);
                Log.recordInLog(Messages.timeExceeded);
                throw new Exception(Messages.timeExceeded);
            }
        }
    }
}
