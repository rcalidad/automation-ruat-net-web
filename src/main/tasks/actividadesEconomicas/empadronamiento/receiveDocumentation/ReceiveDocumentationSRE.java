package main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ReceiveDocumentationUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentationSRE implements IReceiveDocumentation {
    public WebDriver driverSRE;
    public ExtentTest extentTest;

    public ReceiveDocumentationSRE(){

    }
    public void setDriver(WebDriver driver, ExtentTest extentTest){
        this.driverSRE = driver;
        this.extentTest = extentTest;
    }

    @Override
    public void now() {
        try{
            Verify.isReady(driverSRE, extentTest, ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
            Click.on(driverSRE, ReceiveDocumentationUI.chkFormularioUnicoDeLicenciaDeFuncionamientoRAE01);
            Click.on(driverSRE, ReceiveDocumentationUI.chkFotocopiaDocumentoDeIdentidad);
            Click.on(driverSRE, ReceiveDocumentationUI.chkFormularioDeInspeccionDeActividadesEconomicasRAE02);
        }catch (Exception exception){}

        //Click.on(driverSRE, ReceiveDocumentationUI.btnGrabar);
        //VerifyAlert.containsThisText(driverSRE, "seguro");
    }
}
