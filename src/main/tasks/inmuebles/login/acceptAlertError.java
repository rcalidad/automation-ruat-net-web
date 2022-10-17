package main.tasks.inmuebles.login;

import main.actions.Click;
import main.ui.inmueblesUI.loginUI.LoginUI;
import org.openqa.selenium.WebDriver;

public class acceptAlertError {
    public static void on(WebDriver webDriver){
        Click.on(webDriver,LoginUI.btnAceptarAlert);
    }

}
