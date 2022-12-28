package main.tasks.actividadesEconomicas.empadronamiento.receiveDocumentation;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.tasks.actividadesEconomicas.commonAEC.Verify;
import main.ui.actividadesEconomicasUI.empadronamientoUI.ReceiveDocumentationUI;
import org.openqa.selenium.WebDriver;

public class ReceiveDocumentationSCZ implements IReceiveDocumentation {
    public WebDriver driverSCZ;
    public ExtentTest extentTestSCZ;
    public ReceiveDocumentationSCZ(){

    }

    @Override
    public void setDriver(WebDriver driver, ExtentTest extentTest) {
        this.driverSCZ = driver;
        this.extentTestSCZ = extentTest;
    }

    @Override
    public void now() {
        try {
            Verify.isReady(driverSCZ, extentTestSCZ, ReceiveDocumentationUI.ttlRecepcionarDocumentacion);
            Click.on(driverSCZ, ReceiveDocumentationUI.chkDocumentoDeIdentidad);
        }catch (Exception exception){}

        //Click.on(driverSCZ, ReceiveDocumentationUI.btnGrabar);
        //VerifyAlert.containsThisText(driverSCZ, "seguro");
    }
}
