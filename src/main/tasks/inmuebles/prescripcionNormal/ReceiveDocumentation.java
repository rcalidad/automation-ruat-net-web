package main.tasks.inmuebles.prescripcionNormal;

import main.tasks.inmuebles.commonInm.inicioTramite.StartProcedure;
import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import main.ui.inmueblesUI.prescripcionNormalUI.InicioTramiteUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static void now(WebDriver driver){
        IInicioTramiteUI elemnts = InicioTramiteUI.getInstance();
        StartProcedure.setElementsProcess(elemnts);
        StartProcedure.checkDocumentsRequired(driver);
        StartProcedure.recordDocumentsOfProcess(driver);
    }
}
