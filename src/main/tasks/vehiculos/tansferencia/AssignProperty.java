package main.tasks.vehiculos.tansferencia;

import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.transferenciaUI.AsignarPropiedadUI;
import org.openqa.selenium.WebDriver;

public class AssignProperty {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, AsignarPropiedadUI.ttlAsignarPropiedad);
    }
    public static void to(WebDriver driver, String documentNumber, String documentType){
        Log.recordInLog("Iniciando la asignación de propiedad.");
        Enter.text(driver, AsignarPropiedadUI.txtDocumento, documentNumber);
        SelectOption.byText(driver, AsignarPropiedadUI.lstTipoDocumento, documentType);
        Click.on(driver, AsignarPropiedadUI.btnBuscar);
        WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
        if (WaitUntilElement.isElementVisible(driver, AsignarPropiedadUI.btnAceptar)){
            Click.on(driver, AsignarPropiedadUI.btnAceptar);
        }
    }
}
