package main.tasks.cobro.cobrosVehiculos;

import main.actions.*;

import main.ui.cobroUI.pagosVehiculosUI.SearchVehicleUI;
import org.openqa.selenium.WebDriver;

public class SearchVehicle {
    private static void enterIdentifier(WebDriver driver, String identifier){
        WaitUntilElement.isVisibleElement(driver, SearchVehicleUI.txtIdentificador);
        Clear.on(driver, SearchVehicleUI.txtIdentificador, 1);
        Enter.text(driver, SearchVehicleUI.txtIdentificador, identifier);
    }
    public static void forPTA(WebDriver driver, String identifier){
        enterIdentifier(driver, identifier);
        Click.on(driver, SearchVehicleUI.rbtPlacaPta);
        Click.on(driver, SearchVehicleUI.btnBuscar);
        Log.recordInLog("Searching vehicle: " + identifier);
    }
}
