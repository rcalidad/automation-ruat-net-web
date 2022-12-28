package main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ReceiveDocumentationUI;
import main.ui.actividadesEconomicasUI.empadronamientoUI.SelectionCriteriaRequiredDocumentsUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentationNaEAL implements IReceiveDocumentation {
    public WebDriver driverEAL;
    public ExtentTest extentTestEAL;
    public ReceiveDocumentationNaEAL(){

    }

    @Override
    public void setDriver(WebDriver driver, ExtentTest extentTest) {
        this.driverEAL = driver;
        this.extentTestEAL = extentTest;
    }

    @Override
    public void now() {
        try{
            Verify.isReady(driverEAL, extentTestEAL, SelectionCriteriaRequiredDocumentsUI.ttlSeleccionCriteriosDocumentosRequeridos);
            Click.on(driverEAL, SelectionCriteriaRequiredDocumentsUI.btnAceptar);
            Verify.isReady(driverEAL, extentTestEAL, ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
            Click.on(driverEAL, ReceiveDocumentationUI.chkDocumentoDeIdentidad);
            Click.on(driverEAL, ReceiveDocumentationUI.chkFormularioUnicoFUTAE);
            Click.on(driverEAL, ReceiveDocumentationUI.chkCarpetaAzul);
        }catch (Exception exception){

        }

        //Click.on(driverEAL, ReceiveDocumentationUI.btnGrabar);
        //VerifyAlert.containsThisText(driverEAL, "seguro");
    }
}
