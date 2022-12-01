package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.ui.vehiculosUI.commonUI.CommonElementsUI;
import main.ui.vehiculosUI.commonUI.ModificarDatosMinutaUI;
import org.openqa.selenium.WebDriver;

public class ModifyMinuteData {
    public static boolean isReady(WebDriver driver, ExtentTest extentTest){
        return Verify.isReady(driver, extentTest, ModificarDatosMinutaUI.ttlModificarDatosMinuta);
    }

    public static void addAmount(WebDriver driver, ExtentTest extentTest, String additionalAmount, String operation){
        Scroll.toEndPage(driver);
        String currentAmount = GetText.ofValue(driver, ModificarDatosMinutaUI.txtMontoMinuta);
        int newAmount = currentAmount.equals("") ?
                additionalAmount.equals("") ? 1 : Integer.parseInt(additionalAmount) :
                additionalAmount.equals("") ? Integer.parseInt(currentAmount) : Integer.parseInt(currentAmount) + Integer.parseInt(additionalAmount);
        Clear.on(driver, ModificarDatosMinutaUI.txtMontoMinuta, 1);
        Enter.text(driver, ModificarDatosMinutaUI.txtMontoMinuta, String.valueOf(newAmount));
        Clear.on(driver, ModificarDatosMinutaUI.txtVerificacionMontoMinuta, 1);
        Enter.text(driver, ModificarDatosMinutaUI.txtVerificacionMontoMinuta, String.valueOf(newAmount));
        Enter.text(driver, ModificarDatosMinutaUI.txtObservaciones, operation);
        Click.on(driver, ModificarDatosMinutaUI.btnAceptar);
        //WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
        if(WaitUntilAlert.isPresent(driver, 30)){
            String message = DisplayAlert.getText(driver);
            Log.recordInLog("Modificación de minuta: " + message);
            DisplayAlert.toAcept(driver);
        }else{
            Log.recordInLog("La transacción demoró demasiado...");
        }
    }
}
