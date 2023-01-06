package main.tasks.inmuebles.commonInm;

import main.actions.Click;
import main.actions.SelectOption;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class StartProcedure {
    public static IInicioTramiteUI elementsProcess;

    public static void setElementsProcess(IInicioTramiteUI elements){
        elementsProcess = elements;
    }
    public static void checkDocumentsRequired(WebDriver driver){
        List<By> locators = elementsProcess.getCheckBoxDocumentsRequired();
        for (By locator: locators) {
            Click.on(driver, locator);
        }
    }
    public static void enterToRegisterProcessManager(WebDriver driver){
        if (elementsProcess.getLinkRegistrar() != null){
            Click.on(driver, elementsProcess.getLinkRegistrar());
        }
    }
    public static void selectProcessManager(WebDriver driver, String rol){
        SelectOption.byText(driver, elementsProcess.getListGestorTramite(), rol);
    }
    public static void recordDocumentsOfProcess(WebDriver driver){
        Click.on(driver, elementsProcess.getBtnGrabar());
        VerifyAlert.containsThisText(driver, "seguro");
    }
}
