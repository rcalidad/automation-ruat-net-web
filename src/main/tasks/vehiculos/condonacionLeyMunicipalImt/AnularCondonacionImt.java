package main.tasks.vehiculos.condonacionLeyMunicipalImt;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.Enter;
import main.actions.WaitUntilAlert;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.condonacionLeyMunicipalImtUI.DetalleItemsCondonacionUI;
import main.ui.vehiculosUI.condonacionLeyMunicipalImtUI.AnularCondonacionUI;
import org.openqa.selenium.WebDriver;

public class AnularCondonacionImt {
    public static void now(WebDriver driver, String observation, ExtentTest extentTest){
        Click.on(driver, DetalleItemsCondonacionUI.btnProcesar);
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
