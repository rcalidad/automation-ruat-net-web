package main.tasks.tasas.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.common.Constants;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.commonTasks.Login;
import main.ui.tasasOtrosIngresosUI.commonUI.CommonElementsUI;
import main.ui.tasasOtrosIngresosUI.loginUI.LoginUI;
import org.openqa.selenium.WebDriver;

public class LoginTasas {
    private static int nroTries = 0;
    public static void authenticate(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password){
        String message;
        String newPassword;
        if (IsDisplayed.element(driver, LoginUI.divModal, 2)){
            Click.on(driver, LoginUI.btnAceptarModal);
        }
        Login.as(driver, LoginUI.txtUsuario, user, LoginUI.txtContrasenia, password, LoginUI.btnIngresar);
        nroTries = nroTries + 1;
        WaitUntilElement.isVisibleElementOr(driver, LoginUI.divModal, LoginUI.lnkMiCuenta);
        if (IsDisplayed.element(driver, LoginUI.divModal)){
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Mensaje en el proceso de inicio de sesión.");
            message = GetText.of(driver, LoginUI.divMensajeModal);
            Click.on(driver, LoginUI.btnAceptarModal, 5);

            if (message.contains("expirado")){
                newPassword = password.contains("PRUEBA") || password.contains("8") ? user.substring(0,1).concat(Constants.DEFAULT_PART_OF_PASSWORD) : user.substring(0,1).concat("12345678$");
                WaitUntilElement.isVisibleElement(driver, LoginUI.txtConfirmarContrasenaNueva);
                Enter.text(driver, LoginUI.txtContraseniaActual, password);
                Enter.text(driver, LoginUI.txtNuevaContrasenia, newPassword);
                Enter.text(driver, LoginUI.txtConfirmarContrasenaNueva, newPassword);
                Click.on(driver, LoginUI.btnGrabar);
                WaitUntilElement.isVisibleElement(driver, LoginUI.divModal);
                if (IsDisplayed.element(driver, LoginUI.divModal, 2)) {
                    message = GetText.of(driver, LoginUI.divMensajeModal);
                    if (message.contains("correctamente")) {
                        Log.recordInLog(" ".concat(message));
                        WaitUntilElement.isVisibleElement(driver, LoginUI.btnAceptarModal);
                        Click.on(driver, LoginUI.btnAceptarModal);
                        WaitUntilElement.isVisibleElement(driver, LoginUI.lnkMiCuenta, 5);
                        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Autenticado.");
                    } else {
                        ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Error en el login.");
                    }
                }
            }
            else if (message.contains("no se encuentra registrado") || message.contains("inexistente") || message.contains("contáctese con su Administrador")) {
                Log.recordInLog(" " + message);
            } else if (message.contains("incorrectos")) {
                Log.recordInLog("Error en la contraseña, intentando ingresar nuevamente...");
                newPassword = password.contains(Constants.DEFAULT_PART_OF_PASSWORD) ? "PRUEBA123$" : password.contains("PRUEBA123$") ? user.substring(0,1).concat("12345678$") : user.substring(0,1).concat(Constants.DEFAULT_PART_OF_PASSWORD);
                if (nroTries < 3){
                    authenticate(driver, extentReports, extentTest, user, newPassword);
                }else {
                    Log.recordInLog( " " + message);
                }
            }
        }
        else {
            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, extentTest, Status.INFO, "Autenticado.");
            Log.recordInLog("Proceso de autentificación: OK.");
            nroTries = 0;
        }
    }
}
