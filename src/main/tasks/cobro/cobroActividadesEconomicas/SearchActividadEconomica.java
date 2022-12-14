package main.tasks.cobro.cobroActividadesEconomicas;

import main.actions.*;
import main.ui.cobroUI.pagarActividadesEconomicasUI.SearchActividadesEconomicasUI;
import main.ui.cobroUI.pagarInmuebleUI.SearchInmuebleUI;
import org.openqa.selenium.WebDriver;

public class SearchActividadEconomica {

    public static void enterIdentifier(WebDriver driver, String identifier){
        WaitUntilElement.isElementVisible(driver, SearchActividadesEconomicasUI.txtIdentificador);
        Clear.on(driver, SearchActividadesEconomicasUI.txtIdentificador, 1);
        Enter.text(driver, SearchActividadesEconomicasUI.txtIdentificador, identifier);
    }
    public static void forLicencia(WebDriver driver, String identifier, String town){
        enterIdentifier(driver, identifier);
        Click.on(driver, SearchActividadesEconomicasUI.rbtLicencia);
        SelectOption.byText(driver, SearchActividadesEconomicasUI.lstGobiernoMunicipal, town);
        Click.on(driver, SearchActividadesEconomicasUI.btnBuscar);
        Log.recordInLog("Buscando deudas de la actividad economica " + identifier);
    }
    public static void forNumeroActividad(WebDriver driver, String identifier, String town){
        enterIdentifier(driver, identifier);
        Click.on(driver, SearchActividadesEconomicasUI.rbtNumeroActividad);
        SelectOption.byText(driver, SearchActividadesEconomicasUI.lstGobiernoMunicipal, town);
        Click.on(driver, SearchActividadesEconomicasUI.btnBuscar);
        Log.recordInLog("Buscando deudas de la actividad economica " + identifier);
    }
}
