package main.tasks.vehiculos.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.Constants;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.commonTasks.Login;
import main.ui.vehiculosUI.loginUI.LoginUI;
import main.ui.vehiculosUI.mainMenuUI.MainMenuUI;
import org.openqa.selenium.WebDriver;

public class LoginVehiculos {
    private static int nroTries = 0;
    public static void authenticate(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password){
        String message;
        String newPassword;
        Login.as(driver, LoginUI.txtUsuario, user, LoginUI.txtContrasenia, password, LoginUI.btnIngresar);
        nroTries = nroTries + 1;
        if (WaitUntilAlert.isPresent(driver, 2)){
            message = DisplayAlert.getText(driver);
            DisplayAlert.toAcept(driver);
        } else if (WaitUntilElement.isElementVisible(driver, LoginUI.msgNotificacion, 2)) {
            message = GetText.of(driver, LoginUI.msgNotificacion);
        }else if (WaitUntilElement.isElementVisible(driver, MainMenuUI.lnkCerrarSesion)){
            message = "Login process: OK";
        }else{
            message = "Something was wrong, please verify the data source...";
        }
        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, message);
        Log.recordInLog(message);
        if (message.contains("expirado")){
            //DisplayAlert.toAcept(driver);
            WaitUntilElement.isElementVisible(driver, LoginUI.txtContraseniaActual, 3);
            newPassword = password.contains("PRUEBA") || password.contains("8") ?
                    user.substring(0, 1).concat(Constants.DEFAULT_PART_OF_PASSWORD) : user.substring(0, 1).concat("12345678$");
            Enter.text(driver, LoginUI.txtContraseniaActual, password);
            Enter.text(driver, LoginUI.txtNuevaContrasenia, newPassword);
            Enter.text(driver, LoginUI.txtConfirmarNuevaContrasenia, newPassword);
            Click.on(driver, LoginUI.btnGrabar);
            if(WaitUntilElement.isElementVisible(driver, LoginUI.lnkAceptar, 3)){
                Click.on(driver, LoginUI.lnkAceptar);
                WaitUntilElement.isElementVisible(driver, LoginUI.btnIngresarCP);
                Click.on(driver, LoginUI.btnIngresarCP);
            }else{
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Something was wrong changing password...");
                Log.recordInLog("Something was wrong changing password...");
            }

        } else if (message.contains("no se encuentra registrado") || message.contains("inexistente") || message.contains("contáctese con su Administrador")) {
            Log.recordInLog(message);
        } else if (message.contains("Error al intentar autentificarse")) {
            Log.recordInLog("Wrong password, trying again...");
            Click.on(driver, LoginUI.lnkAnterior);
            newPassword = password.contains(Constants.DEFAULT_PART_OF_PASSWORD) ?
                    "PRUEBA123$" : password.contains("PRUEBA123$") ? user.substring(0,1).concat("12345678$") : user.substring(0,1).concat(Constants.DEFAULT_PART_OF_PASSWORD);
            if (nroTries < 3){
                authenticate(driver, extentReports, extentTest, user, newPassword);
            }else {
                Log.recordInLog(" " + message);
                Log.recordInLog(" Please, verify password...");
            }
        } else if (message.contains("OK")){
            //Log.recordInLog("Login process: Successful.");
            nroTries = 0;
        }
    }
    public static boolean as(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password){
        Enter.text(driver, LoginUI.txtUsuario, user);
        Enter.text(driver, LoginUI.txtContrasenia, password);
        Click.on(driver, LoginUI.btnIngresar);
        return WaitUntilElement.isElementVisible(driver, MainMenuUI.lnkCerrarSesion);
    }

    public static void logout(WebDriver driver){
        if(IsDisplayed.element(driver, main.ui.actividadesEconomicasUI.commonUI.MainMenuUI.lnkCerrarSesion)){
            Click.on(driver, main.ui.actividadesEconomicasUI.commonUI.MainMenuUI.lnkCerrarSesion);
        }
    }
}
