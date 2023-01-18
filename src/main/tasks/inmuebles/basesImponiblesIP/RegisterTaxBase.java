package main.tasks.inmuebles.basesImponiblesIP;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.actions.Scroll;
import main.tasks.inmuebles.commonInm.Verify;
import main.tasks.inmuebles.helpersInm.MessagesINM;
import main.tasks.vehiculos.commonVeh.VerifyAlert;
import main.ui.inmueblesUI.basesImponiblesIpUI.DetalleBasesImponiblesUI;
import main.ui.inmueblesUI.basesImponiblesIpUI.RegistrarBaseImponibleUI;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterTaxBase {
    public static void withSpecificValue(WebDriver driver, ExtentTest extentTest, String taxBase, String year){
        try{
            Verify.elementIsReady(driver, extentTest, RegistrarBaseImponibleUI.ttlRegistrarBaseImponible);
            Enter.text(driver, RegistrarBaseImponibleUI.txtFechaInicial, "01/01/".concat(year));
            Enter.text(driver, RegistrarBaseImponibleUI.txtFechaBalance, "31/12/".concat(year));
            Enter.text(driver, RegistrarBaseImponibleUI.txtBaseImponible, taxBase);
            Enter.text(driver, RegistrarBaseImponibleUI.txtVerificacionBaseImponible, taxBase);
            Enter.text(driver, RegistrarBaseImponibleUI.txtNumeroFormulario, MessagesINM.defaultNumSerieAlfanumerico);
            Scroll.toEndPage(driver);
            Click.on(driver, RegistrarBaseImponibleUI.btnGrabar);
            if (VerifyAlert.containsThisText(driver, "seguro")){
                VerifyAlert.containsThisText(driver, "correctamente");
            }
            Verify.elementIsReady(driver, extentTest, DetalleBasesImponiblesUI.ttlDetalleBasesImponibles);
        }catch (Exception exception){

        }
    }
}
