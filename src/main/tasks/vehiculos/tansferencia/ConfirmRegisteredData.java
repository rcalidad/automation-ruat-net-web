package main.tasks.vehiculos.tansferencia;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.WaitUntilElement;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.transferenciaUI.ConfirmarDatosRegistradosUI;
import org.openqa.selenium.WebDriver;

public class ConfirmRegisteredData {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, ConfirmarDatosRegistradosUI.ttlConfirmarDatosRegistrados);
    }
    public static void now(WebDriver driver){
        Click.on(driver, ConfirmarDatosRegistradosUI.btnAceptar);
        WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
    }
}
