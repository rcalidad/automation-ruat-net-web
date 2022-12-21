package main.tasks.vehiculos.basesImponiblesIMT;

import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.Enter;
import main.actions.WaitUntilAlert;
import main.ui.vehiculosUI.basesImponiblesImtUI.AnularBaseImponibleImtUI;
import org.openqa.selenium.WebDriver;

public class AnnulTaxBaseImt {
    public static void now(WebDriver driver, String observation){
        Enter.text(driver, AnularBaseImponibleImtUI.txtObservaciones, observation);
        Click.on(driver, AnularBaseImponibleImtUI.btnAnular);
        if (WaitUntilAlert.isPresent(driver, 15)){
            String message = DisplayAlert.getText(driver);
            if (message.contains("Confirme")){
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
