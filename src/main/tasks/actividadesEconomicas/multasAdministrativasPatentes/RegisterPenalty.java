package main.tasks.actividadesEconomicas.multasAdministrativasPatentes;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.actions.SelectOption;
import main.helpers.common.DateUtility;
import main.tasks.actividadesEconomicas.commonAEC.SetPenaltyAmount;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.multasAdministrativasPatentesUI.RegisterPenaltyUI;
import org.openqa.selenium.WebDriver;

public class RegisterPenalty {
    public static void withDefaultData(WebDriver driver, String amount, String date){
        Clear.on(driver, RegisterPenaltyUI.txtNumeroDocumento, 1);
        Enter.text(driver, RegisterPenaltyUI.txtNumeroDocumento, "123");
        Clear.on(driver, RegisterPenaltyUI.txtFechaDocumento, 1);
        Enter.text(driver, RegisterPenaltyUI.txtFechaDocumento, date);
        Clear.on(driver, RegisterPenaltyUI.txtAutorizadoPor, 1);
        Enter.text(driver, RegisterPenaltyUI.txtAutorizadoPor, "Juan Topo");
        Clear.on(driver, RegisterPenaltyUI.txtCargo, 1);
        Enter.text(driver, RegisterPenaltyUI.txtCargo, "El Jefe");
        SelectOption.firstOptionDifferentOfEmpty(driver, RegisterPenaltyUI.lstMotivo);
        SetPenaltyAmount.with(driver, amount, RegisterPenaltyUI.sanctionTable);
        Click.on(driver, RegisterPenaltyUI.btnRegistrar);
        if (VerifyAlert.containsThisText(driver, "seguro")){
            VerifyAlert.containsThisText(driver, "correctamente");
        }

    }
}
