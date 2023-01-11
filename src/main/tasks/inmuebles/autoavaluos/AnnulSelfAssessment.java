package main.tasks.inmuebles.autoavaluos;

import main.actions.Click;
import main.actions.Enter;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.autoavaluosUI.AnularAutoavaluoUI;
import org.openqa.selenium.WebDriver;

public class AnnulSelfAssessment {
    public static void now(WebDriver driver, String observation){
        Enter.text(driver, AnularAutoavaluoUI.txtObservaciones, observation);
        Click.on(driver, AnularAutoavaluoUI.btnGrabar);
        if (VerifyAlert.containsThisText(driver, "seguro")){
            VerifyAlert.containsThisText(driver, "correctamente");
        }
    }
}
