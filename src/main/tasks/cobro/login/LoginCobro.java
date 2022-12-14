package main.tasks.cobro.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.Constants;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.commonTasks.Login;
import main.ui.cobroUI.loginUI.LoginUI;
import main.ui.cobroUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class LoginCobro {
    private static int nroTries = 0;
    public static void authenticate(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password){
        String message;
        String newPassword;
        Login.as(driver, LoginUI.txtUsuario, user, LoginUI.txtContrasenia, password, LoginUI.btnIngresar);
        nroTries = nroTries +1;
        if (WaitUntilAlert.isPresent(driver, 1)){
            message = DisplayAlert.getText(driver);
            DisplayAlert.toAcept(driver);
        } else if (WaitUntilElement.isElementVisible(driver, LoginUI.msgNotificacion, 1)) {
            message = GetText.of(driver, LoginUI.msgNotificacion);
        } else if (WaitUntilElement.isElementVisible(driver, MainMenuUI.lnkCerrarSesion)) {
            message = "Login process: OK";
        } else if (WaitUntilElement.isElementVisible(driver, LoginUI.txtContraseniaActual,2)) {
            message = "Password expirado";
        } else {
            message = "Algo salió mal, por favor verifique los datos de entrada...";
        }
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, message);
        Log.recordInLog(message);
        if (message.contains("expirado")){
            WaitUntilElement.isElementVisible(driver, LoginUI.txtContraseniaActual, 2);
            newPassword = password.contains("PRUEBA") || password.contains("8") ?
                    user.substring(0, 1).concat(Constants.DEFAULT_PART_OF_PASSWORD) : user.substring(0, 1).concat("12345678$");
            Login.updatePassword(driver, LoginUI.txtContraseniaActual, password, LoginUI.txtNuevaContrasenia, newPassword, LoginUI.txtConfirmeNuevaContrasenia, LoginUI.btnGrabar);
            if(WaitUntilElement.isElementVisible(driver, LoginUI.lnkAceptar, 3)){
                Click.on(driver, LoginUI.lnkAceptar);
                WaitUntilElement.isElementVisible(driver, LoginUI.btnIngresarCP);
                Click.on(driver, LoginUI.btnIngresarCP);
            }else{
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Algo salió mal al cambiar el password...");
                Log.recordInLog("Algo salió mal al cambiar el password...");
            }
        } else if (message.contains("no se encuentra registrado") || message.contains("inexistente") || message.contains("contáctese con su Administrador")) {
            Log.recordInLog(message);
        } else if (message.contains("Error al intentar autentificarse")) {
            Log.recordInLog("Password equivocado, intentando otra vez...");
            Click.on(driver, LoginUI.lnkAnterior);
            newPassword = password.contains(Constants.DEFAULT_PART_OF_PASSWORD) ?
                    "PRUEBA123$" : password.contains("PRUEBA123$") ? user.substring(0,1).concat("12345678$") : user.substring(0,1).concat(Constants.DEFAULT_PART_OF_PASSWORD);
            if (nroTries < 3){
                authenticate(driver, extentReports, extentTest, user, newPassword);
            }else {
                Log.recordInLog(" " + message);
                Log.recordInLog(" Por favor, verificar el password...");
            }
        } else if (message.contains("OK")){
            nroTries = 0;
        }
    }

    public static void logout(WebDriver driver){
        if(IsDisplayed.element(driver, MainMenuUI.lnkCerrarSesion)){
            Click.on(driver, MainMenuUI.lnkCerrarSesion);
        }
    }
}
