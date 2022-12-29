package main.tasks.actividadesEconomicas.multasAdministrativasPatentes;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.actions.SelectOption;
import main.tasks.actividadesEconomicas.commonAEC.SetPenaltyAmount;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.ModifyPenaltyUI;
import org.openqa.selenium.WebDriver;

public class ModifyPenalty {
    public static void withDefaultData(WebDriver driver, String amount){
        SelectOption.firstOptionDifferentOfEmpty(driver, ModifyPenaltyUI.lstMotivo);
        SetPenaltyAmount.with(driver, amount, ModifyPenaltyUI.sanctionTable);
        Clear.on(driver, ModifyPenaltyUI.txtObservaciones, 1);
        Enter.text(driver, ModifyPenaltyUI.txtObservaciones, "Observado");
        Click.on(driver, ModifyPenaltyUI.btnRegistrar);
        if (VerifyAlert.containsThisText(driver, "seguro")){
            VerifyAlert.containsThisText(driver, "correctamente");
        }
    }
}
