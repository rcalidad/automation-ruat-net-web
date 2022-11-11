package main.tasks.vehiculos.modificarDatosTecnicosOperador;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.vehiculos.commonVeh.ModificationOption;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.modificarDatosTecnicosOperadorUI.SeleccionarModificacionUI;
import org.openqa.selenium.WebDriver;

public class SeleccionarModificacion {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        //return Verify.isReady(driver, extentTest, RegistrarTarjetaOperacionUI.ttlRegistrarTarjetaOperacion);
        return Verify.isReady(driver, extentTest,SeleccionarModificacionUI.ttlSeleccionarModificacion);
        /*
        String message;
        WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
        if(WaitUntilAlert.isPresent(driver, 1)){
            message = DisplayAlert.getText(driver);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.INFO, message);
            Log.recordInLog(message);
            return false;
        }else if (WaitUntilElement.isElementVisible(driver, SeleccionarModificacionUI.ttlSeleccionarModificacion, 1)){
            Log.recordInLog("Seleccionando modificación...");
            return true;
        }else{
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "El vehículo no pasó las validaciones necesarias.");
            Log.recordInLog("El vehículo no pasó las validaciones necesarias.");
            return false;
        }*/
    }
    public static void option(WebDriver driver, String modificationOption){
        Click.on(driver, ModificationOption.modificationOption.get(modificationOption));
    }
}
