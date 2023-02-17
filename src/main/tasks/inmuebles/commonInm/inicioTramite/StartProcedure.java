package main.tasks.inmuebles.commonInm.inicioTramite;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Find;
import main.actions.SelectOption;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.commonUI.interfacesUI.IInicioTramiteUI;
import main.ui.inmueblesUI.empadronamientoUI.inicioTramite.InicioTramiteDesUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public static void checkAllDocuments(WebDriver driver){
        List<WebElement> checkBoxes = Find.elements(driver, InicioTramiteDesUI.chkAllDocumentsRequired);
        for (WebElement element : checkBoxes) {
            element.click();
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
    public static void fillFormsOfDocumentsRequired(WebDriver driver, ExtentTest extentTest){
        //Formulario406
        //, Map<String, Map<String, String>> data
        //Formulario406
        Map<String, By> documents = elementsProcess.getLinksDocumentRequired();
        Set<String> keys = documents.keySet();
        for (String className : keys) {
            try {
                Click.on(driver, documents.get(className));
                ReceiveDocumentationFactory.getInstance().executeReceiveDocumentation(driver, extentTest, className);

            }catch (Exception exception){

            }
        }
    }
}
