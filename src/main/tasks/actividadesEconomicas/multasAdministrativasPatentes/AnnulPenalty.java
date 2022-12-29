package main.tasks.actividadesEconomicas.multasAdministrativasPatentes;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.AnnulPenaltyUI;
import org.openqa.selenium.WebDriver;

public class AnnulPenalty {
    public static void withDefaultData(WebDriver driver){
        Clear.on(driver, AnnulPenaltyUI.txtObservaciones, 1);
        Enter.text(driver, AnnulPenaltyUI.txtObservaciones, "Observado");
        Click.on(driver, AnnulPenaltyUI.btnRegistrar);
        if (VerifyAlert.containsThisText(driver, "seguro")){
            VerifyAlert.containsThisText(driver, "correctamente");
        }
    }
}
