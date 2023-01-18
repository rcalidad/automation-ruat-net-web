package main.tasks.inmuebles.compensaciones;

import main.actions.Click;
import main.actions.Scroll;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.compensacionesUI.ConfirmarRegistroUI;
import org.openqa.selenium.WebDriver;

public class ConfirmRegistration {
    public static void now(WebDriver driver){
        Scroll.toEndPage(driver);
        Click.on(driver, ConfirmarRegistroUI.btnGrabar);
        VerifyAlert.containsThisText(driver, "seguro");
    }
}
