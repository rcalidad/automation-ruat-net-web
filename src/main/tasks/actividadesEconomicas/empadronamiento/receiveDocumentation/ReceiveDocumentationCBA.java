package main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ReceiveDocumentationUI;
import main.ui.actividadesEconomicasUI.empadronamientoUI.SelectionCriteriaRequiredDocumentsUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentationCBA implements IReceiveDocumentation{
    public WebDriver driverCBA;
    public ExtentTest extentTestCBA;

    public ReceiveDocumentationCBA(){

    }
    @Override
    public void setDriver(WebDriver driver, ExtentTest extentTest) {
        this.driverCBA = driver;
        this.extentTestCBA = extentTest;
    }

    @Override
    public void now() {
        try{
            Verify.isReady(driverCBA, extentTestCBA, SelectionCriteriaRequiredDocumentsUI.ttlSeleccionCriteriosDocumentosRequeridos);
            Click.on(driverCBA, SelectionCriteriaRequiredDocumentsUI.btnAceptar);
            Verify.isReady(driverCBA, extentTestCBA, ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
            for (By elements : ReceiveDocumentationUI.chkDocumentsCBA) {
                Click.on(driverCBA, elements);
            }
        }catch (Exception exception){

        }
    }
}
