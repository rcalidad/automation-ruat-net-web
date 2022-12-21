package main.tasks.vehiculos.basesImponiblesIMT;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.Enter;
import main.actions.WaitUntilAlert;
import main.ui.vehiculosUI.basesImponiblesImtUI.RegistrarBaseImponibleImtUI;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterTaxBase {
    public static void now(WebDriver driver, String taxBase, String documentNumber, String name){
        Enter.text(driver, RegistrarBaseImponibleImtUI.txtBaseImponibleDeclarada, taxBase);
        Click.on(driver, RegistrarBaseImponibleImtUI.rbtBolivianos);
        Enter.text(driver, RegistrarBaseImponibleImtUI.txtNumeroDocumento, documentNumber);
        Enter.dateByElementId(driver, RegistrarBaseImponibleImtUI.txtFechaDocumento, getCurrentDate());
        Enter.text(driver, RegistrarBaseImponibleImtUI.txtNombreAutoridad, name);
        Click.on(driver, RegistrarBaseImponibleImtUI.btnRegistrar);
        String message;
        if (WaitUntilAlert.isPresent(driver, 10)){
            message = DisplayAlert.getText(driver);
            if (message.contains("Confirme")){
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

    public static String getCurrentDate(){
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
