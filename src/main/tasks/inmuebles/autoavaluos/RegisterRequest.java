package main.tasks.inmuebles.autoavaluos;

import main.actions.*;
import main.helpers.common.DateUtility;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.autoavaluosUI.RegistrarSolicitudUI;
import org.openqa.selenium.WebDriver;

public class RegisterRequest {
    public static void withDefaultData(WebDriver driver, String date){
        Scroll.toElement(driver, RegistrarSolicitudUI.lstOrigenSolicitud);
        SelectOption.nonEmptyRandomValue(driver, RegistrarSolicitudUI.lstOrigenSolicitud);
        WaitUntilElement.isElementVisible(driver, RegistrarSolicitudUI.txtFecha);
        Enter.text(driver, RegistrarSolicitudUI.txtFecha, date);
        Enter.text(driver, RegistrarSolicitudUI.txtNumeroDocumento, MessagesINM.testText);
        Enter.text(driver, RegistrarSolicitudUI.txtAutorizadoPor, MessagesINM.defaultName);
        Enter.text(driver, RegistrarSolicitudUI.txtCargo, MessagesINM.defaultPosition);
        Enter.text(driver, RegistrarSolicitudUI.txtObservaciones, MessagesINM.testText);
        Scroll.toEndPage(driver);
        Click.on(driver, RegistrarSolicitudUI.btnAceptar);
    }
}
