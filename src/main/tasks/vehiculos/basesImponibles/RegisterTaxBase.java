package main.tasks.vehiculos.basesImponibles;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.vehiculos.commonVeh.Verify;
import main.ui.vehiculosUI.basesImponiblesUI.RegistrarBaseImponibleUI;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import org.openqa.selenium.WebDriver;

public class RegisterTaxBase {

    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, RegistrarBaseImponibleUI.ttlRegistrarBaseImponible);
    }

    public static void register(WebDriver driver, ExtentTest extentTest, String year, String taxBase, String numForm){
        Enter.text(driver, RegistrarBaseImponibleUI.txtValorInicial, taxBase);
        Enter.dateByElementId(driver, RegistrarBaseImponibleUI.txtFechaInicial, "01/01/".concat(year));
        Enter.dateByElementId(driver, RegistrarBaseImponibleUI.txtFechaBalance, "31/12/".concat(year));
        Enter.text(driver, RegistrarBaseImponibleUI.txtDepreciacion, "15");
        Enter.text(driver, RegistrarBaseImponibleUI.txtBaseImponible, taxBase);
        Enter.text(driver, RegistrarBaseImponibleUI.txtVerificacionBaseImponible, taxBase);
        Enter.text(driver, RegistrarBaseImponibleUI.txtNumeroFormulario, numForm);
        Click.on(driver, RegistrarBaseImponibleUI.btnRegistrar);
        if (WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            if (message.contains("Confirma")){
                DisplayAlert.toAcept(driver);
            }else {
                ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
                Log.recordInLog(message);
            }
        }
        //WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
        if (WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            if (message.contains("correctamente")){
                DisplayAlert.toAcept(driver);
            }else {
                ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
                Log.recordInLog(message);
            }
        }
    }
}
