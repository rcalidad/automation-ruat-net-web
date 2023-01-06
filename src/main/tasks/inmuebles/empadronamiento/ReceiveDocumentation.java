package main.tasks.inmuebles.empadronamiento;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Scroll;
import main.tasks.inmuebles.commonInm.SearchTaxpayer;
import main.tasks.inmuebles.commonInm.StartProcedure;
import main.tasks.inmuebles.commonInm.Verify;
import main.ui.inmueblesUI.commonUI.interfacesUI.IBuscarPersonaUI;
import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import main.ui.inmueblesUI.empadronamientoUI.BuscarGestorTramiteUI;
import main.ui.inmueblesUI.empadronamientoUI.InicioTramiteUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentation {
    public static void now(WebDriver driver, ExtentTest extentTest, IInicioTramiteUI objElements, String numDocument, String documentType, String rolProcessManager){
        try {
            StartProcedure.setElementsProcess(objElements);
            StartProcedure.checkDocumentsRequired(driver);
            Scroll.toElement(driver, objElements.getListGestorTramite());
            StartProcedure.enterToRegisterProcessManager(driver);
            Verify.elementIsReady(driver, extentTest, BuscarGestorTramiteUI.ttlBuscarGestorTramite);
            IBuscarPersonaUI obj = BuscarGestorTramiteUI.getInstance();
            StablishPerson.likeProcessManager(driver, extentTest, obj, numDocument, documentType);
            Verify.elementIsReady(driver, extentTest, InicioTramiteUI.ttlInicioTramite);
            Scroll.toEndPage(driver);
            StartProcedure.selectProcessManager(driver, rolProcessManager);
            StartProcedure.recordDocumentsOfProcess(driver);
        }catch (Exception exception){

        }
    }
}
