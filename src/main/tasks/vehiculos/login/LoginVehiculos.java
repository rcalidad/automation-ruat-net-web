package main.tasks.vehiculos.login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import main.actions.Click;
import main.actions.Enter;
import main.ui.vehiculosUI.loginUI.LoginUI;
import org.openqa.selenium.WebDriver;

public class LoginVehiculos {
    public static void as(WebDriver driver, ExtentReports extentReports, ExtentTest extentTest, String user, String password){
        Enter.text(driver, LoginUI.txtUsuario, user);
        Enter.text(driver, LoginUI.txtContrasena, password);
        Click.on(driver, LoginUI.btnIngresar);
    }
}
