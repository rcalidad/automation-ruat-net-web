package main.tasks.actividadesEconomicas.empadronamiento;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.actions.SelectOption;
import main.helpers.common.DateUtility;
import main.ui.actividadesEconomicasUI.empadronamientoUI.AuthorizationUI;
import org.openqa.selenium.WebDriver;

public class Authorization {
    public static void by(WebDriver driver, String name){
        Clear.on(driver, AuthorizationUI.txtAutorizadoPor, 1);
        Enter.text(driver, AuthorizationUI.txtAutorizadoPor, name);
        SelectOption.firstOption(driver, AuthorizationUI.lstCargo);
        Enter.dateByElementId(driver, AuthorizationUI.txtFecha, DateUtility.getCurrentDate());
        Click.on(driver, AuthorizationUI.btnAceptar);
    }
}
