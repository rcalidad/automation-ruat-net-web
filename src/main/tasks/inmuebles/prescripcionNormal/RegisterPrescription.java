package main.tasks.inmuebles.prescripcionNormal;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.prescripcionNormalUI.RegistrarPrescripcionUI;
import org.openqa.selenium.WebDriver;

public class RegisterPrescription {
    public static void now(WebDriver driver, ExtentTest extentTest, String observation){
        try {
            Verify.elementIsReady(driver, extentTest, RegistrarPrescripcionUI.ttlRegistrarPrescripcion);
            Enter.text(driver, RegistrarPrescripcionUI.txtObservaciones, observation);
            Click.on(driver, RegistrarPrescripcionUI.btnGrabar);
            if (VerifyAlert.containsThisText(driver, "seguro")){
                VerifyAlert.containsThisText(driver, "correctamente");
            }
        }catch (Exception exception){

        }
    }
}
