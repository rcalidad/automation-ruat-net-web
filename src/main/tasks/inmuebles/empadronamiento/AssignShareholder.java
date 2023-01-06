package main.tasks.inmuebles.empadronamiento;

import main.actions.Click;
import main.actions.IsDisplayed;
import main.ui.inmueblesUI.empadronamientoUI.AsignarAccionistasUI;
import org.openqa.selenium.WebDriver;

public class AssignShareholder {
    public static void addShareholder(WebDriver driver){
        if (IsDisplayed.element(driver, AsignarAccionistasUI.lnkAdicionarDatosAccionistas)){
            Click.on(driver, AsignarAccionistasUI.lnkAdicionarDatosAccionistas);
        }
    }
    public static void recordData(WebDriver driver){
        Click.on(driver, AsignarAccionistasUI.btnAceptar);
    }
}
