package main.ui.cobroUI.loginUI;

import org.openqa.selenium.By;

public class LoginUI {
    public static By txtUsuario = By.id("username");
    public static By txtContrasenia = By.id("password");
    public static By btnIngresar = By.id("btnIngresar");

    //CAMBIO CONTRASENIA
    public static By txtContraseniaActual = By.id("txtpwd");
    public static By txtNuevaContrasenia = By.id("pwd1");
    public static By txtConfirmeNuevaContrasenia = By.id("pwd2");
    public static By btnGrabar = By.name("grabar");
    public static By lnkAceptar = By.linkText("Aceptar");
    public static By btnIngresarCP = By.xpath("//input[@value='Ingresar']");

    //ERROR MESSAGES
    public static By msgNotificacion = By.xpath("//form[@id='errorLogin']//td");
    public static By lnkAnterior = By.linkText("Anterior");
}
