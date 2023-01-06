package main.tasks.inmuebles.commonInm;

import main.actions.Clear;
import main.actions.Click;
import main.actions.Enter;
import main.actions.SelectOption;
import main.ui.inmueblesUI.commonUI.interfacesUI.IBuscarPersonaUI;
import main.ui.inmueblesUI.empadronamientoUI.BuscarGestorTramiteUI;
import org.openqa.selenium.WebDriver;

public class SearchTaxpayer {
    public static void by(WebDriver driver, IBuscarPersonaUI elements, String numDocument, String documentType){
        String documentId = numDocument;
        String complementId;
        SelectOption.byText(driver, elements.getDocumentTypeList(), documentType);
        if (numDocument.contains("-") && documentType.contains("IDENTIDAD")){
            documentId = numDocument.split("-")[0];
            complementId = numDocument.split("-")[1];
            Enter.text(driver, elements.getNroComplementBox(), complementId);
        }
        Enter.text(driver, elements.getNroDocumentBox(), documentId);
        Click.on(driver, elements.getSearchButton());
    }
}
