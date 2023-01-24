package main.tasks.inmuebles.condonacionLeyMunicipal;

import main.tasks.inmuebles.commonInm.inicioTramite.StartProcedure;
import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import main.ui.inmueblesUI.condonacionLeyMunicipalUI.InicioTramiteUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static void now(WebDriver driver){
        IInicioTramiteUI elements = InicioTramiteUI.getInstance();
        StartProcedure.setElementsProcess(elements);
        StartProcedure.checkDocumentsRequired(driver);
        StartProcedure.recordDocumentsOfProcess(driver);
    }
}
