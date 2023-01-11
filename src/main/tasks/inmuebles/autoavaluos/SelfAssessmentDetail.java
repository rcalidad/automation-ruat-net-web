package main.tasks.inmuebles.autoavaluos;

import main.actions.Click;
import main.actions.Scroll;
import main.ui.inmueblesUI.autoavaluosUI.DetalleAutoavaluosUI;
import org.openqa.selenium.WebDriver;

public class SelfAssessmentDetail {
    public static void record(WebDriver driver){
        Scroll.toEndPage(driver);
        Click.on(driver, DetalleAutoavaluosUI.btnAceptar);
    }
}
