package main.tasks.vehiculos.commonVeh;

import main.actions.*;
import main.ui.vehiculosUI.commonUI.SearchVehicleUI;
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
    public static void forPoliza(WebDriver driver, String identifier){
        enterIdentifier(driver, identifier);
        Click.on(driver, SearchVehicleUI.rbtPoliza);
        Click.on(driver, SearchVehicleUI.btnBuscar);
    }
    public static void forPlacaAnterior(WebDriver driver, String identifier){
        enterIdentifier(driver, identifier);
        Click.on(driver, SearchVehicleUI.rbtPlacaAnterior);
        Click.on(driver, SearchVehicleUI.btnBuscar);
    }
    public static void forCopo(WebDriver driver, String identifier){
        enterIdentifier(driver, identifier);
        Click.on(driver, SearchVehicleUI.rbtCopo);
        Click.on(driver, SearchVehicleUI.rbtCopo);
    }
}
