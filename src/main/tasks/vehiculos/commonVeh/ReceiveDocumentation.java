package main.tasks.vehiculos.commonVeh;

import main.actions.Click;
import main.actions.DisplayAlert;
import main.actions.WaitUntilAlert;
import main.actions.WaitUntilElement;
import main.ui.vehiculosUI.commonUI.ReceiveDocumentationUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static boolean isReady(WebDriver driver){
        return WaitUntilElement.isElementVisible(driver, ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
    }
    public static void toModifyTechnicalData(WebDriver driver){
        Click.on(driver, ReceiveDocumentationUI.chkCrpva);
        Click.on(driver, ReceiveDocumentationUI.chkDocumentoIdentidad);
        Click.on(driver, ReceiveDocumentationUI.btnGrabar);
        WaitUntilAlert.isPresent(driver);
        DisplayAlert.toAcept(driver);
    }
}
