package main.tasks.actividadesEconomicas.empadronamiento;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.actions.SelectOption;
import main.ui.actividadesEconomicasUI.empadronamientoUI.TechnicalDataUI;
import org.openqa.selenium.WebDriver;

public class TechnicalData {
    public static void load(WebDriver driver, String taxZone, String superficie, String rubro, String subRubro, String tipoActividad){
        SelectOption.byText(driver, TechnicalDataUI.lstZonaTributaria, taxZone);
        Clear.on(driver, TechnicalDataUI.txtSuperficie, 1);
        Enter.text(driver, TechnicalDataUI.txtSuperficie, superficie);
        SelectOption.byText(driver, TechnicalDataUI.lstRubro, rubro);
        SelectOption.waitUntilLoadOptions(driver, TechnicalDataUI.lstSubRubro);
        SelectOption.byText(driver, TechnicalDataUI.lstSubRubro, subRubro);
        SelectOption.waitUntilLoadOptions(driver, TechnicalDataUI.lstTipoActividad);
        SelectOption.byText(driver, TechnicalDataUI.lstTipoActividad, tipoActividad);
        Click.on(driver, TechnicalDataUI.btnAceptar);
    }
}
