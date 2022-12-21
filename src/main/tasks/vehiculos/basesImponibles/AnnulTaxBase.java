package main.tasks.vehiculos.basesImponibles;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.Enter;
import main.actions.WaitUntilAlert;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.basesImponiblesUI.AnularBaseImponibleUI;
import org.openqa.selenium.WebDriver;

public class AnnulTaxBase {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, AnularBaseImponibleUI.ttlAnularBaseImponible);
    }
    public static void now(WebDriver driver, ExtentTest extentTest, String observation){
        Enter.text(driver, AnularBaseImponibleUI.txtObservaciones, observation);
        Click.on(driver, AnularBaseImponibleUI.btnRegistrar);
        if (WaitUntilAlert.isPresent(driver, 15)){
            String message = DisplayAlert.getText(driver);
            if (message.contains("continuar")){
                DisplayAlert.toAcept(driver);
                if (WaitUntilAlert.isPresent(driver, 15)){
                    message = DisplayAlert.getText(driver);
                    if (message.contains("correctamente")){
                        DisplayAlert.toAcept(driver);
                    }
                }
            }
        }
    }
}
