package main.tasks.actividadesEconomicas.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.helpers.dataUtility.ScreenShotHelper;
import main.tasks.commonTasks.Login;
import main.ui.actividadesEconomicasUI.commonUI.MainMenuUI;
import main.ui.actividadesEconomicasUI.loginUI.LoginUI;
import org.openqa.selenium.WebDriver;

public class LoginActividadesEconomicas {
    private static int nroTries = 0;
    public static boolean loginFailed = true;
    public static void as(WebDriver driver, ExtentReports extentApp, ExtentTest test, String user, String password){
        String message;
        //String newPassword;
        Login.as(driver, LoginUI.txtUsuario, user, LoginUI.txtContrasena, password, LoginUI.btnIngresar);
        nroTries = nroTries + 1;
        //WaitUntilElement.isVisibleElement(driver, CommonElementsUI.imgEnProgreso);
        //WaitUntilElement.isInvisibleElement(driver, CommonElementsUI.imgEnProgreso);
        //login(driver, user, password);
        if (IsDisplayed.element(driver, MainMenuUI.lnkCerrarSesion)){
            loginFailed = false;
            Log.recordInLog(" Proceso de autenticación exitoso.");
        }else{
            if(IsDisplayed.element(driver, LoginUI.msgNotificacionUsuarioInexistente, 1)){
                loginFailed = true;
                ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, test, Status.FAIL, "<b>No se pudo autenticar, usuario inexistente.</b>");
                Log.recordInLog(" ".concat(GetText.of(driver, LoginUI.msgNotificacionUsuarioInexistente)));
            }else{
                if (IsDisplayed.element(driver, LoginUI.msgNotificacionContrasenaIncorrecta)){
                    Click.on(driver, LoginUI.lnkAnterior);
                    Login.as(driver, LoginUI.txtUsuario, user, LoginUI.txtContrasena, "PRUEBA123$", LoginUI.btnIngresar);
                    //login(driver, user, "PRUEBA123$");
                    if(IsDisplayed.element(driver, LoginUI.msgNotificacionContrasenaIncorrecta)){
                        Click.on(driver, LoginUI.lnkAnterior);
                        //login(driver, user, changePassword(user, password));
                        Login.as(driver, LoginUI.txtUsuario, user, LoginUI.txtContrasena, changePassword(user, password), LoginUI.btnIngresar);
                        if(IsDisplayed.element(driver, LoginUI.msgNotificacionContrasenaIncorrecta, 1)){
                            loginFailed = true;
                            ScreenShotHelper.takeScreenShotAndAdToHTMLReportGenerator(driver, test, Status.FAIL, "<b>No se pudo autenticar, contraseña incorrecta</b>");
                            Log.recordInLog(" ".concat("Error al intentar autenticarse"));
                        }
                    }
                }
                if (WaitUntilAlert.isPresent(driver, 1)){
                    if(DisplayAlert.getText(driver).contains("actualice su contraseña")){
                        DisplayAlert.toAcept(driver);
                        String newPassword = changePassword(user, password);
                        Login.updatePassword(driver, LoginUI.txtContrasenaActual, password, LoginUI.txtNuevaContrasena, newPassword, LoginUI.txtConfirmaNuevaContrasena, LoginUI.btnGrabar);
                        if(DisplayAlert.getText(driver).contains("no debe ser igual")){
                            DisplayAlert.toAcept(driver);
                            Enter.text(driver, LoginUI.txtContrasenaActual, newPassword);
                            newPassword = changePassword(user, newPassword);
                            Enter.text(driver, LoginUI.txtNuevaContrasena, newPassword);
                            Enter.text(driver, LoginUI.txtConfirmaNuevaContrasena, newPassword);
                            Click.on(driver, LoginUI.btnGrabar);
                        }else{
                            if (DisplayAlert.getText(driver).contains("contraseña es incorrecta")){
                                DisplayAlert.toAcept(driver);
                                Enter.text(driver, LoginUI.txtContrasenaActual, newPassword);
                                newPassword = changePassword(user, newPassword);
                                Enter.text(driver, LoginUI.txtNuevaContrasena, newPassword);
                                Enter.text(driver, LoginUI.txtConfirmaNuevaContrasena, newPassword);
                                Click.on(driver, LoginUI.btnGrabar);
                            }
                        }
                        if(IsDisplayed.element(driver, LoginUI.msgCambioContrasenia, 3)){
                            Click.on(driver, LoginUI.lnkAceptar);
                            Click.on(driver, LoginUI.btnIngreso);
                            if (IsDisplayed.element(driver, MainMenuUI.lnkCerrarSesion)){
                                loginFailed = false;
                                Log.recordInLog(" Proceso de autenticación exitoso.");
                            }
                        }
                    }
                }
            }
        }
    }
    public static String changePassword(String user, String password){
        String newPassword;
        if(!password.equals(user.substring(0, 1).concat("1234567$"))){
            newPassword = user.substring(0, 1).concat("1234567$");
        }else{
            newPassword = user.substring(0,1).concat("12345678$");
        }
        return newPassword;
    }
    public static void login(WebDriver driver, String user, String password){
        Enter.text(driver, LoginUI.txtUsuario,user);
        Enter.text(driver, LoginUI.txtContrasena, password);
        Click.on(driver, LoginUI.btnIngresar);
        Log.recordInLog("Proceso de autenticacion: ...");
    }
    public static void logout(WebDriver driver){
        if(IsDisplayed.element(driver, MainMenuUI.lnkCerrarSesion)){
            Click.on(driver, MainMenuUI.lnkCerrarSesion);
            loginFailed = true;
        }
    }
}
