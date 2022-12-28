package main.tasks.actividadesEconomicas.empadronamiento;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.ui.actividadesEconomicasUI.empadronamientoUI.DataActividadEconomicaUI;
import org.openqa.selenium.WebDriver;

public class DataActividadEconomica {
    public static void load(WebDriver driver, String businessName){
        Clear.on(driver, DataActividadEconomicaUI.txtRazonSocial, 1);
        Enter.text(driver, DataActividadEconomicaUI.txtRazonSocial, businessName);
        Click.on(driver, DataActividadEconomicaUI.btnAceptar);
    }
}
