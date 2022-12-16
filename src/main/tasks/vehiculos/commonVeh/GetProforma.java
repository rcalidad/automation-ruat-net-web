package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.vehiculos.ConstantsVEH;
import main.helpers.dataUtility.ScreenShotHelper;
import main.helpers.fileUtility.FileBuilder;
import main.tasks.vehiculos.mainMenu.MainMenu;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.commonUI.FramesUI;
import main.ui.vehiculosUI.liquidacionUI.DeudaUI;
import main.ui.vehiculosUI.liquidacionUI.ProformaUI;
import org.openqa.selenium.WebDriver;

public class GetProforma {
    public static void detailed(WebDriver driver, ExtentTest extentTest, String pta, int index){
        MainMenu.selectOption(driver, "Proforma");
        Log.recordInLog("Entrando a proforma...");
        driver.switchTo().frame(FramesUI.frameNameMenuLateral);
        LoadModule.whichIs(driver, "Proforma Vehículo");
        Log.recordInLog("Cargando módulo Proforma");
        driver.switchTo().parentFrame();
        driver.switchTo().frame(FramesUI.frameNameContenido);
        SearchVehicle.forPTA(driver, pta);
        Log.recordInLog("Buscando PTA: " + pta);
        Log.recordInLog("Verificando si hay alertas...");
        if(WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            Log.recordInLog("Alert: " + message);
            ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.INFO, message);
            DisplayAlert.toAcept(driver);
        }
        Log.recordInLog("Verificando notificaciones...");
        WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
        if (WaitUntilElement.isElementVisible(driver, ProformaUI.btnContinuar, 3)) {
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Notificaciones");
            Log.recordInLog("Hay notificaciones (ver reporte html). Continuando con el proceso");
            Click.on(driver, ProformaUI.btnContinuar);
        }
        Scroll.toEndPage(driver);
        Log.recordInLog("deslizando la página hasta el final...");
        if(WaitUntilElement.isElementVisible(driver, DeudaUI.btnProformaDetallada)){
            Click.on(driver, DeudaUI.btnProformaDetallada);
            Log.recordInLog("Obteniendo proforma detallada");
            if(WaitUntilAlert.isPresent(driver)){
                String message = DisplayAlert.getText(driver);
                ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.INFO, message);
                DisplayAlert.toAcept(driver);
            }
        }
        try{
            Thread.sleep(2000);
        }catch (Exception exception){
            Log.recordInLog(exception.getMessage());
        }
        FileBuilder.moveAndRenameFile("enviarPDF.pdf", "TODOS", "PROFORMA-DETALLADA", pta, ConstantsVEH.ID_SUBSYSTEM, index);
        if(WaitUntilElement.isElementVisible(driver, ProformaUI.ttlNotificacion)){
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "La proforma fue generada correctamente.");
            Log.recordInLog("La proforma fue generada correctamente.");
        }
    }
}
