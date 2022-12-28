package main.tasks.actividadesEconomicas.empadronamiento;

import main.actions.Click;
import main.ui.actividadesEconomicasUI.empadronamientoUI.AdditionalInformationUI;
import org.openqa.selenium.WebDriver;

public class AdditionalInformation {
    public static void emptyRecord(WebDriver driver){
        Click.on(driver, AdditionalInformationUI.btnAceptar);
    }
}
