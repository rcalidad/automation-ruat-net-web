package main.tasks.actividadesEconomicas.empadronamiento;

import main.actions.*;
import main.tasks.actividadesEconomicas.helpersAEC.Messages;
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
    public static void loadWithDefaultData(WebDriver driver, String area){
        SelectOption.nonEmptyRandomValue(driver, TechnicalDataUI.lstZonaTributaria);
        Enter.text(driver, TechnicalDataUI.txtSuperficie, area);
        SelectOption.nonEmptyRandomValue(driver, TechnicalDataUI.lstRubro);
        SelectOption.waitUntilLoadOptions(driver, TechnicalDataUI.lstSubRubro);
        SelectOption.nonEmptyRandomValue(driver, TechnicalDataUI.lstSubRubro);
        if (IsDisplayed.element(driver, TechnicalDataUI.lstTipoActividad, 1)){
            SelectOption.waitUntilLoadOptions(driver, TechnicalDataUI.lstTipoActividad);
            SelectOption.nonEmptyRandomValue(driver, TechnicalDataUI.lstTipoActividad);
        }
        if (IsDisplayed.element(driver, TechnicalDataUI.lstCuenta, 1)){
            SelectOption.waitUntilLoadOptions(driver, TechnicalDataUI.lstCuenta);
            SelectOption.nonEmptyRandomValue(driver, TechnicalDataUI.lstCuenta);
        }
        if (IsDisplayed.element(driver, TechnicalDataUI.txtDescripcionActividad, 1)){
            Enter.text(driver, TechnicalDataUI.txtDescripcionActividad, Messages.description);
        }
        Click.on(driver, TechnicalDataUI.btnAceptar);
    }
}
