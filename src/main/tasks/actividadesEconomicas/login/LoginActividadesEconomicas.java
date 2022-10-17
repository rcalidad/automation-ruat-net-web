package main.tasks.actividadesEconomicas.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import main.actions.*;
import main.tasks.actividadesEconomicas.commonAec.Generator;
import main.ui.actividadesEconomicasUI.commonUI.MainMenuUI;
import main.ui.actividadesEconomicasUI.loginUI.LoginUI;
import org.openqa.selenium.WebDriver;

public class LoginActividadesEconomicas {
    public static boolean loginFailed = true;
    public static void as(WebDriver driver, ExtentReports extentApp, ExtentTest test, String user, String password){
        login(driver, user, password);
        if (IsDisplayed.element(driver, MainMenuUI.lnkCerrarSesion)){
            loginFailed = false;
            Log.recordInLog(" Proceso de autenticación exitoso.");
        }else{
            if(IsDisplayed.element(driver, LoginUI.msgNotificacionUsuarioInexistente)){
                loginFailed = true;
                Generator.takeScreenShotAndAdToHTMLReportGenerator(driver,extentApp, Status.FAIL, "<b>No se pudo autenticar, usuario inexistente.</b>");
                Log.recordInLog(" ".concat(GetText.of(driver, LoginUI.msgNotificacionUsuarioInexistente)));
            }else{
                if (IsDisplayed.element(driver, LoginUI.msgNotificacionContrasenaIncorrecta)){
                    Click.on(driver, LoginUI.lnkAnterior);
                    login(driver, user, "PRUEBA123");
                    if(IsDisplayed.element(driver, LoginUI.msgNotificacionContrasenaIncorrecta)){
                        Click.on(driver, LoginUI.lnkAnterior);
                        login(driver, user, changePassword(user, password));
                        if(IsDisplayed.element(driver, LoginUI.msgNotificacionContrasenaIncorrecta)){
                            loginFailed = true;
                            Generator.takeScreenShotAndAdToHTMLReportGenerator(driver, extentApp, Status.FAIL, "<b>No se pudo autenticar, contraseña incorrecta</b>");
                            Log.recordInLog(" ".concat("Error al intentar autenticarse"));
                        }
                    }
                }
                if(DisplayAlert.getText(driver).contains("actualice su contraseña")){
                    DisplayAlert.toAcept(driver);
                    String newPassword = changePassword(user, password);
                    Enter.text(driver, LoginUI.txtNuevaContrasena, newPassword);
                    Enter.text(driver, LoginUI.txtConfirmaNuevaContrasena, newPassword);
                    Click.on(driver, LoginUI.btnGrabar);
                    if(DisplayAlert.getText(driver).contains("no debe ser igual")){
                        DisplayAlert.toAcept(driver);
                        Enter.text(driver, LoginUI.txtContrasenaActual, newPassword);
                        newPassword = changePassword(user, newPassword);
                        Enter.text(driver, LoginUI.txtNuevaContrasena, newPassword);
                        Enter.text(driver, LoginUI.txtConfirmaNuevaContrasena, newPassword);
                        Click.on(driver, LoginUI.btnGrabar);
                    }
                    if(IsDisplayed.element(driver, LoginUI.msgCambioContraseña)){
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
