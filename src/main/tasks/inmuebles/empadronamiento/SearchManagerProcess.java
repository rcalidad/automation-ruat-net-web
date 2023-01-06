package main.tasks.inmuebles.empadronamiento;

import main.actions.Click;
import main.tasks.inmuebles.commonInm.SearchTaxpayer;
import main.ui.inmueblesUI.empadronamientoUI.BuscarGestorTramiteUI;
import org.openqa.selenium.WebDriver;

public class SearchManagerProcess {
    public static void associate(WebDriver driver){
        Click.on(driver, BuscarGestorTramiteUI.lnkAsociar);
    }
}
