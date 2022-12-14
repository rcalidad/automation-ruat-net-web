package main.tasks.cobro.common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.ui.cobroUI.commonUI.RecordPaymentUI;
import org.openqa.selenium.WebDriver;

public class RecordPayment {
    public static void now(WebDriver driver, ExtentTest extentTest){
        if(GetText.ofValue(driver, RecordPaymentUI.txtVerificacionMontoEfectivo).equals("")){
            String debt = GetText.of(driver, RecordPaymentUI.txtDeuda);
            Clear.on(driver, RecordPaymentUI.txtMontoEfectivo, 1);
            Enter.text(driver, RecordPaymentUI.txtMontoEfectivo, debt);
            Enter.text(driver, RecordPaymentUI.txtVerificacionMontoEfectivo, debt);
        }
        Click.on(driver, RecordPaymentUI.btnAceptar);
        if(WaitUntilAlert.isPresent(driver)){
            String message = DisplayAlert.getText(driver);
            if (message.contains("Confirma")){
                DisplayAlert.toAcept(driver);
            }else {
                ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.FAIL, message);
                Log.recordInLog(message);
            }
        }
    }
}
