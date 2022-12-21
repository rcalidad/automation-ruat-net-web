package main.tasks.vehiculos.condonacionLeyMunicipalImt;

import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.WaitUntilAlert;
import main.ui.vehiculosUI.condonacionLeyMunicipalImtUI.DetalleItemsCondonacionUI;
import org.openqa.selenium.WebDriver;

public class RegistrarCondonacionImt {
    public static void now(WebDriver driver){
        Click.on(driver, DetalleItemsCondonacionUI.btnProcesar);
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
