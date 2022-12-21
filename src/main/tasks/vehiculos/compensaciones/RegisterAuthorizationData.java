package main.tasks.vehiculos.compensaciones;

import main.actions.Click;
import main.actions.Enter;
import main.ui.vehiculosUI.compensacionesUI.DatosAutorizacionUI;
import org.openqa.selenium.WebDriver;

public class RegisterAuthorizationData {
    public static void now(WebDriver driver, String docNum, String docDate, String nameAuthorizer, String position,String observation){
        Enter.text(driver, DatosAutorizacionUI.txtNumeroDocumento, docNum);
        Enter.dateByElementId(driver, DatosAutorizacionUI.txtFechaDocumento, docDate);
        Enter.text(driver, DatosAutorizacionUI.txtAutorizadoPor, nameAuthorizer);
        Enter.text(driver, DatosAutorizacionUI.txtCargo, position);
        Enter.text(driver, DatosAutorizacionUI.txtObservaciones, observation);
        Click.on(driver, DatosAutorizacionUI.btnAceptar);
    }
}
