package main.tasks.inmuebles.empadronamiento;

import main.actions.Click;
import main.actions.SelectOption;
import main.ui.inmueblesUI.empadronamientoUI.DefinicionInmuebleUI;
import org.openqa.selenium.WebDriver;

public class EstateDefinition {
    public static void as(WebDriver driver, String area, String estateType){
        Click.on(driver, DefinicionInmuebleUI.area.get(area));
        SelectOption.waitUntilLoadOptions(driver, DefinicionInmuebleUI.lstClaseInmueble, 1);
        SelectOption.byText(driver, DefinicionInmuebleUI.lstClaseInmueble, estateType);
        Click.on(driver, DefinicionInmuebleUI.btnAceptar);
    }
    public static void asDes(WebDriver driver, String area, String estateType){
        SelectOption.waitUntilLoadOptions(driver, DefinicionInmuebleUI.lstArea, 1);
        SelectOption.byText(driver, DefinicionInmuebleUI.lstArea, area);
        SelectOption.waitUntilLoadOptions(driver, DefinicionInmuebleUI.lstClaseInmueble, 1);
        SelectOption.byText(driver, DefinicionInmuebleUI.lstClaseInmueble, estateType);
        Click.on(driver, DefinicionInmuebleUI.btnAceptar);
    }
}
