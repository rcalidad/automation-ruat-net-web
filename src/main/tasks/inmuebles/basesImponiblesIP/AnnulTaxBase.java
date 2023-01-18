package main.tasks.inmuebles.basesImponiblesIP;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.basesImponiblesIpUI.AnularBaseImponibleUI;
import main.ui.inmueblesUI.basesImponiblesIpUI.DetalleBasesImponiblesUI;
import org.openqa.selenium.WebDriver;

public class AnnulTaxBase {
    public static void withDefaultData(WebDriver driver, ExtentTest extentTest){
        try {
            Verify.elementIsReady(driver, extentTest, AnularBaseImponibleUI.ttlAnularBaseImponible);
            Enter.text(driver, AnularBaseImponibleUI.txtObservaciones, MessagesINM.testText);
            Click.on(driver, AnularBaseImponibleUI.btnGrabar);
            if (VerifyAlert.containsThisText(driver, "seguro")){
                VerifyAlert.containsThisText(driver, "correctamente");
            }
            Verify.elementIsReady(driver, extentTest, DetalleBasesImponiblesUI.ttlDetalleBasesImponibles);
        }catch (Exception exception){

        }
    }
}
