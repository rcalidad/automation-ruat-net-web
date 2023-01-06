package main.tasks.inmuebles.empadronamiento;

import main.actions.Click;
import main.actions.IsDisplayed;
import main.actions.Log;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.ui.inmueblesUI.empadronamientoUI.AsignarContribuyenteUI;
import org.openqa.selenium.WebDriver;

public class AssignTaxpayer {
    public static void add(WebDriver driver){
        if (IsDisplayed.element(driver, AsignarContribuyenteUI.lnkAdicionar)){
            Click.on(driver, AsignarContribuyenteUI.lnkAdicionar);
        }else {
            Log.recordInLog(MessagesINM.thereIsNotElement);
        }
    }
    public static void record(WebDriver driver){
        Click.on(driver, AsignarContribuyenteUI.btnAceptar);
    }
}
