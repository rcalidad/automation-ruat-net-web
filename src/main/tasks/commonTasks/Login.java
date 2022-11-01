package main.tasks.commonTasks;

import main.actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    public static void as(WebDriver driver, By txtUser, String user, By txtPassword, String password, By btnGetInto){
        WaitUntilElement.isVisibleElement(driver, txtPassword);
        Clear.on(driver, txtUser,1);
        Enter.text(driver, txtUser, user);
        Clear.on(driver, txtPassword, 1);
        Enter.text(driver, txtPassword, password);
        WaitUntilElement.isClikeableOf(driver, btnGetInto);
        Click.on(driver, btnGetInto);
        Log.recordInLog("Proceso de Iniciar sesión: ...");
    }

    public static void updatePassword(WebDriver driver,
                                      By txtPassword, String password,
                                      By txtNewPassword, String newPassword,
                                      By txtConfirmPassword,
                                      By btnRecord){
        WaitUntilElement.isVisibleElement(driver, txtPassword);
        Clear.on(driver, txtPassword, 1);
        Enter.text(driver, txtPassword, password);
        Enter.text(driver, txtNewPassword, newPassword);
        Enter.text(driver, txtConfirmPassword, newPassword);
        WaitUntilElement.isClikeableOf(driver, btnRecord);
        Click.on(driver, btnRecord);
        Log.recordInLog("Proceso de actualización de contraseña: ...");
    }
}
