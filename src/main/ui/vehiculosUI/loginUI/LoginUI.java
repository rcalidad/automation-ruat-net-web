/**A
 * @description Elementos HTML relacionados al Login de Vehículos
 * @date 12/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.vehiculosUI.loginUI;

import org.openqa.selenium.By;

public class LoginUI {
    public static By txtUsuario = By.id("username");
    public static By txtContrasenia = By.id("password");
    public static By btnIngresar = By.id("btnIngresar");
    public static By lnkSalir = By.id("Salir");

    //Error messages
    public static By msgNotificacion = By.xpath("//form[@id='errorLogin']//td");
    public static By lnkAnterior = By.linkText("Anterior");

    //Change password
    public static By txtContraseniaActual = By.id("txtpwd");
    public static By txtNuevaContrasenia = By.id("pwd1");
    public static By txtConfirmarNuevaContrasenia = By.id("pwd2");
    public static By btnGrabar = By.id("btnGrabar");
    public static By msgCambioContrasenia = By.xpath("//center//td");
    public static By lnkAceptar = By.linkText("Aceptar");
    public static By btnIngresarCP = By.id("btnIngreso");


}
