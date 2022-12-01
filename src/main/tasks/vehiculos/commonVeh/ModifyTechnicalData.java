package main.tasks.vehiculos.commonVeh;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.ui.vehiculosUI.commonUI.TechnicalDataUI;
import org.openqa.selenium.WebDriver;

public class ModifyTechnicalData {
    public static boolean isReady(WebDriver driver){
        return WaitUntilElement.isElementVisible(driver, TechnicalDataUI.txtNumeroMotor);
    }
    public static void cilindrada(WebDriver driver, ExtentTest extentTest, String operation, String cylinderCapacity, String traction){
        String message;
        String currentCilindrada = GetText.ofValue(driver, TechnicalDataUI.txtCilindrada).trim();
        int newCilindrada = currentCilindrada.equals("") ? 0 : Integer.parseInt(currentCilindrada);
        int addCilindrada = Integer.parseInt(cylinderCapacity);
        newCilindrada = operation.equals("INCREMENTAR BASE IMPONIBLE") ? newCilindrada + addCilindrada : newCilindrada - addCilindrada;
        Log.recordInLog("Moficando cilindrada: de " + currentCilindrada + " a " + String.valueOf(newCilindrada));
        Clear.on(driver, TechnicalDataUI.txtCilindrada, 1);
        Enter.text(driver, TechnicalDataUI.txtCilindrada, String.valueOf(newCilindrada));
        String currentTraction = GetText.ofValue(driver, TechnicalDataUI.lstTraccion);
        if(currentTraction.equals("")){
            SelectOption.byText(driver, TechnicalDataUI.lstTraccion, traction);
        }
        Click.on(driver, TechnicalDataUI.btnAceptar);
        if (WaitUntilAlert.isPresent(driver)){
            message = DisplayAlert.getText(driver);
            if (message.contains("Desea continuar")){
                DisplayAlert.toAcept(driver);
                WaitUntilElement.isElementVisible(driver, TechnicalDataUI.btnAceptar);
                Click.on(driver, TechnicalDataUI.btnAceptar);
            }else{
                ScreenShotHelper.takeScreenShotOfAnAlert(driver, extentTest, Status.SKIP, message);
                DisplayAlert.toAcept(driver);
                Log.recordInLog("No es posible continuar: " + message);
            }
        }else if (WaitUntilElement.isElementVisible(driver, TechnicalDataUI.btnAceptar)){
            Click.on(driver, TechnicalDataUI.btnAceptar);
        }else{
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.SKIP, "No es posible continuar.");
        }
    }
    public static void technicalData(WebDriver driver, String turbo){
        if (turbo.equals("SI")){
            if(!IsChecked.element(driver, TechnicalDataUI.chkTurbo)){
                Click.on(driver, TechnicalDataUI.chkTurbo);
            }
        }else {
            if(IsChecked.element(driver, TechnicalDataUI.chkTurbo)){
                Click.on(driver, TechnicalDataUI.chkTurbo);
            }
        }

    }
}
