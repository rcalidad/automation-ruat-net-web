package main.tasks.actividadesEconomicas.commonAEC;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.Log;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
import main.ui.actividadesEconomicasUI.commonUI.NotificationsUI;
import org.openqa.selenium.WebDriver;

public class Notification {
    public static void continueNow(WebDriver driver, ExtentTest extentTest){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, Messages.notification);
        Log.recordInLog(Messages.notification);
        Click.on(driver, NotificationsUI.btnContinuar);
    }
}
