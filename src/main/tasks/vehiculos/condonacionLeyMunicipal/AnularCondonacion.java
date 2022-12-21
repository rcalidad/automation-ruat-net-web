package main.tasks.vehiculos.condonacionLeyMunicipal;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.Enter;
import main.actions.WaitUntilAlert;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.condonacionLeyMunicipalUI.AnularCondonacionUI;
import main.ui.vehiculosUI.condonacionLeyMunicipalUI.DetalleGestionesUI;
import org.openqa.selenium.WebDriver;

public class AnularCondonacion {
    public static void now(WebDriver driver, String observation, ExtentTest extentTest){
        Click.on(driver, DetalleGestionesUI.btnProcesar);
        if (Verify.isReady(driver, extentTest, AnularCondonacionUI.ttlAnularCondonacion)){
            Enter.text(driver, AnularCondonacionUI.txtObservaciones, observation);
            Click.on(driver, AnularCondonacionUI.btnRegistrar);
            if (WaitUntilAlert.isPresent(driver)){
                String message = DisplayAlert.getText(driver);
                if (message.contains("Confirma")){
                    DisplayAlert.toAcept(driver);
                    if (WaitUntilAlert.isPresent(driver)){
                        message = DisplayAlert.getText(driver);
                        if (message.contains("correctamente")){
                            DisplayAlert.toAcept(driver);
                        }
                    }
                }
            }
        }
    }
}
