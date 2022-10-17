/**A
 * @description Elementos HTML relacionados al Login de Actividades Económicas
 * @date 06/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.actividadesEconomicasUI.loginUI;

import org.openqa.selenium.By;

public class LoginUI {
    //-------------- MAIN PAGE ---------------------
    public static By lnkIngresarAlSistema       = By.linkText("Ingresar al sistema");

    //-------------- LOGIN PAGE --------------------
    public static By txtUsuario                 = By.id("username");
    public static By txtContrasena              = By.id("password");
    public static By btnIngresar                = By.id("btnIngresar");
    public static By lnkSalir                   = By.linkText("Salir");

    //-------------- WRONG PASSWORD ---------------
    public static By msgNotificacionContrasenaIncorrecta = By.xpath("//td[contains(.,'Error al intentar autentificarse')]");
    public static By lnkAnterior                = By.linkText("Anterior");

    //-------------- FIRST LOGIN ------------------
    // CONSIDER ALERT COMPONENT
    public static By txtContrasenaActual        = By.id("txtpwd");
    public static By txtNuevaContrasena         = By.id("pwd1");
    public static By txtConfirmaNuevaContrasena = By.id("pwd2");
    public static By btnGrabar                  = By.id("btnGrabar");
    public static By btnIngreso                = By.id("btnIngreso");
    public static By lnkPoliticasSeguridad      = By.linkText("Políticas de Cuentas y Contraseñas");
    public static By getLnkSalir                = By.linkText("Salir");

    //-------------- PASSWORD CHANGED -------------
    public static By lnkAceptar                 = By.linkText("Aceptar");
    public static By msgCambioContraseña = By.xpath("//table/tbody/tr[3]/td/span");

    //-------------- FIRST GET INTO ---------------
    public static By btnPrimerIngresar          = By.id("btnIngreso");

    //-------------- USUARIO INEXISTENTE ----------
    public static By msgNotificacionUsuarioInexistente = By.xpath("//table/tbody/tr[3]/td/span");


}
