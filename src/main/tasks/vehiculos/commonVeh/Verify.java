package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest, By controlLocator){
        String message;
        if(WaitUntilAlert.isPresent(driver, 1)){
            message = DisplayAlert.getText(driver);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
            DisplayAlert.toAcept(driver);
            Log.recordInLog(message);
            return false;
        }else{
            try{
                Thread.sleep(500);
            }catch (Exception e){
                Log.recordInLog("Sin alertas, esperando respuesta...");
            }
            WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
            if (WaitUntilElement.isElementVisible(driver, CommonElementsUI.btnContinuar, 3)){
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "El vehículo tiene notificaciones.");
                Log.recordInLog("El vehículo tiene notificaciones.");
                Click.on(driver, CommonElementsUI.btnContinuar);
            }
            if (WaitUntilElement.isElementVisible(driver, CommonElementsUI.ttlErrorRojo, 3)){
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.FAIL, "Hubo un error.");
                Log.recordInLog("Hubo un error.");
                return false;
            }
            if (WaitUntilElement.isElementVisible(driver, controlLocator,3)){
                Log.recordInLog("Cargando opción...");
                return true;
            }else{
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "El vehículo no pasó las validaciones necesarias.");
                Log.recordInLog("El vehículo no pasó las validaciones necesarias.");
                return false;
            }
        }
    }
    public static void isLoading(WebDriver driver, int waitTime){
        if (IsDisplayed.element(driver, CommonElementsUI.imgEnProgreso)){
            Log.recordInLog("Barra de progreso visible...");
            WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso, waitTime);
        }
    }
}
