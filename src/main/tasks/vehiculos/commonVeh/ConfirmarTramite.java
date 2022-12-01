package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.commonUI.ConfirmarTramiteUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmarTramite {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, ConfirmarTramiteUI.ttlConfirmarTramite);
    }
    public static boolean getReport(WebDriver driver, String originalFilename, String operation, String identificador, int index, By locator){
        WaitUntilElement.isClikeableOf(driver, locator);
        Click.on(driver, locator);
        return FileBuilder.moveAndRenameFile(originalFilename, operation, GetText.ofValue(driver, locator).trim(), identificador, ConstantsVEH.ID_SUBSYSTEM, index);
    }
    public static void grabar(WebDriver driver, ExtentTest extentTest, String originalFilename, String operation, String identificador, int index){
        if (getReport(driver, originalFilename, operation, identificador, index, ConfirmarTramiteUI.btnImprimirReporte)){
            WaitUntilElement.isClikeableOf(driver, ConfirmarTramiteUI.btnGrabar);
            Click.on(driver, ConfirmarTramiteUI.btnGrabar);
            if (WaitUntilAlert.isPresent(driver)){
                String message = DisplayAlert.getText(driver);
                if (message.contains("correctamente")){
                    ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.PASS, message);
                    Log.recordInLog(message);
                }else {
                    ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, "No se pudo consolidar los datos...");
                    Log.recordInLog("No se pudo consolidar los datos...");
                }
                DisplayAlert.toAcept(driver);
                if (getReport(driver, originalFilename, operation, identificador, index, ConfirmarTramiteUI.btnImprimirProforma)){
                    Click.on(driver, ConfirmarTramiteUI.btnSalir);
                }
            }else {
                if (WaitUntilElement.isElementVisible(driver, CommonElementsUI.ttlErrorRojo, 5)){
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "Error rojo");
                    Log.recordInLog("Error rojo...");
                }else{
                    ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "No se puedo grabar el tramite");
                    Log.recordInLog("No se pudo grabar el trámite...");
                }
            }
        }else {
            if (WaitUntilElement.isElementVisible(driver, CommonElementsUI.ttlErrorRojo, 5)) {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "Error rojo");
                Log.recordInLog("Error rojo...");
            } else {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "No se puedo grabar el tramite");
                Log.recordInLog("No se pudo grabar el trámite...");
            }
        }
    }
}
