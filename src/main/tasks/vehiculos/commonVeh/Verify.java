package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.DisplayAlert;
import main.actions.Log;
import main.actions.WaitUntilAlert;
import main.actions.WaitUntilElement;
import main.helpers.dataUtility.ScreenShotHelper;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest, By controlLocator){
        String message;
        if(WaitUntilAlert.isPresent(driver, 1)){
            message = DisplayAlert.getText(driver);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.INFO, message);
            Log.recordInLog(message);
            return false;
        }else{
            WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
            if (WaitUntilElement.isElementVisible(driver, controlLocator, 1)){
                Log.recordInLog("Seleccionando servicio...");
                return true;
            }else{
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "El vehículo no pasó las validaciones necesarias.");
                Log.recordInLog("El vehículo no pasó las validaciones necesarias.");
                return false;
            }
        }
    }
}
