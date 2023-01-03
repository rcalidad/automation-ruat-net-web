package main.tasks.actividadesEconomicas.condonacionLeyMunicipal;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.condonacionLeyMunicipalUI.AnnulCondonacionUI;
import org.openqa.selenium.WebDriver;

public class AnnulCondonacion {
    public static void now(WebDriver driver, String observation){
        Clear.on(driver, AnnulCondonacionUI.txtObservaciones, 1);
        Enter.text(driver, AnnulCondonacionUI.txtObservaciones, observation);
        Click.on(driver, AnnulCondonacionUI.btnRegistrar);
        if (VerifyAlert.containsThisText(driver, "Confirma", 15)){
            VerifyAlert.containsThisText(driver, "correctamente");
        }
    }
}
