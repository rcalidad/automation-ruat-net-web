package main.tasks.cobro.cobrosInmuebles;

import main.actions.*;
import main.ui.cobroUI.pagarInmuebleUI.SearchInmuebleUI;
import org.openqa.selenium.WebDriver;

public class SearchInmueble {
    public static void enterIdentifier(WebDriver driver, String identifier){
        WaitUntilElement.isElementVisible(driver, SearchInmuebleUI.txtIdentificador);
        Clear.on(driver, SearchInmuebleUI.txtIdentificador, 1);
        Enter.text(driver, SearchInmuebleUI.txtIdentificador, identifier);
    }
    public static void forNumeroInmueble(WebDriver driver, String identifier, String town){
        enterIdentifier(driver, identifier);
        Click.on(driver, SearchInmuebleUI.rbtNumeroInmueble);
        SelectOption.byText(driver, SearchInmuebleUI.lstGobiernoMunicipal, town);
        Click.on(driver, SearchInmuebleUI.btnBuscar);
        Log.recordInLog("Buscando deudas del inmueble " + identifier);
    }
}
