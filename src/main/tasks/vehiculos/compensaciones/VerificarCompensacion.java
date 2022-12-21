package main.tasks.vehiculos.compensaciones;

import main.actions.Click;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.vehiculosUI.compensacionesUI.VerificacionCompensacionUI;
import org.openqa.selenium.WebDriver;

public class VerificarCompensacion {
    public static void now(WebDriver driver){
        Click.on(driver, VerificacionCompensacionUI.btnCompensar);
        VerifyAlert.containsThisText(driver, "seguro");
    }
}
