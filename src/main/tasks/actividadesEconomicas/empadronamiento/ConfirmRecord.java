package main.tasks.actividadesEconomicas.empadronamiento;

import main.actions.Click;
import main.actions.Scroll;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ConfirmRecordUI;
import org.openqa.selenium.WebDriver;

public class ConfirmRecord {
    public static void withoutObservations(WebDriver driver){
        Scroll.toEndPage(driver);
        Click.on(driver, ConfirmRecordUI.btnAceptar);
    }
}
