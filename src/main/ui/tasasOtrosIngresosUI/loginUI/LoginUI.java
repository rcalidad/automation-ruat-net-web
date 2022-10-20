package main.ui.tasasOtrosIngresosUI.loginUI;

import org.openqa.selenium.By;

public class LoginUI {
    public static By txtUsuario = By.id("login");
    public static By txtContrasenia = By.id("password");
    public static By btnIngresar = By.className("boton");

    public static By txtContraseniaActual = By.id("password-actual");
    public static By txtNuevaContrasenia = By.id("password-nuevo");
    public static By btnGrabar = By.id("password-confirmacion");

    public static By divModal = By.id("modal_window");
    public static By divMensajeModal = By.id("'mensaje-modal");
    public static By btnAceptarModal = By.xpath("//div[@id='modal_window']//button");
}
