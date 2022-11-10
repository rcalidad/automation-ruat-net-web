package main.tasks.vehiculos.commonVeh;

import main.actions.Click;
import main.actions.SelectOption;
import main.actions.WaitUntilElement;
import main.ui.vehiculosUI.commonUI.SelectPeriodUI;
import main.ui.vehiculosUI.modificacionDatosTecnicosUI.TramiteUI;
import org.openqa.selenium.WebDriver;

public class SelectPeriod {
    public static boolean isReady(WebDriver driver){
        return WaitUntilElement.isElementVisible(driver, SelectPeriodUI.lstGestion);
    }
    public static void toModifyTechnicalData(WebDriver driver, String year){
        //SelectOption.byText(driver, SelectPeriodUI.lstGestion, year);
        Click.on(driver, SelectPeriodUI.btnAceptar);
    }
}
