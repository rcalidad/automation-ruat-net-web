package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.actions.Log;
import main.actions.WaitUntilElement;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.commonUI.ValidarCertificadoPropiedadUI;
import org.openqa.selenium.WebDriver;

public class ValidatePropertyCertificate {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, ValidarCertificadoPropiedadUI.txtCRPVA);
        /*if(WaitUntilElement.isElementVisible(driver, CommonElementsUI.ttlValidaciones, 3)){
            return false;
        }
        return WaitUntilElement.isElementVisible(driver, ValidarCertificadoPropiedadUI.txtCRPVA);*/
    }
    public static void withData(WebDriver driver, String crpva, String nroCopies){
        Enter.text(driver, ValidarCertificadoPropiedadUI.txtCRPVA, crpva);
        Enter.text(driver, ValidarCertificadoPropiedadUI.txtNumeroCopia, nroCopies);
        Click.on(driver, ValidarCertificadoPropiedadUI.btnAceptar);
        Log.recordInLog("Validating CRPVA: " + crpva);
    }
}
