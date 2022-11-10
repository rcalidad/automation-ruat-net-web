/**A
 * @description Elementos HTML relacionados a elementos comunes en el men� lateral de veh�culos
 * @date 12/10/2022
 * @author Sol Maria Condori Ticona
 */

package main.ui.vehiculosUI.commonUI;

import org.openqa.selenium.By;

public class LeftMenuUI {
    public static By lnkConsultaContribuyentes = By.linkText("Consulta Contribuyentes");
    public static By lnkAyudaCaracteristicasTecnicas = By.linkText("Ayuda Caracter�sticas T�cnicas");
    public static By lnkCosultaVehiculo = By.linkText("Consulta Veh�culo");
    public static By lnkObservacionesSugerencias = By.linkText("Observaciones y/o Sugerencias");
    public static By lnkMenuPrincipal = By.linkText("Men� Principal");

    public static By getOption(String textLink){
        return By.linkText(textLink);
    }
}
