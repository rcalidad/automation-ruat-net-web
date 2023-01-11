package main.tasks.inmuebles.autoavaluos;

import main.actions.Click;
import main.actions.Enter;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.autoavaluosUI.RegistrarAutoavaluoUI;
import org.openqa.selenium.WebDriver;

public class RegisterSelfAssessment {
    public static void withoutObservation(WebDriver driver, String estateValuation, String dateSelfAssessment){
        Enter.text(driver, RegistrarAutoavaluoUI.txtValuacionInmueble, estateValuation);
        Enter.text(driver, RegistrarAutoavaluoUI.txtVerificacionValuacionInmueble, estateValuation);
        Enter.text(driver, RegistrarAutoavaluoUI.txtFechaAutoavaluo, dateSelfAssessment);
        Click.on(driver, RegistrarAutoavaluoUI.btnGrabar);
        if (VerifyAlert.containsThisText(driver, "seguro")){
            VerifyAlert.containsThisText(driver, "correctamente");
        }
    }
}
