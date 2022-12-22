package main.tasks.actividadesEconomicas.commonAEC;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.ui.actividadesEconomicasUI.commonUI.SearchActivityUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchActivity {
    public static void search(WebDriver driver, String identifier, By locator){
        Clear.on(driver, SearchActivityUI.txtIdentificador, 1);
        Enter.text(driver, SearchActivityUI.txtIdentificador, identifier);
        Click.on(driver, locator);
        Click.on(driver, SearchActivityUI.btnBuscar);
    }
    public static void byActivityNumber(WebDriver driver, String identifier){
        search(driver, identifier, SearchActivityUI.rbtNumeroActividad);
    }
    public static void byLicence(WebDriver driver, String identifier){
        search(driver, identifier, SearchActivityUI.rbtNumeroLicencia);
    }
}
