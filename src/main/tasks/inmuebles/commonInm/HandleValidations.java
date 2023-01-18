package main.tasks.inmuebles.commonInm;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.Click;
import main.actions.GetText;
import main.actions.IsDisplayed;
import main.helpers.dataUtility.ScreenShotHelper;
import main.ui.inmueblesUI.commonUI.ValidacionesUI;
import org.openqa.selenium.WebDriver;

public class HandleValidations {
    public static void takeScreenshot(WebDriver driver, ExtentTest extentTest){
        String message = GetText.of(driver, ValidacionesUI.msgValidacion);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, message);
    }
    public static void returnBeforeStep(WebDriver driver){
        if (IsDisplayed.element(driver, ValidacionesUI.lnkAnterior)){
            Click.on(driver, ValidacionesUI.lnkAnterior);
        }
    }
}
