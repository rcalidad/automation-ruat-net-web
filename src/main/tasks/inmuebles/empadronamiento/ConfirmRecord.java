package main.tasks.inmuebles.empadronamiento;

import main.actions.Click;
import main.actions.Scroll;
import main.ui.inmueblesUI.empadronamientoUI.ConfirmarRegistroUI;
import org.openqa.selenium.WebDriver;

public class ConfirmRecord {
    public static void now(WebDriver driver){
        Scroll.toEndPage(driver);
        Click.on(driver, ConfirmarRegistroUI.btnAceptar);

    }
}
