package main.tasks.actividadesEconomicas.condonacionLeyMunicipal;

import main.actions.Click;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.condonacionLeyMunicipalUI.ReceiveDocumentationUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static void withoutData(WebDriver driver){
        Click.on(driver, ReceiveDocumentationUI.btnGrabar);
        VerifyAlert.containsThisText(driver, "seguro");
    }
}
