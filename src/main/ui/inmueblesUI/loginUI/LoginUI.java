/**A
 * @description Representa elementos HTML relacionados al Login del subsistema Inmuebles
 * @date 26/07/2022
 * @author Hugo Luis Aruni Mamani
 */

package main.ui.inmueblesUI.loginUI;

import org.openqa.selenium.By;

public class LoginUI {
	//-------------- login --------------------
	public static By userInput = By.id("login");
	public static By passwordInput = By.id("password");
	public static By loginButton = By.id("btn-ingresar");

	//--------------- en pagina principal -----
	public static By logoMainPage = By.id("logo-aplicacion");
	public static By icoProforma = By.className("ico_prof");

	//---------------- alert error ------------
	public static By btnAceptarAlert 			 = By.className("botones-modal");

	//------------------ nuevo ----------------------------
	public static By txtUsuario 				 = By.id("login");
	public static By txtContrasena 				 = By.id("password");
	public static By btnIngresar 				 = By.id("btn-ingresar");
	public static By ventanaModal 				 = By.id("modal_window");
	public static By mensajeModal 				 = By.id("mensaje-modal");
	public static By btnAceptarModal 			 = By.xpath("//*[@id='modal_window']/div[2]/div[2]/button");
	public static By txtBuscarModulo 		 	 = By.id("txt-buscar-modulo");
	public static By txtContrasenaActual 		 = By.id("password-actual");
	public static By txtContrasenaNueva 		 = By.id("password-nuevo");
	public static By txtConfirmarContrasenaNueva = By.id("password-confirmacion");
	public static By btnGrabar 					 = By.id("btn-grabar");

}
