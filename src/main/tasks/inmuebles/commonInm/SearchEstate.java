package main.tasks.inmuebles.commonInm;

import main.actions.Click;
import main.actions.Enter;
import main.ui.inmueblesUI.commonUI.BusquedaInmuebleUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchEstate {
    public static void byNumeroInmueble(WebDriver driver, String estateNum){
        search(driver, BusquedaInmuebleUI.rbtNumeroInmueble, estateNum);
    }
    public static void byCodigoCatastral(WebDriver driver, String estateNum){
        search(driver, BusquedaInmuebleUI.rbtCodigoCatastral, estateNum);
    }
    public static void search(WebDriver driver, By locator, String estateNum){
        Enter.text(driver, BusquedaInmuebleUI.txtIdentificador, estateNum);
        Click.on(driver, locator);
        Click.on(driver, BusquedaInmuebleUI.btnBuscar);
    }

}
