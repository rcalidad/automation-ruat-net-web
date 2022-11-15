package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Scroll;
import main.ui.vehiculosUI.commonUI.ConfirmarModificacionUI;
import org.openqa.selenium.WebDriver;

public class ConfirmarModificacion {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, ConfirmarModificacionUI.ttlConfirmarModificacion);
    }
    public static void now(WebDriver driver){
        Scroll.toEndPage(driver);
        Click.on(driver, ConfirmarModificacionUI.btnAceptar);
    }
}
