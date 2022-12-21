package main.tasks.vehiculos.condonacionLeyMunicipal;

import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.WaitUntilAlert;
import main.ui.vehiculosUI.condonacionLeyMunicipalUI.DetalleGestionesUI;
import org.openqa.selenium.WebDriver;

public class RegistrarCondonacion {
    public static void now(WebDriver driver){
        Click.on(driver, DetalleGestionesUI.btnProcesar);
        if (WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            if (message.contains("seguro")){
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
