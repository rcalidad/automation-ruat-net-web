package main.tasks.inmuebles.condonacionLeyMunicipal;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.IsPresent;
import main.actions.Scroll;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.condonacionLeyMunicipalUI.RegistrarCondonacionUI;
import org.openqa.selenium.WebDriver;

public class RegisterCondonation {
    public static void now(WebDriver driver){
        Scroll.toEndPage(driver);
        if (IsPresent.elements(driver, RegistrarCondonacionUI.btnGrabar)){
            Click.on(driver, RegistrarCondonacionUI.btnGrabar);
            if (VerifyAlert.containsThisText(driver, "seguro")){
                VerifyAlert.containsThisText(driver, "correctamente");
            }
        }
    }
}
