package main.tasks.inmuebles.compensaciones;

import main.tasks.inmuebles.commonInm.inicioTramite.StartProcedure;
import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static void now(WebDriver driver, IInicioTramiteUI elements){
        StartProcedure.setElementsProcess(elements);
        StartProcedure.checkDocumentsRequired(driver);
        StartProcedure.recordDocumentsOfProcess(driver);
    }
}
