package main.tasks.actividadesEconomicas.multasAdministrativasPatentes;

import main.actions.Click;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ReceiveDocumentationUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static void withoutDocuments(WebDriver driver){
        Click.on(driver, ReceiveDocumentationUI.btnGrabar);
        VerifyAlert.containsThisText(driver, "seguro");
    }
}
