package main.tasks.cobro.cobroTasasOtrosIngresos;

import main.actions.*;
import main.ui.cobroUI.pagarTasasOtrosIngresos.SearchTasasOtrosIngresosUI;
import org.openqa.selenium.WebDriver;

public class SearchTasaOtroIngreso {
    public static void enterIdentifier(WebDriver driver, String identifier){
        WaitUntilElement.isElementVisible(driver, SearchTasasOtrosIngresosUI.txtIdentificador);
        Clear.on(driver, SearchTasasOtrosIngresosUI.txtIdentificador, 1);
        Enter.text(driver, SearchTasasOtrosIngresosUI.txtIdentificador, identifier);
    }
    public static void forTasaType(WebDriver driver, String identifier, String tasaType, String town){
        enterIdentifier(driver, identifier);
        Click.on(driver, SearchTasasOtrosIngresosUI.tasaType.get(tasaType));
        SelectOption.byText(driver, SearchTasasOtrosIngresosUI.lstGobiernoMunicipal, town);
        Click.on(driver, SearchTasasOtrosIngresosUI.btnBuscar);
    }
}
