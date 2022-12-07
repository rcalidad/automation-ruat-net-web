package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.commonUI.ReceiveDocumentationUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
        //return WaitUntilElement.isElementVisible(driver, ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
    }
    public static void toModifyTechnicalData(WebDriver driver){
        Log.recordInLog("Proceso de recibir documentación...");
        Click.on(driver, ReceiveDocumentationUI.chkCrpva);
        Click.on(driver, ReceiveDocumentationUI.chkDocumentoIdentidad);
        SelectOption.firstOption(driver, ReceiveDocumentationUI.lstGestorTramite);
        Click.on(driver, ReceiveDocumentationUI.btnGrabar);
        WaitUntilAlert.isPresent(driver);
        DisplayAlert.toAcept(driver);
    }
    public static void toModifyDataBySupervisor(WebDriver driver){
        Log.recordInLog("Proceso de recibir documentación...");
        Click.on(driver, ReceiveDocumentationUI.chkSolicitudCorreccionDatos);
        SelectOption.firstOption(driver, ReceiveDocumentationUI.lstGestorTramite);
        Click.on(driver, ReceiveDocumentationUI.btnGrabar);
        if(WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            Log.recordInLog(message);
            DisplayAlert.toAcept(driver);
        }
    }
    public static void toTransfer(WebDriver driver){
        Log.recordInLog("Proceso de recibir documentación...");
        Click.on(driver, ReceiveDocumentationUI.chkCrpva);
        Click.on(driver, ReceiveDocumentationUI.chkMinutaCompraVenta);
        Click.on(driver, ReceiveDocumentationUI.chkDocumentoIdentidadComprador);
        Click.on(driver, ReceiveDocumentationUI.btnGrabar);
        if(WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            Log.recordInLog(message);
            DisplayAlert.toAcept(driver);
        }
    }
    public static void toTaxBases(WebDriver driver){
        Log.recordInLog("Proceso de recibir documentación...");
        Click.on(driver, ReceiveDocumentationUI.chkDocumentoDeIdentidad);
        Click.on(driver, ReceiveDocumentationUI.btnGrabar);
        if(WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            Log.recordInLog("Recibir documentación:" + message);
            DisplayAlert.toAcept(driver);
        }
        WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
    }
}
